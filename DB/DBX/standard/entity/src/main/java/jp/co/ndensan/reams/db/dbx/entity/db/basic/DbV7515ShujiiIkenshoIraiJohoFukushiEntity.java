package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 主治医意見書作成依頼情報・福祉Newestテーブルのエンティティクラスです。
 */
public class DbV7515ShujiiIkenshoIraiJohoFukushiEntity extends DbTableEntityBase<DbV7515ShujiiIkenshoIraiJohoFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7515ShujiiIkenshoIraiJohoFukushi");

    private ShinseishoKanriNo shinseishoKanriNo;
    private int ikenshoIraiRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private RString shujiiIryokikanCode;
    private RString shujiiCode;
    private RString ikenshoIraiKubun;
    private int ikenshoIraiKaisu;
    private Code ishiKubunCode;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate ikenshoSakuseiKigenYMD;
    private FlexibleDate teishutsuIraishoShutsuryokuYMD;
    private FlexibleDate ikenshoShutsuryokuYMD;
    private FlexibleDate seikyushoShutsuryokuYMD;
    private Code sakuseiryoSeikyuKubun;
    private FlexibleDate ikenshoSakuseiTokusokuYMD;
    private RString ikenshoSakuseiTokusokuHoho;
    private int ikenshoTokusokuKaisu;
    private RString ikenshoTokusokuMemo;
    private boolean ninteiJohoTeikyoKiboFlag;
    private FlexibleDate ninteiJohoTeikyoYMD;
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
     * ikenshoIraiRirekiNoのgetメソッドです。
     * 
     * @return ikenshoIraiRirekiNo
     */
    @CheckForNull
    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /**
     * ikenshoIraiRirekiNoのsetメソッドです。
     * 
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     */
    public void setIkenshoIraiRirekiNo(int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
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
     * shujiiIryokikanCodeのgetメソッドです。
     * 
     * @return shujiiIryokikanCode
     */
    @CheckForNull
    public RString getShujiiIryokikanCode() {
        return shujiiIryokikanCode;
    }

    /**
     * shujiiIryokikanCodeのsetメソッドです。
     * 
     * @param shujiiIryokikanCode shujiiIryokikanCode
     */
    public void setShujiiIryokikanCode(RString shujiiIryokikanCode) {
        this.shujiiIryokikanCode = shujiiIryokikanCode;
    }

    /**
     * shujiiCodeのgetメソッドです。
     * 
     * @return shujiiCode
     */
    @CheckForNull
    public RString getShujiiCode() {
        return shujiiCode;
    }

    /**
     * shujiiCodeのsetメソッドです。
     * 
     * @param shujiiCode shujiiCode
     */
    public void setShujiiCode(RString shujiiCode) {
        this.shujiiCode = shujiiCode;
    }

    /**
     * ikenshoIraiKubunのgetメソッドです。
     * 
     * @return ikenshoIraiKubun
     */
    @CheckForNull
    public RString getIkenshoIraiKubun() {
        return ikenshoIraiKubun;
    }

    /**
     * ikenshoIraiKubunのsetメソッドです。
     * 
     * @param ikenshoIraiKubun ikenshoIraiKubun
     */
    public void setIkenshoIraiKubun(RString ikenshoIraiKubun) {
        this.ikenshoIraiKubun = ikenshoIraiKubun;
    }

    /**
     * ikenshoIraiKaisuのgetメソッドです。
     * 
     * @return ikenshoIraiKaisu
     */
    @CheckForNull
    public int getIkenshoIraiKaisu() {
        return ikenshoIraiKaisu;
    }

    /**
     * ikenshoIraiKaisuのsetメソッドです。
     * 
     * @param ikenshoIraiKaisu ikenshoIraiKaisu
     */
    public void setIkenshoIraiKaisu(int ikenshoIraiKaisu) {
        this.ikenshoIraiKaisu = ikenshoIraiKaisu;
    }

    /**
     * ishiKubunCodeのgetメソッドです。
     * 
     * @return ishiKubunCode
     */
    @CheckForNull
    public Code getIshiKubunCode() {
        return ishiKubunCode;
    }

    /**
     * ishiKubunCodeのsetメソッドです。
     * 
     * @param ishiKubunCode ishiKubunCode
     */
    public void setIshiKubunCode(Code ishiKubunCode) {
        this.ishiKubunCode = ishiKubunCode;
    }

    /**
     * ikenshoSakuseiIraiYMDのgetメソッドです。
     * 
     * @return ikenshoSakuseiIraiYMD
     */
    @CheckForNull
    public FlexibleDate getIkenshoSakuseiIraiYMD() {
        return ikenshoSakuseiIraiYMD;
    }

    /**
     * ikenshoSakuseiIraiYMDのsetメソッドです。
     * 
     * @param ikenshoSakuseiIraiYMD ikenshoSakuseiIraiYMD
     */
    public void setIkenshoSakuseiIraiYMD(FlexibleDate ikenshoSakuseiIraiYMD) {
        this.ikenshoSakuseiIraiYMD = ikenshoSakuseiIraiYMD;
    }

    /**
     * ikenshoSakuseiKigenYMDのgetメソッドです。
     * 
     * @return ikenshoSakuseiKigenYMD
     */
    @CheckForNull
    public FlexibleDate getIkenshoSakuseiKigenYMD() {
        return ikenshoSakuseiKigenYMD;
    }

    /**
     * ikenshoSakuseiKigenYMDのsetメソッドです。
     * 
     * @param ikenshoSakuseiKigenYMD ikenshoSakuseiKigenYMD
     */
    public void setIkenshoSakuseiKigenYMD(FlexibleDate ikenshoSakuseiKigenYMD) {
        this.ikenshoSakuseiKigenYMD = ikenshoSakuseiKigenYMD;
    }

    /**
     * teishutsuIraishoShutsuryokuYMDのgetメソッドです。
     * 
     * @return teishutsuIraishoShutsuryokuYMD
     */
    @CheckForNull
    public FlexibleDate getTeishutsuIraishoShutsuryokuYMD() {
        return teishutsuIraishoShutsuryokuYMD;
    }

    /**
     * teishutsuIraishoShutsuryokuYMDのsetメソッドです。
     * 
     * @param teishutsuIraishoShutsuryokuYMD teishutsuIraishoShutsuryokuYMD
     */
    public void setTeishutsuIraishoShutsuryokuYMD(FlexibleDate teishutsuIraishoShutsuryokuYMD) {
        this.teishutsuIraishoShutsuryokuYMD = teishutsuIraishoShutsuryokuYMD;
    }

    /**
     * ikenshoShutsuryokuYMDのgetメソッドです。
     * 
     * @return ikenshoShutsuryokuYMD
     */
    @CheckForNull
    public FlexibleDate getIkenshoShutsuryokuYMD() {
        return ikenshoShutsuryokuYMD;
    }

    /**
     * ikenshoShutsuryokuYMDのsetメソッドです。
     * 
     * @param ikenshoShutsuryokuYMD ikenshoShutsuryokuYMD
     */
    public void setIkenshoShutsuryokuYMD(FlexibleDate ikenshoShutsuryokuYMD) {
        this.ikenshoShutsuryokuYMD = ikenshoShutsuryokuYMD;
    }

    /**
     * seikyushoShutsuryokuYMDのgetメソッドです。
     * 
     * @return seikyushoShutsuryokuYMD
     */
    @CheckForNull
    public FlexibleDate getSeikyushoShutsuryokuYMD() {
        return seikyushoShutsuryokuYMD;
    }

    /**
     * seikyushoShutsuryokuYMDのsetメソッドです。
     * 
     * @param seikyushoShutsuryokuYMD seikyushoShutsuryokuYMD
     */
    public void setSeikyushoShutsuryokuYMD(FlexibleDate seikyushoShutsuryokuYMD) {
        this.seikyushoShutsuryokuYMD = seikyushoShutsuryokuYMD;
    }

    /**
     * sakuseiryoSeikyuKubunのgetメソッドです。
     * 
     * @return sakuseiryoSeikyuKubun
     */
    @CheckForNull
    public Code getSakuseiryoSeikyuKubun() {
        return sakuseiryoSeikyuKubun;
    }

    /**
     * sakuseiryoSeikyuKubunのsetメソッドです。
     * 
     * @param sakuseiryoSeikyuKubun sakuseiryoSeikyuKubun
     */
    public void setSakuseiryoSeikyuKubun(Code sakuseiryoSeikyuKubun) {
        this.sakuseiryoSeikyuKubun = sakuseiryoSeikyuKubun;
    }

    /**
     * ikenshoSakuseiTokusokuYMDのgetメソッドです。
     * 
     * @return ikenshoSakuseiTokusokuYMD
     */
    @CheckForNull
    public FlexibleDate getIkenshoSakuseiTokusokuYMD() {
        return ikenshoSakuseiTokusokuYMD;
    }

    /**
     * ikenshoSakuseiTokusokuYMDのsetメソッドです。
     * 
     * @param ikenshoSakuseiTokusokuYMD ikenshoSakuseiTokusokuYMD
     */
    public void setIkenshoSakuseiTokusokuYMD(FlexibleDate ikenshoSakuseiTokusokuYMD) {
        this.ikenshoSakuseiTokusokuYMD = ikenshoSakuseiTokusokuYMD;
    }

    /**
     * ikenshoSakuseiTokusokuHohoのgetメソッドです。
     * 
     * @return ikenshoSakuseiTokusokuHoho
     */
    @CheckForNull
    public RString getIkenshoSakuseiTokusokuHoho() {
        return ikenshoSakuseiTokusokuHoho;
    }

    /**
     * ikenshoSakuseiTokusokuHohoのsetメソッドです。
     * 
     * @param ikenshoSakuseiTokusokuHoho ikenshoSakuseiTokusokuHoho
     */
    public void setIkenshoSakuseiTokusokuHoho(RString ikenshoSakuseiTokusokuHoho) {
        this.ikenshoSakuseiTokusokuHoho = ikenshoSakuseiTokusokuHoho;
    }

    /**
     * ikenshoTokusokuKaisuのgetメソッドです。
     * 
     * @return ikenshoTokusokuKaisu
     */
    @CheckForNull
    public int getIkenshoTokusokuKaisu() {
        return ikenshoTokusokuKaisu;
    }

    /**
     * ikenshoTokusokuKaisuのsetメソッドです。
     * 
     * @param ikenshoTokusokuKaisu ikenshoTokusokuKaisu
     */
    public void setIkenshoTokusokuKaisu(int ikenshoTokusokuKaisu) {
        this.ikenshoTokusokuKaisu = ikenshoTokusokuKaisu;
    }

    /**
     * ikenshoTokusokuMemoのgetメソッドです。
     * 
     * @return ikenshoTokusokuMemo
     */
    @CheckForNull
    public RString getIkenshoTokusokuMemo() {
        return ikenshoTokusokuMemo;
    }

    /**
     * ikenshoTokusokuMemoのsetメソッドです。
     * 
     * @param ikenshoTokusokuMemo ikenshoTokusokuMemo
     */
    public void setIkenshoTokusokuMemo(RString ikenshoTokusokuMemo) {
        this.ikenshoTokusokuMemo = ikenshoTokusokuMemo;
    }

    /**
     * ninteiJohoTeikyoKiboFlagのgetメソッドです。
     * 
     * @return ninteiJohoTeikyoKiboFlag
     */
    @CheckForNull
    public boolean getNinteiJohoTeikyoKiboFlag() {
        return ninteiJohoTeikyoKiboFlag;
    }

    /**
     * ninteiJohoTeikyoKiboFlagのsetメソッドです。
     * 
     * @param ninteiJohoTeikyoKiboFlag ninteiJohoTeikyoKiboFlag
     */
    public void setNinteiJohoTeikyoKiboFlag(boolean ninteiJohoTeikyoKiboFlag) {
        this.ninteiJohoTeikyoKiboFlag = ninteiJohoTeikyoKiboFlag;
    }

    /**
     * ninteiJohoTeikyoYMDのgetメソッドです。
     * 
     * @return ninteiJohoTeikyoYMD
     */
    @CheckForNull
    public FlexibleDate getNinteiJohoTeikyoYMD() {
        return ninteiJohoTeikyoYMD;
    }

    /**
     * ninteiJohoTeikyoYMDのsetメソッドです。
     * 
     * @param ninteiJohoTeikyoYMD ninteiJohoTeikyoYMD
     */
    public void setNinteiJohoTeikyoYMD(FlexibleDate ninteiJohoTeikyoYMD) {
        this.ninteiJohoTeikyoYMD = ninteiJohoTeikyoYMD;
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
     * このエンティティの主キーが他の{@literal DbV7515ShujiiIkenshoIraiJohoFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7515ShujiiIkenshoIraiJohoFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7515ShujiiIkenshoIraiJohoFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7515ShujiiIkenshoIraiJohoFukushiEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ikenshoIraiRirekiNo = entity.ikenshoIraiRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.shujiiIryokikanCode = entity.shujiiIryokikanCode;
        this.shujiiCode = entity.shujiiCode;
        this.ikenshoIraiKubun = entity.ikenshoIraiKubun;
        this.ikenshoIraiKaisu = entity.ikenshoIraiKaisu;
        this.ishiKubunCode = entity.ishiKubunCode;
        this.ikenshoSakuseiIraiYMD = entity.ikenshoSakuseiIraiYMD;
        this.ikenshoSakuseiKigenYMD = entity.ikenshoSakuseiKigenYMD;
        this.teishutsuIraishoShutsuryokuYMD = entity.teishutsuIraishoShutsuryokuYMD;
        this.ikenshoShutsuryokuYMD = entity.ikenshoShutsuryokuYMD;
        this.seikyushoShutsuryokuYMD = entity.seikyushoShutsuryokuYMD;
        this.sakuseiryoSeikyuKubun = entity.sakuseiryoSeikyuKubun;
        this.ikenshoSakuseiTokusokuYMD = entity.ikenshoSakuseiTokusokuYMD;
        this.ikenshoSakuseiTokusokuHoho = entity.ikenshoSakuseiTokusokuHoho;
        this.ikenshoTokusokuKaisu = entity.ikenshoTokusokuKaisu;
        this.ikenshoTokusokuMemo = entity.ikenshoTokusokuMemo;
        this.ninteiJohoTeikyoKiboFlag = entity.ninteiJohoTeikyoKiboFlag;
        this.ninteiJohoTeikyoYMD = entity.ninteiJohoTeikyoYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ikenshoIraiRirekiNo, koroshoIfShikibetsuCode, shujiiIryokikanCode, shujiiCode, ikenshoIraiKubun, ikenshoIraiKaisu, ishiKubunCode, ikenshoSakuseiIraiYMD, ikenshoSakuseiKigenYMD, teishutsuIraishoShutsuryokuYMD, ikenshoShutsuryokuYMD, seikyushoShutsuryokuYMD, sakuseiryoSeikyuKubun, ikenshoSakuseiTokusokuYMD, ikenshoSakuseiTokusokuHoho, ikenshoTokusokuKaisu, ikenshoTokusokuMemo, ninteiJohoTeikyoKiboFlag, ninteiJohoTeikyoYMD, logicalDeletedFlag);
    }

// </editor-fold>
}
