/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.seikatsuhogorireki;

import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 生活保護履歴情報のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SeikatsuhogoParameter {

    private ShikibetsuCode shikibetsuCode;
    private GyomuCode gyomuCode;
}
