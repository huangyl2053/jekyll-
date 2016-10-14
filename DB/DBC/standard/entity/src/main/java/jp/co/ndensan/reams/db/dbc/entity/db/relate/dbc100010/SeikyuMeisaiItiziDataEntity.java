/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成取得Entity
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyuMeisaiItiziDataEntity {

    private DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity dbT3095;
    private DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity dbT3096;
    private DbT3034ShokanShinseiEntity dbT3034;
    private DbT3049ShokanJutakuKaishuEntity dbT3049;
    private HihokenshaNo dbT3049_hiHokenshaNo;
}
