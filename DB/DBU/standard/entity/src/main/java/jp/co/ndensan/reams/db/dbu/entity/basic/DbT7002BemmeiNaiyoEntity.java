package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 弁明内容テーブルのエンティティクラスです。
 * <br/> 不服申立に対する弁明内容を登録する
 */
public class DbT7002BemmeiNaiyoEntity extends DbTableEntityBase<DbT7002BemmeiNaiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7002BemmeiNaiyo");

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
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private DbUDD002HihokenshaNo genshobunHihokenshaNo;
    @PrimaryKey
    private FlexibleDate shinsaseikyuTodokedeYMD;
    @PrimaryKey
    private FlexibleDate bemmeishoSakuseiYMD;
    private RString shinsaseikyuKankeiShobunNaiyo;
    private RString bemmeiNaiyo;
    private FlexibleDate bemmeishoSakuseiTeishutsuYMD;

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
     * 原処分被保険者番号のgetメソッドです。
     * 
     * @return 原処分被保険者番号
     */
    public DbUDD002HihokenshaNo getGenshobunHihokenshaNo() {
        return genshobunHihokenshaNo;
    }

    /**
     * 原処分被保険者番号のsetメソッドです。
     * 
     * @param genshobunHihokenshaNo 原処分被保険者番号
     */
    public void setGenshobunHihokenshaNo(DbUDD002HihokenshaNo genshobunHihokenshaNo) {
        this.genshobunHihokenshaNo = genshobunHihokenshaNo;
    }

    /**
     * 審査請求届出日のgetメソッドです。
     * 
     * @return 審査請求届出日
     */
    public FlexibleDate getShinsaseikyuTodokedeYMD() {
        return shinsaseikyuTodokedeYMD;
    }

    /**
     * 審査請求届出日のsetメソッドです。
     * 
     * @param shinsaseikyuTodokedeYMD 審査請求届出日
     */
    public void setShinsaseikyuTodokedeYMD(FlexibleDate shinsaseikyuTodokedeYMD) {
        this.shinsaseikyuTodokedeYMD = shinsaseikyuTodokedeYMD;
    }

    /**
     * 弁明書作成日のgetメソッドです。
     * 
     * @return 弁明書作成日
     */
    public FlexibleDate getBemmeishoSakuseiYMD() {
        return bemmeishoSakuseiYMD;
    }

    /**
     * 弁明書作成日のsetメソッドです。
     * 
     * @param bemmeishoSakuseiYMD 弁明書作成日
     */
    public void setBemmeishoSakuseiYMD(FlexibleDate bemmeishoSakuseiYMD) {
        this.bemmeishoSakuseiYMD = bemmeishoSakuseiYMD;
    }

    /**
     * 審査請求に係る処分内容のgetメソッドです。
     * 
     * @return 審査請求に係る処分内容
     */
    public RString getShinsaseikyuKankeiShobunNaiyo() {
        return shinsaseikyuKankeiShobunNaiyo;
    }

    /**
     * 審査請求に係る処分内容のsetメソッドです。
     * 
     * @param shinsaseikyuKankeiShobunNaiyo 審査請求に係る処分内容
     */
    public void setShinsaseikyuKankeiShobunNaiyo(RString shinsaseikyuKankeiShobunNaiyo) {
        this.shinsaseikyuKankeiShobunNaiyo = shinsaseikyuKankeiShobunNaiyo;
    }

    /**
     * 弁明内容のgetメソッドです。
     * 
     * @return 弁明内容
     */
    public RString getBemmeiNaiyo() {
        return bemmeiNaiyo;
    }

    /**
     * 弁明内容のsetメソッドです。
     * 
     * @param bemmeiNaiyo 弁明内容
     */
    public void setBemmeiNaiyo(RString bemmeiNaiyo) {
        this.bemmeiNaiyo = bemmeiNaiyo;
    }

    /**
     * 弁明書作成日提出日のgetメソッドです。
     * 
     * @return 弁明書作成日提出日
     */
    public FlexibleDate getBemmeishoSakuseiTeishutsuYMD() {
        return bemmeishoSakuseiTeishutsuYMD;
    }

    /**
     * 弁明書作成日提出日のsetメソッドです。
     * 
     * @param bemmeishoSakuseiTeishutsuYMD 弁明書作成日提出日
     */
    public void setBemmeishoSakuseiTeishutsuYMD(FlexibleDate bemmeishoSakuseiTeishutsuYMD) {
        this.bemmeishoSakuseiTeishutsuYMD = bemmeishoSakuseiTeishutsuYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7002BemmeiNaiyoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7002BemmeiNaiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7002BemmeiNaiyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.genshobunHihokenshaNo, other.genshobunHihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinsaseikyuTodokedeYMD, other.shinsaseikyuTodokedeYMD)) {
            return false;
        }
        if (!Objects.equals(this.bemmeishoSakuseiYMD, other.bemmeishoSakuseiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7002BemmeiNaiyoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.genshobunHihokenshaNo = entity.genshobunHihokenshaNo;
        this.shinsaseikyuTodokedeYMD = entity.shinsaseikyuTodokedeYMD;
        this.bemmeishoSakuseiYMD = entity.bemmeishoSakuseiYMD;
        this.shinsaseikyuKankeiShobunNaiyo = entity.shinsaseikyuKankeiShobunNaiyo;
        this.bemmeiNaiyo = entity.bemmeiNaiyo;
        this.bemmeishoSakuseiTeishutsuYMD = entity.bemmeishoSakuseiTeishutsuYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, shikibetsuCode, genshobunHihokenshaNo, shinsaseikyuTodokedeYMD, bemmeishoSakuseiYMD, shinsaseikyuKankeiShobunNaiyo, bemmeiNaiyo, bemmeishoSakuseiTeishutsuYMD);
    }

// </editor-fold>
}
