package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;

/**
 * 合併内住特者新旧番号変換テーブルテーブルのエンティティクラスです。
 */
public class DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity extends DbTableEntityBase<DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7033GappeiNaiJutokushaShinKyuNoHenkan");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private RString rirekiNo;
    private ShikibetsuCode shikibetsuCodeSochiMoto;
    private LasdecCode shichosonCode;
    private LasdecCode shichosonCodeSochiMoto;
    private HihokenshaNo hihokenshaNo;
    private HihokenshaNo hihokenshaNoSochiMoto;
    private FlexibleDate kaishiYMD;
    private FlexibleDate shuryoYMD;

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
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 識別コード（措置元）のgetメソッドです。
     *
     * @return 識別コード（措置元）
     */
    public ShikibetsuCode getShikibetsuCodeSochiMoto() {
        return shikibetsuCodeSochiMoto;
    }

    /**
     * 識別コード（措置元）のsetメソッドです。
     *
     * @param shikibetsuCodeSochiMoto 識別コード（措置元）
     */
    public void setShikibetsuCodeSochiMoto(ShikibetsuCode shikibetsuCodeSochiMoto) {
        this.shikibetsuCodeSochiMoto = shikibetsuCodeSochiMoto;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 市町村コード（措置元）のgetメソッドです。
     *
     * @return 市町村コード（措置元）
     */
    public LasdecCode getShichosonCodeSochiMoto() {
        return shichosonCodeSochiMoto;
    }

    /**
     * 市町村コード（措置元）のsetメソッドです。
     *
     * @param shichosonCodeSochiMoto 市町村コード（措置元）
     */
    public void setShichosonCodeSochiMoto(LasdecCode shichosonCodeSochiMoto) {
        this.shichosonCodeSochiMoto = shichosonCodeSochiMoto;
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
     * 被保険者番号（措置元）のgetメソッドです。
     *
     * @return 被保険者番号（措置元）
     */
    public HihokenshaNo getHihokenshaNoSochiMoto() {
        return hihokenshaNoSochiMoto;
    }

    /**
     * 被保険者番号（措置元）のsetメソッドです。
     *
     * @param hihokenshaNoSochiMoto 被保険者番号（措置元）
     */
    public void setHihokenshaNoSochiMoto(HihokenshaNo hihokenshaNoSochiMoto) {
        this.hihokenshaNoSochiMoto = hihokenshaNoSochiMoto;
    }

    /**
     * 開始年月日のgetメソッドです。
     *
     * @return 開始年月日
     */
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * 開始年月日のsetメソッドです。
     *
     * @param kaishiYMD 開始年月日
     */
    public void setKaishiYMD(FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * 終了年月日のgetメソッドです。
     *
     * @return 終了年月日
     */
    public FlexibleDate getShuryoYMD() {
        return shuryoYMD;
    }

    /**
     * 終了年月日のsetメソッドです。
     *
     * @param shuryoYMD 終了年月日
     */
    public void setShuryoYMD(FlexibleDate shuryoYMD) {
        this.shuryoYMD = shuryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
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
    public void shallowCopy(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.shikibetsuCodeSochiMoto = entity.shikibetsuCodeSochiMoto;
        this.shichosonCode = entity.shichosonCode;
        this.shichosonCodeSochiMoto = entity.shichosonCodeSochiMoto;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.hihokenshaNoSochiMoto = entity.hihokenshaNoSochiMoto;
        this.kaishiYMD = entity.kaishiYMD;
        this.shuryoYMD = entity.shuryoYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, rirekiNo, shikibetsuCodeSochiMoto, shichosonCode, shichosonCodeSochiMoto, hihokenshaNo, hihokenshaNoSochiMoto, kaishiYMD, shuryoYMD);
    }

// </editor-fold>
}
