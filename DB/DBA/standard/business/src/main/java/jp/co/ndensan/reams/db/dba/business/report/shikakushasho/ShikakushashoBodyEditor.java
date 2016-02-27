/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import jp.co.ndensan.reams.db.dba.entity.report.shikakushasho.ShikakushashoReportSource;

/**
 * 介護保険資格者証ボディEditorです。
 * 
 */
public class ShikakushashoBodyEditor implements IShikakushashoEditor {

    private final ShikakushashoBodyItem item;
    private final int no;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険資格者証リスト情報
     * @param no NO
     */
    public ShikakushashoBodyEditor(ShikakushashoBodyItem item, int no) {
        this.item = item;
        this.no = no + 1;
    }

    /**
     * 介護保険資格者証ボディEditorです。
     *
     * @param source 介護保険資格者証Source
     * @return 介護保険資格者証Source
     */
    @Override
    public ShikakushashoReportSource edit(ShikakushashoReportSource source) {
        return bodyEdit(source);
    }

    private ShikakushashoReportSource bodyEdit(ShikakushashoReportSource source) {

        source.subTitle = item.getSubTitle();
        source.yukoKigen = item.getYukoKigen();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.jusho = item.getJusho();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthYMD = item.getBirthYMD();
        source.kofuYMD = item.getKofuYMD();
        source.yokaigoJotaiKubun = item.getYokaigoJotaiKubun();
        source.ninteiYMD = item.getNinteiYMD();
        source.yukoKaishiYMD = item.getYukoKaishiYMD();
        source.yukoShuryoYMD = item.getYukoShuryoYMD();
        source.kubunShikyuTanisu = item.getKubunShikyuTanisu();
        source.kubunShikyuYukoKaishiYMD = item.getKubunShikyuYukoKaishiYMD();
        source.kubunShikyuYukoShuryoYMD = item.getKubunShikyuYukoShuryoYMD();
        source.kubunShikyuTaniShurui = item.getKubunShikyuTaniShurui();
        source.kubunShikyuTani = item.getKubunShikyuTani();
        source.serviceRyui = item.getServiceRyui();
        source.keikakuJigyoshaName1 = item.getKeikakuJigyoshaName1();
        source.keikakuTodokedeYMD1 = item.getKeikakuTodokedeYMD1();
        source.nyushoShisetsuShurui1 = item.getNyushoShisetsuShurui1();
        source.nyushoShisetsuName1 = item.getNyushoShisetsuName1();
        source.shisetsuNyusho1 = item.getShisetsuNyusho1();
        source.shisetsuNyuin1 = item.getShisetsuNyuin1();
        source.shisetsuNyushoYMD1 = item.getShisetsuNyushoYMD1();
        source.shisetsuTaisho1 = item.getShisetsuTaisho1();
        source.shisetsuTaiin1 = item.getShisetsuTaiin1();
        source.shisetsuTaishoYMD1 = item.getShisetsuTaishoYMD1();
        source.nyushoShisetsuShurui2 = item.getNyushoShisetsuShurui2();
        source.nyushoShisetsuName2 = item.getNyushoShisetsuName2();
        source.shisetsuNyusho2 = item.getShisetsuNyusho2();
        source.shisetsuNyuin2 = item.getShisetsuNyuin2();
        source.shisetsuNyushoYMD2 = item.getShisetsuNyushoYMD2();
        source.shisetsuTaisho2 = item.getShisetsuTaisho2();
        source.shisetsuTaiin2 = item.getShisetsuTaiin2();
        source.shisetsuTaishoYMD2 = item.getShisetsuTaishoYMD2();
        source.hokenshaNo1 = item.getHokenshaNo1();
        source.hokenshaNo2 = item.getHokenshaNo2();
        source.hokenshaNo3 = item.getHokenshaNo3();
        source.hokenshaNo4 = item.getHokenshaNo4();
        source.hokenshaNo5 = item.getHokenshaNo5();
        source.hokenshaNo6 = item.getHokenshaNo6();
        source.hokenshaJusho = item.getHokenshaJusho();
        source.hokenshaName = item.getHokenshaName();
        source.hokenshaTelno = item.getHokenshaTelno();
        source.remban = item.getRemban();
        source.denshiKoin = item.getDenshiKoin();
        return source;
    }
}
