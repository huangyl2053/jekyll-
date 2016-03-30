/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（仮算定）帳票 B5横タイプ連帳Builder
 */
public class TokubetsuChoshuKaishiTsuchishoKariB5RenchoBuilder implements
        ITokubetsuChoshuKaishiTsuchishoKariB5RenchoBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoKariB5RenchoEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoKariB5RenchoEditor
     */
    public TokubetsuChoshuKaishiTsuchishoKariB5RenchoBuilder(
            ITokubetsuChoshuKaishiTsuchishoKariB5RenchoEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource())
                .join(eidtor).buildSource();
    }
}
