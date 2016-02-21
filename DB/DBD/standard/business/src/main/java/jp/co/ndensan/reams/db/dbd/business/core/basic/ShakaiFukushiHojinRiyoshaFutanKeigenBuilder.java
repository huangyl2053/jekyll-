/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShakaiFukushiHojinRiyoshaFutanKeigen}の編集を行うビルダークラスです。
 */
public class ShakaiFukushiHojinRiyoshaFutanKeigenBuilder {

    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity;
    private final ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier id;

    /**
     * {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}より{@link ShakaiFukushiHojinRiyoshaFutanKeigen}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}
     * @param id {@link ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier}
     *
     */
    ShakaiFukushiHojinRiyoshaFutanKeigenBuilder(
            DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity,
            ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set申請事由(RString 申請事由) {
        requireNonNull(申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事由"));
        entity.setShinseiJiyu(申請事由);
        return this;
    }

    /**
     * 生活保護受給有無を設定します。
     *
     * @param 生活保護受給有無 生活保護受給有無
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set生活保護受給有無(boolean 生活保護受給有無) {
        requireNonNull(生活保護受給有無, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護受給有無"));
        entity.setSeihoJukyuUmu(生活保護受給有無);
        return this;
    }

    /**
     * 老齢福祉年金受給有無を設定します。
     *
     * @param 老齢福祉年金受給有無 老齢福祉年金受給有無
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set老齢福祉年金受給有無(boolean 老齢福祉年金受給有無) {
        requireNonNull(老齢福祉年金受給有無, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢福祉年金受給有無"));
        entity.setRoreiFukushiNenkinJukyuUmu(老齢福祉年金受給有無);
        return this;
    }

    /**
     * 生保扶助見直し特例有無を設定します。
     *
     * @param 生保扶助見直し特例有無 生保扶助見直し特例有無
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set生保扶助見直し特例有無(boolean 生保扶助見直し特例有無) {
        requireNonNull(生保扶助見直し特例有無, UrSystemErrorMessages.値がnull.getReplacedMessage("生保扶助見直し特例有無"));
        entity.setSeihoFujoMinaoshiTokureiUmu(生保扶助見直し特例有無);
        return this;
    }

    /**
     * 軽減率（分子）を設定します。
     *
     * @param 軽減率分子 軽減率（分子）
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set軽減率分子(Decimal 軽減率分子) {
        requireNonNull(軽減率分子, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率（分子）")
        );
        entity.setKeigenritsu_Bunshi(軽減率分子);
        return this;
    }

    /**
     * 軽減率（分母）を設定します。
     *
     * @param 軽減率分母 軽減率（分母）
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set軽減率分母(Decimal 軽減率分母) {
        requireNonNull(軽減率分母, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率（分母）")
        );
        entity.setKeigenritsu_Bumbo(軽減率分母);
        return this;
    }

    /**
     * 居宅サービス限定を設定します。
     *
     * @param 居宅サービス限定 居宅サービス限定
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set居宅サービス限定(boolean 居宅サービス限定) {
        requireNonNull(居宅サービス限定, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス限定"));
        entity.setKyotakuServiceGentei(居宅サービス限定);
        return this;
    }

    /**
     * 居住費・食費のみを設定します。
     *
     * @param 居住費食費のみ 居住費・食費のみ
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set居住費食費のみ(boolean 居住費食費のみ) {
        requireNonNull(居住費食費のみ, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費・食費のみ")
        );
        entity.setKyojuhiShokuhiNomi(居住費食費のみ);
        return this;
    }

    /**
     * 旧措置者ユニット型個室のみを設定します。
     *
     * @param 旧措置者ユニット型個室のみ 旧措置者ユニット型個室のみ
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set旧措置者ユニット型個室のみ(boolean 旧措置者ユニット型個室のみ) {
        requireNonNull(旧措置者ユニット型個室のみ, UrSystemErrorMessages.値がnull.getReplacedMessage("旧措置者ユニット型個室のみ"));
        entity.setKyusochishaUnitTypeKoshitsuNomi(旧措置者ユニット型個室のみ);
        return this;
    }

    /**
     * 確認番号を設定します。
     *
     * @param 確認番号 確認番号
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set確認番号(RString 確認番号) {
        requireNonNull(確認番号, UrSystemErrorMessages.値がnull.getReplacedMessage("確認番号"));
        entity.setKakuninNo(確認番号);
        return this;
    }

    /**
     * 減免区分を設定します。
     *
     * @param 減免区分 減免区分
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigenBuilder}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder set減免区分(RString 減免区分) {
        requireNonNull(減免区分, UrSystemErrorMessages.値がnull.getReplacedMessage("減免区分"));
        entity.setGemmenKubun(減免区分);
        return this;
    }

    /**
     * {@link ShakaiFukushiHojinRiyoshaFutanKeigen}のインスタンスを生成します。
     *
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigen}のインスタンス
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigen build() {
        return new ShakaiFukushiHojinRiyoshaFutanKeigen(entity, id);
    }
}
