/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kijunshunyugakutekiyokettei.KijunShunyugakuTekiyoKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 基準収入額決定通知一覧表のPageBreakクラスです。
 *
 * @reamsid_L DBC-4610-050 xuhao
 */
public class KijunShunyugakuTekiyoKetteiTsuchiIchiranPageBreak extends PageBreaker<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KijunShunyugakuTekiyoKetteiTsuchiIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> currentSource,
            ReportLineRecord<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.年度.getフォームフィールド名())
                && !currentSource.getSource().listHakkoTaishosha_3.equals(nextSource.getSource().listHakkoTaishosha_3)) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.申請年月日.getフォームフィールド名())
                && !currentSource.getSource().listHakkoTaishosha_6.equals(nextSource.getSource().listHakkoTaishosha_6)) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.決定年月日.getフォームフィールド名())
                && !currentSource.getSource().listHakkoTaishosha_7.equals(nextSource.getSource().listHakkoTaishosha_7)) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.適用開始年月.getフォームフィールド名())
                && !currentSource.getSource().listHakkoTaishosha_8.equals(nextSource.getSource().listHakkoTaishosha_8)) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.算定基準額.getフォームフィールド名())
                && !currentSource.getSource().listHakkoTaishosha_9.equals(nextSource.getSource().listHakkoTaishosha_9)) {
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
        if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.年度.getフォームフィールド名())
                && !currentSource.get年度().equals(nextSource.get年度())) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.申請年月日.getフォームフィールド名())
                && !currentSource.get申請日().equals(nextSource.get申請日())) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.決定年月日.getフォームフィールド名())
                && !currentSource.get決定日().equals(nextSource.get決定日())) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.適用開始年月.getフォームフィールド名())
                && !currentSource.get適用開始年月().equals(nextSource.get適用開始年月())) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.算定基準額.getフォームフィールド名())
                && !currentSource.get算定基準額().equals(nextSource.get算定基準額())) {
            flag = true;
        }
        return flag;
    }
}
