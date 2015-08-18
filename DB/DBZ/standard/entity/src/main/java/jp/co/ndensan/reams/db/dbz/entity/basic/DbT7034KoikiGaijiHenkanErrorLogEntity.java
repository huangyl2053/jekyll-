package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
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
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

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
    private int rirekiNo;
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
     * 処理番号のgetメソッドです。
     *
     * @return 処理番号
     */
    public RString getShoriNo() {
        return shoriNo;
    }

    /**
     * 処理番号のsetメソッドです。
     *
     * @param shoriNo 処理番号
     */
    public void setShoriNo(RString shoriNo) {
        this.shoriNo = shoriNo;
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public RString getRenNo() {
        return renNo;
    }

    /**
     * 連番のsetメソッドです。
     *
     * @param renNo 連番
     */
    public void setRenNo(RString renNo) {
        this.renNo = renNo;
    }

    /**
     * 市町村番号のgetメソッドです。
     *
     * @return 市町村番号
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村番号のsetメソッドです。
     *
     * @param shichosonCode 市町村番号
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 種別のgetメソッドです。
     *
     * @return 種別
     */
    public RString getShubetsu() {
        return shubetsu;
    }

    /**
     * 種別のsetメソッドです。
     *
     * @param shubetsu 種別
     */
    public void setShubetsu(RString shubetsu) {
        this.shubetsu = shubetsu;
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
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 送信元市町村コードのgetメソッドです。
     *
     * @return 送信元市町村コード
     */
    public LasdecCode getMotoShichosonCode() {
        return motoShichosonCode;
    }

    /**
     * 送信元市町村コードのsetメソッドです。
     *
     * @param motoShichosonCode 送信元市町村コード
     */
    public void setMotoShichosonCode(LasdecCode motoShichosonCode) {
        this.motoShichosonCode = motoShichosonCode;
    }

    /**
     * 送信元市町村名称のgetメソッドです。
     *
     * @return 送信元市町村名称
     */
    public RString getMotoShichosonMeisho() {
        return motoShichosonMeisho;
    }

    /**
     * 送信元市町村名称のsetメソッドです。
     *
     * @param motoShichosonMeisho 送信元市町村名称
     */
    public void setMotoShichosonMeisho(RString motoShichosonMeisho) {
        this.motoShichosonMeisho = motoShichosonMeisho;
    }

    /**
     * 送信先市町村コードのgetメソッドです。
     *
     * @return 送信先市町村コード
     */
    public LasdecCode getSakiShichosonCode() {
        return sakiShichosonCode;
    }

    /**
     * 送信先市町村コードのsetメソッドです。
     *
     * @param sakiShichosonCode 送信先市町村コード
     */
    public void setSakiShichosonCode(LasdecCode sakiShichosonCode) {
        this.sakiShichosonCode = sakiShichosonCode;
    }

    /**
     * 送信先市町村名称のgetメソッドです。
     *
     * @return 送信先市町村名称
     */
    public RString getSakiShichosonMeisho() {
        return sakiShichosonMeisho;
    }

    /**
     * 送信先市町村名称のsetメソッドです。
     *
     * @param sakiShichosonMeisho 送信先市町村名称
     */
    public void setSakiShichosonMeisho(RString sakiShichosonMeisho) {
        this.sakiShichosonMeisho = sakiShichosonMeisho;
    }

    /**
     * 住基識別コードのgetメソッドです。
     *
     * @return 住基識別コード
     */
    public ShikibetsuCode getJukiShikibetsuCode() {
        return jukiShikibetsuCode;
    }

    /**
     * 住基識別コードのsetメソッドです。
     *
     * @param jukiShikibetsuCode 住基識別コード
     */
    public void setJukiShikibetsuCode(ShikibetsuCode jukiShikibetsuCode) {
        this.jukiShikibetsuCode = jukiShikibetsuCode;
    }

    /**
     * 確認区分のgetメソッドです。
     *
     * @return 確認区分
     */
    public RString getKakuninKubun() {
        return kakuninKubun;
    }

    /**
     * 確認区分のsetメソッドです。
     *
     * @param kakuninKubun 確認区分
     */
    public void setKakuninKubun(RString kakuninKubun) {
        this.kakuninKubun = kakuninKubun;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
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
     * レコードＮｏのgetメソッドです。
     *
     * @return レコードＮｏ
     */
    public RString getRecoadNo() {
        return recoadNo;
    }

    /**
     * レコードＮｏのsetメソッドです。
     *
     * @param recoadNo レコードＮｏ
     */
    public void setRecoadNo(RString recoadNo) {
        this.recoadNo = recoadNo;
    }

    /**
     * 変換エラーフィールド名称のgetメソッドです。
     *
     * @return 変換エラーフィールド名称
     */
    public RString getErrorKomokuMeisho() {
        return errorKomokuMeisho;
    }

    /**
     * 変換エラーフィールド名称のsetメソッドです。
     *
     * @param errorKomokuMeisho 変換エラーフィールド名称
     */
    public void setErrorKomokuMeisho(RString errorKomokuMeisho) {
        this.errorKomokuMeisho = errorKomokuMeisho;
    }

    /**
     * 変換エラーフィールドＮｏのgetメソッドです。
     *
     * @return 変換エラーフィールドＮｏ
     */
    public RString getErrorKomokuNo() {
        return errorKomokuNo;
    }

    /**
     * 変換エラーフィールドＮｏのsetメソッドです。
     *
     * @param errorKomokuNo 変換エラーフィールドＮｏ
     */
    public void setErrorKomokuNo(RString errorKomokuNo) {
        this.errorKomokuNo = errorKomokuNo;
    }

    /**
     * 変換エラーコードのgetメソッドです。
     *
     * @return 変換エラーコード
     */
    public RString getErrorCode() {
        return errorCode;
    }

    /**
     * 変換エラーコードのsetメソッドです。
     *
     * @param errorCode 変換エラーコード
     */
    public void setErrorCode(RString errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * エラー表示連番のgetメソッドです。
     *
     * @return エラー表示連番
     */
    public RString getErrorHyojiRenban() {
        return errorHyojiRenban;
    }

    /**
     * エラー表示連番のsetメソッドです。
     *
     * @param errorHyojiRenban エラー表示連番
     */
    public void setErrorHyojiRenban(RString errorHyojiRenban) {
        this.errorHyojiRenban = errorHyojiRenban;
    }

    /**
     * エラー表示フィールド名称のgetメソッドです。
     *
     * @return エラー表示フィールド名称
     */
    public RString getErrorHyojiKomokuMeisho() {
        return errorHyojiKomokuMeisho;
    }

    /**
     * エラー表示フィールド名称のsetメソッドです。
     *
     * @param errorHyojiKomokuMeisho エラー表示フィールド名称
     */
    public void setErrorHyojiKomokuMeisho(RString errorHyojiKomokuMeisho) {
        this.errorHyojiKomokuMeisho = errorHyojiKomokuMeisho;
    }

    /**
     * エラー表示フィールドのgetメソッドです。
     *
     * @return エラー表示フィールド
     */
    public RString getErrorHyojiKomoku() {
        return errorHyojiKomoku;
    }

    /**
     * エラー表示フィールドのsetメソッドです。
     *
     * @param errorHyojiKomoku エラー表示フィールド
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(shoriNo, renNo, shichosonCode, shubetsu, rirekiNo, motoShichosonCode, motoShichosonMeisho, sakiShichosonCode, sakiShichosonMeisho, jukiShikibetsuCode, kakuninKubun, shikibetsuCode, hihokenshaNo, recoadNo, errorKomokuMeisho, errorKomokuNo, errorCode, errorHyojiRenban, errorHyojiKomokuMeisho, errorHyojiKomoku);
    }

// </editor-fold>
}
