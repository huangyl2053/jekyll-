/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokohi;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 総合事業費等請求額通知書（公費負担者分）帳票Report
 *
 * @reamsid_L DBC-4700-040 zhangyaru
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSeikyugakuTsuchishoKohiReport extends
        Report<SogojigyohiSeikyugakuTsuchishoKohiSource> {

    private final DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書情報;
    private final YMDHMS 帳票作成日時;

    /**
     * コンストラクタです
     *
     * @param 請求額通知書情報 DbWT1511SeikyugakuTsuchishoTempEntity
     * @param 帳票作成日時 YMDHMS
     */
    public SogojigyohiSeikyugakuTsuchishoKohiReport(DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書情報,
            YMDHMS 帳票作成日時) {
        this.請求額通知書情報 = 請求額通知書情報;
        this.帳票作成日時 = 帳票作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoKohiSource> writer) {
        ISogojigyohiSeikyugakuTsuchishoKohiEditor editor
                = new SogojigyohiSeikyugakuTsuchishoKohiEditor(請求額通知書情報, 帳票作成日時);
        ISogojigyohiSeikyugakuTsuchishoKohiBuilder builder
                = new SogojigyohiSeikyugakuTsuchishoKohiBuilder(editor);
        writer.writeLine(builder);
    }

}
