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
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookNofushoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】納付書
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class HokenryoNonyuTsuchishoBookNofushoReport extends Report<HokenryoNonyuTsuchishoBookNofushoSource> {

    private final HokenryoNonyuTsuchishoBookItem item;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT1 = 1;
    private static final int INT2 = 2;

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
     * @param item HokenryoNonyuTsuchishoBookItem
     * @return HokenryoNonyuTsuchishoBookNofushoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoBookNofushoReport createFrom(@NonNull HokenryoNonyuTsuchishoBookItem item) {
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
        RString 帳票ID = 仮算定納入通知書情報.get帳票ID().value();
        if (null == 帳票ID) {
            return;
        }
        RString 帳票IDの先頭 = 帳票ID.substring(0, 帳票ID.indexOf("-"));
        boolean is口振あり = new RString("DBB100020").equals(帳票IDの先頭) || new RString("DBB100022").equals(帳票IDの先頭);
        int 通知書の連番 = INT1;
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit = new ArrayList<>();
        boolean is納入通知書期情報リスト設定中 = false;
        int 納入通知書期情報リストの設定数 = 0;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int ブック開始位置 = 納入通知書期情報.getブック開始位置();
            if (is口振あり) {
//            if ((1 == ブック開始位置 || ブック開始位置 > 5)) {
//            }
                if (!is納入通知書期情報リスト設定中 && ブック開始位置 == INT5) {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    edit(納入通知書期情報リストEdit, 通知書の連番, writer);
                    通知書の連番++;
                    納入通知書期情報リストEdit = new ArrayList<>();
                    is納入通知書期情報リスト設定中 = true;
                } else if (!is納入通知書期情報リスト設定中) {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    is納入通知書期情報リスト設定中 = true;
                    switch (ブック開始位置) {
                        case INT2:
                            納入通知書期情報リストの設定数 = INT1;
                            break;
                        case INT3:
                            納入通知書期情報リストの設定数 = INT2;
                            break;
                        case INT4:
                            納入通知書期情報リストの設定数 = INT3;
                            break;
                        default:
                            break;
                    }
                } else if (納入通知書期情報リストの設定数 == INT3) {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    edit(納入通知書期情報リストEdit, 通知書の連番, writer);
                    通知書の連番++;
                    納入通知書期情報リストEdit = new ArrayList<>();
                    納入通知書期情報リストの設定数 = 0;
                } else {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    納入通知書期情報リストの設定数++;
                }
            } else {
//                if ((ブック開始位置 > 5)) {
//                }
                if (!is納入通知書期情報リスト設定中 && ブック開始位置 == 1) {
                    is納入通知書期情報リスト設定中 = true;
                } else if (!is納入通知書期情報リスト設定中 && ブック開始位置 == INT5) {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    edit(納入通知書期情報リストEdit, 通知書の連番, writer);
                    通知書の連番++;
                    納入通知書期情報リストEdit = new ArrayList<>();
                    is納入通知書期情報リスト設定中 = true;
                } else if (!is納入通知書期情報リスト設定中) {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    is納入通知書期情報リスト設定中 = true;
                    switch (ブック開始位置) {
                        case INT2:
                            納入通知書期情報リストの設定数 = INT1;
                            break;
                        case INT3:
                            納入通知書期情報リストの設定数 = INT2;
                            break;
                        case INT4:
                            納入通知書期情報リストの設定数 = INT3;
                            break;
                        default:
                            break;
                    }
                } else if (納入通知書期情報リストの設定数 == INT3) {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    edit(納入通知書期情報リストEdit, 通知書の連番, writer);
                    通知書の連番++;
                    納入通知書期情報リストEdit = new ArrayList<>();
                    納入通知書期情報リストの設定数 = 0;
                } else {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    納入通知書期情報リストの設定数++;
                }
            }
        }
        edit(納入通知書期情報リストEdit, 通知書の連番, writer);
    }

    private void edit(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit, int 通知書の連番,
            ReportSourceWriter<HokenryoNonyuTsuchishoBookNofushoSource> writer) {
        if (納入通知書期情報リストEdit.isEmpty()) {
            return;
        }
        IHokenryoNonyuTsuchishoBookNofushoEditor edit = new HokenryoNonyuTsuchishoBookNofushoEditor(item, 納入通知書期情報リストEdit, 通知書の連番);
        IHokenryoNonyuTsuchishoBookNofushoBuilder builder = new HokenryoNonyuTsuchishoBookNofushoBuilder(edit);
        writer.writeLine(builder);
    }

    private boolean is全部の納付額が0(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.get納付額().compareTo(Decimal.ZERO) > 0) {
                return false;
            }
        }
        return true;
    }

//    /**
//     * devidedByPageメソッド
//     *
//     * @return List<NonyuTsuchisho>
//     */
//    @Override
//    public List<NonyuTsuchisho> devidedByPage() {
//        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = item.get仮算定納入通知書情報();
//        if (null == 仮算定納入通知書情報) {
//            仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
//        }
//        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
//        if (納入通知書期情報リスト.isEmpty()) {
//            納入通知書期情報リスト = new ArrayList<>();
//        }
//        RString 帳票ID = 仮算定納入通知書情報.get帳票ID().value();
//        if (null == 帳票ID) {
//            return new ArrayList<>();
//        }
//        RString 帳票IDの先頭 = 帳票ID.substring(0, 帳票ID.indexOf("-"));
//        if (new RString("DBB100020").equals(帳票IDの先頭) || new RString("DBB100022").equals(帳票IDの先頭)) {
//            return devidedByPage1(納入通知書期情報リスト);
//        } else {
//            return devidedByPage2(納入通知書期情報リスト);
//        }
//    }
//
//    private List<NonyuTsuchisho> devidedByPage1(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
//        List<NonyuTsuchisho> reportLst = new ArrayList<>();
//        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
//        int 納入通知書期情報リストの設定数 = 0;
//        boolean is納入通知書期情報リスト設定中 = false;
//        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
//            int ブック開始位置 = 納入通知書期情報.getブック開始位置();
////            if (1 == ブック開始位置 || ブック開始位置 > 5) {
////            }
//            if (!is納入通知書期情報リスト設定中) {
//                納入通知書期情報リストReport.add(納入通知書期情報);
//                is納入通知書期情報リスト設定中 = true;
//                switch (ブック開始位置) {
//                    case 2:
//                        納入通知書期情報リストの設定数 = 1;
//                        break;
//                    case INT3:
//                        納入通知書期情報リストの設定数 = 2;
//                        break;
//                    case INT4:
//                        納入通知書期情報リストの設定数 = INT3;
//                        break;
//                    case INT5:
//                        reportLst.add(getNewReport(納入通知書期情報リストReport));
//                        reportLst = new ArrayList<>();
//                        納入通知書期情報リストの設定数 = 0;
//                        break;
//                    default:
//                        break;
//                }
//            } else {
//                納入通知書期情報リストReport.add(納入通知書期情報);
//                納入通知書期情報リストの設定数++;
//                if (納入通知書期情報リストの設定数 == INT4) {
//                    reportLst.add(getNewReport(納入通知書期情報リストReport));
//                    reportLst = new ArrayList<>();
//                    納入通知書期情報リストの設定数 = 0;
//                } else {
//                    reportLst.add(getNewReport(納入通知書期情報リストReport));
//                }
//            }
//        }
//        reportLst.add(getNewReport(納入通知書期情報リストReport));
//        return reportLst;
//    }
//
//    private List<NonyuTsuchisho> devidedByPage2(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
//        List<NonyuTsuchisho> reportLst = new ArrayList<>();
//        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
//        int 納入通知書期情報リストの設定数 = 0;
//        boolean is納入通知書期情報リスト設定中 = false;
//        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
//            int ブック開始位置 = 納入通知書期情報.getブック開始位置();
////            if (ブック開始位置 > 5) {
////            }
//            if (!is納入通知書期情報リスト設定中) {
//                switch (ブック開始位置) {
//                    case 1:
//                        break;
//                    case 2:
//                        納入通知書期情報リストReport.add(納入通知書期情報);
//                        納入通知書期情報リストの設定数 = 1;
//                        is納入通知書期情報リスト設定中 = true;
//                        break;
//                    case INT3:
//                        納入通知書期情報リストReport.add(納入通知書期情報);
//                        納入通知書期情報リストの設定数 = 2;
//                        is納入通知書期情報リスト設定中 = true;
//                        break;
//                    case INT4:
//                        納入通知書期情報リストReport.add(納入通知書期情報);
//                        納入通知書期情報リストの設定数 = INT3;
//                        is納入通知書期情報リスト設定中 = true;
//                        break;
//                    case INT5:
//                        is納入通知書期情報リスト設定中 = true;
//                        納入通知書期情報リストReport.add(納入通知書期情報);
//                        reportLst.add(getNewReport(納入通知書期情報リストReport));
//                        reportLst = new ArrayList<>();
//                        納入通知書期情報リストの設定数 = 0;
//                        break;
//                    default:
//                        break;
//                }
//            } else {
//                納入通知書期情報リストReport.add(納入通知書期情報);
//                納入通知書期情報リストの設定数++;
//                if (納入通知書期情報リストの設定数 == INT4) {
//                    reportLst.add(getNewReport(納入通知書期情報リストReport));
//                    reportLst = new ArrayList<>();
//                    納入通知書期情報リストの設定数 = 0;
//                }
//            }
//        }
//        reportLst.add(getNewReport(納入通知書期情報リストReport));
//        return reportLst;
//    }
//    private HokenryoNonyuTsuchishoBookNofushoReport getNewReport(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport) {
//        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report = new KariSanteiNonyuTsuchiShoJoho();
//        clone仮算定納入通知書情報(仮算定納入通知書情報Report);
//        仮算定納入通知書情報Report.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
//        仮算定納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);
//        HokenryoNonyuTsuchishoBookNofushoReport report
//                = HokenryoNonyuTsuchishoBookNofushoReport
//                .createFrom(new HokenryoNonyuTsuchishoBookItem(仮算定納入通知書情報Report, item.getNinshoshaSource()));
//        return report;
//    }
//
//    private void clone仮算定納入通知書情報(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report) {
//        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = item.get仮算定納入通知書情報();
//        仮算定納入通知書情報Report.set仮算定納入通知書制御情報(仮算定納入通知書情報.get仮算定納入通知書制御情報());
//        仮算定納入通知書情報Report.set処理区分(仮算定納入通知書情報.get処理区分());
//        仮算定納入通知書情報Report.set出力期リスト(仮算定納入通知書情報.get出力期リスト());
//        仮算定納入通知書情報Report.set地方公共団体(仮算定納入通知書情報.get地方公共団体());
//        仮算定納入通知書情報Report.set帳票ID(仮算定納入通知書情報.get帳票ID());
//        仮算定納入通知書情報Report.set帳票分類ID(仮算定納入通知書情報.get帳票分類ID());
//        仮算定納入通知書情報Report.set発行日(仮算定納入通知書情報.get発行日());
//        仮算定納入通知書情報Report.set算定の基礎(仮算定納入通知書情報.get算定の基礎());
//        仮算定納入通知書情報Report.set納付書共通(仮算定納入通知書情報.get納付書共通());
//        仮算定納入通知書情報Report.set編集後仮算定通知書共通情報(仮算定納入通知書情報.get編集後仮算定通知書共通情報());
//    }
}
