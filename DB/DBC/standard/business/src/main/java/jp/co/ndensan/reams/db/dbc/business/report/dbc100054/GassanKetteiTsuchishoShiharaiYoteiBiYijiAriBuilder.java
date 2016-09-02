/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100054;

import jp.co.ndensan.reams.db.dbc.entity.report.gassanketteitsuchishoshiharaiyoteibiyijiari.GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN63004_高額合算支給決定通知書（一括）Builder
 *
 * @reamsid_L DBC-2300-050 jiangxiaolong
 */
public class GassanKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder
        implements IGassanKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder {

    private final IGassanKetteiTsuchishoShiharaiYoteiBiYijiAriEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder(
            IGassanKetteiTsuchishoShiharaiYoteiBiYijiAriEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource build() {
        return ReportEditorJoiner.from(new GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource())
                .join(bodyEditor).buildSource();
    }

}
