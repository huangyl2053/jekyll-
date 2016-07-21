/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼なし）通知書
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport
        extends NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT1 = 1;
    private static final int INT2 = 2;

    /**
     * コンストラクタです。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     */
    protected KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     * @return KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport createFrom(
            @NonNull KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        return new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport(仮算定納入通知書情報, ninshoshaSource);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> writer) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        if (null == 納入通知書期情報リスト || is全部の納付額が0(納入通知書期情報リスト)) {
            return;
        }
        if (HenshuHaniKubun.Detailのみ.equals(仮算定納入通知書情報.get編集範囲区分())) {
            edit納付書(納入通知書期情報リスト, 1, writer);
            return;
        }
        if (仮算定納入通知書情報.get仮算定納入通知書制御情報() != null
                && 仮算定納入通知書情報.get編集後仮算定通知書共通情報() != null
                && 仮算定納入通知書情報.get編集後仮算定通知書共通情報().get更正後() != null
                && ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())
                && KozaKubun.口座振替.equals(仮算定納入通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後口座区分())
                && 仮算定納入通知書情報.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                && HyojiUmu.表示しない
                .equals(仮算定納入通知書情報.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
            仮算定納入通知書情報.set編集範囲区分(HenshuHaniKubun.Coverのみ);
        }
        edit納入通知書期情報(納入通知書期情報リスト, writer);
    }

    private void edit納入通知書期情報(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> writer) {
        int ページ = INT1;
        HenshuHaniKubun 編集範囲区分 = 仮算定納入通知書情報.get編集範囲区分();
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
                    edit納付書(納入通知書期情報リストEdit, ページ, writer);
                    ページ++;
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
                edit納付書(納入通知書期情報リストEdit, ページ, writer);
                ページ++;
                納入通知書期情報リストEdit = new ArrayList<>();
                納入通知書期情報リストの設定数 = 0;
            } else {
                納入通知書期情報リストEdit.add(納入通知書期情報);
                納入通知書期情報リストの設定数++;
            }
        }
        edit納付書(納入通知書期情報リストEdit, ページ, writer);
    }

    private void set納入通知書期情報リストEdit(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit, int 納入通知書期情報リストの設定数) {
        for (int 設定数 = 1; 設定数 <= 納入通知書期情報リストの設定数; 設定数++) {
            納入通知書期情報リストEdit.add(null);
        }
    }

    private void edit通知書(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit,
            ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> writer) {
        if (納入通知書期情報リストEdit.isEmpty()) {
            return;
        }
        IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverEditor editor
                = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverEditor(
                        仮算定納入通知書情報, 納入通知書期情報リストEdit, ninshoshaSource);
        IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder builder
                = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder(editor);
        writer.writeLine(builder);
    }

    private void edit納付書(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit, int ページ,
            ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> writer) {
        if (納入通知書期情報リストEdit.isEmpty()) {
            return;
        }
        IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverEditor editor
                = new HokenryoNonyuTsuchishoBookNofushoNashiEditor(
                        仮算定納入通知書情報, 納入通知書期情報リストEdit, ページ);
        IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder builder
                = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder(editor);
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
    public List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource>> devidedByPage() {
        List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource>> nonyuTsuchishoList = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Cover = getNew仮算定納入通知書情報(HenshuHaniKubun.Coverのみ, 納入通知書期情報リスト, true);
        KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport reportCover
                = KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport.createFrom(仮算定納入通知書情報Cover, ninshoshaSource);
        nonyuTsuchishoList.add(reportCover);
        if (仮算定納入通知書情報.get仮算定納入通知書制御情報() != null
                && 仮算定納入通知書情報.get編集後仮算定通知書共通情報() != null
                && 仮算定納入通知書情報.get編集後仮算定通知書共通情報().get更正後() != null
                && ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())
                && KozaKubun.口座振替.equals(仮算定納入通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後口座区分())
                && 仮算定納入通知書情報.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                && HyojiUmu.表示しない
                .equals(仮算定納入通知書情報.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
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
        boolean isBegin = false;
        int detail設定数 = 0;
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストDetail = new ArrayList<>();
        KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport reportDetail;
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Detail;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (!isBegin) {
                if (isブック開始位置が1) {
                    納入通知書期情報リストDetail.add(納入通知書期情報);
                    isBegin = true;
                    detail設定数 = INT1;
                } else {
                    ブック開始位置 = 納入通知書期情報.getブック開始位置();
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
            } else {
                if (detail設定数 >= INT4) {
                    仮算定納入通知書情報Detail
                            = getNew仮算定納入通知書情報(HenshuHaniKubun.Detailのみ, 納入通知書期情報リストDetail, false);
                    reportDetail = KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport
                            .createFrom(仮算定納入通知書情報Detail, ninshoshaSource);
                    nonyuTsuchishoList.add(reportDetail);
                    納入通知書期情報リストDetail = new ArrayList<>();
                    納入通知書期情報リストDetail.add(納入通知書期情報);
                    detail設定数 = INT1;
                } else {
                    納入通知書期情報リストDetail.add(納入通知書期情報);
                    detail設定数++;
                }
            }
        }
        仮算定納入通知書情報Detail
                = getNew仮算定納入通知書情報(HenshuHaniKubun.Detailのみ, 納入通知書期情報リストDetail, false);
        reportDetail = KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport
                .createFrom(仮算定納入通知書情報Detail, ninshoshaSource);
        nonyuTsuchishoList.add(reportDetail);
        return nonyuTsuchishoList;
    }

    private KariSanteiNonyuTsuchiShoJoho getNew仮算定納入通知書情報(
            HenshuHaniKubun 編集範囲区分, List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト, boolean is通知書) {
        KariSanteiNonyuTsuchiShoJoho new仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        new仮算定納入通知書情報.set仮算定納入通知書制御情報(仮算定納入通知書情報.get仮算定納入通知書制御情報());
        new仮算定納入通知書情報.set処理区分(仮算定納入通知書情報.get処理区分());
        new仮算定納入通知書情報.set出力期リスト(仮算定納入通知書情報.get出力期リスト());
        new仮算定納入通知書情報.set地方公共団体(仮算定納入通知書情報.get地方公共団体());
        new仮算定納入通知書情報.set帳票ID(仮算定納入通知書情報.get帳票ID());
        new仮算定納入通知書情報.set帳票分類ID(仮算定納入通知書情報.get帳票分類ID());
        new仮算定納入通知書情報.set発行日(仮算定納入通知書情報.get発行日());
        new仮算定納入通知書情報.set算定の基礎(仮算定納入通知書情報.get算定の基礎());
        new仮算定納入通知書情報.set納付書共通(仮算定納入通知書情報.get納付書共通());
        new仮算定納入通知書情報.set編集後仮算定通知書共通情報(仮算定納入通知書情報.get編集後仮算定通知書共通情報());
        new仮算定納入通知書情報.set連番(仮算定納入通知書情報.get連番());
        if (is通知書) {
            List<NonyuTsuchiShoKiJoho> new納入通知書期情報リスト = new ArrayList<>();
            for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
                new納入通知書期情報リスト.add(納入通知書期情報);
            }
            new仮算定納入通知書情報.set納入通知書期情報リスト(new納入通知書期情報リスト);
        } else {
            new仮算定納入通知書情報.set納入通知書期情報リスト(納入通知書期情報リスト);
        }
        new仮算定納入通知書情報.set編集範囲区分(編集範囲区分);
        return new仮算定納入通知書情報;
    }
}
