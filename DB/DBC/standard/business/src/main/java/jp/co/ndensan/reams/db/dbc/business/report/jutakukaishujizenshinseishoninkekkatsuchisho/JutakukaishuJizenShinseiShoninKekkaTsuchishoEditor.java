/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakukaishujizenshinseishoninkekka.JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修事前申請承認結果通知書Editorです。
 */
public class JutakukaishuJizenShinseiShoninKekkaTsuchishoEditor implements IJutakukaishuJizenShinseiShoninKekkaTsuchishoEditor {

    private static final RString 承認区分_承認 = new RString("承認");
    private static final RString 承認区分_未承認 = new RString("未承認");
    private final JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JutakukaishuJizenShinseiShoninKekkaTsuchishoItem}
     */
    protected JutakukaishuJizenShinseiShoninKekkaTsuchishoEditor(JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource edit(JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource source) {
        return editSource(source);
    }

    private JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource editSource(JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource source) {

        source.bunshoNo = item.getBunshoNo();
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.uketsukeYMD = item.getUketsukeYMD();
        if (ShoninKubun.承認する.getコード().equals(item.getShoninKbn())) {
            source.shoninKbn = 承認区分_承認;
        } else if (ShoninKubun.承認しない.getコード().equals(item.getShoninKbn())) {
            source.shoninKbn = 承認区分_未承認;
        }
        source.shoninYMD = item.getShoninYMD();
        source.fushoninRiyu = item.getFushoninRiyu();
        source.kyufuShurui = item.getKyufuShurui();
        source.jigyoshaName = item.getJigyoshaName();
        source.jigyoshaYubinNo = item.getJigyoshaYubinNo();
        source.jigyoshoJusho = item.getJigyoshoJusho();
        source.jigyoshoTelNo = item.getJigyoshoTelNo();
        source.riyushoSakuseisha = item.getRiyushoSakuseisha();
        source.hiyogakuGokei = item.getHiyogakuGokei();
        source.hokenHiyogaku = item.getHokenHiyogaku();
        source.riyoFutangaku = item.getRiyoFutangaku();
        source.hokenKyufuhigaku = item.getHokenKyufuhigaku();
        source.tsuchibun2 = item.getTsuchibun2();
        source.hakkoYMD = item.getHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinShoryaku = item.getKoinShoryaku();
        source.yubinNo = item.getYubinNo();
        source.gyoseiku1 = item.getGyoseiku1();
        source.jusho4 = item.getJusho4();
        source.jushoText = item.getJushoText();
        source.jusho5 = item.getJusho5();
        source.jusho6 = item.getJusho6();
        source.katagakiText = item.getKatagakiText();
        source.katagaki3 = item.getKatagaki3();
        source.katagakiSmall2 = item.getKatagakiSmall2();
        source.katagaki4 = item.getKatagaki4();
        source.katagakiSmall1 = item.getKatagakiSmall1();
        source.shimei5 = item.getShimei5();
        source.shimeiSmall2 = item.getShimeiSmall2();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo2 = item.getMeishoFuyo2();
        source.shimeiSmall1 = item.getShimeiSmall1();
        source.dainoKubunMei = item.getDainoKubunMei();
        source.shimei6 = item.getShimei6();
        source.meishoFuyo1 = item.getMeishoFuyo1();
        source.samabunShimeiText = item.getSamabunShimeiText();
        source.samaBun2 = item.getSamaBun2();
        source.kakkoLeft2 = item.getKakkoLeft2();
        source.samabunShimei2 = item.getSamabunShimei2();
        source.samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
        source.kakkoRight2 = item.getKakkoRight2();
        source.kakkoLeft1 = item.getKakkoLeft1();
        source.samabunShimei1 = item.getSamabunShimei1();
        source.samaBun1 = item.getSamaBun1();
        source.kakkoRight1 = item.getKakkoRight1();
        source.samabunShimeiSmall1 = item.getSamabunShimeiSmall1();
        source.customerBarCode = item.getCustomerBarCode();
        return source;
    }
}
