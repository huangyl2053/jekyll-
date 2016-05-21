/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.kaigoninteishinsakaischedule;

import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 介護認定審査会スケジュール表ですためのバッチ用パラメータクラスです。
 *
 * @reamsid_L DBE-0130-090 yaodongsheng
 */
@Getter
@Setter
public class KaigoNinteiShinsakaiScheduleBatchParamter extends BatchParameterBase {

    private static final String SHINSAKAIKAISAIKIKANFROM = "shinsakaiKaisaiKikanFrom";
    private static final String SHINSAKAIKAISAIKIKANTO = "shinsakaiKaisaiKikanTo";
    private static final String NENDO = "shinsakaiKaisaiKikanTo";
    private static final String CHOHYOSHUTSURYOKUKUBUN = "chohyoShutsuryokuKubun";

    @BatchParameter(key = SHINSAKAIKAISAIKIKANFROM, name = "介護認定審査会開催予定期間From")
    private RString shinsakaiKaisaiKikanFrom;
    @BatchParameter(key = SHINSAKAIKAISAIKIKANTO, name = "介護認定審査会開催予定期間To")
    private RString shinsakaiKaisaiKikanTo;
    @BatchParameter(key = NENDO, name = "年度")
    private RString nendo;
    @BatchParameter(key = CHOHYOSHUTSURYOKUKUBUN, name = "帳票出力区分")
    private RString chohyoShutsuryokuKubun;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催予定期間From 介護認定審査会開催予定期間From
     * @param 介護認定審査会開催予定期間To 介護認定審査会開催予定期間To
     * @param 年度 年度
     * @param 帳票出力区分 帳票出力区分
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public KaigoNinteiShinsakaiScheduleBatchParamter(
            RString 介護認定審査会開催予定期間From,
            RString 介護認定審査会開催予定期間To,
            RString 年度,
            RString 帳票出力区分) {
        this.shinsakaiKaisaiKikanFrom = 介護認定審査会開催予定期間From;
        this.shinsakaiKaisaiKikanTo = 介護認定審査会開催予定期間To;
        this.nendo = 年度;
        this.chohyoShutsuryokuKubun = 帳票出力区分;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return KaigoNinteiShinsakaiScheduleProcessParamter
     */
    public KaigoNinteiShinsakaiScheduleProcessParamter toKaigoNinteiShinsakaiScheduleProcessParamter() {
        return new KaigoNinteiShinsakaiScheduleProcessParamter(shinsakaiKaisaiKikanFrom,
                shinsakaiKaisaiKikanTo,
                nendo,
                chohyoShutsuryokuKubun);
    }
}
