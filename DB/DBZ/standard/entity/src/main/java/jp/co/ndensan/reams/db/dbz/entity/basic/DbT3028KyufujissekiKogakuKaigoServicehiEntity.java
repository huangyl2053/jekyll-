package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3028KyufujissekiKogakuKaigoServicehiの項目定義クラスです
 *
 */
public class DbT3028KyufujissekiKogakuKaigoServicehiEntity extends DbTableEntityBase<DbT3028KyufujissekiKogakuKaigoServicehiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    @PrimaryKey
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @PrimaryKey
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString toshiNo;
    @PrimaryKey
    private RString kyufuSakuseiKubunCode;
    @PrimaryKey
    private RString kyufuJissekiKubunCode;
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
     * getKokanJohoShikibetsuNo
     *
     * @return kokanJohoShikibetsuNo
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * setKokanJohoShikibetsuNo
     *
     * @param kokanJohoShikibetsuNo kokanJohoShikibetsuNo
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * getInputShikibetsuNo
     *
     * @return inputShikibetsuNo
     */
    public NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * setInputShikibetsuNo
     *
     * @param inputShikibetsuNo inputShikibetsuNo
     */
    public void setInputShikibetsuNo(NyuryokuShikibetsuNo inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * getRecodeShubetsuCode
     *
     * @return recodeShubetsuCode
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * setRecodeShubetsuCode
     *
     * @param recodeShubetsuCode recodeShubetsuCode
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * getShokisaiHokenshaNo
     *
     * @return shokisaiHokenshaNo
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     *
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getToshiNo
     *
     * @return toshiNo
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * setToshiNo
     *
     * @param toshiNo toshiNo
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * getKyufuSakuseiKubunCode
     *
     * @return kyufuSakuseiKubunCode
     */
    public RString getKyufuSakuseiKubunCode() {
        return kyufuSakuseiKubunCode;
    }

    /**
     * setKyufuSakuseiKubunCode
     *
     * @param kyufuSakuseiKubunCode kyufuSakuseiKubunCode
     */
    public void setKyufuSakuseiKubunCode(RString kyufuSakuseiKubunCode) {
        this.kyufuSakuseiKubunCode = kyufuSakuseiKubunCode;
    }

    /**
     * getKyufuJissekiKubunCode
     *
     * @return kyufuJissekiKubunCode
     */
    public RString getKyufuJissekiKubunCode() {
        return kyufuJissekiKubunCode;
    }

    /**
     * setKyufuJissekiKubunCode
     *
     * @param kyufuJissekiKubunCode kyufuJissekiKubunCode
     */
    public void setKyufuJissekiKubunCode(RString kyufuJissekiKubunCode) {
        this.kyufuJissekiKubunCode = kyufuJissekiKubunCode;
    }

    /**
     * getUketsukeYMD
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * setUketsukeYMD
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * getKetteiYMD
     *
     * @return ketteiYMD
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * setKetteiYMD
     *
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * getKohi1FutanNo
     *
     * @return kohi1FutanNo
     */
    public RString getKohi1FutanNo() {
        return kohi1FutanNo;
    }

    /**
     * setKohi1FutanNo
     *
     * @param kohi1FutanNo kohi1FutanNo
     */
    public void setKohi1FutanNo(RString kohi1FutanNo) {
        this.kohi1FutanNo = kohi1FutanNo;
    }

    /**
     * getKohi2FutanNo
     *
     * @return kohi2FutanNo
     */
    public RString getKohi2FutanNo() {
        return kohi2FutanNo;
    }

    /**
     * setKohi2FutanNo
     *
     * @param kohi2FutanNo kohi2FutanNo
     */
    public void setKohi2FutanNo(RString kohi2FutanNo) {
        this.kohi2FutanNo = kohi2FutanNo;
    }

    /**
     * getKohi3FutanNo
     *
     * @return kohi3FutanNo
     */
    public RString getKohi3FutanNo() {
        return kohi3FutanNo;
    }

    /**
     * setKohi3FutanNo
     *
     * @param kohi3FutanNo kohi3FutanNo
     */
    public void setKohi3FutanNo(RString kohi3FutanNo) {
        this.kohi3FutanNo = kohi3FutanNo;
    }

    /**
     * getRiyoshaFutangaku
     *
     * @return riyoshaFutangaku
     */
    public int getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * setRiyoshaFutangaku
     *
     * @param riyoshaFutangaku riyoshaFutangaku
     */
    public void setRiyoshaFutangaku(int riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * getKohi1Futangaku
     *
     * @return kohi1Futangaku
     */
    public int getKohi1Futangaku() {
        return kohi1Futangaku;
    }

    /**
     * setKohi1Futangaku
     *
     * @param kohi1Futangaku kohi1Futangaku
     */
    public void setKohi1Futangaku(int kohi1Futangaku) {
        this.kohi1Futangaku = kohi1Futangaku;
    }

    /**
     * getKohi2Futangaku
     *
     * @return kohi2Futangaku
     */
    public int getKohi2Futangaku() {
        return kohi2Futangaku;
    }

    /**
     * setKohi2Futangaku
     *
     * @param kohi2Futangaku kohi2Futangaku
     */
    public void setKohi2Futangaku(int kohi2Futangaku) {
        this.kohi2Futangaku = kohi2Futangaku;
    }

    /**
     * getKohi3Futangaku
     *
     * @return kohi3Futangaku
     */
    public int getKohi3Futangaku() {
        return kohi3Futangaku;
    }

    /**
     * setKohi3Futangaku
     *
     * @param kohi3Futangaku kohi3Futangaku
     */
    public void setKohi3Futangaku(int kohi3Futangaku) {
        this.kohi3Futangaku = kohi3Futangaku;
    }

    /**
     * getShikyugaku
     *
     * @return shikyugaku
     */
    public int getShikyugaku() {
        return shikyugaku;
    }

    /**
     * setShikyugaku
     *
     * @param shikyugaku shikyugaku
     */
    public void setShikyugaku(int shikyugaku) {
        this.shikyugaku = shikyugaku;
    }

    /**
     * getKohi1Shikyugaku
     *
     * @return kohi1Shikyugaku
     */
    public int getKohi1Shikyugaku() {
        return kohi1Shikyugaku;
    }

    /**
     * setKohi1Shikyugaku
     *
     * @param kohi1Shikyugaku kohi1Shikyugaku
     */
    public void setKohi1Shikyugaku(int kohi1Shikyugaku) {
        this.kohi1Shikyugaku = kohi1Shikyugaku;
    }

    /**
     * getKohi2Shikyugaku
     *
     * @return kohi2Shikyugaku
     */
    public int getKohi2Shikyugaku() {
        return kohi2Shikyugaku;
    }

    /**
     * setKohi2Shikyugaku
     *
     * @param kohi2Shikyugaku kohi2Shikyugaku
     */
    public void setKohi2Shikyugaku(int kohi2Shikyugaku) {
        this.kohi2Shikyugaku = kohi2Shikyugaku;
    }

    /**
     * getKohi3Shikyugaku
     *
     * @return kohi3Shikyugaku
     */
    public int getKohi3Shikyugaku() {
        return kohi3Shikyugaku;
    }

    /**
     * setKohi3Shikyugaku
     *
     * @param kohi3Shikyugaku kohi3Shikyugaku
     */
    public void setKohi3Shikyugaku(int kohi3Shikyugaku) {
        this.kohi3Shikyugaku = kohi3Shikyugaku;
    }

    /**
     * getShinsaYM
     *
     * @return shinsaYM
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * setShinsaYM
     *
     * @param shinsaYM shinsaYM
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * getSeiriNo
     *
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     *
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * getSofuYM
     *
     * @return sofuYM
     */
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * setSofuYM
     *
     * @param sofuYM sofuYM
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * getTorikomiYM
     *
     * @return torikomiYM
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * setTorikomiYM
     *
     * @param torikomiYM torikomiYM
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * getSakuseiKubun
     *
     * @return sakuseiKubun
     */
    public RString getSakuseiKubun() {
        return sakuseiKubun;
    }

    /**
     * setSakuseiKubun
     *
     * @param sakuseiKubun sakuseiKubun
     */
    public void setSakuseiKubun(RString sakuseiKubun) {
        this.sakuseiKubun = sakuseiKubun;
    }

    /**
     * getKanriNo
     *
     * @return kanriNo
     */
    public RString getKanriNo() {
        return kanriNo;
    }

    /**
     * setKanriNo
     *
     * @param kanriNo kanriNo
     */
    public void setKanriNo(RString kanriNo) {
        this.kanriNo = kanriNo;
    }

    /**
     * getHokenshaHoyuKyufujissekiJohoSakujoZumiFlag
     *
     * @return hokenshaHoyuKyufujissekiJohoSakujoZumiFlag
     */
    public boolean getHokenshaHoyuKyufujissekiJohoSakujoZumiFlag() {
        return hokenshaHoyuKyufujissekiJohoSakujoZumiFlag;
    }

    /**
     * setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag
     *
     * @param hokenshaHoyuKyufujissekiJohoSakujoZumiFlag hokenshaHoyuKyufujissekiJohoSakujoZumiFlag
     */
    public void setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag(boolean hokenshaHoyuKyufujissekiJohoSakujoZumiFlag) {
        this.hokenshaHoyuKyufujissekiJohoSakujoZumiFlag = hokenshaHoyuKyufujissekiJohoSakujoZumiFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3028KyufujissekiKogakuKaigoServicehiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3028KyufujissekiKogakuKaigoServicehiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3028KyufujissekiKogakuKaigoServicehiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kokanJohoShikibetsuNo, other.kokanJohoShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.inputShikibetsuNo, other.inputShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeShubetsuCode, other.recodeShubetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shokisaiHokenshaNo, other.shokisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.toshiNo, other.toshiNo)) {
            return false;
        }
        if (!Objects.equals(this.kyufuSakuseiKubunCode, other.kyufuSakuseiKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.kyufuJissekiKubunCode, other.kyufuJissekiKubunCode)) {
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
        this.toshiNo = entity.toshiNo;
        this.kyufuSakuseiKubunCode = entity.kyufuSakuseiKubunCode;
        this.kyufuJissekiKubunCode = entity.kyufuJissekiKubunCode;
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
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, toshiNo, kyufuSakuseiKubunCode, kyufuJissekiKubunCode, uketsukeYMD, ketteiYMD, kohi1FutanNo, kohi2FutanNo, kohi3FutanNo, riyoshaFutangaku, kohi1Futangaku, kohi2Futangaku, kohi3Futangaku, shikyugaku, kohi1Shikyugaku, kohi2Shikyugaku, kohi3Shikyugaku, shinsaYM, seiriNo, sofuYM, torikomiYM, sakuseiKubun, kanriNo, hokenshaHoyuKyufujissekiJohoSakujoZumiFlag);
    }

// </editor-fold>
}
