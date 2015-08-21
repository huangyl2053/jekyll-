/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.codeassigneditem.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.codeassigneditem.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護資格の情報を保持するクラスです。
 *
 * @author n8168 岩山 慎吾
 * @jpName 介護資格
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護資格
 * @mainClass
 * @reference
 * @deprecated 介護にて再設計します。
 */
public class _KaigoShikaku implements IKaigoShikaku, IKobetsuJikoKaigoShikaku {

    // TODO n3137 倉田 このクラスは使いずらいので再設計する。その中でShikakuShutokuJiyuのICodeAssignedItemの継承を解消する（URのMergeRequest#983も参照すること）2014/07/31まで
    private final ShikibetsuCode 識別コード;
    private final HokenShubetsu 保険種別;
    private final RDate 資格取得届出年月日;
    private final RDate 資格取得年月日;
    private final ShikakuShutokuJiyu 資格取得事由;
    private final RDate 資格喪失届出年月日;
    private final RDate 資格喪失年月日;
    private final ShikakuSoshitsuJiyu 資格喪失事由;
    private final RString 被保険者番号;
    private final RString 介護保険広域構成市町村コード;
    private final RDate 一号該当日;
    private final ShikakuHihokenshaKubun 資格被保険者区分;
    private final JushochiTokureishaKubun 住所地特例者区分;

    /**
     * インスタンスを生成します。
     *
     * @param 識別コード 識別コード
     * @param 保険種別 保険種別
     * @param 資格取得届出年月日 資格取得届出年月日
     * @param 資格取得年月日 資格取得年月日
     * @param 資格取得事由 資格取得事由
     * @param 資格喪失届出年月日 資格喪失届出年月日
     * @param 資格喪失年月日 資格喪失年月日
     * @param 資格喪失事由 資格喪失事由
     * @param 被保険者番号 被保険者番号
     * @param 介護保険広域構成市町村コード 介護保険広域構成市町村コード
     * @param 一号該当日 一号該当日
     * @param 資格被保険者区分 資格被保険者区分
     * @param 住所地特例者区分 住所地特例者区分
     * @throws NullPointerException 引数がNullの場合
     */
    public _KaigoShikaku(ShikibetsuCode 識別コード, HokenShubetsu 保険種別, RDate 資格取得届出年月日,
            RDate 資格取得年月日, ShikakuShutokuJiyu 資格取得事由, RDate 資格喪失届出年月日, RDate 資格喪失年月日,
            ShikakuSoshitsuJiyu 資格喪失事由, RString 被保険者番号, RString 介護保険広域構成市町村コード, RDate 一号該当日,
            ShikakuHihokenshaKubun 資格被保険者区分, JushochiTokureishaKubun 住所地特例者区分) throws NullPointerException {
        this.識別コード = requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.保険種別 = requireNonNull(保険種別, UrSystemErrorMessages.値がnull.getReplacedMessage("保険種別"));
        this.資格取得届出年月日 = 資格取得届出年月日;
        this.資格取得年月日 = requireNonNull(資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得年月日"));
        this.資格取得事由 = isNull(資格取得事由) ? new ShikakuShutokuJiyu(Code.EMPTY, RString.EMPTY, RString.EMPTY) : 資格取得事由;
        this.資格喪失届出年月日 = 資格喪失届出年月日;
        this.資格喪失年月日 = requireNonNull(資格喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失年月日"));
        this.資格喪失事由 = isNull(資格喪失事由) ? new ShikakuSoshitsuJiyu(Code.EMPTY, RString.EMPTY, RString.EMPTY) : 資格喪失事由;
        this.被保険者番号 = requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.介護保険広域構成市町村コード = requireNonNull(介護保険広域構成市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険広域構成市町村コード"));
        this.一号該当日 = 一号該当日;
        this.資格被保険者区分 = requireNonNull(資格被保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("資格被保険者区分"));
        this.住所地特例者区分 = requireNonNull(住所地特例者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例者区分"));
    }

    private <T> boolean isNull(T obj) {
        return (obj == null);
    }

    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    public HokenShubetsu get保険種別() {
        return 保険種別;
    }

    public RDate get資格取得届出年月日() {
        return 資格取得届出年月日;
    }

    @Override
    public RDate get資格取得年月日() {
        return 資格取得年月日;
    }

    @Override
    public ShikakuShutokuJiyu get資格取得事由() {
        return 資格取得事由;
    }

    public RDate get資格喪失届出年月日() {
        return 資格喪失届出年月日;
    }

    @Override
    public RDate get資格喪失年月日() {
        return 資格喪失年月日;
    }

    @Override
    public ShikakuSoshitsuJiyu get資格喪失事由() {
        return 資格喪失事由;
    }

    @Override
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    @Override
    public RString get介護保険広域構成市町村コード() {
        return 介護保険広域構成市町村コード;
    }

    @Override
    public RDate get一号該当日() {
        return 一号該当日;
    }

    public boolean is資格あり(RDate baseDate) {
        return baseDate.isBeforeOrEquals(資格喪失年月日) && 資格取得年月日.isBeforeOrEquals(baseDate);
    }

    public boolean isWapperFor(Class<?> iface) {
        return iface.isInstance(this);
    }

    public <T> T unwrap(Class<T> iface) {
        return iface.cast(this);
    }

    @Override
    public ShikakuHihokenshaKubun get資格被保険者区分() {
        return 資格被保険者区分;
    }

    @Override
    public JushochiTokureishaKubun get住所地特例者区分() {
        return 住所地特例者区分;
    }
}
