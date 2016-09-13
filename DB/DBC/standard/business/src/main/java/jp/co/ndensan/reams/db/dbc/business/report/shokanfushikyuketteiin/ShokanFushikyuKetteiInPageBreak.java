/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 償還払不支給決定情報取込 のPageBreakクラスです。
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public class ShokanFushikyuKetteiInPageBreak extends PageBreaker<ShokanbaraiFushikyuKetteishaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public ShokanFushikyuKetteiInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<ShokanbaraiFushikyuKetteishaIchiranSource> currentSource,
            ReportLineRecord<ShokanbaraiFushikyuKetteishaIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(ShokanFushikyuKetteiInOutPutOrder.証記載保険者番号.getフォームフィールド名())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource ShokanFushikyuKetteiInEntity
     * @param nextSource ShokanFushikyuKetteiInEntity
     * @return 改頁Flag
     */
    public boolean is改頁(ShokanFushikyuKetteiInEntity currentSource,
            ShokanFushikyuKetteiInEntity nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(ShokanFushikyuKetteiInOutPutOrder.証記載保険者番号.getフォームフィールド名())
                && !currentSource.get証記載保険者番号().equals(nextSource.get証記載保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(ShokanFushikyuKetteiInOutPutOrder.町域コード.getフォームフィールド名())
                && !currentSource.get町域コード().equals(nextSource.get町域コード())) {
            flag = true;
        } else if (this.breakKeysList.contains(ShokanFushikyuKetteiInOutPutOrder.行政区コード.getフォームフィールド名())
                && !currentSource.get行政区コード().equals(nextSource.get行政区コード())) {
            flag = true;
        } else if (this.breakKeysList.contains(ShokanFushikyuKetteiInOutPutOrder.被保険者番号.getフォームフィールド名())
                && !currentSource.get被保険者番号().equals(nextSource.get被保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(ShokanFushikyuKetteiInOutPutOrder.通知書番号.getフォームフィールド名())
                && !currentSource.get決定通知().equals(nextSource.get決定通知())) {
            flag = true;
        } else if (this.breakKeysList.contains(ShokanFushikyuKetteiInOutPutOrder.整理番号.getフォームフィールド名())
                && !currentSource.get整理番号().equals(nextSource.get整理番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(ShokanFushikyuKetteiInOutPutOrder.サービス種類コード.getフォームフィールド名())
                && !currentSource.getサービス種類コード().equals(nextSource.getサービス種類コード())) {
            flag = true;
        }
        return flag;
    }
}
