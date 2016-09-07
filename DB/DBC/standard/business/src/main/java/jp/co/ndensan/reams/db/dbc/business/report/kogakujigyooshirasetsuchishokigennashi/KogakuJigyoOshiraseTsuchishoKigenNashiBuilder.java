/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyooshirasetsuchishokigennashi;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyooshirasetsuchishoteshutsukigennashi.KogakuJigyoOshiraseTsuchishoKigenNashiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 高額総合事業サービス費給付お知らせ通知書（提出期限なし）Builderクラスです。
 *
 * @reamsid_L DBC-4770-110 wangxingpeng
 */
public class KogakuJigyoOshiraseTsuchishoKigenNashiBuilder implements IKogakuJigyoOshiraseTsuchishoKigenNashiBuilder {

    private final IKogakuJigyoOshiraseTsuchishoKigenNashiEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKogakuJigyoOshiraseTsuchishoKigenNashiEditor
     */
    public KogakuJigyoOshiraseTsuchishoKigenNashiBuilder(IKogakuJigyoOshiraseTsuchishoKigenNashiEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuJigyoOshiraseTsuchishoKigenNashiSource build() {
        return ReportEditorJoiner.from(new KogakuJigyoOshiraseTsuchishoKigenNashiSource())
                .join(editor).buildSource();
    }

}
