package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.NinshoshaCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7004KaigoShiharaiJohoの項目定義クラスです
 *
 */
public class DbT7004KaigoShiharaiJohoEntity extends DbTableEntityBase<DbT7004KaigoShiharaiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7004KaigoShiharaiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private KamokuCode kamokuCode;
    @PrimaryKey
    private FlexibleDate ketteiYMD;
    private HihokenshaNo hihokenshaNo;
    private RString shiharaiHohoKubun;
    private Code madoguchiShiharaiBashoCode;
    private YMDHM madoguchiShiharaiKaishiYMDHM;
    private YMDHM madoguchiShiharaiShuryoYMDHM;
    private FlexibleDate furikomiYoteiYMD;
    private int shiharaiKingaku;
    private Code shubetsuCode;
    private Code yotoKubunCode;
    private FlexibleDate ninshoYMD1;
    private NinshoshaCode ninshoshaCode1;
    private FlexibleDate ninshoYMD2;
    private NinshoshaCode ninshoshaCode2;

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
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getKamokuCode
     *
     * @return kamokuCode
     */
    public KamokuCode getKamokuCode() {
        return kamokuCode;
    }

    /**
     * setKamokuCode
     *
     * @param kamokuCode kamokuCode
     */
    public void setKamokuCode(KamokuCode kamokuCode) {
        this.kamokuCode = kamokuCode;
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
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
     * getMadoguchiShiharaiBashoCode
     *
     * @return madoguchiShiharaiBashoCode
     */
    public Code getMadoguchiShiharaiBashoCode() {
        return madoguchiShiharaiBashoCode;
    }

    /**
     * setMadoguchiShiharaiBashoCode
     *
     * @param madoguchiShiharaiBashoCode madoguchiShiharaiBashoCode
     */
    public void setMadoguchiShiharaiBashoCode(Code madoguchiShiharaiBashoCode) {
        this.madoguchiShiharaiBashoCode = madoguchiShiharaiBashoCode;
    }

    /**
     * getMadoguchiShiharaiKaishiYMDHM
     *
     * @return madoguchiShiharaiKaishiYMDHM
     */
    public YMDHM getMadoguchiShiharaiKaishiYMDHM() {
        return madoguchiShiharaiKaishiYMDHM;
    }

    /**
     * setMadoguchiShiharaiKaishiYMDHM
     *
     * @param madoguchiShiharaiKaishiYMDHM madoguchiShiharaiKaishiYMDHM
     */
    public void setMadoguchiShiharaiKaishiYMDHM(YMDHM madoguchiShiharaiKaishiYMDHM) {
        this.madoguchiShiharaiKaishiYMDHM = madoguchiShiharaiKaishiYMDHM;
    }

    /**
     * getMadoguchiShiharaiShuryoYMDHM
     *
     * @return madoguchiShiharaiShuryoYMDHM
     */
    public YMDHM getMadoguchiShiharaiShuryoYMDHM() {
        return madoguchiShiharaiShuryoYMDHM;
    }

    /**
     * setMadoguchiShiharaiShuryoYMDHM
     *
     * @param madoguchiShiharaiShuryoYMDHM madoguchiShiharaiShuryoYMDHM
     */
    public void setMadoguchiShiharaiShuryoYMDHM(YMDHM madoguchiShiharaiShuryoYMDHM) {
        this.madoguchiShiharaiShuryoYMDHM = madoguchiShiharaiShuryoYMDHM;
    }

    /**
     * getFurikomiYoteiYMD
     *
     * @return furikomiYoteiYMD
     */
    public FlexibleDate getFurikomiYoteiYMD() {
        return furikomiYoteiYMD;
    }

    /**
     * setFurikomiYoteiYMD
     *
     * @param furikomiYoteiYMD furikomiYoteiYMD
     */
    public void setFurikomiYoteiYMD(FlexibleDate furikomiYoteiYMD) {
        this.furikomiYoteiYMD = furikomiYoteiYMD;
    }

    /**
     * getShiharaiKingaku
     *
     * @return shiharaiKingaku
     */
    public int getShiharaiKingaku() {
        return shiharaiKingaku;
    }

    /**
     * setShiharaiKingaku
     *
     * @param shiharaiKingaku shiharaiKingaku
     */
    public void setShiharaiKingaku(int shiharaiKingaku) {
        this.shiharaiKingaku = shiharaiKingaku;
    }

    /**
     * getShubetsuCode
     *
     * @return shubetsuCode
     */
    public Code getShubetsuCode() {
        return shubetsuCode;
    }

    /**
     * setShubetsuCode
     *
     * @param shubetsuCode shubetsuCode
     */
    public void setShubetsuCode(Code shubetsuCode) {
        this.shubetsuCode = shubetsuCode;
    }

    /**
     * getYotoKubunCode
     *
     * @return yotoKubunCode
     */
    public Code getYotoKubunCode() {
        return yotoKubunCode;
    }

    /**
     * setYotoKubunCode
     *
     * @param yotoKubunCode yotoKubunCode
     */
    public void setYotoKubunCode(Code yotoKubunCode) {
        this.yotoKubunCode = yotoKubunCode;
    }

    /**
     * getNinshoYMD1
     *
     * @return ninshoYMD1
     */
    public FlexibleDate getNinshoYMD1() {
        return ninshoYMD1;
    }

    /**
     * setNinshoYMD1
     *
     * @param ninshoYMD1 ninshoYMD1
     */
    public void setNinshoYMD1(FlexibleDate ninshoYMD1) {
        this.ninshoYMD1 = ninshoYMD1;
    }

    /**
     * getNinshoshaCode1
     *
     * @return ninshoshaCode1
     */
    public NinshoshaCode getNinshoshaCode1() {
        return ninshoshaCode1;
    }

    /**
     * setNinshoshaCode1
     *
     * @param ninshoshaCode1 ninshoshaCode1
     */
    public void setNinshoshaCode1(NinshoshaCode ninshoshaCode1) {
        this.ninshoshaCode1 = ninshoshaCode1;
    }

    /**
     * getNinshoYMD2
     *
     * @return ninshoYMD2
     */
    public FlexibleDate getNinshoYMD2() {
        return ninshoYMD2;
    }

    /**
     * setNinshoYMD2
     *
     * @param ninshoYMD2 ninshoYMD2
     */
    public void setNinshoYMD2(FlexibleDate ninshoYMD2) {
        this.ninshoYMD2 = ninshoYMD2;
    }

    /**
     * getNinshoshaCode2
     *
     * @return ninshoshaCode2
     */
    public NinshoshaCode getNinshoshaCode2() {
        return ninshoshaCode2;
    }

    /**
     * setNinshoshaCode2
     *
     * @param ninshoshaCode2 ninshoshaCode2
     */
    public void setNinshoshaCode2(NinshoshaCode ninshoshaCode2) {
        this.ninshoshaCode2 = ninshoshaCode2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7004KaigoShiharaiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7004KaigoShiharaiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7004KaigoShiharaiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.kamokuCode, other.kamokuCode)) {
            return false;
        }
        if (!Objects.equals(this.ketteiYMD, other.ketteiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7004KaigoShiharaiJohoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.kamokuCode = entity.kamokuCode;
        this.ketteiYMD = entity.ketteiYMD;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shiharaiHohoKubun = entity.shiharaiHohoKubun;
        this.madoguchiShiharaiBashoCode = entity.madoguchiShiharaiBashoCode;
        this.madoguchiShiharaiKaishiYMDHM = entity.madoguchiShiharaiKaishiYMDHM;
        this.madoguchiShiharaiShuryoYMDHM = entity.madoguchiShiharaiShuryoYMDHM;
        this.furikomiYoteiYMD = entity.furikomiYoteiYMD;
        this.shiharaiKingaku = entity.shiharaiKingaku;
        this.shubetsuCode = entity.shubetsuCode;
        this.yotoKubunCode = entity.yotoKubunCode;
        this.ninshoYMD1 = entity.ninshoYMD1;
        this.ninshoshaCode1 = entity.ninshoshaCode1;
        this.ninshoYMD2 = entity.ninshoYMD2;
        this.ninshoshaCode2 = entity.ninshoshaCode2;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, shikibetsuCode, kamokuCode, ketteiYMD, hihokenshaNo, shiharaiHohoKubun, madoguchiShiharaiBashoCode, madoguchiShiharaiKaishiYMDHM, madoguchiShiharaiShuryoYMDHM, furikomiYoteiYMD, shiharaiKingaku, shubetsuCode, yotoKubunCode, ninshoYMD1, ninshoshaCode1, ninshoYMD2, ninshoshaCode2);
    }

// </editor-fold>
}
