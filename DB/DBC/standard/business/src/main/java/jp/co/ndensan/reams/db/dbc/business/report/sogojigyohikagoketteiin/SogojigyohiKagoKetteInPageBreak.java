/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kijunshunyugakutekiyokettei.KijunShunyugakuTekiyoKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業費（経過措置）過誤決定通知書情報取込一覧表帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2550-030　jianglaishen
 */
public class SogojigyohiKagoKetteInPageBreak extends PageBreaker<SogojigyohiKagoKetteiInSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public SogojigyohiKagoKetteInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiKagoKetteiInSource> currentSource,
            ReportLineRecord<SogojigyohiKagoKetteiInSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(SogojigyohiKagoKetteInOutPutOrder.被保険者番号.getフォームフィールド名())
                && !currentSource.getSource().listUpper_4.equals(nextSource.getSource().listUpper_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteInOutPutOrder.サービス提供年月.getフォームフィールド名())
                && !currentSource.getSource().listUpper_6.equals(nextSource.getSource().listUpper_6)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteInOutPutOrder.事業所番号.getフォームフィールド名())
                && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteInOutPutOrder.取り扱い年月.getフォームフィールド名())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource KijunShunyugakuTekiyoKetteiEntity
     * @param nextSource KijunShunyugakuTekiyoKetteiEntity
     * @return 改頁Flag
     */
    public boolean is改頁(KijunShunyugakuTekiyoKetteiEntity currentSource,
            KijunShunyugakuTekiyoKetteiEntity nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(SogojigyohiKagoKetteInOutPutOrder.被保険者番号.getフォームフィールド名())
                && !currentSource.get年度().equals(nextSource.get年度())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteInOutPutOrder.サービス提供年月.getフォームフィールド名())
                && !currentSource.get申請日().equals(nextSource.get申請日())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteInOutPutOrder.事業所番号.getフォームフィールド名())
                && !currentSource.get決定日().equals(nextSource.get決定日())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteInOutPutOrder.取り扱い年月.getフォームフィールド名())
                && !currentSource.get適用開始年月().equals(nextSource.get適用開始年月())) {
            flag = true;
        }
        return flag;
    }
}
