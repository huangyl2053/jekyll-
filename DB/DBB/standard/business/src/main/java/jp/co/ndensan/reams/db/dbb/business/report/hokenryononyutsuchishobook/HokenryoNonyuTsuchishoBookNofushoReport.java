/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookNofushoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】納付書
 */
public class HokenryoNonyuTsuchishoBookNofushoReport extends Report<HokenryoNonyuTsuchishoBookNofushoSource> {

    private final HokenryoNonyuTsuchishoBookItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoBookItem
     */
    protected HokenryoNonyuTsuchishoBookNofushoReport(HokenryoNonyuTsuchishoBookItem item) {
        this.item = item;
    }

    /**
     *
     * @param item
     * @return HokenryoNonyuTsuchishoBookNofushoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoBookNofushoReport createFrom(HokenryoNonyuTsuchishoBookItem item) {
        return new HokenryoNonyuTsuchishoBookNofushoReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoBookNofushoSource> writer) {
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        if (null == 仮算定納入通知書情報) {
            仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        if (納入通知書期情報リスト.isEmpty()) {
            納入通知書期情報リスト = new ArrayList<>();
        }
        if (is全部の納付額が0(納入通知書期情報リスト)) {
            return;
        }
        //TODO 雛形部品CompNinshoshaを作成する
//        INinshoshaSourceBuilder iNinshoshaSourceBuilder
//                = NinshoshaSourceBuilderFactory.createInstance(null, null, RString.HALF_SPACE, RDate.MAX, 1);
//        NinshoshaSource ninshoshaSource = iNinshoshaSourceBuilder.buildSource();
        //TODO 共通部品CompSofubutsuAtesakiを作成する
        //SofubutsuAtesakiSource sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        int 通知書の連番 = 1;
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit = new ArrayList<>();
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int ブック開始位置 = 納入通知書期情報.getブック開始位置();
//            if (1 == ブック開始位置 || ブック開始位置 > 5) {
//            }
            納入通知書期情報リストEdit.add(納入通知書期情報);
            if (ブック開始位置 == 5) {
                edit(納入通知書期情報リストEdit, 通知書の連番, writer);
                通知書の連番++;
                納入通知書期情報リストEdit.clear();
            }
        }
        edit(納入通知書期情報リストEdit, 通知書の連番, writer);
    }

    private void edit(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit, int 通知書の連番,
            ReportSourceWriter<HokenryoNonyuTsuchishoBookNofushoSource> writer) {
        IHokenryoNonyuTsuchishoBookNofushoEditor edit = new HokenryoNonyuTsuchishoBookNofushoEditor(item, 納入通知書期情報リストEdit, 通知書の連番);
        IHokenryoNonyuTsuchishoBookNofushoBuilder buiolder = new HokenryoNonyuTsuchishoBookNofushoBuilder(edit);
        writer.writeLine(buiolder);
    }

    private boolean is全部の納付額が0(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.get納付額().compareTo(Decimal.ZERO) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * devidedByPageメソッド
     *
     * @return List<HokenryoNonyuTsuchishoBookNofushoReport>
     */
    public List<HokenryoNonyuTsuchishoBookNofushoReport> devidedByPage() {//TODO
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        if (null == 仮算定納入通知書情報) {
            仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        if (納入通知書期情報リスト.isEmpty()) {
            納入通知書期情報リスト = new ArrayList<>();
        }
        RString 帳票ID = 仮算定納入通知書情報.get帳票ID().value();
        RString 帳票IDの先頭 = null == 帳票ID ? null : 帳票ID.substring(0, 帳票ID.indexOf("-"));
        if (new RString("DBB100020").equals(帳票IDの先頭) || new RString("DBB100021").equals(帳票IDの先頭)) {
            return devidedByPage1(納入通知書期情報リスト);
        } else {
            return devidedByPage2(納入通知書期情報リスト);
        }
    }

    private List<HokenryoNonyuTsuchishoBookNofushoReport> devidedByPage1(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        List<HokenryoNonyuTsuchishoBookNofushoReport> reportLst = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
        int 納入通知書期情報リストの設定数 = 0;
        boolean is納入通知書期情報リスト設定中 = false;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int ブック開始位置 = 納入通知書期情報.getブック開始位置();
//            if (1 == ブック開始位置 || ブック開始位置 > 5) {
//            }
            if (!is納入通知書期情報リスト設定中) {
                納入通知書期情報リストReport.add(納入通知書期情報);
                is納入通知書期情報リスト設定中 = true;
                switch (ブック開始位置) {
                    case 2:
                        納入通知書期情報リストの設定数 = 1;
                        break;
                    case 3:
                        納入通知書期情報リストの設定数 = 2;
                        break;
                    case 4:
                        納入通知書期情報リストの設定数 = 3;
                        break;
                    case 5:
                        reportLst.add(getNewReport(納入通知書期情報リストReport));
                        reportLst = new ArrayList<>();
                        納入通知書期情報リストの設定数 = 0;
                        break;
                    default:
                        break;
                }
            } else {
                納入通知書期情報リストReport.add(納入通知書期情報);
                納入通知書期情報リストの設定数++;
                if (納入通知書期情報リストの設定数 == 4) {
                    reportLst.add(getNewReport(納入通知書期情報リストReport));
                    reportLst = new ArrayList<>();
                    納入通知書期情報リストの設定数 = 0;
                } else {
                    reportLst.add(getNewReport(納入通知書期情報リストReport));
                }
            }
        }
        reportLst.add(getNewReport(納入通知書期情報リストReport));
        return reportLst;
    }

    private List<HokenryoNonyuTsuchishoBookNofushoReport> devidedByPage2(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        List<HokenryoNonyuTsuchishoBookNofushoReport> reportLst = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
        int 納入通知書期情報リストの設定数 = 0;
        boolean is納入通知書期情報リスト設定中 = false;
        int 番目番号 = 1;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int ブック開始位置 = 納入通知書期情報.getブック開始位置();
//            if (1 == ブック開始位置 || ブック開始位置 > 5) {
//            }
            if (!is納入通知書期情報リスト設定中) {
                if (1 == 番目番号) {
                    switch (ブック開始位置) {
                        case 1:
                            break;
                        case 2:
                            納入通知書期情報リストReport.add(納入通知書期情報);
                            is納入通知書期情報リスト設定中 = true;
                            納入通知書期情報リストの設定数 = 1;
                            break;
                        case 3:
                            納入通知書期情報リストReport.add(納入通知書期情報);
                            is納入通知書期情報リスト設定中 = true;
                            納入通知書期情報リストの設定数 = 2;
                            break;
                        case 4:
                            納入通知書期情報リストReport.add(納入通知書期情報);
                            is納入通知書期情報リスト設定中 = true;
                            納入通知書期情報リストの設定数 = 3;
                            break;
                        case 5:
                            納入通知書期情報リストReport.add(納入通知書期情報);
                            is納入通知書期情報リスト設定中 = true;
                            reportLst.add(getNewReport(納入通知書期情報リストReport));
                            reportLst = new ArrayList<>();
                            納入通知書期情報リストの設定数 = 0;
                            break;
                        default:
                            break;
                    }
                } else {
                    納入通知書期情報リストReport.add(納入通知書期情報);
                    is納入通知書期情報リスト設定中 = true;
                    納入通知書期情報リストの設定数 = 1;
                }
            } else {
                納入通知書期情報リストReport.add(納入通知書期情報);
                納入通知書期情報リストの設定数++;
                if (納入通知書期情報リストの設定数 == 4) {
                    reportLst.add(getNewReport(納入通知書期情報リストReport));
                    reportLst = new ArrayList<>();
                    納入通知書期情報リストの設定数 = 0;
                } else {
                    reportLst.add(getNewReport(納入通知書期情報リストReport));
                }
            }
        }
        reportLst.add(getNewReport(納入通知書期情報リストReport));
        return reportLst;
    }

    private HokenryoNonyuTsuchishoBookNofushoReport getNewReport(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport) {
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report = new KariSanteiNonyuTsuchiShoJoho();
        clone仮算定納入通知書情報(仮算定納入通知書情報Report);
        仮算定納入通知書情報Report.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
        仮算定納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);
        HokenryoNonyuTsuchishoBookNofushoReport report
                = HokenryoNonyuTsuchishoBookNofushoReport
                .createFrom(new HokenryoNonyuTsuchishoBookItem(仮算定納入通知書情報Report));
        return report;
    }

    private void clone仮算定納入通知書情報(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report) {
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        仮算定納入通知書情報Report.set仮算定納入通知書制御情報(仮算定納入通知書情報.get仮算定納入通知書制御情報());
        仮算定納入通知書情報Report.set処理区分(仮算定納入通知書情報.get処理区分());
        仮算定納入通知書情報Report.set出力期リスト(仮算定納入通知書情報.get出力期リスト());
        仮算定納入通知書情報Report.set地方公共団体(仮算定納入通知書情報.get地方公共団体());
        仮算定納入通知書情報Report.set帳票ID(仮算定納入通知書情報.get帳票ID());
        仮算定納入通知書情報Report.set帳票分類ID(仮算定納入通知書情報.get帳票分類ID());
        仮算定納入通知書情報Report.set発行日(仮算定納入通知書情報.get発行日());
        仮算定納入通知書情報Report.set算定の基礎(仮算定納入通知書情報.get算定の基礎());
        仮算定納入通知書情報Report.set納付書共通(仮算定納入通知書情報.get納付書共通());
        仮算定納入通知書情報Report.set編集後仮算定通知書共通情報(仮算定納入通知書情報.get編集後仮算定通知書共通情報());
    }

}
