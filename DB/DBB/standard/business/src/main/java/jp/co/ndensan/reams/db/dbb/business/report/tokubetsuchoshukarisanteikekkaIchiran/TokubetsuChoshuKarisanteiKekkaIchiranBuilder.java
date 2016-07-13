/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（本算定） シーラタイプ（連帳）帳票Builder
 *
 * @reamsid_L DBB-0700-030 xuhao
 */
public class TokubetsuChoshuKarisanteiKekkaIchiranBuilder implements ITokubetsuChoshuKarisanteiKekkaIchiranBuilder {

    private final ITokubetsuChoshuKarisanteiKekkaIchiranEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKarisanteiKekkaIchiranEditor
     */
    public TokubetsuChoshuKarisanteiKekkaIchiranBuilder(
            ITokubetsuChoshuKarisanteiKekkaIchiranEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKarisanteiKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKarisanteiKekkaIchiranSource())
                .join(eidtor).buildSource();
    }

}
