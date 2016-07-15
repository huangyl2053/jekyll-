/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshuseikyu;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshuseikyu.IkenshoHoshuSeikyuBodyEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshohoshuseikyu.IkenshoHoshuSeikyuReportSource;

/**
 * 帳票設計_DBE621004_主治医意見書作成報酬請求書のIkenshoHoshuSeikyuBodyEditorです。
 *
 * @reamsid_L DBE-1980-042 xuyongchao
 */
public class IkenshoHoshuSeikyuBodyEditor implements IIkenshoHoshuSeikyuBodyEditor {

    private final IkenshoHoshuSeikyuBodyEntity bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem bodyItem
     */
    protected IkenshoHoshuSeikyuBodyEditor(IkenshoHoshuSeikyuBodyEntity bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public IkenshoHoshuSeikyuReportSource edit(IkenshoHoshuSeikyuReportSource source) {
        source.listGokei_1 = bodyItem.getListGokei_1();
        source.listGokei_2 = bodyItem.getListGokei_2();
        source.listGokei_3 = bodyItem.getListGokei_3();
        return source;
    }

}
