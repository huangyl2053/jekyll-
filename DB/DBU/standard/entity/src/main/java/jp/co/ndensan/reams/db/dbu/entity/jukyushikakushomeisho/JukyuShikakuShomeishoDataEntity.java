/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 受給資格証明書の帳票出力用データEntity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuShikakuShomeishoDataEntity {

    HihokenshaNo 被保険者番号;
    AtenaKanaMeisho 被保険者フリガナ;
    AtenaMeisho 被保険者氏名;
    RString 被保険者生年月日;
    RString 被保険者性別;
    RString 被保険者住所_転出先予定;
    RString 被保険者異動予定日;
    RString 保険者番号;
    RString 日付;
    RString 役職名;
    RString 認職者氏名;
    RString 電子公印_イメージファイル;
    RString 公印省略;
    RString 市町村名;
    RString 申請状況;
    RString 申請年月日;
    RString 要介護状態区分;
    RString 認定年月日;
    RString 認定の有効期間の開始年月日;
    RString 認定の有効期間の終了年月日;
    RString 認定審査会の意見等;
    RString 備考;
    RString 連番;
    RString 交付年月日;

}
