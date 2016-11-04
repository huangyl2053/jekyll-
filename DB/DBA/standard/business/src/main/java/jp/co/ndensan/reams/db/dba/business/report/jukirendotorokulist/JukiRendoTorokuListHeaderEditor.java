/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist;

import jp.co.ndensan.reams.db.dba.entity.report.jukirendotorokulist.JukiRendoTorokuListReportSource;

/**
 * 住基連動登録リスト帳票HeaderEditorです。
 *
 * @reamsid_L DBA-0560-060 xuyue
 */
class JukiRendoTorokuListHeaderEditor implements IJukiRendoTorokuListEditor {

    private final JukiRendoTorokuListItem item;

    public JukiRendoTorokuListHeaderEditor(JukiRendoTorokuListItem item) {
        this.item = item;
    }

    @Override
    public JukiRendoTorokuListReportSource edit(JukiRendoTorokuListReportSource source) {
        return editorHeader(source);
    }

    private JukiRendoTorokuListReportSource editorHeader(JukiRendoTorokuListReportSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
        source.taishoJohotitle = item.getTaishoJohotitle();
        source.tyusyutsukikanF = item.getTyusyutsukikanF();
        source.tyusyutsukikanT = item.getTyusyutsukikanT();
       return source;
    }

}
