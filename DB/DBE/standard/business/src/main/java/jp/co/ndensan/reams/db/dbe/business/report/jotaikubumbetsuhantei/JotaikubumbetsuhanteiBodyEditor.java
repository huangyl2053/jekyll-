/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jotaikubumbetsuhantei;

import jp.co.ndensan.reams.db.dbe.business.core.jotaikubumbetsuhantei.JotaikubumbetsuhanteiBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jotaikubumbetsuhantei.JotaikubumbetsuhanteiReportSource;

/**
 * 要介護状態区分別判定件数のEditorです。
 *
 * @reamsid_L DBE-1450-050 dongyabin
 */
public class JotaikubumbetsuhanteiBodyEditor implements IJotaikubumbetsuhanteiBodyEditor {

    private final JotaikubumbetsuhanteiBody item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected JotaikubumbetsuhanteiBodyEditor(JotaikubumbetsuhanteiBody item) {
        this.item = item;
    }

    @Override
    public JotaikubumbetsuhanteiReportSource edit(JotaikubumbetsuhanteiReportSource source) {
        return editSource(source);
    }

    private JotaikubumbetsuhanteiReportSource editSource(JotaikubumbetsuhanteiReportSource source) {
        source.listHantei1_1 = item.getListHantei1_1();
        source.listHantei1_2 = item.getListHantei1_2();
        source.listHantei1_3 = item.getListHantei1_3();
        source.listHantei1_4 = item.getListHantei1_4();
        source.listHantei1_5 = item.getListHantei1_5();
        source.listHantei1_6 = item.getListHantei1_6();
        source.listHantei1_7 = item.getListHantei1_7();
        source.listHantei1_8 = item.getListHantei1_8();
        source.listHantei1_9 = item.getListHantei1_9();
        source.listHantei1_10 = item.getListHantei1_10();
        source.listHantei_1 = item.getListHantei_1();
        source.listHantei_2 = item.getListHantei_2();
        source.listHantei_3 = item.getListHantei_3();
        source.listHantei_4 = item.getListHantei_4();
        source.listHantei_5 = item.getListHantei_5();
        return source;
    }
}
