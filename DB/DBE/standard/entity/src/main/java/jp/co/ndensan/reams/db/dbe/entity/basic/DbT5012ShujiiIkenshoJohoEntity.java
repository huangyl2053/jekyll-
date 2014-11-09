package jp.co.ndensan.reams.db.dbe.entity.basic;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 主治医意見書情報のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT5012ShujiiIkenshoJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5012ShujiiIkenshoJoho");
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
    private RString ikenshoIraiKubun;
    @PrimaryKey
    private int ikenshoIraiRirekiNo;
    private RString shujiiIryoKikanCode;
    private RString shujiiCode;
    private FlexibleDate ikenshoJuryoYMD;
    private FlexibleDate ikenshoKinyuYMD;
    private RString ikenshoSakuseiKaisu;
    private RString ikenshoSakuseiryoShubetsu;
    private boolean ninteiJohoTeikyoKiboFlag;
    private boolean ikenshoDoiUmuFlag;

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
     * getShujiiIryoKikanCode
     *
     * @return shujiiIryoKikanCode
     */
    public RString getShujiiIryoKikanCode() {
        return shujiiIryoKikanCode;
    }

    /**
     * setShujiiIryoKikanCode
     *
     * @param shujiiIryoKikanCode shujiiIryoKikanCode
     */
    public void setShujiiIryoKikanCode(RString shujiiIryoKikanCode) {
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
    }

    /**
     * getShujiiCode
     *
     * @return shujiiCode
     */
    public RString getShujiiCode() {
        return shujiiCode;
    }

    /**
     * setShujiiCode
     *
     * @param shujiiCode shujiiCode
     */
    public void setShujiiCode(RString shujiiCode) {
        this.shujiiCode = shujiiCode;
    }

    /**
     * getIkenshoJuryoYMD
     *
     * @return ikenshoJuryoYMD
     */
    public FlexibleDate getIkenshoJuryoYMD() {
        return ikenshoJuryoYMD;
    }

    /**
     * setIkenshoJuryoYMD
     *
     * @param ikenshoJuryoYMD ikenshoJuryoYMD
     */
    public void setIkenshoJuryoYMD(FlexibleDate ikenshoJuryoYMD) {
        this.ikenshoJuryoYMD = ikenshoJuryoYMD;
    }

    /**
     * getIkenshoKinyuYMD
     *
     * @return ikenshoKinyuYMD
     */
    public FlexibleDate getIkenshoKinyuYMD() {
        return ikenshoKinyuYMD;
    }

    /**
     * setIkenshoKinyuYMD
     *
     * @param ikenshoKinyuYMD ikenshoKinyuYMD
     */
    public void setIkenshoKinyuYMD(FlexibleDate ikenshoKinyuYMD) {
        this.ikenshoKinyuYMD = ikenshoKinyuYMD;
    }

    /**
     * getIkenshoSakuseiKaisu
     *
     * @return ikenshoSakuseiKaisu
     */
    public RString getIkenshoSakuseiKaisu() {
        return ikenshoSakuseiKaisu;
    }

    /**
     * setIkenshoSakuseiKaisu
     *
     * @param ikenshoSakuseiKaisu ikenshoSakuseiKaisu
     */
    public void setIkenshoSakuseiKaisu(RString ikenshoSakuseiKaisu) {
        this.ikenshoSakuseiKaisu = ikenshoSakuseiKaisu;
    }

    /**
     * getIkenshoSakuseiryoShubetsu
     *
     * @return ikenshoSakuseiryoShubetsu
     */
    public RString getIkenshoSakuseiryoShubetsu() {
        return ikenshoSakuseiryoShubetsu;
    }

    /**
     * setIkenshoSakuseiryoShubetsu
     *
     * @param ikenshoSakuseiryoShubetsu ikenshoSakuseiryoShubetsu
     */
    public void setIkenshoSakuseiryoShubetsu(RString ikenshoSakuseiryoShubetsu) {
        this.ikenshoSakuseiryoShubetsu = ikenshoSakuseiryoShubetsu;
    }

    /**
     * getNinteiJohoTeikyoKiboFlag
     *
     * @return ninteiJohoTeikyoKiboFlag
     */
    public boolean getNinteiJohoTeikyoKiboFlag() {
        return ninteiJohoTeikyoKiboFlag;
    }

    /**
     * setNinteiJohoTeikyoKiboFlag
     *
     * @param ninteiJohoTeikyoKiboFlag ninteiJohoTeikyoKiboFlag
     */
    public void setNinteiJohoTeikyoKiboFlag(boolean ninteiJohoTeikyoKiboFlag) {
        this.ninteiJohoTeikyoKiboFlag = ninteiJohoTeikyoKiboFlag;
    }

    /**
     * getIkenshoDoiUmuFlag
     *
     * @return ikenshoDoiUmuFlag
     */
    public boolean getIkenshoDoiUmuFlag() {
        return ikenshoDoiUmuFlag;
    }

    /**
     * setIkenshoDoiUmuFlag
     *
     * @param ikenshoDoiUmuFlag ikenshoDoiUmuFlag
     */
    public void setIkenshoDoiUmuFlag(boolean ikenshoDoiUmuFlag) {
        this.ikenshoDoiUmuFlag = ikenshoDoiUmuFlag;
    }
// </editor-fold>
}
