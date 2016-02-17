/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員情報を管理するクラスです。
 */
public class SetaiinJoho {

    private final IShikibetsuTaisho 識別対象;
    private final RString 本人区分;

    /**
     * コンストラクタです。<br/>
     * 世帯員情報の新規作成時に使用します。
     *
     * @param 識別対象 識別対象
     * @param 本人区分 本人区分
     */
    public SetaiinJoho(IShikibetsuTaisho 識別対象, RString 本人区分) {
        requireNonNull(識別対象, UrSystemErrorMessages.値がnull.getReplacedMessage("識別対象"));
        requireNonNull(本人区分, UrSystemErrorMessages.値がnull.getReplacedMessage("本人区分"));
        this.識別対象 = 識別対象;
        this.本人区分 = 本人区分;
    }

    /**
     * 識別対象を返します。
     *
     * @return 識別対象
     */
    public IShikibetsuTaisho get識別対象() {
        return 識別対象;
    }

    /**
     * 本人区分を返します。
     *
     * @return 本人区分
     */
    public RString get本人区分() {
        return 本人区分;
    }
}
