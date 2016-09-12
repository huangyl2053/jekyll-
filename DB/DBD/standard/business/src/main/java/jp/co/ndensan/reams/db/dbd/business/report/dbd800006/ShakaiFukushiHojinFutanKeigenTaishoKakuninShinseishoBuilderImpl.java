/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800006;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800006.ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 社会福祉法人等利用者負担軽減対象確認申請書Builderクラスです。
 *
 * @reamsid_L DBA-0540-698 zhangguopeng
 */
class ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoBuilderImpl implements IShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoBuilder {

    private final IShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoEditor}
     */
    public ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoBuilderImpl(
            IShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource}
     */
    @Override
    public ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource build() {
        return ReportEditorJoiner.from(
                new ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource()).join(editor).buildSource();
    }
}
