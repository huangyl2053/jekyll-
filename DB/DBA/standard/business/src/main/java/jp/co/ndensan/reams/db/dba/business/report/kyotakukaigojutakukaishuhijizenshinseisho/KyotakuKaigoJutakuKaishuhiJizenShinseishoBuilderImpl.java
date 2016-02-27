/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyotakukaigojutakukaishuhijizenshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.kyotakukaigojutakukaishuhijizenshinseisho.JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書Builderクラスです。
 *
 */
public class KyotakuKaigoJutakuKaishuhiJizenShinseishoBuilderImpl implements IKyotakuKaigoJutakuKaishuhiJizenShinseishoBuilder {

    private final IKyotakuKaigoJutakuKaishuhiJizenShinseishoEditor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書情報
     */
    public KyotakuKaigoJutakuKaishuhiJizenShinseishoBuilderImpl(IKyotakuKaigoJutakuKaishuhiJizenShinseishoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource}
     */
    @Override
    public JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource build() {
        return ReportEditorJoiner.from(new JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource()).join(joho).buildSource();
    }
}
