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
 * 被保険者証B4版の帳票ソースが持つ、帳票の上部に印字される情報について取得・設定する際に使用するクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoB4UpperEditData implements IHihokenshashoB4CommonEditData {

    private final HihokenshashoB4 hihokenshasho;

    /**
     * コンストラクタです。
     *
     * @param hihokenshasho 被保険者証A4版の帳票ソース
     */
    public HihokenshashoB4UpperEditData(HihokenshashoB4 hihokenshasho) {
        requireNonNull(hihokenshasho, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証B4版帳票ソース", getClass().getName()));
        this.hihokenshasho = hihokenshasho;
    }

    @Override
    public HihokenshashoB4 getEditData() {
        return this.hihokenshasho;
    }

    @Override
    public RString getYukokigen() {
        return hihokenshasho.yukokigen1;
    }

    @Override
    public void setYukokigen(RString yukokigen) {
        this.hihokenshasho.yukokigen1 = yukokigen;
    }

    @Override
    public RString getYukokigen2() {
        return hihokenshasho.yukokigen21;
    }

    @Override
    public void setYukokigen2(RString yukokigen2) {
        this.hihokenshasho.yukokigen21 = yukokigen2;
    }

    @Override
    public RString getHihokenshanno() {
        return hihokenshasho.hihokenshanno1;
    }

    @Override
    public void setHihokenshanno(RString hihokenshanno) {
        this.hihokenshasho.hihokenshanno1 = hihokenshanno;
    }

    @Override
    public RString getYubinno() {
        return hihokenshasho.yubinno1;
    }

    @Override
    public void setYubinno(RString yubinno) {
        this.hihokenshasho.yubinno1 = yubinno;
    }

    @Override
    public RString getGyoseiku() {
        return hihokenshasho.gyoseiku1;
    }

    @Override
    public void setGyoseiku(RString gyoseiku) {
        this.hihokenshasho.gyoseiku1 = gyoseiku;
    }

    @Override
    public RString getGyoseikuS() {
        return hihokenshasho.gyoseikuS1;
    }

    @Override
    public void setGyoseikuS(RString gyoseikuS) {
        this.hihokenshasho.gyoseikuS1 = gyoseikuS;
    }

    @Override
    public RString getHihojusho() {
        return hihokenshasho.hihojusho1;
    }

    @Override
    public void setHihojusho(RString hihojusho) {
        this.hihokenshasho.hihojusho1 = hihojusho;
    }

    @Override
    public RString getHihokana() {
        return hihokenshasho.hihokana1;
    }

    @Override
    public void setHihokana(RString hihokana) {
        this.hihokenshasho.hihokana1 = hihokana;
    }

    @Override
    public RString getHihoname() {
        return hihokenshasho.hihoname1;
    }

    @Override
    public void setHihoname(RString hihoname) {
        this.hihokenshasho.hihoname1 = hihoname;
    }

    @Override
    public RString getUmareMeiji1() {
        return hihokenshasho.umareMeiji1;
    }

    @Override
    public void setUmareMeiji1(RString umareMeiji1) {
        this.hihokenshasho.umareMeiji1 = umareMeiji1;
    }

    @Override
    public RString getUmareTaisho1() {
        return hihokenshasho.umareTaisho1;
    }

    @Override
    public void setUmareTaisho1(RString umareTaisho1) {
        this.hihokenshasho.umareTaisho1 = umareTaisho1;
    }

    @Override
    public RString getUmareShowa1() {
        return hihokenshasho.umareShowa1;
    }

    @Override
    public void setUmareShowa1(RString umareShowa1) {
        this.hihokenshasho.umareShowa1 = umareShowa1;
    }

    @Override
    public RString getUmareYy1() {
        return hihokenshasho.umareYy1;
    }

    @Override
    public void setUmareYy1(RString umareYy1) {
        this.hihokenshasho.umareYy1 = umareYy1;
    }

    @Override
    public RString getUmareMm1() {
        return hihokenshasho.umareMm1;
    }

    @Override
    public void setUmareMm1(RString umareMm1) {
        this.hihokenshasho.umareMm1 = umareMm1;
    }

    @Override
    public RString getUmareDd1() {
        return hihokenshasho.umareDd1;
    }

    @Override
    public void setUmareDd1(RString umareDd1) {
        this.hihokenshasho.umareDd1 = umareDd1;
    }

    @Override
    public RString getUmareYyyy1() {
        return hihokenshasho.umareYyyy1;
    }

    @Override
    public void setUmareYyyy1(RString umareYyyy1) {
        this.hihokenshasho.umareYyyy1 = umareYyyy1;
    }

    @Override
    public RString getUmareMmS1() {
        return hihokenshasho.umareMmS1;
    }

    @Override
    public void setUmareMmS1(RString umareMmS1) {
        this.hihokenshasho.umareMmS1 = umareMmS1;
    }

    @Override
    public RString getUmareDdS1() {
        return hihokenshasho.umareDdS1;
    }

    @Override
    public void setUmareDdS1(RString umareDdS1) {
        this.hihokenshasho.umareDdS1 = umareDdS1;
    }

    @Override
    public RString getSeibetsuMan1() {
        return hihokenshasho.seibetsuMan1;
    }

    @Override
    public void setSeibetsuMan1(RString seibetsuMan1) {
        this.hihokenshasho.seibetsuMan1 = seibetsuMan1;
    }

    @Override
    public RString getSeibetsuWoman1() {
        return hihokenshasho.seibetsuWoman1;
    }

    @Override
    public void setSeibetsuWoman1(RString seibetsuWoman1) {
        this.hihokenshasho.seibetsuWoman1 = seibetsuWoman1;
    }

    @Override
    public RString getKofuymdGengo() {
        return hihokenshasho.kofuymdGengo1;
    }

    @Override
    public void setKofuymdGengo(RString kofuymdGengo) {
        this.hihokenshasho.kofuymdGengo1 = kofuymdGengo;
    }

    @Override
    public RString getKofuymdYy() {
        return hihokenshasho.kofuymdYy1;
    }

    @Override
    public void setKofuymdYy(RString kofuymdYy) {
        this.hihokenshasho.kofuymdYy1 = kofuymdYy;
    }

    @Override
    public RString getKofuymdMm() {
        return hihokenshasho.kofuymdMm1;
    }

    @Override
    public void setKofuymdMm(RString kofuymdMm) {
        this.hihokenshasho.kofuymdMm1 = kofuymdMm;
    }

    @Override
    public RString getKofuymdDd() {
        return hihokenshasho.kofuymdDd1;
    }

    @Override
    public void setKofuymdDd(RString kofuymdDd) {
        this.hihokenshasho.kofuymdDd1 = kofuymdDd;
    }

    @Override
    public RString getSaikofu1() {
        return hihokenshasho.saikofu11;
    }

    @Override
    public void setSaikofu1(RString saikofu1) {
        this.hihokenshasho.saikofu11 = saikofu1;
    }

    @Override
    public RString getSaikofu2() {
        return hihokenshasho.saikofu21;
    }

    @Override
    public void setSaikofu2(RString saikofu2) {
        this.hihokenshasho.saikofu21 = saikofu2;
    }

    @Override
    public RString getHokenshano1() {
        return hihokenshasho.hokenshano11;
    }

    @Override
    public void setHokenshano1(RString hokenshano1) {
        this.hihokenshasho.hokenshano11 = hokenshano1;
    }

    @Override
    public RString getHokenshano2() {
        return hihokenshasho.hokenshano21;
    }

    @Override
    public void setHokenshano2(RString hokenshano2) {
        this.hihokenshasho.hokenshano21 = hokenshano2;
    }

    @Override
    public RString getHokenshano3() {
        return hihokenshasho.hokenshano31;
    }

    @Override
    public void setHokenshano3(RString hokenshano3) {
        this.hihokenshasho.hokenshano31 = hokenshano3;
    }

    @Override
    public RString getHokenshano4() {
        return hihokenshasho.hokenshano41;
    }

    @Override
    public void setHokenshano4(RString hokenshano4) {
        this.hihokenshasho.hokenshano41 = hokenshano4;
    }

    @Override
    public RString getHokenshano5() {
        return hihokenshasho.hokenshano51;
    }

    @Override
    public void setHokenshano5(RString hokenshano5) {
        this.hihokenshasho.hokenshano51 = hokenshano5;
    }

    @Override
    public RString getHokenshano6() {
        return hihokenshasho.hokenshano61;
    }

    @Override
    public void setHokenshano6(RString hokenshano6) {
        this.hihokenshasho.hokenshano61 = hokenshano6;
    }

    @Override
    public RString getKaigokbn() {
        return hihokenshasho.kaigokbn1;
    }

    @Override
    public void setKaigokbn(RString kaigokbn) {
        this.hihokenshasho.kaigokbn1 = kaigokbn;
    }

    @Override
    public RString getNinteiymd() {
        return hihokenshasho.ninteiymd1;
    }

    @Override
    public void setNinteiymd(RString ninteiymd) {
        this.hihokenshasho.ninteiymd1 = ninteiymd;
    }

    @Override
    public RString getYukokikanst() {
        return hihokenshasho.yukokikanst1;
    }

    @Override
    public void setYukokikanst(RString yukokikanst) {
        this.hihokenshasho.yukokikanst1 = yukokikanst;
    }

    @Override
    public RString getYukokikaned() {
        return hihokenshasho.yukokikaned1;
    }

    @Override
    public void setYukokikaned(RString yukokikaned) {
        this.hihokenshasho.yukokikaned1 = yukokikaned;
    }

    @Override
    public RString getHomonkikanst() {
        return hihokenshasho.homonkikanst1;
    }

    @Override
    public void setHomonkikanst(RString homonkikanst) {
        this.hihokenshasho.homonkikanst1 = homonkikanst;
    }

    @Override
    public RString getHomonkikaned() {
        return hihokenshasho.homonkikaned1;
    }

    @Override
    public void setHomonkikaned(RString homonkikaned) {
        this.hihokenshasho.homonkikaned1 = homonkikaned;
    }

    @Override
    public RString getService1() {
        return hihokenshasho.service11;
    }

    @Override
    public void setService1(RString service1) {
        this.hihokenshasho.service11 = service1;
    }

    @Override
    public RString getTen0() {
        return hihokenshasho.ten01;
    }

    @Override
    public void setTen0(RString ten0) {
        this.hihokenshasho.ten01 = ten0;
    }

    @Override
    public RString getShurui1() {
        return hihokenshasho.shurui11;
    }

    @Override
    public void setShurui1(RString shurui1) {
        this.hihokenshasho.shurui11 = shurui1;
    }

    @Override
    public RString getShurui2() {
        return hihokenshasho.shurui21;
    }

    @Override
    public void setShurui2(RString shurui2) {
        this.hihokenshasho.shurui21 = shurui2;
    }

    @Override
    public RString getShurui3() {
        return hihokenshasho.shurui31;
    }

    @Override
    public void setShurui3(RString shurui3) {
        this.hihokenshasho.shurui31 = shurui3;
    }

    @Override
    public RString getShurui4() {
        return hihokenshasho.shurui41;
    }

    @Override
    public void setShurui4(RString shurui4) {
        this.hihokenshasho.shurui41 = shurui4;
    }

    @Override
    public RString getShurui5() {
        return hihokenshasho.shurui51;
    }

    @Override
    public void setShurui5(RString shurui5) {
        this.hihokenshasho.shurui51 = shurui5;
    }

    @Override
    public RString getShurui6() {
        return hihokenshasho.shurui61;
    }

    @Override
    public void setShurui6(RString shurui6) {
        this.hihokenshasho.shurui61 = shurui6;
    }

    @Override
    public RString getShuruigendo1() {
        return hihokenshasho.shuruigendo11;
    }

    @Override
    public void setShuruigendo1(RString shuruigendo1) {
        this.hihokenshasho.shuruigendo11 = shuruigendo1;
    }

    @Override
    public RString getShuruigendo2() {
        return hihokenshasho.shuruigendo21;
    }

    @Override
    public void setShuruigendo2(RString shuruigendo2) {
        this.hihokenshasho.shuruigendo21 = shuruigendo2;
    }

    @Override
    public RString getShuruigendo3() {
        return hihokenshasho.shuruigendo31;
    }

    @Override
    public void setShuruigendo3(RString shuruigendo3) {
        this.hihokenshasho.shuruigendo31 = shuruigendo3;
    }

    @Override
    public RString getShuruigendo4() {
        return hihokenshasho.shuruigendo41;
    }

    @Override
    public void setShuruigendo4(RString shuruigendo4) {
        this.hihokenshasho.shuruigendo41 = shuruigendo4;
    }

    @Override
    public RString getShuruigendo5() {
        return hihokenshasho.shuruigendo51;
    }

    @Override
    public void setShuruigendo5(RString shuruigendo5) {
        this.hihokenshasho.shuruigendo51 = shuruigendo5;
    }

    @Override
    public RString getShuruigendo6() {
        return hihokenshasho.shuruigendo61;
    }

    @Override
    public void setShuruigendo6(RString shuruigendo6) {
        this.hihokenshasho.shuruigendo61 = shuruigendo6;
    }

    @Override
    public RString getTen1() {
        return hihokenshasho.ten11;
    }

    @Override
    public void setTen1(RString ten1) {
        this.hihokenshasho.ten11 = ten1;
    }

    @Override
    public RString getTen2() {
        return hihokenshasho.ten21;
    }

    @Override
    public void setTen2(RString ten2) {
        this.hihokenshasho.ten21 = ten2;
    }

    @Override
    public RString getTen3() {
        return hihokenshasho.ten31;
    }

    @Override
    public void setTen3(RString ten3) {
        this.hihokenshasho.ten31 = ten3;
    }

    @Override
    public RString getTen4() {
        return hihokenshasho.ten41;
    }

    @Override
    public void setTen4(RString ten4) {
        this.hihokenshasho.ten41 = ten4;
    }

    @Override
    public RString getTen5() {
        return hihokenshasho.ten51;
    }

    @Override
    public void setTen5(RString ten5) {
        this.hihokenshasho.ten51 = ten5;
    }

    @Override
    public RString getTen6() {
        return hihokenshasho.ten61;
    }

    @Override
    public void setTen6(RString ten6) {
        this.hihokenshasho.ten61 = ten6;
    }

    @Override
    public RString getRyui() {
        return hihokenshasho.ryui1;
    }

    @Override
    public void setRyui(RString ryui) {
        this.hihokenshasho.ryui1 = ryui;
    }

    @Override
    public RString getSeigen1() {
        return hihokenshasho.seigen11;
    }

    @Override
    public void setSeigen1(RString seigen1) {
        this.hihokenshasho.seigen11 = seigen1;
    }

    @Override
    public RString getSeigenLong1() {
        return hihokenshasho.seigenLong11;
    }

    @Override
    public void setSeigenLong1(RString seigenLong1) {
        this.hihokenshasho.seigenLong11 = seigenLong1;
    }

    @Override
    public RString getSeigen2() {
        return hihokenshasho.seigen21;
    }

    @Override
    public void setSeigen2(RString seigen2) {
        this.hihokenshasho.seigen21 = seigen2;
    }

    @Override
    public RString getSeigenLong2() {
        return hihokenshasho.seigenLong21;
    }

    @Override
    public void setSeigenLong2(RString seigenLong2) {
        this.hihokenshasho.seigenLong21 = seigenLong2;
    }

    @Override
    public RString getSeigen3() {
        return hihokenshasho.seigen31;
    }

    @Override
    public void setSeigen3(RString seigen3) {
        this.hihokenshasho.seigen31 = seigen3;
    }

    @Override
    public RString getSeigenLong3() {
        return hihokenshasho.seigenLong31;
    }

    @Override
    public void setSeigenLong3(RString seigenLong3) {
        this.hihokenshasho.seigenLong31 = seigenLong3;
    }

    @Override
    public RString getSeigen4() {
        return hihokenshasho.seigen41;
    }

    @Override
    public void setSeigen4(RString seigen4) {
        this.hihokenshasho.seigen41 = seigen4;
    }

    @Override
    public RString getSeigenLong4() {
        return hihokenshasho.seigenLong41;
    }

    @Override
    public void setSeigenLong4(RString seigenLong4) {
        this.hihokenshasho.seigenLong41 = seigenLong4;
    }

    @Override
    public RString getSeigen5() {
        return hihokenshasho.seigen51;
    }

    @Override
    public void setSeigen5(RString seigen5) {
        this.hihokenshasho.seigen51 = seigen5;
    }

    @Override
    public RString getSeigenLong5() {
        return hihokenshasho.seigenLong51;
    }

    @Override
    public void setSeigenLong5(RString seigenLong5) {
        this.hihokenshasho.seigenLong51 = seigenLong5;
    }

    @Override
    public RString getSeigen6() {
        return hihokenshasho.seigen61;
    }

    @Override
    public void setSeigen6(RString seigen6) {
        this.hihokenshasho.seigen61 = seigen6;
    }

    @Override
    public RString getSeigenLong6() {
        return hihokenshasho.seigenLong61;
    }

    @Override
    public void setSeigenLong6(RString seigenLong6) {
        this.hihokenshasho.seigenLong61 = seigenLong6;
    }

    @Override
    public RString getSeigenSt1() {
        return hihokenshasho.seigenSt11;
    }

    @Override
    public void setSeigenSt1(RString seigenSt1) {
        this.hihokenshasho.seigenSt11 = seigenSt1;
    }

    @Override
    public RString getSeigenEd1() {
        return hihokenshasho.seigenEd11;
    }

    @Override
    public void setSeigenEd1(RString seigenEd1) {
        this.hihokenshasho.seigenEd11 = seigenEd1;
    }

    @Override
    public RString getSeigenSt2() {
        return hihokenshasho.seigenSt21;
    }

    @Override
    public void setSeigenSt2(RString seigenSt2) {
        this.hihokenshasho.seigenSt21 = seigenSt2;
    }

    @Override
    public RString getSeigenEd2() {
        return hihokenshasho.seigenEd21;
    }

    @Override
    public void setSeigenEd2(RString seigenEd2) {
        this.hihokenshasho.seigenEd21 = seigenEd2;
    }

    @Override
    public RString getSeigenSt3() {
        return hihokenshasho.seigenSt31;
    }

    @Override
    public void setSeigenSt3(RString seigenSt3) {
        this.hihokenshasho.seigenSt31 = seigenSt3;
    }

    @Override
    public RString getSeigenEd3() {
        return hihokenshasho.seigenEd31;
    }

    @Override
    public void setSeigenEd3(RString seigenEd3) {
        this.hihokenshasho.seigenEd31 = seigenEd3;
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
        return hihokenshasho.todokeYmd11;
    }

    @Override
    public void setTodokeYmd1(RString todokeYmd1) {
        this.hihokenshasho.todokeYmd11 = todokeYmd1;
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
        return hihokenshasho.todokeYmd21;
    }

    @Override
    public void setTodokeYmd2(RString todokeYmd2) {
        this.hihokenshasho.todokeYmd21 = todokeYmd2;
    }

    @Override
    public RString getTodokeYmd2Asa() {
        return hihokenshasho.todokeYmd2Asa1;
    }

    @Override
    public void setTodokeYmd2Asa(RString todokeYmd2Asa) {
        this.hihokenshasho.todokeYmd2Asa1 = todokeYmd2Asa;
    }

    @Override
    public RString getTodokeYmd2Massho() {
        return hihokenshasho.todokeYmd2Massho1;
    }

    @Override
    public void setTodokeYmd2Massho(RString todokeYmd2Massho) {
        this.hihokenshasho.todokeYmd2Massho1 = todokeYmd2Massho;
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
        return hihokenshasho.todokeYmd31;
    }

    @Override
    public void setTodokeYmd3(RString todokeYmd3) {
        this.hihokenshasho.todokeYmd31 = todokeYmd3;
    }

    @Override
    public RString getTodokeYmd3Asa() {
        return hihokenshasho.todokeYmd3Asa1;
    }

    @Override
    public void setTodokeYmd3Asa(RString todokeYmd3Asa) {
        this.hihokenshasho.todokeYmd3Asa1 = todokeYmd3Asa;
    }

    @Override
    public RString getTodokeYmd3Massho() {
        return hihokenshasho.todokeYmd3Massho1;
    }

    @Override
    public void setTodokeYmd3Massho(RString todokeYmd3Massho) {
        this.hihokenshasho.todokeYmd3Massho1 = todokeYmd3Massho;
    }

    @Override
    public RString getShisetsuSyu1() {
        return hihokenshasho.shisetsuSyu11;
    }

    @Override
    public void setShisetsuSyu1(RString shisetsuSyu1) {
        this.hihokenshasho.shisetsuSyu11 = shisetsuSyu1;
    }

    @Override
    public RString getShisetsuname1() {
        return hihokenshasho.shisetsuname11;
    }

    @Override
    public void setShisetsuname1(RString shisetsuname1) {
        this.hihokenshasho.shisetsuname11 = shisetsuname1;
    }

    @Override
    public RString getNyushochk1() {
        return hihokenshasho.nyushochk11;
    }

    @Override
    public void setNyushochk1(RString nyushochk1) {
        this.hihokenshasho.nyushochk11 = nyushochk1;
    }

    @Override
    public RString getNyuinchk1() {
        return hihokenshasho.nyuinchk11;
    }

    @Override
    public void setNyuinchk1(RString nyuinchk1) {
        this.hihokenshasho.nyuinchk11 = nyuinchk1;
    }

    @Override
    public RString getTaishochk1() {
        return hihokenshasho.taishochk11;
    }

    @Override
    public void setTaishochk1(RString taishochk1) {
        this.hihokenshasho.taishochk11 = taishochk1;
    }

    @Override
    public RString getTaiinchk1() {
        return hihokenshasho.taiinchk11;
    }

    @Override
    public void setTaiinchk1(RString taiinchk1) {
        this.hihokenshasho.taiinchk11 = taiinchk1;
    }

    @Override
    public RString getNyushoymd1() {
        return hihokenshasho.nyushoymd11;
    }

    @Override
    public void setNyushoymd1(RString nyushoymd1) {
        this.hihokenshasho.nyushoymd11 = nyushoymd1;
    }

    @Override
    public RString getTaishoymd1() {
        return hihokenshasho.taiinymd11;
    }

    @Override
    public void setTaiinymd1(RString taiinymd1) {
        this.hihokenshasho.taiinymd11 = taiinymd1;
    }

    @Override
    public RString getShisetsuSyu2() {
        return hihokenshasho.shisetsuSyu21;
    }

    @Override
    public void setShisetsuSyu2(RString shisetsuSyu2) {
        this.hihokenshasho.shisetsuSyu21 = shisetsuSyu2;
    }

    @Override
    public RString getShisetsuname2() {
        return hihokenshasho.shisetsuname21;
    }

    @Override
    public void setShisetsuname2(RString shisetsuname2) {
        this.hihokenshasho.shisetsuname21 = shisetsuname2;
    }

    @Override
    public RString getNyushochk2() {
        return hihokenshasho.nyushochk21;
    }

    @Override
    public void setNyushochk2(RString nyushochk2) {
        this.hihokenshasho.nyushochk21 = nyushochk2;
    }

    @Override
    public RString getNyuinchk2() {
        return hihokenshasho.nyuinchk21;
    }

    @Override
    public void setNyuinchk2(RString nyuinchk2) {
        this.hihokenshasho.nyuinchk21 = nyuinchk2;
    }

    @Override
    public RString getTaishochk2() {
        return hihokenshasho.taishochk21;
    }

    @Override
    public void setTaishochk2(RString taishochk2) {
        this.hihokenshasho.taishochk21 = taishochk2;
    }

    @Override
    public RString getTaiinchk2() {
        return hihokenshasho.taiinchk21;
    }

    @Override
    public void setTaiinchk2(RString taiinchk2) {
        this.hihokenshasho.taiinchk21 = taiinchk2;
    }

    @Override
    public RString getNyushoymd2() {
        return hihokenshasho.nyushoymd21;
    }

    @Override
    public void setNyushoymd2(RString nyushoymd2) {
        this.hihokenshasho.nyushoymd21 = nyushoymd2;
    }

    @Override
    public RString getTaishoymd2() {
        return hihokenshasho.taiinymd21;
    }

    @Override
    public void setTaiinymd2(RString taiinymd2) {
        this.hihokenshasho.taiinymd21 = taiinymd2;
    }

    @Override
    public RString getRenban() {
        return hihokenshasho.renban1;
    }

    @Override
    public void setRenban(RString renban) {
        this.hihokenshasho.renban1 = renban;
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
        return hihokenshasho.seiShogai21;
    }

    @Override
    public void setSeiShogai2(RString seiShogai2) {
        this.hihokenshasho.seiShogai21 = seiShogai2;
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
        return hihokenshasho.kosekiSeibetsu21;
    }

    @Override
    public void setKosekiSeibetsu2(RString kosekiSeibetsu2) {
        this.hihokenshasho.kosekiSeibetsu21 = kosekiSeibetsu2;
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
        this.hihokenshasho.sofusakiAtena1 = tsuchishoSofusakiSource;
    }

    @Override
    public RString getServicetani1() {
        return this.hihokenshasho.servicetani1;
    }

    @Override
    public void setServicetani1(RString servicetani1) {
        this.hihokenshasho.servicetani1 = servicetani1;
    }

}
