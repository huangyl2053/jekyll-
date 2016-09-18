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
 * 高額合算自己負担額証明書発行一覧表の改ページ処理するクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
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
        //QA 1527
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
                && !currentSource.getSource().市町村コード.equals(nextSource.getSource().市町村コード)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.証記載保険者番号.get項目ID())
                && !currentSource.getSource().証記載保険者番号.equals(nextSource.getSource().証記載保険者番号)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().list_2.equals(nextSource.getSource().list_2)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.支給区分コード.get項目ID())
                && !currentSource.getSource().支給区分コード.equals(nextSource.getSource().支給区分コード)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.申請書整理番号.get項目ID())
                && !currentSource.getSource().list_6.equals(nextSource.getSource().list_6)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.新規継続区分.get項目ID())
                && !currentSource.getSource().新規継続区分.equals(nextSource.getSource().新規継続区分)) {
            return true;
        } else if (part2(currentSource, nextSource)) {
            return true;
        }
        return false;
    }

    private boolean part2(ReportLineRecord<GassanJikofutangakuHakkoIchiranSource> currentSource,
            ReportLineRecord<GassanJikofutangakuHakkoIchiranSource> nextSource) {
        if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.支給区分コード.get項目ID())
                && !currentSource.getSource().支給区分コード.equals(nextSource.getSource().支給区分コード)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.申請書整理番号.get項目ID())
                && !currentSource.getSource().list_6.equals(nextSource.getSource().list_6)) {
            return true;
        } else if (this.breakKeysList.contains(JikoFutangakushomeishoShutsuryokujunEnum.新規継続区分.get項目ID())
                && !currentSource.getSource().新規継続区分.equals(nextSource.getSource().新規継続区分)) {
            return true;
        }
        return false;
    }
}
