package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;

/**
 * 認定調査票（基本調査素点）2006Aテーブルのエンティティクラスです。
 */
public class DbT5204NinteichosahyoKihonChosaScore2006AEntity extends DbTableEntityBase<DbT5204NinteichosahyoKihonChosaScore2006AEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5204NinteichosahyoKihonChosaScore2006A");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD013ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private int reserchItem01;
    private int reserchItem02;
    private int reserchItem03;
    private int reserchItem04;
    private int reserchItem05;
    private int reserchItem06;
    private int reserchItem07;
    private int reserchItem08;
    private int reserchItem09;
    private int reserchItem10;
    private int reserchItem11;
    private int reserchItem12;
    private int reserchItem13;
    private int reserchItem14;
    private int reserchItem15;
    private int reserchItem16;
    private int reserchItem17;
    private int reserchItem18;
    private int reserchItem19;
    private int reserchItem20;
    private int reserchItem21;
    private int reserchItem22;
    private int reserchItem23;
    private int reserchItem24;
    private int reserchItem25;
    private int reserchItem26;
    private int reserchItem27;
    private int reserchItem28;
    private int reserchItem29;
    private int reserchItem30;
    private int reserchItem31;
    private int reserchItem32;
    private int reserchItem33;
    private int reserchItem34;
    private int reserchItem35;
    private int reserchItem36;
    private int reserchItem37;
    private int reserchItem38;
    private int reserchItem39;
    private int reserchItem40;
    private int reserchItem41;
    private int reserchItem42;
    private int reserchItem43;
    private int reserchItem44;
    private int reserchItem45;
    private int reserchItem46;
    private int reserchItem47;
    private int reserchItem48;
    private int reserchItem49;
    private int reserchItem50;
    private int reserchItem51;
    private int reserchItem52;
    private int reserchItem53;
    private int reserchItem54;
    private int reserchItem55;
    private int reserchItem56;
    private int reserchItem57;
    private int reserchItem58;
    private int reserchItem59;
    private int reserchItem60;
    private int reserchItem61;
    private int reserchItem62;
    private int reserchItem63;
    private int reserchItem64;
    private int reserchItem65;
    private int reserchItem66;
    private int reserchItem67;
    private int reserchItem68;
    private int reserchItem69;
    private int reserchItem70;
    private int reserchItem71;
    private int reserchItem72;
    private int reserchItem73;
    private int reserchItem74;
    private int reserchItem75;
    private int reserchItem76;
    private int reserchItem77;
    private int reserchItem78;
    private int reserchItem79;
    private int reserchItem80;
    private int reserchItem81;
    private int reserchItem82;
    private int reserchItem83;
    private int reserchItem84;
    private int reserchItem85;
    private int reserchItem86;
    private int reserchItem87;
    private int reserchItem88;
    private int reserchItem89;
    private int reserchItem90;
    private int reserchItem91;
    private int reserchItem92;
    private int reserchItem93;
    private int reserchItem94;
    private int reserchItem95;
    private int reserchItem96;
    private int reserchItem97;
    private int reserchItem98;
    private int tokutenTotal1gun;
    private int tokutenTotal2gun;
    private int tokutenTotal3gun;
    private int tokutenTotal4gun;
    private int tokutenTotal5gun;
    private int tokutenTotal6gun;
    private int tokutenTotal7gun;

    /**
     * insertDantaiCdのgetメソッドです。
     * 
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     * 
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     * 
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     * 
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     * 
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @return 申請書管理番号
     */
    public DbUDD013ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(DbUDD013ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 要介護認定調査履歴番号のgetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @return 要介護認定調査履歴番号
     */
    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * 要介護認定調査履歴番号のsetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @param ninteichosaRirekiNo 要介護認定調査履歴番号
     */
    public void setNinteichosaRirekiNo(int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     * 
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     * 
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 素点項目01のgetメソッドです。
     * 
     * @return 素点項目01
     */
    public int getReserchItem01() {
        return reserchItem01;
    }

    /**
     * 素点項目01のsetメソッドです。
     * 
     * @param reserchItem01 素点項目01
     */
    public void setReserchItem01(int reserchItem01) {
        this.reserchItem01 = reserchItem01;
    }

    /**
     * 素点項目02のgetメソッドです。
     * 
     * @return 素点項目02
     */
    public int getReserchItem02() {
        return reserchItem02;
    }

    /**
     * 素点項目02のsetメソッドです。
     * 
     * @param reserchItem02 素点項目02
     */
    public void setReserchItem02(int reserchItem02) {
        this.reserchItem02 = reserchItem02;
    }

    /**
     * 素点項目03のgetメソッドです。
     * 
     * @return 素点項目03
     */
    public int getReserchItem03() {
        return reserchItem03;
    }

    /**
     * 素点項目03のsetメソッドです。
     * 
     * @param reserchItem03 素点項目03
     */
    public void setReserchItem03(int reserchItem03) {
        this.reserchItem03 = reserchItem03;
    }

    /**
     * 素点項目04のgetメソッドです。
     * 
     * @return 素点項目04
     */
    public int getReserchItem04() {
        return reserchItem04;
    }

    /**
     * 素点項目04のsetメソッドです。
     * 
     * @param reserchItem04 素点項目04
     */
    public void setReserchItem04(int reserchItem04) {
        this.reserchItem04 = reserchItem04;
    }

    /**
     * 素点項目05のgetメソッドです。
     * 
     * @return 素点項目05
     */
    public int getReserchItem05() {
        return reserchItem05;
    }

    /**
     * 素点項目05のsetメソッドです。
     * 
     * @param reserchItem05 素点項目05
     */
    public void setReserchItem05(int reserchItem05) {
        this.reserchItem05 = reserchItem05;
    }

    /**
     * 素点項目06のgetメソッドです。
     * 
     * @return 素点項目06
     */
    public int getReserchItem06() {
        return reserchItem06;
    }

    /**
     * 素点項目06のsetメソッドです。
     * 
     * @param reserchItem06 素点項目06
     */
    public void setReserchItem06(int reserchItem06) {
        this.reserchItem06 = reserchItem06;
    }

    /**
     * 素点項目07のgetメソッドです。
     * 
     * @return 素点項目07
     */
    public int getReserchItem07() {
        return reserchItem07;
    }

    /**
     * 素点項目07のsetメソッドです。
     * 
     * @param reserchItem07 素点項目07
     */
    public void setReserchItem07(int reserchItem07) {
        this.reserchItem07 = reserchItem07;
    }

    /**
     * 素点項目08のgetメソッドです。
     * 
     * @return 素点項目08
     */
    public int getReserchItem08() {
        return reserchItem08;
    }

    /**
     * 素点項目08のsetメソッドです。
     * 
     * @param reserchItem08 素点項目08
     */
    public void setReserchItem08(int reserchItem08) {
        this.reserchItem08 = reserchItem08;
    }

    /**
     * 素点項目09のgetメソッドです。
     * 
     * @return 素点項目09
     */
    public int getReserchItem09() {
        return reserchItem09;
    }

    /**
     * 素点項目09のsetメソッドです。
     * 
     * @param reserchItem09 素点項目09
     */
    public void setReserchItem09(int reserchItem09) {
        this.reserchItem09 = reserchItem09;
    }

    /**
     * 素点項目10のgetメソッドです。
     * 
     * @return 素点項目10
     */
    public int getReserchItem10() {
        return reserchItem10;
    }

    /**
     * 素点項目10のsetメソッドです。
     * 
     * @param reserchItem10 素点項目10
     */
    public void setReserchItem10(int reserchItem10) {
        this.reserchItem10 = reserchItem10;
    }

    /**
     * 素点項目11のgetメソッドです。
     * 
     * @return 素点項目11
     */
    public int getReserchItem11() {
        return reserchItem11;
    }

    /**
     * 素点項目11のsetメソッドです。
     * 
     * @param reserchItem11 素点項目11
     */
    public void setReserchItem11(int reserchItem11) {
        this.reserchItem11 = reserchItem11;
    }

    /**
     * 素点項目12のgetメソッドです。
     * 
     * @return 素点項目12
     */
    public int getReserchItem12() {
        return reserchItem12;
    }

    /**
     * 素点項目12のsetメソッドです。
     * 
     * @param reserchItem12 素点項目12
     */
    public void setReserchItem12(int reserchItem12) {
        this.reserchItem12 = reserchItem12;
    }

    /**
     * 素点項目13のgetメソッドです。
     * 
     * @return 素点項目13
     */
    public int getReserchItem13() {
        return reserchItem13;
    }

    /**
     * 素点項目13のsetメソッドです。
     * 
     * @param reserchItem13 素点項目13
     */
    public void setReserchItem13(int reserchItem13) {
        this.reserchItem13 = reserchItem13;
    }

    /**
     * 素点項目14のgetメソッドです。
     * 
     * @return 素点項目14
     */
    public int getReserchItem14() {
        return reserchItem14;
    }

    /**
     * 素点項目14のsetメソッドです。
     * 
     * @param reserchItem14 素点項目14
     */
    public void setReserchItem14(int reserchItem14) {
        this.reserchItem14 = reserchItem14;
    }

    /**
     * 素点項目15のgetメソッドです。
     * 
     * @return 素点項目15
     */
    public int getReserchItem15() {
        return reserchItem15;
    }

    /**
     * 素点項目15のsetメソッドです。
     * 
     * @param reserchItem15 素点項目15
     */
    public void setReserchItem15(int reserchItem15) {
        this.reserchItem15 = reserchItem15;
    }

    /**
     * 素点項目16のgetメソッドです。
     * 
     * @return 素点項目16
     */
    public int getReserchItem16() {
        return reserchItem16;
    }

    /**
     * 素点項目16のsetメソッドです。
     * 
     * @param reserchItem16 素点項目16
     */
    public void setReserchItem16(int reserchItem16) {
        this.reserchItem16 = reserchItem16;
    }

    /**
     * 素点項目17のgetメソッドです。
     * 
     * @return 素点項目17
     */
    public int getReserchItem17() {
        return reserchItem17;
    }

    /**
     * 素点項目17のsetメソッドです。
     * 
     * @param reserchItem17 素点項目17
     */
    public void setReserchItem17(int reserchItem17) {
        this.reserchItem17 = reserchItem17;
    }

    /**
     * 素点項目18のgetメソッドです。
     * 
     * @return 素点項目18
     */
    public int getReserchItem18() {
        return reserchItem18;
    }

    /**
     * 素点項目18のsetメソッドです。
     * 
     * @param reserchItem18 素点項目18
     */
    public void setReserchItem18(int reserchItem18) {
        this.reserchItem18 = reserchItem18;
    }

    /**
     * 素点項目19のgetメソッドです。
     * 
     * @return 素点項目19
     */
    public int getReserchItem19() {
        return reserchItem19;
    }

    /**
     * 素点項目19のsetメソッドです。
     * 
     * @param reserchItem19 素点項目19
     */
    public void setReserchItem19(int reserchItem19) {
        this.reserchItem19 = reserchItem19;
    }

    /**
     * 素点項目20のgetメソッドです。
     * 
     * @return 素点項目20
     */
    public int getReserchItem20() {
        return reserchItem20;
    }

    /**
     * 素点項目20のsetメソッドです。
     * 
     * @param reserchItem20 素点項目20
     */
    public void setReserchItem20(int reserchItem20) {
        this.reserchItem20 = reserchItem20;
    }

    /**
     * 素点項目21のgetメソッドです。
     * 
     * @return 素点項目21
     */
    public int getReserchItem21() {
        return reserchItem21;
    }

    /**
     * 素点項目21のsetメソッドです。
     * 
     * @param reserchItem21 素点項目21
     */
    public void setReserchItem21(int reserchItem21) {
        this.reserchItem21 = reserchItem21;
    }

    /**
     * 素点項目22のgetメソッドです。
     * 
     * @return 素点項目22
     */
    public int getReserchItem22() {
        return reserchItem22;
    }

    /**
     * 素点項目22のsetメソッドです。
     * 
     * @param reserchItem22 素点項目22
     */
    public void setReserchItem22(int reserchItem22) {
        this.reserchItem22 = reserchItem22;
    }

    /**
     * 素点項目23のgetメソッドです。
     * 
     * @return 素点項目23
     */
    public int getReserchItem23() {
        return reserchItem23;
    }

    /**
     * 素点項目23のsetメソッドです。
     * 
     * @param reserchItem23 素点項目23
     */
    public void setReserchItem23(int reserchItem23) {
        this.reserchItem23 = reserchItem23;
    }

    /**
     * 素点項目24のgetメソッドです。
     * 
     * @return 素点項目24
     */
    public int getReserchItem24() {
        return reserchItem24;
    }

    /**
     * 素点項目24のsetメソッドです。
     * 
     * @param reserchItem24 素点項目24
     */
    public void setReserchItem24(int reserchItem24) {
        this.reserchItem24 = reserchItem24;
    }

    /**
     * 素点項目25のgetメソッドです。
     * 
     * @return 素点項目25
     */
    public int getReserchItem25() {
        return reserchItem25;
    }

    /**
     * 素点項目25のsetメソッドです。
     * 
     * @param reserchItem25 素点項目25
     */
    public void setReserchItem25(int reserchItem25) {
        this.reserchItem25 = reserchItem25;
    }

    /**
     * 素点項目26のgetメソッドです。
     * 
     * @return 素点項目26
     */
    public int getReserchItem26() {
        return reserchItem26;
    }

    /**
     * 素点項目26のsetメソッドです。
     * 
     * @param reserchItem26 素点項目26
     */
    public void setReserchItem26(int reserchItem26) {
        this.reserchItem26 = reserchItem26;
    }

    /**
     * 素点項目27のgetメソッドです。
     * 
     * @return 素点項目27
     */
    public int getReserchItem27() {
        return reserchItem27;
    }

    /**
     * 素点項目27のsetメソッドです。
     * 
     * @param reserchItem27 素点項目27
     */
    public void setReserchItem27(int reserchItem27) {
        this.reserchItem27 = reserchItem27;
    }

    /**
     * 素点項目28のgetメソッドです。
     * 
     * @return 素点項目28
     */
    public int getReserchItem28() {
        return reserchItem28;
    }

    /**
     * 素点項目28のsetメソッドです。
     * 
     * @param reserchItem28 素点項目28
     */
    public void setReserchItem28(int reserchItem28) {
        this.reserchItem28 = reserchItem28;
    }

    /**
     * 素点項目29のgetメソッドです。
     * 
     * @return 素点項目29
     */
    public int getReserchItem29() {
        return reserchItem29;
    }

    /**
     * 素点項目29のsetメソッドです。
     * 
     * @param reserchItem29 素点項目29
     */
    public void setReserchItem29(int reserchItem29) {
        this.reserchItem29 = reserchItem29;
    }

    /**
     * 素点項目30のgetメソッドです。
     * 
     * @return 素点項目30
     */
    public int getReserchItem30() {
        return reserchItem30;
    }

    /**
     * 素点項目30のsetメソッドです。
     * 
     * @param reserchItem30 素点項目30
     */
    public void setReserchItem30(int reserchItem30) {
        this.reserchItem30 = reserchItem30;
    }

    /**
     * 素点項目31のgetメソッドです。
     * 
     * @return 素点項目31
     */
    public int getReserchItem31() {
        return reserchItem31;
    }

    /**
     * 素点項目31のsetメソッドです。
     * 
     * @param reserchItem31 素点項目31
     */
    public void setReserchItem31(int reserchItem31) {
        this.reserchItem31 = reserchItem31;
    }

    /**
     * 素点項目32のgetメソッドです。
     * 
     * @return 素点項目32
     */
    public int getReserchItem32() {
        return reserchItem32;
    }

    /**
     * 素点項目32のsetメソッドです。
     * 
     * @param reserchItem32 素点項目32
     */
    public void setReserchItem32(int reserchItem32) {
        this.reserchItem32 = reserchItem32;
    }

    /**
     * 素点項目33のgetメソッドです。
     * 
     * @return 素点項目33
     */
    public int getReserchItem33() {
        return reserchItem33;
    }

    /**
     * 素点項目33のsetメソッドです。
     * 
     * @param reserchItem33 素点項目33
     */
    public void setReserchItem33(int reserchItem33) {
        this.reserchItem33 = reserchItem33;
    }

    /**
     * 素点項目34のgetメソッドです。
     * 
     * @return 素点項目34
     */
    public int getReserchItem34() {
        return reserchItem34;
    }

    /**
     * 素点項目34のsetメソッドです。
     * 
     * @param reserchItem34 素点項目34
     */
    public void setReserchItem34(int reserchItem34) {
        this.reserchItem34 = reserchItem34;
    }

    /**
     * 素点項目35のgetメソッドです。
     * 
     * @return 素点項目35
     */
    public int getReserchItem35() {
        return reserchItem35;
    }

    /**
     * 素点項目35のsetメソッドです。
     * 
     * @param reserchItem35 素点項目35
     */
    public void setReserchItem35(int reserchItem35) {
        this.reserchItem35 = reserchItem35;
    }

    /**
     * 素点項目36のgetメソッドです。
     * 
     * @return 素点項目36
     */
    public int getReserchItem36() {
        return reserchItem36;
    }

    /**
     * 素点項目36のsetメソッドです。
     * 
     * @param reserchItem36 素点項目36
     */
    public void setReserchItem36(int reserchItem36) {
        this.reserchItem36 = reserchItem36;
    }

    /**
     * 素点項目37のgetメソッドです。
     * 
     * @return 素点項目37
     */
    public int getReserchItem37() {
        return reserchItem37;
    }

    /**
     * 素点項目37のsetメソッドです。
     * 
     * @param reserchItem37 素点項目37
     */
    public void setReserchItem37(int reserchItem37) {
        this.reserchItem37 = reserchItem37;
    }

    /**
     * 素点項目38のgetメソッドです。
     * 
     * @return 素点項目38
     */
    public int getReserchItem38() {
        return reserchItem38;
    }

    /**
     * 素点項目38のsetメソッドです。
     * 
     * @param reserchItem38 素点項目38
     */
    public void setReserchItem38(int reserchItem38) {
        this.reserchItem38 = reserchItem38;
    }

    /**
     * 素点項目39のgetメソッドです。
     * 
     * @return 素点項目39
     */
    public int getReserchItem39() {
        return reserchItem39;
    }

    /**
     * 素点項目39のsetメソッドです。
     * 
     * @param reserchItem39 素点項目39
     */
    public void setReserchItem39(int reserchItem39) {
        this.reserchItem39 = reserchItem39;
    }

    /**
     * 素点項目40のgetメソッドです。
     * 
     * @return 素点項目40
     */
    public int getReserchItem40() {
        return reserchItem40;
    }

    /**
     * 素点項目40のsetメソッドです。
     * 
     * @param reserchItem40 素点項目40
     */
    public void setReserchItem40(int reserchItem40) {
        this.reserchItem40 = reserchItem40;
    }

    /**
     * 素点項目41のgetメソッドです。
     * 
     * @return 素点項目41
     */
    public int getReserchItem41() {
        return reserchItem41;
    }

    /**
     * 素点項目41のsetメソッドです。
     * 
     * @param reserchItem41 素点項目41
     */
    public void setReserchItem41(int reserchItem41) {
        this.reserchItem41 = reserchItem41;
    }

    /**
     * 素点項目42のgetメソッドです。
     * 
     * @return 素点項目42
     */
    public int getReserchItem42() {
        return reserchItem42;
    }

    /**
     * 素点項目42のsetメソッドです。
     * 
     * @param reserchItem42 素点項目42
     */
    public void setReserchItem42(int reserchItem42) {
        this.reserchItem42 = reserchItem42;
    }

    /**
     * 素点項目43のgetメソッドです。
     * 
     * @return 素点項目43
     */
    public int getReserchItem43() {
        return reserchItem43;
    }

    /**
     * 素点項目43のsetメソッドです。
     * 
     * @param reserchItem43 素点項目43
     */
    public void setReserchItem43(int reserchItem43) {
        this.reserchItem43 = reserchItem43;
    }

    /**
     * 素点項目44のgetメソッドです。
     * 
     * @return 素点項目44
     */
    public int getReserchItem44() {
        return reserchItem44;
    }

    /**
     * 素点項目44のsetメソッドです。
     * 
     * @param reserchItem44 素点項目44
     */
    public void setReserchItem44(int reserchItem44) {
        this.reserchItem44 = reserchItem44;
    }

    /**
     * 素点項目45のgetメソッドです。
     * 
     * @return 素点項目45
     */
    public int getReserchItem45() {
        return reserchItem45;
    }

    /**
     * 素点項目45のsetメソッドです。
     * 
     * @param reserchItem45 素点項目45
     */
    public void setReserchItem45(int reserchItem45) {
        this.reserchItem45 = reserchItem45;
    }

    /**
     * 素点項目46のgetメソッドです。
     * 
     * @return 素点項目46
     */
    public int getReserchItem46() {
        return reserchItem46;
    }

    /**
     * 素点項目46のsetメソッドです。
     * 
     * @param reserchItem46 素点項目46
     */
    public void setReserchItem46(int reserchItem46) {
        this.reserchItem46 = reserchItem46;
    }

    /**
     * 素点項目47のgetメソッドです。
     * 
     * @return 素点項目47
     */
    public int getReserchItem47() {
        return reserchItem47;
    }

    /**
     * 素点項目47のsetメソッドです。
     * 
     * @param reserchItem47 素点項目47
     */
    public void setReserchItem47(int reserchItem47) {
        this.reserchItem47 = reserchItem47;
    }

    /**
     * 素点項目48のgetメソッドです。
     * 
     * @return 素点項目48
     */
    public int getReserchItem48() {
        return reserchItem48;
    }

    /**
     * 素点項目48のsetメソッドです。
     * 
     * @param reserchItem48 素点項目48
     */
    public void setReserchItem48(int reserchItem48) {
        this.reserchItem48 = reserchItem48;
    }

    /**
     * 素点項目49のgetメソッドです。
     * 
     * @return 素点項目49
     */
    public int getReserchItem49() {
        return reserchItem49;
    }

    /**
     * 素点項目49のsetメソッドです。
     * 
     * @param reserchItem49 素点項目49
     */
    public void setReserchItem49(int reserchItem49) {
        this.reserchItem49 = reserchItem49;
    }

    /**
     * 素点項目50のgetメソッドです。
     * 
     * @return 素点項目50
     */
    public int getReserchItem50() {
        return reserchItem50;
    }

    /**
     * 素点項目50のsetメソッドです。
     * 
     * @param reserchItem50 素点項目50
     */
    public void setReserchItem50(int reserchItem50) {
        this.reserchItem50 = reserchItem50;
    }

    /**
     * 素点項目51のgetメソッドです。
     * 
     * @return 素点項目51
     */
    public int getReserchItem51() {
        return reserchItem51;
    }

    /**
     * 素点項目51のsetメソッドです。
     * 
     * @param reserchItem51 素点項目51
     */
    public void setReserchItem51(int reserchItem51) {
        this.reserchItem51 = reserchItem51;
    }

    /**
     * 素点項目52のgetメソッドです。
     * 
     * @return 素点項目52
     */
    public int getReserchItem52() {
        return reserchItem52;
    }

    /**
     * 素点項目52のsetメソッドです。
     * 
     * @param reserchItem52 素点項目52
     */
    public void setReserchItem52(int reserchItem52) {
        this.reserchItem52 = reserchItem52;
    }

    /**
     * 素点項目53のgetメソッドです。
     * 
     * @return 素点項目53
     */
    public int getReserchItem53() {
        return reserchItem53;
    }

    /**
     * 素点項目53のsetメソッドです。
     * 
     * @param reserchItem53 素点項目53
     */
    public void setReserchItem53(int reserchItem53) {
        this.reserchItem53 = reserchItem53;
    }

    /**
     * 素点項目54のgetメソッドです。
     * 
     * @return 素点項目54
     */
    public int getReserchItem54() {
        return reserchItem54;
    }

    /**
     * 素点項目54のsetメソッドです。
     * 
     * @param reserchItem54 素点項目54
     */
    public void setReserchItem54(int reserchItem54) {
        this.reserchItem54 = reserchItem54;
    }

    /**
     * 素点項目55のgetメソッドです。
     * 
     * @return 素点項目55
     */
    public int getReserchItem55() {
        return reserchItem55;
    }

    /**
     * 素点項目55のsetメソッドです。
     * 
     * @param reserchItem55 素点項目55
     */
    public void setReserchItem55(int reserchItem55) {
        this.reserchItem55 = reserchItem55;
    }

    /**
     * 素点項目56のgetメソッドです。
     * 
     * @return 素点項目56
     */
    public int getReserchItem56() {
        return reserchItem56;
    }

    /**
     * 素点項目56のsetメソッドです。
     * 
     * @param reserchItem56 素点項目56
     */
    public void setReserchItem56(int reserchItem56) {
        this.reserchItem56 = reserchItem56;
    }

    /**
     * 素点項目57のgetメソッドです。
     * 
     * @return 素点項目57
     */
    public int getReserchItem57() {
        return reserchItem57;
    }

    /**
     * 素点項目57のsetメソッドです。
     * 
     * @param reserchItem57 素点項目57
     */
    public void setReserchItem57(int reserchItem57) {
        this.reserchItem57 = reserchItem57;
    }

    /**
     * 素点項目58のgetメソッドです。
     * 
     * @return 素点項目58
     */
    public int getReserchItem58() {
        return reserchItem58;
    }

    /**
     * 素点項目58のsetメソッドです。
     * 
     * @param reserchItem58 素点項目58
     */
    public void setReserchItem58(int reserchItem58) {
        this.reserchItem58 = reserchItem58;
    }

    /**
     * 素点項目59のgetメソッドです。
     * 
     * @return 素点項目59
     */
    public int getReserchItem59() {
        return reserchItem59;
    }

    /**
     * 素点項目59のsetメソッドです。
     * 
     * @param reserchItem59 素点項目59
     */
    public void setReserchItem59(int reserchItem59) {
        this.reserchItem59 = reserchItem59;
    }

    /**
     * 素点項目60のgetメソッドです。
     * 
     * @return 素点項目60
     */
    public int getReserchItem60() {
        return reserchItem60;
    }

    /**
     * 素点項目60のsetメソッドです。
     * 
     * @param reserchItem60 素点項目60
     */
    public void setReserchItem60(int reserchItem60) {
        this.reserchItem60 = reserchItem60;
    }

    /**
     * 素点項目61のgetメソッドです。
     * 
     * @return 素点項目61
     */
    public int getReserchItem61() {
        return reserchItem61;
    }

    /**
     * 素点項目61のsetメソッドです。
     * 
     * @param reserchItem61 素点項目61
     */
    public void setReserchItem61(int reserchItem61) {
        this.reserchItem61 = reserchItem61;
    }

    /**
     * 素点項目62のgetメソッドです。
     * 
     * @return 素点項目62
     */
    public int getReserchItem62() {
        return reserchItem62;
    }

    /**
     * 素点項目62のsetメソッドです。
     * 
     * @param reserchItem62 素点項目62
     */
    public void setReserchItem62(int reserchItem62) {
        this.reserchItem62 = reserchItem62;
    }

    /**
     * 素点項目63のgetメソッドです。
     * 
     * @return 素点項目63
     */
    public int getReserchItem63() {
        return reserchItem63;
    }

    /**
     * 素点項目63のsetメソッドです。
     * 
     * @param reserchItem63 素点項目63
     */
    public void setReserchItem63(int reserchItem63) {
        this.reserchItem63 = reserchItem63;
    }

    /**
     * 素点項目64のgetメソッドです。
     * 
     * @return 素点項目64
     */
    public int getReserchItem64() {
        return reserchItem64;
    }

    /**
     * 素点項目64のsetメソッドです。
     * 
     * @param reserchItem64 素点項目64
     */
    public void setReserchItem64(int reserchItem64) {
        this.reserchItem64 = reserchItem64;
    }

    /**
     * 素点項目65のgetメソッドです。
     * 
     * @return 素点項目65
     */
    public int getReserchItem65() {
        return reserchItem65;
    }

    /**
     * 素点項目65のsetメソッドです。
     * 
     * @param reserchItem65 素点項目65
     */
    public void setReserchItem65(int reserchItem65) {
        this.reserchItem65 = reserchItem65;
    }

    /**
     * 素点項目66のgetメソッドです。
     * 
     * @return 素点項目66
     */
    public int getReserchItem66() {
        return reserchItem66;
    }

    /**
     * 素点項目66のsetメソッドです。
     * 
     * @param reserchItem66 素点項目66
     */
    public void setReserchItem66(int reserchItem66) {
        this.reserchItem66 = reserchItem66;
    }

    /**
     * 素点項目67のgetメソッドです。
     * 
     * @return 素点項目67
     */
    public int getReserchItem67() {
        return reserchItem67;
    }

    /**
     * 素点項目67のsetメソッドです。
     * 
     * @param reserchItem67 素点項目67
     */
    public void setReserchItem67(int reserchItem67) {
        this.reserchItem67 = reserchItem67;
    }

    /**
     * 素点項目68のgetメソッドです。
     * 
     * @return 素点項目68
     */
    public int getReserchItem68() {
        return reserchItem68;
    }

    /**
     * 素点項目68のsetメソッドです。
     * 
     * @param reserchItem68 素点項目68
     */
    public void setReserchItem68(int reserchItem68) {
        this.reserchItem68 = reserchItem68;
    }

    /**
     * 素点項目69のgetメソッドです。
     * 
     * @return 素点項目69
     */
    public int getReserchItem69() {
        return reserchItem69;
    }

    /**
     * 素点項目69のsetメソッドです。
     * 
     * @param reserchItem69 素点項目69
     */
    public void setReserchItem69(int reserchItem69) {
        this.reserchItem69 = reserchItem69;
    }

    /**
     * 素点項目70のgetメソッドです。
     * 
     * @return 素点項目70
     */
    public int getReserchItem70() {
        return reserchItem70;
    }

    /**
     * 素点項目70のsetメソッドです。
     * 
     * @param reserchItem70 素点項目70
     */
    public void setReserchItem70(int reserchItem70) {
        this.reserchItem70 = reserchItem70;
    }

    /**
     * 素点項目71のgetメソッドです。
     * 
     * @return 素点項目71
     */
    public int getReserchItem71() {
        return reserchItem71;
    }

    /**
     * 素点項目71のsetメソッドです。
     * 
     * @param reserchItem71 素点項目71
     */
    public void setReserchItem71(int reserchItem71) {
        this.reserchItem71 = reserchItem71;
    }

    /**
     * 素点項目72のgetメソッドです。
     * 
     * @return 素点項目72
     */
    public int getReserchItem72() {
        return reserchItem72;
    }

    /**
     * 素点項目72のsetメソッドです。
     * 
     * @param reserchItem72 素点項目72
     */
    public void setReserchItem72(int reserchItem72) {
        this.reserchItem72 = reserchItem72;
    }

    /**
     * 素点項目73のgetメソッドです。
     * 
     * @return 素点項目73
     */
    public int getReserchItem73() {
        return reserchItem73;
    }

    /**
     * 素点項目73のsetメソッドです。
     * 
     * @param reserchItem73 素点項目73
     */
    public void setReserchItem73(int reserchItem73) {
        this.reserchItem73 = reserchItem73;
    }

    /**
     * 素点項目74のgetメソッドです。
     * 
     * @return 素点項目74
     */
    public int getReserchItem74() {
        return reserchItem74;
    }

    /**
     * 素点項目74のsetメソッドです。
     * 
     * @param reserchItem74 素点項目74
     */
    public void setReserchItem74(int reserchItem74) {
        this.reserchItem74 = reserchItem74;
    }

    /**
     * 素点項目75のgetメソッドです。
     * 
     * @return 素点項目75
     */
    public int getReserchItem75() {
        return reserchItem75;
    }

    /**
     * 素点項目75のsetメソッドです。
     * 
     * @param reserchItem75 素点項目75
     */
    public void setReserchItem75(int reserchItem75) {
        this.reserchItem75 = reserchItem75;
    }

    /**
     * 素点項目76のgetメソッドです。
     * 
     * @return 素点項目76
     */
    public int getReserchItem76() {
        return reserchItem76;
    }

    /**
     * 素点項目76のsetメソッドです。
     * 
     * @param reserchItem76 素点項目76
     */
    public void setReserchItem76(int reserchItem76) {
        this.reserchItem76 = reserchItem76;
    }

    /**
     * 素点項目77のgetメソッドです。
     * 
     * @return 素点項目77
     */
    public int getReserchItem77() {
        return reserchItem77;
    }

    /**
     * 素点項目77のsetメソッドです。
     * 
     * @param reserchItem77 素点項目77
     */
    public void setReserchItem77(int reserchItem77) {
        this.reserchItem77 = reserchItem77;
    }

    /**
     * 素点項目78のgetメソッドです。
     * 
     * @return 素点項目78
     */
    public int getReserchItem78() {
        return reserchItem78;
    }

    /**
     * 素点項目78のsetメソッドです。
     * 
     * @param reserchItem78 素点項目78
     */
    public void setReserchItem78(int reserchItem78) {
        this.reserchItem78 = reserchItem78;
    }

    /**
     * 素点項目79のgetメソッドです。
     * 
     * @return 素点項目79
     */
    public int getReserchItem79() {
        return reserchItem79;
    }

    /**
     * 素点項目79のsetメソッドです。
     * 
     * @param reserchItem79 素点項目79
     */
    public void setReserchItem79(int reserchItem79) {
        this.reserchItem79 = reserchItem79;
    }

    /**
     * 素点項目80のgetメソッドです。
     * 
     * @return 素点項目80
     */
    public int getReserchItem80() {
        return reserchItem80;
    }

    /**
     * 素点項目80のsetメソッドです。
     * 
     * @param reserchItem80 素点項目80
     */
    public void setReserchItem80(int reserchItem80) {
        this.reserchItem80 = reserchItem80;
    }

    /**
     * 素点項目81のgetメソッドです。
     * 
     * @return 素点項目81
     */
    public int getReserchItem81() {
        return reserchItem81;
    }

    /**
     * 素点項目81のsetメソッドです。
     * 
     * @param reserchItem81 素点項目81
     */
    public void setReserchItem81(int reserchItem81) {
        this.reserchItem81 = reserchItem81;
    }

    /**
     * 素点項目82のgetメソッドです。
     * 
     * @return 素点項目82
     */
    public int getReserchItem82() {
        return reserchItem82;
    }

    /**
     * 素点項目82のsetメソッドです。
     * 
     * @param reserchItem82 素点項目82
     */
    public void setReserchItem82(int reserchItem82) {
        this.reserchItem82 = reserchItem82;
    }

    /**
     * 素点項目83のgetメソッドです。
     * 
     * @return 素点項目83
     */
    public int getReserchItem83() {
        return reserchItem83;
    }

    /**
     * 素点項目83のsetメソッドです。
     * 
     * @param reserchItem83 素点項目83
     */
    public void setReserchItem83(int reserchItem83) {
        this.reserchItem83 = reserchItem83;
    }

    /**
     * 素点項目84のgetメソッドです。
     * 
     * @return 素点項目84
     */
    public int getReserchItem84() {
        return reserchItem84;
    }

    /**
     * 素点項目84のsetメソッドです。
     * 
     * @param reserchItem84 素点項目84
     */
    public void setReserchItem84(int reserchItem84) {
        this.reserchItem84 = reserchItem84;
    }

    /**
     * 素点項目85のgetメソッドです。
     * 
     * @return 素点項目85
     */
    public int getReserchItem85() {
        return reserchItem85;
    }

    /**
     * 素点項目85のsetメソッドです。
     * 
     * @param reserchItem85 素点項目85
     */
    public void setReserchItem85(int reserchItem85) {
        this.reserchItem85 = reserchItem85;
    }

    /**
     * 素点項目86のgetメソッドです。
     * 
     * @return 素点項目86
     */
    public int getReserchItem86() {
        return reserchItem86;
    }

    /**
     * 素点項目86のsetメソッドです。
     * 
     * @param reserchItem86 素点項目86
     */
    public void setReserchItem86(int reserchItem86) {
        this.reserchItem86 = reserchItem86;
    }

    /**
     * 素点項目87のgetメソッドです。
     * 
     * @return 素点項目87
     */
    public int getReserchItem87() {
        return reserchItem87;
    }

    /**
     * 素点項目87のsetメソッドです。
     * 
     * @param reserchItem87 素点項目87
     */
    public void setReserchItem87(int reserchItem87) {
        this.reserchItem87 = reserchItem87;
    }

    /**
     * 素点項目88のgetメソッドです。
     * 
     * @return 素点項目88
     */
    public int getReserchItem88() {
        return reserchItem88;
    }

    /**
     * 素点項目88のsetメソッドです。
     * 
     * @param reserchItem88 素点項目88
     */
    public void setReserchItem88(int reserchItem88) {
        this.reserchItem88 = reserchItem88;
    }

    /**
     * 素点項目89のgetメソッドです。
     * 
     * @return 素点項目89
     */
    public int getReserchItem89() {
        return reserchItem89;
    }

    /**
     * 素点項目89のsetメソッドです。
     * 
     * @param reserchItem89 素点項目89
     */
    public void setReserchItem89(int reserchItem89) {
        this.reserchItem89 = reserchItem89;
    }

    /**
     * 素点項目90のgetメソッドです。
     * 
     * @return 素点項目90
     */
    public int getReserchItem90() {
        return reserchItem90;
    }

    /**
     * 素点項目90のsetメソッドです。
     * 
     * @param reserchItem90 素点項目90
     */
    public void setReserchItem90(int reserchItem90) {
        this.reserchItem90 = reserchItem90;
    }

    /**
     * 素点項目91のgetメソッドです。
     * 
     * @return 素点項目91
     */
    public int getReserchItem91() {
        return reserchItem91;
    }

    /**
     * 素点項目91のsetメソッドです。
     * 
     * @param reserchItem91 素点項目91
     */
    public void setReserchItem91(int reserchItem91) {
        this.reserchItem91 = reserchItem91;
    }

    /**
     * 素点項目92のgetメソッドです。
     * 
     * @return 素点項目92
     */
    public int getReserchItem92() {
        return reserchItem92;
    }

    /**
     * 素点項目92のsetメソッドです。
     * 
     * @param reserchItem92 素点項目92
     */
    public void setReserchItem92(int reserchItem92) {
        this.reserchItem92 = reserchItem92;
    }

    /**
     * 素点項目93のgetメソッドです。
     * 
     * @return 素点項目93
     */
    public int getReserchItem93() {
        return reserchItem93;
    }

    /**
     * 素点項目93のsetメソッドです。
     * 
     * @param reserchItem93 素点項目93
     */
    public void setReserchItem93(int reserchItem93) {
        this.reserchItem93 = reserchItem93;
    }

    /**
     * 素点項目94のgetメソッドです。
     * 
     * @return 素点項目94
     */
    public int getReserchItem94() {
        return reserchItem94;
    }

    /**
     * 素点項目94のsetメソッドです。
     * 
     * @param reserchItem94 素点項目94
     */
    public void setReserchItem94(int reserchItem94) {
        this.reserchItem94 = reserchItem94;
    }

    /**
     * 素点項目95のgetメソッドです。
     * 
     * @return 素点項目95
     */
    public int getReserchItem95() {
        return reserchItem95;
    }

    /**
     * 素点項目95のsetメソッドです。
     * 
     * @param reserchItem95 素点項目95
     */
    public void setReserchItem95(int reserchItem95) {
        this.reserchItem95 = reserchItem95;
    }

    /**
     * 素点項目96のgetメソッドです。
     * 
     * @return 素点項目96
     */
    public int getReserchItem96() {
        return reserchItem96;
    }

    /**
     * 素点項目96のsetメソッドです。
     * 
     * @param reserchItem96 素点項目96
     */
    public void setReserchItem96(int reserchItem96) {
        this.reserchItem96 = reserchItem96;
    }

    /**
     * 素点項目97のgetメソッドです。
     * 
     * @return 素点項目97
     */
    public int getReserchItem97() {
        return reserchItem97;
    }

    /**
     * 素点項目97のsetメソッドです。
     * 
     * @param reserchItem97 素点項目97
     */
    public void setReserchItem97(int reserchItem97) {
        this.reserchItem97 = reserchItem97;
    }

    /**
     * 素点項目98のgetメソッドです。
     * 
     * @return 素点項目98
     */
    public int getReserchItem98() {
        return reserchItem98;
    }

    /**
     * 素点項目98のsetメソッドです。
     * 
     * @param reserchItem98 素点項目98
     */
    public void setReserchItem98(int reserchItem98) {
        this.reserchItem98 = reserchItem98;
    }

    /**
     * 素点合計　第１郡のgetメソッドです。
     * 
     * @return 素点合計　第１郡
     */
    public int getTokutenTotal1gun() {
        return tokutenTotal1gun;
    }

    /**
     * 素点合計　第１郡のsetメソッドです。
     * 
     * @param tokutenTotal1gun 素点合計　第１郡
     */
    public void setTokutenTotal1gun(int tokutenTotal1gun) {
        this.tokutenTotal1gun = tokutenTotal1gun;
    }

    /**
     * 素点合計　第２郡のgetメソッドです。
     * 
     * @return 素点合計　第２郡
     */
    public int getTokutenTotal2gun() {
        return tokutenTotal2gun;
    }

    /**
     * 素点合計　第２郡のsetメソッドです。
     * 
     * @param tokutenTotal2gun 素点合計　第２郡
     */
    public void setTokutenTotal2gun(int tokutenTotal2gun) {
        this.tokutenTotal2gun = tokutenTotal2gun;
    }

    /**
     * 素点合計　第３郡のgetメソッドです。
     * 
     * @return 素点合計　第３郡
     */
    public int getTokutenTotal3gun() {
        return tokutenTotal3gun;
    }

    /**
     * 素点合計　第３郡のsetメソッドです。
     * 
     * @param tokutenTotal3gun 素点合計　第３郡
     */
    public void setTokutenTotal3gun(int tokutenTotal3gun) {
        this.tokutenTotal3gun = tokutenTotal3gun;
    }

    /**
     * 素点合計　第４郡のgetメソッドです。
     * 
     * @return 素点合計　第４郡
     */
    public int getTokutenTotal4gun() {
        return tokutenTotal4gun;
    }

    /**
     * 素点合計　第４郡のsetメソッドです。
     * 
     * @param tokutenTotal4gun 素点合計　第４郡
     */
    public void setTokutenTotal4gun(int tokutenTotal4gun) {
        this.tokutenTotal4gun = tokutenTotal4gun;
    }

    /**
     * 素点合計　第５郡のgetメソッドです。
     * 
     * @return 素点合計　第５郡
     */
    public int getTokutenTotal5gun() {
        return tokutenTotal5gun;
    }

    /**
     * 素点合計　第５郡のsetメソッドです。
     * 
     * @param tokutenTotal5gun 素点合計　第５郡
     */
    public void setTokutenTotal5gun(int tokutenTotal5gun) {
        this.tokutenTotal5gun = tokutenTotal5gun;
    }

    /**
     * 素点合計　第６郡のgetメソッドです。
     * 
     * @return 素点合計　第６郡
     */
    public int getTokutenTotal6gun() {
        return tokutenTotal6gun;
    }

    /**
     * 素点合計　第６郡のsetメソッドです。
     * 
     * @param tokutenTotal6gun 素点合計　第６郡
     */
    public void setTokutenTotal6gun(int tokutenTotal6gun) {
        this.tokutenTotal6gun = tokutenTotal6gun;
    }

    /**
     * 素点合計　第７郡のgetメソッドです。
     * 
     * @return 素点合計　第７郡
     */
    public int getTokutenTotal7gun() {
        return tokutenTotal7gun;
    }

    /**
     * 素点合計　第７郡のsetメソッドです。
     * 
     * @param tokutenTotal7gun 素点合計　第７郡
     */
    public void setTokutenTotal7gun(int tokutenTotal7gun) {
        this.tokutenTotal7gun = tokutenTotal7gun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5204NinteichosahyoKihonChosaScore2006AEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5204NinteichosahyoKihonChosaScore2006AEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5204NinteichosahyoKihonChosaScore2006AEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5204NinteichosahyoKihonChosaScore2006AEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.reserchItem01 = entity.reserchItem01;
        this.reserchItem02 = entity.reserchItem02;
        this.reserchItem03 = entity.reserchItem03;
        this.reserchItem04 = entity.reserchItem04;
        this.reserchItem05 = entity.reserchItem05;
        this.reserchItem06 = entity.reserchItem06;
        this.reserchItem07 = entity.reserchItem07;
        this.reserchItem08 = entity.reserchItem08;
        this.reserchItem09 = entity.reserchItem09;
        this.reserchItem10 = entity.reserchItem10;
        this.reserchItem11 = entity.reserchItem11;
        this.reserchItem12 = entity.reserchItem12;
        this.reserchItem13 = entity.reserchItem13;
        this.reserchItem14 = entity.reserchItem14;
        this.reserchItem15 = entity.reserchItem15;
        this.reserchItem16 = entity.reserchItem16;
        this.reserchItem17 = entity.reserchItem17;
        this.reserchItem18 = entity.reserchItem18;
        this.reserchItem19 = entity.reserchItem19;
        this.reserchItem20 = entity.reserchItem20;
        this.reserchItem21 = entity.reserchItem21;
        this.reserchItem22 = entity.reserchItem22;
        this.reserchItem23 = entity.reserchItem23;
        this.reserchItem24 = entity.reserchItem24;
        this.reserchItem25 = entity.reserchItem25;
        this.reserchItem26 = entity.reserchItem26;
        this.reserchItem27 = entity.reserchItem27;
        this.reserchItem28 = entity.reserchItem28;
        this.reserchItem29 = entity.reserchItem29;
        this.reserchItem30 = entity.reserchItem30;
        this.reserchItem31 = entity.reserchItem31;
        this.reserchItem32 = entity.reserchItem32;
        this.reserchItem33 = entity.reserchItem33;
        this.reserchItem34 = entity.reserchItem34;
        this.reserchItem35 = entity.reserchItem35;
        this.reserchItem36 = entity.reserchItem36;
        this.reserchItem37 = entity.reserchItem37;
        this.reserchItem38 = entity.reserchItem38;
        this.reserchItem39 = entity.reserchItem39;
        this.reserchItem40 = entity.reserchItem40;
        this.reserchItem41 = entity.reserchItem41;
        this.reserchItem42 = entity.reserchItem42;
        this.reserchItem43 = entity.reserchItem43;
        this.reserchItem44 = entity.reserchItem44;
        this.reserchItem45 = entity.reserchItem45;
        this.reserchItem46 = entity.reserchItem46;
        this.reserchItem47 = entity.reserchItem47;
        this.reserchItem48 = entity.reserchItem48;
        this.reserchItem49 = entity.reserchItem49;
        this.reserchItem50 = entity.reserchItem50;
        this.reserchItem51 = entity.reserchItem51;
        this.reserchItem52 = entity.reserchItem52;
        this.reserchItem53 = entity.reserchItem53;
        this.reserchItem54 = entity.reserchItem54;
        this.reserchItem55 = entity.reserchItem55;
        this.reserchItem56 = entity.reserchItem56;
        this.reserchItem57 = entity.reserchItem57;
        this.reserchItem58 = entity.reserchItem58;
        this.reserchItem59 = entity.reserchItem59;
        this.reserchItem60 = entity.reserchItem60;
        this.reserchItem61 = entity.reserchItem61;
        this.reserchItem62 = entity.reserchItem62;
        this.reserchItem63 = entity.reserchItem63;
        this.reserchItem64 = entity.reserchItem64;
        this.reserchItem65 = entity.reserchItem65;
        this.reserchItem66 = entity.reserchItem66;
        this.reserchItem67 = entity.reserchItem67;
        this.reserchItem68 = entity.reserchItem68;
        this.reserchItem69 = entity.reserchItem69;
        this.reserchItem70 = entity.reserchItem70;
        this.reserchItem71 = entity.reserchItem71;
        this.reserchItem72 = entity.reserchItem72;
        this.reserchItem73 = entity.reserchItem73;
        this.reserchItem74 = entity.reserchItem74;
        this.reserchItem75 = entity.reserchItem75;
        this.reserchItem76 = entity.reserchItem76;
        this.reserchItem77 = entity.reserchItem77;
        this.reserchItem78 = entity.reserchItem78;
        this.reserchItem79 = entity.reserchItem79;
        this.reserchItem80 = entity.reserchItem80;
        this.reserchItem81 = entity.reserchItem81;
        this.reserchItem82 = entity.reserchItem82;
        this.reserchItem83 = entity.reserchItem83;
        this.reserchItem84 = entity.reserchItem84;
        this.reserchItem85 = entity.reserchItem85;
        this.reserchItem86 = entity.reserchItem86;
        this.reserchItem87 = entity.reserchItem87;
        this.reserchItem88 = entity.reserchItem88;
        this.reserchItem89 = entity.reserchItem89;
        this.reserchItem90 = entity.reserchItem90;
        this.reserchItem91 = entity.reserchItem91;
        this.reserchItem92 = entity.reserchItem92;
        this.reserchItem93 = entity.reserchItem93;
        this.reserchItem94 = entity.reserchItem94;
        this.reserchItem95 = entity.reserchItem95;
        this.reserchItem96 = entity.reserchItem96;
        this.reserchItem97 = entity.reserchItem97;
        this.reserchItem98 = entity.reserchItem98;
        this.tokutenTotal1gun = entity.tokutenTotal1gun;
        this.tokutenTotal2gun = entity.tokutenTotal2gun;
        this.tokutenTotal3gun = entity.tokutenTotal3gun;
        this.tokutenTotal4gun = entity.tokutenTotal4gun;
        this.tokutenTotal5gun = entity.tokutenTotal5gun;
        this.tokutenTotal6gun = entity.tokutenTotal6gun;
        this.tokutenTotal7gun = entity.tokutenTotal7gun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, koroshoIfShikibetsuCode, reserchItem01, reserchItem02, reserchItem03, reserchItem04, reserchItem05, reserchItem06, reserchItem07, reserchItem08, reserchItem09, reserchItem10, reserchItem11, reserchItem12, reserchItem13, reserchItem14, reserchItem15, reserchItem16, reserchItem17, reserchItem18, reserchItem19, reserchItem20, reserchItem21, reserchItem22, reserchItem23, reserchItem24, reserchItem25, reserchItem26, reserchItem27, reserchItem28, reserchItem29, reserchItem30, reserchItem31, reserchItem32, reserchItem33, reserchItem34, reserchItem35, reserchItem36, reserchItem37, reserchItem38, reserchItem39, reserchItem40, reserchItem41, reserchItem42, reserchItem43, reserchItem44, reserchItem45, reserchItem46, reserchItem47, reserchItem48, reserchItem49, reserchItem50, reserchItem51, reserchItem52, reserchItem53, reserchItem54, reserchItem55, reserchItem56, reserchItem57, reserchItem58, reserchItem59, reserchItem60, reserchItem61, reserchItem62, reserchItem63, reserchItem64, reserchItem65, reserchItem66, reserchItem67, reserchItem68, reserchItem69, reserchItem70, reserchItem71, reserchItem72, reserchItem73, reserchItem74, reserchItem75, reserchItem76, reserchItem77, reserchItem78, reserchItem79, reserchItem80, reserchItem81, reserchItem82, reserchItem83, reserchItem84, reserchItem85, reserchItem86, reserchItem87, reserchItem88, reserchItem89, reserchItem90, reserchItem91, reserchItem92, reserchItem93, reserchItem94, reserchItem95, reserchItem96, reserchItem97, reserchItem98, tokutenTotal1gun, tokutenTotal2gun, tokutenTotal3gun, tokutenTotal4gun, tokutenTotal5gun, tokutenTotal6gun, tokutenTotal7gun);
    }

// </editor-fold>
}
