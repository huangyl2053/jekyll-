package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 地区認定調査員テーブルのエンティティクラスです。
 */
public class DbT5223ChikuNinteiChosainEntity extends DbTableEntityBase<DbT5223ChikuNinteiChosainEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5223ChikuNinteiChosain");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private Code chosaChikuCode;
    @PrimaryKey
    private RString ninteiChosaItakusakiCode;
    @PrimaryKey
    private RString ninteiChosainCode;
    @PrimaryKey
    private LasdecCode shichosonCode;
    private int yusenNo;
    private RString biko;

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
     * 調査地区コードのgetメソッドです。
     * <br/>
     * <br/>Code（DBE：5002）
     * 
     * @return 調査地区コード
     */
    public Code getChosaChikuCode() {
        return chosaChikuCode;
    }

    /**
     * 調査地区コードのsetメソッドです。
     * <br/>
     * <br/>Code（DBE：5002）
     * 
     * @param chosaChikuCode 調査地区コード
     */
    public void setChosaChikuCode(@Nonnull Code chosaChikuCode) {
        this.chosaChikuCode = chosaChikuCode;
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     * 
     * @return 認定調査委託先コード
     */
    public RString getNinteiChosaItakusakiCode() {
        return ninteiChosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     * 
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     */
    public void setNinteiChosaItakusakiCode(@Nonnull RString ninteiChosaItakusakiCode) {
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     * <br/>
     * <br/>認定調査員コード
     * 
     * @return 認定調査員コード
     */
    public RString getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     * <br/>
     * <br/>認定調査員コード
     * 
     * @param ninteiChosainCode 認定調査員コード
     */
    public void setNinteiChosainCode(@Nonnull RString ninteiChosainCode) {
        this.ninteiChosainCode = ninteiChosainCode;
    }

    /**
     * 市町村コードのgetメソッドです。
     * 
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     * 
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(@Nonnull LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 優先番号のgetメソッドです。
     * 
     * @return 優先番号
     */
    public int getYusenNo() {
        return yusenNo;
    }

    /**
     * 優先番号のsetメソッドです。
     * 
     * @param yusenNo 優先番号
     */
    public void setYusenNo(@Nonnull int yusenNo) {
        this.yusenNo = yusenNo;
    }

    /**
     * 備考のgetメソッドです。
     * 
     * @return 備考
     */
    @CheckForNull
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     * 
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5223ChikuNinteiChosainEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5223ChikuNinteiChosainEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5223ChikuNinteiChosainEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.chosaChikuCode, other.chosaChikuCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosaItakusakiCode, other.ninteiChosaItakusakiCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosainCode, other.ninteiChosainCode)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5223ChikuNinteiChosainEntity entity) {
        this.chosaChikuCode = entity.chosaChikuCode;
        this.ninteiChosaItakusakiCode = entity.ninteiChosaItakusakiCode;
        this.ninteiChosainCode = entity.ninteiChosainCode;
        this.shichosonCode = entity.shichosonCode;
        this.yusenNo = entity.yusenNo;
        this.biko = entity.biko;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(chosaChikuCode, ninteiChosaItakusakiCode, ninteiChosainCode, shichosonCode, yusenNo, biko);
    }

// </editor-fold>
}
