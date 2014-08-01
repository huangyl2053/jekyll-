/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Minashi2GoHihokenshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * みなし2号者台帳クラスです。
 *
 * @author n8211 田辺 紘一
 */
public class Minashi2GoshaDaicho implements IMinashi2GoshaDaicho {

    private final LasdecCode 市町村コード;
    private final ShikibetsuCode 識別コード;
    private final KaigoHihokenshaNo 被保険者番号;
    private final int 履歴番号;
    private final Minashi2GoHihokenshaKubun 被保険者区分コード;
    private final FlexibleDate みなし2号登録年月日;
    private final FlexibleDate みなし2号解除年月日;

    /**
     * インスタンスを生成します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 KaigoHihokenshaNo
     * @param 履歴番号 int
     * @param 被保険者区分コード RString
     * @param みなし2号登録年月日 FlexibleDate
     * @param みなし2号解除年月日 FlexibleDate
     * @throws NullPointerException 市町村コード、識別コード、被保険者番号、履歴番号 がNullの場合エラー
     */
    public Minashi2GoshaDaicho(
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            KaigoHihokenshaNo 被保険者番号,
            int 履歴番号,
            Minashi2GoHihokenshaKubun 被保険者区分コード,
            FlexibleDate みなし2号登録年月日,
            FlexibleDate みなし2号解除年月日) throws NullPointerException {
        this.市町村コード = requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.識別コード = requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.被保険者番号 = requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.履歴番号 = 履歴番号;
        this.被保険者区分コード = requireNonNull(被保険者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
        this.みなし2号登録年月日 = requireNonNull(みなし2号登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("みなし2号登録年月日"));
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
    public Minashi2GoHihokenshaKubun get被保険者区分コード() {
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
