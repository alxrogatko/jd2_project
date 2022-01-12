package by.academy.it.util;

import by.academy.it.pojo.Friends;
import by.academy.it.pojo.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public class FriendsQueries {

    public static List<User> getUserByEmail(String email) {
        Query<User> userQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "from User where email =: paramEmail", User.class);
        userQuery.setParameter("paramEmail", email);
        return userQuery.list();
    }

    public static String getRequestStatus(String receiverId, String requesterId) {
        Query<Friends> friendsQuery = SessionFactoryUtil.getSession().openSession().createQuery(
            "select status from Friends where receiverId =: paramReceiver and requesterId =: paramRequester"
        );
        friendsQuery.setParameter("paramReceiver", receiverId);
        friendsQuery.setParameter("paramRequester", requesterId);
        List<Friends> requestStatus = friendsQuery.list();
        if (!requestStatus.isEmpty()) {
            return String.valueOf(requestStatus.get(0));
        } else {
            return "none";
        }
    }

    public static void updateFriendStatus(LocalDateTime addDate, String requesterId, String receiverId, String status) {
        Session session = SessionFactoryUtil.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> friendsQuery = session.createQuery(
                "update Friends set addDate =: paramDate, status =: paramStatus where requesterId =: paramId and receiverId =: paramFriendId"
        );
        friendsQuery.setParameter("paramDate", addDate);
        friendsQuery.setParameter("paramStatus", status);
        friendsQuery.setParameter("paramId", requesterId);
        friendsQuery.setParameter("paramFriendId", receiverId);
        friendsQuery.executeUpdate();
        transaction.commit();
        session.close();
    }

    public static List<Friends> showFriendsList(String mainUserId) {
        Query<Friends> friends = SessionFactoryUtil.getSession().openSession().createQuery(
                "from Friends where receiverId =: id and status =: status"
        );
        friends.setParameter("id", mainUserId);
        friends.setParameter("status", "added");
        return friends.list();
    }

    public static List<Friends> getFriendRequestsForUser(String id) {
        Query<Friends> friendsQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "from Friends where receiverId =: paramId and status =: paramStatus", Friends.class
        );
        friendsQuery.setParameter("paramId", id);
        friendsQuery.setParameter("paramStatus", "request");
        return friendsQuery.list();
    }

    public static void deleteFriendRequest(String receiverId, String requesterId) {
        Session session = SessionFactoryUtil.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> friendsQuery = session.createQuery(
                "delete from Friends where receiverId =: paramReceiverId and requesterId =: paramRequesterId"
        );
        friendsQuery.setParameter("paramReceiverId", receiverId);
        friendsQuery.setParameter("paramRequesterId", requesterId);
        friendsQuery.executeUpdate();
        transaction.commit();
        session.close();
    }
}
