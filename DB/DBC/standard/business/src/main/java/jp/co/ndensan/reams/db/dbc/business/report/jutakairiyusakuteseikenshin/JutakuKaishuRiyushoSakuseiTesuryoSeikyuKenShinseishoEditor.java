/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakairiyusakuteseikenshin;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakairiyusakuteseikenshin.JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakairiyusakuteseikenshin.JutakuKaishuRSTSKSReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のEditorです。
 *
 * @reamsid_L DBC-2860-040 dangjingjing
 */
public class JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoEditor implements IJutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoEditor {

    private final JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData data;

    /**
     * インスタンスを生成します。
     *
     * @param data JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData
     */
    protected JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoEditor(JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData data) {
        this.data = data;
    }

    @Override
    public JutakuKaishuRSTSKSReportSource edit(JutakuKaishuRSTSKSReportSource source) {
        return editSource(source);
    }

    private JutakuKaishuRSTSKSReportSource editSource(JutakuKaishuRSTSKSReportSource source) {
        source.sofusakiYubinNo = data.get請求者_郵便番号();
        source.jigyoshoJusho = data.get請求者_所在地();
        source.jigyoshoName = data.get請求者_名称();
        source.jigyoshoDaihyoshaShimei = data.get請求者_代表者氏名();
        source.jigyoshaTelNo = data.get請求者_電話番号();
        source.tsuchoBun = data.get通知文();
        source.jigyoshaNo = data.get指定事業者番号();
        source.seikyuGaku = new RString(data.get請求金額().toString());
        source.tanka = data.get単価();
        source.kensu = data.get件数();
        source.hakkoYMD = set平成年月日(new FlexibleDate(data.get発行日()));
        source.ninshoshaYakushokuMei = data.get認証者役職名();
        return source;
    }

    private RString set平成年月日(FlexibleDate dateTime) {
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        return hakkoYMD.toRString();
    }
}
