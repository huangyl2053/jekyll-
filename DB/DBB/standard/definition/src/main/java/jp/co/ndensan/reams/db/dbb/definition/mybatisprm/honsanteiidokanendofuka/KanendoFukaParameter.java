/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（過年度）（バッチ）用パラメータです。
 *
 * @reamsid_L DBB-0910-020 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KanendoFukaParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
    private Long 出力順ID;
    private RDateTime 抽出開始日時;
    private RDateTime 抽出終了日時;
    private YMDHMS システム日時;
    private RString 日付関連_年度サイクル;

    private FlexibleYear 調定年度minus1;
    private FlexibleYear 調定年度minus2;

    private FlexibleYear 賦課年度;
    private RString 年度サイクル;

    private RString 抽出開始日時str;
    private RString 抽出終了日時str;
}
