/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshujissekijoho;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosahoshujissekijoho.NinteichosahyoGaikyoChosaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託料入力Businessクラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
public class NinteichosahyoGaikyoChosaBusiness {

    private final NinteichosahyoGaikyoChosaRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link NinteichosahyoGaikyoChosaRelateEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link NinteiChosainMasterRelateEntity}
     */
    public NinteichosahyoGaikyoChosaBusiness(NinteichosahyoGaikyoChosaRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public RString get認定調査依頼履歴番号() {
        return entity.getNinteichosaRirekiNo();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getChosainCode();
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 認定調査受領年月日を返します。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return entity.getNinteichosaJuryoYMD();
    }

    /**
     * 認定調査実施場所名称を返します。
     *
     * @return 認定調査実施場所名称
     */
    public RString get認定調査実施場所名称() {
        return entity.getChosaJisshiBashoMeisho();
    }

    /**
     * 認定調査依頼年月日を返します。
     *
     * @return 認定調査依頼年月日
     */
    public FlexibleDate get認定調査依頼年月日() {
        return entity.getNinteichosaIraiYMD();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 申請区分申請時コードを返します。
     *
     * @return 申請区分申請時コード
     */
    public RString get申請区分申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public RString get履歴番号() {
        return entity.getNinteichosaIraiRirekiNo();
    }

    /**
     * 認定調査委託料を返します。
     *
     * @return 認定調査委託料
     */
    public int get認定調査委託料() {
        return entity.getChosaItakuryo();
    }

    /**
     * 認定調査委託料支払メモを返します。
     *
     * @return 認定調査委託料支払メモ
     */
    public RString get認定調査委託料支払メモ() {
        return entity.getChosaItakuryoShiharaiMemo();
    }

    /**
     * 銀行振込出力フラグを返します。
     *
     * @return 銀行振込出力フラグ
     */
    public boolean is銀行振込出力フラグ() {
        return entity.isGinkoFurikomiShutsuryoku();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 単価を返します。
     *
     * @return 単価
     */
    public RString get単価() {
        return entity.getTanka();
    }
}
