/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 振込明細・振込みデータ作成の事業高額データEntityです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomimeisaiFurikomiDataJigyoKogakuEntity {

    private DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果entity;
    private DbT3110JigyoKogakuShikyuShinseiEntity 支給申請entity;
    private DbT3112KogakuShikyuShinsaKetteiEntity 審査決定entity;
    private DbT3105SogoJigyoTaishoshaEntity 総合事業entity;
}
