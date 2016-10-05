/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteifuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴仮算定賦課する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKarisanteiFukaMyBatisParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 調定年度BeforeYear;
    private FlexibleYear 賦課年度;
    private FlexibleYear 賦課年度BeforeYear;
    private YMDHMS 調定日時;
    private RString 出力順;
    private SubGyomuCode サーブ業務コード;
    private RString 処理名;
    private FlexibleYear 年度;
    private RString 年度内番号;
}
