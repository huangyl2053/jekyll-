/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員識別コードを管理するクラスです。
 */
public class SetaiinShikibetsuCd {

    private final SetaiCode 世帯コード;
    private final ShikibetsuCode 世帯員識別コード;
    private final RString 本人区分;

    /**
     * コンストラクタです。<br/>
     * 世帯員識別コードの新規作成時に使用します。
     *
     * @param 世帯コード 世帯コード
     * @param 世帯員識別コード 世帯員識別コード
     * @param 本人区分 本人区分
     */
    public SetaiinShikibetsuCd(SetaiCode 世帯コード, ShikibetsuCode 世帯員識別コード, RString 本人区分) {
        requireNonNull(世帯員識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員識別コード"));
        requireNonNull(本人区分, UrSystemErrorMessages.値がnull.getReplacedMessage("本人区分"));
        this.世帯コード = 世帯コード;
        this.世帯員識別コード = 世帯員識別コード;
        this.本人区分 = 本人区分;
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return 世帯コード;
    }

    /**
     * 世帯員識別コードを返します。
     *
     * @return 世帯員識別コード
     */
    public ShikibetsuCode get世帯員識別コード() {
        return 世帯員識別コード;
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
