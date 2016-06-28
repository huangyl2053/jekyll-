/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo;

import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu.FuseigoRiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakufuseigo.DaichoFuseigoJotai;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;

/**
 * 不整合チェック結果のビジネスクラスです
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuseigoCheckResult {

    private FuseigoRiyu 不整合理由;
    private IKojin 個人;
    private HihokenshaDaicho 現在の資格の情報;
    private DaichoFuseigoJotai 被保険者台帳状態;
    private HihokenshaDaicho 修正後の資格の情報;

}
