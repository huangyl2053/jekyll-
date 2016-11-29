/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuShikyuFushikyuKetteiTsuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakushikyufushikyuketteitsuchihakkoichiran.KogakuShikyuFushikyuKetteiTsuchiHakkoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額介護サービス費支給（不支給）決定通知一覧Reportクラスです。
 *
 * @reamsid_L DBC-2000-080 wangxingpeng
 */
public class KogakuShikyuFushikyuKetteiTsuchiHakkoReport
        extends Report<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> {

    private final List<KogakuShikyuFushikyuKetteiTsuchiHakkoEntity> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList List<KogakuShikyuFushikyuKetteiTsuchiHakkoEntity>
     */
    public KogakuShikyuFushikyuKetteiTsuchiHakkoReport(List<KogakuShikyuFushikyuKetteiTsuchiHakkoEntity> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> writer) {

        for (KogakuShikyuFushikyuKetteiTsuchiHakkoEntity item : itemList) {
            IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor headerEditor
                    = new KogakuShikyuFushikyuKetteiTsuchiHakkoHeaderEditor(item);
            IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor bodyEditor
                    = new KogakuShikyuFushikyuKetteiTsuchiHakkoBodyEditor(item);
            IKogakuShikyuFushikyuKetteiTsuchiHakkoBuilder builder = new KogakuShikyuFushikyuKetteiTsuchiHakkoBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
