package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * DbT5022RenkeiyoDataSofuKirokuの項目定義クラスです
 *
 */
public class DbT5022RenkeiyoDataSofuKirokuEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

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
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private KaigoHihokenshaNo hihokenshaNo;
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
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public KaigoHihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(KaigoHihokenshaNo hihokenshaNo) {
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

    /**
     * このエンティティの主キーが他の{@literal DbT5022RenkeiyoDataSofuKirokuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5022RenkeiyoDataSofuKirokuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5022RenkeiyoDataSofuKirokuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

// </editor-fold>
}
