/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料作成の更新情報のMyBatisParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiShiryoUpdateMyBatisParameter implements IMyBatisParameter {

    private RString shinsakaiKaisaiNo;
    private int bangoStart;
    private int bangoEnd;
    private boolean isSakuseiJokenHani;
    private boolean isSakuseiJokenTsuika;
    private boolean isGogitaiDummyFlag;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param bangoStart int
     * @param bangoEnd int
     * @param isSakuseiJokenHani 作成条件が範囲指定かどうか
     * @param isSakuseiJokenTsuika 作成条件が追加かどうか
     * @param isGogitaiDummyFlag 合議体ダミーフラグ
     */
    public ShinsakaiShiryoUpdateMyBatisParameter(RString shinsakaiKaisaiNo, int bangoStart, int bangoEnd,
            boolean isSakuseiJokenHani, boolean isSakuseiJokenTsuika, boolean isGogitaiDummyFlag) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
        this.isSakuseiJokenHani = isSakuseiJokenHani;
        this.isSakuseiJokenTsuika = isSakuseiJokenTsuika;
        this.isGogitaiDummyFlag = isGogitaiDummyFlag;
    }
}
