/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.db.dbb.definition.valueobject.FukaErrorCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課エラーを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaError extends KaigoCodeAssignedItem<FukaErrorCode> {

    /**
     * 引数から賦課エラーコード・名称・略称を渡し、インスタンスを生成します。
     *
     * @param code 賦課エラーコード
     * @param codeMeisho 名称
     * @param codeRyakusho 略称
     */
    public FukaError(Code code, RString codeMeisho, RString codeRyakusho) {
        super(new FukaErrorCode(code), code, codeMeisho, codeRyakusho);
    }

    /**
     * 賦課エラーコードを返します。
     *
     * @return 賦課エラーコード
     */
    public FukaErrorCode getFukaErrorCode() {
        return getExtendedCode();
    }

    @Override
    public String toString() {
        return getCode().toString().concat(":").concat(getMeisho().toString());
    }
}
