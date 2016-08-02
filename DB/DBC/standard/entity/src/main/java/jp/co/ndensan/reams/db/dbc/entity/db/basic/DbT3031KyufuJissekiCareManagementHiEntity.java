package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;

/**
 * 給付実績ケアマネジメント費テーブルのエンティティクラスです。
 */
public class DbT3031KyufuJissekiCareManagementHiEntity extends DbTableEntityBase<DbT3031KyufuJissekiCareManagementHiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3031KyufuJissekiCareManagementHi");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    private RString recodeShubetsuCode;
    private HokenshaNo shokisaiHokenshaNo;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private JigyoshaNo jigyoshoNo;
    private RString shiteiKijungaitoJigyoshoKubunCode;
    private FlexibleDate kyotakuServiceSakuseiIraiYMD;
    private RString toshiNo;
    private RString servicePlanhiMeisaiLineNo;
    private Decimal tanisuTanka;
    private ServiceCode serviceCode;
    private int tanisu;
    private int kaisu;
    private int serviceTanisu;
    private int serivceTanisuTotal;
    private int seikyuKingaku;
    private RString tantoKaigoShienSemmoninNo;
    private RString tekiyo;
    private int riyoushaFutangaku;
    private int atoTanisu;
    private int atoKaisu;
    private int atoServiceTanisu;
    private int atoServiceTanisuTotal;
    private int atoSeikyuKingaku;
    private int atoRiyoshaFutangaku;
    private int saishinsaKaisu;
    private int kagoKaisu;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
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
     * 交換情報識別番号のgetメソッドです。
     * 
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * 交換情報識別番号のsetメソッドです。
     * 
     * @param kokanJohoShikibetsuNo 交換情報識別番号
     */
    public void setKokanJohoShikibetsuNo(@Nonnull KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * 入力識別番号のgetメソッドです。
     * 
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * 入力識別番号のsetメソッドです。
     * 
     * @param inputShikibetsuNo 入力識別番号
     */
    public void setInputShikibetsuNo(@Nonnull NyuryokuShikibetsuNo inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * レコード種別コードのgetメソッドです。
     * 
     * @return レコード種別コード
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * レコード種別コードのsetメソッドです。
     * 
     * @param recodeShubetsuCode レコード種別コード
     */
    public void setRecodeShubetsuCode(@Nonnull RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
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
    public void setShokisaiHokenshaNo(@Nonnull HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
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
    public void setHiHokenshaNo(@Nonnull HihokenshaNo hiHokenshaNo) {
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
    public void setServiceTeikyoYM(@Nonnull FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
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
    public void setJigyoshoNo(@Nonnull JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * 指定／基準該当事業所区分コードのgetメソッドです。
     * 
     * @return 指定／基準該当事業所区分コード
     */
    public RString getShiteiKijungaitoJigyoshoKubunCode() {
        return shiteiKijungaitoJigyoshoKubunCode;
    }

    /**
     * 指定／基準該当事業所区分コードのsetメソッドです。
     * 
     * @param shiteiKijungaitoJigyoshoKubunCode 指定／基準該当事業所区分コード
     */
    public void setShiteiKijungaitoJigyoshoKubunCode(@Nonnull RString shiteiKijungaitoJigyoshoKubunCode) {
        this.shiteiKijungaitoJigyoshoKubunCode = shiteiKijungaitoJigyoshoKubunCode;
    }

    /**
     * 居宅サービス計画作成依頼届出年月日のgetメソッドです。
     * 
     * @return 居宅サービス計画作成依頼届出年月日
     */
    public FlexibleDate getKyotakuServiceSakuseiIraiYMD() {
        return kyotakuServiceSakuseiIraiYMD;
    }

    /**
     * 居宅サービス計画作成依頼届出年月日のsetメソッドです。
     * 
     * @param kyotakuServiceSakuseiIraiYMD 居宅サービス計画作成依頼届出年月日
     */
    public void setKyotakuServiceSakuseiIraiYMD(@Nonnull FlexibleDate kyotakuServiceSakuseiIraiYMD) {
        this.kyotakuServiceSakuseiIraiYMD = kyotakuServiceSakuseiIraiYMD;
    }

    /**
     * 通し番号のgetメソッドです。
     * 
     * @return 通し番号
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * 通し番号のsetメソッドです。
     * 
     * @param toshiNo 通し番号
     */
    public void setToshiNo(@Nonnull RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * サービス計画費明細行番号のgetメソッドです。
     * 
     * @return サービス計画費明細行番号
     */
    public RString getServicePlanhiMeisaiLineNo() {
        return servicePlanhiMeisaiLineNo;
    }

    /**
     * サービス計画費明細行番号のsetメソッドです。
     * 
     * @param servicePlanhiMeisaiLineNo サービス計画費明細行番号
     */
    public void setServicePlanhiMeisaiLineNo(@Nonnull RString servicePlanhiMeisaiLineNo) {
        this.servicePlanhiMeisaiLineNo = servicePlanhiMeisaiLineNo;
    }

    /**
     * 単位数単価のgetメソッドです。
     * 
     * @return 単位数単価
     */
    public Decimal getTanisuTanka() {
        return tanisuTanka;
    }

    /**
     * 単位数単価のsetメソッドです。
     * 
     * @param tanisuTanka 単位数単価
     */
    public void setTanisuTanka(@Nonnull Decimal tanisuTanka) {
        this.tanisuTanka = tanisuTanka;
    }

    /**
     * サービスコードのgetメソッドです。
     * 
     * @return サービスコード
     */
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * サービスコードのsetメソッドです。
     * 
     * @param serviceCode サービスコード
     */
    public void setServiceCode(@Nonnull ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * 単位数のgetメソッドです。
     * 
     * @return 単位数
     */
    @CheckForNull
    public int getTanisu() {
        return tanisu;
    }

    /**
     * 単位数のsetメソッドです。
     * 
     * @param tanisu 単位数
     */
    public void setTanisu(int tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * 回数のgetメソッドです。
     * 
     * @return 回数
     */
    @CheckForNull
    public int getKaisu() {
        return kaisu;
    }

    /**
     * 回数のsetメソッドです。
     * 
     * @param kaisu 回数
     */
    public void setKaisu(int kaisu) {
        this.kaisu = kaisu;
    }

    /**
     * サービス単位数のgetメソッドです。
     * 
     * @return サービス単位数
     */
    @CheckForNull
    public int getServiceTanisu() {
        return serviceTanisu;
    }

    /**
     * サービス単位数のsetメソッドです。
     * 
     * @param serviceTanisu サービス単位数
     */
    public void setServiceTanisu(int serviceTanisu) {
        this.serviceTanisu = serviceTanisu;
    }

    /**
     * サービス単位数合計のgetメソッドです。
     * 
     * @return サービス単位数合計
     */
    @CheckForNull
    public int getSerivceTanisuTotal() {
        return serivceTanisuTotal;
    }

    /**
     * サービス単位数合計のsetメソッドです。
     * 
     * @param serivceTanisuTotal サービス単位数合計
     */
    public void setSerivceTanisuTotal(int serivceTanisuTotal) {
        this.serivceTanisuTotal = serivceTanisuTotal;
    }

    /**
     * 請求金額のgetメソッドです。
     * 
     * @return 請求金額
     */
    @CheckForNull
    public int getSeikyuKingaku() {
        return seikyuKingaku;
    }

    /**
     * 請求金額のsetメソッドです。
     * 
     * @param seikyuKingaku 請求金額
     */
    public void setSeikyuKingaku(int seikyuKingaku) {
        this.seikyuKingaku = seikyuKingaku;
    }

    /**
     * 担当介護支援専門員番号のgetメソッドです。
     * 
     * @return 担当介護支援専門員番号
     */
    @CheckForNull
    public RString getTantoKaigoShienSemmoninNo() {
        return tantoKaigoShienSemmoninNo;
    }

    /**
     * 担当介護支援専門員番号のsetメソッドです。
     * 
     * @param tantoKaigoShienSemmoninNo 担当介護支援専門員番号
     */
    public void setTantoKaigoShienSemmoninNo(RString tantoKaigoShienSemmoninNo) {
        this.tantoKaigoShienSemmoninNo = tantoKaigoShienSemmoninNo;
    }

    /**
     * 摘要のgetメソッドです。
     * 
     * @return 摘要
     */
    @CheckForNull
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * 摘要のsetメソッドです。
     * 
     * @param tekiyo 摘要
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
    }

    /**
     * 利用者負担額のgetメソッドです。
     * 
     * @return 利用者負担額
     */
    @CheckForNull
    public int getRiyoushaFutangaku() {
        return riyoushaFutangaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     * 
     * @param riyoushaFutangaku 利用者負担額
     */
    public void setRiyoushaFutangaku(int riyoushaFutangaku) {
        this.riyoushaFutangaku = riyoushaFutangaku;
    }

    /**
     * 後・単位数のgetメソッドです。
     * 
     * @return 後・単位数
     */
    @CheckForNull
    public int getAtoTanisu() {
        return atoTanisu;
    }

    /**
     * 後・単位数のsetメソッドです。
     * 
     * @param atoTanisu 後・単位数
     */
    public void setAtoTanisu(int atoTanisu) {
        this.atoTanisu = atoTanisu;
    }

    /**
     * 後・回数のgetメソッドです。
     * 
     * @return 後・回数
     */
    @CheckForNull
    public int getAtoKaisu() {
        return atoKaisu;
    }

    /**
     * 後・回数のsetメソッドです。
     * 
     * @param atoKaisu 後・回数
     */
    public void setAtoKaisu(int atoKaisu) {
        this.atoKaisu = atoKaisu;
    }

    /**
     * 後・サービス単位数のgetメソッドです。
     * 
     * @return 後・サービス単位数
     */
    @CheckForNull
    public int getAtoServiceTanisu() {
        return atoServiceTanisu;
    }

    /**
     * 後・サービス単位数のsetメソッドです。
     * 
     * @param atoServiceTanisu 後・サービス単位数
     */
    public void setAtoServiceTanisu(int atoServiceTanisu) {
        this.atoServiceTanisu = atoServiceTanisu;
    }

    /**
     * 後・サービス単位数合計のgetメソッドです。
     * 
     * @return 後・サービス単位数合計
     */
    @CheckForNull
    public int getAtoServiceTanisuTotal() {
        return atoServiceTanisuTotal;
    }

    /**
     * 後・サービス単位数合計のsetメソッドです。
     * 
     * @param atoServiceTanisuTotal 後・サービス単位数合計
     */
    public void setAtoServiceTanisuTotal(int atoServiceTanisuTotal) {
        this.atoServiceTanisuTotal = atoServiceTanisuTotal;
    }

    /**
     * 後・請求金額のgetメソッドです。
     * 
     * @return 後・請求金額
     */
    @CheckForNull
    public int getAtoSeikyuKingaku() {
        return atoSeikyuKingaku;
    }

    /**
     * 後・請求金額のsetメソッドです。
     * 
     * @param atoSeikyuKingaku 後・請求金額
     */
    public void setAtoSeikyuKingaku(int atoSeikyuKingaku) {
        this.atoSeikyuKingaku = atoSeikyuKingaku;
    }

    /**
     * 後・利用者負担額のgetメソッドです。
     * 
     * @return 後・利用者負担額
     */
    @CheckForNull
    public int getAtoRiyoshaFutangaku() {
        return atoRiyoshaFutangaku;
    }

    /**
     * 後・利用者負担額のsetメソッドです。
     * 
     * @param atoRiyoshaFutangaku 後・利用者負担額
     */
    public void setAtoRiyoshaFutangaku(int atoRiyoshaFutangaku) {
        this.atoRiyoshaFutangaku = atoRiyoshaFutangaku;
    }

    /**
     * 再審査回数のgetメソッドです。
     * 
     * @return 再審査回数
     */
    @CheckForNull
    public int getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * 再審査回数のsetメソッドです。
     * 
     * @param saishinsaKaisu 再審査回数
     */
    public void setSaishinsaKaisu(int saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * 過誤回数のgetメソッドです。
     * 
     * @return 過誤回数
     */
    @CheckForNull
    public int getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * 過誤回数のsetメソッドです。
     * 
     * @param kagoKaisu 過誤回数
     */
    public void setKagoKaisu(int kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
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
    public void setShinsaYM(@Nonnull FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * 整理番号のgetメソッドです。
     * 
     * @return 整理番号
     */
    @CheckForNull
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * 整理番号のsetメソッドです。
     * 
     * @param seiriNo 整理番号
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * 取込年月のgetメソッドです。
     * 
     * @return 取込年月
     */
    @CheckForNull
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
     * このエンティティの主キーが他の{@literal DbT3031KyufuJissekiCareManagementHiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3031KyufuJissekiCareManagementHiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3031KyufuJissekiCareManagementHiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3031KyufuJissekiCareManagementHiEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.shiteiKijungaitoJigyoshoKubunCode = entity.shiteiKijungaitoJigyoshoKubunCode;
        this.kyotakuServiceSakuseiIraiYMD = entity.kyotakuServiceSakuseiIraiYMD;
        this.toshiNo = entity.toshiNo;
        this.servicePlanhiMeisaiLineNo = entity.servicePlanhiMeisaiLineNo;
        this.tanisuTanka = entity.tanisuTanka;
        this.serviceCode = entity.serviceCode;
        this.tanisu = entity.tanisu;
        this.kaisu = entity.kaisu;
        this.serviceTanisu = entity.serviceTanisu;
        this.serivceTanisuTotal = entity.serivceTanisuTotal;
        this.seikyuKingaku = entity.seikyuKingaku;
        this.tantoKaigoShienSemmoninNo = entity.tantoKaigoShienSemmoninNo;
        this.tekiyo = entity.tekiyo;
        this.riyoushaFutangaku = entity.riyoushaFutangaku;
        this.atoTanisu = entity.atoTanisu;
        this.atoKaisu = entity.atoKaisu;
        this.atoServiceTanisu = entity.atoServiceTanisu;
        this.atoServiceTanisuTotal = entity.atoServiceTanisuTotal;
        this.atoSeikyuKingaku = entity.atoSeikyuKingaku;
        this.atoRiyoshaFutangaku = entity.atoRiyoshaFutangaku;
        this.saishinsaKaisu = entity.saishinsaKaisu;
        this.kagoKaisu = entity.kagoKaisu;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, shiteiKijungaitoJigyoshoKubunCode, kyotakuServiceSakuseiIraiYMD, toshiNo, servicePlanhiMeisaiLineNo, tanisuTanka, serviceCode, tanisu, kaisu, serviceTanisu, serivceTanisuTotal, seikyuKingaku, tantoKaigoShienSemmoninNo, tekiyo, riyoushaFutangaku, atoTanisu, atoKaisu, atoServiceTanisu, atoServiceTanisuTotal, atoSeikyuKingaku, atoRiyoshaFutangaku, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>



}
