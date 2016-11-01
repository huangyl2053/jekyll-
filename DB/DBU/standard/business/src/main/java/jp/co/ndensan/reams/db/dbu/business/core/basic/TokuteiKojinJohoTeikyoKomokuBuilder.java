/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7303TokuteiKojinJohoTeikyoKomokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TokuteiKojinJohoTeikyoKomoku}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class TokuteiKojinJohoTeikyoKomokuBuilder {

    private final DbT7303TokuteiKojinJohoTeikyoKomokuEntity entity;
    private final TokuteiKojinJohoTeikyoKomokuIdentifier id;

    /**
     * {@link DbT7303TokuteiKojinJohoTeikyoKomokuEntity}より{@link TokuteiKojinJohoTeikyoKomoku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7303TokuteiKojinJohoTeikyoKomokuEntity}
     * @param id {@link TokuteiKojinJohoTeikyoKomokuIdentifier}
     *
     */
    TokuteiKojinJohoTeikyoKomokuBuilder(
            DbT7303TokuteiKojinJohoTeikyoKomokuEntity entity,
            TokuteiKojinJohoTeikyoKomokuIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 特定個人情報名コードを設定します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @return {@link TokuteiKojinJohoTeikyoKomokuBuilder}
     */
    public TokuteiKojinJohoTeikyoKomokuBuilder set特定個人情報名コード(RString 特定個人情報名コード) {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        entity.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        return this;
    }

    /**
     * データセット番号を設定します。
     *
     * @param データセット番号 データセット番号
     * @return {@link TokuteiKojinJohoTeikyoKomokuBuilder}
     */
    public TokuteiKojinJohoTeikyoKomokuBuilder setデータセット番号(RString データセット番号) {
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage("データセット番号"));
        entity.setDataSetNo(データセット番号);
        return this;
    }

    /**
     * 版番号を設定します。
     *
     * @param 版番号 版番号
     * @return {@link TokuteiKojinJohoTeikyoKomokuBuilder}
     */
    public TokuteiKojinJohoTeikyoKomokuBuilder set版番号(RString 版番号) {
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage("版番号"));
        entity.setHanNo(版番号);
        return this;
    }

    /**
     * 特定個人情報項目コードを設定します。
     *
     * @param 特定個人情報項目コード 特定個人情報項目コード
     * @return {@link TokuteiKojinJohoTeikyoKomokuBuilder}
     */
    public TokuteiKojinJohoTeikyoKomokuBuilder set特定個人情報項目コード(RString 特定個人情報項目コード) {
        requireNonNull(特定個人情報項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報項目コード"));
        entity.setTokuteiKojinJohoKomokuCode(特定個人情報項目コード);
        return this;
    }

    /**
     * 特定個人情報項目区分を設定します。
     *
     * @param 特定個人情報項目区分 特定個人情報項目区分
     * @return {@link TokuteiKojinJohoTeikyoKomokuBuilder}
     */
    public TokuteiKojinJohoTeikyoKomokuBuilder set特定個人情報項目区分(RString 特定個人情報項目区分) {
        requireNonNull(特定個人情報項目区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報項目区分"));
        entity.setTokuteiKojinJohoKomokuKubun(特定個人情報項目区分);
        return this;
    }

    /**
     * 提供内容項目番号を設定します。
     *
     * @param 提供内容項目番号 提供内容項目番号
     * @return {@link TokuteiKojinJohoTeikyoKomokuBuilder}
     */
    public TokuteiKojinJohoTeikyoKomokuBuilder set提供内容項目番号(RString 提供内容項目番号) {
        requireNonNull(提供内容項目番号, UrSystemErrorMessages.値がnull.getReplacedMessage("提供内容項目番号"));
        entity.setTeikyoNaiyoKomokuNo(提供内容項目番号);
        return this;
    }

    /**
     * {@link TokuteiKojinJohoTeikyoKomoku}のインスタンスを生成します。
     *
     * @return {@link TokuteiKojinJohoTeikyoKomoku}のインスタンス
     */
    public TokuteiKojinJohoTeikyoKomoku build() {
        return new TokuteiKojinJohoTeikyoKomoku(entity, id);
    }
}
