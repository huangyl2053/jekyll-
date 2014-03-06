package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang._UUID;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
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
    private NinteiShinseiKubunShinsei ninteiShinseiShinseijiKubunCode;
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
     * ORマッパーのためのデフォルトコンストラクタです。
     */
    public DbT5001NinteiShinseiJohoEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param shichosonCode 市町村コード
     * @param shishoCode 支所コード
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     * @param ninteiShinseiYMD 認定申請年月日
     * @param ninteiShinseiEdabanCode 認定申請枝番コード
     * @param ninteiShinseiShinseijiKubunCode 認定申請区分（申請時）コード
     * @param ninteiShinseiHoreiKubunCode 認定申請区分（法令）コード
     * @param ninteiShinseiYukoKubunCode 認定申請有効区分
     * @param shienShinseiKubun 要介護申請・要支援申請の区分
     * @param shinseiRiyu 認定申請理由
     * @param zenYokaigoKubunCode 前回要介護状態区分コード
     * @param zenYukoKikan 前回認定有効期間
     * @param johoteikyoDouiUmuKubun 情報提供への同意有無
     * @param ninteichosaIraiRirekiNo 認定調査依頼履歴番号
     * @param ikenshoIraiRirekiNo 主治医意見書作成依頼履歴番号
     * @param minashiCode みなし要介護区分コード
     * @param enkitsuchiDoiUmuKubun 認定延期通知発行に対する同意有無
     * @param shisetsuNyushoUmuKubun 施設入所の有無
     * @param sichosonRenrakuJiko 市町村連絡事項
     * @param torisageKubunCode 取下げ区分コード
     * @param torisageRiyu 取下げ理由
     * @param torisageYMD 取下げ年月日
     * @param shinsaKeizokuKubun 審査継続区分
     */
    public DbT5001NinteiShinseiJohoEntity(ShinseishoKanriNo shinseishoKanriNo,
            ShichosonCode shichosonCode,
            RString shishoCode,
            KaigoHihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode,
            FlexibleDate ninteiShinseiYMD,
            EdabanCode ninteiShinseiEdabanCode,
            NinteiShinseiKubunShinsei ninteiShinseiShinseijiKubunCode,
            Code ninteiShinseiHoreiKubunCode,
            Code ninteiShinseiYukoKubunCode,
            RString shienShinseiKubun,
            RString shinseiRiyu,
            Code zenYokaigoKubunCode,
            int zenYukoKikan,
            boolean johoteikyoDouiUmuKubun,
            NinteichosaIraiRirekiNo ninteichosaIraiRirekiNo,
            int ikenshoIraiRirekiNo,
            RString minashiCode,
            boolean enkitsuchiDoiUmuKubun,
            boolean shisetsuNyushoUmuKubun,
            RString sichosonRenrakuJiko,
            Code torisageKubunCode,
            RString torisageRiyu,
            FlexibleDate torisageYMD,
            boolean shinsaKeizokuKubun) {

        this.shinseishoKanriNo = shinseishoKanriNo;
        this.shichosonCode = shichosonCode;
        this.shishoCode = shishoCode;
        this.hihokenshaNo = hihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.ninteiShinseiEdabanCode = ninteiShinseiEdabanCode;
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
        this.ninteiShinseiHoreiKubunCode = ninteiShinseiHoreiKubunCode;
        this.ninteiShinseiYukoKubunCode = ninteiShinseiYukoKubunCode;
        this.shienShinseiKubun = shienShinseiKubun;
        this.shinseiRiyu = shinseiRiyu;
        this.zenYokaigoKubunCode = zenYokaigoKubunCode;
        this.zenYukoKikan = zenYukoKikan;
        this.johoteikyoDouiUmuKubun = johoteikyoDouiUmuKubun;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo.value();
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
        this.minashiCode = minashiCode;
        this.enkitsuchiDoiUmuKubun = enkitsuchiDoiUmuKubun;
        this.shisetsuNyushoUmuKubun = shisetsuNyushoUmuKubun;
        this.sichosonRenrakuJiko = sichosonRenrakuJiko;
        this.torisageKubunCode = torisageKubunCode;
        this.torisageRiyu = torisageRiyu;
        this.torisageYMD = torisageYMD;
        this.shinsaKeizokuKubun = shinsaKeizokuKubun;
    }

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
    public NinteiShinseiKubunShinsei getNinteiShinseiShinseijiKubunCode() {
        return ninteiShinseiShinseijiKubunCode;
    }

    /**
     * setNinteiShinseiShinseijiKubunCode
     *
     * @param ninteiShinseiShinseijiKubunCode ninteiShinseiShinseijiKubunCode
     */
    public void setNinteiShinseiShinseijiKubunCode(NinteiShinseiKubunShinsei ninteiShinseiShinseijiKubunCode) {
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
     * 情報提供への同意有無が有効かどうかを返します。
     *
     * @return {@code true}:有効、{@code false}:無効
     */
    public boolean isJohoteikyoDouiUmuKubun() {
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
     * 認定延期通知発行に対する同意有無が有効かどうかを返します。
     *
     * @return {@code true}:有効、{@code false}:無効
     */
    public boolean isEnkitsuchiDoiUmuKubun() {
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
     * 施設入所の有無が有効かどうかを返します。
     *
     * @return {@code true}:有効、{@code false}:無効
     */
    public boolean isShisetsuNyushoUmuKubun() {
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
     * 取下げ年月日を設定します。
     *
     * @param torisageYMD 取下げ年月日
     */
    public void setTorisageYMD(FlexibleDate torisageYMD) {
        this.torisageYMD = torisageYMD;
    }

    /**
     * 審査継続区分が有効かどうかを返します。
     *
     * @return {@code true}:有効、{@code false}:無効
     */
    public boolean isShinsaKeizokuKubun() {
        return shinsaKeizokuKubun;
    }

    /**
     * 審査継続区分を設定します。
     *
     * @param shinsaKeizokuKubun 審査継続区分
     */
    public void setShinsaKeizokuKubun(boolean shinsaKeizokuKubun) {
        this.shinsaKeizokuKubun = shinsaKeizokuKubun;
    }
// </editor-fold>
}
