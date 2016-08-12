/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyooshirasetsuchishokigenari;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyooshirasetsuchishokigenari.KogakuJigyoOshiraseTsuchishoKigenAriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 高額総合事業サービス費給付お知らせ通知書（提出期限あり）Builderクラスです。
 *
 * @reamsid_L DBC-4770-100 wangxingpeng
 */
public class KogakuJigyoOshiraseTsuchishoKigenAriBuilder implements IKogakuJigyoOshiraseTsuchishoKigenAriBuilder {

    private final IKogakuJigyoOshiraseTsuchishoKigenAriEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKogakuJigyoOshiraseTsuchishoKigenAriEditor
     */
    public KogakuJigyoOshiraseTsuchishoKigenAriBuilder(IKogakuJigyoOshiraseTsuchishoKigenAriEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuJigyoOshiraseTsuchishoKigenAriSource build() {
        return ReportEditorJoiner.from(new KogakuJigyoOshiraseTsuchishoKigenAriSource())
                .join(editor).buildSource();
    }

}
