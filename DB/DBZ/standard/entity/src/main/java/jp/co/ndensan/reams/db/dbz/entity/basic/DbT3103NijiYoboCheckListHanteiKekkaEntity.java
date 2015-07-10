package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3103NijiYoboCheckListHanteiKekkaの項目定義クラスです
 *
 */
public class DbT3103NijiYoboCheckListHanteiKekkaEntity extends DbTableEntityBase<DbT3103NijiYoboCheckListHanteiKekkaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3103NijiYoboCheckListHanteiKekka");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private Decimal tensu_SeikatsuKinoZenpan;
    private Decimal tensu_UndokiKino;
    private Decimal tensu_Eiyo;
    private Decimal tensu_Koku;
    private Decimal tensu_Tojikomori;
    private Decimal tensu_NinchiNoryoku;
    private Decimal tensu_Utsu;
    private int shien_SeikatsuKinoZenpan;
    private int shien_UndokiKino;
    private int shien_Eiyo;
    private int shien_Koku;
    private int shien_Tojikomori;
    private int shien_NinchiNoryoku;
    private int shien_Utsu;
    private RString nijiYobo_ShukantekiKenkouKan;

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
     * getUketsukeYMD
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * setUketsukeYMD
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
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
     * getTensu_SeikatsuKinoZenpan
     *
     * @return tensu_SeikatsuKinoZenpan
     */
    public Decimal getTensu_SeikatsuKinoZenpan() {
        return tensu_SeikatsuKinoZenpan;
    }

    /**
     * setTensu_SeikatsuKinoZenpan
     *
     * @param tensu_SeikatsuKinoZenpan tensu_SeikatsuKinoZenpan
     */
    public void setTensu_SeikatsuKinoZenpan(Decimal tensu_SeikatsuKinoZenpan) {
        this.tensu_SeikatsuKinoZenpan = tensu_SeikatsuKinoZenpan;
    }

    /**
     * getTensu_UndokiKino
     *
     * @return tensu_UndokiKino
     */
    public Decimal getTensu_UndokiKino() {
        return tensu_UndokiKino;
    }

    /**
     * setTensu_UndokiKino
     *
     * @param tensu_UndokiKino tensu_UndokiKino
     */
    public void setTensu_UndokiKino(Decimal tensu_UndokiKino) {
        this.tensu_UndokiKino = tensu_UndokiKino;
    }

    /**
     * getTensu_Eiyo
     *
     * @return tensu_Eiyo
     */
    public Decimal getTensu_Eiyo() {
        return tensu_Eiyo;
    }

    /**
     * setTensu_Eiyo
     *
     * @param tensu_Eiyo tensu_Eiyo
     */
    public void setTensu_Eiyo(Decimal tensu_Eiyo) {
        this.tensu_Eiyo = tensu_Eiyo;
    }

    /**
     * getTensu_Koku
     *
     * @return tensu_Koku
     */
    public Decimal getTensu_Koku() {
        return tensu_Koku;
    }

    /**
     * setTensu_Koku
     *
     * @param tensu_Koku tensu_Koku
     */
    public void setTensu_Koku(Decimal tensu_Koku) {
        this.tensu_Koku = tensu_Koku;
    }

    /**
     * getTensu_Tojikomori
     *
     * @return tensu_Tojikomori
     */
    public Decimal getTensu_Tojikomori() {
        return tensu_Tojikomori;
    }

    /**
     * setTensu_Tojikomori
     *
     * @param tensu_Tojikomori tensu_Tojikomori
     */
    public void setTensu_Tojikomori(Decimal tensu_Tojikomori) {
        this.tensu_Tojikomori = tensu_Tojikomori;
    }

    /**
     * getTensu_NinchiNoryoku
     *
     * @return tensu_NinchiNoryoku
     */
    public Decimal getTensu_NinchiNoryoku() {
        return tensu_NinchiNoryoku;
    }

    /**
     * setTensu_NinchiNoryoku
     *
     * @param tensu_NinchiNoryoku tensu_NinchiNoryoku
     */
    public void setTensu_NinchiNoryoku(Decimal tensu_NinchiNoryoku) {
        this.tensu_NinchiNoryoku = tensu_NinchiNoryoku;
    }

    /**
     * getTensu_Utsu
     *
     * @return tensu_Utsu
     */
    public Decimal getTensu_Utsu() {
        return tensu_Utsu;
    }

    /**
     * setTensu_Utsu
     *
     * @param tensu_Utsu tensu_Utsu
     */
    public void setTensu_Utsu(Decimal tensu_Utsu) {
        this.tensu_Utsu = tensu_Utsu;
    }

    /**
     * getShien_SeikatsuKinoZenpan
     *
     * @return shien_SeikatsuKinoZenpan
     */
    public int getShien_SeikatsuKinoZenpan() {
        return shien_SeikatsuKinoZenpan;
    }

    /**
     * setShien_SeikatsuKinoZenpan
     *
     * @param shien_SeikatsuKinoZenpan shien_SeikatsuKinoZenpan
     */
    public void setShien_SeikatsuKinoZenpan(int shien_SeikatsuKinoZenpan) {
        this.shien_SeikatsuKinoZenpan = shien_SeikatsuKinoZenpan;
    }

    /**
     * getShien_UndokiKino
     *
     * @return shien_UndokiKino
     */
    public int getShien_UndokiKino() {
        return shien_UndokiKino;
    }

    /**
     * setShien_UndokiKino
     *
     * @param shien_UndokiKino shien_UndokiKino
     */
    public void setShien_UndokiKino(int shien_UndokiKino) {
        this.shien_UndokiKino = shien_UndokiKino;
    }

    /**
     * getShien_Eiyo
     *
     * @return shien_Eiyo
     */
    public int getShien_Eiyo() {
        return shien_Eiyo;
    }

    /**
     * setShien_Eiyo
     *
     * @param shien_Eiyo shien_Eiyo
     */
    public void setShien_Eiyo(int shien_Eiyo) {
        this.shien_Eiyo = shien_Eiyo;
    }

    /**
     * getShien_Koku
     *
     * @return shien_Koku
     */
    public int getShien_Koku() {
        return shien_Koku;
    }

    /**
     * setShien_Koku
     *
     * @param shien_Koku shien_Koku
     */
    public void setShien_Koku(int shien_Koku) {
        this.shien_Koku = shien_Koku;
    }

    /**
     * getShien_Tojikomori
     *
     * @return shien_Tojikomori
     */
    public int getShien_Tojikomori() {
        return shien_Tojikomori;
    }

    /**
     * setShien_Tojikomori
     *
     * @param shien_Tojikomori shien_Tojikomori
     */
    public void setShien_Tojikomori(int shien_Tojikomori) {
        this.shien_Tojikomori = shien_Tojikomori;
    }

    /**
     * getShien_NinchiNoryoku
     *
     * @return shien_NinchiNoryoku
     */
    public int getShien_NinchiNoryoku() {
        return shien_NinchiNoryoku;
    }

    /**
     * setShien_NinchiNoryoku
     *
     * @param shien_NinchiNoryoku shien_NinchiNoryoku
     */
    public void setShien_NinchiNoryoku(int shien_NinchiNoryoku) {
        this.shien_NinchiNoryoku = shien_NinchiNoryoku;
    }

    /**
     * getShien_Utsu
     *
     * @return shien_Utsu
     */
    public int getShien_Utsu() {
        return shien_Utsu;
    }

    /**
     * setShien_Utsu
     *
     * @param shien_Utsu shien_Utsu
     */
    public void setShien_Utsu(int shien_Utsu) {
        this.shien_Utsu = shien_Utsu;
    }

    /**
     * getNijiYobo_ShukantekiKenkouKan
     *
     * @return nijiYobo_ShukantekiKenkouKan
     */
    public RString getNijiYobo_ShukantekiKenkouKan() {
        return nijiYobo_ShukantekiKenkouKan;
    }

    /**
     * setNijiYobo_ShukantekiKenkouKan
     *
     * @param nijiYobo_ShukantekiKenkouKan nijiYobo_ShukantekiKenkouKan
     */
    public void setNijiYobo_ShukantekiKenkouKan(RString nijiYobo_ShukantekiKenkouKan) {
        this.nijiYobo_ShukantekiKenkouKan = nijiYobo_ShukantekiKenkouKan;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3103NijiYoboCheckListHanteiKekkaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3103NijiYoboCheckListHanteiKekkaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3103NijiYoboCheckListHanteiKekkaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.uketsukeYMD, other.uketsukeYMD)) {
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
    public void shallowCopy(DbT3103NijiYoboCheckListHanteiKekkaEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.tensu_SeikatsuKinoZenpan = entity.tensu_SeikatsuKinoZenpan;
        this.tensu_UndokiKino = entity.tensu_UndokiKino;
        this.tensu_Eiyo = entity.tensu_Eiyo;
        this.tensu_Koku = entity.tensu_Koku;
        this.tensu_Tojikomori = entity.tensu_Tojikomori;
        this.tensu_NinchiNoryoku = entity.tensu_NinchiNoryoku;
        this.tensu_Utsu = entity.tensu_Utsu;
        this.shien_SeikatsuKinoZenpan = entity.shien_SeikatsuKinoZenpan;
        this.shien_UndokiKino = entity.shien_UndokiKino;
        this.shien_Eiyo = entity.shien_Eiyo;
        this.shien_Koku = entity.shien_Koku;
        this.shien_Tojikomori = entity.shien_Tojikomori;
        this.shien_NinchiNoryoku = entity.shien_NinchiNoryoku;
        this.shien_Utsu = entity.shien_Utsu;
        this.nijiYobo_ShukantekiKenkouKan = entity.nijiYobo_ShukantekiKenkouKan;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, hihokenshaNo, uketsukeYMD, shoriTimestamp, tensu_SeikatsuKinoZenpan, tensu_UndokiKino, tensu_Eiyo, tensu_Koku, tensu_Tojikomori, tensu_NinchiNoryoku, tensu_Utsu, shien_SeikatsuKinoZenpan, shien_UndokiKino, shien_Eiyo, shien_Koku, shien_Tojikomori, shien_NinchiNoryoku, shien_Utsu, nijiYobo_ShukantekiKenkouKan);
    }

// </editor-fold>
}
