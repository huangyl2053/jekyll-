package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3003KyodoShoriyoJukyushaIdoShokanSofuの項目定義クラスです
 *
 */
public class DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity extends DbTableEntityBase<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3003KyodoShoriyoJukyushaIdoShokanSofu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private RString idoKubunCode;
    @PrimaryKey
    private RString jukyushaIdoJiyu;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private YMDHMS syoriTimestamp;
    private FlexibleDate hokenKyufuIchijiSashitomeKaishiYMD;
    private FlexibleDate hokenKyufuIchijiSashitomeShuryoYMD;
    private RString hokenkyufuIchijiSashitomeKubunCode;
    private Decimal hokenkyufuIchijiSashitomeKingaku;
    private boolean teiseiRenrakuhyoFlag;
    private FlexibleYearMonth sofuYM;

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
     * getIdoYMD
     *
     * @return idoYMD
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * setIdoYMD
     *
     * @param idoYMD idoYMD
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * getIdoKubunCode
     *
     * @return idoKubunCode
     */
    public RString getIdoKubunCode() {
        return idoKubunCode;
    }

    /**
     * setIdoKubunCode
     *
     * @param idoKubunCode idoKubunCode
     */
    public void setIdoKubunCode(RString idoKubunCode) {
        this.idoKubunCode = idoKubunCode;
    }

    /**
     * getJukyushaIdoJiyu
     *
     * @return jukyushaIdoJiyu
     */
    public RString getJukyushaIdoJiyu() {
        return jukyushaIdoJiyu;
    }

    /**
     * setJukyushaIdoJiyu
     *
     * @param jukyushaIdoJiyu jukyushaIdoJiyu
     */
    public void setJukyushaIdoJiyu(RString jukyushaIdoJiyu) {
        this.jukyushaIdoJiyu = jukyushaIdoJiyu;
    }

    /**
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getSyoriTimestamp
     *
     * @return syoriTimestamp
     */
    public YMDHMS getSyoriTimestamp() {
        return syoriTimestamp;
    }

    /**
     * setSyoriTimestamp
     *
     * @param syoriTimestamp syoriTimestamp
     */
    public void setSyoriTimestamp(YMDHMS syoriTimestamp) {
        this.syoriTimestamp = syoriTimestamp;
    }

    /**
     * getHokenKyufuIchijiSashitomeKaishiYMD
     *
     * @return hokenKyufuIchijiSashitomeKaishiYMD
     */
    public FlexibleDate getHokenKyufuIchijiSashitomeKaishiYMD() {
        return hokenKyufuIchijiSashitomeKaishiYMD;
    }

    /**
     * setHokenKyufuIchijiSashitomeKaishiYMD
     *
     * @param hokenKyufuIchijiSashitomeKaishiYMD hokenKyufuIchijiSashitomeKaishiYMD
     */
    public void setHokenKyufuIchijiSashitomeKaishiYMD(FlexibleDate hokenKyufuIchijiSashitomeKaishiYMD) {
        this.hokenKyufuIchijiSashitomeKaishiYMD = hokenKyufuIchijiSashitomeKaishiYMD;
    }

    /**
     * getHokenKyufuIchijiSashitomeShuryoYMD
     *
     * @return hokenKyufuIchijiSashitomeShuryoYMD
     */
    public FlexibleDate getHokenKyufuIchijiSashitomeShuryoYMD() {
        return hokenKyufuIchijiSashitomeShuryoYMD;
    }

    /**
     * setHokenKyufuIchijiSashitomeShuryoYMD
     *
     * @param hokenKyufuIchijiSashitomeShuryoYMD hokenKyufuIchijiSashitomeShuryoYMD
     */
    public void setHokenKyufuIchijiSashitomeShuryoYMD(FlexibleDate hokenKyufuIchijiSashitomeShuryoYMD) {
        this.hokenKyufuIchijiSashitomeShuryoYMD = hokenKyufuIchijiSashitomeShuryoYMD;
    }

    /**
     * getHokenkyufuIchijiSashitomeKubunCode
     *
     * @return hokenkyufuIchijiSashitomeKubunCode
     */
    public RString getHokenkyufuIchijiSashitomeKubunCode() {
        return hokenkyufuIchijiSashitomeKubunCode;
    }

    /**
     * setHokenkyufuIchijiSashitomeKubunCode
     *
     * @param hokenkyufuIchijiSashitomeKubunCode hokenkyufuIchijiSashitomeKubunCode
     */
    public void setHokenkyufuIchijiSashitomeKubunCode(RString hokenkyufuIchijiSashitomeKubunCode) {
        this.hokenkyufuIchijiSashitomeKubunCode = hokenkyufuIchijiSashitomeKubunCode;
    }

    /**
     * getHokenkyufuIchijiSashitomeKingaku
     *
     * @return hokenkyufuIchijiSashitomeKingaku
     */
    public Decimal getHokenkyufuIchijiSashitomeKingaku() {
        return hokenkyufuIchijiSashitomeKingaku;
    }

    /**
     * setHokenkyufuIchijiSashitomeKingaku
     *
     * @param hokenkyufuIchijiSashitomeKingaku hokenkyufuIchijiSashitomeKingaku
     */
    public void setHokenkyufuIchijiSashitomeKingaku(Decimal hokenkyufuIchijiSashitomeKingaku) {
        this.hokenkyufuIchijiSashitomeKingaku = hokenkyufuIchijiSashitomeKingaku;
    }

    /**
     * getTeiseiRenrakuhyoFlag
     *
     * @return teiseiRenrakuhyoFlag
     */
    public boolean getTeiseiRenrakuhyoFlag() {
        return teiseiRenrakuhyoFlag;
    }

    /**
     * setTeiseiRenrakuhyoFlag
     *
     * @param teiseiRenrakuhyoFlag teiseiRenrakuhyoFlag
     */
    public void setTeiseiRenrakuhyoFlag(boolean teiseiRenrakuhyoFlag) {
        this.teiseiRenrakuhyoFlag = teiseiRenrakuhyoFlag;
    }

    /**
     * getSofuYM
     *
     * @return sofuYM
     */
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * setSofuYM
     *
     * @param sofuYM sofuYM
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.idoYMD, other.idoYMD)) {
            return false;
        }
        if (!Objects.equals(this.idoKubunCode, other.idoKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.jukyushaIdoJiyu, other.jukyushaIdoJiyu)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.syoriTimestamp, other.syoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity) {
        this.idoYMD = entity.idoYMD;
        this.idoKubunCode = entity.idoKubunCode;
        this.jukyushaIdoJiyu = entity.jukyushaIdoJiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.syoriTimestamp = entity.syoriTimestamp;
        this.hokenKyufuIchijiSashitomeKaishiYMD = entity.hokenKyufuIchijiSashitomeKaishiYMD;
        this.hokenKyufuIchijiSashitomeShuryoYMD = entity.hokenKyufuIchijiSashitomeShuryoYMD;
        this.hokenkyufuIchijiSashitomeKubunCode = entity.hokenkyufuIchijiSashitomeKubunCode;
        this.hokenkyufuIchijiSashitomeKingaku = entity.hokenkyufuIchijiSashitomeKingaku;
        this.teiseiRenrakuhyoFlag = entity.teiseiRenrakuhyoFlag;
        this.sofuYM = entity.sofuYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(idoYMD, idoKubunCode, jukyushaIdoJiyu, shoKisaiHokenshaNo, hiHokenshaNo, syoriTimestamp, hokenKyufuIchijiSashitomeKaishiYMD, hokenKyufuIchijiSashitomeShuryoYMD, hokenkyufuIchijiSashitomeKubunCode, hokenkyufuIchijiSashitomeKingaku, teiseiRenrakuhyoFlag, sofuYM);
    }

// </editor-fold>
}
