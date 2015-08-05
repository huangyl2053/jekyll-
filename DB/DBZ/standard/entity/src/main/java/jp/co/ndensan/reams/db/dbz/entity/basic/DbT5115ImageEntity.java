package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * イメージ情報テーブルのエンティティクラスです。
 * <br/> 認定調査票や主治医意見書以外の書類のイメージ
 */
public class DbT5115ImageEntity extends DbTableEntityBase<DbT5115ImageEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5115Image");

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
    private int torikomiPageNo;
    @PrimaryKey
    private Code genponMaskKubun;
    private RDateTime imageSharedFileId;

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
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 取込ページ番号のgetメソッドです。
     *
     * @return 取込ページ番号
     */
    public int getTorikomiPageNo() {
        return torikomiPageNo;
    }

    /**
     * 取込ページ番号のsetメソッドです。
     *
     * @param torikomiPageNo 取込ページ番号
     */
    public void setTorikomiPageNo(int torikomiPageNo) {
        this.torikomiPageNo = torikomiPageNo;
    }

    /**
     * 原本マスク分のgetメソッドです。
     *
     * @return 原本マスク分
     */
    public Code getGenponMaskKubun() {
        return genponMaskKubun;
    }

    /**
     * 原本マスク分のsetメソッドです。
     *
     * @param genponMaskKubun 原本マスク分
     */
    public void setGenponMaskKubun(Code genponMaskKubun) {
        this.genponMaskKubun = genponMaskKubun;
    }

    /**
     * イメージ共有ファイルIDのgetメソッドです。
     *
     * @return イメージ共有ファイルID
     */
    public RDateTime getImageSharedFileId() {
        return imageSharedFileId;
    }

    /**
     * イメージ共有ファイルIDのsetメソッドです。
     *
     * @param imageSharedFileId イメージ共有ファイルID
     */
    public void setImageSharedFileId(RDateTime imageSharedFileId) {
        this.imageSharedFileId = imageSharedFileId;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5115ImageEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT5115ImageEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5115ImageEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.torikomiPageNo != other.torikomiPageNo) {
            return false;
        }
        if (!Objects.equals(this.genponMaskKubun, other.genponMaskKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5115ImageEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.torikomiPageNo = entity.torikomiPageNo;
        this.genponMaskKubun = entity.genponMaskKubun;
        this.imageSharedFileId = entity.imageSharedFileId;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, torikomiPageNo, genponMaskKubun, imageSharedFileId);
    }

// </editor-fold>
}
