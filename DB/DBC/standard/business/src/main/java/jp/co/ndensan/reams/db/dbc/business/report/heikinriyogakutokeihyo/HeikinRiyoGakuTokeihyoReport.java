/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.heikinriyogakutokeihyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.HeikinRiyoGakuTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.heikinriyogakutokeihyo.HeikinRiyoGakuTokeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 平均利用額統計表のReportです。
 *
 * @reamsid_L DBC-3490-040 sunhaidi
 */
public class HeikinRiyoGakuTokeihyoReport extends Report<HeikinRiyoGakuTokeihyoReportSource> {

    private final HeikinRiyoGakuTokeihyoEntity entity;
    private final RDateTime 処理時間;

    /**
     * コンストラクタです。
     *
     * @param entity HeikinRiyoGakuTokeihyoEntity
     * @param 処理時間 RDateTime
     */
    public HeikinRiyoGakuTokeihyoReport(HeikinRiyoGakuTokeihyoEntity entity, RDateTime 処理時間) {
        this.entity = entity;
        this.処理時間 = 処理時間;
    }

    @Override
    public void writeBy(ReportSourceWriter<HeikinRiyoGakuTokeihyoReportSource> writer) {
        IHeikinRiyoGakuTokeihyoEditor editor = new HeikinRiyoGakuTokeihyoEditor(entity, 処理時間);
        IHeikinRiyoGakuTokeihyoBuilder builder = new HeikinRiyoGakuTokeihyoBuilder(editor);
        writer.writeLine(builder);
    }
}
