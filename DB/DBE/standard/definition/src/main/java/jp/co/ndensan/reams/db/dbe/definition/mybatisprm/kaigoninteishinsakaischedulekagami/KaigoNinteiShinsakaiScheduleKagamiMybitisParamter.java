/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kaigoninteishinsakaischedulekagami;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護認定審査会スケジュール表かがみですためのMyBatis用パラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoNinteiShinsakaiScheduleKagamiMybitisParamter implements IMyBatisParameter {

    private final List<RString> shinsakaiIinCodeList;

    /**
     * コンストラクタです。
     *
     * @param 審査会委員コードリスト 審査会委員コードリスト
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public KaigoNinteiShinsakaiScheduleKagamiMybitisParamter(
            List<RString> 審査会委員コードリスト) {
        this.shinsakaiIinCodeList = 審査会委員コードリスト;
    }
}
