/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.db.dbb.entity.report.choteibo.ChoteiboSource;

/**
 *
 */
class ChoteiboHeaderEditor implements IChoteiboEditor {

    private final ChoteiboHeaderItem item;

    protected ChoteiboHeaderEditor(ChoteiboHeaderItem item) {
        this.item = item;
    }

    @Override
    public ChoteiboSource edit(ChoteiboSource source) {
        editPrintTimeStamp(source);
        editMidashi(source);
        editGengo(source);
        editNendo(source);
        editHokenshaNo(source);
        editHokenshaName(source);
        return source;
    }

    private void editMidashi(ChoteiboSource source) {
        source.midashi = item.getMidashi();
    }

    private void editGengo(ChoteiboSource source) {
        source.gengo = item.getGengo();
    }

    private void editNendo(ChoteiboSource source) {
        source.nendo = item.getNendo();
    }

    private void editHokenshaName(ChoteiboSource source) {
        source.hokenshaName = item.getHokenshaName();
    }

    private void editHokenshaNo(ChoteiboSource source) {
        source.hokenshaNo = item.getHokenshaNo();
    }

    private void editPrintTimeStamp(ChoteiboSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
    }
}
