package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7003BemmeishaJohoの項目定義クラスです
 *
 */
public class DbT7003BemmeishaJohoEntity extends DbTableEntityBase<DbT7003BemmeishaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7003BemmeishaJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private HihokenshaNo genshobunHihokenshaNo;
    @PrimaryKey
    private FlexibleDate shinsaseikyuTodokedeYMD;
    @PrimaryKey
    private FlexibleDate bemmeishoSakuseiYMD;
    @PrimaryKey
    private int bemmeishaEdaban;
    private Code shokuinCode;
    private BushoCode bushoCode;
    private RString yakushoskuName;
    private AtenaMeisho bemmeishaShimei;

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
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getGenshobunHihokenshaNo
     *
     * @return genshobunHihokenshaNo
     */
    public HihokenshaNo getGenshobunHihokenshaNo() {
        return genshobunHihokenshaNo;
    }

    /**
     * setGenshobunHihokenshaNo
     *
     * @param genshobunHihokenshaNo genshobunHihokenshaNo
     */
    public void setGenshobunHihokenshaNo(HihokenshaNo genshobunHihokenshaNo) {
        this.genshobunHihokenshaNo = genshobunHihokenshaNo;
    }

    /**
     * getShinsaseikyuTodokedeYMD
     *
     * @return shinsaseikyuTodokedeYMD
     */
    public FlexibleDate getShinsaseikyuTodokedeYMD() {
        return shinsaseikyuTodokedeYMD;
    }

    /**
     * setShinsaseikyuTodokedeYMD
     *
     * @param shinsaseikyuTodokedeYMD shinsaseikyuTodokedeYMD
     */
    public void setShinsaseikyuTodokedeYMD(FlexibleDate shinsaseikyuTodokedeYMD) {
        this.shinsaseikyuTodokedeYMD = shinsaseikyuTodokedeYMD;
    }

    /**
     * getBemmeishoSakuseiYMD
     *
     * @return bemmeishoSakuseiYMD
     */
    public FlexibleDate getBemmeishoSakuseiYMD() {
        return bemmeishoSakuseiYMD;
    }

    /**
     * setBemmeishoSakuseiYMD
     *
     * @param bemmeishoSakuseiYMD bemmeishoSakuseiYMD
     */
    public void setBemmeishoSakuseiYMD(FlexibleDate bemmeishoSakuseiYMD) {
        this.bemmeishoSakuseiYMD = bemmeishoSakuseiYMD;
    }

    /**
     * getBemmeishaEdaban
     *
     * @return bemmeishaEdaban
     */
    public int getBemmeishaEdaban() {
        return bemmeishaEdaban;
    }

    /**
     * setBemmeishaEdaban
     *
     * @param bemmeishaEdaban bemmeishaEdaban
     */
    public void setBemmeishaEdaban(int bemmeishaEdaban) {
        this.bemmeishaEdaban = bemmeishaEdaban;
    }

    /**
     * getShokuinCode
     *
     * @return shokuinCode
     */
    public Code getShokuinCode() {
        return shokuinCode;
    }

    /**
     * setShokuinCode
     *
     * @param shokuinCode shokuinCode
     */
    public void setShokuinCode(Code shokuinCode) {
        this.shokuinCode = shokuinCode;
    }

    /**
     * getBushoCode
     *
     * @return bushoCode
     */
    public BushoCode getBushoCode() {
        return bushoCode;
    }

    /**
     * setBushoCode
     *
     * @param bushoCode bushoCode
     */
    public void setBushoCode(BushoCode bushoCode) {
        this.bushoCode = bushoCode;
    }

    /**
     * getYakushoskuName
     *
     * @return yakushoskuName
     */
    public RString getYakushoskuName() {
        return yakushoskuName;
    }

    /**
     * setYakushoskuName
     *
     * @param yakushoskuName yakushoskuName
     */
    public void setYakushoskuName(RString yakushoskuName) {
        this.yakushoskuName = yakushoskuName;
    }

    /**
     * getBemmeishaShimei
     *
     * @return bemmeishaShimei
     */
    public AtenaMeisho getBemmeishaShimei() {
        return bemmeishaShimei;
    }

    /**
     * setBemmeishaShimei
     *
     * @param bemmeishaShimei bemmeishaShimei
     */
    public void setBemmeishaShimei(AtenaMeisho bemmeishaShimei) {
        this.bemmeishaShimei = bemmeishaShimei;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7003BemmeishaJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7003BemmeishaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7003BemmeishaJohoEntity other) {
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
        if (this.bemmeishaEdaban != other.bemmeishaEdaban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7003BemmeishaJohoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.genshobunHihokenshaNo = entity.genshobunHihokenshaNo;
        this.shinsaseikyuTodokedeYMD = entity.shinsaseikyuTodokedeYMD;
        this.bemmeishoSakuseiYMD = entity.bemmeishoSakuseiYMD;
        this.bemmeishaEdaban = entity.bemmeishaEdaban;
        this.shokuinCode = entity.shokuinCode;
        this.bushoCode = entity.bushoCode;
        this.yakushoskuName = entity.yakushoskuName;
        this.bemmeishaShimei = entity.bemmeishaShimei;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, shikibetsuCode, genshobunHihokenshaNo, shinsaseikyuTodokedeYMD, bemmeishoSakuseiYMD, bemmeishaEdaban, shokuinCode, bushoCode, yakushoskuName, bemmeishaShimei);
    }

// </editor-fold>
}
