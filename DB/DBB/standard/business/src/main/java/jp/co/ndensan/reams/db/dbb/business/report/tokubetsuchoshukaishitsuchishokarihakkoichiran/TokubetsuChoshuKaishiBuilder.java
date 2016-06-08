/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）TokubetsuChoshuKaishiBuilder
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class TokubetsuChoshuKaishiBuilder implements ITokubetsuChoshuKaishiBuilder {

    private final ITokubetsuChoshuKaishiEditor tokubetsuchoshukaishieditor;

    /**
     * インスタンスを生成します。
     *
     * @param tokubetsuchoshukaishieditor {@link IKarisanteiFukaDaichoEditor}
     */
    public TokubetsuChoshuKaishiBuilder(ITokubetsuChoshuKaishiEditor tokubetsuchoshukaishieditor) {
        this.tokubetsuchoshukaishieditor = tokubetsuchoshukaishieditor;
    }

    /**
     * 帳票ソースビルド
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public TokubetsuChoshuKaishiSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiSource()).join(tokubetsuchoshukaishieditor).buildSource();
    }

}
