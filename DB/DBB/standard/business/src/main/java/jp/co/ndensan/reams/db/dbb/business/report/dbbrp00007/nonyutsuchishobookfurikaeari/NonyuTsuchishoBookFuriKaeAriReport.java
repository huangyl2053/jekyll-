/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishobookfurikaeari;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.SpecialIncomeInformation;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.IKingakuFormatter;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.KingakuFormatter;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.KingakuUnit;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.Sign;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ】のReportです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class NonyuTsuchishoBookFuriKaeAriReport extends Report<FuriKaeAriCoverToNofushoReportSource> {

    private final HonSanteiNonyuTsuchiShoJoho 通知書情報;
    private final NinshoshaSource ninshoshaSource;

    private static final RString 次期以降 = new RString("次期以降");
    private static final RString 円 = new RString("円");
    private static final RString 期_4 = new RString("4");
    private static final RString 期_5 = new RString("5");
    private static final RString 期_6 = new RString("6");
    private static final RString FORMAT_第X期 = new RString("第%s期"); //TODO
    private static final RString FORMAT_第XX期 = new RString("第%02d期");
    private static final RString 星6 = new RString("******");
    private static final RString 星2 = new RString("**");
    private static final RString 星10 = new RString("**********");
    private static final RString 星11 = new RString("***********");
    private static final RString 星12 = new RString("************");
    private static final RString 星19 = new RString("*******************");
    private static final RString 星20 = new RString("********************");
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;

    /**
     * フォームのコンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource 認証者雛形部品
     */
    public NonyuTsuchishoBookFuriKaeAriReport(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        this.通知書情報 = 本算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<FuriKaeAriCoverToNofushoReportSource> reportSourceWriter) {
        int 中期開始期 = 通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get当初出力_中期開始期();
        int 後期開始期 = 通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get当初出力_後期開始期();

        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 通知書情報.get納入通知書期情報リスト();
        List<NonyuTsuchiShoKiJoho> 前期リスト = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 中期リスト = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 後期リスト = new ArrayList<>();

        int 期 = 0;
        if (中期開始期 != 0 && 後期開始期 != 0) {
            for (NonyuTsuchiShoKiJoho joho : 納入通知書期情報リスト) {
                期 = joho.get期();
                if (期 < 中期開始期) {
                    前期リスト.add(joho);
                } else if (期 >= 中期開始期 && 期 < 後期開始期) {
                    中期リスト.add(joho);
                } else if (期 >= 後期開始期) {
                    後期リスト.add(joho);
                }
            }
        } else if (中期開始期 == 0 && 後期開始期 != 0) {
            for (NonyuTsuchiShoKiJoho joho : 納入通知書期情報リスト) {
                期 = joho.get期();
                if (期 < 後期開始期) {
                    前期リスト.add(joho);
                } else if (期 >= 後期開始期) {
                    後期リスト.add(joho);
                }
            }
        } else if (中期開始期 == 0 && 後期開始期 == 0) {
            for (NonyuTsuchiShoKiJoho joho : 納入通知書期情報リスト) {
                前期リスト.add(joho);
            }
        }

        List<NonyuTsuchishoBookFuriKaeAriItem> itemList = new ArrayList<>();
        NonyuTsuchishoBookFuriKaeAriItem item = edit口振依頼あり通知書();
        itemList.add(item);
        if (前期リスト.size() > 0) {
            edit納付書(前期リスト.get(0).getブック開始位置(), 前期リスト, itemList);
        }
        if (中期リスト.size() > 0) {
            edit納付書(中期リスト.get(0).getブック開始位置(), 中期リスト, itemList);
        }
        if (後期リスト.size() > 0) {
            edit納付書(後期リスト.get(0).getブック開始位置(), 後期リスト, itemList);
        }

        writeBy(reportSourceWriter, itemList);
    }

    private void writeBy(ReportSourceWriter<FuriKaeAriCoverToNofushoReportSource> reportSourceWriter, List<NonyuTsuchishoBookFuriKaeAriItem> itemList) {
        for (NonyuTsuchishoBookFuriKaeAriItem target : itemList) {
            INonyuTsuchishoBookFuriKaeAriEditor tsuchishoEditor = new FuriKaeAriTsuchishoEditor(target);
            INonyuTsuchishoBookFuriKaeAriEditor nofushoEditor = new FuriKaeAriNofushoEditor(target);
            INonyuTsuchishoBookFuriKaeAriBuilder builder = new NonyuTsuchishoBookFuriKaeAriBuilderImpl(tsuchishoEditor, nofushoEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void edit納付書(int ブック開始位置, List<NonyuTsuchiShoKiJoho> 期リスト, List<NonyuTsuchishoBookFuriKaeAriItem> itemList) { // 山分け

        List<NonyuTsuchiShoKiJoho> tmp期リスト = new ArrayList<>();
        tmp期リスト.addAll(期リスト);
        if (tmp期リスト == null || tmp期リスト.isEmpty()) {
            return;
        }

        NonyuTsuchiShoKiJoho joho1 = getNonyuTsuchiShoKiJoho();
        NonyuTsuchiShoKiJoho joho2 = getNonyuTsuchiShoKiJoho();
        NonyuTsuchiShoKiJoho joho3 = getNonyuTsuchiShoKiJoho();
        NonyuTsuchiShoKiJoho joho4 = getNonyuTsuchiShoKiJoho();

        int size = tmp期リスト.size();
        if (ブック開始位置 == INDEX_2) {
            if (size >= INDEX_1) {
                joho1 = tmp期リスト.get(0);
                期リスト.remove(joho1);
            }
            if (size >= INDEX_2) {
                joho2 = tmp期リスト.get(1);
                期リスト.remove(joho2);
            }
            if (size >= INDEX_3) {
                joho3 = tmp期リスト.get(2);
                期リスト.remove(joho3);
            }
            if (size >= INDEX_4) {
                joho4 = tmp期リスト.get(INDEX_3);
                期リスト.remove(joho4);
            }
        } else if (ブック開始位置 == INDEX_3) {
            if (size >= INDEX_1) {
                joho2 = tmp期リスト.get(0);
                期リスト.remove(joho2);
            }
            if (size >= INDEX_2) {
                joho3 = tmp期リスト.get(1);
                期リスト.remove(joho3);
            }
            if (size >= INDEX_3) {
                joho4 = tmp期リスト.get(2);
                期リスト.remove(joho4);
            }
        } else if (ブック開始位置 == INDEX_4) {
            if (size >= INDEX_1) {
                joho3 = tmp期リスト.get(0);
                期リスト.remove(joho3);
            }
            if (size >= INDEX_2) {
                joho4 = tmp期リスト.get(1);
                期リスト.remove(joho4);
            }
        } else if (ブック開始位置 == INDEX_5 && size >= 1) {
            joho4 = tmp期リスト.get(0);
            期リスト.remove(joho4);
        }

        NonyuTsuchishoBookFuriKaeAriItem item = new NonyuTsuchishoBookFuriKaeAriItem();
        set印字位置２(joho1, item);
        set印字位置３(joho2, item);
        set印字位置４(joho3, item);
        set印字位置５(joho4, item);
        item.setLayoutBreakItem(2);

        itemList.add(item);

        if (期リスト.size() > 0) {
            ブック開始位置 = 2;
            edit納付書(ブック開始位置, 期リスト, itemList);
        }
    }

    private void set印字位置２(NonyuTsuchiShoKiJoho joho1, NonyuTsuchishoBookFuriKaeAriItem item) {
        // TODO set2项目
        // 印字位置②
        RString nofuzumishoTitleNendoBun1 = RString.EMPTY;
        RString nofuzumishoTitleKi1 = joho1.get期表記();
        RString nofuzumishoTitleTsuki1 = joho1.get月表記();
        RString 調定年度表記 = 通知書情報.get納付書共通().get調定年度表記() == null || 通知書情報.get納付書共通().get調定年度表記().isEmpty() ? 星6 : 通知書情報.get納付書共通().get調定年度表記();
        RString nofozumishoTitleNendo1 = 調定年度表記;
        RString ryoshushoTitleNendo1 = 調定年度表記;
        RString ryoshushoTitleKi1 = joho1.get期表記();
        RString ryoshushoTitleTsuki1 = joho1.get月表記();
        RString nofushoTitleNendo1 = 調定年度表記;
        RString nofushoTitleKi1 = joho1.get期表記();
        RString nofushoTitleTsuki1 = joho1.get月表記();
        RString ryoshushoJusho1 = 通知書情報.get納付書共通().get住所();
        RString nofuzumishoOCR11 = joho1.getOcr().get(0);
        RString nofuzumishoTsuchishoNo1 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString ryoshushoKatagaki1 = 通知書情報.get納付書共通().get方書();
        RString nofuzumishoSetaiCode1 = 通知書情報.get納付書共通().get世帯コード().getColumnValue();
        RString nofuzumishoOCR21 = joho1.getOcr().get(1);
        RString ryoshushoHihokenshaName1 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofushoHihokenshaName1 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofuzumishoOCR31 = joho1.getOcr().get(2);
        RString nofuzumishoNokigen1 = joho1.get納期限表記();
        RString ryoshushoTsuchishoNo1 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString nofushoTsuchishoNo1 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString ryoshushoHokenryoGaku1 = joho1.get領収証書納付額欄();
        RString nofushoHokenryoGaku1 = joho1.get納付書納付額欄();
        RString nofuzumishoNofuGaku1 = joho1.get納付書納付額欄();
        RString ryoshushoNokigen1 = joho1.get納期限表記();
        RString nofushoNokigen1 = joho1.get納期限表記();
        RString nofuzumishoJusho1 = 通知書情報.get納付書共通().get住所();
        RString nofuzumishoKatagaki1 = 通知書情報.get納付書共通().get方書();
        RString ryoshushoNofuIn1 = joho1.get領収日付印欄();
        RString nofushoNofuIn1 = joho1.get領収日付欄();
        RString nofuzumishoNofuIn1 = joho1.get領収日付欄();
        RString ryoshushoKozaCom1 = joho1.get領収証書領収印欄();
        RString nofushoKozaCom1 = joho1.get納付書領収印欄();
        RString nofuzumishoHihokenshaName1 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofuzumishoKozaCom1 = joho1.get納付書領収印欄();
        RString ryoshushoZuiji1 = joho1.get随時表記();
        RString nofushoZuiji1 = joho1.get随時表記();
        RString nofuzumishoZuiji1 = joho1.get随時表記();
        RString nofuzumishoshichosonName1 = 通知書情報.get納付書共通().get納付書市町村名(); // TODO QA 納付書共通.納付済書市町村名
        RString pagerenban1 = RString.EMPTY; // TODO

        item.setNofuzumishoTitleNendoBun1(nofuzumishoTitleNendoBun1);
        item.setNofuzumishoTitleKi1(nofuzumishoTitleKi1);
        item.setNofuzumishoTitleTsuki1(nofuzumishoTitleTsuki1);
        item.setNofozumishoTitleNendo1(nofozumishoTitleNendo1);

        item.setRyoshushoTitleNendo1(ryoshushoTitleNendo1);
        item.setRyoshushoTitleKi1(ryoshushoTitleKi1);
        item.setRyoshushoTitleTsuki1(ryoshushoTitleTsuki1);
        item.setNofushoTitleNendo1(nofushoTitleNendo1);
        item.setNofushoTitleKi1(nofushoTitleKi1);
        item.setNofushoTitleTsuki1(nofushoTitleTsuki1);
        item.setRyoshushoJusho1(ryoshushoJusho1);

        item.setNofuzumishoTsuchishoNo1(nofuzumishoTsuchishoNo1);
        item.setNofuzumishoOCR11(nofuzumishoOCR11);
        item.setRyoshushoKatagaki1(ryoshushoKatagaki1);
        item.setNofuzumishoSetaiCode1(nofuzumishoSetaiCode1);
        item.setNofuzumishoOCR21(nofuzumishoOCR21);
        item.setRyoshushoHihokenshaName1(ryoshushoHihokenshaName1);
        item.setNofushoHihokenshaName1(nofushoHihokenshaName1);
        item.setNofuzumishoOCR31(nofuzumishoOCR31);
        item.setNofuzumishoNokigen1(nofuzumishoNokigen1);
        item.setRyoshushoTsuchishoNo1(ryoshushoTsuchishoNo1);
        item.setNofushoTsuchishoNo1(nofushoTsuchishoNo1);
        item.setRyoshushoHokenryoGaku1(ryoshushoHokenryoGaku1);
        item.setNofushoHokenryoGaku1(nofushoHokenryoGaku1);
        item.setNofuzumishoNofuGaku1(nofuzumishoNofuGaku1);
        item.setRyoshushoNokigen1(ryoshushoNokigen1);
        item.setNofushoNokigen1(nofushoNokigen1);
        item.setNofuzumishoJusho1(nofuzumishoJusho1);
        item.setNofuzumishoKatagaki1(nofuzumishoKatagaki1);
        item.setRyoshushoNofuIn1(ryoshushoNofuIn1);
        item.setNofushoNofuIn1(nofushoNofuIn1);
        item.setNofuzumishoNofuIn1(nofuzumishoNofuIn1);
        item.setRyoshushoKozaCom1(ryoshushoKozaCom1);
        item.setNofushoKozaCom1(nofushoKozaCom1);
        item.setNofuzumishoHihokenshaName1(nofuzumishoHihokenshaName1);
        item.setNofuzumishoKozaCom1(nofuzumishoKozaCom1);
        item.setRyoshushoZuiji1(ryoshushoZuiji1);
        item.setNofushoZuiji1(nofushoZuiji1);
        item.setNofuzumishoZuiji1(nofuzumishoZuiji1);
        item.setNofuzumishoshichosonName1(nofuzumishoshichosonName1);
        item.setNofusho_pagerenban1(pagerenban1);
    }

    private void set印字位置３(NonyuTsuchiShoKiJoho joho2, NonyuTsuchishoBookFuriKaeAriItem item) {

        RString 調定年度表記 = 通知書情報.get納付書共通().get調定年度表記() == null || 通知書情報.get納付書共通().get調定年度表記().isEmpty()
                ? 星6 : 通知書情報.get納付書共通().get調定年度表記();

        // 印字位置③
        RString nofozumishoTitleNendo2 = 調定年度表記;
        RString nofuzumishoTitleNendoBun2 = RString.EMPTY;
        RString nofuzumishoTitleKi2 = joho2.get期表記();
        RString nofuzumishoTitleTsuki2 = joho2.get月表記();
        RString ryoshushoTitleNendo2 = 調定年度表記;
        RString ryoshushoTitleKi2 = joho2.get期表記();
        RString ryoshushoTitleTsuki2 = joho2.get月表記();
        RString nofushoTitleNendo2 = 調定年度表記;
        RString nofushoTitleKi2 = joho2.get期表記();
        RString nofushoTitleTsuki2 = joho2.get月表記();
        RString ryoshushoJusho2 = 通知書情報.get納付書共通().get住所();
        RString nofuzumishoTsuchishoNo2 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString nofuzumishoOCR12 = joho2.getOcr().get(0);
        RString ryoshushoKatagaki2 = 通知書情報.get納付書共通().get方書();
        RString nofuzumishoSetaiCode2 = 通知書情報.get納付書共通().get世帯コード().getColumnValue();
        RString nofuzumishoOCR22 = joho2.getOcr().get(1);
        RString ryoshushoHihokenshaName2 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofushoHihokenshaName2 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofuzumishoNokigen2 = joho2.get納期限表記();
        RString nofuzumishoOCR32 = joho2.getOcr().get(2);
        RString ryoshushoTsuchishoNo2 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString nofushoTsuchishoNo2 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString ryoshushoHokenryoGaku2 = joho2.get領収証書納付額欄();
        RString nofushoHokenryoGaku2 = joho2.get納付書納付額欄();
        RString nofuzumishoNofuGaku2 = joho2.get納付書納付額欄();
        RString ryoshushoNokigen2 = joho2.get納期限表記();
        RString nofushoNokigen2 = joho2.get納期限表記();
        RString nofuzumishoJusho2 = 通知書情報.get納付書共通().get住所();
        RString nofuzumishoKatagaki2 = 通知書情報.get納付書共通().get方書();
        RString ryoshushoNofuIn2 = joho2.get領収日付印欄();
        RString nofushoNofuIn2 = joho2.get領収日付欄();
        RString nofuzumishoNofuIn2 = joho2.get領収日付欄();
        RString ryoshushoKozaCom2 = joho2.get領収証書領収印欄();
        RString nofushoKozaCom2 = joho2.get納付書領収印欄();
        RString nofuzumishoHihokenshaName2 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofuzumishoKozaCom2 = joho2.get納付書領収印欄();
        RString ryoshushoZuiji2 = joho2.get随時表記();
        RString nofushoZuiji2 = joho2.get随時表記();
        RString nofuzumishoZuiji2 = joho2.get随時表記();
        RString nofuzumishoshichosonName2 = 通知書情報.get納付書共通().get納付書市町村名(); // TODO QA 納付書共通.納付済書市町村名
        RString pagerenban2 = RString.EMPTY; // TODO

        item.setNofozumishoTitleNendo2(nofozumishoTitleNendo2);
        item.setNofuzumishoTitleNendoBun2(nofuzumishoTitleNendoBun2);
        item.setNofuzumishoTitleKi2(nofuzumishoTitleKi2);
        item.setNofuzumishoTitleTsuki2(nofuzumishoTitleTsuki2);
        item.setRyoshushoTitleNendo2(ryoshushoTitleNendo2);
        item.setRyoshushoTitleKi2(ryoshushoTitleKi2);
        item.setRyoshushoTitleTsuki2(ryoshushoTitleTsuki2);
        item.setNofushoTitleNendo2(nofushoTitleNendo2);
        item.setNofushoTitleKi2(nofushoTitleKi2);
        item.setNofushoTitleTsuki2(nofushoTitleTsuki2);
        item.setRyoshushoJusho2(ryoshushoJusho2);
        item.setNofuzumishoTsuchishoNo2(nofuzumishoTsuchishoNo2);
        item.setNofuzumishoOCR12(nofuzumishoOCR12);
        item.setRyoshushoKatagaki2(ryoshushoKatagaki2);
        item.setNofuzumishoSetaiCode2(nofuzumishoSetaiCode2);
        item.setNofuzumishoOCR22(nofuzumishoOCR22);
        item.setRyoshushoHihokenshaName2(ryoshushoHihokenshaName2);
        item.setNofushoHihokenshaName2(nofushoHihokenshaName2);
        item.setNofuzumishoNokigen2(nofuzumishoNokigen2);
        item.setNofuzumishoOCR32(nofuzumishoOCR32);
        item.setRyoshushoTsuchishoNo2(ryoshushoTsuchishoNo2);
        item.setNofushoTsuchishoNo2(nofushoTsuchishoNo2);
        item.setRyoshushoHokenryoGaku2(ryoshushoHokenryoGaku2);
        item.setNofushoHokenryoGaku2(nofushoHokenryoGaku2);
        item.setNofuzumishoNofuGaku2(nofuzumishoNofuGaku2);
        item.setRyoshushoNokigen2(ryoshushoNokigen2);
        item.setNofushoNokigen2(nofushoNokigen2);
        item.setNofuzumishoJusho2(nofuzumishoJusho2);
        item.setNofuzumishoKatagaki2(nofuzumishoKatagaki2);
        item.setRyoshushoNofuIn2(ryoshushoNofuIn2);
        item.setNofushoNofuIn2(nofushoNofuIn2);
        item.setNofuzumishoNofuIn2(nofuzumishoNofuIn2);
        item.setRyoshushoKozaCom2(ryoshushoKozaCom2);
        item.setNofushoKozaCom2(nofushoKozaCom2);
        item.setNofuzumishoHihokenshaName2(nofuzumishoHihokenshaName2);
        item.setNofuzumishoKozaCom2(nofuzumishoKozaCom2);
        item.setRyoshushoZuiji2(ryoshushoZuiji2);
        item.setNofushoZuiji2(nofushoZuiji2);
        item.setNofuzumishoZuiji2(nofuzumishoZuiji2);
        item.setNofuzumishoshichosonName2(nofuzumishoshichosonName2);
        item.setNofusho_pagerenban2(pagerenban2);
    }

    private void set印字位置４(NonyuTsuchiShoKiJoho joho3, NonyuTsuchishoBookFuriKaeAriItem item) {

        RString 調定年度表記 = 通知書情報.get納付書共通().get調定年度表記() == null || 通知書情報.get納付書共通().get調定年度表記().isEmpty()
                ? 星6 : 通知書情報.get納付書共通().get調定年度表記();

        RString nofozumishoTitleNendo3 = 調定年度表記;
        RString nofuzumishoTitleNendoBun3 = RString.EMPTY;
        RString nofuzumishoTitleKi3 = joho3.get期表記();
        RString nofuzumishoTitleTsuki3 = joho3.get月表記();
        RString ryoshushoTitleNendo3 = 調定年度表記;
        RString ryoshushoTitleKi3 = joho3.get期表記();
        RString ryoshushoTitleTsuki3 = joho3.get月表記();
        RString nofushoTitleNendo3 = 調定年度表記;
        RString nofushoTitleKi3 = joho3.get期表記();
        RString nofushoTitleTsuki3 = joho3.get月表記();
        RString ryoshushoJusho3 = 通知書情報.get納付書共通().get住所();
        RString nofuzumishoTsuchishoNo3 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString nofuzumishoOCR13 = joho3.getOcr().get(0);
        RString ryoshushoKatagaki3 = 通知書情報.get納付書共通().get方書();
        RString nofuzumishoSetaiCode3 = 通知書情報.get納付書共通().get世帯コード().getColumnValue();
        RString nofuzumishoOCR23 = joho3.getOcr().get(1);
        RString ryoshushoHihokenshaName3 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofushoHihokenshaName3 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofuzumishoNokigen3 = joho3.get納期限表記();
        RString nofuzumishoOCR33 = joho3.getOcr().get(2);
        RString ryoshushoTsuchishoNo3 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString nofushoTsuchishoNo3 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString ryoshushoHokenryoGaku3 = joho3.get領収証書納付額欄();
        RString nofushoHokenryoGaku3 = joho3.get納付書納付額欄();
        RString nofuzumishoNofuGaku3 = joho3.get納付書納付額欄();
        RString ryoshushoNokigen3 = joho3.get納期限表記();
        RString nofushoNokigen3 = joho3.get納期限表記();
        RString nofuzumishoJusho3 = 通知書情報.get納付書共通().get住所();
        RString nofuzumishoKatagaki3 = 通知書情報.get納付書共通().get方書();
        RString ryoshushoNofuIn3 = joho3.get領収日付印欄();
        RString nofushoNofuIn3 = joho3.get領収日付欄();
        RString nofuzumishoNofuIn3 = joho3.get領収日付欄();
        RString ryoshushoKozaCom3 = joho3.get領収証書領収印欄();
        RString nofushoKozaCom3 = joho3.get納付書領収印欄();
        RString nofuzumishoHihokenshaName3 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofuzumishoKozaCom3 = joho3.get納付書領収印欄();
        RString ryoshushoZuiji3 = joho3.get随時表記();
        RString nofushoZuiji3 = joho3.get随時表記();
        RString nofuzumishoZuiji3 = joho3.get随時表記();
        RString nofuzumishoshichosonName3 = 通知書情報.get納付書共通().get納付書市町村名(); // TODO QA 納付書共通.納付済書市町村名
        RString pagerenban3 = RString.EMPTY; // TODO

        item.setNofozumishoTitleNendo3(nofozumishoTitleNendo3);
        item.setNofuzumishoTitleNendoBun3(nofuzumishoTitleNendoBun3);
        item.setNofuzumishoTitleKi3(nofuzumishoTitleKi3);
        item.setNofuzumishoTitleTsuki3(nofuzumishoTitleTsuki3);
        item.setRyoshushoTitleNendo3(ryoshushoTitleNendo3);
        item.setRyoshushoTitleKi3(ryoshushoTitleKi3);
        item.setRyoshushoTitleTsuki3(ryoshushoTitleTsuki3);
        item.setNofushoTitleNendo3(nofushoTitleNendo3);
        item.setNofushoTitleKi3(nofushoTitleKi3);
        item.setNofushoTitleTsuki3(nofushoTitleTsuki3);
        item.setRyoshushoJusho3(ryoshushoJusho3);
        item.setNofuzumishoTsuchishoNo3(nofuzumishoTsuchishoNo3);
        item.setNofuzumishoOCR13(nofuzumishoOCR13);
        item.setRyoshushoKatagaki3(ryoshushoKatagaki3);
        item.setNofuzumishoSetaiCode3(nofuzumishoSetaiCode3);
        item.setNofuzumishoOCR23(nofuzumishoOCR23);
        item.setRyoshushoHihokenshaName3(ryoshushoHihokenshaName3);
        item.setNofushoHihokenshaName3(nofushoHihokenshaName3);
        item.setNofuzumishoNokigen3(nofuzumishoNokigen3);
        item.setNofuzumishoOCR33(nofuzumishoOCR33);
        item.setRyoshushoTsuchishoNo3(ryoshushoTsuchishoNo3);
        item.setNofushoTsuchishoNo3(nofushoTsuchishoNo3);
        item.setRyoshushoHokenryoGaku3(ryoshushoHokenryoGaku3);
        item.setNofushoHokenryoGaku3(nofushoHokenryoGaku3);
        item.setNofuzumishoNofuGaku3(nofuzumishoNofuGaku3);
        item.setRyoshushoNokigen3(ryoshushoNokigen3);
        item.setNofushoNokigen3(nofushoNokigen3);
        item.setNofuzumishoJusho3(nofuzumishoJusho3);
        item.setNofuzumishoKatagaki3(nofuzumishoKatagaki3);
        item.setRyoshushoNofuIn3(ryoshushoNofuIn3);
        item.setNofushoNofuIn3(nofushoNofuIn3);
        item.setNofuzumishoNofuIn3(nofuzumishoNofuIn3);
        item.setRyoshushoKozaCom3(ryoshushoKozaCom3);
        item.setNofushoKozaCom3(nofushoKozaCom3);
        item.setNofuzumishoHihokenshaName3(nofuzumishoHihokenshaName3);
        item.setNofuzumishoKozaCom3(nofuzumishoKozaCom3);
        item.setRyoshushoZuiji3(ryoshushoZuiji3);
        item.setNofushoZuiji3(nofushoZuiji3);
        item.setNofuzumishoZuiji3(nofuzumishoZuiji3);
        item.setNofuzumishoshichosonName3(nofuzumishoshichosonName3);
        item.setNofusho_pagerenban3(pagerenban3);

    }

    private void set印字位置５(NonyuTsuchiShoKiJoho joho4, NonyuTsuchishoBookFuriKaeAriItem item) {

        RString nofozumishoTitleNendo4 = 通知書情報.get納付書共通().get調定年度表記();
        RString nofuzumishoTitleNendoBun4 = RString.EMPTY;
        RString nofuzumishoTitleKi4 = joho4.get期表記();
        RString nofuzumishoTitleTsuki4 = joho4.get月表記();
        RString ryoshushoTitleNendo4 = 通知書情報.get納付書共通().get調定年度表記();
        RString ryoshushoTitleKi4 = joho4.get期表記();
        RString ryoshushoTitleTsuki4 = joho4.get月表記();
        RString nofushoTitleNendo4 = 通知書情報.get納付書共通().get調定年度表記();
        RString nofushoTitleKi4 = joho4.get期表記();
        RString nofushoTitleTsuki4 = joho4.get月表記();
        RString ryoshushoJusho4 = 通知書情報.get納付書共通().get住所();
        RString nofuzumishoTsuchishoNo4 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString nofuzumishoOCR14 = joho4.getOcr().get(0);
        RString ryoshushoKatagaki4 = 通知書情報.get納付書共通().get方書();
        RString nofuzumishoSetaiCode4 = 通知書情報.get納付書共通().get世帯コード().getColumnValue();
        RString nofuzumishoOCR24 = joho4.getOcr().get(1);
        RString ryoshushoHihokenshaName4 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofushoHihokenshaName4 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofuzumishoNokigen4 = joho4.get納期限表記();
        RString nofuzumishoOCR34 = joho4.getOcr().get(2);
        RString ryoshushoTsuchishoNo4 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString nofushoTsuchishoNo4 = 通知書情報.get納付書共通().get通知書番号().getColumnValue();
        RString ryoshushoHokenryoGaku4 = joho4.get領収証書納付額欄();
        RString nofushoHokenryoGaku4 = joho4.get納付書納付額欄();
        RString nofuzumishoNofuGaku4 = joho4.get納付書納付額欄();
        RString ryoshushoNokigen4 = joho4.get納期限表記();
        RString nofushoNokigen4 = joho4.get納期限表記();
        RString nofuzumishoJusho4 = 通知書情報.get納付書共通().get住所();
        RString nofuzumishoKatagaki4 = 通知書情報.get納付書共通().get方書();
        RString ryoshushoNofuIn4 = joho4.get領収日付印欄();
        RString nofushoNofuIn4 = joho4.get領収日付欄();
        RString nofuzumishoNofuIn4 = joho4.get領収日付欄();
        RString ryoshushoKozaCom4 = joho4.get領収証書領収印欄();
        RString nofushoKozaCom4 = joho4.get納付書領収印欄();
        RString nofuzumishoHihokenshaName4 = 通知書情報.get納付書共通().get納付者氏名();
        RString nofuzumishoKozaCom4 = joho4.get納付書領収印欄();
        RString ryoshushoZuiji4 = joho4.get随時表記();
        RString nofushoZuiji4 = joho4.get随時表記();
        RString nofuzumishoZuiji4 = joho4.get随時表記();
        RString nofuzumishoshichosonName4 = 通知書情報.get納付書共通().get納付書市町村名(); // TODO QA 納付書共通.納付済書市町村名
        RString pagerenban4 = RString.EMPTY; // TODO
        RString eRenban = RString.EMPTY;
        RString ePage = RString.EMPTY;
        RString eHokensyaName = 通知書情報.get編集後本算定通知書共通情報().get保険者名();

        item.setNofozumishoTitleNendo4(nofozumishoTitleNendo4);
        item.setNofuzumishoTitleNendoBun4(nofuzumishoTitleNendoBun4);
        item.setNofuzumishoTitleKi4(nofuzumishoTitleKi4);
        item.setNofuzumishoTitleTsuki4(nofuzumishoTitleTsuki4);
        item.setRyoshushoTitleNendo4(ryoshushoTitleNendo4);
        item.setRyoshushoTitleKi4(ryoshushoTitleKi4);
        item.setRyoshushoTitleTsuki4(ryoshushoTitleTsuki4);
        item.setNofushoTitleNendo4(nofushoTitleNendo4);
        item.setNofushoTitleKi4(nofushoTitleKi4);
        item.setNofushoTitleTsuki4(nofushoTitleTsuki4);
        item.setRyoshushoJusho4(ryoshushoJusho4);
        item.setNofuzumishoTsuchishoNo4(nofuzumishoTsuchishoNo4);
        item.setNofuzumishoOCR14(nofuzumishoOCR14);
        item.setRyoshushoKatagaki4(ryoshushoKatagaki4);
        item.setNofuzumishoSetaiCode4(nofuzumishoSetaiCode4);
        item.setNofuzumishoOCR24(nofuzumishoOCR24);
        item.setRyoshushoHihokenshaName4(ryoshushoHihokenshaName4);
        item.setNofushoHihokenshaName4(nofushoHihokenshaName4);
        item.setNofuzumishoNokigen4(nofuzumishoNokigen4);
        item.setNofuzumishoOCR34(nofuzumishoOCR34);
        item.setRyoshushoTsuchishoNo4(ryoshushoTsuchishoNo4);
        item.setNofushoTsuchishoNo4(nofushoTsuchishoNo4);
        item.setRyoshushoHokenryoGaku4(ryoshushoHokenryoGaku4);
        item.setNofushoHokenryoGaku4(nofushoHokenryoGaku4);
        item.setNofuzumishoNofuGaku4(nofuzumishoNofuGaku4);
        item.setRyoshushoNokigen4(ryoshushoNokigen4);
        item.setNofushoNokigen4(nofushoNokigen4);
        item.setNofuzumishoJusho4(nofuzumishoJusho4);
        item.setNofuzumishoKatagaki4(nofuzumishoKatagaki4);
        item.setRyoshushoNofuIn4(ryoshushoNofuIn4);
        item.setNofushoNofuIn4(nofushoNofuIn4);
        item.setNofuzumishoNofuIn4(nofuzumishoNofuIn4);
        item.setRyoshushoKozaCom4(ryoshushoKozaCom4);
        item.setNofushoKozaCom4(nofushoKozaCom4);
        item.setNofuzumishoHihokenshaName4(nofuzumishoHihokenshaName4);
        item.setNofuzumishoKozaCom4(nofuzumishoKozaCom4);
        item.setRyoshushoZuiji4(ryoshushoZuiji4);
        item.setNofushoZuiji4(nofushoZuiji4);
        item.setNofuzumishoZuiji4(nofuzumishoZuiji4);
        item.setERenban(eRenban);
        item.setEPage(ePage);
        item.setNofuzumishoshichosonName4(nofuzumishoshichosonName4);
        item.setNofusho_pagerenban4(pagerenban4);
        item.setEHokensyaName(eHokensyaName);
    }

    private NonyuTsuchiShoKiJoho getNonyuTsuchiShoKiJoho() {

        // 納付書共通.調定年度表記 QA
        int 銀振印字位置 = 0;
        int コンビニ連帳印字位置 = 0;
        int コンビニカット印字位置 = 0;
        int ブック開始位置 = 0;
        int 期 = 0;
        Tsuki 月 = Tsuki._10月;
        RString 期表記 = 星2;
        RString 月表記 = 星2;
        RString 随時表記 = RString.EMPTY;
        RString 科目名称 = RString.EMPTY;
        RDate 納期開始日 = RDate.MAX;
        RString 納期開始日表記 = RString.EMPTY;
        RDate 納期終了日 = RDate.MAX;
        RString 納期終了日表記 = RString.EMPTY;
        RDate 納期限 = RDate.MAX;
        RString 納期限表記 = 星11;
        Decimal 納付額 = new Decimal(0);
        RString 納付額表記 = RString.EMPTY;
        Decimal 調定額 = new Decimal(0);
        RString 調定額表記 = RString.EMPTY;
        Decimal 収入額 = new Decimal(0);
        RString 収入額表記 = RString.EMPTY;
        Decimal 差額 = new Decimal(0);
        RString 差額表記 = RString.EMPTY;
        RString 収納機関番号表示用 = RString.EMPTY;
        RString 納付番号 = RString.EMPTY;
        RString 確認番号 = RString.EMPTY;
        RString 納付区分 = RString.EMPTY;

        RString ocrId = RString.EMPTY;
        Map<Integer, RString> ocr = new HashMap<>();
        ocr.put(0, 星19);
        ocr.put(0, 星20);
        ocr.put(0, 星12);
        RString バーコード情報 = RString.EMPTY;
        RString バーコード情報上段 = RString.EMPTY;
        RString バーコード情報下段 = RString.EMPTY;
        RDate コンビニ支払期限 = RDate.MAX;
        RString 領収証書納付額欄 = 星10;
        RString 納付書納付額欄 = 星10;
        RString 領収証書領収印欄 = RString.EMPTY;
        RString 納付書領収印欄 = RString.EMPTY;
        RString 領収日付印欄 = 星2;
        RString 領収日付欄 = 星2;
        RString 領収書日付欄期月 = RString.EMPTY;

        NonyuTsuchiShoKiJoho nonyuTsuchiShoKiJoho = new NonyuTsuchiShoKiJoho();
        nonyuTsuchiShoKiJoho.set銀振印字位置(銀振印字位置);
        nonyuTsuchiShoKiJoho.setコンビニ連帳印字位置(コンビニ連帳印字位置);
        nonyuTsuchiShoKiJoho.setコンビニカット印字位置(コンビニカット印字位置);
        nonyuTsuchiShoKiJoho.setブック開始位置(ブック開始位置);
        nonyuTsuchiShoKiJoho.set期(期);
        nonyuTsuchiShoKiJoho.set月(月);
        nonyuTsuchiShoKiJoho.set期表記(期表記);
        nonyuTsuchiShoKiJoho.set月表記(月表記);
        nonyuTsuchiShoKiJoho.set随時表記(随時表記);
        nonyuTsuchiShoKiJoho.set科目名称(科目名称);
        nonyuTsuchiShoKiJoho.set納期開始日(納期開始日);
        nonyuTsuchiShoKiJoho.set納期開始日表記(納期開始日表記);
        nonyuTsuchiShoKiJoho.set納期終了日(納期終了日);
        nonyuTsuchiShoKiJoho.set納期終了日表記(納期終了日表記);
        nonyuTsuchiShoKiJoho.set納期限(納期限);
        nonyuTsuchiShoKiJoho.set納期限表記(納期限表記);
        nonyuTsuchiShoKiJoho.set納付額(納付額);
        nonyuTsuchiShoKiJoho.set納付額表記(納付額表記);
        nonyuTsuchiShoKiJoho.set調定額(調定額);
        nonyuTsuchiShoKiJoho.set調定額表記(調定額表記);
        nonyuTsuchiShoKiJoho.set収入額(収入額);
        nonyuTsuchiShoKiJoho.set収入額表記(収入額表記);
        nonyuTsuchiShoKiJoho.set差額(差額);
        nonyuTsuchiShoKiJoho.set差額表記(差額表記);
        nonyuTsuchiShoKiJoho.set収納機関番号表示用(収納機関番号表示用);
        nonyuTsuchiShoKiJoho.set納付番号(納付番号);
        nonyuTsuchiShoKiJoho.set確認番号(確認番号);
        nonyuTsuchiShoKiJoho.set納付区分(納付区分);
        nonyuTsuchiShoKiJoho.setOcrid(ocrId);
        nonyuTsuchiShoKiJoho.setOcr(ocr);
        nonyuTsuchiShoKiJoho.setバーコード情報(バーコード情報);
        nonyuTsuchiShoKiJoho.setバーコード情報上段(バーコード情報上段);
        nonyuTsuchiShoKiJoho.setバーコード情報下段(バーコード情報下段);
        nonyuTsuchiShoKiJoho.setコンビニ支払期限(コンビニ支払期限);
        nonyuTsuchiShoKiJoho.set領収証書納付額欄(領収証書納付額欄);
        nonyuTsuchiShoKiJoho.set納付書納付額欄(納付書納付額欄);
        nonyuTsuchiShoKiJoho.set領収証書領収印欄(領収証書領収印欄);
        nonyuTsuchiShoKiJoho.set納付書領収印欄(納付書領収印欄);
        nonyuTsuchiShoKiJoho.set領収日付印欄(領収日付印欄);
        nonyuTsuchiShoKiJoho.set領収日付欄(領収日付欄);
        nonyuTsuchiShoKiJoho.set領収書日付欄期月(領収書日付欄期月);

        return nonyuTsuchiShoKiJoho;
    }

    private NonyuTsuchiShoKiJoho getNonyuTsuchiShoKiJoho_空() {

        // 納付書共通.調定年度表記 QA
        int 銀振印字位置 = 0;
        int コンビニ連帳印字位置 = 0;
        int コンビニカット印字位置 = 0;
        int ブック開始位置 = 0;
        int 期 = 0;
        Tsuki 月 = Tsuki._10月;
        RString 期表記 = RString.EMPTY;
        RString 月表記 = RString.EMPTY;
        RString 随時表記 = RString.EMPTY;
        RString 科目名称 = RString.EMPTY;
        RDate 納期開始日 = RDate.MAX;
        RString 納期開始日表記 = RString.EMPTY;
        RDate 納期終了日 = RDate.MAX;
        RString 納期終了日表記 = RString.EMPTY;
        RDate 納期限 = RDate.MAX;
        RString 納期限表記 = RString.EMPTY;
        Decimal 納付額 = new Decimal(0);
        RString 納付額表記 = RString.EMPTY;
        Decimal 調定額 = new Decimal(0);
        RString 調定額表記 = RString.EMPTY;
        Decimal 収入額 = new Decimal(0);
        RString 収入額表記 = RString.EMPTY;
        Decimal 差額 = new Decimal(0);
        RString 差額表記 = RString.EMPTY;
        RString 収納機関番号表示用 = RString.EMPTY;
        RString 納付番号 = RString.EMPTY;
        RString 確認番号 = RString.EMPTY;
        RString 納付区分 = RString.EMPTY;

        RString ocrId = RString.EMPTY;
        Map<Integer, RString> ocr = new HashMap<>();
        RString バーコード情報 = RString.EMPTY;
        RString バーコード情報上段 = RString.EMPTY;
        RString バーコード情報下段 = RString.EMPTY;
        RDate コンビニ支払期限 = RDate.MAX;
        RString 領収証書納付額欄 = RString.EMPTY;
        RString 納付書納付額欄 = RString.EMPTY;
        RString 領収証書領収印欄 = RString.EMPTY;
        RString 納付書領収印欄 = RString.EMPTY;
        RString 領収日付印欄 = RString.EMPTY;
        RString 領収日付欄 = RString.EMPTY;
        RString 領収書日付欄期月 = RString.EMPTY;

        NonyuTsuchiShoKiJoho nonyuTsuchiShoKiJoho = new NonyuTsuchiShoKiJoho();
        nonyuTsuchiShoKiJoho.set銀振印字位置(銀振印字位置);
        nonyuTsuchiShoKiJoho.setコンビニ連帳印字位置(コンビニ連帳印字位置);
        nonyuTsuchiShoKiJoho.setコンビニカット印字位置(コンビニカット印字位置);
        nonyuTsuchiShoKiJoho.setブック開始位置(ブック開始位置);
        nonyuTsuchiShoKiJoho.set期(期);
        nonyuTsuchiShoKiJoho.set月(月);
        nonyuTsuchiShoKiJoho.set期表記(期表記);
        nonyuTsuchiShoKiJoho.set月表記(月表記);
        nonyuTsuchiShoKiJoho.set随時表記(随時表記);
        nonyuTsuchiShoKiJoho.set科目名称(科目名称);
        nonyuTsuchiShoKiJoho.set納期開始日(納期開始日);
        nonyuTsuchiShoKiJoho.set納期開始日表記(納期開始日表記);
        nonyuTsuchiShoKiJoho.set納期終了日(納期終了日);
        nonyuTsuchiShoKiJoho.set納期終了日表記(納期終了日表記);
        nonyuTsuchiShoKiJoho.set納期限(納期限);
        nonyuTsuchiShoKiJoho.set納期限表記(納期限表記);
        nonyuTsuchiShoKiJoho.set納付額(納付額);
        nonyuTsuchiShoKiJoho.set納付額表記(納付額表記);
        nonyuTsuchiShoKiJoho.set調定額(調定額);
        nonyuTsuchiShoKiJoho.set調定額表記(調定額表記);
        nonyuTsuchiShoKiJoho.set収入額(収入額);
        nonyuTsuchiShoKiJoho.set収入額表記(収入額表記);
        nonyuTsuchiShoKiJoho.set差額(差額);
        nonyuTsuchiShoKiJoho.set差額表記(差額表記);
        nonyuTsuchiShoKiJoho.set収納機関番号表示用(収納機関番号表示用);
        nonyuTsuchiShoKiJoho.set納付番号(納付番号);
        nonyuTsuchiShoKiJoho.set確認番号(確認番号);
        nonyuTsuchiShoKiJoho.set納付区分(納付区分);
        nonyuTsuchiShoKiJoho.setOcrid(ocrId);
        nonyuTsuchiShoKiJoho.setOcr(ocr);
        nonyuTsuchiShoKiJoho.setバーコード情報(バーコード情報);
        nonyuTsuchiShoKiJoho.setバーコード情報上段(バーコード情報上段);
        nonyuTsuchiShoKiJoho.setバーコード情報下段(バーコード情報下段);
        nonyuTsuchiShoKiJoho.setコンビニ支払期限(コンビニ支払期限);
        nonyuTsuchiShoKiJoho.set領収証書納付額欄(領収証書納付額欄);
        nonyuTsuchiShoKiJoho.set納付書納付額欄(納付書納付額欄);
        nonyuTsuchiShoKiJoho.set領収証書領収印欄(領収証書領収印欄);
        nonyuTsuchiShoKiJoho.set納付書領収印欄(納付書領収印欄);
        nonyuTsuchiShoKiJoho.set領収日付印欄(領収日付印欄);
        nonyuTsuchiShoKiJoho.set領収日付欄(領収日付欄);
        nonyuTsuchiShoKiJoho.set領収書日付欄期月(領収書日付欄期月);

        return nonyuTsuchiShoKiJoho;
    }

    private NonyuTsuchishoBookFuriKaeAriItem edit口振依頼あり通知書() {
        RString titleNendo = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get調定年度_年度なし());
        RString titleNendoBun = RString.EMPTY;
        RString hyojicodeName1 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名１();
        RString hyojicodeName2 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名２();
        RString hyojicodeName3 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名３();
        RString hyojicode1 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード１();
        RString hyojicode2 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名２();
        RString hyojicode3 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名３();
        RString tsuchishoNo = 通知書情報.get編集後本算定通知書共通情報().get通知書番号().getColumnValue();
        RString setaiCode;
        try {
            setaiCode = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get世帯コード().getColumnValue();
        } catch (Exception e) {
            setaiCode = RString.EMPTY;
        }

        RString kmsNendo = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get調定年度_年度なし());
        RString kmsTsuchishoNo;
        try {
            kmsTsuchishoNo = 通知書情報.get編集後本算定通知書共通情報().get通知書番号().getColumnValue();
        } catch (Exception e) {
            kmsTsuchishoNo = RString.EMPTY;
        }

        RString kmsKaishiKi = RString.EMPTY;
        try {
            kmsKaishiKi = 通知書情報.get編集後本算定通知書共通情報().get更正後().get期間_自();
        } catch (Exception e) {
            kmsKaishiKi = RString.EMPTY;
        }
        RString kmsShuryoKi;
        try {
            kmsShuryoKi = 通知書情報.get編集後本算定通知書共通情報().get更正後().get期間_至();
        } catch (Exception e) {
            kmsShuryoKi = RString.EMPTY;
        }
        RString kmsShotokuDankai;
        try {
            kmsShotokuDankai = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get更正後().get保険料段階());
        } catch (Exception e) {
            kmsShotokuDankai = RString.EMPTY;
        }

        IKingakuFormatter 保険料率formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get保険料率());
        RString kaisanHokenryoRitsu = new RString(保険料率formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        IKingakuFormatter 減免前保険料_年額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get減免前保険料_年額());
        RString kmsCalHokenryoGaku = new RString(減免前保険料_年額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
        RString kmsTsukiSu = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get更正後().get月数_ケ月());

        IKingakuFormatter 減免額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get減免額());
        RString kmsGenmenGaku = new RString(減免額formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        IKingakuFormatter 特別徴収額合計formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get特別徴収額合計());
        RString kmsTokuchoGokeiGaku = new RString(特別徴収額合計formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        IKingakuFormatter 普通徴収額合計formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get普通徴収額合計());
        RString kmsFuchoGokeiGaku = new RString(普通徴収額合計formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        RString kmsNofuZumiGaku = RString.EMPTY;
        RString kmsKongoNofuGaku = RString.EMPTY;
        if (通知書情報.get本算定納入通知書制御情報() != null
                && 通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get納付額算出方法() != null
                && NofugakuSanshutsuHoho.収入額をもとに算出.getコード().equals(通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get納付額算出方法().getコード())) {
            IKingakuFormatter 普徴納付済額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get普徴納付済額_未到来期含む());
            IKingakuFormatter 普徴今後納付すべき額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get普徴今後納付すべき額_調定元に());
            kmsNofuZumiGaku = new RString(普徴納付済額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            kmsKongoNofuGaku = new RString(普徴今後納付すべき額formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        } else if (通知書情報.get本算定納入通知書制御情報() != null
                && 通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get納付額算出方法() != null
                && NofugakuSanshutsuHoho.調定額をもとに算出.getコード().equals(通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get納付額算出方法().getコード())) {
            IKingakuFormatter 普徴既に納付すべき額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get普徴既に納付すべき額());
            IKingakuFormatter 普徴今後納付すべき額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get普徴今後納付すべき額_収入元に());
            kmsNofuZumiGaku = new RString(普徴既に納付すべき額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            kmsKongoNofuGaku = new RString(普徴今後納付すべき額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
        }

        RString keisanmeisaishoNendo2 = 通知書情報.get編集後本算定通知書共通情報().get賦課年度_年度なし();
        IKingakuFormatter 確定保険料formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get確定保険料_年額());
        RString kmsHokenryoGokeiGaku = new RString(確定保険料formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        RString nbmsNendo = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get調定年度_年度なし());
        RString nbmsNendoBun = RString.EMPTY;
        RString nbmsTsuchishoNo = 通知書情報.get編集後本算定通知書共通情報().get通知書番号().getColumnValue();
        RString kozaIraishoLeftShikibetsuCode = 通知書情報.get編集後本算定通知書共通情報().get識別コード().getColumnValue();
        RString kozaIraishoRightShikibetsuCode = 通知書情報.get編集後本算定通知書共通情報().get識別コード().getColumnValue();
        RString hokenshaName = 通知書情報.get編集後本算定通知書共通情報().get保険者名();

        NonyuTsuchishoBookFuriKaeAriItem item = new NonyuTsuchishoBookFuriKaeAriItem();
        set計算明細書期１To１０(item);
        set納期別明細書特徴納付済額１To３(item);
        set編集後口座(item);
        set編集後個人(item);
        item.setLayoutBreakItem(1);
        item.setKmsNendo(kmsNendo);
        item.setKmsNendoBun(RString.EMPTY);
        item.setTitleNendo(titleNendo);
        item.setTitleNendoBun(titleNendoBun);
        item.setHyojicodeName1(hyojicodeName1);
        item.setHyojicodeName2(hyojicodeName2);
        item.setHyojicodeName3(hyojicodeName3);
        item.setHyojicode1(hyojicode1);
        item.setHyojicode2(hyojicode2);
        item.setHyojicode3(hyojicode3);
        item.setKmsTsuchishoNo(kmsTsuchishoNo);
        item.setTsuchishoNo(tsuchishoNo);
        item.setSetaiCode(setaiCode);
        item.setKmsKaishiKi(kmsKaishiKi);
        item.setKmsTsukiSu(kmsTsukiSu);
        item.setKaisanMeisaishoShuryoKi(kmsShuryoKi);
        item.setKmsShotokuDankai(kmsShotokuDankai);
        item.setKaisanHokenryoRitsu(kaisanHokenryoRitsu);
        item.setKmsCalHokenryoGaku(kmsCalHokenryoGaku);
        item.setKmsGenmenGaku(kmsGenmenGaku);
        item.setKmsTokuchoGokeiGaku(kmsTokuchoGokeiGaku);
        item.setKaisanMeisaishoFuchoGokeiGaku(kmsFuchoGokeiGaku);
        item.setKaisanMeisaishoNofuZumiGaku(kmsNofuZumiGaku);
        item.setKmsKongoNofuGaku(kmsKongoNofuGaku);
        item.setYen2(円);
        item.setYen3(円);
        item.setYen4(円);
        item.setKmsKiTitle2(RString.EMPTY);
        item.setGekihenTitle(RString.EMPTY);
        item.setKmsKibetsuNofuGaku2(RString.EMPTY);
        item.setKmsKiTitle4(RString.EMPTY);
        item.setGekihenMongon(RString.EMPTY);
        item.setKmsKibetsuNofuGaku4(RString.EMPTY);
        item.setKeisanmeisaishoNendo2(keisanmeisaishoNendo2);
        item.setKmsHokenryoGokeiGaku(kmsHokenryoGokeiGaku);
        item.setNbmsNendo(nbmsNendo);
        item.setNbmsNendoBun(nbmsNendoBun);
        item.setNbmsTsuchishoNo(nbmsTsuchishoNo);
        item.setKozaIraishoLeftShikibetsuCode(kozaIraishoLeftShikibetsuCode);
        item.setKozaIraishoRightShikibetsuCode(kozaIraishoRightShikibetsuCode);
        item.setHokenshaName(hokenshaName);

        set連番(item);
        setCompNinshosha(item);
        setCompSofubutsuAtesaki(item);
        return item;
    }

    private void set連番(NonyuTsuchishoBookFuriKaeAriItem item) {
        RString pagerenban1;
        if (ShoriKubun.バッチ.getコード().equals(通知書情報.get処理区分().getコード())) {
            pagerenban1 = RString.EMPTY; // TODO 連番　＋　"-1"
        } else {
            pagerenban1 = new RString("1-1");
        }

        RString pagerenban2;
        if (ShoriKubun.バッチ.getコード().equals(通知書情報.get処理区分().getコード())) {
            pagerenban2 = RString.EMPTY; // TODO 連番　＋　"-2"
        } else {
            pagerenban2 = new RString("1-2");
        }

        RString pagerenban3;
        if (ShoriKubun.バッチ.getコード().equals(通知書情報.get処理区分().getコード())) {
            pagerenban3 = RString.EMPTY; // TODO 連番　＋　"-3"
        } else {
            pagerenban3 = new RString("1-3");
        }

        RString pagerenban4;
        if (ShoriKubun.バッチ.getコード().equals(通知書情報.get処理区分().getコード())) {
            pagerenban4 = RString.EMPTY; // TODO 連番　＋　"-4"
        } else {
            pagerenban4 = new RString("1-4");
        }

        RString renban = RString.EMPTY; // TODO 通知書番号単位に、1から順番で採番する？
        item.setRenban(renban);

        item.setTsuchisho_pagerenban1(pagerenban1);
        item.setTsuchisho_pagerenban2(pagerenban2);
        item.setTsuchisho_pagerenban3(pagerenban3);
        item.setTsuchisho_pagerenban4(pagerenban4);
    }

    private void set編集後口座(NonyuTsuchishoBookFuriKaeAriItem item) {
        RString bankCode;
        try {
            bankCode = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get金融機関コードCombinedWith支店コード();
        } catch (Exception e) {
            bankCode = RString.EMPTY;
        }
        RString kozaShurui;
        try {
            kozaShurui = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get口座種別略称();
        } catch (Exception e) {
            kozaShurui = RString.EMPTY;
        }
        RString kozaNo;
        try {
            kozaNo = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get口座番号Or通帳記号番号();
        } catch (Exception e) {
            kozaNo = RString.EMPTY;
        }
        RString bankName;
        try {
            bankName = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get金融機関名CombinedWith支店名();
        } catch (Exception e) {
            bankName = RString.EMPTY;
        }
        RString kozaMeiginin;
        try {
            kozaMeiginin = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get口座名義人漢字優先(); // TODO QA get口座名義人()
        } catch (Exception e) {
            kozaMeiginin = RString.EMPTY;
        }

        item.setBankCode(bankCode);
        item.setKozaShurui(kozaShurui);
        item.setKozaNo(kozaNo);
        item.setBankName(bankName);
        item.setKozaMeiginin(kozaMeiginin);
    }

    private void set編集後個人(NonyuTsuchishoBookFuriKaeAriItem item) {
        RString kozaIraishoLeftJusho = RString.EMPTY;
        RString kozaIraishoRightJusho = RString.EMPTY;
        RString kozaIraishoLeftHihokenshaName = RString.EMPTY;
        RString kozaIraishoRightHihokenshaName = RString.EMPTY;
        if (通知書情報.get編集後本算定通知書共通情報().get編集後個人() != null) {
            kozaIraishoLeftJusho = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get編集後住所();
            kozaIraishoRightJusho = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get編集後住所();
            kozaIraishoLeftHihokenshaName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().getColumnValue();
            kozaIraishoRightHihokenshaName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().getColumnValue();
        }

        RString kmsHihokenshaName;
        RString nbmsHohokenshaName;
        try {
            kmsHihokenshaName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().getColumnValue();
            nbmsHohokenshaName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().getColumnValue();
        } catch (Exception e) {
            kmsHihokenshaName = RString.EMPTY;
            nbmsHohokenshaName = RString.EMPTY;
        }
        RString kmsSetaiCode = RString.EMPTY;
        RString nbmsSetaiCode;
        try {
            kmsSetaiCode = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get世帯コード().getColumnValue();
            nbmsSetaiCode = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get世帯コード().getColumnValue();
        } catch (Exception e) {
            kmsHihokenshaName = RString.EMPTY;
            nbmsSetaiCode = RString.EMPTY;
        }
        RString kmsSetaiNushiName;
        try {
            kmsSetaiNushiName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get世帯主名().getColumnValue();
        } catch (Exception e) {
            kmsSetaiNushiName = RString.EMPTY;
        }

        item.setKozaIraishoLeftJusho(kozaIraishoLeftJusho);
        item.setKozaIraishoRightJusho(kozaIraishoRightJusho);
        item.setKozaIraishoLeftHihokenshaName(kozaIraishoLeftHihokenshaName);
        item.setKozaIraishoRightHihokenshaName(kozaIraishoRightHihokenshaName);
        item.setKaisanMeisaishoHihokenshaName(kmsHihokenshaName);
        item.setKaisanMeisaishoSetaiNushiName(kmsSetaiNushiName);
        item.setKmsSetaiCode(kmsSetaiCode);
        item.setNbmsSetaiCode(nbmsSetaiCode);
        item.setNbmsHohokenshaName(nbmsHohokenshaName);
    }

    private void set計算明細書期１To１０(NonyuTsuchishoBookFuriKaeAriItem item) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 通知書情報.get納入通知書期情報リスト();

        NonyuTsuchiShoKiJoho 納入通知書期情報一番目 = getNonyuTsuchiShoKiJoho_空();
        NonyuTsuchiShoKiJoho 納入通知書期情報二番目 = getNonyuTsuchiShoKiJoho_空();
        NonyuTsuchiShoKiJoho 納入通知書期情報三番目 = getNonyuTsuchiShoKiJoho_空();
        NonyuTsuchiShoKiJoho 納入通知書期情報四番目 = getNonyuTsuchiShoKiJoho_空();
        NonyuTsuchiShoKiJoho 納入通知書期情報五番目 = getNonyuTsuchiShoKiJoho_空();
        NonyuTsuchiShoKiJoho 納入通知書期情報六番目 = getNonyuTsuchiShoKiJoho_空();
        NonyuTsuchiShoKiJoho 納入通知書期情報七番目 = getNonyuTsuchiShoKiJoho_空();
        NonyuTsuchiShoKiJoho 納入通知書期情報八番目 = getNonyuTsuchiShoKiJoho_空();
        NonyuTsuchiShoKiJoho 納入通知書期情報九番目 = getNonyuTsuchiShoKiJoho_空();
        NonyuTsuchiShoKiJoho 納入通知書期情報十番目 = getNonyuTsuchiShoKiJoho_空();
        int size = 納入通知書期情報リスト.size();
        for (int index = 0; index < size; index++) {
            if (index == 0) {
                納入通知書期情報一番目 = 納入通知書期情報リスト.get(index);
            } else if (index == INDEX_1) {
                納入通知書期情報二番目 = 納入通知書期情報リスト.get(index);
            } else if (index == INDEX_2) {
                納入通知書期情報三番目 = 納入通知書期情報リスト.get(index);
            } else if (index == INDEX_3) {
                納入通知書期情報四番目 = 納入通知書期情報リスト.get(index);
            } else if (index == INDEX_4) {
                納入通知書期情報五番目 = 納入通知書期情報リスト.get(index);
            } else if (index == INDEX_5) {
                納入通知書期情報六番目 = 納入通知書期情報リスト.get(index);
            } else if (index == INDEX_6) {
                納入通知書期情報七番目 = 納入通知書期情報リスト.get(index);
            } else if (index == INDEX_7) {
                納入通知書期情報八番目 = 納入通知書期情報リスト.get(index);
            } else if (index == INDEX_8) {
                納入通知書期情報九番目 = 納入通知書期情報リスト.get(index);
            } else if (index == INDEX_9) {
                納入通知書期情報十番目 = 納入通知書期情報リスト.get(index);
            }
        }

        RString kmsKi1 = 納入通知書期情報一番目.get期表記();
        RString kmsTsuki1 = 納入通知書期情報一番目.get月表記();
        RString kmsNokigenKaishi1 = 納入通知書期情報一番目.get納期開始日表記();
        RString kmsNokigenShuryo1 = 納入通知書期情報一番目.get納期終了日表記();
        RString kmsKi2 = 納入通知書期情報二番目.get期表記();
        RString kmsTsuki2 = 納入通知書期情報二番目.get月表記();
        RString kmsNokigenKaishi2 = 納入通知書期情報二番目.get納期開始日表記();
        RString kmsNokigenShuryo2 = 納入通知書期情報二番目.get納期終了日表記();
        RString kmsKi3 = 納入通知書期情報三番目.get期表記();
        RString kmsTsuki3 = 納入通知書期情報三番目.get月表記();
        RString kmsNokigenKaishi3 = 納入通知書期情報三番目.get納期開始日表記();
        RString kmsNokigenShuryo3 = 納入通知書期情報三番目.get納期終了日表記();
        RString kmsKi4 = 納入通知書期情報四番目.get期表記();
        RString kmsTsuki4 = 納入通知書期情報四番目.get月表記();
        RString kmsNokigenKaishi4 = 納入通知書期情報四番目.get納期開始日表記();
        RString kmsNokigenShuryo4 = 納入通知書期情報四番目.get納期終了日表記();
        RString kmsKi5 = 納入通知書期情報五番目.get期表記();
        RString kmsTsuki5 = 納入通知書期情報五番目.get月表記();
        RString kmsNokigenKaishi5 = 納入通知書期情報五番目.get納期開始日表記();
        RString kmsNokigenShuryo5 = 納入通知書期情報五番目.get納期終了日表記();
        RString kmsKi6 = 納入通知書期情報六番目.get期表記();
        RString kmsTsuki6 = 納入通知書期情報六番目.get月表記();
        RString kmsNokigenKaishi6 = 納入通知書期情報六番目.get納期開始日表記();
        RString kmsNokigenShuryo6 = 納入通知書期情報六番目.get納期終了日表記();
        RString kmsKi7 = 納入通知書期情報七番目.get期表記();
        RString kmsTsuki7 = 納入通知書期情報七番目.get月表記();
        RString kmsNokigenKaishi7 = 納入通知書期情報七番目.get納期開始日表記();
        RString kmsNokigenShuryo7 = 納入通知書期情報七番目.get納期終了日表記();
        RString kmsKi8 = 納入通知書期情報八番目.get期表記();
        RString kmsTsuki8 = 納入通知書期情報八番目.get月表記();
        RString kmsNokigenKaishi8 = 納入通知書期情報八番目.get納期開始日表記();
        RString kmsNokigenShuryo8 = 納入通知書期情報八番目.get納期終了日表記();
        RString kmsKi9 = 納入通知書期情報九番目.get期表記();
        RString kmsTsuki9 = 納入通知書期情報九番目.get月表記();
        RString kmsNokigenKaishi9 = 納入通知書期情報九番目.get納期開始日表記();
        RString kmsNokigenShuryo9 = 納入通知書期情報九番目.get納期終了日表記();
        RString kmsKi10 = 納入通知書期情報十番目.get期表記();
        RString kmsTsuki10 = 納入通知書期情報十番目.get月表記();
        RString kmsNokigenKaishi10 = 納入通知書期情報十番目.get納期開始日表記();
        RString kmsNokigenShuryo10 = 納入通知書期情報十番目.get納期終了日表記();

        item.setKmsKi1(kmsKi1);
        item.setKmsNokigenKaishi1(kmsNokigenKaishi1);
        item.setKmsTsuki1(kmsTsuki1);
        item.setKmsNokigenShuryo1(kmsNokigenShuryo1);
        item.setKmsKi2(kmsKi2);
        item.setKmsNokigenKaishi2(kmsNokigenKaishi2);
        item.setKmsTsuki2(kmsTsuki2);
        item.setKmsNokigenShuryo2(kmsNokigenShuryo2);
        item.setKmsKi3(kmsKi3);
        item.setKmsNokigenKaishi3(kmsNokigenKaishi3);
        item.setKmsTsuki3(kmsTsuki3);
        item.setKmsNokigenShuryo3(kmsNokigenShuryo3);
        item.setKmsKi4(kmsKi4);
        item.setKmsNokigenKaishi4(kmsNokigenKaishi4);
        item.setKmsTsuki4(kmsTsuki4);
        item.setKmsNokigenShuryo4(kmsNokigenShuryo4);
        item.setKmsKi5(kmsKi5);
        item.setKmsNokigenKaishi5(kmsNokigenKaishi5);
        item.setKmsTsuki5(kmsTsuki5);
        item.setKmsNokigenShuryo5(kmsNokigenShuryo5);
        item.setKmsKi6(kmsKi6);
        item.setKmsNokigenKaishi6(kmsNokigenKaishi6);
        item.setKmsTsuki6(kmsTsuki6);
        item.setKmsNokigenShuryo6(kmsNokigenShuryo6);
        item.setKmsKi7(kmsKi7);
        item.setKmsNokigenKaishi7(kmsNokigenKaishi7);
        item.setKmsTsuki7(kmsTsuki7);
        item.setKmsNokigenShuryo7(kmsNokigenShuryo7);
        item.setKmsKi8(kmsKi8);
        item.setKmsNokigenKaishi8(kmsNokigenKaishi8);
        item.setKmsTsuki8(kmsTsuki8);
        item.setKmsNokigenShuryo8(kmsNokigenShuryo8);
        item.setKmsKi9(kmsKi9);
        item.setKmsNokigenKaishi9(kmsNokigenKaishi9);
        item.setKmsTsuki9(kmsTsuki9);
        item.setKmsNokigenShuryo9(kmsNokigenShuryo9);
        item.setKmsKi10(kmsKi10);
        item.setKmsNokigenKaishi10(kmsNokigenKaishi10);
        item.setKmsTsuki10(kmsTsuki10);
        item.setKmsNokigenShuryo10(kmsNokigenShuryo10);

        set計算明細書(納入通知書期情報一番目, 納入通知書期情報二番目, 納入通知書期情報三番目,
                納入通知書期情報四番目, 納入通知書期情報五番目, 納入通知書期情報六番目, 納入通知書期情報七番目,
                納入通知書期情報八番目, 納入通知書期情報九番目, 納入通知書期情報十番目, item);

    }

    private void set計算明細書(NonyuTsuchiShoKiJoho 納入通知書期情報一番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報二番目, NonyuTsuchiShoKiJoho 納入通知書期情報三番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報四番目, NonyuTsuchiShoKiJoho 納入通知書期情報五番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報六番目, NonyuTsuchiShoKiJoho 納入通知書期情報七番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報八番目, NonyuTsuchiShoKiJoho 納入通知書期情報九番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報十番目, NonyuTsuchishoBookFuriKaeAriItem item) {

        RString kmsKiTitle1 = new RString(String.format(FORMAT_第XX期.toString(), 納入通知書期情報一番目.get期()));
        RString kmsKibetsuNofuGaku1 = 納入通知書期情報一番目.get調定額表記();
        RString yen1 = 円;
        RString kmsKiTitle3 = RString.EMPTY;
        RString kmsKibetsuNofuGaku3 = RString.EMPTY;
        if (納入通知書期情報二番目.get期() != 0) {
            kmsKiTitle3 = 次期以降;
            kmsKibetsuNofuGaku3 = 納入通知書期情報二番目.get調定額表記();

        }
        RString nbmsKi1 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報一番目.get期表記()));
        RString nbmsFuchoNofuGaku1 = 納入通知書期情報一番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku1 = 納入通知書期情報一番目.get収入額表記();
        RString nbmsFuchoSaGaku1 = 納入通知書期情報一番目.get差額表記();
        RString nbmsNokigen1 = 納入通知書期情報一番目.get納期限表記();
        RString nbmsKi2 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報二番目.get期表記()));
        RString nbmsFuchoNofuGaku2 = 納入通知書期情報二番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku2 = 納入通知書期情報二番目.get収入額表記();
        RString nbmsFuchoSaGaku2 = 納入通知書期情報二番目.get差額表記();
        RString nbmsNokigen2 = 納入通知書期情報二番目.get納期限表記();
        RString nbmsKi3 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報三番目.get期表記()));
        RString nbmsFuchoNofuGaku3 = 納入通知書期情報三番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku3 = 納入通知書期情報三番目.get収入額表記();
        RString nbmsFuchoSaGaku3 = 納入通知書期情報三番目.get差額表記();
        RString nbmsNokigen3 = 納入通知書期情報三番目.get納期限表記();
        RString nbmsKi4 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報四番目.get期表記()));
        RString nbmsFuchoNofuGaku4 = 納入通知書期情報四番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku4 = 納入通知書期情報四番目.get収入額表記();
        RString nbmsFuchoSaGaku4 = 納入通知書期情報四番目.get差額表記();
        RString nbmsNokigen4 = 納入通知書期情報四番目.get納期限表記();
        RString nbmsKi5 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報五番目.get期表記()));
        RString nbmsFuchoNofuGaku5 = 納入通知書期情報五番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku5 = 納入通知書期情報五番目.get収入額表記();
        RString nbmsFuchoSaGaku5 = 納入通知書期情報五番目.get差額表記();
        RString nbmsNokigen5 = 納入通知書期情報五番目.get納期限表記();
        RString nbmsKi6 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報六番目.get期表記()));
        RString nbmsFuchoNofuGaku6 = 納入通知書期情報六番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku6 = 納入通知書期情報六番目.get収入額表記();
        RString nbmsFuchoSaGaku6 = 納入通知書期情報六番目.get差額表記();
        RString nbmsNokigen6 = 納入通知書期情報六番目.get納期限表記();
        RString nbmsKi7 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報七番目.get期表記()));
        RString nbmsFuchoNofuGaku7 = 納入通知書期情報七番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku7 = 納入通知書期情報七番目.get収入額表記();
        RString nbmsFuchoSaGaku7 = 納入通知書期情報七番目.get差額表記();
        RString nbmsNokigen7 = 納入通知書期情報七番目.get納期限表記();
        RString nbmsKi8 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報八番目.get期表記()));
        RString nbmsFuchoNofuGaku8 = 納入通知書期情報八番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku8 = 納入通知書期情報八番目.get収入額表記();
        RString nbmsFuchoSaGaku8 = 納入通知書期情報八番目.get差額表記();
        RString nbmsNokigen8 = 納入通知書期情報八番目.get納期限表記();
        RString nbmsKi9 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報九番目.get期表記()));
        RString nbmsFuchoNofuGaku9 = 納入通知書期情報九番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku9 = 納入通知書期情報九番目.get収入額表記();
        RString nbmsFuchoSaGaku9 = 納入通知書期情報九番目.get差額表記();
        RString nbmsNokigen9 = 納入通知書期情報九番目.get納期限表記();
        RString nbmsKi10 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報十番目.get期表記()));
        RString nbmsFuchoNofuGaku10 = 納入通知書期情報十番目.get調定額表記();
        RString nbmsFuchoNofuZumiGaku10 = 納入通知書期情報十番目.get収入額表記();
        RString nbmsFuchoSaGaku10 = 納入通知書期情報十番目.get差額表記();
        RString nbmsNokigen10 = 納入通知書期情報十番目.get納期限表記();
        RString nbmsFuchoNofuGaku11 = new RString(納入通知書期情報一番目.get調定額表記().concat(納入通知書期情報二番目.get調定額表記()).
                concat(納入通知書期情報三番目.get調定額表記()).concat(納入通知書期情報四番目.get調定額表記()).concat(納入通知書期情報五番目.get調定額表記()).
                concat(納入通知書期情報六番目.get調定額表記()).concat(納入通知書期情報七番目.get調定額表記()).concat(納入通知書期情報八番目.get調定額表記()).
                concat(納入通知書期情報九番目.get調定額表記()).concat(納入通知書期情報十番目.get調定額表記()).toString());
        RString nbmsFuchoNofuZumiGaku11 = new RString(納入通知書期情報一番目.get収入額表記().concat(納入通知書期情報二番目.get収入額表記()).
                concat(納入通知書期情報三番目.get収入額表記()).concat(納入通知書期情報四番目.get収入額表記()).concat(納入通知書期情報五番目.get収入額表記()).
                concat(納入通知書期情報六番目.get収入額表記()).concat(納入通知書期情報七番目.get収入額表記()).concat(納入通知書期情報八番目.get収入額表記()).
                concat(納入通知書期情報九番目.get収入額表記()).concat(納入通知書期情報十番目.get収入額表記()).toString());
        RString nbmsFuchoSaGaku11 = new RString(納入通知書期情報一番目.get差額表記().concat(納入通知書期情報二番目.get差額表記()).
                concat(納入通知書期情報三番目.get差額表記()).concat(納入通知書期情報四番目.get差額表記()).concat(納入通知書期情報五番目.get差額表記()).
                concat(納入通知書期情報六番目.get差額表記()).concat(納入通知書期情報七番目.get差額表記()).concat(納入通知書期情報八番目.get差額表記()).
                concat(納入通知書期情報九番目.get差額表記()).concat(納入通知書期情報十番目.get差額表記()).toString());

        item.setYen1(yen1);
        item.setKmsKiTitle1(kmsKiTitle1);
        item.setKmsKibetsuNofuGaku1(kmsKibetsuNofuGaku1);
        item.setKmsKiTitle3(kmsKiTitle3);
        item.setKmsKibetsuNofuGaku3(kmsKibetsuNofuGaku3);
        item.setNbmsKi1(nbmsKi1);
        item.setNbmsFuchoNofuGaku1(nbmsFuchoNofuGaku1);
        item.setNbmsFuchoNofuZumiGaku1(nbmsFuchoNofuZumiGaku1);
        item.setNbmsFuchoSaGaku1(nbmsFuchoSaGaku1);
        item.setNbmsNokigen1(nbmsNokigen1);
        item.setNbmsKi2(nbmsKi2);
        item.setNbmsFuchoNofuGaku2(nbmsFuchoNofuGaku2);
        item.setNbmsFuchoNofuZumiGaku2(nbmsFuchoNofuZumiGaku2);
        item.setNbmsFuchoSaGaku2(nbmsFuchoSaGaku2);
        item.setNbmsNokigen2(nbmsNokigen2);
        item.setNbmsKi3(nbmsKi3);
        item.setNbmsFuchoNofuGaku3(nbmsFuchoNofuGaku3);
        item.setNbmsFuchoNofuZumiGaku3(nbmsFuchoNofuZumiGaku3);
        item.setNbmsFuchoSaGaku3(nbmsFuchoSaGaku3);
        item.setNbmsNokigen3(nbmsNokigen3);
        item.setNbmsKi4(nbmsKi4);
        item.setNbmsFuchoNofuGaku4(nbmsFuchoNofuGaku4);
        item.setNbmsFuchoNofuZumiGaku4(nbmsFuchoNofuZumiGaku4);
        item.setNbmsFuchoSaGaku4(nbmsFuchoSaGaku4);
        item.setNbmsNokigen4(nbmsNokigen4);
        item.setNbmsKi5(nbmsKi5);
        item.setNbmsFuchoNofuGaku5(nbmsFuchoNofuGaku5);
        item.setNbmsFuchoNofuZumiGaku5(nbmsFuchoNofuZumiGaku5);
        item.setNbmsFuchoSaGaku5(nbmsFuchoSaGaku5);
        item.setNbmsNokigen5(nbmsNokigen5);
        item.setNbmsKi6(nbmsKi6);
        item.setNbmsFuchoNofuGaku6(nbmsFuchoNofuGaku6);
        item.setNbmsFuchoNofuZumiGaku6(nbmsFuchoNofuZumiGaku6);
        item.setNbmsFuchoSaGaku6(nbmsFuchoSaGaku6);
        item.setNbmsNokigen6(nbmsNokigen6);
        item.setNbmsKi7(nbmsKi7);
        item.setNbmsFuchoNofuGaku7(nbmsFuchoNofuGaku7);
        item.setNbmsFuchoNofuZumiGaku7(nbmsFuchoNofuZumiGaku7);
        item.setNbmsFuchoSaGaku7(nbmsFuchoSaGaku7);
        item.setNbmsNokigen7(nbmsNokigen7);
        item.setNbmsKi8(nbmsKi8);
        item.setNbmsFuchoNofuGaku8(nbmsFuchoNofuGaku8);
        item.setNbmsFuchoNofuZumiGaku8(nbmsFuchoNofuZumiGaku8);
        item.setNbmsFuchoSaGaku8(nbmsFuchoSaGaku8);
        item.setNbmsNokigen8(nbmsNokigen8);
        item.setNbmsKi9(nbmsKi9);
        item.setNbmsFuchoNofuGaku9(nbmsFuchoNofuGaku9);
        item.setNbmsFuchoNofuZumiGaku9(nbmsFuchoNofuZumiGaku9);
        item.setNbmsFuchoSaGaku9(nbmsFuchoSaGaku9);
        item.setNbmsNokigen9(nbmsNokigen9);
        item.setNbmsKi10(nbmsKi10);
        item.setNbmsFuchoNofuGaku10(nbmsFuchoNofuGaku10);
        item.setNbmsFuchoNofuZumiGaku10(nbmsFuchoNofuZumiGaku10);
        item.setNbmsFuchoSaGaku10(nbmsFuchoSaGaku10);
        item.setNbmsNokigen10(nbmsNokigen10);
        item.setNbmsFuchoNofuGaku11(nbmsFuchoNofuGaku11);
        item.setNbmsFuchoNofuZumiGaku11(nbmsFuchoNofuZumiGaku11);
        item.setNbmsFuchoSaGaku11(nbmsFuchoSaGaku11);
    }

    private void set納期別明細書特徴納付済額１To３(NonyuTsuchishoBookFuriKaeAriItem item) {
        List<CharacteristicsPhase> 特徴期別金額リスト = 通知書情報.get編集後本算定通知書共通情報().get更正後().get特徴期別金額リスト();
        if (特徴期別金額リスト == null) {
            特徴期別金額リスト = new ArrayList<>();
        }
        CharacteristicsPhase 特徴期別金額１ = new CharacteristicsPhase();
        CharacteristicsPhase 特徴期別金額２ = new CharacteristicsPhase();
        CharacteristicsPhase 特徴期別金額３ = new CharacteristicsPhase();
        for (CharacteristicsPhase joho : 特徴期別金額リスト) {
            if (期_4.equals(joho.get期())) {
                特徴期別金額１ = joho;
            } else if (期_5.equals(joho.get期())) {
                特徴期別金額２ = joho;
            } else if (期_6.equals(joho.get期())) {
                特徴期別金額３ = joho;
            }
        }

        Decimal 納期別明細書特徴納付額１ = 特徴期別金額１.get金額() == null ? new Decimal(0) : 特徴期別金額１.get金額();
        Decimal 納期別明細書特徴納付額２ = 特徴期別金額２.get金額() == null ? new Decimal(0) : 特徴期別金額２.get金額();
        Decimal 納期別明細書特徴納付額３ = 特徴期別金額３.get金額() == null ? new Decimal(0) : 特徴期別金額３.get金額();
        List<SpecialIncomeInformation> 特徴収入情報リスト = 通知書情報.get編集後本算定通知書共通情報().get特徴収入情報リスト();
        if (特徴収入情報リスト == null) {
            特徴収入情報リスト = new ArrayList<>();
        }
        SpecialIncomeInformation 収入額１ = new SpecialIncomeInformation();
        SpecialIncomeInformation 収入額２ = new SpecialIncomeInformation();
        SpecialIncomeInformation 収入額３ = new SpecialIncomeInformation();
        for (SpecialIncomeInformation joho : 特徴収入情報リスト) {
            if (期_4.equals(joho.get期月().get期())) {
                収入額１ = joho;
            } else if (期_5.equals(joho.get期月().get期())) {
                収入額２ = joho;
            } else if (期_6.equals(joho.get期月().get期())) {
                収入額３ = joho;
            }
        }
        Decimal 納期別明細書特徴納付済額１ = ObjectUtil.defaultIfNull(収入額１.get収入額(), new Decimal(0));
        Decimal 納期別明細書特徴納付済額２ = ObjectUtil.defaultIfNull(収入額２.get収入額(), new Decimal(0));
        Decimal 納期別明細書特徴納付済額３ = ObjectUtil.defaultIfNull(収入額３.get収入額(), new Decimal(0));
        Decimal 納期別明細書特徴差額１ = 納期別明細書特徴納付額１.subtract(納期別明細書特徴納付済額１);
        Decimal 納期別明細書特徴差額２ = 納期別明細書特徴納付額２.subtract(納期別明細書特徴納付済額２);
        Decimal 納期別明細書特徴差額３ = 納期別明細書特徴納付額３.subtract(納期別明細書特徴納付済額３);

        RString nbmsTokuchoNofuGaku1 = new RString(KingakuFormatter.
                create(納期別明細書特徴納付額１).format(KingakuUnit.円).setCommaSeparated().toString());
        RString nbmsTokuchoNofuZumiGaku1 = new RString(KingakuFormatter.
                create(納期別明細書特徴納付済額１).format(KingakuUnit.円).setCommaSeparated().toString());
        RString nbmsTokuchoSaGaku1 = new RString(KingakuFormatter.
                create(納期別明細書特徴差額１).format(KingakuUnit.円).setCommaSeparated().setSignPattern(Sign.プラス表示).toString());
        RString nbmsTokuchoNofuGaku2 = new RString(KingakuFormatter.
                create(納期別明細書特徴納付額２).format(KingakuUnit.円).setCommaSeparated().toString());
        RString nbmsTokuchoNofuZumiGaku2 = new RString(KingakuFormatter.
                create(納期別明細書特徴納付済額２).format(KingakuUnit.円).setCommaSeparated().toString());
        RString nbmsTokuchoSaGaku2 = new RString(KingakuFormatter.
                create(納期別明細書特徴差額２).format(KingakuUnit.円).setCommaSeparated().setSignPattern(Sign.プラス表示).toString());
        RString nbmsTokuchoNofuGaku3 = new RString(KingakuFormatter.
                create(納期別明細書特徴納付額３).format(KingakuUnit.円).setCommaSeparated().toString());
        RString nbmsTokuchoNofuZumiGaku3 = new RString(KingakuFormatter.
                create(納期別明細書特徴差額３).
                format(KingakuUnit.円).setCommaSeparated().toString());
        RString nbmsTokuchoSaGaku3 = new RString(KingakuFormatter.
                create(納期別明細書特徴差額３).
                format(KingakuUnit.円).setCommaSeparated().setSignPattern(Sign.プラス表示).toString());
        RString nbmsTokuchoNofuGaku4 = new RString(KingakuFormatter.
                create(納期別明細書特徴納付額１.add(納期別明細書特徴納付額２).add(納期別明細書特徴納付額３)).
                format(KingakuUnit.円).setCommaSeparated().toString());
        RString nbmsTokuchoNofuZumiGaku4 = new RString(KingakuFormatter.
                create(納期別明細書特徴納付済額１.add(納期別明細書特徴納付済額２).add(納期別明細書特徴納付済額３)).
                format(KingakuUnit.円).setCommaSeparated().toString());
        RString nbmsTokuchoSaGaku4 = new RString(KingakuFormatter.
                create(納期別明細書特徴差額１.add(納期別明細書特徴差額２).add(納期別明細書特徴差額３)).
                format(KingakuUnit.円).setCommaSeparated().setSignPattern(Sign.プラス表示).toString());

        item.setNbmsTokuchoNofuGaku1(nbmsTokuchoNofuGaku1);
        item.setNbmsTokuchoNofuZumiGaku1(nbmsTokuchoNofuZumiGaku1);
        item.setNbmsTokuchoSaGaku1(nbmsTokuchoSaGaku1);
        item.setNbmsTokuchoNofuGaku2(nbmsTokuchoNofuGaku2);
        item.setNbmsTokuchoNofuZumiGaku2(nbmsTokuchoNofuZumiGaku2);
        item.setNbmsTokuchoSaGaku2(nbmsTokuchoSaGaku2);
        item.setNbmsTokuchoNofuGaku3(nbmsTokuchoNofuGaku3);
        item.setNbmsTokuchoNofuZumiGaku3(nbmsTokuchoNofuZumiGaku3);
        item.setNbmsTokuchoSaGaku3(nbmsTokuchoSaGaku3);
        item.setNbmsTokuchoNofuGaku4(nbmsTokuchoNofuGaku4);
        item.setNbmsTokuchoNofuZumiGaku4(nbmsTokuchoNofuZumiGaku4);
        item.setNbmsTokuchoSaGaku4(nbmsTokuchoSaGaku4);
    }

    private void setCompNinshosha(NonyuTsuchishoBookFuriKaeAriItem item) {
        // CompNinshosha
        RString denshiKoin = ninshoshaSource.denshiKoin;
        RString hakkoYMD = ninshoshaSource.hakkoYMD;
        RString ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        RString ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        RString ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        RString koinMojiretsu = ninshoshaSource.koinMojiretsu;
        RString ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        RString ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        RString koinShoryaku = ninshoshaSource.koinShoryaku;

        // CompNinshoshaのset処理
        item.setDenshiKoin(denshiKoin);
        item.setHakkoYMD(hakkoYMD);
        item.setNinshoshaYakushokuMei(ninshoshaYakushokuMei);
        item.setNinshoshaYakushokuMei1(ninshoshaYakushokuMei1);
        item.setKoinMojiretsu(koinMojiretsu);
        item.setNinshoshaYakushokuMei2(ninshoshaYakushokuMei2);
        item.setNinshoshaShimeiKakenai(ninshoshaShimeiKakenai);
        item.setNinshoshaShimeiKakeru(ninshoshaShimeiKakeru);
        item.setKoinShoryaku(koinShoryaku);
    }

    private void setCompSofubutsuAtesaki(NonyuTsuchishoBookFuriKaeAriItem item) {
        // CompSofubutsuAtesaki
        SofubutsuAtesakiSource sofubutsuAtesakiSource = 通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource().get送付物宛先ソース();
        RString customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        RString dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        RString gyoseiku = sofubutsuAtesakiSource.gyoseiku;
        RString jusho1 = sofubutsuAtesakiSource.jusho1;
        RString jusho2 = sofubutsuAtesakiSource.jusho2;
        RString jusho3 = sofubutsuAtesakiSource.jusho3;
        RString jushoText = sofubutsuAtesakiSource.jushoText;
        RString kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        RString kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        RString kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        RString kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        RString katagaki1 = sofubutsuAtesakiSource.katagaki1;
        RString katagaki2 = sofubutsuAtesakiSource.katagaki2;
        RString katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        RString katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        RString katagakiText = sofubutsuAtesakiSource.katagakiText;
        RString meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        RString meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        RString samaBun1 = sofubutsuAtesakiSource.samaBun1;
        RString samaBun2 = sofubutsuAtesakiSource.samaBun2;
        RString samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        RString samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        RString samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        RString samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        RString samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        RString shimei1 = sofubutsuAtesakiSource.shimei1;
        RString shimei2 = sofubutsuAtesakiSource.shimei2;
        RString shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        RString shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        RString shimeiText = sofubutsuAtesakiSource.shimeiText;
        RString yubinNo = sofubutsuAtesakiSource.yubinNo;

        // CompSofubutsuAtesakiのset処理
        item.setYubinNo(yubinNo);
        item.setGyoseiku(gyoseiku);
        item.setJushoText(jushoText);
        item.setJusho3(jusho3);
        item.setJusho1(jusho1);
        item.setJusho2(jusho2);
        item.setKatagakiText(katagakiText);
        item.setKatagaki2(katagaki2);
        item.setKatagakiSmall2(katagakiSmall2);
        item.setKatagaki1(katagaki1);
        item.setKatagakiSmall1(katagakiSmall1);
        item.setShimei2(shimei2);
        item.setShimeiSmall2(shimeiSmall2);
        item.setShimeiText(shimeiText);
        item.setMeishoFuyo2(meishoFuyo2);
        item.setShimeiSmall1(shimeiSmall1);
        item.setDainoKubunMei(dainoKubunMei);
        item.setShimei1(shimei1);
        item.setMeishoFuyo1(meishoFuyo1);
        item.setSamabunShimeiText(samabunShimeiText);
        item.setSamaBun2(samaBun2);
        item.setSamabunShimeiSmall2(samabunShimeiSmall2);
        item.setKakkoLeft2(kakkoLeft2);
        item.setSamabunShimei2(samabunShimei2);
        item.setKakkoRight2(kakkoRight2);
        item.setKakkoLeft1(kakkoLeft1);
        item.setSamabunShimei1(samabunShimei1);
        item.setSamaBun1(samaBun1);
        item.setKakkoRight1(kakkoRight1);
        item.setSamabunShimeiSmall1(samabunShimeiSmall1);
        item.setCustomerBarCode(customerBarCode);
    }
}
