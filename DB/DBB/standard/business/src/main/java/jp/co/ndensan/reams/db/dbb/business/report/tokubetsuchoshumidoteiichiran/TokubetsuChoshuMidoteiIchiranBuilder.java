/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshumidoteiichiran.TokubetsuChoshuMidoteiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR81003_2_特別徴収未同定一覧表のBuilderです。
 *
 * @reamsid_L DBB-1860-070 liuyang
 */
public class TokubetsuChoshuMidoteiIchiranBuilder implements ITokubetsuChoshuMidoteiIchiranBuilder {

    private final ITokubetsuChoshuMidoteiIchiranEditor eidtor;

    /**
     * コンストラクタです。
     *
     * @param eidtor ITokubetsuChoshuMidoteiIchiranEditor
     */
    public TokubetsuChoshuMidoteiIchiranBuilder(ITokubetsuChoshuMidoteiIchiranEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuMidoteiIchiranSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuMidoteiIchiranSource())
                .join(eidtor).buildSource();
    }

}
