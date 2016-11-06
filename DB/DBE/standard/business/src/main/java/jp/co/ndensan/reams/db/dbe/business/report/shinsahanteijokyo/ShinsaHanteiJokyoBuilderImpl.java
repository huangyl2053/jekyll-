/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
public class ShinsaHanteiJokyoBuilderImpl implements IShinsaHanteiJokyoBuilder {

    private final IShinsaHanteiJokyoEditor editor;
    private final ShinsaHanteiJokyoBodyEditor bodyeditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsaHanteiJokyoEditor}
     * @param bodyeditor {@link IShinsaHanteiJokyoEditor}
     */
    public ShinsaHanteiJokyoBuilderImpl(IShinsaHanteiJokyoEditor editor,
            ShinsaHanteiJokyoBodyEditor bodyeditor) {
        this.editor = editor;
        this.bodyeditor = bodyeditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsaHanteiJokyoReportSource}
     */
    @Override
    public ShinsaHanteiJokyoReportSource build() {
        return ReportEditorJoiner.from(new ShinsaHanteiJokyoReportSource()).join(editor).join(bodyeditor).buildSource();
    }

}
