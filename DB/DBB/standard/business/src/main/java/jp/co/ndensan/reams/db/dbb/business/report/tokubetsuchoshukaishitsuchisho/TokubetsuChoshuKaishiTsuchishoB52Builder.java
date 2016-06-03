/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Source;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（本算定） B5横タイプ2帳票Builder
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoB52Builder implements ITokubetsuChoshuKaishiTsuchishoB52Builder {

    private final ITokubetsuChoshuKaishiTsuchishoB52Editor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoB52Editor
     */
    public TokubetsuChoshuKaishiTsuchishoB52Builder(
            ITokubetsuChoshuKaishiTsuchishoB52Editor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoB52Source build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoB52Source()).join(eidtor).buildSource();
    }
}
