package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 特徴未同定情報テーブルのエンティティクラスです。
 * <br/> バッチの通知書一括発行のリアル発行された通知書を除外する考慮のため、リアル発行の履歴を通知書番号単位で管理する。
 */
public class DbT2019TokuchoMidoteiJohoEntity extends DbTableEntityBase<DbT2019TokuchoMidoteiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT2019TokuchoMidoteiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear shoriNendo;
    @PrimaryKey
    private RString kisoNenkinNo;
    @PrimaryKey
    private RString nenkinCode;
    @PrimaryKey
    private RString hosokuM;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    private RString kaishiM;
    private RString fuichiRiyuCode;
    private RString kakuninJokyoKbn;

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
     * 処理年度のgetメソッドです。
     * 
     * @return 処理年度
     */
    public FlexibleYear getShoriNendo() {
        return shoriNendo;
    }

    /**
     * 処理年度のsetメソッドです。
     * 
     * @param shoriNendo 処理年度
     */
    public void setShoriNendo(@Nonnull FlexibleYear shoriNendo) {
        this.shoriNendo = shoriNendo;
    }

    /**
     * 基礎年金番号のgetメソッドです。
     * 
     * @return 基礎年金番号
     */
    public RString getKisoNenkinNo() {
        return kisoNenkinNo;
    }

    /**
     * 基礎年金番号のsetメソッドです。
     * 
     * @param kisoNenkinNo 基礎年金番号
     */
    public void setKisoNenkinNo(@Nonnull RString kisoNenkinNo) {
        this.kisoNenkinNo = kisoNenkinNo;
    }

    /**
     * 年金コードのgetメソッドです。
     * 
     * @return 年金コード
     */
    public RString getNenkinCode() {
        return nenkinCode;
    }

    /**
     * 年金コードのsetメソッドです。
     * 
     * @param nenkinCode 年金コード
     */
    public void setNenkinCode(@Nonnull RString nenkinCode) {
        this.nenkinCode = nenkinCode;
    }

    /**
     * 捕捉月のgetメソッドです。
     * 
     * @return 捕捉月
     */
    public RString getHosokuM() {
        return hosokuM;
    }

    /**
     * 捕捉月のsetメソッドです。
     * 
     * @param hosokuM 捕捉月
     */
    public void setHosokuM(@Nonnull RString hosokuM) {
        this.hosokuM = hosokuM;
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
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 開始月のgetメソッドです。
     * 
     * @return 開始月
     */
    @CheckForNull
    public RString getKaishiM() {
        return kaishiM;
    }

    /**
     * 開始月のsetメソッドです。
     * 
     * @param kaishiM 開始月
     */
    public void setKaishiM(RString kaishiM) {
        this.kaishiM = kaishiM;
    }

    /**
     * 不一致理由コードのgetメソッドです。
     * 
     * @return 不一致理由コード
     */
    @CheckForNull
    public RString getFuichiRiyuCode() {
        return fuichiRiyuCode;
    }

    /**
     * 不一致理由コードのsetメソッドです。
     * 
     * @param fuichiRiyuCode 不一致理由コード
     */
    public void setFuichiRiyuCode(RString fuichiRiyuCode) {
        this.fuichiRiyuCode = fuichiRiyuCode;
    }

    /**
     * 確認状況区分のgetメソッドです。
     * <br/>
     * <br/>0：未同定　1：同定済み　2：対象外
     * 
     * @return 確認状況区分
     */
    @CheckForNull
    public RString getKakuninJokyoKbn() {
        return kakuninJokyoKbn;
    }

    /**
     * 確認状況区分のsetメソッドです。
     * <br/>
     * <br/>0：未同定　1：同定済み　2：対象外
     * 
     * @param kakuninJokyoKbn 確認状況区分
     */
    public void setKakuninJokyoKbn(RString kakuninJokyoKbn) {
        this.kakuninJokyoKbn = kakuninJokyoKbn;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2019TokuchoMidoteiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2019TokuchoMidoteiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2019TokuchoMidoteiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoriNendo, other.shoriNendo)) {
            return false;
        }
        if (!Objects.equals(this.kisoNenkinNo, other.kisoNenkinNo)) {
            return false;
        }
        if (!Objects.equals(this.nenkinCode, other.nenkinCode)) {
            return false;
        }
        if (!Objects.equals(this.hosokuM, other.hosokuM)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2019TokuchoMidoteiJohoEntity entity) {
        this.shoriNendo = entity.shoriNendo;
        this.kisoNenkinNo = entity.kisoNenkinNo;
        this.nenkinCode = entity.nenkinCode;
        this.hosokuM = entity.hosokuM;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.kaishiM = entity.kaishiM;
        this.fuichiRiyuCode = entity.fuichiRiyuCode;
        this.kakuninJokyoKbn = entity.kakuninJokyoKbn;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoriNendo, kisoNenkinNo, nenkinCode, hosokuM, shikibetsuCode, kaishiM, fuichiRiyuCode, kakuninJokyoKbn);
    }

// </editor-fold>

}
