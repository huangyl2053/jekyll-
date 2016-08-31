/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KokiKoreishaInfo}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
public class KokiKoreishaInfoBuilder {

    private final DbT7124KokiKoreishaInfoEntity entity;
    private final KokiKoreishaInfoIdentifier id;

    /**
     * {@link DbT7124KokiKoreishaInfoEntity}より{@link KokiKoreishaInfoIdentifier}の編集用Builderクラスを生成します。
     *
     * @param entity DbT7124KokiKoreishaInfoEntity
     * @param id KokiKoreishaInfoIdentifier
     */
    KokiKoreishaInfoBuilder(DbT7124KokiKoreishaInfoEntity entity, KokiKoreishaInfoIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード ShikibetsuCode
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCd(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set履歴番号(RString 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 後期高齢保険者番号_市町村を設定します。
     *
     * @param 後期高齢保険者番号_市町村 RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set後期高齢保険者番号_市町村(RString 後期高齢保険者番号_市町村) {
        requireNonNull(後期高齢保険者番号_市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("後期高齢保険者番号_市町村"));
        entity.setKokiHokenshaNoCity(後期高齢保険者番号_市町村);
        return this;
    }

    /**
     * 後期高齢保険者番号_広域を設定します。
     *
     * @param 後期高齢保険者番号_広域 RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set後期高齢保険者番号_広域(RString 後期高齢保険者番号_広域) {
        entity.setKokiHokenshaNoKoiki(後期高齢保険者番号_広域);
        return this;
    }

    /**
     * 後期高齢被保険者番号を設定します。
     *
     * @param 後期高齢被保険者番号 RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set後期高齢被保険者番号(RString 後期高齢被保険者番号) {
        requireNonNull(後期高齢被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("後期高齢被保険者番号"));
        entity.setKokikoreiHihokenshaNo(後期高齢被保険者番号);
        return this;
    }

    /**
     * 資格取得事由コードを設定します。
     *
     * @param 資格取得事由コード RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set資格取得事由コード(RString 資格取得事由コード) {
        requireNonNull(資格取得事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由コード"));
        entity.setShikakuShutokuJiyuCode(資格取得事由コード);
        return this;
    }

    /**
     * 資格取得日を設定します。
     *
     * @param 資格取得日 RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set資格取得日(RString 資格取得日) {
        requireNonNull(資格取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得日"));
        entity.setShikakuShutokuYMD(資格取得日);
        return this;
    }

    /**
     * 資格喪失事由コードを設定します。
     *
     * @param 資格喪失事由コード RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set資格喪失事由コード(RString 資格喪失事由コード) {
        requireNonNull(資格喪失事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由コード"));
        entity.setShikakuSoshitsuJiyuCode(資格喪失事由コード);
        return this;
    }

    /**
     * 資格喪失日を設定します。
     *
     * @param 資格喪失日 RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set資格喪失日(RString 資格喪失日) {
        requireNonNull(資格喪失日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失日"));
        entity.setShikakuSoshitsuYMD(資格喪失日);
        return this;
    }

    /**
     * 保険者適用開始日を設定します。
     *
     * @param 保険者適用開始日 RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set保険者適用開始日(RString 保険者適用開始日) {
        requireNonNull(保険者適用開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者適用開始日"));
        entity.setHokenshaKaishiYMD(保険者適用開始日);
        return this;
    }

    /**
     * 保険者適用終了日を設定します。
     *
     * @param 保険者適用終了日 RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set保険者適用終了日(RString 保険者適用終了日) {
        requireNonNull(保険者適用終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者適用終了日"));
        entity.setHokenshaShuryoYMD(保険者適用終了日);
        return this;
    }

    /**
     * 個人区分コードを設定します。
     *
     * @param 個人区分コード RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set個人区分コード(RString 個人区分コード) {
        requireNonNull(個人区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("個人区分コード"));
        entity.setKojinKubunCode(個人区分コード);
        return this;
    }

    /**
     * 登録区分を設定します。
     *
     * @param 登録区分 RString
     * @return KokiKoreishaInfoBuilder
     */
    public KokiKoreishaInfoBuilder set登録区分(RString 登録区分) {
        requireNonNull(登録区分, UrSystemErrorMessages.値がnull.getReplacedMessage("登録区分"));
        entity.setTorokuKubun(登録区分);
        return this;
    }

    /**
     * {@link KokiKoreishaInfo}のインスタンスを生成します。
     *
     * @return {@link KokiKoreishaInfo}
     */
    public KokiKoreishaInfo build() {
        return new KokiKoreishaInfo(entity, id);
    }
}
