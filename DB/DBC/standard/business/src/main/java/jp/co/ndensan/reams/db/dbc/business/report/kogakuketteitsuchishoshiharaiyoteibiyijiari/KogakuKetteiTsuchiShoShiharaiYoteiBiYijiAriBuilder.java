/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijiari;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書((支払予定日あり))のBuilderクラスです。
 *
 * @reamsid_L DBC-2000-040 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder implements IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder {

    private final IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder(IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource build() {
        return ReportEditorJoiner.from(new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource()).join(editor).buildSource();
    }

}
