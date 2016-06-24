/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaigijiroku.ShinsakaiGijirokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会議事録Builderクラスです。
 *
 * @reamsid_L DBE-0170-040 wangkun
 */
public class ShinsakaiGijirokuBuilder implements IShinsakaiGijirokuBuilder {

    private final ShinsakaiGijirokuEditor editor;
    private final ShinsakaiGijirokuBodyEditor1 bodyEditor1;
    private final ShinsakaiGijirokuBodyEditor2 bodyEditor2;
    private final ShinsakaiGijirokuBodyEditor3 bodyEditor3;
    private final ShinsakaiGijirokuBodyEditor4 bodyEditor4;
    private final ShinsakaiGijirokuBodyEditor5 bodyEditor5;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link HanteikekkaKagamiEditor}
     * @param bodyEditor1 ShinsakaiGijirokuBodyEditor1
     * @param bodyEditor2 ShinsakaiGijirokuBodyEditor2
     * @param bodyEditor3 ShinsakaiGijirokuBodyEditor3
     * @param bodyEditor4 ShinsakaiGijirokuBodyEditor4
     * @param bodyEditor5 ShinsakaiGijirokuBodyEditor5
     */
    protected ShinsakaiGijirokuBuilder(ShinsakaiGijirokuEditor editor,
            ShinsakaiGijirokuBodyEditor1 bodyEditor1,
            ShinsakaiGijirokuBodyEditor2 bodyEditor2,
            ShinsakaiGijirokuBodyEditor3 bodyEditor3,
            ShinsakaiGijirokuBodyEditor4 bodyEditor4,
            ShinsakaiGijirokuBodyEditor5 bodyEditor5) {
        this.editor = editor;
        this.bodyEditor1 = bodyEditor1;
        this.bodyEditor2 = bodyEditor2;
        this.bodyEditor3 = bodyEditor3;
        this.bodyEditor4 = bodyEditor4;
        this.bodyEditor5 = bodyEditor5;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HanteiKekkaIchiranReportSource}
     */
    @Override
    public ShinsakaiGijirokuReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaiGijirokuReportSource()).join(editor)
                .join(bodyEditor1).join(bodyEditor2).join(bodyEditor3).join(bodyEditor4).join(bodyEditor5).buildSource();
    }
}
