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
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return 更新件数
     */
    @Transaction
    public int 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        int 更新件数 = 0;
        if (ninteiKanryoJoho != null) {
            dac.save(ninteiKanryoJoho.toEntity());
            更新件数 = 更新件数 + 1;
        }
        return 更新件数;
    }

    /**
     * 要介護認定完了情報追加処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return 追加件数
     */
    @Transaction
    public int 要介護認定完了情報が追加(NinteiKanryoJoho ninteiKanryoJoho) {
        int 追加件数 = 0;
        if (ninteiKanryoJoho != null) {
            dac.save(ninteiKanryoJoho.toEntity());
            追加件数 = 追加件数 + 1;
        }
        return 追加件数;
    }

}
