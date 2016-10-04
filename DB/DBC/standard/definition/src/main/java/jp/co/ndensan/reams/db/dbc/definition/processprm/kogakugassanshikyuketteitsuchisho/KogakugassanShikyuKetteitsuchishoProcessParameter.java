/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 基準収入額決定通知書発行のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanShikyuKetteitsuchishoProcessParameter implements IBatchProcessParameter {

    private RString 日付選択区分;
    private FlexibleYearMonth 受取年月;
    private FlexibleDate 申請開始年月日;
    private FlexibleDate 申請終了年月日;
    private FlexibleDate 決定開始年月日;
    private FlexibleDate 決定終了年月日;
    private RString 印書区分;
    private RString 改頁出力順ID;
    private FlexibleDate 発行日;
    private RString 支払予定日印字有無;
    private FlexibleDate 支払予定日;
    private RString 決定日一括更新区分;
    private FlexibleDate 決定日;
    private RString 文書番号;
    private YMDHMS 処理日時;

}
