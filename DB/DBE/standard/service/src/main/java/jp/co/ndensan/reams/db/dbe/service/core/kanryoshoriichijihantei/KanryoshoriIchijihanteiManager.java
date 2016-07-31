/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.kanryoshoriichijihantei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 完了処理・一次判定のManagerクラスです。
 *
 * @reamsid_L DBE-2070-010 wangrenze
 */
public class KanryoshoriIchijihanteiManager {

    private final DbT5116IchijiHanteiKekkaJohoDac dac;
    private final DbT5105NinteiKanryoJohoDac dac1;

    /**
     * コンストラクタです。
     */
    KanryoshoriIchijihanteiManager() {
        dac = InstanceProvider.create(DbT5116IchijiHanteiKekkaJohoDac.class);
        dac1 = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac DbT5116IchijiHanteiKekkaJohoDac
     * @param dac1 DbT5105NinteiKanryoJohoDac
     */
    KanryoshoriIchijihanteiManager(DbT5116IchijiHanteiKekkaJohoDac dac, DbT5105NinteiKanryoJohoDac dac1) {

        this.dac = dac;
        this.dac1 = dac1;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KanryoshoriIchijihanteiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KanryoshoriIchijihanteiManager}のインスタンス
     */
    public static KanryoshoriIchijihanteiManager createInstance() {
        return InstanceProvider.create(KanryoshoriIchijihanteiManager.class);
    }

    /**
     * 要介護認定完了情報更新処理です。
     *
     * @param ninteiKanryoJoho ninteiKanryoJoho
     * @return int
     */
    @Transaction
    public int 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        if (ninteiKanryoJoho != null) {
            return dac1.save(ninteiKanryoJoho.toEntity());
        }
        return 0;
    }

    /**
     * 要介護認定完了情報更新処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return boolean
     */
    @Transaction
    public boolean get仮一次判定区分(ShinseishoKanriNo 申請書管理番号) {

        DbT5116IchijiHanteiKekkaJohoEntity entity = dac.selectByKey(申請書管理番号);
        if (entity != null) {
            return entity.getKariIchijiHanteiKubun();
        }
        return true;
    }

}
