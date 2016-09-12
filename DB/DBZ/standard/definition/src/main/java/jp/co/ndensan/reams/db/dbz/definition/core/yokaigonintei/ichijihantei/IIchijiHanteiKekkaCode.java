/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定一次判定結果コードであることを表します。
 */
public interface IIchijiHanteiKekkaCode {

    /**
     * コードを返します。
     *
     * @return コード
     */
    RString getコード();

    /**
     * 名称を返します
     *
     * @return 名称
     */
    RString get名称();

    /**
     * 略称を返します。
     *
     * @return 略称
     */
    RString get略称();
}
