/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiranjigyokogaku;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.FurikomiMeisaiIchiranJigyoKogakuSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 振込明細一覧表（事業高額）Builderクラスです。
 *
 * @reamsid_L DBC-4870-070 wangxingpeng
 */
public class FurikomiMeisaiIchiranJigyoKogakuBuilder implements IFurikomiMeisaiIchiranJigyoKogakuBuilder {

    private final IFurikomiMeisaiIchiranJigyoKogakuEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor FurikomiMeisaiIchiranJigyoKogakuEditor
     */
    public FurikomiMeisaiIchiranJigyoKogakuBuilder(IFurikomiMeisaiIchiranJigyoKogakuEditor editor) {
        this.editor = editor;
    }

    @Override
    public FurikomiMeisaiIchiranJigyoKogakuSource build() {
        return ReportEditorJoiner.from(new FurikomiMeisaiIchiranJigyoKogakuSource())
                .join(editor).buildSource();
    }

}
