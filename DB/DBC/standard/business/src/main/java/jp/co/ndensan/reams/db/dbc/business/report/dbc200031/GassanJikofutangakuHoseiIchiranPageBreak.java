/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200031;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200031.GassanJikofutangakuHoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200031.GassanJikofutangakuHoseiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算自己負担額情報補正（一括）のPageBreakクラスです。
 *
 * @reamsid_L DBC-2320-030 chenyadong
 */
public class GassanJikofutangakuHoseiIchiranPageBreak extends PageBreaker<GassanJikofutangakuHoseiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public GassanJikofutangakuHoseiIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanJikofutangakuHoseiIchiranSource> currentSource,
            ReportLineRecord<GassanJikofutangakuHoseiIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listList1_1.equals(nextSource.getSource().listList1_1)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.申請書整理番号.get項目ID())
                && !currentSource.getSource().listList1_5.equals(nextSource.getSource().listList1_5)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.対象年度.get項目ID())
                && !currentSource.getSource().listList1_6.equals(nextSource.getSource().listList1_6)) {
            flag = true;
        } else {
            isFlag(currentSource, nextSource);
        }
        return flag;
    }

    private boolean isFlag(ReportLineRecord<GassanJikofutangakuHoseiIchiranSource> currentSource,
            ReportLineRecord<GassanJikofutangakuHoseiIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().add_hokenshaNo.equals(nextSource.getSource().add_hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().add_shichosonCode.equals(nextSource.getSource().add_shichosonCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().add_gyoseikuCode.equals(nextSource.getSource().add_gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().add_yubinNo.equals(nextSource.getSource().add_yubinNo)) {
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
    public boolean is改頁(GassanJikofutangakuHoseiIchiranEntity currentSource,
            GassanJikofutangakuHoseiIchiranEntity nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.申請書整理番号.get項目ID())
                && !currentSource.get申請書整理番号().equals(nextSource.get申請書整理番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.get被保険者番号().equals(nextSource.get被保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuHoseiOutPutOrder.対象年度.get項目ID())
                && !currentSource.get申請対象年度().equals(nextSource.get申請対象年度())) {
            flag = true;
        }
        return flag;
    }
}
