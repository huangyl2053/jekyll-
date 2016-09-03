/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200040;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一覧表帳票のパラメータです。
 *
 * @reamsid_L DBC-2300-045 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanShikyuFushikyuKetteishaIchiranParameter {

    private FlexibleYearMonth 処理年月;
    private boolean 合計flag;
    private int 連番;
    private RString 市町村コード;
    private RString 市町村名称;
    private RDateTime 作成日時;
    private RString 日付選択区分;
    private FlexibleYearMonth 受取年月;
    private FlexibleDate 申請開始年月日;
    private FlexibleDate 申請終了年月日;
    private FlexibleDate 決定開始年月日;
    private FlexibleDate 決定終了年月日;
    private int 支給の件数;
    private RString 自己負担総額の合計金額;
    private RString 支給額の合計金額;

}
