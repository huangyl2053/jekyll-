/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranhyoReportSource;

/**
 *
 * 被保険者証発行一覧表Editorです。
 */
public class HihokenshashoHakkoIchiranHyoEditor implements IHihokenshashoHakkoIchiranHyoEditor {
    
    private final HihokenshashoHakkoIchiranHyoItem joho;
    
    /**
     * コンストラクタです。
     * @param joho 一覧表証発行者Entityリストです
     */
    public HihokenshashoHakkoIchiranHyoEditor(HihokenshashoHakkoIchiranHyoItem joho) {
        this.joho = joho;
    }

    /**
     * 要介護認定業務進捗状況一覧表editです。
     * @param source 被保険者証発行一覧表Source
     * @return 要介護認定業務進捗状況一覧表
     */
    @Override
    public HihokenshashoHakkoIchiranhyoReportSource edit(HihokenshashoHakkoIchiranhyoReportSource source) {
        return editBody(source);
    }
    
    private HihokenshashoHakkoIchiranhyoReportSource editBody(HihokenshashoHakkoIchiranhyoReportSource source) {
        source.printTimeStamp = joho.getPrintTimeStamp();
        source.shichosonName = joho.getShichosonName();
        source.shichosonCode = joho.getShichosonCode();
        source.shutsuryokujun1 = joho.getShutsuryokujun1();
        source.shutsuryokujun2 = joho.getShutsuryokujun2();
        source.shutsuryokujun3 = joho.getShutsuryokujun3();
        source.shutsuryokujun4 = joho.getShutsuryokujun4();
        source.shutsuryokujun5 = joho.getShutsuryokujun5();
        source.kaipage1 = joho.getKaipage1();
        source.kaipage2 = joho.getKaipage2();
        source.kaipage3 = joho.getKaipage3();
        source.kaipage4 = joho.getKaipage4();
        source.kaipage5 = joho.getKaipage5();
        source.kofujiyutitle = joho.getKofujiyutitle();
        source.list_1 = joho.getList_1();
        source.list_2 = joho.getList_2();
        source.list_3 = joho.getList_3();
        source.list_4 = joho.getList_4();
        source.list_5 = joho.getList_5();
        source.list_6 = joho.getList_6();
        source.list_7 = joho.getList_7();
        source.list_8 = joho.getList_8();
        source.list_9 = joho.getList_9();
        source.list_10 = joho.getList_10();

        return source;
    }
    
}
