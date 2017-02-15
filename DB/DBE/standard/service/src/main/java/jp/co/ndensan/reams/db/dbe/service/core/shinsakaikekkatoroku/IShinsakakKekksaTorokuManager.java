/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku;

import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;

/**
 *
 */
public interface IShinsakakKekksaTorokuManager {

    /**
     * 介護認定審査会割当情報を更新です。
     *
     * @param shinsakaiWariateJoho 介護認定審査会割当情報
     * @return 更新件数
     */
    int save介護認定審査会割当情報(ShinsakaiWariateJoho shinsakaiWariateJoho);

    /**
     * 要介護認定結果情報への変更を保存します。
     *
     * @param ninteiKekka 認定結果
     * @return 更新件数
     */
    int save要介護認定結果情報(NinteiKekkaJoho ninteiKekka);

    /**
     * 要介護認定申請情報を更新です。
     *
     * @param ninteiShinsei 要介護認定申請情報
     * @return 更新件数
     */
    int save要介護認定申請情報(NinteiShinseiJoho ninteiShinsei);

    /**
     * 要介護認定完了情報を更新です。
     *
     * @param ninteiKanryo 要介護認定完了情報
     * @return 更新件数
     */
    int save要介護認定完了情報(NinteiKanryoJoho ninteiKanryo);
}
