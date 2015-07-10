package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3069KogakuGassanShinseishoKanyurekiの項目定義クラスです
 *
 */
public class DbT3069KogakuGassanShinseishoKanyurekiEntity extends DbTableEntityBase<DbT3069KogakuGassanShinseishoKanyurekiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3069KogakuGassanShinseishoKanyureki");

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
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo hokenshaNo;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private RString kanyurekiNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString hokenshaMei;
    private FlexibleDate kanyuKaishiYMD;
    private FlexibleDate kanyuShuryoYMD;
    private RString jikoFutanShomeisho_SeiriNo;

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
     * getTaishoNendo
     *
     * @return taishoNendo
     */
    public FlexibleYear getTaishoNendo() {
        return taishoNendo;
    }

    /**
     * setTaishoNendo
     *
     * @param taishoNendo taishoNendo
     */
    public void setTaishoNendo(FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
    }

    /**
     * getHokenshaNo
     *
     * @return hokenshaNo
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * setHokenshaNo
     *
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
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
     * getKanyurekiNo
     *
     * @return kanyurekiNo
     */
    public RString getKanyurekiNo() {
        return kanyurekiNo;
    }

    /**
     * setKanyurekiNo
     *
     * @param kanyurekiNo kanyurekiNo
     */
    public void setKanyurekiNo(RString kanyurekiNo) {
        this.kanyurekiNo = kanyurekiNo;
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
     * getHokenshaMei
     *
     * @return hokenshaMei
     */
    public RString getHokenshaMei() {
        return hokenshaMei;
    }

    /**
     * setHokenshaMei
     *
     * @param hokenshaMei hokenshaMei
     */
    public void setHokenshaMei(RString hokenshaMei) {
        this.hokenshaMei = hokenshaMei;
    }

    /**
     * getKanyuKaishiYMD
     *
     * @return kanyuKaishiYMD
     */
    public FlexibleDate getKanyuKaishiYMD() {
        return kanyuKaishiYMD;
    }

    /**
     * setKanyuKaishiYMD
     *
     * @param kanyuKaishiYMD kanyuKaishiYMD
     */
    public void setKanyuKaishiYMD(FlexibleDate kanyuKaishiYMD) {
        this.kanyuKaishiYMD = kanyuKaishiYMD;
    }

    /**
     * getKanyuShuryoYMD
     *
     * @return kanyuShuryoYMD
     */
    public FlexibleDate getKanyuShuryoYMD() {
        return kanyuShuryoYMD;
    }

    /**
     * setKanyuShuryoYMD
     *
     * @param kanyuShuryoYMD kanyuShuryoYMD
     */
    public void setKanyuShuryoYMD(FlexibleDate kanyuShuryoYMD) {
        this.kanyuShuryoYMD = kanyuShuryoYMD;
    }

    /**
     * getJikoFutanShomeisho_SeiriNo
     *
     * @return jikoFutanShomeisho_SeiriNo
     */
    public RString getJikoFutanShomeisho_SeiriNo() {
        return jikoFutanShomeisho_SeiriNo;
    }

    /**
     * setJikoFutanShomeisho_SeiriNo
     *
     * @param jikoFutanShomeisho_SeiriNo jikoFutanShomeisho_SeiriNo
     */
    public void setJikoFutanShomeisho_SeiriNo(RString jikoFutanShomeisho_SeiriNo) {
        this.jikoFutanShomeisho_SeiriNo = jikoFutanShomeisho_SeiriNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3069KogakuGassanShinseishoKanyurekiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3069KogakuGassanShinseishoKanyurekiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3069KogakuGassanShinseishoKanyurekiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoNendo, other.taishoNendo)) {
            return false;
        }
        if (!Objects.equals(this.hokenshaNo, other.hokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
            return false;
        }
        if (!Objects.equals(this.kanyurekiNo, other.kanyurekiNo)) {
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
    public void shallowCopy(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.hokenshaNo = entity.hokenshaNo;
        this.seiriNo = entity.seiriNo;
        this.kanyurekiNo = entity.kanyurekiNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.hokenshaMei = entity.hokenshaMei;
        this.kanyuKaishiYMD = entity.kanyuKaishiYMD;
        this.kanyuShuryoYMD = entity.kanyuShuryoYMD;
        this.jikoFutanShomeisho_SeiriNo = entity.jikoFutanShomeisho_SeiriNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, seiriNo, kanyurekiNo, shoriTimestamp, hokenshaMei, kanyuKaishiYMD, kanyuShuryoYMD, jikoFutanShomeisho_SeiriNo);
    }

// </editor-fold>
}
