/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス1SQL検索結果クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuOneEntity {

    // 対象者情報
    private HihokenshaNo 対象者情報_被保険者番号;
    private List<ShunoJohoEntity> 収納情報リスト;

}
