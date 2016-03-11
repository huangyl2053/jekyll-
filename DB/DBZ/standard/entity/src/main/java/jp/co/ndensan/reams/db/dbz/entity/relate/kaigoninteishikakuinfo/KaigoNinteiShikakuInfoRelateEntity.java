/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.relate.kaigoninteishikakuinfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定資格情報RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KaigoNinteiShikakuInfoRelateEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 資格取得年月日;
    private RString 資格取得事由コード;
    private FlexibleDate 資格喪失年月日;
    private RString 資格喪失事由コード;
    private RString 住所地特例フラグ;
    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
//    private ShoKisaiHokenshaNo 保険者番号;
//    private RString 保険者名称;
}
