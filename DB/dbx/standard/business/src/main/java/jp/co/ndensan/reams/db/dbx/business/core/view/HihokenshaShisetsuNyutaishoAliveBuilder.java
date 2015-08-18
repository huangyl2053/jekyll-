/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link HihokenshaShisetsuNyutaishoAlive}の編集を行うビルダークラスです。
 */
public class HihokenshaShisetsuNyutaishoAliveBuilder {

    private final DbV1004HihokenshaShisetsuNyutaishoEntity entity;
    private final HihokenshaShisetsuNyutaishoAliveIdentifier id;

    /**
     * {@link DbV1004HihokenshaShisetsuNyutaishoEntity}より{@link HihokenshaShisetsuNyutaishoAlive}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbV1004HihokenshaShisetsuNyutaishoEntity}
     * @param id {@link HihokenshaShisetsuNyutaishoAliveIdentifier}
     *
     */
    HihokenshaShisetsuNyutaishoAliveBuilder(
            DbV1004HihokenshaShisetsuNyutaishoEntity entity,
            HihokenshaShisetsuNyutaishoAliveIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link HihokenshaShisetsuNyutaishoAliveBuilder}
     */
    public HihokenshaShisetsuNyutaishoAliveBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link HihokenshaShisetsuNyutaishoAliveBuilder}
     */
    public HihokenshaShisetsuNyutaishoAliveBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link HihokenshaShisetsuNyutaishoAliveBuilder}
     */
    public HihokenshaShisetsuNyutaishoAliveBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 台帳種別を設定します。
     *
     * @param 台帳種別 台帳種別
     * @return {@link HihokenshaShisetsuNyutaishoAliveBuilder}
     */
    public HihokenshaShisetsuNyutaishoAliveBuilder set台帳種別(RString 台帳種別) {
        requireNonNull(台帳種別, UrSystemErrorMessages.値がnull.getReplacedMessage("台帳種別"));
        entity.setDaichoShubetsu(台帳種別);
        return this;
    }

    /**
     * 入所施設種類を設定します。
     *
     * @param 入所施設種類 入所施設種類
     * @return {@link HihokenshaShisetsuNyutaishoAliveBuilder}
     */
    public HihokenshaShisetsuNyutaishoAliveBuilder set入所施設種類(RString 入所施設種類) {
        requireNonNull(入所施設種類, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設種類"));
        entity.setNyushoShisetsuShurui(入所施設種類);
        return this;
    }

    /**
     * 入所施設コードを設定します。
     *
     * @param 入所施設コード 入所施設コード
     * @return {@link HihokenshaShisetsuNyutaishoAliveBuilder}
     */
    public HihokenshaShisetsuNyutaishoAliveBuilder set入所施設コード(JigyoshaNo 入所施設コード) {
        requireNonNull(入所施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設コード"));
        entity.setNyushoShisetsuCode(new KaigoJigyoshaNo(入所施設コード.getColumnValue()));
        return this;
    }

    /**
     * 入所年月日を設定します。
     *
     * @param 入所年月日 入所年月日
     * @return {@link HihokenshaShisetsuNyutaishoAliveBuilder}
     */
    public HihokenshaShisetsuNyutaishoAliveBuilder set入所年月日(FlexibleDate 入所年月日) {
        requireNonNull(入所年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所年月日"));
        entity.setNyushoYMD(入所年月日);
        return this;
    }

    /**
     * 退所年月日を設定します。
     *
     * @param 退所年月日 退所年月日
     * @return {@link HihokenshaShisetsuNyutaishoAliveBuilder}
     */
    public HihokenshaShisetsuNyutaishoAliveBuilder set退所年月日(FlexibleDate 退所年月日) {
        requireNonNull(退所年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所年月日"));
        entity.setTaishoYMD(退所年月日);
        return this;
    }

    /**
     * {@link HihokenshaShisetsuNyutaishoAlive}のインスタンスを生成します。
     *
     * @return {@link HihokenshaShisetsuNyutaishoAlive}のインスタンス
     */
    public HihokenshaShisetsuNyutaishoAlive build() {
        return new HihokenshaShisetsuNyutaishoAlive(entity, id);
    }
}
