package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定調査依頼情報・福祉Newestテーブルのエンティティクラスです。
 */
public class DbV7514NinteichosaIraiJohoFukushiEntity extends DbTableEntityBase<DbV7514NinteichosaIraiJohoFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7514NinteichosaIraiJohoFukushi");

    private ShinseishoKanriNo shinseishoKanriNo;
    private int ninteichosaIraiRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private JigyoshaNo ninteichosaItakusakiCode;
    private RString ninteiChosainCode;
    private Code ninteichosaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaIraiYMD;
    private FlexibleDate ninteichosaKigenYMD;
    private FlexibleDate chosaIraishoShutsuryokuYMD;
    private FlexibleDate chosahyoTouShutsuryokuYMD;
    private boolean mobileDataShutsuryokuZumiFlag;
    private boolean jizenChosaFlag;
    private FlexibleDate ninteichosaTokusokuYMD;
    private RString ninteichosaTokusokuHoho;
    private int ninteichosaTokusokuKaisu;
    private RString ninteichosaTokusokuMemo;
    private boolean logicalDeletedFlag;

    /**
     * shinseishoKanriNoのgetメソッドです。
     * 
     * @return shinseishoKanriNo
     */
    @CheckForNull
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * shinseishoKanriNoのsetメソッドです。
     * 
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * ninteichosaIraiRirekiNoのgetメソッドです。
     * 
     * @return ninteichosaIraiRirekiNo
     */
    @CheckForNull
    public int getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    /**
     * ninteichosaIraiRirekiNoのsetメソッドです。
     * 
     * @param ninteichosaIraiRirekiNo ninteichosaIraiRirekiNo
     */
    public void setNinteichosaIraiRirekiNo(int ninteichosaIraiRirekiNo) {
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    /**
     * koroshoIfShikibetsuCodeのgetメソッドです。
     * 
     * @return koroshoIfShikibetsuCode
     */
    @CheckForNull
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * koroshoIfShikibetsuCodeのsetメソッドです。
     * 
     * @param koroshoIfShikibetsuCode koroshoIfShikibetsuCode
     */
    public void setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * ninteichosaItakusakiCodeのgetメソッドです。
     * 
     * @return ninteichosaItakusakiCode
     */
    @CheckForNull
    public JigyoshaNo getNinteichosaItakusakiCode() {
        return ninteichosaItakusakiCode;
    }

    /**
     * ninteichosaItakusakiCodeのsetメソッドです。
     * 
     * @param ninteichosaItakusakiCode ninteichosaItakusakiCode
     */
    public void setNinteichosaItakusakiCode(JigyoshaNo ninteichosaItakusakiCode) {
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
    }

    /**
     * ninteiChosainCodeのgetメソッドです。
     * 
     * @return ninteiChosainCode
     */
    @CheckForNull
    public RString getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    /**
     * ninteiChosainCodeのsetメソッドです。
     * 
     * @param ninteiChosainCode ninteiChosainCode
     */
    public void setNinteiChosainCode(RString ninteiChosainCode) {
        this.ninteiChosainCode = ninteiChosainCode;
    }

    /**
     * ninteichosaIraiKubunCodeのgetメソッドです。
     * 
     * @return ninteichosaIraiKubunCode
     */
    @CheckForNull
    public Code getNinteichosaIraiKubunCode() {
        return ninteichosaIraiKubunCode;
    }

    /**
     * ninteichosaIraiKubunCodeのsetメソッドです。
     * 
     * @param ninteichosaIraiKubunCode ninteichosaIraiKubunCode
     */
    public void setNinteichosaIraiKubunCode(Code ninteichosaIraiKubunCode) {
        this.ninteichosaIraiKubunCode = ninteichosaIraiKubunCode;
    }

    /**
     * ninteichosaIraiKaisuのgetメソッドです。
     * 
     * @return ninteichosaIraiKaisu
     */
    @CheckForNull
    public int getNinteichosaIraiKaisu() {
        return ninteichosaIraiKaisu;
    }

    /**
     * ninteichosaIraiKaisuのsetメソッドです。
     * 
     * @param ninteichosaIraiKaisu ninteichosaIraiKaisu
     */
    public void setNinteichosaIraiKaisu(int ninteichosaIraiKaisu) {
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
    }

    /**
     * ninteichosaIraiYMDのgetメソッドです。
     * 
     * @return ninteichosaIraiYMD
     */
    @CheckForNull
    public FlexibleDate getNinteichosaIraiYMD() {
        return ninteichosaIraiYMD;
    }

    /**
     * ninteichosaIraiYMDのsetメソッドです。
     * 
     * @param ninteichosaIraiYMD ninteichosaIraiYMD
     */
    public void setNinteichosaIraiYMD(FlexibleDate ninteichosaIraiYMD) {
        this.ninteichosaIraiYMD = ninteichosaIraiYMD;
    }

    /**
     * ninteichosaKigenYMDのgetメソッドです。
     * 
     * @return ninteichosaKigenYMD
     */
    @CheckForNull
    public FlexibleDate getNinteichosaKigenYMD() {
        return ninteichosaKigenYMD;
    }

    /**
     * ninteichosaKigenYMDのsetメソッドです。
     * 
     * @param ninteichosaKigenYMD ninteichosaKigenYMD
     */
    public void setNinteichosaKigenYMD(FlexibleDate ninteichosaKigenYMD) {
        this.ninteichosaKigenYMD = ninteichosaKigenYMD;
    }

    /**
     * chosaIraishoShutsuryokuYMDのgetメソッドです。
     * 
     * @return chosaIraishoShutsuryokuYMD
     */
    @CheckForNull
    public FlexibleDate getChosaIraishoShutsuryokuYMD() {
        return chosaIraishoShutsuryokuYMD;
    }

    /**
     * chosaIraishoShutsuryokuYMDのsetメソッドです。
     * 
     * @param chosaIraishoShutsuryokuYMD chosaIraishoShutsuryokuYMD
     */
    public void setChosaIraishoShutsuryokuYMD(FlexibleDate chosaIraishoShutsuryokuYMD) {
        this.chosaIraishoShutsuryokuYMD = chosaIraishoShutsuryokuYMD;
    }

    /**
     * chosahyoTouShutsuryokuYMDのgetメソッドです。
     * 
     * @return chosahyoTouShutsuryokuYMD
     */
    @CheckForNull
    public FlexibleDate getChosahyoTouShutsuryokuYMD() {
        return chosahyoTouShutsuryokuYMD;
    }

    /**
     * chosahyoTouShutsuryokuYMDのsetメソッドです。
     * 
     * @param chosahyoTouShutsuryokuYMD chosahyoTouShutsuryokuYMD
     */
    public void setChosahyoTouShutsuryokuYMD(FlexibleDate chosahyoTouShutsuryokuYMD) {
        this.chosahyoTouShutsuryokuYMD = chosahyoTouShutsuryokuYMD;
    }

    /**
     * mobileDataShutsuryokuZumiFlagのgetメソッドです。
     * 
     * @return mobileDataShutsuryokuZumiFlag
     */
    @CheckForNull
    public boolean getMobileDataShutsuryokuZumiFlag() {
        return mobileDataShutsuryokuZumiFlag;
    }

    /**
     * mobileDataShutsuryokuZumiFlagのsetメソッドです。
     * 
     * @param mobileDataShutsuryokuZumiFlag mobileDataShutsuryokuZumiFlag
     */
    public void setMobileDataShutsuryokuZumiFlag(boolean mobileDataShutsuryokuZumiFlag) {
        this.mobileDataShutsuryokuZumiFlag = mobileDataShutsuryokuZumiFlag;
    }

    /**
     * jizenChosaFlagのgetメソッドです。
     * 
     * @return jizenChosaFlag
     */
    @CheckForNull
    public boolean getJizenChosaFlag() {
        return jizenChosaFlag;
    }

    /**
     * jizenChosaFlagのsetメソッドです。
     * 
     * @param jizenChosaFlag jizenChosaFlag
     */
    public void setJizenChosaFlag(boolean jizenChosaFlag) {
        this.jizenChosaFlag = jizenChosaFlag;
    }

    /**
     * ninteichosaTokusokuYMDのgetメソッドです。
     * 
     * @return ninteichosaTokusokuYMD
     */
    @CheckForNull
    public FlexibleDate getNinteichosaTokusokuYMD() {
        return ninteichosaTokusokuYMD;
    }

    /**
     * ninteichosaTokusokuYMDのsetメソッドです。
     * 
     * @param ninteichosaTokusokuYMD ninteichosaTokusokuYMD
     */
    public void setNinteichosaTokusokuYMD(FlexibleDate ninteichosaTokusokuYMD) {
        this.ninteichosaTokusokuYMD = ninteichosaTokusokuYMD;
    }

    /**
     * ninteichosaTokusokuHohoのgetメソッドです。
     * 
     * @return ninteichosaTokusokuHoho
     */
    @CheckForNull
    public RString getNinteichosaTokusokuHoho() {
        return ninteichosaTokusokuHoho;
    }

    /**
     * ninteichosaTokusokuHohoのsetメソッドです。
     * 
     * @param ninteichosaTokusokuHoho ninteichosaTokusokuHoho
     */
    public void setNinteichosaTokusokuHoho(RString ninteichosaTokusokuHoho) {
        this.ninteichosaTokusokuHoho = ninteichosaTokusokuHoho;
    }

    /**
     * ninteichosaTokusokuKaisuのgetメソッドです。
     * 
     * @return ninteichosaTokusokuKaisu
     */
    @CheckForNull
    public int getNinteichosaTokusokuKaisu() {
        return ninteichosaTokusokuKaisu;
    }

    /**
     * ninteichosaTokusokuKaisuのsetメソッドです。
     * 
     * @param ninteichosaTokusokuKaisu ninteichosaTokusokuKaisu
     */
    public void setNinteichosaTokusokuKaisu(int ninteichosaTokusokuKaisu) {
        this.ninteichosaTokusokuKaisu = ninteichosaTokusokuKaisu;
    }

    /**
     * ninteichosaTokusokuMemoのgetメソッドです。
     * 
     * @return ninteichosaTokusokuMemo
     */
    @CheckForNull
    public RString getNinteichosaTokusokuMemo() {
        return ninteichosaTokusokuMemo;
    }

    /**
     * ninteichosaTokusokuMemoのsetメソッドです。
     * 
     * @param ninteichosaTokusokuMemo ninteichosaTokusokuMemo
     */
    public void setNinteichosaTokusokuMemo(RString ninteichosaTokusokuMemo) {
        this.ninteichosaTokusokuMemo = ninteichosaTokusokuMemo;
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
     * このエンティティの主キーが他の{@literal DbV7514NinteichosaIraiJohoFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7514NinteichosaIraiJohoFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7514NinteichosaIraiJohoFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7514NinteichosaIraiJohoFukushiEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaIraiRirekiNo = entity.ninteichosaIraiRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.ninteichosaItakusakiCode = entity.ninteichosaItakusakiCode;
        this.ninteiChosainCode = entity.ninteiChosainCode;
        this.ninteichosaIraiKubunCode = entity.ninteichosaIraiKubunCode;
        this.ninteichosaIraiKaisu = entity.ninteichosaIraiKaisu;
        this.ninteichosaIraiYMD = entity.ninteichosaIraiYMD;
        this.ninteichosaKigenYMD = entity.ninteichosaKigenYMD;
        this.chosaIraishoShutsuryokuYMD = entity.chosaIraishoShutsuryokuYMD;
        this.chosahyoTouShutsuryokuYMD = entity.chosahyoTouShutsuryokuYMD;
        this.mobileDataShutsuryokuZumiFlag = entity.mobileDataShutsuryokuZumiFlag;
        this.jizenChosaFlag = entity.jizenChosaFlag;
        this.ninteichosaTokusokuYMD = entity.ninteichosaTokusokuYMD;
        this.ninteichosaTokusokuHoho = entity.ninteichosaTokusokuHoho;
        this.ninteichosaTokusokuKaisu = entity.ninteichosaTokusokuKaisu;
        this.ninteichosaTokusokuMemo = entity.ninteichosaTokusokuMemo;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaIraiRirekiNo, koroshoIfShikibetsuCode, ninteichosaItakusakiCode, ninteiChosainCode, ninteichosaIraiKubunCode, ninteichosaIraiKaisu, ninteichosaIraiYMD, ninteichosaKigenYMD, chosaIraishoShutsuryokuYMD, chosahyoTouShutsuryokuYMD, mobileDataShutsuryokuZumiFlag, jizenChosaFlag, ninteichosaTokusokuYMD, ninteichosaTokusokuHoho, ninteichosaTokusokuKaisu, ninteichosaTokusokuMemo, logicalDeletedFlag);
    }

// </editor-fold>

}
