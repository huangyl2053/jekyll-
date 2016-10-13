 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import jp.co.ndensan.reams.db.dbb.entity.report.fukadaicho.FukaDaichoSource;

/**
 * 賦課台帳（本算定）帳票 BodyEditor
 *
 * @reamsid_L DBB-9100-030 surun
 */
class FukaDaichoBodyEditor implements IFukaDaichoEditor {

    private final FukaDaichoItem item;

    protected FukaDaichoBodyEditor(FukaDaichoItem item) {
        this.item = item;
    }

    @Override
    public FukaDaichoSource edit(FukaDaichoSource source) {
        source.kozaMeiginin = item.getKozaMeiginin();
        source.bankName = item.getBankName();
        source.bankNo = item.getBankNo();
        source.choteiJiyu1 = item.getChoteiJiyu1();
        source.choteiJiyu2 = item.getChoteiJiyu2();
        source.choteiJiyu3 = item.getChoteiJiyu3();
        source.choteiJiyu4 = item.getChoteiJiyu4();
        source.dainoninJusho = item.getDainoninJusho();
        source.dainoninName = item.getDainoninName();
        source.dainoninNameKana = item.getDainoninNameKana();
        source.dainoninRenrakuSaki1 = item.getDainoninRenrakuSaki1();
        source.dainoninRenrakuSaki2 = item.getDainoninRenrakuSaki2();
        source.dainoninyubinNo = item.getDainoninyubinNo();
        source.henkoJiyu1 = item.getHenkoJiyu1();
        source.henkoJiyu2 = item.getHenkoJiyu2();
        source.henkoJiyu3 = item.getHenkoJiyu3();
        source.henkoJiyu4 = item.getHenkoJiyu4();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hokenshaName = item.getHokenshaName();
        source.hokenshaNo = item.getHokenshaNo();
        source.honinBirthYMD = item.getHoninBirthYMD();
        source.honinJusho = item.getHoninJusho();
        source.honinName = item.getHoninName();
        source.honinNameKana = item.getHoninNameKana();
        source.honinRenrakuSaki1 = item.getHoninRenrakuSaki1();
        source.honinRenrakuSaki2 = item.getHoninRenrakuSaki2();
        source.honinSeibetsu = item.getHoninSeibetsu();
        source.honinShotokuDankaiHenko = item.getHoninShotokuDankaiHenko();
        source.honinTokuchoGimusha = item.getHoninTokuchoGimusha();
        source.honinTokuchoTaishoNenkin = item.getHoninTokuchoTaishoNenkin();
        source.honinyubinNo = item.getHoninyubinNo();
        source.hyojicode1 = item.getHyojicode1();
        source.hyojicode2 = item.getHyojicode2();
        source.hyojicode3 = item.getHyojicode3();
        source.hyojicodeName1 = item.getHyojicodeName1();
        source.hyojicodeName2 = item.getHyojicodeName2();
        source.hyojicodeName3 = item.getHyojicodeName3();
        source.jukyuJoho = item.getJukyuJoho();
        source.kazeiHikazei = item.getKazeiHikazei();
        source.kozaNo = item.getKozaNo();
        source.kozaShurui = item.getKozaShurui();
        source.listFuchoKi_1 = item.getListFuchoKi_1();
        source.listFuchoKi_2 = item.getListFuchoKi_2();
        source.listFuchoKi_3 = item.getListFuchoKi_3();
        source.listFuchoKi_4 = item.getListFuchoKi_4();
        source.listFuchoKi_5 = item.getListFuchoKi_5();
        source.listFuchoKi_6 = item.getListFuchoKi_6();
        source.listFuchoKi_7 = item.getListFuchoKi_7();
        source.listFuchoKi_8 = item.getListFuchoKi_8();
        source.listFuchoKi_9 = item.getListFuchoKi_9();
        source.listFuchoKi_10 = item.getListFuchoKi_10();
        source.listFuchoKi_11 = item.getListFuchoKi_11();
        source.listFuchoKi_12 = item.getListFuchoKi_12();
        source.listFuchoKi_13 = item.getListFuchoKi_13();
        source.listFuchoKi_14 = item.getListFuchoKi_14();
        source.listFuchoTsuki_1 = item.getListFuchoTsuki_1();
        source.listFuchoTsuki_2 = item.getListFuchoTsuki_2();
        source.listFuchoTsuki_3 = item.getListFuchoTsuki_3();
        source.listFuchoTsuki_4 = item.getListFuchoTsuki_4();
        source.listFuchoTsuki_5 = item.getListFuchoTsuki_5();
        source.listFuchoTsuki_6 = item.getListFuchoTsuki_6();
        source.listFuchoTsuki_7 = item.getListFuchoTsuki_7();
        source.listFuchoTsuki_8 = item.getListFuchoTsuki_8();
        source.listFuchoTsuki_9 = item.getListFuchoTsuki_9();
        source.listFuchoTsuki_10 = item.getListFuchoTsuki_10();
        source.listFuchoTsuki_11 = item.getListFuchoTsuki_11();
        source.listFuchoTsuki_12 = item.getListFuchoTsuki_12();
        source.listFuchoTsuki_13 = item.getListFuchoTsuki_13();
        source.listFuchoTsuki_14 = item.getListFuchoTsuki_14();
        source.listFuchoZuiji_1 = item.getListFuchoZuiji_1();
        source.listFuchoZuiji_2 = item.getListFuchoZuiji_2();
        source.listFuchoZuiji_3 = item.getListFuchoZuiji_3();
        source.listFuchoZuiji_4 = item.getListFuchoZuiji_4();
        source.listFuchoZuiji_5 = item.getListFuchoZuiji_5();
        source.listFuchoZuiji_6 = item.getListFuchoZuiji_6();
        source.listFuchoZuiji_7 = item.getListFuchoZuiji_7();
        source.listFuchoZuiji_8 = item.getListFuchoZuiji_8();
        source.listFuchoZuiji_9 = item.getListFuchoZuiji_9();
        source.listFuchoZuiji_10 = item.getListFuchoZuiji_10();
        source.listFuchoZuiji_11 = item.getListFuchoZuiji_11();
        source.listFuchoZuiji_12 = item.getListFuchoZuiji_12();
        source.listFuchoZuiji_13 = item.getListFuchoZuiji_13();
        source.listFuchoZuiji_14 = item.getListFuchoZuiji_14();
        source.listFukaUchiwake1_1 = item.getListFukaUchiwake1_1();
        source.listFukaUchiwake1_2 = item.getListFukaUchiwake1_2();
        source.listFukaUchiwake1_3 = item.getListFukaUchiwake1_3();
        source.listFukaUchiwake1_4 = item.getListFukaUchiwake1_4();
        source.listFukaUchiwake1_5 = item.getListFukaUchiwake1_5();
        source.listFukaUchiwake1_6 = item.getListFukaUchiwake1_6();
        source.listFukaUchiwake1_7 = item.getListFukaUchiwake1_7();
        source.listFukaUchiwake1_8 = item.getListFukaUchiwake1_8();
        source.listFukaUchiwake1_9 = item.getListFukaUchiwake1_9();
        source.listFukaUchiwake2_1 = item.getListFukaUchiwake2_1();
        source.listFukaUchiwake2_2 = item.getListFukaUchiwake2_2();
        source.listFukaUchiwake2_3 = item.getListFukaUchiwake2_3();
        source.listFukaUchiwake2_4 = item.getListFukaUchiwake2_4();
        source.listFukaUchiwake2_5 = item.getListFukaUchiwake2_5();
        source.listFukaUchiwake2_6 = item.getListFukaUchiwake2_6();
        source.listFukaUchiwake2_7 = item.getListFukaUchiwake2_7();
        source.listFukaUchiwake2_8 = item.getListFukaUchiwake2_8();
        source.listFukaUchiwake2_9 = item.getListFukaUchiwake2_9();
        source.listFukaUchiwake2_10 = item.getListFukaUchiwake2_10();
        source.listFukaUchiwake2_11 = item.getListFukaUchiwake2_11();
        source.listFukaUchiwake2_12 = item.getListFukaUchiwake2_12();
        source.listFukaUchiwake2_13 = item.getListFukaUchiwake2_13();
        source.listFukaUchiwake2_14 = item.getListFukaUchiwake2_14();
        source.listFukaUchiwake2_15 = item.getListFukaUchiwake2_15();
        editSource(source);
        return source;
    }

    private void editSource(FukaDaichoSource source) {
        source.listFutsuChoshu_1 = item.getListFutsuChoshu_1();
        source.listFutsuChoshu_2 = item.getListFutsuChoshu_2();
        source.listFutsuChoshu_3 = item.getListFutsuChoshu_3();
        source.listFutsuChoshu_4 = item.getListFutsuChoshu_4();
        source.listFutsuChoshu_5 = item.getListFutsuChoshu_5();
        source.listFutsuChoshu_6 = item.getListFutsuChoshu_6();
        source.listFutsuChoshu_7 = item.getListFutsuChoshu_7();
        source.listFutsuChoshu_8 = item.getListFutsuChoshu_8();
        source.listFutsuChoshu_9 = item.getListFutsuChoshu_9();
        source.listFutsuChoshu_10 = item.getListFutsuChoshu_10();
        source.listFutsuChoshu_11 = item.getListFutsuChoshu_11();
        source.listFutsuChoshu_12 = item.getListFutsuChoshu_12();
        source.listFutsuChoshu_13 = item.getListFutsuChoshu_13();
        source.listFutsuChoshu_14 = item.getListFutsuChoshu_14();
        source.listFutsuChoshu_15 = item.getListFutsuChoshu_15();
        source.listFutsuChoshu_16 = item.getListFutsuChoshu_16();
        source.listFutsuChoshu_17 = item.getListFutsuChoshu_17();
        source.listFutsuChoshu_18 = item.getListFutsuChoshu_18();
        source.listFutsuChoshu_19 = item.getListFutsuChoshu_19();
        source.listFutsuChoshu_20 = item.getListFutsuChoshu_20();
        source.listHonin1_1 = item.getListHonin1_1();
        source.listHonin1_2 = item.getListHonin1_2();
        source.listHonin1_3 = item.getListHonin1_3();
        source.listHonin1_4 = item.getListHonin1_4();
        source.listHonin1_6 = item.getListHonin1_6();
        source.listHonin1_7 = item.getListHonin1_7();
        source.listHonin1_8 = item.getListHonin1_8();
        source.listHonin1_9 = item.getListHonin1_9();
        source.listHonin1_10 = item.getListHonin1_10();
        source.listHonin1_11 = item.getListHonin1_11();
        source.listHonin2_1 = item.getListHonin2_1();
        source.listHonin2_2 = item.getListHonin2_2();
        source.listHonin2_3 = item.getListHonin2_3();
        source.listHonin2_4 = item.getListHonin2_4();
        source.listHonin2_5 = item.getListHonin2_5();
        source.listSetaiin_1 = item.getListSetaiin_1();
        source.listSetaiin_2 = item.getListSetaiin_2();
        source.listSetaiin_3 = item.getListSetaiin_3();
        source.listSetaiin_4 = item.getListSetaiin_4();
        source.listSetaiin_5 = item.getListSetaiin_5();
        source.listSetaiin_6 = item.getListSetaiin_6();
        source.listSetaiin_7 = item.getListSetaiin_7();
        source.listSetaiin_8 = item.getListSetaiin_8();
        source.listSetaiin_9 = item.getListSetaiin_9();
        source.listSetaiin_10 = item.getListSetaiin_10();
        source.listSetaiin_11 = item.getListSetaiin_11();
        source.listSetaiin_12 = item.getListSetaiin_12();
        source.listSetaiin_13 = item.getListSetaiin_13();
        source.listSetaiin_14 = item.getListSetaiin_14();
        source.listTokuChoshu_1 = item.getListTokuChoshu_1();
        source.listTokuChoshu_2 = item.getListTokuChoshu_2();
        source.listTokuChoshu_3 = item.getListTokuChoshu_3();
        source.listTokuChoshu_4 = item.getListTokuChoshu_4();
        source.listTokuChoshu_5 = item.getListTokuChoshu_5();
        source.listTokuChoshu_6 = item.getListTokuChoshu_6();
        source.listTokuChoshu_7 = item.getListTokuChoshu_7();
        source.listTokuChoshu_8 = item.getListTokuChoshu_8();
        source.listTokuChoshu_9 = item.getListTokuChoshu_9();
        source.listTokuChoshu_10 = item.getListTokuChoshu_10();
        source.listTokuChoshu_11 = item.getListTokuChoshu_11();
        source.listTokuChoshu_12 = item.getListTokuChoshu_12();
        source.listTokuChoshu_13 = item.getListTokuChoshu_13();
        source.listTokuChoshu_14 = item.getListTokuChoshu_14();
        source.listTokuChoshu_15 = item.getListTokuChoshu_15();
        source.listTokuChoshu_16 = item.getListTokuChoshu_16();
        source.listTokuChoshu_17 = item.getListTokuChoshu_17();
        source.listTokuChoshu_18 = item.getListTokuChoshu_18();
        source.listTokuChoshu_19 = item.getListTokuChoshu_19();
        source.listTokuChoshu_20 = item.getListTokuChoshu_20();
        source.listTokuchoKi_1 = item.getListTokuchoKi_1();
        source.listTokuchoKi_2 = item.getListTokuchoKi_2();
        source.listTokuchoKi_3 = item.getListTokuchoKi_3();
        source.listTokuchoKi_4 = item.getListTokuchoKi_4();
        source.listTokuchoKi_5 = item.getListTokuchoKi_5();
        source.listTokuchoKi_6 = item.getListTokuchoKi_6();
        source.listTokuchoKi_7 = item.getListTokuchoKi_7();
        source.listTokuchoKi_8 = item.getListTokuchoKi_8();
        source.listTokuchoKi_9 = item.getListTokuchoKi_9();
        source.listTokuchoKi_10 = item.getListTokuchoKi_10();
        source.listTokuchoKi_11 = item.getListTokuchoKi_11();
        source.listTokuchoKi_12 = item.getListTokuchoKi_12();
        source.listTokuchoKi_13 = item.getListTokuchoKi_13();
        source.listTokuchoKi_14 = item.getListTokuchoKi_14();
        source.listTokuchoTsuki_1 = item.getListTokuchoTsuki_1();
        source.listTokuchoTsuki_2 = item.getListTokuchoTsuki_2();
        source.listTokuchoTsuki_3 = item.getListTokuchoTsuki_3();
        source.listTokuchoTsuki_4 = item.getListTokuchoTsuki_4();
        source.listTokuchoTsuki_5 = item.getListTokuchoTsuki_5();
        source.listTokuchoTsuki_6 = item.getListTokuchoTsuki_6();
        source.listTokuchoTsuki_7 = item.getListTokuchoTsuki_7();
        source.listTokuchoTsuki_8 = item.getListTokuchoTsuki_8();
        source.listTokuchoTsuki_9 = item.getListTokuchoTsuki_9();
        source.listTokuchoTsuki_10 = item.getListTokuchoTsuki_10();
        source.listTokuchoTsuki_11 = item.getListTokuchoTsuki_11();
        source.listTokuchoTsuki_12 = item.getListTokuchoTsuki_12();
        source.listTokuchoTsuki_13 = item.getListTokuchoTsuki_13();
        source.listTokuchoTsuki_14 = item.getListTokuchoTsuki_14();
        source.setaiCode = item.getSetaiCode();
        source.tsuchishoNo = item.getTsuchishoNo();
    }

}
