/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100019;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 社会福祉法人等利用者負担軽減対象確認証Builderクラスです。
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public class ShafukuRiysFutKeigTaisKakuninshoShoNoAriBuilderImpl implements IShafukuRiysFutKeigTaisKakuninshoShoNoAriBuider {

    private final IShafukuRiysFutKeigTaisKakuninshoShoNoAriEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShafukuRiysFutKeigTaisKakuninshoShoNoAriEditor}
     */
    ShafukuRiysFutKeigTaisKakuninshoShoNoAriBuilderImpl(IShafukuRiysFutKeigTaisKakuninshoShoNoAriEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource}
     */
    @Override
    public ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource build() {
        return ReportEditorJoiner.from(new ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource()).join(bodyEditor).buildSource();
    }
}
