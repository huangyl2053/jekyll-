/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月処理区分のインタフェースです。
 */
public interface ITsukiShorkiKubun {

    boolean is仮算定期();

    boolean is本算定期();

    RString getName();
}
