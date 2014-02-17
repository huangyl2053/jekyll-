package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang._UUID;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * DbT5001NinteiShinseiJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5001NinteiShinseiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5001NinteiShinseiJoho");
    private RString insertDantaiCd = RString.EMPTY;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId = RString.EMPTY;
    private _UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId = RString.EMPTY;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    private ShichosonCode shichosonCode;
    private RString shishoCode;
    private KaigoHihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate ninteiShinseiYMD;
    private EdabanCode ninteiShinseiEdabanCode;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code ninteiShinseiHoreiKubunCode;
    private Code ninteiShinseiYukoKubunCode;
    private RString shienShinseiKubun;
    private RString shinseiRiyu;
    private Code zenYokaigoKubunCode;
    private int zenYukoKikan;
    private boolean johoteikyoDouiUmuKubun;
    private int ninteichosaIraiRirekiNo;
    private int ikenshoIraiRirekiNo;
    private RString minashiCode;
    private boolean enkitsuchiDoiUmuKubun;
    private boolean shisetsuNyushoUmuKubun;
    private RString sichosonRenrakuJiko;
    private Code torisageKubunCode;
    private RString torisageRiyu;
    private FlexibleDate torisageYMD;
    private boolean shinsaKeizokuKubun;

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
     * getShinseishoKanriNo
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public ShichosonCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(ShichosonCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getShishoCode
     *
     * @return shishoCode
     */
    public RString getShishoCode() {
        return shishoCode;
    }

    /**
     * setShishoCode
     *
     * @param shishoCode shishoCode
     */
    public void setShishoCode(RString shishoCode) {
        this.shishoCode = shishoCode;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public KaigoHihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(KaigoHihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
     * getNinteiShinseiYMD
     *
     * @return ninteiShinseiYMD
     */
    public FlexibleDate getNinteiShinseiYMD() {
        return ninteiShinseiYMD;
    }

    /**
     * setNinteiShinseiYMD
     *
     * @param ninteiShinseiYMD ninteiShinseiYMD
     */
    public void setNinteiShinseiYMD(FlexibleDate ninteiShinseiYMD) {
        this.ninteiShinseiYMD = ninteiShinseiYMD;
    }

    /**
     * getNinteiShinseiEdabanCode
     *
     * @return ninteiShinseiEdabanCode
     */
    public EdabanCode getNinteiShinseiEdabanCode() {
        return ninteiShinseiEdabanCode;
    }

    /**
     * setNinteiShinseiEdabanCode
     *
     * @param ninteiShinseiEdabanCode ninteiShinseiEdabanCode
     */
    public void setNinteiShinseiEdabanCode(EdabanCode ninteiShinseiEdabanCode) {
        this.ninteiShinseiEdabanCode = ninteiShinseiEdabanCode;
    }

    /**
     * getNinteiShinseiShinseijiKubunCode
     *
     * @return ninteiShinseiShinseijiKubunCode
     */
    public Code getNinteiShinseiShinseijiKubunCode() {
        return ninteiShinseiShinseijiKubunCode;
    }

    /**
     * setNinteiShinseiShinseijiKubunCode
     *
     * @param ninteiShinseiShinseijiKubunCode ninteiShinseiShinseijiKubunCode
     */
    public void setNinteiShinseiShinseijiKubunCode(Code ninteiShinseiShinseijiKubunCode) {
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
    }

    /**
     * getNinteiShinseiHoreiKubunCode
     *
     * @return ninteiShinseiHoreiKubunCode
     */
    public Code getNinteiShinseiHoreiKubunCode() {
        return ninteiShinseiHoreiKubunCode;
    }

    /**
     * setNinteiShinseiHoreiKubunCode
     *
     * @param ninteiShinseiHoreiKubunCode ninteiShinseiHoreiKubunCode
     */
    public void setNinteiShinseiHoreiKubunCode(Code ninteiShinseiHoreiKubunCode) {
        this.ninteiShinseiHoreiKubunCode = ninteiShinseiHoreiKubunCode;
    }

    /**
     * getNinteiShinseiYukoKubunCode
     *
     * @return ninteiShinseiYukoKubunCode
     */
    public Code getNinteiShinseiYukoKubunCode() {
        return ninteiShinseiYukoKubunCode;
    }

    /**
     * setNinteiShinseiYukoKubunCode
     *
     * @param ninteiShinseiYukoKubunCode ninteiShinseiYukoKubunCode
     */
    public void setNinteiShinseiYukoKubunCode(Code ninteiShinseiYukoKubunCode) {
        this.ninteiShinseiYukoKubunCode = ninteiShinseiYukoKubunCode;
    }

    /**
     * getShienShinseiKubun
     *
     * @return shienShinseiKubun
     */
    public RString getShienShinseiKubun() {
        return shienShinseiKubun;
    }

    /**
     * setShienShinseiKubun
     *
     * @param shienShinseiKubun shienShinseiKubun
     */
    public void setShienShinseiKubun(RString shienShinseiKubun) {
        this.shienShinseiKubun = shienShinseiKubun;
    }

    /**
     * getShinseiRiyu
     *
     * @return shinseiRiyu
     */
    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    /**
     * setShinseiRiyu
     *
     * @param shinseiRiyu shinseiRiyu
     */
    public void setShinseiRiyu(RString shinseiRiyu) {
        this.shinseiRiyu = shinseiRiyu;
    }

    /**
     * getZenYokaigoKubunCode
     *
     * @return zenYokaigoKubunCode
     */
    public Code getZenYokaigoKubunCode() {
        return zenYokaigoKubunCode;
    }

    /**
     * setZenYokaigoKubunCode
     *
     * @param zenYokaigoKubunCode zenYokaigoKubunCode
     */
    public void setZenYokaigoKubunCode(Code zenYokaigoKubunCode) {
        this.zenYokaigoKubunCode = zenYokaigoKubunCode;
    }

    /**
     * getZenYukoKikan
     *
     * @return zenYukoKikan
     */
    public int getZenYukoKikan() {
        return zenYukoKikan;
    }

    /**
     * setZenYukoKikan
     *
     * @param zenYukoKikan zenYukoKikan
     */
    public void setZenYukoKikan(int zenYukoKikan) {
        this.zenYukoKikan = zenYukoKikan;
    }

    /**
     * getJohoteikyoDouiUmuKubun
     *
     * @return johoteikyoDouiUmuKubun
     */
    public boolean getJohoteikyoDouiUmuKubun() {
        return johoteikyoDouiUmuKubun;
    }

    /**
     * setJohoteikyoDouiUmuKubun
     *
     * @param johoteikyoDouiUmuKubun johoteikyoDouiUmuKubun
     */
    public void setJohoteikyoDouiUmuKubun(boolean johoteikyoDouiUmuKubun) {
        this.johoteikyoDouiUmuKubun = johoteikyoDouiUmuKubun;
    }

    /**
     * getNinteichosaIraiRirekiNo
     *
     * @return ninteichosaIraiRirekiNo
     */
    public int getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    /**
     * setNinteichosaIraiRirekiNo
     *
     * @param ninteichosaIraiRirekiNo ninteichosaIraiRirekiNo
     */
    public void setNinteichosaIraiRirekiNo(int ninteichosaIraiRirekiNo) {
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    /**
     * getIkenshoIraiRirekiNo
     *
     * @return ikenshoIraiRirekiNo
     */
    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /**
     * setIkenshoIraiRirekiNo
     *
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     */
    public void setIkenshoIraiRirekiNo(int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /**
     * getMinashiCode
     *
     * @return minashiCode
     */
    public RString getMinashiCode() {
        return minashiCode;
    }

    /**
     * setMinashiCode
     *
     * @param minashiCode minashiCode
     */
    public void setMinashiCode(RString minashiCode) {
        this.minashiCode = minashiCode;
    }

    /**
     * getEnkitsuchiDoiUmuKubun
     *
     * @return enkitsuchiDoiUmuKubun
     */
    public boolean getEnkitsuchiDoiUmuKubun() {
        return enkitsuchiDoiUmuKubun;
    }

    /**
     * setEnkitsuchiDoiUmuKubun
     *
     * @param enkitsuchiDoiUmuKubun enkitsuchiDoiUmuKubun
     */
    public void setEnkitsuchiDoiUmuKubun(boolean enkitsuchiDoiUmuKubun) {
        this.enkitsuchiDoiUmuKubun = enkitsuchiDoiUmuKubun;
    }

    /**
     * getShisetsuNyushoUmuKubun
     *
     * @return shisetsuNyushoUmuKubun
     */
    public boolean getShisetsuNyushoUmuKubun() {
        return shisetsuNyushoUmuKubun;
    }

    /**
     * setShisetsuNyushoUmuKubun
     *
     * @param shisetsuNyushoUmuKubun shisetsuNyushoUmuKubun
     */
    public void setShisetsuNyushoUmuKubun(boolean shisetsuNyushoUmuKubun) {
        this.shisetsuNyushoUmuKubun = shisetsuNyushoUmuKubun;
    }

    /**
     * getSichosonRenrakuJiko
     *
     * @return sichosonRenrakuJiko
     */
    public RString getSichosonRenrakuJiko() {
        return sichosonRenrakuJiko;
    }

    /**
     * setSichosonRenrakuJiko
     *
     * @param sichosonRenrakuJiko sichosonRenrakuJiko
     */
    public void setSichosonRenrakuJiko(RString sichosonRenrakuJiko) {
        this.sichosonRenrakuJiko = sichosonRenrakuJiko;
    }

    /**
     * getTorisageKubunCode
     *
     * @return torisageKubunCode
     */
    public Code getTorisageKubunCode() {
        return torisageKubunCode;
    }

    /**
     * setTorisageKubunCode
     *
     * @param torisageKubunCode torisageKubunCode
     */
    public void setTorisageKubunCode(Code torisageKubunCode) {
        this.torisageKubunCode = torisageKubunCode;
    }

    /**
     * getTorisageRiyu
     *
     * @return torisageRiyu
     */
    public RString getTorisageRiyu() {
        return torisageRiyu;
    }

    /**
     * setTorisageRiyu
     *
     * @param torisageRiyu torisageRiyu
     */
    public void setTorisageRiyu(RString torisageRiyu) {
        this.torisageRiyu = torisageRiyu;
    }

    /**
     * getTorisageYMD
     *
     * @return torisageYMD
     */
    public FlexibleDate getTorisageYMD() {
        return torisageYMD;
    }

    /**
     * setTorisageYMD
     *
     * @param torisageYMD torisageYMD
     */
    public void setTorisageYMD(FlexibleDate torisageYMD) {
        this.torisageYMD = torisageYMD;
    }

    /**
     * getShinsaKeizokuKubun
     *
     * @return shinsaKeizokuKubun
     */
    public boolean getShinsaKeizokuKubun() {
        return shinsaKeizokuKubun;
    }

    /**
     * setShinsaKeizokuKubun
     *
     * @param shinsaKeizokuKubun shinsaKeizokuKubun
     */
    public void setShinsaKeizokuKubun(boolean shinsaKeizokuKubun) {
        this.shinsaKeizokuKubun = shinsaKeizokuKubun;
    }
// </editor-fold>
}
