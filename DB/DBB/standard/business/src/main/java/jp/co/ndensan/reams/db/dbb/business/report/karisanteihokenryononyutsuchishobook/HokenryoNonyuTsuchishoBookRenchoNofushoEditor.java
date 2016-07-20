/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（仮算定）【ブックタイプ】納付書_連帳の帳票クラスです。
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class HokenryoNonyuTsuchishoBookRenchoNofushoEditor implements IKarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor {

    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final NofuShoKyotsu 納付書共通;
    private final int 通知書の連番;
    private final int ページ;
    private static final RString 星12 = new RString("************");
    private static final RString 星20 = new RString("********************");
    private static final RString 星19 = new RString("*******************");
    private static final RString 星11 = new RString("***********");
    private static final RString 星10 = new RString("**********");
    private static final RString 星5 = new RString("******");
    private static final int INT1 = 1;
    private static final int INT2 = 2;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;

    /**
     * コンストラクタです。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param 納入通知書期情報リスト 納入通知書期情報リスト
     * @param ページ ページ
     */
    protected HokenryoNonyuTsuchishoBookRenchoNofushoEditor(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト, int ページ) {
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.納付書共通 = null == 仮算定納入通知書情報.get納付書共通() ? new NofuShoKyotsu() : 仮算定納入通知書情報.get納付書共通();
        this.通知書の連番 = 仮算定納入通知書情報.get連番();
        this.ページ = ページ;
    }

    @Override
    public KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource edit(KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        source.layoutBreakItem = INT2;
        edit印字位置2(source);
        edit印字位置3(source);
        edit印字位置4(source);
        edit印字位置5(source);
        return source;
    }

    private void edit印字位置2(KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(2);
        boolean is納入通知書期情報がある = is納入通知書期情報がある(納入通知書期情報);
        source.ryoshushoTitleNendo1 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.ryoshushoTitleKi1 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.ryoshushoTitleTsuki1 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.ryoshushoJusho1 = 納付書共通.get住所();
        source.ryoshushoKatagaki1 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName1 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.ryoshushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
        }
        source.ryoshushoHokenryoGaku1 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書納付額欄() : 星10;
        source.ryoshushoNokigen1 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.ryoshushoNofuIn1 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付印欄() : new RString("**");
        source.ryoshushoKozaCom1 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書領収印欄() : RString.EMPTY;
        source.ryoshushoZuiji1 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofushoTitleNendo1 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofushoTitleKi1 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofushoTitleTsuki1 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofushoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.nofushoHokenryoGaku1 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofushoNokigen1 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofushoNofuIn1 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        edit印字位置2_1(source, 納入通知書期情報, is納入通知書期情報がある);

    }

    private void edit印字位置2_1(KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofushoKozaCom1 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofushoZuiji1 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoTitleNendoBun1 = RString.EMPTY;
        source.nofuzumishoTitleKi1 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki1 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofozumishoTitleNendo1 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofuzumishoOCR11 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT1) : 星19;
        source.nofuzumishoOCR21 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT2) : 星20;
        source.nofuzumishoOCR31 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT3) : 星12;
        source.nofuzumishoNofuGaku1 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofuzumishoJusho1 = 納付書共通.get住所();
        source.nofuzumishoKatagaki1 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName1 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
        }
        source.nofuzumishoNokigen1 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofuzumishoNofuIn1 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofuzumishoKozaCom1 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofuzumishoZuiji1 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoshichosonName1 = 納付書共通.get納付書市町村名();
        source.pagerenban5 = getページ連番(1);
    }

    private void edit印字位置3(KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(INT3);
        boolean is納入通知書期情報がある = is納入通知書期情報がある(納入通知書期情報);
        source.ryoshushoTitleNendo2 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.ryoshushoTitleKi2 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.ryoshushoTitleTsuki2 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.ryoshushoJusho2 = 納付書共通.get住所();
        source.ryoshushoKatagaki2 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName2 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.ryoshushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        }
        source.ryoshushoHokenryoGaku2 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書納付額欄() : 星10;
        source.ryoshushoNokigen2 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.ryoshushoNofuIn2 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付印欄() : new RString("**");
        source.ryoshushoKozaCom2 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書領収印欄() : RString.EMPTY;
        source.ryoshushoZuiji2 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofushoTitleNendo2 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofushoTitleKi2 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofushoTitleTsuki2 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofushoHihokenshaName2 = 納付書共通.get納付者氏名();
        source.nofushoHokenryoGaku2 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofushoNokigen2 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        edit印字位置3_1(source, 納入通知書期情報, is納入通知書期情報がある);
    }

    private void edit印字位置3_1(KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofuzumishoTitleNendoBun2 = RString.EMPTY;
        source.nofuzumishoTitleKi2 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki2 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        if (is納入通知書期情報がある) {
            source.nofuzumishoOCR12 = null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT1);
            source.nofuzumishoOCR22 = null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT2);
            source.nofuzumishoOCR32 = null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT3);
            source.nofushoNofuIn2 = 納入通知書期情報.get領収日付欄();
            source.nofushoKozaCom2 = 納入通知書期情報.get納付書領収印欄();
            source.nofushoZuiji2 = 納入通知書期情報.get随時表記();
            source.nofozumishoTitleNendo2 = 納付書共通.get調定年度表記();
        } else {
            source.nofuzumishoOCR12 = 星19;
            source.nofuzumishoOCR22 = 星20;
            source.nofuzumishoOCR32 = 星12;
            source.nofushoNofuIn2 = new RString("**");
            source.nofushoKozaCom2 = RString.EMPTY;
            source.nofushoZuiji2 = RString.EMPTY;
            source.nofozumishoTitleNendo2 = 星5;
        }
        source.nofuzumishoNofuGaku2 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofuzumishoJusho2 = 納付書共通.get住所();
        source.nofuzumishoKatagaki2 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName2 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode2 = 納付書共通.get世帯コード().getColumnValue();
        }
        source.nofuzumishoNokigen2 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofuzumishoNofuIn2 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofuzumishoKozaCom2 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofuzumishoZuiji2 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoshichosonName2 = 納付書共通.get納付書市町村名();
        source.pagerenban6 = getページ連番(2);
    }

    private void edit印字位置4(KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(INT4);
        boolean is納入通知書期情報がある = is納入通知書期情報がある(納入通知書期情報);
        source.ryoshushoTitleNendo3 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.ryoshushoTitleKi3 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.ryoshushoTitleTsuki3 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.ryoshushoJusho3 = 納付書共通.get住所();
        source.ryoshushoKatagaki3 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName3 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.ryoshushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
        }
        source.ryoshushoHokenryoGaku3 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書納付額欄() : 星10;
        source.ryoshushoNokigen3 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.ryoshushoNofuIn3 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付印欄() : new RString("**");
        source.ryoshushoKozaCom3 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書領収印欄() : RString.EMPTY;
        source.ryoshushoZuiji3 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofushoTitleNendo3 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofushoTitleKi3 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofushoTitleTsuki3 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofushoHihokenshaName3 = 納付書共通.get納付者氏名();
        source.nofushoHokenryoGaku3 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofushoNokigen3 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofushoNofuIn3 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        edit印字位置4_1(source, 納入通知書期情報, is納入通知書期情報がある);
    }

    private void edit印字位置4_1(KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofushoKozaCom3 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofushoZuiji3 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoTitleNendoBun3 = RString.EMPTY;
        source.nofozumishoTitleNendo3 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofuzumishoTitleKi3 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki3 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofuzumishoOCR13 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT1) : 星19;
        source.nofuzumishoOCR23 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT2) : 星20;
        source.nofuzumishoOCR33 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT3) : 星12;
        source.nofuzumishoNofuGaku3 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofuzumishoJusho3 = 納付書共通.get住所();
        source.nofuzumishoKatagaki3 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName3 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode3 = 納付書共通.get世帯コード().getColumnValue();
        }
        source.nofuzumishoNokigen3 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofuzumishoNofuIn3 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofuzumishoKozaCom3 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofuzumishoZuiji3 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoshichosonName3 = 納付書共通.get納付書市町村名();
        source.pagerenban7 = getページ連番(INT3);
    }

    private void edit印字位置5(KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(INT5);
        boolean is納入通知書期情報がある = is納入通知書期情報がある(納入通知書期情報);
        source.ryoshushoTitleNendo4 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.ryoshushoTitleKi4 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.ryoshushoTitleTsuki4 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.ryoshushoJusho4 = 納付書共通.get住所();
        source.ryoshushoKatagaki4 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName4 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.ryoshushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
        }
        source.ryoshushoHokenryoGaku4 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書納付額欄() : 星10;
        source.ryoshushoNokigen4 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.ryoshushoNofuIn4 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付印欄() : new RString("**");
        source.ryoshushoKozaCom4 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書領収印欄() : RString.EMPTY;
        source.ryoshushoZuiji4 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofushoTitleNendo4 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofushoTitleKi4 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofushoTitleTsuki4 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofushoHihokenshaName4 = 納付書共通.get納付者氏名();
        source.nofushoHokenryoGaku4 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofushoNokigen4 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofushoNofuIn4 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        edit印字位置5_1(source, 納入通知書期情報, is納入通知書期情報がある);
    }

    private void edit印字位置5_1(KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofushoKozaCom4 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofushoZuiji4 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofozumishoTitleNendo4 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofuzumishoTitleNendoBun4 = RString.EMPTY;
        source.nofuzumishoTitleKi4 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki4 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofuzumishoOCR14 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT1) : 星19;
        source.nofuzumishoOCR24 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT2) : 星20;
        source.nofuzumishoOCR34 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT3) : 星12;
        source.nofuzumishoNofuGaku4 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofuzumishoJusho4 = 納付書共通.get住所();
        source.nofuzumishoKatagaki4 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName4 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode4 = 納付書共通.get世帯コード().getColumnValue();
        }
        source.nofuzumishoNokigen4 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofuzumishoNofuIn4 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofuzumishoKozaCom4 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofuzumishoZuiji4 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoshichosonName4 = 納付書共通.get納付書市町村名();
        source.pagerenban8 = getページ連番(INT4);
    }

    private RString getページ連番(int 連番) {
        int ページ連番 = ページ * INT4 + 連番;
        return ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())
                ? new RString(String.valueOf(通知書の連番)).concat("-").concat(String.valueOf(ページ連番))
                : new RString("1-").concat(String.valueOf(ページ連番));
    }

    private NonyuTsuchiShoKiJoho get納入通知書期情報(int 印字位置) {
        if (納入通知書期情報リスト.size() >= 印字位置 - 1) {
            return 納入通知書期情報リスト.get(印字位置 - 2);
        }
        return null;
    }

    private boolean is納入通知書期情報がある(NonyuTsuchiShoKiJoho 納入通知書期情報) {
        return 納入通知書期情報 != null;
    }

}
