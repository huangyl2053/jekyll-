package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT7012ShujiiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7012ShujiiJoho");
    @PrimaryKey
    private RString shichosonCode;
    @PrimaryKey
    private RString kaigoIryokikanCode;
    @PrimaryKey
    private RString kaigoIshiCode;
    private RString iryokikanCode;
    private RString shujiiCode;
    private boolean shujiiJokyo;
    private RString yubinNo;
    private RString jusho;
    private RString telNo;
    private RString faxNo;

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
    public RString getYubinNo() {
        return yubinNo;
    }

    /**
     * setYubinNo
     *
     * @param yubinNo yubinNo
     */
    public void setYubinNo(RString yubinNo) {
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
    public RString getTelNo() {
        return telNo;
    }

    /**
     * setTelNo
     *
     * @param telNo telNo
     */
    public void setTelNo(RString telNo) {
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
