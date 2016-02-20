/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import jp.co.ndensan.reams.db.dbb.entity.report.fukadaicho.FukaDaichoSource;

/**
 *
 */
class HeaderEditor implements IFukaDaichoEditor{
    
    private final FukaDaichoItem item;

    protected HeaderEditor(FukaDaichoItem item) {
        this.item = item;
    }
    
    @Override
    // TODO 编辑PDF Header
    public FukaDaichoSource edit(FukaDaichoSource source) {
        editChoteiNendo(source);
        editFukaNendo(source);
        editPrintTimeStamp(source);
        editPageNo(source);
        editPageNoAll(source);
        editTitle(source);
        return source;
    }

    private void editChoteiNendo(FukaDaichoSource source) {
        source.choteiNendo = item.getChoteiNendo();
    }
    
    private void editFukaNendo(FukaDaichoSource source) {
        source.fukaNendo = item.getFukaNendo();
    }
    
    private void editPrintTimeStamp(FukaDaichoSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
    }
    
    private void editPageNo(FukaDaichoSource source) {
        source.pageNo = item.getPageNo();
    }
    
    private void editPageNoAll(FukaDaichoSource source) {
        source.pageNoAll = item.getPageNoAll();
    }

    private void editTitle(FukaDaichoSource source) {
        source.title = item.getTitle();
    }
}