/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5207NinteichosahyoServiceJokyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（概況調査）サービスの状況を取得します。
 *
 * @author n8429
 */
public class NinteichosahyoServiceJokyoManager {

    private final DbT5207NinteichosahyoServiceJokyoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoServiceJokyoManager() {
        dac = InstanceProvider.create(DbT5207NinteichosahyoServiceJokyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5207NinteichosahyoServiceJokyoDac}
     */
    NinteichosahyoServiceJokyoManager(DbT5207NinteichosahyoServiceJokyoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoServiceJokyoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoKihonChosa06AManager}のインスタンス
     */
    public static NinteichosahyoServiceJokyoManager createInstance() {
        return InstanceProvider.create(NinteichosahyoServiceJokyoManager.class);
    }

    /**
     * 認定調査票（基本調査）{@link NinteiKeikakuJoho}を保存します。
     *
     * @param shinseishoKanriNo
     * @param 認定調査依頼履歴番号
     * @param 連番
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public DbT5207NinteichosahyoServiceJokyoEntity select認定調査票(ShinseishoKanriNo shinseishoKanriNo, int 認定調査依頼履歴番号, int 連番) {
        return dac.selectByKey(shinseishoKanriNo, 認定調査依頼履歴番号, 連番);
    }

    /**
     * 認定調査票（基本調査）{@link NinteiKeikakuJoho}を保存します。
     *
     * @param 情報
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票(DbT5207NinteichosahyoServiceJokyoEntity 情報) {
        requireNonNull(情報, UrSystemErrorMessages.値がnull.getReplacedMessage("情報"));

        return 1 == dac.save(情報);
    }

}
