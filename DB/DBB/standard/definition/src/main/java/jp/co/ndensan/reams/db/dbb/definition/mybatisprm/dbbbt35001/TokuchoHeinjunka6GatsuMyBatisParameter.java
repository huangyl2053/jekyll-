/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt35001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴平準化（特徴6月分）用パラメータのクラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeinjunka6GatsuMyBatisParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private YMDHMS 調定日時;
    private OutputChohyoIchiran 出力帳票一覧;
    private RDate 発行日;
    private RString 文書番号;
    private RString 出力対象;
    private RString 増額平準化方法;
    private RString 減額平準化方法;
    private FlexibleYear 調定前年度;
    private RString 出力順;
    private int 出力ページ数;
    private UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;
    private RDateTime システーム日時;
}
