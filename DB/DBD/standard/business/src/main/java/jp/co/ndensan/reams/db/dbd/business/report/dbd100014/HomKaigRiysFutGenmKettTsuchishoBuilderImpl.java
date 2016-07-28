/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100014;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100014.HomKaigRiysFutGenmKettTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 社会福祉法人等利用者負担軽減対象確認証Builderクラスです。
 *
 * @reamsid_L DBD-3540-130 wangchao
 */
public class HomKaigRiysFutGenmKettTsuchishoBuilderImpl implements IHomKaigRiysFutGenmKettTsuchishoBuider {

    private final IHomKaigRiysFutGenmKettTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IHomKaigRiysFutGenmKettTsuchishoEditor}
     */
    HomKaigRiysFutGenmKettTsuchishoBuilderImpl(IHomKaigRiysFutGenmKettTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HomKaigRiysFutGenmKettTsuchishoReportSource}
     */
    @Override
    public HomKaigRiysFutGenmKettTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new HomKaigRiysFutGenmKettTsuchishoReportSource()).join(bodyEditor).buildSource();
    }
}
