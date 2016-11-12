/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyokyotakuyobosogojigyo;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.JigyoshoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyokyotakuyobosogojigyo.KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyokyotakuyobosogojigyo.KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付管理票のEditorクラスです。
 *
 * @reamsid_L DBC-2840-040 sunhaidi
 */
public class KyufuKanrihyoKyotakuYoboSogoJigyoServiceEditor implements IKyufuKanrihyoKyotakuYoboSogoJigyoServiceEditor {

    private final KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity 帳票出力対象データ;
    private final FlexibleYearMonth 処理年月;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_10 = 10;
    private static final int SIZE_20 = 20;
    private static final RString 元号_明治 = new RString("明治");
    private static final RString 元号_大正 = new RString("大正");
    private static final RString 元号_昭和 = new RString("昭和");
    private static final RString HOUSI = new RString("**");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity
     * @param 処理年月 FlexibleYearMonth
     */
    public KyufuKanrihyoKyotakuYoboSogoJigyoServiceEditor(KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity 帳票出力対象データ, FlexibleYearMonth 処理年月) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.処理年月 = 処理年月;
    }

    @Override
    public KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource edit(KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource source) {
        source.teishutsuYM = パターン56(処理年月);
        if (!RString.isNullOrEmpty(帳票出力対象データ.get更新区分())) {
            source.koshinKbn = KyufukanrihyoSakuseiKubun.toValue(帳票出力対象データ.get更新区分()).get名称();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get保険者番号())) {
            source.hokenshaNo = 帳票出力対象データ.get保険者番号().padRight(INDEX_6);
        }
        source.hokenshaName = 帳票出力対象データ.get保険者名();
        if (!RString.isNullOrEmpty(帳票出力対象データ.get被保険者番号())) {
            source.hihokenshaNo = 帳票出力対象データ.get被保険者番号().padRight(INDEX_10);
        }
        source.hihokenshaKanaShimei = 帳票出力対象データ.get宛名カナ名称();
        source.hihokenshaShimei = 帳票出力対象データ.get宛名名称();
        edit1(source);
        if (!RString.isNullOrEmpty(帳票出力対象データ.get性別コード())) {
            source.seibetsu = Seibetsu.toValue(帳票出力対象データ.get性別コード()).get名称();
        }
        RString 表示用要介護状態区分コード = 帳票出力対象データ.get表示用要介護状態区分コード();
        FlexibleYearMonth 利用年月 = 帳票出力対象データ.get利用年月();
        if ((利用年月 != null && !利用年月.isEmpty()) && !RString.isNullOrEmpty(表示用要介護状態区分コード)) {
            source.yokaigoJotaiKubun
                    = YokaigoJotaiKubunSupport.toValue(利用年月, 表示用要介護状態区分コード).getName();
        }
        source.shikyuGendoKijunGaku = get金額のカンマ編集(帳票出力対象データ.get表示用支給限度単位数());
        RString 限度額適用期間_開始年月 = パターン62(帳票出力対象データ.get限度額適用期間_開始年月());
        if (!RString.isNullOrEmpty(限度額適用期間_開始年月)) {
            source.gendogakuTekiyoKikanStGengo = 限度額適用期間_開始年月.substring(0, 2);
            source.gendogakuTekiyoKikanStYY = 限度額適用期間_開始年月.substring(2, INDEX_4);
            source.gendogakuTekiyoKikanStMM = 限度額適用期間_開始年月.substring(INDEX_5, INDEX_7);
        }
        RString 支給限度有効終了年月 = パターン62(帳票出力対象データ.get支給限度有効終了年月());
        if (!RString.isNullOrEmpty(支給限度有効終了年月)) {
            source.gendogakuTekiyoKikanEdGengo = 支給限度有効終了年月.substring(0, 2);
            source.gendogakuTekiyoKikanEdYY = 支給限度有効終了年月.substring(2, INDEX_4);
            source.gendogakuTekiyoKikanEdMM = 支給限度有効終了年月.substring(INDEX_5, INDEX_7);
        }
        RString サービス提供事業者名称 = 帳票出力対象データ.getサービス提供事業者名称();
        if (!RString.isNullOrEmpty(サービス提供事業者名称)) {

            if (SIZE_20 < サービス提供事業者名称.length()) {
                source.listUpper_1 = サービス提供事業者名称.substring(0, SIZE_20);
                source.listLower_1 = サービス提供事業者名称.substring(SIZE_20);
            } else {
                source.listUpper_1 = サービス提供事業者名称;
                source.listLower_1 = RString.EMPTY;
            }
        }
        RString サービス提供事業者番号 = 帳票出力対象データ.getサービス提供事業者番号();
        if (!RString.isNullOrEmpty(サービス提供事業者番号)) {
            source.listUpper_2 = サービス提供事業者番号.padRight(INDEX_10);
            RString 事業所区分 = サービス提供事業者番号.substring(2, INDEX_3);
            source.listUpper_3 = getサービス識別(事業所区分);
        }
        RString サービス種類コード = 帳票出力対象データ.getサービス種類コード();
        if (!RString.isNullOrEmpty(サービス種類コード)) {
            RString サービス種類 = ServiceCategoryShurui.toValue(サービス種類コード).get名称();
            if (INDEX_7 < サービス種類.length()) {
                source.listUpper_4 = サービス種類.substring(0, INDEX_7);
                source.listLower_2 = サービス種類.substring(INDEX_7);
            } else {
                source.listUpper_4 = サービス種類;
                source.listLower_2 = RString.EMPTY;
            }
        }
        source.listUpper_5 = サービス種類コード;
        if (0 < Decimal.ZERO.compareTo(帳票出力対象データ.get給付計画単位数())) {
            source.listUpper_6 = new RString("(-)");
            source.listLower_3 = new RString(帳票出力対象データ.get給付計画単位数().toString()).replace(new RString("-"), RString.HALF_SPACE);
            source.gokeiTanisuMainusKigo = new RString("(-)");
            source.gokeiTanisu = new RString(帳票出力対象データ.get給付計画単位数().toString()).replace(new RString("-"), RString.HALF_SPACE);
        } else {
            source.listLower_3 = new RString(帳票出力対象データ.get給付計画単位数().toString());
            source.gokeiTanisu = new RString(帳票出力対象データ.get給付計画単位数().toString());
        }
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                ReportKomokuEditorUtil.get非空文字列(帳票出力対象データ.get被保険者番号()));
        return source;
    }

    private void edit1(KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource source) {
        FlexibleDate 生年月日 = 帳票出力対象データ.get生年月日();
        if (生年月日 != null && !生年月日.isEmpty()) {
            RString era = 生年月日.wareki().eraType(EraType.KANJI).toDateString();
            if (era.startsWith(元号_明治)) {
                source.seinengappiGengoMeiji = RString.EMPTY;
                source.seinengappiGengoTaisho = HOUSI;
                source.seinengappiGengoShowa = HOUSI;
            } else if (era.startsWith(元号_大正)) {
                source.seinengappiGengoMeiji = HOUSI;
                source.seinengappiGengoTaisho = RString.EMPTY;
                source.seinengappiGengoShowa = HOUSI;
            } else if (era.startsWith(元号_昭和)) {
                source.seinengappiGengoMeiji = HOUSI;
                source.seinengappiGengoTaisho = HOUSI;
                source.seinengappiGengoShowa = RString.EMPTY;
            }
            source.seinengappiYY = era.substring(2, INDEX_4);
            source.seinengappiMM = era.substring(INDEX_5, INDEX_7);
            source.seinengappiDD = era.substring(INDEX_8);
        }
    }

    private RString get金額のカンマ編集(Decimal 金額) {
        return 金額 == null ? null : DecimalFormatter.toRString(金額, 0);
    }

    private RString getサービス識別(RString 事業所区分) {

        for (JigyoshoKubun jigyoshoKubun : JigyoshoKubun.values()) {
            if (jigyoshoKubun.getコード().equals(事業所区分)) {
                return jigyoshoKubun.get名称();
            }
        }
        return JigyoshoKubun.指定事業所.get名称();
    }

    private RString パターン56(FlexibleYearMonth 処理年月) {
        if (処理年月 == null) {
            return RString.EMPTY;
        }
        return 処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString パターン62(FlexibleYearMonth 処理年月) {
        if (処理年月 == null) {
            return RString.EMPTY;
        }
        return 処理年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
