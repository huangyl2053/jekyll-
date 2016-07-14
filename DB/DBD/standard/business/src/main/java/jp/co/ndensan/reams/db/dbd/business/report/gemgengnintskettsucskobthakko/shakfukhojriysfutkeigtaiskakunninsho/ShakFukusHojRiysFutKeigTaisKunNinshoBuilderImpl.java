/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.shakfukhojriysfutkeigtaiskakunninsho;

import jp.co.ndensan.reams.db.dbd.entity.report.shakfukriysfutkeigtaiskakunninsho.ShafukuRiyoshaFutanKeigenTaishoKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 社会福祉法人等利用者負担軽減対象確認証Builderクラスです。
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public class ShakFukusHojRiysFutKeigTaisKunNinshoBuilderImpl implements IShakFukusHojRiysFutKeigTaisKunNinshoBuider {

    private final IShakFukusHojRiysFutKeigTaisKunNinshoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShakFukusHojRiysFutKeigTaisKetTsuchishoEditor}
     */
    ShakFukusHojRiysFutKeigTaisKunNinshoBuilderImpl(IShakFukusHojRiysFutKeigTaisKunNinshoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource}
     */
    @Override
    public ShafukuRiyoshaFutanKeigenTaishoKakuninshoReportSource build() {
        return ReportEditorJoiner.from(new ShafukuRiyoshaFutanKeigenTaishoKakuninshoReportSource())
                .join(bodyEditor).buildSource();
    }

}
