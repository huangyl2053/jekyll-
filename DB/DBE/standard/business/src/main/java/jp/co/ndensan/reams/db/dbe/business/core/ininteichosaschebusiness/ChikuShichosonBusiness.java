/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ininteichosaschebusiness;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaschedule.ChikuShichosonRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査スケジュール登録3Businessです。
 *
 * @reamsid_L DBE-0020-030 wanghui
 */
public class ChikuShichosonBusiness {

    private final ChikuShichosonRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChikuShichosonRelateEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link ChikuShichosonRelateEntity}
     */
    public ChikuShichosonBusiness(ChikuShichosonRelateEntity entity) {
        this.entity = entity;
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

}
