/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranProperty.DBC200073BreakerFieldsEnum;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 給付管理票取込結果一覧表のPageBreakクラスです。
 *
 * @reamsid_L DBC-2450-040 zhangrui
 */
public class KyufuKanrihyoTorikomiKekkaIchiranPageBreak
        extends PageBreaker<KyufuKanrihyoTorikomiKekkaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys ページングキー
     */
    public KyufuKanrihyoTorikomiKekkaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KyufuKanrihyoTorikomiKekkaIchiranSource> currentSource,
            ReportLineRecord<KyufuKanrihyoTorikomiKekkaIchiranSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200073BreakerFieldsEnum.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200073BreakerFieldsEnum.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200073BreakerFieldsEnum.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200073BreakerFieldsEnum.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200073BreakerFieldsEnum.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200073BreakerFieldsEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().listCenter_4.equals(nextSource.getSource().listCenter_4)) {
            flag = true;
        }
        return flag;
    }

}
