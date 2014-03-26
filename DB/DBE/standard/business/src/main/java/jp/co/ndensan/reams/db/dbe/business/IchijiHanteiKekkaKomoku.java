/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.IchijiHanteiKekkaCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定の結果を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiKekkaKomoku extends KaigoCodeAssignedItem<IchijiHanteiKekkaCode> {

    /**
     * 引数に一次判定結果コードとそれに対応する名称を受け取り、インスタンスを生成します。
     *
     * @param 一次判定結果コード 一次判定結果コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public IchijiHanteiKekkaKomoku(Code 一次判定結果コード, RString 名称, RString 略称) {
        super(new IchijiHanteiKekkaCode(一次判定結果コード.value()), 一次判定結果コード, 名称, 略称, null, null, null);
    }

    /**
     * 一次判定結果コードを受け取ります。
     *
     * @return 一次判定結果コード
     */
    public IchijiHanteiKekkaCode get一次判定結果コード() {
        return getExtendedCode();
    }
}
