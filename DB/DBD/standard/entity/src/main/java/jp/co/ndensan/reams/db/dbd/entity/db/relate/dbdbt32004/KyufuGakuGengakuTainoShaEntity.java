/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt32004;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 給付額減額滞納者把握情報取得Entity
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGakuGengakuTainoShaEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 対象者情報一時Entityを返します。
     *
     * @return 対象者情報一時Entity -- SETTER -- 対象者情報一時Entityを設定します。
     *
     * @param 対象者情報一時Entity 対象者情報一時Entity
     */
    private TaishoShaKanriJohoTableEntity 対象者情報一時Entity;

    /**
     * -- GETTER -- 収納滞納状況一時EntityListを返します。
     *
     * @return 収納滞納状況一時EntityList -- SETTER -- 収納滞納状況一時EntityListを設定します。
     *
     * @param 収納滞納状況一時EntityList 収納滞納状況一時EntityList
     */
    private List<ShunoTainoJokyoTempTableEntity> 収納滞納状況一時Entity;

    /**
     * -- GETTER -- 支払方法変更減額EntityListを返します。
     *
     * @return 支払方法変更減額EntityList -- SETTER -- 支払方法変更減額EntityListを設定します。
     *
     * @param 支払方法変更減額EntityList 支払方法変更減額EntityList
     */
    private List<DbT4025ShiharaiHohoHenkoGengakuEntity> 支払方法変更減額Entity;

    private UaFt200FindShikibetsuTaishoEntity psmEntity;

    /**
     * コンストラクタです。
     */
    private KyufuGakuGengakuTainoShaEntity() {
        対象者情報一時Entity = new TaishoShaKanriJohoTableEntity();
        収納滞納状況一時Entity = new ArrayList<>();
        支払方法変更減額Entity = new ArrayList<>();
    }

}
