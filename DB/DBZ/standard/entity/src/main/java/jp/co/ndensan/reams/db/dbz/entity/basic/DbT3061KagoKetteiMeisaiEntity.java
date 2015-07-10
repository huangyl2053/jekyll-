package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3061KagoKetteiMeisaiの項目定義クラスです
 *
 */
public class DbT3061KagoKetteiMeisaiEntity extends DbTableEntityBase<DbT3061KagoKetteiMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3061KagoKetteiMeisai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYearMonth toriatsukaiYM;
    @PrimaryKey
    private RString hokenshaKubun;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private JigyoshaNo jigyoshoNo;
    private RString jigyoshoName;
    private HihokenshaNo hiHokenshaNo;
    private RString kohiJukyushaNo;
    private HokenshaNo shokisaiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private ServiceShuruiCode serviceShuruiCode;
    private RString serviceShuruiName;
    private Code kagomoushitateJiyuCode;
    private RString kagomoushitateJiyu;
    private Decimal tanisu;
    private Decimal hokenshaFutangaku;

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
     * getToriatsukaiYM
     *
     * @return toriatsukaiYM
     */
    public FlexibleYearMonth getToriatsukaiYM() {
        return toriatsukaiYM;
    }

    /**
     * setToriatsukaiYM
     *
     * @param toriatsukaiYM toriatsukaiYM
     */
    public void setToriatsukaiYM(FlexibleYearMonth toriatsukaiYM) {
        this.toriatsukaiYM = toriatsukaiYM;
    }

    /**
     * getHokenshaKubun
     *
     * @return hokenshaKubun
     */
    public RString getHokenshaKubun() {
        return hokenshaKubun;
    }

    /**
     * setHokenshaKubun
     *
     * @param hokenshaKubun hokenshaKubun
     */
    public void setHokenshaKubun(RString hokenshaKubun) {
        this.hokenshaKubun = hokenshaKubun;
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
     * getJigyoshoName
     *
     * @return jigyoshoName
     */
    public RString getJigyoshoName() {
        return jigyoshoName;
    }

    /**
     * setJigyoshoName
     *
     * @param jigyoshoName jigyoshoName
     */
    public void setJigyoshoName(RString jigyoshoName) {
        this.jigyoshoName = jigyoshoName;
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
     * getKohiJukyushaNo
     *
     * @return kohiJukyushaNo
     */
    public RString getKohiJukyushaNo() {
        return kohiJukyushaNo;
    }

    /**
     * setKohiJukyushaNo
     *
     * @param kohiJukyushaNo kohiJukyushaNo
     */
    public void setKohiJukyushaNo(RString kohiJukyushaNo) {
        this.kohiJukyushaNo = kohiJukyushaNo;
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
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getServiceShuruiName
     *
     * @return serviceShuruiName
     */
    public RString getServiceShuruiName() {
        return serviceShuruiName;
    }

    /**
     * setServiceShuruiName
     *
     * @param serviceShuruiName serviceShuruiName
     */
    public void setServiceShuruiName(RString serviceShuruiName) {
        this.serviceShuruiName = serviceShuruiName;
    }

    /**
     * getKagomoushitateJiyuCode
     *
     * @return kagomoushitateJiyuCode
     */
    public Code getKagomoushitateJiyuCode() {
        return kagomoushitateJiyuCode;
    }

    /**
     * setKagomoushitateJiyuCode
     *
     * @param kagomoushitateJiyuCode kagomoushitateJiyuCode
     */
    public void setKagomoushitateJiyuCode(Code kagomoushitateJiyuCode) {
        this.kagomoushitateJiyuCode = kagomoushitateJiyuCode;
    }

    /**
     * getKagomoushitateJiyu
     *
     * @return kagomoushitateJiyu
     */
    public RString getKagomoushitateJiyu() {
        return kagomoushitateJiyu;
    }

    /**
     * setKagomoushitateJiyu
     *
     * @param kagomoushitateJiyu kagomoushitateJiyu
     */
    public void setKagomoushitateJiyu(RString kagomoushitateJiyu) {
        this.kagomoushitateJiyu = kagomoushitateJiyu;
    }

    /**
     * getTanisu
     *
     * @return tanisu
     */
    public Decimal getTanisu() {
        return tanisu;
    }

    /**
     * setTanisu
     *
     * @param tanisu tanisu
     */
    public void setTanisu(Decimal tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * getHokenshaFutangaku
     *
     * @return hokenshaFutangaku
     */
    public Decimal getHokenshaFutangaku() {
        return hokenshaFutangaku;
    }

    /**
     * setHokenshaFutangaku
     *
     * @param hokenshaFutangaku hokenshaFutangaku
     */
    public void setHokenshaFutangaku(Decimal hokenshaFutangaku) {
        this.hokenshaFutangaku = hokenshaFutangaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3061KagoKetteiMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3061KagoKetteiMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3061KagoKetteiMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.toriatsukaiYM, other.toriatsukaiYM)) {
            return false;
        }
        if (!Objects.equals(this.hokenshaKubun, other.hokenshaKubun)) {
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
    public void shallowCopy(DbT3061KagoKetteiMeisaiEntity entity) {
        this.toriatsukaiYM = entity.toriatsukaiYM;
        this.hokenshaKubun = entity.hokenshaKubun;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.jigyoshoName = entity.jigyoshoName;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.kohiJukyushaNo = entity.kohiJukyushaNo;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceShuruiName = entity.serviceShuruiName;
        this.kagomoushitateJiyuCode = entity.kagomoushitateJiyuCode;
        this.kagomoushitateJiyu = entity.kagomoushitateJiyu;
        this.tanisu = entity.tanisu;
        this.hokenshaFutangaku = entity.hokenshaFutangaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(toriatsukaiYM, hokenshaKubun, shoriTimestamp, jigyoshoNo, jigyoshoName, hiHokenshaNo, kohiJukyushaNo, shokisaiHokenshaNo, serviceTeikyoYM, serviceShuruiCode, serviceShuruiName, kagomoushitateJiyuCode, kagomoushitateJiyu, tanisu, hokenshaFutangaku);
    }

// </editor-fold>
}
