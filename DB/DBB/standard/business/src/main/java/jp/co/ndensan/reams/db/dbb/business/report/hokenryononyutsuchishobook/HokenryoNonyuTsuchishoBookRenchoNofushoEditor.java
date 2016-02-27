/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookRenchoNofushoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author wangjie2
 */
public class HokenryoNonyuTsuchishoBookRenchoNofushoEditor implements IHokenryoNonyuTsuchishoBookRenchoNofushoEditor {

    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final NofuShoKyotsu 納付書共通;
    private final int 通知書の連番;
    private static final RString 星12 = new RString("************");
    private static final RString 星20 = new RString("********************");
    private static final RString 星19 = new RString("*******************");
    private static final RString 星11 = new RString("***********");
    private static final RString 星10 = new RString("**********");
    private static final RString 星5 = new RString("******");

    protected HokenryoNonyuTsuchishoBookRenchoNofushoEditor(
            HokenryoNonyuTsuchishoBookItem item,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            int 通知書の連番) {
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        this.納付書共通 = null == this.仮算定納入通知書情報 ? null : 仮算定納入通知書情報.get納付書共通();
        this.通知書の連番 = 通知書の連番;
    }

    @Override
    public HokenryoNonyuTsuchishoBookRenchoNofushoSource edit(HokenryoNonyuTsuchishoBookRenchoNofushoSource source) {
        edit印字位置2(source);
        edit印字位置3(source);
        edit印字位置4(source);
        edit印字位置5(source);
        return source;
    }

    private void edit印字位置2(HokenryoNonyuTsuchishoBookRenchoNofushoSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(2);
        boolean is納入通知書期情報がある = is納入通知書期情報がある();
        source.ryoshushoTitleNendo1 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.ryoshushoTitleKi1 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.ryoshushoTitleTsuki1 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.ryoshushoJusho1 = 納付書共通.get住所();
        source.ryoshushoKatagaki1 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.ryoshushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
        source.ryoshushoHokenryoGaku1 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書納付額欄() : 星10;
        source.ryoshushoNokigen1 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.ryoshushoNofuIn1 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付印欄() : new RString("**");
        source.ryoshushoKozaCom1 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書領収印欄() : RString.EMPTY;
        source.ryoshushoZuiji1 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofushoTitleNendo1 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofushoTitleKi1 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofushoTitleTsuki1 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofushoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoHokenryoGaku1 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofushoNokigen1 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofushoNofuIn1 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        edit印字位置2_1(source, 納入通知書期情報, is納入通知書期情報がある);

    }

    private void edit印字位置2_1(HokenryoNonyuTsuchishoBookRenchoNofushoSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofushoKozaCom1 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofushoZuiji1 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoTitleNendoBun1 = RString.EMPTY;
        source.nofuzumishoTitleKi1 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki1 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofozumishoTitleNendo1 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofuzumishoOCR11 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(1) : 星19;
        source.nofuzumishoOCR21 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(2) : 星20;
        source.nofuzumishoOCR31 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(3) : 星12;
        source.nofuzumishoNofuGaku1 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofuzumishoJusho1 = 納付書共通.get住所();
        source.nofuzumishoKatagaki1 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.nofuzumishoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
        source.nofuzumishoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
        source.nofuzumishoNokigen1 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofuzumishoNofuIn1 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofuzumishoKozaCom1 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofuzumishoZuiji1 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoshichosonName1 = 納付書共通.get納付書市町村名();
        source.pagerenban1 = getページ連番(1);
    }

    private void edit印字位置3(HokenryoNonyuTsuchishoBookRenchoNofushoSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(3);
        boolean is納入通知書期情報がある = is納入通知書期情報がある();
        source.ryoshushoTitleNendo2 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.ryoshushoTitleKi2 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.ryoshushoTitleTsuki2 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.ryoshushoJusho2 = 納付書共通.get住所();
        source.ryoshushoKatagaki2 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName2 = 納付書共通.get納付者氏名();
        source.ryoshushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        source.ryoshushoHokenryoGaku2 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書納付額欄() : 星10;
        source.ryoshushoNokigen2 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.ryoshushoNofuIn2 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付印欄() : new RString("**");
        source.ryoshushoKozaCom2 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書領収印欄() : RString.EMPTY;
        source.ryoshushoZuiji2 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofushoTitleNendo2 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofushoTitleKi2 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofushoTitleTsuki2 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofushoHihokenshaName2 = 納付書共通.get納付者氏名();
        source.nofushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoHokenryoGaku2 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofushoNokigen2 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        edit印字位置3_1(source, 納入通知書期情報, is納入通知書期情報がある);
    }

    private void edit印字位置3_1(HokenryoNonyuTsuchishoBookRenchoNofushoSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofushoNofuIn2 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofushoKozaCom2 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofushoZuiji2 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoTitleNendoBun2 = RString.EMPTY;
        source.nofuzumishoTitleKi2 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki2 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofuzumishoOCR12 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(1) : 星19;
        source.nofuzumishoOCR22 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(2) : 星20;
        source.nofuzumishoOCR32 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(3) : 星12;
        source.nofuzumishoNofuGaku2 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofuzumishoJusho2 = 納付書共通.get住所();
        source.nofuzumishoKatagaki2 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName2 = 納付書共通.get納付者氏名();
        source.nofuzumishoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        source.nofuzumishoSetaiCode2 = 納付書共通.get世帯コード().getColumnValue();
        source.nofuzumishoNokigen2 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofuzumishoNofuIn2 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofuzumishoKozaCom2 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofuzumishoZuiji2 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoshichosonName2 = 納付書共通.get納付書市町村名();
        source.pagerenban2 = getページ連番(2);
    }

    private void edit印字位置4(HokenryoNonyuTsuchishoBookRenchoNofushoSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(4);
        boolean is納入通知書期情報がある = is納入通知書期情報がある();
        source.ryoshushoTitleNendo3 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.ryoshushoTitleKi3 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.ryoshushoTitleTsuki3 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.ryoshushoJusho3 = 納付書共通.get住所();
        source.ryoshushoKatagaki3 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName3 = 納付書共通.get納付者氏名();
        source.ryoshushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
        source.ryoshushoHokenryoGaku3 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書納付額欄() : 星10;
        source.ryoshushoNokigen3 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.ryoshushoNofuIn3 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付印欄() : new RString("**");
        source.ryoshushoKozaCom3 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書領収印欄() : RString.EMPTY;
        source.ryoshushoZuiji3 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofushoTitleNendo3 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofushoTitleKi3 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofushoTitleTsuki3 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofushoHihokenshaName3 = 納付書共通.get納付者氏名();
        source.nofushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoHokenryoGaku3 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofushoNokigen3 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofushoNofuIn3 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        edit印字位置4_1(source, 納入通知書期情報, is納入通知書期情報がある);
    }

    private void edit印字位置4_1(HokenryoNonyuTsuchishoBookRenchoNofushoSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofushoKozaCom3 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofushoZuiji3 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoTitleNendoBun3 = RString.EMPTY;
        source.nofuzumishoTitleKi3 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki3 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofuzumishoOCR13 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(1) : 星19;
        source.nofuzumishoOCR23 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(2) : 星20;
        source.nofuzumishoOCR33 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(3) : 星12;
        source.nofuzumishoNofuGaku3 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofuzumishoJusho3 = 納付書共通.get住所();
        source.nofuzumishoKatagaki3 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName3 = 納付書共通.get納付者氏名();
        source.nofuzumishoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
        source.nofuzumishoSetaiCode3 = 納付書共通.get世帯コード().getColumnValue();
        source.nofuzumishoNokigen3 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofuzumishoNofuIn3 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofuzumishoKozaCom3 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofuzumishoZuiji3 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoshichosonName3 = 納付書共通.get納付書市町村名();
        source.pagerenban3 = getページ連番(3);
    }

    private void edit印字位置5(HokenryoNonyuTsuchishoBookRenchoNofushoSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(5);
        boolean is納入通知書期情報がある = is納入通知書期情報がある();
        source.ryoshushoTitleNendo4 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.ryoshushoTitleKi4 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.ryoshushoTitleTsuki4 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.ryoshushoJusho4 = 納付書共通.get住所();
        source.ryoshushoKatagaki4 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName4 = 納付書共通.get納付者氏名();
        source.ryoshushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
        source.ryoshushoHokenryoGaku4 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書納付額欄() : 星10;
        source.ryoshushoNokigen4 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.ryoshushoNofuIn4 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付印欄() : new RString("**");
        source.ryoshushoKozaCom4 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書領収印欄() : RString.EMPTY;
        source.ryoshushoZuiji4 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofushoTitleNendo4 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofushoTitleKi4 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofushoTitleTsuki4 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofushoHihokenshaName4 = 納付書共通.get納付者氏名();
        source.nofushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoHokenryoGaku4 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofushoNokigen4 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofushoNofuIn4 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        edit印字位置5_1(source, 納入通知書期情報, is納入通知書期情報がある);
    }

    private void edit印字位置5_1(HokenryoNonyuTsuchishoBookRenchoNofushoSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofushoKozaCom4 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofushoZuiji4 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoTitleNendoBun4 = RString.EMPTY;
        source.nofuzumishoTitleKi4 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki4 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofuzumishoOCR14 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(1) : 星19;
        source.nofuzumishoOCR24 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(2) : 星20;
        source.nofuzumishoOCR34 = is納入通知書期情報がある ? 納入通知書期情報.getOCR().get(3) : 星12;
        source.nofuzumishoNofuGaku4 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofuzumishoJusho4 = 納付書共通.get住所();
        source.nofuzumishoKatagaki4 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName4 = 納付書共通.get納付者氏名();
        source.nofuzumishoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
        source.nofuzumishoSetaiCode4 = 納付書共通.get世帯コード().getColumnValue();
        source.nofuzumishoNokigen4 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofuzumishoNofuIn4 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofuzumishoKozaCom4 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofuzumishoZuiji4 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoshichosonName4 = 納付書共通.get納付書市町村名();
        source.pagerenban4 = getページ連番(4);
    }

    private RString getページ連番(int 連番) {
        int ページ連番 = 通知書の連番 * 4 + 連番;
        return ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())
                ? new RString(String.valueOf(通知書の連番)).concat("-").concat(String.valueOf(ページ連番))
                : new RString("1-").concat(String.valueOf(ページ連番));
    }

    private NonyuTsuchiShoKiJoho get納入通知書期情報(int 印字位置) {
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (印字位置 == 納入通知書期情報.getブック開始位置()) {
                return 納入通知書期情報;
            }
        }
        return null;
    }

    private boolean is納入通知書期情報がある() {
        return !納入通知書期情報リスト.isEmpty();
    }

}
