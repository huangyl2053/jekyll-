/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月処理区分のインタフェースです。
 *
 * @reamsid_L DBB-9020-080 sunhaidi
 */
public interface ITsukiShorkiKubun {

    /**
     * 仮算定期処理です。
     *
     * @return 判断結果
     */
    boolean is仮算定期();

    /**
     * 本算定期処理です。
     *
     * @return 判断結果
     */
    boolean is本算定期();

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    RString getName();

    /**
     * コードを返します。
     *
     * @return コード
     */
    RString get区分();
}
