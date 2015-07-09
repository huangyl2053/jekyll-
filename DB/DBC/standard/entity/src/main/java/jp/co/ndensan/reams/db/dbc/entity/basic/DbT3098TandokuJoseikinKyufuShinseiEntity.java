package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * 市町村単独助成金給付申請テーブルのエンティティクラスです。
 */
public class DbT3098TandokuJoseikinKyufuShinseiEntity extends DbTableEntityBase<DbT3098TandokuJoseikinKyufuShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3098TandokuJoseikinKyufuShinsei");

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
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate shinseiYMD;
    private RString shinseishaKubun;
    private DbUDD004JigyoshaNo daikoJigyoshaNo;
    private RString jigyoshaKubun;
    private YubinNo shinseishaYubinNo;
    private RString shinseishaJusho;
    private TelNo shinseishaTelNo;
    private RString shinseiRiyu;
    private RString tandokuJoseiShuruiCode;

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
     * 受付年月日のgetメソッドです。
     * 
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     * 
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 申請年月日のgetメソッドです。
     * 
     * @return 申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     * 
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 申請者区分のgetメソッドです。
     * 
     * @return 申請者区分
     */
    public RString getShinseishaKubun() {
        return shinseishaKubun;
    }

    /**
     * 申請者区分のsetメソッドです。
     * 
     * @param shinseishaKubun 申請者区分
     */
    public void setShinseishaKubun(RString shinseishaKubun) {
        this.shinseishaKubun = shinseishaKubun;
    }

    /**
     * 申請代行事業者番号のgetメソッドです。
     * 
     * @return 申請代行事業者番号
     */
    public DbUDD004JigyoshaNo getDaikoJigyoshaNo() {
        return daikoJigyoshaNo;
    }

    /**
     * 申請代行事業者番号のsetメソッドです。
     * 
     * @param daikoJigyoshaNo 申請代行事業者番号
     */
    public void setDaikoJigyoshaNo(DbUDD004JigyoshaNo daikoJigyoshaNo) {
        this.daikoJigyoshaNo = daikoJigyoshaNo;
    }

    /**
     * 事業者区分のgetメソッドです。
     * 
     * @return 事業者区分
     */
    public RString getJigyoshaKubun() {
        return jigyoshaKubun;
    }

    /**
     * 事業者区分のsetメソッドです。
     * 
     * @param jigyoshaKubun 事業者区分
     */
    public void setJigyoshaKubun(RString jigyoshaKubun) {
        this.jigyoshaKubun = jigyoshaKubun;
    }

    /**
     * 申請者郵便番号のgetメソッドです。
     * 
     * @return 申請者郵便番号
     */
    public YubinNo getShinseishaYubinNo() {
        return shinseishaYubinNo;
    }

    /**
     * 申請者郵便番号のsetメソッドです。
     * 
     * @param shinseishaYubinNo 申請者郵便番号
     */
    public void setShinseishaYubinNo(YubinNo shinseishaYubinNo) {
        this.shinseishaYubinNo = shinseishaYubinNo;
    }

    /**
     * 申請者住所のgetメソッドです。
     * 
     * @return 申請者住所
     */
    public RString getShinseishaJusho() {
        return shinseishaJusho;
    }

    /**
     * 申請者住所のsetメソッドです。
     * 
     * @param shinseishaJusho 申請者住所
     */
    public void setShinseishaJusho(RString shinseishaJusho) {
        this.shinseishaJusho = shinseishaJusho;
    }

    /**
     * 申請者電話番号のgetメソッドです。
     * 
     * @return 申請者電話番号
     */
    public TelNo getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * 申請者電話番号のsetメソッドです。
     * 
     * @param shinseishaTelNo 申請者電話番号
     */
    public void setShinseishaTelNo(TelNo shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * 申請理由のgetメソッドです。
     * 
     * @return 申請理由
     */
    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    /**
     * 申請理由のsetメソッドです。
     * 
     * @param shinseiRiyu 申請理由
     */
    public void setShinseiRiyu(RString shinseiRiyu) {
        this.shinseiRiyu = shinseiRiyu;
    }

    /**
     * 市町村単独助成種類のgetメソッドです。
     * 
     * @return 市町村単独助成種類
     */
    public RString getTandokuJoseiShuruiCode() {
        return tandokuJoseiShuruiCode;
    }

    /**
     * 市町村単独助成種類のsetメソッドです。
     * 
     * @param tandokuJoseiShuruiCode 市町村単独助成種類
     */
    public void setTandokuJoseiShuruiCode(RString tandokuJoseiShuruiCode) {
        this.tandokuJoseiShuruiCode = tandokuJoseiShuruiCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3098TandokuJoseikinKyufuShinseiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3098TandokuJoseikinKyufuShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3098TandokuJoseikinKyufuShinseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.uketsukeYMD, other.uketsukeYMD)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3098TandokuJoseikinKyufuShinseiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiYMD = entity.shinseiYMD;
        this.shinseishaKubun = entity.shinseishaKubun;
        this.daikoJigyoshaNo = entity.daikoJigyoshaNo;
        this.jigyoshaKubun = entity.jigyoshaKubun;
        this.shinseishaYubinNo = entity.shinseishaYubinNo;
        this.shinseishaJusho = entity.shinseishaJusho;
        this.shinseishaTelNo = entity.shinseishaTelNo;
        this.shinseiRiyu = entity.shinseiRiyu;
        this.tandokuJoseiShuruiCode = entity.tandokuJoseiShuruiCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, uketsukeYMD, rirekiNo, shinseiYMD, shinseishaKubun, daikoJigyoshaNo, jigyoshaKubun, shinseishaYubinNo, shinseishaJusho, shinseishaTelNo, shinseiRiyu, tandokuJoseiShuruiCode);
    }

// </editor-fold>
}
