/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich;

import java.util.List;
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

    private final List<JigyoKogakuShikyuFushikyuKetteTsuchiEntity> itemList;

    /**
     * コンストラクタです
     *
     * @param itemList List<JigyoKogakuShikyuFushikyuKetteTsuchiEntity>
     */
    public JigyoKogakuShikyuFushikyuKetteTsuchiReport(List<JigyoKogakuShikyuFushikyuKetteTsuchiEntity> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyoKogakuShikyuFushikyuKetteTsuchiSource> writer) {
        for (JigyoKogakuShikyuFushikyuKetteTsuchiEntity entity : itemList) {
            IJigyoKogakuShikyuFushikyuKetteTsuchiEditor headerEditor = new JigyoKogakuShikyuFushikyuKetteTsuchiHeaderEditor(entity);
            IJigyoKogakuShikyuFushikyuKetteTsuchiEditor bodyEditor = new JigyoKogakuShikyuFushikyuKetteTsuchiBodyEditor(entity);
            IJigyoKogakuShikyuFushikyuKetteTsuchiBuilder builder = new JigyoKogakuShikyuFushikyuKetteTsuchiBuidler(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }
}
