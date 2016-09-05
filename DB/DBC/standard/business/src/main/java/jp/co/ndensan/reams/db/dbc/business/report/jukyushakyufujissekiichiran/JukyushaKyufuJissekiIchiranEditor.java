/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
        source.hokenshaName = data.get保険者氏名();
        source.hokenshaNo = data.get保険者番号();
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
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (data.get被保険者番号() != null) {
            source.hihokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), data.get被保険者番号());
        }
        return source;
    }

    private RString set作成日時(RDateTime dateTime) {
        dateTime = RDateTime.now();
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        hakkoYMD.append("△");
        hakkoYMD.append(RString.HALF_SPACE);
        hakkoYMD.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        hakkoYMD.append("△");
        hakkoYMD.append("作成");
        return hakkoYMD.toRString();
    }

}
