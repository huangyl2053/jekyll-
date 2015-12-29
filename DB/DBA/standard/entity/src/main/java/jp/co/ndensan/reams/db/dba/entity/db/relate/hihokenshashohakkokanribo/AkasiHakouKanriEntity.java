/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 証発行管理リストEntityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AkasiHakouKanriEntity {

    private int 連番;
    private HihokenshaNo 被保険者番号;
    private RString 住民コード;
    private YubinNo 郵便番号;
    private RString 氏名;
    private RString 住所;
    private LasdecCode 市町村コードList;
    private FlexibleDate 交付年月日;
    private Code 交付事由コード;
    private RString 交付事由略称;
    private RString 交付事由名称;
    private FlexibleDate 回収年月日;
    private Code 回収事由コード;
    private RString 回収事由名称;
    private FlexibleDate 有効期限;
    private RString 証様式区分コード;
    private boolean 項目名付加フラグ;
    private boolean 日付編集フラグ;
}
