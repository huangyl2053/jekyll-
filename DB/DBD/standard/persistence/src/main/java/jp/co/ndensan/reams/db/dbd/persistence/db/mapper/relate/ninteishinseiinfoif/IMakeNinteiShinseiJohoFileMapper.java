/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseiinfoif;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.temp.KouikiyoukaigoNinteishinseiJouhouTempEntity;

/**
 * 要介護認定申請連携データの取得。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
public interface IMakeNinteiShinseiJohoFileMapper {

    /**
     * 要介護認定申請連携データの取得。
     *
     * @return List<KouikiyoukaigoNinteishinseiJouhouTempEntity>
     */
    List<KouikiyoukaigoNinteishinseiJouhouTempEntity> select要介護認定申請連携データ();
}
