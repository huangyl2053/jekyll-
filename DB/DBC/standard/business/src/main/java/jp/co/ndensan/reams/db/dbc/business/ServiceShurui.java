/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス種類を表すクラスです。
 *
 * @author n8223 朴 義一
 */
public class ServiceShurui extends KaigoCodeAssignedItem<ServiceShuruiCode> {

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public ServiceShurui(Code サービス種類コード, RString 名称, RString 略称) {
        super(new ServiceShuruiCode(サービス種類コード), サービス種類コード, 名称, 略称);
    }

    /**
     * サービス種類を表すコードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return getExtendedCode();
    }
}
