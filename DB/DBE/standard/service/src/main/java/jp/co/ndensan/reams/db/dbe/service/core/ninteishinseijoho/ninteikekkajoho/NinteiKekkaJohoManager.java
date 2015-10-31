/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ninteikekkajoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定結果情報を管理するクラスです。
 */
public class NinteiKekkaJohoManager {

    private final DbT5102NinteiKekkaJohoDac 要介護認定結果情報Dac;

    /**
     * コンストラクタです。
     */
    public NinteiKekkaJohoManager() {
        this.要介護認定結果情報Dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5102NinteiKekkaJohoDac}
     */
    NinteiKekkaJohoManager(DbT5102NinteiKekkaJohoDac 要介護認定結果情報Dac) {
        this.要介護認定結果情報Dac = 要介護認定結果情報Dac;
    }

    /**
     * 要介護認定結果情報{@link NinteiKekkaJoho}を保存します。
     *
     * @param 要介護認定結果情報 要介護認定結果情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save要介護認定結果情報(NinteiKekkaJoho 要介護認定結果情報) {
        requireNonNull(要介護認定結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報"));
        if (!要介護認定結果情報.hasChanged()) {
            return false;
        }
        要介護認定結果情報 = 要介護認定結果情報.modifiedModel();
        return 1 == 要介護認定結果情報Dac.save(要介護認定結果情報.toEntity());
    }

}
