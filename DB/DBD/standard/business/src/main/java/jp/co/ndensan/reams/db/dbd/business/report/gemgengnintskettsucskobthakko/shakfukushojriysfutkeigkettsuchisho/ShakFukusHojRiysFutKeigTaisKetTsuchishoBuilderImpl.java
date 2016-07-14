/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.shakfukushojriysfutkeigkettsuchisho;

import jp.co.ndensan.reams.db.dbd.entity.report.shakfukushojriysfutkeigkettsuchisho.ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 利用者負担額減額・免除等認定証Builderクラスです。
 *
 * @reamsid_L DBD-3540-110 wangchao
 */
public class ShakFukusHojRiysFutKeigTaisKetTsuchishoBuilderImpl implements IShakFukusHojRiysFutKeigTaisKetTsuchishoBuider {

    private final IShakFukusHojRiysFutKeigTaisKetTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShakFukusHojRiysFutKeigTaisKetTsuchishoEditor}
     */
    ShakFukusHojRiysFutKeigTaisKetTsuchishoBuilderImpl(IShakFukusHojRiysFutKeigTaisKetTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource}
     */
    @Override
    public ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource())
                .join(bodyEditor).buildSource();
    }

}
