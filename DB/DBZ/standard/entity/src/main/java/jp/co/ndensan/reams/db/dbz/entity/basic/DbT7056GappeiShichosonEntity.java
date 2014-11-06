package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7056GappeiShichosonの項目定義クラスです
 *
 */
public class DbT7056GappeiShichosonEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7056GappeiShichoson");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate gappeiYMD;
    @PrimaryKey
    private RString chiikiNo;
    @PrimaryKey
    private RString kyuShichosonCode;
    private FlexibleDate unyoKaishiYMD;
    private FlexibleDate unyoShuryoYMD;
    private ShoKisaiHokenshaNo kyuHokenshaNo;
    private RString kyuShichosonMeisho;
    private RString todofukenMeisho;
    private RString gunMeisho;
    private YubinNo yubinNo;
    private TelNo telNo;
    private RString rojinhokenShichosonNo;
    private RString rokenJukyushaNoTaikei;
    private RString hyojiUmu;

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
     * getGappeiYMD
     *
     * @return gappeiYMD
     */
    public FlexibleDate getGappeiYMD() {
        return gappeiYMD;
    }

    /**
     * setGappeiYMD
     *
     * @param gappeiYMD gappeiYMD
     */
    public void setGappeiYMD(FlexibleDate gappeiYMD) {
        this.gappeiYMD = gappeiYMD;
    }

    /**
     * getChiikiNo
     *
     * @return chiikiNo
     */
    public RString getChiikiNo() {
        return chiikiNo;
    }

    /**
     * setChiikiNo
     *
     * @param chiikiNo chiikiNo
     */
    public void setChiikiNo(RString chiikiNo) {
        this.chiikiNo = chiikiNo;
    }

    /**
     * getKyuShichosonCode
     *
     * @return kyuShichosonCode
     */
    public RString getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    /**
     * setKyuShichosonCode
     *
     * @param kyuShichosonCode kyuShichosonCode
     */
    public void setKyuShichosonCode(RString kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    /**
     * getUnyoKaishiYMD
     *
     * @return unyoKaishiYMD
     */
    public FlexibleDate getUnyoKaishiYMD() {
        return unyoKaishiYMD;
    }

    /**
     * setUnyoKaishiYMD
     *
     * @param unyoKaishiYMD unyoKaishiYMD
     */
    public void setUnyoKaishiYMD(FlexibleDate unyoKaishiYMD) {
        this.unyoKaishiYMD = unyoKaishiYMD;
    }

    /**
     * getUnyoShuryoYMD
     *
     * @return unyoShuryoYMD
     */
    public FlexibleDate getUnyoShuryoYMD() {
        return unyoShuryoYMD;
    }

    /**
     * setUnyoShuryoYMD
     *
     * @param unyoShuryoYMD unyoShuryoYMD
     */
    public void setUnyoShuryoYMD(FlexibleDate unyoShuryoYMD) {
        this.unyoShuryoYMD = unyoShuryoYMD;
    }

    /**
     * getKyuHokenshaNo
     *
     * @return kyuHokenshaNo
     */
    public ShoKisaiHokenshaNo getKyuHokenshaNo() {
        return kyuHokenshaNo;
    }

    /**
     * setKyuHokenshaNo
     *
     * @param kyuHokenshaNo kyuHokenshaNo
     */
    public void setKyuHokenshaNo(ShoKisaiHokenshaNo kyuHokenshaNo) {
        this.kyuHokenshaNo = kyuHokenshaNo;
    }

    /**
     * getKyuShichosonMeisho
     *
     * @return kyuShichosonMeisho
     */
    public RString getKyuShichosonMeisho() {
        return kyuShichosonMeisho;
    }

    /**
     * setKyuShichosonMeisho
     *
     * @param kyuShichosonMeisho kyuShichosonMeisho
     */
    public void setKyuShichosonMeisho(RString kyuShichosonMeisho) {
        this.kyuShichosonMeisho = kyuShichosonMeisho;
    }

    /**
     * getTodofukenMeisho
     *
     * @return todofukenMeisho
     */
    public RString getTodofukenMeisho() {
        return todofukenMeisho;
    }

    /**
     * setTodofukenMeisho
     *
     * @param todofukenMeisho todofukenMeisho
     */
    public void setTodofukenMeisho(RString todofukenMeisho) {
        this.todofukenMeisho = todofukenMeisho;
    }

    /**
     * getGunMeisho
     *
     * @return gunMeisho
     */
    public RString getGunMeisho() {
        return gunMeisho;
    }

    /**
     * setGunMeisho
     *
     * @param gunMeisho gunMeisho
     */
    public void setGunMeisho(RString gunMeisho) {
        this.gunMeisho = gunMeisho;
    }

    /**
     * getYubinNo
     *
     * @return yubinNo
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * setYubinNo
     *
     * @param yubinNo yubinNo
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * getTelNo
     *
     * @return telNo
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * setTelNo
     *
     * @param telNo telNo
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * getRojinhokenShichosonNo
     *
     * @return rojinhokenShichosonNo
     */
    public RString getRojinhokenShichosonNo() {
        return rojinhokenShichosonNo;
    }

    /**
     * setRojinhokenShichosonNo
     *
     * @param rojinhokenShichosonNo rojinhokenShichosonNo
     */
    public void setRojinhokenShichosonNo(RString rojinhokenShichosonNo) {
        this.rojinhokenShichosonNo = rojinhokenShichosonNo;
    }

    /**
     * getRokenJukyushaNoTaikei
     *
     * @return rokenJukyushaNoTaikei
     */
    public RString getRokenJukyushaNoTaikei() {
        return rokenJukyushaNoTaikei;
    }

    /**
     * setRokenJukyushaNoTaikei
     *
     * @param rokenJukyushaNoTaikei rokenJukyushaNoTaikei
     */
    public void setRokenJukyushaNoTaikei(RString rokenJukyushaNoTaikei) {
        this.rokenJukyushaNoTaikei = rokenJukyushaNoTaikei;
    }

    /**
     * getHyojiUmu
     *
     * @return hyojiUmu
     */
    public RString getHyojiUmu() {
        return hyojiUmu;
    }

    /**
     * setHyojiUmu
     *
     * @param hyojiUmu hyojiUmu
     */
    public void setHyojiUmu(RString hyojiUmu) {
        this.hyojiUmu = hyojiUmu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7056GappeiShichosonEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7056GappeiShichosonEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT7056GappeiShichosonEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.gappeiYMD, other.gappeiYMD)) {
            return false;
        }
        if (!Objects.equals(this.chiikiNo, other.chiikiNo)) {
            return false;
        }
        if (!Objects.equals(this.kyuShichosonCode, other.kyuShichosonCode)) {
            return false;
        }
        return true;
    }

// </editor-fold>
}
