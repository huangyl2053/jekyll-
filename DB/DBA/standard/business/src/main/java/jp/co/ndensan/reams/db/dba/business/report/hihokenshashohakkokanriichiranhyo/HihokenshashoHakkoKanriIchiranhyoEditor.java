/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihokenshashoHakkoKanriIchiranhyoEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;

/**
 * 被保険者証発行管理一覧表ヘッダEditorクラスです。
 *
 * @reamsid_L DBA-0600-070 lishengli
 */
public class HihokenshashoHakkoKanriIchiranhyoEditor implements IHihokenshashoHakkoKanriIchiranhyoEditor {

    private final HihokenshashoHakkoKanriIchiranhyoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link HihokenshashoHakkoKanriIchiranhyoEntity}
     */
    protected HihokenshashoHakkoKanriIchiranhyoEditor(HihokenshashoHakkoKanriIchiranhyoEntity entity) {
        this.entity = entity;
    }

    /**
     *
     * @param source 被保険者証発行管理一覧表のReportSourceクラス
     * @return HihokenshashoHakkoKanriIchiranhyoReportSource
     */
    @Override
    public HihokenshashoHakkoKanriIchiranhyoReportSource edit(HihokenshashoHakkoKanriIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private HihokenshashoHakkoKanriIchiranhyoReportSource editHeader(HihokenshashoHakkoKanriIchiranhyoReportSource source) {
        source.printTimeStamp = entity.getPrintTimeStamp();
        source.title = entity.getTitle();
        source.shichosonCode = entity.getShichosonCode();
        source.shichosonName = entity.getShichosonName();
        source.kaipage1 = entity.getKaipage1();
        source.kaipage2 = entity.getKaipage2();
        source.kaipage3 = entity.getKaipage3();
        source.kaipage4 = entity.getKaipage4();
        source.kaipage5 = entity.getKaipage5();
        source.shutsuryokujun1 = entity.getShutsuryokujun1();
        source.shutsuryokujun2 = entity.getShutsuryokujun2();
        source.shutsuryokujun3 = entity.getShutsuryokujun3();
        source.shutsuryokujun4 = entity.getShutsuryokujun4();
        source.shutsuryokujun5 = entity.getShutsuryokujun5();
        source.listUpper_1 = entity.getListUpper_1();
        source.listUpper_2 = entity.getListUpper_2();
        source.listUpper_3 = entity.getListUpper_3();
        source.listUpper_4 = entity.getListUpper_4();
        source.listUpper_5 = entity.getListUpper_5();
        source.listUpper_6 = entity.getListUpper_6();
        source.listUpper_7 = entity.getListUpper_7();
        source.listUpper_8 = entity.getListUpper_8();
        source.listLower_1 = entity.getListLower_1();
        source.listLower_2 = entity.getListLower_2();
        source.listLower_3 = entity.getListLower_3();
        source.listLower_4 = entity.getListLower_4();
        source.listLower_5 = entity.getListLower_5();
        source.listLower_6 = entity.getListLower_6();
        source.listLower_7 = entity.getListLower_7();
        source.yubinNo = entity.getYubinNo();
        source.choikiCode = entity.getChoikiCode();
        source.gyoseikuCode = entity.getGyoseikuCode();
        source.kanaMeisho = entity.getKanaMeisho();
        return source;
    }
}
