/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス1SQL検索結果の督促状発行履歴情報クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokusokuHakkoRirekiEntity {

    //督促状発行履歴
    private RString 督促状発行履歴_収納ID;
    private FlexibleDate 督促状発行履歴_督促状発行年月日;

}
