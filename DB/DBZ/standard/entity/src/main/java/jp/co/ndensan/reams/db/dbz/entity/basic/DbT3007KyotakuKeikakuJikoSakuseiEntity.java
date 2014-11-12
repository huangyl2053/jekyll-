package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3007KyotakuKeikakuJikoSakuseiの項目定義クラスです
 *
 */
public class DbT3007KyotakuKeikakuJikoSakuseiEntity extends DbTableEntityBase<DbT3007KyotakuKeikakuJikoSakuseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3007KyotakuKeikakuJikoSakusei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString kyotaku_SogoJigyoKubun;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private FlexibleDate keikakuSakuseiYMD;
    private FlexibleDate keikakuHenkoYMD;
    private RString keikakuHenkoJiyu;

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
     * getTaishoYM
     *
     * @return taishoYM
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * setTaishoYM
     *
     * @param taishoYM taishoYM
     */
    public void setTaishoYM(FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * getKyotaku_SogoJigyoKubun
     *
     * @return kyotaku_SogoJigyoKubun
     */
    public RString getKyotaku_SogoJigyoKubun() {
        return kyotaku_SogoJigyoKubun;
    }

    /**
     * setKyotaku_SogoJigyoKubun
     *
     * @param kyotaku_SogoJigyoKubun kyotaku_SogoJigyoKubun
     */
    public void setKyotaku_SogoJigyoKubun(RString kyotaku_SogoJigyoKubun) {
        this.kyotaku_SogoJigyoKubun = kyotaku_SogoJigyoKubun;
    }

    /**
     * getTekiyoKaishiYMD
     *
     * @return tekiyoKaishiYMD
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * setTekiyoKaishiYMD
     *
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * getTekiyoShuryoYMD
     *
     * @return tekiyoShuryoYMD
     */
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * setTekiyoShuryoYMD
     *
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * getKeikakuSakuseiYMD
     *
     * @return keikakuSakuseiYMD
     */
    public FlexibleDate getKeikakuSakuseiYMD() {
        return keikakuSakuseiYMD;
    }

    /**
     * setKeikakuSakuseiYMD
     *
     * @param keikakuSakuseiYMD keikakuSakuseiYMD
     */
    public void setKeikakuSakuseiYMD(FlexibleDate keikakuSakuseiYMD) {
        this.keikakuSakuseiYMD = keikakuSakuseiYMD;
    }

    /**
     * getKeikakuHenkoYMD
     *
     * @return keikakuHenkoYMD
     */
    public FlexibleDate getKeikakuHenkoYMD() {
        return keikakuHenkoYMD;
    }

    /**
     * setKeikakuHenkoYMD
     *
     * @param keikakuHenkoYMD keikakuHenkoYMD
     */
    public void setKeikakuHenkoYMD(FlexibleDate keikakuHenkoYMD) {
        this.keikakuHenkoYMD = keikakuHenkoYMD;
    }

    /**
     * getKeikakuHenkoJiyu
     *
     * @return keikakuHenkoJiyu
     */
    public RString getKeikakuHenkoJiyu() {
        return keikakuHenkoJiyu;
    }

    /**
     * setKeikakuHenkoJiyu
     *
     * @param keikakuHenkoJiyu keikakuHenkoJiyu
     */
    public void setKeikakuHenkoJiyu(RString keikakuHenkoJiyu) {
        this.keikakuHenkoJiyu = keikakuHenkoJiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3007KyotakuKeikakuJikoSakuseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3007KyotakuKeikakuJikoSakuseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3007KyotakuKeikakuJikoSakuseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.taishoYM, other.taishoYM)) {
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
    public void shallowCopy(DbT3007KyotakuKeikakuJikoSakuseiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.taishoYM = entity.taishoYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kyotaku_SogoJigyoKubun = entity.kyotaku_SogoJigyoKubun;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.keikakuSakuseiYMD = entity.keikakuSakuseiYMD;
        this.keikakuHenkoYMD = entity.keikakuHenkoYMD;
        this.keikakuHenkoJiyu = entity.keikakuHenkoJiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shoKisaiHokenshaNo, shikibetsuCode, taishoYM, shoriTimestamp, kyotaku_SogoJigyoKubun, tekiyoKaishiYMD, tekiyoShuryoYMD, keikakuSakuseiYMD, keikakuHenkoYMD, keikakuHenkoJiyu);
    }

// </editor-fold>
}
