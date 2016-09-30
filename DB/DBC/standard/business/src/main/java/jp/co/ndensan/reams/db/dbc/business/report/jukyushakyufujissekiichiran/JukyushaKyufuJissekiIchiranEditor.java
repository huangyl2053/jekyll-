/*
 * To data this license header, choose License Headers in Project Properties.
 * To data this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakyufujissekiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranReportSource;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 受給者給付実績一覧表 のEditorです。
 *
 * @reamsid_L DBC-3070-040 dangjingjing
 */
public class JukyushaKyufuJissekiIchiranEditor implements IJukyushaKyufuJissekiIchiranEditor {

    private final JukyushaKyufuJissekiIchiranData data;
    private static final RString 三角 = new RString("△");

    /**
     * インスタンスを生成します。
     *
     * @param data JukyushaKyufuJissekiIchiranData
     */
    protected JukyushaKyufuJissekiIchiranEditor(JukyushaKyufuJissekiIchiranData data) {
        this.data = data;
    }

    @Override
    public JukyushaKyufuJissekiIchiranReportSource edit(JukyushaKyufuJissekiIchiranReportSource source) {
        return editSource(source);
    }

    private JukyushaKyufuJissekiIchiranReportSource editSource(JukyushaKyufuJissekiIchiranReportSource source) {
        source.printTimeStamp = set作成日時(data.get作成日時());
        source.hokenshaName = data.get市町村名();
        source.hokenshaNo = data.get市町村コード();
        source.shutsuryokujun1 = data.get出力順1();
        source.shutsuryokujun2 = data.get出力順2();
        source.shutsuryokujun3 = data.get出力順3();
        source.shutsuryokujun4 = data.get出力順4();
        source.shutsuryokujun5 = data.get出力順5();
        source.kaiPege1 = data.get改頁1();
        source.kaiPege2 = data.get改頁2();
        source.kaiPege3 = data.get改頁3();
        source.kaiPege4 = data.get改頁4();
        source.kaiPege5 = data.get改頁5();
        source.listUpper_1 = data.get被保険者番号();
        source.listUpper_2 = data.get被保険者氏名();
        source.listUpper_3 = data.get要介護度();
        source.listUpper_4 = set年月(data.getサービス提供年月());
        source.listUpper_5 = data.get公費負担者1();
        source.listUpper_6 = data.get公費受給者1();
        source.listUpper_7 = data.getサービス単位数_保険();
        source.listUpper_8 = data.getサービス単位数_公費1();
        source.listUpper_9 = data.get請求額_保険();
        source.listUpper_10 = data.get請求額_公費1();
        source.listUpper_11 = data.get負担額_利用者();
        source.listUpper_12 = data.get負担額_公費本人1();
        source.listUpper_13 = data.get緊急時施設療養請求合計額_保険();
        source.listUpper_14 = data.get緊急時施設療養請求合計額_公費1();
        source.listUpper_15 = data.get特定診療請求合計額_保険();
        source.listUpper_16 = data.get特定診療請求合計額_公費1();
        source.listUpper_17 = data.get特定入所者介護費等請求額_保険();
        source.listUpper_18 = data.get特定入所者介護費等請求額_公費1();
        source.listCenter_1 = data.get識別コード();
        source.listCenter_2 = data.get住所();
        source.listCenter_3 = data.get様式();
        source.listCenter_4 = data.get公費負担者2();
        source.listCenter_5 = data.get公費受給者2();
        source.listCenter_6 = data.getサービス単位数_公費2();
        source.listCenter_7 = data.get請求額_公費2();
        source.listCenter_8 = data.get負担額_公費本人2();
        source.listCenter_9 = data.get緊急時施設療養請求合計額_公費2();
        source.listCenter_10 = data.get特定診療請求合計額_公費2();
        source.listCenter_11 = data.get特定入所者介護費等請求額_公費2();
        source.listCenter_12 = set年月(data.get審査年月());
        source.listLower_1 = data.get世帯コード();
        source.listLower_2 = data.get事業者番号();
        source.listLower_3 = data.get事業者名称();
        source.listLower_4 = data.get実績区分();
        source.listLower_5 = data.get公費負担者3();
        source.listLower_6 = data.get公費受給者3();
        source.listLower_7 = data.getサービス単位数_公費3();
        source.listLower_8 = data.get請求額_公費3();
        source.listLower_9 = data.get負担額_公費本人3();
        source.listLower_10 = data.get緊急時施設療養請求合計額_公費3();
        source.listLower_11 = data.get特定診療請求合計額_公費3();
        source.listLower_12 = data.get特定入所者介護費等請求額_公費3();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (data.get被保険者番号() != null) {
            source.hihokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), data.get被保険者番号());
        }
        return source;
    }

    private RString set作成日時(RDateTime dateTime) {
        RStringBuilder hakkoYMD = new RStringBuilder();
        if (dateTime != null) {
            hakkoYMD.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.ZERO).toDateString());
            hakkoYMD.append(三角);
            hakkoYMD.append(RString.HALF_SPACE);
            hakkoYMD.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
            hakkoYMD.append(三角);
            hakkoYMD.append("作成");
        }
        return hakkoYMD.toRString();
    }

    private RString set年月(FlexibleYearMonth dateTime) {
        RStringBuilder hakkoYMD = new RStringBuilder();
        if (dateTime != null) {
            hakkoYMD.append(dateTime.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString());
        }
        return hakkoYMD.toRString();
    }
}
