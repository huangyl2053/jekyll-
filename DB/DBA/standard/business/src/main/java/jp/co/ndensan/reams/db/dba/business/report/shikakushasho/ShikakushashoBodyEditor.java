/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.KyufuseigenBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.NyushoShisetsuBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.ShuruiShikyuGendoKizyunngakuBusiness;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushasho.ShikakushashoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険資格者証ボディEditorです。
 *
 * @reamsid_L DBU-0490-080 suguangjun
 */
public class ShikakushashoBodyEditor implements IShikakushashoEditor {

    private static final int NOCOUNT_1 = 1;
    private static final int NOCOUNT_2 = 2;
    private static final int NOCOUNT_3 = 3;
    private static final int NOCOUNT_4 = 4;
    private static final int NOCOUNT_5 = 5;
    private static final int NOCOUNT_6 = 6;
    private static final RString SHINSEICHU_1 = new RString("1");
    private static final RString SHINSEICHU_2 = new RString("2");
    private static final RString HOUSI = new RString("＊");

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
        RString seibetsu = item.getSeibetsu();
        source.seibetsuMan = seibetsu.equals(SHINSEICHU_1) ? RString.EMPTY : HOUSI;
        source.seibetsuWoman = seibetsu.equals(SHINSEICHU_2) ? RString.EMPTY : HOUSI;
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
        if (item.getShuruiShikyuGendoBusiness() != null) {
            List<ShuruiShikyuGendoKizyunngakuBusiness> gakuEntityList = item.getShuruiShikyuGendoBusiness();
            for (int i = 1; i <= gakuEntityList.size(); i++) {
                if (i == 1) {
                    source.shuruiShikyuServiceName1 = gakuEntityList.get(0).getServiceShurui();
                    source.shuruiShikyuTnisu1 = gakuEntityList.get(0).getShuruiShikyuKizyunngaku();
                    source.shuruiShikyuTani1 = gakuEntityList.get(0).getShuruiShikyuKizyunngakuTani();
                }
                if (i == NOCOUNT_2) {
                    source.shuruiShikyuServiceName2 = gakuEntityList.get(1).getServiceShurui();
                    source.shuruiShikyuTnisu2 = gakuEntityList.get(1).getShuruiShikyuKizyunngaku();
                    source.shuruiShikyuTani2 = gakuEntityList.get(1).getShuruiShikyuKizyunngakuTani();
                }
                if (i == NOCOUNT_3) {
                    source.shuruiShikyuServiceName3 = gakuEntityList.get(2).getServiceShurui();
                    source.shuruiShikyuTnisu3 = gakuEntityList.get(2).getShuruiShikyuKizyunngaku();
                    source.shuruiShikyuTani3 = gakuEntityList.get(2).getShuruiShikyuKizyunngakuTani();
                }
                if (i == NOCOUNT_4) {
                    source.shuruiShikyuServiceName4 = gakuEntityList.get(NOCOUNT_3).getServiceShurui();
                    source.shuruiShikyuTnisu4 = gakuEntityList.get(NOCOUNT_3).getShuruiShikyuKizyunngaku();
                    source.shuruiShikyuTani4 = gakuEntityList.get(NOCOUNT_3).getShuruiShikyuKizyunngakuTani();
                }
                if (i == NOCOUNT_5) {
                    source.shuruiShikyuServiceName5 = gakuEntityList.get(NOCOUNT_4).getServiceShurui();
                    source.shuruiShikyuTnisu5 = gakuEntityList.get(NOCOUNT_4).getShuruiShikyuKizyunngaku();
                    source.shuruiShikyuTani5 = gakuEntityList.get(NOCOUNT_4).getShuruiShikyuKizyunngakuTani();
                }
                if (i == NOCOUNT_6) {
                    source.shuruiShikyuServiceName6 = gakuEntityList.get(NOCOUNT_5).getServiceShurui();
                    source.shuruiShikyuTnisu6 = gakuEntityList.get(NOCOUNT_5).getShuruiShikyuKizyunngaku();
                    source.shuruiShikyuTani6 = gakuEntityList.get(NOCOUNT_5).getShuruiShikyuKizyunngakuTani();
                }
            }
        }
        source.serviceRyui = item.getServiceRyui();
        if (item.getKyufuseigenBusiness() != null) {
            List<KyufuseigenBusiness> seigenEntityList = item.getKyufuseigenBusiness();
            for (int i = 1; i <= seigenEntityList.size(); i++) {
                if (i == 1) {
                    source.kyufuseigenNaiyo1 = seigenEntityList.get(0).getKyufuseigenNaiyo();
                    source.kyufuseigenKaishiYMD1 = seigenEntityList.get(0).getKyufuseigenKaishiYMD();
                    source.kyufuseigenShuryoYMD1 = seigenEntityList.get(0).getKyufuseigenShuryoYMD();
                }
                if (i == NOCOUNT_2) {
                    source.kyufuseigenNaiyo2 = seigenEntityList.get(1).getKyufuseigenNaiyo();
                    source.kyufuseigenKaishiYMD2 = seigenEntityList.get(1).getKyufuseigenKaishiYMD();
                    source.kyufuseigenShuryoYMD2 = seigenEntityList.get(1).getKyufuseigenShuryoYMD();
                }
                if (i == NOCOUNT_3) {
                    source.kyufuseigenNaiyo3 = seigenEntityList.get(2).getKyufuseigenNaiyo();
                    source.kyufuseigenKaishiYMD3 = seigenEntityList.get(2).getKyufuseigenKaishiYMD();
                    source.kyufuseigenShuryoYMD3 = seigenEntityList.get(2).getKyufuseigenShuryoYMD();
                }
            }
        }
        bodyEdit2(source);
        return source;
    }

    private ShikakushashoReportSource bodyEdit2(ShikakushashoReportSource source) {
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
        if (item.getNyushoShisetsuBusiness() != null) {
            List<NyushoShisetsuBusiness> entityList = item.getNyushoShisetsuBusiness();
            for (int i = 1; i <= entityList.size(); i++) {
                if (i == 1) {
                    source.nyushoShisetsuShurui1 = entityList.get(0).getNyushoShisetsuShurui();
                    source.nyushoShisetsuName1 = entityList.get(0).getNyushoShisetsuName();
                    source.shisetsuNyushoYMD1 = entityList.get(0).getShisetsuNyushoYMD();
                    source.shisetsuTaishoYMD1 = entityList.get(0).getShisetsuTaishoYMD();
                }
                if (i == NOCOUNT_2) {
                    source.nyushoShisetsuShurui2 = entityList.get(1).getNyushoShisetsuShurui();
                    source.nyushoShisetsuName2 = entityList.get(1).getNyushoShisetsuName();
                    source.shisetsuNyushoYMD2 = entityList.get(1).getShisetsuNyushoYMD();
                    source.shisetsuTaishoYMD2 = entityList.get(1).getShisetsuTaishoYMD();
                }
            }
        }
        source.shisetsuNyusho1 = item.getShisetsuNyusho();
        source.shisetsuNyuin1 = item.getShisetsuNyuin();
        source.shisetsuTaisho1 = item.getShisetsuTaisho();
        source.shisetsuTaiin1 = item.getShisetsuTaiin();
        source.shisetsuNyusho2 = item.getShisetsuNyusho();
        source.shisetsuNyuin2 = item.getShisetsuNyuin();
        source.shisetsuTaisho2 = item.getShisetsuTaisho();
        source.shisetsuTaiin2 = item.getShisetsuTaiin();
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
