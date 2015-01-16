/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.BemmeiRiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.BemmeiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.KanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.ShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.ShuryoShinseiRiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.ShuryoShinseiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.TorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 支払方法変更のモデルクラスです。
 *
 * @author n8187 久保田 英男
 */
public class ShiharaiHohoHenkoModel implements Serializable {

    private DbT4021ShiharaiHohoHenkoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoModel() {
        entity = new DbT4021ShiharaiHohoHenkoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4021ShiharaiHohoHenkoEntity
     */
    public ShiharaiHohoHenkoModel(DbT4021ShiharaiHohoHenkoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT4021ShiharaiHohoHenkoEntityを返します。
     *
     * @return DbT4021ShiharaiHohoHenkoEntity
     */
    public DbT4021ShiharaiHohoHenkoEntity getEntity() {
        return entity;
    }

    /**
     * DbT4021ShiharaiHohoHenkoEntityを設定します。
     *
     * @param entity DbT4021ShiharaiHohoHenkoEntity
     */
    public void setEntity(DbT4021ShiharaiHohoHenkoEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 管理区分を返します。
     *
     * @return 管理区分
     */
    public KanriKubun get管理区分() {
        return KanriKubun.toValue(entity.getKanriKubun());
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 登録区分を返します。
     *
     * @return 登録区分
     */
    public TorokuKubun get登録区分() {
        return TorokuKubun.toValue(entity.getTorokuKubun());
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 終了区分を返します。
     *
     * @return 終了区分
     */
    public ShuryoKubun get終了区分() {
        return ShuryoKubun.toValue(entity.getShuryoKubun());
    }

    /**
     * 予告登録年月日を返します。
     *
     * @return 予告登録年月日
     */
    public FlexibleDate get予告登録年月日() {
        return entity.getYokoku_TorokuYMD();
    }

    /**
     * 差止依頼書受理年月日を返します。
     *
     * @return 差止依頼書受理年月日
     */
    public FlexibleDate get差止依頼書受理年月日() {
        return entity.getSashitome_IraiJuriYMD();
    }

    /**
     * 予告通知書発行年月日を返します。
     *
     * @return 予告通知書発行年月日
     */
    public FlexibleDate get予告通知書発行年月日() {
        return entity.getYokoku_TsuchiHakkoYMD();
    }

    /**
     * 予告通知書再発行フラグを返します。
     *
     * @return 予告通知書再発行フラグ {true:再発行 false:再発行ではない}
     */
    public boolean has予告通知書再発行() {
        return entity.getYokoku_TsuchiSaiHakkoFlag();
    }

    /**
     * 弁明書提出期限を返します。
     *
     * @return 弁明書提出期限
     */
    public FlexibleDate get弁明書提出期限() {
        return entity.getBemmei_TeishutsuYMD();
    }

    /**
     * 弁明書受付年月日を返します。
     *
     * @return 弁明書受付年月日
     */
    public FlexibleDate get弁明書受付年月日() {
        return entity.getBemmei_UketsukeYMD();
    }

    /**
     * 弁明理由コードを返します。
     *
     * @return 弁明理由コード
     */
    public BemmeiRiyu get弁明理由コード() {
        return BemmeiRiyu.toValue(entity.getBemmei_RiyuCode());
    }

    /**
     * 弁明審査決定年月日を返します。
     *
     * @return 弁明審査決定年月日
     */
    public FlexibleDate get弁明審査決定年月日() {
        return entity.getBemmei_ShinsaKetteiYMD();
    }

    /**
     * 弁明審査結果区分を返します。
     *
     * @return 弁明審査結果区分
     */
    public BemmeiShinsaKekkaKubun get弁明審査結果区分() {
        return BemmeiShinsaKekkaKubun.toValue(entity.getBemmei_ShinsaKekkaKubun());
    }

    /**
     * 償還払化決定年月日を返します。
     *
     * @return 償還払化決定年月日
     */
    public FlexibleDate get償還払化決定年月日() {
        return entity.getShokan_KetteiYMD();
    }

    /**
     * 償還払化通知書発行年月日を返します。
     *
     * @return 償還払化通知書発行年月日
     */
    public FlexibleDate get償還払化通知書発行年月日() {
        return entity.getShokan_TsuchiHakkoYMD();
    }

    /**
     * 償還払化通知書再発行フラグを返します。
     *
     * @return 償還払化通知書再発行フラグ {true:再発行 false:再発行ではない}
     */
    public boolean has償還払化通知書再発行() {
        return entity.getShokan_TsuchiSaiHakkoFlag();
    }

    /**
     * 被保険者証提出期限を返します。
     *
     * @return 被保険者証提出期限
     */
    public FlexibleDate get被保険者証提出期限() {
        return entity.getHihokenshaShoTeishutsuYMD();
    }

    /**
     * 差止対象フラグを返します。
     *
     * @return 差止対象フラグ {true:差止対象 false:差止対象ではない}
     */
    public boolean is差止対象() {
        return entity.getSashitome_Flag();
    }

    /**
     * 差止対象決定年月日を返します。
     *
     * @return 差止対象決定年月日
     */
    public FlexibleDate get差止対象決定年月日() {
        return entity.getSashitome_KetteiYMD();
    }

    /**
     * 差止対象解除年月日を返します。
     *
     * @return 差止対象解除年月日
     */
    public FlexibleDate get差止対象解除年月日() {
        return entity.getSashitome_KaijoYMD();
    }

    /**
     * 減額決定年月日を返します。
     *
     * @return 減額決定年月日
     */
    public FlexibleDate get減額決定年月日() {
        return entity.getGemmen_KetteiYMD();
    }

    /**
     * 減額通知書発行年月日を返します。
     *
     * @return 減額通知書発行年月日
     */
    public FlexibleDate get減額通知書発行年月日() {
        return entity.getGemmen_TsuchiHakkoYMD();
    }

    /**
     * 減額通知書再発行フラグを返します。
     *
     * @return 減額通知書再発行フラグ {true:再発行 false:再発行ではない}
     */
    public boolean has減額通知書再発行() {
        return entity.getGemmen_TsuchiSaiHakkoFlag();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyufuRitsu();
    }

    /**
     * 終了申請書受付年月日を返します。
     *
     * @return 終了申請書受付年月日
     */
    public FlexibleDate get終了申請書受付年月日() {
        return entity.getShuryoShinsei_UketsukeYMD();
    }

    /**
     * 終了申請年月日を返します。
     *
     * @return 終了申請年月日
     */
    public FlexibleDate get終了申請年月日() {
        return entity.getShuryoShinsei_YMD();
    }

    /**
     * 終了申請理由コードを返します。
     *
     * @return 終了申請理由コード
     */
    public ShuryoShinseiRiyu get終了申請理由コード() {
        return ShuryoShinseiRiyu.toValue(entity.getShuryoShinsei_RiyuCode());
    }

    /**
     * 終了申請審査決定年月日を返します。
     *
     * @return 終了申請審査決定年月日
     */
    public FlexibleDate get終了申請審査決定年月日() {
        return entity.getShuryoShinsei_ShinsaKetteiYMD();
    }

    /**
     * 終了申請審査結果区分を返します。
     *
     * @return 終了申請審査結果区分
     */
    public ShuryoShinseiShinsaKekkaKubun get終了申請審査結果区分() {
        return ShuryoShinseiShinsaKekkaKubun.toValue(entity.getShuryoShinsei_ShinsaKekkaKubun());
    }

    /**
     * 無効区分を返します。
     *
     * @return 無効区分 {true:無効 false:有効}
     */
    public boolean is無効() {
        return entity.getMukoKubun();
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 管理区分を設定します。
     *
     * @param 管理区分 管理区分
     */
    public void set管理区分(KanriKubun 管理区分) {
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        entity.setKanriKubun(管理区分.code());
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 登録区分を設定します。
     *
     * @param 登録区分 登録区分
     */
    public void set登録区分(TorokuKubun 登録区分) {
        requireNonNull(登録区分, UrSystemErrorMessages.値がnull.getReplacedMessage("登録区分"));
        entity.setTorokuKubun(登録区分.code());
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     */
    public void set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     */
    public void set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
    }

    /**
     * 終了区分を設定します。
     *
     * @param 終了区分 終了区分
     */
    public void set終了区分(ShuryoKubun 終了区分) {
        requireNonNull(終了区分, UrSystemErrorMessages.値がnull.getReplacedMessage("終了区分"));
        if (終了区分 == ShuryoKubun.EMPTY) {
            entity.setShuryoKubun(null);
        } else {
            entity.setShuryoKubun(終了区分.code());
        }
    }

    /**
     * 予告登録年月日を設定します。
     *
     * @param 予告登録年月日 予告登録年月日
     */
    public void set予告登録年月日(FlexibleDate 予告登録年月日) {
        requireNonNull(予告登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("予告登録年月日"));
        entity.setYokoku_TorokuYMD(予告登録年月日);
    }

    /**
     * 差止依頼書受理年月日を設定します。
     *
     * @param 差止依頼書受理年月日 差止依頼書受理年月日
     */
    public void set差止依頼書受理年月日(FlexibleDate 差止依頼書受理年月日) {
        requireNonNull(差止依頼書受理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("差止依頼書受理年月日"));
        entity.setSashitome_IraiJuriYMD(差止依頼書受理年月日);
    }

    /**
     * 予告通知書発行年月日を設定します。
     *
     * @param 予告通知書発行年月日 予告通知書発行年月日
     */
    public void set予告通知書発行年月日(FlexibleDate 予告通知書発行年月日) {
        requireNonNull(予告通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("予告通知書発行年月日"));
        entity.setYokoku_TsuchiHakkoYMD(予告通知書発行年月日);
    }

    /**
     * 予告通知書再発行フラグを設定します。
     *
     * @param 予告通知書再発行フラグ 予告通知書再発行フラグ
     */
    public void set予告通知書再発行フラグ(boolean 予告通知書再発行フラグ) {
        requireNonNull(予告通知書再発行フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("予告通知書再発行フラグ"));
        entity.setYokoku_TsuchiSaiHakkoFlag(予告通知書再発行フラグ);
    }

    /**
     * 弁明書提出期限を設定します。
     *
     * @param 弁明書提出期限 弁明書提出期限
     */
    public void set弁明書提出期限(FlexibleDate 弁明書提出期限) {
        requireNonNull(弁明書提出期限, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書提出期限"));
        entity.setBemmei_TeishutsuYMD(弁明書提出期限);
    }

    /**
     * 弁明書受付年月日を設定します。
     *
     * @param 弁明書受付年月日 弁明書受付年月日
     */
    public void set弁明書受付年月日(FlexibleDate 弁明書受付年月日) {
        requireNonNull(弁明書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書受付年月日"));
        entity.setBemmei_UketsukeYMD(弁明書受付年月日);
    }

    /**
     * 弁明理由コードを設定します。
     *
     * @param 弁明理由コード 弁明理由コード
     */
    public void set弁明理由コード(BemmeiRiyu 弁明理由コード) {
        requireNonNull(弁明理由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明理由コード"));
        entity.setBemmei_RiyuCode(弁明理由コード.code());
    }

    /**
     * 弁明審査決定年月日を設定します。
     *
     * @param 弁明審査決定年月日 弁明審査決定年月日
     */
    public void set弁明審査決定年月日(FlexibleDate 弁明審査決定年月日) {
        requireNonNull(弁明審査決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明審査決定年月日"));
        entity.setBemmei_ShinsaKetteiYMD(弁明審査決定年月日);
    }

    /**
     * 弁明審査結果区分を設定します。
     *
     * @param 弁明審査結果区分 弁明審査結果区分
     */
    public void set弁明審査結果区分(BemmeiShinsaKekkaKubun 弁明審査結果区分) {
        requireNonNull(弁明審査結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明審査結果区分"));
        entity.setBemmei_ShinsaKekkaKubun(弁明審査結果区分.code());
    }

    /**
     * 償還払化決定年月日を設定します。
     *
     * @param 償還払化決定年月日 償還払化決定年月日
     */
    public void set償還払化決定年月日(FlexibleDate 償還払化決定年月日) {
        requireNonNull(償還払化決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化決定年月日"));
        entity.setShokan_KetteiYMD(償還払化決定年月日);
    }

    /**
     * 償還払化通知書発行年月日を設定します。
     *
     * @param 償還払化通知書発行年月日 償還払化通知書発行年月日
     */
    public void set償還払化通知書発行年月日(FlexibleDate 償還払化通知書発行年月日) {
        requireNonNull(償還払化通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化通知書発行年月日"));
        entity.setShokan_TsuchiHakkoYMD(償還払化通知書発行年月日);
    }

    /**
     * 償還払化通知書再発行フラグを設定します。
     *
     * @param 償還払化通知書再発行フラグ 償還払化通知書再発行フラグ
     */
    public void set償還払化通知書再発行フラグ(boolean 償還払化通知書再発行フラグ) {
        requireNonNull(償還払化通知書再発行フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化通知書再発行フラグ"));
        entity.setShokan_TsuchiSaiHakkoFlag(償還払化通知書再発行フラグ);
    }

    /**
     * 被保険者証提出期限を設定します。
     *
     * @param 被保険者証提出期限 被保険者証提出期限
     */
    public void set被保険者証提出期限(FlexibleDate 被保険者証提出期限) {
        requireNonNull(被保険者証提出期限, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者証提出期限"));
        entity.setHihokenshaShoTeishutsuYMD(被保険者証提出期限);
    }

    /**
     * 差止対象フラグを設定します。
     *
     * @param 差止対象フラグ 差止対象フラグ
     */
    public void set差止対象フラグ(boolean 差止対象フラグ) {
        requireNonNull(差止対象フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("差止対象フラグ"));
        entity.setSashitome_Flag(差止対象フラグ);
    }

    /**
     * 差止対象決定年月日を設定します。
     *
     * @param 差止対象決定年月日 差止対象決定年月日
     */
    public void set差止対象決定年月日(FlexibleDate 差止対象決定年月日) {
        requireNonNull(差止対象決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("差止対象決定年月日"));
        entity.setSashitome_KetteiYMD(差止対象決定年月日);
    }

    /**
     * 差止対象解除年月日を設定します。
     *
     * @param 差止対象解除年月日 差止対象解除年月日
     */
    public void set差止対象解除年月日(FlexibleDate 差止対象解除年月日) {
        requireNonNull(差止対象解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("差止対象解除年月日"));
        entity.setSashitome_KaijoYMD(差止対象解除年月日);
    }

    /**
     * 減額決定年月日を設定します。
     *
     * @param 減額決定年月日 減額決定年月日
     */
    public void set減額決定年月日(FlexibleDate 減額決定年月日) {
        requireNonNull(減額決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減額決定年月日"));
        entity.setGemmen_KetteiYMD(減額決定年月日);
    }

    /**
     * 減額通知書発行年月日を設定します。
     *
     * @param 減額通知書発行年月日 減額通知書発行年月日
     */
    public void set減額通知書発行年月日(FlexibleDate 減額通知書発行年月日) {
        requireNonNull(減額通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減額通知書発行年月日"));
        entity.setGemmen_TsuchiHakkoYMD(減額通知書発行年月日);
    }

    /**
     * 減額通知書再発行フラグを設定します。
     *
     * @param 減額通知書再発行フラグ 減額通知書再発行フラグ
     */
    public void set減額通知書再発行フラグ(boolean 減額通知書再発行フラグ) {
        requireNonNull(減額通知書再発行フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("減額通知書再発行フラグ"));
        entity.setGemmen_TsuchiSaiHakkoFlag(減額通知書再発行フラグ);
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     */
    public void set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
    }

    /**
     * 終了申請書受付年月日を設定します。
     *
     * @param 終了申請書受付年月日 終了申請書受付年月日
     */
    public void set終了申請書受付年月日(FlexibleDate 終了申請書受付年月日) {
        requireNonNull(終了申請書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請書受付年月日"));
        entity.setShuryoShinsei_UketsukeYMD(終了申請書受付年月日);
    }

    /**
     * 終了申請年月日を設定します。
     *
     * @param 終了申請年月日 終了申請年月日
     */
    public void set終了申請年月日(FlexibleDate 終了申請年月日) {
        requireNonNull(終了申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請年月日"));
        entity.setShuryoShinsei_YMD(終了申請年月日);
    }

    /**
     * 終了申請理由コードを設定します。
     *
     * @param 終了申請理由コード 終了申請理由コード
     */
    public void set終了申請理由コード(ShuryoShinseiRiyu 終了申請理由コード) {
        requireNonNull(終了申請理由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請理由コード"));
        entity.setShuryoShinsei_RiyuCode(終了申請理由コード.code());
    }

    /**
     * 終了申請審査決定年月日を設定します。
     *
     * @param 終了申請審査決定年月日 終了申請審査決定年月日
     */
    public void set終了申請審査決定年月日(FlexibleDate 終了申請審査決定年月日) {
        requireNonNull(終了申請審査決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請審査決定年月日"));
        entity.setShuryoShinsei_ShinsaKetteiYMD(終了申請審査決定年月日);
    }

    /**
     * 終了申請審査結果区分を設定します。
     *
     * @param 終了申請審査結果区分 終了申請審査結果区分
     */
    public void set終了申請審査結果区分(ShuryoShinseiShinsaKekkaKubun 終了申請審査結果区分) {
        requireNonNull(終了申請審査結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("終了申請審査結果区分"));
        entity.setShuryoShinsei_ShinsaKekkaKubun(終了申請審査結果区分.code());
    }

    /**
     * 無効区分を設定します。
     *
     * @param 無効区分 無効区分
     */
    public void set無効区分(boolean 無効区分) {
        requireNonNull(無効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("無効区分"));
        entity.setMukoKubun(無効区分);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
