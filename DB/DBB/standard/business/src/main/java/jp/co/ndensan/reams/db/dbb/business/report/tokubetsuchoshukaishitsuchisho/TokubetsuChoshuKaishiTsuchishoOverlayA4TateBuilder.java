/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（本算定） A4縦・オーバレイタイプ帳票Builder
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoOverlayA4TateBuilder implements ITokubetsuChoshuKaishiTsuchishoOverlayA4TateBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor
     */
    public TokubetsuChoshuKaishiTsuchishoOverlayA4TateBuilder(
            ITokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource())
                .join(eidtor).buildSource();
    }
}
