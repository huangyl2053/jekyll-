/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関&主治医入力のビジネスクラスです
 *
 * @reamsid_L DBZ-1300-140 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIryokikanandshujiiDataPassModel implements Serializable {

    private RString 主治医医療機関名称;
    private RString 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 主治医コード;
    private RString 市町村コード;
    private RString サブ業務コード;
    private RString 対象モード;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;

}
