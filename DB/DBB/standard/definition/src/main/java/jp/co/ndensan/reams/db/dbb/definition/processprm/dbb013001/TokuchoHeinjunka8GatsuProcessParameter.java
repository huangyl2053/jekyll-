/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb013001;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴平準化（特徴8月分）プロセスパラメータです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeinjunka8GatsuProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private YMDHMS 調定日時;
    private RString 増額平準化方法;
    private RString 減額平準化方法;
    private RString 出力順ID;
    private UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;
}
