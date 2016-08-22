package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 認定調査票（基本調査）調査項目一時テーブルです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@OnNextSchema("rgdb")
public class NinteichosahyoChosaItemTempEntity extends DbTableEntityBase<NinteichosahyoChosaItemTempEntity> implements IDbAccessable {

    /**
     * 調査票（概況調査）サービスの状況一時テーブル
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("NinteichosahyoChosaItemTemp"));
    }
    @TempTableColumnOrder(1)
    private ShinseishoKanriNo shinseishoKanriNo;
    @TempTableColumnOrder(2)
    private Code koroshoIfShikibetsuCode;
    @TempTableColumnOrder(3)
    private RString koban1;
    @TempTableColumnOrder(4)
    private RString koban2;
    @TempTableColumnOrder(5)
    private RString koban3;
    @TempTableColumnOrder(6)
    private RString koban4;
    @TempTableColumnOrder(7)
    private RString koban5;
    @TempTableColumnOrder(8)
    private RString koban6;
    @TempTableColumnOrder(9)
    private RString koban7;
    @TempTableColumnOrder(10)
    private RString koban8;
    @TempTableColumnOrder(11)
    private RString koban9;
    @TempTableColumnOrder(12)
    private RString koban10;
    @TempTableColumnOrder(13)
    private RString koban11;
    @TempTableColumnOrder(14)
    private RString koban12;
    @TempTableColumnOrder(15)
    private RString koban13;
    @TempTableColumnOrder(16)
    private RString koban14;
    @TempTableColumnOrder(17)
    private RString koban15;
    @TempTableColumnOrder(18)
    private RString koban16;
    @TempTableColumnOrder(19)
    private RString koban17;
    @TempTableColumnOrder(20)
    private RString koban18;
    @TempTableColumnOrder(21)
    private RString koban19;
    @TempTableColumnOrder(22)
    private RString koban20;
    @TempTableColumnOrder(23)
    private RString koban21;
    @TempTableColumnOrder(24)
    private RString koban22;
    @TempTableColumnOrder(25)
    private RString koban23;
    @TempTableColumnOrder(26)
    private RString koban24;
    @TempTableColumnOrder(27)
    private RString koban25;
    @TempTableColumnOrder(28)
    private RString koban26;
    @TempTableColumnOrder(29)
    private RString koban27;
    @TempTableColumnOrder(30)
    private RString koban28;
    @TempTableColumnOrder(31)
    private RString koban29;
    @TempTableColumnOrder(32)
    private RString koban30;
    @TempTableColumnOrder(33)
    private RString koban31;
    @TempTableColumnOrder(34)
    private RString koban32;
    @TempTableColumnOrder(35)
    private RString koban33;
    @TempTableColumnOrder(36)
    private RString koban34;
    @TempTableColumnOrder(37)
    private RString koban35;
    @TempTableColumnOrder(38)
    private RString koban36;
    @TempTableColumnOrder(39)
    private RString koban37;
    @TempTableColumnOrder(40)
    private RString koban38;
    @TempTableColumnOrder(41)
    private RString koban39;
    @TempTableColumnOrder(42)
    private RString koban40;
    @TempTableColumnOrder(43)
    private RString koban41;
    @TempTableColumnOrder(44)
    private RString koban42;
    @TempTableColumnOrder(45)
    private RString koban43;
    @TempTableColumnOrder(46)
    private RString koban44;
    @TempTableColumnOrder(47)
    private RString koban45;
    @TempTableColumnOrder(48)
    private RString koban46;
    @TempTableColumnOrder(49)
    private RString koban47;
    @TempTableColumnOrder(50)
    private RString koban48;
    @TempTableColumnOrder(51)
    private RString koban49;
    @TempTableColumnOrder(52)
    private RString koban50;
    @TempTableColumnOrder(53)
    private RString koban51;
    @TempTableColumnOrder(54)
    private RString koban52;
    @TempTableColumnOrder(55)
    private RString koban53;
    @TempTableColumnOrder(56)
    private RString koban54;
    @TempTableColumnOrder(57)
    private RString koban55;
    @TempTableColumnOrder(58)
    private RString koban56;
    @TempTableColumnOrder(59)
    private RString koban57;
    @TempTableColumnOrder(60)
    private RString koban58;
    @TempTableColumnOrder(61)
    private RString koban59;
    @TempTableColumnOrder(62)
    private RString koban60;
    @TempTableColumnOrder(63)
    private RString koban61;
    @TempTableColumnOrder(64)
    private RString koban62;
    @TempTableColumnOrder(65)
    private RString koban63;
    @TempTableColumnOrder(66)
    private RString koban64;
    @TempTableColumnOrder(67)
    private RString koban65;
    @TempTableColumnOrder(68)
    private RString koban66;
    @TempTableColumnOrder(69)
    private RString koban67;
    @TempTableColumnOrder(70)
    private RString koban68;
    @TempTableColumnOrder(71)
    private RString koban69;
    @TempTableColumnOrder(72)
    private RString koban70;
    @TempTableColumnOrder(73)
    private RString koban71;
    @TempTableColumnOrder(74)
    private RString koban72;
    @TempTableColumnOrder(75)
    private RString koban73;
    @TempTableColumnOrder(76)
    private RString koban74;
    @TempTableColumnOrder(77)
    private RString koban75;
    @TempTableColumnOrder(78)
    private RString koban76;
    @TempTableColumnOrder(79)
    private RString koban77;
    @TempTableColumnOrder(80)
    private RString koban78;
    @TempTableColumnOrder(81)
    private RString koban79;
    @TempTableColumnOrder(82)
    private RString koban80;
    @TempTableColumnOrder(83)
    private RString koban81;
    @TempTableColumnOrder(84)
    private RString koban82;
    @TempTableColumnOrder(85)
    private RString koban83;
    @TempTableColumnOrder(86)
    private RString koban84;
    @TempTableColumnOrder(87)
    private RString koban85;

    /**
     * 申請書管理番号のgetメソッドです。
     *
     * @return the nijiHanteiYM
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     *
     * @return the koroshoIfShikibetsuCode
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     *
     * @param koroshoIfShikibetsuCode Code
     */
    public void setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 項番1のgetメソッドです。
     *
     * @return the koban1
     */
    public RString getKoban1() {
        return koban1;
    }

    /**
     * 項番1のsetメソッドです。
     *
     * @param koban1 the koban1 to set
     */
    public void setKoban1(RString koban1) {
        this.koban1 = koban1;
    }

    /**
     * 項番2のgetメソッドです。
     *
     * @return the koban2
     */
    public RString getKoban2() {
        return koban2;
    }

    /**
     * 項番2のsetメソッドです。
     *
     * @param koban2 the koban2 to set
     */
    public void setKoban2(RString koban2) {
        this.koban2 = koban2;
    }

    /**
     * 項番3のgetメソッドです。
     *
     * @return the koban3
     */
    public RString getKoban3() {
        return koban3;
    }

    /**
     * 項番3のsetメソッドです。
     *
     * @param koban3 the koban3 to set
     */
    public void setKoban3(RString koban3) {
        this.koban3 = koban3;
    }

    /**
     * 項番4のgetメソッドです。
     *
     * @return the koban4
     */
    public RString getKoban4() {
        return koban4;
    }

    /**
     * 項番4のsetメソッドです。
     *
     * @param koban4 the koban4 to set
     */
    public void setKoban4(RString koban4) {
        this.koban4 = koban4;
    }

    /**
     * 項番5のgetメソッドです。
     *
     * @return the koban5
     */
    public RString getKoban5() {
        return koban5;
    }

    /**
     * 項番5のsetメソッドです。
     *
     * @param koban5 the koban5 to set
     */
    public void setKoban5(RString koban5) {
        this.koban5 = koban5;
    }

    /**
     * 項番6のgetメソッドです。
     *
     * @return the koban6
     */
    public RString getKoban6() {
        return koban6;
    }

    /**
     * 項番6のsetメソッドです。
     *
     * @param koban6 the koban6 to set
     */
    public void setKoban6(RString koban6) {
        this.koban6 = koban6;
    }

    /**
     * 項番7のgetメソッドです。
     *
     * @return the koban7
     */
    public RString getKoban7() {
        return koban7;
    }

    /**
     * 項番7のsetメソッドです。
     *
     * @param koban7 the koban7 to set
     */
    public void setKoban7(RString koban7) {
        this.koban7 = koban7;
    }

    /**
     * 項番8のgetメソッドです。
     *
     * @return the koban8
     */
    public RString getKoban8() {
        return koban8;
    }

    /**
     * 項番8のsetメソッドです。
     *
     * @param koban8 the koban8 to set
     */
    public void setKoban8(RString koban8) {
        this.koban8 = koban8;
    }

    /**
     * 項番9のgetメソッドです。
     *
     * @return the koban9
     */
    public RString getKoban9() {
        return koban9;
    }

    /**
     * 項番9のsetメソッドです。
     *
     * @param koban9 the koban9 to set
     */
    public void setKoban9(RString koban9) {
        this.koban9 = koban9;
    }

    /**
     * 項番10のgetメソッドです。
     *
     * @return the koban10
     */
    public RString getKoban10() {
        return koban10;
    }

    /**
     * 項番10のsetメソッドです。
     *
     * @param koban10 the koban10 to set
     */
    public void setKoban10(RString koban10) {
        this.koban10 = koban10;
    }

    /**
     * 項番11のgetメソッドです。
     *
     * @return the koban11
     */
    public RString getKoban11() {
        return koban11;
    }

    /**
     * 項番11のsetメソッドです。
     *
     * @param koban11 the koban11 to set
     */
    public void setKoban11(RString koban11) {
        this.koban11 = koban11;
    }

    /**
     * 項番12のgetメソッドです。
     *
     * @return the koban12
     */
    public RString getKoban12() {
        return koban12;
    }

    /**
     * 項番12のsetメソッドです。
     *
     * @param koban12 the koban12 to set
     */
    public void setKoban12(RString koban12) {
        this.koban12 = koban12;
    }

    /**
     * 項番13のgetメソッドです。
     *
     * @return the koban13
     */
    public RString getKoban13() {
        return koban13;
    }

    /**
     * 項番13のsetメソッドです。
     *
     * @param koban13 the koban13 to set
     */
    public void setKoban13(RString koban13) {
        this.koban13 = koban13;
    }

    /**
     * 項番14のgetメソッドです。
     *
     * @return the koban14
     */
    public RString getKoban14() {
        return koban14;
    }

    /**
     * 項番14のsetメソッドです。
     *
     * @param koban14 the koban14 to set
     */
    public void setKoban14(RString koban14) {
        this.koban14 = koban14;
    }

    /**
     * 項番15のgetメソッドです。
     *
     * @return the koban15
     */
    public RString getKoban15() {
        return koban15;
    }

    /**
     * 項番15のsetメソッドです。
     *
     * @param koban15 the koban15 to set
     */
    public void setKoban15(RString koban15) {
        this.koban15 = koban15;
    }

    /**
     * 項番16のgetメソッドです。
     *
     * @return the koban16
     */
    public RString getKoban16() {
        return koban16;
    }

    /**
     * 項番16のsetメソッドです。
     *
     * @param koban16 the koban16 to set
     */
    public void setKoban16(RString koban16) {
        this.koban16 = koban16;
    }

    /**
     * 項番17のgetメソッドです。
     *
     * @return the koban17
     */
    public RString getKoban17() {
        return koban17;
    }

    /**
     * 項番17のsetメソッドです。
     *
     * @param koban17 the koban17 to set
     */
    public void setKoban17(RString koban17) {
        this.koban17 = koban17;
    }

    /**
     * 項番18のgetメソッドです。
     *
     * @return the koban18
     */
    public RString getKoban18() {
        return koban18;
    }

    /**
     * 項番18のsetメソッドです。
     *
     * @param koban18 the koban18 to set
     */
    public void setKoban18(RString koban18) {
        this.koban18 = koban18;
    }

    /**
     * 項番19のgetメソッドです。
     *
     * @return the koban19
     */
    public RString getKoban19() {
        return koban19;
    }

    /**
     * 項番19のsetメソッドです。
     *
     * @param koban19 the koban19 to set
     */
    public void setKoban19(RString koban19) {
        this.koban19 = koban19;
    }

    /**
     * 項番20のgetメソッドです。
     *
     * @return the koban20
     */
    public RString getKoban20() {
        return koban20;
    }

    /**
     * 項番20のsetメソッドです。
     *
     * @param koban20 the koban20 to set
     */
    public void setKoban20(RString koban20) {
        this.koban20 = koban20;
    }

    /**
     * @return the koban21
     */
    public RString getKoban21() {
        return koban21;
    }

    /**
     * @param koban21 the koban21 to set
     */
    public void setKoban21(RString koban21) {
        this.koban21 = koban21;
    }

    /**
     * @return the koban22
     */
    public RString getKoban22() {
        return koban22;
    }

    /**
     * @param koban22 the koban22 to set
     */
    public void setKoban22(RString koban22) {
        this.koban22 = koban22;
    }

    /**
     * @return the koban23
     */
    public RString getKoban23() {
        return koban23;
    }

    /**
     * @param koban23 the koban23 to set
     */
    public void setKoban23(RString koban23) {
        this.koban23 = koban23;
    }

    /**
     * @return the koban24
     */
    public RString getKoban24() {
        return koban24;
    }

    /**
     * @param koban24 the koban24 to set
     */
    public void setKoban24(RString koban24) {
        this.koban24 = koban24;
    }

    /**
     * @return the koban25
     */
    public RString getKoban25() {
        return koban25;
    }

    /**
     * @param koban25 the koban25 to set
     */
    public void setKoban25(RString koban25) {
        this.koban25 = koban25;
    }

    /**
     * @return the koban26
     */
    public RString getKoban26() {
        return koban26;
    }

    /**
     * @param koban26 the koban26 to set
     */
    public void setKoban26(RString koban26) {
        this.koban26 = koban26;
    }

    /**
     * @return the koban27
     */
    public RString getKoban27() {
        return koban27;
    }

    /**
     * @param koban27 the koban27 to set
     */
    public void setKoban27(RString koban27) {
        this.koban27 = koban27;
    }

    /**
     * @return the koban28
     */
    public RString getKoban28() {
        return koban28;
    }

    /**
     * @param koban28 the koban28 to set
     */
    public void setKoban28(RString koban28) {
        this.koban28 = koban28;
    }

    /**
     * @return the koban29
     */
    public RString getKoban29() {
        return koban29;
    }

    /**
     * @param koban29 the koban29 to set
     */
    public void setKoban29(RString koban29) {
        this.koban29 = koban29;
    }

    /**
     * @return the koban30
     */
    public RString getKoban30() {
        return koban30;
    }

    /**
     * @param koban30 the koban30 to set
     */
    public void setKoban30(RString koban30) {
        this.koban30 = koban30;
    }

    /**
     * @return the koban31
     */
    public RString getKoban31() {
        return koban31;
    }

    /**
     * @param koban31 the koban31 to set
     */
    public void setKoban31(RString koban31) {
        this.koban31 = koban31;
    }

    /**
     * @return the koban32
     */
    public RString getKoban32() {
        return koban32;
    }

    /**
     * @param koban32 the koban32 to set
     */
    public void setKoban32(RString koban32) {
        this.koban32 = koban32;
    }

    /**
     * @return the koban33
     */
    public RString getKoban33() {
        return koban33;
    }

    /**
     * @param koban33 the koban33 to set
     */
    public void setKoban33(RString koban33) {
        this.koban33 = koban33;
    }

    /**
     * @return the koban34
     */
    public RString getKoban34() {
        return koban34;
    }

    /**
     * @param koban34 the koban34 to set
     */
    public void setKoban34(RString koban34) {
        this.koban34 = koban34;
    }

    /**
     * @return the koban35
     */
    public RString getKoban35() {
        return koban35;
    }

    /**
     * @param koban35 the koban35 to set
     */
    public void setKoban35(RString koban35) {
        this.koban35 = koban35;
    }

    /**
     * @return the koban36
     */
    public RString getKoban36() {
        return koban36;
    }

    /**
     * @param koban36 the koban36 to set
     */
    public void setKoban36(RString koban36) {
        this.koban36 = koban36;
    }

    /**
     * @return the koban37
     */
    public RString getKoban37() {
        return koban37;
    }

    /**
     * @param koban37 the koban37 to set
     */
    public void setKoban37(RString koban37) {
        this.koban37 = koban37;
    }

    /**
     * @return the koban38
     */
    public RString getKoban38() {
        return koban38;
    }

    /**
     * @param koban38 the koban38 to set
     */
    public void setKoban38(RString koban38) {
        this.koban38 = koban38;
    }

    /**
     * @return the koban39
     */
    public RString getKoban39() {
        return koban39;
    }

    /**
     * @param koban39 the koban39 to set
     */
    public void setKoban39(RString koban39) {
        this.koban39 = koban39;
    }

    /**
     * @return the koban40
     */
    public RString getKoban40() {
        return koban40;
    }

    /**
     * @param koban40 the koban40 to set
     */
    public void setKoban40(RString koban40) {
        this.koban40 = koban40;
    }

    /**
     * @return the koban41
     */
    public RString getKoban41() {
        return koban41;
    }

    /**
     * @param koban41 the koban41 to set
     */
    public void setKoban41(RString koban41) {
        this.koban41 = koban41;
    }

    /**
     * @return the koban42
     */
    public RString getKoban42() {
        return koban42;
    }

    /**
     * @param koban42 the koban42 to set
     */
    public void setKoban42(RString koban42) {
        this.koban42 = koban42;
    }

    /**
     * @return the koban43
     */
    public RString getKoban43() {
        return koban43;
    }

    /**
     * @param koban43 the koban43 to set
     */
    public void setKoban43(RString koban43) {
        this.koban43 = koban43;
    }

    /**
     * @return the koban44
     */
    public RString getKoban44() {
        return koban44;
    }

    /**
     * @param koban44 the koban44 to set
     */
    public void setKoban44(RString koban44) {
        this.koban44 = koban44;
    }

    /**
     * @return the koban45
     */
    public RString getKoban45() {
        return koban45;
    }

    /**
     * @param koban45 the koban45 to set
     */
    public void setKoban45(RString koban45) {
        this.koban45 = koban45;
    }

    /**
     * @return the koban46
     */
    public RString getKoban46() {
        return koban46;
    }

    /**
     * @param koban46 the koban46 to set
     */
    public void setKoban46(RString koban46) {
        this.koban46 = koban46;
    }

    /**
     * @return the koban47
     */
    public RString getKoban47() {
        return koban47;
    }

    /**
     * @param koban47 the koban47 to set
     */
    public void setKoban47(RString koban47) {
        this.koban47 = koban47;
    }

    /**
     * @return the koban48
     */
    public RString getKoban48() {
        return koban48;
    }

    /**
     * @param koban48 the koban48 to set
     */
    public void setKoban48(RString koban48) {
        this.koban48 = koban48;
    }

    /**
     * @return the koban49
     */
    public RString getKoban49() {
        return koban49;
    }

    /**
     * @param koban49 the koban49 to set
     */
    public void setKoban49(RString koban49) {
        this.koban49 = koban49;
    }

    /**
     * @return the koban50
     */
    public RString getKoban50() {
        return koban50;
    }

    /**
     * @param koban50 the koban50 to set
     */
    public void setKoban50(RString koban50) {
        this.koban50 = koban50;
    }

    /**
     * @return the koban51
     */
    public RString getKoban51() {
        return koban51;
    }

    /**
     * @param koban51 the koban51 to set
     */
    public void setKoban51(RString koban51) {
        this.koban51 = koban51;
    }

    /**
     * @return the koban52
     */
    public RString getKoban52() {
        return koban52;
    }

    /**
     * @param koban52 the koban52 to set
     */
    public void setKoban52(RString koban52) {
        this.koban52 = koban52;
    }

    /**
     * @return the koban53
     */
    public RString getKoban53() {
        return koban53;
    }

    /**
     * @param koban53 the koban53 to set
     */
    public void setKoban53(RString koban53) {
        this.koban53 = koban53;
    }

    /**
     * @return the koban54
     */
    public RString getKoban54() {
        return koban54;
    }

    /**
     * @param koban54 the koban54 to set
     */
    public void setKoban54(RString koban54) {
        this.koban54 = koban54;
    }

    /**
     * @return the koban55
     */
    public RString getKoban55() {
        return koban55;
    }

    /**
     * @param koban55 the koban55 to set
     */
    public void setKoban55(RString koban55) {
        this.koban55 = koban55;
    }

    /**
     * @return the koban56
     */
    public RString getKoban56() {
        return koban56;
    }

    /**
     * @param koban56 the koban56 to set
     */
    public void setKoban56(RString koban56) {
        this.koban56 = koban56;
    }

    /**
     * @return the koban57
     */
    public RString getKoban57() {
        return koban57;
    }

    /**
     * @param koban57 the koban57 to set
     */
    public void setKoban57(RString koban57) {
        this.koban57 = koban57;
    }

    /**
     * @return the koban58
     */
    public RString getKoban58() {
        return koban58;
    }

    /**
     * @param koban58 the koban58 to set
     */
    public void setKoban58(RString koban58) {
        this.koban58 = koban58;
    }

    /**
     * @return the koban59
     */
    public RString getKoban59() {
        return koban59;
    }

    /**
     * @param koban59 the koban59 to set
     */
    public void setKoban59(RString koban59) {
        this.koban59 = koban59;
    }

    /**
     * @return the koban60
     */
    public RString getKoban60() {
        return koban60;
    }

    /**
     * @param koban60 the koban60 to set
     */
    public void setKoban60(RString koban60) {
        this.koban60 = koban60;
    }

    /**
     * @return the koban61
     */
    public RString getKoban61() {
        return koban61;
    }

    /**
     * @param koban61 the koban61 to set
     */
    public void setKoban61(RString koban61) {
        this.koban61 = koban61;
    }

    /**
     * @return the koban62
     */
    public RString getKoban62() {
        return koban62;
    }

    /**
     * @param koban62 the koban62 to set
     */
    public void setKoban62(RString koban62) {
        this.koban62 = koban62;
    }

    /**
     * @return the koban63
     */
    public RString getKoban63() {
        return koban63;
    }

    /**
     * @param koban63 the koban63 to set
     */
    public void setKoban63(RString koban63) {
        this.koban63 = koban63;
    }

    /**
     * @return the koban64
     */
    public RString getKoban64() {
        return koban64;
    }

    /**
     * @param koban64 the koban64 to set
     */
    public void setKoban64(RString koban64) {
        this.koban64 = koban64;
    }

    /**
     * @return the koban65
     */
    public RString getKoban65() {
        return koban65;
    }

    /**
     * @param koban65 the koban65 to set
     */
    public void setKoban65(RString koban65) {
        this.koban65 = koban65;
    }

    /**
     * @return the koban66
     */
    public RString getKoban66() {
        return koban66;
    }

    /**
     * @param koban66 the koban66 to set
     */
    public void setKoban66(RString koban66) {
        this.koban66 = koban66;
    }

    /**
     * @return the koban67
     */
    public RString getKoban67() {
        return koban67;
    }

    /**
     * @param koban67 the koban67 to set
     */
    public void setKoban67(RString koban67) {
        this.koban67 = koban67;
    }

    /**
     * @return the koban68
     */
    public RString getKoban68() {
        return koban68;
    }

    /**
     * @param koban68 the koban68 to set
     */
    public void setKoban68(RString koban68) {
        this.koban68 = koban68;
    }

    /**
     * @return the koban69
     */
    public RString getKoban69() {
        return koban69;
    }

    /**
     * @param koban69 the koban69 to set
     */
    public void setKoban69(RString koban69) {
        this.koban69 = koban69;
    }

    /**
     * @return the koban70
     */
    public RString getKoban70() {
        return koban70;
    }

    /**
     * @param koban70 the koban70 to set
     */
    public void setKoban70(RString koban70) {
        this.koban70 = koban70;
    }

    /**
     * @return the koban71
     */
    public RString getKoban71() {
        return koban71;
    }

    /**
     * @param koban71 the koban71 to set
     */
    public void setKoban71(RString koban71) {
        this.koban71 = koban71;
    }

    /**
     * @return the koban72
     */
    public RString getKoban72() {
        return koban72;
    }

    /**
     * @param koban72 the koban72 to set
     */
    public void setKoban72(RString koban72) {
        this.koban72 = koban72;
    }

    /**
     * @return the koban73
     */
    public RString getKoban73() {
        return koban73;
    }

    /**
     * @param koban73 the koban73 to set
     */
    public void setKoban73(RString koban73) {
        this.koban73 = koban73;
    }

    /**
     * @return the koban74
     */
    public RString getKoban74() {
        return koban74;
    }

    /**
     * @param koban74 the koban74 to set
     */
    public void setKoban74(RString koban74) {
        this.koban74 = koban74;
    }

    /**
     * @return the koban75
     */
    public RString getKoban75() {
        return koban75;
    }

    /**
     * @param koban75 the koban75 to set
     */
    public void setKoban75(RString koban75) {
        this.koban75 = koban75;
    }

    /**
     * @return the koban76
     */
    public RString getKoban76() {
        return koban76;
    }

    /**
     * @param koban76 the koban76 to set
     */
    public void setKoban76(RString koban76) {
        this.koban76 = koban76;
    }

    /**
     * @return the koban77
     */
    public RString getKoban77() {
        return koban77;
    }

    /**
     * @param koban77 the koban77 to set
     */
    public void setKoban77(RString koban77) {
        this.koban77 = koban77;
    }

    /**
     * @return the koban78
     */
    public RString getKoban78() {
        return koban78;
    }

    /**
     * @param koban78 the koban78 to set
     */
    public void setKoban78(RString koban78) {
        this.koban78 = koban78;
    }

    /**
     * @return the koban79
     */
    public RString getKoban79() {
        return koban79;
    }

    /**
     * @param koban79 the koban79 to set
     */
    public void setKoban79(RString koban79) {
        this.koban79 = koban79;
    }

    /**
     * @return the koban80
     */
    public RString getKoban80() {
        return koban80;
    }

    /**
     * @param koban80 the koban80 to set
     */
    public void setKoban80(RString koban80) {
        this.koban80 = koban80;
    }

    /**
     * @return the koban81
     */
    public RString getKoban81() {
        return koban81;
    }

    /**
     * @param koban81 the koban81 to set
     */
    public void setKoban81(RString koban81) {
        this.koban81 = koban81;
    }

    /**
     * @return the koban82
     */
    public RString getKoban82() {
        return koban82;
    }

    /**
     * @param koban82 the koban82 to set
     */
    public void setKoban82(RString koban82) {
        this.koban82 = koban82;
    }

    /**
     * @return the koban83
     */
    public RString getKoban83() {
        return koban83;
    }

    /**
     * @param koban83 the koban83 to set
     */
    public void setKoban83(RString koban83) {
        this.koban83 = koban83;
    }

    /**
     * @return the koban84
     */
    public RString getKoban84() {
        return koban84;
    }

    /**
     * @param koban84 the koban84 to set
     */
    public void setKoban84(RString koban84) {
        this.koban84 = koban84;
    }

    /**
     * @return the koban85
     */
    public RString getKoban85() {
        return koban85;
    }

    /**
     * @param koban85 the koban85 to set
     */
    public void setKoban85(RString koban85) {
        this.koban85 = koban85;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(NinteichosahyoChosaItemTempEntity entity) {
        this.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        this.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        this.setKoban1(entity.getKoban1());
        this.setKoban2(entity.getKoban2());
        this.setKoban3(entity.getKoban3());
        this.setKoban4(entity.getKoban4());
        this.setKoban5(entity.getKoban5());
        this.setKoban6(entity.getKoban6());
        this.setKoban7(entity.getKoban7());
        this.setKoban8(entity.getKoban8());
        this.setKoban9(entity.getKoban9());
        this.setKoban10(entity.getKoban10());
        this.setKoban11(entity.getKoban11());
        this.setKoban12(entity.getKoban12());
        this.setKoban13(entity.getKoban13());
        this.setKoban14(entity.getKoban14());
        this.setKoban15(entity.getKoban15());
        this.setKoban16(entity.getKoban16());
        this.setKoban17(entity.getKoban17());
        this.setKoban18(entity.getKoban18());
        this.setKoban19(entity.getKoban19());
        this.setKoban21(entity.getKoban21());
        this.setKoban22(entity.getKoban22());
        this.setKoban23(entity.getKoban23());
        this.setKoban24(entity.getKoban24());
        this.setKoban25(entity.getKoban25());
        this.setKoban26(entity.getKoban26());
        this.setKoban27(entity.getKoban27());
        this.setKoban28(entity.getKoban28());
        this.setKoban29(entity.getKoban29());
        this.setKoban30(entity.getKoban30());
        this.setKoban31(entity.getKoban31());
        this.setKoban32(entity.getKoban32());
        this.setKoban33(entity.getKoban33());
        this.setKoban34(entity.getKoban34());
        this.setKoban35(entity.getKoban35());
        this.setKoban36(entity.getKoban36());
        this.setKoban37(entity.getKoban37());
        this.setKoban38(entity.getKoban38());
        this.setKoban39(entity.getKoban39());
        this.setKoban40(entity.getKoban40());
        this.setKoban41(entity.getKoban41());
        this.setKoban42(entity.getKoban42());
        this.setKoban43(entity.getKoban43());
        this.setKoban44(entity.getKoban44());
        this.setKoban45(entity.getKoban45());
        this.setKoban46(entity.getKoban46());
        this.setKoban47(entity.getKoban47());
        this.setKoban48(entity.getKoban48());
        this.setKoban49(entity.getKoban49());
        this.setKoban50(entity.getKoban50());
        this.setKoban51(entity.getKoban51());
        this.setKoban52(entity.getKoban52());
        this.setKoban53(entity.getKoban53());
        this.setKoban54(entity.getKoban54());
        this.setKoban55(entity.getKoban55());
        this.setKoban56(entity.getKoban56());
        this.setKoban57(entity.getKoban57());
        this.setKoban58(entity.getKoban58());
        this.setKoban59(entity.getKoban59());
        this.setKoban60(entity.getKoban60());
        this.setKoban61(entity.getKoban61());
        this.setKoban62(entity.getKoban62());
        this.setKoban63(entity.getKoban63());
        this.setKoban64(entity.getKoban64());
        this.setKoban65(entity.getKoban65());
        this.setKoban66(entity.getKoban66());
        this.setKoban67(entity.getKoban67());
        this.setKoban68(entity.getKoban68());
        this.setKoban69(entity.getKoban69());
        this.setKoban70(entity.getKoban70());
        this.setKoban71(entity.getKoban71());
        this.setKoban72(entity.getKoban72());
        this.setKoban73(entity.getKoban73());
        this.setKoban74(entity.getKoban74());
        this.setKoban75(entity.getKoban75());
        this.setKoban76(entity.getKoban76());
        this.setKoban77(entity.getKoban77());
        this.setKoban78(entity.getKoban78());
        this.setKoban79(entity.getKoban79());
        this.setKoban80(entity.getKoban80());
        this.setKoban81(entity.getKoban81());
        this.setKoban82(entity.getKoban82());
        this.setKoban83(entity.getKoban83());
        this.setKoban84(entity.getKoban84());
        this.setKoban85(entity.getKoban85());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, koroshoIfShikibetsuCode, koban1, koban2, koban3, koban4,
                koban5, koban6, koban7, koban8, koban9, koban10, koban11, koban12, koban13, koban14,
                koban15, koban16, koban17, koban18, koban19, koban20, koban21, koban22, koban23, koban24,
                koban25, koban26, koban27, koban28, koban29, koban30, koban31, koban32, koban33, koban34,
                koban35, koban36, koban37, koban38, koban39, koban40, koban41, koban42, koban43, koban44,
                koban45, koban46, koban47, koban48, koban49, koban50, koban51, koban52, koban53, koban54,
                koban55, koban56, koban57, koban58, koban59, koban60, koban61, koban62, koban63, koban64,
                koban65, koban66, koban67, koban68, koban69, koban70, koban71, koban72, koban73, koban74,
                koban75, koban76, koban77, koban78, koban79, koban80, koban81, koban82, koban83, koban84, koban85);
    }
// </editor-fold>
}
