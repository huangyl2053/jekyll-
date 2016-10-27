/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijinashi;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書のBuilderクラスです。
 *
 * @reamsid_L DBC-2000-050 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaBuilder implements IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaBuilder {

    private final IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaBuilder(IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource build() {
        return ReportEditorJoiner.from(new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource()).join(editor).buildSource();
    }

}
