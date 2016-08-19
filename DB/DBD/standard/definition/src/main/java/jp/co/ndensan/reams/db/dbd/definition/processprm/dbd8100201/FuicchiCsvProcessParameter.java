/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201.FuicchiCsvMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者情報 不一致～CSV_Process用パラメータクラスです。
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuicchiCsvProcessParameter implements IBatchProcessParameter {

    private Long 出力順ID2;

    /**
     * コンストラクタです。
     *
     * @param 出力順ID2 出力順ID2
     */
    public FuicchiCsvProcessParameter(Long 出力順ID2) {
        this.出力順ID2 = 出力順ID2;
    }

    /**
     * ＳＱＬ使用された情報を作成します．
     *
     * @param 出力順 出力順
     * @return ＳＱＬ使用されたパラメター
     */
    public FuicchiCsvMybatisParameter toFuicchiCsvMybatisParameter(RString 出力順) {
        return new FuicchiCsvMybatisParameter(出力順);
    }
}
