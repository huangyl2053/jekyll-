package jp.co.ndensan.reams.db.dbz.entity.basic;

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
 * DbT7027KakushuCodeHenkanの項目定義クラスです
 *
 */
public class DbT7027KakushuCodeHenkanEntity extends DbTableEntityBase<DbT7027KakushuCodeHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
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
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShichosonCode
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getCodeKubun
     * @return codeKubun
     */
    public RString getCodeKubun() {
        return codeKubun;
    }

    /**
     * setCodeKubun
     * @param codeKubun codeKubun
     */
    public void setCodeKubun(RString codeKubun) {
        this.codeKubun = codeKubun;
    }

    /**
     * getNaibuCode
     * @return naibuCode
     */
    public RString getNaibuCode() {
        return naibuCode;
    }

    /**
     * setNaibuCode
     * @param naibuCode naibuCode
     */
    public void setNaibuCode(RString naibuCode) {
        this.naibuCode = naibuCode;
    }

    /**
     * getNaibuNo
     * @return naibuNo
     */
    public RString getNaibuNo() {
        return naibuNo;
    }

    /**
     * setNaibuNo
     * @param naibuNo naibuNo
     */
    public void setNaibuNo(RString naibuNo) {
        this.naibuNo = naibuNo;
    }

    /**
     * getGaibuCode
     * @return gaibuCode
     */
    public RString getGaibuCode() {
        return gaibuCode;
    }

    /**
     * setGaibuCode
     * @param gaibuCode gaibuCode
     */
    public void setGaibuCode(RString gaibuCode) {
        this.gaibuCode = gaibuCode;
    }

    /**
     * getShichosonCode2
     * @return shichosonCode2
     */
    public LasdecCode getShichosonCode2() {
        return shichosonCode2;
    }

    /**
     * setShichosonCode2
     * @param shichosonCode2 shichosonCode2
     */
    public void setShichosonCode2(LasdecCode shichosonCode2) {
        this.shichosonCode2 = shichosonCode2;
    }

    /**
     * getGaibuCode2
     * @return gaibuCode2
     */
    public RString getGaibuCode2() {
        return gaibuCode2;
    }

    /**
     * setGaibuCode2
     * @param gaibuCode2 gaibuCode2
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
