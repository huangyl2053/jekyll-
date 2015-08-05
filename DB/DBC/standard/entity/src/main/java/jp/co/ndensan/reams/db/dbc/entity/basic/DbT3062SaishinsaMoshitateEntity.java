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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import java.util.Objects;

/**
 * 再審査申立テーブルのエンティティクラスです。
 */
public class DbT3062SaishinsaMoshitateEntity extends DbTableEntityBase<DbT3062SaishinsaMoshitateEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3062SaishinsaMoshitate");

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
    private ServiceShuruiCode serviceTeikyoShuruiCode;
    @PrimaryKey
    private ServiceKomokuCode serviceKomokuCode;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate moshitateYMD;
    private RString moshitateshaKubunCode;
    private HokenshaNo shokisaiHokenshaNo;
    private int moshitateTanisu;
    private RString moshitateJiyuCode;
    private FlexibleYearMonth kokuhorenSofuYM;
    private boolean kokuhirenSaiSofuAriFlag;
    private RString biko;

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
     * サービス種類コードのgetメソッドです。
     * 
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceTeikyoShuruiCode() {
        return serviceTeikyoShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     * 
     * @param serviceTeikyoShuruiCode サービス種類コード
     */
    public void setServiceTeikyoShuruiCode(ServiceShuruiCode serviceTeikyoShuruiCode) {
        this.serviceTeikyoShuruiCode = serviceTeikyoShuruiCode;
    }

    /**
     * サービス項目コードのgetメソッドです。
     * <br/>
     * <br/>特定診療費・特別療養費の場合は識別番号を設定する（上2桁は00)
     * 
     * @return サービス項目コード
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * サービス項目コードのsetメソッドです。
     * <br/>
     * <br/>特定診療費・特別療養費の場合は識別番号を設定する（上2桁は00)
     * 
     * @param serviceKomokuCode サービス項目コード
     */
    public void setServiceKomokuCode(ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
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
     * <br/>1：サービス事業者等申立
     * 
     * @return 申立者区分コード
     */
    public RString getMoshitateshaKubunCode() {
        return moshitateshaKubunCode;
    }

    /**
     * 申立者区分コードのsetメソッドです。
     * <br/>
     * <br/>1：サービス事業者等申立
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
     * 申立単位数のgetメソッドです。
     * 
     * @return 申立単位数
     */
    public int getMoshitateTanisu() {
        return moshitateTanisu;
    }

    /**
     * 申立単位数のsetメソッドです。
     * 
     * @param moshitateTanisu 申立単位数
     */
    public void setMoshitateTanisu(int moshitateTanisu) {
        this.moshitateTanisu = moshitateTanisu;
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
     * 
     * @return 国保連再送付有フラグ
     */
    public boolean getKokuhirenSaiSofuAriFlag() {
        return kokuhirenSaiSofuAriFlag;
    }

    /**
     * 国保連再送付有フラグのsetメソッドです。
     * 
     * @param kokuhirenSaiSofuAriFlag 国保連再送付有フラグ
     */
    public void setKokuhirenSaiSofuAriFlag(boolean kokuhirenSaiSofuAriFlag) {
        this.kokuhirenSaiSofuAriFlag = kokuhirenSaiSofuAriFlag;
    }

    /**
     * 備考のgetメソッドです。
     * <br/>
     * <br/>沖縄広域のみ使用
     * 
     * @return 備考
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     * <br/>
     * <br/>沖縄広域のみ使用
     * 
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3062SaishinsaMoshitateEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3062SaishinsaMoshitateEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3062SaishinsaMoshitateEntity other) {
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
        if (!Objects.equals(this.serviceTeikyoShuruiCode, other.serviceTeikyoShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.serviceKomokuCode, other.serviceKomokuCode)) {
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
    public void shallowCopy(DbT3062SaishinsaMoshitateEntity entity) {
        this.jigyoshoNo = entity.jigyoshoNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.serviceTeikyoShuruiCode = entity.serviceTeikyoShuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.rirekiNo = entity.rirekiNo;
        this.moshitateYMD = entity.moshitateYMD;
        this.moshitateshaKubunCode = entity.moshitateshaKubunCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.moshitateTanisu = entity.moshitateTanisu;
        this.moshitateJiyuCode = entity.moshitateJiyuCode;
        this.kokuhorenSofuYM = entity.kokuhorenSofuYM;
        this.kokuhirenSaiSofuAriFlag = entity.kokuhirenSaiSofuAriFlag;
        this.biko = entity.biko;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshoNo, hiHokenshaNo, serviceTeikyoYM, serviceTeikyoShuruiCode, serviceKomokuCode, rirekiNo, moshitateYMD, moshitateshaKubunCode, shokisaiHokenshaNo, moshitateTanisu, moshitateJiyuCode, kokuhorenSofuYM, kokuhirenSaiSofuAriFlag, biko);
    }

// </editor-fold>


}
