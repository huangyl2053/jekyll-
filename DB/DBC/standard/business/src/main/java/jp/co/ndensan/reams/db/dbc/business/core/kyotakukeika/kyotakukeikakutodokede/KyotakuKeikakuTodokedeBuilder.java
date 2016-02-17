/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakutodokede;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujigyoshasakusei.KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujigyoshasakusei.KyotakuKeikakuJigyoshaSakuseiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KyotakuKeikakuTodokede}の編集を行うビルダークラスです。
 */
public class KyotakuKeikakuTodokedeBuilder {

    private final DbT3005KyotakuKeikakuTodokedeEntity entity;
    private final KyotakuKeikakuTodokedeIdentifier id;
    private final Models<KyotakuKeikakuJikoSakuseiIdentifier, KyotakuKeikakuJikoSakusei> kyotakuKeikakuJikoSakusei;
    private final Models<KyotakuKeikakuJigyoshaSakuseiIdentifier, KyotakuKeikakuJigyoshaSakusei> kyotakuKeikakuJigyoshaSakusei;

    /**
     * {@link DbT3005KyotakuKeikakuTodokedeEntity}より{@link KyotakuKeikakuTodokede}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3005KyotakuKeikakuTodokedeEntity}
     * @param id {@link KyotakuKeikakuTodokedeIdentifier}
     * @param kyotakuKeikakuJikoSakusei {@link Models}
     * @param kyotakuKeikakuJigyoshaSakusei {@link Models}
     *
     */
    KyotakuKeikakuTodokedeBuilder(
            DbT3005KyotakuKeikakuTodokedeEntity entity,
            KyotakuKeikakuTodokedeIdentifier id,
            Models<KyotakuKeikakuJikoSakuseiIdentifier, KyotakuKeikakuJikoSakusei> kyotakuKeikakuJikoSakusei,
            Models<KyotakuKeikakuJigyoshaSakuseiIdentifier, KyotakuKeikakuJigyoshaSakusei> kyotakuKeikakuJigyoshaSakusei
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.kyotakuKeikakuJikoSakusei = kyotakuKeikakuJikoSakusei.clone();
        this.kyotakuKeikakuJigyoshaSakusei = kyotakuKeikakuJigyoshaSakusei.clone();
    }

    /**
     * 届出区分を設定します。
     *
     * @param 届出区分 届出区分
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set届出区分(RString 届出区分) {
        requireNonNull(届出区分, UrSystemErrorMessages.値がnull.getReplacedMessage("届出区分"));
        entity.setTodokedeKubun(届出区分);
        return this;
    }

    /**
     * 届出年月日を設定します。
     *
     * @param 届出年月日 届出年月日
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set届出年月日(FlexibleDate 届出年月日) {
        requireNonNull(届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("届出年月日"));
        entity.setTodokedeYMD(届出年月日);
        return this;
    }

    /**
     * 届出者氏名を設定します。
     *
     * @param 届出者氏名 届出者氏名
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set届出者氏名(AtenaMeisho 届出者氏名) {
        requireNonNull(届出者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者氏名"));
        entity.setTodokedeshaShimei(届出者氏名);
        return this;
    }

    /**
     * 届出者氏名カナを設定します。
     *
     * @param 届出者氏名カナ 届出者氏名カナ
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set届出者氏名カナ(AtenaKanaMeisho 届出者氏名カナ) {
        requireNonNull(届出者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者氏名カナ"));
        entity.setTodokedeshaShimeiKana(届出者氏名カナ);
        return this;
    }

    /**
     * 届出者郵便番号を設定します。
     *
     * @param 届出者郵便番号 届出者郵便番号
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set届出者郵便番号(YubinNo 届出者郵便番号) {
        requireNonNull(届出者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者郵便番号"));
        entity.setTodokedeshaYubinNo(届出者郵便番号);
        return this;
    }

    /**
     * 届出者住所を設定します。
     *
     * @param 届出者住所 届出者住所
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set届出者住所(RString 届出者住所) {
        requireNonNull(届出者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者住所"));
        entity.setTodokedeshaJusho(届出者住所);
        return this;
    }

    /**
     * 届出者電話番号を設定します。
     *
     * @param 届出者電話番号 届出者電話番号
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set届出者電話番号(TelNo 届出者電話番号) {
        requireNonNull(届出者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者電話番号"));
        entity.setTodokedeshaTelNo(届出者電話番号);
        return this;
    }

    /**
     * 届出者関係区分を設定します。
     *
     * @param 届出者関係区分 届出者関係区分
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set届出者関係区分(RString 届出者関係区分) {
        requireNonNull(届出者関係区分, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者関係区分"));
        entity.setTodokedeshaKankeiKubun(届出者関係区分);
        return this;
    }

    /**
     * 暫定区分を設定します。
     *
     * @param 暫定区分 暫定区分
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set暫定区分(RString 暫定区分) {
        requireNonNull(暫定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("暫定区分"));
        entity.setZanteiKubun(暫定区分);
        return this;
    }

    /**
     * 居宅給付計画自己作成のキー情報について判定します。<br>
     * 居宅給付計画自己作成に関連できる居宅給付計画自己作成である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は居宅給付計画自己作成リストに居宅給付計画自己作成{@link KyotakuKeikakuJikoSakusei}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 居宅給付計画自己作成 {@link KyotakuKeikakuJikoSakusei}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public KyotakuKeikakuTodokedeBuilder setKyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakusei 居宅給付計画自己作成) {
        if (hasSameIdentifier(居宅給付計画自己作成.identifier())) {
            kyotakuKeikakuJikoSakusei.add(居宅給付計画自己作成);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KyotakuKeikakuJikoSakuseiIdentifier 居宅給付計画自己作成識別子) {
        return (id.get対象年月().equals(居宅給付計画自己作成識別子.get対象年月())
                && id.get被保険者番号().equals(居宅給付計画自己作成識別子.get被保険者番号())
                && id.get履歴番号() == 居宅給付計画自己作成識別子.get履歴番号());
    }

    /**
     * 居宅給付計画事業者作成のキー情報について判定します。<br>
     * 居宅給付計画事業者作成に関連できる居宅給付計画事業者作成である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は居宅給付計画事業者作成リストに居宅給付計画事業者作成{@link KyotakuKeikakuJigyoshaSakusei}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 居宅給付計画事業者作成 {@link KyotakuKeikakuJigyoshaSakusei}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public KyotakuKeikakuTodokedeBuilder setKyotakuKeikakuJigyoshaSakusei(KyotakuKeikakuJigyoshaSakusei 居宅給付計画事業者作成) {
        if (hasSameIdentifier(居宅給付計画事業者作成.identifier())) {
            kyotakuKeikakuJigyoshaSakusei.add(居宅給付計画事業者作成);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KyotakuKeikakuJigyoshaSakuseiIdentifier 居宅給付計画事業者作成識別子) {
        return (id.get対象年月().equals(居宅給付計画事業者作成識別子.get対象年月())
                && id.get被保険者番号().equals(居宅給付計画事業者作成識別子.get被保険者番号())
                && id.get履歴番号() == 居宅給付計画事業者作成識別子.get履歴番号());
    }

    /**
     * {@link KyotakuKeikakuTodokede}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuTodokede}のインスタンス
     */
    public KyotakuKeikakuTodokede build() {
        return new KyotakuKeikakuTodokede(entity, id, kyotakuKeikakuJikoSakusei, kyotakuKeikakuJigyoshaSakusei);
    }
}
