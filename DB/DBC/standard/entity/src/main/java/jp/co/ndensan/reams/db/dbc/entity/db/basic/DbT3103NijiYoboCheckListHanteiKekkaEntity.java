package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 二次予防チェックリスト判定結果テーブルのエンティティクラスです。
 */
public class DbT3103NijiYoboCheckListHanteiKekkaEntity extends DbTableEntityBase<DbT3103NijiYoboCheckListHanteiKekkaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
    private Decimal tensu_SeikatsuKinoZenpan;
    private Decimal tensu_UndokiKino;
    private Decimal tensu_Eiyo;
    private Decimal tensu_Koku;
    private Decimal tensu_Tojikomori;
    private Decimal tensu_NinchiNoryoku;
    private Decimal tensu_Utsu;
    private Decimal shien_SeikatsuKinoZenpan;
    private Decimal shien_UndokiKino;
    private Decimal shien_Eiyo;
    private Decimal shien_Koku;
    private Decimal shien_Tojikomori;
    private Decimal shien_NinchiNoryoku;
    private Decimal shien_Utsu;
    private RString nijiYobo_ShukantekiKenkouKan;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 受付年月日のgetメソッドです。
     *
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     *
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 点数・生活機能全般のgetメソッドです。
     *
     * @return 点数・生活機能全般
     */
    public Decimal getTensu_SeikatsuKinoZenpan() {
        return tensu_SeikatsuKinoZenpan;
    }

    /**
     * 点数・生活機能全般のsetメソッドです。
     *
     * @param tensu_SeikatsuKinoZenpan 点数・生活機能全般
     */
    public void setTensu_SeikatsuKinoZenpan(Decimal tensu_SeikatsuKinoZenpan) {
        this.tensu_SeikatsuKinoZenpan = tensu_SeikatsuKinoZenpan;
    }

    /**
     * 点数・運動器機能のgetメソッドです。
     *
     * @return 点数・運動器機能
     */
    public Decimal getTensu_UndokiKino() {
        return tensu_UndokiKino;
    }

    /**
     * 点数・運動器機能のsetメソッドです。
     *
     * @param tensu_UndokiKino 点数・運動器機能
     */
    public void setTensu_UndokiKino(Decimal tensu_UndokiKino) {
        this.tensu_UndokiKino = tensu_UndokiKino;
    }

    /**
     * 点数・栄養のgetメソッドです。
     *
     * @return 点数・栄養
     */
    public Decimal getTensu_Eiyo() {
        return tensu_Eiyo;
    }

    /**
     * 点数・栄養のsetメソッドです。
     *
     * @param tensu_Eiyo 点数・栄養
     */
    public void setTensu_Eiyo(Decimal tensu_Eiyo) {
        this.tensu_Eiyo = tensu_Eiyo;
    }

    /**
     * 点数・口腔のgetメソッドです。
     *
     * @return 点数・口腔
     */
    public Decimal getTensu_Koku() {
        return tensu_Koku;
    }

    /**
     * 点数・口腔のsetメソッドです。
     *
     * @param tensu_Koku 点数・口腔
     */
    public void setTensu_Koku(Decimal tensu_Koku) {
        this.tensu_Koku = tensu_Koku;
    }

    /**
     * 点数・閉じこもりのgetメソッドです。
     *
     * @return 点数・閉じこもり
     */
    public Decimal getTensu_Tojikomori() {
        return tensu_Tojikomori;
    }

    /**
     * 点数・閉じこもりのsetメソッドです。
     *
     * @param tensu_Tojikomori 点数・閉じこもり
     */
    public void setTensu_Tojikomori(Decimal tensu_Tojikomori) {
        this.tensu_Tojikomori = tensu_Tojikomori;
    }

    /**
     * 点数・認知能力のgetメソッドです。
     *
     * @return 点数・認知能力
     */
    public Decimal getTensu_NinchiNoryoku() {
        return tensu_NinchiNoryoku;
    }

    /**
     * 点数・認知能力のsetメソッドです。
     *
     * @param tensu_NinchiNoryoku 点数・認知能力
     */
    public void setTensu_NinchiNoryoku(Decimal tensu_NinchiNoryoku) {
        this.tensu_NinchiNoryoku = tensu_NinchiNoryoku;
    }

    /**
     * 点数・うつのgetメソッドです。
     *
     * @return 点数・うつ
     */
    public Decimal getTensu_Utsu() {
        return tensu_Utsu;
    }

    /**
     * 点数・うつのsetメソッドです。
     *
     * @param tensu_Utsu 点数・うつ
     */
    public void setTensu_Utsu(Decimal tensu_Utsu) {
        this.tensu_Utsu = tensu_Utsu;
    }

    /**
     * 支援必要性・生活機能全般のgetメソッドです。
     *
     * @return 支援必要性・生活機能全般
     */
    public Decimal getShien_SeikatsuKinoZenpan() {
        return shien_SeikatsuKinoZenpan;
    }

    /**
     * 支援必要性・生活機能全般のsetメソッドです。
     *
     * @param shien_SeikatsuKinoZenpan 支援必要性・生活機能全般
     */
    public void setShien_SeikatsuKinoZenpan(Decimal shien_SeikatsuKinoZenpan) {
        this.shien_SeikatsuKinoZenpan = shien_SeikatsuKinoZenpan;
    }

    /**
     * 支援必要性・運動器機能のgetメソッドです。
     *
     * @return 支援必要性・運動器機能
     */
    public Decimal getShien_UndokiKino() {
        return shien_UndokiKino;
    }

    /**
     * 支援必要性・運動器機能のsetメソッドです。
     *
     * @param shien_UndokiKino 支援必要性・運動器機能
     */
    public void setShien_UndokiKino(Decimal shien_UndokiKino) {
        this.shien_UndokiKino = shien_UndokiKino;
    }

    /**
     * 支援必要性・栄養のgetメソッドです。
     *
     * @return 支援必要性・栄養
     */
    public Decimal getShien_Eiyo() {
        return shien_Eiyo;
    }

    /**
     * 支援必要性・栄養のsetメソッドです。
     *
     * @param shien_Eiyo 支援必要性・栄養
     */
    public void setShien_Eiyo(Decimal shien_Eiyo) {
        this.shien_Eiyo = shien_Eiyo;
    }

    /**
     * 支援必要性・口腔のgetメソッドです。
     *
     * @return 支援必要性・口腔
     */
    public Decimal getShien_Koku() {
        return shien_Koku;
    }

    /**
     * 支援必要性・口腔のsetメソッドです。
     *
     * @param shien_Koku 支援必要性・口腔
     */
    public void setShien_Koku(Decimal shien_Koku) {
        this.shien_Koku = shien_Koku;
    }

    /**
     * 支援必要性・閉じこもりのgetメソッドです。
     *
     * @return 支援必要性・閉じこもり
     */
    public Decimal getShien_Tojikomori() {
        return shien_Tojikomori;
    }

    /**
     * 支援必要性・閉じこもりのsetメソッドです。
     *
     * @param shien_Tojikomori 支援必要性・閉じこもり
     */
    public void setShien_Tojikomori(Decimal shien_Tojikomori) {
        this.shien_Tojikomori = shien_Tojikomori;
    }

    /**
     * 支援必要性・認知能力のgetメソッドです。
     *
     * @return 支援必要性・認知能力
     */
    public Decimal getShien_NinchiNoryoku() {
        return shien_NinchiNoryoku;
    }

    /**
     * 支援必要性・認知能力のsetメソッドです。
     *
     * @param shien_NinchiNoryoku 支援必要性・認知能力
     */
    public void setShien_NinchiNoryoku(Decimal shien_NinchiNoryoku) {
        this.shien_NinchiNoryoku = shien_NinchiNoryoku;
    }

    /**
     * 支援必要性・うつのgetメソッドです。
     *
     * @return 支援必要性・うつ
     */
    public Decimal getShien_Utsu() {
        return shien_Utsu;
    }

    /**
     * 支援必要性・うつのsetメソッドです。
     *
     * @param shien_Utsu 支援必要性・うつ
     */
    public void setShien_Utsu(Decimal shien_Utsu) {
        this.shien_Utsu = shien_Utsu;
    }

    /**
     * 二次予防・主観的健康感のgetメソッドです。
     *
     * @return 二次予防・主観的健康感
     */
    public RString getNijiYobo_ShukantekiKenkouKan() {
        return nijiYobo_ShukantekiKenkouKan;
    }

    /**
     * 二次予防・主観的健康感のsetメソッドです。
     *
     * @param nijiYobo_ShukantekiKenkouKan 二次予防・主観的健康感
     */
    public void setNijiYobo_ShukantekiKenkouKan(RString nijiYobo_ShukantekiKenkouKan) {
        this.nijiYobo_ShukantekiKenkouKan = nijiYobo_ShukantekiKenkouKan;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3103NijiYoboCheckListHanteiKekkaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(shikibetsuCode, hihokenshaNo, uketsukeYMD, rirekiNo, tensu_SeikatsuKinoZenpan, tensu_UndokiKino, tensu_Eiyo, tensu_Koku, tensu_Tojikomori, tensu_NinchiNoryoku, tensu_Utsu, shien_SeikatsuKinoZenpan, shien_UndokiKino, shien_Eiyo, shien_Koku, shien_Tojikomori, shien_NinchiNoryoku, shien_Utsu, nijiYobo_ShukantekiKenkouKan);
    }

// </editor-fold>
}
