package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3098TandokuJoseikinKyufuShinseiの項目定義クラスです
 *
 */
public class DbT3098TandokuJoseikinKyufuShinseiEntity extends DbTableEntityBase<DbT3098TandokuJoseikinKyufuShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate shinseiYMD;
    private RString shinseishaKubun;
    private JigyoshaNo daikoJigyoshaNo;
    private RString jigyoshaKubun;
    private YubinNo shinseishaYubinNo;
    private RString shinseishaJusho;
    private TelNo shinseishaTelNo;
    private RString shinseiRiyu;
    private RString tandokuJoseiShuruiCode;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getUketsukeYMD
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * setUketsukeYMD
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getShinseiYMD
     *
     * @return shinseiYMD
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * setShinseiYMD
     *
     * @param shinseiYMD shinseiYMD
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * getShinseishaKubun
     *
     * @return shinseishaKubun
     */
    public RString getShinseishaKubun() {
        return shinseishaKubun;
    }

    /**
     * setShinseishaKubun
     *
     * @param shinseishaKubun shinseishaKubun
     */
    public void setShinseishaKubun(RString shinseishaKubun) {
        this.shinseishaKubun = shinseishaKubun;
    }

    /**
     * getDaikoJigyoshaNo
     *
     * @return daikoJigyoshaNo
     */
    public JigyoshaNo getDaikoJigyoshaNo() {
        return daikoJigyoshaNo;
    }

    /**
     * setDaikoJigyoshaNo
     *
     * @param daikoJigyoshaNo daikoJigyoshaNo
     */
    public void setDaikoJigyoshaNo(JigyoshaNo daikoJigyoshaNo) {
        this.daikoJigyoshaNo = daikoJigyoshaNo;
    }

    /**
     * getJigyoshaKubun
     *
     * @return jigyoshaKubun
     */
    public RString getJigyoshaKubun() {
        return jigyoshaKubun;
    }

    /**
     * setJigyoshaKubun
     *
     * @param jigyoshaKubun jigyoshaKubun
     */
    public void setJigyoshaKubun(RString jigyoshaKubun) {
        this.jigyoshaKubun = jigyoshaKubun;
    }

    /**
     * getShinseishaYubinNo
     *
     * @return shinseishaYubinNo
     */
    public YubinNo getShinseishaYubinNo() {
        return shinseishaYubinNo;
    }

    /**
     * setShinseishaYubinNo
     *
     * @param shinseishaYubinNo shinseishaYubinNo
     */
    public void setShinseishaYubinNo(YubinNo shinseishaYubinNo) {
        this.shinseishaYubinNo = shinseishaYubinNo;
    }

    /**
     * getShinseishaJusho
     *
     * @return shinseishaJusho
     */
    public RString getShinseishaJusho() {
        return shinseishaJusho;
    }

    /**
     * setShinseishaJusho
     *
     * @param shinseishaJusho shinseishaJusho
     */
    public void setShinseishaJusho(RString shinseishaJusho) {
        this.shinseishaJusho = shinseishaJusho;
    }

    /**
     * getShinseishaTelNo
     *
     * @return shinseishaTelNo
     */
    public TelNo getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * setShinseishaTelNo
     *
     * @param shinseishaTelNo shinseishaTelNo
     */
    public void setShinseishaTelNo(TelNo shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * getShinseiRiyu
     *
     * @return shinseiRiyu
     */
    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    /**
     * setShinseiRiyu
     *
     * @param shinseiRiyu shinseiRiyu
     */
    public void setShinseiRiyu(RString shinseiRiyu) {
        this.shinseiRiyu = shinseiRiyu;
    }

    /**
     * getTandokuJoseiShuruiCode
     *
     * @return tandokuJoseiShuruiCode
     */
    public RString getTandokuJoseiShuruiCode() {
        return tandokuJoseiShuruiCode;
    }

    /**
     * setTandokuJoseiShuruiCode
     *
     * @param tandokuJoseiShuruiCode tandokuJoseiShuruiCode
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
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
        this.shoriTimestamp = entity.shoriTimestamp;
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
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, uketsukeYMD, shoriTimestamp, shinseiYMD, shinseishaKubun, daikoJigyoshaNo, jigyoshaKubun, shinseishaYubinNo, shinseishaJusho, shinseishaTelNo, shinseiRiyu, tandokuJoseiShuruiCode);
    }

// </editor-fold>
}
