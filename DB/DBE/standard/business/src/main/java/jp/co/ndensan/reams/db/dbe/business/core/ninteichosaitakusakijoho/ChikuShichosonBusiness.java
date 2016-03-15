/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.ChikuShichosonRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査スケジュール登録9Businessです。
 */
public class ChikuShichosonBusiness {

    private final ChikuShichosonRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChikuShichosonRelateEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link NinteiChosainMasterRelateEntity}
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
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }
}
