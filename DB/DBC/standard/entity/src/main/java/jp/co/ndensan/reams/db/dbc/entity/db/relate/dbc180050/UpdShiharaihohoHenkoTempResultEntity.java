/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(支払方法変更情報の取得ResultEntity)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdShiharaihohoHenkoTempResultEntity {

    private FlexibleYear 年度;
    private DbT4021ShiharaiHohoHenkoEntity 支払方法変更;
}
