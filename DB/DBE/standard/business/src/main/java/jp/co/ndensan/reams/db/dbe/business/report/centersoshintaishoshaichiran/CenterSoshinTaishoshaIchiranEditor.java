/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.centersoshintaishoshaichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterSoshinTaishoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.centersoshintaishoshaichiran.CenterSoshinTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・センター送信のEditorです。
 *
 * @reamsid_L DBE_1520_DBEMN91010 n8466
 */
class CenterSoshinTaishoshaIchiranEditor implements ICenterSoshinTaishoshaIchiranEditor {

    private final RString printTimeStamp;
    private final CenterSoshinTaishoshaIchiranEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param printTimeStamp 作成日時
     * @param item センター送信対象者一覧
     */
    protected CenterSoshinTaishoshaIchiranEditor(RString printTimeStamp, CenterSoshinTaishoshaIchiranEntity item) {
        this.printTimeStamp = printTimeStamp;
        this.item = item;
    }

    @Override
    public CenterSoshinTaishoshaIchiranReportSource edit(CenterSoshinTaishoshaIchiranReportSource source) {
        return editSource(source);
    }

    private CenterSoshinTaishoshaIchiranReportSource editSource(CenterSoshinTaishoshaIchiranReportSource source) {
        editPrintTimeStamp(source);
        editListTaishoshaIchiran_1(source);
        editListTaishoshaIchiran_2(source);
        editListTaishoshaIchiran_3(source);
        editListTaishoshaIchiran_4(source);
        editListTaishoshaIchiran_5(source);
        editListTaishoshaIchiran_6(source);
        editListTaishoshaIchiran_7(source);
        editListTaishoshaIchiran_8(source);
        editListTaishoshaIchiran_9(source);
        editListTaishoshaIchiran_10(source);
        editListTaishoshaIchiran_11(source);
        return source;
    }

    private void editPrintTimeStamp(CenterSoshinTaishoshaIchiranReportSource source) {
        source.printTimeStamp = printTimeStamp;
    }

    private void editListTaishoshaIchiran_1(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_1 = item.getListTaishoshaIchiran_1();
    }

    private void editListTaishoshaIchiran_2(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_2 = item.getListTaishoshaIchiran_2();
    }

    private void editListTaishoshaIchiran_3(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_3 = item.getListTaishoshaIchiran_3();
    }

    private void editListTaishoshaIchiran_4(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_4 = item.getListTaishoshaIchiran_4();
    }

    private void editListTaishoshaIchiran_5(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_5 = item.getListTaishoshaIchiran_5();
    }

    private void editListTaishoshaIchiran_6(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_6 = item.getListTaishoshaIchiran_6();
    }

    private void editListTaishoshaIchiran_7(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_7 = item.getListTaishoshaIchiran_7();
    }

    private void editListTaishoshaIchiran_8(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_8 = item.getListTaishoshaIchiran_8();
    }

    private void editListTaishoshaIchiran_9(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_9 = item.getListTaishoshaIchiran_9();
    }

    private void editListTaishoshaIchiran_10(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_10 = item.getListTaishoshaIchiran_10();
    }

    private void editListTaishoshaIchiran_11(CenterSoshinTaishoshaIchiranReportSource source) {
        source.listTaishoshaIchiran_11 = item.getListTaishoshaIchiran_11();
    }
}
