/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号者台帳クラスです。
 *
 * @author n8211 田辺 紘一
 */
public class Minashi2GoshaDaicho implements IMinashi2GoshaDaicho {

    private final LasdecCode 市町村コード;
    private final ShikibetsuCode 識別コード;
    private final KaigoHihokenshaNo 被保険者番号;
    private final YMDHMS 処理日時;
    private final HihokenshaKubun 被保険者区分コード;
    private final FlexibleDate みなし2号登録年月日;
    private final FlexibleDate みなし2号解除年月日;
    //TODO n8178 城間篤人 福祉で使用されている被保険者番号に変更するか、新規で型を作る必要がある 2014年9月末
    private final RString 福祉被保険者番号;

    /**
     * インスタンスを生成します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 KaigoHihokenshaNo
     * @param 処理日時 YMDHMS
     * @param 被保険者区分コード RString
     * @param みなし2号登録年月日 FlexibleDate
     * @param みなし2号解除年月日 FlexibleDate
     * @param 福祉被保険者番号 FukushiHihokenshaNo
     * @throws NullPointerException
     * 市町村コード,識別コード,被保険者番号,処理日時,被保険者区分コード,みなし2号登録年月日がNullの場合
     */
    public Minashi2GoshaDaicho(
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            KaigoHihokenshaNo 被保険者番号,
            YMDHMS 処理日時,
            HihokenshaKubun 被保険者区分コード,
            FlexibleDate みなし2号登録年月日,
            FlexibleDate みなし2号解除年月日,
            RString 福祉被保険者番号) throws NullPointerException {
        this.市町村コード = requireNonNull(市町村コード, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("市町村コード", getClass().getName()));
        this.識別コード = requireNonNull(識別コード, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("識別コード", getClass().getName()));
        this.被保険者番号 = requireNonNull(被保険者番号, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者番号", getClass().getName()));
        this.処理日時 = requireNonNull(処理日時, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("処理日時", getClass().getName()));
        this.被保険者区分コード = requireNonNull(被保険者区分コード, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者区分コード", getClass().getName()));
        this.みなし2号登録年月日 = requireNonNull(みなし2号登録年月日, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("みなし2号登録年月日", getClass().getName()));
        this.みなし2号解除年月日 = みなし2号解除年月日;
        this.福祉被保険者番号 = 福祉被保険者番号;
    }

    @Override
    public LasdecCode get市町村コード() {
        return 市町村コード;
    }

    @Override
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    @Override
    public KaigoHihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    @Override
    public YMDHMS get処理日時() {
        return 処理日時;
    }

    @Override
    public HihokenshaKubun get被保険者区分() {
        return 被保険者区分コード;
    }

    @Override
    public FlexibleDate getみなし2号登録年月日() {
        return みなし2号登録年月日;
    }

    @Override
    public FlexibleDate getみなし2号解除年月日() {
        return みなし2号解除年月日;
    }

    @Override
    public RString get福祉被保険者番号() {
        return 福祉被保険者番号;
    }

}
