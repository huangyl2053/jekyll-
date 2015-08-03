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
 * 定型文情報テーブルのエンティティクラスです。
 */
public class DbT7103TeikeibunJohoEntity extends DbTableEntityBase<DbT7103TeikeibunJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7103TeikeibunJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString teikeiKubun;
    @PrimaryKey
    private RString shubetsu;
    @PrimaryKey
    private RString teikeibunCd;
    private RString teikeibunNaiyo;

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
     * 定型区分のgetメソッドです。
     * 
     * @return 定型区分
     */
    public RString getTeikeiKubun() {
        return teikeiKubun;
    }

    /**
     * 定型区分のsetメソッドです。
     * 
     * @param teikeiKubun 定型区分
     */
    public void setTeikeiKubun(RString teikeiKubun) {
        this.teikeiKubun = teikeiKubun;
    }

    /**
     * 種別のgetメソッドです。
     * 
     * @return 種別
     */
    public RString getShubetsu() {
        return shubetsu;
    }

    /**
     * 種別のsetメソッドです。
     * 
     * @param shubetsu 種別
     */
    public void setShubetsu(RString shubetsu) {
        this.shubetsu = shubetsu;
    }

    /**
     * 定型文コードのgetメソッドです。
     * 
     * @return 定型文コード
     */
    public RString getTeikeibunCd() {
        return teikeibunCd;
    }

    /**
     * 定型文コードのsetメソッドです。
     * 
     * @param teikeibunCd 定型文コード
     */
    public void setTeikeibunCd(RString teikeibunCd) {
        this.teikeibunCd = teikeibunCd;
    }

    /**
     * 定型文内容のgetメソッドです。
     * 
     * @return 定型文内容
     */
    public RString getTeikeibunNaiyo() {
        return teikeibunNaiyo;
    }

    /**
     * 定型文内容のsetメソッドです。
     * 
     * @param teikeibunNaiyo 定型文内容
     */
    public void setTeikeibunNaiyo(RString teikeibunNaiyo) {
        this.teikeibunNaiyo = teikeibunNaiyo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7103TeikeibunJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7103TeikeibunJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7103TeikeibunJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.teikeiKubun, other.teikeiKubun)) {
            return false;
        }
        if (!Objects.equals(this.shubetsu, other.shubetsu)) {
            return false;
        }
        if (!Objects.equals(this.teikeibunCd, other.teikeibunCd)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7103TeikeibunJohoEntity entity) {
        this.teikeiKubun = entity.teikeiKubun;
        this.shubetsu = entity.shubetsu;
        this.teikeibunCd = entity.teikeibunCd;
        this.teikeibunNaiyo = entity.teikeibunNaiyo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(teikeiKubun, shubetsu, teikeibunCd, teikeibunNaiyo);
    }

// </editor-fold>
}
