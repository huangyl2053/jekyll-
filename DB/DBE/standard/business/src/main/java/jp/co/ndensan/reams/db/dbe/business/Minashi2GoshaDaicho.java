/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号者台帳クラスです。
 *
 * @author n8211 田辺 紘一
 */
public class Minashi2GoshaDaicho implements IMinashi2GoshaDaicho {

    // TODO 田辺 紘一 〆日に間に合わず 2014/07/24
    private final LasdecCode 市町村コード;
    private final ShikibetsuCode 識別コード;
    private final KaigoHihokenshaNo 被保険者番号;
    private final int 履歴番号;
    private final RString 被保険者区分コード;
    private final FlexibleDate みなし2号登録年月日;
    private final FlexibleDate みなし2号解除年月日;

    /**
     * インスタンスを生成します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 KaigoHihokenshaNo
     * @param 履歴番号 RString
     * @param 被保険者区分コード RString
     * @param みなし2号登録年月日 FlexibleDate
     * @param みなし2号解除年月日 FlexibleDate
     */
    public Minashi2GoshaDaicho(
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            KaigoHihokenshaNo 被保険者番号,
            int 履歴番号,
            RString 被保険者区分コード,
            FlexibleDate みなし2号登録年月日,
            FlexibleDate みなし2号解除年月日) {
        this.市町村コード = requireNonNull(市町村コード, UrSystemErrorMessages.valueOf("市町村コード").getMessage());
        this.識別コード = requireNonNull(識別コード, UrSystemErrorMessages.valueOf("識別コード").getMessage());
        this.被保険者番号 = requireNonNull(被保険者番号, UrSystemErrorMessages.valueOf("被保険者番号").getMessage());
        this.履歴番号 = requireNonNull(履歴番号, UrSystemErrorMessages.valueOf("履歴番号").getMessage());
        this.被保険者区分コード = 被保険者区分コード;
        this.みなし2号登録年月日 = みなし2号登録年月日;
        this.みなし2号解除年月日 = みなし2号解除年月日;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    @Override
    public LasdecCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    @Override
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    @Override
    public KaigoHihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    @Override
    public int get履歴番号() {
        return 履歴番号;
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    @Override
    public RString get被保険者区分コード() {
        return 被保険者区分コード;
    }

    /**
     * 登録年月日を返します。
     *
     * @return 登録年月日
     */
    @Override
    public FlexibleDate getみなし2号登録年月日() {
        return みなし2号登録年月日;
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    @Override
    public FlexibleDate getみなし2号解除年月日() {
        return みなし2号解除年月日;
    }
}
