/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100203;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100203.SokyuuFuicchiCsvMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者情報_遡及不一致_Process用パラメータクラスです。
 *
 * @reamsid_L DBD-4910-030 x_miaocl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokyuuFuicchiCsvProcessParameter implements IBatchProcessParameter {

    private Long 出力順ID2;

    /**
     * コンストラクタです。
     *
     * @param 出力順ID2 出力順ID2
     */
    public SokyuuFuicchiCsvProcessParameter(Long 出力順ID2) {
        this.出力順ID2 = 出力順ID2;
    }

    /**
     * ＳＱＬ使用された情報を作成します．
     *
     * @param 出力順 出力順
     * @return ＳＱＬ使用された情報
     */
    public SokyuuFuicchiCsvMybatisParameter toSokyuuFuicchiCsvMybatisParameter(RString 出力順) {
        return new SokyuuFuicchiCsvMybatisParameter(出力順);
    }
}
