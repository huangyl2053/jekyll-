/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyotakuKeikakuTodokede}の編集を行うビルダークラスです。
 */
public class KyotakuKeikakuTodokedeBuilder {

    private final DbT3005KyotakuKeikakuTodokedeEntity entity;
    private final KyotakuKeikakuTodokedeIdentifier id;

    /**
     * {@link DbT3005KyotakuKeikakuTodokedeEntity}より{@link KyotakuKeikakuTodokede}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3005KyotakuKeikakuTodokedeEntity}
     * @param id {@link KyotakuKeikakuTodokedeIdentifier}
     *
     */
    KyotakuKeikakuTodokedeBuilder(
            DbT3005KyotakuKeikakuTodokedeEntity entity,
            KyotakuKeikakuTodokedeIdentifier id
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
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
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
     * {@link KyotakuKeikakuTodokede}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuTodokede}のインスタンス
     */
    public KyotakuKeikakuTodokede build() {
        return new KyotakuKeikakuTodokede(entity, id);
    }

    public KyotakuKeikakuTodokedeBuilder setKyotakuKeikakuJigyosha(KyotakuKeikakuJigyoshaSakusei createKyotakuKeikakuJigyosha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public KyotakuKeikakuTodokedeBuilder setKyotakuKeikakuJiko(KyotakuKeikakuJikoSakusei createKyotakuKeikakuJigyosha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
