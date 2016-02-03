/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedule;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会スケジュール表ですためのProcess用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KaigoNinteiShinsakaiScheduleProcessParamter implements IBatchProcessParameter {

    private final RString shinsakaiKaisaiKikanFrom;
    private final RString shinsakaiKaisaiKikanTo;
    private final List<RString> shinsakaiIinCodeList;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催予定期間From 介護認定審査会開催予定期間From
     * @param 介護認定審査会開催予定期間To 介護認定審査会開催予定期間To
     * @param 審査会委員コードリスト 審査会委員コードリスト
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public KaigoNinteiShinsakaiScheduleProcessParamter(
            RString 介護認定審査会開催予定期間From,
            RString 介護認定審査会開催予定期間To,
            List<RString> 審査会委員コードリスト) {
        this.shinsakaiKaisaiKikanFrom = 介護認定審査会開催予定期間From;
        this.shinsakaiKaisaiKikanTo = 介護認定審査会開催予定期間To;
        this.shinsakaiIinCodeList = 審査会委員コードリスト;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return KaigoNinteiShinsakaiScheduleMybitisParamter
     */
    public KaigoNinteiShinsakaiScheduleMybitisParamter toKaigoNinteiShinsakaiScheduleMybitisParamter() {
        return new KaigoNinteiShinsakaiScheduleMybitisParamter(
                shinsakaiKaisaiKikanFrom,
                shinsakaiKaisaiKikanTo,
                shinsakaiIinCodeList);
    }
}
