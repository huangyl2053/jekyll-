/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kaigoninteishinsakaischedule;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会スケジュール表ですためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0130-090 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KaigoNinteiShinsakaiScheduleMybitisParamter implements IMyBatisParameter {

    private final RString shinsakaiKaisaiKikanFrom;
    private final RString shinsakaiKaisaiKikanTo;
    private final RString nendo;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催予定期間From 介護認定審査会開催予定期間From
     * @param 介護認定審査会開催予定期間To 介護認定審査会開催予定期間To
     * @param 年度 年度
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public KaigoNinteiShinsakaiScheduleMybitisParamter(
            RString 介護認定審査会開催予定期間From,
            RString 介護認定審査会開催予定期間To,
            RString 年度) {
        this.shinsakaiKaisaiKikanFrom = 介護認定審査会開催予定期間From;
        this.shinsakaiKaisaiKikanTo = 介護認定審査会開催予定期間To;
        this.nendo = 年度;
    }
}
