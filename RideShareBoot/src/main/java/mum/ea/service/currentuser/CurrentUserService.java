package mum.ea.service.currentuser;

import mum.ea.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
