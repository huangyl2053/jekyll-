/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者情報のエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OtherAddressInfEntity {

    private RString NO;
    private FlexibleDate 適用年月日;
    private FlexibleDate 適用届出年月日;
    private KaigoTatokuTekiyoJiyu 適用事由コード;
    private RString 適用事由名称;
    private FlexibleDate 解除年月日;
    private FlexibleDate 解除届出年月日;
    private KaigoTatokuTekiyoJiyu 解除事由コード;
    private RString 解除事由名称;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
    private AtenaMeisho 事業者名称;
    private RString 事業者住所;
    private TelNo 電話番号;
    private YubinNo 郵便番号;
    private RString 保険者名称;
    private HihokenshaNo 他被保番号;
    private LasdecCode 市町村コード;

}
