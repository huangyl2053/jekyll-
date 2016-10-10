/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TokuteiKojinJohoHanKanri}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class TokuteiKojinJohoHanKanriBuilder {

    private final DbT7301TokuteiKojinJohoHanKanriEntity entity;
    private final TokuteiKojinJohoHanKanriIdentifier id;

    /**
     * {@link DbT7301TokuteiKojinJohoHanKanriEntity}より{@link TokuteiKojinJohoHanKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7301TokuteiKojinJohoHanKanriEntity}
     * @param id {@link TokuteiKojinJohoHanKanriIdentifier}
     *
     */
    TokuteiKojinJohoHanKanriBuilder(
            DbT7301TokuteiKojinJohoHanKanriEntity entity,
            TokuteiKojinJohoHanKanriIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 特定個人情報名コードを設定します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @return {@link TokuteiKojinJohoHanKanriBuilder}
     */
    public TokuteiKojinJohoHanKanriBuilder set特定個人情報名コード(RString 特定個人情報名コード) {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        entity.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        return this;
    }

    /**
     * データセット番号を設定します。
     *
     * @param データセット番号 データセット番号
     * @return {@link TokuteiKojinJohoHanKanriBuilder}
     */
    public TokuteiKojinJohoHanKanriBuilder setデータセット番号(RString データセット番号) {
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage("データセット番号"));
        entity.setDataSetNo(データセット番号);
        return this;
    }

    /**
     * 版番号を設定します。
     *
     * @param 版番号 版番号
     * @return {@link TokuteiKojinJohoHanKanriBuilder}
     */
    public TokuteiKojinJohoHanKanriBuilder set版番号(RString 版番号) {
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage("版番号"));
        entity.setHanNo(版番号);
        return this;
    }

    /**
     * 版有効開始年月日を設定します。
     *
     * @param 版有効開始年月日 版有効開始年月日
     * @return {@link TokuteiKojinJohoHanKanriBuilder}
     */
    public TokuteiKojinJohoHanKanriBuilder set版有効開始年月日(FlexibleDate 版有効開始年月日) {
        requireNonNull(版有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("版有効開始年月日"));
        entity.setHanStYMD(版有効開始年月日);
        return this;
    }

    /**
     * 版有効終了年月日を設定します。
     *
     * @param 版有効終了年月日 版有効終了年月日
     * @return {@link TokuteiKojinJohoHanKanriBuilder}
     */
    public TokuteiKojinJohoHanKanriBuilder set版有効終了年月日(FlexibleDate 版有効終了年月日) {
        requireNonNull(版有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("版有効終了年月日"));
        entity.setHanEdYMD(版有効終了年月日);
        return this;
    }

    /**
     * 初回提供区分を設定します。
     *
     * @param 初回提供区分 初回提供区分
     * @return {@link TokuteiKojinJohoHanKanriBuilder}
     */
    public TokuteiKojinJohoHanKanriBuilder set初回提供区分(RString 初回提供区分) {
        requireNonNull(初回提供区分, UrSystemErrorMessages.値がnull.getReplacedMessage("初回提供区分"));
        entity.setShokaiTeikyoKubun(初回提供区分);
        return this;
    }

    /**
     * {@link TokuteiKojinJohoHanKanri}のインスタンスを生成します。
     *
     * @return {@link TokuteiKojinJohoHanKanri}のインスタンス
     */
    public TokuteiKojinJohoHanKanri build() {
        return new TokuteiKojinJohoHanKanri(entity, id);
    }
}
