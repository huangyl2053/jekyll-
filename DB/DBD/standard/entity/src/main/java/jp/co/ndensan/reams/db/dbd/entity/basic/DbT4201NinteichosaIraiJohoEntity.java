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
 * 認定調査依頼情報テーブルのエンティティクラスです。
 */
public class DbT4201NinteichosaIraiJohoEntity extends DbTableEntityBase<DbT4201NinteichosaIraiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4201NinteichosaIraiJoho");

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
    private int ninteichosaIraiRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private DbUDD004JigyoshaNo ninteichosaItakusakiCode;
    private RString ninteiChousainCode;
    private Code ninteichousaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaIraiYMD;
    private FlexibleDate ninteichosaKigenYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate chosahyoTouShutsuryokuYMD;
    private boolean mobileDataShutsuryokuZumiFlag;
    private boolean jizenChosaFlag;
    private FlexibleDate ninteichosaTokusokuYMD;
    private RString ninteichosaTokusokuHoho;
    private int ninteichosaTokusokuKaisu;
    private RString ninteichosaTokusokuMemo;
    private boolean logicalDeletedFlag;

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
     * 認定調査依頼履歴番号のgetメソッドです。
     * 
     * @return 認定調査依頼履歴番号
     */
    public int getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    /**
     * 認定調査依頼履歴番号のsetメソッドです。
     * 
     * @param ninteichosaIraiRirekiNo 認定調査依頼履歴番号
     */
    public void setNinteichosaIraiRirekiNo(int ninteichosaIraiRirekiNo) {
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーテショニングのCheck項目
     * 
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーテショニングのCheck項目
     * 
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     * 
     * @return 認定調査委託先コード
     */
    public DbUDD004JigyoshaNo getNinteichosaItakusakiCode() {
        return ninteichosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     * 
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     */
    public void setNinteichosaItakusakiCode(DbUDD004JigyoshaNo ninteichosaItakusakiCode) {
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     * <br/>
     * <br/>認定調査員情報
     * 
     * @return 認定調査員コード
     */
    public RString getNinteiChousainCode() {
        return ninteiChousainCode;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     * <br/>
     * <br/>認定調査員情報
     * 
     * @param ninteiChousainCode 認定調査員コード
     */
    public void setNinteiChousainCode(RString ninteiChousainCode) {
        this.ninteiChousainCode = ninteiChousainCode;
    }

    /**
     * 認定調査依頼区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定調査依頼区分コード）初回・再依頼・再調査
     * 
     * @return 認定調査依頼区分コード
     */
    public Code getNinteichousaIraiKubunCode() {
        return ninteichousaIraiKubunCode;
    }

    /**
     * 認定調査依頼区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定調査依頼区分コード）初回・再依頼・再調査
     * 
     * @param ninteichousaIraiKubunCode 認定調査依頼区分コード
     */
    public void setNinteichousaIraiKubunCode(Code ninteichousaIraiKubunCode) {
        this.ninteichousaIraiKubunCode = ninteichousaIraiKubunCode;
    }

    /**
     * 認定調査回数のgetメソッドです。
     * 
     * @return 認定調査回数
     */
    public int getNinteichosaIraiKaisu() {
        return ninteichosaIraiKaisu;
    }

    /**
     * 認定調査回数のsetメソッドです。
     * 
     * @param ninteichosaIraiKaisu 認定調査回数
     */
    public void setNinteichosaIraiKaisu(int ninteichosaIraiKaisu) {
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
    }

    /**
     * 認定調査依頼年月日のgetメソッドです。
     * 
     * @return 認定調査依頼年月日
     */
    public FlexibleDate getNinteichosaIraiYMD() {
        return ninteichosaIraiYMD;
    }

    /**
     * 認定調査依頼年月日のsetメソッドです。
     * 
     * @param ninteichosaIraiYMD 認定調査依頼年月日
     */
    public void setNinteichosaIraiYMD(FlexibleDate ninteichosaIraiYMD) {
        this.ninteichosaIraiYMD = ninteichosaIraiYMD;
    }

    /**
     * 認定調査期限年月日のgetメソッドです。
     * 
     * @return 認定調査期限年月日
     */
    public FlexibleDate getNinteichosaKigenYMD() {
        return ninteichosaKigenYMD;
    }

    /**
     * 認定調査期限年月日のsetメソッドです。
     * 
     * @param ninteichosaKigenYMD 認定調査期限年月日
     */
    public void setNinteichosaKigenYMD(FlexibleDate ninteichosaKigenYMD) {
        this.ninteichosaKigenYMD = ninteichosaKigenYMD;
    }

    /**
     * 依頼書出力年月日のgetメソッドです。
     * 
     * @return 依頼書出力年月日
     */
    public FlexibleDate getIraishoShutsuryokuYMD() {
        return iraishoShutsuryokuYMD;
    }

    /**
     * 依頼書出力年月日のsetメソッドです。
     * 
     * @param iraishoShutsuryokuYMD 依頼書出力年月日
     */
    public void setIraishoShutsuryokuYMD(FlexibleDate iraishoShutsuryokuYMD) {
        this.iraishoShutsuryokuYMD = iraishoShutsuryokuYMD;
    }

    /**
     * 調査票等出力年月日のgetメソッドです。
     * 
     * @return 調査票等出力年月日
     */
    public FlexibleDate getChosahyoTouShutsuryokuYMD() {
        return chosahyoTouShutsuryokuYMD;
    }

    /**
     * 調査票等出力年月日のsetメソッドです。
     * 
     * @param chosahyoTouShutsuryokuYMD 調査票等出力年月日
     */
    public void setChosahyoTouShutsuryokuYMD(FlexibleDate chosahyoTouShutsuryokuYMD) {
        this.chosahyoTouShutsuryokuYMD = chosahyoTouShutsuryokuYMD;
    }

    /**
     * モバイルデータ出力済フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：モバイルデータ出力フラグ）
     * 
     * @return モバイルデータ出力済フラグ
     */
    public boolean getMobileDataShutsuryokuZumiFlag() {
        return mobileDataShutsuryokuZumiFlag;
    }

    /**
     * モバイルデータ出力済フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：モバイルデータ出力フラグ）
     * 
     * @param mobileDataShutsuryokuZumiFlag モバイルデータ出力済フラグ
     */
    public void setMobileDataShutsuryokuZumiFlag(boolean mobileDataShutsuryokuZumiFlag) {
        this.mobileDataShutsuryokuZumiFlag = mobileDataShutsuryokuZumiFlag;
    }

    /**
     * 事前調査フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：事前調査フラグ）
     * 
     * @return 事前調査フラグ
     */
    public boolean getJizenChosaFlag() {
        return jizenChosaFlag;
    }

    /**
     * 事前調査フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：事前調査フラグ）
     * 
     * @param jizenChosaFlag 事前調査フラグ
     */
    public void setJizenChosaFlag(boolean jizenChosaFlag) {
        this.jizenChosaFlag = jizenChosaFlag;
    }

    /**
     * 認定調査督促年月日のgetメソッドです。
     * 
     * @return 認定調査督促年月日
     */
    public FlexibleDate getNinteichosaTokusokuYMD() {
        return ninteichosaTokusokuYMD;
    }

    /**
     * 認定調査督促年月日のsetメソッドです。
     * 
     * @param ninteichosaTokusokuYMD 認定調査督促年月日
     */
    public void setNinteichosaTokusokuYMD(FlexibleDate ninteichosaTokusokuYMD) {
        this.ninteichosaTokusokuYMD = ninteichosaTokusokuYMD;
    }

    /**
     * 認定調査督促方法のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定調査督促方法）
     * 
     * @return 認定調査督促方法
     */
    public RString getNinteichosaTokusokuHoho() {
        return ninteichosaTokusokuHoho;
    }

    /**
     * 認定調査督促方法のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定調査督促方法）
     * 
     * @param ninteichosaTokusokuHoho 認定調査督促方法
     */
    public void setNinteichosaTokusokuHoho(RString ninteichosaTokusokuHoho) {
        this.ninteichosaTokusokuHoho = ninteichosaTokusokuHoho;
    }

    /**
     * 認定調査督促回数のgetメソッドです。
     * 
     * @return 認定調査督促回数
     */
    public int getNinteichosaTokusokuKaisu() {
        return ninteichosaTokusokuKaisu;
    }

    /**
     * 認定調査督促回数のsetメソッドです。
     * 
     * @param ninteichosaTokusokuKaisu 認定調査督促回数
     */
    public void setNinteichosaTokusokuKaisu(int ninteichosaTokusokuKaisu) {
        this.ninteichosaTokusokuKaisu = ninteichosaTokusokuKaisu;
    }

    /**
     * 認定調査督促メモのgetメソッドです。
     * 
     * @return 認定調査督促メモ
     */
    public RString getNinteichosaTokusokuMemo() {
        return ninteichosaTokusokuMemo;
    }

    /**
     * 認定調査督促メモのsetメソッドです。
     * 
     * @param ninteichosaTokusokuMemo 認定調査督促メモ
     */
    public void setNinteichosaTokusokuMemo(RString ninteichosaTokusokuMemo) {
        this.ninteichosaTokusokuMemo = ninteichosaTokusokuMemo;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     * <br/>
     * <br/>True：削除　False：通常
     * 
     * @return 論理削除フラグ
     */
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     * <br/>
     * <br/>True：削除　False：通常
     * 
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4201NinteichosaIraiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4201NinteichosaIraiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4201NinteichosaIraiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaIraiRirekiNo != other.ninteichosaIraiRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4201NinteichosaIraiJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaIraiRirekiNo = entity.ninteichosaIraiRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.ninteichosaItakusakiCode = entity.ninteichosaItakusakiCode;
        this.ninteiChousainCode = entity.ninteiChousainCode;
        this.ninteichousaIraiKubunCode = entity.ninteichousaIraiKubunCode;
        this.ninteichosaIraiKaisu = entity.ninteichosaIraiKaisu;
        this.ninteichosaIraiYMD = entity.ninteichosaIraiYMD;
        this.ninteichosaKigenYMD = entity.ninteichosaKigenYMD;
        this.iraishoShutsuryokuYMD = entity.iraishoShutsuryokuYMD;
        this.chosahyoTouShutsuryokuYMD = entity.chosahyoTouShutsuryokuYMD;
        this.mobileDataShutsuryokuZumiFlag = entity.mobileDataShutsuryokuZumiFlag;
        this.jizenChosaFlag = entity.jizenChosaFlag;
        this.ninteichosaTokusokuYMD = entity.ninteichosaTokusokuYMD;
        this.ninteichosaTokusokuHoho = entity.ninteichosaTokusokuHoho;
        this.ninteichosaTokusokuKaisu = entity.ninteichosaTokusokuKaisu;
        this.ninteichosaTokusokuMemo = entity.ninteichosaTokusokuMemo;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaIraiRirekiNo, koroshoIfShikibetsuCode, ninteichosaItakusakiCode, ninteiChousainCode, ninteichousaIraiKubunCode, ninteichosaIraiKaisu, ninteichosaIraiYMD, ninteichosaKigenYMD, iraishoShutsuryokuYMD, chosahyoTouShutsuryokuYMD, mobileDataShutsuryokuZumiFlag, jizenChosaFlag, ninteichosaTokusokuYMD, ninteichosaTokusokuHoho, ninteichosaTokusokuKaisu, ninteichosaTokusokuMemo, logicalDeletedFlag);
    }

// </editor-fold>
}
