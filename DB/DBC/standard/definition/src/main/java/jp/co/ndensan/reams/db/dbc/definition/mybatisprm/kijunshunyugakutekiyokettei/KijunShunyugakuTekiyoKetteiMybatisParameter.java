/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunshunyugakutekiyokettei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 基準収入額決定通知書発行のバッチのパラメータです
 *
 * @reamsid_L DBC-4610-030 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KijunShunyugakuTekiyoKetteiMybatisParameter implements IMyBatisParameter {

    private RString 抽出期間;
    private FlexibleDate 開始日;
    private FlexibleDate 終了日;
    private RString 印書;
    private RString temp_出力順;

}
