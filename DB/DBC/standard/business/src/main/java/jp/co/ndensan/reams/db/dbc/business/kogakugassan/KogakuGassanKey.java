/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.kogakugassan;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 高額合算キークラス
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKey implements Serializable {

    private Map<FlexibleYear, List<KogakuGassanNendoKey>> 年度毎キー;

    /**
     * 年度毎キーを返します。
     *
     * @return 年度毎キー
     */
    public Map<FlexibleYear, List<KogakuGassanNendoKey>> get年度毎キー() {
        return 年度毎キー;
    }
}
