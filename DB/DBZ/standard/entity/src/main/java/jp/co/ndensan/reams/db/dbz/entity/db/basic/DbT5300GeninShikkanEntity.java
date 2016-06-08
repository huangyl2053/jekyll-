package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 原因疾患テーブルのエンティティクラスです。
 */
public class DbT5300GeninShikkanEntity extends DbTableEntityBase<DbT5300GeninShikkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5300GeninShikkan");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int remban;
    private boolean isShutaruGeninShikkan;
    private Code geninShikkanCode;

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
     * 申請書管理番号のgetメソッドです。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public int getRemban() {
        return remban;
    }

    /**
     * 連番のsetメソッドです。
     *
     * @param remban 連番
     */
    public void setRemban(int remban) {
        this.remban = remban;
    }

    /**
     * 主たる原因疾患フラグのgetメソッドです。
     *
     * @return 主たる原因疾患フラグ
     */
    public boolean getIsShutaruGeninShikkan() {
        return isShutaruGeninShikkan;
    }

    /**
     * 主たる原因疾患フラグのsetメソッドです。
     *
     * @param isShutaruGeninShikkan 主たる原因疾患フラグ
     */
    public void setIsShutaruGeninShikkan(boolean isShutaruGeninShikkan) {
        this.isShutaruGeninShikkan = isShutaruGeninShikkan;
    }

    /**
     * 原因疾患コードのgetメソッドです。
     *
     * @return 原因疾患コード
     */
    public Code getGeninShikkanCode() {
        return geninShikkanCode;
    }

    /**
     * 原因疾患コードのsetメソッドです。
     *
     * @param geninShikkanCode 原因疾患コード
     */
    public void setGeninShikkanCode(Code geninShikkanCode) {
        this.geninShikkanCode = geninShikkanCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5300GeninShikkanEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT5300GeninShikkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5300GeninShikkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.remban != other.remban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5300GeninShikkanEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.remban = entity.remban;
        this.isShutaruGeninShikkan = entity.isShutaruGeninShikkan;
        this.geninShikkanCode = entity.geninShikkanCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, remban, isShutaruGeninShikkan, geninShikkanCode);
    }

// </editor-fold>
}
