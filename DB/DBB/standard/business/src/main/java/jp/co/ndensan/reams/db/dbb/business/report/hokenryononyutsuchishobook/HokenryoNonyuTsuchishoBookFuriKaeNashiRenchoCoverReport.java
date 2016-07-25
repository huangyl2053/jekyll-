/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【ブックタイプ】（口振依頼なし）通知書_連帳
 *
 * @reamsid_L DBB-9110-010 huangh
 */
public class HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport
        extends NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト前期 = new ArrayList<>();
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト中期 = new ArrayList<>();
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト後期 = new ArrayList<>();
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT1 = 1;
    private static final int INT2 = 2;
    private final RString 当初出力_中期開始期;
    private final RString 当初出力_後期開始期;

    /**
     * コンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     * @param 当初出力_中期開始期 RString
     * @param 当初出力_後期開始期 RString
     */
    public HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            NinshoshaSource ninshoshaSource,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
        this.当初出力_中期開始期 = 当初出力_中期開始期;
        this.当初出力_後期開始期 = 当初出力_後期開始期;
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> writer) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        if (null == 納入通知書期情報リスト || is全部の納付額が0(納入通知書期情報リスト)) {
            return;
        }

        this.edit前中後期リスト(納入通知書期情報リスト);

        if (!納入通知書期情報リスト前期.isEmpty()) {
            this.edit前中後期(納入通知書期情報リスト前期, writer);
        }
        if (!納入通知書期情報リスト中期.isEmpty()) {
            this.edit前中後期(納入通知書期情報リスト中期, writer);
        }
        if (!納入通知書期情報リスト後期.isEmpty()) {
            this.edit前中後期(納入通知書期情報リスト後期, writer);
        }

    }

    private void edit前中後期(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> writer) {

        if (HenshuHaniKubun.Detailのみ.equals(本算定納入通知書情報.get編集範囲区分())) {
            edit納付書(納入通知書期情報リスト, writer);
            return;
        }
        if (本算定納入通知書情報.get本算定納入通知書制御情報() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報().get更正後() != null
                && ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分())
                && KozaKubun.口座振替.equals(本算定納入通知書情報.get編集後本算定通知書共通情報().get更正後().get口座区分())
                && 本算定納入通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報() != null
                && HyojiUmu.表示しない
                .equals(本算定納入通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
            本算定納入通知書情報.set編集範囲区分(HenshuHaniKubun.Coverのみ);
        }
        edit納入通知書期情報(納入通知書期情報リスト, writer);
    }

    private void edit納入通知書期情報(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> writer) {

        HenshuHaniKubun 編集範囲区分 = 本算定納入通知書情報.get編集範囲区分();
        if (HenshuHaniKubun.Coverのみ.equals(編集範囲区分) || HenshuHaniKubun.全てのレイアウト.equals(編集範囲区分)) {
            edit通知書(納入通知書期情報リスト, writer);
        }
        if (!HenshuHaniKubun.Detailのみ.equals(編集範囲区分) && !HenshuHaniKubun.全てのレイアウト.equals(編集範囲区分)) {
            return;
        }
        int ブック開始位置 = 納入通知書期情報リスト.get(0).getブック開始位置();
        if (ブック開始位置 > INT5) {
            throw new ApplicationException(DbbErrorMessages.ブック開始位置不正.getMessage());
        }
        boolean isブック開始位置が1 = false;
        if (ブック開始位置 == INT1) {
            納入通知書期情報リスト.remove(0);
            isブック開始位置が1 = true;
        }
        if (納入通知書期情報リスト.isEmpty()) {
            return;
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit = new ArrayList<>();
        boolean is納入通知書期情報リスト設定中 = false;
        int 納入通知書期情報リストの設定数 = 0;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            ブック開始位置 = 納入通知書期情報.getブック開始位置();
            if (!is納入通知書期情報リスト設定中 && ブック開始位置 == INT5) {
                if (isブック開始位置が1) {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    is納入通知書期情報リスト設定中 = true;
                    納入通知書期情報リストの設定数 = INT1;
                } else {
                    set納入通知書期情報リストEdit(納入通知書期情報リストEdit, INT3);
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    edit納付書(納入通知書期情報リストEdit, writer);

                    納入通知書期情報リストEdit = new ArrayList<>();
                    is納入通知書期情報リスト設定中 = true;
                }
            } else if (!is納入通知書期情報リスト設定中) {
                if (isブック開始位置が1) {
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    is納入通知書期情報リスト設定中 = true;
                    納入通知書期情報リストの設定数 = INT1;
                } else {
                    switch (ブック開始位置) {
                        case INT2:
                            納入通知書期情報リストの設定数 = INT1;
                            break;
                        case INT3:
                            set納入通知書期情報リストEdit(納入通知書期情報リストEdit, INT1);
                            納入通知書期情報リストの設定数 = INT2;
                            break;
                        case INT4:
                            set納入通知書期情報リストEdit(納入通知書期情報リストEdit, INT2);
                            納入通知書期情報リストの設定数 = INT3;
                            break;
                        default:
                            break;
                    }
                    納入通知書期情報リストEdit.add(納入通知書期情報);
                    is納入通知書期情報リスト設定中 = true;
                }
            } else if (納入通知書期情報リストの設定数 == INT3) {
                納入通知書期情報リストEdit.add(納入通知書期情報);
                edit納付書(納入通知書期情報リストEdit, writer);

                納入通知書期情報リストEdit = new ArrayList<>();
                納入通知書期情報リストの設定数 = 0;
            } else {
                納入通知書期情報リストEdit.add(納入通知書期情報);
                納入通知書期情報リストの設定数++;
            }
        }
        edit納付書(納入通知書期情報リストEdit, writer);
    }

    private void set納入通知書期情報リストEdit(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit, int 納入通知書期情報リストの設定数) {
        for (int 設定数 = 1; 設定数 <= 納入通知書期情報リストの設定数; 設定数++) {
            納入通知書期情報リストEdit.add(null);
        }
    }

    private void edit通知書(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit,
            ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> writer) {
        if (納入通知書期情報リストEdit.isEmpty()) {
            return;
        }
        IHokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor editor
                = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor(
                        本算定納入通知書情報, ninshoshaSource);
        IHokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder builder
                = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder(editor);
        writer.writeLine(builder);
    }

    private void edit納付書(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit,
            ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> writer) {
        if (納入通知書期情報リストEdit.isEmpty()) {
            return;
        }
        IHokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor editor
                = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoNofushoEditor(
                        本算定納入通知書情報, 納入通知書期情報リストEdit);
        IHokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder builder
                = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder(editor);
        writer.writeLine(builder);
    }

    private boolean is全部の納付額が0(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (null == 納入通知書期情報) {
                continue;
            }
            if (納入通知書期情報.get納付額() != null && 納入通知書期情報.get納付額().compareTo(Decimal.ZERO) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource>> devidedByPage() {
        List<NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource>> nonyuTsuchishoList = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Cover = getNew本算定納入通知書情報(HenshuHaniKubun.Coverのみ, 納入通知書期情報リスト, true);
        HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport reportCover
                = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(
                        本算定納入通知書情報Cover, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
        nonyuTsuchishoList.add(reportCover);
        if (null == 納入通知書期情報リスト || 納入通知書期情報リスト.isEmpty()) {
            return nonyuTsuchishoList;
        }
        int ブック開始位置 = 納入通知書期情報リスト.get(0).getブック開始位置();
        if (ブック開始位置 > INT5) {
            throw new ApplicationException(DbbErrorMessages.ブック開始位置不正.getMessage());
        }
        boolean isブック開始位置が1 = false;
        if (ブック開始位置 == INT1) {
            納入通知書期情報リスト.remove(0);
            isブック開始位置が1 = true;
        }
        if (納入通知書期情報リスト.isEmpty()) {
            return nonyuTsuchishoList;
        }

        this.edit前中後期リスト(納入通知書期情報リスト);

        if (!納入通知書期情報リスト前期.isEmpty()) {
            boolean isBegin = false;
            this.devidedEdit前中後期(納入通知書期情報リスト前期, isBegin, nonyuTsuchishoList, isブック開始位置が1);
        }
        if (!納入通知書期情報リスト中期.isEmpty()) {
            boolean isBegin = true;
            this.devidedEdit前中後期(納入通知書期情報リスト中期, isBegin, nonyuTsuchishoList, isブック開始位置が1);
        }
        if (!納入通知書期情報リスト後期.isEmpty()) {
            boolean isBegin = true;
            this.devidedEdit前中後期(納入通知書期情報リスト後期, isBegin, nonyuTsuchishoList, isブック開始位置が1);
        }

        return nonyuTsuchishoList;
    }

    private void devidedEdit前中後期(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            boolean isBegin,
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource>> nonyuTsuchishoList,
            boolean isブック開始位置が1) {

        int detail設定数 = 0;
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストDetail = new ArrayList<>();
        HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport reportDetail;
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Detail;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (!isBegin) {
                if (isブック開始位置が1) {
                    納入通知書期情報リストDetail.add(納入通知書期情報);
                    isBegin = true;
                    detail設定数 = INT1;
                } else {
                    int ブック開始位置 = 納入通知書期情報.getブック開始位置();
                    switch (ブック開始位置) {
                        case INT2:
                            detail設定数 = INT1;
                            break;
                        case INT3:
                            set納入通知書期情報リストEdit(納入通知書期情報リストDetail, INT1);
                            detail設定数 = INT2;
                            break;
                        case INT4:
                            set納入通知書期情報リストEdit(納入通知書期情報リストDetail, INT2);
                            detail設定数 = INT3;
                            break;
                        case INT5:
                            set納入通知書期情報リストEdit(納入通知書期情報リストDetail, INT3);
                            detail設定数 = INT4;
                            break;
                        default:
                            break;
                    }
                    納入通知書期情報リストDetail.add(納入通知書期情報);
                    isBegin = true;
                }
            } else if (detail設定数 >= INT4) {
                本算定納入通知書情報Detail
                        = getNew本算定納入通知書情報(HenshuHaniKubun.Detailのみ, 納入通知書期情報リストDetail, false);
                reportDetail = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(
                        本算定納入通知書情報Detail, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
                nonyuTsuchishoList.add(reportDetail);
                納入通知書期情報リストDetail = new ArrayList<>();
                納入通知書期情報リストDetail.add(納入通知書期情報);
                detail設定数 = INT1;
            } else {
                納入通知書期情報リストDetail.add(納入通知書期情報);
                detail設定数++;
            }
        }
        本算定納入通知書情報Detail
                = getNew本算定納入通知書情報(HenshuHaniKubun.Detailのみ, 納入通知書期情報リストDetail, false);
        reportDetail = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(
                本算定納入通知書情報Detail, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
        nonyuTsuchishoList.add(reportDetail);
    }

    private HonSanteiNonyuTsuchiShoJoho getNew本算定納入通知書情報(
            HenshuHaniKubun 編集範囲区分, List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト, boolean is通知書) {
        HonSanteiNonyuTsuchiShoJoho new本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        new本算定納入通知書情報.set本算定納入通知書制御情報(本算定納入通知書情報.get本算定納入通知書制御情報());
        new本算定納入通知書情報.set処理区分(本算定納入通知書情報.get処理区分());
        new本算定納入通知書情報.set出力期リスト(本算定納入通知書情報.get出力期リスト());
        new本算定納入通知書情報.set地方公共団体(本算定納入通知書情報.get地方公共団体());
        new本算定納入通知書情報.set帳票ID(本算定納入通知書情報.get帳票ID());
        new本算定納入通知書情報.set帳票分類ID(本算定納入通知書情報.get帳票分類ID());
        new本算定納入通知書情報.set発行日(本算定納入通知書情報.get発行日());
        new本算定納入通知書情報.set現年度_過年度区分(本算定納入通知書情報.get現年度_過年度区分());
        new本算定納入通知書情報.set納付書共通(本算定納入通知書情報.get納付書共通());
        new本算定納入通知書情報.set編集後本算定通知書共通情報(本算定納入通知書情報.get編集後本算定通知書共通情報());
        new本算定納入通知書情報.set連番(本算定納入通知書情報.get連番());
        if (is通知書) {
            List<NonyuTsuchiShoKiJoho> new納入通知書期情報リスト = new ArrayList<>();
            for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
                new納入通知書期情報リスト.add(納入通知書期情報);
            }
            new本算定納入通知書情報.set納入通知書期情報リスト(new納入通知書期情報リスト);
        } else {
            new本算定納入通知書情報.set納入通知書期情報リスト(納入通知書期情報リスト);
        }
        new本算定納入通知書情報.set編集範囲区分(編集範囲区分);
        return new本算定納入通知書情報;
    }

    private void edit前中後期リスト(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {

        int 中期開始期 = Integer.parseInt(当初出力_中期開始期.toString());
        int 後期開始期 = Integer.parseInt(当初出力_後期開始期.toString());

        if (中期開始期 != 0 && 後期開始期 != 0) {
            int 前期 = 0;
            for (int i = 納入通知書期情報リスト.get(0).get期(); i <= 中期開始期 - 1; i++) {
                納入通知書期情報リスト前期.add(納入通知書期情報リスト.get(前期));
                前期++;
            }
            if (納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期() < 中期開始期) {
                return;
            }
            int 中期 = 前期;
            for (int i = 中期開始期; i <= 後期開始期 - 1; i++) {
                納入通知書期情報リスト中期.add(納入通知書期情報リスト.get(中期));
                中期++;
            }
            if (納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期() < 後期開始期) {
                return;
            }
            int 後期 = 中期;
            for (int i = 後期開始期; i <= 納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期(); i++) {
                納入通知書期情報リスト後期.add(納入通知書期情報リスト.get(後期));
                後期++;
            }
        } else if (中期開始期 == 0 && 後期開始期 != 0) {
            int 前期 = 0;
            for (int i = 納入通知書期情報リスト.get(0).get期(); i <= 後期開始期 - 1; i++) {
                納入通知書期情報リスト前期.add(納入通知書期情報リスト.get(前期));
                前期++;
            }
            if (納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期() < 後期開始期) {
                return;
            }
            int 後期 = 前期;
            for (int i = 後期開始期; i <= 納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期(); i++) {
                納入通知書期情報リスト後期.add(納入通知書期情報リスト.get(後期));
                後期++;
            }
        } else if (中期開始期 == 0 && 後期開始期 == 0) {
            納入通知書期情報リスト前期.addAll(納入通知書期情報リスト);
        }
    }
}
