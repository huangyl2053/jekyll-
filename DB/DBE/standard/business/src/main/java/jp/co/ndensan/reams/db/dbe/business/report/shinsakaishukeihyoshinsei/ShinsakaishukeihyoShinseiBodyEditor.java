/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyoshinsei;

import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinseiBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinseiReportSource;

/**
 * 介護認定審査会集計表（申請区分別）のEditorです。
 *
 * @reamsid_L DBE-1450-070 dongyabin
 */
public class ShinsakaishukeihyoShinseiBodyEditor implements IShinsakaishukeihyoShinseiBodyEditor {

    private final ShinsakaiShukeihyoShinseiBody item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected ShinsakaishukeihyoShinseiBodyEditor(ShinsakaiShukeihyoShinseiBody item) {
        this.item = item;
    }

    @Override
    public ShinsakaiShukeihyoShinseiReportSource edit(ShinsakaiShukeihyoShinseiReportSource source) {
        return editSource(source);
    }

    private ShinsakaiShukeihyoShinseiReportSource editSource(ShinsakaiShukeihyoShinseiReportSource source) {
        source.listShukeihyo1_1 = item.getListShukeihyo1_1();
        source.listShukeihyo1_2 = item.getListShukeihyo1_2();
        source.listShukeihyo1_3 = item.getListShukeihyo1_3();
        source.listShukeihyo1_4 = item.getListShukeihyo1_4();
        source.listShukeihyo1_5 = item.getListShukeihyo1_5();
        source.listShukeihyo2_1 = item.getListShukeihyo2_1();
        source.listShukeihyo2_2 = item.getListShukeihyo2_2();
        source.listShukeihyo2_3 = item.getListShukeihyo2_3();
        source.listShukeihyo2_4 = item.getListShukeihyo2_4();
        source.listShukeihyo2_5 = item.getListShukeihyo2_5();
        source.listShukeihyo3_1 = item.getListShukeihyo3_1();
        source.listShukeihyo3_2 = item.getListShukeihyo3_2();
        source.listShukeihyo3_3 = item.getListShukeihyo3_3();
        return source;
    }
}
