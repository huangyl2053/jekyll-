/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200024;

import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200024.ShokanbaraiSashitomeTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200024_償還払支給差止対象者一覧表のEditor
 *
 * @reamsid_L DBC-1000-160 liwul
 */
public class ShokanbaraiSashitomeTaishoshaIchiranEditor implements IShokanbaraiSashitomeTaishoshaIchiranEditor {

    private final ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem entity;
    private static final int 文字目_0 = 0;
    private static final int 文字目_15 = 15;
    private static final int 文字目_25 = 25;
    private static final int 文字目_30 = 30;
    private static final int 文字目_50 = 50;

    /**
     * コンストラクタです
     *
     * @param entity 帳票用のentity
     */
    public ShokanbaraiSashitomeTaishoshaIchiranEditor(ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem entity) {
        this.entity = entity;
    }

    @Override
    public ShokanbaraiSashitomeTaishoshaIchiranSource edit(ShokanbaraiSashitomeTaishoshaIchiranSource source) {
        source.printTimeStamp = entity.getPrintTimeStamp();
        source.hokenshaNo = entity.getHihokenshaNo();
        source.hokenshaName = entity.getHokenshaName();
        source.shutsuryokujun1 = entity.getShutsuryokujun1();
        source.shutsuryokujun2 = entity.getShutsuryokujun2();
        source.shutsuryokujun3 = entity.getShutsuryokujun3();
        source.shutsuryokujun4 = entity.getShutsuryokujun4();
        source.shutsuryokujun5 = entity.getShutsuryokujun5();
        source.kaipage1 = entity.getKaipage1();
        source.kaipage2 = entity.getKaipage2();
        source.kaipage3 = entity.getKaipage3();
        source.kaipage4 = entity.getKaipage4();
        source.kaipage5 = entity.getKaipage5();
        source.List1_1 = entity.getRenban();
        source.List1_2 = entity.getSeiriNo();
        source.List1_3 = entity.getKetteiTsuchiNo();
        source.List1_4 = entity.getHihokenshaNo();
        source.List1_5 = subRString(entity.getHihokenshaName(), 文字目_0, 文字目_15);
        source.List1_6 = entity.getYubinBango();
        source.List1_7 = subRString(entity.getJusho(), 文字目_0, 文字目_25);
        source.List1_8 = entity.getUketsukeYMD();
        source.List1_9 = entity.getHonjinShiharaigaku();
        source.List1_10 = entity.getTuika();
        source.List2_1 = subRString(entity.getHihokenshaName(), 文字目_15, 文字目_30);
        source.List2_2 = subRString(entity.getJusho(), 文字目_25, 文字目_50);
        source.List2_3 = entity.getKeteiYMD();
        source.List2_4 = entity.getShikyugaku();
        return source;
    }

    private RString subRString(RString str, int start, int end) {
        if (RString.isNullOrEmpty(str) || str.length() < start) {
            return RString.EMPTY;
        }
        return str.substringReturnAsPossible(start, end);
    }
}
