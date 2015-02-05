/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dba.model.relate.shikakuido.JushochiTokureiModel;
import jp.co.ndensan.reams.db.dba.persistence.relate.JushochiTokureiRirekiRelateDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住所地特例異動処理を行う際に、被保険者台帳と施設入退所の情報を、同一トランザクションで登録する機能を提供します。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiRegister {

    private final JushochiTokureiRirekiRelateDac dac;

    /**
     * コンストラクタです。
     */
    public JushochiTokureiRegister() {
        dac = InstanceProvider.create(JushochiTokureiRirekiRelateDac.class);
    }

    /**
     * テスト用コンストラクタです。DacのMockを引数から受け取ります。
     *
     * @param dac テスト用MockDac
     */
    JushochiTokureiRegister(JushochiTokureiRirekiRelateDac dac) {
        this.dac = dac;
    }

    /**
     * 引数から資格取得関連情報Modelを受け取り、その情報を元にDBを更新します。
     *
     * @param 住所地特例Model 住所地特例Model
     * @return 保存に成功した場合、true
     */
    public boolean save(JushochiTokureiModel 住所地特例Model) {
        return dac.update(住所地特例Model) > 0;
    }
}
