/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Source;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（本算定） B5横タイプ帳票Builder
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoB5Builder implements ITokubetsuChoshuKaishiTsuchishoB5Builder {

    private final ITokubetsuChoshuKaishiTsuchishoB5Editor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoKariB5Editor
     */
    public TokubetsuChoshuKaishiTsuchishoB5Builder(
            ITokubetsuChoshuKaishiTsuchishoB5Editor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoB5Source build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoB5Source())
                .join(eidtor).buildSource();
    }
}
