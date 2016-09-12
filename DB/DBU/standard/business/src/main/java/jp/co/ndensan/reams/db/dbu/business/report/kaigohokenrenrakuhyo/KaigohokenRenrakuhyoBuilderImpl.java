/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyo;

import jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyo.KaigohokenRenrakuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険連絡票Builderクラスです。
 *
 * @reamsid_L DBA-1290-070 lishengli
 */
public class KaigohokenRenrakuhyoBuilderImpl implements IKaigohokenRenrakuhyoBuilder {

    private final IKaigohokenRenrakuhyoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor 介護保険資格取得・異動・喪失届ヘッダエディターのインターフェース
     */
    public KaigohokenRenrakuhyoBuilderImpl(IKaigohokenRenrakuhyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KaigohokenRenrakuhyoReportSource build() {
        return ReportEditorJoiner.from(new KaigohokenRenrakuhyoReportSource()).join(editor).buildSource();
    }

}
