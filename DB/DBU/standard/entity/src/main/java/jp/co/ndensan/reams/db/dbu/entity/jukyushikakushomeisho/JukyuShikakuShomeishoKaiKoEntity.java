/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 受給資格証明書発行Entity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuShikakuShomeishoKaiKoEntity {

    HihokenshaNo 被保険者番号;
    RString 異動予定日;
    RString 認定審査会の意見等;
    RString 備考;
    RString 交付年月日;
    RDate 交付日;
    RString 申請日;
    RString 申請状況区分;
    RString 要介護状態区分;
    RString 有効期間の終了年月日;
    RString 有効期間の開始年月日;
    ShikibetsuCode 識別コード;
    boolean 住所を印字;

}
