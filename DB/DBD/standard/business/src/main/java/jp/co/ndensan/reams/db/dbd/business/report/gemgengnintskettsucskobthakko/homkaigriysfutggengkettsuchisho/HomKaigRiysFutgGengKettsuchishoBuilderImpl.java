/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengkettsuchisho;

import jp.co.ndensan.reams.db.dbd.entity.report.homkaigriysfutggengkettsuchisho.HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 訪問介護等利用者負担額減額決定通知書Builderクラスです。
 *
 * @reamsid_L DBD-3540-080 wangchao
 */
public class HomKaigRiysFutgGengKettsuchishoBuilderImpl implements IHomKaigRiysFutgGengKettsuchishoBuider {

    private final IHomKaigRiysFutgGengKettsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IHomKaigRiysFutgGengKettsuchishoEditor}
     */
    HomKaigRiysFutgGengKettsuchishoBuilderImpl(IHomKaigRiysFutgGengKettsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource}
     */
    @Override
    public HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource())
                .join(bodyEditor).buildSource();
    }
}
