/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100053;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc100053.GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN63004_高額合算支給決定通知書（一括）Builder
 *
 * @reamsid_L DBC-2300-050 jiangxiaolong
 */
public class GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder
        implements IGassanKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder {

    private final IGassanKetteiTsuchishoShiharaiYoteiBiYijiNashiEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder(
            IGassanKetteiTsuchishoShiharaiYoteiBiYijiNashiEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource build() {
        return ReportEditorJoiner.from(new GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource())
                .join(bodyEditor).buildSource();
    }

}
