package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
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
 * DbT3059KagoMoshitateの項目定義クラスです
 *
 */
public class DbT3059KagoMoshitateEntity extends DbTableEntityBase<DbT3059KagoMoshitateEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3059KagoMoshitate");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate moshitateYMD;
    private RString moshitateshaKubunCode;
    private HokenshaNo shokisaiHokenshaNo;
    private RString moshitateJiyuCode;
    private FlexibleYearMonth kokuhorenSofuYM;
    private boolean kokuhirenSaiSofuAriFlag;
    private boolean dogetsuShinsaAriFlag;
    private RString moshitateshoKubunCode;

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
     * getJigyoshoNo
     *
     * @return jigyoshoNo
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * setJigyoshoNo
     *
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
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
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
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
     * getMoshitateYMD
     *
     * @return moshitateYMD
     */
    public FlexibleDate getMoshitateYMD() {
        return moshitateYMD;
    }

    /**
     * setMoshitateYMD
     *
     * @param moshitateYMD moshitateYMD
     */
    public void setMoshitateYMD(FlexibleDate moshitateYMD) {
        this.moshitateYMD = moshitateYMD;
    }

    /**
     * getMoshitateshaKubunCode
     *
     * @return moshitateshaKubunCode
     */
    public RString getMoshitateshaKubunCode() {
        return moshitateshaKubunCode;
    }

    /**
     * setMoshitateshaKubunCode
     *
     * @param moshitateshaKubunCode moshitateshaKubunCode
     */
    public void setMoshitateshaKubunCode(RString moshitateshaKubunCode) {
        this.moshitateshaKubunCode = moshitateshaKubunCode;
    }

    /**
     * getShokisaiHokenshaNo
     *
     * @return shokisaiHokenshaNo
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     *
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * getMoshitateJiyuCode
     *
     * @return moshitateJiyuCode
     */
    public RString getMoshitateJiyuCode() {
        return moshitateJiyuCode;
    }

    /**
     * setMoshitateJiyuCode
     *
     * @param moshitateJiyuCode moshitateJiyuCode
     */
    public void setMoshitateJiyuCode(RString moshitateJiyuCode) {
        this.moshitateJiyuCode = moshitateJiyuCode;
    }

    /**
     * getKokuhorenSofuYM
     *
     * @return kokuhorenSofuYM
     */
    public FlexibleYearMonth getKokuhorenSofuYM() {
        return kokuhorenSofuYM;
    }

    /**
     * setKokuhorenSofuYM
     *
     * @param kokuhorenSofuYM kokuhorenSofuYM
     */
    public void setKokuhorenSofuYM(FlexibleYearMonth kokuhorenSofuYM) {
        this.kokuhorenSofuYM = kokuhorenSofuYM;
    }

    /**
     * getKokuhirenSaiSofuAriFlag
     *
     * @return kokuhirenSaiSofuAriFlag
     */
    public boolean getKokuhirenSaiSofuAriFlag() {
        return kokuhirenSaiSofuAriFlag;
    }

    /**
     * setKokuhirenSaiSofuAriFlag
     *
     * @param kokuhirenSaiSofuAriFlag kokuhirenSaiSofuAriFlag
     */
    public void setKokuhirenSaiSofuAriFlag(boolean kokuhirenSaiSofuAriFlag) {
        this.kokuhirenSaiSofuAriFlag = kokuhirenSaiSofuAriFlag;
    }

    /**
     * getDogetsuShinsaAriFlag
     *
     * @return dogetsuShinsaAriFlag
     */
    public boolean getDogetsuShinsaAriFlag() {
        return dogetsuShinsaAriFlag;
    }

    /**
     * setDogetsuShinsaAriFlag
     *
     * @param dogetsuShinsaAriFlag dogetsuShinsaAriFlag
     */
    public void setDogetsuShinsaAriFlag(boolean dogetsuShinsaAriFlag) {
        this.dogetsuShinsaAriFlag = dogetsuShinsaAriFlag;
    }

    /**
     * getMoshitateshoKubunCode
     *
     * @return moshitateshoKubunCode
     */
    public RString getMoshitateshoKubunCode() {
        return moshitateshoKubunCode;
    }

    /**
     * setMoshitateshoKubunCode
     *
     * @param moshitateshoKubunCode moshitateshoKubunCode
     */
    public void setMoshitateshoKubunCode(RString moshitateshoKubunCode) {
        this.moshitateshoKubunCode = moshitateshoKubunCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3059KagoMoshitateEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3059KagoMoshitateEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3059KagoMoshitateEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshoNo, other.jigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
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
    public void shallowCopy(DbT3059KagoMoshitateEntity entity) {
        this.jigyoshoNo = entity.jigyoshoNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.moshitateYMD = entity.moshitateYMD;
        this.moshitateshaKubunCode = entity.moshitateshaKubunCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.moshitateJiyuCode = entity.moshitateJiyuCode;
        this.kokuhorenSofuYM = entity.kokuhorenSofuYM;
        this.kokuhirenSaiSofuAriFlag = entity.kokuhirenSaiSofuAriFlag;
        this.dogetsuShinsaAriFlag = entity.dogetsuShinsaAriFlag;
        this.moshitateshoKubunCode = entity.moshitateshoKubunCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshoNo, hiHokenshaNo, serviceTeikyoYM, shoriTimestamp, moshitateYMD, moshitateshaKubunCode, shokisaiHokenshaNo, moshitateJiyuCode, kokuhorenSofuYM, kokuhirenSaiSofuAriFlag, dogetsuShinsaAriFlag, moshitateshoKubunCode);
    }

// </editor-fold>
}
