package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定意見書イメージ情報テーブルのエンティティクラスです。
 */
public class DbT4305IkenshoImageJohoEntity extends DbTableEntityBase<DbT4305IkenshoImageJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4305IkenshoImageJoho");

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
    private int iraiRirekiNo;
    @PrimaryKey
    private Code ChoyoID;
    @PrimaryKey
    private RString maskDataKubun;
    @PrimaryKey
    private int torikomiPageNo;
    private int ninteiShinseiNen;
    private RDateTime sharedFileId;

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
     * 主治医意見書作成依頼履歴番号のgetメソッドです。
     * <br/>
     * <br/>主治医意見書作成依頼情報
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int getIraiRirekiNo() {
        return iraiRirekiNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号のsetメソッドです。
     * <br/>
     * <br/>主治医意見書作成依頼情報
     *
     * @param iraiRirekiNo 主治医意見書作成依頼履歴番号
     */
    public void setIraiRirekiNo(int iraiRirekiNo) {
        this.iraiRirekiNo = iraiRirekiNo;
    }

    /**
     * 帳票IDのgetメソッドです。
     *
     * @return 帳票ID
     */
    public Code getChoyoID() {
        return ChoyoID;
    }

    /**
     * 帳票IDのsetメソッドです。
     *
     * @param ChoyoID 帳票ID
     */
    public void setChoyoID(Code ChoyoID) {
        this.ChoyoID = ChoyoID;
    }

    /**
     * マスキングデータ区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）
     *
     * @return マスキングデータ区分
     */
    public RString getMaskDataKubun() {
        return maskDataKubun;
    }

    /**
     * マスキングデータ区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）
     *
     * @param maskDataKubun マスキングデータ区分
     */
    public void setMaskDataKubun(RString maskDataKubun) {
        this.maskDataKubun = maskDataKubun;
    }

    /**
     * 取込みページ番号のgetメソッドです。
     *
     * @return 取込みページ番号
     */
    public int getTorikomiPageNo() {
        return torikomiPageNo;
    }

    /**
     * 取込みページ番号のsetメソッドです。
     *
     * @param torikomiPageNo 取込みページ番号
     */
    public void setTorikomiPageNo(int torikomiPageNo) {
        this.torikomiPageNo = torikomiPageNo;
    }

    /**
     * 認定申請年のgetメソッドです。
     * <br/>
     * <br/>パーティション振り分け用
     *
     * @return 認定申請年
     */
    public int getNinteiShinseiNen() {
        return ninteiShinseiNen;
    }

    /**
     * 認定申請年のsetメソッドです。
     * <br/>
     * <br/>パーティション振り分け用
     *
     * @param ninteiShinseiNen 認定申請年
     */
    public void setNinteiShinseiNen(int ninteiShinseiNen) {
        this.ninteiShinseiNen = ninteiShinseiNen;
    }

    /**
     * 共有ファイルIDのgetメソッドです。
     *
     * @return 共有ファイルID
     */
    public RDateTime getSharedFileId() {
        return sharedFileId;
    }

    /**
     * 共有ファイルIDのsetメソッドです。
     *
     * @param sharedFileId 共有ファイルID
     */
    public void setSharedFileId(RDateTime sharedFileId) {
        this.sharedFileId = sharedFileId;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4305IkenshoImageJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT4305IkenshoImageJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4305IkenshoImageJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.iraiRirekiNo != other.iraiRirekiNo) {
            return false;
        }
        if (!Objects.equals(this.ChoyoID, other.ChoyoID)) {
            return false;
        }
        if (!Objects.equals(this.maskDataKubun, other.maskDataKubun)) {
            return false;
        }
        if (this.torikomiPageNo != other.torikomiPageNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4305IkenshoImageJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.iraiRirekiNo = entity.iraiRirekiNo;
        this.ChoyoID = entity.ChoyoID;
        this.maskDataKubun = entity.maskDataKubun;
        this.torikomiPageNo = entity.torikomiPageNo;
        this.ninteiShinseiNen = entity.ninteiShinseiNen;
        this.sharedFileId = entity.sharedFileId;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, iraiRirekiNo, ChoyoID, maskDataKubun, torikomiPageNo, ninteiShinseiNen, sharedFileId);
    }

// </editor-fold>
}
