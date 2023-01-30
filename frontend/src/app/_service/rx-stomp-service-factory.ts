import { RxStompService } from './rx-stomp.service';
import { myRxStompConfig } from './rx-stomp.config';
import {environment} from '../../environment/environment';

export function rxStompServiceFactory() {
  const rxStomp = new RxStompService();
  rxStomp.configure(myRxStompConfig);
  rxStomp.stompClient.brokerURL = environment.brokerURL + '?token=' + localStorage.getItem('token');
  rxStomp.activate();
  return rxStomp;
}
