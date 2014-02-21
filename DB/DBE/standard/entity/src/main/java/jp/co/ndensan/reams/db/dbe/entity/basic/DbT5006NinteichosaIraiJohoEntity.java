package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosainBangoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * DbT5006NinteichosaIraiJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5006NinteichosaIraiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5006NinteichosaIraiJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted;
    private int updateCount;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private NinteichosaIraiRirekiNo ninteichosaIraiRirekiNo;
    private KaigoJigyoshaNo ninteichosaItakusakiCode;
    private NinteichosainBangoCode chousainCode;
    private RString ninteichousaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaIraiYMD;
    private FlexibleDate ninteichosaKigenYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate chosahyoTouShutsuryokuYMD;
    private boolean mobileDataShutsuryokuFlag;
    private FlexibleDate ninteichosaTokusokuYMD;
    private RString ninteichosaTokusokuHoho;
    private int ninteichosaTokusokuKaisu;
    private RString ninteichosaTokusokuMemo;

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
     * getNinteichosaIraiRirekiNo
     *
     * @return ninteichosaIraiRirekiNo
     */
    public NinteichosaIraiRirekiNo getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    /**
     * setNinteichosaIraiRirekiNo
     *
     * @param ninteichosaIraiRirekiNo ninteichosaIraiRirekiNo
     */
    public void setNinteichosaIraiRirekiNo(NinteichosaIraiRirekiNo ninteichosaIraiRirekiNo) {
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    /**
     * getNinteichosaItakusakiCode
     *
     * @return ninteichosaItakusakiCode
     */
    public KaigoJigyoshaNo getNinteichosaItakusakiCode() {
        return ninteichosaItakusakiCode;
    }

    /**
     * setNinteichosaItakusakiCode
     *
     * @param ninteichosaItakusakiCode ninteichosaItakusakiCode
     */
    public void setNinteichosaItakusakiCode(KaigoJigyoshaNo ninteichosaItakusakiCode) {
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
    }

    /**
     * getChousainCode
     *
     * @return chousainCode
     */
    public NinteichosainBangoCode getChousainCode() {
        return chousainCode;
    }

    /**
     * setChousainCode
     *
     * @param chousainCode chousainCode
     */
    public void setChousainCode(NinteichosainBangoCode chousainCode) {
        this.chousainCode = chousainCode;
    }

    /**
     * getNinteichousaIraiKubunCode
     *
     * @return ninteichousaIraiKubunCode
     */
    public RString getNinteichousaIraiKubunCode() {
        return ninteichousaIraiKubunCode;
    }

    /**
     * setNinteichousaIraiKubunCode
     *
     * @param ninteichousaIraiKubunCode ninteichousaIraiKubunCode
     */
    public void setNinteichousaIraiKubunCode(RString ninteichousaIraiKubunCode) {
        this.ninteichousaIraiKubunCode = ninteichousaIraiKubunCode;
    }

    /**
     * getNinteichosaIraiKaisu
     *
     * @return ninteichosaIraiKaisu
     */
    public int getNinteichosaIraiKaisu() {
        return ninteichosaIraiKaisu;
    }

    /**
     * setNinteichosaIraiKaisu
     *
     * @param ninteichosaIraiKaisu ninteichosaIraiKaisu
     */
    public void setNinteichosaIraiKaisu(int ninteichosaIraiKaisu) {
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
    }

    /**
     * getNinteichosaIraiYMD
     *
     * @return ninteichosaIraiYMD
     */
    public FlexibleDate getNinteichosaIraiYMD() {
        return ninteichosaIraiYMD;
    }

    /**
     * setNinteichosaIraiYMD
     *
     * @param ninteichosaIraiYMD ninteichosaIraiYMD
     */
    public void setNinteichosaIraiYMD(FlexibleDate ninteichosaIraiYMD) {
        this.ninteichosaIraiYMD = ninteichosaIraiYMD;
    }

    /**
     * getNinteichosaKigenYMD
     *
     * @return ninteichosaKigenYMD
     */
    public FlexibleDate getNinteichosaKigenYMD() {
        return ninteichosaKigenYMD;
    }

    /**
     * setNinteichosaKigenYMD
     *
     * @param ninteichosaKigenYMD ninteichosaKigenYMD
     */
    public void setNinteichosaKigenYMD(FlexibleDate ninteichosaKigenYMD) {
        this.ninteichosaKigenYMD = ninteichosaKigenYMD;
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
     * getChosahyoTouShutsuryokuYMD
     *
     * @return chosahyoTouShutsuryokuYMD
     */
    public FlexibleDate getChosahyoTouShutsuryokuYMD() {
        return chosahyoTouShutsuryokuYMD;
    }

    /**
     * setChosahyoTouShutsuryokuYMD
     *
     * @param chosahyoTouShutsuryokuYMD chosahyoTouShutsuryokuYMD
     */
    public void setChosahyoTouShutsuryokuYMD(FlexibleDate chosahyoTouShutsuryokuYMD) {
        this.chosahyoTouShutsuryokuYMD = chosahyoTouShutsuryokuYMD;
    }

    /**
     * getMobileDataShutsuryokuFlag
     *
     * @return mobileDataShutsuryokuFlag
     */
    public boolean getMobileDataShutsuryokuFlag() {
        return mobileDataShutsuryokuFlag;
    }

    /**
     * setMobileDataShutsuryokuFlag
     *
     * @param mobileDataShutsuryokuFlag mobileDataShutsuryokuFlag
     */
    public void setMobileDataShutsuryokuFlag(boolean mobileDataShutsuryokuFlag) {
        this.mobileDataShutsuryokuFlag = mobileDataShutsuryokuFlag;
    }

    /**
     * getNinteichosaTokusokuYMD
     *
     * @return ninteichosaTokusokuYMD
     */
    public FlexibleDate getNinteichosaTokusokuYMD() {
        return ninteichosaTokusokuYMD;
    }

    /**
     * setNinteichosaTokusokuYMD
     *
     * @param ninteichosaTokusokuYMD ninteichosaTokusokuYMD
     */
    public void setNinteichosaTokusokuYMD(FlexibleDate ninteichosaTokusokuYMD) {
        this.ninteichosaTokusokuYMD = ninteichosaTokusokuYMD;
    }

    /**
     * getNinteichosaTokusokuHoho
     *
     * @return ninteichosaTokusokuHoho
     */
    public RString getNinteichosaTokusokuHoho() {
        return ninteichosaTokusokuHoho;
    }

    /**
     * setNinteichosaTokusokuHoho
     *
     * @param ninteichosaTokusokuHoho ninteichosaTokusokuHoho
     */
    public void setNinteichosaTokusokuHoho(RString ninteichosaTokusokuHoho) {
        this.ninteichosaTokusokuHoho = ninteichosaTokusokuHoho;
    }

    /**
     * getNinteichosaTokusokuKaisu
     *
     * @return ninteichosaTokusokuKaisu
     */
    public int getNinteichosaTokusokuKaisu() {
        return ninteichosaTokusokuKaisu;
    }

    /**
     * setNinteichosaTokusokuKaisu
     *
     * @param ninteichosaTokusokuKaisu ninteichosaTokusokuKaisu
     */
    public void setNinteichosaTokusokuKaisu(int ninteichosaTokusokuKaisu) {
        this.ninteichosaTokusokuKaisu = ninteichosaTokusokuKaisu;
    }

    /**
     * getNinteichosaTokusokuMemo
     *
     * @return ninteichosaTokusokuMemo
     */
    public RString getNinteichosaTokusokuMemo() {
        return ninteichosaTokusokuMemo;
    }

    /**
     * setNinteichosaTokusokuMemo
     *
     * @param ninteichosaTokusokuMemo ninteichosaTokusokuMemo
     */
    public void setNinteichosaTokusokuMemo(RString ninteichosaTokusokuMemo) {
        this.ninteichosaTokusokuMemo = ninteichosaTokusokuMemo;
    }
// </editor-fold>
}
