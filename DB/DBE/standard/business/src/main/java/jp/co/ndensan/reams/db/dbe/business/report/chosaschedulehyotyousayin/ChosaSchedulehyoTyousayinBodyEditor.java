/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * 認定調査スケジュール表(調査員)ボディEditorです。
 */
class ChosaSchedulehyoTyousayinBodyEditor implements IChosaSchedulehyoTyousayinEditor {

    private final ChosaSchedulehyoTyousayinBodyItem item;
    private static final RString KANA = new RString("-");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaSchedulehyoTyousayinBodyItem}
     */
    protected ChosaSchedulehyoTyousayinBodyEditor(ChosaSchedulehyoTyousayinBodyItem item) {
        this.item = item;
    }

    @Override
    public ChosaSchedulehyoTyousayinReportSource edit(ChosaSchedulehyoTyousayinReportSource source) {
        return editBody(source);
    }

    private ChosaSchedulehyoTyousayinReportSource editBody(ChosaSchedulehyoTyousayinReportSource source) {
        source.listChosaSukejuru_1 = item.getListChosaSukejuru_1();
        source.listChosaSukejuru_2 = item.getListChosaSukejuru_2();
        source.listChosaSukejuru_3 = item.getListChosaSukejuru_3();
        source.listChosaSukejuru_4 = new RDate(item.getListChosaSukejuru_4().toString()).wareki().toDateString();
        RStringBuilder ninnteyityousaTime = new RStringBuilder();
        ninnteyityousaTime.append(item.getNinnteyityousakaisiTime());
        ninnteyityousaTime.append(KANA);
        ninnteyityousaTime.append(item.getNinnteyityousasyuroTime());
        source.listChosaSukejuru_5 = ninnteyityousaTime.toRString();
        source.listChosaSukejuru_6 = item.getListChosaSukejuru_6();
        source.listChosaSukejuru_7 = item.getListChosaSukejuru_7();
        source.listChosaSukejuru_8 = item.getListChosaSukejuru_8();
        source.listChosaSukejuru_9 = item.getListChosaSukejuru_9();
        source.listChosaSukejuru_10 = item.getListChosaSukejuru_10();
        source.listChosaSukejuru_11 = item.getListChosaSukejuru_11();
        source.listTel1_1 = item.getListTel1_1();
        source.listTel2_1 = item.getListTel2_1();
        return source;
    }
}
