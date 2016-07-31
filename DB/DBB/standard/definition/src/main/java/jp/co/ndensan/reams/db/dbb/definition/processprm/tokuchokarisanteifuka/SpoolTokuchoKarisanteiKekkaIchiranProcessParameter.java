/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴仮算定結果一覧表出力processParameter
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SpoolTokuchoKarisanteiKekkaIchiranProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private YMDHMS 調定日時;
    private RString 出力順ID;

    /**
     * コンストラクタ
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID RString
     */
    public SpoolTokuchoKarisanteiKekkaIchiranProcessParameter(FlexibleYear 調定年度, FlexibleYear 賦課年度, YMDHMS 調定日時, RString 出力順ID) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.出力順ID = 出力順ID;
    }
}
