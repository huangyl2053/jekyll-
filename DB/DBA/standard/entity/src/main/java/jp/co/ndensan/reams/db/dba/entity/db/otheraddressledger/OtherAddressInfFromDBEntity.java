/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者情報(DB)のエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OtherAddressInfFromDBEntity {

    private ShikibetsuCode 識別コード;
    private FlexibleDate 異動日;
    private RString 枝番;
    private LasdecCode 市町村コード;
    private RString 他市町村住所地特例適用事由コード;
    private FlexibleDate 適用年月日;
    private FlexibleDate 適用届出年月日;
    private RString 他市町村住所地特例解除事由コード;
    private FlexibleDate 解除年月日;
    private FlexibleDate 解除届出年月日;
    private ShoKisaiHokenshaNo 措置保険者番号;
    private HihokenshaNo 措置被保険者番号;
    private RString 保険者名称;
    private RString 台帳種別;
    private JigyoshaNo 入所施設コード;
    private RString 入所施設種類;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
    private RString 事業者種別;
    private RString 事業者番号;
    private AtenaMeisho 事業者名称;
    private RString 事業者住所;
    private YubinNo 郵便番号;
    private TelNo 電話番号;

}
