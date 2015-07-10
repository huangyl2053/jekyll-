/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.report.DBA10000X;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.business.report.parts.tsuchishoatesaki.TsuchishoAtesakiSource;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証A4版の帳票ソースが持つ情報を取得・設定する際に使用するクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoA4EditData implements IHihokenshashoA4CommonEditData {

    private final HihokenshashoA4 hihokenshasho;

    /**
     * コンストラクタです。
     *
     * @param hihokenshasho 被保険者証A4版の帳票ソース
     */
    public HihokenshashoA4EditData(HihokenshashoA4 hihokenshasho) {
        requireNonNull(hihokenshasho, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証B4版帳票ソース", getClass().getName()));
        this.hihokenshasho = hihokenshasho;
    }

    @Override
    public HihokenshashoA4 getEditData() {
        return hihokenshasho;
    }

    @Override
    public RString getYukokigen() {
        return hihokenshasho.yukokigen;
    }

    @Override
    public void setYukokigen(RString yukokigen) {
        this.hihokenshasho.yukokigen = yukokigen;
    }

    @Override
    public RString getYukokigen2() {
        return hihokenshasho.yukokigen2;
    }

    @Override
    public void setYukokigen2(RString yukokigen2) {
        this.hihokenshasho.yukokigen2 = yukokigen2;
    }

    @Override
    public RString getHihokenshanno() {
        return hihokenshasho.hihokenshanno;
    }

    @Override
    public void setHihokenshanno(RString hihokenshanno) {
        this.hihokenshasho.hihokenshanno = hihokenshanno;
    }

    @Override
    public RString getYubinno() {
        return hihokenshasho.yubinno;
    }

    @Override
    public void setYubinno(RString yubinno) {
        this.hihokenshasho.yubinno = yubinno;
    }

    @Override
    public RString getGyoseiku() {
        return hihokenshasho.gyoseiku;
    }

    @Override
    public void setGyoseiku(RString gyoseiku) {
        this.hihokenshasho.gyoseiku = gyoseiku;
    }

    @Override
    public RString getGyoseikuS() {
        return hihokenshasho.gyoseikuS;
    }

    @Override
    public void setGyoseikuS(RString gyoseikuS) {
        this.hihokenshasho.gyoseikuS = gyoseikuS;
    }

    @Override
    public RString getHihojusho() {
        return hihokenshasho.hihojusho;
    }

    @Override
    public void setHihojusho(RString hihojusho) {
        this.hihokenshasho.hihojusho = hihojusho;
    }

    @Override
    public RString getHihokana() {
        return hihokenshasho.hihokana;
    }

    @Override
    public void setHihokana(RString hihokana) {
        this.hihokenshasho.hihokana = hihokana;
    }

    @Override
    public RString getHihoname() {
        return hihokenshasho.hihoname;
    }

    @Override
    public void setHihoname(RString hihoname) {
        this.hihokenshasho.hihoname = hihoname;
    }

    @Override
    public RString getUmareG() {
        return hihokenshasho.umareG;
    }

    @Override
    public void setUmareG(RString umareG) {
        this.hihokenshasho.umareG = umareG;
    }

    @Override
    public RString getUmareYyyy() {
        return hihokenshasho.umareYyyy;
    }

    @Override
    public void setUmareYyyy(RString umareYyyy) {
        this.hihokenshasho.umareYyyy = umareYyyy;
    }

    @Override
    public RString getUmareYy() {
        return hihokenshasho.umareYy;
    }

    @Override
    public void setUmareYy(RString umareYy) {
        this.hihokenshasho.umareYy = umareYy;
    }

    @Override
    public RString getUmareMm() {
        return hihokenshasho.umareMm;
    }

    @Override
    public void setUmareMm(RString umareMm) {
        this.hihokenshasho.umareMm = umareMm;
    }

    @Override
    public RString getUmareDd() {
        return hihokenshasho.umareDd;
    }

    @Override
    public void setUmareDd(RString umareDd) {
        this.hihokenshasho.umareDd = umareDd;
    }

    @Override
    public RString getSeibetsu() {
        return hihokenshasho.seibetsu;
    }

    @Override
    public void setSeibetsu(RString seibetsu) {
        this.hihokenshasho.seibetsu = seibetsu;
    }

    @Override
    public RString getKofuymdGengo() {
        return hihokenshasho.kofuymdGengo;
    }

    @Override
    public void setKofuymdGengo(RString kofuymdGengo) {
        this.hihokenshasho.kofuymdGengo = kofuymdGengo;
    }

    @Override
    public RString getKofuymdYy() {
        return hihokenshasho.kofuymdYy;
    }

    @Override
    public void setKofuymdYy(RString kofuymdYy) {
        this.hihokenshasho.kofuymdYy = kofuymdYy;
    }

    @Override
    public RString getKofuymdMm() {
        return hihokenshasho.kofuymdMm;
    }

    @Override
    public void setKofuymdMm(RString kofuymdMm) {
        this.hihokenshasho.kofuymdMm = kofuymdMm;
    }

    @Override
    public RString getKofuymdDd() {
        return hihokenshasho.kofuymdDd;
    }

    @Override
    public void setKofuymdDd(RString kofuymdDd) {
        this.hihokenshasho.kofuymdDd = kofuymdDd;
    }

    @Override
    public RString getSaikofu1() {
        return hihokenshasho.saikofu1;
    }

    @Override
    public void setSaikofu1(RString saikofu1) {
        this.hihokenshasho.saikofu1 = saikofu1;
    }

    @Override
    public RString getSaikofu2() {
        return hihokenshasho.saikofu2;
    }

    @Override
    public void setSaikofu2(RString saikofu2) {
        this.hihokenshasho.saikofu2 = saikofu2;
    }

    @Override
    public RString getHokenshano1() {
        return hihokenshasho.hokenshano1;
    }

    @Override
    public void setHokenshano1(RString hokenshano1) {
        this.hihokenshasho.hokenshano1 = hokenshano1;
    }

    @Override
    public RString getHokenshano2() {
        return hihokenshasho.hokenshano2;
    }

    @Override
    public void setHokenshano2(RString hokenshano2) {
        this.hihokenshasho.hokenshano2 = hokenshano2;
    }

    @Override
    public RString getHokenshano3() {
        return hihokenshasho.hokenshano3;
    }

    @Override
    public void setHokenshano3(RString hokenshano3) {
        this.hihokenshasho.hokenshano3 = hokenshano3;
    }

    @Override
    public RString getHokenshano4() {
        return hihokenshasho.hokenshano4;
    }

    @Override
    public void setHokenshano4(RString hokenshano4) {
        this.hihokenshasho.hokenshano4 = hokenshano4;
    }

    @Override
    public RString getHokenshano5() {
        return hihokenshasho.hokenshano5;
    }

    @Override
    public void setHokenshano5(RString hokenshano5) {
        this.hihokenshasho.hokenshano5 = hokenshano5;
    }

    @Override
    public RString getHokenshano6() {
        return hihokenshasho.hokenshano6;
    }

    @Override
    public void setHokenshano6(RString hokenshano6) {
        this.hihokenshasho.hokenshano6 = hokenshano6;
    }

    @Override
    public RString getKaigokbn() {
        return hihokenshasho.kaigokbn;
    }

    @Override
    public void setKaigokbn(RString kaigokbn) {
        this.hihokenshasho.kaigokbn = kaigokbn;
    }

    @Override
    public RString getNinteiymd() {
        return hihokenshasho.ninteiymd;
    }

    @Override
    public void setNinteiymd(RString ninteiymd) {
        this.hihokenshasho.ninteiymd = ninteiymd;
    }

    @Override
    public RString getYukokikanst() {
        return hihokenshasho.yukokikanst;
    }

    @Override
    public void setYukokikanst(RString yukokikanst) {
        this.hihokenshasho.yukokikanst = yukokikanst;
    }

    @Override
    public RString getYukokikannamisen() {
        return hihokenshasho.yukokikannamisen;
    }

    @Override
    public void setYukokikannamisen(RString yukokikannamisen) {
        this.hihokenshasho.yukokikannamisen = yukokikannamisen;
    }

    @Override
    public RString getYukokikaned() {
        return hihokenshasho.yukokikaned;
    }

    @Override
    public void setYukokikaned(RString yukokikaned) {
        this.hihokenshasho.yukokikaned = yukokikaned;
    }

    @Override
    public RString getHomonkikanst() {
        return hihokenshasho.homonkikanst;
    }

    @Override
    public void setHomonkikanst(RString homonkikanst) {
        this.hihokenshasho.homonkikanst = homonkikanst;
    }

    @Override
    public RString getHomonkikannamisen() {
        return hihokenshasho.homonkikannamisen;
    }

    @Override
    public void setHomonkikannamisen(RString homonkikannamisen) {
        this.hihokenshasho.homonkikannamisen = homonkikannamisen;
    }

    @Override
    public RString getHomonkikaned() {
        return hihokenshasho.homonkikaned;
    }

    @Override
    public void setHomonkikaned(RString homonkikaned) {
        this.hihokenshasho.homonkikaned = homonkikaned;
    }

    @Override
    public RString getService1() {
        return hihokenshasho.service1;
    }

    @Override
    public void setService1(RString service1) {
        this.hihokenshasho.service1 = service1;
    }

    @Override
    public RString getTen0() {
        return hihokenshasho.ten0;
    }

    @Override
    public void setTen0(RString ten0) {
        this.hihokenshasho.ten0 = ten0;
    }

    @Override
    public RString getShurui1() {
        return hihokenshasho.shurui1;
    }

    @Override
    public void setShurui1(RString shurui1) {
        this.hihokenshasho.shurui1 = shurui1;
    }

    @Override
    public RString getShurui2() {
        return hihokenshasho.shurui2;
    }

    @Override
    public void setShurui2(RString shurui2) {
        this.hihokenshasho.shurui2 = shurui2;
    }

    @Override
    public RString getShurui3() {
        return hihokenshasho.shurui3;
    }

    @Override
    public void setShurui3(RString shurui3) {
        this.hihokenshasho.shurui3 = shurui3;
    }

    @Override
    public RString getShurui4() {
        return hihokenshasho.shurui4;
    }

    @Override
    public void setShurui4(RString shurui4) {
        this.hihokenshasho.shurui4 = shurui4;
    }

    @Override
    public RString getShurui5() {
        return hihokenshasho.shurui5;
    }

    @Override
    public void setShurui5(RString shurui5) {
        this.hihokenshasho.shurui5 = shurui5;
    }

    @Override
    public RString getShurui6() {
        return hihokenshasho.shurui6;
    }

    @Override
    public void setShurui6(RString shurui6) {
        this.hihokenshasho.shurui6 = shurui6;
    }

    @Override
    public RString getShuruigendo1() {
        return hihokenshasho.shuruigendo1;
    }

    @Override
    public void setShuruigendo1(RString shuruigendo1) {
        this.hihokenshasho.shuruigendo1 = shuruigendo1;
    }

    @Override
    public RString getShuruigendo2() {
        return hihokenshasho.shuruigendo2;
    }

    @Override
    public void setShuruigendo2(RString shuruigendo2) {
        this.hihokenshasho.shuruigendo2 = shuruigendo2;
    }

    @Override
    public RString getShuruigendo3() {
        return hihokenshasho.shuruigendo3;
    }

    @Override
    public void setShuruigendo3(RString shuruigendo3) {
        this.hihokenshasho.shuruigendo3 = shuruigendo3;
    }

    @Override
    public RString getShuruigendo4() {
        return hihokenshasho.shuruigendo4;
    }

    @Override
    public void setShuruigendo4(RString shuruigendo4) {
        this.hihokenshasho.shuruigendo4 = shuruigendo4;
    }

    @Override
    public RString getShuruigendo5() {
        return hihokenshasho.shuruigendo5;
    }

    @Override
    public void setShuruigendo5(RString shuruigendo5) {
        this.hihokenshasho.shuruigendo5 = shuruigendo5;
    }

    @Override
    public RString getShuruigendo6() {
        return hihokenshasho.shuruigendo6;
    }

    @Override
    public void setShuruigendo6(RString shuruigendo6) {
        this.hihokenshasho.shuruigendo6 = shuruigendo6;
    }

    @Override
    public RString getTen1() {
        return hihokenshasho.ten1;
    }

    @Override
    public void setTen1(RString ten1) {
        this.hihokenshasho.ten1 = ten1;
    }

    @Override
    public RString getTen2() {
        return hihokenshasho.ten2;
    }

    @Override
    public void setTen2(RString ten2) {
        this.hihokenshasho.ten2 = ten2;
    }

    @Override
    public RString getTen3() {
        return hihokenshasho.ten3;
    }

    @Override
    public void setTen3(RString ten3) {
        this.hihokenshasho.ten3 = ten3;
    }

    @Override
    public RString getTen4() {
        return hihokenshasho.ten4;
    }

    @Override
    public void setTen4(RString ten4) {
        this.hihokenshasho.ten4 = ten4;
    }

    @Override
    public RString getTen5() {
        return hihokenshasho.ten5;
    }

    @Override
    public void setTen5(RString ten5) {
        this.hihokenshasho.ten5 = ten5;
    }

    @Override
    public RString getTen6() {
        return hihokenshasho.ten6;
    }

    @Override
    public void setTen6(RString ten6) {
        this.hihokenshasho.ten6 = ten6;
    }

    @Override
    public RString getRyui() {
        return hihokenshasho.ryui;
    }

    @Override
    public void setRyui(RString ryui) {
        this.hihokenshasho.ryui = ryui;
    }

    @Override
    public RString getSeigen1() {
        return hihokenshasho.seigen1;
    }

    @Override
    public void setSeigen1(RString seigen1) {
        this.hihokenshasho.seigen1 = seigen1;
    }

    @Override
    public RString getSeigenLong1() {
        return hihokenshasho.seigenLong1;
    }

    @Override
    public void setSeigenLong1(RString seigenLong1) {
        this.hihokenshasho.seigenLong1 = seigenLong1;
    }

    @Override
    public RString getSeigen2() {
        return hihokenshasho.seigen2;
    }

    @Override
    public void setSeigen2(RString seigen2) {
        this.hihokenshasho.seigen2 = seigen2;
    }

    @Override
    public RString getSeigenLong2() {
        return hihokenshasho.seigenLong2;
    }

    @Override
    public void setSeigenLong2(RString seigenLong2) {
        this.hihokenshasho.seigenLong2 = seigenLong2;
    }

    @Override
    public RString getSeigen3() {
        return hihokenshasho.seigen3;
    }

    @Override
    public void setSeigen3(RString seigen3) {
        this.hihokenshasho.seigen3 = seigen3;
    }

    @Override
    public RString getSeigenLong3() {
        return hihokenshasho.seigenLong3;
    }

    @Override
    public void setSeigenLong3(RString seigenLong3) {
        this.hihokenshasho.seigenLong3 = seigenLong3;
    }

    @Override
    public RString getSeigen4() {
        return hihokenshasho.seigen4;
    }

    @Override
    public void setSeigen4(RString seigen4) {
        this.hihokenshasho.seigen4 = seigen4;
    }

    @Override
    public RString getSeigenLong4() {
        return hihokenshasho.seigenLong4;
    }

    @Override
    public void setSeigenLong4(RString seigenLong4) {
        this.hihokenshasho.seigenLong4 = seigenLong4;
    }

    @Override
    public RString getSeigen5() {
        return hihokenshasho.seigen5;
    }

    @Override
    public void setSeigen5(RString seigen5) {
        this.hihokenshasho.seigen5 = seigen5;
    }

    @Override
    public RString getSeigenLong5() {
        return hihokenshasho.seigenLong5;
    }

    @Override
    public void setSeigenLong5(RString seigenLong5) {
        this.hihokenshasho.seigenLong5 = seigenLong5;
    }

    @Override
    public RString getSeigen6() {
        return hihokenshasho.seigen6;
    }

    @Override
    public void setSeigen6(RString seigen6) {
        this.hihokenshasho.seigen6 = seigen6;
    }

    @Override
    public RString getSeigenLong6() {
        return hihokenshasho.seigenLong6;
    }

    @Override
    public void setSeigenLong6(RString seigenLong6) {
        this.hihokenshasho.seigenLong6 = seigenLong6;
    }

    @Override
    public RString getSeigenSt1() {
        return hihokenshasho.seigenSt1;
    }

    @Override
    public void setSeigenSt1(RString seigenSt1) {
        this.hihokenshasho.seigenSt1 = seigenSt1;
    }

    @Override
    public RString getSeigenEd1() {
        return hihokenshasho.seigenEd1;
    }

    @Override
    public void setSeigenEd1(RString seigenEd1) {
        this.hihokenshasho.seigenEd1 = seigenEd1;
    }

    @Override
    public RString getSeigenSt2() {
        return hihokenshasho.seigenSt2;
    }

    @Override
    public void setSeigenSt2(RString seigenSt2) {
        this.hihokenshasho.seigenSt2 = seigenSt2;
    }

    @Override
    public RString getSeigenEd2() {
        return hihokenshasho.seigenEd2;
    }

    @Override
    public void setSeigenEd2(RString seigenEd2) {
        this.hihokenshasho.seigenEd2 = seigenEd2;
    }

    @Override
    public RString getSeigenSt3() {
        return hihokenshasho.seigenSt3;
    }

    @Override
    public void setSeigenSt3(RString seigenSt3) {
        this.hihokenshasho.seigenSt3 = seigenSt3;
    }

    @Override
    public RString getSeigenEd3() {
        return hihokenshasho.seigenEd3;
    }

    @Override
    public void setSeigenEd3(RString seigenEd3) {
        this.hihokenshasho.seigenEd3 = seigenEd3;
    }

    @Override
    public RString getGyosha1() {
        return hihokenshasho.gyosha1;
    }

    @Override
    public void setGyosha1(RString gyosha1) {
        this.hihokenshasho.gyosha1 = gyosha1;
    }

    @Override
    public RString getTodokeYmd1() {
        return hihokenshasho.todokeYmd1;
    }

    @Override
    public void setTodokeYmd1(RString todokeYmd1) {
        this.hihokenshasho.todokeYmd1 = todokeYmd1;
    }

    @Override
    public RString getGyosha2() {
        return hihokenshasho.gyosha2;
    }

    @Override
    public void setGyosha2(RString gyosha2) {
        this.hihokenshasho.gyosha2 = gyosha2;
    }

    @Override
    public RString getGyosha2Asa() {
        return hihokenshasho.gyosha2Asa;
    }

    @Override
    public void setGyosha2Asa(RString gyosha2Asa) {
        this.hihokenshasho.gyosha2Asa = gyosha2Asa;
    }

    @Override
    public RString getGyosha2Massho() {
        return hihokenshasho.gyosha2Massho;
    }

    @Override
    public void setGyosha2Massho(RString gyosha2Massho) {
        this.hihokenshasho.gyosha2Massho = gyosha2Massho;
    }

    @Override
    public RString getTodokeYmd2() {
        return hihokenshasho.todokeYmd2;
    }

    @Override
    public void setTodokeYmd2(RString todokeYmd2) {
        this.hihokenshasho.todokeYmd2 = todokeYmd2;
    }

    @Override
    public RString getTodokeYmd2Asa() {
        return hihokenshasho.todokeYmd2Asa;
    }

    @Override
    public void setTodokeYmd2Asa(RString todokeYmd2Asa) {
        this.hihokenshasho.todokeYmd2Asa = todokeYmd2Asa;
    }

    @Override
    public RString getTodokeYmd2Massho() {
        return hihokenshasho.todokeYmd2Massho;
    }

    @Override
    public void setTodokeYmd2Massho(RString todokeYmd2Massho) {
        this.hihokenshasho.todokeYmd2Massho = todokeYmd2Massho;
    }

    @Override
    public RString getGyosha3() {
        return hihokenshasho.gyosha3;
    }

    @Override
    public void setGyosha3(RString gyosha3) {
        this.hihokenshasho.gyosha3 = gyosha3;
    }

    @Override
    public RString getGyosha3Asa() {
        return hihokenshasho.gyosha3Asa;
    }

    @Override
    public void setGyosha3Asa(RString gyosha3Asa) {
        this.hihokenshasho.gyosha3Asa = gyosha3Asa;
    }

    @Override
    public RString getGyosha3Massho() {
        return hihokenshasho.gyosha3Massho;
    }

    @Override
    public void setGyosha3Massho(RString gyosha3Massho) {
        this.hihokenshasho.gyosha3Massho = gyosha3Massho;
    }

    @Override
    public RString getTodokeYmd3() {
        return hihokenshasho.todokeYmd3;
    }

    @Override
    public void setTodokeYmd3(RString todokeYmd3) {
        this.hihokenshasho.todokeYmd3 = todokeYmd3;
    }

    @Override
    public RString getTodokeYmd3Asa() {
        return hihokenshasho.todokeYmd3Asa;
    }

    @Override
    public void setTodokeYmd3Asa(RString todokeYmd3Asa) {
        this.hihokenshasho.todokeYmd3Asa = todokeYmd3Asa;
    }

    @Override
    public RString getTodokeYmd3Massho() {
        return hihokenshasho.todokeYmd3Massho;
    }

    @Override
    public void setTodokeYmd3Massho(RString todokeYmd3Massho) {
        this.hihokenshasho.todokeYmd3Massho = todokeYmd3Massho;
    }

    @Override
    public RString getShisetsuSyu1() {
        return hihokenshasho.shisetsuSyu1;
    }

    @Override
    public void setShisetsuSyu1(RString shisetsuSyu1) {
        this.hihokenshasho.shisetsuSyu1 = shisetsuSyu1;
    }

    @Override
    public RString getShisetsuname1() {
        return hihokenshasho.shisetsuname1;
    }

    @Override
    public void setShisetsuname1(RString shisetsuname1) {
        this.hihokenshasho.shisetsuname1 = shisetsuname1;
    }

    @Override
    public RString getNyushochk1() {
        return hihokenshasho.nyushochk1;
    }

    @Override
    public void setNyushochk1(RString nyushochk1) {
        this.hihokenshasho.nyushochk1 = nyushochk1;
    }

    @Override
    public RString getNyuinchk1() {
        return hihokenshasho.nyuinchk1;
    }

    @Override
    public void setNyuinchk1(RString nyuinchk1) {
        this.hihokenshasho.nyuinchk1 = nyuinchk1;
    }

    @Override
    public RString getTaishochk1() {
        return hihokenshasho.taishochk1;
    }

    @Override
    public void setTaishochk1(RString taishochk1) {
        this.hihokenshasho.taishochk1 = taishochk1;
    }

    @Override
    public RString getTaiinchk1() {
        return hihokenshasho.taiinchk1;
    }

    @Override
    public void setTaiinchk1(RString taiinchk1) {
        this.hihokenshasho.taiinchk1 = taiinchk1;
    }

    @Override
    public RString getNyushoymd1() {
        return hihokenshasho.nyushoymd1;
    }

    @Override
    public void setNyushoymd1(RString nyushoymd1) {
        this.hihokenshasho.nyushoymd1 = nyushoymd1;
    }

    @Override
    public RString getTaishoymd1() {
        return hihokenshasho.taiinymd1;
    }

    @Override
    public void setTaiinymd1(RString taiinymd1) {
        this.hihokenshasho.taiinymd1 = taiinymd1;
    }

    @Override
    public RString getShisetsuSyu2() {
        return hihokenshasho.shisetsuSyu2;
    }

    @Override
    public void setShisetsuSyu2(RString shisetsuSyu2) {
        this.hihokenshasho.shisetsuSyu2 = shisetsuSyu2;
    }

    @Override
    public RString getShisetsuname2() {
        return hihokenshasho.shisetsuname2;
    }

    @Override
    public void setShisetsuname2(RString shisetsuname2) {
        this.hihokenshasho.shisetsuname2 = shisetsuname2;
    }

    @Override
    public RString getNyushochk2() {
        return hihokenshasho.nyushochk2;
    }

    @Override
    public void setNyushochk2(RString nyushochk2) {
        this.hihokenshasho.nyushochk2 = nyushochk2;
    }

    @Override
    public RString getNyuinchk2() {
        return hihokenshasho.nyuinchk2;
    }

    @Override
    public void setNyuinchk2(RString nyuinchk2) {
        this.hihokenshasho.nyuinchk2 = nyuinchk2;
    }

    @Override
    public RString getTaishochk2() {
        return hihokenshasho.taishochk2;
    }

    @Override
    public void setTaishochk2(RString taishochk2) {
        this.hihokenshasho.taishochk2 = taishochk2;
    }

    @Override
    public RString getTaiinchk2() {
        return hihokenshasho.taiinchk2;
    }

    @Override
    public void setTaiinchk2(RString taiinchk2) {
        this.hihokenshasho.taiinchk2 = taiinchk2;
    }

    @Override
    public RString getNyushoymd2() {
        return hihokenshasho.nyushoymd2;
    }

    @Override
    public void setNyushoymd2(RString nyushoymd2) {
        this.hihokenshasho.nyushoymd2 = nyushoymd2;
    }

    @Override
    public RString getTaishoymd2() {
        return hihokenshasho.taiinymd2;
    }

    @Override
    public void setTaiinymd2(RString taiinymd2) {
        this.hihokenshasho.taiinymd2 = taiinymd2;
    }

    @Override
    public RString getRenban() {
        return hihokenshasho.renban;
    }

    @Override
    public void setRenban(RString renban) {
        this.hihokenshasho.renban = renban;
    }

    @Override
    public RString getSeiShogai1() {
        return hihokenshasho.seiShogai11;
    }

    @Override
    public void setSeiShogai1(RString seiShogai1) {
        this.hihokenshasho.seiShogai11 = seiShogai1;
    }

    @Override
    public RString getSeiShogai2() {
        return hihokenshasho.seiShogai12;
    }

    @Override
    public void setSeiShogai2(RString seiShogai2) {
        this.hihokenshasho.seiShogai12 = seiShogai2;
    }

    @Override
    public RString getKosekiSeibetsu1() {
        return hihokenshasho.kosekiSeibetsu11;
    }

    @Override
    public void setKosekiSeibetsu1(RString kosekiSeibetsu1) {
        this.hihokenshasho.kosekiSeibetsu11 = kosekiSeibetsu1;
    }

    @Override
    public RString getKosekiSeibetsu2() {
        return hihokenshasho.kosekiSeibetsu12;
    }

    @Override
    public void setKosekiSeibetsu2(RString kosekiSeibetsu2) {
        this.hihokenshasho.kosekiSeibetsu12 = kosekiSeibetsu2;
    }

    @Override
    public RString getItakuGyosha1() {
        return hihokenshasho.itakuGyosha1;
    }

    @Override
    public void setItakuGyosha1(RString itakuGyosha1) {
        this.hihokenshasho.itakuGyosha1 = itakuGyosha1;
    }

    @Override
    public RString getItakuGyosha2() {
        return hihokenshasho.itakuGyosha2;
    }

    @Override
    public void setItakuGyosha2(RString itakuGyosha2) {
        this.hihokenshasho.itakuGyosha2 = itakuGyosha2;
    }

    @Override
    public RString getItakuGyosha2Asa() {
        return hihokenshasho.itakuGyosha2Asa;
    }

    @Override
    public void setItakuGyosha2Asa(RString itakuGyosha2Asa) {
        this.hihokenshasho.itakuGyosha2Asa = itakuGyosha2Asa;
    }

    @Override
    public RString getItakuGyosha2Massho() {
        return hihokenshasho.itakuGyosha2Massho;
    }

    @Override
    public void setItakuGyosha2Massho(RString itakuGyosha2Massho) {
        this.hihokenshasho.itakuGyosha2Massho = itakuGyosha2Massho;
    }

    @Override
    public RString getItakuGyosha3() {
        return hihokenshasho.itakuGyosha3;
    }

    @Override
    public void setItakuGyosha3(RString itakuGyosha3) {
        this.hihokenshasho.itakuGyosha3 = itakuGyosha3;
    }

    @Override
    public RString getItakuGyosha3Asa() {
        return hihokenshasho.itakuGyosha3Asa;
    }

    @Override
    public void setItakuGyosha3Asa(RString itakuGyosha3Asa) {
        this.hihokenshasho.itakuGyosha3Asa = itakuGyosha3Asa;
    }

    @Override
    public RString getItakuGyosha3Massho() {
        return hihokenshasho.itakuGyosha3Massho;
    }

    @Override
    public void setItakuGyosha3Massho(RString itakuGyosha3Massho) {
        this.hihokenshasho.itakuGyosha3Massho = itakuGyosha3Massho;
    }

    @Override
    public void setTsuchishoSofusakiSource(TsuchishoAtesakiSource tsuchishoSofusakiSource) {
        this.hihokenshasho.sofusakiAtena = tsuchishoSofusakiSource;
    }
}
