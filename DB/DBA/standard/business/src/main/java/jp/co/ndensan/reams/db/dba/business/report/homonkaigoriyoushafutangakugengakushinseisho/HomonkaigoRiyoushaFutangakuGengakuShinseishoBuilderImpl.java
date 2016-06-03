/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.homonkaigoriyoushafutangakugengakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.homonkaigoriyoushafutangakugengakushinseisho.HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 訪問介護利用者負担額減額申請書Builderクラスです。
 *
 */
public class HomonkaigoRiyoushaFutangakuGengakuShinseishoBuilderImpl implements IHomonkaigoRiyoushaFutangakuGengakuShinseishoBuilder {

    private final IHomonkaigoRiyoushaFutangakuGengakuShinseishoEditor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 訪問介護利用者負担額減額申請書情報
     */
    public HomonkaigoRiyoushaFutangakuGengakuShinseishoBuilderImpl(IHomonkaigoRiyoushaFutangakuGengakuShinseishoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource}
     */
    @Override
    public HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource()).join(joho).buildSource();
    }
}
