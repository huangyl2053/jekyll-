/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShikakuShutokuJogaisha}の編集を行うビルダークラスです。
 */
public class ShikakuShutokuJogaishaBuilder {

    private final DbT1009ShikakuShutokuJogaishaEntity entity;
    private final ShikakuShutokuJogaishaIdentifier id;

    /**
     * {@link DbT1009ShikakuShutokuJogaishaEntity}より{@link ShikakuShutokuJogaisha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1009ShikakuShutokuJogaishaEntity}
     * @param id {@link ShikakuShutokuJogaishaIdentifier}
     *
     */
    ShikakuShutokuJogaishaBuilder(
            DbT1009ShikakuShutokuJogaishaEntity entity,
            ShikakuShutokuJogaishaIdentifier id
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
     * @return {@link ShikakuShutokuJogaishaBuilder}
     */
    public ShikakuShutokuJogaishaBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShikakuShutokuJogaishaBuilder}
     */
    public ShikakuShutokuJogaishaBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ShikakuShutokuJogaishaBuilder}
     */
    public ShikakuShutokuJogaishaBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 資格取得除外理由を設定します。
     *
     * @param 資格取得除外理由 資格取得除外理由
     * @return {@link ShikakuShutokuJogaishaBuilder}
     */
    public ShikakuShutokuJogaishaBuilder set資格取得除外理由(RString 資格取得除外理由) {
        requireNonNull(資格取得除外理由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外理由"));
        entity.setShikakuShutokuJogaiRiyu(資格取得除外理由);
        return this;
    }

    /**
     * 資格取得除外年月日を設定します。
     *
     * @param 資格取得除外年月日 資格取得除外年月日
     * @return {@link ShikakuShutokuJogaishaBuilder}
     */
    public ShikakuShutokuJogaishaBuilder set資格取得除外年月日(FlexibleDate 資格取得除外年月日) {
        requireNonNull(資格取得除外年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外年月日"));
        entity.setShikakuShutokuJogaiYMD(資格取得除外年月日);
        return this;
    }

    /**
     * 資格取得除外解除年月日を設定します。
     *
     * @param 資格取得除外解除年月日 資格取得除外解除年月日
     * @return {@link ShikakuShutokuJogaishaBuilder}
     */
    public ShikakuShutokuJogaishaBuilder set資格取得除外解除年月日(FlexibleDate 資格取得除外解除年月日) {
        requireNonNull(資格取得除外解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外解除年月日"));
        entity.setShikakuShutokuJogaiKaijoYMD(資格取得除外解除年月日);
        return this;
    }

    /**
     * {@link ShikakuShutokuJogaisha}のインスタンスを生成します。
     *
     * @return {@link ShikakuShutokuJogaisha}のインスタンス
     */
    public ShikakuShutokuJogaisha build() {
        return new ShikakuShutokuJogaisha(entity, id);
    }
}
