/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310012;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受領委任払いの（福祉用具購入費・住宅改修費）契約者を管理する画面のパラメータです。
 *
 * @reamsid_L DBC-2130-020 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PnlTotalPanelParameter implements Serializable {

    private static final long serialVersionUID = -6680438140785085182L;
    private final ShikibetsuCode 識別コード;
    private final RString 被保番号;
    private final RDate 契約申請受付日;
    private final RDate 契約申請日;
    private final RString 契約事業者番号;
    private final RString 契約事業者名称;
    private final RString 契約ｻｰﾋﾞｽ種類;
    private final RDate 契約決定日;
    private final RString 決定区分;
    private final RString 承認しない理由;
    private final RString 年度;
    private final Decimal 番号1;
    private final RString 番号2;
    private final RDate 承認期間From;
    private final RDate 承認期間To;
    private final RDate 承認通知書作成日;
    private final RString 承認結果通知書再発行区分;
    private final RString 支給申請有無区分;
    private final RYearMonth サービス提供年月;
    private final RString 償還整理番号;
    private final RString 備考;
    private final Decimal 費用額合計;
    private final Decimal 利用者自己負担額;
    private final Decimal 保険対象費用額;
    private final Decimal 保険給付費用額;

    /**
     * パラメータを作成する。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保番号 RString
     * @param 契約申請受付日 RDate
     * @param 契約申請日 RDate
     * @param 契約事業者番号 RString
     * @param 契約事業者名称 RString
     * @param 契約ｻｰﾋﾞｽ種類 RString
     * @param 契約決定日 RDate
     * @param 決定区分 RString
     * @param 承認しない理由 RString
     * @param 年度 RString
     * @param 番号1 Decimal
     * @param 番号2 RString
     * @param 承認期間From RDate
     * @param 承認期間To RDate
     * @param 承認通知書作成日 RString
     * @param 承認結果通知書再発行区分 RString
     * @param 支給申請有無区分 RString
     * @param サービス提供年月 RYearMonth
     * @param 償還整理番号 RString
     * @param 備考 RString
     * @param 費用額合計 Decimal
     * @param 利用者自己負担額 Decimal
     * @param 保険対象費用額 Decimal
     * @param 保険給付費用額 Decimal
     */
    public PnlTotalPanelParameter(ShikibetsuCode 識別コード,
            RString 被保番号,
            RDate 契約申請受付日,
            RDate 契約申請日,
            RString 契約事業者番号,
            RString 契約事業者名称,
            RString 契約ｻｰﾋﾞｽ種類,
            RDate 契約決定日,
            RString 決定区分,
            RString 承認しない理由,
            RString 年度,
            Decimal 番号1,
            RString 番号2,
            RDate 承認期間From,
            RDate 承認期間To,
            RDate 承認通知書作成日,
            RString 承認結果通知書再発行区分,
            RString 支給申請有無区分,
            RYearMonth サービス提供年月,
            RString 償還整理番号,
            RString 備考,
            Decimal 費用額合計,
            Decimal 利用者自己負担額,
            Decimal 保険対象費用額,
            Decimal 保険給付費用額) {
        this.識別コード = 識別コード;
        this.被保番号 = 被保番号;
        this.契約申請受付日 = 契約申請受付日;
        this.契約申請日 = 契約申請日;
        this.契約事業者番号 = 契約事業者番号;
        this.契約事業者名称 = 契約事業者名称;
        this.契約ｻｰﾋﾞｽ種類 = 契約ｻｰﾋﾞｽ種類;
        this.契約決定日 = 契約決定日;
        this.決定区分 = 決定区分;
        this.承認しない理由 = 承認しない理由;
        this.年度 = 年度;
        this.番号1 = 番号1;
        this.番号2 = 番号2;
        this.承認期間From = 承認期間From;
        this.承認期間To = 承認期間To;
        this.承認通知書作成日 = 承認通知書作成日;
        this.承認結果通知書再発行区分 = 承認結果通知書再発行区分;
        this.支給申請有無区分 = 支給申請有無区分;
        this.サービス提供年月 = サービス提供年月;
        this.償還整理番号 = 償還整理番号;
        this.備考 = 備考;
        this.費用額合計 = 費用額合計;
        this.利用者自己負担額 = 利用者自己負担額;
        this.保険対象費用額 = 保険対象費用額;
        this.保険給付費用額 = 保険給付費用額;
    }
}
