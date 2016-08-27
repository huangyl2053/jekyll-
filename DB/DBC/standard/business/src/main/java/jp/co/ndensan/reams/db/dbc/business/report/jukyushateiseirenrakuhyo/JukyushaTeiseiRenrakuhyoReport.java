/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）Reportクラスです。
 *
 * @reamsid_L DBC-2101-060 lijian
 */
public class JukyushaTeiseiRenrakuhyoReport extends Report<JukyushaTeiseiRenrakuhyoSource> {

    private final JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity;
    private final RString 市町村名称;

    /**
     * コンストラクタです。
     *
     * @param 出力用受給者訂正情報Entity JukyushaIdoRenrakuhyoTorokuEntity
     * @param 市町村名称 RString
     */
    public JukyushaTeiseiRenrakuhyoReport(JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity, RString 市町村名称) {
        this.出力用受給者訂正情報Entity = 出力用受給者訂正情報Entity;
        this.市町村名称 = 市町村名称;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaTeiseiRenrakuhyoSource> writer) {
        writeLine(writer, 出力用受給者訂正情報Entity, 市町村名称);
    }

    private void writeLine(ReportSourceWriter<JukyushaTeiseiRenrakuhyoSource> writer,
            JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity, RString 市町村名称) {
        IJukyushaTeiseiRenrakuhyoEditor editor = new JukyushaTeiseiRenrakuhyoEditor(出力用受給者訂正情報Entity, 市町村名称);

        IJukyushaTeiseiRenrakuhyoBuilder builder = new JukyushaTeiseiRenrakuhyoBuilder(editor);
        writer.writeLine(builder);

    }

}
