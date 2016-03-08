/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.iknijuntsukishichosonjoho.IKijuntsukiShichosonjohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査委託先＆調査員ガイドのbusinessクラスです。
 */
public class KijuntsukiShichosonjoho {

    private final IKijuntsukiShichosonjohoRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 調査委託先＆調査員ガイドEntity
     */
    public KijuntsukiShichosonjoho(IKijuntsukiShichosonjohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査委託先コードを取得します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 事業者名称カナを取得します。
     *
     * @return 事業者名称カナ
     */
    public RString get事業者名称カナ() {
        return entity.getJigyoshaMeishoKana();
    }

    /**
     * 調査委託区分を取得します。
     *
     * @return 調査委託区分
     */
    public RString get調査委託区分() {
        return entity.getChosaItakuKubun();
    }

    /**
     * 状況フラグを取得します。
     *
     * @return 状況フラグ
     */
    public boolean is状況フラグ() {
        return entity.isJokyoFlag();
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 調査員氏名カナを取得します。
     *
     * @return 調査員氏名カナ
     */
    public RString get調査員氏名カナ() {
        return entity.getChosainKanaShimei();
    }

    /**
     * 調査員状況フラグを取得します。
     *
     * @return 調査員状況フラグ
     */
    public boolean is調査員状況フラグ() {
        return entity.isJokyoFlag2();
    }
}
