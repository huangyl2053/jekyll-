/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.IchijiHanteiKeikokuCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定警告を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiKeikoku extends KaigoCodeAssignedItem<IchijiHanteiKeikokuCode> {

    /**
     * 一次判定警告コードとその名称、略称を引数に渡し、インスタンスを生成します。
     *
     * @param code 一次判定警告コード
     * @param codeMeisho 警告内容
     * @param codeRyakusho 警告内容(略)
     */
    public IchijiHanteiKeikoku(Code code, RString codeMeisho, RString codeRyakusho) {
        super(new IchijiHanteiKeikokuCode(code.value()), code, codeMeisho, codeRyakusho, null, null, null);
    }

    /**
     * IchijiHanteiKeikokuCodeを返します。
     *
     * @return IchijiHanteiKeikokuCode
     */
    public IchijiHanteiKeikokuCode get一次判定警告コード() {
        return getExtendedCode();
    }
}
