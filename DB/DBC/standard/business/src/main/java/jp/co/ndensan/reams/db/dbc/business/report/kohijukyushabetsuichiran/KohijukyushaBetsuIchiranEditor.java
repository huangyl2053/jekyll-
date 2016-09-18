/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kohijukyushabetsuichiran;

import jp.co.ndensan.reams.db.dbc.business.core.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranBusiness;
import jp.co.ndensan.reams.db.dbc.entity.report.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護給付費公費受給者別一覧表Editorクラスです。
 *
 * @reamsid_L DBC-2800-030 xuyannan
 */
public class KohijukyushaBetsuIchiranEditor implements IKohijukyushaBetsuIchiranEditor {

    private static final int 設定項目リスト_INDEX1 = 0;
    private static final int 設定項目リスト_INDEX2 = 1;
    private static final int 設定項目リスト_INDEX3 = 2;
    private static final int 設定項目リスト_INDEX4 = 3;
    private static final int 設定項目リスト_INDEX5 = 4;
    private static final int INDEX = 8;
    private final KohijukyushaBetsuIchiranBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link KohijukyushaBetsuIchiranBusiness}
     */
    protected KohijukyushaBetsuIchiranEditor(KohijukyushaBetsuIchiranBusiness business) {
        this.business = business;
    }

    @Override
    public KohijukyushaBetsuIchiranReportSource edit(KohijukyushaBetsuIchiranReportSource source) {
        return editSource(source);
    }

    private KohijukyushaBetsuIchiranReportSource editSource(KohijukyushaBetsuIchiranReportSource source) {
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), business.get被保険者番号());
        source.printTimeStamp = get印刷日時(business.get作成日時());
        if (!RString.isNullOrEmpty(business.get審査年月())) {
            source.shinsaYM = new FlexibleDate(business.get審査年月()).wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getYearMonth();
        }
        source.kokuhorenName = business.get国保連合会名();
        source.kohiFutanshaNo = business.get公費負担者番号();
        source.kohiFutanshaName = business.get公費負担者名();
        set並び順と改頁(source);
        source.listUpper_1 = business.get公費受給者番号();
        if (!RString.isNullOrEmpty(business.getサービス提供年月())) {
            source.listUpper_2 = new FlexibleDate(business.getサービス提供年月())
                    .wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).getYearMonth();
        }
        source.listUpper_3 = business.get事業所番号();
        source.listLower_1 = business.get事業所名();
        if (!RString.isNullOrEmpty(business.getサービス種類名()) && business.getサービス種類名().length() > INDEX) {
            source.listUpper_4 = business.getサービス種類名().substring(0, INDEX);
            source.listLower_2 = business.getサービス種類名().substring(INDEX, business.getサービス種類名().length());
        } else {
            source.listUpper_4 = business.getサービス種類名();
        }
        if (!RString.isNullOrEmpty(business.getサービス項目名()) && business.getサービス項目名().length() > INDEX) {
            source.listUpper_4 = business.getサービス項目名().substring(0, INDEX);
            source.listLower_3 = business.getサービス項目名().substring(INDEX, business.getサービス項目名().length());
        } else {
            source.listUpper_4 = business.getサービス項目名();
        }
        source.listUpper_6 = business.get日数回数();
        if (business.get公費対象単位数() > 0) {
            source.listUpper_7 = decimalToRString(business.get公費対象単位数());
        }
        if (business.get公費負担金額() > 0) {
            source.listUpper_8 = decimalToRString(business.get公費負担金額());
        }
        if (business.get公費分本人負担額() > 0) {
            source.listUpper_9 = decimalToRString(business.get公費分本人負担額());
        }
        source.listUpper_10 = business.get登録被保険者番号();
        source.listLower_4 = business.get宛名名称();
        source.listUpper_11 = business.get証記載保険者番号();
        if (business.get公費対象単位数集計() > 0) {
            source.kohiTensuGokei = decimalToRString(business.get公費対象単位数集計());
        }
        if (business.get公費負担金額集計() > 0) {
            source.kohiFutanGakuGokei = decimalToRString(business.get公費負担金額集計());
        }
        if (business.get公費分本人負担額集計() > 0) {
            source.kohiHoninFutanGakuGokei = decimalToRString(business.get公費分本人負担額集計());
        }
        return source;
    }

    private static RString get印刷日時(RDateTime datetime) {
        RStringBuilder systemDateTime = new RStringBuilder();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%2d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%2d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%2d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }

    private void set並び順と改頁(KohijukyushaBetsuIchiranReportSource source) {
        if (business.get出力順情報() != null
                && business.get出力順情報().get設定項目リスト() != null) {
            if (business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX1) != null) {
                source.shutsuryokujun1 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX1).get項目名();
                source.kaiPege1 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX1).get項目名();
            }
            if (business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX2) != null) {
                source.shutsuryokujun2 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX2).get項目名();
                source.kaiPege2 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX2).get項目名();
            }
            if (business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX3) != null) {
                source.shutsuryokujun3 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX3).get項目名();
                source.kaiPege3 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX3).get項目名();
            }
            if (business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX4) != null) {
                source.shutsuryokujun4 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX4).get項目名();
                source.kaiPege4 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX4).get項目名();
            }
            if (business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX5) != null) {
                source.shutsuryokujun5 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX5).get項目名();
                source.kaiPege5 = business.get出力順情報().get設定項目リスト().get(設定項目リスト_INDEX5).get項目名();
            }
        }
    }

    private RString decimalToRString(int data) {
        return DecimalFormatter.toコンマ区切りRString(new Decimal(data), 0);
    }
}
