/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hokenja;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報です。
 *
 */
public class Hokensha implements Serializable {

    private final UrT0507HokenjaEntity entity;
    private final HokenshaIdentifier id;

    /**
     * <p>
     * コンストラクタです。
     * </p>
     * <p>
     * 保険者情報の新規作成時に使用します。
     * </p>
     *
     * @param hokenjaShubetsu 保険者種別
     * @param hokenjaNo 保険者番号
     */
//    public Hokensha(HokenjaShubetsu hokenjaShubetsu, HokenjaNo hokenjaNo) {
//        requireNonNull(hokenjaShubetsu, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者種別"));
//        requireNonNull(hokenjaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
//        this.entity = new UrT0507HokenjaEntity();
//        this.entity.setHokenjaShubetsu(hokenjaShubetsu);
//        this.entity.setHokenjaNo(hokenjaNo);
//        this.id = new HokenshaIdentifier(hokenjaShubetsu, hokenjaNo);
//    }
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
        this.id = new HokenshaIdentifier(
                entity.getHokenjaShubetsu(),
                entity.getHokenjaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     *
     * @param entity {@link UrT0507HokenjaEntity}
     * @param id {@link HokenshaIdentifier}
     */
    Hokensha(
            UrT0507HokenjaEntity entity,
            HokenshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
