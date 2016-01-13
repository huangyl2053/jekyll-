/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist;

import jp.co.ndensan.reams.db.dba.entity.report.jukirendotorokulist.JukiRendoTorokuListReportSource;

/**
 *
 * @author yuyong3
 */
class JukiRendoTorokuListBodyEditor implements IJukiRendoTorokuListEditor {

    private final JukiRendoTorokuListItem item;

    public JukiRendoTorokuListBodyEditor(JukiRendoTorokuListItem item) {
        this.item = item;
    }

    @Override
    public JukiRendoTorokuListReportSource edit(JukiRendoTorokuListReportSource source) {

        return editBody(source);
    }

    private JukiRendoTorokuListReportSource editBody(JukiRendoTorokuListReportSource source) {

        source.shichosonCode = item.getShichosonCode();
        source.shichosonName = item.getShichosonName();
        source.shutsuryokujun1 = item.getShutsuryokujun1();
        source.shutsuryokujun2 = item.getShutsuryokujun2();
        source.shutsuryokujun3 = item.getShutsuryokujun3();
        source.shutsuryokujun4 = item.getShutsuryokujun4();
        source.shutsuryokujun5 = item.getShutsuryokujun5();
        source.kaipage1 = item.getKaipage1();
        source.kaipage2 = item.getKaipage2();
        source.kaipage3 = item.getKaipage3();
        source.kaipage4 = item.getKaipage4();
        source.kaipage5 = item.getKaipage5();
        source.idoJohoTitle1 = item.getIdoJohoTitle1();
        source.idoJohoTitle2 = item.getIdoJohoTitle2();
        source.idoJohoTitle3 = item.getIdoJohoTitle3();
        source.idoJohoTitle4 = item.getIdoJohoTitle4();
        source.idoJohoTitle5 = item.getIdoJohoTitle5();
        source.idoJohoTitle6 = item.getIdoJohoTitle6();
        source.listHihokenshaNo_1 = item.getListHihokenshaNo_1();
        source.listUpper_1 = item.getListUpper_1();
        source.listUpper_2 = item.getListUpper_2();
        source.listUpper_3 = item.getListUpper_3();
        source.listUpper_4 = item.getListUpper_4();
        source.listUpper_5 = item.getListUpper_5();
        source.listUpper_6 = item.getListUpper_6();
        source.listUpper_7 = item.getListUpper_7();
        source.listUpper_8 = item.getListUpper_8();
        source.listUpper_9 = item.getListUpper_9();
        source.listUpper_10 = item.getListUpper_10();
        source.listUpper_11 = item.getListUpper_11();
        source.listUpper_12 = item.getListUpper_12();
        source.listUpper_13 = item.getListUpper_13();
        source.listUpper_14 = item.getListUpper_14();
        source.listLower_1 = item.getListLower_1();
        source.listLower_2 = item.getListLower_2();
        source.listLower_3 = item.getListLower_3();
        source.listLower_4 = item.getListLower_4();
        source.listLower_5 = item.getListLower_5();
        source.listLower_6 = item.getListLower_6();
        source.listLower_7 = item.getListLower_7();
        source.listLower_8 = item.getListLower_8();
        source.listLower_9 = item.getListLower_9();
        source.listLower_10 = item.getListLower_10();
        source.listLower_11 = item.getListLower_11();
        source.listLower_12 = item.getListLower_12();
        source.listLower_13 = item.getListLower_13();
        source.listLower_14 = item.getListLower_14();
        source.shuryoTitle = item.getShuryoTitle();
        source.shuryoYmdTitle = item.getShuryoYmdTitle();
        source.kaishiTitle = item.getKaishiTitle();
        source.kaishiYmdTitle = item.getKaishiYmdTitle();
        source.kubunTitle = item.getKubunTitle();
        return source;
    }

}
