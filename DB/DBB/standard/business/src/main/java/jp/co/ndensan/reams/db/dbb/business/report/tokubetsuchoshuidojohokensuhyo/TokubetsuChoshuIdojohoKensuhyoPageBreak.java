/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 特徴異動情報件数表のPageBreakクラスです。
 *
 * @reamsid_L @reamsid_L DBB-1840-040 xuzhao
 */
public class TokubetsuChoshuIdojohoKensuhyoPageBreak extends PageBreaker<TokubetsuChoshuIdojohoKensuhyoSource> {

    private final List<RString> breakKeysList;
    private static final RString 年金保険者名称 = new RString("年金保険者名称");
    private static final RString 市町村コード = new RString("市町村コード");

    /**
     *
     * @param breakKeys ページングキー
     */
    public TokubetsuChoshuIdojohoKensuhyoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuIdojohoKensuhyoSource> currentSource,
            ReportLineRecord<TokubetsuChoshuIdojohoKensuhyoSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(年金保険者名称)
                || this.breakKeysList.contains(市町村コード)) {
            if (currentSource.getSource().nenkinHokenshaName.equals(nextSource.getSource().nenkinHokenshaName)) {
                flag = true;
            }
            if (currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 市町村コード改頁判断のメソッドです。
     *
     * @param currentSource RString
     * @param nextSource RString
     * @return 市町村コード改頁Flag
     */
    public boolean is市町村コード改頁(RString currentSource,
            RString nextSource) {
        return this.breakKeysList.contains(市町村コード)
                && !currentSource.equals(nextSource);
    }

    /**
     * 年金保険者名称改頁判断のメソッドです。
     *
     * @param currentSource RString
     * @param nextSource RString
     * @return 年金保険者名称改頁Flag
     */
    public boolean is年金保険者名称改頁(RString currentSource,
            RString nextSource) {
        return this.breakKeysList.contains(年金保険者名称)
                && !currentSource.equals(nextSource);
    }
}
