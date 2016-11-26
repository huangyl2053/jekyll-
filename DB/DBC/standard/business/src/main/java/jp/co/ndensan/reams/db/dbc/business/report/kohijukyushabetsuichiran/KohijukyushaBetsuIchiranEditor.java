/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kohijukyushabetsuichiran;

import jp.co.ndensan.reams.db.dbc.business.core.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranBusiness;
import jp.co.ndensan.reams.db.dbc.entity.report.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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

    private static final int INDEX = 8;
    private final KohijukyushaBetsuIchiranBusiness business;
    private final boolean 集計Flag;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link KohijukyushaBetsuIchiranBusiness}
     * @param 集計Flag 集計Flag
     */
    protected KohijukyushaBetsuIchiranEditor(KohijukyushaBetsuIchiranBusiness business, boolean 集計Flag) {
        this.business = business;
        this.集計Flag = 集計Flag;
    }

    @Override
    public KohijukyushaBetsuIchiranReportSource edit(KohijukyushaBetsuIchiranReportSource source) {
        return editSource(source);
    }

    private KohijukyushaBetsuIchiranReportSource editSource(KohijukyushaBetsuIchiranReportSource source) {
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), business.get登録被保険者番号().value());
        source.printTimeStamp = get印刷日時(business.get作成日時());
        FlexibleYearMonth 審査年月 = business.get審査年月();
        if (審査年月 != null && !審査年月.isEmpty()) {
            source.shinsaYM = 審査年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.kokuhorenName = business.get国保連合会名();
        source.kohiFutanshaNo = business.get公費負担者番号();
        source.kohiFutanshaName = business.get公費負担者名();
        source.kaiPege1 = business.get改頁1();
        source.kaiPege2 = business.get改頁2();
        source.kaiPege3 = business.get改頁3();
        source.kaiPege4 = business.get改頁4();
        source.kaiPege5 = business.get改頁5();
        source.shutsuryokujun1 = business.get並び順1();
        source.shutsuryokujun2 = business.get並び順2();
        source.shutsuryokujun3 = business.get並び順3();
        source.shutsuryokujun4 = business.get並び順4();
        source.shutsuryokujun5 = business.get並び順5();
        source.listUpper_1 = business.get公費受給者番号();
        FlexibleYearMonth サービス提供年月 = business.getサービス提供年月();
        if (サービス提供年月 != null && !サービス提供年月.isEmpty()) {
            source.listUpper_2 = サービス提供年月
                    .wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
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
            source.listUpper_5 = business.getサービス項目名().substring(0, INDEX);
            source.listLower_3 = business.getサービス項目名().substring(INDEX, business.getサービス項目名().length());
        } else {
            source.listUpper_5 = business.getサービス項目名();
        }
        source.listUpper_6 = new RString(business.get日数回数().toString());
        source.listUpper_7 = decimalFormatter(business.get公費対象単位数(), 0);
        source.listUpper_8 = decimalFormatter(business.get公費負担金額(), 0);
        source.listUpper_9 = decimalFormatter(business.get公費分本人負担額(), 0);
        HihokenshaNo 登録被保険者番号 = business.get登録被保険者番号();
        if (登録被保険者番号 != null && !登録被保険者番号.isEmpty()) {
            source.listUpper_10 = business.get登録被保険者番号().value();
        }
        source.listLower_4 = business.get宛名名称();
        ShoKisaiHokenshaNo 証記載保険者番号 = business.get証記載保険者番号();
        if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
            source.listUpper_11 = business.get証記載保険者番号().value();
        }
        if (集計Flag) {
            source.kohiTensuGokei = decimalFormatter(business.get公費対象単位数集計(), 0);
            source.kohiFutanGakuGokei = decimalFormatter(business.get公費負担金額集計(), 0);
            source.kohiHoninFutanGakuGokei = decimalFormatter(business.get公費分本人負担額集計(), 0);
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

    private RString decimalFormatter(RString 額, int count) {
        if (null == 額) {
            return RString.EMPTY;
        }
        if (Decimal.canConvert(額)) {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(額.toString()), count);
        }
        return 額;
    }
}
