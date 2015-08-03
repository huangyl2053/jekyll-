package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;

/**
 * 関連被保険者番号テーブルのエンティティクラスです。
 * <br/> 被保険者番号違いの同一人物を管理する
 */
public class DbT7054KanrenHihokenshaNoEntity extends DbTableEntityBase<DbT7054KanrenHihokenshaNoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7054KanrenHihokenshaNo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD015ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private DbUDD002HihokenshaNo saishinHihokenshaNo;
    private DbUDD002HihokenshaNo kyuuHihokenshaNo;
    private ShikibetsuCode shikibetsuCode;

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
     * 証記載保険者番号のgetメソッドです。
     * 
     * @return 証記載保険者番号
     */
    public DbUDD015ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(DbUDD015ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 最新被保険者番号のgetメソッドです。
     * 
     * @return 最新被保険者番号
     */
    public DbUDD002HihokenshaNo getSaishinHihokenshaNo() {
        return saishinHihokenshaNo;
    }

    /**
     * 最新被保険者番号のsetメソッドです。
     * 
     * @param saishinHihokenshaNo 最新被保険者番号
     */
    public void setSaishinHihokenshaNo(DbUDD002HihokenshaNo saishinHihokenshaNo) {
        this.saishinHihokenshaNo = saishinHihokenshaNo;
    }

    /**
     * 旧被保険者番号のgetメソッドです。
     * 
     * @return 旧被保険者番号
     */
    public DbUDD002HihokenshaNo getKyuuHihokenshaNo() {
        return kyuuHihokenshaNo;
    }

    /**
     * 旧被保険者番号のsetメソッドです。
     * 
     * @param kyuuHihokenshaNo 旧被保険者番号
     */
    public void setKyuuHihokenshaNo(DbUDD002HihokenshaNo kyuuHihokenshaNo) {
        this.kyuuHihokenshaNo = kyuuHihokenshaNo;
    }

    /**
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7054KanrenHihokenshaNoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7054KanrenHihokenshaNoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7054KanrenHihokenshaNoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.saishinHihokenshaNo, other.saishinHihokenshaNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7054KanrenHihokenshaNoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.saishinHihokenshaNo = entity.saishinHihokenshaNo;
        this.kyuuHihokenshaNo = entity.kyuuHihokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, saishinHihokenshaNo, kyuuHihokenshaNo, shikibetsuCode);
    }

// </editor-fold>
}
