/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomitsuchisho.FurikomiTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100060_事業合算・事業分振込明細書作成（一括） Reportクラスです。
 *
 * @reamsid_L DBC-4870-050 lijian
 */
public class FurikomiTsuchishoReport extends Report<FurikomiTsuchishoSource> {

    private final FurikaeGoEntity 振込Entity;

    /**
     * コンストラクタです。
     *
     * @param 振込Entity FurikaeGoEntity
     */
    public FurikomiTsuchishoReport(FurikaeGoEntity 振込Entity) {
        this.振込Entity = 振込Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<FurikomiTsuchishoSource> writer) {

        IFurikomiTsuchishoEditor headerEditor = new FurikomiTsuchishoHeaderEditor(振込Entity);
        IFurikomiTsuchishoEditor bodyEditor = new FurikomiTsuchishoBodyEditor(振込Entity);
        IFurikomiTsuchishoBuilder builder = new FurikomiTsuchishoBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
