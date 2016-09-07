/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashoa4.HihokenshashoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護保険被保険者証ボディEditorです。
 *
 * @reamsid_L DBU-0490-070 suguangjun
 */
public class HihokenshashoA4BodyEditor implements IHihokenshashoA4Editor {

    private final HihokenshashoA4BodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険被保険者証リスト情報
     */
    public HihokenshashoA4BodyEditor(HihokenshashoA4BodyItem item) {
        this.item = item;
    }

    /**
     * 介護保険被保険者証ボディEditorです。
     *
     * @param source 介護保険被保険者証Source
     * @return 介護保険被保険者証Source
     */
    @Override
    public HihokenshashoA4ReportSource edit(HihokenshashoA4ReportSource source) {
        return bodyEdit(source);
    }

    private HihokenshashoA4ReportSource bodyEdit(HihokenshashoA4ReportSource source) {
        source.yukokigen = item.getYukokigen1();
        source.yukokigen2 = item.getYukokigen2();
        source.hihokenshanno = item.getHihokenshanno();
        source.yubinno = item.getYubinno();
        source.gyoseiku = item.getGyoseiku();
        source.gyoseikuS = item.getGyoseikuS();
        source.hihojusho = item.getHihojusho();
        source.hihokana = item.getHihokana();
        source.hihoname = item.getHihoname();
        source.umareG = item.getUmareG();
        source.umareYyyy = item.getUmareYyyy();
        source.umareYy = item.getUmareYy();
        source.umareMm = item.getUmareMm();
        source.umareDd = item.getUmareDd();
        source.seibetsu = item.getSeibetsu();
        RString kofuymd = item.getKofuymd();
        if (!RString.isNullOrEmpty(kofuymd)) {
            FillTypeFormatted kofuymdFormat = new RDate(kofuymd.toString()).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK);
            source.kofuymdGengo = kofuymdFormat.getEra();
            source.kofuymdYy = kofuymdFormat.getYear();
            source.kofuymdMm = kofuymdFormat.getMonth();
            source.kofuymdDd = kofuymdFormat.getDay();
        }
        source.saikofu1 = item.getSaikofu1();
        source.hokenshano1 = item.getHokenshano1();
        source.hokenshano2 = item.getHokenshano2();
        source.hokenshano3 = item.getHokenshano3();
        source.hokenshano4 = item.getHokenshano4();
        source.hokenshano5 = item.getHokenshano5();
        source.hokenshano6 = item.getHokenshano6();
        source.kaigokbn = item.getKaigokbn();
        source.ninteiymd = item.getNinteiymd();
        source.yukokikanst = item.getYukokikanst();
        source.yukokikannamisen = item.getYukokikannamisen();
        source.yukokikaned = item.getYukokikaned();
        source.homonkikanst = item.getHomonkikanst();
        source.homonkikannamisen = item.getHomonkikannamisen();
        source.homonkikaned = item.getHomonkikaned();
        source.service1 = item.getService1();
        source.ten0 = item.getTen0();
        source.shurui1 = item.getShurui1();
        source.shurui2 = item.getShurui2();
        source.shurui3 = item.getShurui3();
        source.shurui4 = item.getShurui4();
        source.shurui5 = item.getShurui5();
        source.shurui6 = item.getShurui6();
        source.shuruigendo1 = item.getShuruigendo1();
        source.shuruigendo2 = item.getShuruigendo2();
        source.shuruigendo3 = item.getShuruigendo3();
        source.shuruigendo4 = item.getShuruigendo4();
        source.shuruigendo5 = item.getShuruigendo5();
        source.shuruigendo6 = item.getShuruigendo6();
        source.ten1 = item.getTen1();
        source.ten2 = item.getTen2();
        source.ten3 = item.getTen3();
        source.ten4 = item.getTen4();
        source.ten5 = item.getTen5();
        source.ten6 = item.getTen6();
        source.ryui = item.getRyui();
        source.saikofu2 = item.getSaikofu2();
        source.seigen1 = item.getSeigen1();
        source.seigenLong1 = item.getSeigenLong1();
        source.seigen2 = item.getSeigen2();
        source.seigenLong2 = item.getSeigenLong2();
        source.seigen3 = item.getSeigen3();
        source.seigenLong3 = item.getSeigenLong3();
        source.seigen4 = item.getSeigen4();
        source.seigenLong4 = item.getSeigenLong4();
        source.seigen5 = item.getSeigen5();
        source.seigenLong5 = item.getSeigenLong5();
        source.seigen6 = item.getSeigen6();
        source.seigenLong6 = item.getSeigenLong6();
        source.seigenSt1 = item.getSeigenSt1();
        source.seigenEd1 = item.getSeigenEd1();
        source.seigenSt2 = item.getSeigenSt2();
        source.seigenEd2 = item.getSeigenEd2();
        source.seigenSt3 = item.getSeigenSt3();
        source.seigenEd3 = item.getSeigenEd3();
        source.gyosha1 = item.getGyosha1();
        source.todokeYmd1 = item.getTodokeYmd1();
        source.gyosha2 = item.getGyosha2();
        source.gyosha2Asa = item.getGyosha2Asa();
        source.gyosha2Massho = item.getGyosha2Massho();
        source.todokeYmd2 = item.getTodokeYmd2();
        source.todokeYmd2Asa = item.getTodokeYmd2();
        source.todokeYmd2Massho = item.getTodokeYmd2Asa();
        source.gyosha3 = item.getGyosha3();
        source.gyosha3Asa = item.getGyosha3Asa();
        source.gyosha3Massho = item.getGyosha3Massho();
        source.todokeYmd3 = item.getTodokeYmd3();
        source.todokeYmd3Asa = item.getTodokeYmd3Asa();
        source.todokeYmd3Massho = item.getTodokeYmd3Massho();
        source.shisetsuSyu1 = item.getShisetsuSyu1();
        source.shisetsuname1 = item.getShisetsuname1();
        source.nyushochk1 = item.getNyushochk1();
        source.nyuinchk1 = item.getNyuinchk1();
        source.taishochk1 = item.getTaishochk1();
        source.taiinchk1 = item.getTaiinchk1();
        source.nyushoymd1 = item.getNyushoymd1();
        source.taiinymd1 = item.getTaiinymd1();
        source.shisetsuSyu2 = item.getShisetsuSyu2();
        source.shisetsuname2 = item.getShisetsuname2();
        source.nyushochk2 = item.getNyushochk2();
        source.nyuinchk2 = item.getNyuinchk2();
        source.taishochk2 = item.getTaishochk2();
        source.taiinchk2 = item.getTaiinchk2();
        source.nyushoymd2 = item.getNyushoymd2();
        source.taiinymd2 = item.getTaiinymd2();
        source.renban = item.getRenban();
        source.seiShogai11 = item.getSeiShogai11();
        source.seiShogai12 = item.getSeiShogai12();
        source.kosekiSeibetsu11 = item.getKosekiSeibetsu11();
        source.kosekiSeibetsu12 = item.getKosekiSeibetsu12();
        source.itakuGyosha1 = item.getItakuGyosha1();
        source.itakuGyosha2 = item.getItakuGyosha2();
        source.itakuGyosha2Asa = item.getItakuGyosha2Asa();
        source.itakuGyosha2Massho = item.getItakuGyosha2Massho();
        source.itakuGyosha3 = item.getItakuGyosha3();
        source.itakuGyosha3Asa = item.getItakuGyosha3Asa();
        source.itakuGyosha3Massho = item.getItakuGyosha3Massho();
        source.imageField1 = item.getImageField1();
        return source;
    }
}
