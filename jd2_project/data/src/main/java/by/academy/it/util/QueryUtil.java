package by.academy.it.util;

import by.academy.it.pojo.Friends;
import by.academy.it.pojo.User;
import org.hibernate.query.Query;

import java.util.List;

public class QueryUtil {

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

    public static void updateFriendStatus(String requesterId, String receiverId, String status) {
        Query<?> friendsQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "update Friends set status =: paramStatus where requesterId =: paramId and receiverId =: paramFriendId"
        );
        friendsQuery.setParameter("paramStatus", status);
        friendsQuery.setParameter("paramId", requesterId);
        friendsQuery.setParameter("paramFriendId", receiverId);
        friendsQuery.executeUpdate();
    }

    public static List<Friends> getFriendRequestsForUser(String id) {
        Query<Friends> friendsQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "from Friends where receiverId =: paramId and status =: paramStatus", Friends.class
        );
        friendsQuery.setParameter("paramId", id);
        friendsQuery.setParameter("paramStatus", "request");
        return friendsQuery.list();
    }
}
