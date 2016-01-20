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

    /**
     *
     * @param source 認定調査スケジュール表(調査員)Sourceクラス
     * @return ChosaSchedulehyoTyousayinReportSource 認定調査スケジュール表(調査員)Sourceクラス
     */
    @Override
    public ChosaSchedulehyoTyousayinReportSource edit(ChosaSchedulehyoTyousayinReportSource source) {
        return editBody(source);
    }

    private ChosaSchedulehyoTyousayinReportSource editBody(ChosaSchedulehyoTyousayinReportSource source) {
        source.listChosaSukejuru_1 = item.getNo();
        source.listChosaSukejuru_2 = item.getNinyutyousayinnNo();
        source.listChosaSukejuru_3 = item.getNinyutyousayinnName();
        if (item.getNinnteyityousayoteyibi() == null || item.getNinnteyityousayoteyibi().isEmpty()) {
            source.listChosaSukejuru_4 = RString.EMPTY;
        } else {
            source.listChosaSukejuru_4 = new RDate(item.getNinnteyityousayoteyibi().toString()).wareki().toDateString();
        }
        RStringBuilder ninnteyityousaTime = new RStringBuilder();
        ninnteyityousaTime.append(item.getNinnteyityousakaisiTime());
        ninnteyityousaTime.append(KANA);
        ninnteyityousaTime.append(item.getNinnteyityousasyuroTime());
        source.listChosaSukejuru_5 = ninnteyityousaTime.toRString();
        source.listChosaSukejuru_6 = item.getJyoukyou();
        source.listChosaSukejuru_7 = item.getHihokennsyaNo();
        source.listChosaSukejuru_8 = item.getHihokennsyaName();
        source.listChosaSukejuru_9 = item.getHihokennsyaAdd();
        source.listChosaSukejuru_10 = item.getTyousajisibasyou();
        //TODO 李 QA501 立会者の編集
        source.listChosaSukejuru_11 = item.getTatiayisya();
        source.listTel1_1 = item.getRennrakusaki1();
        source.listTel2_1 = item.getRennrakusaki2();
        return source;
    }
}
