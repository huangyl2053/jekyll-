/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput.ShinsaTaishoDataOutPutMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 認定審査依頼IF作成（モバイル）ですためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShinsaTaishoDataOutPutProcessParammeter implements IBatchProcessParameter {

    private RString spoolWorkPath;
    private final RString kaisaiBangou;

    /**
     * コンストラクタです。
     *
     * @param kaisaiBangou 開催番号
     * @param spoolWorkPath spoolWorkPath
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public ShinsaTaishoDataOutPutProcessParammeter(RString kaisaiBangou, RString spoolWorkPath) {
        this.kaisaiBangou = kaisaiBangou;
        this.spoolWorkPath = spoolWorkPath;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return ShinsaTaishoDataOutMybatisParameter
     */
    public ShinsaTaishoDataOutPutMybatisParameter toShinsaTaishoDataOutMybatisParameter() {
        return new ShinsaTaishoDataOutPutMybatisParameter(kaisaiBangou);
    }
}
