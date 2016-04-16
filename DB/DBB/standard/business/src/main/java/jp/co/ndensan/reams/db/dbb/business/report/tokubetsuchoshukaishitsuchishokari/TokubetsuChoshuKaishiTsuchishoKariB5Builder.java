/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Source;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（仮算定）帳票 B5横タイプ
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariB5Builder implements
        ITokubetsuChoshuKaishiTsuchishoKariB5Builder {

    private final ITokubetsuChoshuKaishiTsuchishoKariB5Editor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoKariB5Editor
     */
    public TokubetsuChoshuKaishiTsuchishoKariB5Builder(
            ITokubetsuChoshuKaishiTsuchishoKariB5Editor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariB5Source build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoKariB5Source())
                .join(eidtor).buildSource();
    }
}
