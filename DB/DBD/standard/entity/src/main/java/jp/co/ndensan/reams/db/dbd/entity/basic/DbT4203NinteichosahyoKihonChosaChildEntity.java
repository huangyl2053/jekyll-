package jp.co.ndensan.reams.db.dbd.entity.basic;

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
 * 認定調査票（基本調査）（子）テーブルのエンティティクラスです。
 */
public class DbT4203NinteichosahyoKihonChosaChildEntity extends DbTableEntityBase<DbT4203NinteichosahyoKihonChosaChildEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4203NinteichosahyoKihonChosaChild");

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
    private RString reserchItem01;
    private RString reserchItem02;
    private RString reserchItem03;
    private RString reserchItem04;
    private RString reserchItem05;
    private RString reserchItem06;
    private RString reserchItem07;
    private RString reserchItem08;
    private RString reserchItem09;
    private RString reserchItem10;
    private RString reserchItem11;
    private RString reserchItem12;
    private RString reserchItem13;
    private RString reserchItem14;
    private RString reserchItem15;
    private RString reserchItem16;
    private RString reserchItem17;
    private RString reserchItem18;
    private RString reserchItem19;
    private RString reserchItem20;
    private RString reserchItem21;
    private RString reserchItem22;
    private RString reserchItem23;
    private RString reserchItem24;
    private RString reserchItem25;
    private RString reserchItem26;
    private RString reserchItem27;
    private RString reserchItem28;
    private RString reserchItem29;
    private RString reserchItem30;
    private RString reserchItem31;
    private RString reserchItem32;
    private RString reserchItem33;
    private RString reserchItem34;
    private RString reserchItem35;
    private RString reserchItem36;
    private RString reserchItem37;
    private RString reserchItem38;
    private RString reserchItem39;
    private RString reserchItem40;
    private RString reserchItem41;
    private RString reserchItem42;
    private RString reserchItem43;
    private RString reserchItem44;
    private RString reserchItem45;
    private RString reserchItem46;
    private RString reserchItem47;
    private RString reserchItem48;
    private RString reserchItem49;
    private RString reserchItem50;
    private RString reserchItem51;
    private RString reserchItem52;
    private RString reserchItem53;
    private RString reserchItem54;
    private RString reserchItem55;
    private RString reserchItem56;
    private RString reserchItem57;
    private RString reserchItem58;
    private RString reserchItem59;
    private RString reserchItem60;
    private RString reserchItem61;
    private RString reserchItem62;
    private RString reserchItem63;
    private RString reserchItem64;
    private RString reserchItem65;
    private RString reserchItem66;
    private RString reserchItem67;
    private RString reserchItem68;
    private RString reserchItem69;
    private RString reserchItem70;
    private RString reserchItem71;
    private RString reserchItem72;
    private RString reserchItem73;
    private RString reserchItem74;
    private RString reserchItem75;
    private RString reserchItem76;
    private RString reserchItem77;
    private RString reserchItem78;
    private RString reserchItem79;
    private RString reserchItem80;
    private RString reserchItem81;
    private RString reserchItem82;
    private RString reserchItem83;
    private RString reserchItem84;
    private RString reserchItem85;
    private RString reserchItem86;
    private RString reserchItem87;
    private RString reserchItem88;
    private RString reserchItem89;
    private RString reserchItem90;
    private RString reserchItem91;
    private RString reserchItem92;
    private RString reserchItem93;
    private RString reserchItem94;
    private RString reserchItem95;
    private RString reserchItem96;
    private RString reserchItem97;
    private RString reserchItem98;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;

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
     * 調査項目01のgetメソッドです。
     * 
     * @return 調査項目01
     */
    public RString getReserchItem01() {
        return reserchItem01;
    }

    /**
     * 調査項目01のsetメソッドです。
     * 
     * @param reserchItem01 調査項目01
     */
    public void setReserchItem01(RString reserchItem01) {
        this.reserchItem01 = reserchItem01;
    }

    /**
     * 調査項目02のgetメソッドです。
     * 
     * @return 調査項目02
     */
    public RString getReserchItem02() {
        return reserchItem02;
    }

    /**
     * 調査項目02のsetメソッドです。
     * 
     * @param reserchItem02 調査項目02
     */
    public void setReserchItem02(RString reserchItem02) {
        this.reserchItem02 = reserchItem02;
    }

    /**
     * 調査項目03のgetメソッドです。
     * 
     * @return 調査項目03
     */
    public RString getReserchItem03() {
        return reserchItem03;
    }

    /**
     * 調査項目03のsetメソッドです。
     * 
     * @param reserchItem03 調査項目03
     */
    public void setReserchItem03(RString reserchItem03) {
        this.reserchItem03 = reserchItem03;
    }

    /**
     * 調査項目04のgetメソッドです。
     * 
     * @return 調査項目04
     */
    public RString getReserchItem04() {
        return reserchItem04;
    }

    /**
     * 調査項目04のsetメソッドです。
     * 
     * @param reserchItem04 調査項目04
     */
    public void setReserchItem04(RString reserchItem04) {
        this.reserchItem04 = reserchItem04;
    }

    /**
     * 調査項目05のgetメソッドです。
     * 
     * @return 調査項目05
     */
    public RString getReserchItem05() {
        return reserchItem05;
    }

    /**
     * 調査項目05のsetメソッドです。
     * 
     * @param reserchItem05 調査項目05
     */
    public void setReserchItem05(RString reserchItem05) {
        this.reserchItem05 = reserchItem05;
    }

    /**
     * 調査項目06のgetメソッドです。
     * 
     * @return 調査項目06
     */
    public RString getReserchItem06() {
        return reserchItem06;
    }

    /**
     * 調査項目06のsetメソッドです。
     * 
     * @param reserchItem06 調査項目06
     */
    public void setReserchItem06(RString reserchItem06) {
        this.reserchItem06 = reserchItem06;
    }

    /**
     * 調査項目07のgetメソッドです。
     * 
     * @return 調査項目07
     */
    public RString getReserchItem07() {
        return reserchItem07;
    }

    /**
     * 調査項目07のsetメソッドです。
     * 
     * @param reserchItem07 調査項目07
     */
    public void setReserchItem07(RString reserchItem07) {
        this.reserchItem07 = reserchItem07;
    }

    /**
     * 調査項目08のgetメソッドです。
     * 
     * @return 調査項目08
     */
    public RString getReserchItem08() {
        return reserchItem08;
    }

    /**
     * 調査項目08のsetメソッドです。
     * 
     * @param reserchItem08 調査項目08
     */
    public void setReserchItem08(RString reserchItem08) {
        this.reserchItem08 = reserchItem08;
    }

    /**
     * 調査項目09のgetメソッドです。
     * 
     * @return 調査項目09
     */
    public RString getReserchItem09() {
        return reserchItem09;
    }

    /**
     * 調査項目09のsetメソッドです。
     * 
     * @param reserchItem09 調査項目09
     */
    public void setReserchItem09(RString reserchItem09) {
        this.reserchItem09 = reserchItem09;
    }

    /**
     * 調査項目10のgetメソッドです。
     * 
     * @return 調査項目10
     */
    public RString getReserchItem10() {
        return reserchItem10;
    }

    /**
     * 調査項目10のsetメソッドです。
     * 
     * @param reserchItem10 調査項目10
     */
    public void setReserchItem10(RString reserchItem10) {
        this.reserchItem10 = reserchItem10;
    }

    /**
     * 調査項目11のgetメソッドです。
     * 
     * @return 調査項目11
     */
    public RString getReserchItem11() {
        return reserchItem11;
    }

    /**
     * 調査項目11のsetメソッドです。
     * 
     * @param reserchItem11 調査項目11
     */
    public void setReserchItem11(RString reserchItem11) {
        this.reserchItem11 = reserchItem11;
    }

    /**
     * 調査項目12のgetメソッドです。
     * 
     * @return 調査項目12
     */
    public RString getReserchItem12() {
        return reserchItem12;
    }

    /**
     * 調査項目12のsetメソッドです。
     * 
     * @param reserchItem12 調査項目12
     */
    public void setReserchItem12(RString reserchItem12) {
        this.reserchItem12 = reserchItem12;
    }

    /**
     * 調査項目13のgetメソッドです。
     * 
     * @return 調査項目13
     */
    public RString getReserchItem13() {
        return reserchItem13;
    }

    /**
     * 調査項目13のsetメソッドです。
     * 
     * @param reserchItem13 調査項目13
     */
    public void setReserchItem13(RString reserchItem13) {
        this.reserchItem13 = reserchItem13;
    }

    /**
     * 調査項目14のgetメソッドです。
     * 
     * @return 調査項目14
     */
    public RString getReserchItem14() {
        return reserchItem14;
    }

    /**
     * 調査項目14のsetメソッドです。
     * 
     * @param reserchItem14 調査項目14
     */
    public void setReserchItem14(RString reserchItem14) {
        this.reserchItem14 = reserchItem14;
    }

    /**
     * 調査項目15のgetメソッドです。
     * 
     * @return 調査項目15
     */
    public RString getReserchItem15() {
        return reserchItem15;
    }

    /**
     * 調査項目15のsetメソッドです。
     * 
     * @param reserchItem15 調査項目15
     */
    public void setReserchItem15(RString reserchItem15) {
        this.reserchItem15 = reserchItem15;
    }

    /**
     * 調査項目16のgetメソッドです。
     * 
     * @return 調査項目16
     */
    public RString getReserchItem16() {
        return reserchItem16;
    }

    /**
     * 調査項目16のsetメソッドです。
     * 
     * @param reserchItem16 調査項目16
     */
    public void setReserchItem16(RString reserchItem16) {
        this.reserchItem16 = reserchItem16;
    }

    /**
     * 調査項目17のgetメソッドです。
     * 
     * @return 調査項目17
     */
    public RString getReserchItem17() {
        return reserchItem17;
    }

    /**
     * 調査項目17のsetメソッドです。
     * 
     * @param reserchItem17 調査項目17
     */
    public void setReserchItem17(RString reserchItem17) {
        this.reserchItem17 = reserchItem17;
    }

    /**
     * 調査項目18のgetメソッドです。
     * 
     * @return 調査項目18
     */
    public RString getReserchItem18() {
        return reserchItem18;
    }

    /**
     * 調査項目18のsetメソッドです。
     * 
     * @param reserchItem18 調査項目18
     */
    public void setReserchItem18(RString reserchItem18) {
        this.reserchItem18 = reserchItem18;
    }

    /**
     * 調査項目19のgetメソッドです。
     * 
     * @return 調査項目19
     */
    public RString getReserchItem19() {
        return reserchItem19;
    }

    /**
     * 調査項目19のsetメソッドです。
     * 
     * @param reserchItem19 調査項目19
     */
    public void setReserchItem19(RString reserchItem19) {
        this.reserchItem19 = reserchItem19;
    }

    /**
     * 調査項目20のgetメソッドです。
     * 
     * @return 調査項目20
     */
    public RString getReserchItem20() {
        return reserchItem20;
    }

    /**
     * 調査項目20のsetメソッドです。
     * 
     * @param reserchItem20 調査項目20
     */
    public void setReserchItem20(RString reserchItem20) {
        this.reserchItem20 = reserchItem20;
    }

    /**
     * 調査項目21のgetメソッドです。
     * 
     * @return 調査項目21
     */
    public RString getReserchItem21() {
        return reserchItem21;
    }

    /**
     * 調査項目21のsetメソッドです。
     * 
     * @param reserchItem21 調査項目21
     */
    public void setReserchItem21(RString reserchItem21) {
        this.reserchItem21 = reserchItem21;
    }

    /**
     * 調査項目22のgetメソッドです。
     * 
     * @return 調査項目22
     */
    public RString getReserchItem22() {
        return reserchItem22;
    }

    /**
     * 調査項目22のsetメソッドです。
     * 
     * @param reserchItem22 調査項目22
     */
    public void setReserchItem22(RString reserchItem22) {
        this.reserchItem22 = reserchItem22;
    }

    /**
     * 調査項目23のgetメソッドです。
     * 
     * @return 調査項目23
     */
    public RString getReserchItem23() {
        return reserchItem23;
    }

    /**
     * 調査項目23のsetメソッドです。
     * 
     * @param reserchItem23 調査項目23
     */
    public void setReserchItem23(RString reserchItem23) {
        this.reserchItem23 = reserchItem23;
    }

    /**
     * 調査項目24のgetメソッドです。
     * 
     * @return 調査項目24
     */
    public RString getReserchItem24() {
        return reserchItem24;
    }

    /**
     * 調査項目24のsetメソッドです。
     * 
     * @param reserchItem24 調査項目24
     */
    public void setReserchItem24(RString reserchItem24) {
        this.reserchItem24 = reserchItem24;
    }

    /**
     * 調査項目25のgetメソッドです。
     * 
     * @return 調査項目25
     */
    public RString getReserchItem25() {
        return reserchItem25;
    }

    /**
     * 調査項目25のsetメソッドです。
     * 
     * @param reserchItem25 調査項目25
     */
    public void setReserchItem25(RString reserchItem25) {
        this.reserchItem25 = reserchItem25;
    }

    /**
     * 調査項目26のgetメソッドです。
     * 
     * @return 調査項目26
     */
    public RString getReserchItem26() {
        return reserchItem26;
    }

    /**
     * 調査項目26のsetメソッドです。
     * 
     * @param reserchItem26 調査項目26
     */
    public void setReserchItem26(RString reserchItem26) {
        this.reserchItem26 = reserchItem26;
    }

    /**
     * 調査項目27のgetメソッドです。
     * 
     * @return 調査項目27
     */
    public RString getReserchItem27() {
        return reserchItem27;
    }

    /**
     * 調査項目27のsetメソッドです。
     * 
     * @param reserchItem27 調査項目27
     */
    public void setReserchItem27(RString reserchItem27) {
        this.reserchItem27 = reserchItem27;
    }

    /**
     * 調査項目28のgetメソッドです。
     * 
     * @return 調査項目28
     */
    public RString getReserchItem28() {
        return reserchItem28;
    }

    /**
     * 調査項目28のsetメソッドです。
     * 
     * @param reserchItem28 調査項目28
     */
    public void setReserchItem28(RString reserchItem28) {
        this.reserchItem28 = reserchItem28;
    }

    /**
     * 調査項目29のgetメソッドです。
     * 
     * @return 調査項目29
     */
    public RString getReserchItem29() {
        return reserchItem29;
    }

    /**
     * 調査項目29のsetメソッドです。
     * 
     * @param reserchItem29 調査項目29
     */
    public void setReserchItem29(RString reserchItem29) {
        this.reserchItem29 = reserchItem29;
    }

    /**
     * 調査項目30のgetメソッドです。
     * 
     * @return 調査項目30
     */
    public RString getReserchItem30() {
        return reserchItem30;
    }

    /**
     * 調査項目30のsetメソッドです。
     * 
     * @param reserchItem30 調査項目30
     */
    public void setReserchItem30(RString reserchItem30) {
        this.reserchItem30 = reserchItem30;
    }

    /**
     * 調査項目31のgetメソッドです。
     * 
     * @return 調査項目31
     */
    public RString getReserchItem31() {
        return reserchItem31;
    }

    /**
     * 調査項目31のsetメソッドです。
     * 
     * @param reserchItem31 調査項目31
     */
    public void setReserchItem31(RString reserchItem31) {
        this.reserchItem31 = reserchItem31;
    }

    /**
     * 調査項目32のgetメソッドです。
     * 
     * @return 調査項目32
     */
    public RString getReserchItem32() {
        return reserchItem32;
    }

    /**
     * 調査項目32のsetメソッドです。
     * 
     * @param reserchItem32 調査項目32
     */
    public void setReserchItem32(RString reserchItem32) {
        this.reserchItem32 = reserchItem32;
    }

    /**
     * 調査項目33のgetメソッドです。
     * 
     * @return 調査項目33
     */
    public RString getReserchItem33() {
        return reserchItem33;
    }

    /**
     * 調査項目33のsetメソッドです。
     * 
     * @param reserchItem33 調査項目33
     */
    public void setReserchItem33(RString reserchItem33) {
        this.reserchItem33 = reserchItem33;
    }

    /**
     * 調査項目34のgetメソッドです。
     * 
     * @return 調査項目34
     */
    public RString getReserchItem34() {
        return reserchItem34;
    }

    /**
     * 調査項目34のsetメソッドです。
     * 
     * @param reserchItem34 調査項目34
     */
    public void setReserchItem34(RString reserchItem34) {
        this.reserchItem34 = reserchItem34;
    }

    /**
     * 調査項目35のgetメソッドです。
     * 
     * @return 調査項目35
     */
    public RString getReserchItem35() {
        return reserchItem35;
    }

    /**
     * 調査項目35のsetメソッドです。
     * 
     * @param reserchItem35 調査項目35
     */
    public void setReserchItem35(RString reserchItem35) {
        this.reserchItem35 = reserchItem35;
    }

    /**
     * 調査項目36のgetメソッドです。
     * 
     * @return 調査項目36
     */
    public RString getReserchItem36() {
        return reserchItem36;
    }

    /**
     * 調査項目36のsetメソッドです。
     * 
     * @param reserchItem36 調査項目36
     */
    public void setReserchItem36(RString reserchItem36) {
        this.reserchItem36 = reserchItem36;
    }

    /**
     * 調査項目37のgetメソッドです。
     * 
     * @return 調査項目37
     */
    public RString getReserchItem37() {
        return reserchItem37;
    }

    /**
     * 調査項目37のsetメソッドです。
     * 
     * @param reserchItem37 調査項目37
     */
    public void setReserchItem37(RString reserchItem37) {
        this.reserchItem37 = reserchItem37;
    }

    /**
     * 調査項目38のgetメソッドです。
     * 
     * @return 調査項目38
     */
    public RString getReserchItem38() {
        return reserchItem38;
    }

    /**
     * 調査項目38のsetメソッドです。
     * 
     * @param reserchItem38 調査項目38
     */
    public void setReserchItem38(RString reserchItem38) {
        this.reserchItem38 = reserchItem38;
    }

    /**
     * 調査項目39のgetメソッドです。
     * 
     * @return 調査項目39
     */
    public RString getReserchItem39() {
        return reserchItem39;
    }

    /**
     * 調査項目39のsetメソッドです。
     * 
     * @param reserchItem39 調査項目39
     */
    public void setReserchItem39(RString reserchItem39) {
        this.reserchItem39 = reserchItem39;
    }

    /**
     * 調査項目40のgetメソッドです。
     * 
     * @return 調査項目40
     */
    public RString getReserchItem40() {
        return reserchItem40;
    }

    /**
     * 調査項目40のsetメソッドです。
     * 
     * @param reserchItem40 調査項目40
     */
    public void setReserchItem40(RString reserchItem40) {
        this.reserchItem40 = reserchItem40;
    }

    /**
     * 調査項目41のgetメソッドです。
     * 
     * @return 調査項目41
     */
    public RString getReserchItem41() {
        return reserchItem41;
    }

    /**
     * 調査項目41のsetメソッドです。
     * 
     * @param reserchItem41 調査項目41
     */
    public void setReserchItem41(RString reserchItem41) {
        this.reserchItem41 = reserchItem41;
    }

    /**
     * 調査項目42のgetメソッドです。
     * 
     * @return 調査項目42
     */
    public RString getReserchItem42() {
        return reserchItem42;
    }

    /**
     * 調査項目42のsetメソッドです。
     * 
     * @param reserchItem42 調査項目42
     */
    public void setReserchItem42(RString reserchItem42) {
        this.reserchItem42 = reserchItem42;
    }

    /**
     * 調査項目43のgetメソッドです。
     * 
     * @return 調査項目43
     */
    public RString getReserchItem43() {
        return reserchItem43;
    }

    /**
     * 調査項目43のsetメソッドです。
     * 
     * @param reserchItem43 調査項目43
     */
    public void setReserchItem43(RString reserchItem43) {
        this.reserchItem43 = reserchItem43;
    }

    /**
     * 調査項目44のgetメソッドです。
     * 
     * @return 調査項目44
     */
    public RString getReserchItem44() {
        return reserchItem44;
    }

    /**
     * 調査項目44のsetメソッドです。
     * 
     * @param reserchItem44 調査項目44
     */
    public void setReserchItem44(RString reserchItem44) {
        this.reserchItem44 = reserchItem44;
    }

    /**
     * 調査項目45のgetメソッドです。
     * 
     * @return 調査項目45
     */
    public RString getReserchItem45() {
        return reserchItem45;
    }

    /**
     * 調査項目45のsetメソッドです。
     * 
     * @param reserchItem45 調査項目45
     */
    public void setReserchItem45(RString reserchItem45) {
        this.reserchItem45 = reserchItem45;
    }

    /**
     * 調査項目46のgetメソッドです。
     * 
     * @return 調査項目46
     */
    public RString getReserchItem46() {
        return reserchItem46;
    }

    /**
     * 調査項目46のsetメソッドです。
     * 
     * @param reserchItem46 調査項目46
     */
    public void setReserchItem46(RString reserchItem46) {
        this.reserchItem46 = reserchItem46;
    }

    /**
     * 調査項目47のgetメソッドです。
     * 
     * @return 調査項目47
     */
    public RString getReserchItem47() {
        return reserchItem47;
    }

    /**
     * 調査項目47のsetメソッドです。
     * 
     * @param reserchItem47 調査項目47
     */
    public void setReserchItem47(RString reserchItem47) {
        this.reserchItem47 = reserchItem47;
    }

    /**
     * 調査項目48のgetメソッドです。
     * 
     * @return 調査項目48
     */
    public RString getReserchItem48() {
        return reserchItem48;
    }

    /**
     * 調査項目48のsetメソッドです。
     * 
     * @param reserchItem48 調査項目48
     */
    public void setReserchItem48(RString reserchItem48) {
        this.reserchItem48 = reserchItem48;
    }

    /**
     * 調査項目49のgetメソッドです。
     * 
     * @return 調査項目49
     */
    public RString getReserchItem49() {
        return reserchItem49;
    }

    /**
     * 調査項目49のsetメソッドです。
     * 
     * @param reserchItem49 調査項目49
     */
    public void setReserchItem49(RString reserchItem49) {
        this.reserchItem49 = reserchItem49;
    }

    /**
     * 調査項目50のgetメソッドです。
     * 
     * @return 調査項目50
     */
    public RString getReserchItem50() {
        return reserchItem50;
    }

    /**
     * 調査項目50のsetメソッドです。
     * 
     * @param reserchItem50 調査項目50
     */
    public void setReserchItem50(RString reserchItem50) {
        this.reserchItem50 = reserchItem50;
    }

    /**
     * 調査項目51のgetメソッドです。
     * 
     * @return 調査項目51
     */
    public RString getReserchItem51() {
        return reserchItem51;
    }

    /**
     * 調査項目51のsetメソッドです。
     * 
     * @param reserchItem51 調査項目51
     */
    public void setReserchItem51(RString reserchItem51) {
        this.reserchItem51 = reserchItem51;
    }

    /**
     * 調査項目52のgetメソッドです。
     * 
     * @return 調査項目52
     */
    public RString getReserchItem52() {
        return reserchItem52;
    }

    /**
     * 調査項目52のsetメソッドです。
     * 
     * @param reserchItem52 調査項目52
     */
    public void setReserchItem52(RString reserchItem52) {
        this.reserchItem52 = reserchItem52;
    }

    /**
     * 調査項目53のgetメソッドです。
     * 
     * @return 調査項目53
     */
    public RString getReserchItem53() {
        return reserchItem53;
    }

    /**
     * 調査項目53のsetメソッドです。
     * 
     * @param reserchItem53 調査項目53
     */
    public void setReserchItem53(RString reserchItem53) {
        this.reserchItem53 = reserchItem53;
    }

    /**
     * 調査項目54のgetメソッドです。
     * 
     * @return 調査項目54
     */
    public RString getReserchItem54() {
        return reserchItem54;
    }

    /**
     * 調査項目54のsetメソッドです。
     * 
     * @param reserchItem54 調査項目54
     */
    public void setReserchItem54(RString reserchItem54) {
        this.reserchItem54 = reserchItem54;
    }

    /**
     * 調査項目55のgetメソッドです。
     * 
     * @return 調査項目55
     */
    public RString getReserchItem55() {
        return reserchItem55;
    }

    /**
     * 調査項目55のsetメソッドです。
     * 
     * @param reserchItem55 調査項目55
     */
    public void setReserchItem55(RString reserchItem55) {
        this.reserchItem55 = reserchItem55;
    }

    /**
     * 調査項目56のgetメソッドです。
     * 
     * @return 調査項目56
     */
    public RString getReserchItem56() {
        return reserchItem56;
    }

    /**
     * 調査項目56のsetメソッドです。
     * 
     * @param reserchItem56 調査項目56
     */
    public void setReserchItem56(RString reserchItem56) {
        this.reserchItem56 = reserchItem56;
    }

    /**
     * 調査項目57のgetメソッドです。
     * 
     * @return 調査項目57
     */
    public RString getReserchItem57() {
        return reserchItem57;
    }

    /**
     * 調査項目57のsetメソッドです。
     * 
     * @param reserchItem57 調査項目57
     */
    public void setReserchItem57(RString reserchItem57) {
        this.reserchItem57 = reserchItem57;
    }

    /**
     * 調査項目58のgetメソッドです。
     * 
     * @return 調査項目58
     */
    public RString getReserchItem58() {
        return reserchItem58;
    }

    /**
     * 調査項目58のsetメソッドです。
     * 
     * @param reserchItem58 調査項目58
     */
    public void setReserchItem58(RString reserchItem58) {
        this.reserchItem58 = reserchItem58;
    }

    /**
     * 調査項目59のgetメソッドです。
     * 
     * @return 調査項目59
     */
    public RString getReserchItem59() {
        return reserchItem59;
    }

    /**
     * 調査項目59のsetメソッドです。
     * 
     * @param reserchItem59 調査項目59
     */
    public void setReserchItem59(RString reserchItem59) {
        this.reserchItem59 = reserchItem59;
    }

    /**
     * 調査項目60のgetメソッドです。
     * 
     * @return 調査項目60
     */
    public RString getReserchItem60() {
        return reserchItem60;
    }

    /**
     * 調査項目60のsetメソッドです。
     * 
     * @param reserchItem60 調査項目60
     */
    public void setReserchItem60(RString reserchItem60) {
        this.reserchItem60 = reserchItem60;
    }

    /**
     * 調査項目61のgetメソッドです。
     * 
     * @return 調査項目61
     */
    public RString getReserchItem61() {
        return reserchItem61;
    }

    /**
     * 調査項目61のsetメソッドです。
     * 
     * @param reserchItem61 調査項目61
     */
    public void setReserchItem61(RString reserchItem61) {
        this.reserchItem61 = reserchItem61;
    }

    /**
     * 調査項目62のgetメソッドです。
     * 
     * @return 調査項目62
     */
    public RString getReserchItem62() {
        return reserchItem62;
    }

    /**
     * 調査項目62のsetメソッドです。
     * 
     * @param reserchItem62 調査項目62
     */
    public void setReserchItem62(RString reserchItem62) {
        this.reserchItem62 = reserchItem62;
    }

    /**
     * 調査項目63のgetメソッドです。
     * 
     * @return 調査項目63
     */
    public RString getReserchItem63() {
        return reserchItem63;
    }

    /**
     * 調査項目63のsetメソッドです。
     * 
     * @param reserchItem63 調査項目63
     */
    public void setReserchItem63(RString reserchItem63) {
        this.reserchItem63 = reserchItem63;
    }

    /**
     * 調査項目64のgetメソッドです。
     * 
     * @return 調査項目64
     */
    public RString getReserchItem64() {
        return reserchItem64;
    }

    /**
     * 調査項目64のsetメソッドです。
     * 
     * @param reserchItem64 調査項目64
     */
    public void setReserchItem64(RString reserchItem64) {
        this.reserchItem64 = reserchItem64;
    }

    /**
     * 調査項目65のgetメソッドです。
     * 
     * @return 調査項目65
     */
    public RString getReserchItem65() {
        return reserchItem65;
    }

    /**
     * 調査項目65のsetメソッドです。
     * 
     * @param reserchItem65 調査項目65
     */
    public void setReserchItem65(RString reserchItem65) {
        this.reserchItem65 = reserchItem65;
    }

    /**
     * 調査項目66のgetメソッドです。
     * 
     * @return 調査項目66
     */
    public RString getReserchItem66() {
        return reserchItem66;
    }

    /**
     * 調査項目66のsetメソッドです。
     * 
     * @param reserchItem66 調査項目66
     */
    public void setReserchItem66(RString reserchItem66) {
        this.reserchItem66 = reserchItem66;
    }

    /**
     * 調査項目67のgetメソッドです。
     * 
     * @return 調査項目67
     */
    public RString getReserchItem67() {
        return reserchItem67;
    }

    /**
     * 調査項目67のsetメソッドです。
     * 
     * @param reserchItem67 調査項目67
     */
    public void setReserchItem67(RString reserchItem67) {
        this.reserchItem67 = reserchItem67;
    }

    /**
     * 調査項目68のgetメソッドです。
     * 
     * @return 調査項目68
     */
    public RString getReserchItem68() {
        return reserchItem68;
    }

    /**
     * 調査項目68のsetメソッドです。
     * 
     * @param reserchItem68 調査項目68
     */
    public void setReserchItem68(RString reserchItem68) {
        this.reserchItem68 = reserchItem68;
    }

    /**
     * 調査項目69のgetメソッドです。
     * 
     * @return 調査項目69
     */
    public RString getReserchItem69() {
        return reserchItem69;
    }

    /**
     * 調査項目69のsetメソッドです。
     * 
     * @param reserchItem69 調査項目69
     */
    public void setReserchItem69(RString reserchItem69) {
        this.reserchItem69 = reserchItem69;
    }

    /**
     * 調査項目70のgetメソッドです。
     * 
     * @return 調査項目70
     */
    public RString getReserchItem70() {
        return reserchItem70;
    }

    /**
     * 調査項目70のsetメソッドです。
     * 
     * @param reserchItem70 調査項目70
     */
    public void setReserchItem70(RString reserchItem70) {
        this.reserchItem70 = reserchItem70;
    }

    /**
     * 調査項目71のgetメソッドです。
     * 
     * @return 調査項目71
     */
    public RString getReserchItem71() {
        return reserchItem71;
    }

    /**
     * 調査項目71のsetメソッドです。
     * 
     * @param reserchItem71 調査項目71
     */
    public void setReserchItem71(RString reserchItem71) {
        this.reserchItem71 = reserchItem71;
    }

    /**
     * 調査項目72のgetメソッドです。
     * 
     * @return 調査項目72
     */
    public RString getReserchItem72() {
        return reserchItem72;
    }

    /**
     * 調査項目72のsetメソッドです。
     * 
     * @param reserchItem72 調査項目72
     */
    public void setReserchItem72(RString reserchItem72) {
        this.reserchItem72 = reserchItem72;
    }

    /**
     * 調査項目73のgetメソッドです。
     * 
     * @return 調査項目73
     */
    public RString getReserchItem73() {
        return reserchItem73;
    }

    /**
     * 調査項目73のsetメソッドです。
     * 
     * @param reserchItem73 調査項目73
     */
    public void setReserchItem73(RString reserchItem73) {
        this.reserchItem73 = reserchItem73;
    }

    /**
     * 調査項目74のgetメソッドです。
     * 
     * @return 調査項目74
     */
    public RString getReserchItem74() {
        return reserchItem74;
    }

    /**
     * 調査項目74のsetメソッドです。
     * 
     * @param reserchItem74 調査項目74
     */
    public void setReserchItem74(RString reserchItem74) {
        this.reserchItem74 = reserchItem74;
    }

    /**
     * 調査項目75のgetメソッドです。
     * 
     * @return 調査項目75
     */
    public RString getReserchItem75() {
        return reserchItem75;
    }

    /**
     * 調査項目75のsetメソッドです。
     * 
     * @param reserchItem75 調査項目75
     */
    public void setReserchItem75(RString reserchItem75) {
        this.reserchItem75 = reserchItem75;
    }

    /**
     * 調査項目76のgetメソッドです。
     * 
     * @return 調査項目76
     */
    public RString getReserchItem76() {
        return reserchItem76;
    }

    /**
     * 調査項目76のsetメソッドです。
     * 
     * @param reserchItem76 調査項目76
     */
    public void setReserchItem76(RString reserchItem76) {
        this.reserchItem76 = reserchItem76;
    }

    /**
     * 調査項目77のgetメソッドです。
     * 
     * @return 調査項目77
     */
    public RString getReserchItem77() {
        return reserchItem77;
    }

    /**
     * 調査項目77のsetメソッドです。
     * 
     * @param reserchItem77 調査項目77
     */
    public void setReserchItem77(RString reserchItem77) {
        this.reserchItem77 = reserchItem77;
    }

    /**
     * 調査項目78のgetメソッドです。
     * 
     * @return 調査項目78
     */
    public RString getReserchItem78() {
        return reserchItem78;
    }

    /**
     * 調査項目78のsetメソッドです。
     * 
     * @param reserchItem78 調査項目78
     */
    public void setReserchItem78(RString reserchItem78) {
        this.reserchItem78 = reserchItem78;
    }

    /**
     * 調査項目79のgetメソッドです。
     * 
     * @return 調査項目79
     */
    public RString getReserchItem79() {
        return reserchItem79;
    }

    /**
     * 調査項目79のsetメソッドです。
     * 
     * @param reserchItem79 調査項目79
     */
    public void setReserchItem79(RString reserchItem79) {
        this.reserchItem79 = reserchItem79;
    }

    /**
     * 調査項目80のgetメソッドです。
     * 
     * @return 調査項目80
     */
    public RString getReserchItem80() {
        return reserchItem80;
    }

    /**
     * 調査項目80のsetメソッドです。
     * 
     * @param reserchItem80 調査項目80
     */
    public void setReserchItem80(RString reserchItem80) {
        this.reserchItem80 = reserchItem80;
    }

    /**
     * 調査項目81のgetメソッドです。
     * 
     * @return 調査項目81
     */
    public RString getReserchItem81() {
        return reserchItem81;
    }

    /**
     * 調査項目81のsetメソッドです。
     * 
     * @param reserchItem81 調査項目81
     */
    public void setReserchItem81(RString reserchItem81) {
        this.reserchItem81 = reserchItem81;
    }

    /**
     * 調査項目82のgetメソッドです。
     * 
     * @return 調査項目82
     */
    public RString getReserchItem82() {
        return reserchItem82;
    }

    /**
     * 調査項目82のsetメソッドです。
     * 
     * @param reserchItem82 調査項目82
     */
    public void setReserchItem82(RString reserchItem82) {
        this.reserchItem82 = reserchItem82;
    }

    /**
     * 調査項目83のgetメソッドです。
     * 
     * @return 調査項目83
     */
    public RString getReserchItem83() {
        return reserchItem83;
    }

    /**
     * 調査項目83のsetメソッドです。
     * 
     * @param reserchItem83 調査項目83
     */
    public void setReserchItem83(RString reserchItem83) {
        this.reserchItem83 = reserchItem83;
    }

    /**
     * 調査項目84のgetメソッドです。
     * 
     * @return 調査項目84
     */
    public RString getReserchItem84() {
        return reserchItem84;
    }

    /**
     * 調査項目84のsetメソッドです。
     * 
     * @param reserchItem84 調査項目84
     */
    public void setReserchItem84(RString reserchItem84) {
        this.reserchItem84 = reserchItem84;
    }

    /**
     * 調査項目85のgetメソッドです。
     * 
     * @return 調査項目85
     */
    public RString getReserchItem85() {
        return reserchItem85;
    }

    /**
     * 調査項目85のsetメソッドです。
     * 
     * @param reserchItem85 調査項目85
     */
    public void setReserchItem85(RString reserchItem85) {
        this.reserchItem85 = reserchItem85;
    }

    /**
     * 調査項目86のgetメソッドです。
     * 
     * @return 調査項目86
     */
    public RString getReserchItem86() {
        return reserchItem86;
    }

    /**
     * 調査項目86のsetメソッドです。
     * 
     * @param reserchItem86 調査項目86
     */
    public void setReserchItem86(RString reserchItem86) {
        this.reserchItem86 = reserchItem86;
    }

    /**
     * 調査項目87のgetメソッドです。
     * 
     * @return 調査項目87
     */
    public RString getReserchItem87() {
        return reserchItem87;
    }

    /**
     * 調査項目87のsetメソッドです。
     * 
     * @param reserchItem87 調査項目87
     */
    public void setReserchItem87(RString reserchItem87) {
        this.reserchItem87 = reserchItem87;
    }

    /**
     * 調査項目88のgetメソッドです。
     * 
     * @return 調査項目88
     */
    public RString getReserchItem88() {
        return reserchItem88;
    }

    /**
     * 調査項目88のsetメソッドです。
     * 
     * @param reserchItem88 調査項目88
     */
    public void setReserchItem88(RString reserchItem88) {
        this.reserchItem88 = reserchItem88;
    }

    /**
     * 調査項目89のgetメソッドです。
     * 
     * @return 調査項目89
     */
    public RString getReserchItem89() {
        return reserchItem89;
    }

    /**
     * 調査項目89のsetメソッドです。
     * 
     * @param reserchItem89 調査項目89
     */
    public void setReserchItem89(RString reserchItem89) {
        this.reserchItem89 = reserchItem89;
    }

    /**
     * 調査項目90のgetメソッドです。
     * 
     * @return 調査項目90
     */
    public RString getReserchItem90() {
        return reserchItem90;
    }

    /**
     * 調査項目90のsetメソッドです。
     * 
     * @param reserchItem90 調査項目90
     */
    public void setReserchItem90(RString reserchItem90) {
        this.reserchItem90 = reserchItem90;
    }

    /**
     * 調査項目91のgetメソッドです。
     * 
     * @return 調査項目91
     */
    public RString getReserchItem91() {
        return reserchItem91;
    }

    /**
     * 調査項目91のsetメソッドです。
     * 
     * @param reserchItem91 調査項目91
     */
    public void setReserchItem91(RString reserchItem91) {
        this.reserchItem91 = reserchItem91;
    }

    /**
     * 調査項目92のgetメソッドです。
     * 
     * @return 調査項目92
     */
    public RString getReserchItem92() {
        return reserchItem92;
    }

    /**
     * 調査項目92のsetメソッドです。
     * 
     * @param reserchItem92 調査項目92
     */
    public void setReserchItem92(RString reserchItem92) {
        this.reserchItem92 = reserchItem92;
    }

    /**
     * 調査項目93のgetメソッドです。
     * 
     * @return 調査項目93
     */
    public RString getReserchItem93() {
        return reserchItem93;
    }

    /**
     * 調査項目93のsetメソッドです。
     * 
     * @param reserchItem93 調査項目93
     */
    public void setReserchItem93(RString reserchItem93) {
        this.reserchItem93 = reserchItem93;
    }

    /**
     * 調査項目94のgetメソッドです。
     * 
     * @return 調査項目94
     */
    public RString getReserchItem94() {
        return reserchItem94;
    }

    /**
     * 調査項目94のsetメソッドです。
     * 
     * @param reserchItem94 調査項目94
     */
    public void setReserchItem94(RString reserchItem94) {
        this.reserchItem94 = reserchItem94;
    }

    /**
     * 調査項目95のgetメソッドです。
     * 
     * @return 調査項目95
     */
    public RString getReserchItem95() {
        return reserchItem95;
    }

    /**
     * 調査項目95のsetメソッドです。
     * 
     * @param reserchItem95 調査項目95
     */
    public void setReserchItem95(RString reserchItem95) {
        this.reserchItem95 = reserchItem95;
    }

    /**
     * 調査項目96のgetメソッドです。
     * 
     * @return 調査項目96
     */
    public RString getReserchItem96() {
        return reserchItem96;
    }

    /**
     * 調査項目96のsetメソッドです。
     * 
     * @param reserchItem96 調査項目96
     */
    public void setReserchItem96(RString reserchItem96) {
        this.reserchItem96 = reserchItem96;
    }

    /**
     * 調査項目97のgetメソッドです。
     * 
     * @return 調査項目97
     */
    public RString getReserchItem97() {
        return reserchItem97;
    }

    /**
     * 調査項目97のsetメソッドです。
     * 
     * @param reserchItem97 調査項目97
     */
    public void setReserchItem97(RString reserchItem97) {
        this.reserchItem97 = reserchItem97;
    }

    /**
     * 調査項目98のgetメソッドです。
     * 
     * @return 調査項目98
     */
    public RString getReserchItem98() {
        return reserchItem98;
    }

    /**
     * 調査項目98のsetメソッドです。
     * 
     * @param reserchItem98 調査項目98
     */
    public void setReserchItem98(RString reserchItem98) {
        this.reserchItem98 = reserchItem98;
    }

    /**
     * 認定調査・認知症高齢者の日常生活自立度コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認知症高齢者自立度コード）
     * 
     * @return 認定調査・認知症高齢者の日常生活自立度コード
     */
    public Code getNinchishoNichijoSeikatsuJiritsudoCode() {
        return ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 認定調査・認知症高齢者の日常生活自立度コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認知症高齢者自立度コード）
     * 
     * @param ninchishoNichijoSeikatsuJiritsudoCode 認定調査・認知症高齢者の日常生活自立度コード
     */
    public void setNinchishoNichijoSeikatsuJiritsudoCode(Code ninchishoNichijoSeikatsuJiritsudoCode) {
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 認定調査・障害高齢者の日常生活自立度コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：障害高齢者自立度コード）
     * 
     * @return 認定調査・障害高齢者の日常生活自立度コード
     */
    public Code getShogaiNichijoSeikatsuJiritsudoCode() {
        return shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 認定調査・障害高齢者の日常生活自立度コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：障害高齢者自立度コード）
     * 
     * @param shogaiNichijoSeikatsuJiritsudoCode 認定調査・障害高齢者の日常生活自立度コード
     */
    public void setShogaiNichijoSeikatsuJiritsudoCode(Code shogaiNichijoSeikatsuJiritsudoCode) {
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4203NinteichosahyoKihonChosaChildEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4203NinteichosahyoKihonChosaChildEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4203NinteichosahyoKihonChosaChildEntity other) {
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
    public void shallowCopy(DbT4203NinteichosahyoKihonChosaChildEntity entity) {
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
        this.ninchishoNichijoSeikatsuJiritsudoCode = entity.ninchishoNichijoSeikatsuJiritsudoCode;
        this.shogaiNichijoSeikatsuJiritsudoCode = entity.shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, koroshoIfShikibetsuCode, reserchItem01, reserchItem02, reserchItem03, reserchItem04, reserchItem05, reserchItem06, reserchItem07, reserchItem08, reserchItem09, reserchItem10, reserchItem11, reserchItem12, reserchItem13, reserchItem14, reserchItem15, reserchItem16, reserchItem17, reserchItem18, reserchItem19, reserchItem20, reserchItem21, reserchItem22, reserchItem23, reserchItem24, reserchItem25, reserchItem26, reserchItem27, reserchItem28, reserchItem29, reserchItem30, reserchItem31, reserchItem32, reserchItem33, reserchItem34, reserchItem35, reserchItem36, reserchItem37, reserchItem38, reserchItem39, reserchItem40, reserchItem41, reserchItem42, reserchItem43, reserchItem44, reserchItem45, reserchItem46, reserchItem47, reserchItem48, reserchItem49, reserchItem50, reserchItem51, reserchItem52, reserchItem53, reserchItem54, reserchItem55, reserchItem56, reserchItem57, reserchItem58, reserchItem59, reserchItem60, reserchItem61, reserchItem62, reserchItem63, reserchItem64, reserchItem65, reserchItem66, reserchItem67, reserchItem68, reserchItem69, reserchItem70, reserchItem71, reserchItem72, reserchItem73, reserchItem74, reserchItem75, reserchItem76, reserchItem77, reserchItem78, reserchItem79, reserchItem80, reserchItem81, reserchItem82, reserchItem83, reserchItem84, reserchItem85, reserchItem86, reserchItem87, reserchItem88, reserchItem89, reserchItem90, reserchItem91, reserchItem92, reserchItem93, reserchItem94, reserchItem95, reserchItem96, reserchItem97, reserchItem98, ninchishoNichijoSeikatsuJiritsudoCode, shogaiNichijoSeikatsuJiritsudoCode);
    }

// </editor-fold>
}
