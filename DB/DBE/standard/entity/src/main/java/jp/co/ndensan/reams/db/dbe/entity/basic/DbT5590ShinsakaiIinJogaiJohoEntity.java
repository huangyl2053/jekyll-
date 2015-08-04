package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;

/**
 * 審査会委員除外情報テーブルのエンティティクラスです。
 */
public class DbT5590ShinsakaiIinJogaiJohoEntity extends DbTableEntityBase<DbT5590ShinsakaiIinJogaiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5590ShinsakaiIinJogaiJoho");

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
    private int renban;
    private RString jogaiTaishoShinsakaiIinCode;

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
     * 連番のgetメソッドです。
     * 
     * @return 連番
     */
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     * 
     * @param renban 連番
     */
    public void setRenban(int renban) {
        this.renban = renban;
    }

    /**
     * 除外対象審査会委員コードのgetメソッドです。
     * <br/>
     * <br/>介護認定審査会委員情報
     * 
     * @return 除外対象審査会委員コード
     */
    public RString getJogaiTaishoShinsakaiIinCode() {
        return jogaiTaishoShinsakaiIinCode;
    }

    /**
     * 除外対象審査会委員コードのsetメソッドです。
     * <br/>
     * <br/>介護認定審査会委員情報
     * 
     * @param jogaiTaishoShinsakaiIinCode 除外対象審査会委員コード
     */
    public void setJogaiTaishoShinsakaiIinCode(RString jogaiTaishoShinsakaiIinCode) {
        this.jogaiTaishoShinsakaiIinCode = jogaiTaishoShinsakaiIinCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5590ShinsakaiIinJogaiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5590ShinsakaiIinJogaiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5590ShinsakaiIinJogaiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.renban != other.renban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5590ShinsakaiIinJogaiJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.renban = entity.renban;
        this.jogaiTaishoShinsakaiIinCode = entity.jogaiTaishoShinsakaiIinCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, renban, jogaiTaishoShinsakaiIinCode);
    }

// </editor-fold>
}
