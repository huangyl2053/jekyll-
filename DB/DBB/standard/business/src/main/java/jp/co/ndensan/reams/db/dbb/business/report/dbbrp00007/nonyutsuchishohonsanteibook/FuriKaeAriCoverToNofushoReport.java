/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishohonsanteibook;

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
 * 「口振依頼あり通知書(DBB100055_NonyuTsuchishoBookFuriKaeAriCover)」と「納付書(DBB100020_HokenryoNonyuTsuchishoBookNofusho)」のReportです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class FuriKaeAriCoverToNofushoReport extends Report<FuriKaeAriCoverToNofushoReportSource> {

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

    /**
     * フォームのコンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource 認証者雛形部品
     */
    public FuriKaeAriCoverToNofushoReport(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, NinshoshaSource ninshoshaSource) {
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

        List<FuriKaeAriCoverToNofushoItem> itemList = new ArrayList<>();
        FuriKaeAriCoverToNofushoItem item = edit口振依頼あり通知書();
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

        for (FuriKaeAriCoverToNofushoItem target : itemList) {
            IFuriKaeAriCoverToNofushoEditor bodyEditor = new FuriKaeAriCoverToNofushoEditor(target);
            IFuriKaeAriCoverToNofushoBuilder builder = new FuriKaeAriCoverToNofushoBuilderImpl(bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void edit納付書(int ブック開始位置, List<NonyuTsuchiShoKiJoho> 期リスト, List<FuriKaeAriCoverToNofushoItem> itemList) { // 山分け

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
        if (ブック開始位置 == 2) {
            if (size >= 1) {
                joho1 = tmp期リスト.get(0);
                期リスト.remove(joho1);
            }
            if (size >= 2) {
                joho2 = tmp期リスト.get(1);
                期リスト.remove(joho2);
            }
            if (size >= 3) {
                joho3 = tmp期リスト.get(2);
                期リスト.remove(joho3);
            }
            if (size >= 4) {
                joho4 = tmp期リスト.get(3);
                期リスト.remove(joho4);
            }
        } else if (ブック開始位置 == 3) {
            if (size >= 1) {
                joho2 = tmp期リスト.get(0);
                期リスト.remove(joho2);
            }
            if (size >= 2) {
                joho3 = tmp期リスト.get(1);
                期リスト.remove(joho3);
            }
            if (size >= 3) {
                joho4 = tmp期リスト.get(2);
                期リスト.remove(joho4);
            }
        } else if (ブック開始位置 == 4) {
            if (size >= 1) {
                joho3 = tmp期リスト.get(0);
                期リスト.remove(joho3);
            }
            if (size >= 2) {
                joho4 = tmp期リスト.get(1);
                期リスト.remove(joho4);
            }
        } else if (ブック開始位置 == 5) {
            if (size >= 1) {
                joho4 = tmp期リスト.get(0);
                期リスト.remove(joho4);
            }
        }

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

        // 印字位置④
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

        //印字位置⑤
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

        FuriKaeAriCoverToNofushoItem item = new FuriKaeAriCoverToNofushoItem();

        // DBB100020_HokenryoNonyuTsuchishoBookNofusho
        item.setLayoutBreakItem(2);
        item.setNofuzumishoTitleNendoBun1(nofuzumishoTitleNendoBun1);
        item.setNofuzumishoTitleKi1(nofuzumishoTitleKi1);
        item.setNofuzumishoTitleTsuki1(nofuzumishoTitleTsuki1);
        item.setNofozumishoTitleNendo1(nofozumishoTitleNendo1);
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
        item.setRyoshushoTitleNendo1(ryoshushoTitleNendo1);
        item.setRyoshushoTitleKi1(ryoshushoTitleKi1);
        item.setRyoshushoTitleTsuki1(ryoshushoTitleTsuki1);
        item.setNofushoTitleNendo1(nofushoTitleNendo1);
        item.setNofushoTitleKi1(nofushoTitleKi1);
        item.setNofushoTitleTsuki1(nofushoTitleTsuki1);
        item.setRyoshushoJusho1(ryoshushoJusho1);
        item.setRyoshushoJusho2(ryoshushoJusho2);
        item.setNofuzumishoTsuchishoNo1(nofuzumishoTsuchishoNo1);
        item.setNofuzumishoTsuchishoNo2(nofuzumishoTsuchishoNo2);
        item.setNofuzumishoOCR11(nofuzumishoOCR11);
        item.setNofuzumishoOCR12(nofuzumishoOCR12);
        item.setRyoshushoKatagaki1(ryoshushoKatagaki1);
        item.setRyoshushoKatagaki2(ryoshushoKatagaki2);
        item.setNofuzumishoSetaiCode1(nofuzumishoSetaiCode1);
        item.setNofuzumishoSetaiCode2(nofuzumishoSetaiCode2);
        item.setNofuzumishoOCR22(nofuzumishoOCR22);
        item.setNofuzumishoOCR21(nofuzumishoOCR21);
        item.setRyoshushoHihokenshaName1(ryoshushoHihokenshaName1);
        item.setNofushoHihokenshaName1(nofushoHihokenshaName1);
        item.setRyoshushoHihokenshaName2(ryoshushoHihokenshaName2);
        item.setNofushoHihokenshaName2(nofushoHihokenshaName2);
        item.setNofuzumishoOCR31(nofuzumishoOCR31);
        item.setNofuzumishoNokigen1(nofuzumishoNokigen1);
        item.setNofuzumishoNokigen2(nofuzumishoNokigen2);
        item.setNofuzumishoOCR32(nofuzumishoOCR32);
        item.setRyoshushoTsuchishoNo1(ryoshushoTsuchishoNo1);
        item.setNofushoTsuchishoNo1(nofushoTsuchishoNo1);
        item.setRyoshushoTsuchishoNo2(ryoshushoTsuchishoNo2);
        item.setNofushoTsuchishoNo2(nofushoTsuchishoNo2);
        item.setRyoshushoHokenryoGaku1(ryoshushoHokenryoGaku1);
        item.setNofushoHokenryoGaku1(nofushoHokenryoGaku1);
        item.setRyoshushoHokenryoGaku2(ryoshushoHokenryoGaku2);
        item.setNofushoHokenryoGaku2(nofushoHokenryoGaku2);
        item.setNofuzumishoNofuGaku1(nofuzumishoNofuGaku1);
        item.setNofuzumishoNofuGaku2(nofuzumishoNofuGaku2);
        item.setRyoshushoNokigen1(ryoshushoNokigen1);
        item.setNofushoNokigen1(nofushoNokigen1);
        item.setRyoshushoNokigen2(ryoshushoNokigen2);
        item.setNofushoNokigen2(nofushoNokigen2);
        item.setNofuzumishoJusho1(nofuzumishoJusho1);
        item.setNofuzumishoJusho2(nofuzumishoJusho2);
        item.setNofuzumishoKatagaki1(nofuzumishoKatagaki1);
        item.setNofuzumishoKatagaki2(nofuzumishoKatagaki2);
        item.setRyoshushoNofuIn1(ryoshushoNofuIn1);
        item.setNofushoNofuIn1(nofushoNofuIn1);
        item.setNofuzumishoNofuIn1(nofuzumishoNofuIn1);
        item.setRyoshushoNofuIn2(ryoshushoNofuIn2);
        item.setNofushoNofuIn2(nofushoNofuIn2);
        item.setNofuzumishoNofuIn2(nofuzumishoNofuIn2);
        item.setRyoshushoKozaCom1(ryoshushoKozaCom1);
        item.setNofushoKozaCom1(nofushoKozaCom1);
        item.setNofuzumishoHihokenshaName1(nofuzumishoHihokenshaName1);
        item.setNofuzumishoKozaCom1(nofuzumishoKozaCom1);
        item.setRyoshushoKozaCom2(ryoshushoKozaCom2);
        item.setNofushoKozaCom2(nofushoKozaCom2);
        item.setNofuzumishoHihokenshaName2(nofuzumishoHihokenshaName2);
        item.setNofuzumishoKozaCom2(nofuzumishoKozaCom2);
        item.setRyoshushoZuiji1(ryoshushoZuiji1);
        item.setNofushoZuiji1(nofushoZuiji1);
        item.setNofuzumishoZuiji1(nofuzumishoZuiji1);
        item.setRyoshushoZuiji2(ryoshushoZuiji2);
        item.setNofushoZuiji2(nofushoZuiji2);
        item.setNofuzumishoZuiji2(nofuzumishoZuiji2);
        item.setNofuzumishoshichosonName1(nofuzumishoshichosonName1);
        item.setPagerenban1(pagerenban1);
        item.setNofuzumishoshichosonName2(nofuzumishoshichosonName2);
        item.setPagerenban2(pagerenban2);
        item.setNofozumishoTitleNendo3(nofozumishoTitleNendo3);
        item.setNofuzumishoTitleNendoBun3(nofuzumishoTitleNendoBun3);
        item.setNofuzumishoTitleKi3(nofuzumishoTitleKi3);
        item.setNofuzumishoTitleTsuki3(nofuzumishoTitleTsuki3);
        item.setNofozumishoTitleNendo4(nofozumishoTitleNendo4);
        item.setNofuzumishoTitleNendoBun4(nofuzumishoTitleNendoBun4);
        item.setNofuzumishoTitleKi4(nofuzumishoTitleKi4);
        item.setNofuzumishoTitleTsuki4(nofuzumishoTitleTsuki4);
        item.setRyoshushoTitleNendo3(ryoshushoTitleNendo3);
        item.setRyoshushoTitleKi3(ryoshushoTitleKi3);
        item.setRyoshushoTitleTsuki3(ryoshushoTitleTsuki3);
        item.setNofushoTitleNendo3(nofushoTitleNendo3);
        item.setNofushoTitleKi3(nofushoTitleKi3);
        item.setNofushoTitleTsuki3(nofushoTitleTsuki3);
        item.setRyoshushoTitleNendo4(ryoshushoTitleNendo4);
        item.setRyoshushoTitleKi4(ryoshushoTitleKi4);
        item.setRyoshushoTitleTsuki4(ryoshushoTitleTsuki4);
        item.setNofushoTitleNendo4(nofushoTitleNendo4);
        item.setNofushoTitleKi4(nofushoTitleKi4);
        item.setNofushoTitleTsuki4(nofushoTitleTsuki4);
        item.setRyoshushoJusho3(ryoshushoJusho3);
        item.setRyoshushoJusho4(ryoshushoJusho4);
        item.setNofuzumishoTsuchishoNo3(nofuzumishoTsuchishoNo3);
        item.setNofuzumishoTsuchishoNo4(nofuzumishoTsuchishoNo4);
        item.setNofuzumishoOCR13(nofuzumishoOCR13);
        item.setNofuzumishoOCR14(nofuzumishoOCR14);
        item.setRyoshushoKatagaki3(ryoshushoKatagaki3);
        item.setRyoshushoKatagaki4(ryoshushoKatagaki4);
        item.setNofuzumishoSetaiCode3(nofuzumishoSetaiCode3);
        item.setNofuzumishoSetaiCode4(nofuzumishoSetaiCode4);
        item.setNofuzumishoOCR23(nofuzumishoOCR23);
        item.setNofuzumishoOCR24(nofuzumishoOCR24);
        item.setRyoshushoHihokenshaName3(ryoshushoHihokenshaName3);
        item.setNofushoHihokenshaName3(nofushoHihokenshaName3);
        item.setRyoshushoHihokenshaName4(ryoshushoHihokenshaName4);
        item.setNofushoHihokenshaName4(nofushoHihokenshaName4);
        item.setNofuzumishoNokigen3(nofuzumishoNokigen3);
        item.setNofuzumishoNokigen4(nofuzumishoNokigen4);
        item.setNofuzumishoOCR33(nofuzumishoOCR33);
        item.setNofuzumishoOCR34(nofuzumishoOCR34);
        item.setRyoshushoTsuchishoNo3(ryoshushoTsuchishoNo3);
        item.setNofushoTsuchishoNo3(nofushoTsuchishoNo3);
        item.setRyoshushoTsuchishoNo4(ryoshushoTsuchishoNo4);
        item.setNofushoTsuchishoNo4(nofushoTsuchishoNo4);
        item.setRyoshushoHokenryoGaku3(ryoshushoHokenryoGaku3);
        item.setNofushoHokenryoGaku3(nofushoHokenryoGaku3);
        item.setRyoshushoHokenryoGaku4(ryoshushoHokenryoGaku4);
        item.setNofushoHokenryoGaku4(nofushoHokenryoGaku4);
        item.setNofuzumishoNofuGaku3(nofuzumishoNofuGaku3);
        item.setNofuzumishoNofuGaku4(nofuzumishoNofuGaku4);
        item.setRyoshushoNokigen3(ryoshushoNokigen3);
        item.setNofushoNokigen3(nofushoNokigen3);
        item.setRyoshushoNokigen4(ryoshushoNokigen4);
        item.setNofushoNokigen4(nofushoNokigen4);
        item.setNofuzumishoJusho3(nofuzumishoJusho3);
        item.setNofuzumishoJusho4(nofuzumishoJusho4);
        item.setNofuzumishoKatagaki3(nofuzumishoKatagaki3);
        item.setNofuzumishoKatagaki4(nofuzumishoKatagaki4);
        item.setRyoshushoNofuIn3(ryoshushoNofuIn3);
        item.setNofushoNofuIn3(nofushoNofuIn3);
        item.setNofuzumishoNofuIn3(nofuzumishoNofuIn3);
        item.setRyoshushoNofuIn4(ryoshushoNofuIn4);
        item.setNofushoNofuIn4(nofushoNofuIn4);
        item.setNofuzumishoNofuIn4(nofuzumishoNofuIn4);
        item.setRyoshushoKozaCom3(ryoshushoKozaCom3);
        item.setNofushoKozaCom3(nofushoKozaCom3);
        item.setNofuzumishoHihokenshaName3(nofuzumishoHihokenshaName3);
        item.setNofuzumishoKozaCom3(nofuzumishoKozaCom3);
        item.setRyoshushoKozaCom4(ryoshushoKozaCom4);
        item.setNofushoKozaCom4(nofushoKozaCom4);
        item.setNofuzumishoHihokenshaName4(nofuzumishoHihokenshaName4);
        item.setNofuzumishoKozaCom4(nofuzumishoKozaCom4);
        item.setRyoshushoZuiji3(ryoshushoZuiji3);
        item.setNofushoZuiji3(nofushoZuiji3);
        item.setNofuzumishoZuiji3(nofuzumishoZuiji3);
        item.setRyoshushoZuiji4(ryoshushoZuiji4);
        item.setNofushoZuiji4(nofushoZuiji4);
        item.setNofuzumishoZuiji4(nofuzumishoZuiji4);
        item.setERenban(eRenban);
        item.setEPage(ePage);
        item.setNofuzumishoshichosonName3(nofuzumishoshichosonName3);
        item.setPagerenban3(pagerenban3);
        item.setNofuzumishoshichosonName4(nofuzumishoshichosonName4);
        item.setPagerenban4(pagerenban4);
        item.setEHokensyaName(eHokensyaName);

        itemList.add(item);

        if (期リスト.size() > 0) {
            ブック開始位置 = 2;
            edit納付書(ブック開始位置, 期リスト, itemList);
        }

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

        RString OCRID = RString.EMPTY;
        Map<Integer, RString> OCR = new HashMap<>();
        OCR.put(0, 星19);
        OCR.put(0, 星20);
        OCR.put(0, 星12);
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
        nonyuTsuchiShoKiJoho.setOcrid(OCRID);
        nonyuTsuchiShoKiJoho.setOcr(OCR);
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

        RString OCRID = RString.EMPTY;
        Map<Integer, RString> OCR = new HashMap<>();
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
        nonyuTsuchiShoKiJoho.setOcrid(OCRID);
        nonyuTsuchiShoKiJoho.setOcr(OCR);
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

    private FuriKaeAriCoverToNofushoItem edit口振依頼あり通知書() {

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
            } else if (index == 1) {
                納入通知書期情報二番目 = 納入通知書期情報リスト.get(index);
            } else if (index == 2) {
                納入通知書期情報三番目 = 納入通知書期情報リスト.get(index);
            } else if (index == 3) {
                納入通知書期情報四番目 = 納入通知書期情報リスト.get(index);
            } else if (index == 4) {
                納入通知書期情報五番目 = 納入通知書期情報リスト.get(index);
            } else if (index == 5) {
                納入通知書期情報六番目 = 納入通知書期情報リスト.get(index);
            } else if (index == 6) {
                納入通知書期情報七番目 = 納入通知書期情報リスト.get(index);
            } else if (index == 7) {
                納入通知書期情報八番目 = 納入通知書期情報リスト.get(index);
            } else if (index == 8) {
                納入通知書期情報九番目 = 納入通知書期情報リスト.get(index);
            } else if (index == 9) {
                納入通知書期情報十番目 = 納入通知書期情報リスト.get(index);
            }
        }

        // レイヤ１
        RString ari_titleNendo = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get調定年度_年度なし());
        RString ari_titleNendoBun = RString.EMPTY;
        RString ari_HyojicodeName1 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名１();
        RString ari_HyojicodeName2 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名２();
        RString ari_HyojicodeName3 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名３();
        RString ari_Hyojicode1 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード１();
        RString ari_Hyojicode2 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名２();
        RString ari_Hyojicode3 = 通知書情報.get編集後本算定通知書共通情報().get表示コード().get表示コード名３();
        RString ari_tsuchishoNo = 通知書情報.get編集後本算定通知書共通情報().get通知書番号().getColumnValue();
        RString ari_setaiCode;
        try {
            ari_setaiCode = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get世帯コード().getColumnValue();
        } catch (Exception e) {
            ari_setaiCode = RString.EMPTY;
        }
        RString ari_bankCode;
        try {
            ari_bankCode = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get金融機関コードCombinedWith支店コード();
        } catch (Exception e) {
            ari_bankCode = RString.EMPTY;
        }
        RString ari_kozaShurui;
        try {
            ari_kozaShurui = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get口座種別略称();
        } catch (Exception e) {
            ari_kozaShurui = RString.EMPTY;
        }
        RString ari_kozaNo;
        try {
            ari_kozaNo = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get口座番号Or通帳記号番号();
        } catch (Exception e) {
            ari_kozaNo = RString.EMPTY;
        }
        RString ari_bankName;
        try {
            ari_bankName = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get金融機関名CombinedWith支店名();
        } catch (Exception e) {
            ari_bankName = RString.EMPTY;
        }
        RString ari_kozaMeiginin;
        try {
            ari_kozaMeiginin = 通知書情報.get編集後本算定通知書共通情報().get編集後口座().get口座名義人漢字優先(); // TODO QA get口座名義人()
        } catch (Exception e) {
            ari_kozaMeiginin = RString.EMPTY;
        }

        RString ari_pagerenban1;
        if (ShoriKubun.バッチ.getコード().equals(通知書情報.get処理区分().getコード())) {
            ari_pagerenban1 = RString.EMPTY; // TODO 連番　＋　"-1"
        } else {
            ari_pagerenban1 = new RString("1-1");
        }
        RString ari_keisanMeisaishoNendo = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get調定年度_年度なし());
        RString ari_keisanMeisaishoNendoBun = RString.EMPTY;
        RString ari_keisanMeisaishoKi1 = 納入通知書期情報一番目.get期表記();
        RString ari_keisanMeisaishoTsuki1 = 納入通知書期情報一番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi1 = 納入通知書期情報一番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo1 = 納入通知書期情報一番目.get納期終了日表記();
        RString ari_keisanMeisaishoKi2 = 納入通知書期情報二番目.get期表記();
        RString ari_keisanMeisaishoTsuki2 = 納入通知書期情報二番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi2 = 納入通知書期情報二番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo2 = 納入通知書期情報二番目.get納期終了日表記();
        RString ari_keisanMeisaishoKi3 = 納入通知書期情報三番目.get期表記();
        RString ari_keisanMeisaishoTsuki3 = 納入通知書期情報三番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi3 = 納入通知書期情報三番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo3 = 納入通知書期情報三番目.get納期終了日表記();
        RString ari_keisanMeisaishoKi4 = 納入通知書期情報四番目.get期表記();
        RString ari_keisanMeisaishoTsuki4 = 納入通知書期情報四番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi4 = 納入通知書期情報四番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo4 = 納入通知書期情報四番目.get納期終了日表記();
        RString ari_keisanMeisaishoKi5 = 納入通知書期情報五番目.get期表記();
        RString ari_keisanMeisaishoTsuki5 = 納入通知書期情報五番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi5 = 納入通知書期情報五番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo5 = 納入通知書期情報五番目.get納期終了日表記();
        RString ari_keisanMeisaishoKi6 = 納入通知書期情報六番目.get期表記();
        RString ari_keisanMeisaishoTsuki6 = 納入通知書期情報六番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi6 = 納入通知書期情報六番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo6 = 納入通知書期情報六番目.get納期終了日表記();
        RString ari_keisanMeisaishoKi7 = 納入通知書期情報七番目.get期表記();
        RString ari_keisanMeisaishoTsuki7 = 納入通知書期情報七番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi7 = 納入通知書期情報七番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo7 = 納入通知書期情報七番目.get納期終了日表記();
        RString ari_keisanMeisaishoKi8 = 納入通知書期情報八番目.get期表記();
        RString ari_keisanMeisaishoTsuki8 = 納入通知書期情報八番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi8 = 納入通知書期情報八番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo8 = 納入通知書期情報八番目.get納期終了日表記();
        RString ari_keisanMeisaishoKi9 = 納入通知書期情報九番目.get期表記();
        RString ari_keisanMeisaishoTsuki9 = 納入通知書期情報九番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi9 = 納入通知書期情報九番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo9 = 納入通知書期情報九番目.get納期終了日表記();
        RString ari_keisanMeisaishoKi10 = 納入通知書期情報十番目.get期表記();
        RString ari_keisanMeisaishoTsuki10 = 納入通知書期情報十番目.get月表記();
        RString ari_keisanMeisaishoNokigenKaishi10 = 納入通知書期情報十番目.get納期開始日表記();
        RString ari_keisanMeisaishoNokigenShuryo10 = 納入通知書期情報十番目.get納期終了日表記();
        RString ari_keisanMeisaishoTsuchishoNo;
        try {
            ari_keisanMeisaishoTsuchishoNo = 通知書情報.get編集後本算定通知書共通情報().get通知書番号().getColumnValue();
        } catch (Exception e) {
            ari_keisanMeisaishoTsuchishoNo = RString.EMPTY;
        }
        RString ari_kaisanMeisaishoHihokenshaName;
        try {
            ari_kaisanMeisaishoHihokenshaName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().getColumnValue();
        } catch (Exception e) {
            ari_kaisanMeisaishoHihokenshaName = RString.EMPTY;
        }
        RString ari_keisanMeisaishoSetaiCode = RString.EMPTY;
        try {
            ari_keisanMeisaishoSetaiCode = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get世帯コード().getColumnValue();
        } catch (Exception e) {
            ari_kaisanMeisaishoHihokenshaName = RString.EMPTY;
        }
        RString ari_kaisanMeisaishoSetaiNushiName;
        try {
            ari_kaisanMeisaishoSetaiNushiName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get世帯主名().getColumnValue();
        } catch (Exception e) {
            ari_kaisanMeisaishoSetaiNushiName = RString.EMPTY;
        }
        RString ari_keisanMeisaishoKaishiKi = RString.EMPTY;
        try {
            ari_keisanMeisaishoKaishiKi = 通知書情報.get編集後本算定通知書共通情報().get更正後().get期間_自();
        } catch (Exception e) {
            ari_kaisanMeisaishoSetaiNushiName = RString.EMPTY;
        }
        RString ari_kaisanMeisaishoShuryoKi;
        try {
            ari_kaisanMeisaishoShuryoKi = 通知書情報.get編集後本算定通知書共通情報().get更正後().get期間_至();
        } catch (Exception e) {
            ari_kaisanMeisaishoShuryoKi = RString.EMPTY;
        }
        RString ari_keisanMeisaishoShotokuDankai;
        try {
            ari_keisanMeisaishoShotokuDankai = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get更正後().get保険料段階());
        } catch (Exception e) {
            ari_keisanMeisaishoShotokuDankai = RString.EMPTY;
        }

        IKingakuFormatter 保険料率formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get保険料率());
        RString ari_kaisanHokenryoRitsu = new RString(保険料率formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        IKingakuFormatter 減免前保険料_年額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get減免前保険料_年額());
        RString ari_keisanMeisaishoCalHokenryoGaku = new RString(減免前保険料_年額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
        RString ari_keisanMeisaishoTsukiSu = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get更正後().get月数_ケ月());

        IKingakuFormatter 減免額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get減免額());
        RString ari_keisanMeisaishoGenmenGaku = new RString(減免額formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        IKingakuFormatter 特別徴収額合計formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get特別徴収額合計());
        RString ari_keisanMeisaishoTokuchoGokeiGaku = new RString(特別徴収額合計formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        IKingakuFormatter 普通徴収額合計formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get普通徴収額合計());
        RString ari_kaisanMeisaishoFuchoGokeiGaku = new RString(普通徴収額合計formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        RString ari_kaisanMeisaishoNofuZumiGaku = RString.EMPTY;
        RString ari_keisanMeisaishoKongoNofuGaku = RString.EMPTY;
        if (通知書情報.get本算定納入通知書制御情報() != null
                && 通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get納付額算出方法() != null
                && NofugakuSanshutsuHoho.収入額をもとに算出.getコード().equals(通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get納付額算出方法().getコード())) {
            IKingakuFormatter 普徴納付済額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get普徴納付済額_未到来期含む());
            IKingakuFormatter 普徴今後納付すべき額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get普徴今後納付すべき額_調定元に());
            ari_kaisanMeisaishoNofuZumiGaku = new RString(普徴納付済額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            ari_keisanMeisaishoKongoNofuGaku = new RString(普徴今後納付すべき額formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        } else if (通知書情報.get本算定納入通知書制御情報() != null
                && 通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get納付額算出方法() != null
                && NofugakuSanshutsuHoho.調定額をもとに算出.getコード().equals(通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get納付額算出方法().getコード())) {
            IKingakuFormatter 普徴既に納付すべき額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get普徴既に納付すべき額());
            IKingakuFormatter 普徴今後納付すべき額formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get普徴今後納付すべき額_収入元に());
            ari_kaisanMeisaishoNofuZumiGaku = new RString(普徴既に納付すべき額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            ari_keisanMeisaishoKongoNofuGaku = new RString(普徴今後納付すべき額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
        }
        RString ari_keisanMeisaishoKiTitle1 = new RString(String.format(FORMAT_第XX期.toString(), 納入通知書期情報一番目.get期()));
        RString ari_keisanMeisaishoKibetsuNofuGaku1 = 納入通知書期情報一番目.get調定額表記();
        RString ari_yen1 = 円;
        RString ari_keisanMeisaishoKiTitle3 = RString.EMPTY;
        RString ari_keisanMeisaishoKibetsuNofuGaku3 = RString.EMPTY;
        if (納入通知書期情報二番目.get期() != 0) {
            ari_keisanMeisaishoKiTitle3 = 次期以降;
            ari_keisanMeisaishoKibetsuNofuGaku3 = 納入通知書期情報二番目.get調定額表記();
        }
        RString ari_yen2 = 円;
        RString ari_keisanMeisaishoKiTitle2 = RString.EMPTY;
        RString ari_gekihenTitle = RString.EMPTY;
        RString ari_keisanMeisaishoKibetsuNofuGaku2 = RString.EMPTY;
        RString ari_yen3 = 円;
        RString ari_keisanMeisaishoKiTitle4 = RString.EMPTY;
        RString ari_gekihenMongon = RString.EMPTY;
        RString ari_keisanMeisaishoKibetsuNofuGaku4 = RString.EMPTY;
        RString ari_yen4 = 円;
        RString ari_keisanmeisaishoNendo2 = 通知書情報.get編集後本算定通知書共通情報().get賦課年度_年度なし();
        IKingakuFormatter 確定保険料formatter = KingakuFormatter.create(通知書情報.get編集後本算定通知書共通情報().get更正後().get確定保険料_年額());
        RString ari_keisanMeisaishoHokenryoGokeiGaku = new RString(確定保険料formatter.format(KingakuUnit.円).setCommaSeparated().toString());

        RString ari_pagerenban2;
        if (ShoriKubun.バッチ.getコード().equals(通知書情報.get処理区分().getコード())) {
            ari_pagerenban2 = RString.EMPTY; // TODO 連番　＋　"-2"
        } else {
            ari_pagerenban2 = new RString("1-2");
        }
        RString ari_nokibetsuMeisaishoNendo = RStringUtil.convert半角to全角(通知書情報.get編集後本算定通知書共通情報().get調定年度_年度なし());
        RString ari_nokibetsuMeisaishoNendoBun = RString.EMPTY;
        RString ari_nokibetsuMeisaishoTsuchishoNo = 通知書情報.get編集後本算定通知書共通情報().get通知書番号().getColumnValue();
        RString ari_nokibetsuMeisaishoSetaiCode;
        try {
            ari_nokibetsuMeisaishoSetaiCode = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get世帯コード().getColumnValue();
        } catch (Exception e) {
            ari_nokibetsuMeisaishoSetaiCode = RString.EMPTY;
        }
        RString ari_nokibetsuMeisaishoHohokenshaName = RString.EMPTY;
        try {
            ari_nokibetsuMeisaishoHohokenshaName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().getColumnValue();
        } catch (Exception e) {
            ari_nokibetsuMeisaishoSetaiCode = RString.EMPTY;
        }

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
        Decimal 納期別明細書特徴納付済額１ = 収入額１.get収入額() == null ? new Decimal(0) : 収入額１.get収入額();
        Decimal 納期別明細書特徴納付済額２ = 収入額２.get収入額() == null ? new Decimal(0) : 収入額２.get収入額();
        Decimal 納期別明細書特徴納付済額３ = 収入額３.get収入額() == null ? new Decimal(0) : 収入額３.get収入額();

        Decimal 納期別明細書特徴差額１ = 納期別明細書特徴納付額１.subtract(納期別明細書特徴納付済額１);
        Decimal 納期別明細書特徴差額２ = 納期別明細書特徴納付額２.subtract(納期別明細書特徴納付済額２);
        Decimal 納期別明細書特徴差額３ = 納期別明細書特徴納付額３.subtract(納期別明細書特徴納付済額３);

        RString ari_nokibetsuMeisaishoTokuchoNofuGaku1 = new RString(KingakuFormatter.create(納期別明細書特徴納付額１).format(KingakuUnit.円).setCommaSeparated().toString());
        RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku1 = new RString(KingakuFormatter.create(納期別明細書特徴納付済額１).format(KingakuUnit.円).setCommaSeparated().toString());
        RString ari_nokibetsuMeisaishoTokuchoSaGaku1 = new RString(KingakuFormatter.create(納期別明細書特徴差額１).format(KingakuUnit.円).setCommaSeparated().setSignPattern(Sign.プラス表示).toString());
        RString ari_nokibetsuMeisaishoTokuchoNofuGaku2 = new RString(KingakuFormatter.create(納期別明細書特徴納付額２).format(KingakuUnit.円).setCommaSeparated().toString());
        RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku2 = new RString(KingakuFormatter.create(納期別明細書特徴納付済額２).format(KingakuUnit.円).setCommaSeparated().toString());
        RString ari_nokibetsuMeisaishoTokuchoSaGaku2 = new RString(KingakuFormatter.create(納期別明細書特徴差額２).format(KingakuUnit.円).setCommaSeparated().setSignPattern(Sign.プラス表示).toString());
        RString ari_nokibetsuMeisaishoTokuchoNofuGaku3 = new RString(KingakuFormatter.create(納期別明細書特徴納付額３).format(KingakuUnit.円).setCommaSeparated().toString());
        RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku3 = new RString(KingakuFormatter.create(納期別明細書特徴差額３).format(KingakuUnit.円).setCommaSeparated().toString());
        RString ari_nokibetsuMeisaishoTokuchoSaGaku3 = new RString(KingakuFormatter.create(納期別明細書特徴差額３).format(KingakuUnit.円).setCommaSeparated().setSignPattern(Sign.プラス表示).toString());
        RString ari_nokibetsuMeisaishoTokuchoNofuGaku4 = new RString(KingakuFormatter.create(納期別明細書特徴納付額１.add(納期別明細書特徴納付額２).add(納期別明細書特徴納付額３)).format(KingakuUnit.円).setCommaSeparated().toString());
        RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku4 = new RString(KingakuFormatter.create(納期別明細書特徴納付済額１.add(納期別明細書特徴納付済額２).add(納期別明細書特徴納付済額３)).format(KingakuUnit.円).setCommaSeparated().toString());
        RString ari_nokibetsuMeisaishoTokuchoSaGaku4 = new RString(KingakuFormatter.create(納期別明細書特徴差額１.add(納期別明細書特徴差額２).add(納期別明細書特徴差額３)).format(KingakuUnit.円).setCommaSeparated().setSignPattern(Sign.プラス表示).toString());
        RString ari_nokibetsuMeisaishoKi1 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報一番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku1 = 納入通知書期情報一番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku1 = 納入通知書期情報一番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku1 = 納入通知書期情報一番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen1 = 納入通知書期情報一番目.get納期限表記();
        RString ari_nokibetsuMeisaishoKi2 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報二番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku2 = 納入通知書期情報二番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku2 = 納入通知書期情報二番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku2 = 納入通知書期情報二番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen2 = 納入通知書期情報二番目.get納期限表記();
        RString ari_nokibetsuMeisaishoKi3 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報三番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku3 = 納入通知書期情報三番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku3 = 納入通知書期情報三番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku3 = 納入通知書期情報三番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen3 = 納入通知書期情報三番目.get納期限表記();
        RString ari_nokibetsuMeisaishoKi4 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報四番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku4 = 納入通知書期情報四番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku4 = 納入通知書期情報四番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku4 = 納入通知書期情報四番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen4 = 納入通知書期情報四番目.get納期限表記();
        RString ari_nokibetsuMeisaishoKi5 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報五番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku5 = 納入通知書期情報五番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku5 = 納入通知書期情報五番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku5 = 納入通知書期情報五番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen5 = 納入通知書期情報五番目.get納期限表記();
        RString ari_nokibetsuMeisaishoKi6 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報六番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku6 = 納入通知書期情報六番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku6 = 納入通知書期情報六番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku6 = 納入通知書期情報六番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen6 = 納入通知書期情報六番目.get納期限表記();
        RString ari_nokibetsuMeisaishoKi7 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報七番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku7 = 納入通知書期情報七番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku7 = 納入通知書期情報七番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku7 = 納入通知書期情報七番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen7 = 納入通知書期情報七番目.get納期限表記();
        RString ari_nokibetsuMeisaishoKi8 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報八番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku8 = 納入通知書期情報八番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku8 = 納入通知書期情報八番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku8 = 納入通知書期情報八番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen8 = 納入通知書期情報八番目.get納期限表記();
        RString ari_nokibetsuMeisaishoKi9 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報九番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku9 = 納入通知書期情報九番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku9 = 納入通知書期情報九番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku9 = 納入通知書期情報九番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen9 = 納入通知書期情報九番目.get納期限表記();
        RString ari_nokibetsuMeisaishoKi10 = new RString(String.format(FORMAT_第X期.toString(), 納入通知書期情報十番目.get期表記()));
        RString ari_nokibetsuMeisaishoFuchoNofuGaku10 = 納入通知書期情報十番目.get調定額表記();
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku10 = 納入通知書期情報十番目.get収入額表記();
        RString ari_nokibetsuMeisaishoFuchoSaGaku10 = 納入通知書期情報十番目.get差額表記();
        RString ari_nokibetsuMeisaishoNokigen10 = 納入通知書期情報十番目.get納期限表記();
        RString ari_nokibetsuMeisaishoFuchoNofuGaku11 = new RString(納入通知書期情報一番目.get調定額表記().concat(納入通知書期情報二番目.get調定額表記()).
                concat(納入通知書期情報三番目.get調定額表記()).concat(納入通知書期情報四番目.get調定額表記()).concat(納入通知書期情報五番目.get調定額表記()).
                concat(納入通知書期情報六番目.get調定額表記()).concat(納入通知書期情報七番目.get調定額表記()).concat(納入通知書期情報八番目.get調定額表記()).
                concat(納入通知書期情報九番目.get調定額表記()).concat(納入通知書期情報十番目.get調定額表記()).toString());
        RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku11 = new RString(納入通知書期情報一番目.get収入額表記().concat(納入通知書期情報二番目.get収入額表記()).
                concat(納入通知書期情報三番目.get収入額表記()).concat(納入通知書期情報四番目.get収入額表記()).concat(納入通知書期情報五番目.get収入額表記()).
                concat(納入通知書期情報六番目.get収入額表記()).concat(納入通知書期情報七番目.get収入額表記()).concat(納入通知書期情報八番目.get収入額表記()).
                concat(納入通知書期情報九番目.get収入額表記()).concat(納入通知書期情報十番目.get収入額表記()).toString());
        RString ari_nokibetsuMeisaishoFuchoSaGaku11 = new RString(納入通知書期情報一番目.get差額表記().concat(納入通知書期情報二番目.get差額表記()).
                concat(納入通知書期情報三番目.get差額表記()).concat(納入通知書期情報四番目.get差額表記()).concat(納入通知書期情報五番目.get差額表記()).
                concat(納入通知書期情報六番目.get差額表記()).concat(納入通知書期情報七番目.get差額表記()).concat(納入通知書期情報八番目.get差額表記()).
                concat(納入通知書期情報九番目.get差額表記()).concat(納入通知書期情報十番目.get差額表記()).toString());

        RString ari_pagerenban3;
        if (ShoriKubun.バッチ.getコード().equals(通知書情報.get処理区分().getコード())) {
            ari_pagerenban3 = RString.EMPTY; // TODO 連番　＋　"-3"
        } else {
            ari_pagerenban3 = new RString("1-3");
        }

        RString ari_kozaIraishoLeftJusho = RString.EMPTY;
        RString ari_kozaIraishoRightJusho = RString.EMPTY;
        RString ari_kozaIraishoLeftHihokenshaName = RString.EMPTY;
        RString ari_kozaIraishoRightHihokenshaName = RString.EMPTY;
        if (通知書情報.get編集後本算定通知書共通情報().get編集後個人() != null) {
            ari_kozaIraishoLeftJusho = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get編集後住所();
            ari_kozaIraishoRightJusho = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get編集後住所();
            ari_kozaIraishoLeftHihokenshaName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().getColumnValue();
            ari_kozaIraishoRightHihokenshaName = 通知書情報.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().getColumnValue();
        }

        RString ari_kozaIraishoLeftShikibetsuCode = 通知書情報.get編集後本算定通知書共通情報().get識別コード().getColumnValue();
        RString ari_kozaIraishoRightShikibetsuCode = 通知書情報.get編集後本算定通知書共通情報().get識別コード().getColumnValue();

        RString ari_pagerenban4;
        if (ShoriKubun.バッチ.getコード().equals(通知書情報.get処理区分().getコード())) {
            ari_pagerenban4 = RString.EMPTY; // TODO 連番　＋　"-4"
        } else {
            ari_pagerenban4 = new RString("1-4");
        }
        RString ari_renban = RString.EMPTY; // TODO 通知書番号単位に、1から順番で採番する？
        RString ari_hokenshaName = 通知書情報.get編集後本算定通知書共通情報().get保険者名();

        // CompNinshosha
        RString ari_denshiKoin = ninshoshaSource.denshiKoin;
        RString ari_hakkoYMD = ninshoshaSource.hakkoYMD;
        RString ari_ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        RString ari_ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        RString ari_ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        RString ari_koinMojiretsu = ninshoshaSource.koinMojiretsu;
        RString ari_ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        RString ari_ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        RString ari_koinShoryaku = ninshoshaSource.koinShoryaku;
        // CompSofubutsuAtesaki
        SofubutsuAtesakiSource sofubutsuAtesakiSource = 通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource().get送付物宛先ソース();
        RString ari_customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        RString ari_dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        RString ari_gyoseiku = sofubutsuAtesakiSource.gyoseiku;
        RString ari_jusho1 = sofubutsuAtesakiSource.jusho1;
        RString ari_jusho2 = sofubutsuAtesakiSource.jusho2;
        RString ari_jusho3 = sofubutsuAtesakiSource.jusho3;
        RString ari_jushoText = sofubutsuAtesakiSource.jushoText;
        RString ari_kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        RString ari_kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        RString ari_kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        RString ari_kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        RString ari_katagaki1 = sofubutsuAtesakiSource.katagaki1;
        RString ari_katagaki2 = sofubutsuAtesakiSource.katagaki2;
        RString ari_katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        RString ari_katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        RString ari_katagakiText = sofubutsuAtesakiSource.katagakiText;
        RString ari_meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        RString ari_meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        RString ari_samaBun1 = sofubutsuAtesakiSource.samaBun1;
        RString ari_samaBun2 = sofubutsuAtesakiSource.samaBun2;
        RString ari_samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        RString ari_samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        RString ari_samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        RString ari_samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        RString ari_samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        RString ari_shimei1 = sofubutsuAtesakiSource.shimei1;
        RString ari_shimei2 = sofubutsuAtesakiSource.shimei2;
        RString ari_shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        RString ari_shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        RString ari_shimeiText = sofubutsuAtesakiSource.shimeiText;
        RString ari_yubinNo = sofubutsuAtesakiSource.yubinNo;

        FuriKaeAriCoverToNofushoItem item = new FuriKaeAriCoverToNofushoItem();
        item.setLayoutBreakItem(1);
        item.setAri_keisanMeisaishoNendo(ari_keisanMeisaishoNendo);
        item.setAri_keisanMeisaishoNendoBun(ari_keisanMeisaishoNendoBun);
        item.setAri_titleNendo(ari_titleNendo);
        item.setAri_titleNendoBun(ari_titleNendoBun);
        item.setAri_HyojicodeName1(ari_HyojicodeName1);
        item.setAri_HyojicodeName2(ari_HyojicodeName2);
        item.setAri_HyojicodeName3(ari_HyojicodeName3);
        item.setAri_Hyojicode1(ari_Hyojicode1);
        item.setAri_Hyojicode2(ari_Hyojicode2);
        item.setAri_Hyojicode3(ari_Hyojicode3);
        item.setAri_keisanMeisaishoKi1(ari_keisanMeisaishoKi1);
        item.setAri_keisanMeisaishoNokigenKaishi1(ari_keisanMeisaishoNokigenKaishi1);
        item.setAri_kaisanMeisaishoHihokenshaName(ari_kaisanMeisaishoHihokenshaName);
        item.setAri_kaisanMeisaishoSetaiNushiName(ari_kaisanMeisaishoSetaiNushiName);
        item.setAri_keisanMeisaishoTsuchishoNo(ari_keisanMeisaishoTsuchishoNo);
        item.setAri_keisanMeisaishoSetaiCode(ari_keisanMeisaishoSetaiCode);
        item.setAri_keisanMeisaishoTsuki1(ari_keisanMeisaishoTsuki1);
        item.setAri_keisanMeisaishoNokigenShuryo1(ari_keisanMeisaishoNokigenShuryo1);
        item.setAri_keisanMeisaishoKi2(ari_keisanMeisaishoKi2);
        item.setAri_keisanMeisaishoNokigenKaishi2(ari_keisanMeisaishoNokigenKaishi2);
        item.setAri_keisanMeisaishoTsuki2(ari_keisanMeisaishoTsuki2);
        item.setAri_keisanMeisaishoNokigenShuryo2(ari_keisanMeisaishoNokigenShuryo2);
        item.setAri_tsuchishoNo(ari_tsuchishoNo);
        item.setAri_setaiCode(ari_setaiCode);
        item.setAri_keisanMeisaishoKi3(ari_keisanMeisaishoKi3);
        item.setAri_keisanMeisaishoNokigenKaishi3(ari_keisanMeisaishoNokigenKaishi3);
        item.setAri_keisanMeisaishoKaishiKi(ari_keisanMeisaishoKaishiKi);
        item.setAri_keisanMeisaishoTsuki3(ari_keisanMeisaishoTsuki3);
        item.setAri_keisanMeisaishoNokigenShuryo3(ari_keisanMeisaishoNokigenShuryo3);
        item.setAri_keisanMeisaishoTsukiSu(ari_keisanMeisaishoTsukiSu);
        item.setAri_kaisanMeisaishoShuryoKi(ari_kaisanMeisaishoShuryoKi);
        item.setAri_keisanMeisaishoKi4(ari_keisanMeisaishoKi4);
        item.setAri_keisanMeisaishoNokigenKaishi4(ari_keisanMeisaishoNokigenKaishi4);
        item.setAri_bankCode(ari_bankCode);
        item.setAri_kozaShurui(ari_kozaShurui);
        item.setAri_kozaNo(ari_kozaNo);
        item.setAri_keisanMeisaishoTsuki4(ari_keisanMeisaishoTsuki4);
        item.setAri_keisanMeisaishoNokigenShuryo4(ari_keisanMeisaishoNokigenShuryo4);
        item.setAri_keisanMeisaishoShotokuDankai(ari_keisanMeisaishoShotokuDankai);
        item.setAri_kaisanHokenryoRitsu(ari_kaisanHokenryoRitsu);
        item.setAri_keisanMeisaishoKi5(ari_keisanMeisaishoKi5);
        item.setAri_keisanMeisaishoNokigenKaishi5(ari_keisanMeisaishoNokigenKaishi5);
        item.setAri_keisanMeisaishoTsuki5(ari_keisanMeisaishoTsuki5);
        item.setAri_keisanMeisaishoNokigenShuryo5(ari_keisanMeisaishoNokigenShuryo5);
        item.setAri_keisanMeisaishoCalHokenryoGaku(ari_keisanMeisaishoCalHokenryoGaku);
        item.setAri_keisanMeisaishoGenmenGaku(ari_keisanMeisaishoGenmenGaku);
        item.setAri_bankName(ari_bankName);
        item.setAri_keisanMeisaishoKi6(ari_keisanMeisaishoKi6);
        item.setAri_keisanMeisaishoNokigenKaishi6(ari_keisanMeisaishoNokigenKaishi6);
        item.setAri_keisanMeisaishoTsuki6(ari_keisanMeisaishoTsuki6);
        item.setAri_keisanMeisaishoNokigenShuryo6(ari_keisanMeisaishoNokigenShuryo6);
        item.setAri_keisanMeisaishoTokuchoGokeiGaku(ari_keisanMeisaishoTokuchoGokeiGaku);
        item.setAri_kaisanMeisaishoFuchoGokeiGaku(ari_kaisanMeisaishoFuchoGokeiGaku);
        item.setAri_keisanMeisaishoKi7(ari_keisanMeisaishoKi7);
        item.setAri_keisanMeisaishoNokigenKaishi7(ari_keisanMeisaishoNokigenKaishi7);
        item.setAri_kozaMeiginin(ari_kozaMeiginin);
        item.setAri_keisanMeisaishoTsuki7(ari_keisanMeisaishoTsuki7);
        item.setAri_keisanMeisaishoNokigenShuryo7(ari_keisanMeisaishoNokigenShuryo7);
        item.setAri_kaisanMeisaishoNofuZumiGaku(ari_kaisanMeisaishoNofuZumiGaku);
        item.setAri_keisanMeisaishoKongoNofuGaku(ari_keisanMeisaishoKongoNofuGaku);
        item.setAri_keisanMeisaishoKi8(ari_keisanMeisaishoKi8);
        item.setAri_keisanMeisaishoNokigenKaishi8(ari_keisanMeisaishoNokigenKaishi8);
        item.setAri_yen1(ari_yen1);
        item.setAri_yen2(ari_yen2);
        item.setAri_keisanMeisaishoTsuki8(ari_keisanMeisaishoTsuki8);
        item.setAri_keisanMeisaishoNokigenShuryo8(ari_keisanMeisaishoNokigenShuryo8);
        item.setAri_keisanMeisaishoKiTitle1(ari_keisanMeisaishoKiTitle1);
        item.setAri_keisanMeisaishoKibetsuNofuGaku1(ari_keisanMeisaishoKibetsuNofuGaku1);
        item.setAri_keisanMeisaishoKiTitle3(ari_keisanMeisaishoKiTitle3);
        item.setAri_keisanMeisaishoKibetsuNofuGaku3(ari_keisanMeisaishoKibetsuNofuGaku3);
        item.setAri_keisanMeisaishoKi9(ari_keisanMeisaishoKi9);
        item.setAri_keisanMeisaishoNokigenKaishi9(ari_keisanMeisaishoNokigenKaishi9);
        item.setAri_yen3(ari_yen3);
        item.setAri_yen4(ari_yen4);
        item.setAri_keisanMeisaishoTsuki9(ari_keisanMeisaishoTsuki9);
        item.setAri_keisanMeisaishoNokigenShuryo9(ari_keisanMeisaishoNokigenShuryo9);
        item.setAri_keisanMeisaishoKiTitle2(ari_keisanMeisaishoKiTitle2);
        item.setAri_gekihenTitle(ari_gekihenTitle);
        item.setAri_keisanMeisaishoKibetsuNofuGaku2(ari_keisanMeisaishoKibetsuNofuGaku2);
        item.setAri_keisanMeisaishoKiTitle4(ari_keisanMeisaishoKiTitle4);
        item.setAri_gekihenMongon(ari_gekihenMongon);
        item.setAri_keisanMeisaishoKibetsuNofuGaku4(ari_keisanMeisaishoKibetsuNofuGaku4);
        item.setAri_keisanMeisaishoKi10(ari_keisanMeisaishoKi10);
        item.setAri_keisanMeisaishoNokigenKaishi10(ari_keisanMeisaishoNokigenKaishi10);
        item.setAri_keisanmeisaishoNendo2(ari_keisanmeisaishoNendo2);
        item.setAri_keisanMeisaishoTsuki10(ari_keisanMeisaishoTsuki10);
        item.setAri_keisanMeisaishoNokigenShuryo10(ari_keisanMeisaishoNokigenShuryo10);
        item.setAri_keisanMeisaishoHokenryoGokeiGaku(ari_keisanMeisaishoHokenryoGokeiGaku);
        item.setAri_pagerenban1(ari_pagerenban1);
        item.setAri_pagerenban2(ari_pagerenban2);
        item.setAri_nokibetsuMeisaishoNendo(ari_nokibetsuMeisaishoNendo);
        item.setAri_nokibetsuMeisaishoNendoBun(ari_nokibetsuMeisaishoNendoBun);
        item.setAri_kozaIraishoLeftJusho(ari_kozaIraishoLeftJusho);
        item.setAri_kozaIraishoRightJusho(ari_kozaIraishoRightJusho);
        item.setAri_nokibetsuMeisaishoTokuchoNofuGaku1(ari_nokibetsuMeisaishoTokuchoNofuGaku1);
        item.setAri_nokibetsuMeisaishoTokuchoNofuZumiGaku1(ari_nokibetsuMeisaishoTokuchoNofuZumiGaku1);
        item.setAri_nokibetsuMeisaishoTsuchishoNo(ari_nokibetsuMeisaishoTsuchishoNo);
        item.setAri_nokibetsuMeisaishoSetaiCode(ari_nokibetsuMeisaishoSetaiCode);
        item.setAri_nokibetsuMeisaishoTokuchoSaGaku1(ari_nokibetsuMeisaishoTokuchoSaGaku1);
        item.setAri_nokibetsuMeisaishoTokuchoNofuGaku2(ari_nokibetsuMeisaishoTokuchoNofuGaku2);
        item.setAri_nokibetsuMeisaishoTokuchoNofuZumiGaku2(ari_nokibetsuMeisaishoTokuchoNofuZumiGaku2);
        item.setAri_nokibetsuMeisaishoTokuchoSaGaku2(ari_nokibetsuMeisaishoTokuchoSaGaku2);
        item.setAri_kozaIraishoLeftHihokenshaName(ari_kozaIraishoLeftHihokenshaName);
        item.setAri_kozaIraishoRightHihokenshaName(ari_kozaIraishoRightHihokenshaName);
        item.setAri_nokibetsuMeisaishoHohokenshaName(ari_nokibetsuMeisaishoHohokenshaName);
        item.setAri_nokibetsuMeisaishoTokuchoNofuGaku3(ari_nokibetsuMeisaishoTokuchoNofuGaku3);
        item.setAri_nokibetsuMeisaishoTokuchoNofuZumiGaku3(ari_nokibetsuMeisaishoTokuchoNofuZumiGaku3);
        item.setAri_nokibetsuMeisaishoTokuchoSaGaku3(ari_nokibetsuMeisaishoTokuchoSaGaku3);
        item.setAri_nokibetsuMeisaishoTokuchoNofuGaku4(ari_nokibetsuMeisaishoTokuchoNofuGaku4);
        item.setAri_nokibetsuMeisaishoTokuchoNofuZumiGaku4(ari_nokibetsuMeisaishoTokuchoNofuZumiGaku4);
        item.setAri_nokibetsuMeisaishoTokuchoSaGaku4(ari_nokibetsuMeisaishoTokuchoSaGaku4);
        item.setAri_kozaIraishoLeftShikibetsuCode(ari_kozaIraishoLeftShikibetsuCode);
        item.setAri_kozaIraishoRightShikibetsuCode(ari_kozaIraishoRightShikibetsuCode);
        item.setAri_nokibetsuMeisaishoKi1(ari_nokibetsuMeisaishoKi1);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku1(ari_nokibetsuMeisaishoFuchoNofuGaku1);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku1(ari_nokibetsuMeisaishoFuchoNofuZumiGaku1);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku1(ari_nokibetsuMeisaishoFuchoSaGaku1);
        item.setAri_nokibetsuMeisaishoNokigen1(ari_nokibetsuMeisaishoNokigen1);
        item.setAri_nokibetsuMeisaishoKi2(ari_nokibetsuMeisaishoKi2);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku2(ari_nokibetsuMeisaishoFuchoNofuGaku2);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku2(ari_nokibetsuMeisaishoFuchoNofuZumiGaku2);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku2(ari_nokibetsuMeisaishoFuchoSaGaku2);
        item.setAri_nokibetsuMeisaishoNokigen2(ari_nokibetsuMeisaishoNokigen2);
        item.setAri_nokibetsuMeisaishoKi3(ari_nokibetsuMeisaishoKi3);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku3(ari_nokibetsuMeisaishoFuchoNofuGaku3);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku3(ari_nokibetsuMeisaishoFuchoNofuZumiGaku3);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku3(ari_nokibetsuMeisaishoFuchoSaGaku3);
        item.setAri_nokibetsuMeisaishoNokigen3(ari_nokibetsuMeisaishoNokigen3);
        item.setAri_nokibetsuMeisaishoKi4(ari_nokibetsuMeisaishoKi4);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku4(ari_nokibetsuMeisaishoFuchoNofuGaku4);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku4(ari_nokibetsuMeisaishoFuchoNofuZumiGaku4);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku4(ari_nokibetsuMeisaishoFuchoSaGaku4);
        item.setAri_nokibetsuMeisaishoNokigen4(ari_nokibetsuMeisaishoNokigen4);
        item.setAri_nokibetsuMeisaishoKi5(ari_nokibetsuMeisaishoKi5);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku5(ari_nokibetsuMeisaishoFuchoNofuGaku5);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku5(ari_nokibetsuMeisaishoFuchoNofuZumiGaku5);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku5(ari_nokibetsuMeisaishoFuchoSaGaku5);
        item.setAri_nokibetsuMeisaishoNokigen5(ari_nokibetsuMeisaishoNokigen5);
        item.setAri_nokibetsuMeisaishoKi6(ari_nokibetsuMeisaishoKi6);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku6(ari_nokibetsuMeisaishoFuchoNofuGaku6);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku6(ari_nokibetsuMeisaishoFuchoNofuZumiGaku6);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku6(ari_nokibetsuMeisaishoFuchoSaGaku6);
        item.setAri_nokibetsuMeisaishoNokigen6(ari_nokibetsuMeisaishoNokigen6);
        item.setAri_nokibetsuMeisaishoKi7(ari_nokibetsuMeisaishoKi7);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku7(ari_nokibetsuMeisaishoFuchoNofuGaku7);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku7(ari_nokibetsuMeisaishoFuchoNofuZumiGaku7);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku7(ari_nokibetsuMeisaishoFuchoSaGaku7);
        item.setAri_nokibetsuMeisaishoNokigen7(ari_nokibetsuMeisaishoNokigen7);
        item.setAri_nokibetsuMeisaishoKi8(ari_nokibetsuMeisaishoKi8);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku8(ari_nokibetsuMeisaishoFuchoNofuGaku8);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku8(ari_nokibetsuMeisaishoFuchoNofuZumiGaku8);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku8(ari_nokibetsuMeisaishoFuchoSaGaku8);
        item.setAri_nokibetsuMeisaishoNokigen8(ari_nokibetsuMeisaishoNokigen8);
        item.setAri_nokibetsuMeisaishoKi9(ari_nokibetsuMeisaishoKi9);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku9(ari_nokibetsuMeisaishoFuchoNofuGaku9);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku9(ari_nokibetsuMeisaishoFuchoNofuZumiGaku9);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku9(ari_nokibetsuMeisaishoFuchoSaGaku9);
        item.setAri_nokibetsuMeisaishoNokigen9(ari_nokibetsuMeisaishoNokigen9);
        item.setAri_nokibetsuMeisaishoKi10(ari_nokibetsuMeisaishoKi10);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku10(ari_nokibetsuMeisaishoFuchoNofuGaku10);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku10(ari_nokibetsuMeisaishoFuchoNofuZumiGaku10);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku10(ari_nokibetsuMeisaishoFuchoSaGaku10);
        item.setAri_nokibetsuMeisaishoNokigen10(ari_nokibetsuMeisaishoNokigen10);
        item.setAri_nokibetsuMeisaishoFuchoNofuGaku11(ari_nokibetsuMeisaishoFuchoNofuGaku11);
        item.setAri_nokibetsuMeisaishoFuchoNofuZumiGaku11(ari_nokibetsuMeisaishoFuchoNofuZumiGaku11);
        item.setAri_nokibetsuMeisaishoFuchoSaGaku11(ari_nokibetsuMeisaishoFuchoSaGaku11);
        item.setAri_renban(ari_renban);
        item.setAri_hokenshaName(ari_hokenshaName);
        item.setAri_pagerenban3(ari_pagerenban3);
        item.setAri_pagerenban4(ari_pagerenban4);

        // CompSofubutsuAtesakiのset処理
        item.setAri_yubinNo(ari_yubinNo);
        item.setAri_gyoseiku(ari_gyoseiku);
        item.setAri_jushoText(ari_jushoText);
        item.setAri_jusho3(ari_jusho3);
        item.setAri_jusho1(ari_jusho1);
        item.setAri_jusho2(ari_jusho2);
        item.setAri_katagakiText(ari_katagakiText);
        item.setAri_katagaki2(ari_katagaki2);
        item.setAri_katagakiSmall2(ari_katagakiSmall2);
        item.setAri_katagaki1(ari_katagaki1);
        item.setAri_katagakiSmall1(ari_katagakiSmall1);
        item.setAri_shimei2(ari_shimei2);
        item.setAri_shimeiSmall2(ari_shimeiSmall2);
        item.setAri_shimeiText(ari_shimeiText);
        item.setAri_meishoFuyo2(ari_meishoFuyo2);
        item.setAri_shimeiSmall1(ari_shimeiSmall1);
        item.setAri_dainoKubunMei(ari_dainoKubunMei);
        item.setAri_shimei1(ari_shimei1);
        item.setAri_meishoFuyo1(ari_meishoFuyo1);
        item.setAri_samabunShimeiText(ari_samabunShimeiText);
        item.setAri_samaBun2(ari_samaBun2);
        item.setAri_samabunShimeiSmall2(ari_samabunShimeiSmall2);
        item.setAri_kakkoLeft2(ari_kakkoLeft2);
        item.setAri_samabunShimei2(ari_samabunShimei2);
        item.setAri_kakkoRight2(ari_kakkoRight2);
        item.setAri_kakkoLeft1(ari_kakkoLeft1);
        item.setAri_samabunShimei1(ari_samabunShimei1);
        item.setAri_samaBun1(ari_samaBun1);
        item.setAri_kakkoRight1(ari_kakkoRight1);
        item.setAri_samabunShimeiSmall1(ari_samabunShimeiSmall1);
        item.setAri_customerBarCode(ari_customerBarCode);
        // CompNinshoshaのset処理
        item.setAri_denshiKoin(ari_denshiKoin);
        item.setAri_hakkoYMD(ari_hakkoYMD);
        item.setAri_ninshoshaYakushokuMei(ari_ninshoshaYakushokuMei);
        item.setAri_ninshoshaYakushokuMei1(ari_ninshoshaYakushokuMei1);
        item.setAri_koinMojiretsu(ari_koinMojiretsu);
        item.setAri_ninshoshaYakushokuMei2(ari_ninshoshaYakushokuMei2);
        item.setAri_ninshoshaShimeiKakenai(ari_ninshoshaShimeiKakenai);
        item.setAri_ninshoshaShimeiKakeru(ari_ninshoshaShimeiKakeru);
        item.setAri_koinShoryaku(ari_koinShoryaku);
        return item;
    }

}
