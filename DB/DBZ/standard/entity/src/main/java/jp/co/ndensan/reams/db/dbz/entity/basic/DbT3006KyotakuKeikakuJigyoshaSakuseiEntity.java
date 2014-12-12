package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * DbT3006KyotakuKeikakuJigyoshaSakuseiの項目定義クラスです
 *
 */
public class DbT3006KyotakuKeikakuJigyoshaSakuseiEntity extends DbTableEntityBase<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3006KyotakuKeikakuJigyoshaSakusei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString hihokenshano;
    @PrimaryKey
    private RString shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString keikakuJigyoshaNo;
    private RString itakusakiJigyoshaNo;
    private FlexibleDate jigyoshaHenkoYMD;
    private RString jigyoshaHenkoJiyu;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getHihokenshano
     * @return hihokenshano
     */
    public RString getHihokenshano() {
        return hihokenshano;
    }

    /**
     * setHihokenshano
     * @param hihokenshano hihokenshano
     */
    public void setHihokenshano(RString hihokenshano) {
        this.hihokenshano = hihokenshano;
    }

    /**
     * getShoKisaiHokenshaNo
     * @return shoKisaiHokenshaNo
     */
    public RString getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(RString shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getShikibetsuCode
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getTaishoYM
     * @return taishoYM
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * setTaishoYM
     * @param taishoYM taishoYM
     */
    public void setTaishoYM(FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
    }

    /**
     * getShoriTimestamp
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getTekiyoKaishiYMD
     * @return tekiyoKaishiYMD
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * setTekiyoKaishiYMD
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * getTekiyoShuryoYMD
     * @return tekiyoShuryoYMD
     */
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * setTekiyoShuryoYMD
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * getKeikakuJigyoshaNo
     * @return keikakuJigyoshaNo
     */
    public RString getKeikakuJigyoshaNo() {
        return keikakuJigyoshaNo;
    }

    /**
     * setKeikakuJigyoshaNo
     * @param keikakuJigyoshaNo keikakuJigyoshaNo
     */
    public void setKeikakuJigyoshaNo(RString keikakuJigyoshaNo) {
        this.keikakuJigyoshaNo = keikakuJigyoshaNo;
    }

    /**
     * getItakusakiJigyoshaNo
     * @return itakusakiJigyoshaNo
     */
    public RString getItakusakiJigyoshaNo() {
        return itakusakiJigyoshaNo;
    }

    /**
     * setItakusakiJigyoshaNo
     * @param itakusakiJigyoshaNo itakusakiJigyoshaNo
     */
    public void setItakusakiJigyoshaNo(RString itakusakiJigyoshaNo) {
        this.itakusakiJigyoshaNo = itakusakiJigyoshaNo;
    }

    /**
     * getJigyoshaHenkoYMD
     * @return jigyoshaHenkoYMD
     */
    public FlexibleDate getJigyoshaHenkoYMD() {
        return jigyoshaHenkoYMD;
    }

    /**
     * setJigyoshaHenkoYMD
     * @param jigyoshaHenkoYMD jigyoshaHenkoYMD
     */
    public void setJigyoshaHenkoYMD(FlexibleDate jigyoshaHenkoYMD) {
        this.jigyoshaHenkoYMD = jigyoshaHenkoYMD;
    }

    /**
     * getJigyoshaHenkoJiyu
     * @return jigyoshaHenkoJiyu
     */
    public RString getJigyoshaHenkoJiyu() {
        return jigyoshaHenkoJiyu;
    }

    /**
     * setJigyoshaHenkoJiyu
     * @param jigyoshaHenkoJiyu jigyoshaHenkoJiyu
     */
    public void setJigyoshaHenkoJiyu(RString jigyoshaHenkoJiyu) {
        this.jigyoshaHenkoJiyu = jigyoshaHenkoJiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshano, other.hihokenshano)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.taishoYM, other.taishoYM)) {
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
    public void shallowCopy(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        this.hihokenshano = entity.hihokenshano;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.taishoYM = entity.taishoYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.keikakuJigyoshaNo = entity.keikakuJigyoshaNo;
        this.itakusakiJigyoshaNo = entity.itakusakiJigyoshaNo;
        this.jigyoshaHenkoYMD = entity.jigyoshaHenkoYMD;
        this.jigyoshaHenkoJiyu = entity.jigyoshaHenkoJiyu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshano, shoKisaiHokenshaNo, shikibetsuCode, taishoYM, shoriTimestamp, tekiyoKaishiYMD, tekiyoShuryoYMD, keikakuJigyoshaNo, itakusakiJigyoshaNo, jigyoshaHenkoYMD, jigyoshaHenkoJiyu);
    }

// </editor-fold>

}
