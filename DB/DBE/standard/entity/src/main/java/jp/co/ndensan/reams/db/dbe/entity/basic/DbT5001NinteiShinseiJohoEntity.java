/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiChosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定申請情報のエンティティクラスです。
 *
 * @author N8187 久保田 英男
 */
public class DbT5001NinteiShinseiJohoEntity implements IDbAccessable {

    /**
     * 要介護認定申請情報テーブル
     */
    @TableName
    public static final RString TABLE_NAME = new RString("T5001NinteiShinseiJoho");
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    private ShichosonCode shichosonCode;
    private RString shishoCode;
    private KaigoHihokenshaNumber hihokenshaNo;
    private IShikibetsuCode shikibetsuCode;
    private FlexibleDate ninteiShinseiYMD;
    private RString ninteiShinseiEdabanCode;
    private RString ninteiShinseiShinseijiKubunCode;
    private RString ninteiShinseiHoreiKubunCode;
    private RString ninteiShinseiYukoKubunCode;
    private RString shienShinseiKubun;
    private RString shinseiRiyu;
    private RString zenYokaigoKubunCode;
    private int zenYukoKikan;
    private boolean johoteikyoDouiUmuKubun;
    private NinteiChosaIraiRirekiNo ninteichosaIraiRirekiNo;
    private RString ikenshoIraiRirekiNo;
    private RString minashiCode;
    private boolean enkitsuchiDoiUmuKubun;
    private boolean shisetsuNyushoUmuKubun;
    private RString sichosonRenrakuJiko;
    private RString torisageKubunCode;
    private RString torisageRiyu;
    private FlexibleDate torisageYMD;
    private boolean shinsaKeizokuKubun;

    /**
     * ORマッパーのためのデフォルトコンストラクタです。
     */
    DbT5001NinteiShinseiJohoEntity() {
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
            KaigoHihokenshaNumber hihokenshaNo,
            IShikibetsuCode shikibetsuCode,
            FlexibleDate ninteiShinseiYMD,
            RString ninteiShinseiEdabanCode,
            RString ninteiShinseiShinseijiKubunCode,
            RString ninteiShinseiHoreiKubunCode,
            RString ninteiShinseiYukoKubunCode,
            RString shienShinseiKubun,
            RString shinseiRiyu,
            RString zenYokaigoKubunCode,
            int zenYukoKikan,
            boolean johoteikyoDouiUmuKubun,
            NinteiChosaIraiRirekiNo ninteichosaIraiRirekiNo,
            RString ikenshoIraiRirekiNo,
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

    /**
     * 申請書管理番号を返します。
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
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
     * 支所コードを返します。
     *
     * @return shishoCode
     */
    public RString getShishoCode() {
        return shishoCode;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return hihokenshaNo
     */
    public KaigoHihokenshaNumber getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 識別コードを返します。
     *
     * @return shikibetsuCode
     */
    public IShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return ninteiShinseiYMD
     */
    public FlexibleDate getNinteiShinseiYMD() {
        return ninteiShinseiYMD;
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
     * 認定申請区分（申請時）コードを返します。
     *
     * @return ninteiShinseiShinseijiKubunCode
     */
    public RString getNinteiShinseiShinseijiKubunCode() {
        return ninteiShinseiShinseijiKubunCode;
    }

    /**
     * 認定申請区分（法令）コードを返します。
     *
     * @return ninteiShinseiHoreiKubunCode
     */
    public RString getNinteiShinseiHoreiKubunCode() {
        return ninteiShinseiHoreiKubunCode;
    }

    /**
     * 認定申請有効区分を返します。
     *
     * @return ninteiShinseiYukoKubunCode
     */
    public RString getNinteiShinseiYukoKubunCode() {
        return ninteiShinseiYukoKubunCode;
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
     * 認定申請理由を返します。
     *
     * @return shinseiRiyu
     */
    public RString getShinseiRiyu() {
        return shinseiRiyu;
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
     * 前回認定有効期間を返します。
     *
     * @return zenYukoKikan
     */
    public int getZenYukoKikan() {
        return zenYukoKikan;
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
     * 認定調査依頼履歴番号を返します。
     *
     * @return ninteichosaIraiRirekiNo
     */
    public NinteiChosaIraiRirekiNo getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号を返します。
     *
     * @return ikenshoIraiRirekiNo
     */
    public RString getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
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
     * 認定延期通知発行に対する同意有無が有効かどうかを返します。
     *
     * @return {@code true}:有効、{@code false}:無効
     */
    public boolean isEnkitsuchiDoiUmuKubun() {
        return enkitsuchiDoiUmuKubun;
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
     * 市町村連絡事項を返します。
     *
     * @return sichosonRenrakuJiko
     */
    public RString getSichosonRenrakuJiko() {
        return sichosonRenrakuJiko;
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
     * 取下げ理由を返します。
     *
     * @return torisageRiyu
     */
    public RString getTorisageRiyu() {
        return torisageRiyu;
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
     * 審査継続区分が有効かどうかを返します。
     *
     * @return {@code true}:有効、{@code false}:無効
     */
    public boolean isShinsaKeizokuKubun() {
        return shinsaKeizokuKubun;
    }
}
