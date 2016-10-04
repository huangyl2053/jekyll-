/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraijohokensuhyo.TokubetsuChoshuIraiJohoKensuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR82001_2_特別徴収依頼情報件数表のBuilderクラスです。
 *
 * @reamsid_L DBB-1840-070 wangxingpeng
 */
class TokubetsuChoshuIraiJohoKensuhyoBuilder implements ITokubetsuChoshuIraiJohoKensuhyoBuilder {

    private final ITokubetsuChoshuIraiJohoKensuhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param Editor Editor
     */
    public TokubetsuChoshuIraiJohoKensuhyoBuilder(ITokubetsuChoshuIraiJohoKensuhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokubetsuChoshuIraiJohoKensuhyoSource}
     */
    @Override
    public TokubetsuChoshuIraiJohoKensuhyoSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuIraiJohoKensuhyoSource()).join(editor).buildSource();
    }

}
