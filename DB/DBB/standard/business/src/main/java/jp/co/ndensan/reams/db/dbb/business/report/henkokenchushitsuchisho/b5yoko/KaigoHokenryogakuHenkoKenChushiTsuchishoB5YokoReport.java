/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.b5yoko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.AfterEditInformation;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.DankaiKubun;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 介護保険料額変更兼特別徴収中止通知書のB5横タイプのReportです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
public class KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReport
        extends Report<KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource> {

    private static final int ROWNUM = 14;
    private final List<KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness> items;

    /**
     * コンストラクタです。
     *
     * @param items KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness
     */
    public KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReport(
            List<KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness> items) {
        this.items = items;
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource> reportSourceWriter) {
        for (KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness item : items) {
            KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoEditor yokoEditor = new KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoEditor(item);
            CompSofubutsuAtesakiEditor compSofubutsuAtesakiEditor = new CompSofubutsuAtesakiEditor(item);
            CompNinshoshaEditor compNinshoshaEditor = new CompNinshoshaEditor(item.getNinshoshaSource());
            CompKaigoToiawasesakiEditor toiawasesakiEditor = new CompKaigoToiawasesakiEditor(item.getCompKaigoToiawasesakiSource());
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = item.get本算定決定通知書情報().get編集後本算定通知書共通情報();
            List<UniversalPhase> 更正前_普徴期別金額リスト = 編集後本算定通知書共通情報.get更正前().get普徴期別金額リスト();
            List<UniversalPhase> 更正後_普徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト();
            List<CharacteristicsPhase> 更正前_特徴期別金額リスト = 編集後本算定通知書共通情報.get更正前().get特徴期別金額リスト();
            List<CharacteristicsPhase> 更正後_特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();
            List<AfterEditInformation> 普徴納期情報リスト = 編集後本算定通知書共通情報.get普徴納期情報リスト();
            HonSanteiTsuchiShoKyotsuKomokuHenshu honSantei = new HonSanteiTsuchiShoKyotsuKomokuHenshu();
            List<ShotokuDankaiBusiness> shotokuDankaiList = getShotokuDankaiBusiness(編集後本算定通知書共通情報);
            List<RString> 特徴期リスト = honSantei.create特徴期リスト();
            特徴期リスト = sort期(特徴期リスト);
            List<Tsuki> 特徴月リス = create特徴月リスト(特徴期リスト);
            List<RString> 普徴期リスト = honSantei.create普徴期リスト(item.get本算定決定通知書情報().get現年度_過年度区分());
            普徴期リスト = sort期(普徴期リスト);
            boolean is現年度 = GennenKanen.現年度 == item.get本算定決定通知書情報().get現年度_過年度区分();
            List<Tsuki> 普徴月リスト = create普徴月リスト(普徴期リスト, item.get本算定決定通知書情報().get現年度_過年度区分());
            for (int i = 1; i <= ROWNUM; i++) {
                KibetsuBusiness kibetsuBusiness = new KibetsuBusiness();
                boolean flag = true;
                if (i <= 普徴期リスト.size()
                        && (is現年度 ? true : !is特徴のみ(編集後本算定通知書共通情報))) {
                    flag = false;
                    RString 普徴期 = 普徴期リスト.get(i - 1);
                    Tsuki 普徴月Enum = 普徴月リスト.get(i - 1);
                    RString 普徴月 = get普徴月コード(普徴月Enum);
                    if (!(!is現年度 && this.get普徴期別金額(普徴期, 更正後_普徴期別金額リスト).equals(Decimal.ZERO))
                            && 普徴月Enum != Tsuki.翌年度4月 && 普徴月Enum != Tsuki.翌年度5月) {
                        kibetsuBusiness.setListKibetsu_5(format月と期(普徴期));
                        kibetsuBusiness.setListKibetsu_6(format月と期(普徴月));
                        set普徴期別金額(kibetsuBusiness, 普徴期, 更正前_普徴期別金額リスト, 更正後_普徴期別金額リスト, is現年度);
                        kibetsuBusiness.setListZuiji_1(get随時(普徴期, 普徴納期情報リスト));
                    }
                }
                if (i <= 特徴期リスト.size()
                        && (is現年度 ? true : !is普徴のみ(編集後本算定通知書共通情報))) {
                    flag = false;
                    RString 特徴期 = 特徴期リスト.get(i - 1);
                    RString 特徴月 = 特徴月リス.get(i - 1).getコード();
                    if (!(!is現年度 && this.get特徴期別金額(特徴期, 更正後_特徴期別金額リスト).equals(Decimal.ZERO))) {
                        kibetsuBusiness.setListKibetsu_1(format月と期(特徴期));
                        kibetsuBusiness.setListKibetsu_2(format月と期(特徴月));
                        set特徴期別金額(kibetsuBusiness, 特徴期, 更正前_特徴期別金額リスト, 更正後_特徴期別金額リスト, is現年度);
                    }
                }
                if (flag) {
                    break;
                }

                KibetsuEditor kibetsuEditor = new KibetsuEditor(kibetsuBusiness);
                ShotokuDankaiEditor shotokuDankaiEditor;
                if (i == 1) {
                    shotokuDankaiEditor = new ShotokuDankaiEditor(shotokuDankaiList.get(0));
                } else {
                    shotokuDankaiEditor = new ShotokuDankaiEditor(shotokuDankaiList.get(1));
                }

                KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoBuilder builder
                        = new KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoBuilder(yokoEditor,
                                kibetsuEditor,
                                compSofubutsuAtesakiEditor,
                                compNinshoshaEditor,
                                toiawasesakiEditor,
                                shotokuDankaiEditor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }

    private boolean is普徴のみ(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        return !編集後本算定通知書共通情報.get更正後().get徴収方法().contains("特別徴収");
    }

    private boolean is特徴のみ(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        return !編集後本算定通知書共通情報.get更正後().get徴収方法().contains("普通徴収");
    }

    private RString edit金額(Decimal 金額, boolean is現年度) {
        if (null == 金額) {
            return is現年度 ? new RString("0") : RString.EMPTY;
        }
        if (Decimal.ZERO.equals(金額)) {
            return is現年度 ? new RString("0") : RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private List<ShotokuDankaiBusiness> getShotokuDankaiBusiness(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        List<ShotokuDankaiBusiness> list = new ArrayList<>();

        HonSanteiTsuchiShoKyotsuKomokuHenshu henshu = new HonSanteiTsuchiShoKyotsuKomokuHenshu();
        List<DankaiKubun> 所得段階区分リスト = henshu.create所得段階区分リスト(編集後本算定通知書共通情報);
        ShotokuDankaiBusiness 更正前 = new ShotokuDankaiBusiness();
        ShotokuDankaiBusiness 更正後 = new ShotokuDankaiBusiness();
        for (DankaiKubun dankaiKubun : 所得段階区分リスト) {
            if (Tsuki._4月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_1(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_1(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._5月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_2(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_2(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._6月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_3(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_3(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._7月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_4(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_4(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._8月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_5(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_5(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._9月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_6(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_6(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._10月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_7(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_7(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._11月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_8(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_8(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._12月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_9(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_9(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._1月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_10(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_10(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._2月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_11(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_11(dankaiKubun.get更正後所得段階());
            }
            if (Tsuki._3月.equals(dankaiKubun.get月())) {
                更正前.setListShotokuDankai_12(dankaiKubun.get更正前所得段階());
                更正後.setListShotokuDankai_12(dankaiKubun.get更正後所得段階());
            }
        }
        list.add(更正前);
        list.add(更正後);
        return list;
    }

    private List<Tsuki> create普徴月リスト(List<RString> 普徴期リスト, GennenKanen 現年過年区分) {
        List<Tsuki> tsukiList = new ArrayList<>();
        KitsukiList kitsukiList;
        if (GennenKanen.現年度 == 現年過年区分) {
            kitsukiList = new FuchoKiUtil().get期月リスト();
        } else {
            kitsukiList = new KanendoKiUtil().get期月リスト();
        }
        for (RString 普徴期 : 普徴期リスト) {
            List<Kitsuki> kitsukiのlist = kitsukiList.get期の月(Integer.parseInt(String.valueOf(普徴期)));
            if (!kitsukiのlist.isEmpty()) {
                tsukiList.add(kitsukiのlist.get(kitsukiのlist.size() - 1).get月());
            }
        }
        return tsukiList;
    }

    private List<Tsuki> create特徴月リスト(List<RString> 特徴期リスト) {
        List<Tsuki> tsukiList = new ArrayList<>();
        KitsukiList kitsukiList = new TokuchoKiUtil().get期月リスト();
        for (RString 特徴期 : 特徴期リスト) {
            List<Kitsuki> kitsukiのlist = kitsukiList.get期の月(Integer.parseInt(String.valueOf(特徴期)));
            if (!kitsukiのlist.isEmpty()) {
                tsukiList.add(kitsukiのlist.get(kitsukiのlist.size() - 1).get月());
            }
        }
        return tsukiList;
    }

    private RString format月と期(RString value) {
        return new RString(Integer.valueOf(value.toString())).padLeft(RString.HALF_SPACE, 2);
    }

    private RString get普徴月コード(Tsuki 普徴月) {
        if (Tsuki.翌年度4月 == 普徴月) {
            return new RString("04");
        }
        if (Tsuki.翌年度5月 == 普徴月) {
            return new RString("05");
        }
        return 普徴月.getコード();
    }

    private List<RString> sort期(List<RString> 期リスト) {
        List<RString> list = new ArrayList<>();
        for (RString 期 : 期リスト) {
            if (Integer.parseInt(期.toString()) == 0 || list.contains(期)) {
                continue;
            }
            list.add(期);
        }
        Collections.sort(list, new Comparator<RString>() {
            @Override
            public int compare(RString arg0, RString arg1) {
                if (Integer.parseInt(arg0.toString()) < Integer.parseInt(arg1.toString())) {
                    return -1;
                } else if (Integer.parseInt(arg1.toString()) < Integer.parseInt(arg0.toString())) {
                    return 1;
                }
                return 0;
            }
        });
        return list;
    }

    private RString get随時(RString 期, List<AfterEditInformation> 普徴納期情報リスト) {
        RString 随時 = RString.EMPTY;
        for (AfterEditInformation afterEditInformation : 普徴納期情報リスト) {
            if (期.equals(afterEditInformation.get期())) {
                随時 = afterEditInformation.get随時();
                break;
            }
        }
        return 随時;
    }

    private void set普徴期別金額(KibetsuBusiness kibetsuBusiness,
            RString 期,
            List<UniversalPhase> 更正前_普徴期別金額リスト,
            List<UniversalPhase> 更正後_普徴期別金額リスト, boolean is現年度) {
        Decimal 更正前_普徴期別金額 = get普徴期別金額(期, 更正前_普徴期別金額リスト);
        Decimal 更正後_普徴期別金額 = get普徴期別金額(期, 更正後_普徴期別金額リスト);
        if (Decimal.ZERO.equals(更正前_普徴期別金額)
                && Decimal.ZERO.equals(更正後_普徴期別金額)) {
            kibetsuBusiness.setListKibetsu_7(RString.EMPTY);
            kibetsuBusiness.setListKibetsu_8(RString.EMPTY);
        } else {
            kibetsuBusiness.setListKibetsu_7(edit金額(更正前_普徴期別金額, is現年度));
            kibetsuBusiness.setListKibetsu_8(edit金額(更正後_普徴期別金額, is現年度));
        }
    }

    private Decimal get普徴期別金額(RString 期, List<UniversalPhase> 普徴期別金額リスト) {
        Decimal 普徴期別金額 = Decimal.ZERO;
        if (普徴期別金額リスト == null) {
            return 普徴期別金額;
        }
        for (UniversalPhase universalPhase : 普徴期別金額リスト) {

            if (new RString(universalPhase.get期()).padZeroToLeft(2).equals(期.padZeroToLeft(2))) {
                普徴期別金額 = universalPhase.get金額() == null ? Decimal.ZERO : universalPhase.get金額();
                break;
            }
        }
        return 普徴期別金額;
    }

    private void set特徴期別金額(KibetsuBusiness kibetsuBusiness,
            RString 期,
            List<CharacteristicsPhase> 更正前_特徴期別金額リスト,
            List<CharacteristicsPhase> 更正後_特徴期別金額リスト, boolean is現年度) {
        Decimal 更正前_特徴期別金額 = get特徴期別金額(期, 更正前_特徴期別金額リスト);
        Decimal 更正後_特徴期別金額 = get特徴期別金額(期, 更正後_特徴期別金額リスト);
        if (Decimal.ZERO.equals(更正前_特徴期別金額)
                && Decimal.ZERO.equals(更正後_特徴期別金額)) {
            kibetsuBusiness.setListKibetsu_3(RString.EMPTY);
            kibetsuBusiness.setListKibetsu_4(RString.EMPTY);
        } else {
            kibetsuBusiness.setListKibetsu_3(edit金額(更正前_特徴期別金額, is現年度));
            kibetsuBusiness.setListKibetsu_4(edit金額(更正後_特徴期別金額, is現年度));
        }
    }

    private Decimal get特徴期別金額(RString 期, List<CharacteristicsPhase> 特徴期別金額リスト) {
        Decimal 特徴期別金額 = Decimal.ZERO;
        if (特徴期別金額リスト == null) {
            return 特徴期別金額;
        }
        for (CharacteristicsPhase characteristicsPhase : 特徴期別金額リスト) {

            if (characteristicsPhase.get期().padZeroToLeft(2).equals(期.padZeroToLeft(2))) {
                特徴期別金額 = characteristicsPhase.get金額() == null ? Decimal.ZERO : characteristicsPhase.get金額();
                break;
            }
        }
        return 特徴期別金額;
    }
}
