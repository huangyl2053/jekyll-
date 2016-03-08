/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.JiKanKanRiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 事務所の場合で認定調査スケジュール登録9Businessです。
 */
public class JiKanKanRiBusiness {

    private final JiKanKanRiEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link JiKanKanRiEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link JiKanKanRiEntity}
     */
    public JiKanKanRiBusiness(JiKanKanRiEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 予約状況を返します。
     *
     * @return 予約状況
     */
    public Code get予約状況() {
        return entity.getYoyakuJokyo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 連絡先1を返します。
     *
     * @return 連絡先1
     */
    public TelNo get連絡先1() {
        return entity.getRenrakusaki1();
    }

    /**
     * 連絡先2を返します。
     *
     * @return 連絡先2
     */
    public TelNo get連絡先2() {
        return entity.getRenrakusaki2();
    }

    /**
     * 8:00～8:30を返します。
     *
     * @return 8:00～8:30
     */
    public RString getEightClock() {
        return entity.getEightClock();
    }

    /**
     * 8:30～9:00を返します。
     *
     * @return 8:30～9:00
     */
    public RString getHalfPastEightClock() {
        return entity.getHalfPastEightClock();
    }

    /**
     * 9:00～9:30を返します。
     *
     * @return 9:00～9:30
     */
    public RString getNineClock() {
        return entity.getNineClock();
    }

    /**
     * 9:30～10:00を返します。
     *
     * @return 9:30～10:00
     */
    public RString getHalfPastNineClock() {
        return entity.getHalfPastNineClock();
    }

    /**
     * 10:00～10:30を返します。
     *
     * @return 10:00～10:30
     */
    public RString getTenClock() {
        return entity.getTenClock();
    }

    /**
     * 10:30～11:00を返します。
     *
     * @return 10:30～11:00
     */
    public RString getHalfPastTenClock() {
        return entity.getHalfPastTenClock();
    }

    /**
     * 11:00～11:30を返します。
     *
     * @return 11:00～11:30
     */
    public RString getElevenClock() {
        return entity.getElevenClock();
    }

    /**
     * 11:30～12:00を返します。
     *
     * @return 11:30～12:00
     */
    public RString getHalfPastElevenClock() {
        return entity.getHalfPastElevenClock();
    }

    /**
     * 12:00～12:30を返します。
     *
     * @return 12:00～12:30
     */
    public RString getTwelveClock() {
        return entity.getTwelveClock();
    }

    /**
     * 12:30～13:00を返します。
     *
     * @return 12:30～13:00
     */
    public RString getHalfPastTwelveClock() {
        return entity.getHalfPastTwelveClock();
    }

    /**
     * 13:00～13:30を返します。
     *
     * @return 13:00～13:30
     */
    public RString getThirteenClock() {
        return entity.getThirteenClock();
    }

    /**
     * 13:30～14:30を返します。
     *
     * @return 13:30～14:00
     */
    public RString getHalfPastThirteenClock() {
        return entity.getHalfPastThirteenClock();
    }

    /**
     * 14:00～14:30を返します。
     *
     * @return 14:00～14:30
     */
    public RString getFourteenClock() {
        return entity.getFourteenClock();
    }

    /**
     * 14:30～15:00を返します。
     *
     * @return 14:30～15:00
     */
    public RString getHalfPastFourteenClock() {
        return entity.getHalfPastFourteenClock();
    }

    /**
     * 15:00～15:30を返します。
     *
     * @return 15:00～15:30
     */
    public RString getFifteenClock() {
        return entity.getFifteenClock();
    }

    /**
     * 15:30～16:00を返します。
     *
     * @return 15:30～16:00
     */
    public RString getHalfPastFifteenClock() {
        return entity.getHalfPastFifteenClock();
    }

    /**
     * 16:00～16:30を返します。
     *
     * @return 16:00～16:30
     */
    public RString getSixteenClock() {
        return entity.getSixteenClock();
    }

    /**
     * 16:30～17:00を返します。
     *
     * @return 16:30～17:00
     */
    public RString getHalfPastSixteenClock() {
        return entity.getHalfPastSixteenClock();
    }

    /**
     * 17:00～17:30を返します。
     *
     * @return 17:00～17:30
     */
    public RString getSeventeenClock() {
        return entity.getSeventeenClock();
    }

    /**
     * 17:30～18:00を返します。
     *
     * @return 17:30～18:00
     */
    public RString getHalfPastSeventeenClock() {
        return entity.getHalfPastSeventeenClock();
    }

    /**
     * 18:00～18:30を返します。
     *
     * @return 18:00～18:30
     */
    public RString getEighteenClock() {
        return entity.getEighteenClock();
    }

    /**
     * 18:30～19:00を返します。
     *
     * @return 18:30～19:00
     */
    public RString getHalfPastEighteenClock() {
        return entity.getHalfPastEighteenClock();
    }

    /**
     * 19:00～19:30を返します。
     *
     * @return 19:00～19:30
     */
    public RString getNineteenClock() {
        return entity.getNineteenClock();
    }

    /**
     * 19:30～20:00を返します。
     *
     * @return 19:30～20:00
     */
    public RString getHalfPastNineteenClock() {
        return entity.getHalfPastNineteenClock();
    }

    /**
     * 20:00～20:30を返します。
     *
     * @return 20:00～20:30
     */
    public RString getTwentyClock() {
        return entity.getTwentyClock();
    }

    /**
     * 20:30～21:00を返します。
     *
     * @return 20:30～21:00
     */
    public RString getHalfPastTwentyClock() {
        return entity.getHalfPastTwentyClock();
    }
}
