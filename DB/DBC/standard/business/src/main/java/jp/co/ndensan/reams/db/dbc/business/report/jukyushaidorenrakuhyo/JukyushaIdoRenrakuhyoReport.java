/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushaidorenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN81001_受給者異動連絡票紙媒体Report
 *
 * @reamsid_L DBC-2100-040 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoReport extends
        Report<JukyushaIdoRenrakuhyoSource> {

    private final JukyushaIdoRenrakuhyoTorokuEntity entity;
    private final RString 市町村名称;

    /**
     * コンストラクタです。
     *
     * @param entity JukyushaIdoRenrakuhyoTorokuEntity
     * @param 市町村名称 RString
     */
    public JukyushaIdoRenrakuhyoReport(JukyushaIdoRenrakuhyoTorokuEntity entity, RString 市町村名称) {
        this.entity = entity;
        this.市町村名称 = 市町村名称;

    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaIdoRenrakuhyoSource> writer) {
        IJukyushaIdoRenrakuhyoEditor editor = new JukyushaIdoRenrakuhyoEditor(entity, 市町村名称);
        IJukyushaIdoRenrakuhyoBuilder builder = new JukyushaIdoRenrakuhyoBuilder(editor);
        writer.writeLine(builder);
    }

}
