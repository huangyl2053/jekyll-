/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KoikiShichosonCodeHenkanPattern}の編集を行うビルダークラスです。
 */
public class KoikiShichosonCodeHenkanPatternBuilder {

    private final DbT7024KoikiShichosonCodeHenkanPatternEntity entity;
    private final KoikiShichosonCodeHenkanPatternIdentifier id;

    /**
     * {@link DbT7024KoikiShichosonCodeHenkanPatternEntity}より{@link KoikiShichosonCodeHenkanPattern}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7024KoikiShichosonCodeHenkanPatternEntity}
     * @param id {@link KoikiShichosonCodeHenkanPatternIdentifier}
     *
     */
    KoikiShichosonCodeHenkanPatternBuilder(
            DbT7024KoikiShichosonCodeHenkanPatternEntity entity,
            KoikiShichosonCodeHenkanPatternIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 広域内市町村番号を設定します。
     *
     * @param 広域内市町村番号 広域内市町村番号
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set広域内市町村番号(RString 広域内市町村番号) {
        requireNonNull(広域内市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内市町村番号"));
        entity.setKoikiShichosonNo(広域内市町村番号);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * コード区分を設定します。
     *
     * @param コード区分 コード区分
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder setコード区分(RString コード区分) {
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        entity.setCodeKubun(コード区分);
        return this;
    }

    /**
     * コード変換テーブル使用区分を設定します。
     *
     * @param コード変換テーブル使用区分 コード変換テーブル使用区分
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder setコード変換テーブル使用区分(RString コード変換テーブル使用区分) {
        requireNonNull(コード変換テーブル使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード変換テーブル使用区分"));
        entity.setCodeHenkanTableShiyoUmu(コード変換テーブル使用区分);
        return this;
    }

    /**
     * 自動採番区分を設定します。
     *
     * @param 自動採番区分 自動採番区分
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set自動採番区分(RString 自動採番区分) {
        requireNonNull(自動採番区分, UrSystemErrorMessages.値がnull.getReplacedMessage("自動採番区分"));
        entity.setJidoSaibanKubun(自動採番区分);
        return this;
    }

    /**
     * 市町村用コード桁数を設定します。
     *
     * @param 市町村用コード桁数 市町村用コード桁数
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set市町村用コード桁数(int 市町村用コード桁数) {
        requireNonNull(市町村用コード桁数, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村用コード桁数"));
        entity.setShichosonCodeKetasu(市町村用コード桁数);
        return this;
    }

    /**
     * 市町村用コード開始位置を設定します。
     *
     * @param 市町村用コード開始位置 市町村用コード開始位置
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set市町村用コード開始位置(int 市町村用コード開始位置) {
        requireNonNull(市町村用コード開始位置, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村用コード開始位置"));
        entity.setShichosonCodeKaishiIchi(市町村用コード開始位置);
        return this;
    }

    /**
     * 市町村用コード使用桁数を設定します。
     *
     * @param 市町村用コード使用桁数 市町村用コード使用桁数
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set市町村用コード使用桁数(int 市町村用コード使用桁数) {
        requireNonNull(市町村用コード使用桁数, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村用コード使用桁数"));
        entity.setShichosonCodeShiyoKetasu(市町村用コード使用桁数);
        return this;
    }

    /**
     * 市町村用チェックディジット有無区分を設定します。
     *
     * @param 市町村用チェックディジット有無区分 市町村用チェックディジット有無区分
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set市町村用チェックディジット有無区分(RString 市町村用チェックディジット有無区分) {
        requireNonNull(市町村用チェックディジット有無区分, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村用チェックディジット有無区分"));
        entity.setShichosonNinshoNoUmu(市町村用チェックディジット有無区分);
        return this;
    }

    /**
     * 広域用コード桁数を設定します。
     *
     * @param 広域用コード桁数 広域用コード桁数
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set広域用コード桁数(int 広域用コード桁数) {
        requireNonNull(広域用コード桁数, UrSystemErrorMessages.値がnull.getReplacedMessage("広域用コード桁数"));
        entity.setKoikiCodeKetasu(広域用コード桁数);
        return this;
    }

    /**
     * 広域用コード開始位置を設定します。
     *
     * @param 広域用コード開始位置 広域用コード開始位置
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set広域用コード開始位置(int 広域用コード開始位置) {
        requireNonNull(広域用コード開始位置, UrSystemErrorMessages.値がnull.getReplacedMessage("広域用コード開始位置"));
        entity.setKoikiCodeKaishiIchi(広域用コード開始位置);
        return this;
    }

    /**
     * 広域用コード使用桁数を設定します。
     *
     * @param 広域用コード使用桁数 広域用コード使用桁数
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set広域用コード使用桁数(int 広域用コード使用桁数) {
        requireNonNull(広域用コード使用桁数, UrSystemErrorMessages.値がnull.getReplacedMessage("広域用コード使用桁数"));
        entity.setKoikiCodeShiyoKetasu(広域用コード使用桁数);
        return this;
    }

    /**
     * 広域用チェックディジット有無区分を設定します。
     *
     * @param 広域用チェックディジット有無区分 広域用チェックディジット有無区分
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set広域用チェックディジット有無区分(RString 広域用チェックディジット有無区分) {
        requireNonNull(広域用チェックディジット有無区分, UrSystemErrorMessages.値がnull.getReplacedMessage("広域用チェックディジット有無区分"));
        entity.setKoikiNinshoNoUmu(広域用チェックディジット有無区分);
        return this;
    }

    /**
     * 広域内市町村番号付加区分を設定します。
     *
     * @param 広域内市町村番号付加区分 広域内市町村番号付加区分
     * @return {@link KoikiShichosonCodeHenkanPatternBuilder}
     */
    public KoikiShichosonCodeHenkanPatternBuilder set広域内市町村番号付加区分(RString 広域内市町村番号付加区分) {
        requireNonNull(広域内市町村番号付加区分, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内市町村番号付加区分"));
        entity.setShichosonNoFukaKubun(広域内市町村番号付加区分);
        return this;
    }

    /**
     * {@link KoikiShichosonCodeHenkanPattern}のインスタンスを生成します。
     *
     * @return {@link KoikiShichosonCodeHenkanPattern}のインスタンス
     */
    public KoikiShichosonCodeHenkanPattern build() {
        return new KoikiShichosonCodeHenkanPattern(entity, id);
    }
}
