/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200018;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shakaifukushihojinkeigenhakkoichiran.ShakaiFukushiHojinKeigenHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表Editorです。
 *
 * @reamsid_L DBD-3981-070 b_liuyang2
 */
public class ShakaiFukushiHojinKeigenHakkoIchiranEditor implements IShakaiFukushiHojinKeigenHakkoIchiranEditor {

    private static final int NOCOUNT_1 = 1;
    private static final int NOCOUNT_2 = 2;
    private static final int NOCOUNT_3 = 3;
    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;

    private final ShakaiFukushiHojinKeigenHakkoIchiranEntity 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final IKojin 個人情報;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 FutangGendoGakuNinteiEntity
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 個人情報 IKojin
     * @param index int
     */
    public ShakaiFukushiHojinKeigenHakkoIchiranEditor(ShakaiFukushiHojinKeigenHakkoIchiranEntity 帳票情報,
            Association association, IOutputOrder iOutputOrder, IKojin 個人情報, int index) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.個人情報 = 個人情報;
        this.index = index;
    }

    @Override
    public ShakaiFukushiHojinKeigenHakkoIchiranReportSource edit(ShakaiFukushiHojinKeigenHakkoIchiranReportSource source) {
        setLayer1Step1(source);
        setLayer1Step2(source);
        setLayer1Step3(source);
        setLayer1Step4(source);
        setAccessLogEditor(source);
        return source;
    }

    private void setLayer1Step1(ShakaiFukushiHojinKeigenHakkoIchiranReportSource source) {
        source.printTimeStamp = get印刷日時();
        if (null != association) {
            source.hokenshaNo = this.association.get地方公共団体コード().value();
            source.hokenshaName = this.association.get市町村名();
        }
        if (null != iOutputOrder) {
            List<ISetSortItem> 設定項目リスト = this.iOutputOrder.get設定項目リスト();
            source.shutsuryokujun1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            source.shutsuryokujun3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
        }
        source.list_1 = new RString(String.valueOf(index + 1));
    }

    private void setLayer1Step2(ShakaiFukushiHojinKeigenHakkoIchiranReportSource source) {
        if (null != 帳票情報) {
            KetteiKubun 決定 = this.帳票情報.get決定();
            KetteiKubun 決定区分承認 = KetteiKubun.承認する;
            KetteiKubun 決定区分承認しない = KetteiKubun.承認しない;
            if (決定.equals(決定区分承認)) {
                source.list_2 = this.帳票情報.get確認番号();
            } else if (決定.equals(決定区分承認しない)) {
                source.list_2 = RString.EMPTY;
            }
            FlexibleDate 喪失年月日 = this.帳票情報.get喪失年月日();
            if (null != 喪失年月日 && !喪失年月日.isEmpty()) {
                source.list_3 = new RString("*");
            }
            source.list_4 = this.帳票情報.get被保険者番号().getColumnValue();
            if (null != 個人情報) {
                source.list_5 = this.個人情報.get名称().getName().value();
                source.list_6 = this.個人情報.get住所().get住所();
            }
            source.list_7 = this.帳票情報.get申請日().wareki().toDateString();
            source.list_8 = this.帳票情報.get決定日().wareki().toDateString();
            source.list_9 = get適用日有効期限();
            if (決定.equals(決定区分承認)) {
                source.list_10 = new RString("承認");
            } else if (決定.equals(決定区分承認しない)) {
                source.list_10 = new RString("却下");
            }
            if (決定.equals(決定区分承認)) {
                source.list_11 = this.帳票情報.get軽減().get略称();
            } else if (決定.equals(決定区分承認しない)) {
                source.list_11 = RString.EMPTY;
            }
            if (this.帳票情報.get軽減率_分子() != null
                    && !this.帳票情報.get軽減率_分子().isEmpty()
                    && this.帳票情報.get軽減率_分母() != null
                    && !this.帳票情報.get軽減率_分母().isEmpty()
                    && !this.帳票情報.get軽減率_分母().equals(new RString("0"))) {
                Decimal 軽減率_分子 = new Decimal(this.帳票情報.get軽減率_分子().toString());
                Decimal 軽減率_分母 = new Decimal(this.帳票情報.get軽減率_分母().toString());
                source.list_12 = new RString(軽減率_分子.divide(軽減率_分母).toString());
            }
            if (決定.equals(決定区分承認しない)) {
                source.list_12 = RString.EMPTY;
            }
        }
    }

    private void setLayer1Step3(ShakaiFukushiHojinKeigenHakkoIchiranReportSource source) {
        if (null != 帳票情報) {
            KetteiKubun 決定 = this.帳票情報.get決定();
            KetteiKubun 決定区分承認 = KetteiKubun.承認する;
            KetteiKubun 決定区分承認しない = KetteiKubun.承認しない;
            boolean 居宅サービス限定 = this.帳票情報.is居宅サービス限定();
            if (決定.equals(決定区分承認) && 居宅サービス限定) {
                source.list_13 = new RString("宅").substring(0, NOCOUNT_1);
            } else if (決定.equals(決定区分承認) && !居宅サービス限定) {
                source.list_13 = RString.EMPTY.substring(0, NOCOUNT_1);
            }
            boolean 居住費食費のみ = this.帳票情報.is居住費食費のみ();
            if (決定.equals(決定区分承認) && 居住費食費のみ) {
                source.list_13 = new RString("住").substring(NOCOUNT_1, NOCOUNT_2);
            } else if (決定.equals(決定区分承認) && !居住費食費のみ) {
                source.list_13 = RString.EMPTY.substring(NOCOUNT_1, NOCOUNT_2);
            }
            boolean 旧措置者ユニット型個室のみ = this.帳票情報.is旧措置者ユニット型個室のみ();
            if (決定.equals(決定区分承認) && 旧措置者ユニット型個室のみ) {
                source.list_13 = new RString("ユ").substring(NOCOUNT_2, NOCOUNT_3);
            } else if (決定.equals(決定区分承認) && !旧措置者ユニット型個室のみ) {
                source.list_13 = RString.EMPTY.substring(NOCOUNT_2, NOCOUNT_3);
            }
            if (決定.equals(決定区分承認しない)) {
                source.list_13 = RString.EMPTY;
            }
        }
    }

    private void setLayer1Step4(ShakaiFukushiHojinKeigenHakkoIchiranReportSource source) {
        if (null != 帳票情報) {
            if (this.帳票情報.is認定証発行フラグ() && this.帳票情報.is認定証発行済み()) {
                source.list_14 = new RString("○");
            }
            if (this.帳票情報.is認定証発行フラグ() && !this.帳票情報.is認定証発行済み()) {
                source.list_14 = new RString("却下");
            }
            if (!this.帳票情報.is認定証発行フラグ() && !this.帳票情報.is認定証発行済み()) {
                source.list_14 = RString.EMPTY;
            }
            if (this.帳票情報.is通知書発行フラグ()) {
                source.list_15 = new RString("○");
            }
        }
    }

    private void setAccessLogEditor(ShakaiFukushiHojinKeigenHakkoIchiranReportSource source) {
        source.shikibetsuCode = this.個人情報.get識別コード().getColumnValue();
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        RString 印刷日時 = 年月日.concat("").concat(時分秒).concat("").concat("作成");
        return 印刷日時;
    }

    private RString get適用日有効期限() {
        RString 適用日 = this.帳票情報.get適用日().wareki().toDateString();
        RString 有効期限 = this.帳票情報.get有効期限().wareki().toDateString();
        RString 適用日有効期限 = 適用日.concat(new RString("~")).concat(有効期限);
        return 適用日有効期限;
    }
}
