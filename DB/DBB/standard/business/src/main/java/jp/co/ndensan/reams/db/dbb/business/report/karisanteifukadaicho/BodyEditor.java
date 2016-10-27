/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteifukadaicho;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteifukadaicho.KarisanteiFukaDaichoSource;

/**
 * 賦課台帳（仮算定）帳票 BodyEditor
 *
 * @reamsid_L DBB-9100-020 yangchenbing
 */
public class BodyEditor implements IKarisanteiFukaDaichoEditor {

    private final KarisanteiFukaDaichoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SampleItem}
     */
    protected BodyEditor(KarisanteiFukaDaichoItem item) {
        this.item = item;
    }

    @Override
    public KarisanteiFukaDaichoSource edit(KarisanteiFukaDaichoSource source) {

        edithokenshaNo(source);
        edithokenshaName(source);
        edittsuchishoNo(source);
        edithihokenshaNo(source);
        editsetaiCode(source);
        edithyojicodeName2(source);
        edithyojicodeName4(source);
        edithyojicodeName1(source);
        edithoninNameKana(source);
        edithoninyubinNo(source);
        edithoninJusho(source);
        edithoninSeibetsu(source);
        edithoninBirthYMD(source);
        edithoninRenrakuSaki1(source);
        edithyojicode1(source);
        edithyojicode2(source);
        edithyojicode3(source);
        edithoninName(source);
        edithoninRenrakuSaki2(source);
        edithoninShotokuDankaiHenko(source);
        editlistHonin1(source);
        edithoninTokuchoGimusha(source);
        edithoninTokuchoTaishoNenkin(source);
        editdainoninNameKana(source);
        editdainoninyubinNo(source);
        editdainoninJusho(source);
        editdainoninRenrakuSaki1(source);
        editdainoninName(source);
        editdainoninRenrakuSaki2(source);
        editbankName(source);
        editbankNo(source);
        edithonDummy(source);
        editkozaShurui(source);
        editlistHonin2(source);
        editKozaMeiginin(source);
        editkozaNo(source);
        editlistSetaiin_1(source);
        editchoteiJiyu1(source);
        edithenkoJiyu1(source);
        editsetDummy(source);
        editchoteiJiyu2(source);
        edithenkoJiyu2(source);
        editchoteiJiyu3(source);
        edithenkoJiyu3(source);
        editchoteiJiyu4(source);
        edithenkoJiyu4(source);
        editlistUchiwakei_1(source);
        editlistUchiwakei_2(source);
        editlistUchiwakei_3(source);
        editlistUchiwakei_4(source);
        editlistUchiwakei_5(source);
        editzenNendoShotokuDankai(source);
        editzenNendoHokenryoRitsu(source);
        editzenNendoHokenryoNengaku(source);
        editzenNendoTochoSaishukiHokenryo(source);
        editzenNendoFuchoSaishukiHokenryo(source);
        edittkDummy(source);
        editlistTokuchoKi_1(source);
        editlistTokuchoTsuki_1(source);
        editlistTokuChoshu_1(source);
        editlistTokuChoshu_2(source);
        editlistTokuChoshu_3(source);
        editlistTokuChoshu_4(source);
        editlistTokuChoshu_5(source);
        editlistTokuChoshu_6(source);
        editlistTokuChoshu_7(source);
        editlistTokuChoshu_8(source);
        editlistTokuChoshu_9(source);
        editlistTokuChoshu_10(source);
        editlistTokuChoshu_11(source);
        editlistTokuChoshu_12(source);
        editlistTokuChoshu_13(source);
        editlistTokuChoshu_14(source);
        editlistTokuChoshu_15(source);
        editlistTokuChoshu_16(source);
        editlistTokuChoshu_17(source);
        editlistTokuChoshu_18(source);
        editlistTokuChoshu_19(source);
        editlistFuchoZuiji_1(source);
        editlistFuchoZuiji_2(source);
        editlistFuchoZuiji_3(source);
        editlistFuchoZuiji_4(source);
        editlistFuchoZuiji_5(source);
        editlistFuchoZuiji_6(source);
        editlistFuchoZuiji_7(source);
        editlistFuchoZuiji_8(source);
        editlistFuchoZuiji_9(source);
        editlistFuchoZuiji_10(source);
        editlistFuchoZuiji_11(source);
        editlistFuchoZuiji_12(source);
        editlistFuchoZuiji_13(source);
        editlistFuchoZuiji_14(source);
        editfuDummy(source);
        editlistFuchoTsuki_1(source);
        editlistFuchoTsuki_2(source);
        editlistFuchoTsuki_3(source);
        editlistFuchoTsuki_4(source);
        editlistFuchoTsuki_5(source);
        editlistFuchoTsuki_6(source);
        editlistFuchoTsuki_7(source);
        editlistFuchoTsuki_8(source);
        editlistFuchoTsuki_9(source);
        editlistFuchoTsuki_10(source);
        editlistFuchoTsuki_11(source);
        editlistFuchoTsuki_12(source);
        editlistFuchoTsuki_13(source);
        editlistFuchoTsuki_14(source);
        editlistFuchoKi_1(source);
        editlistFutsuChoshu_1(source);
        editjukyuJoho(source);
        return source;
    }

    private void edithokenshaNo(KarisanteiFukaDaichoSource source) {
        source.hokenshaNo = item.getHokenshaNo();
    }

    private void edithokenshaName(KarisanteiFukaDaichoSource source) {
        source.hokenshaName = item.getHokenshaName();
    }

    private void edittsuchishoNo(KarisanteiFukaDaichoSource source) {
        source.tsuchishoNo = item.getTsuchishoNo();
    }

    private void edithihokenshaNo(KarisanteiFukaDaichoSource source) {
        source.hihokenshaNo = item.getHihokenshaNo();
    }

    private void editsetaiCode(KarisanteiFukaDaichoSource source) {
        source.setaiCode = item.getSetaiCode();
    }

    private void edithyojicodeName2(KarisanteiFukaDaichoSource source) {
        source.hyojicodeName2 = item.getHyojicodeName2();
    }

    private void edithyojicodeName4(KarisanteiFukaDaichoSource source) {
        source.hyojicodeName4 = item.getHyojicodeName4();
    }

    private void edithyojicodeName1(KarisanteiFukaDaichoSource source) {
        source.hyojicodeName1 = item.getHyojicodeName1();
    }

    private void edithoninNameKana(KarisanteiFukaDaichoSource source) {
        source.honinNameKana = item.getHoninNameKana();
    }

    private void edithoninyubinNo(KarisanteiFukaDaichoSource source) {
        source.honinyubinNo = item.getHoninyubinNo();
    }

    private void edithoninJusho(KarisanteiFukaDaichoSource source) {
        source.honinJusho = item.getHoninJusho();
    }

    private void edithoninSeibetsu(KarisanteiFukaDaichoSource source) {
        source.honinSeibetsu = item.getHoninSeibetsu();
    }

    private void edithoninBirthYMD(KarisanteiFukaDaichoSource source) {
        source.honinBirthYMD = item.getHoninBirthYMD();
    }

    private void edithoninRenrakuSaki1(KarisanteiFukaDaichoSource source) {
        source.honinRenrakuSaki1 = item.getHoninRenrakuSaki1();
    }

    private void edithyojicode1(KarisanteiFukaDaichoSource source) {
        source.hyojicode1 = item.getHyojicode1();
    }

    private void edithyojicode2(KarisanteiFukaDaichoSource source) {
        source.hyojicode2 = item.getHyojicode2();
    }

    private void edithyojicode3(KarisanteiFukaDaichoSource source) {
        source.hyojicode3 = item.getHyojicode3();
    }

    private void edithoninName(KarisanteiFukaDaichoSource source) {
        source.honinName = item.getHoninName();
    }

    private void edithoninRenrakuSaki2(KarisanteiFukaDaichoSource source) {
        source.honinRenrakuSaki2 = item.getHoninRenrakuSaki2();
    }

    private void edithoninShotokuDankaiHenko(KarisanteiFukaDaichoSource source) {
        source.honinShotokuDankaiHenko = item.getHoninShotokuDankaiHenko();
    }

    private void editlistHonin1(KarisanteiFukaDaichoSource source) {
        source.listHonin1_1 = item.getListHonin1_1();
        source.listHonin1_2 = item.getListHonin1_2();
        source.listHonin1_3 = item.getListHonin1_3();
        source.listHonin1_4 = item.getListHonin1_4();
        source.listHonin1_6 = item.getListHonin1_6();
        source.listHonin1_7 = item.getListHonin1_7();
        source.listHonin1_8 = item.getListHonin1_8();
        source.listHonin1_9 = item.getListHonin1_9();
    }

    private void edithoninTokuchoGimusha(KarisanteiFukaDaichoSource source) {
        source.honinTokuchoGimusha = item.getHoninTokuchoGimusha();
    }

    private void edithoninTokuchoTaishoNenkin(KarisanteiFukaDaichoSource source) {
        source.honinTokuchoTaishoNenkin = item.getHoninTokuchoTaishoNenkin();
    }

    private void editdainoninNameKana(KarisanteiFukaDaichoSource source) {
        source.dainoninNameKana = item.getDainoninNameKana();
    }

    private void editdainoninyubinNo(KarisanteiFukaDaichoSource source) {
        source.dainoninyubinNo = item.getDainoninyubinNo();
    }

    private void editdainoninJusho(KarisanteiFukaDaichoSource source) {
        source.dainoninJusho = item.getDainoninJusho();
    }

    private void editdainoninRenrakuSaki1(KarisanteiFukaDaichoSource source) {
        source.dainoninRenrakuSaki1 = item.getDainoninRenrakuSaki1();
    }

    private void editdainoninName(KarisanteiFukaDaichoSource source) {
        source.dainoninName = item.getDainoninName();
    }

    private void editdainoninRenrakuSaki2(KarisanteiFukaDaichoSource source) {
        source.dainoninRenrakuSaki2 = item.getDainoninRenrakuSaki2();
    }

    private void editbankName(KarisanteiFukaDaichoSource source) {
        source.bankName = item.getBankName();
    }

    private void editbankNo(KarisanteiFukaDaichoSource source) {
        source.bankNo = item.getBankNo();
    }

    private void edithonDummy(KarisanteiFukaDaichoSource source) {
        source.honDummy = item.getHonDummy();
    }

    private void editkozaShurui(KarisanteiFukaDaichoSource source) {
        source.kozaShurui = item.getKozaShurui();
    }

    private void editlistHonin2(KarisanteiFukaDaichoSource source) {
        source.listHonin2_1 = item.getListHonin2_1();
        source.listHonin2_2 = item.getListHonin2_2();
        source.listHonin2_3 = item.getListHonin2_3();
        source.listHonin2_4 = item.getListHonin2_4();
        source.listHonin2_5 = item.getListHonin2_5();
        source.listHonin2_6 = item.getListHonin2_6();
        source.listHonin2_7 = item.getListHonin2_7();
    }

    private void editKozaMeiginin(KarisanteiFukaDaichoSource source) {
        source.kozaMeiginin = item.getKozaMeiginin();
    }

    private void editkozaNo(KarisanteiFukaDaichoSource source) {
        source.kozaNo = item.getKozaNo();
    }

    private void editlistSetaiin_1(KarisanteiFukaDaichoSource source) {
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
    }

    private void editchoteiJiyu1(KarisanteiFukaDaichoSource source) {
        source.choteiJiyu1 = item.getChoteiJiyu1();
    }

    private void edithenkoJiyu1(KarisanteiFukaDaichoSource source) {
        source.henkoJiyu1 = item.getHenkoJiyu1();
    }

    private void editsetDummy(KarisanteiFukaDaichoSource source) {
        source.setDummy = item.getSetDummy();
    }

    private void editchoteiJiyu2(KarisanteiFukaDaichoSource source) {
        source.choteiJiyu2 = item.getChoteiJiyu2();
    }

    private void edithenkoJiyu2(KarisanteiFukaDaichoSource source) {
        source.henkoJiyu2 = item.getHenkoJiyu2();
    }

    private void editchoteiJiyu3(KarisanteiFukaDaichoSource source) {
        source.choteiJiyu3 = item.getChoteiJiyu3();
    }

    private void edithenkoJiyu3(KarisanteiFukaDaichoSource source) {
        source.henkoJiyu3 = item.getHenkoJiyu3();
    }

    private void editchoteiJiyu4(KarisanteiFukaDaichoSource source) {
        source.choteiJiyu4 = item.getChoteiJiyu4();
    }

    private void edithenkoJiyu4(KarisanteiFukaDaichoSource source) {
        source.henkoJiyu4 = item.getHenkoJiyu4();
    }

    private void editlistUchiwakei_1(KarisanteiFukaDaichoSource source) {
        source.listUchiwakei_1 = item.getListUchiwakei_1();
    }

    private void editlistUchiwakei_2(KarisanteiFukaDaichoSource source) {
        source.listUchiwakei_2 = item.getListUchiwakei_2();
    }

    private void editlistUchiwakei_3(KarisanteiFukaDaichoSource source) {
        source.listUchiwakei_3 = item.getListUchiwakei_3();
    }

    private void editlistUchiwakei_4(KarisanteiFukaDaichoSource source) {
        source.listUchiwakei_4 = item.getListUchiwakei_4();
    }

    private void editlistUchiwakei_5(KarisanteiFukaDaichoSource source) {
        source.listUchiwakei_5 = item.getListUchiwakei_5();
    }

    private void editzenNendoShotokuDankai(KarisanteiFukaDaichoSource source) {
        source.zenNendoShotokuDankai = item.getZenNendoShotokuDankai();
    }

    private void editzenNendoHokenryoRitsu(KarisanteiFukaDaichoSource source) {
        source.zenNendoHokenryoRitsu = item.getZenNendoHokenryoRitsu();
    }

    private void editzenNendoHokenryoNengaku(KarisanteiFukaDaichoSource source) {
        source.zenNendoHokenryoNengaku = item.getZenNendoHokenryoNengaku();
    }

    private void editzenNendoTochoSaishukiHokenryo(KarisanteiFukaDaichoSource source) {
        source.zenNendoTochoSaishukiHokenryo = item.getZenNendoTochoSaishukiHokenryo();
    }

    private void editzenNendoFuchoSaishukiHokenryo(KarisanteiFukaDaichoSource source) {
        source.zenNendoFuchoSaishukiHokenryo = item.getZenNendoFuchoSaishukiHokenryo();
    }

    private void editlistTokuchoKi_1(KarisanteiFukaDaichoSource source) {
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
    }

    private void edittkDummy(KarisanteiFukaDaichoSource source) {
        source.tkDummy = item.getTkDummy();
    }

    private void editlistTokuchoTsuki_1(KarisanteiFukaDaichoSource source) {
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
    }

    private void editlistTokuChoshu_1(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_1 = item.getListTokuChoshu_1();
    }

    private void editlistTokuChoshu_2(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_2 = item.getListTokuChoshu_2();
    }

    private void editlistTokuChoshu_3(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_3 = item.getListTokuChoshu_3();
    }

    private void editlistTokuChoshu_4(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_4 = item.getListTokuChoshu_4();
    }

    private void editlistTokuChoshu_5(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_5 = item.getListTokuChoshu_5();
    }

    private void editlistTokuChoshu_6(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_6 = item.getListTokuChoshu_6();
    }

    private void editlistTokuChoshu_7(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_7 = item.getListTokuChoshu_7();
    }

    private void editlistTokuChoshu_8(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_8 = item.getListTokuChoshu_8();
    }

    private void editlistTokuChoshu_9(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_9 = item.getListTokuChoshu_9();
    }

    private void editlistTokuChoshu_10(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_10 = item.getListTokuChoshu_10();
    }

    private void editlistTokuChoshu_11(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_11 = item.getListTokuChoshu_11();
    }

    private void editlistTokuChoshu_12(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_12 = item.getListTokuChoshu_12();
    }

    private void editlistTokuChoshu_13(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_13 = item.getListTokuChoshu_13();
    }

    private void editlistTokuChoshu_14(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_14 = item.getListTokuChoshu_14();
    }

    private void editlistTokuChoshu_15(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_15 = item.getListTokuChoshu_15();
    }

    private void editlistTokuChoshu_16(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_16 = item.getListTokuChoshu_16();
    }

    private void editlistTokuChoshu_17(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_17 = item.getListTokuChoshu_17();
    }

    private void editlistTokuChoshu_18(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_18 = item.getListTokuChoshu_18();
    }

    private void editlistTokuChoshu_19(KarisanteiFukaDaichoSource source) {
        source.listTokuChoshu_19 = item.getListTokuChoshu_19();
    }

    private void editlistFuchoZuiji_1(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_1 = item.getListFuchoZuiji_1();
    }

    private void editlistFuchoZuiji_2(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_2 = item.getListFuchoZuiji_2();
    }

    private void editlistFuchoZuiji_3(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_3 = item.getListFuchoZuiji_3();
    }

    private void editlistFuchoZuiji_4(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_4 = item.getListFuchoZuiji_4();
    }

    private void editlistFuchoZuiji_5(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_5 = item.getListFuchoZuiji_5();
    }

    private void editlistFuchoZuiji_6(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_6 = item.getListFuchoZuiji_6();
    }

    private void editlistFuchoZuiji_7(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_7 = item.getListFuchoZuiji_7();
    }

    private void editlistFuchoZuiji_8(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_8 = item.getListFuchoZuiji_8();
    }

    private void editlistFuchoZuiji_9(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_9 = item.getListFuchoZuiji_9();
    }

    private void editlistFuchoZuiji_10(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_10 = item.getListFuchoZuiji_10();
    }

    private void editlistFuchoZuiji_11(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_11 = item.getListFuchoZuiji_11();
    }

    private void editlistFuchoZuiji_12(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_12 = item.getListFuchoZuiji_12();
    }

    private void editlistFuchoZuiji_13(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_13 = item.getListFuchoZuiji_13();
    }

    private void editlistFuchoZuiji_14(KarisanteiFukaDaichoSource source) {
        source.listFuchoZuiji_14 = item.getListFuchoZuiji_14();
    }

    private void editfuDummy(KarisanteiFukaDaichoSource source) {
        source.fuDummy = item.getFuDummy();
    }

    private void editlistFuchoTsuki_1(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_1 = item.getListFuchoTsuki_1();
    }

    private void editlistFuchoTsuki_2(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_2 = item.getListFuchoTsuki_2();
    }

    private void editlistFuchoTsuki_3(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_3 = item.getListFuchoTsuki_3();
    }

    private void editlistFuchoTsuki_4(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_4 = item.getListFuchoTsuki_4();
    }

    private void editlistFuchoTsuki_5(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_5 = item.getListFuchoTsuki_5();
    }

    private void editlistFuchoTsuki_6(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_6 = item.getListFuchoTsuki_6();
    }

    private void editlistFuchoTsuki_7(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_7 = item.getListFuchoTsuki_7();
    }

    private void editlistFuchoTsuki_8(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_8 = item.getListFuchoTsuki_8();
    }

    private void editlistFuchoTsuki_9(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_9 = item.getListFuchoTsuki_9();
    }

    private void editlistFuchoTsuki_10(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_10 = item.getListFuchoTsuki_10();
    }

    private void editlistFuchoTsuki_11(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_11 = item.getListFuchoTsuki_11();
    }

    private void editlistFuchoTsuki_12(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_12 = item.getListFuchoTsuki_12();
    }

    private void editlistFuchoTsuki_13(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_13 = item.getListFuchoTsuki_13();
    }

    private void editlistFuchoTsuki_14(KarisanteiFukaDaichoSource source) {
        source.listFuchoTsuki_14 = item.getListFuchoTsuki_14();
    }

    private void editlistFuchoKi_1(KarisanteiFukaDaichoSource source) {
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
    }

    private void editlistFutsuChoshu_1(KarisanteiFukaDaichoSource source) {
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
    }

    private void editjukyuJoho(KarisanteiFukaDaichoSource source) {
        source.jukyuJoho = item.getJukyuJoho();
    }

}
