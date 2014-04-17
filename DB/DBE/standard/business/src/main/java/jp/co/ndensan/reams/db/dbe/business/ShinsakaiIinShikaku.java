/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinShikakuCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 審査会委員資格を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinShikaku extends KaigoCodeAssignedItem<ShinsakaiIinShikakuCode> {

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param 審査会委員資格コード 審査会委員資格コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public ShinsakaiIinShikaku(Code 審査会委員資格コード, RString 名称, RString 略称) {
        super(new ShinsakaiIinShikakuCode(審査会委員資格コード), 審査会委員資格コード, 名称, 略称);
    }

    /**
     * 審査会委員資格を表すコードを返します。
     *
     * @return 審査会委員資格コード
     */
    public ShinsakaiIinShikakuCode getShinsakaiIinShikakuCode() {
        return getExtendedCode();
    }
}
