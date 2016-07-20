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
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼なし）納付書 HokenryoNonyuTsuchishoBookNofushoNashiEditor
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class HokenryoNonyuTsuchishoBookNofushoNashiEditor implements IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverEditor {

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
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param 納入通知書期情報リスト 納入通知書期情報リスト
     * @param ページ ページ
     */
    protected HokenryoNonyuTsuchishoBookNofushoNashiEditor(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト, int ページ) {
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.納付書共通 = null == 仮算定納入通知書情報.get納付書共通() ? new NofuShoKyotsu() : 仮算定納入通知書情報.get納付書共通();
        this.通知書の連番 = 仮算定納入通知書情報.get連番();
        this.ページ = ページ;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource edit(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource source) {
        source.layoutBreakItem = 2;
        edit印字位置2(source);
        edit印字位置3(source);
        edit印字位置4(source);
        edit印字位置5(source);
        source.eRenban = RString.EMPTY;
        if (仮算定納入通知書情報.get編集後仮算定通知書共通情報() != null) {
            source.eHokensyaName = 仮算定納入通知書情報.get編集後仮算定通知書共通情報().get保険者名();
        }
        return source;
    }

    private void edit印字位置2(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(2);
        boolean is納入通知書期情報がある = is納入通知書期情報がある(納入通知書期情報);
        source.ryoshushoTitleNendo5 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.ryoshushoTitleKi5 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.ryoshushoTitleTsuki5 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.ryoshushoJusho5 = 納付書共通.get住所();
        source.ryoshushoKatagaki5 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName5 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.ryoshushoTsuchishoNo5 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo5 = 納付書共通.get通知書番号().getColumnValue();
        }
        source.ryoshushoHokenryoGaku5 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書納付額欄() : 星10;
        source.ryoshushoNokigen5 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.ryoshushoNofuIn5 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付印欄() : new RString("**");
        source.ryoshushoKozaCom5 = is納入通知書期情報がある ? 納入通知書期情報.get領収証書領収印欄() : RString.EMPTY;
        source.ryoshushoZuiji5 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofushoTitleNendo5 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofushoTitleKi5 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofushoTitleTsuki5 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofushoHihokenshaName5 = 納付書共通.get納付者氏名();
        source.nofushoHokenryoGaku5 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofushoNokigen5 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofushoNofuIn5 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofushoKozaCom5 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofushoZuiji5 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoTitleNendoBun5 = RString.EMPTY;
        edit印字位置2_1(source, 納入通知書期情報, is納入通知書期情報がある);

    }

    private void edit印字位置2_1(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofuzumishoTitleKi5 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki5 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofozumishoTitleNendo5 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofuzumishoOCR15 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(1) : 星19;
        source.nofuzumishoOCR25 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(2) : 星20;
        source.nofuzumishoOCR35 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT3) : 星12;
        source.nofuzumishoNofuGaku5 = is納入通知書期情報がある ? 納入通知書期情報.get納付書納付額欄() : 星10;
        source.nofuzumishoJusho5 = 納付書共通.get住所();
        source.nofuzumishoKatagaki5 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName5 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo5 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode5 = 納付書共通.get世帯コード().getColumnValue();
        }
        source.nofuzumishoNokigen5 = is納入通知書期情報がある ? 納入通知書期情報.get納期限表記() : 星11;
        source.nofuzumishoNofuIn5 = is納入通知書期情報がある ? 納入通知書期情報.get領収日付欄() : new RString("**");
        source.nofuzumishoKozaCom5 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofuzumishoZuiji5 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoshichosonName5 = 納付書共通.get納付書市町村名();
        source.pagerenban5 = getページ連番(1);
    }

    private void edit印字位置3(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(INT3);
        boolean is納入通知書期情報がある = is納入通知書期情報がある(納入通知書期情報);
        source.ryoshushoJusho2 = 納付書共通.get住所();
        source.ryoshushoKatagaki2 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName2 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.ryoshushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (is納入通知書期情報がある) {
            source.ryoshushoHokenryoGaku2 = 納入通知書期情報.get領収証書納付額欄();
            source.ryoshushoNokigen2 = 納入通知書期情報.get納期限表記();
            source.ryoshushoNofuIn2 = 納入通知書期情報.get領収日付印欄();
            source.ryoshushoKozaCom2 = 納入通知書期情報.get領収証書領収印欄();
            source.ryoshushoZuiji2 = 納入通知書期情報.get随時表記();
            source.nofushoTitleNendo2 = 納付書共通.get調定年度表記();
            source.nofushoTitleKi2 = 納入通知書期情報.get期表記();
            source.nofushoTitleTsuki2 = 納入通知書期情報.get月表記();
            source.ryoshushoTitleNendo2 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleKi2 = 納入通知書期情報.get期表記();
            source.ryoshushoTitleTsuki2 = 納入通知書期情報.get月表記();
            source.nofushoHokenryoGaku2 = 納入通知書期情報.get納付書納付額欄();
            source.nofushoNokigen2 = 納入通知書期情報.get納期限表記();
            source.nofushoNofuIn2 = 納入通知書期情報.get領収日付欄();
            source.nofushoKozaCom2 = 納入通知書期情報.get納付書領収印欄();
            source.nofushoZuiji2 = 納入通知書期情報.get随時表記();
            source.nofuzumishoTitleKi2 = 納入通知書期情報.get期表記();
            source.nofuzumishoTitleTsuki2 = 納入通知書期情報.get月表記();
        } else {
            source.ryoshushoHokenryoGaku2 = 星10;
            source.ryoshushoNokigen2 = 星11;
            source.ryoshushoNofuIn2 = new RString("**");
            source.ryoshushoKozaCom2 = RString.EMPTY;
            source.ryoshushoZuiji2 = RString.EMPTY;
            source.nofushoTitleNendo2 = 星5;
            source.nofushoTitleKi2 = new RString("**");
            source.nofushoTitleTsuki2 = new RString("**");
            source.ryoshushoTitleNendo2 = 星5;
            source.ryoshushoTitleKi2 = new RString("**");
            source.ryoshushoTitleTsuki2 = new RString("**");
            source.nofushoHokenryoGaku2 = 星10;
            source.nofushoNokigen2 = 星11;
            source.nofushoNofuIn2 = new RString("**");
            source.nofushoKozaCom2 = RString.EMPTY;
            source.nofushoZuiji2 = RString.EMPTY;
            source.nofuzumishoTitleKi2 = new RString("**");
            source.nofuzumishoTitleTsuki2 = new RString("**");
        }
        source.nofushoHihokenshaName2 = 納付書共通.get納付者氏名();
        source.nofuzumishoTitleNendoBun2 = RString.EMPTY;
        edit印字位置3_1(source, 納入通知書期情報, is納入通知書期情報がある);
    }

    private void edit印字位置3_1(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofuzumishoJusho2 = 納付書共通.get住所();
        source.nofuzumishoKatagaki2 = 納付書共通.get方書();
        source.nofuzumishoHihokenshaName2 = 納付書共通.get納付者氏名();
        source.nofozumishoTitleNendo2 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode2 = 納付書共通.get世帯コード().getColumnValue();
        }
        if (is納入通知書期情報がある) {
            source.nofuzumishoNokigen2 = 納入通知書期情報.get納期限表記();
            source.nofuzumishoNofuIn2 = 納入通知書期情報.get領収日付欄();
            source.nofuzumishoKozaCom2 = 納入通知書期情報.get納付書領収印欄();
            source.nofuzumishoZuiji2 = 納入通知書期情報.get随時表記();
            source.nofuzumishoOCR12 = null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(1);
            source.nofuzumishoOCR22 = null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(2);
            source.nofuzumishoOCR32 = null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(INT3);
            source.nofuzumishoNofuGaku2 = null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.get納付書納付額欄();
        } else {
            source.nofuzumishoNokigen2 = 星11;
            source.nofuzumishoNofuIn2 = new RString("**");
            source.nofuzumishoKozaCom2 = RString.EMPTY;
            source.nofuzumishoZuiji2 = RString.EMPTY;
            source.nofuzumishoOCR12 = 星19;
            source.nofuzumishoOCR22 = is納入通知書期情報がある ? 納入通知書期情報.getOcr().get(2) : 星20;
            source.nofuzumishoOCR32 = 星12;
            source.nofuzumishoNofuGaku2 = 星10;
        }
        source.nofuzumishoshichosonName2 = 納付書共通.get納付書市町村名();
        source.pagerenban6 = getページ連番(2);
    }

    private void edit印字位置4(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(INT4);
        boolean is納入通知書期情報がある = is納入通知書期情報がある(納入通知書期情報);
        source.ryoshushoJusho3 = 納付書共通.get住所();
        source.ryoshushoKatagaki3 = 納付書共通.get方書();
        source.ryoshushoHihokenshaName3 = 納付書共通.get納付者氏名();
        if (納付書共通.get通知書番号() != null) {
            source.ryoshushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (is納入通知書期情報がある) {
            source.ryoshushoTitleNendo3 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleKi3 = 納入通知書期情報.get期表記();
            source.ryoshushoTitleTsuki3 = 納入通知書期情報.get月表記();
            source.ryoshushoHokenryoGaku3 = 納入通知書期情報.get領収証書納付額欄();
            source.ryoshushoNokigen3 = 納入通知書期情報.get納期限表記();
            source.ryoshushoNofuIn3 = 納入通知書期情報.get領収日付印欄();
            source.ryoshushoKozaCom3 = 納入通知書期情報.get領収証書領収印欄();
            source.ryoshushoZuiji3 = 納入通知書期情報.get随時表記();
            source.nofushoTitleNendo3 = 納付書共通.get調定年度表記();
            source.nofushoTitleKi3 = 納入通知書期情報.get期表記();
            source.nofushoTitleTsuki3 = 納入通知書期情報.get月表記();
            source.nofushoHokenryoGaku3 = 納入通知書期情報.get納付書納付額欄();
            source.nofushoNokigen3 = 納入通知書期情報.get納期限表記();
            source.nofushoNofuIn3 = 納入通知書期情報.get領収日付欄();
            source.nofushoKozaCom3 = 納入通知書期情報.get納付書領収印欄();
            source.nofushoZuiji3 = 納入通知書期情報.get随時表記();
        } else {
            source.ryoshushoTitleNendo3 = 星5;
            source.ryoshushoTitleKi3 = new RString("**");
            source.ryoshushoTitleTsuki3 = new RString("**");
            source.ryoshushoHokenryoGaku3 = 星10;
            source.ryoshushoNokigen3 = 星11;
            source.ryoshushoNofuIn3 = new RString("**");
            source.ryoshushoKozaCom3 = RString.EMPTY;
            source.ryoshushoZuiji3 = RString.EMPTY;
            source.nofushoTitleNendo3 = 星5;
            source.nofushoTitleKi3 = new RString("**");
            source.nofushoTitleTsuki3 = new RString("**");
            source.nofushoHokenryoGaku3 = 星10;
            source.nofushoNokigen3 = 星11;
            source.nofushoNofuIn3 = new RString("**");
            source.nofushoKozaCom3 = RString.EMPTY;
            source.nofushoZuiji3 = RString.EMPTY;
        }
        source.nofushoHihokenshaName3 = 納付書共通.get納付者氏名();
        edit印字位置4_1(source, 納入通知書期情報, is納入通知書期情報がある);
    }

    private void edit印字位置4_1(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofuzumishoTitleNendoBun3 = RString.EMPTY;
        source.nofozumishoTitleNendo3 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofuzumishoTitleKi3 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        source.nofuzumishoTitleTsuki3 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofuzumishoOCR13 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(1) : 星19;
        source.nofuzumishoOCR23 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(2) : 星20;
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

    private void edit印字位置5(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource source) {
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
        source.nofushoKozaCom4 = is納入通知書期情報がある ? 納入通知書期情報.get納付書領収印欄() : RString.EMPTY;
        source.nofushoZuiji4 = is納入通知書期情報がある ? 納入通知書期情報.get随時表記() : RString.EMPTY;
        source.nofuzumishoTitleNendoBun4 = RString.EMPTY;
        source.nofuzumishoTitleKi4 = is納入通知書期情報がある ? 納入通知書期情報.get期表記() : new RString("**");
        edit印字位置5_1(source, 納入通知書期情報, is納入通知書期情報がある);
    }

    private void edit印字位置5_1(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報, boolean is納入通知書期情報がある) {
        source.nofozumishoTitleNendo4 = is納入通知書期情報がある ? 納付書共通.get調定年度表記() : 星5;
        source.nofuzumishoTitleTsuki4 = is納入通知書期情報がある ? 納入通知書期情報.get月表記() : new RString("**");
        source.nofuzumishoOCR14 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(1) : 星19;
        source.nofuzumishoOCR24 = is納入通知書期情報がある
                ? null == 納入通知書期情報.getOcr() ? RString.EMPTY : 納入通知書期情報.getOcr().get(2) : 星20;
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
        return !(null == 納入通知書期情報);
    }

}
