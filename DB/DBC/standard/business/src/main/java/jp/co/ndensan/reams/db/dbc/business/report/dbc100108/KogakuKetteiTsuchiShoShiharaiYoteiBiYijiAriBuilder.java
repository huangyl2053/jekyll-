/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100108;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc100108.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額サービス等支給（不支給）決定通知書(支払予定日あり)のBuilderです。
 *
 * @reamsid_L DBC-5160-040 donghj
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder implements
        IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder {

    private final IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor}
     */
    KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder(
            IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource build() {
        return ReportEditorJoiner.from(new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource()).join(editor).buildSource();
    }

}
