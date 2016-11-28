/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009;

import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFrom2009ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 自己負担証明書_2009年以降のEditorです。
 *
 * @reamsid_L DBC-4810-040 kanghongsong
 */
public class JikoFutangakushomeishoFrom2009HeaderEditor implements IJikoFutangakushomeishoFrom2009Editor {

    private final JikoFutangakushomeishoFromData data;

    /**
     * インスタンスを生成します。
     *
     * @param data 自己負担証明書
     */
    protected JikoFutangakushomeishoFrom2009HeaderEditor(JikoFutangakushomeishoFromData data) {
        this.data = data;
    }

    @Override
    public JikoFutangakushomeishoFrom2009ReportSource edit(JikoFutangakushomeishoFrom2009ReportSource source) {
        source.bunshoNo = data.get文書番号();
        source.title = data.getタイトル();
        source.tsuchibun1 = data.get通知文1();
        source.hokenshaJoho = data.get保険者情報();
        source.tsuchibun2 = data.get通知文2();
        source.biko = data.get備考();
        source.toiawasesaki = data.get問合せ先情報();
        KogakuGassanData 高額合算データ = data.get高額合算データ();
        if (高額合算データ.get被保険者氏名カナ() != null) {
            source.hihokenshaNameKana = 高額合算データ.get被保険者氏名カナ().value();
        }
        if (高額合算データ.get被保険者氏名() != null) {
            source.hihokenshaName = 高額合算データ.get被保険者氏名().value();
        }

        if (高額合算データ.get性別() != null) {
            source.seibetsu = 高額合算データ.get性別().getName().getShortJapanese();
        }
        if (高額合算データ.get生年月日() != null) {
            source.birthYMD = getDate1(高額合算データ.get生年月日());
        }
        if (高額合算データ.get対象年度() != null) {
            source.taishoNendo = パターン62(高額合算データ.get対象年度());
        }

        source.jikoFutanSeiriNO = 高額合算データ.get自己負担額証明書整理番号();
        if (高額合算データ.get保険者番号() != null) {
            source.hokenshaNo = new RString(高額合算データ.get保険者番号().toString());
        }
        if (高額合算データ.get被保険者番号() != null) {
            source.hihokenshaNo = 高額合算データ.get被保険者番号().value();
            source.hihokennshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), source.hihokenshaNo);
        }
        if (高額合算データ.get対象計算期間開始年月日() != null) {
            source.keisanSTYMD = パターン12(高額合算データ.get対象計算期間開始年月日());
        }
        if (高額合算データ.get対象計算期間終了年月日() != null) {
            source.keisanEDYMD = パターン12(高額合算データ.get対象計算期間終了年月日());
        }
        if (高額合算データ.get被保険者期間開始年月日() != null) {
            source.hihoKikanSTYMD = パターン12(高額合算データ.get被保険者期間開始年月日());
        }
        if (高額合算データ.get被保険者期間開始年月日() != null) {
            source.hihoKikanEDYMD = パターン12(高額合算データ.get被保険者期間終了年月日());
        }

        if (高額合算データ.get対象年度() != null) {
            source.toNendo = パターン127(高額合算データ.get対象年度());
        }
        if (高額合算データ.get対象年度() != null) {
            source.yokuNendo = パターン127(高額合算データ.get対象年度().plusYear(1));
        }
        if (高額合算データ.get支給申請書整理番号() != null) {
            source.shikyuSeiriNo = 高額合算データ.get支給申請書整理番号();
        }

        if (高額合算データ.get識別コード() != null) {
            source.shikibetuCode = 高額合算データ.get識別コード();
        }
        return source;
    }

    private static RString パターン12(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private static RString パターン127(FlexibleYear year) {
        if (year == null || year.isEmpty()) {
            return RString.EMPTY;
        }
        return year.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private static RString getDate1(FlexibleDate date) {
        if (date == null || date.equals(FlexibleDate.MAX) || date.equals(FlexibleDate.MIN)) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString パターン62(FlexibleYear 年度) {
        if (年度 == null) {
            return RString.EMPTY;
        }
        return 年度.wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
