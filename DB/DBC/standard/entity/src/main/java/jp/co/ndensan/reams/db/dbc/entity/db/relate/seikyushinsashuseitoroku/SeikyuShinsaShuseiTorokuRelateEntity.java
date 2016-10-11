/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyushinsashuseitoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 住宅改修理由書作成手数料請求情報修正登録(審査結果登録)のクラスです。
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyuShinsaShuseiTorokuRelateEntity {

    private DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity dbT3094;
    private DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity dbT3095;
    private DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity dbT3096;

}
