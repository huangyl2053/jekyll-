/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChikuNinteiNinteichosaRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先情報を管理するクラスです。
 *
 * @reamsid_L DBE-0020-020 lishengli
 */
public class ChikuNinteiNinteichosa {

    private final ChikuNinteiNinteichosaRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChikuNinteiNinteichosaRelateEntity}より{@link ChikuNinteiNinteichosa}を生成します。
     *
     * @param entity DBより取得した{@link ChikuNinteiNinteichosaRelateEntity}
     */
    public ChikuNinteiNinteichosa(ChikuNinteiNinteichosaRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("対象地区"));
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
     * 認定調査委託先名称を返します。
     *
     * @return 認定調査委託先名称
     */
    public RString get認定調査委託先名称() {
        return entity.getJigyoshaMeisho();
    }
}
