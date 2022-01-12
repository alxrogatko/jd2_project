package by.academy.it.dao;

import by.academy.it.pojo.Friends;
import by.academy.it.util.FriendsQueries;
import by.academy.it.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FriendsDao {

    private final SessionFactory sessionFactory;

    public FriendsDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public FriendsDao() {
        this(SessionFactoryUtil.getSession());
    }

    public void addNewFriend(Friends friends) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(friends);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteFriend(Friends friends) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(friends);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Friends> showFriendsList(String mainUserId) {
        return FriendsQueries.showFriendsList(mainUserId);
    }

    public void updateFriendStatus(LocalDateTime addDate, String ownerId, String friendId, String status) {
        FriendsQueries.updateFriendStatus(addDate, ownerId, friendId, status);
    }

    public String getFriendRequestStatus(String receiverId, String requesterId) {
        return FriendsQueries.getRequestStatus(receiverId, requesterId);
    }

    public List<Friends> getFriendRequests(String id) {
        return FriendsQueries.getFriendRequestsForUser(id);
    }

    public void deleteFriendRequest(String receiverId, String requesterId) {
        FriendsQueries.deleteFriendRequest(receiverId, requesterId);
    }
}
