/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link KyufuhiKashitsukekinShinsei}の編集を行うビルダークラスです。
 */
public class KyufuhiKashitsukekinShinseiBuilder {

    private final DbT3086KyufuhiKashitsukekinShinseiEntity entity;
    private final KyufuhiKashitsukekinShinseiIdentifier id;

    /**
     * {@link DbT3086KyufuhiKashitsukekinShinseiEntity}より{@link KyufuhiKashitsukekinShinsei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3086KyufuhiKashitsukekinShinseiEntity}
     * @param id {@link KyufuhiKashitsukekinShinseiIdentifier}
     *
     */
    KyufuhiKashitsukekinShinseiBuilder(
            DbT3086KyufuhiKashitsukekinShinseiEntity entity,
            KyufuhiKashitsukekinShinseiIdentifier id
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
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 借入申請年月日を設定します。
     *
     * @param 借入申請年月日 借入申請年月日
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set借入申請年月日(FlexibleDate 借入申請年月日) {
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        entity.setKariireShinseiYMD(借入申請年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 申請者郵便番号を設定します。
     *
     * @param 申請者郵便番号 申請者郵便番号
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set申請者郵便番号(YubinNo 申請者郵便番号) {
        requireNonNull(申請者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者郵便番号"));
        entity.setShinseishaYubinNo(申請者郵便番号);
        return this;
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.setShinseishaJusho(申請者住所);
        return this;
    }

    /**
     * 申請者氏名カナを設定します。
     *
     * @param 申請者氏名カナ 申請者氏名カナ
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set申請者氏名カナ(AtenaKanaMeisho 申請者氏名カナ) {
        requireNonNull(申請者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名カナ"));
        entity.setShinseishaShimeiKana(申請者氏名カナ);
        return this;
    }

    /**
     * 申請者氏名を設定します。
     *
     * @param 申請者氏名 申請者氏名
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set申請者氏名(AtenaMeisho 申請者氏名) {
        requireNonNull(申請者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名"));
        entity.setShinseishaShimei(申請者氏名);
        return this;
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set申請者電話番号(TelNo 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.setShinseishaTelNo(申請者電話番号);
        return this;
    }

    /**
     * 申請者との関係を設定します。
     *
     * @param 申請者との関係 申請者との関係
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set申請者との関係(RString 申請者との関係) {
        requireNonNull(申請者との関係, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者との関係"));
        entity.setShinseishaKankei(申請者との関係);
        return this;
    }

    /**
     * 借入利用期間開始年月日を設定します。
     *
     * @param 借入利用期間開始年月日 借入利用期間開始年月日
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set借入利用期間開始年月日(FlexibleDate 借入利用期間開始年月日) {
        requireNonNull(借入利用期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入利用期間開始年月日"));
        entity.setKariireRiyoKaishiYMD(借入利用期間開始年月日);
        return this;
    }

    /**
     * 借入利用期間終了年月日を設定します。
     *
     * @param 借入利用期間終了年月日 借入利用期間終了年月日
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set借入利用期間終了年月日(FlexibleDate 借入利用期間終了年月日) {
        requireNonNull(借入利用期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入利用期間終了年月日"));
        entity.setKariireRiyoShuryoYMD(借入利用期間終了年月日);
        return this;
    }

    /**
     * 貸付対象・高額介護サービス費等有無を設定します。
     *
     * @param 貸付対象・高額介護サービス費等有無 貸付対象・高額介護サービス費等有無
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set貸付対象・高額介護サービス費等有無(RString 貸付対象・高額介護サービス費等有無) {
        requireNonNull(貸付対象・高額介護サービス費等有無, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付対象・高額介護サービス費等有無"));
        entity.setKashitsuke_KogakuUmu(貸付対象・高額介護サービス費等有無);
        return this;
    }

    /**
     * 貸付対象・住宅改修費等有無を設定します。
     *
     * @param 貸付対象・住宅改修費等有無 貸付対象・住宅改修費等有無
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set貸付対象・住宅改修費等有無(RString 貸付対象・住宅改修費等有無) {
        requireNonNull(貸付対象・住宅改修費等有無, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付対象・住宅改修費等有無"));
        entity.setKashitsuke_JutakuKaishuUmu(貸付対象・住宅改修費等有無);
        return this;
    }

    /**
     * 貸付対象・福祉用具購入費等有無を設定します。
     *
     * @param 貸付対象・福祉用具購入費等有無 貸付対象・福祉用具購入費等有無
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set貸付対象・福祉用具購入費等有無(RString 貸付対象・福祉用具購入費等有無) {
        requireNonNull(貸付対象・福祉用具購入費等有無, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付対象・福祉用具購入費等有無"));
        entity.setKahitsuke_YoguKonyuUmu(貸付対象・福祉用具購入費等有無);
        return this;
    }

    /**
     * 貸付対象・特例介護サービス費等有無を設定します。
     *
     * @param 貸付対象・特例介護サービス費等有無 貸付対象・特例介護サービス費等有無
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set貸付対象・特例介護サービス費等有無(RString 貸付対象・特例介護サービス費等有無) {
        requireNonNull(貸付対象・特例介護サービス費等有無, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付対象・特例介護サービス費等有無"));
        entity.setKashitsuke_TokureiServiceUmu(貸付対象・特例介護サービス費等有無);
        return this;
    }

    /**
     * 保証人氏名カナを設定します。
     *
     * @param 保証人氏名カナ 保証人氏名カナ
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人氏名カナ(AtenaKanaMeisho 保証人氏名カナ) {
        requireNonNull(保証人氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人氏名カナ"));
        entity.setHoshonin_ShimeiKana(保証人氏名カナ);
        return this;
    }

    /**
     * 保証人氏名を設定します。
     *
     * @param 保証人氏名 保証人氏名
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人氏名(AtenaMeisho 保証人氏名) {
        requireNonNull(保証人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人氏名"));
        entity.setHoshonin_Shimei(保証人氏名);
        return this;
    }

    /**
     * 保証人生年月日を設定します。
     *
     * @param 保証人生年月日 保証人生年月日
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人生年月日(FlexibleDate 保証人生年月日) {
        requireNonNull(保証人生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人生年月日"));
        entity.setHoshonin_UmareYMD(保証人生年月日);
        return this;
    }

    /**
     * 保証人性別を設定します。
     *
     * @param 保証人性別 保証人性別
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人性別(Code 保証人性別) {
        requireNonNull(保証人性別, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人性別"));
        entity.setHoshinin_SeibetsuCd(保証人性別);
        return this;
    }

    /**
     * 保証人郵便番号を設定します。
     *
     * @param 保証人郵便番号 保証人郵便番号
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人郵便番号(YubinNo 保証人郵便番号) {
        requireNonNull(保証人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人郵便番号"));
        entity.setHoshonin_YubinNo(保証人郵便番号);
        return this;
    }

    /**
     * 保証人住所を設定します。
     *
     * @param 保証人住所 保証人住所
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人住所(RString 保証人住所) {
        requireNonNull(保証人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人住所"));
        entity.setHoshonin_Jusho(保証人住所);
        return this;
    }

    /**
     * 保証人電話番号を設定します。
     *
     * @param 保証人電話番号 保証人電話番号
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人電話番号(TelNo 保証人電話番号) {
        requireNonNull(保証人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人電話番号"));
        entity.setHoshonin_TelNo(保証人電話番号);
        return this;
    }

    /**
     * 借入申請者との関係を設定します。
     *
     * @param 借入申請者との関係 借入申請者との関係
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set借入申請者との関係(RString 借入申請者との関係) {
        requireNonNull(借入申請者との関係, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請者との関係"));
        entity.setKariireShinseishaKankei(借入申請者との関係);
        return this;
    }

    /**
     * 保証人勤務先名称を設定します。
     *
     * @param 保証人勤務先名称 保証人勤務先名称
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人勤務先名称(AtenaMeisho 保証人勤務先名称) {
        requireNonNull(保証人勤務先名称, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人勤務先名称"));
        entity.setHoshonin_KinmusakiMeisho(保証人勤務先名称);
        return this;
    }

    /**
     * 保証人勤務先郵便番号を設定します。
     *
     * @param 保証人勤務先郵便番号 保証人勤務先郵便番号
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人勤務先郵便番号(YubinNo 保証人勤務先郵便番号) {
        requireNonNull(保証人勤務先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人勤務先郵便番号"));
        entity.setHoshonin_KinmusakiYubinNo(保証人勤務先郵便番号);
        return this;
    }

    /**
     * 保証人勤務先所在地を設定します。
     *
     * @param 保証人勤務先所在地 保証人勤務先所在地
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人勤務先所在地(RString 保証人勤務先所在地) {
        requireNonNull(保証人勤務先所在地, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人勤務先所在地"));
        entity.setHoshonin_KinmusakiJusho(保証人勤務先所在地);
        return this;
    }

    /**
     * 保証人勤務先電話番号を設定します。
     *
     * @param 保証人勤務先電話番号 保証人勤務先電話番号
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set保証人勤務先電話番号(TelNo 保証人勤務先電話番号) {
        requireNonNull(保証人勤務先電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人勤務先電話番号"));
        entity.setHoshonin_KinmusakiTelNo(保証人勤務先電話番号);
        return this;
    }

    /**
     * 請求書・領収書の有無を設定します。
     *
     * @param 請求書・領収書の有無 請求書・領収書の有無
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set請求書・領収書の有無(RString 請求書・領収書の有無) {
        requireNonNull(請求書・領収書の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("請求書・領収書の有無"));
        entity.setSeikyusho_RyoshushoUmu(請求書・領収書の有無);
        return this;
    }

    /**
     * 提出物管理番号を設定します。
     *
     * @param 提出物管理番号 提出物管理番号
     * @return {@link KyufuhiKashitsukekinShinseiBuilder}
     */
    public KyufuhiKashitsukekinShinseiBuilder set提出物管理番号(Decimal 提出物管理番号) {
        requireNonNull(提出物管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("提出物管理番号"));
        entity.setTeishutsubutsuKanriNo(提出物管理番号);
        return this;
    }

    /**
     * {@link KyufuhiKashitsukekinShinsei}のインスタンスを生成します。
     *
     * @return {@link KyufuhiKashitsukekinShinsei}のインスタンス
     */
    public KyufuhiKashitsukekinShinsei build() {
        return new KyufuhiKashitsukekinShinsei(entity, id);
    }
}
