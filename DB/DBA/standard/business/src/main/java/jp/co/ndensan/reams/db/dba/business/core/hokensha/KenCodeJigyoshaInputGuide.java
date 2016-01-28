/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hokensha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJushoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 県コードオブジェクトです。
 */
public class KenCodeJigyoshaInputGuide {

    private final UrT0101ZenkokuJushoEntity entity;

    /**
     * <p>
     * コンストラクタです。
     * </p>
     * <p>
     * DBより取得した{@link UrT0507HokenjaEntity}より{@link Hokensha}を生成します。
     * </p>
     *
     * @param entity DBより取得した{@link UrT0507HokenjaEntity}
     */
    public KenCodeJigyoshaInputGuide(UrT0101ZenkokuJushoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("全国住所情報"));
    }

    /**
     * 都道府県住所コードを返します。
     *
     * @return 都道府県住所コード
     */
    public RString get都道府県住所コード() {
        return entity.getTodofukenJushoCode();
    }

    /**
     * 都道府県名を返します。
     *
     * @return 都道府県名
     */
    public RString get都道府県名() {
        return entity.getTodofukenName();
    }
}
