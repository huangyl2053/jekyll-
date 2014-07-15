/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.InputShikibetsuNoCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入力識別番号
 * 
 * @author n8223
 */
public class InputShikibetsuNo extends KaigoCodeAssignedItem<InputShikibetsuNoCode> {

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param 入力識別番号 入力識別番号
     * @param 名称 名称
     * @param 略称 略称
     */
    public InputShikibetsuNo(Code 入力識別番号, RString 名称, RString 略称) {
        super(new InputShikibetsuNoCode(入力識別番号), 入力識別番号, 名称, 略称);
    }

    /**
     * 合議体長区分を表すコードを返します。
     *
     * @return 合議体長区分コード
     */
    public InputShikibetsuNoCode getInputShikibetsuNoCode() {
        return getExtendedCode();
    }
}
