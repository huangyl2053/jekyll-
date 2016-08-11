/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定審査依頼IF作成（モバイル）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShinsaTaishoDataOutPutMybatisParameter implements IMyBatisParameter {

    private final RString kaisaiBangou;

    /**
     * コンストラクタです。
     *
     * @param kaisaiBangou 開催番号
     *
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public ShinsaTaishoDataOutPutMybatisParameter(RString kaisaiBangou) {
        this.kaisaiBangou = kaisaiBangou;

    }

    /**
     * コンストラクタです。
     *
     * @param kaisaiBangou 開催番号
     * @param kaisaiBangouList 開催番号
     * @return ShinsaTaishoDataOutPutMybatisParameter
     */
    public ShinsaTaishoDataOutPutMybatisParameter createParamter(RString kaisaiBangou, List<RString> kaisaiBangouList) {
        return new ShinsaTaishoDataOutPutMybatisParameter(kaisaiBangou);
    }
}
