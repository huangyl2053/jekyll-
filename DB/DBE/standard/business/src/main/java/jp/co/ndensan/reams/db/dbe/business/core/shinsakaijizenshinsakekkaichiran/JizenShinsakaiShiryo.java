/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.JizenShinsakaiShiryoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事前審査会用結果のビジネスクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public class JizenShinsakaiShiryo {

    private final JizenShinsakaiShiryoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 事前審査会用結果情報
     */
    public JizenShinsakaiShiryo(JizenShinsakaiShiryoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 審査会開催番号を取得します。
     *
     * @return 審査会開催番号
     */
    public RString getShinsakaiKaisaiNo() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 開催予定日を取得します。
     *
     * @return 開催予定日
     */
    public RString getShinsakaiKaisaiYoteiYMD() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 審査会会場を取得します。
     *
     * @return 審査会会場
     */
    public RString getShinsakaiKaisaiBashoName() {
        return entity.getShinsakaiKaisaiBashoName();
    }

    /**
     * 開始予定時刻を取得します。
     *
     * @return 開始予定時刻
     */
    public RString getShinsakaiKaishiYoteiTime() {
        return entity.getShinsakaiKaishiYoteiTime();
    }

    /**
     * 資料作成のフラグを取得します。
     *
     * @return 資料作成のフラグ
     */
    public boolean isShiryoSakuseiZumiFlag() {
        return entity.isShiryoSakuseiZumiFlag();
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public int getGogitaiNo() {
        return entity.getGogitaiNo();
    }

    /**
     * 合議体名称を取得します。
     *
     * @return 合議体名称
     */
    public RString getGogitaiMei() {
        return entity.getGogitaiMei();
    }

    /**
     * 予定定員を取得します。
     *
     * @return 予定定員
     */
    public int getShinsakaiYoteiTeiin() {
        return entity.getShinsakaiYoteiTeiin();
    }

    /**
     * 割付人数を取得します。
     *
     * @return 割付人数
     */
    public int getShinsakaiWariateZumiNinzu() {
        return entity.getShinsakaiWariateZumiNinzu();
    }
}
