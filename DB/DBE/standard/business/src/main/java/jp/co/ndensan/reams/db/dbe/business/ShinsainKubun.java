/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsainKubunCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 審査員区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsainKubun extends KaigoCodeAssignedItem<ShinsainKubunCode> {

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param 区分コード 区分コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public ShinsainKubun(Code 区分コード, RString 名称, RString 略称) {
        super(new ShinsainKubunCode(区分コード), 区分コード, 名称, 略称);
    }

    /**
     * 審査員区分を表すコードを返します。
     *
     * @return 審査員区分コード
     */
    public ShinsainKubunCode getShinsainKubunCode() {
        return getExtendedCode();
    }
}
