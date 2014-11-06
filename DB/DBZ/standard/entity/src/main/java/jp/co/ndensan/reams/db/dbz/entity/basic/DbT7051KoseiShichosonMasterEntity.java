package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7051KoseiShichosonMasterの項目定義クラスです
 *
 */
public class DbT7051KoseiShichosonMasterEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7051KoseiShichosonMaster");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shichosonShokibetsuID;
    @PrimaryKey
    private RString shichosonCode;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString kokuhorenKoikiShichosonNo;
    private RString shichosonMeisho;
    private RString todofukenMeisho;
    private RString gunMeisho;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private RString yusenChikuCode;
    private RString tyohyoTodoufukenHyojiUmu;
    private RString tyohyoGunHyojiUmu;
    private RString tyohyoShichosonHyojiUmu;
    private RString tyohyoJushoHenshuHouhou;
    private RString tyohyoKatagakiHyojiUmu;
    private RString gaikokujinHyojiHouhou;
    private RString rojinhokenShichosonNo;
    private RString rokenJukyushaNoTaikei;
    private FlexibleDate ikoYMD;
    private FlexibleDate kanyuYMD;
    private FlexibleDate ridatsuYMD;
    private RString gappeiKyuShichosonKubun;
    private RString gappeiKyuShichosonHyojiUmu;
    private RString gappeiLinkNo;
    private ShoKisaiHokenshaNo unyoHokenshaNo;
    private FlexibleDate unyoKaishiYMD;
    private FlexibleDate unyoShuryoYMD;
    private RString unyoKeitaiKubun;

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
     * getShichosonShokibetsuID
     *
     * @return shichosonShokibetsuID
     */
    public RString getShichosonShokibetsuID() {
        return shichosonShokibetsuID;
    }

    /**
     * setShichosonShokibetsuID
     *
     * @param shichosonShokibetsuID shichosonShokibetsuID
     */
    public void setShichosonShokibetsuID(RString shichosonShokibetsuID) {
        this.shichosonShokibetsuID = shichosonShokibetsuID;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public RString getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
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
     * getKokuhorenKoikiShichosonNo
     *
     * @return kokuhorenKoikiShichosonNo
     */
    public RString getKokuhorenKoikiShichosonNo() {
        return kokuhorenKoikiShichosonNo;
    }

    /**
     * setKokuhorenKoikiShichosonNo
     *
     * @param kokuhorenKoikiShichosonNo kokuhorenKoikiShichosonNo
     */
    public void setKokuhorenKoikiShichosonNo(RString kokuhorenKoikiShichosonNo) {
        this.kokuhorenKoikiShichosonNo = kokuhorenKoikiShichosonNo;
    }

    /**
     * getShichosonMeisho
     *
     * @return shichosonMeisho
     */
    public RString getShichosonMeisho() {
        return shichosonMeisho;
    }

    /**
     * setShichosonMeisho
     *
     * @param shichosonMeisho shichosonMeisho
     */
    public void setShichosonMeisho(RString shichosonMeisho) {
        this.shichosonMeisho = shichosonMeisho;
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
     * getJusho
     *
     * @return jusho
     */
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * setJusho
     *
     * @param jusho jusho
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
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
     * getYusenChikuCode
     *
     * @return yusenChikuCode
     */
    public RString getYusenChikuCode() {
        return yusenChikuCode;
    }

    /**
     * setYusenChikuCode
     *
     * @param yusenChikuCode yusenChikuCode
     */
    public void setYusenChikuCode(RString yusenChikuCode) {
        this.yusenChikuCode = yusenChikuCode;
    }

    /**
     * getTyohyoTodoufukenHyojiUmu
     *
     * @return tyohyoTodoufukenHyojiUmu
     */
    public RString getTyohyoTodoufukenHyojiUmu() {
        return tyohyoTodoufukenHyojiUmu;
    }

    /**
     * setTyohyoTodoufukenHyojiUmu
     *
     * @param tyohyoTodoufukenHyojiUmu tyohyoTodoufukenHyojiUmu
     */
    public void setTyohyoTodoufukenHyojiUmu(RString tyohyoTodoufukenHyojiUmu) {
        this.tyohyoTodoufukenHyojiUmu = tyohyoTodoufukenHyojiUmu;
    }

    /**
     * getTyohyoGunHyojiUmu
     *
     * @return tyohyoGunHyojiUmu
     */
    public RString getTyohyoGunHyojiUmu() {
        return tyohyoGunHyojiUmu;
    }

    /**
     * setTyohyoGunHyojiUmu
     *
     * @param tyohyoGunHyojiUmu tyohyoGunHyojiUmu
     */
    public void setTyohyoGunHyojiUmu(RString tyohyoGunHyojiUmu) {
        this.tyohyoGunHyojiUmu = tyohyoGunHyojiUmu;
    }

    /**
     * getTyohyoShichosonHyojiUmu
     *
     * @return tyohyoShichosonHyojiUmu
     */
    public RString getTyohyoShichosonHyojiUmu() {
        return tyohyoShichosonHyojiUmu;
    }

    /**
     * setTyohyoShichosonHyojiUmu
     *
     * @param tyohyoShichosonHyojiUmu tyohyoShichosonHyojiUmu
     */
    public void setTyohyoShichosonHyojiUmu(RString tyohyoShichosonHyojiUmu) {
        this.tyohyoShichosonHyojiUmu = tyohyoShichosonHyojiUmu;
    }

    /**
     * getTyohyoJushoHenshuHouhou
     *
     * @return tyohyoJushoHenshuHouhou
     */
    public RString getTyohyoJushoHenshuHouhou() {
        return tyohyoJushoHenshuHouhou;
    }

    /**
     * setTyohyoJushoHenshuHouhou
     *
     * @param tyohyoJushoHenshuHouhou tyohyoJushoHenshuHouhou
     */
    public void setTyohyoJushoHenshuHouhou(RString tyohyoJushoHenshuHouhou) {
        this.tyohyoJushoHenshuHouhou = tyohyoJushoHenshuHouhou;
    }

    /**
     * getTyohyoKatagakiHyojiUmu
     *
     * @return tyohyoKatagakiHyojiUmu
     */
    public RString getTyohyoKatagakiHyojiUmu() {
        return tyohyoKatagakiHyojiUmu;
    }

    /**
     * setTyohyoKatagakiHyojiUmu
     *
     * @param tyohyoKatagakiHyojiUmu tyohyoKatagakiHyojiUmu
     */
    public void setTyohyoKatagakiHyojiUmu(RString tyohyoKatagakiHyojiUmu) {
        this.tyohyoKatagakiHyojiUmu = tyohyoKatagakiHyojiUmu;
    }

    /**
     * getGaikokujinHyojiHouhou
     *
     * @return gaikokujinHyojiHouhou
     */
    public RString getGaikokujinHyojiHouhou() {
        return gaikokujinHyojiHouhou;
    }

    /**
     * setGaikokujinHyojiHouhou
     *
     * @param gaikokujinHyojiHouhou gaikokujinHyojiHouhou
     */
    public void setGaikokujinHyojiHouhou(RString gaikokujinHyojiHouhou) {
        this.gaikokujinHyojiHouhou = gaikokujinHyojiHouhou;
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
     * getIkoYMD
     *
     * @return ikoYMD
     */
    public FlexibleDate getIkoYMD() {
        return ikoYMD;
    }

    /**
     * setIkoYMD
     *
     * @param ikoYMD ikoYMD
     */
    public void setIkoYMD(FlexibleDate ikoYMD) {
        this.ikoYMD = ikoYMD;
    }

    /**
     * getKanyuYMD
     *
     * @return kanyuYMD
     */
    public FlexibleDate getKanyuYMD() {
        return kanyuYMD;
    }

    /**
     * setKanyuYMD
     *
     * @param kanyuYMD kanyuYMD
     */
    public void setKanyuYMD(FlexibleDate kanyuYMD) {
        this.kanyuYMD = kanyuYMD;
    }

    /**
     * getRidatsuYMD
     *
     * @return ridatsuYMD
     */
    public FlexibleDate getRidatsuYMD() {
        return ridatsuYMD;
    }

    /**
     * setRidatsuYMD
     *
     * @param ridatsuYMD ridatsuYMD
     */
    public void setRidatsuYMD(FlexibleDate ridatsuYMD) {
        this.ridatsuYMD = ridatsuYMD;
    }

    /**
     * getGappeiKyuShichosonKubun
     *
     * @return gappeiKyuShichosonKubun
     */
    public RString getGappeiKyuShichosonKubun() {
        return gappeiKyuShichosonKubun;
    }

    /**
     * setGappeiKyuShichosonKubun
     *
     * @param gappeiKyuShichosonKubun gappeiKyuShichosonKubun
     */
    public void setGappeiKyuShichosonKubun(RString gappeiKyuShichosonKubun) {
        this.gappeiKyuShichosonKubun = gappeiKyuShichosonKubun;
    }

    /**
     * getGappeiKyuShichosonHyojiUmu
     *
     * @return gappeiKyuShichosonHyojiUmu
     */
    public RString getGappeiKyuShichosonHyojiUmu() {
        return gappeiKyuShichosonHyojiUmu;
    }

    /**
     * setGappeiKyuShichosonHyojiUmu
     *
     * @param gappeiKyuShichosonHyojiUmu gappeiKyuShichosonHyojiUmu
     */
    public void setGappeiKyuShichosonHyojiUmu(RString gappeiKyuShichosonHyojiUmu) {
        this.gappeiKyuShichosonHyojiUmu = gappeiKyuShichosonHyojiUmu;
    }

    /**
     * getGappeiLinkNo
     *
     * @return gappeiLinkNo
     */
    public RString getGappeiLinkNo() {
        return gappeiLinkNo;
    }

    /**
     * setGappeiLinkNo
     *
     * @param gappeiLinkNo gappeiLinkNo
     */
    public void setGappeiLinkNo(RString gappeiLinkNo) {
        this.gappeiLinkNo = gappeiLinkNo;
    }

    /**
     * getUnyoHokenshaNo
     *
     * @return unyoHokenshaNo
     */
    public ShoKisaiHokenshaNo getUnyoHokenshaNo() {
        return unyoHokenshaNo;
    }

    /**
     * setUnyoHokenshaNo
     *
     * @param unyoHokenshaNo unyoHokenshaNo
     */
    public void setUnyoHokenshaNo(ShoKisaiHokenshaNo unyoHokenshaNo) {
        this.unyoHokenshaNo = unyoHokenshaNo;
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
     * getUnyoKeitaiKubun
     *
     * @return unyoKeitaiKubun
     */
    public RString getUnyoKeitaiKubun() {
        return unyoKeitaiKubun;
    }

    /**
     * setUnyoKeitaiKubun
     *
     * @param unyoKeitaiKubun unyoKeitaiKubun
     */
    public void setUnyoKeitaiKubun(RString unyoKeitaiKubun) {
        this.unyoKeitaiKubun = unyoKeitaiKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7051KoseiShichosonMasterEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7051KoseiShichosonMasterEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT7051KoseiShichosonMasterEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonShokibetsuID, other.shichosonShokibetsuID)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        return true;
    }

// </editor-fold>
}
