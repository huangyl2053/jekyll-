/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.report.DBA10000X;

import jp.co.ndensan.reams.ur.urz.business.report.parts.tsuchishoatesaki.ITsuchishoAtesakiSourceMappable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証の帳票ソースが持つ、A4版とB4版で共通な情報を取得・設定できることを示すインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IHihokenshashoCommonEditData extends ITsuchishoAtesakiSourceMappable {

    /**
     * @return the yukokigen
     */
    RString getYukokigen();

    /**
     * @param yukokigen the yukokigen to set
     */
    void setYukokigen(RString yukokigen);

    /*
     * @return the yukokigen2
     */
    RString getYukokigen2();

    /**
     * @param yukokigen2 the yukokigen2 to set
     */
    void setYukokigen2(RString yukokigen2);

    /**
     * @return the hihokenshanno
     */
    RString getHihokenshanno();

    /**
     * @param hihokenshanno the hihokenshanno to set
     */
    void setHihokenshanno(RString hihokenshanno);

    /**
     * @return the yubinno
     */
    RString getYubinno();

    /**
     * @param yubinno the yubinno to set
     */
    void setYubinno(RString yubinno);

    /**
     * @return the gyoseiku
     */
    RString getGyoseiku();

    /**
     * @param gyoseiku the gyoseiku to set
     */
    void setGyoseiku(RString gyoseiku);

    /**
     * @return the gyoseikuS
     */
    RString getGyoseikuS();

    /**
     * @param gyoseikuS the gyoseikuS to set
     */
    void setGyoseikuS(RString gyoseikuS);

    /**
     * @return the hihojusho
     */
    RString getHihojusho();

    /**
     * @param hihojusho the hihojusho to set
     */
    void setHihojusho(RString hihojusho);

    /**
     * @return the hihokana
     */
    RString getHihokana();

    /**
     * @param hihokana the hihokana to set
     */
    void setHihokana(RString hihokana);

    /**
     * @return the hihoname
     */
    RString getHihoname();

    /**
     * @param hihoname the hihoname to set
     */
    void setHihoname(RString hihoname);

    /**
     * @return the kofuymdGengo
     */
    RString getKofuymdGengo();

    /**
     * @param kofuymdGengo the kofuymdGengo to set
     */
    void setKofuymdGengo(RString kofuymdGengo);

    /**
     * @return the kofuymdYy
     */
    RString getKofuymdYy();

    /**
     * @param kofuymdYy the kofuymdYy to set
     */
    void setKofuymdYy(RString kofuymdYy);

    /**
     * @return the kofuymdMm
     */
    RString getKofuymdMm();

    /**
     * @param kofuymdMm the kofuymdMm to set
     */
    void setKofuymdMm(RString kofuymdMm);

    /**
     * @return the kofuymdDd
     */
    RString getKofuymdDd();

    /**
     * @param kofuymdDd the kofuymdDd to set
     */
    void setKofuymdDd(RString kofuymdDd);

    /**
     * @return the saikofu1
     */
    RString getSaikofu1();

    /**
     * @param saikofu1 the saikofu1 to set
     */
    void setSaikofu1(RString saikofu1);

    /**
     * @return the saikofu2
     */
    RString getSaikofu2();

    /**
     * @param saikofu2 the saikofu2 to set
     */
    void setSaikofu2(RString saikofu2);

    /**
     * @return the hokenshano1
     */
    RString getHokenshano1();

    /**
     * @param hokenshano1 the hokenshano1 to set
     */
    void setHokenshano1(RString hokenshano1);

    /**
     * @return the hokenshano2
     */
    RString getHokenshano2();

    /**
     * @param hokenshano2 the hokenshano2 to set
     */
    void setHokenshano2(RString hokenshano2);

    /**
     * @return the hokenshano3
     */
    RString getHokenshano3();

    /**
     * @param hokenshano3 the hokenshano3 to set
     */
    void setHokenshano3(RString hokenshano3);

    /**
     * @return the hokenshano4
     */
    RString getHokenshano4();

    /**
     * @param hokenshano4 the hokenshano4 to set
     */
    void setHokenshano4(RString hokenshano4);

    /**
     * @return the hokenshano5
     */
    RString getHokenshano5();

    /**
     * @param hokenshano5 the hokenshano5 to set
     */
    void setHokenshano5(RString hokenshano5);

    /**
     * @return the hokenshano6
     */
    RString getHokenshano6();

    /**
     * @param hokenshano6 the hokenshano6 to set
     */
    void setHokenshano6(RString hokenshano6);

    /**
     * @return the kaigokbn
     */
    RString getKaigokbn();

    /**
     * @param kaigokbn the kaigokbn to set
     */
    void setKaigokbn(RString kaigokbn);

    /**
     * @return the ninteiymd
     */
    RString getNinteiymd();

    /**
     * @param ninteiymd the ninteiymd to set
     */
    void setNinteiymd(RString ninteiymd);

    /**
     * @return the yukokikanst
     */
    RString getYukokikanst();

    /**
     * @param yukokikanst the yukokikanst to set
     */
    void setYukokikanst(RString yukokikanst);

    /**
     * @return the yukokikaned
     */
    RString getYukokikaned();

    /**
     * @param yukokikaned the yukokikaned to set
     */
    void setYukokikaned(RString yukokikaned);

    /**
     * @return the homonkikanst
     */
    RString getHomonkikanst();

    /**
     * @param homonkikanst the homonkikanst to set
     */
    void setHomonkikanst(RString homonkikanst);

    /**
     * @return the homonkikaned
     */
    RString getHomonkikaned();

    /**
     * @param homonkikaned the homonkikaned to set
     */
    void setHomonkikaned(RString homonkikaned);

    /**
     * @return the service1
     */
    RString getService1();

    /**
     * @param service1 the service1 to set
     */
    void setService1(RString service1);

    /**
     * @return the ten0
     */
    RString getTen0();

    /**
     * @param ten0 the ten0 to set
     */
    void setTen0(RString ten0);

    /**
     * @return the shurui1
     */
    RString getShurui1();

    /**
     * @param shurui1 the shurui1 to set
     */
    void setShurui1(RString shurui1);

    /**
     * @return the shurui2
     */
    RString getShurui2();

    /**
     * @param shurui2 the shurui2 to set
     */
    void setShurui2(RString shurui2);

    /**
     * @return the shurui3
     */
    RString getShurui3();

    /**
     * @param shurui3 the shurui3 to set
     */
    void setShurui3(RString shurui3);

    /**
     * @return the shurui4
     */
    RString getShurui4();

    /**
     * @param shurui4 the shurui4 to set
     */
    void setShurui4(RString shurui4);

    /**
     * @return the shurui5
     */
    RString getShurui5();

    /**
     * @param shurui5 the shurui5 to set
     */
    void setShurui5(RString shurui5);

    /**
     * @return the shurui6
     */
    RString getShurui6();

    /**
     * @param shurui6 the shurui6 to set
     */
    void setShurui6(RString shurui6);

    /**
     * @return the shuruigendo1
     */
    RString getShuruigendo1();

    /**
     * @param shuruigendo1 the shuruigendo1 to set
     */
    void setShuruigendo1(RString shuruigendo1);

    /**
     * @return the shuruigendo2
     */
    RString getShuruigendo2();

    /**
     * @param shuruigendo2 the shuruigendo2 to set
     */
    void setShuruigendo2(RString shuruigendo2);

    /**
     * @return the shuruigendo3
     */
    RString getShuruigendo3();

    /**
     * @param shuruigendo3 the shuruigendo3 to set
     */
    void setShuruigendo3(RString shuruigendo3);

    /**
     * @return the shuruigendo4
     */
    RString getShuruigendo4();

    /**
     * @param shuruigendo4 the shuruigendo4 to set
     */
    void setShuruigendo4(RString shuruigendo4);

    /**
     * @return the shuruigendo5
     */
    RString getShuruigendo5();

    /**
     * @param shuruigendo5 the shuruigendo5 to set
     */
    void setShuruigendo5(RString shuruigendo5);

    /**
     * @return the shuruigendo6
     */
    RString getShuruigendo6();

    /**
     * @param shuruigendo6 the shuruigendo6 to set
     */
    void setShuruigendo6(RString shuruigendo6);

    /**
     * @return the ten1
     */
    RString getTen1();

    /**
     * @param ten1 the ten1 to set
     */
    void setTen1(RString ten1);

    /**
     * @return the ten2
     */
    RString getTen2();

    /**
     * @param ten2 the ten2 to set
     */
    void setTen2(RString ten2);

    /**
     * @return the ten3
     */
    RString getTen3();

    /**
     * @param ten3 the ten3 to set
     */
    void setTen3(RString ten3);

    /**
     * @return the ten4
     */
    RString getTen4();

    /**
     * @param ten4 the ten4 to set
     */
    void setTen4(RString ten4);

    /**
     * @return the ten5
     */
    RString getTen5();

    /**
     * @param ten5 the ten5 to set
     */
    void setTen5(RString ten5);

    /**
     * @return the ten6
     */
    RString getTen6();

    /**
     * @param ten6 the ten6 to set
     */
    void setTen6(RString ten6);

    /**
     * @return the ryui
     */
    RString getRyui();

    /**
     * @param ryui the ryui to set
     */
    void setRyui(RString ryui);

    /**
     * @return the seigen1
     */
    RString getSeigen1();

    /**
     * @param seigen1 the seigen1 to set
     */
    void setSeigen1(RString seigen1);

    /**
     * @return the seigenLong1
     */
    RString getSeigenLong1();

    /**
     * @param seigenLong1 the seigenLong1 to set
     */
    void setSeigenLong1(RString seigenLong1);

    /**
     * @return the seigen2
     */
    RString getSeigen2();

    /**
     * @param seigen2 the seigen2 to set
     */
    void setSeigen2(RString seigen2);

    /**
     * @return the seigenLong2
     */
    RString getSeigenLong2();

    /**
     * @param seigenLong2 the seigenLong2 to set
     */
    void setSeigenLong2(RString seigenLong2);

    /**
     * @return the seigen3
     */
    RString getSeigen3();

    /**
     * @param seigen3 the seigen3 to set
     */
    void setSeigen3(RString seigen3);

    /**
     * @return the seigenLong3
     */
    RString getSeigenLong3();

    /**
     * @param seigenLong3 the seigenLong3 to set
     */
    void setSeigenLong3(RString seigenLong3);

    /**
     * @return the seigen4
     */
    RString getSeigen4();

    /**
     * @param seigen4 the seigen4 to set
     */
    void setSeigen4(RString seigen4);

    /**
     * @return the seigenLong4
     */
    RString getSeigenLong4();

    /**
     * @param seigenLong4 the seigenLong4 to set
     */
    void setSeigenLong4(RString seigenLong4);

    /**
     * @return the seigen5
     */
    RString getSeigen5();

    /**
     * @param seigen5 the seigen5 to set
     */
    void setSeigen5(RString seigen5);

    /**
     * @return the seigenLong5
     */
    RString getSeigenLong5();

    /**
     * @param seigenLong5 the seigenLong5 to set
     */
    void setSeigenLong5(RString seigenLong5);

    /**
     * @return the seigen6
     */
    RString getSeigen6();

    /**
     * @param seigen6 the seigen6 to set
     */
    void setSeigen6(RString seigen6);

    /**
     * @return the seigenLong6
     */
    RString getSeigenLong6();

    /**
     * @param seigenLong6 the seigenLong6 to set
     */
    void setSeigenLong6(RString seigenLong6);

    /**
     * @return the seigenSt1
     */
    RString getSeigenSt1();

    /**
     * @param seigenSt1 the seigenSt1 to set
     */
    void setSeigenSt1(RString seigenSt1);

    /**
     * @return the seigenEd1
     */
    RString getSeigenEd1();

    /**
     * @param seigenEd1 the seigenEd1 to set
     */
    void setSeigenEd1(RString seigenEd1);

    /**
     * @return the seigenSt2
     */
    RString getSeigenSt2();

    /**
     * @param seigenSt2 the seigenSt2 to set
     */
    void setSeigenSt2(RString seigenSt2);

    /**
     * @return the seigenEd2
     */
    RString getSeigenEd2();

    /**
     * @param seigenEd2 the seigenEd2 to set
     */
    void setSeigenEd2(RString seigenEd2);

    /**
     * @return the seigenSt3
     */
    RString getSeigenSt3();

    /**
     * @param seigenSt3 the seigenSt3 to set
     */
    void setSeigenSt3(RString seigenSt3);

    /**
     * @return the seigenEd3
     */
    RString getSeigenEd3();

    /**
     * @param seigenEd3 the seigenEd3 to set
     */
    void setSeigenEd3(RString seigenEd3);

    /**
     * @return the gyosha1
     */
    RString getGyosha1();

    /**
     * @param gyosha1 the gyosha1 to set
     */
    void setGyosha1(RString gyosha1);

    /**
     * @return the todokeYmd1
     */
    RString getTodokeYmd1();

    /**
     * @param todokeYmd1 the todokeYmd1 to set
     */
    void setTodokeYmd1(RString todokeYmd1);

    /**
     * @return the gyosha2
     */
    RString getGyosha2();

    /**
     * @param gyosha2 the gyosha2 to set
     */
    void setGyosha2(RString gyosha2);

    /**
     * @return the gyosha2Asa
     */
    RString getGyosha2Asa();

    /**
     * @param gyosha2Asa the gyosha2Asa to set
     */
    void setGyosha2Asa(RString gyosha2Asa);

    /**
     * @return the gyosha2Massho
     */
    RString getGyosha2Massho();

    /**
     * @param gyosha2Massho the gyosha2Massho to set
     */
    void setGyosha2Massho(RString gyosha2Massho);

    /**
     * @return the todokeYmd2
     */
    RString getTodokeYmd2();

    /**
     * @param todokeYmd2 the todokeYmd2 to set
     */
    void setTodokeYmd2(RString todokeYmd2);

    /**
     * @return the todokeYmd2Asa
     */
    RString getTodokeYmd2Asa();

    /**
     * @param todokeYmd2Asa the todokeYmd2Asa to set
     */
    void setTodokeYmd2Asa(RString todokeYmd2Asa);

    /**
     * @return the todokeYmd2Massho
     */
    RString getTodokeYmd2Massho();

    /**
     * @param todokeYmd2Massho the todokeYmd2Massho to set
     */
    void setTodokeYmd2Massho(RString todokeYmd2Massho);

    /**
     * @return the gyosha3
     */
    RString getGyosha3();

    /**
     * @param gyosha3 the gyosha3 to set
     */
    void setGyosha3(RString gyosha3);

    /**
     * @return the gyosha3Asa
     */
    RString getGyosha3Asa();

    /**
     * @param gyosha3Asa the gyosha3Asa to set
     */
    void setGyosha3Asa(RString gyosha3Asa);

    /**
     * @return the gyosha3Massho
     */
    RString getGyosha3Massho();

    /**
     * @param gyosha3Massho the gyosha3Massho to set
     */
    void setGyosha3Massho(RString gyosha3Massho);

    /**
     * @return the todokeYmd3
     */
    RString getTodokeYmd3();

    /**
     * @param todokeYmd3 the todokeYmd3 to set
     */
    void setTodokeYmd3(RString todokeYmd3);

    /**
     * @return the todokeYmd3Asa
     */
    RString getTodokeYmd3Asa();

    /**
     * @param todokeYmd3Asa the todokeYmd3Asa to set
     */
    void setTodokeYmd3Asa(RString todokeYmd3Asa);

    /**
     * @return the todokeYmd3Massho
     */
    RString getTodokeYmd3Massho();

    /**
     * @param todokeYmd3Massho the todokeYmd3Massho to set
     */
    void setTodokeYmd3Massho(RString todokeYmd3Massho);

    /**
     * @return the shisetsuSyu1
     */
    RString getShisetsuSyu1();

    /**
     * @param shisetsuSyu1 the shisetsuSyu1 to set
     */
    void setShisetsuSyu1(RString shisetsuSyu1);

    /**
     * @return the shisetsuname1
     */
    RString getShisetsuname1();

    /**
     * @param shisetsuname1 the shisetsuname1 to set
     */
    void setShisetsuname1(RString shisetsuname1);

    /**
     * @return the nyushochk1
     */
    RString getNyushochk1();

    /**
     * @param nyushochk1 the nyushochk1 to set
     */
    void setNyushochk1(RString nyushochk1);

    /**
     * @return the nyuinchk1
     */
    RString getNyuinchk1();

    /**
     * @param nyuinchk1 the nyuinchk1 to set
     */
    void setNyuinchk1(RString nyuinchk1);

    /**
     * @return the taishochk1
     */
    RString getTaishochk1();

    /**
     * @param taishochk1 the taishochk1 to set
     */
    void setTaishochk1(RString taishochk1);

    /**
     * @return the taiinchk1
     */
    RString getTaiinchk1();

    /**
     * @param taiinchk1 the taiinchk1 to set
     */
    void setTaiinchk1(RString taiinchk1);

    /**
     * @return the nyushoymd1
     */
    RString getNyushoymd1();

    /**
     * @param nyushoymd1 the nyushoymd1 to set
     */
    void setNyushoymd1(RString nyushoymd1);

    /**
     * @return the taiinymd1
     */
    RString getTaishoymd1();

    /**
     * @param taiinymd1 the taiinymd1 to set
     */
    void setTaiinymd1(RString taiinymd1);

    /**
     * @return the shisetsuSyu2
     */
    RString getShisetsuSyu2();

    /**
     * @param shisetsuSyu2 the shisetsuSyu2 to set
     */
    void setShisetsuSyu2(RString shisetsuSyu2);

    /**
     * @return the shisetsuname2
     */
    RString getShisetsuname2();

    /**
     * @param shisetsuname2 the shisetsuname2 to set
     */
    void setShisetsuname2(RString shisetsuname2);

    /**
     * @return the nyushochk2
     */
    RString getNyushochk2();

    /**
     * @param nyushochk2 the nyushochk2 to set
     */
    void setNyushochk2(RString nyushochk2);

    /**
     * @return the nyuinchk2
     */
    RString getNyuinchk2();

    /**
     * @param nyuinchk2 the nyuinchk2 to set
     */
    void setNyuinchk2(RString nyuinchk2);

    /**
     * @return the taishochk2
     */
    RString getTaishochk2();

    /**
     * @param taishochk2 the taishochk2 to set
     */
    void setTaishochk2(RString taishochk2);

    /**
     * @return the taiinchk2
     */
    RString getTaiinchk2();

    /**
     * @param taiinchk2 the taiinchk2 to set
     */
    void setTaiinchk2(RString taiinchk2);

    /**
     * @return the nyushoymd2
     */
    RString getNyushoymd2();

    /**
     * @param nyushoymd2 the nyushoymd2 to set
     */
    void setNyushoymd2(RString nyushoymd2);

    /**
     * @return the taiinymd2
     */
    RString getTaishoymd2();

    /**
     * @param taiinymd2 the taiinymd2 to set
     */
    void setTaiinymd2(RString taiinymd2);

    /**
     * @return the renban
     */
    RString getRenban();

    /**
     * @param renban the renban to set
     */
    void setRenban(RString renban);

    /**
     * @return the seiShogai1
     */
    RString getSeiShogai1();

    /**
     * @param seiShogai1 the seiShogai1 to set
     */
    void setSeiShogai1(RString seiShogai1);

    /**
     * @return the seiShogai2
     */
    RString getSeiShogai2();

    /**
     * @param seiShogai2 the seiShogai2 to set
     */
    void setSeiShogai2(RString seiShogai2);

    /**
     * @return the kosekiSeibetsu1
     */
    RString getKosekiSeibetsu1();

    /**
     * @param kosekiSeibetsu1 the kosekiSeibetsu1 to set
     */
    void setKosekiSeibetsu1(RString kosekiSeibetsu1);

    /**
     * @return the kosekiSeibetsu2
     */
    RString getKosekiSeibetsu2();

    /**
     * @param kosekiSeibetsu2 the kosekiSeibetsu2 to set
     */
    void setKosekiSeibetsu2(RString kosekiSeibetsu2);

    /**
     * @return the itakuGyosha1
     */
    RString getItakuGyosha1();

    /**
     * @param itakuGyosha1 the itakuGyosha1 to set
     */
    void setItakuGyosha1(RString itakuGyosha1);

    /**
     * @return the itakuGyosha2
     */
    RString getItakuGyosha2();

    /**
     * @param itakuGyosha2 the itakuGyosha2 to set
     */
    void setItakuGyosha2(RString itakuGyosha2);

    /**
     * @return the itakuGyosha2Asa
     */
    RString getItakuGyosha2Asa();

    /**
     * @param itakuGyosha2Asa the itakuGyosha2Asa to set
     */
    void setItakuGyosha2Asa(RString itakuGyosha2Asa);

    /**
     * @return the itakuGyosha2Massho
     */
    RString getItakuGyosha2Massho();

    /**
     * @param itakuGyosha2Massho the itakuGyosha2Massho to set
     */
    void setItakuGyosha2Massho(RString itakuGyosha2Massho);

    /**
     * @return the itakuGyosha3
     */
    RString getItakuGyosha3();

    /**
     * @param itakuGyosha3 the itakuGyosha3 to set
     */
    void setItakuGyosha3(RString itakuGyosha3);

    /**
     * @return the itakuGyosha3Asa
     */
    RString getItakuGyosha3Asa();

    /**
     * @param itakuGyosha3Asa the itakuGyosha3Asa to set
     */
    void setItakuGyosha3Asa(RString itakuGyosha3Asa);

    /**
     * @return the itakuGyosha3Massho
     */
    RString getItakuGyosha3Massho();

    /**
     * @param itakuGyosha3Massho the itakuGyosha3Massho to set
     */
    void setItakuGyosha3Massho(RString itakuGyosha3Massho);
}
