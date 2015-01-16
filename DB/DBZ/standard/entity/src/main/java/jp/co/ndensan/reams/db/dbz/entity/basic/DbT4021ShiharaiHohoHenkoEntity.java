package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import java.util.Objects;

/**
 * DbT4021ShiharaiHohoHenkoの項目定義クラスです
 *
 */
public class DbT4021ShiharaiHohoHenkoEntity extends DbTableEntityBase<DbT4021ShiharaiHohoHenkoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4021ShiharaiHohoHenko");

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
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString kanriKubun;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString torokuKubun;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString shuryoKubun;
    private FlexibleDate yokoku_TorokuYMD;
    private FlexibleDate sashitome_IraiJuriYMD;
    private FlexibleDate yokoku_TsuchiHakkoYMD;
    private boolean yokoku_TsuchiSaiHakkoFlag;
    private FlexibleDate bemmei_TeishutsuYMD;
    private FlexibleDate bemmei_UketsukeYMD;
    private RString bemmei_RiyuCode;
    private FlexibleDate bemmei_ShinsaKetteiYMD;
    private RString bemmei_ShinsaKekkaKubun;
    private FlexibleDate shokan_KetteiYMD;
    private FlexibleDate shokan_TsuchiHakkoYMD;
    private boolean shokan_TsuchiSaiHakkoFlag;
    private FlexibleDate hihokenshaShoTeishutsuYMD;
    private boolean sashitome_Flag;
    private FlexibleDate sashitome_KetteiYMD;
    private FlexibleDate sashitome_KaijoYMD;
    private FlexibleDate gemmen_KetteiYMD;
    private FlexibleDate gemmen_TsuchiHakkoYMD;
    private boolean gemmen_TsuchiSaiHakkoFlag;
    private HokenKyufuRitsu kyufuRitsu;
    private FlexibleDate shuryoShinsei_UketsukeYMD;
    private FlexibleDate shuryoShinsei_YMD;
    private RString shuryoShinsei_RiyuCode;
    private FlexibleDate shuryoShinsei_ShinsaKetteiYMD;
    private RString shuryoShinsei_ShinsaKekkaKubun;
    private boolean mukoKubun;

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
     * getShoKisaiHokenshaNo
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getHihokenshaNo
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getKanriKubun
     * @return kanriKubun
     */
    public RString getKanriKubun() {
        return kanriKubun;
    }

    /**
     * setKanriKubun
     * @param kanriKubun kanriKubun
     */
    public void setKanriKubun(RString kanriKubun) {
        this.kanriKubun = kanriKubun;
    }

    /**
     * getShoriTimestamp
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getTorokuKubun
     * @return torokuKubun
     */
    public RString getTorokuKubun() {
        return torokuKubun;
    }

    /**
     * setTorokuKubun
     * @param torokuKubun torokuKubun
     */
    public void setTorokuKubun(RString torokuKubun) {
        this.torokuKubun = torokuKubun;
    }

    /**
     * getTekiyoKaishiYMD
     * @return tekiyoKaishiYMD
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * setTekiyoKaishiYMD
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * getTekiyoShuryoYMD
     * @return tekiyoShuryoYMD
     */
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * setTekiyoShuryoYMD
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * getShuryoKubun
     * @return shuryoKubun
     */
    public RString getShuryoKubun() {
        return shuryoKubun;
    }

    /**
     * setShuryoKubun
     * @param shuryoKubun shuryoKubun
     */
    public void setShuryoKubun(RString shuryoKubun) {
        this.shuryoKubun = shuryoKubun;
    }

    /**
     * getYokoku_TorokuYMD
     * @return yokoku_TorokuYMD
     */
    public FlexibleDate getYokoku_TorokuYMD() {
        return yokoku_TorokuYMD;
    }

    /**
     * setYokoku_TorokuYMD
     * @param yokoku_TorokuYMD yokoku_TorokuYMD
     */
    public void setYokoku_TorokuYMD(FlexibleDate yokoku_TorokuYMD) {
        this.yokoku_TorokuYMD = yokoku_TorokuYMD;
    }

    /**
     * getSashitome_IraiJuriYMD
     * @return sashitome_IraiJuriYMD
     */
    public FlexibleDate getSashitome_IraiJuriYMD() {
        return sashitome_IraiJuriYMD;
    }

    /**
     * setSashitome_IraiJuriYMD
     * @param sashitome_IraiJuriYMD sashitome_IraiJuriYMD
     */
    public void setSashitome_IraiJuriYMD(FlexibleDate sashitome_IraiJuriYMD) {
        this.sashitome_IraiJuriYMD = sashitome_IraiJuriYMD;
    }

    /**
     * getYokoku_TsuchiHakkoYMD
     * @return yokoku_TsuchiHakkoYMD
     */
    public FlexibleDate getYokoku_TsuchiHakkoYMD() {
        return yokoku_TsuchiHakkoYMD;
    }

    /**
     * setYokoku_TsuchiHakkoYMD
     * @param yokoku_TsuchiHakkoYMD yokoku_TsuchiHakkoYMD
     */
    public void setYokoku_TsuchiHakkoYMD(FlexibleDate yokoku_TsuchiHakkoYMD) {
        this.yokoku_TsuchiHakkoYMD = yokoku_TsuchiHakkoYMD;
    }

    /**
     * getYokoku_TsuchiSaiHakkoFlag
     * @return yokoku_TsuchiSaiHakkoFlag
     */
    public boolean getYokoku_TsuchiSaiHakkoFlag() {
        return yokoku_TsuchiSaiHakkoFlag;
    }

    /**
     * setYokoku_TsuchiSaiHakkoFlag
     * @param yokoku_TsuchiSaiHakkoFlag yokoku_TsuchiSaiHakkoFlag
     */
    public void setYokoku_TsuchiSaiHakkoFlag(boolean yokoku_TsuchiSaiHakkoFlag) {
        this.yokoku_TsuchiSaiHakkoFlag = yokoku_TsuchiSaiHakkoFlag;
    }

    /**
     * getBemmei_TeishutsuYMD
     * @return bemmei_TeishutsuYMD
     */
    public FlexibleDate getBemmei_TeishutsuYMD() {
        return bemmei_TeishutsuYMD;
    }

    /**
     * setBemmei_TeishutsuYMD
     * @param bemmei_TeishutsuYMD bemmei_TeishutsuYMD
     */
    public void setBemmei_TeishutsuYMD(FlexibleDate bemmei_TeishutsuYMD) {
        this.bemmei_TeishutsuYMD = bemmei_TeishutsuYMD;
    }

    /**
     * getBemmei_UketsukeYMD
     * @return bemmei_UketsukeYMD
     */
    public FlexibleDate getBemmei_UketsukeYMD() {
        return bemmei_UketsukeYMD;
    }

    /**
     * setBemmei_UketsukeYMD
     * @param bemmei_UketsukeYMD bemmei_UketsukeYMD
     */
    public void setBemmei_UketsukeYMD(FlexibleDate bemmei_UketsukeYMD) {
        this.bemmei_UketsukeYMD = bemmei_UketsukeYMD;
    }

    /**
     * getBemmei_RiyuCode
     * @return bemmei_RiyuCode
     */
    public RString getBemmei_RiyuCode() {
        return bemmei_RiyuCode;
    }

    /**
     * setBemmei_RiyuCode
     * @param bemmei_RiyuCode bemmei_RiyuCode
     */
    public void setBemmei_RiyuCode(RString bemmei_RiyuCode) {
        this.bemmei_RiyuCode = bemmei_RiyuCode;
    }

    /**
     * getBemmei_ShinsaKetteiYMD
     * @return bemmei_ShinsaKetteiYMD
     */
    public FlexibleDate getBemmei_ShinsaKetteiYMD() {
        return bemmei_ShinsaKetteiYMD;
    }

    /**
     * setBemmei_ShinsaKetteiYMD
     * @param bemmei_ShinsaKetteiYMD bemmei_ShinsaKetteiYMD
     */
    public void setBemmei_ShinsaKetteiYMD(FlexibleDate bemmei_ShinsaKetteiYMD) {
        this.bemmei_ShinsaKetteiYMD = bemmei_ShinsaKetteiYMD;
    }

    /**
     * getBemmei_ShinsaKekkaKubun
     * @return bemmei_ShinsaKekkaKubun
     */
    public RString getBemmei_ShinsaKekkaKubun() {
        return bemmei_ShinsaKekkaKubun;
    }

    /**
     * setBemmei_ShinsaKekkaKubun
     * @param bemmei_ShinsaKekkaKubun bemmei_ShinsaKekkaKubun
     */
    public void setBemmei_ShinsaKekkaKubun(RString bemmei_ShinsaKekkaKubun) {
        this.bemmei_ShinsaKekkaKubun = bemmei_ShinsaKekkaKubun;
    }

    /**
     * getShokan_KetteiYMD
     * @return shokan_KetteiYMD
     */
    public FlexibleDate getShokan_KetteiYMD() {
        return shokan_KetteiYMD;
    }

    /**
     * setShokan_KetteiYMD
     * @param shokan_KetteiYMD shokan_KetteiYMD
     */
    public void setShokan_KetteiYMD(FlexibleDate shokan_KetteiYMD) {
        this.shokan_KetteiYMD = shokan_KetteiYMD;
    }

    /**
     * getShokan_TsuchiHakkoYMD
     * @return shokan_TsuchiHakkoYMD
     */
    public FlexibleDate getShokan_TsuchiHakkoYMD() {
        return shokan_TsuchiHakkoYMD;
    }

    /**
     * setShokan_TsuchiHakkoYMD
     * @param shokan_TsuchiHakkoYMD shokan_TsuchiHakkoYMD
     */
    public void setShokan_TsuchiHakkoYMD(FlexibleDate shokan_TsuchiHakkoYMD) {
        this.shokan_TsuchiHakkoYMD = shokan_TsuchiHakkoYMD;
    }

    /**
     * getShokan_TsuchiSaiHakkoFlag
     * @return shokan_TsuchiSaiHakkoFlag
     */
    public boolean getShokan_TsuchiSaiHakkoFlag() {
        return shokan_TsuchiSaiHakkoFlag;
    }

    /**
     * setShokan_TsuchiSaiHakkoFlag
     * @param shokan_TsuchiSaiHakkoFlag shokan_TsuchiSaiHakkoFlag
     */
    public void setShokan_TsuchiSaiHakkoFlag(boolean shokan_TsuchiSaiHakkoFlag) {
        this.shokan_TsuchiSaiHakkoFlag = shokan_TsuchiSaiHakkoFlag;
    }

    /**
     * getHihokenshaShoTeishutsuYMD
     * @return hihokenshaShoTeishutsuYMD
     */
    public FlexibleDate getHihokenshaShoTeishutsuYMD() {
        return hihokenshaShoTeishutsuYMD;
    }

    /**
     * setHihokenshaShoTeishutsuYMD
     * @param hihokenshaShoTeishutsuYMD hihokenshaShoTeishutsuYMD
     */
    public void setHihokenshaShoTeishutsuYMD(FlexibleDate hihokenshaShoTeishutsuYMD) {
        this.hihokenshaShoTeishutsuYMD = hihokenshaShoTeishutsuYMD;
    }

    /**
     * getSashitome_Flag
     * @return sashitome_Flag
     */
    public boolean getSashitome_Flag() {
        return sashitome_Flag;
    }

    /**
     * setSashitome_Flag
     * @param sashitome_Flag sashitome_Flag
     */
    public void setSashitome_Flag(boolean sashitome_Flag) {
        this.sashitome_Flag = sashitome_Flag;
    }

    /**
     * getSashitome_KetteiYMD
     * @return sashitome_KetteiYMD
     */
    public FlexibleDate getSashitome_KetteiYMD() {
        return sashitome_KetteiYMD;
    }

    /**
     * setSashitome_KetteiYMD
     * @param sashitome_KetteiYMD sashitome_KetteiYMD
     */
    public void setSashitome_KetteiYMD(FlexibleDate sashitome_KetteiYMD) {
        this.sashitome_KetteiYMD = sashitome_KetteiYMD;
    }

    /**
     * getSashitome_KaijoYMD
     * @return sashitome_KaijoYMD
     */
    public FlexibleDate getSashitome_KaijoYMD() {
        return sashitome_KaijoYMD;
    }

    /**
     * setSashitome_KaijoYMD
     * @param sashitome_KaijoYMD sashitome_KaijoYMD
     */
    public void setSashitome_KaijoYMD(FlexibleDate sashitome_KaijoYMD) {
        this.sashitome_KaijoYMD = sashitome_KaijoYMD;
    }

    /**
     * getGemmen_KetteiYMD
     * @return gemmen_KetteiYMD
     */
    public FlexibleDate getGemmen_KetteiYMD() {
        return gemmen_KetteiYMD;
    }

    /**
     * setGemmen_KetteiYMD
     * @param gemmen_KetteiYMD gemmen_KetteiYMD
     */
    public void setGemmen_KetteiYMD(FlexibleDate gemmen_KetteiYMD) {
        this.gemmen_KetteiYMD = gemmen_KetteiYMD;
    }

    /**
     * getGemmen_TsuchiHakkoYMD
     * @return gemmen_TsuchiHakkoYMD
     */
    public FlexibleDate getGemmen_TsuchiHakkoYMD() {
        return gemmen_TsuchiHakkoYMD;
    }

    /**
     * setGemmen_TsuchiHakkoYMD
     * @param gemmen_TsuchiHakkoYMD gemmen_TsuchiHakkoYMD
     */
    public void setGemmen_TsuchiHakkoYMD(FlexibleDate gemmen_TsuchiHakkoYMD) {
        this.gemmen_TsuchiHakkoYMD = gemmen_TsuchiHakkoYMD;
    }

    /**
     * getGemmen_TsuchiSaiHakkoFlag
     * @return gemmen_TsuchiSaiHakkoFlag
     */
    public boolean getGemmen_TsuchiSaiHakkoFlag() {
        return gemmen_TsuchiSaiHakkoFlag;
    }

    /**
     * setGemmen_TsuchiSaiHakkoFlag
     * @param gemmen_TsuchiSaiHakkoFlag gemmen_TsuchiSaiHakkoFlag
     */
    public void setGemmen_TsuchiSaiHakkoFlag(boolean gemmen_TsuchiSaiHakkoFlag) {
        this.gemmen_TsuchiSaiHakkoFlag = gemmen_TsuchiSaiHakkoFlag;
    }

    /**
     * getKyufuRitsu
     * @return kyufuRitsu
     */
    public HokenKyufuRitsu getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * setKyufuRitsu
     * @param kyufuRitsu kyufuRitsu
     */
    public void setKyufuRitsu(HokenKyufuRitsu kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * getShuryoShinsei_UketsukeYMD
     * @return shuryoShinsei_UketsukeYMD
     */
    public FlexibleDate getShuryoShinsei_UketsukeYMD() {
        return shuryoShinsei_UketsukeYMD;
    }

    /**
     * setShuryoShinsei_UketsukeYMD
     * @param shuryoShinsei_UketsukeYMD shuryoShinsei_UketsukeYMD
     */
    public void setShuryoShinsei_UketsukeYMD(FlexibleDate shuryoShinsei_UketsukeYMD) {
        this.shuryoShinsei_UketsukeYMD = shuryoShinsei_UketsukeYMD;
    }

    /**
     * getShuryoShinsei_YMD
     * @return shuryoShinsei_YMD
     */
    public FlexibleDate getShuryoShinsei_YMD() {
        return shuryoShinsei_YMD;
    }

    /**
     * setShuryoShinsei_YMD
     * @param shuryoShinsei_YMD shuryoShinsei_YMD
     */
    public void setShuryoShinsei_YMD(FlexibleDate shuryoShinsei_YMD) {
        this.shuryoShinsei_YMD = shuryoShinsei_YMD;
    }

    /**
     * getShuryoShinsei_RiyuCode
     * @return shuryoShinsei_RiyuCode
     */
    public RString getShuryoShinsei_RiyuCode() {
        return shuryoShinsei_RiyuCode;
    }

    /**
     * setShuryoShinsei_RiyuCode
     * @param shuryoShinsei_RiyuCode shuryoShinsei_RiyuCode
     */
    public void setShuryoShinsei_RiyuCode(RString shuryoShinsei_RiyuCode) {
        this.shuryoShinsei_RiyuCode = shuryoShinsei_RiyuCode;
    }

    /**
     * getShuryoShinsei_ShinsaKetteiYMD
     * @return shuryoShinsei_ShinsaKetteiYMD
     */
    public FlexibleDate getShuryoShinsei_ShinsaKetteiYMD() {
        return shuryoShinsei_ShinsaKetteiYMD;
    }

    /**
     * setShuryoShinsei_ShinsaKetteiYMD
     * @param shuryoShinsei_ShinsaKetteiYMD shuryoShinsei_ShinsaKetteiYMD
     */
    public void setShuryoShinsei_ShinsaKetteiYMD(FlexibleDate shuryoShinsei_ShinsaKetteiYMD) {
        this.shuryoShinsei_ShinsaKetteiYMD = shuryoShinsei_ShinsaKetteiYMD;
    }

    /**
     * getShuryoShinsei_ShinsaKekkaKubun
     * @return shuryoShinsei_ShinsaKekkaKubun
     */
    public RString getShuryoShinsei_ShinsaKekkaKubun() {
        return shuryoShinsei_ShinsaKekkaKubun;
    }

    /**
     * setShuryoShinsei_ShinsaKekkaKubun
     * @param shuryoShinsei_ShinsaKekkaKubun shuryoShinsei_ShinsaKekkaKubun
     */
    public void setShuryoShinsei_ShinsaKekkaKubun(RString shuryoShinsei_ShinsaKekkaKubun) {
        this.shuryoShinsei_ShinsaKekkaKubun = shuryoShinsei_ShinsaKekkaKubun;
    }

    /**
     * getMukoKubun
     * @return mukoKubun
     */
    public boolean getMukoKubun() {
        return mukoKubun;
    }

    /**
     * setMukoKubun
     * @param mukoKubun mukoKubun
     */
    public void setMukoKubun(boolean mukoKubun) {
        this.mukoKubun = mukoKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4021ShiharaiHohoHenkoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4021ShiharaiHohoHenkoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4021ShiharaiHohoHenkoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kanriKubun, other.kanriKubun)) {
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
    public void shallowCopy(DbT4021ShiharaiHohoHenkoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kanriKubun = entity.kanriKubun;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.torokuKubun = entity.torokuKubun;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.shuryoKubun = entity.shuryoKubun;
        this.yokoku_TorokuYMD = entity.yokoku_TorokuYMD;
        this.sashitome_IraiJuriYMD = entity.sashitome_IraiJuriYMD;
        this.yokoku_TsuchiHakkoYMD = entity.yokoku_TsuchiHakkoYMD;
        this.yokoku_TsuchiSaiHakkoFlag = entity.yokoku_TsuchiSaiHakkoFlag;
        this.bemmei_TeishutsuYMD = entity.bemmei_TeishutsuYMD;
        this.bemmei_UketsukeYMD = entity.bemmei_UketsukeYMD;
        this.bemmei_RiyuCode = entity.bemmei_RiyuCode;
        this.bemmei_ShinsaKetteiYMD = entity.bemmei_ShinsaKetteiYMD;
        this.bemmei_ShinsaKekkaKubun = entity.bemmei_ShinsaKekkaKubun;
        this.shokan_KetteiYMD = entity.shokan_KetteiYMD;
        this.shokan_TsuchiHakkoYMD = entity.shokan_TsuchiHakkoYMD;
        this.shokan_TsuchiSaiHakkoFlag = entity.shokan_TsuchiSaiHakkoFlag;
        this.hihokenshaShoTeishutsuYMD = entity.hihokenshaShoTeishutsuYMD;
        this.sashitome_Flag = entity.sashitome_Flag;
        this.sashitome_KetteiYMD = entity.sashitome_KetteiYMD;
        this.sashitome_KaijoYMD = entity.sashitome_KaijoYMD;
        this.gemmen_KetteiYMD = entity.gemmen_KetteiYMD;
        this.gemmen_TsuchiHakkoYMD = entity.gemmen_TsuchiHakkoYMD;
        this.gemmen_TsuchiSaiHakkoFlag = entity.gemmen_TsuchiSaiHakkoFlag;
        this.kyufuRitsu = entity.kyufuRitsu;
        this.shuryoShinsei_UketsukeYMD = entity.shuryoShinsei_UketsukeYMD;
        this.shuryoShinsei_YMD = entity.shuryoShinsei_YMD;
        this.shuryoShinsei_RiyuCode = entity.shuryoShinsei_RiyuCode;
        this.shuryoShinsei_ShinsaKetteiYMD = entity.shuryoShinsei_ShinsaKetteiYMD;
        this.shuryoShinsei_ShinsaKekkaKubun = entity.shuryoShinsei_ShinsaKekkaKubun;
        this.mukoKubun = entity.mukoKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, shoriTimestamp, torokuKubun, tekiyoKaishiYMD, tekiyoShuryoYMD, shuryoKubun, yokoku_TorokuYMD, sashitome_IraiJuriYMD, yokoku_TsuchiHakkoYMD, yokoku_TsuchiSaiHakkoFlag, bemmei_TeishutsuYMD, bemmei_UketsukeYMD, bemmei_RiyuCode, bemmei_ShinsaKetteiYMD, bemmei_ShinsaKekkaKubun, shokan_KetteiYMD, shokan_TsuchiHakkoYMD, shokan_TsuchiSaiHakkoFlag, hihokenshaShoTeishutsuYMD, sashitome_Flag, sashitome_KetteiYMD, sashitome_KaijoYMD, gemmen_KetteiYMD, gemmen_TsuchiHakkoYMD, gemmen_TsuchiSaiHakkoFlag, kyufuRitsu, shuryoShinsei_UketsukeYMD, shuryoShinsei_YMD, shuryoShinsei_RiyuCode, shuryoShinsei_ShinsaKetteiYMD, shuryoShinsei_ShinsaKekkaKubun, mukoKubun);
    }

// </editor-fold>
}
