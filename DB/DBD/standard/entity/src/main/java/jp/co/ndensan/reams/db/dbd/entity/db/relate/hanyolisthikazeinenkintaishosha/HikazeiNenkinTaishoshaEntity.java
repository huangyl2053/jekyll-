/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolisthikazeinenkintaishosha;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 汎用リスト出力(非課税年金対象者)のRelateEntityクラスです。
 *
 * @reamsid_L DBD-5820-030 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeiNenkinTaishoshaEntity {

    private RString 市町村コード;
    private RString 被保険者番号;
    private RString 年度;
    private RString 処理区分;
    private RString 対象月;
    private RString 基礎年金番号;
    private RString 現基礎年金番号;
    private RString 年金コード;
    private RString if市町村コード;
    private RString if年金保険者コード;
    private RString if通知内容コード;
    private RString if作成年月日;
    private RString if性別;
    private RString ifカナ氏名;
    private RString if漢字氏名;
    private YubinNo if郵便番号;
    private RString ifカナ住所;
    private RString if漢字住所;
    private RString if対象年;
    private RString if訂正表示;
    private RString if各種区分;
    private RString if処理結果;
    private RString if金額１;
    private RString 登録区分;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private UaFt250FindAtesakiEntity atesakiEntity;
}
