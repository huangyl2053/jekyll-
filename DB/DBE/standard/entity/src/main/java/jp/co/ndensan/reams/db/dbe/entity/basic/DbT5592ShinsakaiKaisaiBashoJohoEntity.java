package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * 介護認定審査会開催場所情報テーブルのエンティティクラスです。
 */
public class DbT5592ShinsakaiKaisaiBashoJohoEntity extends DbTableEntityBase<DbT5592ShinsakaiKaisaiBashoJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5592ShinsakaiKaisaiBashoJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shinsakaiKaisaiBashoCode;
    private RString shinsakaiKaisaiBashoName;
    private Code shinsakaiKaisaiChikuCode;
    private AtenaJusho shinsakaiKaisaiBashoJusho;
    private TelNo shinsakaiKaisaiBashoTelNo;
    private RString shinsakaiKaisaiBashoJokyo;

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
     * 介護認定審査会開催場所コードのgetメソッドです。
     * 
     * @return 介護認定審査会開催場所コード
     */
    public RString getShinsakaiKaisaiBashoCode() {
        return shinsakaiKaisaiBashoCode;
    }

    /**
     * 介護認定審査会開催場所コードのsetメソッドです。
     * 
     * @param shinsakaiKaisaiBashoCode 介護認定審査会開催場所コード
     */
    public void setShinsakaiKaisaiBashoCode(RString shinsakaiKaisaiBashoCode) {
        this.shinsakaiKaisaiBashoCode = shinsakaiKaisaiBashoCode;
    }

    /**
     * 介護認定審査会開催場所名称のgetメソッドです。
     * 
     * @return 介護認定審査会開催場所名称
     */
    public RString getShinsakaiKaisaiBashoName() {
        return shinsakaiKaisaiBashoName;
    }

    /**
     * 介護認定審査会開催場所名称のsetメソッドです。
     * 
     * @param shinsakaiKaisaiBashoName 介護認定審査会開催場所名称
     */
    public void setShinsakaiKaisaiBashoName(RString shinsakaiKaisaiBashoName) {
        this.shinsakaiKaisaiBashoName = shinsakaiKaisaiBashoName;
    }

    /**
     * 介護認定審査会開催地区コードのgetメソッドです。
     * 
     * @return 介護認定審査会開催地区コード
     */
    public Code getShinsakaiKaisaiChikuCode() {
        return shinsakaiKaisaiChikuCode;
    }

    /**
     * 介護認定審査会開催地区コードのsetメソッドです。
     * 
     * @param shinsakaiKaisaiChikuCode 介護認定審査会開催地区コード
     */
    public void setShinsakaiKaisaiChikuCode(Code shinsakaiKaisaiChikuCode) {
        this.shinsakaiKaisaiChikuCode = shinsakaiKaisaiChikuCode;
    }

    /**
     * 介護認定審査会開催場所住所のgetメソッドです。
     * 
     * @return 介護認定審査会開催場所住所
     */
    public AtenaJusho getShinsakaiKaisaiBashoJusho() {
        return shinsakaiKaisaiBashoJusho;
    }

    /**
     * 介護認定審査会開催場所住所のsetメソッドです。
     * 
     * @param shinsakaiKaisaiBashoJusho 介護認定審査会開催場所住所
     */
    public void setShinsakaiKaisaiBashoJusho(AtenaJusho shinsakaiKaisaiBashoJusho) {
        this.shinsakaiKaisaiBashoJusho = shinsakaiKaisaiBashoJusho;
    }

    /**
     * 介護認定審査会開催場所電話番号のgetメソッドです。
     * 
     * @return 介護認定審査会開催場所電話番号
     */
    public TelNo getShinsakaiKaisaiBashoTelNo() {
        return shinsakaiKaisaiBashoTelNo;
    }

    /**
     * 介護認定審査会開催場所電話番号のsetメソッドです。
     * 
     * @param shinsakaiKaisaiBashoTelNo 介護認定審査会開催場所電話番号
     */
    public void setShinsakaiKaisaiBashoTelNo(TelNo shinsakaiKaisaiBashoTelNo) {
        this.shinsakaiKaisaiBashoTelNo = shinsakaiKaisaiBashoTelNo;
    }

    /**
     * 介護認定審査会開催場所状況のgetメソッドです。
     * 
     * @return 介護認定審査会開催場所状況
     */
    public RString getShinsakaiKaisaiBashoJokyo() {
        return shinsakaiKaisaiBashoJokyo;
    }

    /**
     * 介護認定審査会開催場所状況のsetメソッドです。
     * 
     * @param shinsakaiKaisaiBashoJokyo 介護認定審査会開催場所状況
     */
    public void setShinsakaiKaisaiBashoJokyo(RString shinsakaiKaisaiBashoJokyo) {
        this.shinsakaiKaisaiBashoJokyo = shinsakaiKaisaiBashoJokyo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5592ShinsakaiKaisaiBashoJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5592ShinsakaiKaisaiBashoJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5592ShinsakaiKaisaiBashoJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiKaisaiBashoCode, other.shinsakaiKaisaiBashoCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5592ShinsakaiKaisaiBashoJohoEntity entity) {
        this.shinsakaiKaisaiBashoCode = entity.shinsakaiKaisaiBashoCode;
        this.shinsakaiKaisaiBashoName = entity.shinsakaiKaisaiBashoName;
        this.shinsakaiKaisaiChikuCode = entity.shinsakaiKaisaiChikuCode;
        this.shinsakaiKaisaiBashoJusho = entity.shinsakaiKaisaiBashoJusho;
        this.shinsakaiKaisaiBashoTelNo = entity.shinsakaiKaisaiBashoTelNo;
        this.shinsakaiKaisaiBashoJokyo = entity.shinsakaiKaisaiBashoJokyo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiKaisaiBashoCode, shinsakaiKaisaiBashoName, shinsakaiKaisaiChikuCode, shinsakaiKaisaiBashoJusho, shinsakaiKaisaiBashoTelNo, shinsakaiKaisaiBashoJokyo);
    }

// </editor-fold>

}
