/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraijohokensuhyo;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBPR82001_2_特別徴収依頼情報件数表のEntity
 *
 * @reamsid_L DBB-1840-070 wangxingpeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TokubetsuChoshuIraiJohoKensuhyoEntity {

    private RString 年金保険者名称;
    private LasdecCode 構成市町村コード;
    private RString 市町村名称;
    private Code left特別徴収義務者コード;
    private int left件数;
    private RString left金額1;
    private RString left金額2;
    private Code right特別徴収義務者コード;
    private RString right年金保険者名称;
    private int right件数;
    private RString right金額1;
    private RString right金額2;

}
