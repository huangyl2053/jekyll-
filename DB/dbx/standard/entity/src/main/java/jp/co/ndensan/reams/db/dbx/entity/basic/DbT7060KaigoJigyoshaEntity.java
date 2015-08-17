package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.HojinsShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShiteiKijunGaitoJigyoshoKubun;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT7060KaigoJigyoshaの項目定義クラスです
 *
 */
@OnNextSchema("rgdb")
public class DbT7060KaigoJigyoshaEntity extends DbTableEntityBase<DbT7060KaigoJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7060KaigoJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KaigoJigyoshaNo jigyoshaNo;
    @PrimaryKey
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private FlexibleDate idoYMD;
    private RString idoJiyuCode;
    private FlexibleDate jigyoKaishiYMD;
    private FlexibleDate jigyoKyushiYMD;
    private FlexibleDate jigyoSaikaiYMD;
    private FlexibleDate jigyoHaishiYMD;
    private AtenaMeisho jigyoshaName;
    private AtenaKanaMeisho jigyoshaNameKana;
    private YubinNo yubinNo;
    private AtenaJusho jigyoshaAddress;
    private RString jigyoshaKanaAddress;
    private TelNo telNo;
    private TelNo faxNo;
    private RString atesakiBusho;
    private AtenaMeisho atesakininName;
    private AtenaKanaMeisho atesakininNamekana;
    private KinyuKikanCode ginkoCode;
    private KinyuKikanShitenCode shitenCode;
    private RString kozaShubetsu;
    private RString kozaNo;
    private AtenaMeisho kozaMeiginin;
    private AtenaKanaMeisho kozaMeigininKana;
    private ShiteiKijunGaitoJigyoshoKubun shiteiKijungaitoJigyoshaKubun;
    private RString shozaiShichoson;
    private RString serviceJisshiChiiki;
    private HojinsShubetsu hojinShubetsu;
    private int bedSu;
    private int shozokuNinzu;
    private int riyoshaSu;
    private RString biko;

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
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(KaigoJigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getYukoKaishiYMD
     *
     * @return yukoKaishiYMD
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * setYukoKaishiYMD
     *
     * @param yukoKaishiYMD yukoKaishiYMD
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * getYukoShuryoYMD
     *
     * @return yukoShuryoYMD
     */
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * setYukoShuryoYMD
     *
     * @param yukoShuryoYMD yukoShuryoYMD
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
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
     * getIdoJiyuCode
     *
     * @return idoJiyuCode
     */
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * setIdoJiyuCode
     *
     * @param idoJiyuCode idoJiyuCode
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * getJigyoKaishiYMD
     *
     * @return jigyoKaishiYMD
     */
    public FlexibleDate getJigyoKaishiYMD() {
        return jigyoKaishiYMD;
    }

    /**
     * setJigyoKaishiYMD
     *
     * @param jigyoKaishiYMD jigyoKaishiYMD
     */
    public void setJigyoKaishiYMD(FlexibleDate jigyoKaishiYMD) {
        this.jigyoKaishiYMD = jigyoKaishiYMD;
    }

    /**
     * getJigyoKyushiYMD
     *
     * @return jigyoKyushiYMD
     */
    public FlexibleDate getJigyoKyushiYMD() {
        return jigyoKyushiYMD;
    }

    /**
     * setJigyoKyushiYMD
     *
     * @param jigyoKyushiYMD jigyoKyushiYMD
     */
    public void setJigyoKyushiYMD(FlexibleDate jigyoKyushiYMD) {
        this.jigyoKyushiYMD = jigyoKyushiYMD;
    }

    /**
     * getJigyoSaikaiYMD
     *
     * @return jigyoSaikaiYMD
     */
    public FlexibleDate getJigyoSaikaiYMD() {
        return jigyoSaikaiYMD;
    }

    /**
     * setJigyoSaikaiYMD
     *
     * @param jigyoSaikaiYMD jigyoSaikaiYMD
     */
    public void setJigyoSaikaiYMD(FlexibleDate jigyoSaikaiYMD) {
        this.jigyoSaikaiYMD = jigyoSaikaiYMD;
    }

    /**
     * getJigyoHaishiYMD
     *
     * @return jigyoHaishiYMD
     */
    public FlexibleDate getJigyoHaishiYMD() {
        return jigyoHaishiYMD;
    }

    /**
     * setJigyoHaishiYMD
     *
     * @param jigyoHaishiYMD jigyoHaishiYMD
     */
    public void setJigyoHaishiYMD(FlexibleDate jigyoHaishiYMD) {
        this.jigyoHaishiYMD = jigyoHaishiYMD;
    }

    /**
     * getJigyoshaName
     *
     * @return jigyoshaName
     */
    public AtenaMeisho getJigyoshaName() {
        return jigyoshaName;
    }

    /**
     * setJigyoshaName
     *
     * @param jigyoshaName jigyoshaName
     */
    public void setJigyoshaName(AtenaMeisho jigyoshaName) {
        this.jigyoshaName = jigyoshaName;
    }

    /**
     * getJigyoshaNameKana
     *
     * @return jigyoshaNameKana
     */
    public AtenaKanaMeisho getJigyoshaNameKana() {
        return jigyoshaNameKana;
    }

    /**
     * setJigyoshaNameKana
     *
     * @param jigyoshaNameKana jigyoshaNameKana
     */
    public void setJigyoshaNameKana(AtenaKanaMeisho jigyoshaNameKana) {
        this.jigyoshaNameKana = jigyoshaNameKana;
    }

    /**
     * getYubinNo
     *
     * @return yubinNo
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * setYubinNo
     *
     * @param yubinNo yubinNo
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * getJigyoshaAddress
     *
     * @return jigyoshaAddress
     */
    public AtenaJusho getJigyoshaAddress() {
        return jigyoshaAddress;
    }

    /**
     * setJigyoshaAddress
     *
     * @param jigyoshaAddress jigyoshaAddress
     */
    public void setJigyoshaAddress(AtenaJusho jigyoshaAddress) {
        this.jigyoshaAddress = jigyoshaAddress;
    }

    /**
     * getJigyoshaKanaAddress
     *
     * @return jigyoshaKanaAddress
     */
    public RString getJigyoshaKanaAddress() {
        return jigyoshaKanaAddress;
    }

    /**
     * setJigyoshaKanaAddress
     *
     * @param jigyoshaKanaAddress jigyoshaKanaAddress
     */
    public void setJigyoshaKanaAddress(RString jigyoshaKanaAddress) {
        this.jigyoshaKanaAddress = jigyoshaKanaAddress;
    }

    /**
     * getTelNo
     *
     * @return telNo
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * setTelNo
     *
     * @param telNo telNo
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * getFaxNo
     *
     * @return faxNo
     */
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * setFaxNo
     *
     * @param faxNo faxNo
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * getAtesakiBusho
     *
     * @return atesakiBusho
     */
    public RString getAtesakiBusho() {
        return atesakiBusho;
    }

    /**
     * setAtesakiBusho
     *
     * @param atesakiBusho atesakiBusho
     */
    public void setAtesakiBusho(RString atesakiBusho) {
        this.atesakiBusho = atesakiBusho;
    }

    /**
     * getAtesakininName
     *
     * @return atesakininName
     */
    public AtenaMeisho getAtesakininName() {
        return atesakininName;
    }

    /**
     * setAtesakininName
     *
     * @param atesakininName atesakininName
     */
    public void setAtesakininName(AtenaMeisho atesakininName) {
        this.atesakininName = atesakininName;
    }

    /**
     * getAtesakininNamekana
     *
     * @return atesakininNamekana
     */
    public AtenaKanaMeisho getAtesakininNamekana() {
        return atesakininNamekana;
    }

    /**
     * setAtesakininNamekana
     *
     * @param atesakininNamekana atesakininNamekana
     */
    public void setAtesakininNamekana(AtenaKanaMeisho atesakininNamekana) {
        this.atesakininNamekana = atesakininNamekana;
    }

    /**
     * getGinkoCode
     *
     * @return ginkoCode
     */
    public KinyuKikanCode getGinkoCode() {
        return ginkoCode;
    }

    /**
     * setGinkoCode
     *
     * @param ginkoCode ginkoCode
     */
    public void setGinkoCode(KinyuKikanCode ginkoCode) {
        this.ginkoCode = ginkoCode;
    }

    /**
     * getShitenCode
     *
     * @return shitenCode
     */
    public KinyuKikanShitenCode getShitenCode() {
        return shitenCode;
    }

    /**
     * setShitenCode
     *
     * @param shitenCode shitenCode
     */
    public void setShitenCode(KinyuKikanShitenCode shitenCode) {
        this.shitenCode = shitenCode;
    }

    /**
     * getKozaShubetsu
     *
     * @return kozaShubetsu
     */
    public RString getKozaShubetsu() {
        return kozaShubetsu;
    }

    /**
     * setKozaShubetsu
     *
     * @param kozaShubetsu kozaShubetsu
     */
    public void setKozaShubetsu(RString kozaShubetsu) {
        this.kozaShubetsu = kozaShubetsu;
    }

    /**
     * getKozaNo
     *
     * @return kozaNo
     */
    public RString getKozaNo() {
        return kozaNo;
    }

    /**
     * setKozaNo
     *
     * @param kozaNo kozaNo
     */
    public void setKozaNo(RString kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * getKozaMeiginin
     *
     * @return kozaMeiginin
     */
    public AtenaMeisho getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * setKozaMeiginin
     *
     * @param kozaMeiginin kozaMeiginin
     */
    public void setKozaMeiginin(AtenaMeisho kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * getKozaMeigininKana
     *
     * @return kozaMeigininKana
     */
    public AtenaKanaMeisho getKozaMeigininKana() {
        return kozaMeigininKana;
    }

    /**
     * setKozaMeigininKana
     *
     * @param kozaMeigininKana kozaMeigininKana
     */
    public void setKozaMeigininKana(AtenaKanaMeisho kozaMeigininKana) {
        this.kozaMeigininKana = kozaMeigininKana;
    }

    /**
     * getShiteiKijungaitoJigyoshaKubun
     *
     * @return shiteiKijungaitoJigyoshaKubun
     */
    public ShiteiKijunGaitoJigyoshoKubun getShiteiKijungaitoJigyoshaKubun() {
        return shiteiKijungaitoJigyoshaKubun;
    }

    /**
     * setShiteiKijungaitoJigyoshaKubun
     *
     * @param shiteiKijungaitoJigyoshaKubun shiteiKijungaitoJigyoshaKubun
     */
    public void setShiteiKijungaitoJigyoshaKubun(ShiteiKijunGaitoJigyoshoKubun shiteiKijungaitoJigyoshaKubun) {
        this.shiteiKijungaitoJigyoshaKubun = shiteiKijungaitoJigyoshaKubun;
    }

    /**
     * getShozaiShichoson
     *
     * @return shozaiShichoson
     */
    public RString getShozaiShichoson() {
        return shozaiShichoson;
    }

    /**
     * setShozaiShichoson
     *
     * @param shozaiShichoson shozaiShichoson
     */
    public void setShozaiShichoson(RString shozaiShichoson) {
        this.shozaiShichoson = shozaiShichoson;
    }

    /**
     * getServiceJisshiChiiki
     *
     * @return serviceJisshiChiiki
     */
    public RString getServiceJisshiChiiki() {
        return serviceJisshiChiiki;
    }

    /**
     * setServiceJisshiChiiki
     *
     * @param serviceJisshiChiiki serviceJisshiChiiki
     */
    public void setServiceJisshiChiiki(RString serviceJisshiChiiki) {
        this.serviceJisshiChiiki = serviceJisshiChiiki;
    }

    /**
     * getHojinShubetsu
     *
     * @return hojinShubetsu
     */
    public HojinsShubetsu getHojinShubetsu() {
        return hojinShubetsu;
    }

    /**
     * setHojinShubetsu
     *
     * @param hojinShubetsu hojinShubetsu
     */
    public void setHojinShubetsu(HojinsShubetsu hojinShubetsu) {
        this.hojinShubetsu = hojinShubetsu;
    }

    /**
     * getBedSu
     *
     * @return bedSu
     */
    public int getBedSu() {
        return bedSu;
    }

    /**
     * setBedSu
     *
     * @param bedSu bedSu
     */
    public void setBedSu(int bedSu) {
        this.bedSu = bedSu;
    }

    /**
     * getShozokuNinzu
     *
     * @return shozokuNinzu
     */
    public int getShozokuNinzu() {
        return shozokuNinzu;
    }

    /**
     * setShozokuNinzu
     *
     * @param shozokuNinzu shozokuNinzu
     */
    public void setShozokuNinzu(int shozokuNinzu) {
        this.shozokuNinzu = shozokuNinzu;
    }

    /**
     * getRiyoshaSu
     *
     * @return riyoshaSu
     */
    public int getRiyoshaSu() {
        return riyoshaSu;
    }

    /**
     * setRiyoshaSu
     *
     * @param riyoshaSu riyoshaSu
     */
    public void setRiyoshaSu(int riyoshaSu) {
        this.riyoshaSu = riyoshaSu;
    }

    /**
     * getBiko
     *
     * @return biko
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * setBiko
     *
     * @param biko biko
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal UrT0518KaigoJigyoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal UrT0518KaigoJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7060KaigoJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yukoKaishiYMD, other.yukoKaishiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity DbT7060KaigoJigyoshaEntity
     */
    @Override
    public void shallowCopy(DbT7060KaigoJigyoshaEntity entity) {
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.yukoShuryoYMD = entity.yukoShuryoYMD;
        this.idoYMD = entity.idoYMD;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.jigyoKaishiYMD = entity.jigyoKaishiYMD;
        this.jigyoKyushiYMD = entity.jigyoKyushiYMD;
        this.jigyoSaikaiYMD = entity.jigyoSaikaiYMD;
        this.jigyoHaishiYMD = entity.jigyoHaishiYMD;
        this.jigyoshaName = entity.jigyoshaName;
        this.jigyoshaNameKana = entity.jigyoshaNameKana;
        this.yubinNo = entity.yubinNo;
        this.jigyoshaAddress = entity.jigyoshaAddress;
        this.jigyoshaKanaAddress = entity.jigyoshaKanaAddress;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.atesakiBusho = entity.atesakiBusho;
        this.atesakininName = entity.atesakininName;
        this.atesakininNamekana = entity.atesakininNamekana;
        this.ginkoCode = entity.ginkoCode;
        this.shitenCode = entity.shitenCode;
        this.kozaShubetsu = entity.kozaShubetsu;
        this.kozaNo = entity.kozaNo;
        this.kozaMeiginin = entity.kozaMeiginin;
        this.kozaMeigininKana = entity.kozaMeigininKana;
        this.shiteiKijungaitoJigyoshaKubun = entity.shiteiKijungaitoJigyoshaKubun;
        this.shozaiShichoson = entity.shozaiShichoson;
        this.serviceJisshiChiiki = entity.serviceJisshiChiiki;
        this.hojinShubetsu = entity.hojinShubetsu;
        this.bedSu = entity.bedSu;
        this.shozokuNinzu = entity.shozokuNinzu;
        this.riyoshaSu = entity.riyoshaSu;
        this.biko = entity.biko;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaNo, yukoKaishiYMD, yukoShuryoYMD, idoYMD, idoJiyuCode, jigyoKaishiYMD, jigyoKyushiYMD, jigyoSaikaiYMD, jigyoHaishiYMD, jigyoshaName, jigyoshaNameKana, yubinNo, jigyoshaAddress, jigyoshaKanaAddress, telNo, faxNo, atesakiBusho, atesakininName, atesakininNamekana, ginkoCode, shitenCode, kozaShubetsu, kozaNo, kozaMeiginin, kozaMeigininKana, shiteiKijungaitoJigyoshaKubun, shozaiShichoson, serviceJisshiChiiki, hojinShubetsu, bedSu, shozokuNinzu, riyoshaSu, biko);
    }

// </editor-fold>
}
