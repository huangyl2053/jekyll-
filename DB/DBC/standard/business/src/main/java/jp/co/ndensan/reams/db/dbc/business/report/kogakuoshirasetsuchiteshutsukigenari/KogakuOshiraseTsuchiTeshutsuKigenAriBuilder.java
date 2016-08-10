/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuoshirasetsuchiteshutsukigenari;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigenari.KogakuOshiraseTsuchiTeshutsuKigenAriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額サービス給付のお知らせ通知書（提出期限あり）のソースの作成クラスです。
 *
 * @reamsid_L DBC-4770-040 zhujun
 */
public class KogakuOshiraseTsuchiTeshutsuKigenAriBuilder implements IKogakuOshiraseTsuchiTeshutsuKigenAriBuilder {

    private final IKogakuOshiraseTsuchiTeshutsuKigenAriEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor editor
     */
    public KogakuOshiraseTsuchiTeshutsuKigenAriBuilder(IKogakuOshiraseTsuchiTeshutsuKigenAriEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuOshiraseTsuchiTeshutsuKigenAriSource build() {
        return ReportEditorJoiner.from(new KogakuOshiraseTsuchiTeshutsuKigenAriSource()).join(editor).buildSource();
    }

}
