/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.service.report.hihokenshashob4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4BodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Item;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Proerty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Report;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashob4.HihokenshashoB4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 介護保険被保険者証（B4版）Printクラスです。
 */
public class HihokenshashoB4PrintService {
    
    private static final int MAX_RECORD_COUNT = 2;
    private static final int ONE = 1;
    
    /**
     * 介護保険被保険者証（B4版）Printします。
     * @param items 介護保険被保険者証（B4版）作成_帳票クラスパラメータ
     * @return 介護保険被保険者証（B4版）作成_帳票
     */
    public SourceDataCollection print(List<HihokenshashoB4Item> items) {
        HihokenshashoB4Proerty proerty = new HihokenshashoB4Proerty();
        return new Printer<HihokenshashoB4ReportSource>().spool(proerty, toReports(items));
    }
    
    private static List<HihokenshashoB4Report> toReports(List<HihokenshashoB4Item> johos) {
        int dataCount = johos.size();
        int pageCount = dataCount / MAX_RECORD_COUNT;
        int lastPageCount = dataCount % MAX_RECORD_COUNT;
        boolean isLastPage = false;
        List<HihokenshashoB4Report> list = new ArrayList<>();
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
        if (isLastPage) {
            if (lastPageCount == 1) {
                HihokenshashoB4Item itemOne = johos.get(dataCount - ONE);
                HihokenshashoB4BodyItem item = setBodyItem_上段(itemOne);
                items.add(item);
            } 
        }
        list.add(HihokenshashoB4Report.createReport(items));
        return list;
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
            item.setTodokeYmd2(itemOne.getTodokeYmd2());
            item.setGyosha3(itemOne.getGyosha3());
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
            item.setItakuGyosha3(itemOne.getItakuGyosha3());
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
            item.setTodokeYmd22(itemTwo.getTodokeYmd2());
            item.setGyosha32(itemTwo.getGyosha3());
            item.setTodokeYmd32(itemTwo.getTodokeYmd3());
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
            item.setItakuGyosha32(itemTwo.getItakuGyosha3());
            return item;
    }
}
