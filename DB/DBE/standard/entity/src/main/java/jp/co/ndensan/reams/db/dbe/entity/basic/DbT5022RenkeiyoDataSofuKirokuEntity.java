/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;

/**
 * DbT5022RenkeiyoDataSofuKirokuの項目定義クラスです
 *
 */
public class DbT5022RenkeiyoDataSofuKirokuEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5022RenkeiyoDataSofuKiroku");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shinseishoKanriNo;
    private RString hihokenshaNo;
    private RString ninteiShinseiShinseijiKubun;
    private RString hikiwatashiKubun;
    private RDateTime hikiwatashiNichiji;
    private RString saiSoufuKubun;
    private RString saiChousaSoufuKubun;
    private RString saiIkenshoSoufuKubun;

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
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getNinteiShinseiShinseijiKubun
     *
     * @return ninteiShinseiShinseijiKubun
     */
    public RString getNinteiShinseiShinseijiKubun() {
        return ninteiShinseiShinseijiKubun;
    }

    /**
     * setNinteiShinseiShinseijiKubun
     *
     * @param ninteiShinseiShinseijiKubun ninteiShinseiShinseijiKubun
     */
    public void setNinteiShinseiShinseijiKubun(RString ninteiShinseiShinseijiKubun) {
        this.ninteiShinseiShinseijiKubun = ninteiShinseiShinseijiKubun;
    }

    /**
     * getHikiwatashiKubun
     *
     * @return hikiwatashiKubun
     */
    public RString getHikiwatashiKubun() {
        return hikiwatashiKubun;
    }

    /**
     * setHikiwatashiKubun
     *
     * @param hikiwatashiKubun hikiwatashiKubun
     */
    public void setHikiwatashiKubun(RString hikiwatashiKubun) {
        this.hikiwatashiKubun = hikiwatashiKubun;
    }

    /**
     * getHikiwatashiNichiji
     *
     * @return hikiwatashiNichiji
     */
    public RDateTime getHikiwatashiNichiji() {
        return hikiwatashiNichiji;
    }

    /**
     * setHikiwatashiNichiji
     *
     * @param hikiwatashiNichiji hikiwatashiNichiji
     */
    public void setHikiwatashiNichiji(RDateTime hikiwatashiNichiji) {
        this.hikiwatashiNichiji = hikiwatashiNichiji;
    }

    /**
     * getSaiSoufuKubun
     *
     * @return saiSoufuKubun
     */
    public RString getSaiSoufuKubun() {
        return saiSoufuKubun;
    }

    /**
     * setSaiSoufuKubun
     *
     * @param saiSoufuKubun saiSoufuKubun
     */
    public void setSaiSoufuKubun(RString saiSoufuKubun) {
        this.saiSoufuKubun = saiSoufuKubun;
    }

    /**
     * getSaiChousaSoufuKubun
     *
     * @return saiChousaSoufuKubun
     */
    public RString getSaiChousaSoufuKubun() {
        return saiChousaSoufuKubun;
    }

    /**
     * setSaiChousaSoufuKubun
     *
     * @param saiChousaSoufuKubun saiChousaSoufuKubun
     */
    public void setSaiChousaSoufuKubun(RString saiChousaSoufuKubun) {
        this.saiChousaSoufuKubun = saiChousaSoufuKubun;
    }

    /**
     * getSaiIkenshoSoufuKubun
     *
     * @return saiIkenshoSoufuKubun
     */
    public RString getSaiIkenshoSoufuKubun() {
        return saiIkenshoSoufuKubun;
    }

    /**
     * setSaiIkenshoSoufuKubun
     *
     * @param saiIkenshoSoufuKubun saiIkenshoSoufuKubun
     */
    public void setSaiIkenshoSoufuKubun(RString saiIkenshoSoufuKubun) {
        this.saiIkenshoSoufuKubun = saiIkenshoSoufuKubun;
    }
// </editor-fold>
}
