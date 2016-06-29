/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成実績集計表の帳票のパラメータクラスです。
 *
 * @reamsid_L DBE-1690-040 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoJissekiIchiranEntity {

    private RString 保険者番号;
    private RString 医療機関コード;
    private RString 医療機関名称;
    private RString 主治医氏名;
    private RString 被保険者番号;
    private RString 申請者氏名;
    private RString 記入日;
    private RString 入手日;
    private RString 入手パターン_在新;
    private RString 入手パターン_在継;
    private RString 入手パターン_施新;
    private RString 入手パターン_施継;
    private RString 医師区分;

}
