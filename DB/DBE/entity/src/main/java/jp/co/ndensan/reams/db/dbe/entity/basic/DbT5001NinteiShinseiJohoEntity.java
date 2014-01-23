package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbe.definition.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.TorisageKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;

public class DbT5001NinteiShinseiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public final static String TABLE_NAME = "DbT5001NinteiShinseiJoho";
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted;
    private int updateCount;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    private ShichosonCode shichosonCode;
    private RString shishoCode;
    private HihokenshaNo hihokenshaNo;
    private RString shikibetsuCode;
    private FlexibleDate ninteiShinseiYMD;
    private RString ninteiShinseiEdabanCode;
    private RString ninteiShinseiShinseijiKubunCode;
    private int ninteiShinseiHoreiKubunCode;
    private RString ninteiShinseiYukoKubunCode;
    private RString shienShinseiKubun;
    private RString shinseiRiyu;
    private RString zenYokaigoKubunCode;
    private int zenYukoKikan;
    private boolean johoteikyoDouiUmuKubun;
    private int ninteichosaIraiRirekiNo;
    private int ikenshoIraiRirekiNo;
    private RString minashiCode;
    private boolean enkitsuchiDoiUmuKubun;
    private boolean shisetsuNyushoUmuKubun;
    private RString sichosonRenrakuJiko;
    private TorisageKubun torisageKubunCode;
    private RString torisageRiyu;
    private FlexibleDate torisageYMD;
    private ShinsaKeizokuKubun shinsaKeizokuKubun;

    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    public RDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    public void setInsertTimestamp(RDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    public RString getInsertReamsLoginId() {
        return insertReamsLoginId;
    }

    public void setInsertReamsLoginId(RString insertReamsLoginId) {
        this.insertReamsLoginId = insertReamsLoginId;
    }

    public UUID getInsertContextId() {
        return insertContextId;
    }

    public void setInsertContextId(UUID insertContextId) {
        this.insertContextId = insertContextId;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    public RDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(RDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public RString getLastUpdateReamsLoginId() {
        return lastUpdateReamsLoginId;
    }

    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public ShichosonCode getShichosonCode() {
        return shichosonCode;
    }

    public void setShichosonCode(ShichosonCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    public RString getShishoCode() {
        return shishoCode;
    }

    public void setShishoCode(RString shishoCode) {
        this.shishoCode = shishoCode;
    }

    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    public FlexibleDate getNinteiShinseiYMD() {
        return ninteiShinseiYMD;
    }

    public void setNinteiShinseiYMD(FlexibleDate ninteiShinseiYMD) {
        this.ninteiShinseiYMD = ninteiShinseiYMD;
    }

    public RString getNinteiShinseiEdabanCode() {
        return ninteiShinseiEdabanCode;
    }

    public void setNinteiShinseiEdabanCode(RString ninteiShinseiEdabanCode) {
        this.ninteiShinseiEdabanCode = ninteiShinseiEdabanCode;
    }

    public RString getNinteiShinseiShinseijiKubunCode() {
        return ninteiShinseiShinseijiKubunCode;
    }

    public void setNinteiShinseiShinseijiKubunCode(RString ninteiShinseiShinseijiKubunCode) {
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
    }

    public int getNinteiShinseiHoreiKubunCode() {
        return ninteiShinseiHoreiKubunCode;
    }

    public void setNinteiShinseiHoreiKubunCode(int ninteiShinseiHoreiKubunCode) {
        this.ninteiShinseiHoreiKubunCode = ninteiShinseiHoreiKubunCode;
    }

    public RString getNinteiShinseiYukoKubunCode() {
        return ninteiShinseiYukoKubunCode;
    }

    public void setNinteiShinseiYukoKubunCode(RString ninteiShinseiYukoKubunCode) {
        this.ninteiShinseiYukoKubunCode = ninteiShinseiYukoKubunCode;
    }

    public RString getShienShinseiKubun() {
        return shienShinseiKubun;
    }

    public void setShienShinseiKubun(RString shienShinseiKubun) {
        this.shienShinseiKubun = shienShinseiKubun;
    }

    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    public void setShinseiRiyu(RString shinseiRiyu) {
        this.shinseiRiyu = shinseiRiyu;
    }

    public RString getZenYokaigoKubunCode() {
        return zenYokaigoKubunCode;
    }

    public void setZenYokaigoKubunCode(RString zenYokaigoKubunCode) {
        this.zenYokaigoKubunCode = zenYokaigoKubunCode;
    }

    public int getZenYukoKikan() {
        return zenYukoKikan;
    }

    public void setZenYukoKikan(int zenYukoKikan) {
        this.zenYukoKikan = zenYukoKikan;
    }

    public boolean getJohoteikyoDouiUmuKubun() {
        return johoteikyoDouiUmuKubun;
    }

    public void setJohoteikyoDouiUmuKubun(boolean johoteikyoDouiUmuKubun) {
        this.johoteikyoDouiUmuKubun = johoteikyoDouiUmuKubun;
    }

    public int getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    public void setNinteichosaIraiRirekiNo(int ninteichosaIraiRirekiNo) {
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    public void setIkenshoIraiRirekiNo(int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    public RString getMinashiCode() {
        return minashiCode;
    }

    public void setMinashiCode(RString minashiCode) {
        this.minashiCode = minashiCode;
    }

    public boolean getEnkitsuchiDoiUmuKubun() {
        return enkitsuchiDoiUmuKubun;
    }

    public void setEnkitsuchiDoiUmuKubun(boolean enkitsuchiDoiUmuKubun) {
        this.enkitsuchiDoiUmuKubun = enkitsuchiDoiUmuKubun;
    }

    public boolean getShisetsuNyushoUmuKubun() {
        return shisetsuNyushoUmuKubun;
    }

    public void setShisetsuNyushoUmuKubun(boolean shisetsuNyushoUmuKubun) {
        this.shisetsuNyushoUmuKubun = shisetsuNyushoUmuKubun;
    }

    public RString getSichosonRenrakuJiko() {
        return sichosonRenrakuJiko;
    }

    public void setSichosonRenrakuJiko(RString sichosonRenrakuJiko) {
        this.sichosonRenrakuJiko = sichosonRenrakuJiko;
    }

    public TorisageKubun getTorisageKubunCode() {
        return torisageKubunCode;
    }

    public void setTorisageKubunCode(TorisageKubun torisageKubunCode) {
        this.torisageKubunCode = torisageKubunCode;
    }

    public RString getTorisageRiyu() {
        return torisageRiyu;
    }

    public void setTorisageRiyu(RString torisageRiyu) {
        this.torisageRiyu = torisageRiyu;
    }

    public FlexibleDate getTorisageYMD() {
        return torisageYMD;
    }

    public void setTorisageYMD(FlexibleDate torisageYMD) {
        this.torisageYMD = torisageYMD;
    }

    public ShinsaKeizokuKubun getShinsaKeizokuKubun() {
        return shinsaKeizokuKubun;
    }

    public void setShinsaKeizokuKubun(ShinsaKeizokuKubun shinsaKeizokuKubun) {
        this.shinsaKeizokuKubun = shinsaKeizokuKubun;
    }
// </editor-fold>
}
