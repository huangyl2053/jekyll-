/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.kyufugakugengakukanrilist;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付額減額管理リストを表す列挙型です。
 *
 * @reamsid_L DBD-3800-010 b_zhengs
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufugakuGengakuKanriListData implements Serializable {

    private RDate 基準日;
    private RString 対象区分;
    private boolean 通知書未発行者抽出;
    private boolean 減額適用中者抽出;
    private RDate 減額適用中者抽出基準日;
    private boolean 減額終了日抽出;
    private RDate 減額終了日範囲From;
    private RDate 減額終了日範囲To;
    private boolean 保険料完納者出力;
    private RString 改頁出力順ID;
    private RString 帳票ID;

}
