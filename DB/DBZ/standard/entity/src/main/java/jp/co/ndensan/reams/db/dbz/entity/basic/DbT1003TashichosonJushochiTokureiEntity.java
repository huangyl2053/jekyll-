package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * DbT1003TashichosonJushochiTokureiの項目定義クラスです
 *
 */
public class DbT1003TashichosonJushochiTokureiEntity extends DbTableEntityBase<DbT1003TashichosonJushochiTokureiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1003TashichosonJushochiTokurei");

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
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private YMDHMS shoriTimeStamp;
    private RString tekiyoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate tekiyoUketsukeYMD;
    private RString kaijoJiyuCode;
    private FlexibleDate kaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private FlexibleDate kaijoUketsukeYMD;
    private RString sochiHokenshaNo;
    private RString sochiHihokenshaNo;
    private FlexibleDate tatokuRenrakuhyoHakkoYMD;
    private FlexibleDate shisetsuTaishoTsuchiHakkoYMD;
    private FlexibleDate shisetsuHenkoTsuchiHakkoYMD;

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
     * getShikibetsuCode
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getShoriTimeStamp
     * @return shoriTimeStamp
     */
    public YMDHMS getShoriTimeStamp() {
        return shoriTimeStamp;
    }

    /**
     * setShoriTimeStamp
     * @param shoriTimeStamp shoriTimeStamp
     */
    public void setShoriTimeStamp(YMDHMS shoriTimeStamp) {
        this.shoriTimeStamp = shoriTimeStamp;
    }

    /**
     * getTekiyoJiyuCode
     * @return tekiyoJiyuCode
     */
    public RString getTekiyoJiyuCode() {
        return tekiyoJiyuCode;
    }

    /**
     * setTekiyoJiyuCode
     * @param tekiyoJiyuCode tekiyoJiyuCode
     */
    public void setTekiyoJiyuCode(RString tekiyoJiyuCode) {
        this.tekiyoJiyuCode = tekiyoJiyuCode;
    }

    /**
     * getTekiyoYMD
     * @return tekiyoYMD
     */
    public FlexibleDate getTekiyoYMD() {
        return tekiyoYMD;
    }

    /**
     * setTekiyoYMD
     * @param tekiyoYMD tekiyoYMD
     */
    public void setTekiyoYMD(FlexibleDate tekiyoYMD) {
        this.tekiyoYMD = tekiyoYMD;
    }

    /**
     * getTekiyoTodokedeYMD
     * @return tekiyoTodokedeYMD
     */
    public FlexibleDate getTekiyoTodokedeYMD() {
        return tekiyoTodokedeYMD;
    }

    /**
     * setTekiyoTodokedeYMD
     * @param tekiyoTodokedeYMD tekiyoTodokedeYMD
     */
    public void setTekiyoTodokedeYMD(FlexibleDate tekiyoTodokedeYMD) {
        this.tekiyoTodokedeYMD = tekiyoTodokedeYMD;
    }

    /**
     * getTekiyoUketsukeYMD
     * @return tekiyoUketsukeYMD
     */
    public FlexibleDate getTekiyoUketsukeYMD() {
        return tekiyoUketsukeYMD;
    }

    /**
     * setTekiyoUketsukeYMD
     * @param tekiyoUketsukeYMD tekiyoUketsukeYMD
     */
    public void setTekiyoUketsukeYMD(FlexibleDate tekiyoUketsukeYMD) {
        this.tekiyoUketsukeYMD = tekiyoUketsukeYMD;
    }

    /**
     * getKaijoJiyuCode
     * @return kaijoJiyuCode
     */
    public RString getKaijoJiyuCode() {
        return kaijoJiyuCode;
    }

    /**
     * setKaijoJiyuCode
     * @param kaijoJiyuCode kaijoJiyuCode
     */
    public void setKaijoJiyuCode(RString kaijoJiyuCode) {
        this.kaijoJiyuCode = kaijoJiyuCode;
    }

    /**
     * getKaijoYMD
     * @return kaijoYMD
     */
    public FlexibleDate getKaijoYMD() {
        return kaijoYMD;
    }

    /**
     * setKaijoYMD
     * @param kaijoYMD kaijoYMD
     */
    public void setKaijoYMD(FlexibleDate kaijoYMD) {
        this.kaijoYMD = kaijoYMD;
    }

    /**
     * getKaijoTodokedeYMD
     * @return kaijoTodokedeYMD
     */
    public FlexibleDate getKaijoTodokedeYMD() {
        return kaijoTodokedeYMD;
    }

    /**
     * setKaijoTodokedeYMD
     * @param kaijoTodokedeYMD kaijoTodokedeYMD
     */
    public void setKaijoTodokedeYMD(FlexibleDate kaijoTodokedeYMD) {
        this.kaijoTodokedeYMD = kaijoTodokedeYMD;
    }

    /**
     * getKaijoUketsukeYMD
     * @return kaijoUketsukeYMD
     */
    public FlexibleDate getKaijoUketsukeYMD() {
        return kaijoUketsukeYMD;
    }

    /**
     * setKaijoUketsukeYMD
     * @param kaijoUketsukeYMD kaijoUketsukeYMD
     */
    public void setKaijoUketsukeYMD(FlexibleDate kaijoUketsukeYMD) {
        this.kaijoUketsukeYMD = kaijoUketsukeYMD;
    }

    /**
     * getSochiHokenshaNo
     * @return sochiHokenshaNo
     */
    public RString getSochiHokenshaNo() {
        return sochiHokenshaNo;
    }

    /**
     * setSochiHokenshaNo
     * @param sochiHokenshaNo sochiHokenshaNo
     */
    public void setSochiHokenshaNo(RString sochiHokenshaNo) {
        this.sochiHokenshaNo = sochiHokenshaNo;
    }

    /**
     * getSochiHihokenshaNo
     * @return sochiHihokenshaNo
     */
    public RString getSochiHihokenshaNo() {
        return sochiHihokenshaNo;
    }

    /**
     * setSochiHihokenshaNo
     * @param sochiHihokenshaNo sochiHihokenshaNo
     */
    public void setSochiHihokenshaNo(RString sochiHihokenshaNo) {
        this.sochiHihokenshaNo = sochiHihokenshaNo;
    }

    /**
     * getTatokuRenrakuhyoHakkoYMD
     * @return tatokuRenrakuhyoHakkoYMD
     */
    public FlexibleDate getTatokuRenrakuhyoHakkoYMD() {
        return tatokuRenrakuhyoHakkoYMD;
    }

    /**
     * setTatokuRenrakuhyoHakkoYMD
     * @param tatokuRenrakuhyoHakkoYMD tatokuRenrakuhyoHakkoYMD
     */
    public void setTatokuRenrakuhyoHakkoYMD(FlexibleDate tatokuRenrakuhyoHakkoYMD) {
        this.tatokuRenrakuhyoHakkoYMD = tatokuRenrakuhyoHakkoYMD;
    }

    /**
     * getShisetsuTaishoTsuchiHakkoYMD
     * @return shisetsuTaishoTsuchiHakkoYMD
     */
    public FlexibleDate getShisetsuTaishoTsuchiHakkoYMD() {
        return shisetsuTaishoTsuchiHakkoYMD;
    }

    /**
     * setShisetsuTaishoTsuchiHakkoYMD
     * @param shisetsuTaishoTsuchiHakkoYMD shisetsuTaishoTsuchiHakkoYMD
     */
    public void setShisetsuTaishoTsuchiHakkoYMD(FlexibleDate shisetsuTaishoTsuchiHakkoYMD) {
        this.shisetsuTaishoTsuchiHakkoYMD = shisetsuTaishoTsuchiHakkoYMD;
    }

    /**
     * getShisetsuHenkoTsuchiHakkoYMD
     * @return shisetsuHenkoTsuchiHakkoYMD
     */
    public FlexibleDate getShisetsuHenkoTsuchiHakkoYMD() {
        return shisetsuHenkoTsuchiHakkoYMD;
    }

    /**
     * setShisetsuHenkoTsuchiHakkoYMD
     * @param shisetsuHenkoTsuchiHakkoYMD shisetsuHenkoTsuchiHakkoYMD
     */
    public void setShisetsuHenkoTsuchiHakkoYMD(FlexibleDate shisetsuHenkoTsuchiHakkoYMD) {
        this.shisetsuHenkoTsuchiHakkoYMD = shisetsuHenkoTsuchiHakkoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1003TashichosonJushochiTokureiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1003TashichosonJushochiTokureiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1003TashichosonJushochiTokureiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimeStamp, other.shoriTimeStamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1003TashichosonJushochiTokureiEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shoriTimeStamp = entity.shoriTimeStamp;
        this.tekiyoJiyuCode = entity.tekiyoJiyuCode;
        this.tekiyoYMD = entity.tekiyoYMD;
        this.tekiyoTodokedeYMD = entity.tekiyoTodokedeYMD;
        this.tekiyoUketsukeYMD = entity.tekiyoUketsukeYMD;
        this.kaijoJiyuCode = entity.kaijoJiyuCode;
        this.kaijoYMD = entity.kaijoYMD;
        this.kaijoTodokedeYMD = entity.kaijoTodokedeYMD;
        this.kaijoUketsukeYMD = entity.kaijoUketsukeYMD;
        this.sochiHokenshaNo = entity.sochiHokenshaNo;
        this.sochiHihokenshaNo = entity.sochiHihokenshaNo;
        this.tatokuRenrakuhyoHakkoYMD = entity.tatokuRenrakuhyoHakkoYMD;
        this.shisetsuTaishoTsuchiHakkoYMD = entity.shisetsuTaishoTsuchiHakkoYMD;
        this.shisetsuHenkoTsuchiHakkoYMD = entity.shisetsuHenkoTsuchiHakkoYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shikibetsuCode, shoriTimeStamp, tekiyoJiyuCode, tekiyoYMD, tekiyoTodokedeYMD, tekiyoUketsukeYMD, kaijoJiyuCode, kaijoYMD, kaijoTodokedeYMD, kaijoUketsukeYMD, sochiHokenshaNo, sochiHihokenshaNo, tatokuRenrakuhyoHakkoYMD, shisetsuTaishoTsuchiHakkoYMD, shisetsuHenkoTsuchiHakkoYMD);
    }

// </editor-fold>



}
