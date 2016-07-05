/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshujissekijoho;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosahoshujissekijoho.NinteiChosaHoshuJissekiJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託料入力Businessクラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
public class NinteiChosaHoshuJissekiJohoBusiness {

    private final NinteiChosaHoshuJissekiJohoRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link NinteiChosaHoshuJissekiJohoRelateEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link NinteiChosainMasterRelateEntity}
     */
    public NinteiChosaHoshuJissekiJohoBusiness(NinteiChosaHoshuJissekiJohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
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
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    public RString get調査員氏名カナ() {
        return entity.getChosainKanaShimei();
    }

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    public RString get調査員資格() {
        return entity.getChosainShikaku();
    }

    /**
     * 所属機関名称を返します。
     *
     * @return 所属機関名称
     */
    public RString get所属機関名称() {
        return entity.getShozokuKikanName();
    }

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    public boolean is状況フラグ() {
        return entity.isJokyoFlag();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }
}
