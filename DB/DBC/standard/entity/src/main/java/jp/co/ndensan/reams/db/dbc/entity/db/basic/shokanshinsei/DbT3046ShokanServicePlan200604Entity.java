package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 償還払請求サービス計画200604テーブルのエンティティクラスです。
 */
public class DbT3046ShokanServicePlan200604Entity extends DbTableEntityBase<DbT3046ShokanServicePlan200604Entity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3046ShokanServicePlan200604");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNp;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private RString meisaiNo;
    @PrimaryKey
    private RString renban;
    private RString shiteiKijunGaitoJigyoshaKubunCode;
    private FlexibleDate kyotakuServiceSakuseiIraiYMD;
    private ServiceCode serviceCode;
    private int tanisu;
    private Decimal tanisuTanka;
    private int seikyuKingaku;
    private RString tantokangoshienSemmoninNo;
    private RString tekiyo;
    private RString shinsaHohoKubunCode;
    private FlexibleYearMonth shinsaYM;
    private RString shikyuKubunCode;
    private int tensuKingaku;
    private int shikyuKingaku;
    private int zougenTen;
    private int sagakuKingaku;
    private RString zougenRiyu;
    private RString fushikyuRiyu;
    private RString kounyuKaishuRireki;

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
     * 整理番号のgetメソッドです。
     * 
     * @return 整理番号
     */
    public RString getSeiriNp() {
        return seiriNp;
    }

    /**
     * 整理番号のsetメソッドです。
     * 
     * @param seiriNp 整理番号
     */
    public void setSeiriNp(@Nonnull RString seiriNp) {
        this.seiriNp = seiriNp;
    }

    /**
     * 事業者番号のgetメソッドです。
     * 
     * @return 事業者番号
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     * 
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(@Nonnull JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 様式番号のgetメソッドです。
     * 
     * @return 様式番号
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * 様式番号のsetメソッドです。
     * 
     * @param yoshikiNo 様式番号
     */
    public void setYoshikiNo(@Nonnull RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * 明細番号のgetメソッドです。
     * 
     * @return 明細番号
     */
    public RString getMeisaiNo() {
        return meisaiNo;
    }

    /**
     * 明細番号のsetメソッドです。
     * 
     * @param meisaiNo 明細番号
     */
    public void setMeisaiNo(@Nonnull RString meisaiNo) {
        this.meisaiNo = meisaiNo;
    }

    /**
     * 連番のgetメソッドです。
     * 
     * @return 連番
     */
    public RString getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     * 
     * @param renban 連番
     */
    public void setRenban(@Nonnull RString renban) {
        this.renban = renban;
    }

    /**
     * 指定／基準該当事業者区分コードのgetメソッドです。
     * 
     * @return 指定／基準該当事業者区分コード
     */
    @CheckForNull
    public RString getShiteiKijunGaitoJigyoshaKubunCode() {
        return shiteiKijunGaitoJigyoshaKubunCode;
    }

    /**
     * 指定／基準該当事業者区分コードのsetメソッドです。
     * 
     * @param shiteiKijunGaitoJigyoshaKubunCode 指定／基準該当事業者区分コード
     */
    public void setShiteiKijunGaitoJigyoshaKubunCode(RString shiteiKijunGaitoJigyoshaKubunCode) {
        this.shiteiKijunGaitoJigyoshaKubunCode = shiteiKijunGaitoJigyoshaKubunCode;
    }

    /**
     * 居宅サービス計画作成依頼届出年月日のgetメソッドです。
     * 
     * @return 居宅サービス計画作成依頼届出年月日
     */
    @CheckForNull
    public FlexibleDate getKyotakuServiceSakuseiIraiYMD() {
        return kyotakuServiceSakuseiIraiYMD;
    }

    /**
     * 居宅サービス計画作成依頼届出年月日のsetメソッドです。
     * 
     * @param kyotakuServiceSakuseiIraiYMD 居宅サービス計画作成依頼届出年月日
     */
    public void setKyotakuServiceSakuseiIraiYMD(FlexibleDate kyotakuServiceSakuseiIraiYMD) {
        this.kyotakuServiceSakuseiIraiYMD = kyotakuServiceSakuseiIraiYMD;
    }

    /**
     * サービスコードのgetメソッドです。
     * 
     * @return サービスコード
     */
    @CheckForNull
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * サービスコードのsetメソッドです。
     * 
     * @param serviceCode サービスコード
     */
    public void setServiceCode(ServiceCode serviceCode) {
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
     * 単位数単価のgetメソッドです。
     * 
     * @return 単位数単価
     */
    @CheckForNull
    public Decimal getTanisuTanka() {
        return tanisuTanka;
    }

    /**
     * 単位数単価のsetメソッドです。
     * 
     * @param tanisuTanka 単位数単価
     */
    public void setTanisuTanka(Decimal tanisuTanka) {
        this.tanisuTanka = tanisuTanka;
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
    public RString getTantokangoshienSemmoninNo() {
        return tantokangoshienSemmoninNo;
    }

    /**
     * 担当介護支援専門員番号のsetメソッドです。
     * 
     * @param tantokangoshienSemmoninNo 担当介護支援専門員番号
     */
    public void setTantokangoshienSemmoninNo(RString tantokangoshienSemmoninNo) {
        this.tantokangoshienSemmoninNo = tantokangoshienSemmoninNo;
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
     * 審査方法区分コードのgetメソッドです。
     * 
     * @return 審査方法区分コード
     */
    @CheckForNull
    public RString getShinsaHohoKubunCode() {
        return shinsaHohoKubunCode;
    }

    /**
     * 審査方法区分コードのsetメソッドです。
     * 
     * @param shinsaHohoKubunCode 審査方法区分コード
     */
    public void setShinsaHohoKubunCode(RString shinsaHohoKubunCode) {
        this.shinsaHohoKubunCode = shinsaHohoKubunCode;
    }

    /**
     * 審査年月のgetメソッドです。
     * 
     * @return 審査年月
     */
    @CheckForNull
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
     * 支給区分コードのgetメソッドです。
     * 
     * @return 支給区分コード
     */
    @CheckForNull
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * 支給区分コードのsetメソッドです。
     * 
     * @param shikyuKubunCode 支給区分コード
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * 点数／金額のgetメソッドです。
     * 
     * @return 点数／金額
     */
    @CheckForNull
    public int getTensuKingaku() {
        return tensuKingaku;
    }

    /**
     * 点数／金額のsetメソッドです。
     * 
     * @param tensuKingaku 点数／金額
     */
    public void setTensuKingaku(int tensuKingaku) {
        this.tensuKingaku = tensuKingaku;
    }

    /**
     * 支給金額のgetメソッドです。
     * 
     * @return 支給金額
     */
    @CheckForNull
    public int getShikyuKingaku() {
        return shikyuKingaku;
    }

    /**
     * 支給金額のsetメソッドです。
     * 
     * @param shikyuKingaku 支給金額
     */
    public void setShikyuKingaku(int shikyuKingaku) {
        this.shikyuKingaku = shikyuKingaku;
    }

    /**
     * 増減点のgetメソッドです。
     * 
     * @return 増減点
     */
    @CheckForNull
    public int getZougenTen() {
        return zougenTen;
    }

    /**
     * 増減点のsetメソッドです。
     * 
     * @param zougenTen 増減点
     */
    public void setZougenTen(int zougenTen) {
        this.zougenTen = zougenTen;
    }

    /**
     * 差額金額のgetメソッドです。
     * 
     * @return 差額金額
     */
    @CheckForNull
    public int getSagakuKingaku() {
        return sagakuKingaku;
    }

    /**
     * 差額金額のsetメソッドです。
     * 
     * @param sagakuKingaku 差額金額
     */
    public void setSagakuKingaku(int sagakuKingaku) {
        this.sagakuKingaku = sagakuKingaku;
    }

    /**
     * 増減理由等のgetメソッドです。
     * 
     * @return 増減理由等
     */
    @CheckForNull
    public RString getZougenRiyu() {
        return zougenRiyu;
    }

    /**
     * 増減理由等のsetメソッドです。
     * 
     * @param zougenRiyu 増減理由等
     */
    public void setZougenRiyu(RString zougenRiyu) {
        this.zougenRiyu = zougenRiyu;
    }

    /**
     * 不支給理由等のgetメソッドです。
     * 
     * @return 不支給理由等
     */
    @CheckForNull
    public RString getFushikyuRiyu() {
        return fushikyuRiyu;
    }

    /**
     * 不支給理由等のsetメソッドです。
     * 
     * @param fushikyuRiyu 不支給理由等
     */
    public void setFushikyuRiyu(RString fushikyuRiyu) {
        this.fushikyuRiyu = fushikyuRiyu;
    }

    /**
     * 購入・改修履歴等のgetメソッドです。
     * 
     * @return 購入・改修履歴等
     */
    @CheckForNull
    public RString getKounyuKaishuRireki() {
        return kounyuKaishuRireki;
    }

    /**
     * 購入・改修履歴等のsetメソッドです。
     * 
     * @param kounyuKaishuRireki 購入・改修履歴等
     */
    public void setKounyuKaishuRireki(RString kounyuKaishuRireki) {
        this.kounyuKaishuRireki = kounyuKaishuRireki;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3046ShokanServicePlan200604Entity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3046ShokanServicePlan200604Entity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3046ShokanServicePlan200604Entity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNp, other.seiriNp)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
            return false;
        }
        if (!Objects.equals(this.meisaiNo, other.meisaiNo)) {
            return false;
        }
        if (!Objects.equals(this.renban, other.renban)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3046ShokanServicePlan200604Entity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNp = entity.seiriNp;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.meisaiNo = entity.meisaiNo;
        this.renban = entity.renban;
        this.shiteiKijunGaitoJigyoshaKubunCode = entity.shiteiKijunGaitoJigyoshaKubunCode;
        this.kyotakuServiceSakuseiIraiYMD = entity.kyotakuServiceSakuseiIraiYMD;
        this.serviceCode = entity.serviceCode;
        this.tanisu = entity.tanisu;
        this.tanisuTanka = entity.tanisuTanka;
        this.seikyuKingaku = entity.seikyuKingaku;
        this.tantokangoshienSemmoninNo = entity.tantokangoshienSemmoninNo;
        this.tekiyo = entity.tekiyo;
        this.shinsaHohoKubunCode = entity.shinsaHohoKubunCode;
        this.shinsaYM = entity.shinsaYM;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.tensuKingaku = entity.tensuKingaku;
        this.shikyuKingaku = entity.shikyuKingaku;
        this.zougenTen = entity.zougenTen;
        this.sagakuKingaku = entity.sagakuKingaku;
        this.zougenRiyu = entity.zougenRiyu;
        this.fushikyuRiyu = entity.fushikyuRiyu;
        this.kounyuKaishuRireki = entity.kounyuKaishuRireki;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNp, jigyoshaNo, yoshikiNo, meisaiNo, renban, shiteiKijunGaitoJigyoshaKubunCode, kyotakuServiceSakuseiIraiYMD, serviceCode, tanisu, tanisuTanka, seikyuKingaku, tantokangoshienSemmoninNo, tekiyo, shinsaHohoKubunCode, shinsaYM, shikyuKubunCode, tensuKingaku, shikyuKingaku, zougenTen, sagakuKingaku, zougenRiyu, fushikyuRiyu, kounyuKaishuRireki);
    }

// </editor-fold>
}
