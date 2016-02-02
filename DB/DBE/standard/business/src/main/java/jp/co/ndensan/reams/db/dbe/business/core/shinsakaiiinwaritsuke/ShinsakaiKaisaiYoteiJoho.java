/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinwaritsuke.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会開催予定情報ビジネスクラスです。
 */
public class ShinsakaiKaisaiYoteiJoho {

    private final ShinsakaiKaisaiYoteiJohoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 審査会開催予定情報RelateEntity
     */
    public ShinsakaiKaisaiYoteiJoho(ShinsakaiKaisaiYoteiJohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 合議体を取得します。
     *
     * @return 合議体
     */
    public RString get合議体() {
        return entity.getGogitaiMei();
    }

    /**
     * 開始予定時間を取得します。
     *
     * @return 開始予定時間
     */
    public RString get開始予定時間() {
        return entity.getShinsakaiKaishiYoteiTime();
    }

    /**
     * ダミー区分を取得します。
     *
     * @return ダミー区分
     */
    public boolean isダミー区分() {
        return entity.isGogitaiDummyFlag();
    }

    /**
     * 開催予定日を取得します。
     *
     * @return 開催予定日
     */
    public RString get開催予定日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 開催場所を取得します。
     *
     * @return 開催予定日
     */
    public RString get開催場所() {
        return entity.getShinsakaiKaisaiBashoName();
    }

    /**
     * 終了予定時間を取得します。
     *
     * @return 終了予定時間
     */
    public RString get終了予定時間() {
        return entity.getShinsakaiShuryoYoteiTime();
    }

    /**
     * 予定定員を取得します。
     *
     * @return 予定定員
     */
    public int get予定定員() {
        return entity.getShinsakaiYoteiTeiin();
    }

    /**
     * 精神科医を取得します。
     *
     * @return 精神科医
     */
    public boolean is精神科医() {
        return entity.isGogitaiSeishinkaSonzaiFlag();
    }
}
