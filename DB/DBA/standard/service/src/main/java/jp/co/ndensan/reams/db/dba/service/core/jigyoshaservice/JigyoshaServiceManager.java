/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jigyoshaservice;

import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 介護事業者指定サービス情報を物理削除します。
 *
 * @reamsid_L DBA-0340-060 dongyabin
 */
public class JigyoshaServiceManager {

    private final DbT7063KaigoJigyoshaShiteiServiceDac dac;

    /**
     * コンストラクタです。
     */
    public JigyoshaServiceManager() {
        dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1004ShisetsuNyutaishoDac}
     */
    JigyoshaServiceManager(DbT7063KaigoJigyoshaShiteiServiceDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JigyoshaServiceManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JigyoshaServiceManager}のインスタンス
     */
    public static JigyoshaServiceManager createInstance() {
        return InstanceProvider.create(JigyoshaServiceManager.class);
    }

    /**
     * 介護事業者指定サービス情報を物理削除します。
     *
     * @param joho 物理削除のデータ
     * @return 削除結果
     */
    public boolean 情報を物理削除(KaigoJigyoshaShiteiService joho) {
        joho = joho.deleted();
        return 1 == dac.delete(joho.toEntity());
    }
}
