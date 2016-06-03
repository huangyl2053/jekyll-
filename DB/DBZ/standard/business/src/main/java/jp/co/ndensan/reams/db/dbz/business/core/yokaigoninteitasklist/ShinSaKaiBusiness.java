/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;

/**
 * タスク一覧共有画面を管理するクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinSaKaiBusiness {

    private List<NinteiKanryoJoho> 要介護認定完了情報Lsit;
}
