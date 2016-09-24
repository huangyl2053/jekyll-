/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicejyuryokakuninsho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBC100031_高額サービス費受領委任契約承認（不承認）確認書のBuilderクラスです。
 *
 * @reamsid_L DBC-1980-040 qinzhen
 */
public class KogakuServiceJyuryoKakuninShoBuilder implements IKogakuServiceJyuryoKakuninShoBuilder {

    private final IKogakuServiceJyuryoKakuninShoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKogakuServiceJyuryoKakuninShoEditor
     */
    public KogakuServiceJyuryoKakuninShoBuilder(IKogakuServiceJyuryoKakuninShoEditor editor) {
        this.editor = editor;
    }

    public KogakuServiceJyuryoKakuninShoSource build() {
        return ReportEditorJoiner.from(new KogakuServiceJyuryoKakuninShoSource())
                .join(editor).buildSource();
    }
}
