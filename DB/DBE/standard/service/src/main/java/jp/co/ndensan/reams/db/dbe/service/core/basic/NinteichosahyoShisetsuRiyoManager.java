/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5210NinteichosahyoShisetsuRiyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *  認定調査票（概況調査）施設利用を取得する
 *
 * @author n8429
 */
public class NinteichosahyoShisetsuRiyoManager {
    
      private final DbT5210NinteichosahyoShisetsuRiyoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoShisetsuRiyoManager() {
        dac = InstanceProvider.create(DbT5210NinteichosahyoShisetsuRiyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5210NinteichosahyoShisetsuRiyoDac}
     */
    NinteichosahyoShisetsuRiyoManager(DbT5210NinteichosahyoShisetsuRiyoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoShisetsuRiyoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoShisetsuRiyoManager}のインスタンス
     */
    public static NinteichosahyoShisetsuRiyoManager createInstance() {
        return InstanceProvider.create(NinteichosahyoShisetsuRiyoManager.class);
    }

    /**
     * 認定調査票（概況調査）施設利用{@link NinteiKeikakuJoho}を保存します。
     *
     * @param shinseishoKanriNo
     * @param 認定調査依頼履歴番号
     * @param 連番
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public DbT5210NinteichosahyoShisetsuRiyoEntity select施設利用(ShinseishoKanriNo shinseishoKanriNo, int 認定調査依頼履歴番号, int 連番) {
        return dac.selectByKey(shinseishoKanriNo, 認定調査依頼履歴番号, 連番);
    }

    /**
     * 認定調査票（概況調査）施設利用{@link NinteiKeikakuJoho}を保存します。
     *
     * @param 情報
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票(DbT5210NinteichosahyoShisetsuRiyoEntity 情報) {
        requireNonNull(情報, UrSystemErrorMessages.値がnull.getReplacedMessage("情報"));
        return 1 == dac.save(情報);
    }
    
}
