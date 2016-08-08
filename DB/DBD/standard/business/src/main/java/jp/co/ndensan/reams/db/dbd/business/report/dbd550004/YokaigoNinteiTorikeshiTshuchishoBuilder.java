/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550004;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd550004.YokaigoNinteiTorikeshiTshuchishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定取消通知書Builderのクラスです。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class YokaigoNinteiTorikeshiTshuchishoBuilder implements IYokaigoNinteiTorikeshiTshuchishoBuilder {

    private final IYokaigoNinteiTorikeshiTshuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IYokaigoNinteiTorikeshiTshuchishoEditor}
     */
    YokaigoNinteiTorikeshiTshuchishoBuilder(IYokaigoNinteiTorikeshiTshuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigoNinteiTorikeshiTshuchishoSource}
     */
    @Override
    public YokaigoNinteiTorikeshiTshuchishoSource build() {
        return ReportEditorJoiner.from(new YokaigoNinteiTorikeshiTshuchishoSource()).join(bodyEditor).buildSource();
    }
}
