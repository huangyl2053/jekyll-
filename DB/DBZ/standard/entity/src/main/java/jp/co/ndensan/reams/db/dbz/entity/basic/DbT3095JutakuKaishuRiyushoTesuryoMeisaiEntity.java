package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3095JutakuKaishuRiyushoTesuryoMeisaiの項目定義クラスです
 *
 */
public class DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity extends DbTableEntityBase<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3095JutakuKaishuRiyushoTesuryoMeisai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private ShikibetsuCode shikibetsuCode;
    private ServiceCode serviceCode;
    private AtenaMeisho jutakuKaishuJigyoshaMeisho;
    private FlexibleDate jutakuKaishuChakkoYMD;
    private AtenaMeisho jutakuKaishuJushoShozaisha;
    private RString kaishuTaishoJutakuJusho;
    private RString kaishuNaiyo_kasho_Kibo;
    private FlexibleDate riyushoSakuseiYMD;
    private JigyoshaNo riyushoSakuseiJigyoshaNo;
    private AtenaMeisho riyushoSakuseishaMei;
    private RString riyushoSakuseishaShikaku;
    private FlexibleDate riyushoSakuseiShinseiYMD;
    private FlexibleDate riyushoSakuseiUketsukeYMD;

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
     * getServiceCode
     *
     * @return serviceCode
     */
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * setServiceCode
     *
     * @param serviceCode serviceCode
     */
    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * getJutakuKaishuJigyoshaMeisho
     *
     * @return jutakuKaishuJigyoshaMeisho
     */
    public AtenaMeisho getJutakuKaishuJigyoshaMeisho() {
        return jutakuKaishuJigyoshaMeisho;
    }

    /**
     * setJutakuKaishuJigyoshaMeisho
     *
     * @param jutakuKaishuJigyoshaMeisho jutakuKaishuJigyoshaMeisho
     */
    public void setJutakuKaishuJigyoshaMeisho(AtenaMeisho jutakuKaishuJigyoshaMeisho) {
        this.jutakuKaishuJigyoshaMeisho = jutakuKaishuJigyoshaMeisho;
    }

    /**
     * getJutakuKaishuChakkoYMD
     *
     * @return jutakuKaishuChakkoYMD
     */
    public FlexibleDate getJutakuKaishuChakkoYMD() {
        return jutakuKaishuChakkoYMD;
    }

    /**
     * setJutakuKaishuChakkoYMD
     *
     * @param jutakuKaishuChakkoYMD jutakuKaishuChakkoYMD
     */
    public void setJutakuKaishuChakkoYMD(FlexibleDate jutakuKaishuChakkoYMD) {
        this.jutakuKaishuChakkoYMD = jutakuKaishuChakkoYMD;
    }

    /**
     * getJutakuKaishuJushoShozaisha
     *
     * @return jutakuKaishuJushoShozaisha
     */
    public AtenaMeisho getJutakuKaishuJushoShozaisha() {
        return jutakuKaishuJushoShozaisha;
    }

    /**
     * setJutakuKaishuJushoShozaisha
     *
     * @param jutakuKaishuJushoShozaisha jutakuKaishuJushoShozaisha
     */
    public void setJutakuKaishuJushoShozaisha(AtenaMeisho jutakuKaishuJushoShozaisha) {
        this.jutakuKaishuJushoShozaisha = jutakuKaishuJushoShozaisha;
    }

    /**
     * getKaishuTaishoJutakuJusho
     *
     * @return kaishuTaishoJutakuJusho
     */
    public RString getKaishuTaishoJutakuJusho() {
        return kaishuTaishoJutakuJusho;
    }

    /**
     * setKaishuTaishoJutakuJusho
     *
     * @param kaishuTaishoJutakuJusho kaishuTaishoJutakuJusho
     */
    public void setKaishuTaishoJutakuJusho(RString kaishuTaishoJutakuJusho) {
        this.kaishuTaishoJutakuJusho = kaishuTaishoJutakuJusho;
    }

    /**
     * getKaishuNaiyo_kasho_Kibo
     *
     * @return kaishuNaiyo_kasho_Kibo
     */
    public RString getKaishuNaiyo_kasho_Kibo() {
        return kaishuNaiyo_kasho_Kibo;
    }

    /**
     * setKaishuNaiyo_kasho_Kibo
     *
     * @param kaishuNaiyo_kasho_Kibo kaishuNaiyo_kasho_Kibo
     */
    public void setKaishuNaiyo_kasho_Kibo(RString kaishuNaiyo_kasho_Kibo) {
        this.kaishuNaiyo_kasho_Kibo = kaishuNaiyo_kasho_Kibo;
    }

    /**
     * getRiyushoSakuseiYMD
     *
     * @return riyushoSakuseiYMD
     */
    public FlexibleDate getRiyushoSakuseiYMD() {
        return riyushoSakuseiYMD;
    }

    /**
     * setRiyushoSakuseiYMD
     *
     * @param riyushoSakuseiYMD riyushoSakuseiYMD
     */
    public void setRiyushoSakuseiYMD(FlexibleDate riyushoSakuseiYMD) {
        this.riyushoSakuseiYMD = riyushoSakuseiYMD;
    }

    /**
     * getRiyushoSakuseiJigyoshaNo
     *
     * @return riyushoSakuseiJigyoshaNo
     */
    public JigyoshaNo getRiyushoSakuseiJigyoshaNo() {
        return riyushoSakuseiJigyoshaNo;
    }

    /**
     * setRiyushoSakuseiJigyoshaNo
     *
     * @param riyushoSakuseiJigyoshaNo riyushoSakuseiJigyoshaNo
     */
    public void setRiyushoSakuseiJigyoshaNo(JigyoshaNo riyushoSakuseiJigyoshaNo) {
        this.riyushoSakuseiJigyoshaNo = riyushoSakuseiJigyoshaNo;
    }

    /**
     * getRiyushoSakuseishaMei
     *
     * @return riyushoSakuseishaMei
     */
    public AtenaMeisho getRiyushoSakuseishaMei() {
        return riyushoSakuseishaMei;
    }

    /**
     * setRiyushoSakuseishaMei
     *
     * @param riyushoSakuseishaMei riyushoSakuseishaMei
     */
    public void setRiyushoSakuseishaMei(AtenaMeisho riyushoSakuseishaMei) {
        this.riyushoSakuseishaMei = riyushoSakuseishaMei;
    }

    /**
     * getRiyushoSakuseishaShikaku
     *
     * @return riyushoSakuseishaShikaku
     */
    public RString getRiyushoSakuseishaShikaku() {
        return riyushoSakuseishaShikaku;
    }

    /**
     * setRiyushoSakuseishaShikaku
     *
     * @param riyushoSakuseishaShikaku riyushoSakuseishaShikaku
     */
    public void setRiyushoSakuseishaShikaku(RString riyushoSakuseishaShikaku) {
        this.riyushoSakuseishaShikaku = riyushoSakuseishaShikaku;
    }

    /**
     * getRiyushoSakuseiShinseiYMD
     *
     * @return riyushoSakuseiShinseiYMD
     */
    public FlexibleDate getRiyushoSakuseiShinseiYMD() {
        return riyushoSakuseiShinseiYMD;
    }

    /**
     * setRiyushoSakuseiShinseiYMD
     *
     * @param riyushoSakuseiShinseiYMD riyushoSakuseiShinseiYMD
     */
    public void setRiyushoSakuseiShinseiYMD(FlexibleDate riyushoSakuseiShinseiYMD) {
        this.riyushoSakuseiShinseiYMD = riyushoSakuseiShinseiYMD;
    }

    /**
     * getRiyushoSakuseiUketsukeYMD
     *
     * @return riyushoSakuseiUketsukeYMD
     */
    public FlexibleDate getRiyushoSakuseiUketsukeYMD() {
        return riyushoSakuseiUketsukeYMD;
    }

    /**
     * setRiyushoSakuseiUketsukeYMD
     *
     * @param riyushoSakuseiUketsukeYMD riyushoSakuseiUketsukeYMD
     */
    public void setRiyushoSakuseiUketsukeYMD(FlexibleDate riyushoSakuseiUketsukeYMD) {
        this.riyushoSakuseiUketsukeYMD = riyushoSakuseiUketsukeYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.serviceCode = entity.serviceCode;
        this.jutakuKaishuJigyoshaMeisho = entity.jutakuKaishuJigyoshaMeisho;
        this.jutakuKaishuChakkoYMD = entity.jutakuKaishuChakkoYMD;
        this.jutakuKaishuJushoShozaisha = entity.jutakuKaishuJushoShozaisha;
        this.kaishuTaishoJutakuJusho = entity.kaishuTaishoJutakuJusho;
        this.kaishuNaiyo_kasho_Kibo = entity.kaishuNaiyo_kasho_Kibo;
        this.riyushoSakuseiYMD = entity.riyushoSakuseiYMD;
        this.riyushoSakuseiJigyoshaNo = entity.riyushoSakuseiJigyoshaNo;
        this.riyushoSakuseishaMei = entity.riyushoSakuseishaMei;
        this.riyushoSakuseishaShikaku = entity.riyushoSakuseishaShikaku;
        this.riyushoSakuseiShinseiYMD = entity.riyushoSakuseiShinseiYMD;
        this.riyushoSakuseiUketsukeYMD = entity.riyushoSakuseiUketsukeYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, shoriTimestamp, shikibetsuCode, serviceCode, jutakuKaishuJigyoshaMeisho, jutakuKaishuChakkoYMD, jutakuKaishuJushoShozaisha, kaishuTaishoJutakuJusho, kaishuNaiyo_kasho_Kibo, riyushoSakuseiYMD, riyushoSakuseiJigyoshaNo, riyushoSakuseishaMei, riyushoSakuseishaShikaku, riyushoSakuseiShinseiYMD, riyushoSakuseiUketsukeYMD);
    }

// </editor-fold>
}
