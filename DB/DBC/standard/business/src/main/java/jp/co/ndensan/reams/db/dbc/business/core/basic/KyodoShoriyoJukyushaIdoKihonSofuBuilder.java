/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KyodoShoriyoJukyushaIdoKihonSofu}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 xupeng
 */
public class KyodoShoriyoJukyushaIdoKihonSofuBuilder {

    private final DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity;
    private final KyodoShoriyoJukyushaIdoKihonSofuIdentifier id;

    /**
     * {@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}より{@link KyodoShoriyoJukyushaIdoKihonSofu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}
     * @param id {@link KyodoShoriyoJukyushaIdoKihonSofuIdentifier}
     *
     */
    KyodoShoriyoJukyushaIdoKihonSofuBuilder(
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity,
            KyodoShoriyoJukyushaIdoKihonSofuIdentifier id
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
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set異動年月日(FlexibleDate 異動年月日) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        entity.setIdoYMD(異動年月日);
        return this;
    }

    /**
     * 異動区分コードを設定します。
     *
     * @param 異動区分コード 異動区分コード
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set異動区分コード(RString 異動区分コード) {
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        entity.setIdoKubunCode(異動区分コード);
        return this;
    }

    /**
     * 受給者異動事由を設定します。
     *
     * @param 受給者異動事由 受給者異動事由
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set受給者異動事由(RString 受給者異動事由) {
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        entity.setJukyushaIdoJiyu(受給者異動事由);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 被保険者氏名を設定します。
     *
     * @param 被保険者氏名 被保険者氏名
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set被保険者氏名(RString 被保険者氏名) {
        entity.setHiHokenshaName(被保険者氏名);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set郵便番号(YubinNo 郵便番号) {
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所カナを設定します。
     *
     * @param 住所カナ 住所カナ
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set住所カナ(RString 住所カナ) {
        entity.setDdressKana(住所カナ);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set住所(RString 住所) {
        entity.setAddress(住所);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set電話番号(TelNo 電話番号) {
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * 帳票出力順序コードを設定します。
     *
     * @param 帳票出力順序コード 帳票出力順序コード
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set帳票出力順序コード(RString 帳票出力順序コード) {
        entity.setChohyoOutputJunjyoCode(帳票出力順序コード);
        return this;
    }

    /**
     * 訂正連絡票フラグを設定します。
     *
     * @param 訂正連絡票フラグ 訂正連絡票フラグ
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set訂正連絡票フラグ(boolean 訂正連絡票フラグ) {
        requireNonNull(訂正連絡票フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("訂正連絡票フラグ"));
        entity.setTeiseiRenrakuhyoFlag(訂正連絡票フラグ);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set送付年月(FlexibleYearMonth 送付年月) {
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * 訂正区分コードを設定します。
     *
     * @param 訂正区分コード 訂正区分コード
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set訂正区分コード(RString 訂正区分コード) {
        entity.setTeiseiKubunCode(訂正区分コード);
        return this;
    }

    /**
     * 訂正年月日を設定します。
     *
     * @param 訂正年月日 訂正年月日
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set訂正年月日(FlexibleDate 訂正年月日) {
        entity.setTeiseiYMD(訂正年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link KyodoShoriyoJukyushaIdoKihonSofu}のインスタンスを生成します。
     *
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofu}のインスタンス
     */
    public KyodoShoriyoJukyushaIdoKihonSofu build() {
        return new KyodoShoriyoJukyushaIdoKihonSofu(entity, id);
    }
}
