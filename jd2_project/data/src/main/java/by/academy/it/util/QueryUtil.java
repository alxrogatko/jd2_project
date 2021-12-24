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

    public static void updateFriendStatus(String ownerId, String friendId, String status) {
        Query<?> friendsQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "update Friends set status =: paramStatus where ownerId =: paramId and friendId =: paramFriendId"
        );
        friendsQuery.setParameter("paramStatus", status);
        friendsQuery.setParameter("paramId", ownerId);
        friendsQuery.setParameter("paramFriendId", friendId);
        friendsQuery.executeUpdate();
    }

    public static List<Friends> getFriendRequestsForUser(String id) {
        Query<Friends> friendsQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "from Friends where friendId =: paramId and status =: paramStatus", Friends.class
        );
        friendsQuery.setParameter("paramId", id);
        friendsQuery.setParameter("paramStatus", "request");
        return friendsQuery.list();
    }
}
