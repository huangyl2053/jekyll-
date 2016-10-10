/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7302TokuteiKojinJohoKoumokuHanKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TokuteiKojinJohoKoumokuHanKanri}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class TokuteiKojinJohoKoumokuHanKanriBuilder {

    private final DbT7302TokuteiKojinJohoKoumokuHanKanriEntity entity;
    private final TokuteiKojinJohoKoumokuHanKanriIdentifier id;

    /**
     * {@link DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}より{@link TokuteiKojinJohoKoumokuHanKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}
     * @param id {@link TokuteiKojinJohoKoumokuHanKanriIdentifier}
     *
     */
    TokuteiKojinJohoKoumokuHanKanriBuilder(
            DbT7302TokuteiKojinJohoKoumokuHanKanriEntity entity,
            TokuteiKojinJohoKoumokuHanKanriIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 項番を設定します。
     *
     * @param 項番 項番
     * @return {@link TokuteiKojinJohoKoumokuHanKanriBuilder}
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder set項番(RString 項番) {
        requireNonNull(項番, UrSystemErrorMessages.値がnull.getReplacedMessage("項番"));
        entity.setKoban(項番);
        return this;
    }

    /**
     * 特定個人情報項目コードを設定します。
     *
     * @param 特定個人情報項目コード 特定個人情報項目コード
     * @return {@link TokuteiKojinJohoKoumokuHanKanriBuilder}
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder set特定個人情報項目コード(RString 特定個人情報項目コード) {
        requireNonNull(特定個人情報項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報項目コード"));
        entity.setTokuteiKojinJohoKomokuCode(特定個人情報項目コード);
        return this;
    }

    /**
     * 特定個人情報名コードを設定します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @return {@link TokuteiKojinJohoKoumokuHanKanriBuilder}
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder set特定個人情報名コード(RString 特定個人情報名コード) {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        entity.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        return this;
    }

    /**
     * コード連番を設定します。
     *
     * @param コード連番 コード連番
     * @return {@link TokuteiKojinJohoKoumokuHanKanriBuilder}
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder setコード連番(RString コード連番) {
        requireNonNull(コード連番, UrSystemErrorMessages.値がnull.getReplacedMessage("コード連番"));
        entity.setCodeRenban(コード連番);
        return this;
    }

    /**
     * バージョン情報を設定します。
     *
     * @param バージョン情報 バージョン情報
     * @return {@link TokuteiKojinJohoKoumokuHanKanriBuilder}
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder setバージョン情報(RString バージョン情報) {
        requireNonNull(バージョン情報, UrSystemErrorMessages.値がnull.getReplacedMessage("バージョン情報"));
        entity.setVersionJoho(バージョン情報);
        return this;
    }

    /**
     * 無効化フラグを設定します。
     *
     * @param 無効化フラグ 無効化フラグ
     * @return {@link TokuteiKojinJohoKoumokuHanKanriBuilder}
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder set無効化フラグ(RString 無効化フラグ) {
        requireNonNull(無効化フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("無効化フラグ"));
        entity.setMukokaFlag(無効化フラグ);
        return this;
    }

    /**
     * 有効開始日時を設定します。
     *
     * @param 有効開始日時 有効開始日時
     * @return {@link TokuteiKojinJohoKoumokuHanKanriBuilder}
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder set有効開始日時(RDateTime 有効開始日時) {
        requireNonNull(有効開始日時, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日時"));
        entity.setYukoStNichiji(有効開始日時);
        return this;
    }

    /**
     * 有効終了日時を設定します。
     *
     * @param 有効終了日時 有効終了日時
     * @return {@link TokuteiKojinJohoKoumokuHanKanriBuilder}
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder set有効終了日時(RDateTime 有効終了日時) {
        requireNonNull(有効終了日時, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了日時"));
        entity.setYukoEdNichiji(有効終了日時);
        return this;
    }

    /**
     * 特定個人情報の項目名を設定します。
     *
     * @param 特定個人情報の項目名 特定個人情報の項目名
     * @return {@link TokuteiKojinJohoKoumokuHanKanriBuilder}
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder set特定個人情報の項目名(RString 特定個人情報の項目名) {
        requireNonNull(特定個人情報の項目名, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報の項目名"));
        entity.setTokuteiKojinJohoKomokuMei(特定個人情報の項目名);
        return this;
    }

    /**
     * {@link TokuteiKojinJohoKoumokuHanKanri}のインスタンスを生成します。
     *
     * @return {@link TokuteiKojinJohoKoumokuHanKanri}のインスタンス
     */
    public TokuteiKojinJohoKoumokuHanKanri build() {
        return new TokuteiKojinJohoKoumokuHanKanri(entity, id);
    }
}
