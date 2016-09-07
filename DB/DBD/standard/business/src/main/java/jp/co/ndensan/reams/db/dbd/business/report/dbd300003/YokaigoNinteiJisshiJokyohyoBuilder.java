/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300003;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd300003.YokaigoNinteiJisshiJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定実施状況表（統計表）Builderクラスです。
 *
 * @reamsid_L DBD-1771-030 b_liuyang2
 */
public class YokaigoNinteiJisshiJokyohyoBuilder implements IYokaigoNinteiJisshiJokyohyoBuilder {

    private final IYokaigoNinteiJisshiJokyohyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IYokaigoNinteiJisshiJokyohyoEditor}
     */
    YokaigoNinteiJisshiJokyohyoBuilder(IYokaigoNinteiJisshiJokyohyoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigoNinteiJisshiJokyohyoReportSource}
     */
    @Override
    public YokaigoNinteiJisshiJokyohyoReportSource build() {
        return ReportEditorJoiner.from(new YokaigoNinteiJisshiJokyohyoReportSource()).join(bodyEditor).buildSource();
    }
}
