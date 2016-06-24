/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha;

import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * NinteiShinseiTodokedesha のクラスファ。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiTodokedeshaNaiyo {

    private RString 届出代行区分;
    private RString 事業者コード;
    private RString 事業者名称;
    private RString 申請関係者;
    private RString 氏名;
    private RString カナ氏名;
    private RString 本人との関係性;
    private YubinNo 郵便番号;
    private RString 全国住所コード;
    private RString 管内管外区分;
    private RString 全国住所名称;
    private RString 全国郵便番号;
    private RString 町域入力住所コード;
    private RString 町域入力住所名称;
    private RString 電話番号;
}
