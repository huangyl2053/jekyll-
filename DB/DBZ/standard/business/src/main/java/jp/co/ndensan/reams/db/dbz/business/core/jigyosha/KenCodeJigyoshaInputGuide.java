/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.jigyosha;

import java.io.Serializable;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJushoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 県コードオブジェクトの項目定義クラスです。
 */
public class KenCodeJigyoshaInputGuide  implements Serializable {

    private final UrT0101ZenkokuJushoEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 全国住所Entity
     */
    public KenCodeJigyoshaInputGuide(UrT0101ZenkokuJushoEntity entity) {
        this.entity = entity;
    }

    /**
     * 都道府県住所コードを取得します。
     *
     * @return 都道府県住所コード
     */
    public RString get都道府県住所コード() {
        return entity.getTodofukenJushoCode();
    }

    /**
     * 都道府県名を取得します。
     *
     * @return 都道府県名
     */
    public RString get都道府県名() {
        return entity.getTodofukenName();
    }
}
