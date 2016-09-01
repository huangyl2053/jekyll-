/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd511001.KoshinShinseiOshiraseTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定更新お知らせ通知書Builderクラスです。
 *
 * @reamsid_L DBD-2030-030 donghj
 */
public class KoshinShinseiOshiraseTshuchishoBuilder implements IKoshinShinseiOshiraseTshuchishoBuilder {

    private final IKoshinShinseiOshiraseTshuchishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKoshinShinseiOshiraseTshuchishoEditor}
     */
    KoshinShinseiOshiraseTshuchishoBuilder(IKoshinShinseiOshiraseTshuchishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KoshinShinseiOshiraseTshuchishoReportSource}
     */
    @Override
    public KoshinShinseiOshiraseTshuchishoReportSource build() {
        return ReportEditorJoiner.from(new KoshinShinseiOshiraseTshuchishoReportSource()).join(editor).buildSource();
    }

}
