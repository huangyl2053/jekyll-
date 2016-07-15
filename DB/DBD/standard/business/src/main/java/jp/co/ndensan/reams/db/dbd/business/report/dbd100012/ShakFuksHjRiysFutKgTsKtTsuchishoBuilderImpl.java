/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100012;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100012.ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 利用者負担額減額・免除等認定証Builderクラスです。
 *
 * @reamsid_L DBD-3540-110 wangchao
 */
public class ShakFuksHjRiysFutKgTsKtTsuchishoBuilderImpl implements IShakFuksHjRiysFutKgTsKtTsuchishoBuider {

    private final IShakFuksHjRiysFutKgTsKtTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShakFuksHjRiysFutKgTsKtTsuchishoEditor}
     */
    ShakFuksHjRiysFutKgTsKtTsuchishoBuilderImpl(IShakFuksHjRiysFutKgTsKtTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource}
     */
    @Override
    public ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource()).join(bodyEditor).buildSource();
    }

}
