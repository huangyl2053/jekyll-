package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiの項目定義クラスです
 *
 */
public class DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity extends DbTableEntityBase<DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisai");

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
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString kyotakuServiceKubun;
    private JigyoshaNo serviceTeikyoJigyoshaNo;
    private ServiceShuruiCode serviceShuruiCode;
    private ServiceKomokuCode serviceKomokuCode;
    private Decimal taniSu;
    private Decimal kaisu_Nissu;
    private Decimal shuruiGendoNaiTaniSu_Nissu;
    private Decimal shuruiGendoChokaTaniSu_Nissu;
    private Decimal kubunGendoNaiTaniSu_Nissu;
    private Decimal kubunGendoChokaTaniSu_Nissu;
    private Decimal taniSuTanka;
    private HokenKyufuRitsu kyufuRitsu;
    private HokenKyufuRitsu waribikiGoTekiyoRitsu;
    private Decimal waribikiGoTekiyoTaniSu;
    private Decimal teigakuRiyoshaFutanTankaKingaku;

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
     * getTaishoYM
     *
     * @return taishoYM
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * setTaishoYM
     *
     * @param taishoYM taishoYM
     */
    public void setTaishoYM(FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * getKyotakuServiceKubun
     *
     * @return kyotakuServiceKubun
     */
    public RString getKyotakuServiceKubun() {
        return kyotakuServiceKubun;
    }

    /**
     * setKyotakuServiceKubun
     *
     * @param kyotakuServiceKubun kyotakuServiceKubun
     */
    public void setKyotakuServiceKubun(RString kyotakuServiceKubun) {
        this.kyotakuServiceKubun = kyotakuServiceKubun;
    }

    /**
     * getServiceTeikyoJigyoshaNo
     *
     * @return serviceTeikyoJigyoshaNo
     */
    public JigyoshaNo getServiceTeikyoJigyoshaNo() {
        return serviceTeikyoJigyoshaNo;
    }

    /**
     * setServiceTeikyoJigyoshaNo
     *
     * @param serviceTeikyoJigyoshaNo serviceTeikyoJigyoshaNo
     */
    public void setServiceTeikyoJigyoshaNo(JigyoshaNo serviceTeikyoJigyoshaNo) {
        this.serviceTeikyoJigyoshaNo = serviceTeikyoJigyoshaNo;
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
     * getServiceKomokuCode
     *
     * @return serviceKomokuCode
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * setServiceKomokuCode
     *
     * @param serviceKomokuCode serviceKomokuCode
     */
    public void setServiceKomokuCode(ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
    }

    /**
     * getTaniSu
     *
     * @return taniSu
     */
    public Decimal getTaniSu() {
        return taniSu;
    }

    /**
     * setTaniSu
     *
     * @param taniSu taniSu
     */
    public void setTaniSu(Decimal taniSu) {
        this.taniSu = taniSu;
    }

    /**
     * getKaisu_Nissu
     *
     * @return kaisu_Nissu
     */
    public Decimal getKaisu_Nissu() {
        return kaisu_Nissu;
    }

    /**
     * setKaisu_Nissu
     *
     * @param kaisu_Nissu kaisu_Nissu
     */
    public void setKaisu_Nissu(Decimal kaisu_Nissu) {
        this.kaisu_Nissu = kaisu_Nissu;
    }

    /**
     * getShuruiGendoNaiTaniSu_Nissu
     *
     * @return shuruiGendoNaiTaniSu_Nissu
     */
    public Decimal getShuruiGendoNaiTaniSu_Nissu() {
        return shuruiGendoNaiTaniSu_Nissu;
    }

    /**
     * setShuruiGendoNaiTaniSu_Nissu
     *
     * @param shuruiGendoNaiTaniSu_Nissu shuruiGendoNaiTaniSu_Nissu
     */
    public void setShuruiGendoNaiTaniSu_Nissu(Decimal shuruiGendoNaiTaniSu_Nissu) {
        this.shuruiGendoNaiTaniSu_Nissu = shuruiGendoNaiTaniSu_Nissu;
    }

    /**
     * getShuruiGendoChokaTaniSu_Nissu
     *
     * @return shuruiGendoChokaTaniSu_Nissu
     */
    public Decimal getShuruiGendoChokaTaniSu_Nissu() {
        return shuruiGendoChokaTaniSu_Nissu;
    }

    /**
     * setShuruiGendoChokaTaniSu_Nissu
     *
     * @param shuruiGendoChokaTaniSu_Nissu shuruiGendoChokaTaniSu_Nissu
     */
    public void setShuruiGendoChokaTaniSu_Nissu(Decimal shuruiGendoChokaTaniSu_Nissu) {
        this.shuruiGendoChokaTaniSu_Nissu = shuruiGendoChokaTaniSu_Nissu;
    }

    /**
     * getKubunGendoNaiTaniSu_Nissu
     *
     * @return kubunGendoNaiTaniSu_Nissu
     */
    public Decimal getKubunGendoNaiTaniSu_Nissu() {
        return kubunGendoNaiTaniSu_Nissu;
    }

    /**
     * setKubunGendoNaiTaniSu_Nissu
     *
     * @param kubunGendoNaiTaniSu_Nissu kubunGendoNaiTaniSu_Nissu
     */
    public void setKubunGendoNaiTaniSu_Nissu(Decimal kubunGendoNaiTaniSu_Nissu) {
        this.kubunGendoNaiTaniSu_Nissu = kubunGendoNaiTaniSu_Nissu;
    }

    /**
     * getKubunGendoChokaTaniSu_Nissu
     *
     * @return kubunGendoChokaTaniSu_Nissu
     */
    public Decimal getKubunGendoChokaTaniSu_Nissu() {
        return kubunGendoChokaTaniSu_Nissu;
    }

    /**
     * setKubunGendoChokaTaniSu_Nissu
     *
     * @param kubunGendoChokaTaniSu_Nissu kubunGendoChokaTaniSu_Nissu
     */
    public void setKubunGendoChokaTaniSu_Nissu(Decimal kubunGendoChokaTaniSu_Nissu) {
        this.kubunGendoChokaTaniSu_Nissu = kubunGendoChokaTaniSu_Nissu;
    }

    /**
     * getTaniSuTanka
     *
     * @return taniSuTanka
     */
    public Decimal getTaniSuTanka() {
        return taniSuTanka;
    }

    /**
     * setTaniSuTanka
     *
     * @param taniSuTanka taniSuTanka
     */
    public void setTaniSuTanka(Decimal taniSuTanka) {
        this.taniSuTanka = taniSuTanka;
    }

    /**
     * getKyufuRitsu
     *
     * @return kyufuRitsu
     */
    public HokenKyufuRitsu getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * setKyufuRitsu
     *
     * @param kyufuRitsu kyufuRitsu
     */
    public void setKyufuRitsu(HokenKyufuRitsu kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * getWaribikiGoTekiyoRitsu
     *
     * @return waribikiGoTekiyoRitsu
     */
    public HokenKyufuRitsu getWaribikiGoTekiyoRitsu() {
        return waribikiGoTekiyoRitsu;
    }

    /**
     * setWaribikiGoTekiyoRitsu
     *
     * @param waribikiGoTekiyoRitsu waribikiGoTekiyoRitsu
     */
    public void setWaribikiGoTekiyoRitsu(HokenKyufuRitsu waribikiGoTekiyoRitsu) {
        this.waribikiGoTekiyoRitsu = waribikiGoTekiyoRitsu;
    }

    /**
     * getWaribikiGoTekiyoTaniSu
     *
     * @return waribikiGoTekiyoTaniSu
     */
    public Decimal getWaribikiGoTekiyoTaniSu() {
        return waribikiGoTekiyoTaniSu;
    }

    /**
     * setWaribikiGoTekiyoTaniSu
     *
     * @param waribikiGoTekiyoTaniSu waribikiGoTekiyoTaniSu
     */
    public void setWaribikiGoTekiyoTaniSu(Decimal waribikiGoTekiyoTaniSu) {
        this.waribikiGoTekiyoTaniSu = waribikiGoTekiyoTaniSu;
    }

    /**
     * getTeigakuRiyoshaFutanTankaKingaku
     *
     * @return teigakuRiyoshaFutanTankaKingaku
     */
    public Decimal getTeigakuRiyoshaFutanTankaKingaku() {
        return teigakuRiyoshaFutanTankaKingaku;
    }

    /**
     * setTeigakuRiyoshaFutanTankaKingaku
     *
     * @param teigakuRiyoshaFutanTankaKingaku teigakuRiyoshaFutanTankaKingaku
     */
    public void setTeigakuRiyoshaFutanTankaKingaku(Decimal teigakuRiyoshaFutanTankaKingaku) {
        this.teigakuRiyoshaFutanTankaKingaku = teigakuRiyoshaFutanTankaKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.taishoYM = entity.taishoYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kyotakuServiceKubun = entity.kyotakuServiceKubun;
        this.serviceTeikyoJigyoshaNo = entity.serviceTeikyoJigyoshaNo;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.taniSu = entity.taniSu;
        this.kaisu_Nissu = entity.kaisu_Nissu;
        this.shuruiGendoNaiTaniSu_Nissu = entity.shuruiGendoNaiTaniSu_Nissu;
        this.shuruiGendoChokaTaniSu_Nissu = entity.shuruiGendoChokaTaniSu_Nissu;
        this.kubunGendoNaiTaniSu_Nissu = entity.kubunGendoNaiTaniSu_Nissu;
        this.kubunGendoChokaTaniSu_Nissu = entity.kubunGendoChokaTaniSu_Nissu;
        this.taniSuTanka = entity.taniSuTanka;
        this.kyufuRitsu = entity.kyufuRitsu;
        this.waribikiGoTekiyoRitsu = entity.waribikiGoTekiyoRitsu;
        this.waribikiGoTekiyoTaniSu = entity.waribikiGoTekiyoTaniSu;
        this.teigakuRiyoshaFutanTankaKingaku = entity.teigakuRiyoshaFutanTankaKingaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shoKisaiHokenshaNo, shikibetsuCode, taishoYM, shoriTimestamp, kyotakuServiceKubun, serviceTeikyoJigyoshaNo, serviceShuruiCode, serviceKomokuCode, taniSu, kaisu_Nissu, shuruiGendoNaiTaniSu_Nissu, shuruiGendoChokaTaniSu_Nissu, kubunGendoNaiTaniSu_Nissu, kubunGendoChokaTaniSu_Nissu, taniSuTanka, kyufuRitsu, waribikiGoTekiyoRitsu, waribikiGoTekiyoTaniSu, teigakuRiyoshaFutanTankaKingaku);
    }

// </editor-fold>
}
