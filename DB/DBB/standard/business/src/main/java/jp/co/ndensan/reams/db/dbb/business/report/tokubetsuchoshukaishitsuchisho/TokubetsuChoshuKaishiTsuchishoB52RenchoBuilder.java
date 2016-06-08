/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 別徴収開始通知書（本算定） B5横タイプ2（連帳）帳票Builder
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoB52RenchoBuilder implements ITokubetsuChoshuKaishiTsuchishoB52RenchoBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoB52RenchoEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoB52RenchoEditor
     */
    public TokubetsuChoshuKaishiTsuchishoB52RenchoBuilder(
            ITokubetsuChoshuKaishiTsuchishoB52RenchoEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoB52RenchoSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoB52RenchoSource()).join(eidtor).buildSource();
    }

}
