/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishuriyushosakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100044_住宅改修理由書作成手数料支給（不支給）決定通知書のEntityクラスです。
 *
 * @reamsid_L DBC-2850-040 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuKaishuRiyushoSakuseiEntity {

    private RString 文書番号;
    private RString 事業者コード;
    private RString 受付年月日;
    private RString 決定年月日;
    private RString 支給_不支給;
    private RString 支給金額;
    private RString 不支給の理由;
    private RString 支払方法;
    private RString 支払予定日;
    private RString 作成日;
}
