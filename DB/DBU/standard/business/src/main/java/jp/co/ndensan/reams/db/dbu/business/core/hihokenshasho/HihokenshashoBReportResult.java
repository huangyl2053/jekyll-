/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.hihokenshasho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4BodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4BodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Item;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashochohyo.HihokenshashoChoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.HihokenshashoChohyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.JushochitokureiTekiParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.NyutaiShoParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.ShiteiServiceParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.ShutokuTodokedeParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票「介護保険被保険者証A4/B4版」のビジネスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class HihokenshashoBReportResult {

    private static final int MAX_RECORD_COUNT = 2;
    private static final int ONE = 1;

    /**
     * 計算中間Entityの設定メッソドです。
     *
     * @param entity IkkatsuHakkoRelateEntity
     * @param kofuYMD 交付日
     * @return HihokenshashoChohyoParameter
     */
    public HihokenshashoChohyoParameter setHihokenshashoChohyoParameter(IkkatsuHakkoRelateEntity entity, FlexibleDate kofuYMD) {
        HihokenshashoChohyoParameter param = new HihokenshashoChohyoParameter();
        param.set被保険者番号(entity.getHihokenshaNo() != null && !entity.getHihokenshaNo().isEmpty()
                ? entity.getHihokenshaNo().value() : RString.EMPTY);
        param.set識別コード(entity.getShikibetsuCode());
        param.set交付日(kofuYMD);
        param.set保険者(entity.getShoKisaiHokenshaNo() != null && !entity.getShoKisaiHokenshaNo().isEmpty()
                ? entity.getShoKisaiHokenshaNo().value() : RString.EMPTY);
        param.set要介護認定状態区分コード(entity.getYokaigoJotaiKubunCode() != null && entity.getYokaigoJotaiKubunCode().isEmpty()
                ? entity.getYokaigoJotaiKubunCode().value() : RString.EMPTY);
        param.set認定年月日(get年月日(entity.getNinteiYMD()));
        param.set認定有効期間開始年月日(get年月日(entity.getNinteiYukoKikanKaishiYMD()));
        param.set認定有効期間終了年月日(get年月日(entity.getNinteiYukoKikanShuryoYMD()));
        param.set支給限度有効開始年月日(get年月日(entity.getShikyuGendoKaishiYMD()));
        param.set支給限度有効終了年月日(get年月日(entity.getShikyuGendoShuryoYMD()));
        param.set支給限度単位数(entity.getShikyuGendoTanisu());
        param.set介護認定審査会意見(entity.getShinsakaiIken());
        param.set指定サービス種類(getサービス種類List(entity));
        param.set適用年月日(get適用年月日List(entity));
        param.set届出年月日(get届出年月日List(entity));
        param.set入退所年月日(get入退所年月日List(entity));
        return param;
    }

    /**
     * 帳票「介護保険被保険者証（A4版）」のItemを設定するメッソドです。
     *
     * @param businessList businessList
     * @return List<HihokenshashoA4BodyItem>
     */
    public List<HihokenshashoA4BodyItem> setA4ItemList(List<HihokenshashoChoBusiness> businessList) {
        List<HihokenshashoA4BodyItem> itemList = new ArrayList<>();
        for (HihokenshashoChoBusiness hihokenshashoChoBusiness : businessList) {
            itemList.add(setA4Item(hihokenshashoChoBusiness));
        }
        return itemList;
    }

    /**
     * 帳票「介護保険被保険者証（B4版）」のItemを設定するメッソドです。
     *
     * @param businessList businessList
     * @return List<HihokenshashoA4BodyItem>
     */
    public List<HihokenshashoB4BodyItem> setB4ItemList(List<HihokenshashoChoBusiness> businessList) {
        List<HihokenshashoB4Item> johos = setHihokenshashoB4ItemList(businessList);
        int dataCount = johos.size();
        int pageCount = dataCount / MAX_RECORD_COUNT;
        int lastPageCount = dataCount % MAX_RECORD_COUNT;
        boolean isLastPage = false;
        List<HihokenshashoB4BodyItem> items = new ArrayList<>();
        if (lastPageCount != 0) {
            isLastPage = true;
        }
        for (int i = 0; i < pageCount; i++) {
            HihokenshashoB4Item itemOne = johos.get(MAX_RECORD_COUNT * i);
            HihokenshashoB4Item itemTwo = johos.get(MAX_RECORD_COUNT * i + ONE);
            HihokenshashoB4BodyItem item = setBodyItem_上段(itemOne);
            item = setBodyItem_下段(item, itemTwo);
            items.add(item);
        }
        if (isLastPage && lastPageCount == 1) {
            HihokenshashoB4Item itemOne = johos.get(dataCount - ONE);
            HihokenshashoB4BodyItem item = setBodyItem_上段(itemOne);
            items.add(item);
        }
        return items;
    }

    private static HihokenshashoB4BodyItem setBodyItem_上段(HihokenshashoB4Item itemOne) {
        HihokenshashoB4BodyItem item = new HihokenshashoB4BodyItem();
        item.setYukokigen(itemOne.getYukokigen());
        item.setHihokenshanno(itemOne.getHihokenshanno());
        item.setYubinno(itemOne.getYubinno());
        item.setGyoseiku(itemOne.getGyoseiku());
        item.setGyoseikuS(itemOne.getGyoseikuS());
        item.setHihojusho(itemOne.getHihojusho());
        item.setHihokana(itemOne.getHihokana());
        item.setHihoname(itemOne.getHihoname());
        item.setUmareMeiji(itemOne.getUmareMeiji());
        item.setUmareTaisho(itemOne.getUmareTaisho());
        item.setUmareShowa(itemOne.getUmareShowa());
        item.setUmareYy(itemOne.getUmareYy());
        item.setUmareMm1(itemOne.getUmareMm());
        item.setUmareDd1(itemOne.getUmareDd());
        item.setUmareYyyy1(itemOne.getUmareYyyy());
        item.setUmareMmS1(itemOne.getUmareMmS());
        item.setUmareDdS1(itemOne.getUmareDdS());
        item.setSeibetsuMan(itemOne.getSeibetsuMan());
        item.setSeibetsuWoman(itemOne.getSeibetsuWoman());
        item.setKofuymdGengo(itemOne.getKofuymdGengo());
        item.setSaikofu1(itemOne.getSaikofu1());
        item.setHokenshano1(itemOne.getHokenshano1());
        item.setHokenshano2(itemOne.getHokenshano2());
        item.setHokenshano3(itemOne.getHokenshano3());
        item.setHokenshano4(itemOne.getHokenshano4());
        item.setHokenshano5(itemOne.getHokenshano5());
        item.setHokenshano6(itemOne.getHokenshano6());
        item.setKaigokbn(itemOne.getKaigokbn());
        item.setNinteiymd(itemOne.getNinteiymd());
        item.setYukokikanst(itemOne.getYukokikanst());
        item.setYukokikaned(itemOne.getYukokikaned());
        item.setHomonkikanst(itemOne.getHomonkikanst());
        item.setHomonkikaned(itemOne.getHomonkikaned());
        item.setServicetani(itemOne.getServicetani());
        item.setService1(itemOne.getService1());
        item.setTen0(itemOne.getTen0());
        item.setShurui1(itemOne.getShurui1());
        item.setShurui2(itemOne.getShurui2());
        item.setShurui3(itemOne.getShurui3());
        item.setShurui4(itemOne.getShurui4());
        item.setShurui5(itemOne.getShurui5());
        item.setShurui6(itemOne.getShurui6());
        item.setShuruigendo1(itemOne.getShuruigendo1());
        item.setShuruigendo2(itemOne.getShuruigendo2());
        item.setShuruigendo3(itemOne.getShuruigendo3());
        item.setShuruigendo4(itemOne.getShuruigendo4());
        item.setShuruigendo5(itemOne.getShuruigendo5());
        item.setShuruigendo6(itemOne.getShuruigendo6());
        item.setTen1(itemOne.getTen1());
        item.setTen2(itemOne.getTen2());
        item.setTen3(itemOne.getTen3());
        item.setTen4(itemOne.getTen4());
        item.setTen5(itemOne.getTen5());
        item.setTen6(itemOne.getTen6());
        item.setRyui(itemOne.getRyui());
        item.setSaikofu2(itemOne.getSaikofu2());
        item.setSeigen1(itemOne.getSeigen1());
        item.setSeigenLong1(itemOne.getSeigenLong1());
        item.setSeigen2(itemOne.getSeigen2());
        item.setSeigenLong2(itemOne.getSeigenLong2());
        item.setSeigen3(itemOne.getSeigen3());
        item.setSeigenLong3(itemOne.getSeigenLong3());
        item.setSeigen4(itemOne.getSeigen4());
        item.setSeigenLong4(itemOne.getSeigenLong4());
        item.setSeigen5(itemOne.getSeigen5());
        item.setSeigenLong5(itemOne.getSeigenLong5());
        item.setSeigen6(itemOne.getSeigen6());
        item.setSeigenLong6(itemOne.getSeigenLong6());
        item.setSeigenSt1(itemOne.getSeigenSt1());
        item.setSeigenEd1(itemOne.getSeigenEd1());
        item.setSeigenSt2(itemOne.getSeigenSt2());
        item.setSeigenEd2(itemOne.getSeigenEd2());
        item.setSeigenSt3(itemOne.getSeigenSt3());
        item.setSeigenEd3(itemOne.getSeigenEd3());
        item.setGyosha(itemOne.getGyosha());
        item.setTodokeYmd1(itemOne.getTodokeYmd1());
        item.setGyosha2(itemOne.getGyosha2());
        item.setGyosha2Asa(itemOne.getGyosha2Asa());
        item.setGyosha2Massho(itemOne.getGyosha2Massho());
        item.setTodokeYmd2(itemOne.getTodokeYmd2());
        item.setTodokeYmd2Asa1(itemOne.getTodokeYmd2Asa1());
        item.setTodokeYmd2Massho1(itemOne.getTodokeYmd2Massho1());
        item.setGyosha3(itemOne.getGyosha3());
        item.setGyosha3Asa(itemOne.getGyosha3Asa());
        item.setGyosha3Massho(itemOne.getGyosha3Massho());
        item.setTodokeYmd3Asa1(itemOne.getTodokeYmd3Asa1());
        item.setTodokeYmd3(itemOne.getTodokeYmd3());
        item.setShisetsuSyu1(itemOne.getShisetsuSyu1());
        item.setShisetsuname1(itemOne.getShisetsuname1());
        item.setNyushochk1(itemOne.getNyushochk1());
        item.setNyuinchk1(itemOne.getNyuinchk1());
        item.setTaishochk1(itemOne.getTaishochk1());
        item.setTaiinchk1(itemOne.getTaiinchk1());
        item.setNyushoymd1(itemOne.getNyushoymd1());
        item.setTaiinymd1(itemOne.getTaiinymd1());
        item.setShisetsuSyu2(itemOne.getShisetsuSyu2());
        item.setShisetsuname2(itemOne.getShisetsuname2());
        item.setNyushochk2(itemOne.getNyushochk2());
        item.setNyuinchk2(itemOne.getNyuinchk2());
        item.setTaishochk2(itemOne.getTaishochk2());
        item.setTaiinchk2(itemOne.getTaiinchk2());
        item.setNyushoymd2(itemOne.getNyushoymd2());
        item.setTaiinymd2(itemOne.getTaiinymd2());
        item.setRenban(itemOne.getRenban());
        item.setSeiShogai1(itemOne.getSeiShogai1());
        item.setSeiShogai2(itemOne.getSeiShogai2());
        item.setKosekiSeibetsu1(itemOne.getKosekiSeibetsu1());
        item.setKosekiSeibetsu2(itemOne.getKosekiSeibetsu2());
        item.setItakuGyosha1(itemOne.getItakuGyosha1());
        item.setItakuGyosha2(itemOne.getItakuGyosha2());
        item.setItakuGyosha2Asa(itemOne.getItakuGyosha2Asa());
        item.setItakuGyosha2Massho(itemOne.getItakuGyosha2Massho());
        item.setItakuGyosha3(itemOne.getItakuGyosha3());
        item.setItakuGyosha3Asa(itemOne.getItakuGyosha3Massho());
        item.setItakuGyosha3Massho(itemOne.getItakuGyosha3Massho());
        return item;
    }

    private static HihokenshashoB4BodyItem setBodyItem_下段(HihokenshashoB4BodyItem item,
            HihokenshashoB4Item itemTwo) {
        item.setYukokigen2(itemTwo.getYukokigen());
        item.setHihokenshanno2(itemTwo.getHihokenshanno());
        item.setYubinno2(itemTwo.getYubinno());
        item.setGyoseiku2(itemTwo.getGyoseiku());
        item.setGyoseikuS2(itemTwo.getGyoseikuS());
        item.setHihojusho2(itemTwo.getHihojusho());
        item.setHihokana2(itemTwo.getHihokana());
        item.setHihoname2(itemTwo.getHihoname());
        item.setUmareMeiji2(itemTwo.getUmareMeiji());
        item.setUmareTaisho2(itemTwo.getUmareTaisho());
        item.setUmareShowa2(itemTwo.getUmareShowa());
        item.setUmareYy2(itemTwo.getUmareYy());
        item.setUmareMm2(itemTwo.getUmareMm());
        item.setUmareDd2(itemTwo.getUmareDd());
        item.setUmareYyyy2(itemTwo.getUmareYyyy());
        item.setUmareMmS2(itemTwo.getUmareMmS());
        item.setUmareDdS2(itemTwo.getUmareDdS());
        item.setSeibetsuMan2(itemTwo.getSeibetsuMan());
        item.setSeibetsuWoman2(itemTwo.getSeibetsuWoman());
        item.setKofuymdGengo2(itemTwo.getKofuymdGengo());
        item.setSaikofu12(itemTwo.getSaikofu1());
        item.setHokenshano12(itemTwo.getHokenshano1());
        item.setHokenshano22(itemTwo.getHokenshano2());
        item.setHokenshano32(itemTwo.getHokenshano3());
        item.setHokenshano42(itemTwo.getHokenshano4());
        item.setHokenshano52(itemTwo.getHokenshano5());
        item.setHokenshano62(itemTwo.getHokenshano6());
        item.setKaigokbn2(itemTwo.getKaigokbn());
        item.setNinteiymd2(itemTwo.getNinteiymd());
        item.setYukokikanst2(itemTwo.getYukokikanst());
        item.setYukokikaned2(itemTwo.getYukokikaned());
        item.setHomonkikanst2(itemTwo.getHomonkikanst());
        item.setHomonkikaned2(itemTwo.getHomonkikaned());
        item.setServicetani2(itemTwo.getServicetani());
        item.setService12(itemTwo.getService1());
        item.setTen02(itemTwo.getTen0());
        item.setShurui12(itemTwo.getShurui1());
        item.setShurui22(itemTwo.getShurui2());
        item.setShurui32(itemTwo.getShurui3());
        item.setShurui42(itemTwo.getShurui4());
        item.setShurui52(itemTwo.getShurui5());
        item.setShurui62(itemTwo.getShurui6());
        item.setShuruigendo12(itemTwo.getShuruigendo1());
        item.setShuruigendo22(itemTwo.getShuruigendo2());
        item.setShuruigendo32(itemTwo.getShuruigendo3());
        item.setShuruigendo42(itemTwo.getShuruigendo4());
        item.setShuruigendo52(itemTwo.getShuruigendo5());
        item.setShuruigendo62(itemTwo.getShuruigendo6());
        item.setTen12(itemTwo.getTen1());
        item.setTen22(itemTwo.getTen2());
        item.setTen32(itemTwo.getTen3());
        item.setTen42(itemTwo.getTen4());
        item.setTen52(itemTwo.getTen5());
        item.setTen62(itemTwo.getTen6());
        item.setRyui2(itemTwo.getRyui());
        item.setSaikofu22(itemTwo.getSaikofu2());
        item.setSeigen12(itemTwo.getSeigen1());
        item.setSeigenLong12(itemTwo.getSeigenLong1());
        item.setSeigen22(itemTwo.getSeigen2());
        item.setSeigenLong22(itemTwo.getSeigenLong2());
        item.setSeigen32(itemTwo.getSeigen3());
        item.setSeigenLong32(itemTwo.getSeigenLong3());
        item.setSeigen42(itemTwo.getSeigen4());
        item.setSeigenLong42(itemTwo.getSeigenLong4());
        item.setSeigen52(itemTwo.getSeigen5());
        item.setSeigenLong52(itemTwo.getSeigenLong5());
        item.setSeigen62(itemTwo.getSeigen6());
        item.setSeigenLong62(itemTwo.getSeigenLong6());
        item.setSeigenSt12(itemTwo.getSeigenSt1());
        item.setSeigenEd12(itemTwo.getSeigenEd1());
        item.setSeigenSt22(itemTwo.getSeigenSt2());
        item.setSeigenEd22(itemTwo.getSeigenEd2());
        item.setSeigenSt32(itemTwo.getSeigenSt3());
        item.setSeigenEd32(itemTwo.getSeigenEd3());
        item.setGyosha02(itemTwo.getGyosha());
        item.setTodokeYmd12(itemTwo.getTodokeYmd1());
        item.setGyosha22(itemTwo.getGyosha2());
        item.setGyosha5Asa(itemTwo.getGyosha2Asa());
        item.setGyosha5Massho(itemTwo.getGyosha2Massho());
        item.setTodokeYmd22(itemTwo.getTodokeYmd2());
        item.setTodokeYmd2Asa2(itemTwo.getTodokeYmd2Asa1());
        item.setTodokeYmd2Massho2(itemTwo.getTodokeYmd2Asa1());
        item.setGyosha32(itemTwo.getGyosha3());
        item.setGyosha6Asa(itemTwo.getGyosha3Asa());
        item.setGyosha6Massho(itemTwo.getGyosha3Massho());
        item.setTodokeYmd32(itemTwo.getTodokeYmd3());
        item.setTodokeYmd3Asa2(itemTwo.getTodokeYmd3Asa1());
        item.setTodokeYmd3Massho2(itemTwo.getTodokeYmd3Asa1());
        item.setShisetsuSyu12(itemTwo.getShisetsuSyu1());
        item.setShisetsuname12(itemTwo.getShisetsuname1());
        item.setNyushochk12(itemTwo.getNyushochk1());
        item.setNyuinchk12(itemTwo.getNyuinchk1());
        item.setTaishochk12(itemTwo.getTaishochk1());
        item.setTaiinchk12(itemTwo.getTaiinchk1());
        item.setNyushoymd12(itemTwo.getNyushoymd1());
        item.setTaiinymd12(itemTwo.getTaiinymd1());
        item.setShisetsuSyu22(itemTwo.getShisetsuSyu2());
        item.setShisetsuname22(itemTwo.getShisetsuname2());
        item.setNyushochk22(itemTwo.getNyushochk2());
        item.setNyuinchk22(itemTwo.getNyuinchk2());
        item.setTaishochk22(itemTwo.getTaishochk2());
        item.setTaiinchk22(itemTwo.getTaiinchk2());
        item.setNyushoymd22(itemTwo.getNyushoymd2());
        item.setTaiinymd22(itemTwo.getTaiinymd2());
        item.setRenban2(itemTwo.getRenban());
        item.setSeiShogai12(itemTwo.getSeiShogai1());
        item.setSeiShogai22(itemTwo.getSeiShogai2());
        item.setKosekiSeibetsu12(itemTwo.getKosekiSeibetsu1());
        item.setKosekiSeibetsu22(itemTwo.getKosekiSeibetsu2());
        item.setItakuGyosha12(itemTwo.getItakuGyosha1());
        item.setItakuGyosha22(itemTwo.getItakuGyosha2());
        item.setItakuGyosha5Asa(itemTwo.getItakuGyosha2Asa());
        item.setItakuGyosha5Massho(itemTwo.getItakuGyosha2Massho());
        item.setItakuGyosha32(itemTwo.getItakuGyosha3());
        item.setItakuGyosha6Asa(itemTwo.getItakuGyosha3Massho());
        item.setItakuGyosha6Massho(itemTwo.getItakuGyosha3Massho());
        return item;
    }

    private List<HihokenshashoB4Item> setHihokenshashoB4ItemList(List<HihokenshashoChoBusiness> businessList) {
        List<HihokenshashoB4Item> itemList = new ArrayList<>();
        for (HihokenshashoChoBusiness hihokenshashoChoBusiness : businessList) {
            itemList.add(setB4Item(hihokenshashoChoBusiness));
        }
        return itemList;
    }

    private HihokenshashoB4Item setB4Item(HihokenshashoChoBusiness business) {
        return new HihokenshashoB4Item(business.get有効期限1(),
                business.get被保険者番号(),
                business.get郵便番号(),
                business.get行政区1(),
                business.get行政区2(),
                business.get住所(),
                business.get氏名カナ(),
                business.get氏名(),
                business.get明治(),
                business.get大正(),
                business.get昭和(),
                business.get和暦年(),
                business.get月(),
                business.get日(),
                business.get西暦年(),
                business.get月(),
                business.get日(),
                business.get男(),
                business.get女(),
                business.get交付年月日(),
                business.get再交付(),
                business.get保険者NO1(),
                business.get保険者NO2(),
                business.get保険者NO3(),
                business.get保険者NO4(),
                business.get保険者NO5(),
                business.get保険者NO6(),
                business.get要介護認定区分(),
                business.get認定年月日(),
                business.get認定有効期間開始年月日(),
                business.get認定有効期間終了年月日(),
                business.get訪問期間開始年月日(),
                business.get訪問期間終了年月日(),
                business.getサービス単位(),
                business.getサービス(),
                business.get点数(),
                business.getサービス種類1(),
                business.getサービス種類2(),
                business.getサービス種類3(),
                business.getサービス種類4(),
                business.getサービス種類5(),
                business.getサービス種類6(),
                business.getサービス種類1つ目の限度額(),
                business.getサービス種類2つ目の限度額(),
                business.getサービス種類3つ目の限度額(),
                business.getサービス種類4つ目の限度額(),
                business.getサービス種類5つ目の限度額(),
                business.getサービス種類6つ目の限度額(),
                business.get点数1(),
                business.get点数2(),
                business.get点数3(),
                business.get点数4(),
                business.get点数5(),
                business.get点数6(),
                business.get認定審査会意見等(),
                business.get再交付2(),
                business.get給付制限1(),
                business.get給付制限長1(),
                business.get給付制限2(),
                business.get給付制限長2(),
                business.get給付制限3(),
                business.get給付制限長3(),
                business.get給付制限4(),
                business.get給付制限長4(),
                business.get給付制限5(),
                business.get給付制限長5(),
                business.get給付制限6(),
                business.get給付制限長6(),
                business.get給付制限開始年月日1(),
                business.get給付制限終了年月日1(),
                business.get給付制限開始年月日2(),
                business.get給付制限終了年月日2(),
                business.get給付制限開始年月日3(),
                business.get給付制限終了年月日3(),
                business.get居宅介護事業者1(),
                business.get届出年月日1(),
                business.get居宅介護事業者2(),
                business.get居宅介護事業者星2(),
                business.get居宅介護事業者取消2(),
                business.get届出年月日2(),
                business.get届出年月日星2(),
                business.get届出年月日取消2(),
                business.get居宅介護事業者3(),
                business.get居宅介護事業者長星3(),
                business.get居宅介護事業者取消3(),
                business.get届出年月日3(),
                business.get届出年月日星3(),
                business.get届出年月日取消3(),
                business.get施設種類11(),
                business.get施設名1(),
                business.get入所チェック1(),
                business.get入院チェック1(),
                business.get退所チェック1(),
                business.get退院チェック1(),
                business.get入所年月日1(),
                business.get退院年月日1(),
                business.get施設種類2(),
                business.get施設名2(),
                business.get入所チェック2(),
                business.get入院チェック2(),
                business.get退所チェック2(),
                business.get退所チェック2(),
                business.get入所年月日2(),
                business.get退院年月日2(),
                business.get連番(),
                business.get性障害1(),
                business.get性障害2(),
                business.get構成性別1(),
                business.get構成性別2(),
                business.get居宅介護事業者長1(),
                business.get居宅介護事業者長2(),
                business.get居宅介護事業者長星2(),
                business.get居宅介護事業者長取消2(),
                business.get居宅介護事業者長3(),
                business.get居宅介護事業者長星3(),
                business.get居宅介護事業者長取消3());
    }

    private HihokenshashoA4BodyItem setA4Item(HihokenshashoChoBusiness business) {
        return new HihokenshashoA4BodyItem(business.get有効期限1(),
                business.get有効期限2(),
                business.get被保険者番号(),
                business.get郵便番号(),
                business.get行政区1(),
                business.get行政区2(),
                business.get住所(),
                business.get氏名カナ(),
                business.get氏名(),
                business.get年号(),
                business.get西暦年(),
                business.get和暦年(),
                business.get月(),
                business.get日(),
                business.get性別(),
                business.get交付年月日(),
                business.get再交付(),
                business.get保険者NO1(),
                business.get保険者NO2(),
                business.get保険者NO3(),
                business.get保険者NO4(),
                business.get保険者NO5(),
                business.get保険者NO6(),
                business.get要介護認定区分(),
                business.get認定年月日(),
                business.get認定有効期間開始年月日(),
                business.get有効期間波線(),
                business.get認定有効期間終了年月日(),
                business.get訪問期間波線(),
                business.get訪問期間波線(),
                business.get訪問期間終了年月日(),
                business.getサービス(),
                business.get点数(),
                business.getサービス種類1(),
                business.getサービス種類2(),
                business.getサービス種類3(),
                business.getサービス種類4(),
                business.getサービス種類5(),
                business.getサービス種類6(),
                business.getサービス種類1つ目の限度額(),
                business.getサービス種類2つ目の限度額(),
                business.getサービス種類3つ目の限度額(),
                business.getサービス種類4つ目の限度額(),
                business.getサービス種類5つ目の限度額(),
                business.getサービス種類6つ目の限度額(),
                business.get点数1(),
                business.get点数2(),
                business.get点数3(),
                business.get点数4(),
                business.get点数5(),
                business.get点数6(),
                business.get認定審査会意見等(),
                business.get再交付2(),
                business.get給付制限1(),
                business.get給付制限長1(),
                business.get給付制限2(),
                business.get給付制限長2(),
                business.get給付制限3(),
                business.get給付制限長3(),
                business.get給付制限4(),
                business.get給付制限長4(),
                business.get給付制限5(),
                business.get給付制限長5(),
                business.get給付制限6(),
                business.get給付制限長6(),
                business.get給付制限開始年月日1(),
                business.get給付制限終了年月日1(),
                business.get給付制限開始年月日2(),
                business.get給付制限終了年月日2(),
                business.get給付制限開始年月日3(),
                business.get給付制限終了年月日3(),
                business.get居宅介護事業者1(),
                business.get届出年月日1(),
                business.get居宅介護事業者2(),
                business.get居宅介護事業者星2(),
                business.get居宅介護事業者取消2(),
                business.get届出年月日2(),
                business.get届出年月日星2(),
                business.get届出年月日取消2(),
                business.get居宅介護事業者3(),
                business.get居宅介護事業者星3(),
                business.get届出年月日3(),
                business.get居宅介護事業者取消3(),
                business.get施設種類11(),
                business.get届出年月日星3(),
                business.get届出年月日取消3(),
                business.get施設名1(),
                business.get入所チェック1(),
                business.get入院チェック1(),
                business.get退所チェック1(),
                business.get入所チェック1(),
                business.get入所年月日1(),
                business.get退院年月日1(),
                business.get施設種類2(),
                business.get施設名2(),
                business.get入所チェック2(),
                business.get入院チェック2(),
                business.get退所チェック2(),
                business.get入所チェック2(),
                business.get入所年月日2(),
                business.get退院年月日2(),
                business.get連番(),
                business.get性障害1(),
                business.get性障害2(),
                business.get構成性別1(),
                business.get構成性別2(),
                business.get居宅介護事業者長1(),
                business.get居宅介護事業者長2(),
                business.get居宅介護事業者長星2(),
                business.get居宅介護事業者長取消2(),
                business.get居宅介護事業者長3(),
                business.get居宅介護事業者長星3(),
                business.get居宅介護事業者長取消3(),
                business.get複合コントロール());
    }

    private List<NyutaiShoParameter> get入退所年月日List(IkkatsuHakkoRelateEntity entity) {
        List<NyutaiShoParameter> 入退所年月日List = new ArrayList<>();
        NyutaiShoParameter 入退所年月日Pram = new NyutaiShoParameter();
        入退所年月日Pram.set入所年月日(entity.getNyushoYMD());
        入退所年月日Pram.set退所年月日(entity.getTaishoYMD());
        入退所年月日Pram.set入所施設コード(entity.getNyushoShisetsuCode() != null
                && !entity.getNyushoShisetsuCode().isEmpty() ? entity.getNyushoShisetsuCode().value() : RString.EMPTY);
        入退所年月日Pram.set入所施設種類(entity.getNyushoShisetsuShurui());
        return 入退所年月日List;
    }

    private List<ShutokuTodokedeParameter> get届出年月日List(IkkatsuHakkoRelateEntity entity) {
        List<ShutokuTodokedeParameter> 届出年月日List = new ArrayList<>();
        ShutokuTodokedeParameter 届出年月日Pram = new ShutokuTodokedeParameter();
        届出年月日Pram.set届出年月日(entity.getTodokedeYMD());
        届出年月日Pram.set計画事業者番号(entity.getKeikakuJigyoshaNo() != null
                && !entity.getKeikakuJigyoshaNo().isEmpty() ? entity.getKeikakuJigyoshaNo().value() : RString.EMPTY);
        届出年月日List.add(届出年月日Pram);
        return 届出年月日List;
    }

    private List<JushochitokureiTekiParameter> get適用年月日List(IkkatsuHakkoRelateEntity entity) {
        List<JushochitokureiTekiParameter> 適用年月日List = new ArrayList<>();
        JushochitokureiTekiParameter 適用年月日Pram = new JushochitokureiTekiParameter();
        適用年月日Pram.set適用開始年月日(get年月日(entity.getTekiyoKaishiYMD()));
        適用年月日Pram.set適用終了年月日(get年月日(entity.getTekiyoShuryoYMD()));
        適用年月日List.add(適用年月日Pram);
        return 適用年月日List;
    }

    private List<ShiteiServiceParameter> getサービス種類List(IkkatsuHakkoRelateEntity entity) {
        List<ShiteiServiceParameter> サービス種類List = new ArrayList<>();
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui01()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui02()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui03()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui04()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui05()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui06()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui07()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui08()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui09()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui10()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui11()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui12()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui13()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui14()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui15()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui16()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui17()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui18()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui19()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui20()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui21()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui22()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui23()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui24()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui25()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui26()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui27()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui28()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui29()));
        サービス種類List.add(getサービス種類(entity.getShiteiServiceShurui30()));
        return サービス種類List;
    }

    private ShiteiServiceParameter getサービス種類(ServiceShuruiCode code) {
        ShiteiServiceParameter サービス種類Parm = new ShiteiServiceParameter();
        RString 指定サービス種類 = RString.EMPTY;
        if (code != null && !code.isEmpty()) {
            指定サービス種類 = code.value();
        }
        サービス種類Parm.set指定サービス種類(指定サービス種類);
        return サービス種類Parm;
    }

    private RDate get年月日(FlexibleDate 日付) {
        if (日付 != null && !日付.isEmpty()) {
            return new RDate(日付.toString());
        }
        return null;
    }
}
