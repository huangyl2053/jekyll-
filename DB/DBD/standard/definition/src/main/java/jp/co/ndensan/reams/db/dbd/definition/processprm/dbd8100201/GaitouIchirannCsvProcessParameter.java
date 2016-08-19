/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201.GaitouIchirannCsvMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者情報(該当一覧CSV)_Process用パラメータクラスです。
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GaitouIchirannCsvProcessParameter implements IBatchProcessParameter {

    private Long 出力順ID1;

    /**
     * コンストラクタです。
     *
     * @param 出力順ID1 出力順ID1
     */
    public GaitouIchirannCsvProcessParameter(Long 出力順ID1) {
        this.出力順ID1 = 出力順ID1;
    }

    /**
     * ＳＱＬ使用された情報を作成します．
     *
     * @param 出力順 出力順
     * @return ＳＱＬ使用されたパラメター
     */
    public GaitouIchirannCsvMybatisParameter toGaitouIchirannCsvMybatisParameter(RString 出力順) {
        return new GaitouIchirannCsvMybatisParameter(出力順);
    }
}
