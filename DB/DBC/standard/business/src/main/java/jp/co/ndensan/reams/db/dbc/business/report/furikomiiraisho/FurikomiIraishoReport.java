/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomiiraisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomiiraisho.FurikomiIraishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100059_事業合算・事業分振込明細書作成（一括） Reportクラスです。
 *
 * @reamsid_L DBC-4870-040 lijian
 */
public class FurikomiIraishoReport extends Report<FurikomiIraishoSource> {

    private final FurikaeGoEntity 振込Entity;

    /**
     * コンストラクタです。
     *
     * @param 振込Entity FurikaeGoEntity
     */
    public FurikomiIraishoReport(FurikaeGoEntity 振込Entity) {
        this.振込Entity = 振込Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<FurikomiIraishoSource> writer) {

        IFurikomiIraishoEditor headerEditor = new FurikomiIraishoHeaderEditor(振込Entity);
        IFurikomiIraishoEditor bodyEditor = new FurikomiIraishoBodyEditor(振込Entity);
        IFurikomiIraishoBuilder builder = new FurikomiIraishoBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
