/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（本算定） B5横タイプ（連帳）帳票Builder
 */
public class TokubetsuChoshuKaishiTsuchishoB5RenchoBuilder implements
        ITokubetsuChoshuKaishiTsuchishoB5RenchoBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoB5RenchoEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoKariB5Editor
     */
    public TokubetsuChoshuKaishiTsuchishoB5RenchoBuilder(
            ITokubetsuChoshuKaishiTsuchishoB5RenchoEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoB5RenchoSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoB5RenchoSource())
                .join(eidtor).buildSource();
    }
}
