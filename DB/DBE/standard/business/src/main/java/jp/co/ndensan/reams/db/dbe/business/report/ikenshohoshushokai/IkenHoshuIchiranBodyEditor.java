/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshushokai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.GokeiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ikenhoshuichiran.IkenHoshuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成報酬実績集計表のEditorです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenHoshuIchiranBodyEditor implements IIkenHoshuIchiranEditor {

    private final IkenHoshuIchiranEntity item;
    private final GokeiEntity 報酬合計;

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書作成報酬Entity
     * @param 報酬合計 報酬合計Entity
     */
    protected IkenHoshuIchiranBodyEditor(IkenHoshuIchiranEntity item, GokeiEntity 報酬合計) {
        this.item = item;
        this.報酬合計 = 報酬合計;
    }

    @Override
    public IkenHoshuIchiranReportSource edit(IkenHoshuIchiranReportSource source) {
        return editSource(source);
    }

    private IkenHoshuIchiranReportSource editSource(IkenHoshuIchiranReportSource source) {
        source.listIkenshosakuseiryo_1 = new RString(報酬合計.get番号());
        source.listIkenshosakuseiryo_2 = item.get医師番号();
        source.listIkenshosakuseiryo_3 = item.get医師名();
        source.listIkenshosakuseiryo_4 = item.get依頼日();
        source.listIkenshosakuseiryo_5 = item.get記入日();
        source.listIkenshosakuseiryo_6 = item.get入手日();
        source.listIkenshosakuseiryo_7 = item.get意見();
        source.listIkenshosakuseiryo_8 = item.get保険者番号();
        source.listIkenshosakuseiryo_9 = item.get被保険者番号();
        source.listIkenshosakuseiryo_10 = item.get申請者();
        source.listIkenshosakuseiryo_11 = item.get在新();
        source.listIkenshosakuseiryo_12 = item.get在継();
        source.listIkenshosakuseiryo_13 = item.get施新();
        source.listIkenshosakuseiryo_14 = item.get施継();
        source.listIkenshosakuseiryo_15 = item.get作成料();
        source.listIkenshosakuseiryo_16 = item.get診断検査費用();
        source.listIkenshosakuseiryo_17 = item.get合計();
        source.listGokei_1 = new RString(報酬合計.get在新());
        source.listGokei_2 = new RString(報酬合計.get在継());
        source.listGokei_3 = new RString(報酬合計.get施新());
        source.listGokei_4 = new RString(報酬合計.get施継());
        source.listGokei_5 = 報酬合計.get作成料();
        source.listGokei_6 = 報酬合計.get診断検査費用();
        source.listGokei_7 = 報酬合計.get合計();
        return source;
    }
}
