/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.shokaishukirokukanrijoho;

import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 証回収記録管理のmanagerクラスです。
 *
 * @reamsid_L DBU-0160-020 yaodongsheng
 */
public class ShoKaishuKirokuKanriJohoManager {

    private final DbT7037ShoKofuKaishuDac 証交付回収情報dac;

    /**
     * コンストラクタ
     */
    ShoKaishuKirokuKanriJohoManager() {
        this.証交付回収情報dac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 証交付回収情報dac 証交付回収情報dac
     */
    ShoKaishuKirokuKanriJohoManager(
            DbT7037ShoKofuKaishuDac 証交付回収情報dac
    ) {
        this.証交付回収情報dac = 証交付回収情報dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShoKaishuKirokuKanriJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShoKaishuKirokuKanriJohoManager}のインスタンス
     */
    public static ShoKaishuKirokuKanriJohoManager createInstance() {
        return InstanceProvider.create(ShoKaishuKirokuKanriJohoManager.class);
    }

    /**
     * 証交付回収情報を変更または削除します
     *
     * @param shoKofuKaishu ShoKofuKaishu
     * @return count
     */
    @Transaction
    public int updateOrdelete(ShoKofuKaishu shoKofuKaishu) {
        if (!shoKofuKaishu.hasChanged()) {
            return 0;
        }
        return 証交付回収情報dac.save(shoKofuKaishu.toEntity());
    }
}
