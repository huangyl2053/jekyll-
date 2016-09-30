/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakugassan;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanhoseizumijikofutangakusofuchiran.GassanHoseizumiJikofutangakuSofuchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算補正済自己負担額情報送付一覧表の改ページ処理するクラスです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public class KogakugassanHoseisumiJikofutangakuOutPageBreak extends PageBreaker<GassanHoseizumiJikofutangakuSofuchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KogakugassanHoseisumiJikofutangakuOutPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanHoseizumiJikofutangakuSofuchiranSource> currentSource,
            ReportLineRecord<GassanHoseizumiJikofutangakuSofuchiranSource> nextSource) {

        if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            return true;
        } else if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            return true;
        } else if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            return true;
        } else if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            return true;
        } else if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().exShoHokenshaNo.equals(nextSource.getSource().exShoHokenshaNo)) {
            return true;
        } else if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().list_3.equals(nextSource.getSource().list_3)) {
            return true;
        } else if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.対象年度.get項目ID())
                && !currentSource.getSource().list_2.equals(nextSource.getSource().list_2)) {
            return true;
        }
        return canBreak(currentSource, nextSource);
    }

    private boolean canBreak(ReportLineRecord<GassanHoseizumiJikofutangakuSofuchiranSource> currentSource,
            ReportLineRecord<GassanHoseizumiJikofutangakuSofuchiranSource> nextSource) {
        if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.申請書整理番号.get項目ID())
                && !currentSource.getSource().list_4.equals(nextSource.getSource().list_4)) {
            return true;
        } else if (this.breakKeysList.contains(KogakugassanHoseisumiJikofutangakuOutputOrder.受取年月.get項目ID())
                && !currentSource.getSource().list_6.equals(nextSource.getSource().list_6)) {
            return true;
        }
        return false;
    }
}
