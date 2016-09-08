/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link FutanGendogakuNintei}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class FutanGendogakuNinteiBuilder {

    private final DbT4018KaigoHokenFutanGendogakuNinteiEntity entity;
    private final FutanGendogakuNinteiIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * {@link DbT4018KaigoHokenFutanGendogakuNinteiEntity}より{@link FutanGendogakuNintei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4018KaigoHokenFutanGendogakuNinteiEntity}
     * @param id {@link FutanGendogakuNinteiIdentifier}
     *
     */
    FutanGendogakuNinteiBuilder(
            DbT4018KaigoHokenFutanGendogakuNinteiEntity entity,
            FutanGendogakuNinteiIdentifier id,
            Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.gemmenGengakuShinsei = gemmenGengakuShinsei;
    }

    /**
     * 旧措置者区分を設定します。
     *
     * @param 旧措置者区分 旧措置者区分
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set旧措置者区分(RString 旧措置者区分) {
        requireNonNull(旧措置者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("旧措置者区分"));
        entity.setKyusochishaKubun(旧措置者区分);
        return this;
    }

    /**
     * 申請理由区分を設定します。
     *
     * @param 申請理由区分 申請理由区分
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set申請理由区分(RString 申請理由区分) {
        requireNonNull(申請理由区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請理由区分"));
        entity.setShinseiRiyuKubun(申請理由区分);
        return this;
    }

    /**
     * 利用者負担段階を設定します。
     *
     * @param 利用者負担段階 利用者負担段階
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set利用者負担段階(RString 利用者負担段階) {
        requireNonNull(利用者負担段階, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担段階"));
        entity.setRiyoshaFutanDankai(利用者負担段階);
        return this;
    }

    /**
     * 境界層該当者区分を設定します。
     *
     * @param 境界層該当者区分 境界層該当者区分
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set境界層該当者区分(boolean 境界層該当者区分) {
        entity.setKyokaisoGaitoshaKubun(境界層該当者区分);
        return this;
    }

    /**
     * 激変緩和措置対象者区分を設定します。
     *
     * @param 激変緩和措置対象者区分 激変緩和措置対象者区分
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set激変緩和措置対象者区分(boolean 激変緩和措置対象者区分) {
        entity.setGekihenKanwaSochiTaishoshaKubun(激変緩和措置対象者区分);
        return this;
    }

    /**
     * 居室種別を設定します。
     *
     * @param 居室種別 居室種別
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set居室種別(RString 居室種別) {
        requireNonNull(居室種別, UrSystemErrorMessages.値がnull.getReplacedMessage("居室種別"));
        entity.setKyoshitsuShubetsu(居室種別);
        return this;
    }

    /**
     * 食費負担限度額を設定します。
     *
     * @param 食費負担限度額 食費負担限度額
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set食費負担限度額(Decimal 食費負担限度額) {
        entity.setShokuhiFutanGendogaku(食費負担限度額);
        return this;
    }

    /**
     * ユニット型個室を設定します。
     *
     * @param ユニット型個室 ユニット型個室
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder setユニット型個室(Decimal ユニット型個室) {
        entity.setUnitTypeKoshitsu(ユニット型個室);
        return this;
    }

    /**
     * ユニット型準個室を設定します。
     *
     * @param ユニット型準個室 ユニット型準個室
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder setユニット型準個室(Decimal ユニット型準個室) {
        entity.setUnitTypeJunKoshitsu(ユニット型準個室);
        return this;
    }

    /**
     * 従来型個室（特養等）を設定します。
     *
     * @param 従来型個室_特養等 従来型個室（特養等）
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set従来型個室_特養等(Decimal 従来型個室_特養等) {
        entity.setJuraiTypeKoshitsu_Tokuyo(従来型個室_特養等);
        return this;
    }

    /**
     * 従来型個室（老健・療養等）を設定します。
     *
     * @param 従来型個室_老健_療養等 従来型個室（老健・療養等）
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set従来型個室_老健_療養等(Decimal 従来型個室_老健_療養等) {
        entity.setJuraiTypeKoshitsu_Roken_Ryoyo(従来型個室_老健_療養等);
        return this;
    }

    /**
     * 多床室を設定します。
     *
     * @param 多床室 多床室
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set多床室(Decimal 多床室) {
        entity.setTashoshitsu(多床室);
        return this;
    }

    /**
     * 配偶者の有無を設定します。
     *
     * @param 配偶者の有無 配偶者の有無
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set配偶者の有無(boolean 配偶者の有無) {
        entity.setHaigushaUmuFlag(配偶者の有無);
        return this;
    }

    /**
     * 配偶者氏名を設定します。
     *
     * @param 配偶者氏名 配偶者氏名
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set配偶者氏名(AtenaMeisho 配偶者氏名) {
        requireNonNull(配偶者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("配偶者氏名"));
        entity.setHaigushaShimei(配偶者氏名);
        return this;
    }

    /**
     * 配偶者氏名カナを設定します。
     *
     * @param 配偶者氏名カナ 配偶者氏名カナ
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set配偶者氏名カナ(AtenaKanaMeisho 配偶者氏名カナ) {
        requireNonNull(配偶者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("配偶者氏名カナ"));
        entity.setHaigushaShimeiKana(配偶者氏名カナ);
        return this;
    }

    /**
     * 配偶者生年月日を設定します。
     *
     * @param 配偶者生年月日 配偶者生年月日
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set配偶者生年月日(FlexibleDate 配偶者生年月日) {
//        requireNonNull(配偶者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("配偶者生年月日"));
        entity.setHaigushaSeinenGappiYMD(配偶者生年月日);
        return this;
    }

    /**
     * 配偶者住所を設定します。
     *
     * @param 配偶者住所 配偶者住所
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set配偶者住所(AtenaJusho 配偶者住所) {
        requireNonNull(配偶者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("配偶者住所"));
        entity.setHaigushaJusho(配偶者住所);
        return this;
    }

    /**
     * 配偶者連絡先を設定します。
     *
     * @param 配偶者連絡先 配偶者連絡先
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set配偶者連絡先(RString 配偶者連絡先) {
        requireNonNull(配偶者連絡先, UrSystemErrorMessages.値がnull.getReplacedMessage("配偶者連絡先"));
        entity.setHaigushaRenrakusaki(配偶者連絡先);
        return this;
    }

    /**
     * 配偶者住所２を設定します。
     *
     * @param 配偶者住所２ 配偶者住所２
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set配偶者住所２(AtenaJusho 配偶者住所２) {
        requireNonNull(配偶者住所２, UrSystemErrorMessages.値がnull.getReplacedMessage("配偶者住所２"));
        entity.setHaigushaJusho2(配偶者住所２);
        return this;
    }

    /**
     * 配偶者課税区分を設定します。
     *
     * @param 配偶者課税区分 配偶者課税区分
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set配偶者課税区分(RString 配偶者課税区分) {
        requireNonNull(配偶者課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("配偶者課税区分"));
        entity.setHaigushaKazeiKubun(配偶者課税区分);
        return this;
    }

    /**
     * 配偶者識別コードを設定します。
     *
     * @param 配偶者識別コード 配偶者識別コード
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set配偶者識別コード(ShikibetsuCode 配偶者識別コード) {
        requireNonNull(配偶者識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("配偶者識別コード"));
        entity.setHaigushaShikibetsuCd(配偶者識別コード);
        return this;
    }

    /**
     * 預貯金申告区分を設定します。
     *
     * @param 預貯金申告区分 預貯金申告区分
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set預貯金申告区分(RString 預貯金申告区分) {
        requireNonNull(預貯金申告区分, UrSystemErrorMessages.値がnull.getReplacedMessage("預貯金申告区分"));
        entity.setYochokinShinkokuKubun(預貯金申告区分);
        return this;
    }

    /**
     * 預貯金額を設定します。
     *
     * @param 預貯金額 預貯金額
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set預貯金額(Decimal 預貯金額) {
        entity.setYochokinGaku(預貯金額);
        return this;
    }

    /**
     * 有価証券評価概算額を設定します。
     *
     * @param 有価証券評価概算額 有価証券評価概算額
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set有価証券評価概算額(Decimal 有価証券評価概算額) {
        entity.setYukashoukenGaisangaku(有価証券評価概算額);
        return this;
    }

    /**
     * その他金額を設定します。
     *
     * @param その他金額 その他金額
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder setその他金額(Decimal その他金額) {
        entity.setSonotaKingaku(その他金額);
        return this;
    }

    /**
     * 一括認定処理日時を設定します。
     *
     * @param 一括認定処理日時 一括認定処理日時
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set一括認定処理日時(YMDHMS 一括認定処理日時) {
        requireNonNull(一括認定処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("一括認定処理日時"));
        entity.setNinteiBatchExecutedTimestamp(一括認定処理日時);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 決定区分を設定します。
     *
     * @param 決定区分 決定区分
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set決定区分(RString 決定区分) {
        requireNonNull(決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("決定区分"));
        entity.setKetteiKubun(決定区分);
        return this;
    }

    /**
     * 非承認理由を設定します。
     *
     * @param 非承認理由 非承認理由
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set非承認理由(RString 非承認理由) {
        requireNonNull(非承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("非承認理由"));
        entity.setHiShoninRiyu(非承認理由);
        return this;
    }

    /**
     * 遺族年金受給フラグを設定します。
     *
     * @param 遺族年金受給フラグ 遺族年金受給フラグ
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set遺族年金受給フラグ(boolean 遺族年金受給フラグ) {
        requireNonNull(遺族年金受給フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("遺族年金受給フラグ"));
        entity.setIzokuNenkinJukyuFlag(遺族年金受給フラグ);
        return this;
    }

    /**
     * 障害年金受給フラグを設定します。
     *
     * @param 障害年金受給フラグ 障害年金受給フラグ
     * @return {@link FutanGendogakuNinteiBuilder}
     */
    public FutanGendogakuNinteiBuilder set障害年金受給フラグ(boolean 障害年金受給フラグ) {
        requireNonNull(障害年金受給フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("障害年金受給フラグ"));
        entity.setShogaiNenkinJukyuFlag(障害年金受給フラグ);
        return this;
    }

    /**
     * 減免減額申請情報のキー情報について判定します。<br>
     * 介護保険負担限度額認定に関連できる減免減額申請情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は合減免減額申請情報リストに減免減額申請情報{@link GemmenGengakuShinsei}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 減免減額申請情報 {@link GemmenGengakuShinsei}
     * @return {@link GogitaiJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public FutanGendogakuNinteiBuilder setGemmenGengakuShinsei(GemmenGengakuShinsei 減免減額申請情報) {
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
     * {@link FutanGendogakuNintei}のインスタンスを生成します。
     *
     * @return {@link FutanGendogakuNintei}のインスタンス
     */
    public FutanGendogakuNintei build() {
        return new FutanGendogakuNintei(entity, id, gemmenGengakuShinsei);
    }
}
