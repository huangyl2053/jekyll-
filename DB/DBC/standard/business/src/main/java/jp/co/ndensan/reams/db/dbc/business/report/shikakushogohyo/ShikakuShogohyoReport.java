/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shikakushogohyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin.ShikakuShogohyoInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.shikakushogohyo.ShikakuShogohyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護給付費資格照合表Reportクラスです。
 *
 * @reamsid_L DBC-2890-030 wangxingpeng
 */
public class ShikakuShogohyoReport extends Report<ShikakuShogohyoSource> {

    private final ShikakuShogohyoInEntity target;
    private final boolean flag;
    private final int 合計;
    private final int 連番;
    private final YMDHMS システム日時;
    private final DonyuKeitaiCode 導入形態コード;

    /**
     * コンストラクタです。
     *
     * @param flag boolean
     * @param 合計 int
     * @param target ShikakuShogohyoInEntity
     * @param システム日時 YMDHMS
     * @param 連番 int
     * @param 導入形態コード DonyuKeitaiCode
     */
    public ShikakuShogohyoReport(boolean flag,
            int 合計,
            ShikakuShogohyoInEntity target,
            YMDHMS システム日時,
            int 連番,
            DonyuKeitaiCode 導入形態コード) {
        this.flag = flag;
        this.合計 = 合計;
        this.target = target;
        this.システム日時 = システム日時;
        this.連番 = 連番;
        this.導入形態コード = 導入形態コード;

    }

    @Override

    public void writeBy(ReportSourceWriter<ShikakuShogohyoSource> reportSourceWriter) {
        IShikakuShogohyoEditor editor = new ShikakuShogohyoEditor(flag, 合計, target, システム日時, 連番, 導入形態コード);
        IShikakuShogohyoBuilder builder = new ShikakuShogohyoBuilder(editor);
        reportSourceWriter.writeLine(builder);

    }

}
