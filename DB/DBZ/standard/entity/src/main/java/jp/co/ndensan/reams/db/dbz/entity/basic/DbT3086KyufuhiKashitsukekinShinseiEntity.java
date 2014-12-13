package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3086KyufuhiKashitsukekinShinseiの項目定義クラスです
 *
 */
public class DbT3086KyufuhiKashitsukekinShinseiEntity extends DbTableEntityBase<DbT3086KyufuhiKashitsukekinShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3086KyufuhiKashitsukekinShinsei");

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
    private FlexibleDate kariireShinseiYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private YubinNo shinseishaYubinNo;
    private RString shinseishaJusho;
    private AtenaKanaMeisho shinseishaShimeiKana;
    private AtenaMeisho shinseishaShimei;
    private TelNo shinseishaTelNo;
    private RString shinseishaKankei;
    private FlexibleDate kariireRiyoKaishiYMD;
    private FlexibleDate kariireRiyoShuryoYMD;
    private RString kashitsuke_KogakuUmu;
    private RString kashitsuke_JutakuKaishuUmu;
    private RString kahitsuke_YoguKonyuUmu;
    private RString kashitsuke_TokureiServiceUmu;
    private AtenaKanaMeisho hoshonin_ShimeiKana;
    private AtenaMeisho hoshonin_Shimei;
    private FlexibleDate hoshonin_UmareYMD;
    private Code hoshinin_SeibetsuCd;
    private YubinNo hoshonin_YubinNo;
    private RString hoshonin_Jusho;
    private TelNo hoshonin_TelNo;
    private RString kariireShinseishaKankei;
    private AtenaMeisho hoshonin_KinmusakiMeisho;
    private YubinNo hoshonin_KinmusakiYubinNo;
    private RString hoshonin_KinmusakiJusho;
    private TelNo hoshonin_KinmusakiTelNo;
    private RString seikyusho_RyoshushoUmu;
    private int teishutsubutsuKanriNo;

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
     * getKariireShinseiYMD
     *
     * @return kariireShinseiYMD
     */
    public FlexibleDate getKariireShinseiYMD() {
        return kariireShinseiYMD;
    }

    /**
     * setKariireShinseiYMD
     *
     * @param kariireShinseiYMD kariireShinseiYMD
     */
    public void setKariireShinseiYMD(FlexibleDate kariireShinseiYMD) {
        this.kariireShinseiYMD = kariireShinseiYMD;
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
     * getShinseishaYubinNo
     *
     * @return shinseishaYubinNo
     */
    public YubinNo getShinseishaYubinNo() {
        return shinseishaYubinNo;
    }

    /**
     * setShinseishaYubinNo
     *
     * @param shinseishaYubinNo shinseishaYubinNo
     */
    public void setShinseishaYubinNo(YubinNo shinseishaYubinNo) {
        this.shinseishaYubinNo = shinseishaYubinNo;
    }

    /**
     * getShinseishaJusho
     *
     * @return shinseishaJusho
     */
    public RString getShinseishaJusho() {
        return shinseishaJusho;
    }

    /**
     * setShinseishaJusho
     *
     * @param shinseishaJusho shinseishaJusho
     */
    public void setShinseishaJusho(RString shinseishaJusho) {
        this.shinseishaJusho = shinseishaJusho;
    }

    /**
     * getShinseishaShimeiKana
     *
     * @return shinseishaShimeiKana
     */
    public AtenaKanaMeisho getShinseishaShimeiKana() {
        return shinseishaShimeiKana;
    }

    /**
     * setShinseishaShimeiKana
     *
     * @param shinseishaShimeiKana shinseishaShimeiKana
     */
    public void setShinseishaShimeiKana(AtenaKanaMeisho shinseishaShimeiKana) {
        this.shinseishaShimeiKana = shinseishaShimeiKana;
    }

    /**
     * getShinseishaShimei
     *
     * @return shinseishaShimei
     */
    public AtenaMeisho getShinseishaShimei() {
        return shinseishaShimei;
    }

    /**
     * setShinseishaShimei
     *
     * @param shinseishaShimei shinseishaShimei
     */
    public void setShinseishaShimei(AtenaMeisho shinseishaShimei) {
        this.shinseishaShimei = shinseishaShimei;
    }

    /**
     * getShinseishaTelNo
     *
     * @return shinseishaTelNo
     */
    public TelNo getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * setShinseishaTelNo
     *
     * @param shinseishaTelNo shinseishaTelNo
     */
    public void setShinseishaTelNo(TelNo shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * getShinseishaKankei
     *
     * @return shinseishaKankei
     */
    public RString getShinseishaKankei() {
        return shinseishaKankei;
    }

    /**
     * setShinseishaKankei
     *
     * @param shinseishaKankei shinseishaKankei
     */
    public void setShinseishaKankei(RString shinseishaKankei) {
        this.shinseishaKankei = shinseishaKankei;
    }

    /**
     * getKariireRiyoKaishiYMD
     *
     * @return kariireRiyoKaishiYMD
     */
    public FlexibleDate getKariireRiyoKaishiYMD() {
        return kariireRiyoKaishiYMD;
    }

    /**
     * setKariireRiyoKaishiYMD
     *
     * @param kariireRiyoKaishiYMD kariireRiyoKaishiYMD
     */
    public void setKariireRiyoKaishiYMD(FlexibleDate kariireRiyoKaishiYMD) {
        this.kariireRiyoKaishiYMD = kariireRiyoKaishiYMD;
    }

    /**
     * getKariireRiyoShuryoYMD
     *
     * @return kariireRiyoShuryoYMD
     */
    public FlexibleDate getKariireRiyoShuryoYMD() {
        return kariireRiyoShuryoYMD;
    }

    /**
     * setKariireRiyoShuryoYMD
     *
     * @param kariireRiyoShuryoYMD kariireRiyoShuryoYMD
     */
    public void setKariireRiyoShuryoYMD(FlexibleDate kariireRiyoShuryoYMD) {
        this.kariireRiyoShuryoYMD = kariireRiyoShuryoYMD;
    }

    /**
     * getKashitsuke_KogakuUmu
     *
     * @return kashitsuke_KogakuUmu
     */
    public RString getKashitsuke_KogakuUmu() {
        return kashitsuke_KogakuUmu;
    }

    /**
     * setKashitsuke_KogakuUmu
     *
     * @param kashitsuke_KogakuUmu kashitsuke_KogakuUmu
     */
    public void setKashitsuke_KogakuUmu(RString kashitsuke_KogakuUmu) {
        this.kashitsuke_KogakuUmu = kashitsuke_KogakuUmu;
    }

    /**
     * getKashitsuke_JutakuKaishuUmu
     *
     * @return kashitsuke_JutakuKaishuUmu
     */
    public RString getKashitsuke_JutakuKaishuUmu() {
        return kashitsuke_JutakuKaishuUmu;
    }

    /**
     * setKashitsuke_JutakuKaishuUmu
     *
     * @param kashitsuke_JutakuKaishuUmu kashitsuke_JutakuKaishuUmu
     */
    public void setKashitsuke_JutakuKaishuUmu(RString kashitsuke_JutakuKaishuUmu) {
        this.kashitsuke_JutakuKaishuUmu = kashitsuke_JutakuKaishuUmu;
    }

    /**
     * getKahitsuke_YoguKonyuUmu
     *
     * @return kahitsuke_YoguKonyuUmu
     */
    public RString getKahitsuke_YoguKonyuUmu() {
        return kahitsuke_YoguKonyuUmu;
    }

    /**
     * setKahitsuke_YoguKonyuUmu
     *
     * @param kahitsuke_YoguKonyuUmu kahitsuke_YoguKonyuUmu
     */
    public void setKahitsuke_YoguKonyuUmu(RString kahitsuke_YoguKonyuUmu) {
        this.kahitsuke_YoguKonyuUmu = kahitsuke_YoguKonyuUmu;
    }

    /**
     * getKashitsuke_TokureiServiceUmu
     *
     * @return kashitsuke_TokureiServiceUmu
     */
    public RString getKashitsuke_TokureiServiceUmu() {
        return kashitsuke_TokureiServiceUmu;
    }

    /**
     * setKashitsuke_TokureiServiceUmu
     *
     * @param kashitsuke_TokureiServiceUmu kashitsuke_TokureiServiceUmu
     */
    public void setKashitsuke_TokureiServiceUmu(RString kashitsuke_TokureiServiceUmu) {
        this.kashitsuke_TokureiServiceUmu = kashitsuke_TokureiServiceUmu;
    }

    /**
     * getHoshonin_ShimeiKana
     *
     * @return hoshonin_ShimeiKana
     */
    public AtenaKanaMeisho getHoshonin_ShimeiKana() {
        return hoshonin_ShimeiKana;
    }

    /**
     * setHoshonin_ShimeiKana
     *
     * @param hoshonin_ShimeiKana hoshonin_ShimeiKana
     */
    public void setHoshonin_ShimeiKana(AtenaKanaMeisho hoshonin_ShimeiKana) {
        this.hoshonin_ShimeiKana = hoshonin_ShimeiKana;
    }

    /**
     * getHoshonin_Shimei
     *
     * @return hoshonin_Shimei
     */
    public AtenaMeisho getHoshonin_Shimei() {
        return hoshonin_Shimei;
    }

    /**
     * setHoshonin_Shimei
     *
     * @param hoshonin_Shimei hoshonin_Shimei
     */
    public void setHoshonin_Shimei(AtenaMeisho hoshonin_Shimei) {
        this.hoshonin_Shimei = hoshonin_Shimei;
    }

    /**
     * getHoshonin_UmareYMD
     *
     * @return hoshonin_UmareYMD
     */
    public FlexibleDate getHoshonin_UmareYMD() {
        return hoshonin_UmareYMD;
    }

    /**
     * setHoshonin_UmareYMD
     *
     * @param hoshonin_UmareYMD hoshonin_UmareYMD
     */
    public void setHoshonin_UmareYMD(FlexibleDate hoshonin_UmareYMD) {
        this.hoshonin_UmareYMD = hoshonin_UmareYMD;
    }

    /**
     * getHoshinin_SeibetsuCd
     *
     * @return hoshinin_SeibetsuCd
     */
    public Code getHoshinin_SeibetsuCd() {
        return hoshinin_SeibetsuCd;
    }

    /**
     * setHoshinin_SeibetsuCd
     *
     * @param hoshinin_SeibetsuCd hoshinin_SeibetsuCd
     */
    public void setHoshinin_SeibetsuCd(Code hoshinin_SeibetsuCd) {
        this.hoshinin_SeibetsuCd = hoshinin_SeibetsuCd;
    }

    /**
     * getHoshonin_YubinNo
     *
     * @return hoshonin_YubinNo
     */
    public YubinNo getHoshonin_YubinNo() {
        return hoshonin_YubinNo;
    }

    /**
     * setHoshonin_YubinNo
     *
     * @param hoshonin_YubinNo hoshonin_YubinNo
     */
    public void setHoshonin_YubinNo(YubinNo hoshonin_YubinNo) {
        this.hoshonin_YubinNo = hoshonin_YubinNo;
    }

    /**
     * getHoshonin_Jusho
     *
     * @return hoshonin_Jusho
     */
    public RString getHoshonin_Jusho() {
        return hoshonin_Jusho;
    }

    /**
     * setHoshonin_Jusho
     *
     * @param hoshonin_Jusho hoshonin_Jusho
     */
    public void setHoshonin_Jusho(RString hoshonin_Jusho) {
        this.hoshonin_Jusho = hoshonin_Jusho;
    }

    /**
     * getHoshonin_TelNo
     *
     * @return hoshonin_TelNo
     */
    public TelNo getHoshonin_TelNo() {
        return hoshonin_TelNo;
    }

    /**
     * setHoshonin_TelNo
     *
     * @param hoshonin_TelNo hoshonin_TelNo
     */
    public void setHoshonin_TelNo(TelNo hoshonin_TelNo) {
        this.hoshonin_TelNo = hoshonin_TelNo;
    }

    /**
     * getKariireShinseishaKankei
     *
     * @return kariireShinseishaKankei
     */
    public RString getKariireShinseishaKankei() {
        return kariireShinseishaKankei;
    }

    /**
     * setKariireShinseishaKankei
     *
     * @param kariireShinseishaKankei kariireShinseishaKankei
     */
    public void setKariireShinseishaKankei(RString kariireShinseishaKankei) {
        this.kariireShinseishaKankei = kariireShinseishaKankei;
    }

    /**
     * getHoshonin_KinmusakiMeisho
     *
     * @return hoshonin_KinmusakiMeisho
     */
    public AtenaMeisho getHoshonin_KinmusakiMeisho() {
        return hoshonin_KinmusakiMeisho;
    }

    /**
     * setHoshonin_KinmusakiMeisho
     *
     * @param hoshonin_KinmusakiMeisho hoshonin_KinmusakiMeisho
     */
    public void setHoshonin_KinmusakiMeisho(AtenaMeisho hoshonin_KinmusakiMeisho) {
        this.hoshonin_KinmusakiMeisho = hoshonin_KinmusakiMeisho;
    }

    /**
     * getHoshonin_KinmusakiYubinNo
     *
     * @return hoshonin_KinmusakiYubinNo
     */
    public YubinNo getHoshonin_KinmusakiYubinNo() {
        return hoshonin_KinmusakiYubinNo;
    }

    /**
     * setHoshonin_KinmusakiYubinNo
     *
     * @param hoshonin_KinmusakiYubinNo hoshonin_KinmusakiYubinNo
     */
    public void setHoshonin_KinmusakiYubinNo(YubinNo hoshonin_KinmusakiYubinNo) {
        this.hoshonin_KinmusakiYubinNo = hoshonin_KinmusakiYubinNo;
    }

    /**
     * getHoshonin_KinmusakiJusho
     *
     * @return hoshonin_KinmusakiJusho
     */
    public RString getHoshonin_KinmusakiJusho() {
        return hoshonin_KinmusakiJusho;
    }

    /**
     * setHoshonin_KinmusakiJusho
     *
     * @param hoshonin_KinmusakiJusho hoshonin_KinmusakiJusho
     */
    public void setHoshonin_KinmusakiJusho(RString hoshonin_KinmusakiJusho) {
        this.hoshonin_KinmusakiJusho = hoshonin_KinmusakiJusho;
    }

    /**
     * getHoshonin_KinmusakiTelNo
     *
     * @return hoshonin_KinmusakiTelNo
     */
    public TelNo getHoshonin_KinmusakiTelNo() {
        return hoshonin_KinmusakiTelNo;
    }

    /**
     * setHoshonin_KinmusakiTelNo
     *
     * @param hoshonin_KinmusakiTelNo hoshonin_KinmusakiTelNo
     */
    public void setHoshonin_KinmusakiTelNo(TelNo hoshonin_KinmusakiTelNo) {
        this.hoshonin_KinmusakiTelNo = hoshonin_KinmusakiTelNo;
    }

    /**
     * getSeikyusho_RyoshushoUmu
     *
     * @return seikyusho_RyoshushoUmu
     */
    public RString getSeikyusho_RyoshushoUmu() {
        return seikyusho_RyoshushoUmu;
    }

    /**
     * setSeikyusho_RyoshushoUmu
     *
     * @param seikyusho_RyoshushoUmu seikyusho_RyoshushoUmu
     */
    public void setSeikyusho_RyoshushoUmu(RString seikyusho_RyoshushoUmu) {
        this.seikyusho_RyoshushoUmu = seikyusho_RyoshushoUmu;
    }

    /**
     * getTeishutsubutsuKanriNo
     *
     * @return teishutsubutsuKanriNo
     */
    public int getTeishutsubutsuKanriNo() {
        return teishutsubutsuKanriNo;
    }

    /**
     * setTeishutsubutsuKanriNo
     *
     * @param teishutsubutsuKanriNo teishutsubutsuKanriNo
     */
    public void setTeishutsubutsuKanriNo(int teishutsubutsuKanriNo) {
        this.teishutsubutsuKanriNo = teishutsubutsuKanriNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3086KyufuhiKashitsukekinShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3086KyufuhiKashitsukekinShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3086KyufuhiKashitsukekinShinseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kariireShinseiYMD, other.kariireShinseiYMD)) {
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
    public void shallowCopy(DbT3086KyufuhiKashitsukekinShinseiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kariireShinseiYMD = entity.kariireShinseiYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shinseishaYubinNo = entity.shinseishaYubinNo;
        this.shinseishaJusho = entity.shinseishaJusho;
        this.shinseishaShimeiKana = entity.shinseishaShimeiKana;
        this.shinseishaShimei = entity.shinseishaShimei;
        this.shinseishaTelNo = entity.shinseishaTelNo;
        this.shinseishaKankei = entity.shinseishaKankei;
        this.kariireRiyoKaishiYMD = entity.kariireRiyoKaishiYMD;
        this.kariireRiyoShuryoYMD = entity.kariireRiyoShuryoYMD;
        this.kashitsuke_KogakuUmu = entity.kashitsuke_KogakuUmu;
        this.kashitsuke_JutakuKaishuUmu = entity.kashitsuke_JutakuKaishuUmu;
        this.kahitsuke_YoguKonyuUmu = entity.kahitsuke_YoguKonyuUmu;
        this.kashitsuke_TokureiServiceUmu = entity.kashitsuke_TokureiServiceUmu;
        this.hoshonin_ShimeiKana = entity.hoshonin_ShimeiKana;
        this.hoshonin_Shimei = entity.hoshonin_Shimei;
        this.hoshonin_UmareYMD = entity.hoshonin_UmareYMD;
        this.hoshinin_SeibetsuCd = entity.hoshinin_SeibetsuCd;
        this.hoshonin_YubinNo = entity.hoshonin_YubinNo;
        this.hoshonin_Jusho = entity.hoshonin_Jusho;
        this.hoshonin_TelNo = entity.hoshonin_TelNo;
        this.kariireShinseishaKankei = entity.kariireShinseishaKankei;
        this.hoshonin_KinmusakiMeisho = entity.hoshonin_KinmusakiMeisho;
        this.hoshonin_KinmusakiYubinNo = entity.hoshonin_KinmusakiYubinNo;
        this.hoshonin_KinmusakiJusho = entity.hoshonin_KinmusakiJusho;
        this.hoshonin_KinmusakiTelNo = entity.hoshonin_KinmusakiTelNo;
        this.seikyusho_RyoshushoUmu = entity.seikyusho_RyoshushoUmu;
        this.teishutsubutsuKanriNo = entity.teishutsubutsuKanriNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kariireShinseiYMD, shoriTimestamp, shinseishaYubinNo, shinseishaJusho, shinseishaShimeiKana, shinseishaShimei, shinseishaTelNo, shinseishaKankei, kariireRiyoKaishiYMD, kariireRiyoShuryoYMD, kashitsuke_KogakuUmu, kashitsuke_JutakuKaishuUmu, kahitsuke_YoguKonyuUmu, kashitsuke_TokureiServiceUmu, hoshonin_ShimeiKana, hoshonin_Shimei, hoshonin_UmareYMD, hoshinin_SeibetsuCd, hoshonin_YubinNo, hoshonin_Jusho, hoshonin_TelNo, kariireShinseishaKankei, hoshonin_KinmusakiMeisho, hoshonin_KinmusakiYubinNo, hoshonin_KinmusakiJusho, hoshonin_KinmusakiTelNo, seikyusho_RyoshushoUmu, teishutsubutsuKanriNo);
    }

// </editor-fold>
}
