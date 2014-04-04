package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * DbT5103GogitaiJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5103GogitaiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5103GogitaiJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int gogitaiNo;
    private RString gogitaiMei;
    @PrimaryKey
    private FlexibleDate gogitaiYukoKikanKaishiYMD;
    private FlexibleDate gogitaiYukoKikanShuryoYMD;
    private RString gogitaiKaishiYoteiTime;
    private RString gogitaiShuryoYoteiTime;
    private RString shinsakaiKaisaiBashoCode;
    private int shinsakaiYoteiTeiin;
    private int shinsakaiJidoWariateTeiin;
    private int shinsakaiIinTeiin;
    private boolean gogitaiSeishinkaSonzaiFlag;
    private boolean gogitaiDummyFlag;

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
     * getGogitaiMei
     *
     * @return gogitaiMei
     */
    public RString getGogitaiMei() {
        return gogitaiMei;
    }

    /**
     * setGogitaiMei
     *
     * @param gogitaiMei gogitaiMei
     */
    public void setGogitaiMei(RString gogitaiMei) {
        this.gogitaiMei = gogitaiMei;
    }

    /**
     * getGogitaiYukoKikanKaishiYMD
     *
     * @return gogitaiYukoKikanKaishiYMD
     */
    public FlexibleDate getGogitaiYukoKikanKaishiYMD() {
        return gogitaiYukoKikanKaishiYMD;
    }

    /**
     * setGogitaiYukoKikanKaishiYMD
     *
     * @param gogitaiYukoKikanKaishiYMD gogitaiYukoKikanKaishiYMD
     */
    public void setGogitaiYukoKikanKaishiYMD(FlexibleDate gogitaiYukoKikanKaishiYMD) {
        this.gogitaiYukoKikanKaishiYMD = gogitaiYukoKikanKaishiYMD;
    }

    /**
     * getGogitaiYukoKikanShuryoYMD
     *
     * @return gogitaiYukoKikanShuryoYMD
     */
    public FlexibleDate getGogitaiYukoKikanShuryoYMD() {
        return gogitaiYukoKikanShuryoYMD;
    }

    /**
     * setGogitaiYukoKikanShuryoYMD
     *
     * @param gogitaiYukoKikanShuryoYMD gogitaiYukoKikanShuryoYMD
     */
    public void setGogitaiYukoKikanShuryoYMD(FlexibleDate gogitaiYukoKikanShuryoYMD) {
        this.gogitaiYukoKikanShuryoYMD = gogitaiYukoKikanShuryoYMD;
    }

    /**
     * getGogitaiKaishiYoteiTime
     *
     * @return gogitaiKaishiYoteiTime
     */
    public RString getGogitaiKaishiYoteiTime() {
        return gogitaiKaishiYoteiTime;
    }

    /**
     * setGogitaiKaishiYoteiTime
     *
     * @param gogitaiKaishiYoteiTime gogitaiKaishiYoteiTime
     */
    public void setGogitaiKaishiYoteiTime(RString gogitaiKaishiYoteiTime) {
        this.gogitaiKaishiYoteiTime = gogitaiKaishiYoteiTime;
    }

    /**
     * getGogitaiShuryoYoteiTime
     *
     * @return gogitaiShuryoYoteiTime
     */
    public RString getGogitaiShuryoYoteiTime() {
        return gogitaiShuryoYoteiTime;
    }

    /**
     * setGogitaiShuryoYoteiTime
     *
     * @param gogitaiShuryoYoteiTime gogitaiShuryoYoteiTime
     */
    public void setGogitaiShuryoYoteiTime(RString gogitaiShuryoYoteiTime) {
        this.gogitaiShuryoYoteiTime = gogitaiShuryoYoteiTime;
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
     * getGogitaiSeishinkaSonzaiFlag
     *
     * @return gogitaiSeishinkaSonzaiFlag
     */
    public boolean getGogitaiSeishinkaSonzaiFlag() {
        return gogitaiSeishinkaSonzaiFlag;
    }

    /**
     * setGogitaiSeishinkaSonzaiFlag
     *
     * @param gogitaiSeishinkaSonzaiFlag gogitaiSeishinkaSonzaiFlag
     */
    public void setGogitaiSeishinkaSonzaiFlag(boolean gogitaiSeishinkaSonzaiFlag) {
        this.gogitaiSeishinkaSonzaiFlag = gogitaiSeishinkaSonzaiFlag;
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
// </editor-fold>
}
