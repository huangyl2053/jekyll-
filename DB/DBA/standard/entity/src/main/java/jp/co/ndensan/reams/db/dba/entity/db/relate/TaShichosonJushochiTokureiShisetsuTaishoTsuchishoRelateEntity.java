/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 他住特施設退所通知書 RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity {

    private FlexibleDate 退所年月日;
    private RString 他市町村住所地特例解除事由コード;
    private RString 事業者名称;
    private RString 電話番号;
    private RString FAX番号;
    private RString 郵便番号;
    private RString 事業者住所;

    private RString 住民状態コード;
    private RString 転出確定郵便番号;
    private RString 転出予定郵便番号;
    private RString 転出確定住所;
    private RString 転出予定住所;
    private RString カナ名称;
    private RString 名称;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private RString 住所;
}
