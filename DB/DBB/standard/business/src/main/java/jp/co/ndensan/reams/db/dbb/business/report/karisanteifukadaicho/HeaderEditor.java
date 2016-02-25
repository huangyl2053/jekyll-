/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteifukadaicho;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteifukadaicho.KarisanteiFukaDaichoSource;

/**
 * 賦課台帳（仮算定）帳票 HeaderEditor
 */
public class HeaderEditor implements IKarisanteiFukaDaichoEditor {

    private final KarisanteiFukaDaichoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SampleItem}
     */
    protected HeaderEditor(KarisanteiFukaDaichoItem item) {
        this.item = item;
    }

    @Override
    public KarisanteiFukaDaichoSource edit(KarisanteiFukaDaichoSource source) {
        editSakuseiYMD(source);
        editErrorKubun(source);
        editpageNo(source);
        editpageNoAll(source);
        editchoteiNendo(source);
        editfukaNendo(source);
        return source;
    }

    private void editpageNo(KarisanteiFukaDaichoSource source) {
        source.pageNo = item.getPageNo();
    }

    private void editpageNoAll(KarisanteiFukaDaichoSource source) {
        source.pageNoAll = item.getPageNoAll();
    }

    private void editSakuseiYMD(KarisanteiFukaDaichoSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
    }

    private void editErrorKubun(KarisanteiFukaDaichoSource source) {
        source.title = item.getTitle();
    }

    private void editchoteiNendo(KarisanteiFukaDaichoSource source) {
        source.choteiNendo = item.getChoteiNendo();
    }

    private void editfukaNendo(KarisanteiFukaDaichoSource source) {
        source.fukaNendo = item.getFukaNendo();
    }
}
