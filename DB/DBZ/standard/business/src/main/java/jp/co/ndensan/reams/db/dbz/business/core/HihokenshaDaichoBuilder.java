/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link HihokenshaDaicho}の編集を行うビルダークラスです。
 */
public class HihokenshaDaichoBuilder {

    private final DbT1001HihokenshaDaichoEntity entity;
    private final HihokenshaDaichoIdentifier id;

    /**
     * {@link DbT1001HihokenshaDaichoEntity}より{@link HihokenshaDaicho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1001HihokenshaDaichoEntity}
     * @param id {@link HihokenshaDaichoIdentifier}
     *
     */
    HihokenshaDaichoBuilder(
            DbT1001HihokenshaDaichoEntity entity,
            HihokenshaDaichoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 異動日を設定します。
     *
     * @param 異動日 異動日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set異動日(FlexibleDate 異動日) {
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        entity.setIdoYMD(異動日);
        return this;
    }

    /**
     * 枝番を設定します。
     *
     * @param 枝番 枝番
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set枝番(RString 枝番) {
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        entity.setEdaNo(枝番);
        return this;
    }

    /**
     * 異動事由コードを設定します。
     *
     * @param 異動事由コード 異動事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set異動事由コード(RString 異動事由コード) {
        requireNonNull(異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由コード"));
        entity.setIdoJiyuCode(異動事由コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 資格取得事由コードを設定します。
     *
     * @param 資格取得事由コード 資格取得事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格取得事由コード(RString 資格取得事由コード) {
        requireNonNull(資格取得事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由コード"));
        entity.setShikakuShutokuJiyuCode(資格取得事由コード);
        return this;
    }

    /**
     * 資格取得年月日を設定します。
     *
     * @param 資格取得年月日 資格取得年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格取得年月日(FlexibleDate 資格取得年月日) {
        requireNonNull(資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得年月日"));
        entity.setShikakuShutokuYMD(資格取得年月日);
        return this;
    }

    /**
     * 資格取得届出年月日を設定します。
     *
     * @param 資格取得届出年月日 資格取得届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格取得届出年月日(FlexibleDate 資格取得届出年月日) {
        requireNonNull(資格取得届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得届出年月日"));
        entity.setShikakuShutokuTodokedeYMD(資格取得届出年月日);
        return this;
    }

    /**
     * 第1号資格取得年月日を設定します。
     *
     * @param 第1号資格取得年月日 第1号資格取得年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set第1号資格取得年月日(FlexibleDate 第1号資格取得年月日) {
        requireNonNull(第1号資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("第1号資格取得年月日"));
        entity.setIchigoShikakuShutokuYMD(第1号資格取得年月日);
        return this;
    }

    /**
     * 被保険者区分コードを設定します。
     *
     * @param 被保険者区分コード 被保険者区分コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set被保険者区分コード(RString 被保険者区分コード) {
        requireNonNull(被保険者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
        entity.setHihokennshaKubunCode(被保険者区分コード);
        return this;
    }

    /**
     * 資格喪失事由コードを設定します。
     *
     * @param 資格喪失事由コード 資格喪失事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格喪失事由コード(RString 資格喪失事由コード) {
        requireNonNull(資格喪失事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由コード"));
        entity.setShikakuSoshitsuJiyuCode(資格喪失事由コード);
        return this;
    }

    /**
     * 資格喪失年月日を設定します。
     *
     * @param 資格喪失年月日 資格喪失年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格喪失年月日(FlexibleDate 資格喪失年月日) {
        requireNonNull(資格喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失年月日"));
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
        return this;
    }

    /**
     * 資格喪失届出年月日を設定します。
     *
     * @param 資格喪失届出年月日 資格喪失届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格喪失届出年月日(FlexibleDate 資格喪失届出年月日) {
        requireNonNull(資格喪失届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失届出年月日"));
        entity.setShikakuSoshitsuTodokedeYMD(資格喪失届出年月日);
        return this;
    }

    /**
     * 資格変更事由コードを設定します。
     *
     * @param 資格変更事由コード 資格変更事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格変更事由コード(RString 資格変更事由コード) {
        requireNonNull(資格変更事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更事由コード"));
        entity.setShikakuHenkoJiyuCode(資格変更事由コード);
        return this;
    }

    /**
     * 資格変更年月日を設定します。
     *
     * @param 資格変更年月日 資格変更年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格変更年月日(FlexibleDate 資格変更年月日) {
        requireNonNull(資格変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更年月日"));
        entity.setShikakuHenkoYMD(資格変更年月日);
        return this;
    }

    /**
     * 資格変更届出年月日を設定します。
     *
     * @param 資格変更届出年月日 資格変更届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格変更届出年月日(FlexibleDate 資格変更届出年月日) {
        requireNonNull(資格変更届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更届出年月日"));
        entity.setShikakuHenkoTodokedeYMD(資格変更届出年月日);
        return this;
    }

    /**
     * 住所地特例適用事由コードを設定します。
     *
     * @param 住所地特例適用事由コード 住所地特例適用事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set住所地特例適用事由コード(RString 住所地特例適用事由コード) {
        requireNonNull(住所地特例適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用事由コード"));
        entity.setJushochitokureiTekiyoJiyuCode(住所地特例適用事由コード);
        return this;
    }

    /**
     * 適用年月日を設定します。
     *
     * @param 適用年月日 適用年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set適用年月日(FlexibleDate 適用年月日) {
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        entity.setJushochitokureiTekiyoYMD(適用年月日);
        return this;
    }

    /**
     * 適用届出年月日を設定します。
     *
     * @param 適用届出年月日 適用届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set適用届出年月日(FlexibleDate 適用届出年月日) {
        requireNonNull(適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        entity.setJushochitokureiTekiyoTodokedeYMD(適用届出年月日);
        return this;
    }

    /**
     * 住所地特例解除事由コードを設定します。
     *
     * @param 住所地特例解除事由コード 住所地特例解除事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set住所地特例解除事由コード(RString 住所地特例解除事由コード) {
        requireNonNull(住所地特例解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例解除事由コード"));
        entity.setJushochitokureiKaijoJiyuCode(住所地特例解除事由コード);
        return this;
    }

    /**
     * 解除年月日を設定します。
     *
     * @param 解除年月日 解除年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set解除年月日(FlexibleDate 解除年月日) {
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setJushochitokureiKaijoYMD(解除年月日);
        return this;
    }

    /**
     * 解除届出年月日を設定します。
     *
     * @param 解除届出年月日 解除届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set解除届出年月日(FlexibleDate 解除届出年月日) {
        requireNonNull(解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        entity.setJushochitokureiKaijoTodokedeYMD(解除届出年月日);
        return this;
    }

    /**
     * 住所地特例フラグを設定します。
     *
     * @param 住所地特例フラグ 住所地特例フラグ
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set住所地特例フラグ(RString 住所地特例フラグ) {
        requireNonNull(住所地特例フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例フラグ"));
        entity.setJushochiTokureiFlag(住所地特例フラグ);
        return this;
    }

    /**
     * 広域内住所地特例フラグを設定します。
     *
     * @param 広域内住所地特例フラグ 広域内住所地特例フラグ
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set広域内住所地特例フラグ(RString 広域内住所地特例フラグ) {
        requireNonNull(広域内住所地特例フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内住所地特例フラグ"));
        entity.setKoikinaiJushochiTokureiFlag(広域内住所地特例フラグ);
        return this;
    }

    /**
     * 広住特措置元市町村コードを設定します。
     *
     * @param 広住特措置元市町村コード 広住特措置元市町村コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set広住特措置元市町村コード(LasdecCode 広住特措置元市町村コード) {
        requireNonNull(広住特措置元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("広住特措置元市町村コード"));
        entity.setKoikinaiTokureiSochimotoShichosonCode(広住特措置元市町村コード);
        return this;
    }

    /**
     * 旧市町村コードを設定します。
     *
     * @param 旧市町村コード 旧市町村コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set旧市町村コード(LasdecCode 旧市町村コード) {
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));
        entity.setKyuShichosonCode(旧市町村コード);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link HihokenshaDaicho}のインスタンスを生成します。
     *
     * @return {@link HihokenshaDaicho}のインスタンス
     */
    public HihokenshaDaicho build() {
        return new HihokenshaDaicho(entity, id);
    }
}
