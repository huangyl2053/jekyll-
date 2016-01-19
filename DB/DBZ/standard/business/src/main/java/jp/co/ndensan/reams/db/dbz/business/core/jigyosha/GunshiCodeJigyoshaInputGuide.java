/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.jigyosha;

import java.io.Serializable;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.gunshiku.UrT0529GunshikuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 郡市コードオブジェクトの項目定義クラスです。
 */
public class GunshiCodeJigyoshaInputGuide implements Serializable {

    private final UrT0529GunshikuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 郡市区Entity
     */
    public GunshiCodeJigyoshaInputGuide(UrT0529GunshikuEntity entity) {
        this.entity = entity;
    }

    /**
     * 都道府県コードを取得します。
     *
     * @return 都道府県コード
     */
    public RString get都道府県コード() {
        return entity.getTodofukenCode();
    }

    /**
     * 郡市区コードを取得します。
     *
     * @return 郡市区コード
     */
    public RString get郡市区コード() {
        return entity.getGunshikuCode();
    }

    /**
     * 郡市区名称を取得します。
     *
     * @return 郡市区名称
     */
    public RString get郡市区名称() {
        return entity.getGunshikuMeisho();
    }
}
