/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyodoShoriyoJukyushaIdoShokanSofu}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 xupeng
 */
public class KyodoShoriyoJukyushaIdoShokanSofuBuilder {

    private final DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity;
    private final KyodoShoriyoJukyushaIdoShokanSofuIdentifier id;

    /**
     * {@link DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}より{@link KyodoShoriyoJukyushaIdoShokanSofu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}
     * @param id {@link KyodoShoriyoJukyushaIdoShokanSofuIdentifier}
     *
     */
    KyodoShoriyoJukyushaIdoShokanSofuBuilder(
            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity,
            KyodoShoriyoJukyushaIdoShokanSofuIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 異動年月日を設定します。
     *
     * @param 異動年月日 異動年月日
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set異動年月日(FlexibleDate 異動年月日) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        entity.setIdoYMD(異動年月日);
        return this;
    }

    /**
     * 異動区分コードを設定します。
     *
     * @param 異動区分コード 異動区分コード
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set異動区分コード(RString 異動区分コード) {
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        entity.setIdoKubunCode(異動区分コード);
        return this;
    }

    /**
     * 受給者異動事由を設定します。
     *
     * @param 受給者異動事由 受給者異動事由
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set受給者異動事由(RString 受給者異動事由) {
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        entity.setJukyushaIdoJiyu(受給者異動事由);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 保険給付支払一時差止開始年月日を設定します。
     *
     * @param 保険給付支払一時差止開始年月日 保険給付支払一時差止開始年月日
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set保険給付支払一時差止開始年月日(FlexibleDate 保険給付支払一時差止開始年月日) {
        entity.setHokenKyufuIchijiSashitomeKaishiYMD(保険給付支払一時差止開始年月日);
        return this;
    }

    /**
     * 保険給付支払一時差止終了年月日を設定します。
     *
     * @param 保険給付支払一時差止終了年月日 保険給付支払一時差止終了年月日
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set保険給付支払一時差止終了年月日(FlexibleDate 保険給付支払一時差止終了年月日) {
        entity.setHokenKyufuIchijiSashitomeShuryoYMD(保険給付支払一時差止終了年月日);
        return this;
    }

    /**
     * 保険給付支払一時差止区分コードを設定します。
     *
     * @param 保険給付支払一時差止区分コード 保険給付支払一時差止区分コード
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set保険給付支払一時差止区分コード(RString 保険給付支払一時差止区分コード) {
        entity.setHokenkyufuIchijiSashitomeKubunCode(保険給付支払一時差止区分コード);
        return this;
    }

    /**
     * 保険給付支払一時差止金額を設定します。
     *
     * @param 保険給付支払一時差止金額 保険給付支払一時差止金額
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set保険給付支払一時差止金額(Decimal 保険給付支払一時差止金額) {
        entity.setHokenkyufuIchijiSashitomeKingaku(保険給付支払一時差止金額);
        return this;
    }

    /**
     * 訂正連絡票フラグを設定します。
     *
     * @param 訂正連絡票フラグ 訂正連絡票フラグ
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set訂正連絡票フラグ(boolean 訂正連絡票フラグ) {
        requireNonNull(訂正連絡票フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("訂正連絡票フラグ"));
        entity.setTeiseiRenrakuhyoFlag(訂正連絡票フラグ);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set送付年月(FlexibleYearMonth 送付年月) {
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * 訂正区分コードを設定します。
     *
     * @param 訂正区分コード 訂正区分コード
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set訂正区分コード(RString 訂正区分コード) {
        entity.setTeiseiKubunCode(訂正区分コード);
        return this;
    }

    /**
     * 訂正年月日を設定します。
     *
     * @param 訂正年月日 訂正年月日
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set訂正年月日(FlexibleDate 訂正年月日) {
        entity.setTeiseiYMD(訂正年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link KyodoShoriyoJukyushaIdoShokanSofu}のインスタンスを生成します。
     *
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofu}のインスタンス
     */
    public KyodoShoriyoJukyushaIdoShokanSofu build() {
        return new KyodoShoriyoJukyushaIdoShokanSofu(entity, id);
    }
}
