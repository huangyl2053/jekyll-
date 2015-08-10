package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DbT3015KyufuKanrihyo200604の項目定義クラスです
 *
 */
public class DbT3015KyufuKanrihyo200604Entity extends DbTableEntityBase<DbT3015KyufuKanrihyo200604Entity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3015KyufuKanrihyo200604");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYearMonth shinsaYM;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private JigyoshaNo kyotakushienJigyoshoNo;
    @PrimaryKey
    private RString kyufuSakuseiKubunCode;
    @PrimaryKey
    private FlexibleDate kyufuSakuseiYMD;
    @PrimaryKey
    private RString kyufuShubetsuKubunCode;
    @PrimaryKey
    private RString kyufuMeisaiLineNo;
    private HokenshaNo hokenshaNo;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleDate hiHokenshaUmareYMD;
    private RString seibetsuCode;
    private RString yoKaigoJotaiKubunCode;
    private FlexibleYearMonth gendogakuTekiyoKaishiYM;
    private FlexibleYearMonth gendogakuTekiyoShuryoYM;
    private int kyotakuKaigoYoboShikyuGendogaku;
    private RString kyotakuServicePlanSakuseiKubunCode;
    private JigyoshaNo serviceJigyoshoNo;
    private RString shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
    private ServiceShuruiCode serviceShuruiCode;
    private int kyufuKeikakuTanisuNissu;
    private Decimal kyufuKeikakuNissu;
    private int shiteiServiceSubTotal;
    private int kijyunGaitoServiceSubTotal;
    private int kyufuKeikakuTotalTanisuNissu;
    private RString tantoKaigoShienSemmoninNo;
    private JigyoshaNo kaigoShienJigyoshaNo;
    private RString itakusakiTantoKaigoShienSemmoninNo;
    private FlexibleDate toshoTorokuYMD;
    private FlexibleYearMonth torikomiYM;

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
     * 審査年月のgetメソッドです。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * 審査年月のsetメソッドです。
     *
     * @param shinsaYM 審査年月
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
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
     * 証記載保険者番号のgetメソッドです。
     * <br/>
     * <br/>当該被保険者の証記載保険者番号を設定。
     * <br/>国保連IF上にはないため、広域の場合は被保険者台帳ﾏｽﾀより市町村ｺｰﾄﾞを判定し保険者番号を求め設定する。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * <br/>
     * <br/>当該被保険者の証記載保険者番号を設定。
     * <br/>国保連IF上にはないため、広域の場合は被保険者台帳ﾏｽﾀより市町村ｺｰﾄﾞを判定し保険者番号を求め設定する。
     *
     * @param shokisaiHokenshaNo 証記載保険者番号
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * 居宅支援事業所番号のgetメソッドです。
     * <br/>
     * <br/>事業所作成の場合必須
     *
     * @return 居宅支援事業所番号
     */
    public JigyoshaNo getKyotakushienJigyoshoNo() {
        return kyotakushienJigyoshoNo;
    }

    /**
     * 居宅支援事業所番号のsetメソッドです。
     * <br/>
     * <br/>事業所作成の場合必須
     *
     * @param kyotakushienJigyoshoNo 居宅支援事業所番号
     */
    public void setKyotakushienJigyoshoNo(JigyoshaNo kyotakushienJigyoshoNo) {
        this.kyotakushienJigyoshoNo = kyotakushienJigyoshoNo;
    }

    /**
     * 給付管理票情報作成区分コードのgetメソッドです。
     *
     * @return 給付管理票情報作成区分コード
     */
    public RString getKyufuSakuseiKubunCode() {
        return kyufuSakuseiKubunCode;
    }

    /**
     * 給付管理票情報作成区分コードのsetメソッドです。
     *
     * @param kyufuSakuseiKubunCode 給付管理票情報作成区分コード
     */
    public void setKyufuSakuseiKubunCode(RString kyufuSakuseiKubunCode) {
        this.kyufuSakuseiKubunCode = kyufuSakuseiKubunCode;
    }

    /**
     * 給付管理票作成年月日のgetメソッドです。
     *
     * @return 給付管理票作成年月日
     */
    public FlexibleDate getKyufuSakuseiYMD() {
        return kyufuSakuseiYMD;
    }

    /**
     * 給付管理票作成年月日のsetメソッドです。
     *
     * @param kyufuSakuseiYMD 給付管理票作成年月日
     */
    public void setKyufuSakuseiYMD(FlexibleDate kyufuSakuseiYMD) {
        this.kyufuSakuseiYMD = kyufuSakuseiYMD;
    }

    /**
     * 給付管理票種別区分コードのgetメソッドです。
     *
     * @return 給付管理票種別区分コード
     */
    public RString getKyufuShubetsuKubunCode() {
        return kyufuShubetsuKubunCode;
    }

    /**
     * 給付管理票種別区分コードのsetメソッドです。
     *
     * @param kyufuShubetsuKubunCode 給付管理票種別区分コード
     */
    public void setKyufuShubetsuKubunCode(RString kyufuShubetsuKubunCode) {
        this.kyufuShubetsuKubunCode = kyufuShubetsuKubunCode;
    }

    /**
     * 給付管理票明細行番号のgetメソッドです。
     *
     * @return 給付管理票明細行番号
     */
    public RString getKyufuMeisaiLineNo() {
        return kyufuMeisaiLineNo;
    }

    /**
     * 給付管理票明細行番号のsetメソッドです。
     *
     * @param kyufuMeisaiLineNo 給付管理票明細行番号
     */
    public void setKyufuMeisaiLineNo(RString kyufuMeisaiLineNo) {
        this.kyufuMeisaiLineNo = kyufuMeisaiLineNo;
    }

    /**
     * 保険者番号のgetメソッドです。
     *
     * @return 保険者番号
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * 保険者番号のsetメソッドです。
     *
     * @param hokenshaNo 保険者番号
     */
    public void setHokenshaNo(HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
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
     * 被保険者生年月日のgetメソッドです。
     *
     * @return 被保険者生年月日
     */
    public FlexibleDate getHiHokenshaUmareYMD() {
        return hiHokenshaUmareYMD;
    }

    /**
     * 被保険者生年月日のsetメソッドです。
     *
     * @param hiHokenshaUmareYMD 被保険者生年月日
     */
    public void setHiHokenshaUmareYMD(FlexibleDate hiHokenshaUmareYMD) {
        this.hiHokenshaUmareYMD = hiHokenshaUmareYMD;
    }

    /**
     * 性別コードのgetメソッドです。
     *
     * @return 性別コード
     */
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * 性別コードのsetメソッドです。
     *
     * @param seibetsuCode 性別コード
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * 要介護状態区分コードのgetメソッドです。
     *
     * @return 要介護状態区分コード
     */
    public RString getYoKaigoJotaiKubunCode() {
        return yoKaigoJotaiKubunCode;
    }

    /**
     * 要介護状態区分コードのsetメソッドです。
     *
     * @param yoKaigoJotaiKubunCode 要介護状態区分コード
     */
    public void setYoKaigoJotaiKubunCode(RString yoKaigoJotaiKubunCode) {
        this.yoKaigoJotaiKubunCode = yoKaigoJotaiKubunCode;
    }

    /**
     * 限度額適用開始年月のgetメソッドです。
     *
     * @return 限度額適用開始年月
     */
    public FlexibleYearMonth getGendogakuTekiyoKaishiYM() {
        return gendogakuTekiyoKaishiYM;
    }

    /**
     * 限度額適用開始年月のsetメソッドです。
     *
     * @param gendogakuTekiyoKaishiYM 限度額適用開始年月
     */
    public void setGendogakuTekiyoKaishiYM(FlexibleYearMonth gendogakuTekiyoKaishiYM) {
        this.gendogakuTekiyoKaishiYM = gendogakuTekiyoKaishiYM;
    }

    /**
     * 限度額適用終了年月のgetメソッドです。
     *
     * @return 限度額適用終了年月
     */
    public FlexibleYearMonth getGendogakuTekiyoShuryoYM() {
        return gendogakuTekiyoShuryoYM;
    }

    /**
     * 限度額適用終了年月のsetメソッドです。
     *
     * @param gendogakuTekiyoShuryoYM 限度額適用終了年月
     */
    public void setGendogakuTekiyoShuryoYM(FlexibleYearMonth gendogakuTekiyoShuryoYM) {
        this.gendogakuTekiyoShuryoYM = gendogakuTekiyoShuryoYM;
    }

    /**
     * 居宅・介護予防支給限度額のgetメソッドです。
     *
     * @return 居宅・介護予防支給限度額
     */
    public int getKyotakuKaigoYoboShikyuGendogaku() {
        return kyotakuKaigoYoboShikyuGendogaku;
    }

    /**
     * 居宅・介護予防支給限度額のsetメソッドです。
     *
     * @param kyotakuKaigoYoboShikyuGendogaku 居宅・介護予防支給限度額
     */
    public void setKyotakuKaigoYoboShikyuGendogaku(int kyotakuKaigoYoboShikyuGendogaku) {
        this.kyotakuKaigoYoboShikyuGendogaku = kyotakuKaigoYoboShikyuGendogaku;
    }

    /**
     * 居宅サービス計画作成区分コードのgetメソッドです。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString getKyotakuServicePlanSakuseiKubunCode() {
        return kyotakuServicePlanSakuseiKubunCode;
    }

    /**
     * 居宅サービス計画作成区分コードのsetメソッドです。
     *
     * @param kyotakuServicePlanSakuseiKubunCode 居宅サービス計画作成区分コード
     */
    public void setKyotakuServicePlanSakuseiKubunCode(RString kyotakuServicePlanSakuseiKubunCode) {
        this.kyotakuServicePlanSakuseiKubunCode = kyotakuServicePlanSakuseiKubunCode;
    }

    /**
     * サービス事業所番号のgetメソッドです。
     *
     * @return サービス事業所番号
     */
    public JigyoshaNo getServiceJigyoshoNo() {
        return serviceJigyoshoNo;
    }

    /**
     * サービス事業所番号のsetメソッドです。
     *
     * @param serviceJigyoshoNo サービス事業所番号
     */
    public void setServiceJigyoshoNo(JigyoshaNo serviceJigyoshoNo) {
        this.serviceJigyoshoNo = serviceJigyoshoNo;
    }

    /**
     * 指定/基準該当/地域密着型サービス識別コードのgetメソッドです。
     *
     * @return 指定/基準該当/地域密着型サービス識別コード
     */
    public RString getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode() {
        return shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
    }

    /**
     * 指定/基準該当/地域密着型サービス識別コードのsetメソッドです。
     *
     * @param shiteiKijungaitoChiikimitchakuServiceShikibetsuCode
     * 指定/基準該当/地域密着型サービス識別コード
     */
    public void setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(RString shiteiKijungaitoChiikimitchakuServiceShikibetsuCode) {
        this.shiteiKijungaitoChiikimitchakuServiceShikibetsuCode = shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
    }

    /**
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * 給付計画単位数／日数のgetメソッドです。
     *
     * @return 給付計画単位数／日数
     */
    public int getKyufuKeikakuTanisuNissu() {
        return kyufuKeikakuTanisuNissu;
    }

    /**
     * 給付計画単位数／日数のsetメソッドです。
     *
     * @param kyufuKeikakuTanisuNissu 給付計画単位数／日数
     */
    public void setKyufuKeikakuTanisuNissu(int kyufuKeikakuTanisuNissu) {
        this.kyufuKeikakuTanisuNissu = kyufuKeikakuTanisuNissu;
    }

    /**
     * 限度額管理期間における前月までの給付計画日数のgetメソッドです。
     * <br/>
     * <br/>短期入所サービス給付管理票の場合、必須
     *
     * @return 限度額管理期間における前月までの給付計画日数
     */
    public Decimal getKyufuKeikakuNissu() {
        return kyufuKeikakuNissu;
    }

    /**
     * 限度額管理期間における前月までの給付計画日数のsetメソッドです。
     * <br/>
     * <br/>短期入所サービス給付管理票の場合、必須
     *
     * @param kyufuKeikakuNissu 限度額管理期間における前月までの給付計画日数
     */
    public void setKyufuKeikakuNissu(Decimal kyufuKeikakuNissu) {
        this.kyufuKeikakuNissu = kyufuKeikakuNissu;
    }

    /**
     * 指定サービス分小計のgetメソッドです。
     *
     * @return 指定サービス分小計
     */
    public int getShiteiServiceSubTotal() {
        return shiteiServiceSubTotal;
    }

    /**
     * 指定サービス分小計のsetメソッドです。
     *
     * @param shiteiServiceSubTotal 指定サービス分小計
     */
    public void setShiteiServiceSubTotal(int shiteiServiceSubTotal) {
        this.shiteiServiceSubTotal = shiteiServiceSubTotal;
    }

    /**
     * 基準該当サービス分小計のgetメソッドです。
     *
     * @return 基準該当サービス分小計
     */
    public int getKijyunGaitoServiceSubTotal() {
        return kijyunGaitoServiceSubTotal;
    }

    /**
     * 基準該当サービス分小計のsetメソッドです。
     *
     * @param kijyunGaitoServiceSubTotal 基準該当サービス分小計
     */
    public void setKijyunGaitoServiceSubTotal(int kijyunGaitoServiceSubTotal) {
        this.kijyunGaitoServiceSubTotal = kijyunGaitoServiceSubTotal;
    }

    /**
     * 給付計画合計単位数/日数のgetメソッドです。
     *
     * @return 給付計画合計単位数/日数
     */
    public int getKyufuKeikakuTotalTanisuNissu() {
        return kyufuKeikakuTotalTanisuNissu;
    }

    /**
     * 給付計画合計単位数/日数のsetメソッドです。
     *
     * @param kyufuKeikakuTotalTanisuNissu 給付計画合計単位数/日数
     */
    public void setKyufuKeikakuTotalTanisuNissu(int kyufuKeikakuTotalTanisuNissu) {
        this.kyufuKeikakuTotalTanisuNissu = kyufuKeikakuTotalTanisuNissu;
    }

    /**
     * 担当介護支援専門員番号のgetメソッドです。
     * <br/>
     * <br/>対象年月が平成１８年４月以降の場合のみ
     *
     * @return 担当介護支援専門員番号
     */
    public RString getTantoKaigoShienSemmoninNo() {
        return tantoKaigoShienSemmoninNo;
    }

    /**
     * 担当介護支援専門員番号のsetメソッドです。
     * <br/>
     * <br/>対象年月が平成１８年４月以降の場合のみ
     *
     * @param tantoKaigoShienSemmoninNo 担当介護支援専門員番号
     */
    public void setTantoKaigoShienSemmoninNo(RString tantoKaigoShienSemmoninNo) {
        this.tantoKaigoShienSemmoninNo = tantoKaigoShienSemmoninNo;
    }

    /**
     * 委託先の居宅介護支援事業所番号のgetメソッドです。
     * <br/>
     * <br/>対象年月が平成１８年４月以降の場合のみ
     *
     * @return 委託先の居宅介護支援事業所番号
     */
    public JigyoshaNo getKaigoShienJigyoshaNo() {
        return kaigoShienJigyoshaNo;
    }

    /**
     * 委託先の居宅介護支援事業所番号のsetメソッドです。
     * <br/>
     * <br/>対象年月が平成１８年４月以降の場合のみ
     *
     * @param kaigoShienJigyoshaNo 委託先の居宅介護支援事業所番号
     */
    public void setKaigoShienJigyoshaNo(JigyoshaNo kaigoShienJigyoshaNo) {
        this.kaigoShienJigyoshaNo = kaigoShienJigyoshaNo;
    }

    /**
     * 委託先の担当介護支援専門員番号のgetメソッドです。
     * <br/>
     * <br/>対象年月が平成１８年４月以降の場合のみ
     *
     * @return 委託先の担当介護支援専門員番号
     */
    public RString getItakusakiTantoKaigoShienSemmoninNo() {
        return itakusakiTantoKaigoShienSemmoninNo;
    }

    /**
     * 委託先の担当介護支援専門員番号のsetメソッドです。
     * <br/>
     * <br/>対象年月が平成１８年４月以降の場合のみ
     *
     * @param itakusakiTantoKaigoShienSemmoninNo 委託先の担当介護支援専門員番号
     */
    public void setItakusakiTantoKaigoShienSemmoninNo(RString itakusakiTantoKaigoShienSemmoninNo) {
        this.itakusakiTantoKaigoShienSemmoninNo = itakusakiTantoKaigoShienSemmoninNo;
    }

    /**
     * 当初登録年月日のgetメソッドです。
     *
     * @return 当初登録年月日
     */
    public FlexibleDate getToshoTorokuYMD() {
        return toshoTorokuYMD;
    }

    /**
     * 当初登録年月日のsetメソッドです。
     *
     * @param toshoTorokuYMD 当初登録年月日
     */
    public void setToshoTorokuYMD(FlexibleDate toshoTorokuYMD) {
        this.toshoTorokuYMD = toshoTorokuYMD;
    }

    /**
     * 取込年月のgetメソッドです。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * 取込年月のsetメソッドです。
     *
     * @param torikomiYM 取込年月
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3015KyufuKanrihyo200604Entity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3015KyufuKanrihyo200604Entity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3015KyufuKanrihyo200604Entity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsaYM, other.shinsaYM)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.shokisaiHokenshaNo, other.shokisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kyotakushienJigyoshoNo, other.kyotakushienJigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.kyufuSakuseiKubunCode, other.kyufuSakuseiKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.kyufuSakuseiYMD, other.kyufuSakuseiYMD)) {
            return false;
        }
        if (!Objects.equals(this.kyufuShubetsuKubunCode, other.kyufuShubetsuKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.kyufuMeisaiLineNo, other.kyufuMeisaiLineNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3015KyufuKanrihyo200604Entity entity) {
        this.shinsaYM = entity.shinsaYM;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.kyotakushienJigyoshoNo = entity.kyotakushienJigyoshoNo;
        this.kyufuSakuseiKubunCode = entity.kyufuSakuseiKubunCode;
        this.kyufuSakuseiYMD = entity.kyufuSakuseiYMD;
        this.kyufuShubetsuKubunCode = entity.kyufuShubetsuKubunCode;
        this.kyufuMeisaiLineNo = entity.kyufuMeisaiLineNo;
        this.hokenshaNo = entity.hokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.hiHokenshaUmareYMD = entity.hiHokenshaUmareYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.yoKaigoJotaiKubunCode = entity.yoKaigoJotaiKubunCode;
        this.gendogakuTekiyoKaishiYM = entity.gendogakuTekiyoKaishiYM;
        this.gendogakuTekiyoShuryoYM = entity.gendogakuTekiyoShuryoYM;
        this.kyotakuKaigoYoboShikyuGendogaku = entity.kyotakuKaigoYoboShikyuGendogaku;
        this.kyotakuServicePlanSakuseiKubunCode = entity.kyotakuServicePlanSakuseiKubunCode;
        this.serviceJigyoshoNo = entity.serviceJigyoshoNo;
        this.shiteiKijungaitoChiikimitchakuServiceShikibetsuCode = entity.shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.kyufuKeikakuTanisuNissu = entity.kyufuKeikakuTanisuNissu;
        this.kyufuKeikakuNissu = entity.kyufuKeikakuNissu;
        this.shiteiServiceSubTotal = entity.shiteiServiceSubTotal;
        this.kijyunGaitoServiceSubTotal = entity.kijyunGaitoServiceSubTotal;
        this.kyufuKeikakuTotalTanisuNissu = entity.kyufuKeikakuTotalTanisuNissu;
        this.tantoKaigoShienSemmoninNo = entity.tantoKaigoShienSemmoninNo;
        this.kaigoShienJigyoshaNo = entity.kaigoShienJigyoshaNo;
        this.itakusakiTantoKaigoShienSemmoninNo = entity.itakusakiTantoKaigoShienSemmoninNo;
        this.toshoTorokuYMD = entity.toshoTorokuYMD;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsaYM, serviceTeikyoYM, shokisaiHokenshaNo, kyotakushienJigyoshoNo, kyufuSakuseiKubunCode, kyufuSakuseiYMD, kyufuShubetsuKubunCode, kyufuMeisaiLineNo, hokenshaNo, hiHokenshaNo, hiHokenshaUmareYMD, seibetsuCode, yoKaigoJotaiKubunCode, gendogakuTekiyoKaishiYM, gendogakuTekiyoShuryoYM, kyotakuKaigoYoboShikyuGendogaku, kyotakuServicePlanSakuseiKubunCode, serviceJigyoshoNo, shiteiKijungaitoChiikimitchakuServiceShikibetsuCode, serviceShuruiCode, kyufuKeikakuTanisuNissu, kyufuKeikakuNissu, shiteiServiceSubTotal, kijyunGaitoServiceSubTotal, kyufuKeikakuTotalTanisuNissu, tantoKaigoShienSemmoninNo, kaigoShienJigyoshaNo, itakusakiTantoKaigoShienSemmoninNo, toshoTorokuYMD, torikomiYM);
    }

// </editor-fold>
}
