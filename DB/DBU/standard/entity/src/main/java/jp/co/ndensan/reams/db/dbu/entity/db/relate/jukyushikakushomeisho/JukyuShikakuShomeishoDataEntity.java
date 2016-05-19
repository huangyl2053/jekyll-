/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給資格証明書の帳票出力用データEntity
 *
 * @reamsid_L DBU-0490-050 wangchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuShikakuShomeishoDataEntity {

    private HihokenshaNo 被保険者番号;
    private AtenaKanaMeisho 被保険者フリガナ;
    private AtenaMeisho 被保険者氏名;
    private RString 年号_明治;
    private RString 年号_大正;
    private RString 年号_昭和;
    private RString 被保険者生年月日;
    private RString 被保険者性別;
    private RString 被保険者住所_転出前;
    private RString 被保険者住所_転出先予定;
    private RString 被保険者異動予定日;
    private RString 保険者番号;
    private RString 発行日;
    private RString 申請状況;
    private RString 申請年月日;
    private RString 要介護状態区分;
    private RString 認定年月日;
    private RString 認定の有効期間の開始年月日;
    private RString 認定の有効期間の終了年月日;
    private RString 認定審査会の意見等;
    private RString 備考;
    private RString 負担割合;
    private RString 負担割該当;
    private RString 連番;

}
