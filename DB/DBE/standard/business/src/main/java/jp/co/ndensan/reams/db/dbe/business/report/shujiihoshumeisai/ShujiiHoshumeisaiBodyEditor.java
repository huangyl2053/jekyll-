/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshumeisai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai.ShujiiHoshumeisaiBodyEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshumeisai.ShujiiHoshumeisaiReportSource;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のShujiiHoshumeisaiEditorです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
public class ShujiiHoshumeisaiBodyEditor implements IShujiiHoshumeisaiBodyEditor {

    private final ShujiiHoshumeisaiBodyEntity bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem bodyItem
     */
    protected ShujiiHoshumeisaiBodyEditor(ShujiiHoshumeisaiBodyEntity bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public ShujiiHoshumeisaiReportSource edit(ShujiiHoshumeisaiReportSource source) {
        source.listIkenshosakuseiryo_1 = bodyItem.getListIkenshosakuseiryo_1();
        source.listIkenshosakuseiryo_2 = bodyItem.getListIkenshosakuseiryo_2();
        source.listIkenshosakuseiryo_3 = bodyItem.getListIkenshosakuseiryo_3();
        source.listIkenshosakuseiryo_4 = bodyItem.getListIkenshosakuseiryo_4();
        source.listIkenshosakuseiryo_5 = bodyItem.getListIkenshosakuseiryo_5();
        source.listIkenshosakuseiryo_6 = bodyItem.getListIkenshosakuseiryo_6();
        source.listIkenshosakuseiryo_7 = bodyItem.getListIkenshosakuseiryo_7();
        source.listIkenshosakuseiryo_8 = bodyItem.getListIkenshosakuseiryo_8();
        source.listIkenshosakuseiryo_9 = bodyItem.getListIkenshosakuseiryo_9();
        source.listIkenshosakuseiryo_10 = bodyItem.getListIkenshosakuseiryo_10();
        source.listGokeikensu_1 = bodyItem.getListGokeikensu_1();
        source.listGokeikensu_2 = bodyItem.getListGokeikensu_2();
        source.listGokeikensu_3 = bodyItem.getListGokeikensu_3();
        source.listGokeikensu_4 = bodyItem.getListGokeikensu_4();
        source.listGokeiKingaku_1 = bodyItem.getListGokeiKingaku_1();
        return source;
    }

}
