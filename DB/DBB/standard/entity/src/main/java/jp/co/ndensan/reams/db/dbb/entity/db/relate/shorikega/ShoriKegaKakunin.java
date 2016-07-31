/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shorikega;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理結果確認entity ShoriKega
 *
 * @reamsid_L DBB-1690-070 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriKegaKakunin {

    private FlexibleYear 賦課年度;
    private RString 住民コード;
    private LasdecCode 市町村コード;
    private RString 非課税区分;
    private RString エラー内容;
}
