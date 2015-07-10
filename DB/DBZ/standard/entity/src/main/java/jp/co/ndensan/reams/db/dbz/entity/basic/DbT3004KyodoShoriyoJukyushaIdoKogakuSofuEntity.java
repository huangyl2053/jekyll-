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
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3004KyodoShoriyoJukyushaIdoKogakuSofuの項目定義クラスです
 *
 */
public class DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity extends DbTableEntityBase<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3004KyodoShoriyoJukyushaIdoKogakuSofu");

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
    private YMDHMS shoriTimestamp;
    private HihokenshaNo setaiShuyakuNo;
    private RString setaiShotokuKubunCode;
    private RString shotokuKubunCode;
    private boolean roureiFukushiNenkinJukyuAriFlag;
    private boolean riyoshaFutan2DankaiAriFlag;
    private boolean shikyuShinseishoOutputAriFlag;
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
     * getSetaiShuyakuNo
     *
     * @return setaiShuyakuNo
     */
    public HihokenshaNo getSetaiShuyakuNo() {
        return setaiShuyakuNo;
    }

    /**
     * setSetaiShuyakuNo
     *
     * @param setaiShuyakuNo setaiShuyakuNo
     */
    public void setSetaiShuyakuNo(HihokenshaNo setaiShuyakuNo) {
        this.setaiShuyakuNo = setaiShuyakuNo;
    }

    /**
     * getSetaiShotokuKubunCode
     *
     * @return setaiShotokuKubunCode
     */
    public RString getSetaiShotokuKubunCode() {
        return setaiShotokuKubunCode;
    }

    /**
     * setSetaiShotokuKubunCode
     *
     * @param setaiShotokuKubunCode setaiShotokuKubunCode
     */
    public void setSetaiShotokuKubunCode(RString setaiShotokuKubunCode) {
        this.setaiShotokuKubunCode = setaiShotokuKubunCode;
    }

    /**
     * getShotokuKubunCode
     *
     * @return shotokuKubunCode
     */
    public RString getShotokuKubunCode() {
        return shotokuKubunCode;
    }

    /**
     * setShotokuKubunCode
     *
     * @param shotokuKubunCode shotokuKubunCode
     */
    public void setShotokuKubunCode(RString shotokuKubunCode) {
        this.shotokuKubunCode = shotokuKubunCode;
    }

    /**
     * getRoureiFukushiNenkinJukyuAriFlag
     *
     * @return roureiFukushiNenkinJukyuAriFlag
     */
    public boolean getRoureiFukushiNenkinJukyuAriFlag() {
        return roureiFukushiNenkinJukyuAriFlag;
    }

    /**
     * setRoureiFukushiNenkinJukyuAriFlag
     *
     * @param roureiFukushiNenkinJukyuAriFlag roureiFukushiNenkinJukyuAriFlag
     */
    public void setRoureiFukushiNenkinJukyuAriFlag(boolean roureiFukushiNenkinJukyuAriFlag) {
        this.roureiFukushiNenkinJukyuAriFlag = roureiFukushiNenkinJukyuAriFlag;
    }

    /**
     * getRiyoshaFutan2DankaiAriFlag
     *
     * @return riyoshaFutan2DankaiAriFlag
     */
    public boolean getRiyoshaFutan2DankaiAriFlag() {
        return riyoshaFutan2DankaiAriFlag;
    }

    /**
     * setRiyoshaFutan2DankaiAriFlag
     *
     * @param riyoshaFutan2DankaiAriFlag riyoshaFutan2DankaiAriFlag
     */
    public void setRiyoshaFutan2DankaiAriFlag(boolean riyoshaFutan2DankaiAriFlag) {
        this.riyoshaFutan2DankaiAriFlag = riyoshaFutan2DankaiAriFlag;
    }

    /**
     * getShikyuShinseishoOutputAriFlag
     *
     * @return shikyuShinseishoOutputAriFlag
     */
    public boolean getShikyuShinseishoOutputAriFlag() {
        return shikyuShinseishoOutputAriFlag;
    }

    /**
     * setShikyuShinseishoOutputAriFlag
     *
     * @param shikyuShinseishoOutputAriFlag shikyuShinseishoOutputAriFlag
     */
    public void setShikyuShinseishoOutputAriFlag(boolean shikyuShinseishoOutputAriFlag) {
        this.shikyuShinseishoOutputAriFlag = shikyuShinseishoOutputAriFlag;
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
     * このエンティティの主キーが他の{@literal DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity other) {
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity entity) {
        this.idoYMD = entity.idoYMD;
        this.idoKubunCode = entity.idoKubunCode;
        this.jukyushaIdoJiyu = entity.jukyushaIdoJiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.setaiShuyakuNo = entity.setaiShuyakuNo;
        this.setaiShotokuKubunCode = entity.setaiShotokuKubunCode;
        this.shotokuKubunCode = entity.shotokuKubunCode;
        this.roureiFukushiNenkinJukyuAriFlag = entity.roureiFukushiNenkinJukyuAriFlag;
        this.riyoshaFutan2DankaiAriFlag = entity.riyoshaFutan2DankaiAriFlag;
        this.shikyuShinseishoOutputAriFlag = entity.shikyuShinseishoOutputAriFlag;
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
        return super.toMd5(idoYMD, idoKubunCode, jukyushaIdoJiyu, shoKisaiHokenshaNo, hiHokenshaNo, shoriTimestamp, setaiShuyakuNo, setaiShotokuKubunCode, shotokuKubunCode, roureiFukushiNenkinJukyuAriFlag, riyoshaFutan2DankaiAriFlag, shikyuShinseishoOutputAriFlag, teiseiRenrakuhyoFlag, sofuYM);
    }

// </editor-fold>
}
