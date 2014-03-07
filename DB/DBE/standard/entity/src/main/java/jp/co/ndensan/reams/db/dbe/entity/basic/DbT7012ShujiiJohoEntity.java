package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang._UUID;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;

/**
 * DbT7012ShujiiJohoの項目定義クラスです
 *
 * @author N8156 宮本 康
 */
public class DbT7012ShujiiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7012ShujiiJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private _UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shichosonCode;
    @PrimaryKey
    private KaigoIryoKikanCode kaigoIryokikanCode;
    @PrimaryKey
    private RString kaigoIshiCode;
    private RString iryokikanCode;
    private RString shujiiCode;
    private boolean shujiiJokyo;
    private YubinNo yubinNo;
    private RString jusho;
    private TelNo telNo;
    private RString faxNo;

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
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public RString getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getKaigoIryokikanCode
     *
     * @return kaigoIryokikanCode
     */
    public KaigoIryoKikanCode getKaigoIryokikanCode() {
        return kaigoIryokikanCode;
    }

    /**
     * setKaigoIryokikanCode
     *
     * @param kaigoIryokikanCode kaigoIryokikanCode
     */
    public void setKaigoIryokikanCode(KaigoIryoKikanCode kaigoIryokikanCode) {
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
     * getIryokikanCode
     *
     * @return iryokikanCode
     */
    public RString getIryokikanCode() {
        return iryokikanCode;
    }

    /**
     * setIryokikanCode
     *
     * @param iryokikanCode iryokikanCode
     */
    public void setIryokikanCode(RString iryokikanCode) {
        this.iryokikanCode = iryokikanCode;
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
     * getShujiiJokyo
     *
     * @return shujiiJokyo
     */
    public boolean getShujiiJokyo() {
        return shujiiJokyo;
    }

    /**
     * setShujiiJokyo
     *
     * @param shujiiJokyo shujiiJokyo
     */
    public void setShujiiJokyo(boolean shujiiJokyo) {
        this.shujiiJokyo = shujiiJokyo;
    }

    /**
     * getYubinNo
     *
     * @return yubinNo
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * setYubinNo
     *
     * @param yubinNo yubinNo
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * getJusho
     *
     * @return jusho
     */
    public RString getJusho() {
        return jusho;
    }

    /**
     * setJusho
     *
     * @param jusho jusho
     */
    public void setJusho(RString jusho) {
        this.jusho = jusho;
    }

    /**
     * getTelNo
     *
     * @return telNo
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * setTelNo
     *
     * @param telNo telNo
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * getFaxNo
     *
     * @return faxNo
     */
    public RString getFaxNo() {
        return faxNo;
    }

    /**
     * setFaxNo
     *
     * @param faxNo faxNo
     */
    public void setFaxNo(RString faxNo) {
        this.faxNo = faxNo;
    }
// </editor-fold>
}
