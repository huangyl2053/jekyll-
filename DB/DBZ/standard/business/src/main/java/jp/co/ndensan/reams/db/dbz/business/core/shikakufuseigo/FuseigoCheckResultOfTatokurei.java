/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo;

import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu.FuseigoRiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakufuseigo.DaichoFuseigoJotai;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;

/**
 * 不整合チェック結果（他市町村住所地特例）のビジネスクラスです
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuseigoCheckResultOfTatokurei {

    private FuseigoRiyu 不整合理由;
    private IKojin 個人;
    private TashichosonJushochiTokurei 現在の他特の情報;
    private DaichoFuseigoJotai 他市町村住所地特例台帳状態;
    private TashichosonJushochiTokurei 修正後の他特の情報;
}
