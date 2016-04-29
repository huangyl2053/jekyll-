/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（仮算定）帳票 シーラタイプ連帳Builder
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariSealerRenchoBuilder implements
        ITokubetsuChoshuKaishiTsuchishoKariSealerRenchoBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoKariSealerRenchoEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor ITokubetsuChoshuKaishiTsuchishoKariSealerRenchoEditor
     */
    public TokubetsuChoshuKaishiTsuchishoKariSealerRenchoBuilder(
            ITokubetsuChoshuKaishiTsuchishoKariSealerRenchoEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource())
                .join(eidtor).buildSource();
    }
}
