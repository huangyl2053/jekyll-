/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohokanrilist;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更管理リストのパラメータクラスです。
 *
 * @reamsid_L DBD-3630-010 zhulx
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoKanriListData implements Serializable {

    private FlexibleDate 基準日;
    private RString 登録者選択;
    private RString 差止予告登録者の選択;
    private RString 差止登録者の選択;
    private RString 償還予告登録者の選択;
    private RString 償還決定登録者の選択;
    private RString 償還決定登録者1の選択;
    private RString 償還決定登録者2の選択;
    private Long 改頁出力順ID;
    private RString 帳票ID;
}
