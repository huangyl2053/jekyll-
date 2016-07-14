/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.sokujikosei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoFuka;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;

/**
 * 即時賦課更正処理情報のクラスです。
 *
 * @reamsid_L DBB-0660-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokujiFukaKoseiResult {

    private List<KoseiZengoFuka> 更正前後賦課のリスト;
    private KoseiZengoChoshuHoho 更正前後徴収方法;
    private List<HihokenshaDaicho> 資格の情報;
    private boolean 本算定処理済フラグ;
}
