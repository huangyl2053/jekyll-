/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShiharaiHohoHenko}の編集を行うビルダークラスです。
 */
public class ShiharaiHohoHenkoBuilder {

    private final DbT4021ShiharaiHohoHenkoEntity entity;
    private final ShiharaiHohoHenkoIdentifier id;

    /**
     * {@link DbT4021ShiharaiHohoHenkoEntity}より{@link ShiharaiHohoHenko}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4021ShiharaiHohoHenkoEntity}
     * @param id {@link ShiharaiHohoHenkoIdentifier}
     *
     */
    ShiharaiHohoHenkoBuilder(
            DbT4021ShiharaiHohoHenkoEntity entity,
            ShiharaiHohoHenkoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 登録区分を設定します。
     *
     * @param 登録区分 登録区分
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set登録区分(RString 登録区分) {
        requireNonNull(登録区分, UrSystemErrorMessages.値がnull.getReplacedMessage("登録区分"));
        entity.setTorokuKubun(登録区分);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 終了区分を設定します。
     *
     * @param 終了区分 終了区分
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set終了区分(RString 終了区分) {
        requireNonNull(終了区分, UrSystemErrorMessages.値がnull.getReplacedMessage("終了区分"));
        entity.setShuryoKubun(終了区分);
        return this;
    }

    /**
     * 予告登録年月日を設定します。
     *
     * @param 予告登録年月日 予告登録年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set予告登録年月日(FlexibleDate 予告登録年月日) {
        requireNonNull(予告登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("予告登録年月日"));
        entity.setYokoku_TorokuYMD(予告登録年月日);
        return this;
    }

    /**
     * 差止依頼書受理年月日を設定します。
     *
     * @param 差止依頼書受理年月日 差止依頼書受理年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set差止依頼書受理年月日(FlexibleDate 差止依頼書受理年月日) {
        requireNonNull(差止依頼書受理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("差止依頼書受理年月日"));
        entity.setSashitome_IraiJuriYMD(差止依頼書受理年月日);
        return this;
    }

    /**
     * 予告通知書発行年月日を設定します。
     *
     * @param 予告通知書発行年月日 予告通知書発行年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set予告通知書発行年月日(FlexibleDate 予告通知書発行年月日) {
        requireNonNull(予告通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("予告通知書発行年月日"));
        entity.setYokoku_TsuchiHakkoYMD(予告通知書発行年月日);
        return this;
    }

    /**
     * 予告通知書再発行フラグを設定します。
     *
     * @param 予告通知書再発行フラグ 予告通知書再発行フラグ
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set予告通知書再発行フラグ(boolean 予告通知書再発行フラグ) {
        requireNonNull(予告通知書再発行フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("予告通知書再発行フラグ"));
        entity.setYokoku_TsuchiSaiHakkoFlag(予告通知書再発行フラグ);
        return this;
    }

    /**
     * 弁明書提出期限を設定します。
     *
     * @param 弁明書提出期限 弁明書提出期限
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set弁明書提出期限(FlexibleDate 弁明書提出期限) {
        requireNonNull(弁明書提出期限, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書提出期限"));
        entity.setBemmei_TeishutsuYMD(弁明書提出期限);
        return this;
    }

    /**
     * 弁明書受付年月日を設定します。
     *
     * @param 弁明書受付年月日 弁明書受付年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set弁明書受付年月日(FlexibleDate 弁明書受付年月日) {
        requireNonNull(弁明書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書受付年月日"));
        entity.setBemmei_UketsukeYMD(弁明書受付年月日);
        return this;
    }

    /**
     * 弁明理由コードを設定します。
     *
     * @param 弁明理由コード 弁明理由コード
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set弁明理由コード(RString 弁明理由コード) {
        requireNonNull(弁明理由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明理由コード"));
        entity.setBemmei_RiyuCode(弁明理由コード);
        return this;
    }

    /**
     * 弁明審査決定年月日を設定します。
     *
     * @param 弁明審査決定年月日 弁明審査決定年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set弁明審査決定年月日(FlexibleDate 弁明審査決定年月日) {
        requireNonNull(弁明審査決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明審査決定年月日"));
        entity.setBemmei_ShinsaKetteiYMD(弁明審査決定年月日);
        return this;
    }

    /**
     * 弁明審査結果区分を設定します。
     *
     * @param 弁明審査結果区分 弁明審査結果区分
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set弁明審査結果区分(RString 弁明審査結果区分) {
        requireNonNull(弁明審査結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明審査結果区分"));
        entity.setBemmei_ShinsaKekkaKubun(弁明審査結果区分);
        return this;
    }

    /**
     * 償還払化決定年月日を設定します。
     *
     * @param 償還払化決定年月日 償還払化決定年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set償還払化決定年月日(FlexibleDate 償還払化決定年月日) {
        requireNonNull(償還払化決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化決定年月日"));
        entity.setShokan_KetteiYMD(償還払化決定年月日);
        return this;
    }

    /**
     * 償還払化通知書発行年月日を設定します。
     *
     * @param 償還払化通知書発行年月日 償還払化通知書発行年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set償還払化通知書発行年月日(FlexibleDate 償還払化通知書発行年月日) {
        requireNonNull(償還払化通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化通知書発行年月日"));
        entity.setShokan_TsuchiHakkoYMD(償還払化通知書発行年月日);
        return this;
    }

    /**
     * 償還払化通知書再発行フラグを設定します。
     *
     * @param 償還払化通知書再発行フラグ 償還払化通知書再発行フラグ
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set償還払化通知書再発行フラグ(boolean 償還払化通知書再発行フラグ) {
        requireNonNull(償還払化通知書再発行フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化通知書再発行フラグ"));
        entity.setShokan_TsuchiSaiHakkoFlag(償還払化通知書再発行フラグ);
        return this;
    }

    /**
     * 被保険者証提出期限を設定します。
     *
     * @param 被保険者証提出期限 被保険者証提出期限
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set被保険者証提出期限(FlexibleDate 被保険者証提出期限) {
        requireNonNull(被保険者証提出期限, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者証提出期限"));
        entity.setHihokenshaShoTeishutsuYMD(被保険者証提出期限);
        return this;
    }

    /**
     * 差止対象フラグを設定します。
     *
     * @param 差止対象フラグ 差止対象フラグ
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set差止対象フラグ(boolean 差止対象フラグ) {
        requireNonNull(差止対象フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("差止対象フラグ"));
        entity.setSashitome_Flag(差止対象フラグ);
        return this;
    }

    /**
     * 差止対象決定年月日を設定します。
     *
     * @param 差止対象決定年月日 差止対象決定年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set差止対象決定年月日(FlexibleDate 差止対象決定年月日) {
        requireNonNull(差止対象決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("差止対象決定年月日"));
        entity.setSashitome_KetteiYMD(差止対象決定年月日);
        return this;
    }

    /**
     * 差止対象解除年月日を設定します。
     *
     * @param 差止対象解除年月日 差止対象解除年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set差止対象解除年月日(FlexibleDate 差止対象解除年月日) {
        requireNonNull(差止対象解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("差止対象解除年月日"));
        entity.setSashitome_KaijoYMD(差止対象解除年月日);
        return this;
    }

    /**
     * 減額決定年月日を設定します。
     *
     * @param 減額決定年月日 減額決定年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set減額決定年月日(FlexibleDate 減額決定年月日) {
        requireNonNull(減額決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減額決定年月日"));
        entity.setGemmen_KetteiYMD(減額決定年月日);
        return this;
    }

    /**
     * 減額通知書発行年月日を設定します。
     *
     * @param 減額通知書発行年月日 減額通知書発行年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set減額通知書発行年月日(FlexibleDate 減額通知書発行年月日) {
        requireNonNull(減額通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減額通知書発行年月日"));
        entity.setGemmen_TsuchiHakkoYMD(減額通知書発行年月日);
        return this;
    }

    /**
     * 減額通知書再発行フラグを設定します。
     *
     * @param 減額通知書再発行フラグ 減額通知書再発行フラグ
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set減額通知書再発行フラグ(boolean 減額通知書再発行フラグ) {
        requireNonNull(減額通知書再発行フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("減額通知書再発行フラグ"));
        entity.setGemmen_TsuchiSaiHakkoFlag(減額通知書再発行フラグ);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
        return this;
    }

    /**
     * 終了申請書受付年月日を設定します。
     *
     * @param 終了申請書受付年月日 終了申請書受付年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set終了申請書受付年月日(FlexibleDate 終了申請書受付年月日) {
        requireNonNull(終了申請書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請書受付年月日"));
        entity.setShuryoShinsei_UketsukeYMD(終了申請書受付年月日);
        return this;
    }

    /**
     * 終了申請年月日を設定します。
     *
     * @param 終了申請年月日 終了申請年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set終了申請年月日(FlexibleDate 終了申請年月日) {
        requireNonNull(終了申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請年月日"));
        entity.setShuryoShinsei_YMD(終了申請年月日);
        return this;
    }

    /**
     * 終了申請理由コードを設定します。
     *
     * @param 終了申請理由コード 終了申請理由コード
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set終了申請理由コード(RString 終了申請理由コード) {
        requireNonNull(終了申請理由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請理由コード"));
        entity.setShuryoShinsei_RiyuCode(終了申請理由コード);
        return this;
    }

    /**
     * 終了申請審査決定年月日を設定します。
     *
     * @param 終了申請審査決定年月日 終了申請審査決定年月日
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set終了申請審査決定年月日(FlexibleDate 終了申請審査決定年月日) {
        requireNonNull(終了申請審査決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請審査決定年月日"));
        entity.setShuryoShinsei_ShinsaKetteiYMD(終了申請審査決定年月日);
        return this;
    }

    /**
     * 終了申請審査結果区分を設定します。
     *
     * @param 終了申請審査結果区分 終了申請審査結果区分
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set終了申請審査結果区分(RString 終了申請審査結果区分) {
        requireNonNull(終了申請審査結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請審査結果区分"));
        entity.setShuryoShinsei_ShinsaKekkaKubun(終了申請審査結果区分);
        return this;
    }

    /**
     * 無効区分を設定します。
     *
     * @param 無効区分 無効区分
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set無効区分(RString 無効区分) {
        requireNonNull(無効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("無効区分"));
        entity.setMukoKubun(無効区分);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link ShiharaiHohoHenko}のインスタンスを生成します。
     *
     * @return {@link ShiharaiHohoHenko}のインスタンス
     */
    public ShiharaiHohoHenko build() {
        return new ShiharaiHohoHenko(entity, id);
    }
}
