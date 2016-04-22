/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証帳票Entity作成クラスです。
 *
 * @reamsid_L DBU-0490-021 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiteiServiceParameter {

    private RString 指定サービス種類;
    private RString サービス種類限度額;
}
