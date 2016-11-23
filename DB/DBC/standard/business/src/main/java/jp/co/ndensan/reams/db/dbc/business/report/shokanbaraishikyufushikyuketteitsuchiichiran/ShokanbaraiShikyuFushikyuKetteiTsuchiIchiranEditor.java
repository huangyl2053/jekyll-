/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import java.nio.charset.Charset;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給（不支給）決定通知一覧表のEditorです。
 *
 * @reamsid_L DBC-1000-150 hezhenzhen
 *
 */
@SuppressWarnings("checkstyle:illegaltoken")
public class ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor implements IShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor {

    private final ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem item;
    private static final int MAX = 24;
    private static final int MIN = 0;
    private static final RString ENCODE = new RString("Shift-JIS");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem}
     */
    protected ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor(ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem item) {
        this.item = item;
    }

    @Override
    public ShokanbaraiShikyuFushikyuReportSource edit(ShokanbaraiShikyuFushikyuReportSource source) {
        return editSource(source);
    }

    private ShokanbaraiShikyuFushikyuReportSource editSource(ShokanbaraiShikyuFushikyuReportSource source) {
        
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
        
        source.listUpper_3 = item.getKeteiTsuchiNo();
        
        RString hihokenshanamelenthMax = item.getHihokenshaName() == null ? RString.EMPTY : item.getHihokenshaName();
        byte[] hihokenshaname = hihokenshanamelenthMax.toString().getBytes(Charset.forName(ENCODE.toString()));
        byte[] getHihokenshaName = new byte[hihokenshaname.length <= MAX ? hihokenshaname.length : MAX];
        System.arraycopy(hihokenshaname, MIN, getHihokenshaName, MIN, hihokenshaname.length <= MAX ? hihokenshaname.length : MAX);
        source.listUpper_5 = new RString(new String(getHihokenshaName, Charset.forName(ENCODE.toString())));

        RString jusholenthMax = item.getJusho() == null ? RString.EMPTY : item.getJusho();
        byte[] jusho = jusholenthMax.toString().getBytes(Charset.forName(ENCODE.toString()));
        byte[] getJusho = new byte[jusho.length <= MAX ? jusho.length : MAX];
        System.arraycopy(jusho, MIN, getJusho, MIN, jusho.length <= MAX ? jusho.length : MAX);
        source.listLower_1 = new RString(new String(getJusho, Charset.forName(ENCODE.toString())));

        
        source.listUpper_7 = item.getTeikyo();
        source.listLower_2 = item.getYoKaigodo();
        source.listUpper_8 = item.getNinteiKaishibi();
        source.listLower_3 = item.getNinteiShuryobi();
        source.listUpper_9 = item.getUketsukeYMD();
        source.listLower_4 = item.getKeteiYMD();
        source.listUpper_10 = item.getHonjinShiharaigaku();
        source.listUpper_11 = item.getShikyugaku().concat(RString.HALF_SPACE);
        source.listLower_5 = item.getYoshikigotoKingaku();
        if (null != item.getKingaku()) {
            source.listLower_6 = new RString("(").concat(item.getKingaku()).concat(new RString(") "));
        }
        source.listLower_7 = item.getShurui2();
        source.listUpper_12 = item.getTuika();
        source.listUpper_13 = item.getShurui1();
        source.listUpper_14 = item.getKeteiKubun();
        source.listLower_8 = item.getShiharaiHoho();
        
        source.yubinBango = item.getYubinBango();
        source.choikiCode = item.getChoikiCode();
        source.gyoseikuCode = item.getGyoseikuCode();
        source.kanaMeisho = item.getKanaMeisho();
        source.hidHokenshaNo = item.getHokenshaNo();
        source.shoKisaiHokenshaNo = item.getShoKisaiHokenshaNo();
        source.hiHokenshaNo = item.getHihokenshaNo();
        source.seiriNo = item.getSeiriNo();
        source.ketteiTsuchiNo = item.getKetteiTsuchiNo();
        source.shinseishaKubun = item.getShinseishaKubun();
        if (item.isBreakKeyFlg()) {
            return source;
        } else {
            source.listUpper_6 = item.getYubinBango();
            source.listUpper_4 = item.getHihokenshaNo();
            source.listUpper_2 = item.getSeiriNo();
        }
        return source;
    }
}
