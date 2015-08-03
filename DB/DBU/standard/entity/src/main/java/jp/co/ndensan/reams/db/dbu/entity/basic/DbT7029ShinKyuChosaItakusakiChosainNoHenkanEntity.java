package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import java.util.Objects;

/**
 * 新旧調査委託先調査員番号変換テーブルテーブルのエンティティクラスです。
 */
public class DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity extends DbTableEntityBase<DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7029ShinKyuChosaItakusakiChosainNoHenkan");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    private RString shinChosaItakusakiNo;
    private RString shinChosainNo;
    @PrimaryKey
    private RString kyuChosaItakusakiNo;
    @PrimaryKey
    private RString kyuChosainNo;
    private LasdecCode shichosonCode2;
    private RString kyuChosaItakusakiNo2;
    private RString kyuChosainNo2;

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
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 新調査委託先番号のgetメソッドです。
     * 
     * @return 新調査委託先番号
     */
    public RString getShinChosaItakusakiNo() {
        return shinChosaItakusakiNo;
    }

    /**
     * 新調査委託先番号のsetメソッドです。
     * 
     * @param shinChosaItakusakiNo 新調査委託先番号
     */
    public void setShinChosaItakusakiNo(RString shinChosaItakusakiNo) {
        this.shinChosaItakusakiNo = shinChosaItakusakiNo;
    }

    /**
     * 新調査員番号のgetメソッドです。
     * 
     * @return 新調査員番号
     */
    public RString getShinChosainNo() {
        return shinChosainNo;
    }

    /**
     * 新調査員番号のsetメソッドです。
     * 
     * @param shinChosainNo 新調査員番号
     */
    public void setShinChosainNo(RString shinChosainNo) {
        this.shinChosainNo = shinChosainNo;
    }

    /**
     * 旧調査委託先番号のgetメソッドです。
     * 
     * @return 旧調査委託先番号
     */
    public RString getKyuChosaItakusakiNo() {
        return kyuChosaItakusakiNo;
    }

    /**
     * 旧調査委託先番号のsetメソッドです。
     * 
     * @param kyuChosaItakusakiNo 旧調査委託先番号
     */
    public void setKyuChosaItakusakiNo(RString kyuChosaItakusakiNo) {
        this.kyuChosaItakusakiNo = kyuChosaItakusakiNo;
    }

    /**
     * 旧調査員番号のgetメソッドです。
     * 
     * @return 旧調査員番号
     */
    public RString getKyuChosainNo() {
        return kyuChosainNo;
    }

    /**
     * 旧調査員番号のsetメソッドです。
     * 
     * @param kyuChosainNo 旧調査員番号
     */
    public void setKyuChosainNo(RString kyuChosainNo) {
        this.kyuChosainNo = kyuChosainNo;
    }

    /**
     * 市町村コード２のgetメソッドです。
     * 
     * @return 市町村コード２
     */
    public LasdecCode getShichosonCode2() {
        return shichosonCode2;
    }

    /**
     * 市町村コード２のsetメソッドです。
     * 
     * @param shichosonCode2 市町村コード２
     */
    public void setShichosonCode2(LasdecCode shichosonCode2) {
        this.shichosonCode2 = shichosonCode2;
    }

    /**
     * 旧調査委託先番号２のgetメソッドです。
     * 
     * @return 旧調査委託先番号２
     */
    public RString getKyuChosaItakusakiNo2() {
        return kyuChosaItakusakiNo2;
    }

    /**
     * 旧調査委託先番号２のsetメソッドです。
     * 
     * @param kyuChosaItakusakiNo2 旧調査委託先番号２
     */
    public void setKyuChosaItakusakiNo2(RString kyuChosaItakusakiNo2) {
        this.kyuChosaItakusakiNo2 = kyuChosaItakusakiNo2;
    }

    /**
     * 旧調査員番号２のgetメソッドです。
     * 
     * @return 旧調査員番号２
     */
    public RString getKyuChosainNo2() {
        return kyuChosainNo2;
    }

    /**
     * 旧調査員番号２のsetメソッドです。
     * 
     * @param kyuChosainNo2 旧調査員番号２
     */
    public void setKyuChosainNo2(RString kyuChosainNo2) {
        this.kyuChosainNo2 = kyuChosainNo2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kyuChosaItakusakiNo, other.kyuChosaItakusakiNo)) {
            return false;
        }
        if (!Objects.equals(this.kyuChosainNo, other.kyuChosainNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shinChosaItakusakiNo = entity.shinChosaItakusakiNo;
        this.shinChosainNo = entity.shinChosainNo;
        this.kyuChosaItakusakiNo = entity.kyuChosaItakusakiNo;
        this.kyuChosainNo = entity.kyuChosainNo;
        this.shichosonCode2 = entity.shichosonCode2;
        this.kyuChosaItakusakiNo2 = entity.kyuChosaItakusakiNo2;
        this.kyuChosainNo2 = entity.kyuChosainNo2;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shinChosaItakusakiNo, shinChosainNo, kyuChosaItakusakiNo, kyuChosainNo, shichosonCode2, kyuChosaItakusakiNo2, kyuChosainNo2);
    }

// </editor-fold>
}
