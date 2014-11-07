/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dba.model.shikakuido.ShikakuShutokuKanrenJohoModel;
import jp.co.ndensan.reams.db.dba.persistence.ShikakuShutokuKanrenJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格取得処理を行う際に、被保険者台帳の情報と同じトランザクションの中で、医療保険や生保などの情報を登録する機能を提供するクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuShutokuKanrenJohoRegister {

    private final ShikakuShutokuKanrenJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShikakuShutokuKanrenJohoRegister() {
        dac = InstanceProvider.create(ShikakuShutokuKanrenJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。DacのMockを引数から受け取ります。
     *
     * @param dac テスト用MockDac
     */
    ShikakuShutokuKanrenJohoRegister(ShikakuShutokuKanrenJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 引数から資格取得関連情報Modelを受け取り、その情報を元にDBを更新します。
     *
     * @param 資格取得関連情報Model 資格取得関連情報Model
     * @return 保存に成功した場合、true
     */
    public boolean save(ShikakuShutokuKanrenJohoModel 資格取得関連情報Model) {
        //TODO #52997
        //一括保存用のDacを呼び出して保存する。
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
