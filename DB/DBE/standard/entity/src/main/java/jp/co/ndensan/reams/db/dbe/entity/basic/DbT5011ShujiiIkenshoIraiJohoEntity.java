package jp.co.ndensan.reams.db.dbe.entity.basic;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 主治医意見書作成依頼情報のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT5011ShujiiIkenshoIraiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5011ShujiiIkenshoIraiJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ikenshoIraiRirekiNo;
    private RString kaigoIryokikanCode;
    private RString kaigoIshiCode;
    private RString ikenshoIraiKubun;
    private int ikenshoIraiKaisu;
    private Code ishiKubunCode;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate ikenshoSakuseiKigenYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate ikenshoShutsuryokuYMD;
    private FlexibleDate seikyushoShutsuryokuYMD;
    private Code sakuseiryoSeikyuKubun;
    private FlexibleDate ikenshoSakuseiTokusokuYMD;
    private RString ikenshoSakuseiTokusokuHoho;
    private int ikenshoTokusokuKaisu;
    private RString ikenshoTokusokuMemo;

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
     * getShinseishoKanriNo
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getIkenshoIraiRirekiNo
     *
     * @return ikenshoIraiRirekiNo
     */
    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /**
     * setIkenshoIraiRirekiNo
     *
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     */
    public void setIkenshoIraiRirekiNo(int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /**
     * getKaigoIryokikanCode
     *
     * @return kaigoIryokikanCode
     */
    public RString getKaigoIryokikanCode() {
        return kaigoIryokikanCode;
    }

    /**
     * setKaigoIryokikanCode
     *
     * @param kaigoIryokikanCode kaigoIryokikanCode
     */
    public void setKaigoIryokikanCode(RString kaigoIryokikanCode) {
        this.kaigoIryokikanCode = kaigoIryokikanCode;
    }

    /**
     * getKaigoIshiCode
     *
     * @return kaigoIshiCode
     */
    public RString getKaigoIshiCode() {
        return kaigoIshiCode;
    }

    /**
     * setKaigoIshiCode
     *
     * @param kaigoIshiCode kaigoIshiCode
     */
    public void setKaigoIshiCode(RString kaigoIshiCode) {
        this.kaigoIshiCode = kaigoIshiCode;
    }

    /**
     * getIkenshoIraiKubun
     *
     * @return ikenshoIraiKubun
     */
    public RString getIkenshoIraiKubun() {
        return ikenshoIraiKubun;
    }

    /**
     * setIkenshoIraiKubun
     *
     * @param ikenshoIraiKubun ikenshoIraiKubun
     */
    public void setIkenshoIraiKubun(RString ikenshoIraiKubun) {
        this.ikenshoIraiKubun = ikenshoIraiKubun;
    }

    /**
     * getIkenshoIraiKaisu
     *
     * @return ikenshoIraiKaisu
     */
    public int getIkenshoIraiKaisu() {
        return ikenshoIraiKaisu;
    }

    /**
     * setIkenshoIraiKaisu
     *
     * @param ikenshoIraiKaisu ikenshoIraiKaisu
     */
    public void setIkenshoIraiKaisu(int ikenshoIraiKaisu) {
        this.ikenshoIraiKaisu = ikenshoIraiKaisu;
    }

    /**
     * getIshiKubunCode
     *
     * @return ishiKubunCode
     */
    public Code getIshiKubunCode() {
        return ishiKubunCode;
    }

    /**
     * setIshiKubunCode
     *
     * @param ishiKubunCode ishiKubunCode
     */
    public void setIshiKubunCode(Code ishiKubunCode) {
        this.ishiKubunCode = ishiKubunCode;
    }

    /**
     * getIkenshoSakuseiIraiYMD
     *
     * @return ikenshoSakuseiIraiYMD
     */
    public FlexibleDate getIkenshoSakuseiIraiYMD() {
        return ikenshoSakuseiIraiYMD;
    }

    /**
     * setIkenshoSakuseiIraiYMD
     *
     * @param ikenshoSakuseiIraiYMD ikenshoSakuseiIraiYMD
     */
    public void setIkenshoSakuseiIraiYMD(FlexibleDate ikenshoSakuseiIraiYMD) {
        this.ikenshoSakuseiIraiYMD = ikenshoSakuseiIraiYMD;
    }

    /**
     * getIkenshoSakuseiKigenYMD
     *
     * @return ikenshoSakuseiKigenYMD
     */
    public FlexibleDate getIkenshoSakuseiKigenYMD() {
        return ikenshoSakuseiKigenYMD;
    }

    /**
     * setIkenshoSakuseiKigenYMD
     *
     * @param ikenshoSakuseiKigenYMD ikenshoSakuseiKigenYMD
     */
    public void setIkenshoSakuseiKigenYMD(FlexibleDate ikenshoSakuseiKigenYMD) {
        this.ikenshoSakuseiKigenYMD = ikenshoSakuseiKigenYMD;
    }

    /**
     * getIraishoShutsuryokuYMD
     *
     * @return iraishoShutsuryokuYMD
     */
    public FlexibleDate getIraishoShutsuryokuYMD() {
        return iraishoShutsuryokuYMD;
    }

    /**
     * setIraishoShutsuryokuYMD
     *
     * @param iraishoShutsuryokuYMD iraishoShutsuryokuYMD
     */
    public void setIraishoShutsuryokuYMD(FlexibleDate iraishoShutsuryokuYMD) {
        this.iraishoShutsuryokuYMD = iraishoShutsuryokuYMD;
    }

    /**
     * getIkenshoShutsuryokuYMD
     *
     * @return ikenshoShutsuryokuYMD
     */
    public FlexibleDate getIkenshoShutsuryokuYMD() {
        return ikenshoShutsuryokuYMD;
    }

    /**
     * setIkenshoShutsuryokuYMD
     *
     * @param ikenshoShutsuryokuYMD ikenshoShutsuryokuYMD
     */
    public void setIkenshoShutsuryokuYMD(FlexibleDate ikenshoShutsuryokuYMD) {
        this.ikenshoShutsuryokuYMD = ikenshoShutsuryokuYMD;
    }

    /**
     * getSeikyushoShutsuryokuYMD
     *
     * @return seikyushoShutsuryokuYMD
     */
    public FlexibleDate getSeikyushoShutsuryokuYMD() {
        return seikyushoShutsuryokuYMD;
    }

    /**
     * setSeikyushoShutsuryokuYMD
     *
     * @param seikyushoShutsuryokuYMD seikyushoShutsuryokuYMD
     */
    public void setSeikyushoShutsuryokuYMD(FlexibleDate seikyushoShutsuryokuYMD) {
        this.seikyushoShutsuryokuYMD = seikyushoShutsuryokuYMD;
    }

    /**
     * getSakuseiryoSeikyuKubun
     *
     * @return sakuseiryoSeikyuKubun
     */
    public Code getSakuseiryoSeikyuKubun() {
        return sakuseiryoSeikyuKubun;
    }

    /**
     * setSakuseiryoSeikyuKubun
     *
     * @param sakuseiryoSeikyuKubun sakuseiryoSeikyuKubun
     */
    public void setSakuseiryoSeikyuKubun(Code sakuseiryoSeikyuKubun) {
        this.sakuseiryoSeikyuKubun = sakuseiryoSeikyuKubun;
    }

    /**
     * getIkenshoSakuseiTokusokuYMD
     *
     * @return ikenshoSakuseiTokusokuYMD
     */
    public FlexibleDate getIkenshoSakuseiTokusokuYMD() {
        return ikenshoSakuseiTokusokuYMD;
    }

    /**
     * setIkenshoSakuseiTokusokuYMD
     *
     * @param ikenshoSakuseiTokusokuYMD ikenshoSakuseiTokusokuYMD
     */
    public void setIkenshoSakuseiTokusokuYMD(FlexibleDate ikenshoSakuseiTokusokuYMD) {
        this.ikenshoSakuseiTokusokuYMD = ikenshoSakuseiTokusokuYMD;
    }

    /**
     * getIkenshoSakuseiTokusokuHoho
     *
     * @return ikenshoSakuseiTokusokuHoho
     */
    public RString getIkenshoSakuseiTokusokuHoho() {
        return ikenshoSakuseiTokusokuHoho;
    }

    /**
     * setIkenshoSakuseiTokusokuHoho
     *
     * @param ikenshoSakuseiTokusokuHoho ikenshoSakuseiTokusokuHoho
     */
    public void setIkenshoSakuseiTokusokuHoho(RString ikenshoSakuseiTokusokuHoho) {
        this.ikenshoSakuseiTokusokuHoho = ikenshoSakuseiTokusokuHoho;
    }

    /**
     * getIkenshoTokusokuKaisu
     *
     * @return ikenshoTokusokuKaisu
     */
    public int getIkenshoTokusokuKaisu() {
        return ikenshoTokusokuKaisu;
    }

    /**
     * setIkenshoTokusokuKaisu
     *
     * @param ikenshoTokusokuKaisu ikenshoTokusokuKaisu
     */
    public void setIkenshoTokusokuKaisu(int ikenshoTokusokuKaisu) {
        this.ikenshoTokusokuKaisu = ikenshoTokusokuKaisu;
    }

    /**
     * getIkenshoTokusokuMemo
     *
     * @return ikenshoTokusokuMemo
     */
    public RString getIkenshoTokusokuMemo() {
        return ikenshoTokusokuMemo;
    }

    /**
     * setIkenshoTokusokuMemo
     *
     * @param ikenshoTokusokuMemo ikenshoTokusokuMemo
     */
    public void setIkenshoTokusokuMemo(RString ikenshoTokusokuMemo) {
        this.ikenshoTokusokuMemo = ikenshoTokusokuMemo;
    }
// </editor-fold>
}
