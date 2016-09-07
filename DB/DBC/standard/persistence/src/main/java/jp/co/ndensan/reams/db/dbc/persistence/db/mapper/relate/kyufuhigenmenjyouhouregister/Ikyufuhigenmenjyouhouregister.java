/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufuhigenmenjyouhouregister;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhigenmenjyouhouregister.GenmenJyouhouParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouregisterParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhigenmenjyouhouregister.KyufuJissekiJyouhouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouRegisterEntity;

/**
 * ビジネス設計_DBCMN71001_給付費通知減免情報補正登録インタフェースクラスです。
 *
 * @reamsid_L DBC-2260-030 xuyongchao
 */
public interface Ikyufuhigenmenjyouhouregister {

    /**
     * 検索条件より、適当な条件を連結して、減免補正情報の取得。
     *
     * @param 検索条件 検索条件
     * @return KyufuhigenmenjyouhouRegisterEntity 検索結果の{@link KyufuhigenmenjyouhouRegisterEntity}
     */
    List<KyufuhigenmenjyouhouRegisterEntity> getGenmenJyouhou(KyufuhigenmenjyouhouregisterParameter 検索条件);

    /**
     * 減免補正情報をinsertする。
     *
     * @param 検索条件 検索条件
     */
    void insertGenmenJyouhou(GenmenJyouhouParameter 検索条件);

    /**
     * 減免補正情報をupdateする
     *
     * @param 検索条件 検索条件
     */
    void updateGenmenJyouhou(GenmenJyouhouParameter 検索条件);

    /**
     * 減免補正情報をdeleteする
     *
     * @param 検索条件 検索条件
     */
    void deleteGenmenJyouhou(GenmenJyouhouParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、給付実績情報の存在。
     *
     * @param 検索条件 検索条件
     * @return KyufuJissekiJyouhouEntity
     */
    KyufuJissekiJyouhouEntity checkKyufuJissekiJyouhou(GenmenJyouhouParameter 検索条件);

}
