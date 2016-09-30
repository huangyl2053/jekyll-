/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100031;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc100031.KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN32003_介護保険高額サービス費受領委任契約承認（不承認）確認書Builder
 *
 * @reamsid_L DBC-1970-040 jiangxiaolong
 */
public class KogakuServiceHiJyuryoItakuKeiyakuKakuninShoBuilder
        implements IKogakuServiceHiJyuryoItakuKeiyakuKakuninShoBuilder {

    private final IKogakuServiceHiJyuryoItakuKeiyakuKakuninShoEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public KogakuServiceHiJyuryoItakuKeiyakuKakuninShoBuilder(
            IKogakuServiceHiJyuryoItakuKeiyakuKakuninShoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource build() {
        return ReportEditorJoiner.from(new KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource())
                .join(bodyEditor).buildSource();
    }

}
