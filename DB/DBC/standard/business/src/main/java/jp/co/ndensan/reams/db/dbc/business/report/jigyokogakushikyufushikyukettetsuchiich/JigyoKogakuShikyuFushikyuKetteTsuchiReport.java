/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.JigyoKogakuShikyuFushikyuKetteTsuchiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakushikyufushikyukettetsuchiichiran.JigyoKogakuShikyuFushikyuKetteTsuchiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業高額支給不支給決定通知一覧表Reportクラスです。
 *
 * @reamsid_L DBC-2000-110 wangxingpeng
 */
public class JigyoKogakuShikyuFushikyuKetteTsuchiReport extends Report<JigyoKogakuShikyuFushikyuKetteTsuchiSource> {

    private final JigyoKogakuShikyuFushikyuKetteTsuchiEntity entity;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param entity JigyoKogakuShikyuFushikyuKetteTsuchiEntity
     * @param 連番 int
     */
    public JigyoKogakuShikyuFushikyuKetteTsuchiReport(JigyoKogakuShikyuFushikyuKetteTsuchiEntity entity,
            int 連番) {
        this.entity = entity;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyoKogakuShikyuFushikyuKetteTsuchiSource> writer) {
        IJigyoKogakuShikyuFushikyuKetteTsuchiEditor headerEditor = new JigyoKogakuShikyuFushikyuKetteTsuchiHeaderEditor(entity);
        IJigyoKogakuShikyuFushikyuKetteTsuchiEditor bodyEditor = new JigyoKogakuShikyuFushikyuKetteTsuchiBodyEditor(entity, 連番);
        IJigyoKogakuShikyuFushikyuKetteTsuchiBuilder builder = new JigyoKogakuShikyuFushikyuKetteTsuchiBuidler(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
