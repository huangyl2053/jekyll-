/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.KogakuGassanJikofutangaku;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.GassanJikofutangakuShomeishoTorikomiIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoDateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票設計_DBC200034_高額合算自己負担額証明書情報取込一覧表のす。PageBreakクラスです。
 *
 * @reamsid_L DBC-2640-030 zhengshenlei
 */
public class KogakuGassanJikofutangakuShomeiPageBreak extends PageBreaker<GassanJikofutangakuShomeishoTorikomiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * 高額合算自己負担額証明書情報取込一覧表
     *
     * @param breakKeys List<RString>
     */
    public KogakuGassanJikofutangakuShomeiPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanJikofutangakuShomeishoTorikomiIchiranSource> currentSource,
            ReportLineRecord<GassanJikofutangakuShomeishoTorikomiIchiranSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(
                KogakuGassanJikofutangakuShomeiOutputOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.自己負担額の差異.get項目ID())
                && !currentSource.getSource().list_14.equals(nextSource.getSource().list_14)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flg = true;
        } else {
            flg = isBreak1(currentSource, nextSource, flg);
        }
        return flg;
    }

    private boolean isBreak1(ReportLineRecord<GassanJikofutangakuShomeishoTorikomiIchiranSource> currentSource,
            ReportLineRecord<GassanJikofutangakuShomeishoTorikomiIchiranSource> nextSource, boolean flg) {
        if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().list_3.equals(nextSource.getSource().list_3)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.対象年度.get項目ID())
                && !currentSource.getSource().list_2.equals(nextSource.getSource().list_2)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.申請年月日.get項目ID())
                && !currentSource.getSource().list_7.equals(nextSource.getSource().list_7)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.申請書整理番号.get項目ID())
                && !currentSource.getSource().list_5.equals(nextSource.getSource().list_5)) {
            flg = true;
        } else if (this.breakKeysList
                .contains(KogakuGassanJikofutangakuShomeiOutputOrder.証明書整理番号.get項目ID())
                && !currentSource.getSource().list_11.equals(nextSource.getSource().list_11)) {
            flg = true;
        }
        return flg;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource KogakuGassanJikofutangakuShomeishoDateEntity
     * @param nextSource KogakuGassanJikofutangakuShomeishoDateEntity
     * @return 改頁Flag
     */
    public boolean is改頁(KogakuGassanJikofutangakuShomeishoDateEntity currentSource,
            KogakuGassanJikofutangakuShomeishoDateEntity nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(
                KogakuGassanJikofutangakuShomeiOutputOrder.証記載保険者番号.get項目ID())
                && !currentSource.get被保険者_証記載保険者番号().equals(nextSource.get被保険者_証記載保険者番号())) {
            flg = true;
        }
        return flg;
    }
}
