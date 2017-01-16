/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスの状況の連番を管理することを表します。
 */
public interface IGaikyoChosahyoServiceJokyo {

    /**
     * サービスの状況の単位1を返します。
     *
     * @return サービスの状況の単位1
     */
    RString get単位1();

    /**
     * サービスの状況の単位2を返します。
     *
     * @return サービスの状況の単位2
     */
    RString get単位2();

    /**
     * サービスの状況の帳票上の文言を返します。
     *
     * @return サービスの状況の帳票上の文言
     */
    RString get名称();

    /**
     * サービスの状況の給付区分を返します。
     *
     * @return サービスの状況の給付区分2
     */
    RString get給付区分();

    /**
     * サービスの状況の連番を返します。
     *
     * @return サービスの状況の連番
     */
    RString get連番();

    /**
     * サービスの状況の連番をint型で返します。
     *
     * @return 連番(int型)
     */
    int get連番AsInt();
}
