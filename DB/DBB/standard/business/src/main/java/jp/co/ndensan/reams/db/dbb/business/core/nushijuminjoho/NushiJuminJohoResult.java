/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBBGM51002_所得照会票作成
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NushiJuminJohoResult {

    private FlexibleYear 住民税課税年度;
    private RDate 発行日;
    private RString 市町村名;
    private YubinNo 郵便番号;
    private RString 住所_上段;
    private RString 住所_下段;
    private RString 役所_役場名_上段;
    private RString 役所_役場名_下段;
    private FlexibleDate 生年月日;
    private RString 転入前住所;
    private RString 転出先住所;
    private RString 氏名;
    private SetaiCode 世帯コード;
    private RString 前住所;
    private RString 現住所;
    private RString 住民状態コード;
    private RString 住民種別コード;
    private List<SetaiInn> 世帯員リスト;
    private RString 担当部署名;
    private RString 担当者名;
    private RString 庁舎名;
    private RString 所在地;
    private RString 内線番号;
    private YubinNo 差出人_郵便番号;
    private TelNo 電話番号;

}
