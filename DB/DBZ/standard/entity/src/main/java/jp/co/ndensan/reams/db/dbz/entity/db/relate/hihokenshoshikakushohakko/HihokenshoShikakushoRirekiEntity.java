/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokenshoshikakushohakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証資格証履歴情報Entityです。
 *
 * @reamsid_L DBA-1090-021 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshoShikakushoRirekiEntity {

    private LasdecCode 市町村コード;
    private HihokenshaNo 被保険者番号;
    private RString 履歴番号;
    private RString 枝番;
    private Code 受給申請事由;
    private FlexibleDate 年月日;
    private RString 区分;
}
