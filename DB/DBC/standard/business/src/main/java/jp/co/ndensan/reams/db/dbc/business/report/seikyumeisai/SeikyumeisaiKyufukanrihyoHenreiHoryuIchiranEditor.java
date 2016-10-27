/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyumeisai;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyumeisai.SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.seikyumeisai.SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource;
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
 * 請求明細・給付管理票返戻（保留）一覧表Editorクラスです。
 *
 * @reamsid_L DBC-2830-030 xuyannan
 */
public class SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEditor implements ISeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEditor {

    private final SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity entity;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity}
     * @param index 連番
     */
    protected SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEditor(SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity entity, int index) {
        this.entity = entity;
        this.index = index;
    }

    @Override
    public SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource edit(SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource source) {
        return editSource(source);
    }

    private SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource editSource(SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource source) {
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), entity.get登録被保険者番号());
        source.printTimeStamp = get印刷日時(entity.get作成日時());
        if (!RString.isNullOrEmpty(entity.get審査年月())) {
            source.shinsaYM = new FlexibleDate(entity.get審査年月()).wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getYearMonth();
        }
        source.shoHokenshaNo = entity.get保険者番号();
        source.shoHokenshaName = entity.get保険者名();
        source.kokuhorenName = entity.get国保連合会名();
        source.listUpper_1 = new RString(index);
        source.listUpper_2 = entity.get事業者番号();
        source.listUpper_3 = entity.get登録被保険者番号();
        source.listUpper_4 = entity.get種別();
        if (RString.isNullOrEmpty(entity.getサービス提供年月())) {
            source.listUpper_5 = new FlexibleDate(entity.getサービス提供年月())
                    .wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).getYearMonth();
        }
        source.listUpper_6 = entity.getサービス種類コード();
        if (entity.get単位数().compareTo(Decimal.ZERO) == 1) {
            source.listUpper_7 = DecimalFormatter.toコンマ区切りRString(entity.get単位数(), 0);
        }
        source.listUpper_8 = entity.get事由();
        source.listUpper_9 = entity.get内容();
        source.listUpper_10 = entity.get備考();
        source.listLower_1 = entity.get事業者名();
        source.listLower_2 = entity.get宛名名称();
        source.listLower_3 = entity.getサービス項目コード等();
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
}
