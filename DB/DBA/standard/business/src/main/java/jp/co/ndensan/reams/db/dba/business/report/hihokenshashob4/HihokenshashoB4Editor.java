/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashob4.HihokenshashoB4ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 介護保険被保険者証（B4版）Editorです。
 */
public class HihokenshashoB4Editor implements IHihokenshashoB4Editor {
    
    private final static int 年月日の年_和暦_STR = 2;
    private final static int 年月日の年_和暦_END = 4;
    private final HihokenshashoB4BodyItem joho;
    
    /**
     * コンストラクタです。
     * @param joho 一覧表証発行者Entityリストです
     */
    public HihokenshashoB4Editor(HihokenshashoB4BodyItem joho) {
        this.joho = joho;
    }

    /**
     * 要介護認定業務進捗状況一覧表editです。
     * @param source 被保険者証発行一覧表Source
     * @return 要介護認定業務進捗状況一覧表
     */
    @Override
    public HihokenshashoB4ReportSource edit(HihokenshashoB4ReportSource source) {
        return editBody(source);
    }
    
    private HihokenshashoB4ReportSource editBody(HihokenshashoB4ReportSource source) {
        source = editBody2(source);
        source.kaigokbn1 = joho.getKaigokbn();
        source.seigen11 = joho.getSeigen1();
        source.seigenSt11 = joho.getSeigenSt1();
        source.seigenLong11 = joho.getSeigenLong1();
        source.seigen21 = joho.getSeigen2();
        source.seigenEd11 = joho.getSeigenEd1();
        source.seigenLong21 = joho.getSeigenLong2();
        source.ninteiymd1 = joho.getNinteiymd();
        source.yukokigen21 = joho.getYukokigen2();
        source.yukokigen1 = joho.getYukokigen();
        source.seigen31 = joho.getSeigen3();
        source.seigenSt21 = joho.getSeigenSt2();
        source.seigenLong31 = joho.getSeigenLong3();
        source.yukokikaned1 = joho.getYukokikaned();
        source.yukokikanst1 = joho.getYukokikanst();
        source.seigen41 = joho.getSeigen4();
        source.hihokenshanno1 = joho.getHihokenshanno();
        source.seigenEd21 = joho.getSeigenEd2();
        source.seigenLong41 = joho.getSeigenLong4();
        source.seigen51 = joho.getSeigen5();
        source.seigenSt31 = joho.getSeigenSt3();
        source.seigenLong51 = joho.getSeigenLong5();
        source.yubinno1 = joho.getYubinno();
        source.homonkikanst1 = joho.getHomonkikanst();
        source.homonkikaned1 = joho.getHomonkikaned();
        source.seigen61 = joho.getSeigen6();
        source.gyoseiku1 = joho.getGyoseiku();
        source.seigenEd31 = joho.getSeigenEd3();
        source.gyoseikuS1 = joho.getGyoseikuS();
        source.seigenLong61 = joho.getSeigenLong6();
        source.hihojusho1 = joho.getHihojusho();
        source.service11 = joho.getService1();
        source.ten01 = joho.getTen0();
        source.gyosha1 = joho.getGyosha();
        source.servicetani1 = joho.getServicetani();
        source.todokeYmd11 = joho.getTodokeYmd1();
        source.shuruigendo11 = joho.getShuruigendo1();
        source.shurui11 = joho.getShurui1();
        source.ten11 = joho.getTen1();
        source.gyosha2 = joho.getGyosha2();
        source.gyosha2Asa = joho.getGyosha2() == null ? RString.EMPTY : new RString("*");
        source.gyosha2Massho = joho.getGyosha2();
        source.shuruigendo21 = joho.getShuruigendo2();
        source.ten21 = joho.getTen2();
        source.shurui21 = joho.getShurui2();
        source.shuruigendo31 = joho.getShuruigendo3();
        source.ten31 = joho.getTen3();
        source.shurui31 = joho.getShurui3();
        source.hihokana1 = joho.getHihokana();
        source.todokeYmd21 = joho.getTodokeYmd2();
        source.todokeYmd2Massho1 = joho.getTodokeYmd2();
        source.todokeYmd2Asa1 = joho.getTodokeYmd2() == null ? RString.EMPTY : new RString("*");
        source.shuruigendo41 = joho.getShuruigendo4();
        source.ten41 = joho.getTen4();
        source.shurui41 = joho.getShurui4();
        source.hihoname1 = joho.getHihoname();
        source.gyosha3 = joho.getGyosha3();
        source.gyosha3Asa = joho.getGyosha3() == null ? RString.EMPTY : new RString("*");
        source.gyosha3Massho = joho.getGyosha3();
        source.shuruigendo51 = joho.getShuruigendo5();
        source.ten51 = joho.getTen5();
        source.shurui51 = joho.getShurui5();
        source.shurui61 = joho.getShurui6();
        source.ten61 = joho.getTen6();
        source.shuruigendo61 = joho.getShuruigendo6();
        source.todokeYmd31 = joho.getTodokeYmd3();
        source.todokeYmd3Asa1 = new RString("*");
        source.todokeYmd3Massho1 = joho.getTodokeYmd3();
        source.ryui1 = joho.getRyui();
        source.shisetsuSyu11 = joho.getShisetsuSyu1();
        source.seibetsuMan1 = joho.getSeibetsuMan();
        source.seibetsuWoman1 = joho.getSeibetsuWoman();
        source.umareMeiji1 = joho.getUmareMeiji();
        source.umareTaisho1 = joho.getUmareTaisho();
        source.umareShowa1 = joho.getUmareShowa();
        source.umareMm1 = get年月日の月_和暦(joho.getUmareYy());
        source.umareDd1 = get年月日の日_和暦(joho.getUmareYy());
        source.umareYy1 = get年月日の年_和暦(joho.getUmareYy());
        source.umareYyyy1 = get年月日の年_西歴(joho.getUmareYy());
        source.umareMmS1 = get年月日の月_西歴(joho.getUmareYy());
        source.umareDdS1 = get年月日の日_西歴(joho.getUmareYy());
        source.saikofu11 = joho.getSaikofu1();
        source.saikofu21 = joho.getSaikofu12();
        source.shisetsuname11 = joho.getShisetsuname1();
        source.kofuymdGengo1 = get年月日の年号(joho.getKofuymdGengo());
        source.kofuymdYy1 = get年月日の年_和暦(joho.getKofuymdGengo());
        source.kofuymdMm1 = get年月日の月_和暦(joho.getKofuymdGengo());
        source.kofuymdDd1 = get年月日の日_和暦(joho.getKofuymdGengo());
        source.nyushochk11 = joho.getNyushochk1();
        source.nyuinchk11 = joho.getNyuinchk1();
        source.nyushoymd11 = joho.getNyushoymd1();
        source.taishochk11 = joho.getTaishochk1();
        source.taiinchk11 = joho.getTaiinchk1();
        source.taiinymd11 = joho.getTaiinymd1();
        source.hokenshano41 = joho.getHokenshano4();
        source.hokenshano11 = joho.getHokenshano1();
        source.hokenshano21 = joho.getHokenshano2();
        source.hokenshano31 = joho.getHokenshano3();
        source.hokenshano51 = joho.getHokenshano5();
        source.hokenshano61 = joho.getHokenshano6();
        source.shisetsuSyu21 = joho.getShisetsuSyu2();
        source.shisetsuname21 = joho.getShisetsuname2();
        source.nyushochk21 = joho.getNyushochk2();
        source.nyuinchk21 = joho.getNyuinchk2();
        source.nyushoymd21 = joho.getNyushoymd2();
        source.taishochk21 = joho.getTaishochk2();
        source.taiinchk21 = joho.getTaiinchk2();
        source.taiinymd21 = joho.getTaiinymd2();
        source.renban1 = joho.getRenban();
        source.kaigokbn2 = joho.getKaigokbn2();
        source.seigen12 = joho.getSeigen12();
        source.seigenLong12 = joho.getSeigenLong12();
        source.seigenSt12 = joho.getSeigenSt12();
        return source;
    }
    
    private HihokenshashoB4ReportSource editBody2(HihokenshashoB4ReportSource source) {
        source.seigen22 = joho.getSeigen22();
        source.seigenLong22 = joho.getSeigenLong22();
        source.seigenEd12 = joho.getSeigenEd12();
        source.ninteiymd2 = joho.getNinteiymd2();
        source.yukokigen22 = joho.getYukokigen2();
        source.yukokigen2 = joho.getYukokigen2();
        source.seigen32 = joho.getSeigen32();
        source.seigenLong32 = joho.getSeigenLong32();
        source.seigenSt22 = joho.getSeigenSt22();
        source.yukokikanst2 = joho.getYukokikanst2();
        source.yukokikaned2 = joho.getYukokikaned2();
        source.seigen42 = joho.getSeigen42();
        source.seigenLong42 = joho.getSeigenLong42();
        source.seigenEd22 = joho.getSeigenEd22();
        source.hihokenshanno2 = joho.getHihokenshanno2();
        source.seigen52 = joho.getSeigen52();
        source.seigenLong52 = joho.getSeigenLong52();
        source.seigenSt32 = joho.getSeigenSt32();
        source.yubinno2 = joho.getYubinno2();
        source.homonkikanst2 = joho.getHomonkikanst2();
        source.homonkikaned2 = joho.getHomonkikaned2();
        source.gyoseikuS2 = joho.getGyoseikuS2();
        source.seigen62 = joho.getSeigen62();
        source.gyoseiku2 = joho.getGyoseiku2();
        source.seigenEd32 = joho.getSeigenEd32();
        source.seigenLong62 = joho.getSeigenLong62();
        source.hihojusho2 = joho.getHihojusho2();
        source.service12 = joho.getService12();
        source.ten02 = joho.getTen02();
        source.servicetani2 = joho.getServicetani2();
        source.gyosha4 = joho.getGyosha02();
        source.todokeYmd12 = joho.getTodokeYmd12();
        source.shuruigendo12 = joho.getShuruigendo12();
        source.ten12 = joho.getTen12();
        source.shurui12 = joho.getShurui12();
        source.gyosha5 = joho.getGyosha22();
        source.gyosha5Asa = joho.getGyosha22() == null ? RString.EMPTY : new RString("*");
        source.gyosha5Massho = joho.getGyosha22();
        source.shuruigendo22 = joho.getShuruigendo22();
        source.ten22 = joho.getTen22();
        source.shurui22 = joho.getShurui22();
        source.shuruigendo32 = joho.getShuruigendo32();
        source.ten32 = joho.getTen32();
        source.shurui32 = joho.getShurui32();
        source.hihokana2 = joho.getHihokana2();
        source.todokeYmd22 = joho.getTodokeYmd22();
        source.todokeYmd2Asa2 =joho.getTodokeYmd22() == null ? RString.EMPTY : new RString("*");
        source.todokeYmd2Massho2 = joho.getTodokeYmd22();
        source.shuruigendo42 = joho.getShuruigendo42();
        source.ten42 = joho.getTen42();
        source.shurui42 = joho.getShurui42();
        source.hihoname2 = joho.getHihoname2();
        source.gyosha6 = joho.getGyosha32();
        source.gyosha6Asa = joho.getGyosha32() == null ? RString.EMPTY : new RString("*");
        source.gyosha6Massho = joho.getGyosha32();
        source.shuruigendo52 = joho.getShuruigendo52();
        source.ten52 = joho.getTen52();
        source.shurui52 = joho.getShurui52();
        source.shuruigendo62 = joho.getShuruigendo62();
        source.ten62 = joho.getTen62();
        source.shurui62 = joho.getShurui62();
        source.ryui2 = joho.getRyui2();
        source.todokeYmd32 = joho.getTodokeYmd32();
        source.todokeYmd3Asa2 = joho.getTodokeYmd32() == null ? RString.EMPTY : new RString("*");
        source.todokeYmd3Massho2 = joho.getTodokeYmd32();
        source.shisetsuSyu12 = joho.getShisetsuSyu12();
        source.seibetsuWoman2 = joho.getSeibetsuWoman2();
        source.seibetsuMan2 = joho.getSeibetsuMan2();
        source.umareMeiji2 = joho.getUmareMeiji2();
        source.umareTaisho2 = joho.getUmareTaisho2();
        source.umareShowa2 = joho.getUmareShowa2();
        source.umareMm2 = get年月日の月_和暦(joho.getUmareYy2());
        source.umareDd2 = get年月日の日_和暦(joho.getUmareYy2());
        source.umareMmS2 = get年月日の月_西歴(joho.getUmareYy2());
        source.umareDdS2 = get年月日の日_西歴(joho.getUmareYy2());
        source.umareYy2 = get年月日の年_和暦(joho.getUmareYy2());
        source.umareYyyy2 = get年月日の年_西歴(joho.getUmareYy2());
        source.saikofu12 = joho.getSaikofu12();
        source.saikofu22 = joho.getSaikofu22();
        source.shisetsuname12 = joho.getShisetsuname12();
        source.kofuymdYy2 = get年月日の年_和暦(joho.getKofuymdGengo2());
        source.kofuymdMm2 = get年月日の月_和暦(joho.getKofuymdGengo2());
        source.kofuymdDd2 = get年月日の日_和暦(joho.getKofuymdGengo2());
        source.kofuymdGengo2 = get年月日の年号(joho.getKofuymdGengo2());
        source.nyushochk12 = joho.getNyushochk12();
        source.nyuinchk12 = joho.getNyuinchk12();
        source.nyushoymd12 = joho.getNyushoymd12();
        source.taiinchk12 = joho.getTaiinchk12();
        source.taishochk12 = joho.getTaishochk12();
        source.taiinymd12 = joho.getTaiinymd12();
        source.hokenshano12 = joho.getHokenshano12();
        source.hokenshano22 = joho.getHokenshano22();
        source.hokenshano32 = joho.getHokenshano32();
        source.hokenshano42 = joho.getHokenshano42();
        source.hokenshano52 = joho.getHokenshano52();
        source.hokenshano62 = joho.getHokenshano62();
        source.shisetsuSyu22 = joho.getShisetsuSyu22();
        source.shisetsuname22 = joho.getShisetsuname22();
        source.nyushoymd22 = joho.getNyushoymd22();
        source.nyushochk22 = joho.getNyushochk22();
        source.nyuinchk22 = joho.getNyuinchk22();
        source.taiinymd22 = joho.getTaiinymd22();
        source.renban2 = joho.getRenban2();
        source.taishochk22 = joho.getTaishochk22();
        source.taiinchk22 = joho.getTaiinchk22();
        source.itakuGyosha1 = joho.getItakuGyosha1();
        source.itakuGyosha2 = joho.getItakuGyosha2();
        source.itakuGyosha2Asa = joho.getItakuGyosha2() == null ? RString.EMPTY :new RString("*");
        source.itakuGyosha2Massho = joho.getItakuGyosha2();
        source.itakuGyosha3 = joho.getItakuGyosha3();
        source.itakuGyosha3Asa = joho.getItakuGyosha3() == null ? RString.EMPTY : new RString("*");
        source.itakuGyosha3Massho = joho.getItakuGyosha3();
        source.seiShogai11 = joho.getSeiShogai12();
        source.seiShogai21 = joho.getSeiShogai22();
        source.kosekiSeibetsu11 = joho.getKosekiSeibetsu1();
        source.kosekiSeibetsu21 = joho.getKosekiSeibetsu2();
        source.itakuGyosha4 = joho.getItakuGyosha12();
        source.itakuGyosha5 = joho.getItakuGyosha22();
        source.itakuGyosha5Asa = joho.getItakuGyosha22() == null ? RString.EMPTY : new RString("*");
        source.itakuGyosha5Massho = joho.getItakuGyosha22();
        source.itakuGyosha6 = joho.getItakuGyosha32();
        source.itakuGyosha6Asa = joho.getItakuGyosha32() == null ? RString.EMPTY : new RString("*");
        source.itakuGyosha6Massho = joho.getItakuGyosha32();
        source.seiShogai12 = joho.getSeiShogai12();
        source.seiShogai22 = joho.getSeiShogai22();
        source.kosekiSeibetsu12 = joho.getKosekiSeibetsu12();
        source.kosekiSeibetsu22 = joho.getKosekiSeibetsu22();
        return source;
    }
    
    private RString get年月日の年_和暦(RString date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getYear().substring(年月日の年_和暦_STR, 年月日の年_和暦_END);
    }
    
    private RString get年月日の月_和暦(RString date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getMonth();
    }
    
    private RString get年月日の日_和暦(RString date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getDay();
    }
    
    private RString get年月日の年号(RString date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getEra();
    }
    
    private RString get年月日の年_西歴(RString date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).seireki().getYear();
    }
    
    private RString get年月日の月_西歴(RString date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).seireki().getMonth();
    }
    
    private RString get年月日の日_西歴(RString date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).seireki().getDay();
    }
    
    
    
}