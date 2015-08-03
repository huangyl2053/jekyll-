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
 * 要介護認定主治医意見書意見項目1999Aテーブルのエンティティクラスです。
 */
public class DbT5304ShujiiIkenshoIkenItem1999AEntity extends DbTableEntityBase<DbT5304ShujiiIkenshoIkenItem1999AEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5304ShujiiIkenshoIkenItem1999A");

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
    private int ikenshoIraiRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private RString ikenItem01;
    private RString ikenItem02;
    private RString ikenItem03;
    private RString ikenItem04;
    private RString ikenItem05;
    private RString ikenItem06;
    private RString ikenItem07;
    private RString ikenItem08;
    private RString ikenItem09;
    private RString ikenItem10;
    private RString ikenItem11;
    private RString ikenItem12;
    private RString ikenItem13;
    private RString ikenItem14;
    private RString ikenItem15;
    private RString ikenItem16;
    private RString ikenItem17;
    private RString ikenItem18;
    private RString ikenItem19;
    private RString ikenItem20;
    private RString ikenItem21;
    private RString ikenItem22;
    private RString ikenItem23;
    private RString ikenItem24;
    private RString ikenItem25;
    private RString ikenItem26;
    private RString ikenItem27;
    private RString ikenItem28;
    private RString ikenItem29;
    private RString ikenItem30;
    private RString ikenItem31;
    private RString ikenItem32;
    private RString ikenItem33;
    private RString ikenItem34;
    private RString ikenItem35;
    private RString ikenItem36;
    private RString ikenItem37;
    private RString ikenItem38;
    private RString ikenItem39;
    private RString ikenItem40;
    private RString ikenItem41;
    private RString ikenItem42;
    private RString ikenItem43;
    private RString ikenItem44;
    private RString ikenItem45;
    private RString ikenItem46;
    private RString ikenItem47;
    private RString ikenItem48;
    private RString ikenItem49;
    private RString ikenItem50;
    private RString ikenItem51;
    private RString ikenItem52;
    private RString ikenItem53;
    private RString ikenItem54;
    private RString ikenItem55;
    private RString ikenItem56;
    private RString ikenItem57;
    private RString ikenItem58;
    private RString ikenItem59;
    private RString ikenItem60;
    private RString ikenItem61;
    private RString ikenItem62;
    private RString ikenItem63;
    private RString ikenItem64;
    private RString ikenItem65;
    private RString ikenItem66;
    private RString ikenItem67;
    private RString ikenItem68;
    private RString ikenItem69;
    private RString ikenItem70;
    private RString ikenItem71;
    private RString ikenItem72;
    private RString ikenItem73;
    private RString ikenItem74;
    private RString ikenItem75;
    private RString ikenItem76;
    private RString ikenItem77;
    private RString ikenItem78;
    private RString ikenItem79;
    private RString ikenItem80;
    private RString ikenItem81;
    private RString ikenItem82;
    private RString ikenItem83;
    private RString ikenItem84;
    private RString ikenItem85;
    private RString ikenItem86;
    private RString ikenItem87;
    private RString ikenItem88;
    private RString ikenItem89;
    private RString ikenItem90;
    private RString ikenItem91;
    private RString ikenItem92;
    private RString ikenItem93;
    private RString ikenItem94;
    private RString ikenItem95;
    private RString ikenItem96;
    private RString ikenItem97;
    private RString ikenItem98;
    private RString ikenItem99;
    private RString ikenItem100;
    private RString ikenItem101;
    private RString ikenItem102;
    private RString ikenItem103;
    private RString ikenItem104;
    private RString ikenItem105;
    private RString ikenItem106;
    private RString ikenItem107;
    private RString ikenItem108;
    private RString ikenItem109;
    private RString ikenItem110;

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
     * 主治医意見書作成依頼履歴番号のgetメソッドです。
     * <br/>
     * <br/>主治医意見書作成依頼情報
     * 
     * @return 主治医意見書作成依頼履歴番号
     */
    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号のsetメソッドです。
     * <br/>
     * <br/>主治医意見書作成依頼情報
     * 
     * @param ikenshoIraiRirekiNo 主治医意見書作成依頼履歴番号
     */
    public void setIkenshoIraiRirekiNo(int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
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
     * 意見項目01のgetメソッドです。
     * 
     * @return 意見項目01
     */
    public RString getIkenItem01() {
        return ikenItem01;
    }

    /**
     * 意見項目01のsetメソッドです。
     * 
     * @param ikenItem01 意見項目01
     */
    public void setIkenItem01(RString ikenItem01) {
        this.ikenItem01 = ikenItem01;
    }

    /**
     * 意見項目02のgetメソッドです。
     * 
     * @return 意見項目02
     */
    public RString getIkenItem02() {
        return ikenItem02;
    }

    /**
     * 意見項目02のsetメソッドです。
     * 
     * @param ikenItem02 意見項目02
     */
    public void setIkenItem02(RString ikenItem02) {
        this.ikenItem02 = ikenItem02;
    }

    /**
     * 意見項目03のgetメソッドです。
     * 
     * @return 意見項目03
     */
    public RString getIkenItem03() {
        return ikenItem03;
    }

    /**
     * 意見項目03のsetメソッドです。
     * 
     * @param ikenItem03 意見項目03
     */
    public void setIkenItem03(RString ikenItem03) {
        this.ikenItem03 = ikenItem03;
    }

    /**
     * 意見項目04のgetメソッドです。
     * 
     * @return 意見項目04
     */
    public RString getIkenItem04() {
        return ikenItem04;
    }

    /**
     * 意見項目04のsetメソッドです。
     * 
     * @param ikenItem04 意見項目04
     */
    public void setIkenItem04(RString ikenItem04) {
        this.ikenItem04 = ikenItem04;
    }

    /**
     * 意見項目05のgetメソッドです。
     * 
     * @return 意見項目05
     */
    public RString getIkenItem05() {
        return ikenItem05;
    }

    /**
     * 意見項目05のsetメソッドです。
     * 
     * @param ikenItem05 意見項目05
     */
    public void setIkenItem05(RString ikenItem05) {
        this.ikenItem05 = ikenItem05;
    }

    /**
     * 意見項目06のgetメソッドです。
     * 
     * @return 意見項目06
     */
    public RString getIkenItem06() {
        return ikenItem06;
    }

    /**
     * 意見項目06のsetメソッドです。
     * 
     * @param ikenItem06 意見項目06
     */
    public void setIkenItem06(RString ikenItem06) {
        this.ikenItem06 = ikenItem06;
    }

    /**
     * 意見項目07のgetメソッドです。
     * 
     * @return 意見項目07
     */
    public RString getIkenItem07() {
        return ikenItem07;
    }

    /**
     * 意見項目07のsetメソッドです。
     * 
     * @param ikenItem07 意見項目07
     */
    public void setIkenItem07(RString ikenItem07) {
        this.ikenItem07 = ikenItem07;
    }

    /**
     * 意見項目08のgetメソッドです。
     * 
     * @return 意見項目08
     */
    public RString getIkenItem08() {
        return ikenItem08;
    }

    /**
     * 意見項目08のsetメソッドです。
     * 
     * @param ikenItem08 意見項目08
     */
    public void setIkenItem08(RString ikenItem08) {
        this.ikenItem08 = ikenItem08;
    }

    /**
     * 意見項目09のgetメソッドです。
     * 
     * @return 意見項目09
     */
    public RString getIkenItem09() {
        return ikenItem09;
    }

    /**
     * 意見項目09のsetメソッドです。
     * 
     * @param ikenItem09 意見項目09
     */
    public void setIkenItem09(RString ikenItem09) {
        this.ikenItem09 = ikenItem09;
    }

    /**
     * 意見項目10のgetメソッドです。
     * 
     * @return 意見項目10
     */
    public RString getIkenItem10() {
        return ikenItem10;
    }

    /**
     * 意見項目10のsetメソッドです。
     * 
     * @param ikenItem10 意見項目10
     */
    public void setIkenItem10(RString ikenItem10) {
        this.ikenItem10 = ikenItem10;
    }

    /**
     * 意見項目11のgetメソッドです。
     * 
     * @return 意見項目11
     */
    public RString getIkenItem11() {
        return ikenItem11;
    }

    /**
     * 意見項目11のsetメソッドです。
     * 
     * @param ikenItem11 意見項目11
     */
    public void setIkenItem11(RString ikenItem11) {
        this.ikenItem11 = ikenItem11;
    }

    /**
     * 意見項目12のgetメソッドです。
     * 
     * @return 意見項目12
     */
    public RString getIkenItem12() {
        return ikenItem12;
    }

    /**
     * 意見項目12のsetメソッドです。
     * 
     * @param ikenItem12 意見項目12
     */
    public void setIkenItem12(RString ikenItem12) {
        this.ikenItem12 = ikenItem12;
    }

    /**
     * 意見項目13のgetメソッドです。
     * 
     * @return 意見項目13
     */
    public RString getIkenItem13() {
        return ikenItem13;
    }

    /**
     * 意見項目13のsetメソッドです。
     * 
     * @param ikenItem13 意見項目13
     */
    public void setIkenItem13(RString ikenItem13) {
        this.ikenItem13 = ikenItem13;
    }

    /**
     * 意見項目14のgetメソッドです。
     * 
     * @return 意見項目14
     */
    public RString getIkenItem14() {
        return ikenItem14;
    }

    /**
     * 意見項目14のsetメソッドです。
     * 
     * @param ikenItem14 意見項目14
     */
    public void setIkenItem14(RString ikenItem14) {
        this.ikenItem14 = ikenItem14;
    }

    /**
     * 意見項目15のgetメソッドです。
     * 
     * @return 意見項目15
     */
    public RString getIkenItem15() {
        return ikenItem15;
    }

    /**
     * 意見項目15のsetメソッドです。
     * 
     * @param ikenItem15 意見項目15
     */
    public void setIkenItem15(RString ikenItem15) {
        this.ikenItem15 = ikenItem15;
    }

    /**
     * 意見項目16のgetメソッドです。
     * 
     * @return 意見項目16
     */
    public RString getIkenItem16() {
        return ikenItem16;
    }

    /**
     * 意見項目16のsetメソッドです。
     * 
     * @param ikenItem16 意見項目16
     */
    public void setIkenItem16(RString ikenItem16) {
        this.ikenItem16 = ikenItem16;
    }

    /**
     * 意見項目17のgetメソッドです。
     * 
     * @return 意見項目17
     */
    public RString getIkenItem17() {
        return ikenItem17;
    }

    /**
     * 意見項目17のsetメソッドです。
     * 
     * @param ikenItem17 意見項目17
     */
    public void setIkenItem17(RString ikenItem17) {
        this.ikenItem17 = ikenItem17;
    }

    /**
     * 意見項目18のgetメソッドです。
     * 
     * @return 意見項目18
     */
    public RString getIkenItem18() {
        return ikenItem18;
    }

    /**
     * 意見項目18のsetメソッドです。
     * 
     * @param ikenItem18 意見項目18
     */
    public void setIkenItem18(RString ikenItem18) {
        this.ikenItem18 = ikenItem18;
    }

    /**
     * 意見項目19のgetメソッドです。
     * 
     * @return 意見項目19
     */
    public RString getIkenItem19() {
        return ikenItem19;
    }

    /**
     * 意見項目19のsetメソッドです。
     * 
     * @param ikenItem19 意見項目19
     */
    public void setIkenItem19(RString ikenItem19) {
        this.ikenItem19 = ikenItem19;
    }

    /**
     * 意見項目20のgetメソッドです。
     * 
     * @return 意見項目20
     */
    public RString getIkenItem20() {
        return ikenItem20;
    }

    /**
     * 意見項目20のsetメソッドです。
     * 
     * @param ikenItem20 意見項目20
     */
    public void setIkenItem20(RString ikenItem20) {
        this.ikenItem20 = ikenItem20;
    }

    /**
     * 意見項目21のgetメソッドです。
     * 
     * @return 意見項目21
     */
    public RString getIkenItem21() {
        return ikenItem21;
    }

    /**
     * 意見項目21のsetメソッドです。
     * 
     * @param ikenItem21 意見項目21
     */
    public void setIkenItem21(RString ikenItem21) {
        this.ikenItem21 = ikenItem21;
    }

    /**
     * 意見項目22のgetメソッドです。
     * 
     * @return 意見項目22
     */
    public RString getIkenItem22() {
        return ikenItem22;
    }

    /**
     * 意見項目22のsetメソッドです。
     * 
     * @param ikenItem22 意見項目22
     */
    public void setIkenItem22(RString ikenItem22) {
        this.ikenItem22 = ikenItem22;
    }

    /**
     * 意見項目23のgetメソッドです。
     * 
     * @return 意見項目23
     */
    public RString getIkenItem23() {
        return ikenItem23;
    }

    /**
     * 意見項目23のsetメソッドです。
     * 
     * @param ikenItem23 意見項目23
     */
    public void setIkenItem23(RString ikenItem23) {
        this.ikenItem23 = ikenItem23;
    }

    /**
     * 意見項目24のgetメソッドです。
     * 
     * @return 意見項目24
     */
    public RString getIkenItem24() {
        return ikenItem24;
    }

    /**
     * 意見項目24のsetメソッドです。
     * 
     * @param ikenItem24 意見項目24
     */
    public void setIkenItem24(RString ikenItem24) {
        this.ikenItem24 = ikenItem24;
    }

    /**
     * 意見項目25のgetメソッドです。
     * 
     * @return 意見項目25
     */
    public RString getIkenItem25() {
        return ikenItem25;
    }

    /**
     * 意見項目25のsetメソッドです。
     * 
     * @param ikenItem25 意見項目25
     */
    public void setIkenItem25(RString ikenItem25) {
        this.ikenItem25 = ikenItem25;
    }

    /**
     * 意見項目26のgetメソッドです。
     * 
     * @return 意見項目26
     */
    public RString getIkenItem26() {
        return ikenItem26;
    }

    /**
     * 意見項目26のsetメソッドです。
     * 
     * @param ikenItem26 意見項目26
     */
    public void setIkenItem26(RString ikenItem26) {
        this.ikenItem26 = ikenItem26;
    }

    /**
     * 意見項目27のgetメソッドです。
     * 
     * @return 意見項目27
     */
    public RString getIkenItem27() {
        return ikenItem27;
    }

    /**
     * 意見項目27のsetメソッドです。
     * 
     * @param ikenItem27 意見項目27
     */
    public void setIkenItem27(RString ikenItem27) {
        this.ikenItem27 = ikenItem27;
    }

    /**
     * 意見項目28のgetメソッドです。
     * 
     * @return 意見項目28
     */
    public RString getIkenItem28() {
        return ikenItem28;
    }

    /**
     * 意見項目28のsetメソッドです。
     * 
     * @param ikenItem28 意見項目28
     */
    public void setIkenItem28(RString ikenItem28) {
        this.ikenItem28 = ikenItem28;
    }

    /**
     * 意見項目29のgetメソッドです。
     * 
     * @return 意見項目29
     */
    public RString getIkenItem29() {
        return ikenItem29;
    }

    /**
     * 意見項目29のsetメソッドです。
     * 
     * @param ikenItem29 意見項目29
     */
    public void setIkenItem29(RString ikenItem29) {
        this.ikenItem29 = ikenItem29;
    }

    /**
     * 意見項目30のgetメソッドです。
     * 
     * @return 意見項目30
     */
    public RString getIkenItem30() {
        return ikenItem30;
    }

    /**
     * 意見項目30のsetメソッドです。
     * 
     * @param ikenItem30 意見項目30
     */
    public void setIkenItem30(RString ikenItem30) {
        this.ikenItem30 = ikenItem30;
    }

    /**
     * 意見項目31のgetメソッドです。
     * 
     * @return 意見項目31
     */
    public RString getIkenItem31() {
        return ikenItem31;
    }

    /**
     * 意見項目31のsetメソッドです。
     * 
     * @param ikenItem31 意見項目31
     */
    public void setIkenItem31(RString ikenItem31) {
        this.ikenItem31 = ikenItem31;
    }

    /**
     * 意見項目32のgetメソッドです。
     * 
     * @return 意見項目32
     */
    public RString getIkenItem32() {
        return ikenItem32;
    }

    /**
     * 意見項目32のsetメソッドです。
     * 
     * @param ikenItem32 意見項目32
     */
    public void setIkenItem32(RString ikenItem32) {
        this.ikenItem32 = ikenItem32;
    }

    /**
     * 意見項目33のgetメソッドです。
     * 
     * @return 意見項目33
     */
    public RString getIkenItem33() {
        return ikenItem33;
    }

    /**
     * 意見項目33のsetメソッドです。
     * 
     * @param ikenItem33 意見項目33
     */
    public void setIkenItem33(RString ikenItem33) {
        this.ikenItem33 = ikenItem33;
    }

    /**
     * 意見項目34のgetメソッドです。
     * 
     * @return 意見項目34
     */
    public RString getIkenItem34() {
        return ikenItem34;
    }

    /**
     * 意見項目34のsetメソッドです。
     * 
     * @param ikenItem34 意見項目34
     */
    public void setIkenItem34(RString ikenItem34) {
        this.ikenItem34 = ikenItem34;
    }

    /**
     * 意見項目35のgetメソッドです。
     * 
     * @return 意見項目35
     */
    public RString getIkenItem35() {
        return ikenItem35;
    }

    /**
     * 意見項目35のsetメソッドです。
     * 
     * @param ikenItem35 意見項目35
     */
    public void setIkenItem35(RString ikenItem35) {
        this.ikenItem35 = ikenItem35;
    }

    /**
     * 意見項目36のgetメソッドです。
     * 
     * @return 意見項目36
     */
    public RString getIkenItem36() {
        return ikenItem36;
    }

    /**
     * 意見項目36のsetメソッドです。
     * 
     * @param ikenItem36 意見項目36
     */
    public void setIkenItem36(RString ikenItem36) {
        this.ikenItem36 = ikenItem36;
    }

    /**
     * 意見項目37のgetメソッドです。
     * 
     * @return 意見項目37
     */
    public RString getIkenItem37() {
        return ikenItem37;
    }

    /**
     * 意見項目37のsetメソッドです。
     * 
     * @param ikenItem37 意見項目37
     */
    public void setIkenItem37(RString ikenItem37) {
        this.ikenItem37 = ikenItem37;
    }

    /**
     * 意見項目38のgetメソッドです。
     * 
     * @return 意見項目38
     */
    public RString getIkenItem38() {
        return ikenItem38;
    }

    /**
     * 意見項目38のsetメソッドです。
     * 
     * @param ikenItem38 意見項目38
     */
    public void setIkenItem38(RString ikenItem38) {
        this.ikenItem38 = ikenItem38;
    }

    /**
     * 意見項目39のgetメソッドです。
     * 
     * @return 意見項目39
     */
    public RString getIkenItem39() {
        return ikenItem39;
    }

    /**
     * 意見項目39のsetメソッドです。
     * 
     * @param ikenItem39 意見項目39
     */
    public void setIkenItem39(RString ikenItem39) {
        this.ikenItem39 = ikenItem39;
    }

    /**
     * 意見項目40のgetメソッドです。
     * 
     * @return 意見項目40
     */
    public RString getIkenItem40() {
        return ikenItem40;
    }

    /**
     * 意見項目40のsetメソッドです。
     * 
     * @param ikenItem40 意見項目40
     */
    public void setIkenItem40(RString ikenItem40) {
        this.ikenItem40 = ikenItem40;
    }

    /**
     * 意見項目41のgetメソッドです。
     * 
     * @return 意見項目41
     */
    public RString getIkenItem41() {
        return ikenItem41;
    }

    /**
     * 意見項目41のsetメソッドです。
     * 
     * @param ikenItem41 意見項目41
     */
    public void setIkenItem41(RString ikenItem41) {
        this.ikenItem41 = ikenItem41;
    }

    /**
     * 意見項目42のgetメソッドです。
     * 
     * @return 意見項目42
     */
    public RString getIkenItem42() {
        return ikenItem42;
    }

    /**
     * 意見項目42のsetメソッドです。
     * 
     * @param ikenItem42 意見項目42
     */
    public void setIkenItem42(RString ikenItem42) {
        this.ikenItem42 = ikenItem42;
    }

    /**
     * 意見項目43のgetメソッドです。
     * 
     * @return 意見項目43
     */
    public RString getIkenItem43() {
        return ikenItem43;
    }

    /**
     * 意見項目43のsetメソッドです。
     * 
     * @param ikenItem43 意見項目43
     */
    public void setIkenItem43(RString ikenItem43) {
        this.ikenItem43 = ikenItem43;
    }

    /**
     * 意見項目44のgetメソッドです。
     * 
     * @return 意見項目44
     */
    public RString getIkenItem44() {
        return ikenItem44;
    }

    /**
     * 意見項目44のsetメソッドです。
     * 
     * @param ikenItem44 意見項目44
     */
    public void setIkenItem44(RString ikenItem44) {
        this.ikenItem44 = ikenItem44;
    }

    /**
     * 意見項目45のgetメソッドです。
     * 
     * @return 意見項目45
     */
    public RString getIkenItem45() {
        return ikenItem45;
    }

    /**
     * 意見項目45のsetメソッドです。
     * 
     * @param ikenItem45 意見項目45
     */
    public void setIkenItem45(RString ikenItem45) {
        this.ikenItem45 = ikenItem45;
    }

    /**
     * 意見項目46のgetメソッドです。
     * 
     * @return 意見項目46
     */
    public RString getIkenItem46() {
        return ikenItem46;
    }

    /**
     * 意見項目46のsetメソッドです。
     * 
     * @param ikenItem46 意見項目46
     */
    public void setIkenItem46(RString ikenItem46) {
        this.ikenItem46 = ikenItem46;
    }

    /**
     * 意見項目47のgetメソッドです。
     * 
     * @return 意見項目47
     */
    public RString getIkenItem47() {
        return ikenItem47;
    }

    /**
     * 意見項目47のsetメソッドです。
     * 
     * @param ikenItem47 意見項目47
     */
    public void setIkenItem47(RString ikenItem47) {
        this.ikenItem47 = ikenItem47;
    }

    /**
     * 意見項目48のgetメソッドです。
     * 
     * @return 意見項目48
     */
    public RString getIkenItem48() {
        return ikenItem48;
    }

    /**
     * 意見項目48のsetメソッドです。
     * 
     * @param ikenItem48 意見項目48
     */
    public void setIkenItem48(RString ikenItem48) {
        this.ikenItem48 = ikenItem48;
    }

    /**
     * 意見項目49のgetメソッドです。
     * 
     * @return 意見項目49
     */
    public RString getIkenItem49() {
        return ikenItem49;
    }

    /**
     * 意見項目49のsetメソッドです。
     * 
     * @param ikenItem49 意見項目49
     */
    public void setIkenItem49(RString ikenItem49) {
        this.ikenItem49 = ikenItem49;
    }

    /**
     * 意見項目50のgetメソッドです。
     * 
     * @return 意見項目50
     */
    public RString getIkenItem50() {
        return ikenItem50;
    }

    /**
     * 意見項目50のsetメソッドです。
     * 
     * @param ikenItem50 意見項目50
     */
    public void setIkenItem50(RString ikenItem50) {
        this.ikenItem50 = ikenItem50;
    }

    /**
     * 意見項目51のgetメソッドです。
     * 
     * @return 意見項目51
     */
    public RString getIkenItem51() {
        return ikenItem51;
    }

    /**
     * 意見項目51のsetメソッドです。
     * 
     * @param ikenItem51 意見項目51
     */
    public void setIkenItem51(RString ikenItem51) {
        this.ikenItem51 = ikenItem51;
    }

    /**
     * 意見項目52のgetメソッドです。
     * 
     * @return 意見項目52
     */
    public RString getIkenItem52() {
        return ikenItem52;
    }

    /**
     * 意見項目52のsetメソッドです。
     * 
     * @param ikenItem52 意見項目52
     */
    public void setIkenItem52(RString ikenItem52) {
        this.ikenItem52 = ikenItem52;
    }

    /**
     * 意見項目53のgetメソッドです。
     * 
     * @return 意見項目53
     */
    public RString getIkenItem53() {
        return ikenItem53;
    }

    /**
     * 意見項目53のsetメソッドです。
     * 
     * @param ikenItem53 意見項目53
     */
    public void setIkenItem53(RString ikenItem53) {
        this.ikenItem53 = ikenItem53;
    }

    /**
     * 意見項目54のgetメソッドです。
     * 
     * @return 意見項目54
     */
    public RString getIkenItem54() {
        return ikenItem54;
    }

    /**
     * 意見項目54のsetメソッドです。
     * 
     * @param ikenItem54 意見項目54
     */
    public void setIkenItem54(RString ikenItem54) {
        this.ikenItem54 = ikenItem54;
    }

    /**
     * 意見項目55のgetメソッドです。
     * 
     * @return 意見項目55
     */
    public RString getIkenItem55() {
        return ikenItem55;
    }

    /**
     * 意見項目55のsetメソッドです。
     * 
     * @param ikenItem55 意見項目55
     */
    public void setIkenItem55(RString ikenItem55) {
        this.ikenItem55 = ikenItem55;
    }

    /**
     * 意見項目56のgetメソッドです。
     * 
     * @return 意見項目56
     */
    public RString getIkenItem56() {
        return ikenItem56;
    }

    /**
     * 意見項目56のsetメソッドです。
     * 
     * @param ikenItem56 意見項目56
     */
    public void setIkenItem56(RString ikenItem56) {
        this.ikenItem56 = ikenItem56;
    }

    /**
     * 意見項目57のgetメソッドです。
     * 
     * @return 意見項目57
     */
    public RString getIkenItem57() {
        return ikenItem57;
    }

    /**
     * 意見項目57のsetメソッドです。
     * 
     * @param ikenItem57 意見項目57
     */
    public void setIkenItem57(RString ikenItem57) {
        this.ikenItem57 = ikenItem57;
    }

    /**
     * 意見項目58のgetメソッドです。
     * 
     * @return 意見項目58
     */
    public RString getIkenItem58() {
        return ikenItem58;
    }

    /**
     * 意見項目58のsetメソッドです。
     * 
     * @param ikenItem58 意見項目58
     */
    public void setIkenItem58(RString ikenItem58) {
        this.ikenItem58 = ikenItem58;
    }

    /**
     * 意見項目59のgetメソッドです。
     * 
     * @return 意見項目59
     */
    public RString getIkenItem59() {
        return ikenItem59;
    }

    /**
     * 意見項目59のsetメソッドです。
     * 
     * @param ikenItem59 意見項目59
     */
    public void setIkenItem59(RString ikenItem59) {
        this.ikenItem59 = ikenItem59;
    }

    /**
     * 意見項目60のgetメソッドです。
     * 
     * @return 意見項目60
     */
    public RString getIkenItem60() {
        return ikenItem60;
    }

    /**
     * 意見項目60のsetメソッドです。
     * 
     * @param ikenItem60 意見項目60
     */
    public void setIkenItem60(RString ikenItem60) {
        this.ikenItem60 = ikenItem60;
    }

    /**
     * 意見項目61のgetメソッドです。
     * 
     * @return 意見項目61
     */
    public RString getIkenItem61() {
        return ikenItem61;
    }

    /**
     * 意見項目61のsetメソッドです。
     * 
     * @param ikenItem61 意見項目61
     */
    public void setIkenItem61(RString ikenItem61) {
        this.ikenItem61 = ikenItem61;
    }

    /**
     * 意見項目62のgetメソッドです。
     * 
     * @return 意見項目62
     */
    public RString getIkenItem62() {
        return ikenItem62;
    }

    /**
     * 意見項目62のsetメソッドです。
     * 
     * @param ikenItem62 意見項目62
     */
    public void setIkenItem62(RString ikenItem62) {
        this.ikenItem62 = ikenItem62;
    }

    /**
     * 意見項目63のgetメソッドです。
     * 
     * @return 意見項目63
     */
    public RString getIkenItem63() {
        return ikenItem63;
    }

    /**
     * 意見項目63のsetメソッドです。
     * 
     * @param ikenItem63 意見項目63
     */
    public void setIkenItem63(RString ikenItem63) {
        this.ikenItem63 = ikenItem63;
    }

    /**
     * 意見項目64のgetメソッドです。
     * 
     * @return 意見項目64
     */
    public RString getIkenItem64() {
        return ikenItem64;
    }

    /**
     * 意見項目64のsetメソッドです。
     * 
     * @param ikenItem64 意見項目64
     */
    public void setIkenItem64(RString ikenItem64) {
        this.ikenItem64 = ikenItem64;
    }

    /**
     * 意見項目65のgetメソッドです。
     * 
     * @return 意見項目65
     */
    public RString getIkenItem65() {
        return ikenItem65;
    }

    /**
     * 意見項目65のsetメソッドです。
     * 
     * @param ikenItem65 意見項目65
     */
    public void setIkenItem65(RString ikenItem65) {
        this.ikenItem65 = ikenItem65;
    }

    /**
     * 意見項目66のgetメソッドです。
     * 
     * @return 意見項目66
     */
    public RString getIkenItem66() {
        return ikenItem66;
    }

    /**
     * 意見項目66のsetメソッドです。
     * 
     * @param ikenItem66 意見項目66
     */
    public void setIkenItem66(RString ikenItem66) {
        this.ikenItem66 = ikenItem66;
    }

    /**
     * 意見項目67のgetメソッドです。
     * 
     * @return 意見項目67
     */
    public RString getIkenItem67() {
        return ikenItem67;
    }

    /**
     * 意見項目67のsetメソッドです。
     * 
     * @param ikenItem67 意見項目67
     */
    public void setIkenItem67(RString ikenItem67) {
        this.ikenItem67 = ikenItem67;
    }

    /**
     * 意見項目68のgetメソッドです。
     * 
     * @return 意見項目68
     */
    public RString getIkenItem68() {
        return ikenItem68;
    }

    /**
     * 意見項目68のsetメソッドです。
     * 
     * @param ikenItem68 意見項目68
     */
    public void setIkenItem68(RString ikenItem68) {
        this.ikenItem68 = ikenItem68;
    }

    /**
     * 意見項目69のgetメソッドです。
     * 
     * @return 意見項目69
     */
    public RString getIkenItem69() {
        return ikenItem69;
    }

    /**
     * 意見項目69のsetメソッドです。
     * 
     * @param ikenItem69 意見項目69
     */
    public void setIkenItem69(RString ikenItem69) {
        this.ikenItem69 = ikenItem69;
    }

    /**
     * 意見項目70のgetメソッドです。
     * 
     * @return 意見項目70
     */
    public RString getIkenItem70() {
        return ikenItem70;
    }

    /**
     * 意見項目70のsetメソッドです。
     * 
     * @param ikenItem70 意見項目70
     */
    public void setIkenItem70(RString ikenItem70) {
        this.ikenItem70 = ikenItem70;
    }

    /**
     * 意見項目71のgetメソッドです。
     * 
     * @return 意見項目71
     */
    public RString getIkenItem71() {
        return ikenItem71;
    }

    /**
     * 意見項目71のsetメソッドです。
     * 
     * @param ikenItem71 意見項目71
     */
    public void setIkenItem71(RString ikenItem71) {
        this.ikenItem71 = ikenItem71;
    }

    /**
     * 意見項目72のgetメソッドです。
     * 
     * @return 意見項目72
     */
    public RString getIkenItem72() {
        return ikenItem72;
    }

    /**
     * 意見項目72のsetメソッドです。
     * 
     * @param ikenItem72 意見項目72
     */
    public void setIkenItem72(RString ikenItem72) {
        this.ikenItem72 = ikenItem72;
    }

    /**
     * 意見項目73のgetメソッドです。
     * 
     * @return 意見項目73
     */
    public RString getIkenItem73() {
        return ikenItem73;
    }

    /**
     * 意見項目73のsetメソッドです。
     * 
     * @param ikenItem73 意見項目73
     */
    public void setIkenItem73(RString ikenItem73) {
        this.ikenItem73 = ikenItem73;
    }

    /**
     * 意見項目74のgetメソッドです。
     * 
     * @return 意見項目74
     */
    public RString getIkenItem74() {
        return ikenItem74;
    }

    /**
     * 意見項目74のsetメソッドです。
     * 
     * @param ikenItem74 意見項目74
     */
    public void setIkenItem74(RString ikenItem74) {
        this.ikenItem74 = ikenItem74;
    }

    /**
     * 意見項目75のgetメソッドです。
     * 
     * @return 意見項目75
     */
    public RString getIkenItem75() {
        return ikenItem75;
    }

    /**
     * 意見項目75のsetメソッドです。
     * 
     * @param ikenItem75 意見項目75
     */
    public void setIkenItem75(RString ikenItem75) {
        this.ikenItem75 = ikenItem75;
    }

    /**
     * 意見項目76のgetメソッドです。
     * 
     * @return 意見項目76
     */
    public RString getIkenItem76() {
        return ikenItem76;
    }

    /**
     * 意見項目76のsetメソッドです。
     * 
     * @param ikenItem76 意見項目76
     */
    public void setIkenItem76(RString ikenItem76) {
        this.ikenItem76 = ikenItem76;
    }

    /**
     * 意見項目77のgetメソッドです。
     * 
     * @return 意見項目77
     */
    public RString getIkenItem77() {
        return ikenItem77;
    }

    /**
     * 意見項目77のsetメソッドです。
     * 
     * @param ikenItem77 意見項目77
     */
    public void setIkenItem77(RString ikenItem77) {
        this.ikenItem77 = ikenItem77;
    }

    /**
     * 意見項目78のgetメソッドです。
     * 
     * @return 意見項目78
     */
    public RString getIkenItem78() {
        return ikenItem78;
    }

    /**
     * 意見項目78のsetメソッドです。
     * 
     * @param ikenItem78 意見項目78
     */
    public void setIkenItem78(RString ikenItem78) {
        this.ikenItem78 = ikenItem78;
    }

    /**
     * 意見項目79のgetメソッドです。
     * 
     * @return 意見項目79
     */
    public RString getIkenItem79() {
        return ikenItem79;
    }

    /**
     * 意見項目79のsetメソッドです。
     * 
     * @param ikenItem79 意見項目79
     */
    public void setIkenItem79(RString ikenItem79) {
        this.ikenItem79 = ikenItem79;
    }

    /**
     * 意見項目80のgetメソッドです。
     * 
     * @return 意見項目80
     */
    public RString getIkenItem80() {
        return ikenItem80;
    }

    /**
     * 意見項目80のsetメソッドです。
     * 
     * @param ikenItem80 意見項目80
     */
    public void setIkenItem80(RString ikenItem80) {
        this.ikenItem80 = ikenItem80;
    }

    /**
     * 意見項目81のgetメソッドです。
     * 
     * @return 意見項目81
     */
    public RString getIkenItem81() {
        return ikenItem81;
    }

    /**
     * 意見項目81のsetメソッドです。
     * 
     * @param ikenItem81 意見項目81
     */
    public void setIkenItem81(RString ikenItem81) {
        this.ikenItem81 = ikenItem81;
    }

    /**
     * 意見項目82のgetメソッドです。
     * 
     * @return 意見項目82
     */
    public RString getIkenItem82() {
        return ikenItem82;
    }

    /**
     * 意見項目82のsetメソッドです。
     * 
     * @param ikenItem82 意見項目82
     */
    public void setIkenItem82(RString ikenItem82) {
        this.ikenItem82 = ikenItem82;
    }

    /**
     * 意見項目83のgetメソッドです。
     * 
     * @return 意見項目83
     */
    public RString getIkenItem83() {
        return ikenItem83;
    }

    /**
     * 意見項目83のsetメソッドです。
     * 
     * @param ikenItem83 意見項目83
     */
    public void setIkenItem83(RString ikenItem83) {
        this.ikenItem83 = ikenItem83;
    }

    /**
     * 意見項目84のgetメソッドです。
     * 
     * @return 意見項目84
     */
    public RString getIkenItem84() {
        return ikenItem84;
    }

    /**
     * 意見項目84のsetメソッドです。
     * 
     * @param ikenItem84 意見項目84
     */
    public void setIkenItem84(RString ikenItem84) {
        this.ikenItem84 = ikenItem84;
    }

    /**
     * 意見項目85のgetメソッドです。
     * 
     * @return 意見項目85
     */
    public RString getIkenItem85() {
        return ikenItem85;
    }

    /**
     * 意見項目85のsetメソッドです。
     * 
     * @param ikenItem85 意見項目85
     */
    public void setIkenItem85(RString ikenItem85) {
        this.ikenItem85 = ikenItem85;
    }

    /**
     * 意見項目86のgetメソッドです。
     * 
     * @return 意見項目86
     */
    public RString getIkenItem86() {
        return ikenItem86;
    }

    /**
     * 意見項目86のsetメソッドです。
     * 
     * @param ikenItem86 意見項目86
     */
    public void setIkenItem86(RString ikenItem86) {
        this.ikenItem86 = ikenItem86;
    }

    /**
     * 意見項目87のgetメソッドです。
     * 
     * @return 意見項目87
     */
    public RString getIkenItem87() {
        return ikenItem87;
    }

    /**
     * 意見項目87のsetメソッドです。
     * 
     * @param ikenItem87 意見項目87
     */
    public void setIkenItem87(RString ikenItem87) {
        this.ikenItem87 = ikenItem87;
    }

    /**
     * 意見項目88のgetメソッドです。
     * 
     * @return 意見項目88
     */
    public RString getIkenItem88() {
        return ikenItem88;
    }

    /**
     * 意見項目88のsetメソッドです。
     * 
     * @param ikenItem88 意見項目88
     */
    public void setIkenItem88(RString ikenItem88) {
        this.ikenItem88 = ikenItem88;
    }

    /**
     * 意見項目89のgetメソッドです。
     * 
     * @return 意見項目89
     */
    public RString getIkenItem89() {
        return ikenItem89;
    }

    /**
     * 意見項目89のsetメソッドです。
     * 
     * @param ikenItem89 意見項目89
     */
    public void setIkenItem89(RString ikenItem89) {
        this.ikenItem89 = ikenItem89;
    }

    /**
     * 意見項目90のgetメソッドです。
     * 
     * @return 意見項目90
     */
    public RString getIkenItem90() {
        return ikenItem90;
    }

    /**
     * 意見項目90のsetメソッドです。
     * 
     * @param ikenItem90 意見項目90
     */
    public void setIkenItem90(RString ikenItem90) {
        this.ikenItem90 = ikenItem90;
    }

    /**
     * 意見項目91のgetメソッドです。
     * 
     * @return 意見項目91
     */
    public RString getIkenItem91() {
        return ikenItem91;
    }

    /**
     * 意見項目91のsetメソッドです。
     * 
     * @param ikenItem91 意見項目91
     */
    public void setIkenItem91(RString ikenItem91) {
        this.ikenItem91 = ikenItem91;
    }

    /**
     * 意見項目92のgetメソッドです。
     * 
     * @return 意見項目92
     */
    public RString getIkenItem92() {
        return ikenItem92;
    }

    /**
     * 意見項目92のsetメソッドです。
     * 
     * @param ikenItem92 意見項目92
     */
    public void setIkenItem92(RString ikenItem92) {
        this.ikenItem92 = ikenItem92;
    }

    /**
     * 意見項目93のgetメソッドです。
     * 
     * @return 意見項目93
     */
    public RString getIkenItem93() {
        return ikenItem93;
    }

    /**
     * 意見項目93のsetメソッドです。
     * 
     * @param ikenItem93 意見項目93
     */
    public void setIkenItem93(RString ikenItem93) {
        this.ikenItem93 = ikenItem93;
    }

    /**
     * 意見項目94のgetメソッドです。
     * 
     * @return 意見項目94
     */
    public RString getIkenItem94() {
        return ikenItem94;
    }

    /**
     * 意見項目94のsetメソッドです。
     * 
     * @param ikenItem94 意見項目94
     */
    public void setIkenItem94(RString ikenItem94) {
        this.ikenItem94 = ikenItem94;
    }

    /**
     * 意見項目95のgetメソッドです。
     * 
     * @return 意見項目95
     */
    public RString getIkenItem95() {
        return ikenItem95;
    }

    /**
     * 意見項目95のsetメソッドです。
     * 
     * @param ikenItem95 意見項目95
     */
    public void setIkenItem95(RString ikenItem95) {
        this.ikenItem95 = ikenItem95;
    }

    /**
     * 意見項目96のgetメソッドです。
     * 
     * @return 意見項目96
     */
    public RString getIkenItem96() {
        return ikenItem96;
    }

    /**
     * 意見項目96のsetメソッドです。
     * 
     * @param ikenItem96 意見項目96
     */
    public void setIkenItem96(RString ikenItem96) {
        this.ikenItem96 = ikenItem96;
    }

    /**
     * 意見項目97のgetメソッドです。
     * 
     * @return 意見項目97
     */
    public RString getIkenItem97() {
        return ikenItem97;
    }

    /**
     * 意見項目97のsetメソッドです。
     * 
     * @param ikenItem97 意見項目97
     */
    public void setIkenItem97(RString ikenItem97) {
        this.ikenItem97 = ikenItem97;
    }

    /**
     * 意見項目98のgetメソッドです。
     * 
     * @return 意見項目98
     */
    public RString getIkenItem98() {
        return ikenItem98;
    }

    /**
     * 意見項目98のsetメソッドです。
     * 
     * @param ikenItem98 意見項目98
     */
    public void setIkenItem98(RString ikenItem98) {
        this.ikenItem98 = ikenItem98;
    }

    /**
     * 意見項目99のgetメソッドです。
     * 
     * @return 意見項目99
     */
    public RString getIkenItem99() {
        return ikenItem99;
    }

    /**
     * 意見項目99のsetメソッドです。
     * 
     * @param ikenItem99 意見項目99
     */
    public void setIkenItem99(RString ikenItem99) {
        this.ikenItem99 = ikenItem99;
    }

    /**
     * 意見項目100のgetメソッドです。
     * 
     * @return 意見項目100
     */
    public RString getIkenItem100() {
        return ikenItem100;
    }

    /**
     * 意見項目100のsetメソッドです。
     * 
     * @param ikenItem100 意見項目100
     */
    public void setIkenItem100(RString ikenItem100) {
        this.ikenItem100 = ikenItem100;
    }

    /**
     * 意見項目101のgetメソッドです。
     * 
     * @return 意見項目101
     */
    public RString getIkenItem101() {
        return ikenItem101;
    }

    /**
     * 意見項目101のsetメソッドです。
     * 
     * @param ikenItem101 意見項目101
     */
    public void setIkenItem101(RString ikenItem101) {
        this.ikenItem101 = ikenItem101;
    }

    /**
     * 意見項目102のgetメソッドです。
     * 
     * @return 意見項目102
     */
    public RString getIkenItem102() {
        return ikenItem102;
    }

    /**
     * 意見項目102のsetメソッドです。
     * 
     * @param ikenItem102 意見項目102
     */
    public void setIkenItem102(RString ikenItem102) {
        this.ikenItem102 = ikenItem102;
    }

    /**
     * 意見項目103のgetメソッドです。
     * 
     * @return 意見項目103
     */
    public RString getIkenItem103() {
        return ikenItem103;
    }

    /**
     * 意見項目103のsetメソッドです。
     * 
     * @param ikenItem103 意見項目103
     */
    public void setIkenItem103(RString ikenItem103) {
        this.ikenItem103 = ikenItem103;
    }

    /**
     * 意見項目104のgetメソッドです。
     * 
     * @return 意見項目104
     */
    public RString getIkenItem104() {
        return ikenItem104;
    }

    /**
     * 意見項目104のsetメソッドです。
     * 
     * @param ikenItem104 意見項目104
     */
    public void setIkenItem104(RString ikenItem104) {
        this.ikenItem104 = ikenItem104;
    }

    /**
     * 意見項目105のgetメソッドです。
     * 
     * @return 意見項目105
     */
    public RString getIkenItem105() {
        return ikenItem105;
    }

    /**
     * 意見項目105のsetメソッドです。
     * 
     * @param ikenItem105 意見項目105
     */
    public void setIkenItem105(RString ikenItem105) {
        this.ikenItem105 = ikenItem105;
    }

    /**
     * 意見項目106のgetメソッドです。
     * 
     * @return 意見項目106
     */
    public RString getIkenItem106() {
        return ikenItem106;
    }

    /**
     * 意見項目106のsetメソッドです。
     * 
     * @param ikenItem106 意見項目106
     */
    public void setIkenItem106(RString ikenItem106) {
        this.ikenItem106 = ikenItem106;
    }

    /**
     * 意見項目107のgetメソッドです。
     * 
     * @return 意見項目107
     */
    public RString getIkenItem107() {
        return ikenItem107;
    }

    /**
     * 意見項目107のsetメソッドです。
     * 
     * @param ikenItem107 意見項目107
     */
    public void setIkenItem107(RString ikenItem107) {
        this.ikenItem107 = ikenItem107;
    }

    /**
     * 意見項目108のgetメソッドです。
     * 
     * @return 意見項目108
     */
    public RString getIkenItem108() {
        return ikenItem108;
    }

    /**
     * 意見項目108のsetメソッドです。
     * 
     * @param ikenItem108 意見項目108
     */
    public void setIkenItem108(RString ikenItem108) {
        this.ikenItem108 = ikenItem108;
    }

    /**
     * 意見項目109のgetメソッドです。
     * 
     * @return 意見項目109
     */
    public RString getIkenItem109() {
        return ikenItem109;
    }

    /**
     * 意見項目109のsetメソッドです。
     * 
     * @param ikenItem109 意見項目109
     */
    public void setIkenItem109(RString ikenItem109) {
        this.ikenItem109 = ikenItem109;
    }

    /**
     * 意見項目110のgetメソッドです。
     * 
     * @return 意見項目110
     */
    public RString getIkenItem110() {
        return ikenItem110;
    }

    /**
     * 意見項目110のsetメソッドです。
     * 
     * @param ikenItem110 意見項目110
     */
    public void setIkenItem110(RString ikenItem110) {
        this.ikenItem110 = ikenItem110;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5304ShujiiIkenshoIkenItem1999AEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5304ShujiiIkenshoIkenItem1999AEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5304ShujiiIkenshoIkenItem1999AEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ikenshoIraiRirekiNo != other.ikenshoIraiRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5304ShujiiIkenshoIkenItem1999AEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ikenshoIraiRirekiNo = entity.ikenshoIraiRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.ikenItem01 = entity.ikenItem01;
        this.ikenItem02 = entity.ikenItem02;
        this.ikenItem03 = entity.ikenItem03;
        this.ikenItem04 = entity.ikenItem04;
        this.ikenItem05 = entity.ikenItem05;
        this.ikenItem06 = entity.ikenItem06;
        this.ikenItem07 = entity.ikenItem07;
        this.ikenItem08 = entity.ikenItem08;
        this.ikenItem09 = entity.ikenItem09;
        this.ikenItem10 = entity.ikenItem10;
        this.ikenItem11 = entity.ikenItem11;
        this.ikenItem12 = entity.ikenItem12;
        this.ikenItem13 = entity.ikenItem13;
        this.ikenItem14 = entity.ikenItem14;
        this.ikenItem15 = entity.ikenItem15;
        this.ikenItem16 = entity.ikenItem16;
        this.ikenItem17 = entity.ikenItem17;
        this.ikenItem18 = entity.ikenItem18;
        this.ikenItem19 = entity.ikenItem19;
        this.ikenItem20 = entity.ikenItem20;
        this.ikenItem21 = entity.ikenItem21;
        this.ikenItem22 = entity.ikenItem22;
        this.ikenItem23 = entity.ikenItem23;
        this.ikenItem24 = entity.ikenItem24;
        this.ikenItem25 = entity.ikenItem25;
        this.ikenItem26 = entity.ikenItem26;
        this.ikenItem27 = entity.ikenItem27;
        this.ikenItem28 = entity.ikenItem28;
        this.ikenItem29 = entity.ikenItem29;
        this.ikenItem30 = entity.ikenItem30;
        this.ikenItem31 = entity.ikenItem31;
        this.ikenItem32 = entity.ikenItem32;
        this.ikenItem33 = entity.ikenItem33;
        this.ikenItem34 = entity.ikenItem34;
        this.ikenItem35 = entity.ikenItem35;
        this.ikenItem36 = entity.ikenItem36;
        this.ikenItem37 = entity.ikenItem37;
        this.ikenItem38 = entity.ikenItem38;
        this.ikenItem39 = entity.ikenItem39;
        this.ikenItem40 = entity.ikenItem40;
        this.ikenItem41 = entity.ikenItem41;
        this.ikenItem42 = entity.ikenItem42;
        this.ikenItem43 = entity.ikenItem43;
        this.ikenItem44 = entity.ikenItem44;
        this.ikenItem45 = entity.ikenItem45;
        this.ikenItem46 = entity.ikenItem46;
        this.ikenItem47 = entity.ikenItem47;
        this.ikenItem48 = entity.ikenItem48;
        this.ikenItem49 = entity.ikenItem49;
        this.ikenItem50 = entity.ikenItem50;
        this.ikenItem51 = entity.ikenItem51;
        this.ikenItem52 = entity.ikenItem52;
        this.ikenItem53 = entity.ikenItem53;
        this.ikenItem54 = entity.ikenItem54;
        this.ikenItem55 = entity.ikenItem55;
        this.ikenItem56 = entity.ikenItem56;
        this.ikenItem57 = entity.ikenItem57;
        this.ikenItem58 = entity.ikenItem58;
        this.ikenItem59 = entity.ikenItem59;
        this.ikenItem60 = entity.ikenItem60;
        this.ikenItem61 = entity.ikenItem61;
        this.ikenItem62 = entity.ikenItem62;
        this.ikenItem63 = entity.ikenItem63;
        this.ikenItem64 = entity.ikenItem64;
        this.ikenItem65 = entity.ikenItem65;
        this.ikenItem66 = entity.ikenItem66;
        this.ikenItem67 = entity.ikenItem67;
        this.ikenItem68 = entity.ikenItem68;
        this.ikenItem69 = entity.ikenItem69;
        this.ikenItem70 = entity.ikenItem70;
        this.ikenItem71 = entity.ikenItem71;
        this.ikenItem72 = entity.ikenItem72;
        this.ikenItem73 = entity.ikenItem73;
        this.ikenItem74 = entity.ikenItem74;
        this.ikenItem75 = entity.ikenItem75;
        this.ikenItem76 = entity.ikenItem76;
        this.ikenItem77 = entity.ikenItem77;
        this.ikenItem78 = entity.ikenItem78;
        this.ikenItem79 = entity.ikenItem79;
        this.ikenItem80 = entity.ikenItem80;
        this.ikenItem81 = entity.ikenItem81;
        this.ikenItem82 = entity.ikenItem82;
        this.ikenItem83 = entity.ikenItem83;
        this.ikenItem84 = entity.ikenItem84;
        this.ikenItem85 = entity.ikenItem85;
        this.ikenItem86 = entity.ikenItem86;
        this.ikenItem87 = entity.ikenItem87;
        this.ikenItem88 = entity.ikenItem88;
        this.ikenItem89 = entity.ikenItem89;
        this.ikenItem90 = entity.ikenItem90;
        this.ikenItem91 = entity.ikenItem91;
        this.ikenItem92 = entity.ikenItem92;
        this.ikenItem93 = entity.ikenItem93;
        this.ikenItem94 = entity.ikenItem94;
        this.ikenItem95 = entity.ikenItem95;
        this.ikenItem96 = entity.ikenItem96;
        this.ikenItem97 = entity.ikenItem97;
        this.ikenItem98 = entity.ikenItem98;
        this.ikenItem99 = entity.ikenItem99;
        this.ikenItem100 = entity.ikenItem100;
        this.ikenItem101 = entity.ikenItem101;
        this.ikenItem102 = entity.ikenItem102;
        this.ikenItem103 = entity.ikenItem103;
        this.ikenItem104 = entity.ikenItem104;
        this.ikenItem105 = entity.ikenItem105;
        this.ikenItem106 = entity.ikenItem106;
        this.ikenItem107 = entity.ikenItem107;
        this.ikenItem108 = entity.ikenItem108;
        this.ikenItem109 = entity.ikenItem109;
        this.ikenItem110 = entity.ikenItem110;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ikenshoIraiRirekiNo, koroshoIfShikibetsuCode, ikenItem01, ikenItem02, ikenItem03, ikenItem04, ikenItem05, ikenItem06, ikenItem07, ikenItem08, ikenItem09, ikenItem10, ikenItem11, ikenItem12, ikenItem13, ikenItem14, ikenItem15, ikenItem16, ikenItem17, ikenItem18, ikenItem19, ikenItem20, ikenItem21, ikenItem22, ikenItem23, ikenItem24, ikenItem25, ikenItem26, ikenItem27, ikenItem28, ikenItem29, ikenItem30, ikenItem31, ikenItem32, ikenItem33, ikenItem34, ikenItem35, ikenItem36, ikenItem37, ikenItem38, ikenItem39, ikenItem40, ikenItem41, ikenItem42, ikenItem43, ikenItem44, ikenItem45, ikenItem46, ikenItem47, ikenItem48, ikenItem49, ikenItem50, ikenItem51, ikenItem52, ikenItem53, ikenItem54, ikenItem55, ikenItem56, ikenItem57, ikenItem58, ikenItem59, ikenItem60, ikenItem61, ikenItem62, ikenItem63, ikenItem64, ikenItem65, ikenItem66, ikenItem67, ikenItem68, ikenItem69, ikenItem70, ikenItem71, ikenItem72, ikenItem73, ikenItem74, ikenItem75, ikenItem76, ikenItem77, ikenItem78, ikenItem79, ikenItem80, ikenItem81, ikenItem82, ikenItem83, ikenItem84, ikenItem85, ikenItem86, ikenItem87, ikenItem88, ikenItem89, ikenItem90, ikenItem91, ikenItem92, ikenItem93, ikenItem94, ikenItem95, ikenItem96, ikenItem97, ikenItem98, ikenItem99, ikenItem100, ikenItem101, ikenItem102, ikenItem103, ikenItem104, ikenItem105, ikenItem106, ikenItem107, ikenItem108, ikenItem109, ikenItem110);
    }

// </editor-fold>
}
