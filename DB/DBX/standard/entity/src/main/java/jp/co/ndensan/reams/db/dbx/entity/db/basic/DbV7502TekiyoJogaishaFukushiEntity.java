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
 * 適用除外者・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7502TekiyoJogaishaFukushiEntity extends DbTableEntityBase<DbV7502TekiyoJogaishaFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7502TekiyoJogaishaFukushi");

    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private RString idoJiyuCode;
    private LasdecCode shichosonCode;
    private RString tekiyoJogaiTekiyoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate tekiyoUketsukeYMD;
    private RString tekiyoJogaikaijokaijoJiyuCode;
    private FlexibleDate kaijoYMD;
    private RString kaijoYMDDCmp;
    private FlexibleDate kaijoTodokedeYMD;
    private FlexibleDate kaijoUketsukeYMD;
    private FlexibleDate nyushoTsuchiHakkoYMD;
    private FlexibleDate taishoTsuchiHakkoYMD;
    private FlexibleDate henkoTsuchiHakkoYMD;
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
     * tekiyoJogaiTekiyoJiyuCodeのgetメソッドです。
     * 
     * @return tekiyoJogaiTekiyoJiyuCode
     */
    @CheckForNull
    public RString getTekiyoJogaiTekiyoJiyuCode() {
        return tekiyoJogaiTekiyoJiyuCode;
    }

    /**
     * tekiyoJogaiTekiyoJiyuCodeのsetメソッドです。
     * 
     * @param tekiyoJogaiTekiyoJiyuCode tekiyoJogaiTekiyoJiyuCode
     */
    public void setTekiyoJogaiTekiyoJiyuCode(RString tekiyoJogaiTekiyoJiyuCode) {
        this.tekiyoJogaiTekiyoJiyuCode = tekiyoJogaiTekiyoJiyuCode;
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
     * tekiyoJogaikaijokaijoJiyuCodeのgetメソッドです。
     * 
     * @return tekiyoJogaikaijokaijoJiyuCode
     */
    @CheckForNull
    public RString getTekiyoJogaikaijokaijoJiyuCode() {
        return tekiyoJogaikaijokaijoJiyuCode;
    }

    /**
     * tekiyoJogaikaijokaijoJiyuCodeのsetメソッドです。
     * 
     * @param tekiyoJogaikaijokaijoJiyuCode tekiyoJogaikaijokaijoJiyuCode
     */
    public void setTekiyoJogaikaijokaijoJiyuCode(RString tekiyoJogaikaijokaijoJiyuCode) {
        this.tekiyoJogaikaijokaijoJiyuCode = tekiyoJogaikaijokaijoJiyuCode;
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
     * nyushoTsuchiHakkoYMDのgetメソッドです。
     * 
     * @return nyushoTsuchiHakkoYMD
     */
    @CheckForNull
    public FlexibleDate getNyushoTsuchiHakkoYMD() {
        return nyushoTsuchiHakkoYMD;
    }

    /**
     * nyushoTsuchiHakkoYMDのsetメソッドです。
     * 
     * @param nyushoTsuchiHakkoYMD nyushoTsuchiHakkoYMD
     */
    public void setNyushoTsuchiHakkoYMD(FlexibleDate nyushoTsuchiHakkoYMD) {
        this.nyushoTsuchiHakkoYMD = nyushoTsuchiHakkoYMD;
    }

    /**
     * taishoTsuchiHakkoYMDのgetメソッドです。
     * 
     * @return taishoTsuchiHakkoYMD
     */
    @CheckForNull
    public FlexibleDate getTaishoTsuchiHakkoYMD() {
        return taishoTsuchiHakkoYMD;
    }

    /**
     * taishoTsuchiHakkoYMDのsetメソッドです。
     * 
     * @param taishoTsuchiHakkoYMD taishoTsuchiHakkoYMD
     */
    public void setTaishoTsuchiHakkoYMD(FlexibleDate taishoTsuchiHakkoYMD) {
        this.taishoTsuchiHakkoYMD = taishoTsuchiHakkoYMD;
    }

    /**
     * henkoTsuchiHakkoYMDのgetメソッドです。
     * 
     * @return henkoTsuchiHakkoYMD
     */
    @CheckForNull
    public FlexibleDate getHenkoTsuchiHakkoYMD() {
        return henkoTsuchiHakkoYMD;
    }

    /**
     * henkoTsuchiHakkoYMDのsetメソッドです。
     * 
     * @param henkoTsuchiHakkoYMD henkoTsuchiHakkoYMD
     */
    public void setHenkoTsuchiHakkoYMD(FlexibleDate henkoTsuchiHakkoYMD) {
        this.henkoTsuchiHakkoYMD = henkoTsuchiHakkoYMD;
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
     * このエンティティの主キーが他の{@literal DbV7502TekiyoJogaishaFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7502TekiyoJogaishaFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7502TekiyoJogaishaFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7502TekiyoJogaishaFukushiEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.idoYMD = entity.idoYMD;
        this.edaNo = entity.edaNo;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.shichosonCode = entity.shichosonCode;
        this.tekiyoJogaiTekiyoJiyuCode = entity.tekiyoJogaiTekiyoJiyuCode;
        this.tekiyoYMD = entity.tekiyoYMD;
        this.tekiyoTodokedeYMD = entity.tekiyoTodokedeYMD;
        this.tekiyoUketsukeYMD = entity.tekiyoUketsukeYMD;
        this.tekiyoJogaikaijokaijoJiyuCode = entity.tekiyoJogaikaijokaijoJiyuCode;
        this.kaijoYMD = entity.kaijoYMD;
        this.kaijoYMDDCmp = entity.kaijoYMDDCmp;
        this.kaijoTodokedeYMD = entity.kaijoTodokedeYMD;
        this.kaijoUketsukeYMD = entity.kaijoUketsukeYMD;
        this.nyushoTsuchiHakkoYMD = entity.nyushoTsuchiHakkoYMD;
        this.taishoTsuchiHakkoYMD = entity.taishoTsuchiHakkoYMD;
        this.henkoTsuchiHakkoYMD = entity.henkoTsuchiHakkoYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, idoYMD, edaNo, idoJiyuCode, shichosonCode, tekiyoJogaiTekiyoJiyuCode, tekiyoYMD, tekiyoTodokedeYMD, tekiyoUketsukeYMD, tekiyoJogaikaijokaijoJiyuCode, kaijoYMD, kaijoYMDDCmp, kaijoTodokedeYMD, kaijoUketsukeYMD, nyushoTsuchiHakkoYMD, taishoTsuchiHakkoYMD, henkoTsuchiHakkoYMD, logicalDeletedFlag);
    }

// </editor-fold>
}
