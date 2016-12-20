/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikeikakujoho.NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5202NinteichosahyoGaikyoChosa09BDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5202NinteichosahyoGaikyoChosa09BEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（概況調査）09B情報を取得します。
 *
 * @author n8429
 */
public class NinteichosahyoGaikyoChosa09BManager {

    private final DbT5202NinteichosahyoGaikyoChosa09BDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoGaikyoChosa09BManager() {
        dac = InstanceProvider.create(DbT5202NinteichosahyoGaikyoChosa09BDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5105NinteiKanryoJohoDac}
     */
    NinteichosahyoGaikyoChosa09BManager(DbT5202NinteichosahyoGaikyoChosa09BDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoGaikyoChosa09BManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoGaikyoChosa09BManager}のインスタンス
     */
    public static NinteichosahyoGaikyoChosa09BManager createInstance() {
        return InstanceProvider.create(NinteichosahyoGaikyoChosa09BManager.class);
    }

    /**
     * 認定調査票（概況調査）{@link NinteiKeikakuJoho}を保存します。
     *
     * @param shinseishoKanriNo
     * @param 認定調査依頼履歴番号
     * @param image
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public DbT5202NinteichosahyoGaikyoChosa09BEntity select認定調査票(ShinseishoKanriNo shinseishoKanriNo, int 認定調査依頼履歴番号, RString image) {
        return dac.selectByKey(shinseishoKanriNo, 認定調査依頼履歴番号, image);
    }

    /**
     * 認定調査票（概況調査）{@link NinteiKeikakuJoho}を保存します。
     *
     * @param 情報
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票(DbT5202NinteichosahyoGaikyoChosa09BEntity 情報) {
        requireNonNull(情報, UrSystemErrorMessages.値がnull.getReplacedMessage("情報"));

        return 1 == dac.save(情報);
    }
}
