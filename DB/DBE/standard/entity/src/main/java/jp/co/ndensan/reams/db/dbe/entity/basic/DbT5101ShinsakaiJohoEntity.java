package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * DbT5101ShinsakaiJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5101ShinsakaiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5101ShinsakaiJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int shinsakaiKaisaiNo;
    private FlexibleDate shinsakaiKaisaiYMD;
    private RString shinsakaiKaishiTime;
    private RString shinsakaiShuryoTime;
    private RString shinsakaiKaisaiBashoCode;
    private int gogitaiNo;
    private int shinsakaiYoteiTeiin;
    private int shinsakaiSaidaiTeiin;
    private int shinsakaiJidoWariateTeiin;
    private int shinsakaiIinTeiin;
    private boolean gogitaiSeishinkaiSonzaiFlag;
    private boolean gogitaiDummyFlag;
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    private boolean shinsakaiKyukaiFlag;
    private int shinsakaiWariateZumiNinzu;

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
     * getShinsakaiKaisaiNo
     *
     * @return shinsakaiKaisaiNo
     */
    public int getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * setShinsakaiKaisaiNo
     *
     * @param shinsakaiKaisaiNo shinsakaiKaisaiNo
     */
    public void setShinsakaiKaisaiNo(int shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * getShinsakaiKaisaiYMD
     *
     * @return shinsakaiKaisaiYMD
     */
    public FlexibleDate getShinsakaiKaisaiYMD() {
        return shinsakaiKaisaiYMD;
    }

    /**
     * setShinsakaiKaisaiYMD
     *
     * @param shinsakaiKaisaiYMD shinsakaiKaisaiYMD
     */
    public void setShinsakaiKaisaiYMD(FlexibleDate shinsakaiKaisaiYMD) {
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
    }

    /**
     * getShinsakaiKaishiTime
     *
     * @return shinsakaiKaishiTime
     */
    public RString getShinsakaiKaishiTime() {
        return shinsakaiKaishiTime;
    }

    /**
     * setShinsakaiKaishiTime
     *
     * @param shinsakaiKaishiTime shinsakaiKaishiTime
     */
    public void setShinsakaiKaishiTime(RString shinsakaiKaishiTime) {
        this.shinsakaiKaishiTime = shinsakaiKaishiTime;
    }

    /**
     * getShinsakaiShuryoTime
     *
     * @return shinsakaiShuryoTime
     */
    public RString getShinsakaiShuryoTime() {
        return shinsakaiShuryoTime;
    }

    /**
     * setShinsakaiShuryoTime
     *
     * @param shinsakaiShuryoTime shinsakaiShuryoTime
     */
    public void setShinsakaiShuryoTime(RString shinsakaiShuryoTime) {
        this.shinsakaiShuryoTime = shinsakaiShuryoTime;
    }

    /**
     * getShinsakaiKaisaiBashoCode
     *
     * @return shinsakaiKaisaiBashoCode
     */
    public RString getShinsakaiKaisaiBashoCode() {
        return shinsakaiKaisaiBashoCode;
    }

    /**
     * setShinsakaiKaisaiBashoCode
     *
     * @param shinsakaiKaisaiBashoCode shinsakaiKaisaiBashoCode
     */
    public void setShinsakaiKaisaiBashoCode(RString shinsakaiKaisaiBashoCode) {
        this.shinsakaiKaisaiBashoCode = shinsakaiKaisaiBashoCode;
    }

    /**
     * getGogitaiNo
     *
     * @return gogitaiNo
     */
    public int getGogitaiNo() {
        return gogitaiNo;
    }

    /**
     * setGogitaiNo
     *
     * @param gogitaiNo gogitaiNo
     */
    public void setGogitaiNo(int gogitaiNo) {
        this.gogitaiNo = gogitaiNo;
    }

    /**
     * getShinsakaiYoteiTeiin
     *
     * @return shinsakaiYoteiTeiin
     */
    public int getShinsakaiYoteiTeiin() {
        return shinsakaiYoteiTeiin;
    }

    /**
     * setShinsakaiYoteiTeiin
     *
     * @param shinsakaiYoteiTeiin shinsakaiYoteiTeiin
     */
    public void setShinsakaiYoteiTeiin(int shinsakaiYoteiTeiin) {
        this.shinsakaiYoteiTeiin = shinsakaiYoteiTeiin;
    }

    /**
     * getShinsakaiSaidaiTeiin
     *
     * @return shinsakaiSaidaiTeiin
     */
    public int getShinsakaiSaidaiTeiin() {
        return shinsakaiSaidaiTeiin;
    }

    /**
     * setShinsakaiSaidaiTeiin
     *
     * @param shinsakaiSaidaiTeiin shinsakaiSaidaiTeiin
     */
    public void setShinsakaiSaidaiTeiin(int shinsakaiSaidaiTeiin) {
        this.shinsakaiSaidaiTeiin = shinsakaiSaidaiTeiin;
    }

    /**
     * getShinsakaiJidoWariateTeiin
     *
     * @return shinsakaiJidoWariateTeiin
     */
    public int getShinsakaiJidoWariateTeiin() {
        return shinsakaiJidoWariateTeiin;
    }

    /**
     * setShinsakaiJidoWariateTeiin
     *
     * @param shinsakaiJidoWariateTeiin shinsakaiJidoWariateTeiin
     */
    public void setShinsakaiJidoWariateTeiin(int shinsakaiJidoWariateTeiin) {
        this.shinsakaiJidoWariateTeiin = shinsakaiJidoWariateTeiin;
    }

    /**
     * getShinsakaiIinTeiin
     *
     * @return shinsakaiIinTeiin
     */
    public int getShinsakaiIinTeiin() {
        return shinsakaiIinTeiin;
    }

    /**
     * setShinsakaiIinTeiin
     *
     * @param shinsakaiIinTeiin shinsakaiIinTeiin
     */
    public void setShinsakaiIinTeiin(int shinsakaiIinTeiin) {
        this.shinsakaiIinTeiin = shinsakaiIinTeiin;
    }

    /**
     * getGogitaiSeishinkaiSonzaiFlag
     *
     * @return gogitaiSeishinkaiSonzaiFlag
     */
    public boolean getGogitaiSeishinkaiSonzaiFlag() {
        return gogitaiSeishinkaiSonzaiFlag;
    }

    /**
     * setGogitaiSeishinkaiSonzaiFlag
     *
     * @param gogitaiSeishinkaiSonzaiFlag gogitaiSeishinkaiSonzaiFlag
     */
    public void setGogitaiSeishinkaiSonzaiFlag(boolean gogitaiSeishinkaiSonzaiFlag) {
        this.gogitaiSeishinkaiSonzaiFlag = gogitaiSeishinkaiSonzaiFlag;
    }

    /**
     * getGogitaiDummyFlag
     *
     * @return gogitaiDummyFlag
     */
    public boolean getGogitaiDummyFlag() {
        return gogitaiDummyFlag;
    }

    /**
     * setGogitaiDummyFlag
     *
     * @param gogitaiDummyFlag gogitaiDummyFlag
     */
    public void setGogitaiDummyFlag(boolean gogitaiDummyFlag) {
        this.gogitaiDummyFlag = gogitaiDummyFlag;
    }

    /**
     * getShinsakaiShiryoSakuseiYMD
     *
     * @return shinsakaiShiryoSakuseiYMD
     */
    public FlexibleDate getShinsakaiShiryoSakuseiYMD() {
        return shinsakaiShiryoSakuseiYMD;
    }

    /**
     * setShinsakaiShiryoSakuseiYMD
     *
     * @param shinsakaiShiryoSakuseiYMD shinsakaiShiryoSakuseiYMD
     */
    public void setShinsakaiShiryoSakuseiYMD(FlexibleDate shinsakaiShiryoSakuseiYMD) {
        this.shinsakaiShiryoSakuseiYMD = shinsakaiShiryoSakuseiYMD;
    }

    /**
     * getShinsakaiKyukaiFlag
     *
     * @return shinsakaiKyukaiFlag
     */
    public boolean getShinsakaiKyukaiFlag() {
        return shinsakaiKyukaiFlag;
    }

    /**
     * setShinsakaiKyukaiFlag
     *
     * @param shinsakaiKyukaiFlag shinsakaiKyukaiFlag
     */
    public void setShinsakaiKyukaiFlag(boolean shinsakaiKyukaiFlag) {
        this.shinsakaiKyukaiFlag = shinsakaiKyukaiFlag;
    }

    /**
     * getShinsakaiWariateZumiNinzu
     *
     * @return shinsakaiWariateZumiNinzu
     */
    public int getShinsakaiWariateZumiNinzu() {
        return shinsakaiWariateZumiNinzu;
    }

    /**
     * setShinsakaiWariateZumiNinzu
     *
     * @param shinsakaiWariateZumiNinzu shinsakaiWariateZumiNinzu
     */
    public void setShinsakaiWariateZumiNinzu(int shinsakaiWariateZumiNinzu) {
        this.shinsakaiWariateZumiNinzu = shinsakaiWariateZumiNinzu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5101ShinsakaiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5101ShinsakaiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5101ShinsakaiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (this.shinsakaiKaisaiNo != other.shinsakaiKaisaiNo) {
            return false;
        }
        return true;
    }
// </editor-fold>
}
