/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）HeaderEditor
 */
public class HeaderEditor implements ITokubetsuChoshuKaishiEditor {

    private final TokubetsuChoshuKaishiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SampleItem}
     */
    protected HeaderEditor(TokubetsuChoshuKaishiItem item) {
        this.item = item;
    }

    @Override
    public TokubetsuChoshuKaishiSource edit(TokubetsuChoshuKaishiSource source) {
        editprintTimeStamp(source);
        editnendo(source);
        edittitle(source);
        return source;
    }

    private void editprintTimeStamp(TokubetsuChoshuKaishiSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
    }

    private void editnendo(TokubetsuChoshuKaishiSource source) {
        source.nendo = item.getNendo();
    }

    private void edittitle(TokubetsuChoshuKaishiSource source) {
        source.title = item.getTitle();
    }

}
