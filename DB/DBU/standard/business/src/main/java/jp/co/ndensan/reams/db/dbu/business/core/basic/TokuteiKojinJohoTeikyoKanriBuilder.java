/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7304TokuteiKojinJohoTeikyoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TokuteiKojinJohoTeikyoKanri}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class TokuteiKojinJohoTeikyoKanriBuilder {

    private final DbT7304TokuteiKojinJohoTeikyoKanriEntity entity;
    private final TokuteiKojinJohoTeikyoKanriIdentifier id;

    /**
     * {@link DbT7304TokuteiKojinJohoTeikyoKanriEntity}より{@link TokuteiKojinJohoTeikyoKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7304TokuteiKojinJohoTeikyoKanriEntity}
     * @param id {@link TokuteiKojinJohoTeikyoKanriIdentifier}
     *
     */
    TokuteiKojinJohoTeikyoKanriBuilder(
            DbT7304TokuteiKojinJohoTeikyoKanriEntity entity,
            TokuteiKojinJohoTeikyoKanriIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * データセットレコードキーを設定します。
     *
     * @param データセットレコードキー データセットレコードキー
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder setデータセットレコードキー(RString データセットレコードキー) {
        requireNonNull(データセットレコードキー, UrSystemErrorMessages.値がnull.getReplacedMessage("データセットレコードキー"));
        entity.setDataSetRecordKey(データセットレコードキー);
        return this;
    }

    /**
     * 提供日時を設定します。
     *
     * @param 提供日時 提供日時
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set提供日時(RDateTime 提供日時) {
        requireNonNull(提供日時, UrSystemErrorMessages.値がnull.getReplacedMessage("提供日時"));
        entity.setTeikyoNichiji(提供日時);
        return this;
    }

    /**
     * 新規異動区分を設定します。
     *
     * @param 新規異動区分 新規異動区分
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set新規異動区分(RString 新規異動区分) {
        requireNonNull(新規異動区分, UrSystemErrorMessages.値がnull.getReplacedMessage("新規異動区分"));
        entity.setShinkiIdoKubun(新規異動区分);
        return this;
    }

    /**
     * 提供区分を設定します。
     *
     * @param 提供区分 提供区分
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set提供区分(RString 提供区分) {
        requireNonNull(提供区分, UrSystemErrorMessages.値がnull.getReplacedMessage("提供区分"));
        entity.setTeikyoKubun(提供区分);
        return this;
    }

    /**
     * 特定個人情報名コードを設定します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set特定個人情報名コード(RString 特定個人情報名コード) {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        entity.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        return this;
    }

    /**
     * 版番号を設定します。
     *
     * @param 版番号 版番号
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set版番号(RString 版番号) {
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage("版番号"));
        entity.setHanNo(版番号);
        return this;
    }

    /**
     * データセット番号を設定します。
     *
     * @param データセット番号 データセット番号
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder setデータセット番号(RString データセット番号) {
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage("データセット番号"));
        entity.setDataSetNo(データセット番号);
        return this;
    }

    /**
     * 公開年月日を設定します。
     *
     * @param 公開年月日 公開年月日
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set公開年月日(FlexibleDate 公開年月日) {
        requireNonNull(公開年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("公開年月日"));
        entity.setKokaiYMD(公開年月日);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setTateNo(識別コード);
        return this;
    }

    /**
     * 送信内容１を設定します。
     *
     * @param 送信内容１ 送信内容１
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容１(RString 送信内容１) {
        requireNonNull(送信内容１, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容１"));
        entity.setSoshinNaiyo01(送信内容１);
        return this;
    }

    /**
     * 未設定事由１を設定します。
     *
     * @param 未設定事由１ 未設定事由１
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由１(RString 未設定事由１) {
        requireNonNull(未設定事由１, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由１"));
        entity.setMisetteiJiyu01(未設定事由１);
        return this;
    }

    /**
     * 送信内容２を設定します。
     *
     * @param 送信内容２ 送信内容２
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容２(RString 送信内容２) {
        requireNonNull(送信内容２, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容２"));
        entity.setSoshinNaiyo02(送信内容２);
        return this;
    }

    /**
     * 未設定事由２を設定します。
     *
     * @param 未設定事由２ 未設定事由２
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由２(RString 未設定事由２) {
        requireNonNull(未設定事由２, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由２"));
        entity.setMisetteiJiyu02(未設定事由２);
        return this;
    }

    /**
     * 送信内容３を設定します。
     *
     * @param 送信内容３ 送信内容３
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容３(RString 送信内容３) {
        requireNonNull(送信内容３, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容３"));
        entity.setSoshinNaiyo03(送信内容３);
        return this;
    }

    /**
     * 未設定事由３を設定します。
     *
     * @param 未設定事由３ 未設定事由３
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由３(RString 未設定事由３) {
        requireNonNull(未設定事由３, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由３"));
        entity.setMisetteiJiyu03(未設定事由３);
        return this;
    }

    /**
     * 送信内容４を設定します。
     *
     * @param 送信内容４ 送信内容４
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容４(RString 送信内容４) {
        requireNonNull(送信内容４, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容４"));
        entity.setSoshinNaiyo04(送信内容４);
        return this;
    }

    /**
     * 未設定事由４を設定します。
     *
     * @param 未設定事由４ 未設定事由４
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由４(RString 未設定事由４) {
        requireNonNull(未設定事由４, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由４"));
        entity.setMisetteiJiyu04(未設定事由４);
        return this;
    }

    /**
     * 送信内容５を設定します。
     *
     * @param 送信内容５ 送信内容５
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容５(RString 送信内容５) {
        requireNonNull(送信内容５, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容５"));
        entity.setSoshinNaiyo05(送信内容５);
        return this;
    }

    /**
     * 未設定事由５を設定します。
     *
     * @param 未設定事由５ 未設定事由５
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由５(RString 未設定事由５) {
        requireNonNull(未設定事由５, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由５"));
        entity.setMisetteiJiyu05(未設定事由５);
        return this;
    }

    /**
     * 送信内容６を設定します。
     *
     * @param 送信内容６ 送信内容６
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容６(RString 送信内容６) {
        requireNonNull(送信内容６, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容６"));
        entity.setSoshinNaiyo06(送信内容６);
        return this;
    }

    /**
     * 未設定事由６を設定します。
     *
     * @param 未設定事由６ 未設定事由６
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由６(RString 未設定事由６) {
        requireNonNull(未設定事由６, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由６"));
        entity.setMisetteiJiyu06(未設定事由６);
        return this;
    }

    /**
     * 送信内容７を設定します。
     *
     * @param 送信内容７ 送信内容７
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容７(RString 送信内容７) {
        requireNonNull(送信内容７, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容７"));
        entity.setSoshinNaiyo07(送信内容７);
        return this;
    }

    /**
     * 未設定事由７を設定します。
     *
     * @param 未設定事由７ 未設定事由７
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由７(RString 未設定事由７) {
        requireNonNull(未設定事由７, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由７"));
        entity.setMisetteiJiyu07(未設定事由７);
        return this;
    }

    /**
     * 送信内容８を設定します。
     *
     * @param 送信内容８ 送信内容８
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容８(RString 送信内容８) {
        requireNonNull(送信内容８, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容８"));
        entity.setSoshinNaiyo08(送信内容８);
        return this;
    }

    /**
     * 未設定事由８を設定します。
     *
     * @param 未設定事由８ 未設定事由８
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由８(RString 未設定事由８) {
        requireNonNull(未設定事由８, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由８"));
        entity.setMisetteiJiyu08(未設定事由８);
        return this;
    }

    /**
     * 送信内容９を設定します。
     *
     * @param 送信内容９ 送信内容９
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容９(RString 送信内容９) {
        requireNonNull(送信内容９, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容９"));
        entity.setSoshinNaiyo09(送信内容９);
        return this;
    }

    /**
     * 未設定事由９を設定します。
     *
     * @param 未設定事由９ 未設定事由９
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由９(RString 未設定事由９) {
        requireNonNull(未設定事由９, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由９"));
        entity.setMisetteiJiyu09(未設定事由９);
        return this;
    }

    /**
     * 送信内容１０を設定します。
     *
     * @param 送信内容１０ 送信内容１０
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set送信内容１０(RString 送信内容１０) {
        requireNonNull(送信内容１０, UrSystemErrorMessages.値がnull.getReplacedMessage("送信内容１０"));
        entity.setSoshinNaiyo10(送信内容１０);
        return this;
    }

    /**
     * 未設定事由１０を設定します。
     *
     * @param 未設定事由１０ 未設定事由１０
     * @return {@link TokuteiKojinJohoTeikyoKanriBuilder}
     */
    public TokuteiKojinJohoTeikyoKanriBuilder set未設定事由１０(RString 未設定事由１０) {
        requireNonNull(未設定事由１０, UrSystemErrorMessages.値がnull.getReplacedMessage("未設定事由１０"));
        entity.setMisetteiJiyu10(未設定事由１０);
        return this;
    }

    /**
     * {@link TokuteiKojinJohoTeikyoKanri}のインスタンスを生成します。
     *
     * @return {@link TokuteiKojinJohoTeikyoKanri}のインスタンス
     */
    public TokuteiKojinJohoTeikyoKanri build() {
        return new TokuteiKojinJohoTeikyoKanri(entity, id);
    }
}
