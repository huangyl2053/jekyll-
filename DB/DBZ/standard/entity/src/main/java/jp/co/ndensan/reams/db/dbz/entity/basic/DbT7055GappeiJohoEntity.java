package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7055GappeiJohoの項目定義クラスです
 *
 */
public class DbT7055GappeiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7055GappeiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate gappeiYMD;
    @PrimaryKey
    private RString chiikiNo;
    private LasdecCode shichosonCode;
    private RString gappeiShurui;
    private ShoKisaiHokenshaNo hokenshaNo;
    private FlexibleDate kyuJohoFuyoToYMD;
    private FlexibleDate kokuhorenDataFromYMD;

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
     * getGappeiYMD
     *
     * @return gappeiYMD
     */
    public FlexibleDate getGappeiYMD() {
        return gappeiYMD;
    }

    /**
     * setGappeiYMD
     *
     * @param gappeiYMD gappeiYMD
     */
    public void setGappeiYMD(FlexibleDate gappeiYMD) {
        this.gappeiYMD = gappeiYMD;
    }

    /**
     * getChiikiNo
     *
     * @return chiikiNo
     */
    public RString getChiikiNo() {
        return chiikiNo;
    }

    /**
     * setChiikiNo
     *
     * @param chiikiNo chiikiNo
     */
    public void setChiikiNo(RString chiikiNo) {
        this.chiikiNo = chiikiNo;
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
     * getGappeiShurui
     *
     * @return gappeiShurui
     */
    public RString getGappeiShurui() {
        return gappeiShurui;
    }

    /**
     * setGappeiShurui
     *
     * @param gappeiShurui gappeiShurui
     */
    public void setGappeiShurui(RString gappeiShurui) {
        this.gappeiShurui = gappeiShurui;
    }

    /**
     * getHokenshaNo
     *
     * @return hokenshaNo
     */
    public ShoKisaiHokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * setHokenshaNo
     *
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(ShoKisaiHokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * getKyuJohoFuyoToYMD
     *
     * @return kyuJohoFuyoToYMD
     */
    public FlexibleDate getKyuJohoFuyoToYMD() {
        return kyuJohoFuyoToYMD;
    }

    /**
     * setKyuJohoFuyoToYMD
     *
     * @param kyuJohoFuyoToYMD kyuJohoFuyoToYMD
     */
    public void setKyuJohoFuyoToYMD(FlexibleDate kyuJohoFuyoToYMD) {
        this.kyuJohoFuyoToYMD = kyuJohoFuyoToYMD;
    }

    /**
     * getKokuhorenDataFromYMD
     *
     * @return kokuhorenDataFromYMD
     */
    public FlexibleDate getKokuhorenDataFromYMD() {
        return kokuhorenDataFromYMD;
    }

    /**
     * setKokuhorenDataFromYMD
     *
     * @param kokuhorenDataFromYMD kokuhorenDataFromYMD
     */
    public void setKokuhorenDataFromYMD(FlexibleDate kokuhorenDataFromYMD) {
        this.kokuhorenDataFromYMD = kokuhorenDataFromYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7055GappeiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7055GappeiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT7055GappeiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.gappeiYMD, other.gappeiYMD)) {
            return false;
        }
        if (!Objects.equals(this.chiikiNo, other.chiikiNo)) {
            return false;
        }
        return true;
    }

// </editor-fold>
}
