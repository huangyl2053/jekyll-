package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;

/**
 * 給付実績高額介護サービス費テーブルのエンティティクラスです。
 */
public class DbT3028KyufujissekiKogakuKaigoServicehiEntity extends DbTableEntityBase<DbT3028KyufujissekiKogakuKaigoServicehiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3028KyufujissekiKogakuKaigoServicehi");

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
    private RString kyufuSakuseiKubunCode;
    private RString kyufuJissekiKubunCode;
    private RString toshiNo;
    private FlexibleDate uketsukeYMD;
    private FlexibleDate ketteiYMD;
    private RString kohi1FutanNo;
    private RString kohi2FutanNo;
    private RString kohi3FutanNo;
    private int riyoshaFutangaku;
    private int kohi1Futangaku;
    private int kohi2Futangaku;
    private int kohi3Futangaku;
    private int shikyugaku;
    private int kohi1Shikyugaku;
    private int kohi2Shikyugaku;
    private int kohi3Shikyugaku;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
    private FlexibleYearMonth sofuYM;
    private FlexibleYearMonth torikomiYM;
    private RString sakuseiKubun;
    private RString kanriNo;
    private boolean hokenshaHoyuKyufujissekiJohoSakujoZumiFlag;

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
     * 給付実績情報作成区分コードのgetメソッドです。
     * 
     * @return 給付実績情報作成区分コード
     */
    public RString getKyufuSakuseiKubunCode() {
        return kyufuSakuseiKubunCode;
    }

    /**
     * 給付実績情報作成区分コードのsetメソッドです。
     * 
     * @param kyufuSakuseiKubunCode 給付実績情報作成区分コード
     */
    public void setKyufuSakuseiKubunCode(@Nonnull RString kyufuSakuseiKubunCode) {
        this.kyufuSakuseiKubunCode = kyufuSakuseiKubunCode;
    }

    /**
     * 給付実績区分コードのgetメソッドです。
     * 
     * @return 給付実績区分コード
     */
    public RString getKyufuJissekiKubunCode() {
        return kyufuJissekiKubunCode;
    }

    /**
     * 給付実績区分コードのsetメソッドです。
     * 
     * @param kyufuJissekiKubunCode 給付実績区分コード
     */
    public void setKyufuJissekiKubunCode(@Nonnull RString kyufuJissekiKubunCode) {
        this.kyufuJissekiKubunCode = kyufuJissekiKubunCode;
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
     * 受付年月日のgetメソッドです。
     * 
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     * 
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(@Nonnull FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 決定年月日のgetメソッドです。
     * 
     * @return 決定年月日
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定年月日のsetメソッドです。
     * 
     * @param ketteiYMD 決定年月日
     */
    public void setKetteiYMD(@Nonnull FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 公費１負担番号のgetメソッドです。
     * 
     * @return 公費１負担番号
     */
    @CheckForNull
    public RString getKohi1FutanNo() {
        return kohi1FutanNo;
    }

    /**
     * 公費１負担番号のsetメソッドです。
     * 
     * @param kohi1FutanNo 公費１負担番号
     */
    public void setKohi1FutanNo(RString kohi1FutanNo) {
        this.kohi1FutanNo = kohi1FutanNo;
    }

    /**
     * 公費２負担番号のgetメソッドです。
     * 
     * @return 公費２負担番号
     */
    @CheckForNull
    public RString getKohi2FutanNo() {
        return kohi2FutanNo;
    }

    /**
     * 公費２負担番号のsetメソッドです。
     * 
     * @param kohi2FutanNo 公費２負担番号
     */
    public void setKohi2FutanNo(RString kohi2FutanNo) {
        this.kohi2FutanNo = kohi2FutanNo;
    }

    /**
     * 公費３負担番号のgetメソッドです。
     * 
     * @return 公費３負担番号
     */
    @CheckForNull
    public RString getKohi3FutanNo() {
        return kohi3FutanNo;
    }

    /**
     * 公費３負担番号のsetメソッドです。
     * 
     * @param kohi3FutanNo 公費３負担番号
     */
    public void setKohi3FutanNo(RString kohi3FutanNo) {
        this.kohi3FutanNo = kohi3FutanNo;
    }

    /**
     * 利用者負担額のgetメソッドです。
     * 
     * @return 利用者負担額
     */
    public int getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     * 
     * @param riyoshaFutangaku 利用者負担額
     */
    public void setRiyoshaFutangaku(@Nonnull int riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * 公費１負担額のgetメソッドです。
     * 
     * @return 公費１負担額
     */
    @CheckForNull
    public int getKohi1Futangaku() {
        return kohi1Futangaku;
    }

    /**
     * 公費１負担額のsetメソッドです。
     * 
     * @param kohi1Futangaku 公費１負担額
     */
    public void setKohi1Futangaku(int kohi1Futangaku) {
        this.kohi1Futangaku = kohi1Futangaku;
    }

    /**
     * 公費２負担額のgetメソッドです。
     * 
     * @return 公費２負担額
     */
    @CheckForNull
    public int getKohi2Futangaku() {
        return kohi2Futangaku;
    }

    /**
     * 公費２負担額のsetメソッドです。
     * 
     * @param kohi2Futangaku 公費２負担額
     */
    public void setKohi2Futangaku(int kohi2Futangaku) {
        this.kohi2Futangaku = kohi2Futangaku;
    }

    /**
     * 公費３負担額のgetメソッドです。
     * 
     * @return 公費３負担額
     */
    @CheckForNull
    public int getKohi3Futangaku() {
        return kohi3Futangaku;
    }

    /**
     * 公費３負担額のsetメソッドです。
     * 
     * @param kohi3Futangaku 公費３負担額
     */
    public void setKohi3Futangaku(int kohi3Futangaku) {
        this.kohi3Futangaku = kohi3Futangaku;
    }

    /**
     * 支給額のgetメソッドです。
     * 
     * @return 支給額
     */
    public int getShikyugaku() {
        return shikyugaku;
    }

    /**
     * 支給額のsetメソッドです。
     * 
     * @param shikyugaku 支給額
     */
    public void setShikyugaku(@Nonnull int shikyugaku) {
        this.shikyugaku = shikyugaku;
    }

    /**
     * 公費１支給額のgetメソッドです。
     * 
     * @return 公費１支給額
     */
    @CheckForNull
    public int getKohi1Shikyugaku() {
        return kohi1Shikyugaku;
    }

    /**
     * 公費１支給額のsetメソッドです。
     * 
     * @param kohi1Shikyugaku 公費１支給額
     */
    public void setKohi1Shikyugaku(int kohi1Shikyugaku) {
        this.kohi1Shikyugaku = kohi1Shikyugaku;
    }

    /**
     * 公費２支給額のgetメソッドです。
     * 
     * @return 公費２支給額
     */
    @CheckForNull
    public int getKohi2Shikyugaku() {
        return kohi2Shikyugaku;
    }

    /**
     * 公費２支給額のsetメソッドです。
     * 
     * @param kohi2Shikyugaku 公費２支給額
     */
    public void setKohi2Shikyugaku(int kohi2Shikyugaku) {
        this.kohi2Shikyugaku = kohi2Shikyugaku;
    }

    /**
     * 公費３支給額のgetメソッドです。
     * 
     * @return 公費３支給額
     */
    @CheckForNull
    public int getKohi3Shikyugaku() {
        return kohi3Shikyugaku;
    }

    /**
     * 公費３支給額のsetメソッドです。
     * 
     * @param kohi3Shikyugaku 公費３支給額
     */
    public void setKohi3Shikyugaku(int kohi3Shikyugaku) {
        this.kohi3Shikyugaku = kohi3Shikyugaku;
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
     * 送付年月のgetメソッドです。
     * 
     * @return 送付年月
     */
    @CheckForNull
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * 送付年月のsetメソッドです。
     * 
     * @param sofuYM 送付年月
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
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
     * 作成区分のgetメソッドです。
     * <br/>
     * <br/>0：国保連受取　1：独自作成
     * 
     * @return 作成区分
     */
    @CheckForNull
    public RString getSakuseiKubun() {
        return sakuseiKubun;
    }

    /**
     * 作成区分のsetメソッドです。
     * <br/>
     * <br/>0：国保連受取　1：独自作成
     * 
     * @param sakuseiKubun 作成区分
     */
    public void setSakuseiKubun(RString sakuseiKubun) {
        this.sakuseiKubun = sakuseiKubun;
    }

    /**
     * 管理番号のgetメソッドです。
     * <br/>
     * <br/>高額申請管理ﾏｽﾀの"管理番号"とﾘﾝｸ
     * <br/>高額支給申請書更新時のみ設定される
     * 
     * @return 管理番号
     */
    @CheckForNull
    public RString getKanriNo() {
        return kanriNo;
    }

    /**
     * 管理番号のsetメソッドです。
     * <br/>
     * <br/>高額申請管理ﾏｽﾀの"管理番号"とﾘﾝｸ
     * <br/>高額支給申請書更新時のみ設定される
     * 
     * @param kanriNo 管理番号
     */
    public void setKanriNo(RString kanriNo) {
        this.kanriNo = kanriNo;
    }

    /**
     * 保険者保有給付実績情報削除済フラグのgetメソッドです。
     * 
     * @return 保険者保有給付実績情報削除済フラグ
     */
    @CheckForNull
    public boolean getHokenshaHoyuKyufujissekiJohoSakujoZumiFlag() {
        return hokenshaHoyuKyufujissekiJohoSakujoZumiFlag;
    }

    /**
     * 保険者保有給付実績情報削除済フラグのsetメソッドです。
     * 
     * @param hokenshaHoyuKyufujissekiJohoSakujoZumiFlag 保険者保有給付実績情報削除済フラグ
     */
    public void setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag(boolean hokenshaHoyuKyufujissekiJohoSakujoZumiFlag) {
        this.hokenshaHoyuKyufujissekiJohoSakujoZumiFlag = hokenshaHoyuKyufujissekiJohoSakujoZumiFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3028KyufujissekiKogakuKaigoServicehiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3028KyufujissekiKogakuKaigoServicehiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3028KyufujissekiKogakuKaigoServicehiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3028KyufujissekiKogakuKaigoServicehiEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.kyufuSakuseiKubunCode = entity.kyufuSakuseiKubunCode;
        this.kyufuJissekiKubunCode = entity.kyufuJissekiKubunCode;
        this.toshiNo = entity.toshiNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.kohi1FutanNo = entity.kohi1FutanNo;
        this.kohi2FutanNo = entity.kohi2FutanNo;
        this.kohi3FutanNo = entity.kohi3FutanNo;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.kohi1Futangaku = entity.kohi1Futangaku;
        this.kohi2Futangaku = entity.kohi2Futangaku;
        this.kohi3Futangaku = entity.kohi3Futangaku;
        this.shikyugaku = entity.shikyugaku;
        this.kohi1Shikyugaku = entity.kohi1Shikyugaku;
        this.kohi2Shikyugaku = entity.kohi2Shikyugaku;
        this.kohi3Shikyugaku = entity.kohi3Shikyugaku;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.sofuYM = entity.sofuYM;
        this.torikomiYM = entity.torikomiYM;
        this.sakuseiKubun = entity.sakuseiKubun;
        this.kanriNo = entity.kanriNo;
        this.hokenshaHoyuKyufujissekiJohoSakujoZumiFlag = entity.hokenshaHoyuKyufujissekiJohoSakujoZumiFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, kyufuSakuseiKubunCode, kyufuJissekiKubunCode, toshiNo, uketsukeYMD, ketteiYMD, kohi1FutanNo, kohi2FutanNo, kohi3FutanNo, riyoshaFutangaku, kohi1Futangaku, kohi2Futangaku, kohi3Futangaku, shikyugaku, kohi1Shikyugaku, kohi2Shikyugaku, kohi3Shikyugaku, shinsaYM, seiriNo, sofuYM, torikomiYM, sakuseiKubun, kanriNo, hokenshaHoyuKyufujissekiJohoSakujoZumiFlag);
    }

// </editor-fold>

}
