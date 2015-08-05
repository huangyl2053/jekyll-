package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import java.util.Objects;

/**
 * 過誤申立テーブルのエンティティクラスです。
 */
public class DbT3059KagoMoshitateEntity extends DbTableEntityBase<DbT3059KagoMoshitateEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private int rirekiNo;
    private FlexibleDate moshitateYMD;
    private RString moshitateshaKubunCode;
    private HokenshaNo shokisaiHokenshaNo;
    private RString moshitateJiyuCode;
    private FlexibleYearMonth kokuhorenSofuYM;
    private boolean kokuhirenSaiSofuAriFlag;
    private boolean dogetsuShinsaAriFlag;
    private RString moshitateshoKubunCode;

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
     * 事業所番号のgetメソッドです。
     *
     * @return 事業所番号
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * 事業所番号のsetメソッドです。
     *
     * @param jigyoshoNo 事業所番号
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * サービス提供年月のsetメソッドです。
     *
     * @param serviceTeikyoYM サービス提供年月
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
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
     * 申立年月日のgetメソッドです。
     *
     * @return 申立年月日
     */
    public FlexibleDate getMoshitateYMD() {
        return moshitateYMD;
    }

    /**
     * 申立年月日のsetメソッドです。
     *
     * @param moshitateYMD 申立年月日
     */
    public void setMoshitateYMD(FlexibleDate moshitateYMD) {
        this.moshitateYMD = moshitateYMD;
    }

    /**
     * 申立者区分コードのgetメソッドです。
     * <br/>
     * <br/>2固定(2：保険者申立)
     *
     * @return 申立者区分コード
     */
    public RString getMoshitateshaKubunCode() {
        return moshitateshaKubunCode;
    }

    /**
     * 申立者区分コードのsetメソッドです。
     * <br/>
     * <br/>2固定(2：保険者申立)
     *
     * @param moshitateshaKubunCode 申立者区分コード
     */
    public void setMoshitateshaKubunCode(RString moshitateshaKubunCode) {
        this.moshitateshaKubunCode = moshitateshaKubunCode;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shokisaiHokenshaNo 証記載保険者番号
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * 申立事由コードのgetメソッドです。
     *
     * @return 申立事由コード
     */
    public RString getMoshitateJiyuCode() {
        return moshitateJiyuCode;
    }

    /**
     * 申立事由コードのsetメソッドです。
     *
     * @param moshitateJiyuCode 申立事由コード
     */
    public void setMoshitateJiyuCode(RString moshitateJiyuCode) {
        this.moshitateJiyuCode = moshitateJiyuCode;
    }

    /**
     * 国保連送付年月のgetメソッドです。
     *
     * @return 国保連送付年月
     */
    public FlexibleYearMonth getKokuhorenSofuYM() {
        return kokuhorenSofuYM;
    }

    /**
     * 国保連送付年月のsetメソッドです。
     *
     * @param kokuhorenSofuYM 国保連送付年月
     */
    public void setKokuhorenSofuYM(FlexibleYearMonth kokuhorenSofuYM) {
        this.kokuhorenSofuYM = kokuhorenSofuYM;
    }

    /**
     * 国保連再送付有フラグのgetメソッドです。
     * <br/>
     * <br/>0：通常　1：再送付
     *
     * @return 国保連再送付有フラグ
     */
    public boolean getKokuhirenSaiSofuAriFlag() {
        return kokuhirenSaiSofuAriFlag;
    }

    /**
     * 国保連再送付有フラグのsetメソッドです。
     * <br/>
     * <br/>0：通常　1：再送付
     *
     * @param kokuhirenSaiSofuAriFlag 国保連再送付有フラグ
     */
    public void setKokuhirenSaiSofuAriFlag(boolean kokuhirenSaiSofuAriFlag) {
        this.kokuhirenSaiSofuAriFlag = kokuhirenSaiSofuAriFlag;
    }

    /**
     * 同月審査有フラグのgetメソッドです。
     * <br/>
     * <br/>0：通常　1：同月審査用（同月過誤）
     *
     * @return 同月審査有フラグ
     */
    public boolean getDogetsuShinsaAriFlag() {
        return dogetsuShinsaAriFlag;
    }

    /**
     * 同月審査有フラグのsetメソッドです。
     * <br/>
     * <br/>0：通常　1：同月審査用（同月過誤）
     *
     * @param dogetsuShinsaAriFlag 同月審査有フラグ
     */
    public void setDogetsuShinsaAriFlag(boolean dogetsuShinsaAriFlag) {
        this.dogetsuShinsaAriFlag = dogetsuShinsaAriFlag;
    }

    /**
     * 申立書区分コードのgetメソッドです。
     * <br/>
     * <br/>1：過誤申立書情報
     *
     * <br/>2：総合事業過誤申立書情報（経過措置）
     *
     * <br/>3:総合事業過誤申立書情報
     *
     * @return 申立書区分コード
     */
    public RString getMoshitateshoKubunCode() {
        return moshitateshoKubunCode;
    }

    /**
     * 申立書区分コードのsetメソッドです。
     * <br/>
     * <br/>1：過誤申立書情報
     *
     * <br/>2：総合事業過誤申立書情報（経過措置）
     *
     * <br/>3:総合事業過誤申立書情報
     *
     * @param moshitateshoKubunCode 申立書区分コード
     */
    public void setMoshitateshoKubunCode(RString moshitateshoKubunCode) {
        this.moshitateshoKubunCode = moshitateshoKubunCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3059KagoMoshitateEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3059KagoMoshitateEntity}の場合{@literal true}、それ以外の場合は{@literal false}
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(jigyoshoNo, hiHokenshaNo, serviceTeikyoYM, rirekiNo, moshitateYMD, moshitateshaKubunCode, shokisaiHokenshaNo, moshitateJiyuCode, kokuhorenSofuYM, kokuhirenSaiSofuAriFlag, dogetsuShinsaAriFlag, moshitateshoKubunCode);
    }

// </editor-fold>
}
