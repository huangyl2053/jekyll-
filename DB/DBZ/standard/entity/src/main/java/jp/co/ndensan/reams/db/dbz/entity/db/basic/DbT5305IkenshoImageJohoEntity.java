package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 要介護認定意見書イメージ情報テーブルのエンティティクラスです。
 */
public class DbT5305IkenshoImageJohoEntity extends DbTableEntityBase<DbT5305IkenshoImageJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5305IkenshoImageJoho");

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
    private int remban;
    @PrimaryKey
    private RString genponMaskKubun;

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
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
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
    public void setIraiRirekiNo(@Nonnull int iraiRirekiNo) {
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
    public void setChoyoID(@Nonnull Code ChoyoID) {
        this.ChoyoID = ChoyoID;
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
    public void setRemban(@Nonnull int remban) {
        this.remban = remban;
    }

    /**
     * 原本マスク区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）
     * 
     * @return 原本マスク区分
     */
    public RString getGenponMaskKubun() {
        return genponMaskKubun;
    }

    /**
     * 原本マスク区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）
     * 
     * @param genponMaskKubun 原本マスク区分
     */
    public void setGenponMaskKubun(@Nonnull RString genponMaskKubun) {
        this.genponMaskKubun = genponMaskKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5305IkenshoImageJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5305IkenshoImageJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5305IkenshoImageJohoEntity other) {
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
        if (this.remban != other.remban) {
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
    public void shallowCopy(DbT5305IkenshoImageJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.iraiRirekiNo = entity.iraiRirekiNo;
        this.ChoyoID = entity.ChoyoID;
        this.remban = entity.remban;
        this.genponMaskKubun = entity.genponMaskKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, iraiRirekiNo, ChoyoID, remban, genponMaskKubun);
    }

// </editor-fold>

}
