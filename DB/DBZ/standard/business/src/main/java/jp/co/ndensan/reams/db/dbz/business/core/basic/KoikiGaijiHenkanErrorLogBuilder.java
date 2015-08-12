/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KoikiGaijiHenkanErrorLog}の編集を行うビルダークラスです。
 */
public class KoikiGaijiHenkanErrorLogBuilder {

    private final DbT7034KoikiGaijiHenkanErrorLogEntity entity;
    private final KoikiGaijiHenkanErrorLogIdentifier id;

    /**
     * {@link DbT7034KoikiGaijiHenkanErrorLogEntity}より{@link KoikiGaijiHenkanErrorLog}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7034KoikiGaijiHenkanErrorLogEntity}
     * @param id {@link KoikiGaijiHenkanErrorLogIdentifier}
     *
     */
    KoikiGaijiHenkanErrorLogBuilder(
            DbT7034KoikiGaijiHenkanErrorLogEntity entity,
            KoikiGaijiHenkanErrorLogIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 処理番号を設定します。
     *
     * @param 処理番号 処理番号
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set処理番号(RString 処理番号) {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));
        entity.setShoriNo(処理番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set連番(RString 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenNo(連番);
        return this;
    }

    /**
     * 市町村番号を設定します。
     *
     * @param 市町村番号 市町村番号
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set市町村番号(LasdecCode 市町村番号) {
        requireNonNull(市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村番号"));
        entity.setShichosonCode(市町村番号);
        return this;
    }

    /**
     * 種別を設定します。
     *
     * @param 種別 種別
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set種別(RString 種別) {
        requireNonNull(種別, UrSystemErrorMessages.値がnull.getReplacedMessage("種別"));
        entity.setShubetsu(種別);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 送信元市町村コードを設定します。
     *
     * @param 送信元市町村コード 送信元市町村コード
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set送信元市町村コード(LasdecCode 送信元市町村コード) {
        requireNonNull(送信元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元市町村コード"));
        entity.setMotoShichosonCode(送信元市町村コード);
        return this;
    }

    /**
     * 送信元市町村名称を設定します。
     *
     * @param 送信元市町村名称 送信元市町村名称
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set送信元市町村名称(RString 送信元市町村名称) {
        requireNonNull(送信元市町村名称, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元市町村名称"));
        entity.setMotoShichosonMeisho(送信元市町村名称);
        return this;
    }

    /**
     * 送信先市町村コードを設定します。
     *
     * @param 送信先市町村コード 送信先市町村コード
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set送信先市町村コード(LasdecCode 送信先市町村コード) {
        requireNonNull(送信先市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先市町村コード"));
        entity.setSakiShichosonCode(送信先市町村コード);
        return this;
    }

    /**
     * 送信先市町村名称を設定します。
     *
     * @param 送信先市町村名称 送信先市町村名称
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set送信先市町村名称(RString 送信先市町村名称) {
        requireNonNull(送信先市町村名称, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先市町村名称"));
        entity.setSakiShichosonMeisho(送信先市町村名称);
        return this;
    }

    /**
     * 住基識別コードを設定します。
     *
     * @param 住基識別コード 住基識別コード
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set住基識別コード(ShikibetsuCode 住基識別コード) {
        requireNonNull(住基識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住基識別コード"));
        entity.setJukiShikibetsuCode(住基識別コード);
        return this;
    }

    /**
     * 確認区分を設定します。
     *
     * @param 確認区分 確認区分
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set確認区分(RString 確認区分) {
        requireNonNull(確認区分, UrSystemErrorMessages.値がnull.getReplacedMessage("確認区分"));
        entity.setKakuninKubun(確認区分);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * レコードＮｏを設定します。
     *
     * @param レコードＮｏ レコードＮｏ
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder setレコードＮｏ(RString レコードＮｏ) {
        requireNonNull(レコードＮｏ, UrSystemErrorMessages.値がnull.getReplacedMessage("レコードＮｏ"));
        entity.setRecoadNo(レコードＮｏ);
        return this;
    }

    /**
     * 変換エラーフィールド名称を設定します。
     *
     * @param 変換エラーフィールド名称 変換エラーフィールド名称
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set変換エラーフィールド名称(RString 変換エラーフィールド名称) {
        requireNonNull(変換エラーフィールド名称, UrSystemErrorMessages.値がnull.getReplacedMessage("変換エラーフィールド名称"));
        entity.setErrorKomokuMeisho(変換エラーフィールド名称);
        return this;
    }

    /**
     * 変換エラーフィールドＮｏを設定します。
     *
     * @param 変換エラーフィールドＮｏ 変換エラーフィールドＮｏ
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set変換エラーフィールドＮｏ(RString 変換エラーフィールドＮｏ) {
        requireNonNull(変換エラーフィールドＮｏ, UrSystemErrorMessages.値がnull.getReplacedMessage("変換エラーフィールドＮｏ"));
        entity.setErrorKomokuNo(変換エラーフィールドＮｏ);
        return this;
    }

    /**
     * 変換エラーコードを設定します。
     *
     * @param 変換エラーコード 変換エラーコード
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder set変換エラーコード(RString 変換エラーコード) {
        requireNonNull(変換エラーコード, UrSystemErrorMessages.値がnull.getReplacedMessage("変換エラーコード"));
        entity.setErrorCode(変換エラーコード);
        return this;
    }

    /**
     * エラー表示連番を設定します。
     *
     * @param エラー表示連番 エラー表示連番
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder setエラー表示連番(RString エラー表示連番) {
        requireNonNull(エラー表示連番, UrSystemErrorMessages.値がnull.getReplacedMessage("エラー表示連番"));
        entity.setErrorHyojiRenban(エラー表示連番);
        return this;
    }

    /**
     * エラー表示フィールド名称を設定します。
     *
     * @param エラー表示フィールド名称 エラー表示フィールド名称
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder setエラー表示フィールド名称(RString エラー表示フィールド名称) {
        requireNonNull(エラー表示フィールド名称, UrSystemErrorMessages.値がnull.getReplacedMessage("エラー表示フィールド名称"));
        entity.setErrorHyojiKomokuMeisho(エラー表示フィールド名称);
        return this;
    }

    /**
     * エラー表示フィールドを設定します。
     *
     * @param エラー表示フィールド エラー表示フィールド
     * @return {@link KoikiGaijiHenkanErrorLogBuilder}
     */
    public KoikiGaijiHenkanErrorLogBuilder setエラー表示フィールド(RString エラー表示フィールド) {
        requireNonNull(エラー表示フィールド, UrSystemErrorMessages.値がnull.getReplacedMessage("エラー表示フィールド"));
        entity.setErrorHyojiKomoku(エラー表示フィールド);
        return this;
    }

    /**
     * {@link KoikiGaijiHenkanErrorLog}のインスタンスを生成します。
     *
     * @return {@link KoikiGaijiHenkanErrorLog}のインスタンス
     */
    public KoikiGaijiHenkanErrorLog build() {
        return new KoikiGaijiHenkanErrorLog(entity, id);
    }
}
