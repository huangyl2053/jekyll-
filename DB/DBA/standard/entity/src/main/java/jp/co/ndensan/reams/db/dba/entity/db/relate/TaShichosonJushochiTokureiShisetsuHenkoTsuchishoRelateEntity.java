/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate;

import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護除外住所地特例対象施設情報&宛名データ情報クラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity {

    private FlexibleDate 入所年月日;
    private RString 事業者名称;
    private RString 電話番号;
    private RString FAX番号;
    private YubinNo 郵便番号;
    private RString 事業者住所;

    private RString カナ名称;
    private RString 名称;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private YubinNo 転入前郵便番号;
    private RString 転入前住所;
    private FlexibleDate 登録異動年月日;

}
