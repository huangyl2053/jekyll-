package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7034KoikiGaijiHenkanErrorLogの項目定義クラスです
 *
 */
public class DbT7034KoikiGaijiHenkanErrorLogEntity extends DbTableEntityBase<DbT7034KoikiGaijiHenkanErrorLogEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7034KoikiGaijiHenkanErrorLog");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shoriNo;
    @PrimaryKey
    private RString renNo;
    private LasdecCode shichosonCode;
    private RString shubetsu;
    private RDateTime shoriTimestamp;
    private LasdecCode motoShichosonCode;
    private RString motoShichosonMeisho;
    private LasdecCode sakiShichosonCode;
    private RString sakiShichosonMeisho;
    private ShikibetsuCode jukiShikibetsuCode;
    private RString kakuninKubun;
    private ShikibetsuCode shikibetsuCode;
    private HihokenshaNo hihokenshaNo;
    private RString recoadNo;
    private RString errorKomokuMeisho;
    private RString errorKomokuNo;
    private RString errorCode;
    @PrimaryKey
    private RString errorHyojiRenban;
    private RString errorHyojiKomokuMeisho;
    private RString errorHyojiKomoku;

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
     * getShoriNo
     *
     * @return shoriNo
     */
    public RString getShoriNo() {
        return shoriNo;
    }

    /**
     * setShoriNo
     *
     * @param shoriNo shoriNo
     */
    public void setShoriNo(RString shoriNo) {
        this.shoriNo = shoriNo;
    }

    /**
     * getRenNo
     *
     * @return renNo
     */
    public RString getRenNo() {
        return renNo;
    }

    /**
     * setRenNo
     *
     * @param renNo renNo
     */
    public void setRenNo(RString renNo) {
        this.renNo = renNo;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getShubetsu
     *
     * @return shubetsu
     */
    public RString getShubetsu() {
        return shubetsu;
    }

    /**
     * setShubetsu
     *
     * @param shubetsu shubetsu
     */
    public void setShubetsu(RString shubetsu) {
        this.shubetsu = shubetsu;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getMotoShichosonCode
     *
     * @return motoShichosonCode
     */
    public LasdecCode getMotoShichosonCode() {
        return motoShichosonCode;
    }

    /**
     * setMotoShichosonCode
     *
     * @param motoShichosonCode motoShichosonCode
     */
    public void setMotoShichosonCode(LasdecCode motoShichosonCode) {
        this.motoShichosonCode = motoShichosonCode;
    }

    /**
     * getMotoShichosonMeisho
     *
     * @return motoShichosonMeisho
     */
    public RString getMotoShichosonMeisho() {
        return motoShichosonMeisho;
    }

    /**
     * setMotoShichosonMeisho
     *
     * @param motoShichosonMeisho motoShichosonMeisho
     */
    public void setMotoShichosonMeisho(RString motoShichosonMeisho) {
        this.motoShichosonMeisho = motoShichosonMeisho;
    }

    /**
     * getSakiShichosonCode
     *
     * @return sakiShichosonCode
     */
    public LasdecCode getSakiShichosonCode() {
        return sakiShichosonCode;
    }

    /**
     * setSakiShichosonCode
     *
     * @param sakiShichosonCode sakiShichosonCode
     */
    public void setSakiShichosonCode(LasdecCode sakiShichosonCode) {
        this.sakiShichosonCode = sakiShichosonCode;
    }

    /**
     * getSakiShichosonMeisho
     *
     * @return sakiShichosonMeisho
     */
    public RString getSakiShichosonMeisho() {
        return sakiShichosonMeisho;
    }

    /**
     * setSakiShichosonMeisho
     *
     * @param sakiShichosonMeisho sakiShichosonMeisho
     */
    public void setSakiShichosonMeisho(RString sakiShichosonMeisho) {
        this.sakiShichosonMeisho = sakiShichosonMeisho;
    }

    /**
     * getJukiShikibetsuCode
     *
     * @return jukiShikibetsuCode
     */
    public ShikibetsuCode getJukiShikibetsuCode() {
        return jukiShikibetsuCode;
    }

    /**
     * setJukiShikibetsuCode
     *
     * @param jukiShikibetsuCode jukiShikibetsuCode
     */
    public void setJukiShikibetsuCode(ShikibetsuCode jukiShikibetsuCode) {
        this.jukiShikibetsuCode = jukiShikibetsuCode;
    }

    /**
     * getKakuninKubun
     *
     * @return kakuninKubun
     */
    public RString getKakuninKubun() {
        return kakuninKubun;
    }

    /**
     * setKakuninKubun
     *
     * @param kakuninKubun kakuninKubun
     */
    public void setKakuninKubun(RString kakuninKubun) {
        this.kakuninKubun = kakuninKubun;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
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
     * getRecoadNo
     *
     * @return recoadNo
     */
    public RString getRecoadNo() {
        return recoadNo;
    }

    /**
     * setRecoadNo
     *
     * @param recoadNo recoadNo
     */
    public void setRecoadNo(RString recoadNo) {
        this.recoadNo = recoadNo;
    }

    /**
     * getErrorKomokuMeisho
     *
     * @return errorKomokuMeisho
     */
    public RString getErrorKomokuMeisho() {
        return errorKomokuMeisho;
    }

    /**
     * setErrorKomokuMeisho
     *
     * @param errorKomokuMeisho errorKomokuMeisho
     */
    public void setErrorKomokuMeisho(RString errorKomokuMeisho) {
        this.errorKomokuMeisho = errorKomokuMeisho;
    }

    /**
     * getErrorKomokuNo
     *
     * @return errorKomokuNo
     */
    public RString getErrorKomokuNo() {
        return errorKomokuNo;
    }

    /**
     * setErrorKomokuNo
     *
     * @param errorKomokuNo errorKomokuNo
     */
    public void setErrorKomokuNo(RString errorKomokuNo) {
        this.errorKomokuNo = errorKomokuNo;
    }

    /**
     * getErrorCode
     *
     * @return errorCode
     */
    public RString getErrorCode() {
        return errorCode;
    }

    /**
     * setErrorCode
     *
     * @param errorCode errorCode
     */
    public void setErrorCode(RString errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * getErrorHyojiRenban
     *
     * @return errorHyojiRenban
     */
    public RString getErrorHyojiRenban() {
        return errorHyojiRenban;
    }

    /**
     * setErrorHyojiRenban
     *
     * @param errorHyojiRenban errorHyojiRenban
     */
    public void setErrorHyojiRenban(RString errorHyojiRenban) {
        this.errorHyojiRenban = errorHyojiRenban;
    }

    /**
     * getErrorHyojiKomokuMeisho
     *
     * @return errorHyojiKomokuMeisho
     */
    public RString getErrorHyojiKomokuMeisho() {
        return errorHyojiKomokuMeisho;
    }

    /**
     * setErrorHyojiKomokuMeisho
     *
     * @param errorHyojiKomokuMeisho errorHyojiKomokuMeisho
     */
    public void setErrorHyojiKomokuMeisho(RString errorHyojiKomokuMeisho) {
        this.errorHyojiKomokuMeisho = errorHyojiKomokuMeisho;
    }

    /**
     * getErrorHyojiKomoku
     *
     * @return errorHyojiKomoku
     */
    public RString getErrorHyojiKomoku() {
        return errorHyojiKomoku;
    }

    /**
     * setErrorHyojiKomoku
     *
     * @param errorHyojiKomoku errorHyojiKomoku
     */
    public void setErrorHyojiKomoku(RString errorHyojiKomoku) {
        this.errorHyojiKomoku = errorHyojiKomoku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7034KoikiGaijiHenkanErrorLogEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7034KoikiGaijiHenkanErrorLogEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7034KoikiGaijiHenkanErrorLogEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoriNo, other.shoriNo)) {
            return false;
        }
        if (!Objects.equals(this.renNo, other.renNo)) {
            return false;
        }
        if (!Objects.equals(this.errorHyojiRenban, other.errorHyojiRenban)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7034KoikiGaijiHenkanErrorLogEntity entity) {
        this.shoriNo = entity.shoriNo;
        this.renNo = entity.renNo;
        this.shichosonCode = entity.shichosonCode;
        this.shubetsu = entity.shubetsu;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.motoShichosonCode = entity.motoShichosonCode;
        this.motoShichosonMeisho = entity.motoShichosonMeisho;
        this.sakiShichosonCode = entity.sakiShichosonCode;
        this.sakiShichosonMeisho = entity.sakiShichosonMeisho;
        this.jukiShikibetsuCode = entity.jukiShikibetsuCode;
        this.kakuninKubun = entity.kakuninKubun;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.recoadNo = entity.recoadNo;
        this.errorKomokuMeisho = entity.errorKomokuMeisho;
        this.errorKomokuNo = entity.errorKomokuNo;
        this.errorCode = entity.errorCode;
        this.errorHyojiRenban = entity.errorHyojiRenban;
        this.errorHyojiKomokuMeisho = entity.errorHyojiKomokuMeisho;
        this.errorHyojiKomoku = entity.errorHyojiKomoku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoriNo, renNo, shichosonCode, shubetsu, shoriTimestamp, motoShichosonCode, motoShichosonMeisho, sakiShichosonCode, sakiShichosonMeisho, jukiShikibetsuCode, kakuninKubun, shikibetsuCode, hihokenshaNo, recoadNo, errorKomokuMeisho, errorKomokuNo, errorCode, errorHyojiRenban, errorHyojiKomokuMeisho, errorHyojiKomoku);
    }

// </editor-fold>
}
