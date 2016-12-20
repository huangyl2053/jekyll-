/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5203NinteichosahyoKihonChosa06AEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5203NinteichosahyoKihonChosa06ADac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（基本調査）06A情報を取得します。
 *
 * @author n8429
 */
public class NinteichosahyoKihonChosa06AManager {

    private final DbT5203NinteichosahyoKihonChosa06ADac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoKihonChosa06AManager() {
        dac = InstanceProvider.create(DbT5203NinteichosahyoKihonChosa06ADac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5203NinteichosahyoKihonChosa06ADac}
     */
    NinteichosahyoKihonChosa06AManager(DbT5203NinteichosahyoKihonChosa06ADac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoKihonChosa06AManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoKihonChosa06AManager}のインスタンス
     */
    public static NinteichosahyoKihonChosa06AManager createInstance() {
        return InstanceProvider.create(NinteichosahyoKihonChosa06AManager.class);
    }

    /**
     * 認定調査票（基本調査）{@link NinteiKeikakuJoho}を保存します。
     *
     * @param shinseishoKanriNo
     * @param 認定調査依頼履歴番号
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public DbT5203NinteichosahyoKihonChosa06AEntity select認定調査票(ShinseishoKanriNo shinseishoKanriNo, int 認定調査依頼履歴番号) {
        return dac.selectByKey(shinseishoKanriNo, 認定調査依頼履歴番号);
    }

    /**
     * 認定調査票（基本調査）{@link NinteiKeikakuJoho}を保存します。
     *
     * @param 情報
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票(DbT5203NinteichosahyoKihonChosa06AEntity 情報) {
        requireNonNull(情報, UrSystemErrorMessages.値がnull.getReplacedMessage("情報"));

        return 1 == dac.save(情報);
    }

}
