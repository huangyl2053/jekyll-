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
 * 非課税年金対象者情報_生年月日SQLのパラメータクラスです．
 *
 * @reamsid_L DBD-4910-050 x_miaocl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokyuuSeinenngappiCsvMybatisParameter implements IMyBatisParameter {

    private RString 出力順;

    /**
     * 非課税年金対象者情報_該当一覧の引数を返します。
     *
     * @param 出力順 出力順
     */
    public SokyuuSeinenngappiCsvMybatisParameter(RString 出力順) {
        this.出力順 = 出力順;
    }
}
