/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakugassan;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakutorikomiichiran.GassanShikyugakuTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算支給額計算結果連絡票情報取込一覧表の改ページ処理するクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class KogakuGassanTorikomiIchiranPageBreak extends PageBreaker<GassanShikyugakuTorikomiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KogakuGassanTorikomiIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanShikyugakuTorikomiIchiranSource> currentSource,
            ReportLineRecord<GassanShikyugakuTorikomiIchiranSource> nextSource) {

        if (this.breakKeysList.contains(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().hihokenshaNo.equals(nextSource.getSource().hihokenshaNo)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.対象年度.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.申請書整理番号.get項目ID())
                && !currentSource.getSource().listUpper_4.equals(nextSource.getSource().listUpper_4)) {
            return true;
        }
        return false;
    }
}
