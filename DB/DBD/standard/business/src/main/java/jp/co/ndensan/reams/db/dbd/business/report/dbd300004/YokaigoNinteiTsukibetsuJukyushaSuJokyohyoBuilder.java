/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300004;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定月別受給者数状況表（統計表）Builderクラスです。
 *
 * @reamsid_L DBD-1771-034 b_liuyang2
 */
public class YokaigoNinteiTsukibetsuJukyushaSuJokyohyoBuilder implements IYokaigoNinteiTsukibetsuJukyushaSuJokyohyoBuilder {

    private final IYokaigoNinteiTsukibetsuJukyushaSuJokyohyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IYokaigoNinteiTsukibetsuJukyushaSuJokyohyoEditor}
     */
    YokaigoNinteiTsukibetsuJukyushaSuJokyohyoBuilder(IYokaigoNinteiTsukibetsuJukyushaSuJokyohyoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource}
     */
    @Override
    public YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource build() {
        return ReportEditorJoiner.from(new YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource()).join(bodyEditor).buildSource();
    }
}
