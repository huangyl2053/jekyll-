/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_Processファイル出力クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuIchiranOutputEntity implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private Long 登録者選択;
    private Long 差止予告登録者２号の選択;
    private Long 差止登録者２号の選択;
    private Long 償還予告登録者１号の選択;
    private Long 償還決定登録者１号の選択;
    private Long 償還決定登録者_差止中あり者のみ１号の選択;
    private Long 償還決定登録者_保険料控除あり者のみ１号の選択;
    private Long 改頁出力順ID;
    private RString 帳票分類ID;
    private RString 帳票ID;
    private RString 帳票作成日時;
}
