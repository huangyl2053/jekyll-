/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiranjigyokogaku;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.FurikomiMeisaiIchiranJigyoKogakuSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 振込明細一覧表（事業高額）Reportクラスです。
 *
 * @reamsid_L DBC-4870-070 wangxingpeng
 */
public class FurikomiMeisaiIchiranJigyoKogakuReport extends Report<FurikomiMeisaiIchiranJigyoKogakuSource> {

    private final FurikomiMeisaiIchiranJigyoKogakuParameter target;
    private final boolean is頁計;
    private final boolean is総合計;

    /**
     * コンストラクタです
     *
     * @param target FurikomiMeisaiIchiranJigyoKogakuParameter
     * @param is頁計 boolean
     * @param is総合計 boolean
     */
    public FurikomiMeisaiIchiranJigyoKogakuReport(FurikomiMeisaiIchiranJigyoKogakuParameter target,
            boolean is頁計, boolean is総合計) {
        this.target = target;
        this.is頁計 = is頁計;
        this.is総合計 = is総合計;
    }

    @Override
    public void writeBy(ReportSourceWriter<FurikomiMeisaiIchiranJigyoKogakuSource> writer) {
        IFurikomiMeisaiIchiranJigyoKogakuEditor editor = new FurikomiMeisaiIchiranJigyoKogakuEditor(target, is頁計, is総合計);
        IFurikomiMeisaiIchiranJigyoKogakuBuilder builder = new FurikomiMeisaiIchiranJigyoKogakuBuilder(editor);
        writer.writeLine(builder);
    }

}
