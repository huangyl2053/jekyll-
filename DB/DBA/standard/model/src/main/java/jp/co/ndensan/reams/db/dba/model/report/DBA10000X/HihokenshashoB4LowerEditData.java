/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.model.report.DBA10000X;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証B4版の帳票ソースが持つ、帳票の上部に印字される情報について取得・設定する際に使用するクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoB4LowerEditData implements IHihokenshashoB4CommonEditData {

    private final HihokenshashoB4 hihokenshasho;

    /**
     * コンストラクタです。
     *
     * @param hihokenshasho 被保険者証A4版の帳票ソース
     */
    public HihokenshashoB4LowerEditData(HihokenshashoB4 hihokenshasho) {
        this.hihokenshasho = hihokenshasho;
    }

    @Override
    public HihokenshashoB4 getEditData() {
        return this.hihokenshasho;
    }

    @Override
    public RString getYukokigen() {
        return hihokenshasho.yukokigen2;
    }

    @Override
    public void setYukokigen(RString yukokigen) {
        this.hihokenshasho.yukokigen2 = yukokigen;
    }

    @Override
    public RString getYukokigen2() {
        return hihokenshasho.yukokigen22;
    }

    @Override
    public void setYukokigen2(RString yukokigen2) {
        this.hihokenshasho.yukokigen22 = yukokigen2;
    }

    @Override
    public RString getHihokenshanno() {
        return hihokenshasho.hihokenshanno2;
    }

    @Override
    public void setHihokenshanno(RString hihokenshanno) {
        this.hihokenshasho.hihokenshanno2 = hihokenshanno;
    }

    @Override
    public RString getYubinno() {
        return hihokenshasho.yubinno2;
    }

    @Override
    public void setYubinno(RString yubinno) {
        this.hihokenshasho.yubinno2 = yubinno;
    }

    @Override
    public RString getGyoseiku() {
        return hihokenshasho.gyoseiku2;
    }

    @Override
    public void setGyoseiku(RString gyoseiku) {
        this.hihokenshasho.gyoseiku2 = gyoseiku;
    }

    @Override
    public RString getGyoseikuS() {
        return hihokenshasho.gyoseikuS2;
    }

    @Override
    public void setGyoseikuS(RString gyoseikuS) {
        this.hihokenshasho.gyoseikuS2 = gyoseikuS;
    }

    @Override
    public RString getHihojusho() {
        return hihokenshasho.hihojusho2;
    }

    @Override
    public void setHihojusho(RString hihojusho) {
        this.hihokenshasho.hihojusho2 = hihojusho;
    }

    @Override
    public RString getHihokana() {
        return hihokenshasho.hihokana2;
    }

    @Override
    public void setHihokana(RString hihokana) {
        this.hihokenshasho.hihokana2 = hihokana;
    }

    @Override
    public RString getHihoname() {
        return hihokenshasho.hihoname2;
    }

    @Override
    public void setHihoname(RString hihoname) {
        this.hihokenshasho.hihoname2 = hihoname;
    }

    @Override
    public RString getUmareMeiji1() {
        return hihokenshasho.umareMeiji2;
    }

    @Override
    public void setUmareMeiji1(RString umareMeiji1) {
        this.hihokenshasho.umareMeiji2 = umareMeiji1;
    }

    @Override
    public RString getUmareTaisho1() {
        return hihokenshasho.umareTaisho2;
    }

    @Override
    public void setUmareTaisho1(RString umareTaisho1) {
        this.hihokenshasho.umareTaisho2 = umareTaisho1;
    }

    @Override
    public RString getUmareShowa1() {
        return hihokenshasho.umareShowa2;
    }

    @Override
    public void setUmareShowa1(RString umareShowa1) {
        this.hihokenshasho.umareShowa2 = umareShowa1;
    }

    @Override
    public RString getUmareYy1() {
        return hihokenshasho.umareYy2;
    }

    @Override
    public void setUmareYy1(RString umareYy1) {
        this.hihokenshasho.umareYy2 = umareYy1;
    }

    @Override
    public RString getUmareMm1() {
        return hihokenshasho.umareMm2;
    }

    @Override
    public void setUmareMm1(RString umareMm1) {
        this.hihokenshasho.umareMm2 = umareMm1;
    }

    @Override
    public RString getUmareDd1() {
        return hihokenshasho.umareDd2;
    }

    @Override
    public void setUmareDd1(RString umareDd1) {
        this.hihokenshasho.umareDd2 = umareDd1;
    }

    @Override
    public RString getUmareYyyy1() {
        return hihokenshasho.umareYyyy2;
    }

    @Override
    public void setUmareYyyy1(RString umareYyyy1) {
        this.hihokenshasho.umareYyyy2 = umareYyyy1;
    }

    @Override
    public RString getUmareMmS1() {
        return hihokenshasho.umareMmS2;
    }

    @Override
    public void setUmareMmS1(RString umareMmS1) {
        this.hihokenshasho.umareMmS2 = umareMmS1;
    }

    @Override
    public RString getUmareDdS1() {
        return hihokenshasho.umareDdS2;
    }

    @Override
    public void setUmareDdS1(RString umareDdS1) {
        this.hihokenshasho.umareDdS2 = umareDdS1;
    }

    @Override
    public RString getSeibetsuMan1() {
        return hihokenshasho.seibetsuMan2;
    }

    @Override
    public void setSeibetsuMan1(RString seibetsuMan1) {
        this.hihokenshasho.seibetsuMan2 = seibetsuMan1;
    }

    @Override
    public RString getSeibetsuWoman1() {
        return hihokenshasho.seibetsuWoman2;
    }

    @Override
    public void setSeibetsuWoman1(RString seibetsuWoman1) {
        this.hihokenshasho.seibetsuWoman2 = seibetsuWoman1;
    }

    @Override
    public RString getKofuymdGengo() {
        return hihokenshasho.kofuymdGengo2;
    }

    @Override
    public void setKofuymdGengo(RString kofuymdGengo) {
        this.hihokenshasho.kofuymdGengo2 = kofuymdGengo;
    }

    @Override
    public RString getKofuymdYy() {
        return hihokenshasho.kofuymdYy2;
    }

    @Override
    public void setKofuymdYy(RString kofuymdYy) {
        this.hihokenshasho.kofuymdYy2 = kofuymdYy;
    }

    @Override
    public RString getKofuymdMm() {
        return hihokenshasho.kofuymdMm2;
    }

    @Override
    public void setKofuymdMm(RString kofuymdMm) {
        this.hihokenshasho.kofuymdMm2 = kofuymdMm;
    }

    @Override
    public RString getKofuymdDd() {
        return hihokenshasho.kofuymdDd2;
    }

    @Override
    public void setKofuymdDd(RString kofuymdDd) {
        this.hihokenshasho.kofuymdDd2 = kofuymdDd;
    }

    @Override
    public RString getSaikofu1() {
        return hihokenshasho.saikofu12;
    }

    @Override
    public void setSaikofu1(RString saikofu1) {
        this.hihokenshasho.saikofu12 = saikofu1;
    }

    @Override
    public RString getSaikofu2() {
        return hihokenshasho.saikofu22;
    }

    @Override
    public void setSaikofu2(RString saikofu2) {
        this.hihokenshasho.saikofu22 = saikofu2;
    }

    @Override
    public RString getHokenshano1() {
        return hihokenshasho.hokenshano12;
    }

    @Override
    public void setHokenshano1(RString hokenshano1) {
        this.hihokenshasho.hokenshano12 = hokenshano1;
    }

    @Override
    public RString getHokenshano2() {
        return hihokenshasho.hokenshano22;
    }

    @Override
    public void setHokenshano2(RString hokenshano2) {
        this.hihokenshasho.hokenshano22 = hokenshano2;
    }

    @Override
    public RString getHokenshano3() {
        return hihokenshasho.hokenshano32;
    }

    @Override
    public void setHokenshano3(RString hokenshano3) {
        this.hihokenshasho.hokenshano32 = hokenshano3;
    }

    @Override
    public RString getHokenshano4() {
        return hihokenshasho.hokenshano42;
    }

    @Override
    public void setHokenshano4(RString hokenshano4) {
        this.hihokenshasho.hokenshano42 = hokenshano4;
    }

    @Override
    public RString getHokenshano5() {
        return hihokenshasho.hokenshano52;
    }

    @Override
    public void setHokenshano5(RString hokenshano5) {
        this.hihokenshasho.hokenshano52 = hokenshano5;
    }

    @Override
    public RString getHokenshano6() {
        return hihokenshasho.hokenshano62;
    }

    @Override
    public void setHokenshano6(RString hokenshano6) {
        this.hihokenshasho.hokenshano62 = hokenshano6;
    }

    @Override
    public RString getKaigokbn() {
        return hihokenshasho.kaigokbn2;
    }

    @Override
    public void setKaigokbn(RString kaigokbn) {
        this.hihokenshasho.kaigokbn2 = kaigokbn;
    }

    @Override
    public RString getNinteiymd() {
        return hihokenshasho.ninteiymd2;
    }

    @Override
    public void setNinteiymd(RString ninteiymd) {
        this.hihokenshasho.ninteiymd2 = ninteiymd;
    }

    @Override
    public RString getYukokikanst() {
        return hihokenshasho.yukokikanst2;
    }

    @Override
    public void setYukokikanst(RString yukokikanst) {
        this.hihokenshasho.yukokikanst2 = yukokikanst;
    }

    @Override
    public RString getYukokikaned() {
        return hihokenshasho.yukokikaned2;
    }

    @Override
    public void setYukokikaned(RString yukokikaned) {
        this.hihokenshasho.yukokikaned2 = yukokikaned;
    }

    @Override
    public RString getHomonkikanst() {
        return hihokenshasho.homonkikanst2;
    }

    @Override
    public void setHomonkikanst(RString homonkikanst) {
        this.hihokenshasho.homonkikanst2 = homonkikanst;
    }

    @Override
    public RString getHomonkikaned() {
        return hihokenshasho.homonkikaned2;
    }

    @Override
    public void setHomonkikaned(RString homonkikaned) {
        this.hihokenshasho.homonkikaned2 = homonkikaned;
    }

    @Override
    public RString getService1() {
        return hihokenshasho.service12;
    }

    @Override
    public void setService1(RString service1) {
        this.hihokenshasho.service12 = service1;
    }

    @Override
    public RString getTen0() {
        return hihokenshasho.ten02;
    }

    @Override
    public void setTen0(RString ten0) {
        this.hihokenshasho.ten02 = ten0;
    }

    @Override
    public RString getShurui1() {
        return hihokenshasho.shurui12;
    }

    @Override
    public void setShurui1(RString shurui1) {
        this.hihokenshasho.shurui12 = shurui1;
    }

    @Override
    public RString getShurui2() {
        return hihokenshasho.shurui22;
    }

    @Override
    public void setShurui2(RString shurui2) {
        this.hihokenshasho.shurui22 = shurui2;
    }

    @Override
    public RString getShurui3() {
        return hihokenshasho.shurui32;
    }

    @Override
    public void setShurui3(RString shurui3) {
        this.hihokenshasho.shurui32 = shurui3;
    }

    @Override
    public RString getShurui4() {
        return hihokenshasho.shurui42;
    }

    @Override
    public void setShurui4(RString shurui4) {
        this.hihokenshasho.shurui42 = shurui4;
    }

    @Override
    public RString getShurui5() {
        return hihokenshasho.shurui52;
    }

    @Override
    public void setShurui5(RString shurui5) {
        this.hihokenshasho.shurui52 = shurui5;
    }

    @Override
    public RString getShurui6() {
        return hihokenshasho.shurui62;
    }

    @Override
    public void setShurui6(RString shurui6) {
        this.hihokenshasho.shurui62 = shurui6;
    }

    @Override
    public RString getShuruigendo1() {
        return hihokenshasho.shuruigendo12;
    }

    @Override
    public void setShuruigendo1(RString shuruigendo1) {
        this.hihokenshasho.shuruigendo12 = shuruigendo1;
    }

    @Override
    public RString getShuruigendo2() {
        return hihokenshasho.shuruigendo22;
    }

    @Override
    public void setShuruigendo2(RString shuruigendo2) {
        this.hihokenshasho.shuruigendo22 = shuruigendo2;
    }

    @Override
    public RString getShuruigendo3() {
        return hihokenshasho.shuruigendo32;
    }

    @Override
    public void setShuruigendo3(RString shuruigendo3) {
        this.hihokenshasho.shuruigendo32 = shuruigendo3;
    }

    @Override
    public RString getShuruigendo4() {
        return hihokenshasho.shuruigendo42;
    }

    @Override
    public void setShuruigendo4(RString shuruigendo4) {
        this.hihokenshasho.shuruigendo42 = shuruigendo4;
    }

    @Override
    public RString getShuruigendo5() {
        return hihokenshasho.shuruigendo52;
    }

    @Override
    public void setShuruigendo5(RString shuruigendo5) {
        this.hihokenshasho.shuruigendo52 = shuruigendo5;
    }

    @Override
    public RString getShuruigendo6() {
        return hihokenshasho.shuruigendo62;
    }

    @Override
    public void setShuruigendo6(RString shuruigendo6) {
        this.hihokenshasho.shuruigendo62 = shuruigendo6;
    }

    @Override
    public RString getTen1() {
        return hihokenshasho.ten12;
    }

    @Override
    public void setTen1(RString ten1) {
        this.hihokenshasho.ten12 = ten1;
    }

    @Override
    public RString getTen2() {
        return hihokenshasho.ten22;
    }

    @Override
    public void setTen2(RString ten2) {
        this.hihokenshasho.ten22 = ten2;
    }

    @Override
    public RString getTen3() {
        return hihokenshasho.ten32;
    }

    @Override
    public void setTen3(RString ten3) {
        this.hihokenshasho.ten32 = ten3;
    }

    @Override
    public RString getTen4() {
        return hihokenshasho.ten42;
    }

    @Override
    public void setTen4(RString ten4) {
        this.hihokenshasho.ten42 = ten4;
    }

    @Override
    public RString getTen5() {
        return hihokenshasho.ten52;
    }

    @Override
    public void setTen5(RString ten5) {
        this.hihokenshasho.ten52 = ten5;
    }

    @Override
    public RString getTen6() {
        return hihokenshasho.ten62;
    }

    @Override
    public void setTen6(RString ten6) {
        this.hihokenshasho.ten62 = ten6;
    }

    @Override
    public RString getRyui() {
        return hihokenshasho.ryui2;
    }

    @Override
    public void setRyui(RString ryui) {
        this.hihokenshasho.ryui2 = ryui;
    }

    @Override
    public RString getSeigen1() {
        return hihokenshasho.seigen12;
    }

    @Override
    public void setSeigen1(RString seigen1) {
        this.hihokenshasho.seigen12 = seigen1;
    }

    @Override
    public RString getSeigenLong1() {
        return hihokenshasho.seigenLong12;
    }

    @Override
    public void setSeigenLong1(RString seigenLong1) {
        this.hihokenshasho.seigenLong12 = seigenLong1;
    }

    @Override
    public RString getSeigen2() {
        return hihokenshasho.seigen22;
    }

    @Override
    public void setSeigen2(RString seigen2) {
        this.hihokenshasho.seigen22 = seigen2;
    }

    @Override
    public RString getSeigenLong2() {
        return hihokenshasho.seigenLong22;
    }

    @Override
    public void setSeigenLong2(RString seigenLong2) {
        this.hihokenshasho.seigenLong22 = seigenLong2;
    }

    @Override
    public RString getSeigen3() {
        return hihokenshasho.seigen32;
    }

    @Override
    public void setSeigen3(RString seigen3) {
        this.hihokenshasho.seigen32 = seigen3;
    }

    @Override
    public RString getSeigenLong3() {
        return hihokenshasho.seigenLong32;
    }

    @Override
    public void setSeigenLong3(RString seigenLong3) {
        this.hihokenshasho.seigenLong32 = seigenLong3;
    }

    @Override
    public RString getSeigen4() {
        return hihokenshasho.seigen42;
    }

    @Override
    public void setSeigen4(RString seigen4) {
        this.hihokenshasho.seigen42 = seigen4;
    }

    @Override
    public RString getSeigenLong4() {
        return hihokenshasho.seigenLong42;
    }

    @Override
    public void setSeigenLong4(RString seigenLong4) {
        this.hihokenshasho.seigenLong42 = seigenLong4;
    }

    @Override
    public RString getSeigen5() {
        return hihokenshasho.seigen52;
    }

    @Override
    public void setSeigen5(RString seigen5) {
        this.hihokenshasho.seigen52 = seigen5;
    }

    @Override
    public RString getSeigenLong5() {
        return hihokenshasho.seigenLong52;
    }

    @Override
    public void setSeigenLong5(RString seigenLong5) {
        this.hihokenshasho.seigenLong52 = seigenLong5;
    }

    @Override
    public RString getSeigen6() {
        return hihokenshasho.seigen62;
    }

    @Override
    public void setSeigen6(RString seigen6) {
        this.hihokenshasho.seigen62 = seigen6;
    }

    @Override
    public RString getSeigenLong6() {
        return hihokenshasho.seigenLong62;
    }

    @Override
    public void setSeigenLong6(RString seigenLong6) {
        this.hihokenshasho.seigenLong62 = seigenLong6;
    }

    @Override
    public RString getSeigenSt1() {
        return hihokenshasho.seigenSt12;
    }

    @Override
    public void setSeigenSt1(RString seigenSt1) {
        this.hihokenshasho.seigenSt12 = seigenSt1;
    }

    @Override
    public RString getSeigenEd1() {
        return hihokenshasho.seigenEd12;
    }

    @Override
    public void setSeigenEd1(RString seigenEd1) {
        this.hihokenshasho.seigenEd12 = seigenEd1;
    }

    @Override
    public RString getSeigenSt2() {
        return hihokenshasho.seigenSt22;
    }

    @Override
    public void setSeigenSt2(RString seigenSt2) {
        this.hihokenshasho.seigenSt22 = seigenSt2;
    }

    @Override
    public RString getSeigenEd2() {
        return hihokenshasho.seigenEd22;
    }

    @Override
    public void setSeigenEd2(RString seigenEd2) {
        this.hihokenshasho.seigenEd22 = seigenEd2;
    }

    @Override
    public RString getSeigenSt3() {
        return hihokenshasho.seigenSt32;
    }

    @Override
    public void setSeigenSt3(RString seigenSt3) {
        this.hihokenshasho.seigenSt32 = seigenSt3;
    }

    @Override
    public RString getSeigenEd3() {
        return hihokenshasho.seigenEd32;
    }

    @Override
    public void setSeigenEd3(RString seigenEd3) {
        this.hihokenshasho.seigenEd32 = seigenEd3;
    }

    @Override
    public RString getGyosha1() {
        return hihokenshasho.gyosha4;
    }

    @Override
    public void setGyosha1(RString gyosha1) {
        this.hihokenshasho.gyosha4 = gyosha1;
    }

    @Override
    public RString getTodokeYmd1() {
        return hihokenshasho.todokeYmd12;
    }

    @Override
    public void setTodokeYmd1(RString todokeYmd1) {
        this.hihokenshasho.todokeYmd12 = todokeYmd1;
    }

    @Override
    public RString getGyosha2() {
        return hihokenshasho.gyosha5;
    }

    @Override
    public void setGyosha2(RString gyosha2) {
        this.hihokenshasho.gyosha5 = gyosha2;
    }

    @Override
    public RString getGyosha2Asa() {
        return hihokenshasho.gyosha5Asa;
    }

    @Override
    public void setGyosha2Asa(RString gyosha2Asa) {
        this.hihokenshasho.gyosha5Asa = gyosha2Asa;
    }

    @Override
    public RString getGyosha2Massho() {
        return hihokenshasho.gyosha5Massho;
    }

    @Override
    public void setGyosha2Massho(RString gyosha2Massho) {
        this.hihokenshasho.gyosha5Massho = gyosha2Massho;
    }

    @Override
    public RString getTodokeYmd2() {
        return hihokenshasho.todokeYmd22;
    }

    @Override
    public void setTodokeYmd2(RString todokeYmd2) {
        this.hihokenshasho.todokeYmd22 = todokeYmd2;
    }

    @Override
    public RString getTodokeYmd2Asa() {
        return hihokenshasho.todokeYmd2Asa2;
    }

    @Override
    public void setTodokeYmd2Asa(RString todokeYmd2Asa) {
        this.hihokenshasho.todokeYmd2Asa2 = todokeYmd2Asa;
    }

    @Override
    public RString getTodokeYmd2Massho() {
        return hihokenshasho.todokeYmd2Massho2;
    }

    @Override
    public void setTodokeYmd2Massho(RString todokeYmd2Massho) {
        this.hihokenshasho.todokeYmd2Massho2 = todokeYmd2Massho;
    }

    @Override
    public RString getGyosha3() {
        return hihokenshasho.gyosha6;
    }

    @Override
    public void setGyosha3(RString gyosha3) {
        this.hihokenshasho.gyosha6 = gyosha3;
    }

    @Override
    public RString getGyosha3Asa() {
        return hihokenshasho.gyosha6Asa;
    }

    @Override
    public void setGyosha3Asa(RString gyosha3Asa) {
        this.hihokenshasho.gyosha6Asa = gyosha3Asa;
    }

    @Override
    public RString getGyosha3Massho() {
        return hihokenshasho.gyosha6Massho;
    }

    @Override
    public void setGyosha3Massho(RString gyosha3Massho) {
        this.hihokenshasho.gyosha6Massho = gyosha3Massho;
    }

    @Override
    public RString getTodokeYmd3() {
        return hihokenshasho.todokeYmd32;
    }

    @Override
    public void setTodokeYmd3(RString todokeYmd3) {
        this.hihokenshasho.todokeYmd32 = todokeYmd3;
    }

    @Override
    public RString getTodokeYmd3Asa() {
        return hihokenshasho.todokeYmd3Asa2;
    }

    @Override
    public void setTodokeYmd3Asa(RString todokeYmd3Asa) {
        this.hihokenshasho.todokeYmd3Asa2 = todokeYmd3Asa;
    }

    @Override
    public RString getTodokeYmd3Massho() {
        return hihokenshasho.todokeYmd3Massho2;
    }

    @Override
    public void setTodokeYmd3Massho(RString todokeYmd3Massho) {
        this.hihokenshasho.todokeYmd3Massho2 = todokeYmd3Massho;
    }

    @Override
    public RString getShisetsuSyu1() {
        return hihokenshasho.shisetsuSyu12;
    }

    @Override
    public void setShisetsuSyu1(RString shisetsuSyu1) {
        this.hihokenshasho.shisetsuSyu12 = shisetsuSyu1;
    }

    @Override
    public RString getShisetsuname1() {
        return hihokenshasho.shisetsuname12;
    }

    @Override
    public void setShisetsuname1(RString shisetsuname1) {
        this.hihokenshasho.shisetsuname12 = shisetsuname1;
    }

    @Override
    public RString getNyushochk1() {
        return hihokenshasho.nyushochk12;
    }

    @Override
    public void setNyushochk1(RString nyushochk1) {
        this.hihokenshasho.nyushochk12 = nyushochk1;
    }

    @Override
    public RString getNyuinchk1() {
        return hihokenshasho.nyuinchk12;
    }

    @Override
    public void setNyuinchk1(RString nyuinchk1) {
        this.hihokenshasho.nyuinchk12 = nyuinchk1;
    }

    @Override
    public RString getTaishochk1() {
        return hihokenshasho.taishochk12;
    }

    @Override
    public void setTaishochk1(RString taishochk1) {
        this.hihokenshasho.taishochk12 = taishochk1;
    }

    @Override
    public RString getTaiinchk1() {
        return hihokenshasho.taiinchk12;
    }

    @Override
    public void setTaiinchk1(RString taiinchk1) {
        this.hihokenshasho.taiinchk12 = taiinchk1;
    }

    @Override
    public RString getNyushoymd1() {
        return hihokenshasho.nyushoymd12;
    }

    @Override
    public void setNyushoymd1(RString nyushoymd1) {
        this.hihokenshasho.nyushoymd12 = nyushoymd1;
    }

    @Override
    public RString getTaiinymd1() {
        return hihokenshasho.taiinymd12;
    }

    @Override
    public void setTaiinymd1(RString taiinymd1) {
        this.hihokenshasho.taiinymd12 = taiinymd1;
    }

    @Override
    public RString getShisetsuSyu2() {
        return hihokenshasho.shisetsuSyu22;
    }

    @Override
    public void setShisetsuSyu2(RString shisetsuSyu2) {
        this.hihokenshasho.shisetsuSyu22 = shisetsuSyu2;
    }

    @Override
    public RString getShisetsuname2() {
        return hihokenshasho.shisetsuname22;
    }

    @Override
    public void setShisetsuname2(RString shisetsuname2) {
        this.hihokenshasho.shisetsuname22 = shisetsuname2;
    }

    @Override
    public RString getNyushochk2() {
        return hihokenshasho.nyushochk22;
    }

    @Override
    public void setNyushochk2(RString nyushochk2) {
        this.hihokenshasho.nyushochk22 = nyushochk2;
    }

    @Override
    public RString getNyuinchk2() {
        return hihokenshasho.nyuinchk22;
    }

    @Override
    public void setNyuinchk2(RString nyuinchk2) {
        this.hihokenshasho.nyuinchk22 = nyuinchk2;
    }

    @Override
    public RString getTaishochk2() {
        return hihokenshasho.taishochk22;
    }

    @Override
    public void setTaishochk2(RString taishochk2) {
        this.hihokenshasho.taishochk22 = taishochk2;
    }

    @Override
    public RString getTaiinchk2() {
        return hihokenshasho.taiinchk22;
    }

    @Override
    public void setTaiinchk2(RString taiinchk2) {
        this.hihokenshasho.taiinchk22 = taiinchk2;
    }

    @Override
    public RString getNyushoymd2() {
        return hihokenshasho.nyushoymd22;
    }

    @Override
    public void setNyushoymd2(RString nyushoymd2) {
        this.hihokenshasho.nyushoymd22 = nyushoymd2;
    }

    @Override
    public RString getTaiinymd2() {
        return hihokenshasho.taiinymd22;
    }

    @Override
    public void setTaiinymd2(RString taiinymd2) {
        this.hihokenshasho.taiinymd22 = taiinymd2;
    }

    @Override
    public RString getRenban() {
        return hihokenshasho.renban2;
    }

    @Override
    public void setRenban(RString renban) {
        this.hihokenshasho.renban2 = renban;
    }

    @Override
    public RString getSeiShogai1() {
        return hihokenshasho.seiShogai12;
    }

    @Override
    public void setSeiShogai1(RString seiShogai1) {
        this.hihokenshasho.seiShogai12 = seiShogai1;
    }

    @Override
    public RString getSeiShogai2() {
        return hihokenshasho.seiShogai22;
    }

    @Override
    public void setSeiShogai2(RString seiShogai2) {
        this.hihokenshasho.seiShogai22 = seiShogai2;
    }

    @Override
    public RString getKosekiSeibetsu1() {
        return hihokenshasho.kosekiSeibetsu12;
    }

    @Override
    public void setKosekiSeibetsu1(RString kosekiSeibetsu1) {
        this.hihokenshasho.kosekiSeibetsu12 = kosekiSeibetsu1;
    }

    @Override
    public RString getKosekiSeibetsu2() {
        return hihokenshasho.kosekiSeibetsu22;
    }

    @Override
    public void setKosekiSeibetsu2(RString kosekiSeibetsu2) {
        this.hihokenshasho.kosekiSeibetsu22 = kosekiSeibetsu2;
    }

    @Override
    public RString getItakuGyosha1() {
        return hihokenshasho.itakuGyosha4;
    }

    @Override
    public void setItakuGyosha1(RString itakuGyosha1) {
        this.hihokenshasho.itakuGyosha4 = itakuGyosha1;
    }

    @Override
    public RString getItakuGyosha2() {
        return hihokenshasho.itakuGyosha5;
    }

    @Override
    public void setItakuGyosha2(RString itakuGyosha2) {
        this.hihokenshasho.itakuGyosha5 = itakuGyosha2;
    }

    @Override
    public RString getItakuGyosha2Asa() {
        return hihokenshasho.itakuGyosha5Asa;
    }

    @Override
    public void setItakuGyosha2Asa(RString itakuGyosha2Asa) {
        this.hihokenshasho.itakuGyosha5Asa = itakuGyosha2Asa;
    }

    @Override
    public RString getItakuGyosha2Massho() {
        return hihokenshasho.itakuGyosha5Massho;
    }

    @Override
    public void setItakuGyosha2Massho(RString itakuGyosha2Massho) {
        this.hihokenshasho.itakuGyosha5Massho = itakuGyosha2Massho;
    }

    @Override
    public RString getItakuGyosha3() {
        return hihokenshasho.itakuGyosha3;
    }

    @Override
    public void setItakuGyosha3(RString itakuGyosha3) {
        this.hihokenshasho.itakuGyosha6 = itakuGyosha3;
    }

    @Override
    public RString getItakuGyosha3Asa() {
        return hihokenshasho.itakuGyosha6Asa;
    }

    @Override
    public void setItakuGyosha3Asa(RString itakuGyosha3Asa) {
        this.hihokenshasho.itakuGyosha6Asa = itakuGyosha3Asa;
    }

    @Override
    public RString getItakuGyosha3Massho() {
        return hihokenshasho.itakuGyosha6Massho;
    }

    @Override
    public void setItakuGyosha3Massho(RString itakuGyosha3Massho) {
        this.hihokenshasho.itakuGyosha6Massho = itakuGyosha3Massho;
    }

    @Override
    public Object getAtesakiSource() {
        return hihokenshasho.atesakiSource2;
    }

    @Override
    public void setAtesakiSource(Object atesakiSource) {
        this.hihokenshasho.atesakiSource2 = atesakiSource;
    }

}
