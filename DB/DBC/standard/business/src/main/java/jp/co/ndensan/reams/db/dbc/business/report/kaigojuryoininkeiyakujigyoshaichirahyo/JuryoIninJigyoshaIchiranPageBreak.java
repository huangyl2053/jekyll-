/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 受領委任契約事業者一覧表のPageBreakクラスです。
 *
 * @reamsid_L DBC-4730-040 liuxiaoyu
 */
public class JuryoIninJigyoshaIchiranPageBreak extends PageBreaker<JuryoIninJigyoshaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public JuryoIninJigyoshaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<JuryoIninJigyoshaIchiranSource> currentSource,
            ReportLineRecord<JuryoIninJigyoshaIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder.契約事業者番号.get項目ID())
                && !currentSource.getSource().listUpper_1.equals(nextSource.getSource().listUpper_1)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder.契約事業者郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder.契約開始年月日.get項目ID())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            flag = true;
        } else if (this.breakKeysList.contains(KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder.契約種別.get項目ID())
                && !currentSource.getSource().listLower_3.equals(nextSource.getSource().listLower_3)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource JuryoIninJigyoshaIchiranEntity
     * @param nextSource JuryoIninJigyoshaIchiranEntity
     * @return 改頁Flag
     */
    public boolean is改頁(JuryoIninJigyoshaIchiranEntity currentSource,
            JuryoIninJigyoshaIchiranEntity nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder.契約事業者番号.get項目ID())
                && !currentSource.get事業者番号().equals(nextSource.get事業者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder.契約事業者郵便番号.get項目ID())
                && !currentSource.get所在地郵番号().equals(nextSource.get所在地郵番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder.契約開始年月日.get項目ID())
                && !currentSource.get契約開始日().equals(nextSource.get契約開始日())) {
            flag = true;
        } else if (this.breakKeysList.contains(KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder.契約種別.get項目ID())
                && !currentSource.get契約種別().equals(nextSource.get契約種別())) {
            flag = true;
        }
        return flag;
    }
}
