/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvsmulti;

import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvsmulti.KanendoNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ】のBuilder
 *
 * @reamsid_L DBB-9110-170 huangh
 */
public class KanendoNonyuTsuchishoCVSMultiBuilder implements IKanendoNonyuTsuchishoCVSMultiBuilder {

    private final IKanendoNonyuTsuchishoCVSMultiEditor coverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param coverEditor coverEditor
     */
    public KanendoNonyuTsuchishoCVSMultiBuilder(IKanendoNonyuTsuchishoCVSMultiEditor coverEditor) {
        this.coverEditor = coverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KanendoNonyuTsuchishoCVSMultiSource}
     */
    @Override
    public KanendoNonyuTsuchishoCVSMultiSource build() {
        return ReportEditorJoiner.from(new KanendoNonyuTsuchishoCVSMultiSource())
                .join(coverEditor).buildSource();
    }

}
