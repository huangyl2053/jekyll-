package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT7021JigyoHokokuTokeiDataの項目定義クラスです
 *
 */
public class DbT7021JigyoHokokuTokeiDataEntity extends DbTableEntityBase<DbT7021JigyoHokokuTokeiDataEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7021JigyoHokokuTokeiData");

    private RString insertDantaiCd;
    @PrimaryKey
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear hokokuYSeireki;
    @PrimaryKey
    private RString hokokuM;
    @PrimaryKey
    private FlexibleYear shukeiTaishoYSeireki;
    @PrimaryKey
    private RString shukeiTaishoM;
    @PrimaryKey
    private RString toukeiTaishoKubun;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private Code hyoNo;
    @PrimaryKey
    private Code shukeiNo;
    @PrimaryKey
    private Code shukeiTani;
    @PrimaryKey
    private Decimal tateNo;
    @PrimaryKey
    private Decimal yokoNo;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private Decimal shukeiKekkaAtai;
    private Code tateKomokuCode;
    private Code yokoKomokuCode;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getHokokuYSeireki
     * @return hokokuYSeireki
     */
    public FlexibleYear getHokokuYSeireki() {
        return hokokuYSeireki;
    }

    /**
     * setHokokuYSeireki
     * @param hokokuYSeireki hokokuYSeireki
     */
    public void setHokokuYSeireki(FlexibleYear hokokuYSeireki) {
        this.hokokuYSeireki = hokokuYSeireki;
    }

    /**
     * getHokokuM
     * @return hokokuM
     */
    public RString getHokokuM() {
        return hokokuM;
    }

    /**
     * setHokokuM
     * @param hokokuM hokokuM
     */
    public void setHokokuM(RString hokokuM) {
        this.hokokuM = hokokuM;
    }

    /**
     * getShukeiTaishoYSeireki
     * @return shukeiTaishoYSeireki
     */
    public FlexibleYear getShukeiTaishoYSeireki() {
        return shukeiTaishoYSeireki;
    }

    /**
     * setShukeiTaishoYSeireki
     * @param shukeiTaishoYSeireki shukeiTaishoYSeireki
     */
    public void setShukeiTaishoYSeireki(FlexibleYear shukeiTaishoYSeireki) {
        this.shukeiTaishoYSeireki = shukeiTaishoYSeireki;
    }

    /**
     * getShukeiTaishoM
     * @return shukeiTaishoM
     */
    public RString getShukeiTaishoM() {
        return shukeiTaishoM;
    }

    /**
     * setShukeiTaishoM
     * @param shukeiTaishoM shukeiTaishoM
     */
    public void setShukeiTaishoM(RString shukeiTaishoM) {
        this.shukeiTaishoM = shukeiTaishoM;
    }

    /**
     * getToukeiTaishoKubun
     * @return toukeiTaishoKubun
     */
    public RString getToukeiTaishoKubun() {
        return toukeiTaishoKubun;
    }

    /**
     * setToukeiTaishoKubun
     * @param toukeiTaishoKubun toukeiTaishoKubun
     */
    public void setToukeiTaishoKubun(RString toukeiTaishoKubun) {
        this.toukeiTaishoKubun = toukeiTaishoKubun;
    }

    /**
     * getShichosonCode
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getHyoNo
     * @return hyoNo
     */
    public Code getHyoNo() {
        return hyoNo;
    }

    /**
     * setHyoNo
     * @param hyoNo hyoNo
     */
    public void setHyoNo(Code hyoNo) {
        this.hyoNo = hyoNo;
    }

    /**
     * getShukeiNo
     * @return shukeiNo
     */
    public Code getShukeiNo() {
        return shukeiNo;
    }

    /**
     * setShukeiNo
     * @param shukeiNo shukeiNo
     */
    public void setShukeiNo(Code shukeiNo) {
        this.shukeiNo = shukeiNo;
    }

    /**
     * getShukeiTani
     * @return shukeiTani
     */
    public Code getShukeiTani() {
        return shukeiTani;
    }

    /**
     * setShukeiTani
     * @param shukeiTani shukeiTani
     */
    public void setShukeiTani(Code shukeiTani) {
        this.shukeiTani = shukeiTani;
    }

    /**
     * getTateNo
     * @return tateNo
     */
    public Decimal getTateNo() {
        return tateNo;
    }

    /**
     * setTateNo
     * @param tateNo tateNo
     */
    public void setTateNo(Decimal tateNo) {
        this.tateNo = tateNo;
    }

    /**
     * getYokoNo
     * @return yokoNo
     */
    public Decimal getYokoNo() {
        return yokoNo;
    }

    /**
     * setYokoNo
     * @param yokoNo yokoNo
     */
    public void setYokoNo(Decimal yokoNo) {
        this.yokoNo = yokoNo;
    }

    /**
     * getShoriTimestamp
     * @return shoriTimestamp
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getShukeiKekkaAtai
     * @return shukeiKekkaAtai
     */
    public Decimal getShukeiKekkaAtai() {
        return shukeiKekkaAtai;
    }

    /**
     * setShukeiKekkaAtai
     * @param shukeiKekkaAtai shukeiKekkaAtai
     */
    public void setShukeiKekkaAtai(Decimal shukeiKekkaAtai) {
        this.shukeiKekkaAtai = shukeiKekkaAtai;
    }

    /**
     * getTateKomokuCode
     * @return tateKomokuCode
     */
    public Code getTateKomokuCode() {
        return tateKomokuCode;
    }

    /**
     * setTateKomokuCode
     * @param tateKomokuCode tateKomokuCode
     */
    public void setTateKomokuCode(Code tateKomokuCode) {
        this.tateKomokuCode = tateKomokuCode;
    }

    /**
     * getYokoKomokuCode
     * @return yokoKomokuCode
     */
    public Code getYokoKomokuCode() {
        return yokoKomokuCode;
    }

    /**
     * setYokoKomokuCode
     * @param yokoKomokuCode yokoKomokuCode
     */
    public void setYokoKomokuCode(Code yokoKomokuCode) {
        this.yokoKomokuCode = yokoKomokuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7021JigyoHokokuTokeiDataEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7021JigyoHokokuTokeiDataEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7021JigyoHokokuTokeiDataEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.hokokuYSeireki, other.hokokuYSeireki)) {
            return false;
        }
        if (!Objects.equals(this.hokokuM, other.hokokuM)) {
            return false;
        }
        if (!Objects.equals(this.shukeiTaishoYSeireki, other.shukeiTaishoYSeireki)) {
            return false;
        }
        if (!Objects.equals(this.shukeiTaishoM, other.shukeiTaishoM)) {
            return false;
        }
        if (!Objects.equals(this.toukeiTaishoKubun, other.toukeiTaishoKubun)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.hyoNo, other.hyoNo)) {
            return false;
        }
        if (!Objects.equals(this.shukeiNo, other.shukeiNo)) {
            return false;
        }
        if (!Objects.equals(this.shukeiTani, other.shukeiTani)) {
            return false;
        }
        if (!Objects.equals(this.tateNo, other.tateNo)) {
            return false;
        }
        if (!Objects.equals(this.yokoNo, other.yokoNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7021JigyoHokokuTokeiDataEntity entity) {
        this.hokokuYSeireki = entity.hokokuYSeireki;
        this.hokokuM = entity.hokokuM;
        this.shukeiTaishoYSeireki = entity.shukeiTaishoYSeireki;
        this.shukeiTaishoM = entity.shukeiTaishoM;
        this.toukeiTaishoKubun = entity.toukeiTaishoKubun;
        this.shichosonCode = entity.shichosonCode;
        this.hyoNo = entity.hyoNo;
        this.shukeiNo = entity.shukeiNo;
        this.shukeiTani = entity.shukeiTani;
        this.tateNo = entity.tateNo;
        this.yokoNo = entity.yokoNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shukeiKekkaAtai = entity.shukeiKekkaAtai;
        this.tateKomokuCode = entity.tateKomokuCode;
        this.yokoKomokuCode = entity.yokoKomokuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hokokuYSeireki, hokokuM, shukeiTaishoYSeireki, shukeiTaishoM, toukeiTaishoKubun, shichosonCode, hyoNo, shukeiNo, shukeiTani, tateNo, yokoNo, shoriTimestamp, shukeiKekkaAtai, tateKomokuCode, yokoKomokuCode);
    }

// </editor-fold>


}
