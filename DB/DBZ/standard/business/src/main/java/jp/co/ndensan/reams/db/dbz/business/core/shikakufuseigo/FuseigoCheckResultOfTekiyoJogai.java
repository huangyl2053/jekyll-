/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo;

import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu.FuseigoRiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakufuseigo.DaichoFuseigoJotai;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;

/**
 * 不整合チェック結果（適用除外者）のビジネスクラスです
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuseigoCheckResultOfTekiyoJogai {

    private FuseigoRiyu 不整合理由;
    private IKojin 個人;
    private TekiyoJogaisha 現在の除外の情報;
    private DaichoFuseigoJotai 適用除外者台帳状態;
    private TekiyoJogaisha 修正後の除外の情報;
}
