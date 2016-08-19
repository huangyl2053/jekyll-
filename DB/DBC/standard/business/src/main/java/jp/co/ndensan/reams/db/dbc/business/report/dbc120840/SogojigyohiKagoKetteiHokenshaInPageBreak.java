/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120840;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc120840.SogojigyohiKagoKetteiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票設計_DBC200085_総合事業費過誤決定通知書情報取込一覧表帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2550-031　jiangxiaolong
 */
public class SogojigyohiKagoKetteiHokenshaInPageBreak extends PageBreaker<SogojigyohiKagoKetteiTorikomiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public SogojigyohiKagoKetteiHokenshaInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiKagoKetteiTorikomiIchiranSource> currentSource,
            ReportLineRecord<SogojigyohiKagoKetteiTorikomiIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.証記載保険者番号.getフォームフィールド名())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.被保険者番号.getフォームフィールド名())
                && !currentSource.getSource().listUpper_4.equals(nextSource.getSource().listUpper_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.サービス提供年月.getフォームフィールド名())
                && !currentSource.getSource().listUpper_6.equals(nextSource.getSource().listUpper_6)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.事業所番号.getフォームフィールド名())
                && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.取り扱い年月.getフォームフィールド名())
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
    public boolean is改頁(SogojigyohiKagoKetteiInEntity currentSource,
            SogojigyohiKagoKetteiInEntity nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.証記載保険者番号.getフォームフィールド名())
                && !currentSource.get証記載保険者番号().equals(nextSource.get証記載保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.被保険者番号.getフォームフィールド名())
                && !currentSource.get被保険者番号().equals(nextSource.get被保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.サービス提供年月.getフォームフィールド名())
                && !currentSource.getサービ提供年月().equals(nextSource.getサービ提供年月())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.事業所番号.getフォームフィールド名())
                && !currentSource.get事業者番号().equals(nextSource.get事業者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKagoKetteiHokenshaInOutPutOrder.取り扱い年月.getフォームフィールド名())
                && !currentSource.get取扱年月().equals(nextSource.get取扱年月())) {
            flag = true;
        }
        return flag;
    }
}
