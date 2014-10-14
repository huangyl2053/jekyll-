/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.ShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiIinDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会委員の情報を管理するManagerです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinManager {

    private final ShinsakaiIinDac shinsakaiIinDac;

    /**
     * デフォルトコンストラクタです。
     */
    public ShinsakaiIinManager() {
        shinsakaiIinDac = InstanceProvider.create(ShinsakaiIinDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param shinsakaiIinDac 審査会委員DacMock
     */
    ShinsakaiIinManager(ShinsakaiIinDac shinsakaiIinDacMock) {
        shinsakaiIinDac = shinsakaiIinDacMock;
    }

    /**
     * 委員コードをリストで指定し、対応する委員をリストにして返します。
     *
     * @param 審査会委員コードList 審査会委員コードList
     * @return 審査会委員List
     */
    public ShinsakaiIinList get審査会委員List(List<ShinsakaiIinCode> 審査会委員コードList) {
        //TODO n8178 城間篤人 審査会委員本実装の際に実装予定 2014年9月末
        return null;
    }

    /**
     * 委員コードを指定し、対応する委員を返します。
     *
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会委員
     */
    public ShinsakaiIin get審査会委員(ShinsakaiIinCode 審査会委員コード) {
        //TODO n8178 城間篤人 審査会委員本実装の際に実装予定 2014年9月末
        return null;
    }

    /**
     * 有効な審査会委員のリストを返します。
     *
     * @return 現在有効な審査会委員のリスト
     */
    public ShinsakaiIinList get有効審査会委員List() {
        List<DbT5102ShinsakaiIinJohoEntity> entities = shinsakaiIinDac.select有効審査会委員List();
        return ShinsakaiIinMapper.to審査会委員List(entities);
    }
}
