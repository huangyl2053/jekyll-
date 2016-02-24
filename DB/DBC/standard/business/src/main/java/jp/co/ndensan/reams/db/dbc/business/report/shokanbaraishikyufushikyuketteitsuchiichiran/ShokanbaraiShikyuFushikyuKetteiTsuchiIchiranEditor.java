/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource;

/**
 * 償還払支給（不支給）決定通知一覧表覧表のEditorです。
 */
public class ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor implements IShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor {

    private final ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem}
     */
    protected ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor(ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem item) {
        this.item = item;
    }

    @Override
    public ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource edit(ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource source) {
        return editSource(source);
    }

    private ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource editSource(ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
        source.hokenshaNo = item.getHokenshaNo();
        source.hokenshaName = item.getHokenshaName();
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
        source.listUpper_1 = item.getRenban();
        source.listUpper_2 = item.getSeiriNo();
        source.listUpper_3 = item.getKeteiTsuchiNo();
        source.listUpper_4 = item.getHihokenshaNo();
        source.listUpper_5 = item.getHihokenshaName();
        source.listLower_1 = item.getJusho();
        source.listUpper_6 = item.getYubinBango();
        source.listUpper_7 = item.getTeikyo();
        source.listLower_2 = item.getYoKaigodo();
        source.listUpper_8 = item.getNinteiKaishibi();
        source.listLower_3 = item.getNinteiShuryobi();
        source.listUpper_9 = item.getUketsukeYMD();
        source.listLower_4 = item.getKeteiYMD();
        source.listUpper_10 = item.getHonjinShiharaigaku();
        source.listUpper_11 = item.getShikyugaku();
        source.listLower_5 = item.getYoshikigotoKingaku();
        source.listUpper_12 = item.getTuika();
        source.listUpper_13 = item.getShurui();
        source.listUpper_14 = item.getKeteiKubun();
        source.listLower_9 = item.getShiharaiHoho();
        return source;
    }
}
