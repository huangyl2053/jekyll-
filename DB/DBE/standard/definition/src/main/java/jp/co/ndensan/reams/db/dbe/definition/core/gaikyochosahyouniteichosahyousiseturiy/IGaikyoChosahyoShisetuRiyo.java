/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 概況調査票 施設利用の連番を管理することを表します。
 */
public interface IGaikyoChosahyoShisetuRiyo {

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    RString get名称();

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    RString get連番();

    /**
     * 連番をint型で返します。
     *
     * @return 連番(int型)
     */
    int get連番AsInt();
}
