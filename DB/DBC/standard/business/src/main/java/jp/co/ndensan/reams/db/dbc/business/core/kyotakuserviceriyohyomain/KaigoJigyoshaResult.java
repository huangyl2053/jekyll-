/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業者の情報を取得のResult
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJigyoshaResult {

    private RString 計画事業者名;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
    private RString 管理者名;
    private RString 委託先事業者名;
}
