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
 * @reamsid_L DBU-0490-080  suguangjun
 */
public class ShikakushashoBodyEditor implements IShikakushashoEditor {

    private static final int NOCOUNT_1 = 1;
    private static final int NOCOUNT_2 = 2;
    private static final int NOCOUNT_3 = 3;
    private static final int NOCOUNT_4 = 4;
    private static final int NOCOUNT_5 = 5;
    private static final int NOCOUNT_6 = 6;

    private final ShikakushashoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険資格者証リスト情報
     */
    public ShikakushashoBodyEditor(ShikakushashoBodyItem item) {
        this.item = item;
    }

    /**
     * 介護保険資格者証ボディEditorです。
     *
     * @param source 介護保険資格者証Source
     * @return 介護保険資格者証Source
     */
    @Override
    public ShikakushashoReportSource edit(ShikakushashoReportSource source) {
        return bodyEdit1(source);
    }

    private ShikakushashoReportSource bodyEdit1(ShikakushashoReportSource source) {
        source.subTitle = item.getSubTitle();
        source.yukoKigen = item.getYukoKigen();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.jusho = item.getJusho();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthGengoMeiji = item.getBirthGengoMeiji();
        source.birthGengoTaisho = item.getBirthGengoTaisho();
        source.birthGengoShowa = item.getBirthGengoShowa();
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
        if (!item.getShuruiShikyuServiceName().isEmpty()) {
            for (int i = 1; i <= item.getShuruiShikyuServiceName().size(); i++) {
                if (i == 1) {
                    source.shuruiShikyuServiceName1 = item.getShuruiShikyuServiceName().get(0);
                }
                if (i == NOCOUNT_2) {
                    source.shuruiShikyuServiceName2 = item.getShuruiShikyuServiceName().get(1);
                }
                if (i == NOCOUNT_3) {
                    source.shuruiShikyuServiceName3 = item.getShuruiShikyuServiceName().get(2);
                }
                if (i == NOCOUNT_4) {
                    source.shuruiShikyuServiceName4 = item.getShuruiShikyuServiceName().get(NOCOUNT_3);
                }
                if (i == NOCOUNT_5) {
                    source.shuruiShikyuServiceName5 = item.getShuruiShikyuServiceName().get(NOCOUNT_4);
                }
                if (i == NOCOUNT_6) {
                    source.shuruiShikyuServiceName6 = item.getShuruiShikyuServiceName().get(NOCOUNT_6);
                }
            }
        }
        if (!item.getShuruiShikyuTnisu().isEmpty()) {
            for (int i = 1; i <= item.getShuruiShikyuTnisu().size(); i++) {
                if (i == 1) {
                    source.shuruiShikyuTnisu1 = item.getShuruiShikyuTnisu().get(0);
                }
                if (i == NOCOUNT_2) {
                    source.shuruiShikyuTnisu2 = item.getShuruiShikyuTnisu().get(1);
                }
                if (i == NOCOUNT_3) {
                    source.shuruiShikyuTnisu3 = item.getShuruiShikyuTnisu().get(2);
                }
                if (i == NOCOUNT_4) {
                    source.shuruiShikyuTnisu4 = item.getShuruiShikyuTnisu().get(NOCOUNT_3);
                }
                if (i == NOCOUNT_5) {
                    source.shuruiShikyuTnisu5 = item.getShuruiShikyuTnisu().get(NOCOUNT_4);
                }
                if (i == NOCOUNT_6) {
                    source.shuruiShikyuTnisu6 = item.getShuruiShikyuTnisu().get(NOCOUNT_6);
                }
            }
        }
        bodyEdit2(source);
        return source;
    }

    private ShikakushashoReportSource bodyEdit2(ShikakushashoReportSource source) {
        if (!item.getShuruiShikyuTani().isEmpty()) {
            for (int i = 1; i <= item.getShuruiShikyuTani().size(); i++) {
                if (i == 1) {
                    source.shuruiShikyuTani1 = item.getShuruiShikyuTani().get(0);
                }
                if (i == NOCOUNT_2) {
                    source.shuruiShikyuTani2 = item.getShuruiShikyuTani().get(1);
                }
                if (i == NOCOUNT_3) {
                    source.shuruiShikyuTani3 = item.getShuruiShikyuTani().get(2);
                }
                if (i == NOCOUNT_4) {
                    source.shuruiShikyuTani4 = item.getShuruiShikyuTani().get(NOCOUNT_3);
                }
                if (i == NOCOUNT_5) {
                    source.shuruiShikyuTani5 = item.getShuruiShikyuTani().get(NOCOUNT_4);
                }
                if (i == NOCOUNT_6) {
                    source.shuruiShikyuTani6 = item.getShuruiShikyuTani().get(NOCOUNT_6);
                }
            }
        }
        source.serviceRyui = item.getServiceRyui();
        source.keikakuJigyoshaName1 = item.getKeikakuJigyoshaName1();
        source.keikakuTodokedeYMD1 = item.getKeikakuTodokedeYMD1();
        source.keikakuJigyoshaName2 = item.getKeikakuJigyoshaName2();
        source.keikakuJigyoshaName2Asutarisuku = item.getShaName2Asutarisuku();
        source.keikakuJigyoshaName2Masshosen = item.getKeikakuJigyoshaName2Masshosen();
        source.keikakuTodokedeYMD2 = item.getKeikakuTodokedeYMD2();
        source.keikakuTodokedeYMD2Asutarisuku = item.getKeikakuTodokedeYMD2Asutarisuku();
        source.keikakuTodokedeYMD2Masshosen = item.getKeikakuTodokedeYMD2Masshosen();
        source.keikakuJigyoshaName3 = item.getKeikakuJigyoshaName3();
        source.keikakuJigyoshaName3Asutarisuku = item.getShaName3Asutarisuku();
        source.keikakuJigyoshaName3Masshosen = item.getKeikakuJigyoshaName3Masshosen();
        source.keikakuTodokedeYMD3 = item.getKeikakuTodokedeYMD3();
        source.keikakuTodokedeYMD3Asutarisuku = item.getKeikakuTodokedeYMD3Asutarisuku();
        source.keikakuTodokedeYMD3Masshosen = item.getKeikakuTodokedeYMD3Masshosen();
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
        if (item.getHokenshaNo() != null) {
            for (int i = 1; i <= item.getHokenshaNo().length(); i++) {
                if (i == 1) {
                    source.hokenshaNo1 = item.getHokenshaNo().substring(0, NOCOUNT_1);
                }
                if (i == NOCOUNT_2) {
                    source.hokenshaNo2 = item.getHokenshaNo().substring(NOCOUNT_1, NOCOUNT_2);
                }
                if (i == NOCOUNT_3) {
                    source.hokenshaNo3 = item.getHokenshaNo().substring(NOCOUNT_2, NOCOUNT_3);
                }
                if (i == NOCOUNT_4) {
                    source.hokenshaNo4 = item.getHokenshaNo().substring(NOCOUNT_3, NOCOUNT_4);
                }
                if (i == NOCOUNT_5) {
                    source.hokenshaNo5 = item.getHokenshaNo().substring(NOCOUNT_4, NOCOUNT_5);
                }
                if (i == NOCOUNT_6) {
                    source.hokenshaNo6 = item.getHokenshaNo().substring(NOCOUNT_5, NOCOUNT_6);
                }
            }
        }
        source.hokenshaJusho = item.getHokenshaJusho();
        source.hokenshaName = item.getHokenshaName();
        source.hokenshaTelno = item.getHokenshaTelno();
        source.remban = item.getRemban();
        source.denshiKoin = item.getDenshiKoin();
        return source;
    }
}
