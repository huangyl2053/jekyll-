/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko;

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

    private final KogakuShikyuFushikyuKetteiTsuchiHakkoEntity entity;
    private final int 連番;

    /**
     * インスタンスを生成します。
     *
     * @param entity KogakuShikyuFushikyuKetteiTsuchiHakkoEntity
     * @param 連番 int
     */
    public KogakuShikyuFushikyuKetteiTsuchiHakkoReport(KogakuShikyuFushikyuKetteiTsuchiHakkoEntity entity, int 連番) {
        this.entity = entity;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> writer) {

        IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor headerEditor = new KogakuShikyuFushikyuKetteiTsuchiHakkoHeaderEditor(entity);
        IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor bodyEditor = new KogakuShikyuFushikyuKetteiTsuchiHakkoBodyEditor(entity, 連番);
        IKogakuShikyuFushikyuKetteiTsuchiHakkoBuilder builder = new KogakuShikyuFushikyuKetteiTsuchiHakkoBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
