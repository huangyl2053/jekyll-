/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import static java.util.Objects.requireNonNull;

/**
 * 対象者を特定するキー情報です。（資格系）
 *
 * @author N8156 宮本 康
 */
public class TaishoshaKey implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final ShikibetsuCode 識別コード;
    private final SetaiCode 世帯コード;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 世帯コード 世帯コード
     * @throws NullPointerException 引数がnullの時
     */
    public TaishoshaKey(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, SetaiCode 世帯コード) throws NullPointerException {
        this.被保険者番号 = requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.識別コード = requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.世帯コード = requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return 世帯コード;
    }
}
