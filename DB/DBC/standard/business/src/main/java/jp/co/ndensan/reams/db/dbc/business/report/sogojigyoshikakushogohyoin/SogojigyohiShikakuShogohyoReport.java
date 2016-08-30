/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyoshikakushogohyoin;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInSource;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 総合事業費資格照合表Report
 *
 * @reamsid_L DBC-2890-032 wangxue
 */
public class SogojigyohiShikakuShogohyoReport extends Report<SogojigyohiShikakuShogohyoInSource> {

    private final SogojigyohiShikakuShogohyoInEntity entity;
    private final DonyuKeitaiCode 導入形態コード;
    private final RDateTime システム日付;
    private final boolean flg;
    private final int 合計件数;

    /**
     * コンストラクタです
     *
     * @param entity SogojigyohiShikakuShogohyoInEntity
     * @param 導入形態コード DonyuKeitaiCode
     * @param システム日付 RDateTime
     * @param flg boolean
     * @param 合計件数 int
     */
    public SogojigyohiShikakuShogohyoReport(SogojigyohiShikakuShogohyoInEntity entity, DonyuKeitaiCode 導入形態コード,
            RDateTime システム日付, boolean flg, int 合計件数) {
        this.entity = entity;
        this.導入形態コード = 導入形態コード;
        this.システム日付 = システム日付;
        this.flg = flg;
        this.合計件数 = 合計件数;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiShikakuShogohyoInSource> reportSourceWriter) {
        ISogojigyohiShikakuShogohyoEditor editor
                = new SogojigyohiShikakuShogohyoEditor(entity, 導入形態コード, システム日付, flg, 合計件数);
        ISogojigyohiShikakuShogohyoBuilder builder = new SogojigyohiShikakuShogohyoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
