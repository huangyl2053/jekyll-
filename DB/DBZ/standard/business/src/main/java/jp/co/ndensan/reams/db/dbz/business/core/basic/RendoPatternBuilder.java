/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link RendoPattern}の編集を行うビルダークラスです。
 */
public class RendoPatternBuilder {

    private final DbT7035RendoPatternEntity entity;
    private final RendoPatternIdentifier id;

    /**
     * {@link DbT7035RendoPatternEntity}より{@link RendoPattern}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7035RendoPatternEntity}
     * @param id {@link RendoPatternIdentifier}
     *
     */
    RendoPatternBuilder(
            DbT7035RendoPatternEntity entity,
            RendoPatternIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 送信元市町村コードを設定します。
     *
     * @param 送信元市町村コード 送信元市町村コード
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set送信元市町村コード(LasdecCode 送信元市町村コード) {
        requireNonNull(送信元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元市町村コード"));
        entity.setMotoShichosonCode(送信元市町村コード);
        return this;
    }

    /**
     * 送信先市町村コードを設定します。
     *
     * @param 送信先市町村コード 送信先市町村コード
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set送信先市町村コード(LasdecCode 送信先市町村コード) {
        requireNonNull(送信先市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先市町村コード"));
        entity.setSakiShichosonCode(送信先市町村コード);
        return this;
    }

    /**
     * 種別を設定します。
     *
     * @param 種別 種別
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set種別(RString 種別) {
        requireNonNull(種別, UrSystemErrorMessages.値がnull.getReplacedMessage("種別"));
        entity.setShubetsu(種別);
        return this;
    }

    /**
     * 有効開始年月日を設定します。
     *
     * @param 有効開始年月日 有効開始年月日
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set有効開始年月日(FlexibleDate 有効開始年月日) {
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        entity.setYukoKaishiYMD(有効開始年月日);
        return this;
    }

    /**
     * 有効終了年月日を設定します。
     *
     * @param 有効終了年月日 有効終了年月日
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set有効終了年月日(FlexibleDate 有効終了年月日) {
        requireNonNull(有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月日"));
        entity.setYukoShuryoYMD(有効終了年月日);
        return this;
    }

    /**
     * 連動形態コードを設定します。
     *
     * @param 連動形態コード 連動形態コード
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set連動形態コード(RString 連動形態コード) {
        requireNonNull(連動形態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("連動形態コード"));
        entity.setRendoKeitaiCode(連動形態コード);
        return this;
    }

    /**
     * 送信元フォーマットバージョンを設定します。
     *
     * @param 送信元フォーマットバージョン 送信元フォーマットバージョン
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set送信元フォーマットバージョン(RString 送信元フォーマットバージョン) {
        requireNonNull(送信元フォーマットバージョン, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元フォーマットバージョン"));
        entity.setMotoFormatVersion(送信元フォーマットバージョン);
        return this;
    }

    /**
     * 送信元エンコーディングを設定します。
     *
     * @param 送信元エンコーディング 送信元エンコーディング
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set送信元エンコーディング(RString 送信元エンコーディング) {
        requireNonNull(送信元エンコーディング, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元エンコーディング"));
        entity.setMotoEncodeKeitai(送信元エンコーディング);
        return this;
    }

    /**
     * 送信先フォーマットバージョンを設定します。
     *
     * @param 送信先フォーマットバージョン 送信先フォーマットバージョン
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set送信先フォーマットバージョン(RString 送信先フォーマットバージョン) {
        requireNonNull(送信先フォーマットバージョン, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先フォーマットバージョン"));
        entity.setSakiFormatVersion(送信先フォーマットバージョン);
        return this;
    }

    /**
     * 送信先エンコーディングを設定します。
     *
     * @param 送信先エンコーディング 送信先エンコーディング
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set送信先エンコーディング(RString 送信先エンコーディング) {
        requireNonNull(送信先エンコーディング, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先エンコーディング"));
        entity.setSakiEncodeKeitai(送信先エンコーディング);
        return this;
    }

    /**
     * コード変換区分を設定します。
     *
     * @param コード変換区分 コード変換区分
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder setコード変換区分(RString コード変換区分) {
        requireNonNull(コード変換区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード変換区分"));
        entity.setCodeHenkanKubun(コード変換区分);
        return this;
    }

    /**
     * 外字変換区分を設定します。
     *
     * @param 外字変換区分 外字変換区分
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set外字変換区分(RString 外字変換区分) {
        requireNonNull(外字変換区分, UrSystemErrorMessages.値がnull.getReplacedMessage("外字変換区分"));
        entity.setGaijiHenkanKubun(外字変換区分);
        return this;
    }

    /**
     * 全件連動区分を設定します。
     *
     * @param 全件連動区分 全件連動区分
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set全件連動区分(RString 全件連動区分) {
        requireNonNull(全件連動区分, UrSystemErrorMessages.値がnull.getReplacedMessage("全件連動区分"));
        entity.setZenkenRendoKubun(全件連動区分);
        return this;
    }

    /**
     * 連携区分を設定します。
     *
     * @param 連携区分 連携区分
     * @return {@link RendoPatternBuilder}
     */
    public RendoPatternBuilder set連携区分(RString 連携区分) {
        requireNonNull(連携区分, UrSystemErrorMessages.値がnull.getReplacedMessage("連携区分"));
        entity.setRendoKubun(連携区分);
        return this;
    }

    /**
     * {@link RendoPattern}のインスタンスを生成します。
     *
     * @return {@link RendoPattern}のインスタンス
     */
    public RendoPattern build() {
        return new RendoPattern(entity, id);
    }
}
