// @flow
import { NativeModules } from 'react-native';
import { nativeSDKMissing } from './../../utils';

const FirebaseAppIndexing = NativeModules.RNFirebaseAppIndexing;


export default class AppIndexing {

  constructor() {
    if (!FirebaseAppIndexing) {
      return nativeSDKMissing('appindexing');
    }
  }

  /**
   * Logs start view action.
   * @param  {string} title
   * @param {string} url
   * @return {void}
   */
  startViewAction(title: string, url: string): void {
    return FirebaseAppIndexing.startViewAction(title, url);
  }

  /**
   * Logs end view action.
   * @param  {string} title
   * @param {string} url
   * @return {void}
   */
  endViewAction(title: string, url: string): void {
    return FirebaseAppIndexing.endViewAction(title, url);
  }

}
