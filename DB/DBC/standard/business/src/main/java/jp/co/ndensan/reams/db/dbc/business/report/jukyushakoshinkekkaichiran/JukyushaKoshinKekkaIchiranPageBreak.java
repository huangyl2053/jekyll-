/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranProperty.DBC120030ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 受給者情報更新結果情報取込一覧表帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2730-030　chenjie
 */
public class JukyushaKoshinKekkaIchiranPageBreak extends PageBreaker<JukyushaKoshinKekkaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public JukyushaKoshinKekkaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<JukyushaKoshinKekkaIchiranSource> currentSource,
            ReportLineRecord<JukyushaKoshinKekkaIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.保険者番号.getフォームフィールド名())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.被保険者番号.getフォームフィールド名())
                && !currentSource.getSource().listList1_4.equals(nextSource.getSource().listList1_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.郵便番号.getフォームフィールド名())
                && !currentSource.getSource().listList1_4.equals(nextSource.getSource().listList1_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.町域コード.getフォームフィールド名())
                && !currentSource.getSource().listList1_4.equals(nextSource.getSource().listList1_4)) {
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.行政区コード.getフォームフィールド名())
                && !currentSource.getSource().listList1_6.equals(nextSource.getSource().listList1_6)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.氏名５０音カナ.getフォームフィールド名())
                && !currentSource.getSource().listList1_4.equals(nextSource.getSource().listList1_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.市町村コード.getフォームフィールド名())
                && !currentSource.getSource().listList1_4.equals(nextSource.getSource().listList1_4)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource KijunShunyugakuTekiyoKetteiEntity
     * @param nextSource KijunShunyugakuTekiyoKetteiEntity
     * @return 改頁Flag
     */
    public boolean is改頁(JukyushaHihokenshaEntity currentSource,
            JukyushaHihokenshaEntity nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.保険者番号.getフォームフィールド名())
                && !currentSource.get受給者情報明細一時().get保険者番号().equals(nextSource.get受給者情報明細一時().get保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.被保険者番号.getフォームフィールド名())
                && !currentSource.get被保険者一時().get被保険者番号().equals(nextSource.get被保険者一時().get被保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.郵便番号.getフォームフィールド名())
                && !currentSource.get被保険者一時().get郵便番号().equals(nextSource.get被保険者一時().get郵便番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.町域コード.getフォームフィールド名())
                && !currentSource.get被保険者一時().get町域コード().equals(nextSource.get被保険者一時().get町域コード())) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.行政区コード.getフォームフィールド名())
                && !currentSource.get被保険者一時().get行政区コード().equals(nextSource.get被保険者一時().get行政区コード())) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.氏名５０音カナ.getフォームフィールド名())
                && !currentSource.get被保険者一時().get氏名50音カナ().equals(nextSource.get被保険者一時().get氏名50音カナ())) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.市町村コード.getフォームフィールド名())
                && !currentSource.get被保険者一時().get市町村コード().equals(nextSource.get被保険者一時().get市町村コード())) {
            flag = true;
        }
        return flag;
    }
}
