package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;

/**
 * DbT5001NinteiShinseiJohoの項目定義クラスです
 *
 */
public class DbT5001NinteiShinseiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5001NinteiShinseiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private ShishoCode shishoCode;
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
    private Code ninteichosaShikibetsuCode;
    private int ikenshoIraiRirekiNo;
    private RString kaigoIryokikanCode;
    private RString kaigoIshiCode;
    private RString minashiCode;
    private boolean enkitsuchiDoiUmuKubun;
    private boolean shisetsuNyushoUmuKubun;
    private RString sichosonRenrakuJiko;
    private Code torisageKubunCode;
    private RString torisageRiyu;
    private FlexibleDate torisageYMD;
    private boolean shinsaKeizokuKubun;
    private Code shinsakaiYusenWaritsukeKubunCode;
    private FlexibleDate ifSofuYMD;

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
     * getShishoCode
     *
     * @return shishoCode
     */
    public ShishoCode getShishoCode() {
        return shishoCode;
    }

    /**
     * setShishoCode
     *
     * @param shishoCode shishoCode
     */
    public void setShishoCode(ShishoCode shishoCode) {
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
     * getNinteichosaShikibetsuCode
     *
     * @return ninteichosaShikibetsuCode
     */
    public Code getNinteichosaShikibetsuCode() {
        return ninteichosaShikibetsuCode;
    }

    /**
     * setNinteichosaShikibetsuCode
     *
     * @param ninteichosaShikibetsuCode ninteichosaShikibetsuCode
     */
    public void setNinteichosaShikibetsuCode(Code ninteichosaShikibetsuCode) {
        this.ninteichosaShikibetsuCode = ninteichosaShikibetsuCode;
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
     * getKaigoIryokikanCode
     *
     * @return kaigoIryokikanCode
     */
    public RString getKaigoIryokikanCode() {
        return kaigoIryokikanCode;
    }

    /**
     * setKaigoIryokikanCode
     *
     * @param kaigoIryokikanCode kaigoIryokikanCode
     */
    public void setKaigoIryokikanCode(RString kaigoIryokikanCode) {
        this.kaigoIryokikanCode = kaigoIryokikanCode;
    }

    /**
     * getKaigoIshiCode
     *
     * @return kaigoIshiCode
     */
    public RString getKaigoIshiCode() {
        return kaigoIshiCode;
    }

    /**
     * setKaigoIshiCode
     *
     * @param kaigoIshiCode kaigoIshiCode
     */
    public void setKaigoIshiCode(RString kaigoIshiCode) {
        this.kaigoIshiCode = kaigoIshiCode;
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

    /**
     * getShinsakaiYusenWaritsukeKubunCode
     *
     * @return shinsakaiYusenWaritsukeKubunCode
     */
    public Code getShinsakaiYusenWaritsukeKubunCode() {
        return shinsakaiYusenWaritsukeKubunCode;
    }

    /**
     * setShinsakaiYusenWaritsukeKubunCode
     *
     * @param shinsakaiYusenWaritsukeKubunCode shinsakaiYusenWaritsukeKubunCode
     */
    public void setShinsakaiYusenWaritsukeKubunCode(Code shinsakaiYusenWaritsukeKubunCode) {
        this.shinsakaiYusenWaritsukeKubunCode = shinsakaiYusenWaritsukeKubunCode;
    }

    /**
     * getIfSofuYMD
     *
     * @return ifSofuYMD
     */
    public FlexibleDate getIfSofuYMD() {
        return ifSofuYMD;
    }

    /**
     * setIfSofuYMD
     *
     * @param ifSofuYMD ifSofuYMD
     */
    public void setIfSofuYMD(FlexibleDate ifSofuYMD) {
        this.ifSofuYMD = ifSofuYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5001NinteiShinseiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5001NinteiShinseiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5001NinteiShinseiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

// </editor-fold>
}
