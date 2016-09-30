/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjikofutangakuhakkoichiran.GassanJikofutangakuHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 自己負担証明書作成（括）の改ページ処理するクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class JikoFutangakushomeishoPageBreak extends PageBreaker<GassanJikofutangakuHakkoIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public JikoFutangakushomeishoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanJikofutangakuHakkoIchiranSource> currentSource,
            ReportLineRecord<GassanJikofutangakuHakkoIchiranSource> nextSource) {
        if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.郵便番号.get項目ID())
                && !currentSource.getSource().郵便番号.equals(nextSource.getSource().郵便番号)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.町域コード.get項目ID())
                && !currentSource.getSource().町域コード.equals(nextSource.getSource().町域コード)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.行政区コード.get項目ID())
                && !currentSource.getSource().行政区コード.equals(nextSource.getSource().行政区コード)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.市町村コード.get項目ID())
                && !currentSource.getSource().市町村コード.equals(nextSource.getSource().市町村コード)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().氏名５０音カナ.equals(nextSource.getSource().氏名５０音カナ)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.証記載保険者番号.get項目ID())
                && !currentSource.getSource().証記載保険者番号.equals(nextSource.getSource().証記載保険者番号)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().list_2.equals(nextSource.getSource().list_2)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.申請書整理番号.get項目ID())
                && !currentSource.getSource().list_6.equals(nextSource.getSource().list_6)) {
            return true;
        }
        return false;
    }

}
