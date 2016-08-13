/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請書発行対象者把握クラスです。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class ShinseishoHakkoTaishoshaHaakuBatch {

    private final DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity entity;
    private final ShinseishoHakkoTaishoshaHaakuBatchIdentifier id;

    /**
     * コンストラクタです。
     *
     * @param 把握処理ID UUID
     */
    public ShinseishoHakkoTaishoshaHaakuBatch(UUID 把握処理ID) {
        this.entity = new DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity();
        this.entity.setHaakuShoriID(把握処理ID);
        this.id = new ShinseishoHakkoTaishoshaHaakuBatchIdentifier(把握処理ID);
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity
     */
    public ShinseishoHakkoTaishoshaHaakuBatch(DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給判定結果"));
        this.id = new ShinseishoHakkoTaishoshaHaakuBatchIdentifier(entity.getHaakuShoriID());
    }

    /**
     * コンストラクタです。
     *
     * @param id ShinseishoHakkoTaishoshaHaakuBatchIdentifier
     * @param entity DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity
     */
    ShinseishoHakkoTaishoshaHaakuBatch(ShinseishoHakkoTaishoshaHaakuBatchIdentifier id,
            DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity entity) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 把握処理IDを取得です。
     *
     * @return 把握処理ID
     */
    public UUID get把握処理ID() {
        return this.entity.getHaakuShoriID();
    }

    /**
     * バッチ処理日時を取得です。
     *
     * @return バッチ処理日時
     */
    public YMDHMS getバッチ処理日時() {
        return this.entity.getBatchExecutedTimestamp();
    }

    /**
     * 減免減額種類を取得です。
     *
     * @return 減免減額種類
     */
    public RString get減免減額種類() {
        return this.entity.getGemmenGengakuShurui();
    }

    /**
     * 基準日を取得です。
     *
     * @return 基準日
     */
    public FlexibleDate get基準日() {
        return this.entity.getKijunYmd();
    }

    /**
     * 所得年度を取得です。
     *
     * @return 所得年度
     */
    public FlexibleYearMonth get所得年度() {
        return this.entity.getShotokuNendo();
    }
}
