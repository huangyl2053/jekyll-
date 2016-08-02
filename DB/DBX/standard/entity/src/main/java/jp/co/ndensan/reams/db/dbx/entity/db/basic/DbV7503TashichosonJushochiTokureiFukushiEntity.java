package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 他市町村住所地特例・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7503TashichosonJushochiTokureiFukushiEntity extends DbTableEntityBase<DbV7503TashichosonJushochiTokureiFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7503TashichosonJushochiTokureiFukushi");

    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private RString idoJiyuCode;
    private LasdecCode shichosonCode;
    private RString tekiyoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate tekiyoUketsukeYMD;
    private RString kaijoJiyuCode;
    private FlexibleDate kaijoYMD;
    private RString kaijoYMDDCmp;
    private FlexibleDate kaijoTodokedeYMD;
    private FlexibleDate kaijoUketsukeYMD;
    private ShoKisaiHokenshaNo sochiHokenshaNo;
    private HihokenshaNo sochiHihokenshaNo;
    private FlexibleDate tatokuRenrakuhyoHakkoYMD;
    private FlexibleDate shisetsuTaishoTsuchiHakkoYMD;
    private FlexibleDate shisetsuHenkoTsuchiHakkoYMD;
    private boolean logicalDeletedFlag;

    /**
     * shikibetsuCodeのgetメソッドです。
     * 
     * @return shikibetsuCode
     */
    @CheckForNull
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shikibetsuCodeのsetメソッドです。
     * 
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * idoYMDのgetメソッドです。
     * 
     * @return idoYMD
     */
    @CheckForNull
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * idoYMDのsetメソッドです。
     * 
     * @param idoYMD idoYMD
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * edaNoのgetメソッドです。
     * 
     * @return edaNo
     */
    @CheckForNull
    public RString getEdaNo() {
        return edaNo;
    }

    /**
     * edaNoのsetメソッドです。
     * 
     * @param edaNo edaNo
     */
    public void setEdaNo(RString edaNo) {
        this.edaNo = edaNo;
    }

    /**
     * idoJiyuCodeのgetメソッドです。
     * 
     * @return idoJiyuCode
     */
    @CheckForNull
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * idoJiyuCodeのsetメソッドです。
     * 
     * @param idoJiyuCode idoJiyuCode
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * shichosonCodeのgetメソッドです。
     * 
     * @return shichosonCode
     */
    @CheckForNull
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * shichosonCodeのsetメソッドです。
     * 
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * tekiyoJiyuCodeのgetメソッドです。
     * 
     * @return tekiyoJiyuCode
     */
    @CheckForNull
    public RString getTekiyoJiyuCode() {
        return tekiyoJiyuCode;
    }

    /**
     * tekiyoJiyuCodeのsetメソッドです。
     * 
     * @param tekiyoJiyuCode tekiyoJiyuCode
     */
    public void setTekiyoJiyuCode(RString tekiyoJiyuCode) {
        this.tekiyoJiyuCode = tekiyoJiyuCode;
    }

    /**
     * tekiyoYMDのgetメソッドです。
     * 
     * @return tekiyoYMD
     */
    @CheckForNull
    public FlexibleDate getTekiyoYMD() {
        return tekiyoYMD;
    }

    /**
     * tekiyoYMDのsetメソッドです。
     * 
     * @param tekiyoYMD tekiyoYMD
     */
    public void setTekiyoYMD(FlexibleDate tekiyoYMD) {
        this.tekiyoYMD = tekiyoYMD;
    }

    /**
     * tekiyoTodokedeYMDのgetメソッドです。
     * 
     * @return tekiyoTodokedeYMD
     */
    @CheckForNull
    public FlexibleDate getTekiyoTodokedeYMD() {
        return tekiyoTodokedeYMD;
    }

    /**
     * tekiyoTodokedeYMDのsetメソッドです。
     * 
     * @param tekiyoTodokedeYMD tekiyoTodokedeYMD
     */
    public void setTekiyoTodokedeYMD(FlexibleDate tekiyoTodokedeYMD) {
        this.tekiyoTodokedeYMD = tekiyoTodokedeYMD;
    }

    /**
     * tekiyoUketsukeYMDのgetメソッドです。
     * 
     * @return tekiyoUketsukeYMD
     */
    @CheckForNull
    public FlexibleDate getTekiyoUketsukeYMD() {
        return tekiyoUketsukeYMD;
    }

    /**
     * tekiyoUketsukeYMDのsetメソッドです。
     * 
     * @param tekiyoUketsukeYMD tekiyoUketsukeYMD
     */
    public void setTekiyoUketsukeYMD(FlexibleDate tekiyoUketsukeYMD) {
        this.tekiyoUketsukeYMD = tekiyoUketsukeYMD;
    }

    /**
     * kaijoJiyuCodeのgetメソッドです。
     * 
     * @return kaijoJiyuCode
     */
    @CheckForNull
    public RString getKaijoJiyuCode() {
        return kaijoJiyuCode;
    }

    /**
     * kaijoJiyuCodeのsetメソッドです。
     * 
     * @param kaijoJiyuCode kaijoJiyuCode
     */
    public void setKaijoJiyuCode(RString kaijoJiyuCode) {
        this.kaijoJiyuCode = kaijoJiyuCode;
    }

    /**
     * kaijoYMDのgetメソッドです。
     * 
     * @return kaijoYMD
     */
    @CheckForNull
    public FlexibleDate getKaijoYMD() {
        return kaijoYMD;
    }

    /**
     * kaijoYMDのsetメソッドです。
     * 
     * @param kaijoYMD kaijoYMD
     */
    public void setKaijoYMD(FlexibleDate kaijoYMD) {
        this.kaijoYMD = kaijoYMD;
    }

    /**
     * kaijoYMDDCmpのgetメソッドです。
     * 
     * @return kaijoYMDDCmp
     */
    @CheckForNull
    public RString getKaijoYMDDCmp() {
        return kaijoYMDDCmp;
    }

    /**
     * kaijoYMDDCmpのsetメソッドです。
     * 
     * @param kaijoYMDDCmp kaijoYMDDCmp
     */
    public void setKaijoYMDDCmp(RString kaijoYMDDCmp) {
        this.kaijoYMDDCmp = kaijoYMDDCmp;
    }

    /**
     * kaijoTodokedeYMDのgetメソッドです。
     * 
     * @return kaijoTodokedeYMD
     */
    @CheckForNull
    public FlexibleDate getKaijoTodokedeYMD() {
        return kaijoTodokedeYMD;
    }

    /**
     * kaijoTodokedeYMDのsetメソッドです。
     * 
     * @param kaijoTodokedeYMD kaijoTodokedeYMD
     */
    public void setKaijoTodokedeYMD(FlexibleDate kaijoTodokedeYMD) {
        this.kaijoTodokedeYMD = kaijoTodokedeYMD;
    }

    /**
     * kaijoUketsukeYMDのgetメソッドです。
     * 
     * @return kaijoUketsukeYMD
     */
    @CheckForNull
    public FlexibleDate getKaijoUketsukeYMD() {
        return kaijoUketsukeYMD;
    }

    /**
     * kaijoUketsukeYMDのsetメソッドです。
     * 
     * @param kaijoUketsukeYMD kaijoUketsukeYMD
     */
    public void setKaijoUketsukeYMD(FlexibleDate kaijoUketsukeYMD) {
        this.kaijoUketsukeYMD = kaijoUketsukeYMD;
    }

    /**
     * sochiHokenshaNoのgetメソッドです。
     * 
     * @return sochiHokenshaNo
     */
    @CheckForNull
    public ShoKisaiHokenshaNo getSochiHokenshaNo() {
        return sochiHokenshaNo;
    }

    /**
     * sochiHokenshaNoのsetメソッドです。
     * 
     * @param sochiHokenshaNo sochiHokenshaNo
     */
    public void setSochiHokenshaNo(ShoKisaiHokenshaNo sochiHokenshaNo) {
        this.sochiHokenshaNo = sochiHokenshaNo;
    }

    /**
     * sochiHihokenshaNoのgetメソッドです。
     * 
     * @return sochiHihokenshaNo
     */
    @CheckForNull
    public HihokenshaNo getSochiHihokenshaNo() {
        return sochiHihokenshaNo;
    }

    /**
     * sochiHihokenshaNoのsetメソッドです。
     * 
     * @param sochiHihokenshaNo sochiHihokenshaNo
     */
    public void setSochiHihokenshaNo(HihokenshaNo sochiHihokenshaNo) {
        this.sochiHihokenshaNo = sochiHihokenshaNo;
    }

    /**
     * tatokuRenrakuhyoHakkoYMDのgetメソッドです。
     * 
     * @return tatokuRenrakuhyoHakkoYMD
     */
    @CheckForNull
    public FlexibleDate getTatokuRenrakuhyoHakkoYMD() {
        return tatokuRenrakuhyoHakkoYMD;
    }

    /**
     * tatokuRenrakuhyoHakkoYMDのsetメソッドです。
     * 
     * @param tatokuRenrakuhyoHakkoYMD tatokuRenrakuhyoHakkoYMD
     */
    public void setTatokuRenrakuhyoHakkoYMD(FlexibleDate tatokuRenrakuhyoHakkoYMD) {
        this.tatokuRenrakuhyoHakkoYMD = tatokuRenrakuhyoHakkoYMD;
    }

    /**
     * shisetsuTaishoTsuchiHakkoYMDのgetメソッドです。
     * 
     * @return shisetsuTaishoTsuchiHakkoYMD
     */
    @CheckForNull
    public FlexibleDate getShisetsuTaishoTsuchiHakkoYMD() {
        return shisetsuTaishoTsuchiHakkoYMD;
    }

    /**
     * shisetsuTaishoTsuchiHakkoYMDのsetメソッドです。
     * 
     * @param shisetsuTaishoTsuchiHakkoYMD shisetsuTaishoTsuchiHakkoYMD
     */
    public void setShisetsuTaishoTsuchiHakkoYMD(FlexibleDate shisetsuTaishoTsuchiHakkoYMD) {
        this.shisetsuTaishoTsuchiHakkoYMD = shisetsuTaishoTsuchiHakkoYMD;
    }

    /**
     * shisetsuHenkoTsuchiHakkoYMDのgetメソッドです。
     * 
     * @return shisetsuHenkoTsuchiHakkoYMD
     */
    @CheckForNull
    public FlexibleDate getShisetsuHenkoTsuchiHakkoYMD() {
        return shisetsuHenkoTsuchiHakkoYMD;
    }

    /**
     * shisetsuHenkoTsuchiHakkoYMDのsetメソッドです。
     * 
     * @param shisetsuHenkoTsuchiHakkoYMD shisetsuHenkoTsuchiHakkoYMD
     */
    public void setShisetsuHenkoTsuchiHakkoYMD(FlexibleDate shisetsuHenkoTsuchiHakkoYMD) {
        this.shisetsuHenkoTsuchiHakkoYMD = shisetsuHenkoTsuchiHakkoYMD;
    }

    /**
     * logicalDeletedFlagのgetメソッドです。
     * 
     * @return logicalDeletedFlag
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * logicalDeletedFlagのsetメソッドです。
     * 
     * @param logicalDeletedFlag logicalDeletedFlag
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7503TashichosonJushochiTokureiFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7503TashichosonJushochiTokureiFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7503TashichosonJushochiTokureiFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7503TashichosonJushochiTokureiFukushiEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.idoYMD = entity.idoYMD;
        this.edaNo = entity.edaNo;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.shichosonCode = entity.shichosonCode;
        this.tekiyoJiyuCode = entity.tekiyoJiyuCode;
        this.tekiyoYMD = entity.tekiyoYMD;
        this.tekiyoTodokedeYMD = entity.tekiyoTodokedeYMD;
        this.tekiyoUketsukeYMD = entity.tekiyoUketsukeYMD;
        this.kaijoJiyuCode = entity.kaijoJiyuCode;
        this.kaijoYMD = entity.kaijoYMD;
        this.kaijoYMDDCmp = entity.kaijoYMDDCmp;
        this.kaijoTodokedeYMD = entity.kaijoTodokedeYMD;
        this.kaijoUketsukeYMD = entity.kaijoUketsukeYMD;
        this.sochiHokenshaNo = entity.sochiHokenshaNo;
        this.sochiHihokenshaNo = entity.sochiHihokenshaNo;
        this.tatokuRenrakuhyoHakkoYMD = entity.tatokuRenrakuhyoHakkoYMD;
        this.shisetsuTaishoTsuchiHakkoYMD = entity.shisetsuTaishoTsuchiHakkoYMD;
        this.shisetsuHenkoTsuchiHakkoYMD = entity.shisetsuHenkoTsuchiHakkoYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, idoYMD, edaNo, idoJiyuCode, shichosonCode, tekiyoJiyuCode, tekiyoYMD, tekiyoTodokedeYMD, tekiyoUketsukeYMD, kaijoJiyuCode, kaijoYMD, kaijoYMDDCmp, kaijoTodokedeYMD, kaijoUketsukeYMD, sochiHokenshaNo, sochiHihokenshaNo, tatokuRenrakuhyoHakkoYMD, shisetsuTaishoTsuchiHakkoYMD, shisetsuHenkoTsuchiHakkoYMD, logicalDeletedFlag);
    }

// </editor-fold>
}
