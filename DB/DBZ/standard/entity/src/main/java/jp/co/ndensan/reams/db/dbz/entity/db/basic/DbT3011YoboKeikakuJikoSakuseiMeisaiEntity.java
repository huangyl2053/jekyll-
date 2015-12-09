package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 予防給付計画自己作成明細テーブルのエンティティクラスです。
 */
public class DbT3011YoboKeikakuJikoSakuseiMeisaiEntity extends DbTableEntityBase<DbT3011YoboKeikakuJikoSakuseiMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3011YoboKeikakuJikoSakuseiMeisai");

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
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private int rirekiNo;
    @PrimaryKey
    private RString kyotakuServiceKubun;
    @PrimaryKey
    private JigyoshaNo serviceTeikyoJigyoshaNo;
    @PrimaryKey
    private ServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 対象年月のgetメソッドです。
     * 
     * @return 対象年月
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * 対象年月のsetメソッドです。
     * 
     * @param taishoYM 対象年月
     */
    public void setTaishoYM(@Nonnull FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 居宅サービス区分のgetメソッドです。
     * <br/>
     * <br/>3:居宅サービス
     * 
     * @return 居宅サービス区分
     */
    public RString getKyotakuServiceKubun() {
        return kyotakuServiceKubun;
    }

    /**
     * 居宅サービス区分のsetメソッドです。
     * <br/>
     * <br/>3:居宅サービス
     * 
     * @param kyotakuServiceKubun 居宅サービス区分
     */
    public void setKyotakuServiceKubun(@Nonnull RString kyotakuServiceKubun) {
        this.kyotakuServiceKubun = kyotakuServiceKubun;
    }

    /**
     * サービス提供事業者番号のgetメソッドです。
     * 
     * @return サービス提供事業者番号
     */
    public JigyoshaNo getServiceTeikyoJigyoshaNo() {
        return serviceTeikyoJigyoshaNo;
    }

    /**
     * サービス提供事業者番号のsetメソッドです。
     * 
     * @param serviceTeikyoJigyoshaNo サービス提供事業者番号
     */
    public void setServiceTeikyoJigyoshaNo(@Nonnull JigyoshaNo serviceTeikyoJigyoshaNo) {
        this.serviceTeikyoJigyoshaNo = serviceTeikyoJigyoshaNo;
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
    public void setServiceShuruiCode(@Nonnull ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * サービス項目コードのgetメソッドです。
     * 
     * @return サービス項目コード
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * サービス項目コードのsetメソッドです。
     * 
     * @param serviceKomokuCode サービス項目コード
     */
    public void setServiceKomokuCode(@Nonnull ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
    }

    /**
     * 単位数のgetメソッドです。
     * 
     * @return 単位数
     */
    @CheckForNull
    public Decimal getTaniSu() {
        return taniSu;
    }

    /**
     * 単位数のsetメソッドです。
     * 
     * @param taniSu 単位数
     */
    public void setTaniSu(Decimal taniSu) {
        this.taniSu = taniSu;
    }

    /**
     * 回数・日数のgetメソッドです。
     * 
     * @return 回数・日数
     */
    @CheckForNull
    public Decimal getKaisu_Nissu() {
        return kaisu_Nissu;
    }

    /**
     * 回数・日数のsetメソッドです。
     * 
     * @param kaisu_Nissu 回数・日数
     */
    public void setKaisu_Nissu(Decimal kaisu_Nissu) {
        this.kaisu_Nissu = kaisu_Nissu;
    }

    /**
     * 種類限度内単位数・日数のgetメソッドです。
     * 
     * @return 種類限度内単位数・日数
     */
    @CheckForNull
    public Decimal getShuruiGendoNaiTaniSu_Nissu() {
        return shuruiGendoNaiTaniSu_Nissu;
    }

    /**
     * 種類限度内単位数・日数のsetメソッドです。
     * 
     * @param shuruiGendoNaiTaniSu_Nissu 種類限度内単位数・日数
     */
    public void setShuruiGendoNaiTaniSu_Nissu(Decimal shuruiGendoNaiTaniSu_Nissu) {
        this.shuruiGendoNaiTaniSu_Nissu = shuruiGendoNaiTaniSu_Nissu;
    }

    /**
     * 種類限度超過単位数・日数のgetメソッドです。
     * 
     * @return 種類限度超過単位数・日数
     */
    @CheckForNull
    public Decimal getShuruiGendoChokaTaniSu_Nissu() {
        return shuruiGendoChokaTaniSu_Nissu;
    }

    /**
     * 種類限度超過単位数・日数のsetメソッドです。
     * 
     * @param shuruiGendoChokaTaniSu_Nissu 種類限度超過単位数・日数
     */
    public void setShuruiGendoChokaTaniSu_Nissu(Decimal shuruiGendoChokaTaniSu_Nissu) {
        this.shuruiGendoChokaTaniSu_Nissu = shuruiGendoChokaTaniSu_Nissu;
    }

    /**
     * 区分限度内単位数・日数のgetメソッドです。
     * 
     * @return 区分限度内単位数・日数
     */
    @CheckForNull
    public Decimal getKubunGendoNaiTaniSu_Nissu() {
        return kubunGendoNaiTaniSu_Nissu;
    }

    /**
     * 区分限度内単位数・日数のsetメソッドです。
     * 
     * @param kubunGendoNaiTaniSu_Nissu 区分限度内単位数・日数
     */
    public void setKubunGendoNaiTaniSu_Nissu(Decimal kubunGendoNaiTaniSu_Nissu) {
        this.kubunGendoNaiTaniSu_Nissu = kubunGendoNaiTaniSu_Nissu;
    }

    /**
     * 区分限度超過単位数・日数のgetメソッドです。
     * 
     * @return 区分限度超過単位数・日数
     */
    @CheckForNull
    public Decimal getKubunGendoChokaTaniSu_Nissu() {
        return kubunGendoChokaTaniSu_Nissu;
    }

    /**
     * 区分限度超過単位数・日数のsetメソッドです。
     * 
     * @param kubunGendoChokaTaniSu_Nissu 区分限度超過単位数・日数
     */
    public void setKubunGendoChokaTaniSu_Nissu(Decimal kubunGendoChokaTaniSu_Nissu) {
        this.kubunGendoChokaTaniSu_Nissu = kubunGendoChokaTaniSu_Nissu;
    }

    /**
     * 単位数単価のgetメソッドです。
     * <br/>
     * <br/>小数点第２位まで管理する
     * 
     * @return 単位数単価
     */
    @CheckForNull
    public Decimal getTaniSuTanka() {
        return taniSuTanka;
    }

    /**
     * 単位数単価のsetメソッドです。
     * <br/>
     * <br/>小数点第２位まで管理する
     * 
     * @param taniSuTanka 単位数単価
     */
    public void setTaniSuTanka(Decimal taniSuTanka) {
        this.taniSuTanka = taniSuTanka;
    }

    /**
     * 給付率のgetメソッドです。
     * <br/>
     * <br/>％
     * 
     * @return 給付率
     */
    @CheckForNull
    public HokenKyufuRitsu getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * 給付率のsetメソッドです。
     * <br/>
     * <br/>％
     * 
     * @param kyufuRitsu 給付率
     */
    public void setKyufuRitsu(HokenKyufuRitsu kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * 割引後適用率のgetメソッドです。
     * <br/>
     * <br/>居宅サービス区分が「3:居宅サービス」の場合に設定 ％
     * 
     * @return 割引後適用率
     */
    @CheckForNull
    public HokenKyufuRitsu getWaribikiGoTekiyoRitsu() {
        return waribikiGoTekiyoRitsu;
    }

    /**
     * 割引後適用率のsetメソッドです。
     * <br/>
     * <br/>居宅サービス区分が「3:居宅サービス」の場合に設定 ％
     * 
     * @param waribikiGoTekiyoRitsu 割引後適用率
     */
    public void setWaribikiGoTekiyoRitsu(HokenKyufuRitsu waribikiGoTekiyoRitsu) {
        this.waribikiGoTekiyoRitsu = waribikiGoTekiyoRitsu;
    }

    /**
     * 割引後適用単位数のgetメソッドです。
     * <br/>
     * <br/>居宅サービス区分が「3:居宅サービス」の場合に設定
     * 
     * @return 割引後適用単位数
     */
    @CheckForNull
    public Decimal getWaribikiGoTekiyoTaniSu() {
        return waribikiGoTekiyoTaniSu;
    }

    /**
     * 割引後適用単位数のsetメソッドです。
     * <br/>
     * <br/>居宅サービス区分が「3:居宅サービス」の場合に設定
     * 
     * @param waribikiGoTekiyoTaniSu 割引後適用単位数
     */
    public void setWaribikiGoTekiyoTaniSu(Decimal waribikiGoTekiyoTaniSu) {
        this.waribikiGoTekiyoTaniSu = waribikiGoTekiyoTaniSu;
    }

    /**
     * 定額利用者負担単価金額のgetメソッドです。
     * <br/>
     * <br/>利用者負担額が定額である場合に設定
     * 
     * @return 定額利用者負担単価金額
     */
    @CheckForNull
    public Decimal getTeigakuRiyoshaFutanTankaKingaku() {
        return teigakuRiyoshaFutanTankaKingaku;
    }

    /**
     * 定額利用者負担単価金額のsetメソッドです。
     * <br/>
     * <br/>利用者負担額が定額である場合に設定
     * 
     * @param teigakuRiyoshaFutanTankaKingaku 定額利用者負担単価金額
     */
    public void setTeigakuRiyoshaFutanTankaKingaku(Decimal teigakuRiyoshaFutanTankaKingaku) {
        this.teigakuRiyoshaFutanTankaKingaku = teigakuRiyoshaFutanTankaKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3011YoboKeikakuJikoSakuseiMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoYM, other.taishoYM)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        if (!Objects.equals(this.kyotakuServiceKubun, other.kyotakuServiceKubun)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoJigyoshaNo, other.serviceTeikyoJigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.serviceKomokuCode, other.serviceKomokuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3011YoboKeikakuJikoSakuseiMeisaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoYM = entity.taishoYM;
        this.rirekiNo = entity.rirekiNo;
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
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoYM, rirekiNo, kyotakuServiceKubun, serviceTeikyoJigyoshaNo, serviceShuruiCode, serviceKomokuCode, taniSu, kaisu_Nissu, shuruiGendoNaiTaniSu_Nissu, shuruiGendoChokaTaniSu_Nissu, kubunGendoNaiTaniSu_Nissu, kubunGendoChokaTaniSu_Nissu, taniSuTanka, kyufuRitsu, waribikiGoTekiyoRitsu, waribikiGoTekiyoTaniSu, teigakuRiyoshaFutanTankaKingaku);
    }

// </editor-fold>
}
