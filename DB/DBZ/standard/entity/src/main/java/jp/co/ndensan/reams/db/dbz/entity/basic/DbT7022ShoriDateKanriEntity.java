package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;

/**
 * DbT7022ShoriDateKanriの項目定義クラスです
 *
 */
public class DbT7022ShoriDateKanriEntity extends DbTableEntityBase<DbT7022ShoriDateKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7022ShoriDateKanri");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private GyomuCode gyomuCode;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private RString batchID;
    @PrimaryKey
    private RString batchIDEdaban;
    @PrimaryKey
    private FlexibleYear nendo;
    @PrimaryKey
    private RString nendoNaiRenban;
    private FlexibleDate kijunYMD;
    private FlexibleDate taishoKaishiYMD;
    private FlexibleDate taishoShuryoYMD;
    private YMDHMS taishoKaishiTimestamp;
    private YMDHMS taishoShuryoTimestamp;

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
     * getGyomuCode
     * @return gyomuCode
     */
    public GyomuCode getGyomuCode() {
        return gyomuCode;
    }

    /**
     * setGyomuCode
     * @param gyomuCode gyomuCode
     */
    public void setGyomuCode(GyomuCode gyomuCode) {
        this.gyomuCode = gyomuCode;
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
     * getBatchID
     * @return batchID
     */
    public RString getBatchID() {
        return batchID;
    }

    /**
     * setBatchID
     * @param batchID batchID
     */
    public void setBatchID(RString batchID) {
        this.batchID = batchID;
    }

    /**
     * getBatchIDEdaban
     * @return batchIDEdaban
     */
    public RString getBatchIDEdaban() {
        return batchIDEdaban;
    }

    /**
     * setBatchIDEdaban
     * @param batchIDEdaban batchIDEdaban
     */
    public void setBatchIDEdaban(RString batchIDEdaban) {
        this.batchIDEdaban = batchIDEdaban;
    }

    /**
     * getNendo
     * @return nendo
     */
    public FlexibleYear getNendo() {
        return nendo;
    }

    /**
     * setNendo
     * @param nendo nendo
     */
    public void setNendo(FlexibleYear nendo) {
        this.nendo = nendo;
    }

    /**
     * getNendoNaiRenban
     * @return nendoNaiRenban
     */
    public RString getNendoNaiRenban() {
        return nendoNaiRenban;
    }

    /**
     * setNendoNaiRenban
     * @param nendoNaiRenban nendoNaiRenban
     */
    public void setNendoNaiRenban(RString nendoNaiRenban) {
        this.nendoNaiRenban = nendoNaiRenban;
    }

    /**
     * getKijunYMD
     * @return kijunYMD
     */
    public FlexibleDate getKijunYMD() {
        return kijunYMD;
    }

    /**
     * setKijunYMD
     * @param kijunYMD kijunYMD
     */
    public void setKijunYMD(FlexibleDate kijunYMD) {
        this.kijunYMD = kijunYMD;
    }

    /**
     * getTaishoKaishiYMD
     * @return taishoKaishiYMD
     */
    public FlexibleDate getTaishoKaishiYMD() {
        return taishoKaishiYMD;
    }

    /**
     * setTaishoKaishiYMD
     * @param taishoKaishiYMD taishoKaishiYMD
     */
    public void setTaishoKaishiYMD(FlexibleDate taishoKaishiYMD) {
        this.taishoKaishiYMD = taishoKaishiYMD;
    }

    /**
     * getTaishoShuryoYMD
     * @return taishoShuryoYMD
     */
    public FlexibleDate getTaishoShuryoYMD() {
        return taishoShuryoYMD;
    }

    /**
     * setTaishoShuryoYMD
     * @param taishoShuryoYMD taishoShuryoYMD
     */
    public void setTaishoShuryoYMD(FlexibleDate taishoShuryoYMD) {
        this.taishoShuryoYMD = taishoShuryoYMD;
    }

    /**
     * getTaishoKaishiTimestamp
     * @return taishoKaishiTimestamp
     */
    public YMDHMS getTaishoKaishiTimestamp() {
        return taishoKaishiTimestamp;
    }

    /**
     * setTaishoKaishiTimestamp
     * @param taishoKaishiTimestamp taishoKaishiTimestamp
     */
    public void setTaishoKaishiTimestamp(YMDHMS taishoKaishiTimestamp) {
        this.taishoKaishiTimestamp = taishoKaishiTimestamp;
    }

    /**
     * getTaishoShuryoTimestamp
     * @return taishoShuryoTimestamp
     */
    public YMDHMS getTaishoShuryoTimestamp() {
        return taishoShuryoTimestamp;
    }

    /**
     * setTaishoShuryoTimestamp
     * @param taishoShuryoTimestamp taishoShuryoTimestamp
     */
    public void setTaishoShuryoTimestamp(YMDHMS taishoShuryoTimestamp) {
        this.taishoShuryoTimestamp = taishoShuryoTimestamp;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7022ShoriDateKanriEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7022ShoriDateKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7022ShoriDateKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.gyomuCode, other.gyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.batchID, other.batchID)) {
            return false;
        }
        if (!Objects.equals(this.batchIDEdaban, other.batchIDEdaban)) {
            return false;
        }
        if (!Objects.equals(this.nendo, other.nendo)) {
            return false;
        }
        if (!Objects.equals(this.nendoNaiRenban, other.nendoNaiRenban)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7022ShoriDateKanriEntity entity) {
        this.gyomuCode = entity.gyomuCode;
        this.shichosonCode = entity.shichosonCode;
        this.batchID = entity.batchID;
        this.batchIDEdaban = entity.batchIDEdaban;
        this.nendo = entity.nendo;
        this.nendoNaiRenban = entity.nendoNaiRenban;
        this.kijunYMD = entity.kijunYMD;
        this.taishoKaishiYMD = entity.taishoKaishiYMD;
        this.taishoShuryoYMD = entity.taishoShuryoYMD;
        this.taishoKaishiTimestamp = entity.taishoKaishiTimestamp;
        this.taishoShuryoTimestamp = entity.taishoShuryoTimestamp;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(gyomuCode, shichosonCode, batchID, batchIDEdaban, nendo, nendoNaiRenban, kijunYMD, taishoKaishiYMD, taishoShuryoYMD, taishoKaishiTimestamp, taishoShuryoTimestamp);
    }

// </editor-fold>


}
