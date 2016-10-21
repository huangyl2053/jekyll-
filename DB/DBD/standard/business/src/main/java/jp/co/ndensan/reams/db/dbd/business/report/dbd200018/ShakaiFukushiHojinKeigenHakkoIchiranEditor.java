/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200018;

import java.util.Map;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shakaifukushihojinkeigenhakkoichiran.ShakaiFukushiHojinKeigenHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
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

    private static final RString 承認 = new RString("承認");
    private static final RString 却下 = new RString("却下");
    private static final RString 作成 = new RString("作成");
    private static final RString 丸 = new RString("○");
    private static final RString 記号 = new RString("~");
    private static final RString 宅 = new RString("宅");
    private static final RString 住 = new RString("住");
    private static final RString ユ = new RString("ユ");
    private static final RString ホシ = new RString("*");

    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final int LISTINDEX_5 = 5;

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
            setiOutputOrder(source);
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
                source.list_3 = ホシ;
            }
            source.list_4 = this.帳票情報.get被保険者番号().getColumnValue();
            if (null != 個人情報.get名称()) {
                source.list_5 = this.個人情報.get名称().getName().value();
            }
            if (null != 個人情報.get住所()) {
                source.list_6 = this.個人情報.get住所().get住所();
            }
            if (null != this.帳票情報.get申請日()) {
                source.list_7 = this.帳票情報.get申請日().wareki().toDateString();
            }
            if (null != this.帳票情報.get決定日()) {
                source.list_8 = this.帳票情報.get決定日().wareki().toDateString();
            }
            source.list_9 = get適用日有効期限();
            if (決定.equals(決定区分承認)) {
                source.list_10 = 承認;
            } else if (決定.equals(決定区分承認しない)) {
                source.list_10 = 却下;
            }
            if (決定.equals(決定区分承認)) {
                source.list_11 = this.帳票情報.get軽減().get名称();
            } else if (決定.equals(決定区分承認しない)) {
                source.list_11 = RString.EMPTY;
            }
            if (this.帳票情報.get軽減率_分子() != null
                    && this.帳票情報.get軽減率_分母() != null
                    && !this.帳票情報.get軽減率_分母().equals(new Decimal(0))) {
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
            RString 居宅 = RString.EMPTY;
            boolean 居宅サービス限定 = this.帳票情報.is居宅サービス限定();
            if (決定.equals(決定区分承認) && 居宅サービス限定) {
                居宅 = 宅;
            }
            boolean 居住費食費のみ = this.帳票情報.is居住費食費のみ();
            if (決定.equals(決定区分承認) && 居住費食費のみ) {
                居宅 = 居宅.concat(住);
            }
            boolean 旧措置者ユニット型個室のみ = this.帳票情報.is旧措置者ユニット型個室のみ();
            if (決定.equals(決定区分承認) && 旧措置者ユニット型個室のみ) {
                居宅 = 居宅.concat(ユ);
            }
            source.list_13 = 居宅;
            if (決定.equals(決定区分承認しない)) {
                source.list_13 = RString.EMPTY;
            }
        }
    }

    private void setLayer1Step4(ShakaiFukushiHojinKeigenHakkoIchiranReportSource source) {
        if (null != 帳票情報) {
            if (this.帳票情報.is認定証発行フラグ() && this.帳票情報.is認定証発行済み()) {
                source.list_14 = 丸;
            }
            if (this.帳票情報.is認定証発行フラグ() && !this.帳票情報.is認定証発行済み()) {
                source.list_14 = 却下;
            }
            if (!this.帳票情報.is認定証発行フラグ() && !this.帳票情報.is認定証発行済み()) {
                source.list_14 = RString.EMPTY;
            }
            if (this.帳票情報.is通知書発行フラグ()) {
                source.list_15 = 丸;
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
        return 年月日.concat(RString.HALF_SPACE).concat(時分秒).concat(RString.HALF_SPACE).concat(作成);
    }

    private RString get適用日有効期限() {
        RString 適用日 = RString.EMPTY;
        RString 有効期限 = RString.EMPTY;

        if (this.帳票情報.get適用日() != null) {
            適用日 = this.帳票情報.get適用日().wareki().toDateString();
        }
        if (this.帳票情報.get有効期限() != null) {
            有効期限 = this.帳票情報.get有効期限().wareki().toDateString();
        }
        return 適用日.concat(記号).concat(有効期限);
    }

    private void setiOutputOrder(ShakaiFukushiHojinKeigenHakkoIchiranReportSource source) {

        Map<Integer, ISetSortItem> 出力順Map = ChohyoUtil.get出力順項目Map(iOutputOrder);
        if (出力順Map.get(LISTINDEX_1) != null) {
            source.shutsuryokujun1 = 出力順Map.get(LISTINDEX_1).get項目名();

        }
        if (出力順Map.get(LISTINDEX_2) != null) {
            source.shutsuryokujun2 = 出力順Map.get(LISTINDEX_2).get項目名();
        }
        if (出力順Map.get(LISTINDEX_3) != null) {
            source.shutsuryokujun3 = 出力順Map.get(LISTINDEX_3).get項目名();
        }
        if (出力順Map.get(LISTINDEX_4) != null) {
            source.shutsuryokujun4 = 出力順Map.get(LISTINDEX_4).get項目名();
        }
        if (出力順Map.get(LISTINDEX_5) != null) {
            source.shutsuryokujun5 = 出力順Map.get(LISTINDEX_5).get項目名();
        }
    }
}
