/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hokensha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報です。
 *
 */
public class Hokensha {

    private final UrT0507HokenjaEntity entity;

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
    public Hokensha(UrT0507HokenjaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者情報"));
    }

    /**
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getHokenjaName();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenjaNo get保険者番号() {
        return entity.getHokenjaNo();
    }

}
