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
 * 被保険者証発行一覧表Editorです。
 */
public class HihokenshashoB4Editor implements IHihokenshashoB4Editor {
    
    private final HihokenshashoB4Item joho;
    
    /**
     * コンストラクタです。
     * @param joho 一覧表証発行者Entityリストです
     */
    public HihokenshashoB4Editor(HihokenshashoB4Item joho) {
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
        // TODO
        source.yukokigen21 = joho.getYukokigen();
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
        source.gyosha2 = joho.getGyosha();
        source.gyosha2Asa = new RString("*");
        source.gyosha2Massho = joho.getGyosha();
        source.shuruigendo21 = joho.getShuruigendo2();
        source.ten21 = joho.getTen2();
        source.shurui21 = joho.getShurui2();
        source.shuruigendo31 = joho.getShuruigendo3();
        source.ten31 = joho.getTen3();
        source.shurui31 = joho.getShurui3();
        source.hihokana1 = joho.getHihokana();
        source.todokeYmd21 = joho.getTodokeYmd2();
        source.todokeYmd2Massho1 = new RString("*");
        source.todokeYmd2Asa1 = joho.getTodokeYmd2();
        source.shuruigendo41 = joho.getShuruigendo4();
        source.ten41 = joho.getTen4();
        source.shurui41 = joho.getShurui4();
        source.hihoname1 = joho.getHihoname();
        source.gyosha3 = joho.getGyosha3();
        source.gyosha3Asa = new RString("*");
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
        source.umareMm1 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho.getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getMonth();
        source.umareDd1 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho.getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getDay();
        source.umareYy1 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho.getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getYear();
        source.umareYyyy1 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho.getUmareYy().toString()).seireki().getYear();
        source.umareMmS1 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho.getUmareYy().toString()).seireki().getMonth();
        source.umareDdS1 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho.getUmareYy().toString()).seireki().getDay();
        source.saikofu11 = joho.getSaikofu1();
        source.saikofu21 = joho.getSaikofu2();
        source.shisetsuname11 = joho.getShisetsuname1();
        source.kofuymdGengo1 = joho.getKofuymdGengo().isEmpty() ? RString.EMPTY : new RDate(joho
                .getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getEra();
        source.kofuymdYy1 = joho.getKofuymdGengo().isEmpty() ? RString.EMPTY : new RDate(joho
                .getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getYear();
        source.kofuymdMm1 = joho.getKofuymdGengo().isEmpty() ? RString.EMPTY : new RDate(joho
                .getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getMonth();
        source.kofuymdDd1 = joho.getKofuymdGengo().isEmpty() ? RString.EMPTY : new RDate(joho
                .getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getDay();
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
        source.kaigokbn2 = joho.getKaigokbn();
        source.seigen12 = joho.getSeigen1();
        source.seigenLong12 = joho.getSeigenLong1();
        source.seigenSt12 = joho.getSeigenSt1();
        return source;
    }
    
    private HihokenshashoB4ReportSource editBody2(HihokenshashoB4ReportSource source) {
        source.seigen22 = joho.getSeigen2();
        source.seigenLong22 = joho.getSeigenLong2();
        source.seigenEd12 = joho.getSeigenEd1();
        source.ninteiymd2 = joho.getNinteiymd();
        // TODO
        source.yukokigen22 = joho.getYukokigen();
        source.yukokigen2 = joho.getYukokigen();
        source.seigen32 = joho.getSeigen3();
        source.seigenLong32 = joho.getSeigenLong3();
        source.seigenSt22 = joho.getSeigenSt2();
        source.yukokikanst2 = joho.getYukokikanst();
        source.yukokikaned2 = joho.getYukokikaned();
        source.seigen42 = joho.getSeigen4();
        source.seigenLong42 = joho.getSeigenLong4();
        source.seigenEd22 = joho.getSeigenEd2();
        source.hihokenshanno2 = joho.getHihokenshanno();
        source.seigen52 = joho.getSeigen5();
        source.seigenLong52 = joho.getSeigenLong5();
        source.seigenSt32 = joho.getSeigenSt3();
        source.yubinno2 = joho.getYubinno();
        source.homonkikanst2 = joho.getHomonkikanst();
        source.homonkikaned2 = joho.getHomonkikaned();
        source.gyoseikuS2 = joho.getGyoseikuS();
        source.seigen62 = joho.getSeigen6();
        source.gyoseiku2 = joho.getGyoseiku();
        source.seigenEd32 = joho.getSeigenEd3();
        source.seigenLong62 = joho.getSeigenLong6();
        source.hihojusho2 = joho.getHihojusho();
        source.service12 = joho.getService1();
        source.ten02 = joho.getTen0();
        source.servicetani2 = joho.getServicetani();
        source.gyosha4 = joho.getGyosha();
        source.todokeYmd12 = joho.getTodokeYmd1();
        source.shuruigendo12 = joho.getShuruigendo1();
        source.ten12 = joho.getTen1();
        source.shurui12 = joho.getShurui1();
        source.gyosha5 = joho.getGyosha2();
        source.gyosha5Asa = new RString("*");
        source.gyosha5Massho = joho.getGyosha2();
        source.shuruigendo22 = joho.getShuruigendo2();
        source.ten22 = joho.getTen2();
        source.shurui22 = joho.getShurui2();
        source.shuruigendo32 = joho.getShuruigendo3();
        source.ten32 = joho.getTen3();
        source.shurui32 = joho.getShurui3();
        source.hihokana2 = joho.getHihokana();
        source.todokeYmd22 = joho.getTodokeYmd2();
        source.todokeYmd2Asa2 = new RString("*");
        source.todokeYmd2Massho2 = joho.getTodokeYmd2();
        source.shuruigendo42 = joho.getShuruigendo4();
        source.ten42 = joho.getTen4();
        source.shurui42 = joho.getShurui4();
        source.hihoname2 = joho.getHihoname();
        source.gyosha6 = joho.getGyosha3();
        source.gyosha6Asa = new RString("*");
        source.gyosha6Massho = joho.getGyosha3();
        source.shuruigendo52 = joho.getShuruigendo5();
        source.ten52 = joho.getTen5();
        source.shurui52 = joho.getShurui5();
        source.shuruigendo62 = joho.getShuruigendo6();
        source.ten62 = joho.getTen6();
        source.shurui62 = joho.getShurui6();
        source.ryui2 = joho.getRyui();
        source.todokeYmd32 = joho.getTodokeYmd3();
        source.todokeYmd3Asa2 = new RString("*");
        source.todokeYmd3Massho2 = joho.getTodokeYmd3();
        source.shisetsuSyu12 = joho.getShisetsuSyu1();
        source.seibetsuWoman2 = joho.getSeibetsuWoman();
        source.seibetsuMan2 = joho.getSeibetsuMan();
        source.umareMeiji2 = joho.getUmareMeiji();
        source.umareTaisho2 = joho.getUmareTaisho();
        source.umareShowa2 = joho.getUmareShowa();
        source.umareMm2 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho
                .getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getMonth();
        source.umareDd2 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho
                .getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).getDay();
        source.umareMmS2 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho
                .getUmareYy().toString()).seireki().getMonth();
        source.umareDdS2 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho
                .getUmareYy().toString()).seireki().getDay();
        source.umareYy2 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho
                .getUmareYy().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getYear();
        source.umareYyyy2 = joho.getUmareYy().isEmpty() ? RString.EMPTY : new RDate(joho.getUmareYy().toString()).seireki().getYear();
        source.saikofu12 = joho.getSaikofu1();
        source.saikofu22 = joho.getSaikofu2();
        source.shisetsuname12 = joho.getShisetsuname1();
        source.kofuymdYy2 = joho.getKofuymdGengo().isEmpty() ? RString.EMPTY : new RDate(joho
                .getKofuymdGengo().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getYear();
        source.kofuymdMm2 = joho.getKofuymdGengo().isEmpty() ? RString.EMPTY : new RDate(joho
                .getKofuymdGengo().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonth();
        source.kofuymdDd2 = joho.getKofuymdGengo().isEmpty() ? RString.EMPTY : new RDate(joho
                .getKofuymdGengo().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getDay();
        source.kofuymdGengo2 = joho.getKofuymdGengo().isEmpty() ? RString.EMPTY : new RDate(joho
                .getKofuymdGengo().toString()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getEra();
        source.nyushochk12 = joho.getNyushochk1();
        source.nyuinchk12 = joho.getNyuinchk1();
        source.nyushoymd12 = joho.getNyushoymd1();
        source.taiinchk12 = joho.getTaiinchk1();
        source.taishochk12 = joho.getTaishochk1();
        source.taiinymd12 = joho.getTaiinymd1();
        source.hokenshano12 = joho.getHokenshano1();
        source.hokenshano22 = joho.getHokenshano2();
        source.hokenshano32 = joho.getHokenshano3();
        source.hokenshano42 = joho.getHokenshano4();
        source.hokenshano52 = joho.getHokenshano5();
        source.hokenshano62 = joho.getHokenshano6();
        source.shisetsuSyu22 = joho.getShisetsuSyu2();
        source.shisetsuname22 = joho.getShisetsuname2();
        source.nyushoymd22 = joho.getNyushoymd2();
        source.nyushochk22 = joho.getNyushochk2();
        source.nyuinchk22 = joho.getNyuinchk2();
        source.taiinymd22 = joho.getTaiinymd2();
        source.renban2 = joho.getRenban();
        source.taishochk22 = joho.getTaishochk2();
        source.taiinchk22 = joho.getTaiinchk2();
        source.itakuGyosha1 = joho.getItakuGyosha1();
        source.itakuGyosha2 = joho.getItakuGyosha2();
        source.itakuGyosha2Asa = new RString("*");
        source.itakuGyosha2Massho = joho.getItakuGyosha2();
        source.itakuGyosha3 = joho.getItakuGyosha3();
        source.itakuGyosha3Asa = new RString("*");
        source.itakuGyosha3Massho = joho.getItakuGyosha3();
        source.seiShogai11 = joho.getSeiShogai1();
        source.seiShogai21 = joho.getSeiShogai2();
        source.kosekiSeibetsu11 = joho.getKosekiSeibetsu1();
        source.kosekiSeibetsu21 = joho.getKosekiSeibetsu2();
        source.itakuGyosha4 = joho.getItakuGyosha1();
        source.itakuGyosha5 = joho.getItakuGyosha2();
        source.itakuGyosha5Asa = new RString("*");
        source.itakuGyosha5Massho = joho.getItakuGyosha2();
        source.itakuGyosha6 = joho.getItakuGyosha3();
        source.itakuGyosha6Asa = new RString("*");
        source.itakuGyosha6Massho = joho.getItakuGyosha3();
        source.seiShogai12 = joho.getSeiShogai1();
        source.seiShogai22 = joho.getSeiShogai2();
        source.kosekiSeibetsu12 = joho.getKosekiSeibetsu1();
        source.kosekiSeibetsu22 = joho.getKosekiSeibetsu2();
        return source;
    }
    
}
