package by.academy.it;

import by.academy.it.dao.FriendsDao;
import by.academy.it.pojo.Friends;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FriendsService {
    private final FriendsDao friendsDao;

    public FriendsService(FriendsDao friendsDao) {
        this.friendsDao = friendsDao;
    }

    public void addFriend(Friends friends) {
        friendsDao.addNewFriend(friends);
    }

    public List<Friends> getFriendsList(String mainUserId) {
        return friendsDao.showFriendsList(mainUserId);
    }

    public List<Friends> getFriendRequests(String id) {
        return friendsDao.getFriendRequests(id);
    }

    public String getRequestStatus(String receiverId, String requesterId) {
       return friendsDao.getFriendRequestStatus(receiverId, requesterId);
    }

    public void deleteFriend(String receiverId, String requesterId) {
        friendsDao.deleteFriend(receiverId, requesterId);
    }

    public void deleteFriendRequest(String receiverId, String requesterId) {
        friendsDao.deleteFriendRequest(receiverId, requesterId);
    }

    public void updateFriendStatus(LocalDateTime addDate, String requesterId, String receiverId, String status) {
        friendsDao.updateFriendStatus(addDate, requesterId, receiverId, status);
    }
}
