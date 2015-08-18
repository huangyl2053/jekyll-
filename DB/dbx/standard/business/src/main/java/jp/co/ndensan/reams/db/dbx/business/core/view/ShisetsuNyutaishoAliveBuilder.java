/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShisetsuNyutaishoAlive}の編集を行うビルダークラスです。
 */
public class ShisetsuNyutaishoAliveBuilder {

    private final DbV1004ShisetsuNyutaishoEntity entity;
    private final ShisetsuNyutaishoAliveIdentifier id;

    /**
     * {@link DbV1004ShisetsuNyutaishoEntity}より{@link ShisetsuNyutaishoAlive}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbV1004ShisetsuNyutaishoEntity}
     * @param id {@link ShisetsuNyutaishoAliveIdentifier}
     *
     */
    ShisetsuNyutaishoAliveBuilder(
            DbV1004ShisetsuNyutaishoEntity entity,
            ShisetsuNyutaishoAliveIdentifier id
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
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 台帳種別を設定します。
     *
     * @param 台帳種別 台帳種別
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set台帳種別(RString 台帳種別) {
        requireNonNull(台帳種別, UrSystemErrorMessages.値がnull.getReplacedMessage("台帳種別"));
        entity.setDaichoShubetsu(台帳種別);
        return this;
    }

    /**
     * 入所施設種類を設定します。
     *
     * @param 入所施設種類 入所施設種類
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set入所施設種類(RString 入所施設種類) {
        requireNonNull(入所施設種類, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設種類"));
        entity.setNyushoShisetsuShurui(入所施設種類);
        return this;
    }

    /**
     * 入所施設コードを設定します。
     *
     * @param 入所施設コード 入所施設コード
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set入所施設コード(JigyoshaNo 入所施設コード) {
        requireNonNull(入所施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設コード"));
        entity.setNyushoShisetsuCode(new KaigoJigyoshaNo(入所施設コード.getColumnValue()));
        return this;
    }

    /**
     * 入所処理年月日を設定します。
     *
     * @param 入所処理年月日 入所処理年月日
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set入所処理年月日(FlexibleDate 入所処理年月日) {
        requireNonNull(入所処理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所処理年月日"));
        entity.setNyushoShoriYMD(入所処理年月日);
        return this;
    }

    /**
     * 入所年月日を設定します。
     *
     * @param 入所年月日 入所年月日
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set入所年月日(FlexibleDate 入所年月日) {
        requireNonNull(入所年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所年月日"));
        entity.setNyushoYMD(入所年月日);
        return this;
    }

    /**
     * 退所処理年月日を設定します。
     *
     * @param 退所処理年月日 退所処理年月日
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set退所処理年月日(FlexibleDate 退所処理年月日) {
        requireNonNull(退所処理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所処理年月日"));
        entity.setTaishoShoriYMD(退所処理年月日);
        return this;
    }

    /**
     * 退所年月日を設定します。
     *
     * @param 退所年月日 退所年月日
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set退所年月日(FlexibleDate 退所年月日) {
        requireNonNull(退所年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所年月日"));
        entity.setTaishoYMD(退所年月日);
        return this;
    }

    /**
     * 部屋記号番号を設定します。
     *
     * @param 部屋記号番号 部屋記号番号
     * @return {@link ShisetsuNyutaishoAliveBuilder}
     */
    public ShisetsuNyutaishoAliveBuilder set部屋記号番号(RString 部屋記号番号) {
        requireNonNull(部屋記号番号, UrSystemErrorMessages.値がnull.getReplacedMessage("部屋記号番号"));
        entity.setRoomKigoNo(部屋記号番号);
        return this;
    }

    /**
     * {@link ShisetsuNyutaishoAlive}のインスタンスを生成します。
     *
     * @return {@link ShisetsuNyutaishoAlive}のインスタンス
     */
    public ShisetsuNyutaishoAlive build() {
        return new ShisetsuNyutaishoAlive(entity, id);
    }
}
