package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;

/**
 * 各種新旧番号変換テーブルテーブルのエンティティクラスです。
 */
public class DbT7028KakushuShinKyuNoHenkanEntity extends DbTableEntityBase<DbT7028KakushuShinKyuNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7028KakushuShinKyuNoHenkan");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD002HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString noKubun;
    private RString shinNo;
    @PrimaryKey
    private RString kyuNo;

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
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public DbUDD002HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(DbUDD002HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 番号区分のgetメソッドです。
     * <br/>
     * <br/>1：特別対策公費受給者番号（７桁）
     * 
     * @return 番号区分
     */
    public RString getNoKubun() {
        return noKubun;
    }

    /**
     * 番号区分のsetメソッドです。
     * <br/>
     * <br/>1：特別対策公費受給者番号（７桁）
     * 
     * @param noKubun 番号区分
     */
    public void setNoKubun(RString noKubun) {
        this.noKubun = noKubun;
    }

    /**
     * 新番号のgetメソッドです。
     * 
     * @return 新番号
     */
    public RString getShinNo() {
        return shinNo;
    }

    /**
     * 新番号のsetメソッドです。
     * 
     * @param shinNo 新番号
     */
    public void setShinNo(RString shinNo) {
        this.shinNo = shinNo;
    }

    /**
     * 旧番号のgetメソッドです。
     * 
     * @return 旧番号
     */
    public RString getKyuNo() {
        return kyuNo;
    }

    /**
     * 旧番号のsetメソッドです。
     * 
     * @param kyuNo 旧番号
     */
    public void setKyuNo(RString kyuNo) {
        this.kyuNo = kyuNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7028KakushuShinKyuNoHenkanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7028KakushuShinKyuNoHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7028KakushuShinKyuNoHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.noKubun, other.noKubun)) {
            return false;
        }
        if (!Objects.equals(this.kyuNo, other.kyuNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7028KakushuShinKyuNoHenkanEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.noKubun = entity.noKubun;
        this.shinNo = entity.shinNo;
        this.kyuNo = entity.kyuNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, noKubun, shinNo, kyuNo);
    }

// </editor-fold>
}
