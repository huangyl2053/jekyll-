/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100203;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者情報_遡及該当一覧SQLのパラメータクラスです．
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokyuuGaitouIchirannCsvMybatisParameter implements IMyBatisParameter {

    private RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 出力順
     */
    public SokyuuGaitouIchirannCsvMybatisParameter(RString 出力順) {
        this.出力順 = 出力順;
    }

}
