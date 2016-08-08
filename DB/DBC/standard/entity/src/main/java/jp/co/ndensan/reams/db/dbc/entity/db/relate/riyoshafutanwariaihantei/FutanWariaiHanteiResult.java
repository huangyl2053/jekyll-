/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担割合判定結果のエンティティです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FutanWariaiHanteiResult {

    private RString 負担割合区分;
    private RString 判定区分;

    /**
     * 負担割合判定結果のコンストラクタです。
     */
    public FutanWariaiHanteiResult() {
    }

    /**
     * 負担割合判定結果のコンストラクタです。
     *
     * @param 負担割合区分 負担割合区分
     * @param 判定区分 負担割合区分
     */
    public FutanWariaiHanteiResult(RString 負担割合区分, RString 判定区分) {
        this.負担割合区分 = 負担割合区分;
        this.判定区分 = 判定区分;
    }

}
