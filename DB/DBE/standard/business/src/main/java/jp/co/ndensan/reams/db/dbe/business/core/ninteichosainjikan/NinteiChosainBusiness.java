/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosainjikan;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosainjikan.NinteiChosainEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール情報を管理するクラスです。
 *
 * @reamsid_L DBE-0022-010 linghuhang
 */
public class NinteiChosainBusiness {

    private final NinteiChosainEntity entity;

    /**
     * 認定調査スケジュール情報を返します。
     *
     * @param entity NinteiChosainEntity
     */
    public NinteiChosainBusiness(NinteiChosainEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日
     */
    public FlexibleDate get認定調査予定年月日() {
        return entity.getNinteiChosaYoteiYMD();
    }

    /**
     * 認定調査予定開始時間を返します。
     *
     * @return 認定調査予定開始時間
     */
    public RString get認定調査予定開始時間() {
        return entity.getNinteiChosaYoteiKaishiTime();
    }

    /**
     * 認定調査予定終了時間を返します。
     *
     * @return 認定調査予定終了時間
     */
    public RString get認定調査予定終了時間() {
        return entity.getNinteiChosaYoteiShuryoTime();
    }

    /**
     * 認定調査時間枠を返します。
     *
     * @return 認定調査時間枠
     */
    public Code get認定調査時間枠() {
        return entity.getNinteiChosaJikanWaku();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity == null ? RString.EMPTY : entity.getBiko();
    }

    /**
     * 予約可能フラグを返します。
     *
     * @return 予約可能フラグ
     */
    public boolean is予約可能フラグ() {
        return entity == null ? true : entity.isYoyakuKaoFlag();
    }

    /**
     * 予約状況を返します。
     *
     * @return 予約状況
     */
    public Code get予約状況() {
        return entity.getYoyakuJokyo();
    }
}
