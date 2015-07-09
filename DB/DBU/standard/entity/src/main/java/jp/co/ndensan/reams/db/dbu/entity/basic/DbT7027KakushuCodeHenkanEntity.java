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
 * 各種コード変換テーブルテーブルのエンティティクラスです。
 */
public class DbT7027KakushuCodeHenkanEntity extends DbTableEntityBase<DbT7027KakushuCodeHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7027KakushuCodeHenkan");

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
    @PrimaryKey
    private RString codeKubun;
    private RString naibuCode;
    private RString naibuNo;
    @PrimaryKey
    private RString gaibuCode;
    private LasdecCode shichosonCode2;
    private RString gaibuCode2;

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
     * コード区分のgetメソッドです。
     * <br/>
     * <br/>変換対象となるコードを表す
     * 
     * @return コード区分
     */
    public RString getCodeKubun() {
        return codeKubun;
    }

    /**
     * コード区分のsetメソッドです。
     * <br/>
     * <br/>変換対象となるコードを表す
     * 
     * @param codeKubun コード区分
     */
    public void setCodeKubun(RString codeKubun) {
        this.codeKubun = codeKubun;
    }

    /**
     * 内部コードのgetメソッドです。
     * 
     * @return 内部コード
     */
    public RString getNaibuCode() {
        return naibuCode;
    }

    /**
     * 内部コードのsetメソッドです。
     * 
     * @param naibuCode 内部コード
     */
    public void setNaibuCode(RString naibuCode) {
        this.naibuCode = naibuCode;
    }

    /**
     * 内部番号のgetメソッドです。
     * 
     * @return 内部番号
     */
    public RString getNaibuNo() {
        return naibuNo;
    }

    /**
     * 内部番号のsetメソッドです。
     * 
     * @param naibuNo 内部番号
     */
    public void setNaibuNo(RString naibuNo) {
        this.naibuNo = naibuNo;
    }

    /**
     * 外部コードのgetメソッドです。
     * 
     * @return 外部コード
     */
    public RString getGaibuCode() {
        return gaibuCode;
    }

    /**
     * 外部コードのsetメソッドです。
     * 
     * @param gaibuCode 外部コード
     */
    public void setGaibuCode(RString gaibuCode) {
        this.gaibuCode = gaibuCode;
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
     * 外部コード２のgetメソッドです。
     * 
     * @return 外部コード２
     */
    public RString getGaibuCode2() {
        return gaibuCode2;
    }

    /**
     * 外部コード２のsetメソッドです。
     * 
     * @param gaibuCode2 外部コード２
     */
    public void setGaibuCode2(RString gaibuCode2) {
        this.gaibuCode2 = gaibuCode2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7027KakushuCodeHenkanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7027KakushuCodeHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7027KakushuCodeHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.codeKubun, other.codeKubun)) {
            return false;
        }
        if (!Objects.equals(this.gaibuCode, other.gaibuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7027KakushuCodeHenkanEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.codeKubun = entity.codeKubun;
        this.naibuCode = entity.naibuCode;
        this.naibuNo = entity.naibuNo;
        this.gaibuCode = entity.gaibuCode;
        this.shichosonCode2 = entity.shichosonCode2;
        this.gaibuCode2 = entity.gaibuCode2;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, codeKubun, naibuCode, naibuNo, gaibuCode, shichosonCode2, gaibuCode2);
    }

// </editor-fold>
}
