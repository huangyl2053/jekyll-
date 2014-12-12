package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7033GappeiNaiJutokushaShinKyuNoHenkanの項目定義クラスです
 *
 */
public class DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity extends DbTableEntityBase<DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
     * getRirekiNo
     *
     * @return rirekiNo
     */
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * setRirekiNo
     *
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * getShikibetsuCodeSochiMoto
     *
     * @return shikibetsuCodeSochiMoto
     */
    public ShikibetsuCode getShikibetsuCodeSochiMoto() {
        return shikibetsuCodeSochiMoto;
    }

    /**
     * setShikibetsuCodeSochiMoto
     *
     * @param shikibetsuCodeSochiMoto shikibetsuCodeSochiMoto
     */
    public void setShikibetsuCodeSochiMoto(ShikibetsuCode shikibetsuCodeSochiMoto) {
        this.shikibetsuCodeSochiMoto = shikibetsuCodeSochiMoto;
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
     * getShichosonCodeSochiMoto
     *
     * @return shichosonCodeSochiMoto
     */
    public LasdecCode getShichosonCodeSochiMoto() {
        return shichosonCodeSochiMoto;
    }

    /**
     * setShichosonCodeSochiMoto
     *
     * @param shichosonCodeSochiMoto shichosonCodeSochiMoto
     */
    public void setShichosonCodeSochiMoto(LasdecCode shichosonCodeSochiMoto) {
        this.shichosonCodeSochiMoto = shichosonCodeSochiMoto;
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
     * getHihokenshaNoSochiMoto
     *
     * @return hihokenshaNoSochiMoto
     */
    public HihokenshaNo getHihokenshaNoSochiMoto() {
        return hihokenshaNoSochiMoto;
    }

    /**
     * setHihokenshaNoSochiMoto
     *
     * @param hihokenshaNoSochiMoto hihokenshaNoSochiMoto
     */
    public void setHihokenshaNoSochiMoto(HihokenshaNo hihokenshaNoSochiMoto) {
        this.hihokenshaNoSochiMoto = hihokenshaNoSochiMoto;
    }

    /**
     * getKaishiYMD
     *
     * @return kaishiYMD
     */
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * setKaishiYMD
     *
     * @param kaishiYMD kaishiYMD
     */
    public void setKaishiYMD(FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * getShuryoYMD
     *
     * @return shuryoYMD
     */
    public FlexibleDate getShuryoYMD() {
        return shuryoYMD;
    }

    /**
     * setShuryoYMD
     *
     * @param shuryoYMD shuryoYMD
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
