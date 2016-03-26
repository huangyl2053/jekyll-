/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;

/**
 * 帳票設計_DBBRP43002_3_介護保険料額決定通知書発行一覧表HeaderEditor
 */
public class HeaderEditor implements IKaigoHokenryogakuEditor {

    private final KaigoHokenryogakuItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SampleItem}
     */
    protected HeaderEditor(KaigoHokenryogakuItem item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryogakuSource edit(KaigoHokenryogakuSource source) {
        editprintTimeStamp(source);
        edittitle(source);

        return source;
    }

    private void editprintTimeStamp(KaigoHokenryogakuSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
    }

    private void edittitle(KaigoHokenryogakuSource source) {
        source.title = item.getTitle();

    }

}
