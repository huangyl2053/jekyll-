package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金申請テーブルのエンティティクラスです。
 */
public class DbT3086KyufuhiKashitsukekinShinseiEntity extends DbTableEntityBase<DbT3086KyufuhiKashitsukekinShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
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
    private Decimal teishutsubutsuKanriNo;

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
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 借入申請年月日のgetメソッドです。
     *
     * @return 借入申請年月日
     */
    public FlexibleDate getKariireShinseiYMD() {
        return kariireShinseiYMD;
    }

    /**
     * 借入申請年月日のsetメソッドです。
     *
     * @param kariireShinseiYMD 借入申請年月日
     */
    public void setKariireShinseiYMD(FlexibleDate kariireShinseiYMD) {
        this.kariireShinseiYMD = kariireShinseiYMD;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 申請者郵便番号のgetメソッドです。
     *
     * @return 申請者郵便番号
     */
    public YubinNo getShinseishaYubinNo() {
        return shinseishaYubinNo;
    }

    /**
     * 申請者郵便番号のsetメソッドです。
     *
     * @param shinseishaYubinNo 申請者郵便番号
     */
    public void setShinseishaYubinNo(YubinNo shinseishaYubinNo) {
        this.shinseishaYubinNo = shinseishaYubinNo;
    }

    /**
     * 申請者住所のgetメソッドです。
     *
     * @return 申請者住所
     */
    public RString getShinseishaJusho() {
        return shinseishaJusho;
    }

    /**
     * 申請者住所のsetメソッドです。
     *
     * @param shinseishaJusho 申請者住所
     */
    public void setShinseishaJusho(RString shinseishaJusho) {
        this.shinseishaJusho = shinseishaJusho;
    }

    /**
     * 申請者氏名カナのgetメソッドです。
     *
     * @return 申請者氏名カナ
     */
    public AtenaKanaMeisho getShinseishaShimeiKana() {
        return shinseishaShimeiKana;
    }

    /**
     * 申請者氏名カナのsetメソッドです。
     *
     * @param shinseishaShimeiKana 申請者氏名カナ
     */
    public void setShinseishaShimeiKana(AtenaKanaMeisho shinseishaShimeiKana) {
        this.shinseishaShimeiKana = shinseishaShimeiKana;
    }

    /**
     * 申請者氏名のgetメソッドです。
     *
     * @return 申請者氏名
     */
    public AtenaMeisho getShinseishaShimei() {
        return shinseishaShimei;
    }

    /**
     * 申請者氏名のsetメソッドです。
     *
     * @param shinseishaShimei 申請者氏名
     */
    public void setShinseishaShimei(AtenaMeisho shinseishaShimei) {
        this.shinseishaShimei = shinseishaShimei;
    }

    /**
     * 申請者電話番号のgetメソッドです。
     *
     * @return 申請者電話番号
     */
    public TelNo getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * 申請者電話番号のsetメソッドです。
     *
     * @param shinseishaTelNo 申請者電話番号
     */
    public void setShinseishaTelNo(TelNo shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * 申請者との関係のgetメソッドです。
     * <br/>
     * <br/>被保険者からの申請者との関係
     *
     * @return 申請者との関係
     */
    public RString getShinseishaKankei() {
        return shinseishaKankei;
    }

    /**
     * 申請者との関係のsetメソッドです。
     * <br/>
     * <br/>被保険者からの申請者との関係
     *
     * @param shinseishaKankei 申請者との関係
     */
    public void setShinseishaKankei(RString shinseishaKankei) {
        this.shinseishaKankei = shinseishaKankei;
    }

    /**
     * 借入利用期間開始年月日のgetメソッドです。
     *
     * @return 借入利用期間開始年月日
     */
    public FlexibleDate getKariireRiyoKaishiYMD() {
        return kariireRiyoKaishiYMD;
    }

    /**
     * 借入利用期間開始年月日のsetメソッドです。
     *
     * @param kariireRiyoKaishiYMD 借入利用期間開始年月日
     */
    public void setKariireRiyoKaishiYMD(FlexibleDate kariireRiyoKaishiYMD) {
        this.kariireRiyoKaishiYMD = kariireRiyoKaishiYMD;
    }

    /**
     * 借入利用期間終了年月日のgetメソッドです。
     *
     * @return 借入利用期間終了年月日
     */
    public FlexibleDate getKariireRiyoShuryoYMD() {
        return kariireRiyoShuryoYMD;
    }

    /**
     * 借入利用期間終了年月日のsetメソッドです。
     *
     * @param kariireRiyoShuryoYMD 借入利用期間終了年月日
     */
    public void setKariireRiyoShuryoYMD(FlexibleDate kariireRiyoShuryoYMD) {
        this.kariireRiyoShuryoYMD = kariireRiyoShuryoYMD;
    }

    /**
     * 貸付対象・高額介護サービス費等有無のgetメソッドです。
     *
     * @return 貸付対象・高額介護サービス費等有無
     */
    public RString getKashitsuke_KogakuUmu() {
        return kashitsuke_KogakuUmu;
    }

    /**
     * 貸付対象・高額介護サービス費等有無のsetメソッドです。
     *
     * @param kashitsuke_KogakuUmu 貸付対象・高額介護サービス費等有無
     */
    public void setKashitsuke_KogakuUmu(RString kashitsuke_KogakuUmu) {
        this.kashitsuke_KogakuUmu = kashitsuke_KogakuUmu;
    }

    /**
     * 貸付対象・住宅改修費等有無のgetメソッドです。
     *
     * @return 貸付対象・住宅改修費等有無
     */
    public RString getKashitsuke_JutakuKaishuUmu() {
        return kashitsuke_JutakuKaishuUmu;
    }

    /**
     * 貸付対象・住宅改修費等有無のsetメソッドです。
     *
     * @param kashitsuke_JutakuKaishuUmu 貸付対象・住宅改修費等有無
     */
    public void setKashitsuke_JutakuKaishuUmu(RString kashitsuke_JutakuKaishuUmu) {
        this.kashitsuke_JutakuKaishuUmu = kashitsuke_JutakuKaishuUmu;
    }

    /**
     * 貸付対象・福祉用具購入費等有無のgetメソッドです。
     *
     * @return 貸付対象・福祉用具購入費等有無
     */
    public RString getKahitsuke_YoguKonyuUmu() {
        return kahitsuke_YoguKonyuUmu;
    }

    /**
     * 貸付対象・福祉用具購入費等有無のsetメソッドです。
     *
     * @param kahitsuke_YoguKonyuUmu 貸付対象・福祉用具購入費等有無
     */
    public void setKahitsuke_YoguKonyuUmu(RString kahitsuke_YoguKonyuUmu) {
        this.kahitsuke_YoguKonyuUmu = kahitsuke_YoguKonyuUmu;
    }

    /**
     * 貸付対象・特例介護サービス費等有無のgetメソッドです。
     *
     * @return 貸付対象・特例介護サービス費等有無
     */
    public RString getKashitsuke_TokureiServiceUmu() {
        return kashitsuke_TokureiServiceUmu;
    }

    /**
     * 貸付対象・特例介護サービス費等有無のsetメソッドです。
     *
     * @param kashitsuke_TokureiServiceUmu 貸付対象・特例介護サービス費等有無
     */
    public void setKashitsuke_TokureiServiceUmu(RString kashitsuke_TokureiServiceUmu) {
        this.kashitsuke_TokureiServiceUmu = kashitsuke_TokureiServiceUmu;
    }

    /**
     * 保証人氏名カナのgetメソッドです。
     *
     * @return 保証人氏名カナ
     */
    public AtenaKanaMeisho getHoshonin_ShimeiKana() {
        return hoshonin_ShimeiKana;
    }

    /**
     * 保証人氏名カナのsetメソッドです。
     *
     * @param hoshonin_ShimeiKana 保証人氏名カナ
     */
    public void setHoshonin_ShimeiKana(AtenaKanaMeisho hoshonin_ShimeiKana) {
        this.hoshonin_ShimeiKana = hoshonin_ShimeiKana;
    }

    /**
     * 保証人氏名のgetメソッドです。
     *
     * @return 保証人氏名
     */
    public AtenaMeisho getHoshonin_Shimei() {
        return hoshonin_Shimei;
    }

    /**
     * 保証人氏名のsetメソッドです。
     *
     * @param hoshonin_Shimei 保証人氏名
     */
    public void setHoshonin_Shimei(AtenaMeisho hoshonin_Shimei) {
        this.hoshonin_Shimei = hoshonin_Shimei;
    }

    /**
     * 保証人生年月日のgetメソッドです。
     *
     * @return 保証人生年月日
     */
    public FlexibleDate getHoshonin_UmareYMD() {
        return hoshonin_UmareYMD;
    }

    /**
     * 保証人生年月日のsetメソッドです。
     *
     * @param hoshonin_UmareYMD 保証人生年月日
     */
    public void setHoshonin_UmareYMD(FlexibleDate hoshonin_UmareYMD) {
        this.hoshonin_UmareYMD = hoshonin_UmareYMD;
    }

    /**
     * 保証人性別のgetメソッドです。
     *
     * @return 保証人性別
     */
    public Code getHoshinin_SeibetsuCd() {
        return hoshinin_SeibetsuCd;
    }

    /**
     * 保証人性別のsetメソッドです。
     *
     * @param hoshinin_SeibetsuCd 保証人性別
     */
    public void setHoshinin_SeibetsuCd(Code hoshinin_SeibetsuCd) {
        this.hoshinin_SeibetsuCd = hoshinin_SeibetsuCd;
    }

    /**
     * 保証人郵便番号のgetメソッドです。
     *
     * @return 保証人郵便番号
     */
    public YubinNo getHoshonin_YubinNo() {
        return hoshonin_YubinNo;
    }

    /**
     * 保証人郵便番号のsetメソッドです。
     *
     * @param hoshonin_YubinNo 保証人郵便番号
     */
    public void setHoshonin_YubinNo(YubinNo hoshonin_YubinNo) {
        this.hoshonin_YubinNo = hoshonin_YubinNo;
    }

    /**
     * 保証人住所のgetメソッドです。
     *
     * @return 保証人住所
     */
    public RString getHoshonin_Jusho() {
        return hoshonin_Jusho;
    }

    /**
     * 保証人住所のsetメソッドです。
     *
     * @param hoshonin_Jusho 保証人住所
     */
    public void setHoshonin_Jusho(RString hoshonin_Jusho) {
        this.hoshonin_Jusho = hoshonin_Jusho;
    }

    /**
     * 保証人電話番号のgetメソッドです。
     *
     * @return 保証人電話番号
     */
    public TelNo getHoshonin_TelNo() {
        return hoshonin_TelNo;
    }

    /**
     * 保証人電話番号のsetメソッドです。
     *
     * @param hoshonin_TelNo 保証人電話番号
     */
    public void setHoshonin_TelNo(TelNo hoshonin_TelNo) {
        this.hoshonin_TelNo = hoshonin_TelNo;
    }

    /**
     * 借入申請者との関係のgetメソッドです。
     * <br/>
     * <br/>保証人からの申請者との関係
     *
     * @return 借入申請者との関係
     */
    public RString getKariireShinseishaKankei() {
        return kariireShinseishaKankei;
    }

    /**
     * 借入申請者との関係のsetメソッドです。
     * <br/>
     * <br/>保証人からの申請者との関係
     *
     * @param kariireShinseishaKankei 借入申請者との関係
     */
    public void setKariireShinseishaKankei(RString kariireShinseishaKankei) {
        this.kariireShinseishaKankei = kariireShinseishaKankei;
    }

    /**
     * 保証人勤務先名称のgetメソッドです。
     *
     * @return 保証人勤務先名称
     */
    public AtenaMeisho getHoshonin_KinmusakiMeisho() {
        return hoshonin_KinmusakiMeisho;
    }

    /**
     * 保証人勤務先名称のsetメソッドです。
     *
     * @param hoshonin_KinmusakiMeisho 保証人勤務先名称
     */
    public void setHoshonin_KinmusakiMeisho(AtenaMeisho hoshonin_KinmusakiMeisho) {
        this.hoshonin_KinmusakiMeisho = hoshonin_KinmusakiMeisho;
    }

    /**
     * 保証人勤務先郵便番号のgetメソッドです。
     *
     * @return 保証人勤務先郵便番号
     */
    public YubinNo getHoshonin_KinmusakiYubinNo() {
        return hoshonin_KinmusakiYubinNo;
    }

    /**
     * 保証人勤務先郵便番号のsetメソッドです。
     *
     * @param hoshonin_KinmusakiYubinNo 保証人勤務先郵便番号
     */
    public void setHoshonin_KinmusakiYubinNo(YubinNo hoshonin_KinmusakiYubinNo) {
        this.hoshonin_KinmusakiYubinNo = hoshonin_KinmusakiYubinNo;
    }

    /**
     * 保証人勤務先所在地のgetメソッドです。
     *
     * @return 保証人勤務先所在地
     */
    public RString getHoshonin_KinmusakiJusho() {
        return hoshonin_KinmusakiJusho;
    }

    /**
     * 保証人勤務先所在地のsetメソッドです。
     *
     * @param hoshonin_KinmusakiJusho 保証人勤務先所在地
     */
    public void setHoshonin_KinmusakiJusho(RString hoshonin_KinmusakiJusho) {
        this.hoshonin_KinmusakiJusho = hoshonin_KinmusakiJusho;
    }

    /**
     * 保証人勤務先電話番号のgetメソッドです。
     *
     * @return 保証人勤務先電話番号
     */
    public TelNo getHoshonin_KinmusakiTelNo() {
        return hoshonin_KinmusakiTelNo;
    }

    /**
     * 保証人勤務先電話番号のsetメソッドです。
     *
     * @param hoshonin_KinmusakiTelNo 保証人勤務先電話番号
     */
    public void setHoshonin_KinmusakiTelNo(TelNo hoshonin_KinmusakiTelNo) {
        this.hoshonin_KinmusakiTelNo = hoshonin_KinmusakiTelNo;
    }

    /**
     * 請求書・領収書の有無のgetメソッドです。
     *
     * @return 請求書・領収書の有無
     */
    public RString getSeikyusho_RyoshushoUmu() {
        return seikyusho_RyoshushoUmu;
    }

    /**
     * 請求書・領収書の有無のsetメソッドです。
     *
     * @param seikyusho_RyoshushoUmu 請求書・領収書の有無
     */
    public void setSeikyusho_RyoshushoUmu(RString seikyusho_RyoshushoUmu) {
        this.seikyusho_RyoshushoUmu = seikyusho_RyoshushoUmu;
    }

    /**
     * 提出物管理番号のgetメソッドです。
     *
     * @return 提出物管理番号
     */
    public Decimal getTeishutsubutsuKanriNo() {
        return teishutsubutsuKanriNo;
    }

    /**
     * 提出物管理番号のsetメソッドです。
     *
     * @param teishutsubutsuKanriNo 提出物管理番号
     */
    public void setTeishutsubutsuKanriNo(Decimal teishutsubutsuKanriNo) {
        this.teishutsubutsuKanriNo = teishutsubutsuKanriNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3086KyufuhiKashitsukekinShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hihokenshaNo, kariireShinseiYMD, rirekiNo, shinseishaYubinNo, shinseishaJusho, shinseishaShimeiKana, shinseishaShimei, shinseishaTelNo, shinseishaKankei, kariireRiyoKaishiYMD, kariireRiyoShuryoYMD, kashitsuke_KogakuUmu, kashitsuke_JutakuKaishuUmu, kahitsuke_YoguKonyuUmu, kashitsuke_TokureiServiceUmu, hoshonin_ShimeiKana, hoshonin_Shimei, hoshonin_UmareYMD, hoshinin_SeibetsuCd, hoshonin_YubinNo, hoshonin_Jusho, hoshonin_TelNo, kariireShinseishaKankei, hoshonin_KinmusakiMeisho, hoshonin_KinmusakiYubinNo, hoshonin_KinmusakiJusho, hoshonin_KinmusakiTelNo, seikyusho_RyoshushoUmu, teishutsubutsuKanriNo);
    }

// </editor-fold>
}
