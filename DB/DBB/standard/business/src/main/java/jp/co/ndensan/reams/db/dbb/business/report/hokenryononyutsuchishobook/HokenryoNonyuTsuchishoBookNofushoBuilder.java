/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】納付書 HokenryoNonyuTsuchishoBookNofushoBuilder
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class HokenryoNonyuTsuchishoBookNofushoBuilder implements IHokenryoNonyuTsuchishoBookNofushoBuilder {

    private final IHokenryoNonyuTsuchishoBookNofushoEditor edit;

    /**
     * インスタンスを生成します。
     *
     * @param edit {@link IHokenryoNonyuTsuchishoBookNofushoEditor}
     */
    public HokenryoNonyuTsuchishoBookNofushoBuilder(IHokenryoNonyuTsuchishoBookNofushoEditor edit) {
        this.edit = edit;
    }

    @Override
    public HokenryoNonyuTsuchishoBookNofushoSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuTsuchishoBookNofushoSource()).join(edit).buildSource();
    }

}
