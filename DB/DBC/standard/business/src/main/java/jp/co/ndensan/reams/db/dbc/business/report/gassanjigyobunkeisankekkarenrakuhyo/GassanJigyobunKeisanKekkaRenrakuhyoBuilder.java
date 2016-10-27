/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkeisankekkarenrakuhyo;

import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業分計算結果連絡票Builderクラスです。
 *
 * @reamsid_L DBC-4840-030 wangxingpeng
 */
public class GassanJigyobunKeisanKekkaRenrakuhyoBuilder implements IGassanJigyobunKeisanKekkaRenrakuhyoBuilder {

    private final IGassanJigyobunKeisanKekkaRenrakuhyoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IGassanJigyobunKeisanKekkaRenrakuhyoEditor
     */
    public GassanJigyobunKeisanKekkaRenrakuhyoBuilder(IGassanJigyobunKeisanKekkaRenrakuhyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public GassanJigyobunKeisanKekkaRenrakuhyoSource build() {
        return ReportEditorJoiner.from(new GassanJigyobunKeisanKekkaRenrakuhyoSource())
                .join(editor).buildSource();
    }

}
