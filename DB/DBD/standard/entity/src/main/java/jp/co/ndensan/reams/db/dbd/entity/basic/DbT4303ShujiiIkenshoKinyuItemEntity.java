package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 要介護認定主治医意見書記入項目テーブルのエンティティクラスです。
 */
public class DbT4303ShujiiIkenshoKinyuItemEntity extends DbTableEntityBase<DbT4303ShujiiIkenshoKinyuItemEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4303ShujiiIkenshoKinyuItem");

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
    private RString shindamMei1;
    private FlexibleDate hasshoYMD1;
    private RString shindamMei2;
    private FlexibleDate hasshoYMD2;
    private RString shindamMei3;
    private FlexibleDate hasshoYMD3;
    private RString anteisei;
    private RString kinyuItem01;
    private RString kinyuItem02;
    private RString kinyuItem03;
    private RString kinyuItem04;
    private RString kinyuItem05;
    private RString kinyuItem06;
    private RString kinyuItem07;
    private RString kinyuItem08;
    private RString kinyuItem09;
    private RString kinyuItem10;
    private RString kinyuItem11;
    private RString kinyuItem12;
    private RString kinyuItem13;
    private RString kinyuItem14;
    private RString kinyuItem15;
    private RString kinyuItem16;
    private RString kinyuItem17;
    private RString kinyuItem18;
    private RString kinyuItem19;
    private RString kinyuItem20;
    private RString kinyuItem21;
    private RString kinyuItem22;
    private RString kinyuItem23;
    private RString kinyuItem24;
    private RString kinyuItem25;
    private RString kinyuItem26;
    private RString kinyuItem27;
    private RString kinyuItem28;
    private RString kinyuItem29;
    private RString kinyuItem30;
    private RString tokkiJiko;
    private RDateTime kinyuItem01ImageSharedFileId;
    private RDateTime kinyuItem02ImageSharedFileId;
    private RDateTime kinyuItem03ImageSharedFileId;
    private RDateTime kinyuItem04ImageSharedFileId;
    private RDateTime kinyuItem05ImageSharedFileId;
    private RDateTime kinyuItem06ImageSharedFileId;
    private RDateTime kinyuItem07ImageSharedFileId;
    private RDateTime kinyuItem08ImageSharedFileId;
    private RDateTime kinyuItem09ImageSharedFileId;
    private RDateTime kinyuItem10ImageSharedFileId;
    private RDateTime kinyuItem11ImageSharedFileId;
    private RDateTime kinyuItem12ImageSharedFileId;
    private RDateTime kinyuItem13ImageSharedFileId;
    private RDateTime kinyuItem14ImageSharedFileId;
    private RDateTime kinyuItem15ImageSharedFileId;
    private RDateTime kinyuItem16ImageSharedFileId;
    private RDateTime kinyuItem17ImageSharedFileId;
    private RDateTime kinyuItem18ImageSharedFileId;
    private RDateTime kinyuItem19ImageSharedFileId;
    private RDateTime kinyuItem20ImageSharedFileId;
    private RDateTime kinyuItem21ImageSharedFileId;
    private RDateTime kinyuItem22ImageSharedFileId;
    private RDateTime kinyuItem23ImageSharedFileId;
    private RDateTime kinyuItem24ImageSharedFileId;
    private RDateTime kinyuItem25ImageSharedFileId;
    private RDateTime kinyuItem26ImageSharedFileId;
    private RDateTime kinyuItem27ImageSharedFileId;
    private RDateTime kinyuItem28ImageSharedFileId;
    private RDateTime kinyuItem29ImageSharedFileId;
    private RDateTime kinyuItem30ImageSharedFileId;
    private RDateTime tokkiJikoImageSharedFileId;

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
     * 意見書・診断名1のgetメソッドです。
     * 
     * @return 意見書・診断名1
     */
    public RString getShindamMei1() {
        return shindamMei1;
    }

    /**
     * 意見書・診断名1のsetメソッドです。
     * 
     * @param shindamMei1 意見書・診断名1
     */
    public void setShindamMei1(RString shindamMei1) {
        this.shindamMei1 = shindamMei1;
    }

    /**
     * 意見書・発症年月日1のgetメソッドです。
     * 
     * @return 意見書・発症年月日1
     */
    public FlexibleDate getHasshoYMD1() {
        return hasshoYMD1;
    }

    /**
     * 意見書・発症年月日1のsetメソッドです。
     * 
     * @param hasshoYMD1 意見書・発症年月日1
     */
    public void setHasshoYMD1(FlexibleDate hasshoYMD1) {
        this.hasshoYMD1 = hasshoYMD1;
    }

    /**
     * 意見書・診断名2のgetメソッドです。
     * 
     * @return 意見書・診断名2
     */
    public RString getShindamMei2() {
        return shindamMei2;
    }

    /**
     * 意見書・診断名2のsetメソッドです。
     * 
     * @param shindamMei2 意見書・診断名2
     */
    public void setShindamMei2(RString shindamMei2) {
        this.shindamMei2 = shindamMei2;
    }

    /**
     * 意見書・発症年月日2のgetメソッドです。
     * 
     * @return 意見書・発症年月日2
     */
    public FlexibleDate getHasshoYMD2() {
        return hasshoYMD2;
    }

    /**
     * 意見書・発症年月日2のsetメソッドです。
     * 
     * @param hasshoYMD2 意見書・発症年月日2
     */
    public void setHasshoYMD2(FlexibleDate hasshoYMD2) {
        this.hasshoYMD2 = hasshoYMD2;
    }

    /**
     * 意見書・診断名3のgetメソッドです。
     * 
     * @return 意見書・診断名3
     */
    public RString getShindamMei3() {
        return shindamMei3;
    }

    /**
     * 意見書・診断名3のsetメソッドです。
     * 
     * @param shindamMei3 意見書・診断名3
     */
    public void setShindamMei3(RString shindamMei3) {
        this.shindamMei3 = shindamMei3;
    }

    /**
     * 意見書・発症年月日3のgetメソッドです。
     * 
     * @return 意見書・発症年月日3
     */
    public FlexibleDate getHasshoYMD3() {
        return hasshoYMD3;
    }

    /**
     * 意見書・発症年月日3のsetメソッドです。
     * 
     * @param hasshoYMD3 意見書・発症年月日3
     */
    public void setHasshoYMD3(FlexibleDate hasshoYMD3) {
        this.hasshoYMD3 = hasshoYMD3;
    }

    /**
     * 意見書・症状としての安定性のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書・症状としての安定性）
     * 
     * @return 意見書・症状としての安定性
     */
    public RString getAnteisei() {
        return anteisei;
    }

    /**
     * 意見書・症状としての安定性のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書・症状としての安定性）
     * 
     * @param anteisei 意見書・症状としての安定性
     */
    public void setAnteisei(RString anteisei) {
        this.anteisei = anteisei;
    }

    /**
     * 記入項目01のgetメソッドです。
     * 
     * @return 記入項目01
     */
    public RString getKinyuItem01() {
        return kinyuItem01;
    }

    /**
     * 記入項目01のsetメソッドです。
     * 
     * @param kinyuItem01 記入項目01
     */
    public void setKinyuItem01(RString kinyuItem01) {
        this.kinyuItem01 = kinyuItem01;
    }

    /**
     * 記入項目02のgetメソッドです。
     * 
     * @return 記入項目02
     */
    public RString getKinyuItem02() {
        return kinyuItem02;
    }

    /**
     * 記入項目02のsetメソッドです。
     * 
     * @param kinyuItem02 記入項目02
     */
    public void setKinyuItem02(RString kinyuItem02) {
        this.kinyuItem02 = kinyuItem02;
    }

    /**
     * 記入項目03のgetメソッドです。
     * 
     * @return 記入項目03
     */
    public RString getKinyuItem03() {
        return kinyuItem03;
    }

    /**
     * 記入項目03のsetメソッドです。
     * 
     * @param kinyuItem03 記入項目03
     */
    public void setKinyuItem03(RString kinyuItem03) {
        this.kinyuItem03 = kinyuItem03;
    }

    /**
     * 記入項目04のgetメソッドです。
     * 
     * @return 記入項目04
     */
    public RString getKinyuItem04() {
        return kinyuItem04;
    }

    /**
     * 記入項目04のsetメソッドです。
     * 
     * @param kinyuItem04 記入項目04
     */
    public void setKinyuItem04(RString kinyuItem04) {
        this.kinyuItem04 = kinyuItem04;
    }

    /**
     * 記入項目05のgetメソッドです。
     * 
     * @return 記入項目05
     */
    public RString getKinyuItem05() {
        return kinyuItem05;
    }

    /**
     * 記入項目05のsetメソッドです。
     * 
     * @param kinyuItem05 記入項目05
     */
    public void setKinyuItem05(RString kinyuItem05) {
        this.kinyuItem05 = kinyuItem05;
    }

    /**
     * 記入項目06のgetメソッドです。
     * 
     * @return 記入項目06
     */
    public RString getKinyuItem06() {
        return kinyuItem06;
    }

    /**
     * 記入項目06のsetメソッドです。
     * 
     * @param kinyuItem06 記入項目06
     */
    public void setKinyuItem06(RString kinyuItem06) {
        this.kinyuItem06 = kinyuItem06;
    }

    /**
     * 記入項目07のgetメソッドです。
     * 
     * @return 記入項目07
     */
    public RString getKinyuItem07() {
        return kinyuItem07;
    }

    /**
     * 記入項目07のsetメソッドです。
     * 
     * @param kinyuItem07 記入項目07
     */
    public void setKinyuItem07(RString kinyuItem07) {
        this.kinyuItem07 = kinyuItem07;
    }

    /**
     * 記入項目08のgetメソッドです。
     * 
     * @return 記入項目08
     */
    public RString getKinyuItem08() {
        return kinyuItem08;
    }

    /**
     * 記入項目08のsetメソッドです。
     * 
     * @param kinyuItem08 記入項目08
     */
    public void setKinyuItem08(RString kinyuItem08) {
        this.kinyuItem08 = kinyuItem08;
    }

    /**
     * 記入項目09のgetメソッドです。
     * 
     * @return 記入項目09
     */
    public RString getKinyuItem09() {
        return kinyuItem09;
    }

    /**
     * 記入項目09のsetメソッドです。
     * 
     * @param kinyuItem09 記入項目09
     */
    public void setKinyuItem09(RString kinyuItem09) {
        this.kinyuItem09 = kinyuItem09;
    }

    /**
     * 記入項目10のgetメソッドです。
     * 
     * @return 記入項目10
     */
    public RString getKinyuItem10() {
        return kinyuItem10;
    }

    /**
     * 記入項目10のsetメソッドです。
     * 
     * @param kinyuItem10 記入項目10
     */
    public void setKinyuItem10(RString kinyuItem10) {
        this.kinyuItem10 = kinyuItem10;
    }

    /**
     * 記入項目11のgetメソッドです。
     * 
     * @return 記入項目11
     */
    public RString getKinyuItem11() {
        return kinyuItem11;
    }

    /**
     * 記入項目11のsetメソッドです。
     * 
     * @param kinyuItem11 記入項目11
     */
    public void setKinyuItem11(RString kinyuItem11) {
        this.kinyuItem11 = kinyuItem11;
    }

    /**
     * 記入項目12のgetメソッドです。
     * 
     * @return 記入項目12
     */
    public RString getKinyuItem12() {
        return kinyuItem12;
    }

    /**
     * 記入項目12のsetメソッドです。
     * 
     * @param kinyuItem12 記入項目12
     */
    public void setKinyuItem12(RString kinyuItem12) {
        this.kinyuItem12 = kinyuItem12;
    }

    /**
     * 記入項目13のgetメソッドです。
     * 
     * @return 記入項目13
     */
    public RString getKinyuItem13() {
        return kinyuItem13;
    }

    /**
     * 記入項目13のsetメソッドです。
     * 
     * @param kinyuItem13 記入項目13
     */
    public void setKinyuItem13(RString kinyuItem13) {
        this.kinyuItem13 = kinyuItem13;
    }

    /**
     * 記入項目14のgetメソッドです。
     * 
     * @return 記入項目14
     */
    public RString getKinyuItem14() {
        return kinyuItem14;
    }

    /**
     * 記入項目14のsetメソッドです。
     * 
     * @param kinyuItem14 記入項目14
     */
    public void setKinyuItem14(RString kinyuItem14) {
        this.kinyuItem14 = kinyuItem14;
    }

    /**
     * 記入項目15のgetメソッドです。
     * 
     * @return 記入項目15
     */
    public RString getKinyuItem15() {
        return kinyuItem15;
    }

    /**
     * 記入項目15のsetメソッドです。
     * 
     * @param kinyuItem15 記入項目15
     */
    public void setKinyuItem15(RString kinyuItem15) {
        this.kinyuItem15 = kinyuItem15;
    }

    /**
     * 記入項目16のgetメソッドです。
     * 
     * @return 記入項目16
     */
    public RString getKinyuItem16() {
        return kinyuItem16;
    }

    /**
     * 記入項目16のsetメソッドです。
     * 
     * @param kinyuItem16 記入項目16
     */
    public void setKinyuItem16(RString kinyuItem16) {
        this.kinyuItem16 = kinyuItem16;
    }

    /**
     * 記入項目17のgetメソッドです。
     * 
     * @return 記入項目17
     */
    public RString getKinyuItem17() {
        return kinyuItem17;
    }

    /**
     * 記入項目17のsetメソッドです。
     * 
     * @param kinyuItem17 記入項目17
     */
    public void setKinyuItem17(RString kinyuItem17) {
        this.kinyuItem17 = kinyuItem17;
    }

    /**
     * 記入項目18のgetメソッドです。
     * 
     * @return 記入項目18
     */
    public RString getKinyuItem18() {
        return kinyuItem18;
    }

    /**
     * 記入項目18のsetメソッドです。
     * 
     * @param kinyuItem18 記入項目18
     */
    public void setKinyuItem18(RString kinyuItem18) {
        this.kinyuItem18 = kinyuItem18;
    }

    /**
     * 記入項目19のgetメソッドです。
     * 
     * @return 記入項目19
     */
    public RString getKinyuItem19() {
        return kinyuItem19;
    }

    /**
     * 記入項目19のsetメソッドです。
     * 
     * @param kinyuItem19 記入項目19
     */
    public void setKinyuItem19(RString kinyuItem19) {
        this.kinyuItem19 = kinyuItem19;
    }

    /**
     * 記入項目10のgetメソッドです。
     * 
     * @return 記入項目10
     */
    public RString getKinyuItem20() {
        return kinyuItem20;
    }

    /**
     * 記入項目10のsetメソッドです。
     * 
     * @param kinyuItem20 記入項目10
     */
    public void setKinyuItem20(RString kinyuItem20) {
        this.kinyuItem20 = kinyuItem20;
    }

    /**
     * 記入項目21のgetメソッドです。
     * 
     * @return 記入項目21
     */
    public RString getKinyuItem21() {
        return kinyuItem21;
    }

    /**
     * 記入項目21のsetメソッドです。
     * 
     * @param kinyuItem21 記入項目21
     */
    public void setKinyuItem21(RString kinyuItem21) {
        this.kinyuItem21 = kinyuItem21;
    }

    /**
     * 記入項目22のgetメソッドです。
     * 
     * @return 記入項目22
     */
    public RString getKinyuItem22() {
        return kinyuItem22;
    }

    /**
     * 記入項目22のsetメソッドです。
     * 
     * @param kinyuItem22 記入項目22
     */
    public void setKinyuItem22(RString kinyuItem22) {
        this.kinyuItem22 = kinyuItem22;
    }

    /**
     * 記入項目23のgetメソッドです。
     * 
     * @return 記入項目23
     */
    public RString getKinyuItem23() {
        return kinyuItem23;
    }

    /**
     * 記入項目23のsetメソッドです。
     * 
     * @param kinyuItem23 記入項目23
     */
    public void setKinyuItem23(RString kinyuItem23) {
        this.kinyuItem23 = kinyuItem23;
    }

    /**
     * 記入項目24のgetメソッドです。
     * 
     * @return 記入項目24
     */
    public RString getKinyuItem24() {
        return kinyuItem24;
    }

    /**
     * 記入項目24のsetメソッドです。
     * 
     * @param kinyuItem24 記入項目24
     */
    public void setKinyuItem24(RString kinyuItem24) {
        this.kinyuItem24 = kinyuItem24;
    }

    /**
     * 記入項目25のgetメソッドです。
     * 
     * @return 記入項目25
     */
    public RString getKinyuItem25() {
        return kinyuItem25;
    }

    /**
     * 記入項目25のsetメソッドです。
     * 
     * @param kinyuItem25 記入項目25
     */
    public void setKinyuItem25(RString kinyuItem25) {
        this.kinyuItem25 = kinyuItem25;
    }

    /**
     * 記入項目26のgetメソッドです。
     * 
     * @return 記入項目26
     */
    public RString getKinyuItem26() {
        return kinyuItem26;
    }

    /**
     * 記入項目26のsetメソッドです。
     * 
     * @param kinyuItem26 記入項目26
     */
    public void setKinyuItem26(RString kinyuItem26) {
        this.kinyuItem26 = kinyuItem26;
    }

    /**
     * 記入項目27のgetメソッドです。
     * 
     * @return 記入項目27
     */
    public RString getKinyuItem27() {
        return kinyuItem27;
    }

    /**
     * 記入項目27のsetメソッドです。
     * 
     * @param kinyuItem27 記入項目27
     */
    public void setKinyuItem27(RString kinyuItem27) {
        this.kinyuItem27 = kinyuItem27;
    }

    /**
     * 記入項目28のgetメソッドです。
     * 
     * @return 記入項目28
     */
    public RString getKinyuItem28() {
        return kinyuItem28;
    }

    /**
     * 記入項目28のsetメソッドです。
     * 
     * @param kinyuItem28 記入項目28
     */
    public void setKinyuItem28(RString kinyuItem28) {
        this.kinyuItem28 = kinyuItem28;
    }

    /**
     * 記入項目29のgetメソッドです。
     * 
     * @return 記入項目29
     */
    public RString getKinyuItem29() {
        return kinyuItem29;
    }

    /**
     * 記入項目29のsetメソッドです。
     * 
     * @param kinyuItem29 記入項目29
     */
    public void setKinyuItem29(RString kinyuItem29) {
        this.kinyuItem29 = kinyuItem29;
    }

    /**
     * 記入項目30のgetメソッドです。
     * 
     * @return 記入項目30
     */
    public RString getKinyuItem30() {
        return kinyuItem30;
    }

    /**
     * 記入項目30のsetメソッドです。
     * 
     * @param kinyuItem30 記入項目30
     */
    public void setKinyuItem30(RString kinyuItem30) {
        this.kinyuItem30 = kinyuItem30;
    }

    /**
     * 特記事項のgetメソッドです。
     * 
     * @return 特記事項
     */
    public RString getTokkiJiko() {
        return tokkiJiko;
    }

    /**
     * 特記事項のsetメソッドです。
     * 
     * @param tokkiJiko 特記事項
     */
    public void setTokkiJiko(RString tokkiJiko) {
        this.tokkiJiko = tokkiJiko;
    }

    /**
     * 記入項目01イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目01イメージ共有ファイルID
     */
    public RDateTime getKinyuItem01ImageSharedFileId() {
        return kinyuItem01ImageSharedFileId;
    }

    /**
     * 記入項目01イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem01ImageSharedFileId 記入項目01イメージ共有ファイルID
     */
    public void setKinyuItem01ImageSharedFileId(RDateTime kinyuItem01ImageSharedFileId) {
        this.kinyuItem01ImageSharedFileId = kinyuItem01ImageSharedFileId;
    }

    /**
     * 記入項目02イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目02イメージ共有ファイルID
     */
    public RDateTime getKinyuItem02ImageSharedFileId() {
        return kinyuItem02ImageSharedFileId;
    }

    /**
     * 記入項目02イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem02ImageSharedFileId 記入項目02イメージ共有ファイルID
     */
    public void setKinyuItem02ImageSharedFileId(RDateTime kinyuItem02ImageSharedFileId) {
        this.kinyuItem02ImageSharedFileId = kinyuItem02ImageSharedFileId;
    }

    /**
     * 記入項目03イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目03イメージ共有ファイルID
     */
    public RDateTime getKinyuItem03ImageSharedFileId() {
        return kinyuItem03ImageSharedFileId;
    }

    /**
     * 記入項目03イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem03ImageSharedFileId 記入項目03イメージ共有ファイルID
     */
    public void setKinyuItem03ImageSharedFileId(RDateTime kinyuItem03ImageSharedFileId) {
        this.kinyuItem03ImageSharedFileId = kinyuItem03ImageSharedFileId;
    }

    /**
     * 記入項目04イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目04イメージ共有ファイルID
     */
    public RDateTime getKinyuItem04ImageSharedFileId() {
        return kinyuItem04ImageSharedFileId;
    }

    /**
     * 記入項目04イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem04ImageSharedFileId 記入項目04イメージ共有ファイルID
     */
    public void setKinyuItem04ImageSharedFileId(RDateTime kinyuItem04ImageSharedFileId) {
        this.kinyuItem04ImageSharedFileId = kinyuItem04ImageSharedFileId;
    }

    /**
     * 記入項目05イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目05イメージ共有ファイルID
     */
    public RDateTime getKinyuItem05ImageSharedFileId() {
        return kinyuItem05ImageSharedFileId;
    }

    /**
     * 記入項目05イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem05ImageSharedFileId 記入項目05イメージ共有ファイルID
     */
    public void setKinyuItem05ImageSharedFileId(RDateTime kinyuItem05ImageSharedFileId) {
        this.kinyuItem05ImageSharedFileId = kinyuItem05ImageSharedFileId;
    }

    /**
     * 記入項目06イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目06イメージ共有ファイルID
     */
    public RDateTime getKinyuItem06ImageSharedFileId() {
        return kinyuItem06ImageSharedFileId;
    }

    /**
     * 記入項目06イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem06ImageSharedFileId 記入項目06イメージ共有ファイルID
     */
    public void setKinyuItem06ImageSharedFileId(RDateTime kinyuItem06ImageSharedFileId) {
        this.kinyuItem06ImageSharedFileId = kinyuItem06ImageSharedFileId;
    }

    /**
     * 記入項目07イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目07イメージ共有ファイルID
     */
    public RDateTime getKinyuItem07ImageSharedFileId() {
        return kinyuItem07ImageSharedFileId;
    }

    /**
     * 記入項目07イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem07ImageSharedFileId 記入項目07イメージ共有ファイルID
     */
    public void setKinyuItem07ImageSharedFileId(RDateTime kinyuItem07ImageSharedFileId) {
        this.kinyuItem07ImageSharedFileId = kinyuItem07ImageSharedFileId;
    }

    /**
     * 記入項目08イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目08イメージ共有ファイルID
     */
    public RDateTime getKinyuItem08ImageSharedFileId() {
        return kinyuItem08ImageSharedFileId;
    }

    /**
     * 記入項目08イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem08ImageSharedFileId 記入項目08イメージ共有ファイルID
     */
    public void setKinyuItem08ImageSharedFileId(RDateTime kinyuItem08ImageSharedFileId) {
        this.kinyuItem08ImageSharedFileId = kinyuItem08ImageSharedFileId;
    }

    /**
     * 記入項目09イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目09イメージ共有ファイルID
     */
    public RDateTime getKinyuItem09ImageSharedFileId() {
        return kinyuItem09ImageSharedFileId;
    }

    /**
     * 記入項目09イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem09ImageSharedFileId 記入項目09イメージ共有ファイルID
     */
    public void setKinyuItem09ImageSharedFileId(RDateTime kinyuItem09ImageSharedFileId) {
        this.kinyuItem09ImageSharedFileId = kinyuItem09ImageSharedFileId;
    }

    /**
     * 記入項目10イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目10イメージ共有ファイルID
     */
    public RDateTime getKinyuItem10ImageSharedFileId() {
        return kinyuItem10ImageSharedFileId;
    }

    /**
     * 記入項目10イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem10ImageSharedFileId 記入項目10イメージ共有ファイルID
     */
    public void setKinyuItem10ImageSharedFileId(RDateTime kinyuItem10ImageSharedFileId) {
        this.kinyuItem10ImageSharedFileId = kinyuItem10ImageSharedFileId;
    }

    /**
     * 記入項目11イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目11イメージ共有ファイルID
     */
    public RDateTime getKinyuItem11ImageSharedFileId() {
        return kinyuItem11ImageSharedFileId;
    }

    /**
     * 記入項目11イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem11ImageSharedFileId 記入項目11イメージ共有ファイルID
     */
    public void setKinyuItem11ImageSharedFileId(RDateTime kinyuItem11ImageSharedFileId) {
        this.kinyuItem11ImageSharedFileId = kinyuItem11ImageSharedFileId;
    }

    /**
     * 記入項目12イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目12イメージ共有ファイルID
     */
    public RDateTime getKinyuItem12ImageSharedFileId() {
        return kinyuItem12ImageSharedFileId;
    }

    /**
     * 記入項目12イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem12ImageSharedFileId 記入項目12イメージ共有ファイルID
     */
    public void setKinyuItem12ImageSharedFileId(RDateTime kinyuItem12ImageSharedFileId) {
        this.kinyuItem12ImageSharedFileId = kinyuItem12ImageSharedFileId;
    }

    /**
     * 記入項目13イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目13イメージ共有ファイルID
     */
    public RDateTime getKinyuItem13ImageSharedFileId() {
        return kinyuItem13ImageSharedFileId;
    }

    /**
     * 記入項目13イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem13ImageSharedFileId 記入項目13イメージ共有ファイルID
     */
    public void setKinyuItem13ImageSharedFileId(RDateTime kinyuItem13ImageSharedFileId) {
        this.kinyuItem13ImageSharedFileId = kinyuItem13ImageSharedFileId;
    }

    /**
     * 記入項目14イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目14イメージ共有ファイルID
     */
    public RDateTime getKinyuItem14ImageSharedFileId() {
        return kinyuItem14ImageSharedFileId;
    }

    /**
     * 記入項目14イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem14ImageSharedFileId 記入項目14イメージ共有ファイルID
     */
    public void setKinyuItem14ImageSharedFileId(RDateTime kinyuItem14ImageSharedFileId) {
        this.kinyuItem14ImageSharedFileId = kinyuItem14ImageSharedFileId;
    }

    /**
     * 記入項目15イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目15イメージ共有ファイルID
     */
    public RDateTime getKinyuItem15ImageSharedFileId() {
        return kinyuItem15ImageSharedFileId;
    }

    /**
     * 記入項目15イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem15ImageSharedFileId 記入項目15イメージ共有ファイルID
     */
    public void setKinyuItem15ImageSharedFileId(RDateTime kinyuItem15ImageSharedFileId) {
        this.kinyuItem15ImageSharedFileId = kinyuItem15ImageSharedFileId;
    }

    /**
     * 記入項目16イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目16イメージ共有ファイルID
     */
    public RDateTime getKinyuItem16ImageSharedFileId() {
        return kinyuItem16ImageSharedFileId;
    }

    /**
     * 記入項目16イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem16ImageSharedFileId 記入項目16イメージ共有ファイルID
     */
    public void setKinyuItem16ImageSharedFileId(RDateTime kinyuItem16ImageSharedFileId) {
        this.kinyuItem16ImageSharedFileId = kinyuItem16ImageSharedFileId;
    }

    /**
     * 記入項目17イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目17イメージ共有ファイルID
     */
    public RDateTime getKinyuItem17ImageSharedFileId() {
        return kinyuItem17ImageSharedFileId;
    }

    /**
     * 記入項目17イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem17ImageSharedFileId 記入項目17イメージ共有ファイルID
     */
    public void setKinyuItem17ImageSharedFileId(RDateTime kinyuItem17ImageSharedFileId) {
        this.kinyuItem17ImageSharedFileId = kinyuItem17ImageSharedFileId;
    }

    /**
     * 記入項目18イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目18イメージ共有ファイルID
     */
    public RDateTime getKinyuItem18ImageSharedFileId() {
        return kinyuItem18ImageSharedFileId;
    }

    /**
     * 記入項目18イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem18ImageSharedFileId 記入項目18イメージ共有ファイルID
     */
    public void setKinyuItem18ImageSharedFileId(RDateTime kinyuItem18ImageSharedFileId) {
        this.kinyuItem18ImageSharedFileId = kinyuItem18ImageSharedFileId;
    }

    /**
     * 記入項目19イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目19イメージ共有ファイルID
     */
    public RDateTime getKinyuItem19ImageSharedFileId() {
        return kinyuItem19ImageSharedFileId;
    }

    /**
     * 記入項目19イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem19ImageSharedFileId 記入項目19イメージ共有ファイルID
     */
    public void setKinyuItem19ImageSharedFileId(RDateTime kinyuItem19ImageSharedFileId) {
        this.kinyuItem19ImageSharedFileId = kinyuItem19ImageSharedFileId;
    }

    /**
     * 記入項目20イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目20イメージ共有ファイルID
     */
    public RDateTime getKinyuItem20ImageSharedFileId() {
        return kinyuItem20ImageSharedFileId;
    }

    /**
     * 記入項目20イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem20ImageSharedFileId 記入項目20イメージ共有ファイルID
     */
    public void setKinyuItem20ImageSharedFileId(RDateTime kinyuItem20ImageSharedFileId) {
        this.kinyuItem20ImageSharedFileId = kinyuItem20ImageSharedFileId;
    }

    /**
     * 記入項目21イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目21イメージ共有ファイルID
     */
    public RDateTime getKinyuItem21ImageSharedFileId() {
        return kinyuItem21ImageSharedFileId;
    }

    /**
     * 記入項目21イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem21ImageSharedFileId 記入項目21イメージ共有ファイルID
     */
    public void setKinyuItem21ImageSharedFileId(RDateTime kinyuItem21ImageSharedFileId) {
        this.kinyuItem21ImageSharedFileId = kinyuItem21ImageSharedFileId;
    }

    /**
     * 記入項目22イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目22イメージ共有ファイルID
     */
    public RDateTime getKinyuItem22ImageSharedFileId() {
        return kinyuItem22ImageSharedFileId;
    }

    /**
     * 記入項目22イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem22ImageSharedFileId 記入項目22イメージ共有ファイルID
     */
    public void setKinyuItem22ImageSharedFileId(RDateTime kinyuItem22ImageSharedFileId) {
        this.kinyuItem22ImageSharedFileId = kinyuItem22ImageSharedFileId;
    }

    /**
     * 記入項目23イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目23イメージ共有ファイルID
     */
    public RDateTime getKinyuItem23ImageSharedFileId() {
        return kinyuItem23ImageSharedFileId;
    }

    /**
     * 記入項目23イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem23ImageSharedFileId 記入項目23イメージ共有ファイルID
     */
    public void setKinyuItem23ImageSharedFileId(RDateTime kinyuItem23ImageSharedFileId) {
        this.kinyuItem23ImageSharedFileId = kinyuItem23ImageSharedFileId;
    }

    /**
     * 記入項目24イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目24イメージ共有ファイルID
     */
    public RDateTime getKinyuItem24ImageSharedFileId() {
        return kinyuItem24ImageSharedFileId;
    }

    /**
     * 記入項目24イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem24ImageSharedFileId 記入項目24イメージ共有ファイルID
     */
    public void setKinyuItem24ImageSharedFileId(RDateTime kinyuItem24ImageSharedFileId) {
        this.kinyuItem24ImageSharedFileId = kinyuItem24ImageSharedFileId;
    }

    /**
     * 記入項目25イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目25イメージ共有ファイルID
     */
    public RDateTime getKinyuItem25ImageSharedFileId() {
        return kinyuItem25ImageSharedFileId;
    }

    /**
     * 記入項目25イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem25ImageSharedFileId 記入項目25イメージ共有ファイルID
     */
    public void setKinyuItem25ImageSharedFileId(RDateTime kinyuItem25ImageSharedFileId) {
        this.kinyuItem25ImageSharedFileId = kinyuItem25ImageSharedFileId;
    }

    /**
     * 記入項目26イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目26イメージ共有ファイルID
     */
    public RDateTime getKinyuItem26ImageSharedFileId() {
        return kinyuItem26ImageSharedFileId;
    }

    /**
     * 記入項目26イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem26ImageSharedFileId 記入項目26イメージ共有ファイルID
     */
    public void setKinyuItem26ImageSharedFileId(RDateTime kinyuItem26ImageSharedFileId) {
        this.kinyuItem26ImageSharedFileId = kinyuItem26ImageSharedFileId;
    }

    /**
     * 記入項目27イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目27イメージ共有ファイルID
     */
    public RDateTime getKinyuItem27ImageSharedFileId() {
        return kinyuItem27ImageSharedFileId;
    }

    /**
     * 記入項目27イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem27ImageSharedFileId 記入項目27イメージ共有ファイルID
     */
    public void setKinyuItem27ImageSharedFileId(RDateTime kinyuItem27ImageSharedFileId) {
        this.kinyuItem27ImageSharedFileId = kinyuItem27ImageSharedFileId;
    }

    /**
     * 記入項目28イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目28イメージ共有ファイルID
     */
    public RDateTime getKinyuItem28ImageSharedFileId() {
        return kinyuItem28ImageSharedFileId;
    }

    /**
     * 記入項目28イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem28ImageSharedFileId 記入項目28イメージ共有ファイルID
     */
    public void setKinyuItem28ImageSharedFileId(RDateTime kinyuItem28ImageSharedFileId) {
        this.kinyuItem28ImageSharedFileId = kinyuItem28ImageSharedFileId;
    }

    /**
     * 記入項目29イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目29イメージ共有ファイルID
     */
    public RDateTime getKinyuItem29ImageSharedFileId() {
        return kinyuItem29ImageSharedFileId;
    }

    /**
     * 記入項目29イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem29ImageSharedFileId 記入項目29イメージ共有ファイルID
     */
    public void setKinyuItem29ImageSharedFileId(RDateTime kinyuItem29ImageSharedFileId) {
        this.kinyuItem29ImageSharedFileId = kinyuItem29ImageSharedFileId;
    }

    /**
     * 記入項目30イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 記入項目30イメージ共有ファイルID
     */
    public RDateTime getKinyuItem30ImageSharedFileId() {
        return kinyuItem30ImageSharedFileId;
    }

    /**
     * 記入項目30イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param kinyuItem30ImageSharedFileId 記入項目30イメージ共有ファイルID
     */
    public void setKinyuItem30ImageSharedFileId(RDateTime kinyuItem30ImageSharedFileId) {
        this.kinyuItem30ImageSharedFileId = kinyuItem30ImageSharedFileId;
    }

    /**
     * 特記事項イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 特記事項イメージ共有ファイルID
     */
    public RDateTime getTokkiJikoImageSharedFileId() {
        return tokkiJikoImageSharedFileId;
    }

    /**
     * 特記事項イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param tokkiJikoImageSharedFileId 特記事項イメージ共有ファイルID
     */
    public void setTokkiJikoImageSharedFileId(RDateTime tokkiJikoImageSharedFileId) {
        this.tokkiJikoImageSharedFileId = tokkiJikoImageSharedFileId;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4303ShujiiIkenshoKinyuItemEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4303ShujiiIkenshoKinyuItemEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4303ShujiiIkenshoKinyuItemEntity other) {
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
    public void shallowCopy(DbT4303ShujiiIkenshoKinyuItemEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ikenshoIraiRirekiNo = entity.ikenshoIraiRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.shindamMei1 = entity.shindamMei1;
        this.hasshoYMD1 = entity.hasshoYMD1;
        this.shindamMei2 = entity.shindamMei2;
        this.hasshoYMD2 = entity.hasshoYMD2;
        this.shindamMei3 = entity.shindamMei3;
        this.hasshoYMD3 = entity.hasshoYMD3;
        this.anteisei = entity.anteisei;
        this.kinyuItem01 = entity.kinyuItem01;
        this.kinyuItem02 = entity.kinyuItem02;
        this.kinyuItem03 = entity.kinyuItem03;
        this.kinyuItem04 = entity.kinyuItem04;
        this.kinyuItem05 = entity.kinyuItem05;
        this.kinyuItem06 = entity.kinyuItem06;
        this.kinyuItem07 = entity.kinyuItem07;
        this.kinyuItem08 = entity.kinyuItem08;
        this.kinyuItem09 = entity.kinyuItem09;
        this.kinyuItem10 = entity.kinyuItem10;
        this.kinyuItem11 = entity.kinyuItem11;
        this.kinyuItem12 = entity.kinyuItem12;
        this.kinyuItem13 = entity.kinyuItem13;
        this.kinyuItem14 = entity.kinyuItem14;
        this.kinyuItem15 = entity.kinyuItem15;
        this.kinyuItem16 = entity.kinyuItem16;
        this.kinyuItem17 = entity.kinyuItem17;
        this.kinyuItem18 = entity.kinyuItem18;
        this.kinyuItem19 = entity.kinyuItem19;
        this.kinyuItem20 = entity.kinyuItem20;
        this.kinyuItem21 = entity.kinyuItem21;
        this.kinyuItem22 = entity.kinyuItem22;
        this.kinyuItem23 = entity.kinyuItem23;
        this.kinyuItem24 = entity.kinyuItem24;
        this.kinyuItem25 = entity.kinyuItem25;
        this.kinyuItem26 = entity.kinyuItem26;
        this.kinyuItem27 = entity.kinyuItem27;
        this.kinyuItem28 = entity.kinyuItem28;
        this.kinyuItem29 = entity.kinyuItem29;
        this.kinyuItem30 = entity.kinyuItem30;
        this.tokkiJiko = entity.tokkiJiko;
        this.kinyuItem01ImageSharedFileId = entity.kinyuItem01ImageSharedFileId;
        this.kinyuItem02ImageSharedFileId = entity.kinyuItem02ImageSharedFileId;
        this.kinyuItem03ImageSharedFileId = entity.kinyuItem03ImageSharedFileId;
        this.kinyuItem04ImageSharedFileId = entity.kinyuItem04ImageSharedFileId;
        this.kinyuItem05ImageSharedFileId = entity.kinyuItem05ImageSharedFileId;
        this.kinyuItem06ImageSharedFileId = entity.kinyuItem06ImageSharedFileId;
        this.kinyuItem07ImageSharedFileId = entity.kinyuItem07ImageSharedFileId;
        this.kinyuItem08ImageSharedFileId = entity.kinyuItem08ImageSharedFileId;
        this.kinyuItem09ImageSharedFileId = entity.kinyuItem09ImageSharedFileId;
        this.kinyuItem10ImageSharedFileId = entity.kinyuItem10ImageSharedFileId;
        this.kinyuItem11ImageSharedFileId = entity.kinyuItem11ImageSharedFileId;
        this.kinyuItem12ImageSharedFileId = entity.kinyuItem12ImageSharedFileId;
        this.kinyuItem13ImageSharedFileId = entity.kinyuItem13ImageSharedFileId;
        this.kinyuItem14ImageSharedFileId = entity.kinyuItem14ImageSharedFileId;
        this.kinyuItem15ImageSharedFileId = entity.kinyuItem15ImageSharedFileId;
        this.kinyuItem16ImageSharedFileId = entity.kinyuItem16ImageSharedFileId;
        this.kinyuItem17ImageSharedFileId = entity.kinyuItem17ImageSharedFileId;
        this.kinyuItem18ImageSharedFileId = entity.kinyuItem18ImageSharedFileId;
        this.kinyuItem19ImageSharedFileId = entity.kinyuItem19ImageSharedFileId;
        this.kinyuItem20ImageSharedFileId = entity.kinyuItem20ImageSharedFileId;
        this.kinyuItem21ImageSharedFileId = entity.kinyuItem21ImageSharedFileId;
        this.kinyuItem22ImageSharedFileId = entity.kinyuItem22ImageSharedFileId;
        this.kinyuItem23ImageSharedFileId = entity.kinyuItem23ImageSharedFileId;
        this.kinyuItem24ImageSharedFileId = entity.kinyuItem24ImageSharedFileId;
        this.kinyuItem25ImageSharedFileId = entity.kinyuItem25ImageSharedFileId;
        this.kinyuItem26ImageSharedFileId = entity.kinyuItem26ImageSharedFileId;
        this.kinyuItem27ImageSharedFileId = entity.kinyuItem27ImageSharedFileId;
        this.kinyuItem28ImageSharedFileId = entity.kinyuItem28ImageSharedFileId;
        this.kinyuItem29ImageSharedFileId = entity.kinyuItem29ImageSharedFileId;
        this.kinyuItem30ImageSharedFileId = entity.kinyuItem30ImageSharedFileId;
        this.tokkiJikoImageSharedFileId = entity.tokkiJikoImageSharedFileId;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ikenshoIraiRirekiNo, koroshoIfShikibetsuCode, shindamMei1, hasshoYMD1, shindamMei2, hasshoYMD2, shindamMei3, hasshoYMD3, anteisei, kinyuItem01, kinyuItem02, kinyuItem03, kinyuItem04, kinyuItem05, kinyuItem06, kinyuItem07, kinyuItem08, kinyuItem09, kinyuItem10, kinyuItem11, kinyuItem12, kinyuItem13, kinyuItem14, kinyuItem15, kinyuItem16, kinyuItem17, kinyuItem18, kinyuItem19, kinyuItem20, kinyuItem21, kinyuItem22, kinyuItem23, kinyuItem24, kinyuItem25, kinyuItem26, kinyuItem27, kinyuItem28, kinyuItem29, kinyuItem30, tokkiJiko, kinyuItem01ImageSharedFileId, kinyuItem02ImageSharedFileId, kinyuItem03ImageSharedFileId, kinyuItem04ImageSharedFileId, kinyuItem05ImageSharedFileId, kinyuItem06ImageSharedFileId, kinyuItem07ImageSharedFileId, kinyuItem08ImageSharedFileId, kinyuItem09ImageSharedFileId, kinyuItem10ImageSharedFileId, kinyuItem11ImageSharedFileId, kinyuItem12ImageSharedFileId, kinyuItem13ImageSharedFileId, kinyuItem14ImageSharedFileId, kinyuItem15ImageSharedFileId, kinyuItem16ImageSharedFileId, kinyuItem17ImageSharedFileId, kinyuItem18ImageSharedFileId, kinyuItem19ImageSharedFileId, kinyuItem20ImageSharedFileId, kinyuItem21ImageSharedFileId, kinyuItem22ImageSharedFileId, kinyuItem23ImageSharedFileId, kinyuItem24ImageSharedFileId, kinyuItem25ImageSharedFileId, kinyuItem26ImageSharedFileId, kinyuItem27ImageSharedFileId, kinyuItem28ImageSharedFileId, kinyuItem29ImageSharedFileId, kinyuItem30ImageSharedFileId, tokkiJikoImageSharedFileId);
    }

// </editor-fold>
}
