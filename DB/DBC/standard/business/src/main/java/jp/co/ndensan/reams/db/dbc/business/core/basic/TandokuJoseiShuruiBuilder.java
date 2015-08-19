/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link TandokuJoseiShurui}の編集を行うビルダークラスです。
 */
public class TandokuJoseiShuruiBuilder {

    private final DbT3099TandokuJoseiShuruiEntity entity;
    private final TandokuJoseiShuruiIdentifier id;

    /**
     * {@link DbT3099TandokuJoseiShuruiEntity}より{@link TandokuJoseiShurui}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3099TandokuJoseiShuruiEntity}
     * @param id {@link TandokuJoseiShuruiIdentifier}
     *
     */
    TandokuJoseiShuruiBuilder(
            DbT3099TandokuJoseiShuruiEntity entity,
            TandokuJoseiShuruiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 市町村単独助成種類を設定します。
     *
     * @param 市町村単独助成種類 市町村単独助成種類
     * @return {@link TandokuJoseiShuruiBuilder}
     */
    public TandokuJoseiShuruiBuilder set市町村単独助成種類(RString 市町村単独助成種類) {
        requireNonNull(市町村単独助成種類, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        entity.setTandokuJoseiShuruiCode(市町村単独助成種類);
        return this;
    }

    /**
     * 助成サービス種類コードを設定します。
     *
     * @param 助成サービス種類コード 助成サービス種類コード
     * @return {@link TandokuJoseiShuruiBuilder}
     */
    public TandokuJoseiShuruiBuilder set助成サービス種類コード(ServiceShuruiCode 助成サービス種類コード) {
        requireNonNull(助成サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("助成サービス種類コード"));
        entity.setJoseiServiceShuruiCode(助成サービス種類コード);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link TandokuJoseiShuruiBuilder}
     */
    public TandokuJoseiShuruiBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link TandokuJoseiShuruiBuilder}
     */
    public TandokuJoseiShuruiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     * @return {@link TandokuJoseiShuruiBuilder}
     */
    public TandokuJoseiShuruiBuilder set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
        return this;
    }

    /**
     * 助成サービス種類名称を設定します。
     *
     * @param 助成サービス種類名称 助成サービス種類名称
     * @return {@link TandokuJoseiShuruiBuilder}
     */
    public TandokuJoseiShuruiBuilder set助成サービス種類名称(RString 助成サービス種類名称) {
        requireNonNull(助成サービス種類名称, UrSystemErrorMessages.値がnull.getReplacedMessage("助成サービス種類名称"));
        entity.setJoseiServiceShuriMeisho(助成サービス種類名称);
        return this;
    }

    /**
     * 市町村単独助成単位を設定します。
     *
     * @param 市町村単独助成単位 市町村単独助成単位
     * @return {@link TandokuJoseiShuruiBuilder}
     */
    public TandokuJoseiShuruiBuilder set市町村単独助成単位(Decimal 市町村単独助成単位) {
        requireNonNull(市町村単独助成単位, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成単位"));
        entity.setJoseiTani(市町村単独助成単位);
        return this;
    }

    /**
     * 市町村単独助成内容を設定します。
     *
     * @param 市町村単独助成内容 市町村単独助成内容
     * @return {@link TandokuJoseiShuruiBuilder}
     */
    public TandokuJoseiShuruiBuilder set市町村単独助成内容(RString 市町村単独助成内容) {
        requireNonNull(市町村単独助成内容, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成内容"));
        entity.setJoseiNaiyo(市町村単独助成内容);
        return this;
    }

    /**
     * {@link TandokuJoseiShurui}のインスタンスを生成します。
     *
     * @return {@link TandokuJoseiShurui}のインスタンス
     */
    public TandokuJoseiShurui build() {
        return new TandokuJoseiShurui(entity, id);
    }
}
