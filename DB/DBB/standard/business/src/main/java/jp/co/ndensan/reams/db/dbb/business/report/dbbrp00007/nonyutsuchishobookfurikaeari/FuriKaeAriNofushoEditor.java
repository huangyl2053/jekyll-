/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishobookfurikaeari;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReportSource;

/**
 * 保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ】の納付書のボディEditorです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class FuriKaeAriNofushoEditor implements INonyuTsuchishoBookFuriKaeAriEditor {

    private final NonyuTsuchishoBookFuriKaeAriItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokusokujoBodyEditor}
     */
    protected FuriKaeAriNofushoEditor(NonyuTsuchishoBookFuriKaeAriItem item) {
        this.item = item;
    }

    @Override
    public FuriKaeAriCoverToNofushoReportSource edit(FuriKaeAriCoverToNofushoReportSource source) {
        return editBody(source);
    }

    private FuriKaeAriCoverToNofushoReportSource editBody(FuriKaeAriCoverToNofushoReportSource source) {

        edit印字位置２(source);
        edit印字位置３(source);
        edit印字位置４(source);
        edit印字位置５(source);
        return source;
    }

    private void edit印字位置２(FuriKaeAriCoverToNofushoReportSource source) {
        source.nofuzumishoTitleNendoBun1 = item.getNofuzumishoTitleNendoBun1();
        source.nofuzumishoTitleKi1 = item.getNofuzumishoTitleKi1();
        source.nofuzumishoTitleTsuki1 = item.getNofuzumishoTitleTsuki1();
        source.nofozumishoTitleNendo1 = item.getNofozumishoTitleNendo1();
        source.ryoshushoTitleNendo1 = item.getRyoshushoTitleNendo1();
        source.ryoshushoTitleKi1 = item.getRyoshushoTitleKi1();
        source.ryoshushoTitleTsuki1 = item.getRyoshushoTitleTsuki1();
        source.nofushoTitleNendo1 = item.getNofushoTitleNendo1();
        source.nofushoTitleKi1 = item.getNofushoTitleKi1();
        source.nofushoTitleTsuki1 = item.getNofushoTitleTsuki1();
        source.ryoshushoJusho1 = item.getRyoshushoJusho1();
        source.nofuzumishoOCR11 = item.getNofuzumishoOCR11();
        source.nofuzumishoTsuchishoNo1 = item.getNofuzumishoTsuchishoNo1();
        source.ryoshushoKatagaki1 = item.getRyoshushoKatagaki1();
        source.nofuzumishoSetaiCode1 = item.getNofuzumishoSetaiCode1();
        source.nofuzumishoOCR21 = item.getNofuzumishoOCR21();
        source.ryoshushoHihokenshaName1 = item.getRyoshushoHihokenshaName1();
        source.nofushoHihokenshaName1 = item.getNofushoHihokenshaName1();
        source.nofuzumishoOCR31 = item.getNofuzumishoOCR31();
        source.nofuzumishoNokigen1 = item.getNofuzumishoNokigen1();
        source.ryoshushoTsuchishoNo1 = item.getRyoshushoTsuchishoNo1();
        source.nofushoTsuchishoNo1 = item.getNofushoTsuchishoNo1();
        source.ryoshushoHokenryoGaku1 = item.getRyoshushoHokenryoGaku1();
        source.nofushoHokenryoGaku1 = item.getNofushoHokenryoGaku1();
        source.nofuzumishoNofuGaku1 = item.getNofuzumishoNofuGaku1();
        source.ryoshushoNokigen1 = item.getRyoshushoNokigen1();
        source.nofushoNokigen1 = item.getNofushoNokigen1();
        source.nofuzumishoJusho1 = item.getNofuzumishoJusho1();
        source.nofuzumishoKatagaki1 = item.getNofuzumishoKatagaki1();
        source.ryoshushoNofuIn1 = item.getRyoshushoNofuIn1();
        source.nofushoNofuIn1 = item.getNofushoNofuIn1();
        source.nofuzumishoNofuIn1 = item.getNofuzumishoNofuIn1();
        source.ryoshushoKozaCom1 = item.getRyoshushoKozaCom1();
        source.nofushoKozaCom1 = item.getNofushoKozaCom1();
        source.nofuzumishoHihokenshaName1 = item.getNofuzumishoHihokenshaName1();
        source.nofuzumishoKozaCom1 = item.getNofuzumishoKozaCom1();
        source.ryoshushoZuiji1 = item.getRyoshushoZuiji1();
        source.nofushoZuiji1 = item.getNofushoZuiji1();
        source.nofuzumishoZuiji1 = item.getNofuzumishoZuiji1();
        source.nofuzumishoshichosonName1 = item.getNofuzumishoshichosonName1();
        source.pagerenban1 = item.getNofusho_pagerenban1();
    }

    private void edit印字位置３(FuriKaeAriCoverToNofushoReportSource source) {
        source.nofozumishoTitleNendo2 = item.getNofozumishoTitleNendo2();
        source.nofuzumishoTitleNendoBun2 = item.getNofuzumishoTitleNendoBun2();
        source.nofuzumishoTitleKi2 = item.getNofuzumishoTitleKi2();
        source.nofuzumishoTitleTsuki2 = item.getNofuzumishoTitleTsuki2();
        source.ryoshushoTitleNendo2 = item.getRyoshushoTitleNendo2();
        source.ryoshushoTitleKi2 = item.getRyoshushoTitleKi2();
        source.ryoshushoTitleTsuki2 = item.getRyoshushoTitleTsuki2();
        source.nofushoTitleNendo2 = item.getNofushoTitleNendo2();
        source.nofushoTitleKi2 = item.getNofushoTitleKi2();
        source.nofushoTitleTsuki2 = item.getNofushoTitleTsuki2();
        source.ryoshushoJusho2 = item.getRyoshushoJusho2();
        source.nofuzumishoTsuchishoNo2 = item.getNofuzumishoTsuchishoNo2();
        source.nofuzumishoOCR12 = item.getNofuzumishoOCR12();
        source.ryoshushoKatagaki2 = item.getRyoshushoKatagaki2();
        source.nofuzumishoSetaiCode2 = item.getNofuzumishoSetaiCode2();
        source.nofuzumishoOCR22 = item.getNofuzumishoOCR22();
        source.ryoshushoHihokenshaName2 = item.getRyoshushoHihokenshaName2();
        source.nofushoHihokenshaName2 = item.getNofushoHihokenshaName2();
        source.nofuzumishoNokigen2 = item.getNofuzumishoNokigen2();
        source.nofuzumishoOCR32 = item.getNofuzumishoOCR32();
        source.ryoshushoTsuchishoNo2 = item.getRyoshushoTsuchishoNo2();
        source.nofushoTsuchishoNo2 = item.getNofushoTsuchishoNo2();
        source.ryoshushoHokenryoGaku2 = item.getRyoshushoHokenryoGaku2();
        source.nofushoHokenryoGaku2 = item.getNofushoHokenryoGaku2();
        source.nofuzumishoNofuGaku2 = item.getNofuzumishoNofuGaku2();
        source.ryoshushoNokigen2 = item.getRyoshushoNokigen2();
        source.nofushoNokigen2 = item.getNofushoNokigen2();
        source.nofuzumishoJusho2 = item.getNofuzumishoJusho2();
        source.nofuzumishoKatagaki2 = item.getNofuzumishoKatagaki2();
        source.ryoshushoNofuIn2 = item.getRyoshushoNofuIn2();
        source.nofushoNofuIn2 = item.getNofushoNofuIn2();
        source.nofuzumishoNofuIn2 = item.getNofuzumishoNofuIn2();
        source.ryoshushoKozaCom2 = item.getRyoshushoKozaCom2();
        source.nofushoKozaCom2 = item.getNofushoKozaCom2();
        source.nofuzumishoHihokenshaName2 = item.getNofuzumishoHihokenshaName2();
        source.nofuzumishoKozaCom2 = item.getNofuzumishoKozaCom2();
        source.ryoshushoZuiji2 = item.getRyoshushoZuiji2();
        source.nofushoZuiji2 = item.getNofushoZuiji2();
        source.nofuzumishoZuiji2 = item.getNofuzumishoZuiji2();
        source.nofuzumishoshichosonName2 = item.getNofuzumishoshichosonName2();
        source.pagerenban2 = item.getNofusho_pagerenban2();
    }

    private void edit印字位置４(FuriKaeAriCoverToNofushoReportSource source) {
        source.nofozumishoTitleNendo3 = item.getNofozumishoTitleNendo3();
        source.nofuzumishoTitleNendoBun3 = item.getNofuzumishoTitleNendoBun3();
        source.nofuzumishoTitleKi3 = item.getNofuzumishoTitleKi3();
        source.nofuzumishoTitleTsuki3 = item.getNofuzumishoTitleTsuki3();
        source.ryoshushoTitleNendo3 = item.getRyoshushoTitleNendo3();
        source.ryoshushoTitleKi3 = item.getRyoshushoTitleKi3();
        source.ryoshushoTitleTsuki3 = item.getRyoshushoTitleTsuki3();
        source.nofushoTitleNendo3 = item.getNofushoTitleNendo3();
        source.nofushoTitleKi3 = item.getNofushoTitleKi3();
        source.nofushoTitleTsuki3 = item.getNofushoTitleTsuki3();
        source.nofuzumishoTsuchishoNo3 = item.getNofuzumishoTsuchishoNo3();
        source.nofuzumishoOCR13 = item.getNofuzumishoOCR13();
        source.ryoshushoJusho3 = item.getRyoshushoJusho3();
        source.ryoshushoKatagaki3 = item.getRyoshushoKatagaki3();
        source.nofuzumishoSetaiCode3 = item.getNofuzumishoSetaiCode3();
        source.nofuzumishoOCR23 = item.getNofuzumishoOCR23();
        source.ryoshushoHihokenshaName3 = item.getRyoshushoHihokenshaName3();
        source.nofushoHihokenshaName3 = item.getNofushoHihokenshaName3();
        source.nofuzumishoNokigen3 = item.getNofuzumishoNokigen3();
        source.nofuzumishoOCR33 = item.getNofuzumishoOCR33();
        source.ryoshushoTsuchishoNo3 = item.getRyoshushoTsuchishoNo3();
        source.nofushoTsuchishoNo3 = item.getNofushoTsuchishoNo3();
        source.ryoshushoHokenryoGaku3 = item.getRyoshushoHokenryoGaku3();
        source.nofushoHokenryoGaku3 = item.getNofushoHokenryoGaku3();
        source.nofuzumishoNofuGaku3 = item.getNofuzumishoNofuGaku3();
        source.ryoshushoNokigen3 = item.getRyoshushoNokigen3();
        source.nofushoNokigen3 = item.getNofushoNokigen3();
        source.nofuzumishoJusho3 = item.getNofuzumishoJusho3();
        source.nofuzumishoKatagaki3 = item.getNofuzumishoKatagaki3();
        source.ryoshushoNofuIn3 = item.getRyoshushoNofuIn3();
        source.nofushoNofuIn3 = item.getNofushoNofuIn3();
        source.nofuzumishoNofuIn3 = item.getNofuzumishoNofuIn3();
        source.ryoshushoKozaCom3 = item.getRyoshushoKozaCom3();
        source.nofushoKozaCom3 = item.getNofushoKozaCom3();
        source.nofuzumishoHihokenshaName3 = item.getNofuzumishoHihokenshaName3();
        source.nofuzumishoKozaCom3 = item.getNofuzumishoKozaCom3();
        source.ryoshushoZuiji3 = item.getRyoshushoZuiji3();
        source.nofushoZuiji3 = item.getNofushoZuiji3();
        source.nofuzumishoZuiji3 = item.getNofuzumishoZuiji3();
        source.nofuzumishoshichosonName3 = item.getNofuzumishoshichosonName3();
        source.pagerenban3 = item.getNofusho_pagerenban3();
    }

    private void edit印字位置５(FuriKaeAriCoverToNofushoReportSource source) {
        source.nofozumishoTitleNendo4 = item.getNofozumishoTitleNendo4();
        source.nofuzumishoTitleNendoBun4 = item.getNofuzumishoTitleNendoBun4();
        source.nofuzumishoTitleKi4 = item.getNofuzumishoTitleKi4();
        source.nofuzumishoTitleTsuki4 = item.getNofuzumishoTitleTsuki4();
        source.ryoshushoTitleNendo4 = item.getRyoshushoTitleNendo4();
        source.ryoshushoTitleKi4 = item.getRyoshushoTitleKi4();
        source.ryoshushoTitleTsuki4 = item.getRyoshushoTitleTsuki4();
        source.nofushoTitleNendo4 = item.getNofushoTitleNendo4();
        source.nofushoTitleKi4 = item.getNofushoTitleKi4();
        source.nofushoTitleTsuki4 = item.getNofushoTitleTsuki4();
        source.ryoshushoJusho4 = item.getRyoshushoJusho4();
        source.nofuzumishoTsuchishoNo4 = item.getNofuzumishoTsuchishoNo4();
        source.nofuzumishoOCR14 = item.getNofuzumishoOCR14();
        source.ryoshushoKatagaki4 = item.getRyoshushoKatagaki4();
        source.nofuzumishoSetaiCode4 = item.getNofuzumishoSetaiCode4();
        source.nofuzumishoOCR24 = item.getNofuzumishoOCR24();
        source.ryoshushoHihokenshaName4 = item.getRyoshushoHihokenshaName4();
        source.nofushoHihokenshaName4 = item.getNofushoHihokenshaName4();
        source.nofuzumishoNokigen4 = item.getNofuzumishoNokigen4();
        source.nofuzumishoOCR34 = item.getNofuzumishoOCR34();
        source.ryoshushoTsuchishoNo4 = item.getRyoshushoTsuchishoNo4();
        source.nofushoTsuchishoNo4 = item.getNofushoTsuchishoNo4();
        source.ryoshushoHokenryoGaku4 = item.getRyoshushoHokenryoGaku4();
        source.nofushoHokenryoGaku4 = item.getNofushoHokenryoGaku4();
        source.nofuzumishoNofuGaku4 = item.getNofuzumishoNofuGaku4();
        source.ryoshushoNokigen4 = item.getRyoshushoNokigen4();
        source.nofushoNokigen4 = item.getNofushoNokigen4();
        source.nofuzumishoJusho4 = item.getNofuzumishoJusho4();
        source.nofuzumishoKatagaki4 = item.getNofuzumishoKatagaki4();
        source.ryoshushoNofuIn4 = item.getRyoshushoNofuIn4();
        source.nofushoNofuIn4 = item.getNofushoNofuIn4();
        source.nofuzumishoNofuIn4 = item.getNofuzumishoNofuIn4();
        source.ryoshushoKozaCom4 = item.getRyoshushoKozaCom4();
        source.nofushoKozaCom4 = item.getNofushoKozaCom4();
        source.nofuzumishoHihokenshaName4 = item.getNofuzumishoHihokenshaName4();
        source.nofuzumishoKozaCom4 = item.getNofuzumishoKozaCom4();
        source.ryoshushoZuiji4 = item.getRyoshushoZuiji4();
        source.nofushoZuiji4 = item.getNofushoZuiji4();
        source.nofuzumishoZuiji4 = item.getNofuzumishoZuiji4();
        source.nofuzumishoshichosonName4 = item.getNofuzumishoshichosonName4();
        source.pagerenban4 = item.getNofusho_pagerenban4();
        source.eRenban = item.getERenban();
        source.ePage = item.getEPage();
        source.eHokensyaName = item.getEHokensyaName();
    }

}
