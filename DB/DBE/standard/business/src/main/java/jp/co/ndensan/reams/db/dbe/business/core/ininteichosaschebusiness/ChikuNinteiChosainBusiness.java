/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ininteichosaschebusiness;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaschedule.ChikuNinteiChosainRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査スケジュール登録3Businessです。
 *
 * @reamsid_L DBE-0020-030 wanghui
 */
public class ChikuNinteiChosainBusiness {

    private final ChikuNinteiChosainRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChikuNinteiChosainRelateEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link ChikuNinteiChosainRelateEntity}
     */
    public ChikuNinteiChosainBusiness(ChikuNinteiChosainRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * get認定調査委託先を返します。
     *
     * @return 予約可能フラグ
     */
    public RString get認定調査委託先() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査委託先名称を返します。
     *
     * @return 認定調査委託先名称
     */
    public RString get認定調査委託先名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 認定調査員を返します。
     *
     * @return 認定調査員
     */
    public RString get認定調査員() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 認定調査員氏名を返します。
     *
     * @return 認定調査員氏名
     */
    public RString get認定調査員氏名() {
        return entity.getChosainShimei();
    }
}
