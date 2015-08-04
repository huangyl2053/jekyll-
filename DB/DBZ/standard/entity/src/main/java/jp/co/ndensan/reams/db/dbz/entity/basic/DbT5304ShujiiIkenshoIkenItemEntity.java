package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;

/**
 * 要介護認定主治医意見書意見項目テーブルのエンティティクラスです。
 */
public class DbT5304ShujiiIkenshoIkenItemEntity extends DbTableEntityBase<DbT5304ShujiiIkenshoIkenItemEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5304ShujiiIkenshoIkenItem");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD013ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ikenshoIraiRirekiNo;
    private int remban;
    private Code koroshoIfShikibetsuCode;
    private RString ikenItem;

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
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @return 申請書管理番号
     */
    public DbUDD013ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(DbUDD013ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号のgetメソッドです。
     * <br/>
     * <br/>主治医意見書作成依頼情報
     * 
     * @return 主治医意見書作成依頼履歴番号
     */
    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号のsetメソッドです。
     * <br/>
     * <br/>主治医意見書作成依頼情報
     * 
     * @param ikenshoIraiRirekiNo 主治医意見書作成依頼履歴番号
     */
    public void setIkenshoIraiRirekiNo(int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
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
     * 厚労省IF識別コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     * 
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     * 
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 意見項目のgetメソッドです。
     * 
     * @return 意見項目
     */
    public RString getIkenItem() {
        return ikenItem;
    }

    /**
     * 意見項目のsetメソッドです。
     * 
     * @param ikenItem 意見項目
     */
    public void setIkenItem(RString ikenItem) {
        this.ikenItem = ikenItem;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5304ShujiiIkenshoIkenItemEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5304ShujiiIkenshoIkenItemEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5304ShujiiIkenshoIkenItemEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ikenshoIraiRirekiNo != other.ikenshoIraiRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5304ShujiiIkenshoIkenItemEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ikenshoIraiRirekiNo = entity.ikenshoIraiRirekiNo;
        this.remban = entity.remban;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.ikenItem = entity.ikenItem;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ikenshoIraiRirekiNo, remban, koroshoIfShikibetsuCode, ikenItem);
    }

// </editor-fold>
}
