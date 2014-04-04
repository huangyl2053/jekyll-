/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaichoKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 合議体長区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaichoKubun extends KaigoCodeAssignedItem<GogitaichoKubunCode> {

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param 区分コード 区分コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public GogitaichoKubun(Code 区分コード, RString 名称, RString 略称) {
        super(new GogitaichoKubunCode(区分コード), 区分コード, 名称, 略称);
    }

    /**
     * 合議体長区分を表すコードを返します。
     *
     * @return 合議体長区分コード
     */
    public GogitaichoKubunCode getGogitaichoKubunCode() {
        return getExtendedCode();
    }
}
