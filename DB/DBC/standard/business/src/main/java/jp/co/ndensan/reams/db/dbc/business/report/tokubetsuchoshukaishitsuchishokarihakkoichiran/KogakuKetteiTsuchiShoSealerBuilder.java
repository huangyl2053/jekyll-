/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer.KogakuKetteiTsuchiShoSealerSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）Builderするクラスです。
 *
 * @reamsid_L DBC-2000-060 lijian
 */
public class KogakuKetteiTsuchiShoSealerBuilder implements
        IKogakuKetteiTsuchiShoSealerBuilder {

    private final IKogakuKetteiTsuchiShoSealerEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IKogakuKetteiTsuchiShoSealerEditor
     */
    public KogakuKetteiTsuchiShoSealerBuilder(IKogakuKetteiTsuchiShoSealerEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuKetteiTsuchiShoSealerSource build() {
        return ReportEditorJoiner.from(new KogakuKetteiTsuchiShoSealerSource()).join(editor).buildSource();
    }
}
