package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * DbT7131KaigoServiceNaiyouテーブルのエンティティクラスです。
 *
 * @author 自動生成
 * @jpName 介護サービス内容エンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class DbT7131KaigoServiceNaiyouEntity extends DbTableEntityBase<DbT7131KaigoServiceNaiyouEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7131KaigoServiceNaiyou");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KaigoServiceShuruiCode serviceShuruiCd;
    @PrimaryKey
    private RString serviceKoumokuCd;
    @PrimaryKey
    private FlexibleYearMonth teikyoKaishiYM;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleYearMonth teikyoShuryoYM;
    private RString serviceName;
    private RString serviceNameRyaku;
    private int taniSu;
    private Code tanisuShikibetsuCode;
    private Code tanisuSanteiTaniCode;
    private Code idouJiyuCode;
    private RString gendogakuTaishogaiFlag;
    private RString gaibuServiceRiyoKataKubun;
    private RString tokubetsuChiikiKasanFlag;
    private RString riyosyaFutanTeiritsuTeigakuKubun;
    private RString koshinUmuFoag;
    private RString motoTensu;
    private RString motoGendogakuTaishogaiFlag;
    private RString motoTaniShikibetsuCd;
    private RString riyoshaFutanGaku;
    private RString kyufuRitsu;
    private RString nijiyoboJigyoTaishaJishiKubunHigaito;
    private RString yoshien1JukyushaJishiKubun;
    private RString yoshien2JukyushaJishiKubun;
    private RString taishoJigyoJishiKubun;
    private RString sogoJigyoServiceKubun;
    private RString seigenNissuKaisu;
    private RString santeiKaisuSeigenKikanKubun;

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
     * サービス種類コードのgetメソッドです。
     * <br/>
     * <br/>介護サービス種類TBLとのLinkキー
     * 
     * @return サービス種類コード
     */
    public KaigoServiceShuruiCode getServiceShuruiCd() {
        return serviceShuruiCd;
    }

    /**
     * サービス種類コードのsetメソッドです。
     * <br/>
     * <br/>介護サービス種類TBLとのLinkキー
     * 
     * @param serviceShuruiCd サービス種類コード
     */
    public void setServiceShuruiCd(@Nonnull KaigoServiceShuruiCode serviceShuruiCd) {
        this.serviceShuruiCd = serviceShuruiCd;
    }

    /**
     * サービス項目コードのgetメソッドです。
     * <br/>
     * <br/>サービス種類コードと合わせてサービスコードを示す。
     * <br/>サービス名称に対するコード
     * 
     * @return サービス項目コード
     */
    public RString getServiceKoumokuCd() {
        return serviceKoumokuCd;
    }

    /**
     * サービス項目コードのsetメソッドです。
     * <br/>
     * <br/>サービス種類コードと合わせてサービスコードを示す。
     * <br/>サービス名称に対するコード
     * 
     * @param serviceKoumokuCd サービス項目コード
     */
    public void setServiceKoumokuCd(@Nonnull RString serviceKoumokuCd) {
        this.serviceKoumokuCd = serviceKoumokuCd;
    }

    /**
     * 提供開始年月のgetメソッドです。
     * 
     * @return 提供開始年月
     */
    public FlexibleYearMonth getTeikyoKaishiYM() {
        return teikyoKaishiYM;
    }

    /**
     * 提供開始年月のsetメソッドです。
     * 
     * @param teikyoKaishiYM 提供開始年月
     */
    public void setTeikyoKaishiYM(@Nonnull FlexibleYearMonth teikyoKaishiYM) {
        this.teikyoKaishiYM = teikyoKaishiYM;
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
    public void setRirekiNo(@Nonnull Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 提供終了年月のgetメソッドです。
     * 
     * @return 提供終了年月
     */
    @CheckForNull
    public FlexibleYearMonth getTeikyoShuryoYM() {
        return teikyoShuryoYM;
    }

    /**
     * 提供終了年月のsetメソッドです。
     * 
     * @param teikyoShuryoYM 提供終了年月
     */
    public void setTeikyoShuryoYM(FlexibleYearMonth teikyoShuryoYM) {
        this.teikyoShuryoYM = teikyoShuryoYM;
    }

    /**
     * サービス名称のgetメソッドです。
     * 
     * @return サービス名称
     */
    public RString getServiceName() {
        return serviceName;
    }

    /**
     * サービス名称のsetメソッドです。
     * 
     * @param serviceName サービス名称
     */
    public void setServiceName(@Nonnull RString serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * サービス略称のgetメソッドです。
     * 
     * @return サービス略称
     */
    public RString getServiceNameRyaku() {
        return serviceNameRyaku;
    }

    /**
     * サービス略称のsetメソッドです。
     * 
     * @param serviceNameRyaku サービス略称
     */
    public void setServiceNameRyaku(@Nonnull RString serviceNameRyaku) {
        this.serviceNameRyaku = serviceNameRyaku;
    }

    /**
     * 単位数のgetメソッドです。
     * 
     * @return 単位数
     */
    public int getTaniSu() {
        return taniSu;
    }

    /**
     * 単位数のsetメソッドです。
     * 
     * @param taniSu 単位数
     */
    public void setTaniSu(@Nonnull int taniSu) {
        this.taniSu = taniSu;
    }

    /**
     * 単位数識別のgetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0021＞
     * <br/>01：単位数　　　　 
     * <br/>02：金額(円)
     * <br/>03：％値　　　　　 
     * <br/>04：きざみ基準単位
     * <br/>05：法定単位数なし(記載省略)
     * <br/>06：単位数(記載省略)
     * <br/>07：％値(記載省略) 
     * <br/>08：1/1000値
     * <br/>09：1/1000値(記載省略)
     * <br/>13：％値：上限
     * 
     * @return 単位数識別
     */
    public Code getTanisuShikibetsuCode() {
        return tanisuShikibetsuCode;
    }

    /**
     * 単位数識別のsetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0021＞
     * <br/>01：単位数　　　　 
     * <br/>02：金額(円)
     * <br/>03：％値　　　　　 
     * <br/>04：きざみ基準単位
     * <br/>05：法定単位数なし(記載省略)
     * <br/>06：単位数(記載省略)
     * <br/>07：％値(記載省略) 
     * <br/>08：1/1000値
     * <br/>09：1/1000値(記載省略)
     * <br/>13：％値：上限
     * 
     * @param tanisuShikibetsuCode 単位数識別
     */
    public void setTanisuShikibetsuCode(@Nonnull Code tanisuShikibetsuCode) {
        this.tanisuShikibetsuCode = tanisuShikibetsuCode;
    }

    /**
     * 単位数算定単位のgetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0022＞
     * <br/>01:1回につき
     * <br/>02:1日につき
     * <br/>03:1月につき
     * <br/>04:算定単位無し
     * <br/>05:1週間につき
     * 
     * @return 単位数算定単位
     */
    public Code getTanisuSanteiTaniCode() {
        return tanisuSanteiTaniCode;
    }

    /**
     * 単位数算定単位のsetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0022＞
     * <br/>01:1回につき
     * <br/>02:1日につき
     * <br/>03:1月につき
     * <br/>04:算定単位無し
     * <br/>05:1週間につき
     * 
     * @param tanisuSanteiTaniCode 単位数算定単位
     */
    public void setTanisuSanteiTaniCode(@Nonnull Code tanisuSanteiTaniCode) {
        this.tanisuSanteiTaniCode = tanisuSanteiTaniCode;
    }

    /**
     * 異動事由のgetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0023＞
     * <br/>010：厚生省改定による 等
     * <br/>
     * <br/>介護サービス異動事由
     * 
     * @return 異動事由
     */
    public Code getIdouJiyuCode() {
        return idouJiyuCode;
    }

    /**
     * 異動事由のsetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0023＞
     * <br/>010：厚生省改定による 等
     * <br/>
     * <br/>介護サービス異動事由
     * 
     * @param idouJiyuCode 異動事由
     */
    public void setIdouJiyuCode(@Nonnull Code idouJiyuCode) {
        this.idouJiyuCode = idouJiyuCode;
    }

    /**
     * 限度額対象外フラグのgetメソッドです。
     * 
     * @return 限度額対象外フラグ
     */
    @CheckForNull
    public RString getGendogakuTaishogaiFlag() {
        return gendogakuTaishogaiFlag;
    }

    /**
     * 限度額対象外フラグのsetメソッドです。
     * 
     * @param gendogakuTaishogaiFlag 限度額対象外フラグ
     */
    public void setGendogakuTaishogaiFlag(RString gendogakuTaishogaiFlag) {
        this.gendogakuTaishogaiFlag = gendogakuTaishogaiFlag;
    }

    /**
     * 外部サービス利用型区分のgetメソッドです。
     * 
     * @return 外部サービス利用型区分
     */
    @CheckForNull
    public RString getGaibuServiceRiyoKataKubun() {
        return gaibuServiceRiyoKataKubun;
    }

    /**
     * 外部サービス利用型区分のsetメソッドです。
     * 
     * @param gaibuServiceRiyoKataKubun 外部サービス利用型区分
     */
    public void setGaibuServiceRiyoKataKubun(RString gaibuServiceRiyoKataKubun) {
        this.gaibuServiceRiyoKataKubun = gaibuServiceRiyoKataKubun;
    }

    /**
     * 特別地域加算フラグのgetメソッドです。
     * 
     * @return 特別地域加算フラグ
     */
    @CheckForNull
    public RString getTokubetsuChiikiKasanFlag() {
        return tokubetsuChiikiKasanFlag;
    }

    /**
     * 特別地域加算フラグのsetメソッドです。
     * 
     * @param tokubetsuChiikiKasanFlag 特別地域加算フラグ
     */
    public void setTokubetsuChiikiKasanFlag(RString tokubetsuChiikiKasanFlag) {
        this.tokubetsuChiikiKasanFlag = tokubetsuChiikiKasanFlag;
    }

    /**
     * 利用者負担定率・定額区分のgetメソッドです。
     * 
     * @return 利用者負担定率・定額区分
     */
    @CheckForNull
    public RString getRiyosyaFutanTeiritsuTeigakuKubun() {
        return riyosyaFutanTeiritsuTeigakuKubun;
    }

    /**
     * 利用者負担定率・定額区分のsetメソッドです。
     * 
     * @param riyosyaFutanTeiritsuTeigakuKubun 利用者負担定率・定額区分
     */
    public void setRiyosyaFutanTeiritsuTeigakuKubun(RString riyosyaFutanTeiritsuTeigakuKubun) {
        this.riyosyaFutanTeiritsuTeigakuKubun = riyosyaFutanTeiritsuTeigakuKubun;
    }

    /**
     * 更新有無フラグのgetメソッドです。
     * 
     * @return 更新有無フラグ
     */
    @CheckForNull
    public RString getKoshinUmuFoag() {
        return koshinUmuFoag;
    }

    /**
     * 更新有無フラグのsetメソッドです。
     * 
     * @param koshinUmuFoag 更新有無フラグ
     */
    public void setKoshinUmuFoag(RString koshinUmuFoag) {
        this.koshinUmuFoag = koshinUmuFoag;
    }

    /**
     * 元点数のgetメソッドです。
     * 
     * @return 元点数
     */
    @CheckForNull
    public RString getMotoTensu() {
        return motoTensu;
    }

    /**
     * 元点数のsetメソッドです。
     * 
     * @param motoTensu 元点数
     */
    public void setMotoTensu(RString motoTensu) {
        this.motoTensu = motoTensu;
    }

    /**
     * 元限度額対象外フラグのgetメソッドです。
     * 
     * @return 元限度額対象外フラグ
     */
    @CheckForNull
    public RString getMotoGendogakuTaishogaiFlag() {
        return motoGendogakuTaishogaiFlag;
    }

    /**
     * 元限度額対象外フラグのsetメソッドです。
     * 
     * @param motoGendogakuTaishogaiFlag 元限度額対象外フラグ
     */
    public void setMotoGendogakuTaishogaiFlag(RString motoGendogakuTaishogaiFlag) {
        this.motoGendogakuTaishogaiFlag = motoGendogakuTaishogaiFlag;
    }

    /**
     * 元単位数識別コードのgetメソッドです。
     * 
     * @return 元単位数識別コード
     */
    @CheckForNull
    public RString getMotoTaniShikibetsuCd() {
        return motoTaniShikibetsuCd;
    }

    /**
     * 元単位数識別コードのsetメソッドです。
     * 
     * @param motoTaniShikibetsuCd 元単位数識別コード
     */
    public void setMotoTaniShikibetsuCd(RString motoTaniShikibetsuCd) {
        this.motoTaniShikibetsuCd = motoTaniShikibetsuCd;
    }

    /**
     * 利用者負担額のgetメソッドです。
     * 
     * @return 利用者負担額
     */
    @CheckForNull
    public RString getRiyoshaFutanGaku() {
        return riyoshaFutanGaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     * 
     * @param riyoshaFutanGaku 利用者負担額
     */
    public void setRiyoshaFutanGaku(RString riyoshaFutanGaku) {
        this.riyoshaFutanGaku = riyoshaFutanGaku;
    }

    /**
     * 給付率のgetメソッドです。
     * 
     * @return 給付率
     */
    @CheckForNull
    public RString getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * 給付率のsetメソッドです。
     * 
     * @param kyufuRitsu 給付率
     */
    public void setKyufuRitsu(RString kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * 二次予防事業対象者実施区分（非該当）のgetメソッドです。
     * 
     * @return 二次予防事業対象者実施区分（非該当）
     */
    @CheckForNull
    public RString getNijiyoboJigyoTaishaJishiKubunHigaito() {
        return nijiyoboJigyoTaishaJishiKubunHigaito;
    }

    /**
     * 二次予防事業対象者実施区分（非該当）のsetメソッドです。
     * 
     * @param nijiyoboJigyoTaishaJishiKubunHigaito 二次予防事業対象者実施区分（非該当）
     */
    public void setNijiyoboJigyoTaishaJishiKubunHigaito(RString nijiyoboJigyoTaishaJishiKubunHigaito) {
        this.nijiyoboJigyoTaishaJishiKubunHigaito = nijiyoboJigyoTaishaJishiKubunHigaito;
    }

    /**
     * 要支援１受給者実施区分のgetメソッドです。
     * 
     * @return 要支援１受給者実施区分
     */
    @CheckForNull
    public RString getYoshien1JukyushaJishiKubun() {
        return yoshien1JukyushaJishiKubun;
    }

    /**
     * 要支援１受給者実施区分のsetメソッドです。
     * 
     * @param yoshien1JukyushaJishiKubun 要支援１受給者実施区分
     */
    public void setYoshien1JukyushaJishiKubun(RString yoshien1JukyushaJishiKubun) {
        this.yoshien1JukyushaJishiKubun = yoshien1JukyushaJishiKubun;
    }

    /**
     * 要支援２受給者実施区分のgetメソッドです。
     * 
     * @return 要支援２受給者実施区分
     */
    @CheckForNull
    public RString getYoshien2JukyushaJishiKubun() {
        return yoshien2JukyushaJishiKubun;
    }

    /**
     * 要支援２受給者実施区分のsetメソッドです。
     * 
     * @param yoshien2JukyushaJishiKubun 要支援２受給者実施区分
     */
    public void setYoshien2JukyushaJishiKubun(RString yoshien2JukyushaJishiKubun) {
        this.yoshien2JukyushaJishiKubun = yoshien2JukyushaJishiKubun;
    }

    /**
     * 対象事業者実施区分のgetメソッドです。
     * 
     * @return 対象事業者実施区分
     */
    @CheckForNull
    public RString getTaishoJigyoJishiKubun() {
        return taishoJigyoJishiKubun;
    }

    /**
     * 対象事業者実施区分のsetメソッドです。
     * 
     * @param taishoJigyoJishiKubun 対象事業者実施区分
     */
    public void setTaishoJigyoJishiKubun(RString taishoJigyoJishiKubun) {
        this.taishoJigyoJishiKubun = taishoJigyoJishiKubun;
    }

    /**
     * 総合事業サービス区分のgetメソッドです。
     * 
     * @return 総合事業サービス区分
     */
    @CheckForNull
    public RString getSogoJigyoServiceKubun() {
        return sogoJigyoServiceKubun;
    }

    /**
     * 総合事業サービス区分のsetメソッドです。
     * 
     * @param sogoJigyoServiceKubun 総合事業サービス区分
     */
    public void setSogoJigyoServiceKubun(RString sogoJigyoServiceKubun) {
        this.sogoJigyoServiceKubun = sogoJigyoServiceKubun;
    }

    /**
     * 制限日数回数のgetメソッドです。
     * 
     * @return 制限日数回数
     */
    @CheckForNull
    public RString getSeigenNissuKaisu() {
        return seigenNissuKaisu;
    }

    /**
     * 制限日数回数のsetメソッドです。
     * 
     * @param seigenNissuKaisu 制限日数回数
     */
    public void setSeigenNissuKaisu(RString seigenNissuKaisu) {
        this.seigenNissuKaisu = seigenNissuKaisu;
    }

    /**
     * 算定回数制限期間区分のgetメソッドです。
     * 
     * @return 算定回数制限期間区分
     */
    @CheckForNull
    public RString getSanteiKaisuSeigenKikanKubun() {
        return santeiKaisuSeigenKikanKubun;
    }

    /**
     * 算定回数制限期間区分のsetメソッドです。
     * 
     * @param santeiKaisuSeigenKikanKubun 算定回数制限期間区分
     */
    public void setSanteiKaisuSeigenKikanKubun(RString santeiKaisuSeigenKikanKubun) {
        this.santeiKaisuSeigenKikanKubun = santeiKaisuSeigenKikanKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7131KaigoServiceNaiyouEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7131KaigoServiceNaiyouEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7131KaigoServiceNaiyouEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCd, other.serviceShuruiCd)) {
            return false;
        }
        if (!Objects.equals(this.serviceKoumokuCd, other.serviceKoumokuCd)) {
            return false;
        }
        if (!Objects.equals(this.teikyoKaishiYM, other.teikyoKaishiYM)) {
            return false;
        }
        if (!Objects.equals(this.rirekiNo, other.rirekiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7131KaigoServiceNaiyouEntity entity) {
        this.serviceShuruiCd = entity.serviceShuruiCd;
        this.serviceKoumokuCd = entity.serviceKoumokuCd;
        this.teikyoKaishiYM = entity.teikyoKaishiYM;
        this.rirekiNo = entity.rirekiNo;
        this.teikyoShuryoYM = entity.teikyoShuryoYM;
        this.serviceName = entity.serviceName;
        this.serviceNameRyaku = entity.serviceNameRyaku;
        this.taniSu = entity.taniSu;
        this.tanisuShikibetsuCode = entity.tanisuShikibetsuCode;
        this.tanisuSanteiTaniCode = entity.tanisuSanteiTaniCode;
        this.idouJiyuCode = entity.idouJiyuCode;
        this.gendogakuTaishogaiFlag = entity.gendogakuTaishogaiFlag;
        this.gaibuServiceRiyoKataKubun = entity.gaibuServiceRiyoKataKubun;
        this.tokubetsuChiikiKasanFlag = entity.tokubetsuChiikiKasanFlag;
        this.riyosyaFutanTeiritsuTeigakuKubun = entity.riyosyaFutanTeiritsuTeigakuKubun;
        this.koshinUmuFoag = entity.koshinUmuFoag;
        this.motoTensu = entity.motoTensu;
        this.motoGendogakuTaishogaiFlag = entity.motoGendogakuTaishogaiFlag;
        this.motoTaniShikibetsuCd = entity.motoTaniShikibetsuCd;
        this.riyoshaFutanGaku = entity.riyoshaFutanGaku;
        this.kyufuRitsu = entity.kyufuRitsu;
        this.nijiyoboJigyoTaishaJishiKubunHigaito = entity.nijiyoboJigyoTaishaJishiKubunHigaito;
        this.yoshien1JukyushaJishiKubun = entity.yoshien1JukyushaJishiKubun;
        this.yoshien2JukyushaJishiKubun = entity.yoshien2JukyushaJishiKubun;
        this.taishoJigyoJishiKubun = entity.taishoJigyoJishiKubun;
        this.sogoJigyoServiceKubun = entity.sogoJigyoServiceKubun;
        this.seigenNissuKaisu = entity.seigenNissuKaisu;
        this.santeiKaisuSeigenKikanKubun = entity.santeiKaisuSeigenKikanKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCd, serviceKoumokuCd, teikyoKaishiYM, rirekiNo, teikyoShuryoYM, serviceName, serviceNameRyaku, taniSu, tanisuShikibetsuCode, tanisuSanteiTaniCode, idouJiyuCode, gendogakuTaishogaiFlag, gaibuServiceRiyoKataKubun, tokubetsuChiikiKasanFlag, riyosyaFutanTeiritsuTeigakuKubun, koshinUmuFoag, motoTensu, motoGendogakuTaishogaiFlag, motoTaniShikibetsuCd, riyoshaFutanGaku, kyufuRitsu, nijiyoboJigyoTaishaJishiKubunHigaito, yoshien1JukyushaJishiKubun, yoshien2JukyushaJishiKubun, taishoJigyoJishiKubun, sogoJigyoServiceKubun, seigenNissuKaisu, santeiKaisuSeigenKikanKubun);
    }

// </editor-fold>

}
