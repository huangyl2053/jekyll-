/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.kanryoshorishinsauketsuke;

import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 完了処理・審査受付のManagerクラスです。
 *
 * @reamsid_L DBE-2060-010 wangrenze
 */
public class KanryoShoriShinsaUketsukeManager {

    private final DbT5105NinteiKanryoJohoDac dac;

    /**
     * コンストラクタです。
     */
    KanryoShoriShinsaUketsukeManager() {
        dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac1 DbT5105NinteiKanryoJohoDac
     */
    KanryoShoriShinsaUketsukeManager(DbT5105NinteiKanryoJohoDac dac) {

        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KanryoShoriShinsaUketsukeManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KanryoShoriShinsaUketsukeManager}のインスタンス
     */
    public static KanryoShoriShinsaUketsukeManager createInstance() {
        return InstanceProvider.create(KanryoShoriShinsaUketsukeManager.class);
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
            return dac.save(ninteiKanryoJoho.toEntity());
        }
        return 0;
    }

}
