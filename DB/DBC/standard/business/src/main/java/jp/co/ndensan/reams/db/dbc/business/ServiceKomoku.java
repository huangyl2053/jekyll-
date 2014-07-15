/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceKomokuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス項目を表すクラスです。
 *
 * @author n8223 朴 義一
 */
public class ServiceKomoku extends KaigoCodeAssignedItem<ServiceKomokuCode> {

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param サービス項目コード サービス項目コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public ServiceKomoku(Code サービス項目コード, RString 名称, RString 略称) {
        super(new ServiceKomokuCode(サービス項目コード), サービス項目コード, 名称, 略称);
    }

    /**
     * サービス項目を表すコードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getGogitaichoKubunCode() {
        return getExtendedCode();
    }
}
