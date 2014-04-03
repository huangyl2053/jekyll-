/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;

/**
 * 審査会委員の情報を管理するManagerです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinManager {
    //TODO n8178 城間篤人 審査会委員チケットで実装予定 2014年4月

    /**
     * 委員コードをリストで指定し、対応する委員をリストにして返します。
     *
     * @param 委員コードList 委員コードList
     * @return 審査会委員List
     */
    public ShinsakaiIinList get審査会委員List(List<ShinsakaiIinCode> 委員コードList) {
        return null;
    }

    /**
     * 委員コードを指定し、対応する委員を返します。
     *
     * @param 委員コード 委員コード
     * @return 審査会委員
     */
    public ShinsakaiIin get審査会委員(ShinsakaiIinCode 委員コード) {
        return null;
    }
}
