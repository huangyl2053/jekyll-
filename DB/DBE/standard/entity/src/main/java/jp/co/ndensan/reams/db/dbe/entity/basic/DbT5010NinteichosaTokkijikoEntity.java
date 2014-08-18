package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * DbT5010NinteichosaTokkijikoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5010NinteichosaTokkijikoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5010NinteichosaTokkijiko");
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
    private NinteichosaIraiRirekiNo ninteichosaRirekiNo;
    @PrimaryKey
    private RString ninteichosaTokkijikoNo;
    @PrimaryKey
    private Code genponMaskKubun;
    private RString ninteichosaTokkijiko;

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
     * getNinteichosaRirekiNo
     *
     * @return ninteichosaRirekiNo
     */
    public NinteichosaIraiRirekiNo getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * setNinteichosaRirekiNo
     *
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     */
    public void setNinteichosaRirekiNo(NinteichosaIraiRirekiNo ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * getNinteichosaTokkijikoNo
     *
     * @return ninteichosaTokkijikoNo
     */
    public RString getNinteichosaTokkijikoNo() {
        return ninteichosaTokkijikoNo;
    }

    /**
     * setNinteichosaTokkijikoNo
     *
     * @param ninteichosaTokkijikoNo ninteichosaTokkijikoNo
     */
    public void setNinteichosaTokkijikoNo(RString ninteichosaTokkijikoNo) {
        this.ninteichosaTokkijikoNo = ninteichosaTokkijikoNo;
    }

    /**
     * getGenponMaskKubun
     *
     * @return genponMaskKubun
     */
    public Code getGenponMaskKubun() {
        return genponMaskKubun;
    }

    /**
     * setGenponMaskKubun
     *
     * @param genponMaskKubun genponMaskKubun
     */
    public void setGenponMaskKubun(Code genponMaskKubun) {
        this.genponMaskKubun = genponMaskKubun;
    }

    /**
     * getNinteichosaTokkijiko
     *
     * @return ninteichosaTokkijiko
     */
    public RString getNinteichosaTokkijiko() {
        return ninteichosaTokkijiko;
    }

    /**
     * setNinteichosaTokkijiko
     *
     * @param ninteichosaTokkijiko ninteichosaTokkijiko
     */
    public void setNinteichosaTokkijiko(RString ninteichosaTokkijiko) {
        this.ninteichosaTokkijiko = ninteichosaTokkijiko;
    }
// </editor-fold>
}
