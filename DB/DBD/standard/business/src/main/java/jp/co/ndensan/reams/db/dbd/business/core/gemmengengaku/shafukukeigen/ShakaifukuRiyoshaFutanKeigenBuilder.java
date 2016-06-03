/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link ShakaifukuRiyoshaFutanKeigen}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class ShakaifukuRiyoshaFutanKeigenBuilder {

    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity;
    private final ShakaifukuRiyoshaFutanKeigenIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}より{@link ShakaifukuRiyoshaFutanKeigen}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}
     * @param id {@link ShakaifukuRiyoshaFutanKeigenIdentifier}
     *
     */
    ShakaifukuRiyoshaFutanKeigenBuilder(
            DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity,
            ShakaifukuRiyoshaFutanKeigenIdentifier id,
            Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.gemmenGengakuShinsei = gemmenGengakuShinsei;
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set申請事由(RString 申請事由) {
        requireNonNull(申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事由"));
        entity.setShinseiJiyu(申請事由);
        return this;
    }

    /**
     * 生活保護受給有無を設定します。
     *
     * @param 生活保護受給有無 生活保護受給有無
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set生活保護受給有無(boolean 生活保護受給有無) {
        entity.setSeihoJukyuUmu(生活保護受給有無);
        return this;
    }

    /**
     * 老齢福祉年金受給有無を設定します。
     *
     * @param 老齢福祉年金受給有無 老齢福祉年金受給有無
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set老齢福祉年金受給有無(boolean 老齢福祉年金受給有無) {
        entity.setRoreiFukushiNenkinJukyuUmu(老齢福祉年金受給有無);
        return this;
    }

    /**
     * 生保扶助見直し特例有無を設定します。
     *
     * @param 生保扶助見直し特例有無 生保扶助見直し特例有無
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set生保扶助見直し特例有無(boolean 生保扶助見直し特例有無) {
        entity.setSeihoFujoMinaoshiTokureiUmu(生保扶助見直し特例有無);
        return this;
    }

    /**
     * 軽減率（分子）を設定します。
     *
     * @param 軽減率_分子 軽減率（分子）
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set軽減率_分子(Decimal 軽減率_分子) {
        entity.setKeigenritsu_Bunshi(軽減率_分子);
        return this;
    }

    /**
     * 軽減率（分母）を設定します。
     *
     * @param 軽減率_分母 軽減率（分母）
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set軽減率_分母(Decimal 軽減率_分母) {
        entity.setKeigenritsu_Bumbo(軽減率_分母);
        return this;
    }

    /**
     * 居宅サービス限定を設定します。
     *
     * @param 居宅サービス限定 居宅サービス限定
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set居宅サービス限定(boolean 居宅サービス限定) {
        entity.setKyotakuServiceGentei(居宅サービス限定);
        return this;
    }

    /**
     * 居住費・食費のみを設定します。
     *
     * @param 居住費_食費のみ 居住費・食費のみ
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set居住費_食費のみ(boolean 居住費_食費のみ) {
        entity.setKyojuhiShokuhiNomi(居住費_食費のみ);
        return this;
    }

    /**
     * 旧措置者ユニット型個室のみを設定します。
     *
     * @param 旧措置者ユニット型個室のみ 旧措置者ユニット型個室のみ
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set旧措置者ユニット型個室のみ(boolean 旧措置者ユニット型個室のみ) {
        entity.setKyusochishaUnitTypeKoshitsuNomi(旧措置者ユニット型個室のみ);
        return this;
    }

    /**
     * 確認番号を設定します。
     *
     * @param 確認番号 確認番号
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set確認番号(RString 確認番号) {
        requireNonNull(確認番号, UrSystemErrorMessages.値がnull.getReplacedMessage("確認番号"));
        entity.setKakuninNo(確認番号);
        return this;
    }

    /**
     * 減免区分を設定します。
     *
     * @param 減免区分 減免区分
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set減免区分(RString 減免区分) {
        requireNonNull(減免区分, UrSystemErrorMessages.値がnull.getReplacedMessage("減免区分"));
        entity.setGemmenKubun(減免区分);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 決定区分を設定します。
     *
     * @param 決定区分 決定区分
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set決定区分(RString 決定区分) {
        requireNonNull(決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("決定区分"));
        entity.setKetteiKubun(決定区分);
        return this;
    }

    /**
     * 非承認理由を設定します。
     *
     * @param 非承認理由 非承認理由
     * @return {@link ShakaifukuRiyoshaFutanKeigenBuilder}
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder set非承認理由(RString 非承認理由) {
        requireNonNull(非承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("非承認理由"));
        entity.setHiShoninRiyu(非承認理由);
        return this;
    }

    /**
     * 減免減額申請情報のキー情報について判定します。<br>
     * 利用者負担額減額に関連できる減免減額申請情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は合減免減額申請情報リストに減免減額申請情報{@link GemmenGengakuShinsei}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 減免減額申請情報 {@link GemmenGengakuShinsei}
     * @return {@link GogitaiJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder setGemmenGengakuShinsei(GemmenGengakuShinsei 減免減額申請情報) {
        if (hasSameIdentifier(減免減額申請情報.identifier())) {
            gemmenGengakuShinsei.add(減免減額申請情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(GemmenGengakuShinseiIdentifier 減免減額申請識別子) {
        return (id.get履歴番号() == 減免減額申請識別子.get履歴番号())
                && id.get被保険者番号().equals(減免減額申請識別子.get被保険者番号())
                && id.get証記載保険者番号().equals(減免減額申請識別子.get証記載保険者番号());
    }

    /**
     * {@link ShakaifukuRiyoshaFutanKeigen}のインスタンスを生成します。
     *
     * @return {@link ShakaifukuRiyoshaFutanKeigen}のインスタンス
     */
    public ShakaifukuRiyoshaFutanKeigen build() {
        return new ShakaifukuRiyoshaFutanKeigen(entity, id, gemmenGengakuShinsei);
    }
}
