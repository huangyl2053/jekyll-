/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteitsuchisho;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohisaishinsaketteitsuchisho.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohisaishin.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業費再審査決定通知書情報取込（公費負担者分）のPageBreakクラスです。
 *
 * @reamsid_L DBC-4730-040 liuxiaoyu
 */
public class SogojigyohiSaishinsaKetteitsuchishoPageBreak extends PageBreaker<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public SogojigyohiSaishinsaKetteitsuchishoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource> currentSource,
            ReportLineRecord<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.公費負担者番号.getフォームフィールド名())
                && !currentSource.getSource().koshiFutanshaNo.equals(nextSource.getSource().koshiFutanshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.被保険者番号.getフォームフィールド名())
                && !currentSource.getSource().listLower_1.equals(nextSource.getSource().listLower_1)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.サービス提供年月.getフォームフィールド名())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.事業者番号.getフォームフィールド名())
                && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.取り扱い年月.getフォームフィールド名())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity
     * @param nextSource SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity
     * @return 改頁Flag
     */
    public boolean is改頁(SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity currentSource,
            SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.公費負担者番号.getフォームフィールド名())
                && !currentSource.get公費負担者番号().equals(nextSource.get公費負担者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.被保険者番号.getフォームフィールド名())
                && !currentSource.get被保険者番号().equals(nextSource.get被保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.サービス提供年月.getフォームフィールド名())
                && !currentSource.getサービス提供年月().equals(nextSource.getサービス提供年月())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.事業者番号.getフォームフィールド名())
                && !currentSource.get事業者番号().equals(nextSource.get事業者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiSaishinsaOutPutOrder.取り扱い年月.getフォームフィールド名())
                && !currentSource.get取扱年月().equals(nextSource.get取扱年月())) {
            flag = true;
        }
        return flag;
    }

}
