/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（仮算定）帳票 A4縦・オーバーレイタイプBuilder
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateBuilder implements
        ITokubetsuChoshuKaishiTsuchishoKariOverlayA4TateBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoKariOverlayA4TateEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoKariB5RenchoEditor
     */
    public TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateBuilder(
            ITokubetsuChoshuKaishiTsuchishoKariOverlayA4TateEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource())
                .join(eidtor).buildSource();
    }
}
