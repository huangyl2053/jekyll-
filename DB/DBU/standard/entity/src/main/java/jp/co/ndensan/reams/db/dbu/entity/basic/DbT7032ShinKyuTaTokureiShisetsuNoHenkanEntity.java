package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import java.util.Objects;

/**
 * 新旧他特例施設番号変換テーブルテーブルのエンティティクラスです。
 */
public class DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity extends DbTableEntityBase<DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7032ShinKyuTaTokureiShisetsuNoHenkan");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    private RString shinTaTokureiShisetsuNo;
    @PrimaryKey
    private RString kyuTaTokureiShisetsuNo;
    private LasdecCode shichosonCode2;
    private RString kyuTaTokureiShisetsuNo2;

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
     * 新他特例施設番号のgetメソッドです。
     * 
     * @return 新他特例施設番号
     */
    public RString getShinTaTokureiShisetsuNo() {
        return shinTaTokureiShisetsuNo;
    }

    /**
     * 新他特例施設番号のsetメソッドです。
     * 
     * @param shinTaTokureiShisetsuNo 新他特例施設番号
     */
    public void setShinTaTokureiShisetsuNo(RString shinTaTokureiShisetsuNo) {
        this.shinTaTokureiShisetsuNo = shinTaTokureiShisetsuNo;
    }

    /**
     * 旧他特例施設番号のgetメソッドです。
     * 
     * @return 旧他特例施設番号
     */
    public RString getKyuTaTokureiShisetsuNo() {
        return kyuTaTokureiShisetsuNo;
    }

    /**
     * 旧他特例施設番号のsetメソッドです。
     * 
     * @param kyuTaTokureiShisetsuNo 旧他特例施設番号
     */
    public void setKyuTaTokureiShisetsuNo(RString kyuTaTokureiShisetsuNo) {
        this.kyuTaTokureiShisetsuNo = kyuTaTokureiShisetsuNo;
    }

    /**
     * 市町村コード２のgetメソッドです。
     * 
     * @return 市町村コード２
     */
    public LasdecCode getShichosonCode2() {
        return shichosonCode2;
    }

    /**
     * 市町村コード２のsetメソッドです。
     * 
     * @param shichosonCode2 市町村コード２
     */
    public void setShichosonCode2(LasdecCode shichosonCode2) {
        this.shichosonCode2 = shichosonCode2;
    }

    /**
     * 旧他特例施設番号２のgetメソッドです。
     * 
     * @return 旧他特例施設番号２
     */
    public RString getKyuTaTokureiShisetsuNo2() {
        return kyuTaTokureiShisetsuNo2;
    }

    /**
     * 旧他特例施設番号２のsetメソッドです。
     * 
     * @param kyuTaTokureiShisetsuNo2 旧他特例施設番号２
     */
    public void setKyuTaTokureiShisetsuNo2(RString kyuTaTokureiShisetsuNo2) {
        this.kyuTaTokureiShisetsuNo2 = kyuTaTokureiShisetsuNo2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kyuTaTokureiShisetsuNo, other.kyuTaTokureiShisetsuNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shinTaTokureiShisetsuNo = entity.shinTaTokureiShisetsuNo;
        this.kyuTaTokureiShisetsuNo = entity.kyuTaTokureiShisetsuNo;
        this.shichosonCode2 = entity.shichosonCode2;
        this.kyuTaTokureiShisetsuNo2 = entity.kyuTaTokureiShisetsuNo2;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shinTaTokureiShisetsuNo, kyuTaTokureiShisetsuNo, shichosonCode2, kyuTaTokureiShisetsuNo2);
    }

// </editor-fold>
}
