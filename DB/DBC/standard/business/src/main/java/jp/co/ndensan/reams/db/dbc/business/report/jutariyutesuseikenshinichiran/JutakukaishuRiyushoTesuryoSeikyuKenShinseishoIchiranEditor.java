/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutariyutesuseikenshinichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のEditorです。
 *
 * @reamsid_L DBC-2860-050 dangjingjing
 */
public class JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranEditor implements
        IJutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranEditor {

    private final JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData data;

    /**
     * インスタンスを生成します。
     *
     * @param data JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData
     */
    protected JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranEditor(JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData data) {
        this.data = data;
    }

    @Override
    public JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource edit(
            JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource source) {
        return editSource(source);
    }

    private JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource editSource(
            JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource source) {
        source.printTimeStamp = set平成年月日(data.get作成年月日());
        source.jigyoshaMeisho = data.get事業者名();
        source.kaishiYM = set平成年月日(data.get集計期間開始());
        source.syuryoYM = set平成年月日(data.get集計期間終了());
        source.list1_1 = data.get連番();
        source.list1_2 = set平成年月日(data.get理由書作成日());
        source.list1_3 = data.get被保険者番号();
        source.list1_4 = data.get被保険者氏名();
        source.list1_5 = data.get改修先住所();
        source.list1_6 = data.get工事の種類();
        source.list1_7 = data.get理由書作成者();
        source.list1_8 = data.get備考();
        source.shikibetuCode = data.get識別コード();
        if (data.get被保険者番号() != null) {
            source.hihokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), data.get被保険者番号());
        }
        return source;
    }

    private RString set平成年月日(FlexibleDate dateTime) {
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        return hakkoYMD.toRString();
    }
}
