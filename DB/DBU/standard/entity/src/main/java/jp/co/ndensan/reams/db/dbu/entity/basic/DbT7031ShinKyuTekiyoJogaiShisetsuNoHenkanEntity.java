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
 * 新旧適用除外施設番号変換テーブルテーブルのエンティティクラスです。
 */
public class DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity extends DbTableEntityBase<DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan");

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
    private RString shinTekiyoJogaiShisetsuNo;
    @PrimaryKey
    private RString kyuTekiyoJogaiShisetsuNo;
    private LasdecCode shichosonCode2;
    private RString kyuTekiyoJogaiShisetsuNo2;

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
     * 新適用除外施設番号のgetメソッドです。
     * 
     * @return 新適用除外施設番号
     */
    public RString getShinTekiyoJogaiShisetsuNo() {
        return shinTekiyoJogaiShisetsuNo;
    }

    /**
     * 新適用除外施設番号のsetメソッドです。
     * 
     * @param shinTekiyoJogaiShisetsuNo 新適用除外施設番号
     */
    public void setShinTekiyoJogaiShisetsuNo(RString shinTekiyoJogaiShisetsuNo) {
        this.shinTekiyoJogaiShisetsuNo = shinTekiyoJogaiShisetsuNo;
    }

    /**
     * 旧適用除外施設番号のgetメソッドです。
     * 
     * @return 旧適用除外施設番号
     */
    public RString getKyuTekiyoJogaiShisetsuNo() {
        return kyuTekiyoJogaiShisetsuNo;
    }

    /**
     * 旧適用除外施設番号のsetメソッドです。
     * 
     * @param kyuTekiyoJogaiShisetsuNo 旧適用除外施設番号
     */
    public void setKyuTekiyoJogaiShisetsuNo(RString kyuTekiyoJogaiShisetsuNo) {
        this.kyuTekiyoJogaiShisetsuNo = kyuTekiyoJogaiShisetsuNo;
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
     * 旧適用除外施設番号２のgetメソッドです。
     * 
     * @return 旧適用除外施設番号２
     */
    public RString getKyuTekiyoJogaiShisetsuNo2() {
        return kyuTekiyoJogaiShisetsuNo2;
    }

    /**
     * 旧適用除外施設番号２のsetメソッドです。
     * 
     * @param kyuTekiyoJogaiShisetsuNo2 旧適用除外施設番号２
     */
    public void setKyuTekiyoJogaiShisetsuNo2(RString kyuTekiyoJogaiShisetsuNo2) {
        this.kyuTekiyoJogaiShisetsuNo2 = kyuTekiyoJogaiShisetsuNo2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kyuTekiyoJogaiShisetsuNo, other.kyuTekiyoJogaiShisetsuNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shinTekiyoJogaiShisetsuNo = entity.shinTekiyoJogaiShisetsuNo;
        this.kyuTekiyoJogaiShisetsuNo = entity.kyuTekiyoJogaiShisetsuNo;
        this.shichosonCode2 = entity.shichosonCode2;
        this.kyuTekiyoJogaiShisetsuNo2 = entity.kyuTekiyoJogaiShisetsuNo2;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shinTekiyoJogaiShisetsuNo, kyuTekiyoJogaiShisetsuNo, shichosonCode2, kyuTekiyoJogaiShisetsuNo2);
    }

// </editor-fold>
}
