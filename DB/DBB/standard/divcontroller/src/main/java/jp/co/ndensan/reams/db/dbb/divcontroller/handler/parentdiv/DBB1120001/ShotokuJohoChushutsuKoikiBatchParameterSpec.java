/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiBatchParameterDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 所得情報抽出・連携（広域用）のHandlerクラスです。
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public enum ShotokuJohoChushutsuKoikiBatchParameterSpec implements IPredicate<ShotokuJohoChushutsuKoikiBatchParameterDiv> {

    /**
     * 共有ファイル化したCSVファイルのチェック
     */
    共有ファイル化したCSVファイルのチェック {
                @Override
                public boolean apply(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
                    return SpecHelper.is共有ファイル化したCSVファイルのチェック(div);
                }
            };

    private static class SpecHelper {

        public static boolean is共有ファイル化したCSVファイルのチェック(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
            return false;
        }
    }
}
