package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;

/**
 * DbT5015NinteiImageJohoの項目定義クラスです
 *
 */
public class DbT5015NinteiImageJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5015NinteiImageJoho");

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
    private Code torikomiChoyoIDCode;
    @PrimaryKey
    private RString maskDataKubun;
    @PrimaryKey
    private int torikomiPageNo;
    @PrimaryKey
    private int iraiRirekiNo;
    private int ninteiShinseiNen;
    private RString fileHaichiBasho;

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
     * getTorikomiChoyoIDCode
     *
     * @return torikomiChoyoIDCode
     */
    public Code getTorikomiChoyoIDCode() {
        return torikomiChoyoIDCode;
    }

    /**
     * setTorikomiChoyoIDCode
     *
     * @param torikomiChoyoIDCode torikomiChoyoIDCode
     */
    public void setTorikomiChoyoIDCode(Code torikomiChoyoIDCode) {
        this.torikomiChoyoIDCode = torikomiChoyoIDCode;
    }

    /**
     * getMaskDataKubun
     *
     * @return maskDataKubun
     */
    public RString getMaskDataKubun() {
        return maskDataKubun;
    }

    /**
     * setMaskDataKubun
     *
     * @param maskDataKubun maskDataKubun
     */
    public void setMaskDataKubun(RString maskDataKubun) {
        this.maskDataKubun = maskDataKubun;
    }

    /**
     * getTorikomiPageNo
     *
     * @return torikomiPageNo
     */
    public int getTorikomiPageNo() {
        return torikomiPageNo;
    }

    /**
     * setTorikomiPageNo
     *
     * @param torikomiPageNo torikomiPageNo
     */
    public void setTorikomiPageNo(int torikomiPageNo) {
        this.torikomiPageNo = torikomiPageNo;
    }

    /**
     * getIraiRirekiNo
     *
     * @return iraiRirekiNo
     */
    public int getIraiRirekiNo() {
        return iraiRirekiNo;
    }

    /**
     * setIraiRirekiNo
     *
     * @param iraiRirekiNo iraiRirekiNo
     */
    public void setIraiRirekiNo(int iraiRirekiNo) {
        this.iraiRirekiNo = iraiRirekiNo;
    }

    /**
     * getNinteiShinseiNen
     *
     * @return ninteiShinseiNen
     */
    public int getNinteiShinseiNen() {
        return ninteiShinseiNen;
    }

    /**
     * setNinteiShinseiNen
     *
     * @param ninteiShinseiNen ninteiShinseiNen
     */
    public void setNinteiShinseiNen(int ninteiShinseiNen) {
        this.ninteiShinseiNen = ninteiShinseiNen;
    }

    /**
     * getFileHaichiBasho
     *
     * @return fileHaichiBasho
     */
    public RString getFileHaichiBasho() {
        return fileHaichiBasho;
    }

    /**
     * setFileHaichiBasho
     *
     * @param fileHaichiBasho fileHaichiBasho
     */
    public void setFileHaichiBasho(RString fileHaichiBasho) {
        this.fileHaichiBasho = fileHaichiBasho;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5015NinteiImageJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5015NinteiImageJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5015NinteiImageJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.torikomiChoyoIDCode, other.torikomiChoyoIDCode)) {
            return false;
        }
        if (!Objects.equals(this.maskDataKubun, other.maskDataKubun)) {
            return false;
        }
        if (this.torikomiPageNo != other.torikomiPageNo) {
            return false;
        }
        if (this.iraiRirekiNo != other.iraiRirekiNo) {
            return false;
        }
        return true;
    }

// </editor-fold>
}
