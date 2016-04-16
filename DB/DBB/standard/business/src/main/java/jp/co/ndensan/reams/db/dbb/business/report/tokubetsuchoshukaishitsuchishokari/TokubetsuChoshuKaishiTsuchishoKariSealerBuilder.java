/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（仮算定）帳票 シーラタイプBuilder
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariSealerBuilder implements
        ITokubetsuChoshuKaishiTsuchishoKariSealerBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoKariSealerEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoKariB5Editor
     */
    public TokubetsuChoshuKaishiTsuchishoKariSealerBuilder(
            ITokubetsuChoshuKaishiTsuchishoKariSealerEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariSealerSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoKariSealerSource())
                .join(eidtor).buildSource();
    }
}
