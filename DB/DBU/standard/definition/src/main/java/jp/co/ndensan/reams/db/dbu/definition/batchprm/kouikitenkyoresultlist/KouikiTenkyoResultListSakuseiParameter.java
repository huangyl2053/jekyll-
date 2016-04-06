/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.kouikitenkyoresultlist;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域内転居結果一覧表パラメータ
 *
 * @reamsid_L DBU-1150-040 xupeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KouikiTenkyoResultListSakuseiParameter {

    private RString shichosonshitei;
    private FlexibleDate kaishihi;
    private FlexibleDate shohi;
}
