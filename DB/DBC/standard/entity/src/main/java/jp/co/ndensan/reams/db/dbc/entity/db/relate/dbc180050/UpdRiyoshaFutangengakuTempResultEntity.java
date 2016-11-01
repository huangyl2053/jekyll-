/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧( 利用者負担減額情報の取得ResultEntity)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdRiyoshaFutangengakuTempResultEntity {

    private FlexibleYear 年度;
    private DbT4014RiyoshaFutangakuGengakuEntity 利用者負担減額;
}
