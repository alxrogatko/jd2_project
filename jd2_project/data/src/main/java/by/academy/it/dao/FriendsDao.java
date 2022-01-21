package by.academy.it.dao;

import by.academy.it.pojo.Friends;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class FriendsDao {

    @Autowired
    @Qualifier("usersSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public void addNewFriend(Friends friends) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(friends);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void deleteFriend(String receiverId, String requesterId) {
        Session session = sessionFactory.getCurrentSession();

        Query<?> query = session.createQuery(
                "delete from Friends where " +
                    "receiverId =: paramReceiver and requesterId =: paramRequester " +
                    "or " +
                    "receiverId =: paramRequester and requesterId =: paramReceiver "
        );
        query.setParameter("paramReceiver", receiverId);
        query.setParameter("paramRequester", requesterId);
        query.executeUpdate();
    }

    public List<Friends> showFriendsList(String mainUserId) {
        Session session = sessionFactory.openSession();

        Query<Friends> query = session.createQuery(
                "from Friends where (receiverId =: id or requesterId =: id) and status =: status", Friends.class
        );
        query.setParameter("id", mainUserId);
        query.setParameter("status", "added");

        List<Friends> friendsList = query.list();
        session.close();
        return friendsList;
    }

    @Transactional
    public void updateFriendStatus(LocalDateTime addDate, String ownerId, String friendId, String status) {
        Session session = sessionFactory.getCurrentSession();

        Query<?> query = session.createQuery(
                "update Friends set addDate =: paramDate, status =: paramStatus " +
                    "where requesterId =: paramId and receiverId =: paramFriendId"
        );
        query.setParameter("paramDate", addDate);
        query.setParameter("paramStatus", status);
        query.setParameter("paramId", ownerId);
        query.setParameter("paramFriendId", friendId);

        query.executeUpdate();
    }

    public String getFriendRequestStatus(String receiverId, String requesterId) {
        Session session = sessionFactory.openSession();

        Query<?> query = session.createQuery(
                "select status from Friends where " +
                    "receiverId =: paramReceiver and requesterId =: paramRequester " +
                    "or " +
                    "receiverId =: paramRequester and requesterId =: paramReceiver "
        );
        query.setParameter("paramReceiver", receiverId);
        query.setParameter("paramRequester", requesterId);
        List<?> requestStatus = query.list();
        session.close();

        if (!requestStatus.isEmpty()) {
            return String.valueOf(requestStatus.get(0));
        } else {
            return "none";
        }
    }

    public List<Friends> getFriendRequests(String id) {
        Session session = sessionFactory.openSession();

        Query<Friends> query = session.createQuery(
                "from Friends where receiverId =: paramId and status =: paramStatus", Friends.class
        );
        query.setParameter("paramId", id);
        query.setParameter("paramStatus", "request");

        List<Friends> friendsList = query.list();
        session.close();
        return friendsList;
    }

    @Transactional
    public void deleteFriendRequest(String receiverId, String requesterId) {
        Session session = sessionFactory.getCurrentSession();

        Query<?> query = session.createQuery(
                "delete from Friends where receiverId =: paramReceiverId and requesterId =: paramRequesterId"
        );
        query.setParameter("paramReceiverId", receiverId);
        query.setParameter("paramRequesterId", requesterId);

        query.executeUpdate();
    }
}
