/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shikakushogohyo;

import jp.co.ndensan.reams.db.dbc.entity.report.shikakushogohyo.ShikakuShogohyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護給付費資格照合表Builderクラスです。
 *
 * @reamsid_L DBC-2890-030 wangxingpeng
 */
public class ShikakuShogohyoBuilder implements IShikakuShogohyoBuilder {

    private final IShikakuShogohyoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IShikakuShogohyoEditor
     */
    public ShikakuShogohyoBuilder(IShikakuShogohyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public ShikakuShogohyoSource build() {
        return ReportEditorJoiner.from(new ShikakuShogohyoSource())
                .join(editor).buildSource();
    }

}
