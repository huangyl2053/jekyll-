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
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuShutokuJiyuJogaiTekiyo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuSoshitsuJiyuJogaiTekiyo;

/**
 * DbT1002TekiyoJogaishaの項目定義クラスです
 *
 */
public class DbT1002TekiyoJogaishaEntity extends DbTableEntityBase<DbT1002TekiyoJogaishaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1002TekiyoJogaisha");

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
    private YMDHMS shoriTimestamp;
    private KaigoshikakuShutokuJiyuJogaiTekiyo tekiyoJogaiTekiyoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate tekiyoUketsukeYMD;
    private KaigoshikakuSoshitsuJiyuJogaiTekiyo tekiyoJogaikaijokaijoJiyuCode;
    private FlexibleDate kaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private FlexibleDate kaijoUketsukeYMD;
    private FlexibleDate nyushoTsuchiHakkoYMD;
    private FlexibleDate taishoTsuchiHakkoYMD;
    private FlexibleDate henkoTsuchiHakkoYMD;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getTekiyoJogaiTekiyoJiyuCode
     *
     * @return tekiyoJogaiTekiyoJiyuCode
     */
    public KaigoshikakuShutokuJiyuJogaiTekiyo getTekiyoJogaiTekiyoJiyuCode() {
        return tekiyoJogaiTekiyoJiyuCode;
    }

    /**
     * setTekiyoJogaiTekiyoJiyuCode
     *
     * @param tekiyoJogaiTekiyoJiyuCode tekiyoJogaiTekiyoJiyuCode
     */
    public void setTekiyoJogaiTekiyoJiyuCode(KaigoshikakuShutokuJiyuJogaiTekiyo tekiyoJogaiTekiyoJiyuCode) {
        this.tekiyoJogaiTekiyoJiyuCode = tekiyoJogaiTekiyoJiyuCode;
    }

    /**
     * getTekiyoYMD
     *
     * @return tekiyoYMD
     */
    public FlexibleDate getTekiyoYMD() {
        return tekiyoYMD;
    }

    /**
     * setTekiyoYMD
     *
     * @param tekiyoYMD tekiyoYMD
     */
    public void setTekiyoYMD(FlexibleDate tekiyoYMD) {
        this.tekiyoYMD = tekiyoYMD;
    }

    /**
     * getTekiyoTodokedeYMD
     *
     * @return tekiyoTodokedeYMD
     */
    public FlexibleDate getTekiyoTodokedeYMD() {
        return tekiyoTodokedeYMD;
    }

    /**
     * setTekiyoTodokedeYMD
     *
     * @param tekiyoTodokedeYMD tekiyoTodokedeYMD
     */
    public void setTekiyoTodokedeYMD(FlexibleDate tekiyoTodokedeYMD) {
        this.tekiyoTodokedeYMD = tekiyoTodokedeYMD;
    }

    /**
     * getTekiyoUketsukeYMD
     *
     * @return tekiyoUketsukeYMD
     */
    public FlexibleDate getTekiyoUketsukeYMD() {
        return tekiyoUketsukeYMD;
    }

    /**
     * setTekiyoUketsukeYMD
     *
     * @param tekiyoUketsukeYMD tekiyoUketsukeYMD
     */
    public void setTekiyoUketsukeYMD(FlexibleDate tekiyoUketsukeYMD) {
        this.tekiyoUketsukeYMD = tekiyoUketsukeYMD;
    }

    /**
     * getTekiyoJogaikaijokaijoJiyuCode
     *
     * @return tekiyoJogaikaijokaijoJiyuCode
     */
    public KaigoshikakuSoshitsuJiyuJogaiTekiyo getTekiyoJogaikaijokaijoJiyuCode() {
        return tekiyoJogaikaijokaijoJiyuCode;
    }

    /**
     * setTekiyoJogaikaijokaijoJiyuCode
     *
     * @param tekiyoJogaikaijokaijoJiyuCode tekiyoJogaikaijokaijoJiyuCode
     */
    public void setTekiyoJogaikaijokaijoJiyuCode(KaigoshikakuSoshitsuJiyuJogaiTekiyo tekiyoJogaikaijokaijoJiyuCode) {
        this.tekiyoJogaikaijokaijoJiyuCode = tekiyoJogaikaijokaijoJiyuCode;
    }

    /**
     * getKaijoYMD
     *
     * @return kaijoYMD
     */
    public FlexibleDate getKaijoYMD() {
        return kaijoYMD;
    }

    /**
     * setKaijoYMD
     *
     * @param kaijoYMD kaijoYMD
     */
    public void setKaijoYMD(FlexibleDate kaijoYMD) {
        this.kaijoYMD = kaijoYMD;
    }

    /**
     * getKaijoTodokedeYMD
     *
     * @return kaijoTodokedeYMD
     */
    public FlexibleDate getKaijoTodokedeYMD() {
        return kaijoTodokedeYMD;
    }

    /**
     * setKaijoTodokedeYMD
     *
     * @param kaijoTodokedeYMD kaijoTodokedeYMD
     */
    public void setKaijoTodokedeYMD(FlexibleDate kaijoTodokedeYMD) {
        this.kaijoTodokedeYMD = kaijoTodokedeYMD;
    }

    /**
     * getKaijoUketsukeYMD
     *
     * @return kaijoUketsukeYMD
     */
    public FlexibleDate getKaijoUketsukeYMD() {
        return kaijoUketsukeYMD;
    }

    /**
     * setKaijoUketsukeYMD
     *
     * @param kaijoUketsukeYMD kaijoUketsukeYMD
     */
    public void setKaijoUketsukeYMD(FlexibleDate kaijoUketsukeYMD) {
        this.kaijoUketsukeYMD = kaijoUketsukeYMD;
    }

    /**
     * getNyushoTsuchiHakkoYMD
     *
     * @return nyushoTsuchiHakkoYMD
     */
    public FlexibleDate getNyushoTsuchiHakkoYMD() {
        return nyushoTsuchiHakkoYMD;
    }

    /**
     * setNyushoTsuchiHakkoYMD
     *
     * @param nyushoTsuchiHakkoYMD nyushoTsuchiHakkoYMD
     */
    public void setNyushoTsuchiHakkoYMD(FlexibleDate nyushoTsuchiHakkoYMD) {
        this.nyushoTsuchiHakkoYMD = nyushoTsuchiHakkoYMD;
    }

    /**
     * getTaishoTsuchiHakkoYMD
     *
     * @return taishoTsuchiHakkoYMD
     */
    public FlexibleDate getTaishoTsuchiHakkoYMD() {
        return taishoTsuchiHakkoYMD;
    }

    /**
     * setTaishoTsuchiHakkoYMD
     *
     * @param taishoTsuchiHakkoYMD taishoTsuchiHakkoYMD
     */
    public void setTaishoTsuchiHakkoYMD(FlexibleDate taishoTsuchiHakkoYMD) {
        this.taishoTsuchiHakkoYMD = taishoTsuchiHakkoYMD;
    }

    /**
     * getHenkoTsuchiHakkoYMD
     *
     * @return henkoTsuchiHakkoYMD
     */
    public FlexibleDate getHenkoTsuchiHakkoYMD() {
        return henkoTsuchiHakkoYMD;
    }

    /**
     * setHenkoTsuchiHakkoYMD
     *
     * @param henkoTsuchiHakkoYMD henkoTsuchiHakkoYMD
     */
    public void setHenkoTsuchiHakkoYMD(FlexibleDate henkoTsuchiHakkoYMD) {
        this.henkoTsuchiHakkoYMD = henkoTsuchiHakkoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1002TekiyoJogaishaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1002TekiyoJogaishaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1002TekiyoJogaishaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1002TekiyoJogaishaEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.tekiyoJogaiTekiyoJiyuCode = entity.tekiyoJogaiTekiyoJiyuCode;
        this.tekiyoYMD = entity.tekiyoYMD;
        this.tekiyoTodokedeYMD = entity.tekiyoTodokedeYMD;
        this.tekiyoUketsukeYMD = entity.tekiyoUketsukeYMD;
        this.tekiyoJogaikaijokaijoJiyuCode = entity.tekiyoJogaikaijokaijoJiyuCode;
        this.kaijoYMD = entity.kaijoYMD;
        this.kaijoTodokedeYMD = entity.kaijoTodokedeYMD;
        this.kaijoUketsukeYMD = entity.kaijoUketsukeYMD;
        this.nyushoTsuchiHakkoYMD = entity.nyushoTsuchiHakkoYMD;
        this.taishoTsuchiHakkoYMD = entity.taishoTsuchiHakkoYMD;
        this.henkoTsuchiHakkoYMD = entity.henkoTsuchiHakkoYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shikibetsuCode, shoriTimestamp, tekiyoJogaiTekiyoJiyuCode, tekiyoYMD, tekiyoTodokedeYMD, tekiyoUketsukeYMD, tekiyoJogaikaijokaijoJiyuCode, kaijoYMD, kaijoTodokedeYMD, kaijoUketsukeYMD, nyushoTsuchiHakkoYMD, taishoTsuchiHakkoYMD, henkoTsuchiHakkoYMD);
    }

// </editor-fold>
}
