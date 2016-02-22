/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyokaisokanrimasterlist;

import jp.co.ndensan.reams.db.dba.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;

/**
 * 境界層管理マスタリストヘッダEditorです。
 */
class KyokaisoKanriMasterListHeaderEditor implements KyokaisoKanriMasterListEditor {

    private final KyokaisoKanriMasterListHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyokaisoKanriMasterListItem}
     */
    protected KyokaisoKanriMasterListHeaderEditor(KyokaisoKanriMasterListHeadItem headItem) {
        this.headItem = headItem;
    }

    @Override
    public KyokaisoKanriMasterListReportSource edit(KyokaisoKanriMasterListReportSource source) {
        return editHeader(source);
    }

    private KyokaisoKanriMasterListReportSource editHeader(KyokaisoKanriMasterListReportSource source) {

        source.printTimeStamp = headItem.getPrintTimeStamp();
        // TODO 袁献輝 QA608、rseファイルにpageCountを存在しない　2016/02/20。
//        source.pageCount = item.getPageCount();
        source.shichosonCode = headItem.getShichosonCode();
        source.shichosonName = headItem.getShichosonName();
        source.shutsuryokujun1 = headItem.getShutsuryokujun1();
        source.shutsuryokujun2 = headItem.getShutsuryokujun2();
        source.shutsuryokujun3 = headItem.getShutsuryokujun3();
        source.shutsuryokujun4 = headItem.getShutsuryokujun4();
        source.shutsuryokujun5 = headItem.getShutsuryokujun5();
        source.kaipage1 = headItem.getKaipage1();
        source.kaipage2 = headItem.getKaipage2();
        source.kaipage3 = headItem.getKaipage3();
        source.kaipage4 = headItem.getKaipage4();
        source.kaipage5 = headItem.getKaipage5();
        return source;
    }
}
