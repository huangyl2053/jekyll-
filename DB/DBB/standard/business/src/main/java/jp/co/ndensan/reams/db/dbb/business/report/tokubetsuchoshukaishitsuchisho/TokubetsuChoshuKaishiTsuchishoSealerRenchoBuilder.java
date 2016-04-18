/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（本算定） シーラタイプ（連帳）帳票Builder
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoSealerRenchoBuilder implements ITokubetsuChoshuKaishiTsuchishoSealerRenchoBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoSealerRenchoEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoSealerRenchoEditor
     */
    public TokubetsuChoshuKaishiTsuchishoSealerRenchoBuilder(
            ITokubetsuChoshuKaishiTsuchishoSealerRenchoEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoSealerRenchoSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoSealerRenchoSource())
                .join(eidtor).buildSource();
    }
}
