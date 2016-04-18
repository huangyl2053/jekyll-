/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（本算定） シーラタイプ帳票Builder
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoSealerBuilder implements ITokubetsuChoshuKaishiTsuchishoSealerBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoSealerEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoSealerEditor
     */
    public TokubetsuChoshuKaishiTsuchishoSealerBuilder(
            ITokubetsuChoshuKaishiTsuchishoSealerEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoSealerSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoSealerSource())
                .join(eidtor).buildSource();
    }
}
