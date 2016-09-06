/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KijunShunyugakuTekiyoKanri}の編集を行うビルダークラスです。
 */
public class KijunShunyugakuTekiyoKanriBuilder {

    private final DbT3116KijunShunyugakuTekiyoKanriEntity entity;
    private final KijunShunyugakuTekiyoKanriIdentifier id;

    /**
     * {@link DbT3116KijunShunyugakuTekiyoKanriEntity}より{@link KijunShunyugakuTekiyoKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3116KijunShunyugakuTekiyoKanriEntity}
     * @param id {@link KijunShunyugakuTekiyoKanriIdentifier}
     *
     */
    KijunShunyugakuTekiyoKanriBuilder(
            DbT3116KijunShunyugakuTekiyoKanriEntity entity,
            KijunShunyugakuTekiyoKanriIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード 世帯コード
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set世帯コード(SetaiCode 世帯コード) {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        entity.setSetaiCode(世帯コード);
        return this;
    }

    /**
     * 年度を設定します。
     *
     * @param 年度 年度
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set年度(FlexibleYear 年度) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        entity.setNendo(年度);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 公的年金収入額を設定します。
     *
     * @param 公的年金収入額 公的年金収入額
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set公的年金収入額(Decimal 公的年金収入額) {
//        requireNonNull(公的年金収入額, UrSystemErrorMessages.値がnull.getReplacedMessage("公的年金収入額"));
        entity.setKotekiNenkinShunyugaku(公的年金収入額);
        return this;
    }

    /**
     * 給与収入額を設定します。
     *
     * @param 給与収入額 給与収入額
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set給与収入額(Decimal 給与収入額) {
//        requireNonNull(給与収入額, UrSystemErrorMessages.値がnull.getReplacedMessage("給与収入額"));
        entity.setKyuyoShunyugaku(給与収入額);
        return this;
    }

    /**
     * その他の収入額を設定します。
     *
     * @param その他の収入額 その他の収入額
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder setその他の収入額(Decimal その他の収入額) {
//        requireNonNull(その他の収入額, UrSystemErrorMessages.値がnull.getReplacedMessage("その他の収入額"));
        entity.setSonotaShunyugaku(その他の収入額);
        return this;
    }

    /**
     * 算定基準額を設定します。
     *
     * @param 算定基準額 算定基準額
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set算定基準額(Decimal 算定基準額) {
//        requireNonNull(算定基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("算定基準額"));
        entity.setSanteiKijungaku(算定基準額);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
//        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYMD(適用開始年月);
        return this;
    }

    /**
     * 申請日を設定します。
     *
     * @param 申請日 申請日
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set申請日(FlexibleDate 申請日) {
//        requireNonNull(申請日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請日"));
        entity.setShinseiYMD(申請日);
        return this;
    }

    /**
     * 決定日を設定します。
     *
     * @param 決定日 決定日
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set決定日(FlexibleDate 決定日) {
//        requireNonNull(決定日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定日"));
        entity.setKetteiYMD(決定日);
        return this;
    }

    /**
     * 申請書作成日を設定します。
     *
     * @param 申請書作成日 申請書作成日
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set申請書作成日(FlexibleDate 申請書作成日) {
//        requireNonNull(申請書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書作成日"));
        entity.setShinseishoSakuseiYMD(申請書作成日);
        return this;
    }

    /**
     * 申請書作成の世帯基準日を設定します。
     *
     * @param 申請書作成の世帯基準日 申請書作成の世帯基準日
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set申請書作成の世帯基準日(FlexibleDate 申請書作成の世帯基準日) {
//        requireNonNull(申請書作成の世帯基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書作成の世帯基準日"));
        entity.setShinseishoSakuseiSetaiKijunYMD(申請書作成の世帯基準日);
        return this;
    }

    /**
     * 決定通知書発行日を設定します。
     *
     * @param 決定通知書発行日 決定通知書発行日
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set決定通知書発行日(FlexibleDate 決定通知書発行日) {
//        requireNonNull(決定通知書発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定通知書発行日"));
        entity.setKetteiTsuchishoHakkoYMD(決定通知書発行日);
        return this;
    }

    /**
     * 宛先印字対象者フラグを設定します。
     *
     * @param 宛先印字対象者フラグ 宛先印字対象者フラグ
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set宛先印字対象者フラグ(boolean 宛先印字対象者フラグ) {
//        requireNonNull(宛先印字対象者フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("宛先印字対象者フラグ"));
        entity.setAtesakiInjiTaishoshaFlag(宛先印字対象者フラグ);
        return this;
    }

    /**
     * 年少扶養控除_16歳未満人数を設定します。
     *
     * @param 年少扶養控除_16歳未満人数 年少扶養控除_16歳未満人数
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set年少扶養控除_16歳未満人数(int 年少扶養控除_16歳未満人数) {
//        requireNonNull(年少扶養控除_16歳未満人数, UrSystemErrorMessages.値がnull.getReplacedMessage("年少扶養控除_16歳未満人数"));
        entity.setNenshoFuyokojoUnder16Ninzu(年少扶養控除_16歳未満人数);
        return this;
    }

    /**
     * 年少扶養控除_16から18歳未満人数を設定します。
     *
     * @param 年少扶養控除_16から18歳未満人数 年少扶養控除_16から18歳未満人数
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set年少扶養控除_16から18歳未満人数(int 年少扶養控除_16から18歳未満人数) {
//        requireNonNull(年少扶養控除_16から18歳未満人数, UrSystemErrorMessages.値がnull.getReplacedMessage("年少扶養控除_16から18歳未満人数"));
        entity.setNenshoFuyokojoOver16Ninzu(年少扶養控除_16から18歳未満人数);
        return this;
    }

    /**
     * 世帯員の総収入額を設定します。
     *
     * @param 世帯員の総収入額 世帯員の総収入額
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set世帯員の総収入額(Decimal 世帯員の総収入額) {
//        requireNonNull(世帯員の総収入額, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員の総収入額"));
        entity.setSetaiinSoShunyugaku(世帯員の総収入額);
        return this;
    }

    /**
     * 世帯主フラグを設定します。
     *
     * @param 世帯主フラグ 世帯主フラグ
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set世帯主フラグ(boolean 世帯主フラグ) {
//        requireNonNull(世帯主フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯主フラグ"));
        entity.setSetainushiFlag(世帯主フラグ);
        return this;
    }

    /**
     * 課税所得額を設定します。
     *
     * @param 課税所得額 課税所得額
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set課税所得額(Decimal 課税所得額) {
//        requireNonNull(課税所得額, UrSystemErrorMessages.値がnull.getReplacedMessage("課税所得額"));
        entity.setKazeiShotokugaku(課税所得額);
        return this;
    }

    /**
     * 課税所得額_控除後を設定します。
     *
     * @param 課税所得額_控除後 課税所得額_控除後
     * @return {@link KijunShunyugakuTekiyoKanriBuilder}
     */
    public KijunShunyugakuTekiyoKanriBuilder set課税所得額_控除後(Decimal 課税所得額_控除後) {
//        requireNonNull(課税所得額_控除後, UrSystemErrorMessages.値がnull.getReplacedMessage("課税所得額_控除後"));
        entity.setKazeiShotokugakuKojogo(課税所得額_控除後);
        return this;
    }

    /**
     * {@link KijunShunyugakuTekiyoKanri}のインスタンスを生成します。
     *
     * @return {@link KijunShunyugakuTekiyoKanri}のインスタンス
     */
    public KijunShunyugakuTekiyoKanri build() {
        return new KijunShunyugakuTekiyoKanri(entity, id);
    }
}
