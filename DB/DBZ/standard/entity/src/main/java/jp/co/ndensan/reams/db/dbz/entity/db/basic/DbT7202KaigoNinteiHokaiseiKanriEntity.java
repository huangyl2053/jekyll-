package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 介護認定法改正管理テーブルのエンティティクラスです。
 */
public class DbT7202KaigoNinteiHokaiseiKanriEntity extends DbTableEntityBase<DbT7202KaigoNinteiHokaiseiKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7202KaigoNinteiHokaiseiKanri");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate hokaiseiShikoYMD;
    private RString koroshoIfShikibetsuCode;
    private boolean chosaGaikyoKomokuChangeFlag;
    private boolean chosaKihonKomokuChangeFlag;
    private boolean shujiiIkenshoKomokuChangeFlag;

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
     * 法改正施行年月日のgetメソッドです。
     * 
     * @return 法改正施行年月日
     */
    public FlexibleDate getHokaiseiShikoYMD() {
        return hokaiseiShikoYMD;
    }

    /**
     * 法改正施行年月日のsetメソッドです。
     * 
     * @param hokaiseiShikoYMD 法改正施行年月日
     */
    public void setHokaiseiShikoYMD(FlexibleDate hokaiseiShikoYMD) {
        this.hokaiseiShikoYMD = hokaiseiShikoYMD;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     * 
     * @return 厚労省IF識別コード
     */
    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * 
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 認定調査概況項目変更フラグのgetメソッドです。
     * 
     * @return 認定調査概況項目変更フラグ
     */
    public boolean getChosaGaikyoKomokuChangeFlag() {
        return chosaGaikyoKomokuChangeFlag;
    }

    /**
     * 認定調査概況項目変更フラグのsetメソッドです。
     * 
     * @param chosaGaikyoKomokuChangeFlag 認定調査概況項目変更フラグ
     */
    public void setChosaGaikyoKomokuChangeFlag(boolean chosaGaikyoKomokuChangeFlag) {
        this.chosaGaikyoKomokuChangeFlag = chosaGaikyoKomokuChangeFlag;
    }

    /**
     * 認定調査基本項目変更フラグのgetメソッドです。
     * 
     * @return 認定調査基本項目変更フラグ
     */
    public boolean getChosaKihonKomokuChangeFlag() {
        return chosaKihonKomokuChangeFlag;
    }

    /**
     * 認定調査基本項目変更フラグのsetメソッドです。
     * 
     * @param chosaKihonKomokuChangeFlag 認定調査基本項目変更フラグ
     */
    public void setChosaKihonKomokuChangeFlag(boolean chosaKihonKomokuChangeFlag) {
        this.chosaKihonKomokuChangeFlag = chosaKihonKomokuChangeFlag;
    }

    /**
     * 主治医意見書項目変更フラグのgetメソッドです。
     * 
     * @return 主治医意見書項目変更フラグ
     */
    public boolean getShujiiIkenshoKomokuChangeFlag() {
        return shujiiIkenshoKomokuChangeFlag;
    }

    /**
     * 主治医意見書項目変更フラグのsetメソッドです。
     * 
     * @param shujiiIkenshoKomokuChangeFlag 主治医意見書項目変更フラグ
     */
    public void setShujiiIkenshoKomokuChangeFlag(boolean shujiiIkenshoKomokuChangeFlag) {
        this.shujiiIkenshoKomokuChangeFlag = shujiiIkenshoKomokuChangeFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7202KaigoNinteiHokaiseiKanriEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7202KaigoNinteiHokaiseiKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7202KaigoNinteiHokaiseiKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hokaiseiShikoYMD, other.hokaiseiShikoYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7202KaigoNinteiHokaiseiKanriEntity entity) {
        this.hokaiseiShikoYMD = entity.hokaiseiShikoYMD;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.chosaGaikyoKomokuChangeFlag = entity.chosaGaikyoKomokuChangeFlag;
        this.chosaKihonKomokuChangeFlag = entity.chosaKihonKomokuChangeFlag;
        this.shujiiIkenshoKomokuChangeFlag = entity.shujiiIkenshoKomokuChangeFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hokaiseiShikoYMD, koroshoIfShikibetsuCode, chosaGaikyoKomokuChangeFlag, chosaKihonKomokuChangeFlag, shujiiIkenshoKomokuChangeFlag);
    }

// </editor-fold>
}
