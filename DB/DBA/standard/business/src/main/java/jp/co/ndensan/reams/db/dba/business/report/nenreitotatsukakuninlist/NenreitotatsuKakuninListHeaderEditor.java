/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist;

import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReportSource;

/**
 * 年齢到達者登録リスト帳票のヘッダエディタです。
 *
 * @reamsid_L DBA-0570-060 xuyue
 */
class NenreitotatsuKakuninListHeaderEditor implements INenreitotatsuKakuninListEdiotr {

    private final NenreitotatsuKakuninListItem item;

    public NenreitotatsuKakuninListHeaderEditor(NenreitotatsuKakuninListItem item) {
        this.item = item;

    }

    @Override
    public NenreitotatsuKakuninListReportSource edit(NenreitotatsuKakuninListReportSource source) {
        return editHeader(source);
    }

    private NenreitotatsuKakuninListReportSource editHeader(NenreitotatsuKakuninListReportSource source) {
        source.taishoJohotitle = item.getTaishoJohotitle();
        source.printTimeStamp = item.getPrintTimeStamp();
        source.tyusyutsukikanF = item.getTyusyutsukikanF();
        source.tyusyutsukikanT = item.getTyusyutsukikanT();
        return source;
    }

}
