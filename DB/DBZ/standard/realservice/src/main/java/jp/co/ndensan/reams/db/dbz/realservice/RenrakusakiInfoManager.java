/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.KaigoRenrakusaki;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.mapper.RenrakusakiInfoMapper;
import jp.co.ndensan.reams.db.dbz.persistence.basic.RenrakusakiInfoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 連絡先情報を管理するためのクラスです。
 *
 * @author n9606 漢那 憲作
 */
public class RenrakusakiInfoManager {

    private final RenrakusakiInfoDac dac;

    /**
     * 新しいRenrakusakiInfoManagerのインスタンスを生成します。
     */
    public RenrakusakiInfoManager() {
        this.dac = InstanceProvider.create(RenrakusakiInfoDac.class);
    }

    /**
     * テスト用のコンストラクタです。dacを指定してインスタンスを生成します。
     *
     * @param dac {@link RenrakusakiInfoManager 連絡先情報DAC}
     */
    public RenrakusakiInfoManager(RenrakusakiInfoDac dac) {
        this.dac = dac;
    }

    private boolean isSuccess(int result) {
        return 0 < result;
    }

    /**
     * 指定の連絡先情報を連絡先情報テーブルへ更新します。
     *
     * @param renrakusakiJoho 連絡先情報
     * @return 成功：true, 失敗：false。
     */
    public boolean save(KaigoRenrakusaki renrakusakiJoho) {
        DbT5050RenrakusakiJohoEntity entity = RenrakusakiInfoMapper.toRenrakusakiJohoEntity(renrakusakiJoho);

        int result = this.dac.insertOrUpdate(entity);
        return isSuccess(result);
    }

    /**
     * 指定の連絡先情報を連絡先情報テーブルから削除します。
     *
     * @param renrakusakiJoho 連絡先情報
     * @return 成功：true, 失敗：false。
     */
    public boolean remove(KaigoRenrakusaki renrakusakiJoho) {
        DbT5050RenrakusakiJohoEntity entity = RenrakusakiInfoMapper.toRenrakusakiJohoEntity(renrakusakiJoho);

        int result = this.dac.delete(entity);
        return isSuccess(result);
    }

}
