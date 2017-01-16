/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスの状況フラグの連番を管理するオブジェクトであることを表します。
 */
public interface IServiceJokyoFlag {

    /**
     * 連番を返します
     *
     * @return 連番
     */
    int get連番();

    /**
     * 名称を返します。
     *
     * @return 名称を返します。
     */
    RString get名称();
}
