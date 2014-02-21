/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiChosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urf.definition.enumeratedtype.NinteiShinseiKubunShinsei;

/**
 * 要介護認定申請情報のエンティティクラスです。
 *
 * @author N8187 久保田 英男
 */
public class DbT5001NinteiShinseiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    /**
     * 要介護認定申請情報テーブル
     */
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
    private KaigoHihokenshaNo hihokenshaNo;
    private RString shikibetsuCode;
    private NinteiShinseiDate ninteiShinseiYMD;
    private RString ninteiShinseiEdabanCode;
    private NinteiShinseiKubunShinsei ninteiShinseiShinseijiKubunCode;
    private NinteiShinseiKubunShinsei ninteiShinseiHoreiKubunCode;
    private NinteiShinseiKubunShinsei ninteiShinseiYukoKubunCode;
    private RString shienShinseiKubun;
    private RString shinseiRiyu;
    private RString zenYokaigoKubunCode;
    private int zenYukoKikan;
    private boolean johoteikyoDouiUmuKubun;
    private NinteiChosaIraiRirekiNo ninteichosaIraiRirekiNo;
    private int ikenshoIraiRirekiNo;
    private RString minashiCode;
    private boolean enkitsuchiDoiUmuKubun;
    private boolean shisetsuNyushoUmuKubun;
    private RString sichosonRenrakuJiko;
    private RString torisageKubunCode;
    private RString torisageRiyu;
    private FlexibleDate torisageYMD;
    private boolean shinsaKeizokuKubun;

    /**
     * デフォルトコンストラクタです。
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
            RString shikibetsuCode,
            NinteiShinseiDate ninteiShinseiYMD,
            RString ninteiShinseiEdabanCode,
            NinteiShinseiKubunShinsei ninteiShinseiShinseijiKubunCode,
            NinteiShinseiKubunShinsei ninteiShinseiHoreiKubunCode,
            NinteiShinseiKubunShinsei ninteiShinseiYukoKubunCode,
            RString shienShinseiKubun,
            RString shinseiRiyu,
            RString zenYokaigoKubunCode,
            int zenYukoKikan,
            boolean johoteikyoDouiUmuKubun,
            NinteiChosaIraiRirekiNo ninteichosaIraiRirekiNo,
            int ikenshoIraiRirekiNo,
            RString minashiCode,
            boolean enkitsuchiDoiUmuKubun,
            boolean shisetsuNyushoUmuKubun,
            RString sichosonRenrakuJiko,
            RString torisageKubunCode,
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
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
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

    /**
     * 申請書管理番号を返します。
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 市町村コードを返します。
     *
     * @return shichosonCode
     */
    public ShichosonCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(ShichosonCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 支所コードを返します。
     *
     * @return shishoCode
     */
    public RString getShishoCode() {
        return shishoCode;
    }

    /**
     * 支所コードを設定します。
     *
     * @param shishoCode 支所コード
     */
    public void setShishoCode(RString shishoCode) {
        this.shishoCode = shishoCode;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return hihokenshaNo
     */
    public KaigoHihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(KaigoHihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 識別コードを返します。
     *
     * @return shikibetsuCode
     */
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードを設定します。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return ninteiShinseiYMD
     */
    public NinteiShinseiDate getNinteiShinseiYMD() {
        return ninteiShinseiYMD;
    }

    /**
     * 認定申請年月日を設定します。
     *
     * @param ninteiShinseiYMD 認定申請年月日
     */
    public void setNinteiShinseiYMD(NinteiShinseiDate ninteiShinseiYMD) {
        this.ninteiShinseiYMD = ninteiShinseiYMD;
    }

    /**
     * 認定申請枝番コードを返します。
     *
     * @return ninteiShinseiEdabanCode
     */
    public RString getNinteiShinseiEdabanCode() {
        return ninteiShinseiEdabanCode;
    }

    /**
     * 認定申請枝番コードを設定します。
     *
     * @param ninteiShinseiEdabanCode 認定申請枝番コード
     */
    public void setNinteiShinseiEdabanCode(RString ninteiShinseiEdabanCode) {
        this.ninteiShinseiEdabanCode = ninteiShinseiEdabanCode;
    }

    /**
     * 認定申請区分（申請時）コードを返します。
     *
     * @return ninteiShinseiShinseijiKubunCode
     */
    public NinteiShinseiKubunShinsei getNinteiShinseiShinseijiKubunCode() {
        return ninteiShinseiShinseijiKubunCode;
    }

    /**
     * 認定申請区分（申請時）コードを設定します。
     *
     * @param ninteiShinseiShinseijiKubunCode 認定申請区分（申請時）コード
     */
    public void setNinteiShinseiShinseijiKubunCode(NinteiShinseiKubunShinsei ninteiShinseiShinseijiKubunCode) {
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
    }

    /**
     * 認定申請区分（法令）コードを返します。
     *
     * @return ninteiShinseiHoreiKubunCode
     */
    public NinteiShinseiKubunShinsei getNinteiShinseiHoreiKubunCode() {
        return ninteiShinseiHoreiKubunCode;
    }

    /**
     * 認定申請区分（法令）コードを設定します。
     *
     * @param ninteiShinseiHoreiKubunCode 認定申請区分（法令）コード
     */
    public void setNinteiShinseiHoreiKubunCode(NinteiShinseiKubunShinsei ninteiShinseiHoreiKubunCode) {
        this.ninteiShinseiHoreiKubunCode = ninteiShinseiHoreiKubunCode;
    }

    /**
     * 認定申請有効区分を返します。
     *
     * @return ninteiShinseiYukoKubunCode
     */
    public NinteiShinseiKubunShinsei getNinteiShinseiYukoKubunCode() {
        return ninteiShinseiYukoKubunCode;
    }

    /**
     * 認定申請有効区分を設定します。
     *
     * @param ninteiShinseiYukoKubunCode 認定申請有効区分
     */
    public void setNinteiShinseiYukoKubunCode(NinteiShinseiKubunShinsei ninteiShinseiYukoKubunCode) {
        this.ninteiShinseiYukoKubunCode = ninteiShinseiYukoKubunCode;
    }

    /**
     * 要介護申請・要支援申請の区分を返します。
     *
     * @return shienShinseiKubun
     */
    public RString getShienShinseiKubun() {
        return shienShinseiKubun;
    }

    /**
     * 要介護申請・要支援申請の区分を設定します。
     *
     * @param shienShinseiKubun 要介護申請・要支援申請の区分
     */
    public void setShienShinseiKubun(RString shienShinseiKubun) {
        this.shienShinseiKubun = shienShinseiKubun;
    }

    /**
     * 認定申請理由を返します。
     *
     * @return shinseiRiyu
     */
    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    /**
     * 認定申請理由を設定します。
     *
     * @param shinseiRiyu 認定申請理由
     */
    public void setShinseiRiyu(RString shinseiRiyu) {
        this.shinseiRiyu = shinseiRiyu;
    }

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return zenYokaigoKubunCode
     */
    public RString getZenYokaigoKubunCode() {
        return zenYokaigoKubunCode;
    }

    /**
     * 前回要介護状態区分コードを設定します。
     *
     * @param zenYokaigoKubunCode 前回要介護状態区分コード
     */
    public void setZenYokaigoKubunCode(RString zenYokaigoKubunCode) {
        this.zenYokaigoKubunCode = zenYokaigoKubunCode;
    }

    /**
     * 前回認定有効期間を返します。
     *
     * @return zenYukoKikan
     */
    public int getZenYukoKikan() {
        return zenYukoKikan;
    }

    /**
     * 前回認定有効期間を設定します。
     *
     * @param zenYukoKikan 前回認定有効期間
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
     * 情報提供への同意有無を設定します。
     *
     * @param johoteikyoDouiUmuKubun 情報提供への同意有無
     */
    public void setJohoteikyoDouiUmuKubun(boolean johoteikyoDouiUmuKubun) {
        this.johoteikyoDouiUmuKubun = johoteikyoDouiUmuKubun;
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return ninteichosaIraiRirekiNo
     */
    public NinteiChosaIraiRirekiNo getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    /**
     * 認定調査依頼履歴番号を設定します。
     *
     * @param ninteichosaIraiRirekiNo 認定調査依頼履歴番号
     */
    public void setNinteichosaIraiRirekiNo(NinteiChosaIraiRirekiNo ninteichosaIraiRirekiNo) {
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号を返します。
     *
     * @return ikenshoIraiRirekiNo
     */
    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号を設定します。
     *
     * @param ikenshoIraiRirekiNo 主治医意見書作成依頼履歴番号
     */
    public void setIkenshoIraiRirekiNo(int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /**
     * みなし要介護区分コードを返します。
     *
     * @return minashiCode
     */
    public RString getMinashiCode() {
        return minashiCode;
    }

    /**
     * みなし要介護区分コードを設定します。
     *
     * @param minashiCode みなし要介護区分コード
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
     * 認定延期通知発行に対する同意有無を設定します。
     *
     * @param enkitsuchiDoiUmuKubun 認定延期通知発行に対する同意有無
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
     * 施設入所の有無を設定します。
     *
     * @param shisetsuNyushoUmuKubun 施設入所の有無
     */
    public void setShisetsuNyushoUmuKubun(boolean shisetsuNyushoUmuKubun) {
        this.shisetsuNyushoUmuKubun = shisetsuNyushoUmuKubun;
    }

    /**
     * 市町村連絡事項を返します。
     *
     * @return sichosonRenrakuJiko
     */
    public RString getSichosonRenrakuJiko() {
        return sichosonRenrakuJiko;
    }

    /**
     * 市町村連絡事項を設定します。
     *
     * @param sichosonRenrakuJiko 市町村連絡事項
     */
    public void setSichosonRenrakuJiko(RString sichosonRenrakuJiko) {
        this.sichosonRenrakuJiko = sichosonRenrakuJiko;
    }

    /**
     * 取下げ区分コードを返します。
     *
     * @return torisageKubunCode
     */
    public RString getTorisageKubunCode() {
        return torisageKubunCode;
    }

    /**
     * 取下げ区分コードを設定します。
     *
     * @param torisageKubunCode 取下げ区分コード
     */
    public void setTorisageKubunCode(RString torisageKubunCode) {
        this.torisageKubunCode = torisageKubunCode;
    }

    /**
     * 取下げ理由を返します。
     *
     * @return torisageRiyu
     */
    public RString getTorisageRiyu() {
        return torisageRiyu;
    }

    /**
     * 取下げ理由を設定します。
     *
     * @param torisageRiyu 取下げ理由
     */
    public void setTorisageRiyu(RString torisageRiyu) {
        this.torisageRiyu = torisageRiyu;
    }

    /**
     * 取下げ年月日を返します。
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
}
