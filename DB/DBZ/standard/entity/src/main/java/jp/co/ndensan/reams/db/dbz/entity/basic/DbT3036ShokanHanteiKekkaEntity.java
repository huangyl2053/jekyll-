package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3036ShokanHanteiKekkaの項目定義クラスです
 *
 */
public class DbT3036ShokanHanteiKekkaEntity extends DbTableEntityBase<DbT3036ShokanHanteiKekkaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3036ShokanHanteiKekka");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private HokenshaNo shoKisaiHokenshaNo;
    private FlexibleDate ketteiYMD;
    private RString shikyuHushikyuKetteiKubun;
    private Decimal shiharaiKingaku;
    private Decimal shiharaiKingakuUchiwakeRiyoshabun;
    private RString shiharaiHohoKubun;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKikanKaishiYMD;
    private FlexibleDate shiharaiKikanShuryoYMD;
    private RString kaichoNaiyo;
    private RTime shiharaiMadoguchiKaishiTime;
    private RTime shiharaiMadoguchiShuryoTime;
    private FlexibleYearMonth ketteiIchiranTorikomiYM;

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
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getSeiriNo
     *
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     *
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
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
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getKetteiYMD
     *
     * @return ketteiYMD
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * setKetteiYMD
     *
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * getShikyuHushikyuKetteiKubun
     *
     * @return shikyuHushikyuKetteiKubun
     */
    public RString getShikyuHushikyuKetteiKubun() {
        return shikyuHushikyuKetteiKubun;
    }

    /**
     * setShikyuHushikyuKetteiKubun
     *
     * @param shikyuHushikyuKetteiKubun shikyuHushikyuKetteiKubun
     */
    public void setShikyuHushikyuKetteiKubun(RString shikyuHushikyuKetteiKubun) {
        this.shikyuHushikyuKetteiKubun = shikyuHushikyuKetteiKubun;
    }

    /**
     * getShiharaiKingaku
     *
     * @return shiharaiKingaku
     */
    public Decimal getShiharaiKingaku() {
        return shiharaiKingaku;
    }

    /**
     * setShiharaiKingaku
     *
     * @param shiharaiKingaku shiharaiKingaku
     */
    public void setShiharaiKingaku(Decimal shiharaiKingaku) {
        this.shiharaiKingaku = shiharaiKingaku;
    }

    /**
     * getShiharaiKingakuUchiwakeRiyoshabun
     *
     * @return shiharaiKingakuUchiwakeRiyoshabun
     */
    public Decimal getShiharaiKingakuUchiwakeRiyoshabun() {
        return shiharaiKingakuUchiwakeRiyoshabun;
    }

    /**
     * setShiharaiKingakuUchiwakeRiyoshabun
     *
     * @param shiharaiKingakuUchiwakeRiyoshabun shiharaiKingakuUchiwakeRiyoshabun
     */
    public void setShiharaiKingakuUchiwakeRiyoshabun(Decimal shiharaiKingakuUchiwakeRiyoshabun) {
        this.shiharaiKingakuUchiwakeRiyoshabun = shiharaiKingakuUchiwakeRiyoshabun;
    }

    /**
     * getShiharaiHohoKubun
     *
     * @return shiharaiHohoKubun
     */
    public RString getShiharaiHohoKubun() {
        return shiharaiHohoKubun;
    }

    /**
     * setShiharaiHohoKubun
     *
     * @param shiharaiHohoKubun shiharaiHohoKubun
     */
    public void setShiharaiHohoKubun(RString shiharaiHohoKubun) {
        this.shiharaiHohoKubun = shiharaiHohoKubun;
    }

    /**
     * getShiharaiBasho
     *
     * @return shiharaiBasho
     */
    public RString getShiharaiBasho() {
        return shiharaiBasho;
    }

    /**
     * setShiharaiBasho
     *
     * @param shiharaiBasho shiharaiBasho
     */
    public void setShiharaiBasho(RString shiharaiBasho) {
        this.shiharaiBasho = shiharaiBasho;
    }

    /**
     * getShiharaiKikanKaishiYMD
     *
     * @return shiharaiKikanKaishiYMD
     */
    public FlexibleDate getShiharaiKikanKaishiYMD() {
        return shiharaiKikanKaishiYMD;
    }

    /**
     * setShiharaiKikanKaishiYMD
     *
     * @param shiharaiKikanKaishiYMD shiharaiKikanKaishiYMD
     */
    public void setShiharaiKikanKaishiYMD(FlexibleDate shiharaiKikanKaishiYMD) {
        this.shiharaiKikanKaishiYMD = shiharaiKikanKaishiYMD;
    }

    /**
     * getShiharaiKikanShuryoYMD
     *
     * @return shiharaiKikanShuryoYMD
     */
    public FlexibleDate getShiharaiKikanShuryoYMD() {
        return shiharaiKikanShuryoYMD;
    }

    /**
     * setShiharaiKikanShuryoYMD
     *
     * @param shiharaiKikanShuryoYMD shiharaiKikanShuryoYMD
     */
    public void setShiharaiKikanShuryoYMD(FlexibleDate shiharaiKikanShuryoYMD) {
        this.shiharaiKikanShuryoYMD = shiharaiKikanShuryoYMD;
    }

    /**
     * getKaichoNaiyo
     *
     * @return kaichoNaiyo
     */
    public RString getKaichoNaiyo() {
        return kaichoNaiyo;
    }

    /**
     * setKaichoNaiyo
     *
     * @param kaichoNaiyo kaichoNaiyo
     */
    public void setKaichoNaiyo(RString kaichoNaiyo) {
        this.kaichoNaiyo = kaichoNaiyo;
    }

    /**
     * getShiharaiMadoguchiKaishiTime
     *
     * @return shiharaiMadoguchiKaishiTime
     */
    public RTime getShiharaiMadoguchiKaishiTime() {
        return shiharaiMadoguchiKaishiTime;
    }

    /**
     * setShiharaiMadoguchiKaishiTime
     *
     * @param shiharaiMadoguchiKaishiTime shiharaiMadoguchiKaishiTime
     */
    public void setShiharaiMadoguchiKaishiTime(RTime shiharaiMadoguchiKaishiTime) {
        this.shiharaiMadoguchiKaishiTime = shiharaiMadoguchiKaishiTime;
    }

    /**
     * getShiharaiMadoguchiShuryoTime
     *
     * @return shiharaiMadoguchiShuryoTime
     */
    public RTime getShiharaiMadoguchiShuryoTime() {
        return shiharaiMadoguchiShuryoTime;
    }

    /**
     * setShiharaiMadoguchiShuryoTime
     *
     * @param shiharaiMadoguchiShuryoTime shiharaiMadoguchiShuryoTime
     */
    public void setShiharaiMadoguchiShuryoTime(RTime shiharaiMadoguchiShuryoTime) {
        this.shiharaiMadoguchiShuryoTime = shiharaiMadoguchiShuryoTime;
    }

    /**
     * getKetteiIchiranTorikomiYM
     *
     * @return ketteiIchiranTorikomiYM
     */
    public FlexibleYearMonth getKetteiIchiranTorikomiYM() {
        return ketteiIchiranTorikomiYM;
    }

    /**
     * setKetteiIchiranTorikomiYM
     *
     * @param ketteiIchiranTorikomiYM ketteiIchiranTorikomiYM
     */
    public void setKetteiIchiranTorikomiYM(FlexibleYearMonth ketteiIchiranTorikomiYM) {
        this.ketteiIchiranTorikomiYM = ketteiIchiranTorikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3036ShokanHanteiKekkaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3036ShokanHanteiKekkaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3036ShokanHanteiKekkaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
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
    public void shallowCopy(DbT3036ShokanHanteiKekkaEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.shikyuHushikyuKetteiKubun = entity.shikyuHushikyuKetteiKubun;
        this.shiharaiKingaku = entity.shiharaiKingaku;
        this.shiharaiKingakuUchiwakeRiyoshabun = entity.shiharaiKingakuUchiwakeRiyoshabun;
        this.shiharaiHohoKubun = entity.shiharaiHohoKubun;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shiharaiKikanKaishiYMD = entity.shiharaiKikanKaishiYMD;
        this.shiharaiKikanShuryoYMD = entity.shiharaiKikanShuryoYMD;
        this.kaichoNaiyo = entity.kaichoNaiyo;
        this.shiharaiMadoguchiKaishiTime = entity.shiharaiMadoguchiKaishiTime;
        this.shiharaiMadoguchiShuryoTime = entity.shiharaiMadoguchiShuryoTime;
        this.ketteiIchiranTorikomiYM = entity.ketteiIchiranTorikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, shoriTimestamp, shoKisaiHokenshaNo, ketteiYMD, shikyuHushikyuKetteiKubun, shiharaiKingaku, shiharaiKingakuUchiwakeRiyoshabun, shiharaiHohoKubun, shiharaiBasho, shiharaiKikanKaishiYMD, shiharaiKikanShuryoYMD, kaichoNaiyo, shiharaiMadoguchiKaishiTime, shiharaiMadoguchiShuryoTime, ketteiIchiranTorikomiYM);
    }

// </editor-fold>
}
