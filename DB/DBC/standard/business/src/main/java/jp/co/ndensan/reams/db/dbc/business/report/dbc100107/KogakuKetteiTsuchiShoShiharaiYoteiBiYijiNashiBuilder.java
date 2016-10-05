/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100107;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc100107.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額サービス等支給（不支給）決定通知書（単）のBuilderです。
 *
 * @reamsid_L DBC-5160-050 donghj
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder implements
        IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder {

    private final IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor}
     */
    KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder(IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource build() {
        return ReportEditorJoiner.from(new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource()).join(editor).buildSource();
    }

}
