package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7001FufukuMoshitateの項目定義クラスです
 *
 */
public class DbT7001FufukuMoshitateEntity extends DbTableEntityBase<DbT7001FufukuMoshitateEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7001FufukuMoshitate");

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
    private HihokenshaNo genshobunsHihokennshaNo;
    @PrimaryKey
    private FlexibleDate shinsaSeikyuTodokedeYMD;
    private YubinNo genshobunHihokenshaYubinNo;
    private AtenaJusho genshobunHihokenshaJusho;
    private AtenaMeisho genshobunHihokenshaShimei;
    private TelNo genshobunHihokenshaTelNo;
    private FlexibleDate genshobunHihokenshaBirthYMD;
    private YubinNo shinsaSeikyuninYubinNo;
    private AtenaJusho shinsaSeikyuninJusho;
    private AtenaMeisho shinsaSeikyuninShimei;
    private TelNo shinsaSeikyuninTelNo;
    private Code hihokenshaTonoKankeiCode;
    private YubinNo dairininYubinNo;
    private AtenaJusho dairininJusho;
    private AtenaMeisho dairininShimei;
    private TelNo dairininTelNo;
    private RString shobunCho;
    private FlexibleDate shobunYMD;
    private Code shobunShuruiCode;
    private FlexibleDate shobunKakuninYMD;
    private RString shinsaSeikyuRiyu;
    private RString shobunChoKyojiNaiyo;
    private boolean tempuShoruiTo;
    private FlexibleDate shinsaSeikyuTorisageYMD;
    private boolean bemmeishoTorokuFlag;
    private FlexibleDate bemmeishoSakuseiYMD;
    private FlexibleDate saiketsuYMD;
    private RString saiketsuKekka;
    private RString saiketsuRiyu;

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
     * getGenshobunsHihokennshaNo
     *
     * @return genshobunsHihokennshaNo
     */
    public HihokenshaNo getGenshobunsHihokennshaNo() {
        return genshobunsHihokennshaNo;
    }

    /**
     * setGenshobunsHihokennshaNo
     *
     * @param genshobunsHihokennshaNo genshobunsHihokennshaNo
     */
    public void setGenshobunsHihokennshaNo(HihokenshaNo genshobunsHihokennshaNo) {
        this.genshobunsHihokennshaNo = genshobunsHihokennshaNo;
    }

    /**
     * getShinsaSeikyuTodokedeYMD
     *
     * @return shinsaSeikyuTodokedeYMD
     */
    public FlexibleDate getShinsaSeikyuTodokedeYMD() {
        return shinsaSeikyuTodokedeYMD;
    }

    /**
     * setShinsaSeikyuTodokedeYMD
     *
     * @param shinsaSeikyuTodokedeYMD shinsaSeikyuTodokedeYMD
     */
    public void setShinsaSeikyuTodokedeYMD(FlexibleDate shinsaSeikyuTodokedeYMD) {
        this.shinsaSeikyuTodokedeYMD = shinsaSeikyuTodokedeYMD;
    }

    /**
     * getGenshobunHihokenshaYubinNo
     *
     * @return genshobunHihokenshaYubinNo
     */
    public YubinNo getGenshobunHihokenshaYubinNo() {
        return genshobunHihokenshaYubinNo;
    }

    /**
     * setGenshobunHihokenshaYubinNo
     *
     * @param genshobunHihokenshaYubinNo genshobunHihokenshaYubinNo
     */
    public void setGenshobunHihokenshaYubinNo(YubinNo genshobunHihokenshaYubinNo) {
        this.genshobunHihokenshaYubinNo = genshobunHihokenshaYubinNo;
    }

    /**
     * getGenshobunHihokenshaJusho
     *
     * @return genshobunHihokenshaJusho
     */
    public AtenaJusho getGenshobunHihokenshaJusho() {
        return genshobunHihokenshaJusho;
    }

    /**
     * setGenshobunHihokenshaJusho
     *
     * @param genshobunHihokenshaJusho genshobunHihokenshaJusho
     */
    public void setGenshobunHihokenshaJusho(AtenaJusho genshobunHihokenshaJusho) {
        this.genshobunHihokenshaJusho = genshobunHihokenshaJusho;
    }

    /**
     * getGenshobunHihokenshaShimei
     *
     * @return genshobunHihokenshaShimei
     */
    public AtenaMeisho getGenshobunHihokenshaShimei() {
        return genshobunHihokenshaShimei;
    }

    /**
     * setGenshobunHihokenshaShimei
     *
     * @param genshobunHihokenshaShimei genshobunHihokenshaShimei
     */
    public void setGenshobunHihokenshaShimei(AtenaMeisho genshobunHihokenshaShimei) {
        this.genshobunHihokenshaShimei = genshobunHihokenshaShimei;
    }

    /**
     * getGenshobunHihokenshaTelNo
     *
     * @return genshobunHihokenshaTelNo
     */
    public TelNo getGenshobunHihokenshaTelNo() {
        return genshobunHihokenshaTelNo;
    }

    /**
     * setGenshobunHihokenshaTelNo
     *
     * @param genshobunHihokenshaTelNo genshobunHihokenshaTelNo
     */
    public void setGenshobunHihokenshaTelNo(TelNo genshobunHihokenshaTelNo) {
        this.genshobunHihokenshaTelNo = genshobunHihokenshaTelNo;
    }

    /**
     * getGenshobunHihokenshaBirthYMD
     *
     * @return genshobunHihokenshaBirthYMD
     */
    public FlexibleDate getGenshobunHihokenshaBirthYMD() {
        return genshobunHihokenshaBirthYMD;
    }

    /**
     * setGenshobunHihokenshaBirthYMD
     *
     * @param genshobunHihokenshaBirthYMD genshobunHihokenshaBirthYMD
     */
    public void setGenshobunHihokenshaBirthYMD(FlexibleDate genshobunHihokenshaBirthYMD) {
        this.genshobunHihokenshaBirthYMD = genshobunHihokenshaBirthYMD;
    }

    /**
     * getShinsaSeikyuninYubinNo
     *
     * @return shinsaSeikyuninYubinNo
     */
    public YubinNo getShinsaSeikyuninYubinNo() {
        return shinsaSeikyuninYubinNo;
    }

    /**
     * setShinsaSeikyuninYubinNo
     *
     * @param shinsaSeikyuninYubinNo shinsaSeikyuninYubinNo
     */
    public void setShinsaSeikyuninYubinNo(YubinNo shinsaSeikyuninYubinNo) {
        this.shinsaSeikyuninYubinNo = shinsaSeikyuninYubinNo;
    }

    /**
     * getShinsaSeikyuninJusho
     *
     * @return shinsaSeikyuninJusho
     */
    public AtenaJusho getShinsaSeikyuninJusho() {
        return shinsaSeikyuninJusho;
    }

    /**
     * setShinsaSeikyuninJusho
     *
     * @param shinsaSeikyuninJusho shinsaSeikyuninJusho
     */
    public void setShinsaSeikyuninJusho(AtenaJusho shinsaSeikyuninJusho) {
        this.shinsaSeikyuninJusho = shinsaSeikyuninJusho;
    }

    /**
     * getShinsaSeikyuninShimei
     *
     * @return shinsaSeikyuninShimei
     */
    public AtenaMeisho getShinsaSeikyuninShimei() {
        return shinsaSeikyuninShimei;
    }

    /**
     * setShinsaSeikyuninShimei
     *
     * @param shinsaSeikyuninShimei shinsaSeikyuninShimei
     */
    public void setShinsaSeikyuninShimei(AtenaMeisho shinsaSeikyuninShimei) {
        this.shinsaSeikyuninShimei = shinsaSeikyuninShimei;
    }

    /**
     * getShinsaSeikyuninTelNo
     *
     * @return shinsaSeikyuninTelNo
     */
    public TelNo getShinsaSeikyuninTelNo() {
        return shinsaSeikyuninTelNo;
    }

    /**
     * setShinsaSeikyuninTelNo
     *
     * @param shinsaSeikyuninTelNo shinsaSeikyuninTelNo
     */
    public void setShinsaSeikyuninTelNo(TelNo shinsaSeikyuninTelNo) {
        this.shinsaSeikyuninTelNo = shinsaSeikyuninTelNo;
    }

    /**
     * getHihokenshaTonoKankeiCode
     *
     * @return hihokenshaTonoKankeiCode
     */
    public Code getHihokenshaTonoKankeiCode() {
        return hihokenshaTonoKankeiCode;
    }

    /**
     * setHihokenshaTonoKankeiCode
     *
     * @param hihokenshaTonoKankeiCode hihokenshaTonoKankeiCode
     */
    public void setHihokenshaTonoKankeiCode(Code hihokenshaTonoKankeiCode) {
        this.hihokenshaTonoKankeiCode = hihokenshaTonoKankeiCode;
    }

    /**
     * getDairininYubinNo
     *
     * @return dairininYubinNo
     */
    public YubinNo getDairininYubinNo() {
        return dairininYubinNo;
    }

    /**
     * setDairininYubinNo
     *
     * @param dairininYubinNo dairininYubinNo
     */
    public void setDairininYubinNo(YubinNo dairininYubinNo) {
        this.dairininYubinNo = dairininYubinNo;
    }

    /**
     * getDairininJusho
     *
     * @return dairininJusho
     */
    public AtenaJusho getDairininJusho() {
        return dairininJusho;
    }

    /**
     * setDairininJusho
     *
     * @param dairininJusho dairininJusho
     */
    public void setDairininJusho(AtenaJusho dairininJusho) {
        this.dairininJusho = dairininJusho;
    }

    /**
     * getDairininShimei
     *
     * @return dairininShimei
     */
    public AtenaMeisho getDairininShimei() {
        return dairininShimei;
    }

    /**
     * setDairininShimei
     *
     * @param dairininShimei dairininShimei
     */
    public void setDairininShimei(AtenaMeisho dairininShimei) {
        this.dairininShimei = dairininShimei;
    }

    /**
     * getDairininTelNo
     *
     * @return dairininTelNo
     */
    public TelNo getDairininTelNo() {
        return dairininTelNo;
    }

    /**
     * setDairininTelNo
     *
     * @param dairininTelNo dairininTelNo
     */
    public void setDairininTelNo(TelNo dairininTelNo) {
        this.dairininTelNo = dairininTelNo;
    }

    /**
     * getShobunCho
     *
     * @return shobunCho
     */
    public RString getShobunCho() {
        return shobunCho;
    }

    /**
     * setShobunCho
     *
     * @param shobunCho shobunCho
     */
    public void setShobunCho(RString shobunCho) {
        this.shobunCho = shobunCho;
    }

    /**
     * getShobunYMD
     *
     * @return shobunYMD
     */
    public FlexibleDate getShobunYMD() {
        return shobunYMD;
    }

    /**
     * setShobunYMD
     *
     * @param shobunYMD shobunYMD
     */
    public void setShobunYMD(FlexibleDate shobunYMD) {
        this.shobunYMD = shobunYMD;
    }

    /**
     * getShobunShuruiCode
     *
     * @return shobunShuruiCode
     */
    public Code getShobunShuruiCode() {
        return shobunShuruiCode;
    }

    /**
     * setShobunShuruiCode
     *
     * @param shobunShuruiCode shobunShuruiCode
     */
    public void setShobunShuruiCode(Code shobunShuruiCode) {
        this.shobunShuruiCode = shobunShuruiCode;
    }

    /**
     * getShobunKakuninYMD
     *
     * @return shobunKakuninYMD
     */
    public FlexibleDate getShobunKakuninYMD() {
        return shobunKakuninYMD;
    }

    /**
     * setShobunKakuninYMD
     *
     * @param shobunKakuninYMD shobunKakuninYMD
     */
    public void setShobunKakuninYMD(FlexibleDate shobunKakuninYMD) {
        this.shobunKakuninYMD = shobunKakuninYMD;
    }

    /**
     * getShinsaSeikyuRiyu
     *
     * @return shinsaSeikyuRiyu
     */
    public RString getShinsaSeikyuRiyu() {
        return shinsaSeikyuRiyu;
    }

    /**
     * setShinsaSeikyuRiyu
     *
     * @param shinsaSeikyuRiyu shinsaSeikyuRiyu
     */
    public void setShinsaSeikyuRiyu(RString shinsaSeikyuRiyu) {
        this.shinsaSeikyuRiyu = shinsaSeikyuRiyu;
    }

    /**
     * getShobunChoKyojiNaiyo
     *
     * @return shobunChoKyojiNaiyo
     */
    public RString getShobunChoKyojiNaiyo() {
        return shobunChoKyojiNaiyo;
    }

    /**
     * setShobunChoKyojiNaiyo
     *
     * @param shobunChoKyojiNaiyo shobunChoKyojiNaiyo
     */
    public void setShobunChoKyojiNaiyo(RString shobunChoKyojiNaiyo) {
        this.shobunChoKyojiNaiyo = shobunChoKyojiNaiyo;
    }

    /**
     * getTempuShoruiTo
     *
     * @return tempuShoruiTo
     */
    public boolean getTempuShoruiTo() {
        return tempuShoruiTo;
    }

    /**
     * setTempuShoruiTo
     *
     * @param tempuShoruiTo tempuShoruiTo
     */
    public void setTempuShoruiTo(boolean tempuShoruiTo) {
        this.tempuShoruiTo = tempuShoruiTo;
    }

    /**
     * getShinsaSeikyuTorisageYMD
     *
     * @return shinsaSeikyuTorisageYMD
     */
    public FlexibleDate getShinsaSeikyuTorisageYMD() {
        return shinsaSeikyuTorisageYMD;
    }

    /**
     * setShinsaSeikyuTorisageYMD
     *
     * @param shinsaSeikyuTorisageYMD shinsaSeikyuTorisageYMD
     */
    public void setShinsaSeikyuTorisageYMD(FlexibleDate shinsaSeikyuTorisageYMD) {
        this.shinsaSeikyuTorisageYMD = shinsaSeikyuTorisageYMD;
    }

    /**
     * getBemmeishoTorokuFlag
     *
     * @return bemmeishoTorokuFlag
     */
    public boolean getBemmeishoTorokuFlag() {
        return bemmeishoTorokuFlag;
    }

    /**
     * setBemmeishoTorokuFlag
     *
     * @param bemmeishoTorokuFlag bemmeishoTorokuFlag
     */
    public void setBemmeishoTorokuFlag(boolean bemmeishoTorokuFlag) {
        this.bemmeishoTorokuFlag = bemmeishoTorokuFlag;
    }

    /**
     * getBemmeishoSakuseiYMD
     *
     * @return bemmeishoSakuseiYMD
     */
    public FlexibleDate getBemmeishoSakuseiYMD() {
        return bemmeishoSakuseiYMD;
    }

    /**
     * setBemmeishoSakuseiYMD
     *
     * @param bemmeishoSakuseiYMD bemmeishoSakuseiYMD
     */
    public void setBemmeishoSakuseiYMD(FlexibleDate bemmeishoSakuseiYMD) {
        this.bemmeishoSakuseiYMD = bemmeishoSakuseiYMD;
    }

    /**
     * getSaiketsuYMD
     *
     * @return saiketsuYMD
     */
    public FlexibleDate getSaiketsuYMD() {
        return saiketsuYMD;
    }

    /**
     * setSaiketsuYMD
     *
     * @param saiketsuYMD saiketsuYMD
     */
    public void setSaiketsuYMD(FlexibleDate saiketsuYMD) {
        this.saiketsuYMD = saiketsuYMD;
    }

    /**
     * getSaiketsuKekka
     *
     * @return saiketsuKekka
     */
    public RString getSaiketsuKekka() {
        return saiketsuKekka;
    }

    /**
     * setSaiketsuKekka
     *
     * @param saiketsuKekka saiketsuKekka
     */
    public void setSaiketsuKekka(RString saiketsuKekka) {
        this.saiketsuKekka = saiketsuKekka;
    }

    /**
     * getSaiketsuRiyu
     *
     * @return saiketsuRiyu
     */
    public RString getSaiketsuRiyu() {
        return saiketsuRiyu;
    }

    /**
     * setSaiketsuRiyu
     *
     * @param saiketsuRiyu saiketsuRiyu
     */
    public void setSaiketsuRiyu(RString saiketsuRiyu) {
        this.saiketsuRiyu = saiketsuRiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7001FufukuMoshitateEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7001FufukuMoshitateEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7001FufukuMoshitateEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.genshobunsHihokennshaNo, other.genshobunsHihokennshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinsaSeikyuTodokedeYMD, other.shinsaSeikyuTodokedeYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7001FufukuMoshitateEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.genshobunsHihokennshaNo = entity.genshobunsHihokennshaNo;
        this.shinsaSeikyuTodokedeYMD = entity.shinsaSeikyuTodokedeYMD;
        this.genshobunHihokenshaYubinNo = entity.genshobunHihokenshaYubinNo;
        this.genshobunHihokenshaJusho = entity.genshobunHihokenshaJusho;
        this.genshobunHihokenshaShimei = entity.genshobunHihokenshaShimei;
        this.genshobunHihokenshaTelNo = entity.genshobunHihokenshaTelNo;
        this.genshobunHihokenshaBirthYMD = entity.genshobunHihokenshaBirthYMD;
        this.shinsaSeikyuninYubinNo = entity.shinsaSeikyuninYubinNo;
        this.shinsaSeikyuninJusho = entity.shinsaSeikyuninJusho;
        this.shinsaSeikyuninShimei = entity.shinsaSeikyuninShimei;
        this.shinsaSeikyuninTelNo = entity.shinsaSeikyuninTelNo;
        this.hihokenshaTonoKankeiCode = entity.hihokenshaTonoKankeiCode;
        this.dairininYubinNo = entity.dairininYubinNo;
        this.dairininJusho = entity.dairininJusho;
        this.dairininShimei = entity.dairininShimei;
        this.dairininTelNo = entity.dairininTelNo;
        this.shobunCho = entity.shobunCho;
        this.shobunYMD = entity.shobunYMD;
        this.shobunShuruiCode = entity.shobunShuruiCode;
        this.shobunKakuninYMD = entity.shobunKakuninYMD;
        this.shinsaSeikyuRiyu = entity.shinsaSeikyuRiyu;
        this.shobunChoKyojiNaiyo = entity.shobunChoKyojiNaiyo;
        this.tempuShoruiTo = entity.tempuShoruiTo;
        this.shinsaSeikyuTorisageYMD = entity.shinsaSeikyuTorisageYMD;
        this.bemmeishoTorokuFlag = entity.bemmeishoTorokuFlag;
        this.bemmeishoSakuseiYMD = entity.bemmeishoSakuseiYMD;
        this.saiketsuYMD = entity.saiketsuYMD;
        this.saiketsuKekka = entity.saiketsuKekka;
        this.saiketsuRiyu = entity.saiketsuRiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, shikibetsuCode, genshobunsHihokennshaNo, shinsaSeikyuTodokedeYMD, genshobunHihokenshaYubinNo, genshobunHihokenshaJusho, genshobunHihokenshaShimei, genshobunHihokenshaTelNo, genshobunHihokenshaBirthYMD, shinsaSeikyuninYubinNo, shinsaSeikyuninJusho, shinsaSeikyuninShimei, shinsaSeikyuninTelNo, hihokenshaTonoKankeiCode, dairininYubinNo, dairininJusho, dairininShimei, dairininTelNo, shobunCho, shobunYMD, shobunShuruiCode, shobunKakuninYMD, shinsaSeikyuRiyu, shobunChoKyojiNaiyo, tempuShoruiTo, shinsaSeikyuTorisageYMD, bemmeishoTorokuFlag, bemmeishoSakuseiYMD, saiketsuYMD, saiketsuKekka, saiketsuRiyu);
    }

// </editor-fold>
}
