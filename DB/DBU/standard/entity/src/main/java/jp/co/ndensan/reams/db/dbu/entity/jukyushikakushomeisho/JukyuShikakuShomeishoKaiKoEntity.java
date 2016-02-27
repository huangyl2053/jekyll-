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

    private HihokenshaNo 被保険者番号;
    private RString 異動予定日;
    private RString 認定審査会の意見等;
    private RString 備考;
    private RString 交付年月日;
    private RDate 交付日;
    private RString 申請日;
    private RString 申請状況区分;
    private RString 要介護状態区分;
    private RString 有効期間の終了年月日;
    private RString 有効期間の開始年月日;
    private ShikibetsuCode 識別コード;
    private boolean 住所を印字;

}
