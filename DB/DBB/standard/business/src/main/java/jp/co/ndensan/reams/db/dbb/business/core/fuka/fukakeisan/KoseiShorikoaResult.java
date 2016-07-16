/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan;

import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;

/**
 * 更正処理コア情報のクラスです。
 *
 * @reamsid_L DBB-0660-030 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiShorikoaResult {

    private NendobunFukaList 年度分賦課リスト_更正後;
    private ChoshuHoho 徴収方法の情報_更正後;
    private HihokenshaDaicho 資格の情報;
}
