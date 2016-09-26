/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200040;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200040.GassanShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算支給決定通知書発行processのPageBreakクラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
public class GassanShikyuFushikyuKetteishaIchiranPageBreak extends PageBreaker<GassanShikyuFushikyuKetteishaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public GassanShikyuFushikyuKetteishaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanShikyuFushikyuKetteishaIchiranSource> currentSource,
            ReportLineRecord<GassanShikyuFushikyuKetteishaIchiranSource> nextSource) {
        boolean flag = false;
        if (!RString.EMPTY.equals(nextSource.getSource().listCerter_2)) {
            if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.被保険者番号.get項目ID())
                    && !currentSource.getSource().listCerter_2.equals(nextSource.getSource().listCerter_2)) {
                flag = true;
            } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.申請年月日.get項目ID())
                    && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
                flag = true;
            } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.対象年度.get項目ID())
                    && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
                flag = true;
            } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.申請書整理番号.get項目ID())
                    && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
                flag = true;
            }
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
    public boolean is改頁(KogakugassanShikyuKetteitsuchishoEntity currentSource,
            KogakugassanShikyuKetteitsuchishoEntity nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.getHihokenshaNo().equals(nextSource.getHihokenshaNo())) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.申請年月日.get項目ID())
                && !currentSource.getShinseiYMD().equals(nextSource.getShinseiYMD())) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.対象年度.get項目ID())
                && !currentSource.getTaishoNendo().equals(nextSource.getTaishoNendo())) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.申請書整理番号.get項目ID())
                && !currentSource.getShikyuSeiriNo().equals(nextSource.getShikyuSeiriNo())) {
            flag = true;
        }
        return flag;
    }

}
