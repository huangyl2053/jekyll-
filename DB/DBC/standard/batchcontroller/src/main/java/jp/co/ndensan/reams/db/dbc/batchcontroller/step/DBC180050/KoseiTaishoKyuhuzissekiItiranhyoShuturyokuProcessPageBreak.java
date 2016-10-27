/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(改頁クラス)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessPageBreak extends PageBreaker<KoseiTaishoJissekiIchiranSource> {

    private final List<RString> breakKeysList;
    private static final RString キー_年度 = new RString("年度");
    private static final RString キー_被保険者番号 = new RString("被保険者番号");
    private static final RString キー_サービス提供年月 = new RString("サービス提供年月");

    /**
     *
     * @param breakKeys ページングキー
     */
    public KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KoseiTaishoJissekiIchiranSource> currentSource,
            ReportLineRecord<KoseiTaishoJissekiIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(キー_年度)
                || this.breakKeysList.contains(キー_被保険者番号)
                || this.breakKeysList.contains(キー_サービス提供年月)) {
            if (currentSource.getSource().listKyufuJisseki_4.equals(nextSource.getSource().listKyufuJisseki_4)) {
                flag = true;
            }
            if (currentSource.getSource().listKyufuJisseki_2.equals(nextSource.getSource().listKyufuJisseki_2)) {
                flag = true;
            }
            if (currentSource.getSource().listKyufuJisseki_5.equals(nextSource.getSource().listKyufuJisseki_5)) {
                flag = true;
            }
        }
        return flag;
    }

}
