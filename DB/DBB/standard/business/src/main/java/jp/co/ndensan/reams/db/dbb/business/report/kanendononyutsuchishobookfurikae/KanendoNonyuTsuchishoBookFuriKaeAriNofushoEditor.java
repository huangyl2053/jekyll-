/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishobookfurikae;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeAriSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）納付書 NonyuTsuchishoBookFuriKaeAriCoverEditor
 *
 * @reamsid_L DBB-9110-160 wangjie2
 */
public class KanendoNonyuTsuchishoBookFuriKaeAriNofushoEditor implements IKanendoNonyuTsuchishoBookFuriKaeAriEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private final int ページ;
    private final RString 星_2 = new RString("**");
    private final RString 星_6 = new RString("******");
    private final RString 星_9 = new RString("*********");
    private final RString 星_10 = new RString("**********");
    private final RString 星_11 = new RString("***********");
    private final RString 星_12 = new RString("************");
    private final RString 星_19 = new RString("*******************");
    private final RString 星_20 = new RString("********************");

    /**
     * コンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param 納入通知書期情報リスト 納入通知書期情報リスト
     * @param ページ ページ
     */
    public KanendoNonyuTsuchishoBookFuriKaeAriNofushoEditor(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            int ページ) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.ページ = ページ;
    }

    @Override
    public KanendoNonyuTsuchishoBookFuriKaeAriSource edit(KanendoNonyuTsuchishoBookFuriKaeAriSource source) {
        source.layoutBreakItem = INT_2;
        edit印字位置2(source);
        edit印字位置3(source);
        edit印字位置4(source);
        edit印字位置5(source);
        return source;
    }

    private void edit印字位置5(KanendoNonyuTsuchishoBookFuriKaeAriSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報印字位置5 = get納入通知書期情報By印字位置(INT_5);
        NofuShoKyotsu 納付書共通 = 本算定納入通知書情報.get納付書共通();
        if (null == 納付書共通) {
            納付書共通 = new NofuShoKyotsu();
        }
        if (null == 納入通知書期情報印字位置5) {
            source.nofuzumishoTitleNendoBun4 = 星_9;
            source.nofuzumishoTitleKi4 = 星_2;
            source.nofuzumishoTitleTsuki4 = 星_2;
            source.nofozumishoTitleNendo4 = 星_6;
            source.ryoshushoTitleNendo4 = 星_6;
            source.nofushoTitleNendo4 = 星_6;
            source.ryoshushoTitleKi4 = 星_2;
            source.nofushoTitleKi4 = 星_2;
            source.ryoshushoTitleTsuki4 = 星_2;
            source.nofushoTitleTsuki4 = 星_2;
            source.nofuzumishoOCR14 = 星_19;
            source.nofuzumishoOCR24 = 星_20;
            source.nofuzumishoOCR34 = 星_12;
            source.nofuzumishoNokigen4 = 星_11;
            source.ryoshushoHokenryoGaku4 = 星_10;
            source.nofushoHokenryoGaku4 = 星_10;
            source.nofuzumishoNofuGaku4 = 星_10;
            source.ryoshushoNokigen4 = 星_11;
            source.nofushoNokigen4 = 星_11;
            source.ryoshushoNofuIn4 = 星_2;
            source.nofushoNofuIn4 = 星_2;
            source.nofuzumishoNofuIn4 = 星_2;
            source.ryoshushoKozaCom4 = RString.EMPTY;
            source.nofushoKozaCom4 = RString.EMPTY;
            source.nofuzumishoKozaCom4 = RString.EMPTY;
            source.ryoshushoZuiji4 = RString.EMPTY;
            source.nofushoZuiji4 = RString.EMPTY;
            source.nofuzumishoZuiji4 = RString.EMPTY;
        } else {
            source.nofuzumishoTitleNendoBun4 = 納付書共通.get賦課年度表記();
            source.nofuzumishoTitleKi4 = 納入通知書期情報印字位置5.get期表記();
            source.nofuzumishoTitleTsuki4 = 納入通知書期情報印字位置5.get月表記();
            source.nofozumishoTitleNendo4 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleNendo4 = 納付書共通.get調定年度表記();
            source.nofushoTitleNendo4 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleKi4 = 納入通知書期情報印字位置5.get期表記();
            source.nofushoTitleKi4 = 納入通知書期情報印字位置5.get期表記();
            source.ryoshushoTitleTsuki4 = 納入通知書期情報印字位置5.get月表記();
            source.nofushoTitleTsuki4 = 納入通知書期情報印字位置5.get月表記();
            source.nofuzumishoOCR14 = get印字文字列(INT_1, 納入通知書期情報印字位置5.getOcr());
            source.nofuzumishoOCR24 = get印字文字列(INT_2, 納入通知書期情報印字位置5.getOcr());
            source.nofuzumishoOCR34 = get印字文字列(INT_3, 納入通知書期情報印字位置5.getOcr());
            source.nofuzumishoNokigen4 = 納入通知書期情報印字位置5.get納期限表記();
            source.ryoshushoHokenryoGaku4 = 納入通知書期情報印字位置5.get領収証書納付額欄();
            source.nofushoHokenryoGaku4 = 納入通知書期情報印字位置5.get納付書納付額欄();
            source.nofuzumishoNofuGaku4 = 納入通知書期情報印字位置5.get納付書納付額欄();
            source.ryoshushoNokigen4 = 納入通知書期情報印字位置5.get納期限表記();
            source.nofushoNokigen4 = 納入通知書期情報印字位置5.get納期限表記();
            source.ryoshushoNofuIn4 = 納入通知書期情報印字位置5.get領収日付印欄();
            source.nofushoNofuIn4 = 納入通知書期情報印字位置5.get領収日付欄();
            source.nofuzumishoNofuIn4 = 納入通知書期情報印字位置5.get領収日付欄();
            source.ryoshushoKozaCom4 = 納入通知書期情報印字位置5.get領収証書領収印欄();
            source.nofushoKozaCom4 = 納入通知書期情報印字位置5.get納付書領収印欄();
            source.nofuzumishoKozaCom4 = 納入通知書期情報印字位置5.get納付書領収印欄();
            source.ryoshushoZuiji4 = 納入通知書期情報印字位置5.get随時表記();
            source.nofushoZuiji4 = 納入通知書期情報印字位置5.get随時表記();
            source.nofuzumishoZuiji4
                    = 納入通知書期情報印字位置5.get随時表記();
        }
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
            source.ryoshushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
        }
        source.ryoshushoJusho4 = 納付書共通.get住所();
        source.ryoshushoKatagaki4 = 納付書共通.get方書();
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode4 = 納付書共通.get世帯コード().getColumnValue();
        }
        source.ryoshushoHihokenshaName4 = 納付書共通.get納付者氏名();
        source.nofushoHihokenshaName4 = 納付書共通.get納付者氏名();
        source.nofuzumishoHihokenshaName4 = 納付書共通.get納付者氏名();
        source.nofuzumishoJusho4 = 納付書共通.get住所();
        source.nofuzumishoKatagaki4 = 納付書共通.get方書();
        source.nofuzumishoshichosonName4 = 納付書共通.get納付書市町村名();
        if (ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分())) {
            source.pagerenban4 = new RString(本算定納入通知書情報.get連番()).concat("-").concat(get連番(INT_5));
        } else {
            source.pagerenban4 = new RString("1").concat("-").concat(get連番(INT_5));
        }
        source.eRenban = RString.EMPTY;
        if (本算定納入通知書情報.get編集後本算定通知書共通情報() != null) {
            source.eHokensyaName = 本算定納入通知書情報.get編集後本算定通知書共通情報().get保険者名();
        }
    }

    private void edit印字位置4(KanendoNonyuTsuchishoBookFuriKaeAriSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報印字位置4 = get納入通知書期情報By印字位置(INT_4);
        NofuShoKyotsu 納付書共通 = 本算定納入通知書情報.get納付書共通();
        if (null == 納付書共通) {
            納付書共通 = new NofuShoKyotsu();
        }
        if (null == 納入通知書期情報印字位置4) {
            source.nofuzumishoTitleNendoBun3 = 星_9;
            source.nofuzumishoTitleKi3 = 星_2;
            source.nofuzumishoTitleTsuki3 = 星_2;
            source.nofozumishoTitleNendo3 = 星_6;
            source.ryoshushoTitleNendo3 = 星_6;
            source.nofushoTitleNendo3 = 星_6;
            source.ryoshushoTitleKi3 = 星_2;
            source.nofushoTitleKi3 = 星_2;
            source.ryoshushoTitleTsuki3 = 星_2;
            source.nofushoTitleTsuki3 = 星_2;
            source.nofuzumishoOCR13 = 星_19;
            source.nofuzumishoOCR23 = 星_20;
            source.nofuzumishoOCR33 = 星_12;
            source.nofuzumishoNokigen3 = 星_11;
            source.ryoshushoHokenryoGaku3 = 星_10;
            source.nofushoHokenryoGaku3 = 星_10;
            source.nofuzumishoNofuGaku3 = 星_10;
            source.ryoshushoNokigen3 = 星_11;
            source.nofushoNokigen3 = 星_11;
            source.ryoshushoNofuIn3 = 星_2;
            source.nofushoNofuIn3 = 星_2;
            source.nofuzumishoNofuIn3 = 星_2;
            source.ryoshushoKozaCom3 = RString.EMPTY;
            source.nofushoKozaCom3 = RString.EMPTY;
            source.nofuzumishoKozaCom3 = RString.EMPTY;
            source.ryoshushoZuiji3 = RString.EMPTY;
            source.nofushoZuiji3 = RString.EMPTY;
            source.nofuzumishoZuiji3 = RString.EMPTY;
        } else {
            source.nofuzumishoTitleNendoBun3 = 納付書共通.get賦課年度表記();
            source.nofuzumishoTitleKi3 = 納入通知書期情報印字位置4.get期表記();
            source.nofuzumishoTitleTsuki3 = 納入通知書期情報印字位置4.get月表記();
            source.nofozumishoTitleNendo3 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleNendo3 = 納付書共通.get調定年度表記();
            source.nofushoTitleNendo3 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleKi3 = 納入通知書期情報印字位置4.get期表記();
            source.nofushoTitleKi3 = 納入通知書期情報印字位置4.get期表記();
            source.ryoshushoTitleTsuki3 = 納入通知書期情報印字位置4.get月表記();
            source.nofushoTitleTsuki3 = 納入通知書期情報印字位置4.get月表記();
            source.nofuzumishoOCR13 = get印字文字列(INT_1, 納入通知書期情報印字位置4.getOcr());
            source.nofuzumishoOCR23 = get印字文字列(INT_2, 納入通知書期情報印字位置4.getOcr());
            source.nofuzumishoOCR33 = get印字文字列(INT_3, 納入通知書期情報印字位置4.getOcr());
            source.nofuzumishoNokigen3 = 納入通知書期情報印字位置4.get納期限表記();
            source.ryoshushoHokenryoGaku3 = 納入通知書期情報印字位置4.get領収証書納付額欄();
            source.nofushoHokenryoGaku3 = 納入通知書期情報印字位置4.get納付書納付額欄();
            source.nofuzumishoNofuGaku3 = 納入通知書期情報印字位置4.get納付書納付額欄();
            source.ryoshushoNokigen3 = 納入通知書期情報印字位置4.get納期限表記();
            source.nofushoNokigen3 = 納入通知書期情報印字位置4.get納期限表記();
            source.ryoshushoNofuIn3 = 納入通知書期情報印字位置4.get領収日付印欄();
            source.nofushoNofuIn3 = 納入通知書期情報印字位置4.get領収日付欄();
            source.nofuzumishoNofuIn3 = 納入通知書期情報印字位置4.get領収日付欄();
            source.ryoshushoKozaCom3 = 納入通知書期情報印字位置4.get領収証書領収印欄();
            source.nofushoKozaCom3 = 納入通知書期情報印字位置4.get納付書領収印欄();
            source.nofuzumishoKozaCom3 = 納入通知書期情報印字位置4.get納付書領収印欄();
            source.ryoshushoZuiji3 = 納入通知書期情報印字位置4.get随時表記();
            source.nofushoZuiji3 = 納入通知書期情報印字位置4.get随時表記();
            source.nofuzumishoZuiji3
                    = 納入通知書期情報印字位置4.get随時表記();
        }
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
            source.ryoshushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
        }
        source.ryoshushoJusho3 = 納付書共通.get住所();
        source.ryoshushoKatagaki3 = 納付書共通.get方書();
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode3 = 納付書共通.get世帯コード().getColumnValue();
        }
        source.ryoshushoHihokenshaName3 = 納付書共通.get納付者氏名();
        source.nofushoHihokenshaName3 = 納付書共通.get納付者氏名();
        source.nofuzumishoHihokenshaName3 = 納付書共通.get納付者氏名();
        source.nofuzumishoJusho3 = 納付書共通.get住所();
        source.nofuzumishoKatagaki3 = 納付書共通.get方書();
        source.nofuzumishoshichosonName3 = 納付書共通.get納付書市町村名();
        if (ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分())) {
            source.pagerenban3 = new RString(本算定納入通知書情報.get連番()).concat("-").concat(get連番(INT_4));
        } else {
            source.pagerenban3 = new RString("1").concat("-").concat(get連番(INT_4));
        }
    }

    private void edit印字位置3(KanendoNonyuTsuchishoBookFuriKaeAriSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報印字位置3 = get納入通知書期情報By印字位置(INT_3);
        NofuShoKyotsu 納付書共通 = 本算定納入通知書情報.get納付書共通();
        if (null == 納付書共通) {
            納付書共通 = new NofuShoKyotsu();
        }
        if (null == 納入通知書期情報印字位置3) {
            source.nofuzumishoTitleNendoBun2 = 星_9;
            source.nofuzumishoTitleKi2 = 星_2;
            source.nofuzumishoTitleTsuki2 = 星_2;
            source.nofozumishoTitleNendo2 = 星_6;
            source.ryoshushoTitleNendo2 = 星_6;
            source.nofushoTitleNendo2 = 星_6;
            source.ryoshushoTitleKi2 = 星_2;
            source.nofushoTitleKi2 = 星_2;
            source.ryoshushoTitleTsuki2 = 星_2;
            source.nofushoTitleTsuki2 = 星_2;
            source.nofuzumishoOCR12 = 星_19;
            source.nofuzumishoOCR22 = 星_20;
            source.nofuzumishoOCR32 = 星_12;
            source.nofuzumishoNokigen2 = 星_11;
            source.ryoshushoHokenryoGaku2 = 星_10;
            source.nofushoHokenryoGaku2 = 星_10;
            source.nofuzumishoNofuGaku2 = 星_10;
            source.ryoshushoNokigen2 = 星_11;
            source.nofushoNokigen2 = 星_11;
            source.ryoshushoNofuIn2 = 星_2;
            source.nofushoNofuIn2 = 星_2;
            source.nofuzumishoNofuIn2 = 星_2;
            source.ryoshushoKozaCom2 = RString.EMPTY;
            source.nofushoKozaCom2 = RString.EMPTY;
            source.nofuzumishoKozaCom2 = RString.EMPTY;
            source.ryoshushoZuiji2 = RString.EMPTY;
            source.nofushoZuiji2 = RString.EMPTY;
            source.nofuzumishoZuiji2 = RString.EMPTY;
        } else {
            source.nofuzumishoTitleNendoBun2 = 納付書共通.get賦課年度表記();
            source.nofuzumishoTitleKi2 = 納入通知書期情報印字位置3.get期表記();
            source.nofuzumishoTitleTsuki2 = 納入通知書期情報印字位置3.get月表記();
            source.nofozumishoTitleNendo2 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleNendo2 = 納付書共通.get調定年度表記();
            source.nofushoTitleNendo2 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleKi2 = 納入通知書期情報印字位置3.get期表記();
            source.nofushoTitleKi2 = 納入通知書期情報印字位置3.get期表記();
            source.ryoshushoTitleTsuki2 = 納入通知書期情報印字位置3.get月表記();
            source.nofushoTitleTsuki2 = 納入通知書期情報印字位置3.get月表記();
            source.nofuzumishoOCR12 = get印字文字列(INT_1, 納入通知書期情報印字位置3.getOcr());
            source.nofuzumishoOCR22 = get印字文字列(INT_2, 納入通知書期情報印字位置3.getOcr());
            source.nofuzumishoOCR32 = get印字文字列(INT_3, 納入通知書期情報印字位置3.getOcr());
            source.nofuzumishoNokigen2 = 納入通知書期情報印字位置3.get納期限表記();
            source.ryoshushoHokenryoGaku2 = 納入通知書期情報印字位置3.get領収証書納付額欄();
            source.nofushoHokenryoGaku2 = 納入通知書期情報印字位置3.get納付書納付額欄();
            source.nofuzumishoNofuGaku2 = 納入通知書期情報印字位置3.get納付書納付額欄();
            source.ryoshushoNokigen2 = 納入通知書期情報印字位置3.get納期限表記();
            source.nofushoNokigen2 = 納入通知書期情報印字位置3.get納期限表記();
            source.ryoshushoNofuIn2 = 納入通知書期情報印字位置3.get領収日付印欄();
            source.nofushoNofuIn2 = 納入通知書期情報印字位置3.get領収日付欄();
            source.nofuzumishoNofuIn2 = 納入通知書期情報印字位置3.get領収日付欄();
            source.ryoshushoKozaCom2 = 納入通知書期情報印字位置3.get領収証書領収印欄();
            source.nofushoKozaCom2 = 納入通知書期情報印字位置3.get納付書領収印欄();
            source.nofuzumishoKozaCom2 = 納入通知書期情報印字位置3.get納付書領収印欄();
            source.ryoshushoZuiji2 = 納入通知書期情報印字位置3.get随時表記();
            source.nofushoZuiji2 = 納入通知書期情報印字位置3.get随時表記();
            source.nofuzumishoZuiji2
                    = 納入通知書期情報印字位置3.get随時表記();
        }
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
            source.ryoshushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        }
        source.ryoshushoJusho2 = 納付書共通.get住所();
        source.ryoshushoKatagaki2 = 納付書共通.get方書();
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode2 = 納付書共通.get世帯コード().getColumnValue();
        }
        source.ryoshushoHihokenshaName2 = 納付書共通.get納付者氏名();
        source.nofushoHihokenshaName2 = 納付書共通.get納付者氏名();
        source.nofuzumishoHihokenshaName2 = 納付書共通.get納付者氏名();
        source.nofuzumishoJusho2 = 納付書共通.get住所();
        source.nofuzumishoKatagaki2 = 納付書共通.get方書();
        source.nofuzumishoshichosonName2 = 納付書共通.get納付書市町村名();
        if (ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分())) {
            source.pagerenban2 = new RString(本算定納入通知書情報.get連番()).concat("-").concat(get連番(INT_3));
        } else {
            source.pagerenban2 = new RString("1").concat("-").concat(get連番(INT_3));
        }
    }

    private void edit印字位置2(KanendoNonyuTsuchishoBookFuriKaeAriSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報印字位置2 = get納入通知書期情報By印字位置(INT_2);
        NofuShoKyotsu 納付書共通 = 本算定納入通知書情報.get納付書共通();
        if (null == 納付書共通) {
            納付書共通 = new NofuShoKyotsu();
        }
        if (null == 納入通知書期情報印字位置2) {
            source.nofuzumishoTitleNendoBun1 = 星_9;
            source.nofuzumishoTitleKi1 = 星_2;
            source.nofuzumishoTitleTsuki1 = 星_2;
            source.nofozumishoTitleNendo1 = 星_6;
            source.ryoshushoTitleNendo1 = 星_6;
            source.nofushoTitleNendo1 = 星_6;
            source.ryoshushoTitleKi1 = 星_2;
            source.nofushoTitleKi1 = 星_2;
            source.ryoshushoTitleTsuki1 = 星_2;
            source.nofushoTitleTsuki1 = 星_2;
            source.nofuzumishoOCR11 = 星_19;
            source.nofuzumishoOCR21 = 星_20;
            source.nofuzumishoOCR31 = 星_12;
            source.nofuzumishoNokigen1 = 星_11;
            source.ryoshushoHokenryoGaku1 = 星_10;
            source.nofushoHokenryoGaku1 = 星_10;
            source.nofuzumishoNofuGaku1 = 星_10;
            source.ryoshushoNokigen1 = 星_11;
            source.nofushoNokigen1 = 星_11;
            source.ryoshushoNofuIn1 = 星_2;
            source.nofushoNofuIn1 = 星_2;
            source.nofuzumishoNofuIn1 = 星_2;
            source.ryoshushoKozaCom1 = RString.EMPTY;
            source.nofushoKozaCom1 = RString.EMPTY;
            source.nofuzumishoKozaCom1 = RString.EMPTY;
            source.ryoshushoZuiji1 = RString.EMPTY;
            source.nofushoZuiji1 = RString.EMPTY;
            source.nofuzumishoZuiji1 = RString.EMPTY;
        } else {
            source.nofuzumishoTitleNendoBun1 = 納付書共通.get賦課年度表記();
            source.nofuzumishoTitleKi1 = 納入通知書期情報印字位置2.get期表記();
            source.nofuzumishoTitleTsuki1 = 納入通知書期情報印字位置2.get月表記();
            source.nofozumishoTitleNendo1 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleNendo1 = 納付書共通.get調定年度表記();
            source.nofushoTitleNendo1 = 納付書共通.get調定年度表記();
            source.ryoshushoTitleKi1 = 納入通知書期情報印字位置2.get期表記();
            source.nofushoTitleKi1 = 納入通知書期情報印字位置2.get期表記();
            source.ryoshushoTitleTsuki1 = 納入通知書期情報印字位置2.get月表記();
            source.nofushoTitleTsuki1 = 納入通知書期情報印字位置2.get月表記();
            source.nofuzumishoOCR11 = get印字文字列(INT_1, 納入通知書期情報印字位置2.getOcr());
            source.nofuzumishoOCR21 = get印字文字列(INT_2, 納入通知書期情報印字位置2.getOcr());
            source.nofuzumishoOCR31 = get印字文字列(INT_3, 納入通知書期情報印字位置2.getOcr());
            source.nofuzumishoNokigen1 = 納入通知書期情報印字位置2.get納期限表記();
            source.ryoshushoHokenryoGaku1 = 納入通知書期情報印字位置2.get領収証書納付額欄();
            source.nofushoHokenryoGaku1 = 納入通知書期情報印字位置2.get納付書納付額欄();
            source.nofuzumishoNofuGaku1 = 納入通知書期情報印字位置2.get納付書納付額欄();
            source.ryoshushoNokigen1 = 納入通知書期情報印字位置2.get納期限表記();
            source.nofushoNokigen1 = 納入通知書期情報印字位置2.get納期限表記();
            source.ryoshushoNofuIn1 = 納入通知書期情報印字位置2.get領収日付印欄();
            source.nofushoNofuIn1 = 納入通知書期情報印字位置2.get領収日付欄();
            source.nofuzumishoNofuIn1 = 納入通知書期情報印字位置2.get領収日付欄();
            source.ryoshushoKozaCom1 = 納入通知書期情報印字位置2.get領収証書領収印欄();
            source.nofushoKozaCom1 = 納入通知書期情報印字位置2.get納付書領収印欄();
            source.nofuzumishoKozaCom1 = 納入通知書期情報印字位置2.get納付書領収印欄();
            source.ryoshushoZuiji1 = 納入通知書期情報印字位置2.get随時表記();
            source.nofushoZuiji1 = 納入通知書期情報印字位置2.get随時表記();
            source.nofuzumishoZuiji1 = 納入通知書期情報印字位置2.get随時表記();
        }
        if (納付書共通.get通知書番号() != null) {
            source.nofuzumishoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
            source.ryoshushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
        }
        source.ryoshushoJusho1 = 納付書共通.get住所();
        source.ryoshushoKatagaki1 = 納付書共通.get方書();
        if (納付書共通.get世帯コード() != null) {
            source.nofuzumishoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
        }
        source.ryoshushoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.nofushoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.nofuzumishoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.nofuzumishoJusho1 = 納付書共通.get住所();
        source.nofuzumishoKatagaki1 = 納付書共通.get方書();
        source.nofuzumishoshichosonName1 = 納付書共通.get納付書市町村名();
        if (ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分())) {
            source.pagerenban1 = new RString(本算定納入通知書情報.get連番()).concat("-").concat(get連番(INT_2));
        } else {
            source.pagerenban1 = new RString("1").concat("-").concat(get連番(INT_2));
        }
    }

    private RString get連番(int 印字位置) {
        return new RString(ページ * INT_4 + 印字位置 - INT_1);
    }

    private RString get印字文字列(int 行目, Map<Integer, RString> ocr) {
        if (null == ocr) {
            return RString.EMPTY;
        }
        return ocr.get(行目);
    }

    private NonyuTsuchiShoKiJoho get納入通知書期情報By印字位置(int 印字位置) {
        if (納入通知書期情報リスト.size() >= 印字位置 - INT_1) {
            return 納入通知書期情報リスト.get(印字位置 - INT_2);
        }
        return null;
    }

}
