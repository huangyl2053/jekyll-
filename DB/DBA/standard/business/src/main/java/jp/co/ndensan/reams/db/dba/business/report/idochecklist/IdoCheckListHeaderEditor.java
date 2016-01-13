/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.idochecklist;

import jp.co.ndensan.reams.db.dba.entity.report.idochecklist.IdoCheckListReportSource;



/**
 *
 * @author yuyong3
 */
class IdoCheckListHeaderEditor implements IIdoCheckListEditor {

    private final IdoCheckListItem item;



    protected IdoCheckListHeaderEditor(IdoCheckListItem item) {
        this.item = item;
    }

    @Override
    public IdoCheckListReportSource edit(IdoCheckListReportSource source) {
        editHeader(source);
        return source;
    }

    private void editHeader(IdoCheckListReportSource source) {
    source.taishoJohotitle=item.getTaishoJohotitle();
    source.printTimeStamp=item.getPrintTimeStamp();
    
    }

}
