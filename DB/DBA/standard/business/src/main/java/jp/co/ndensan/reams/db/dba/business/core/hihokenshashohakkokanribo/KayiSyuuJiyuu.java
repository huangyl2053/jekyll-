/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * 回収事由です。
 *
 * @reamsid_L DBA-0600-030 zhangguopeng
 */
public class KayiSyuuJiyuu {

    private final UzT0007CodeEntity entity;

    /**
     * <p>
     * コンストラクタです。
     * </p>
     * <p>
     * DBより取得した{@link UzT0007CodeEntity}より{@link KayiSyuuJiyuu}を生成します。
     * </p>
     *
     * @param entity DBより取得した{@link UzT0007CodeEntity}
     */
    public KayiSyuuJiyuu(UzT0007CodeEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("コードマスタ"));
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public Code getコード() {
        return entity.getコード();
    }

    /**
     * コード名称を返します。
     *
     * @return コード名称
     */
    public RString getコード名称() {
        return entity.getコード名称();
    }
}
