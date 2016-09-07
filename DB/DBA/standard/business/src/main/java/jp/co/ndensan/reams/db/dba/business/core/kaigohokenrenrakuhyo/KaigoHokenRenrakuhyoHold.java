/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo;

import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.view.JukyushaDaichoAlive;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護保険連絡票Entityクラスです。
 *
 * @reamsid_L DBA-1290-070 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenRenrakuhyoHold {

    private FlexibleDate 連絡票作成日;
    private KyufuGengakuKisai 給付減額などの記載;
    private KyojuhiFutanGendogakuKisai 居住費の負担限度額;
    private SyokuhiFutanGendogakuKisai 食費の_特定_負担限度額;
    private KogakuKaigoServiceHiKisai 高額介護サービス費支給による自己負担限度額;
    private KaigoHokenryoKisai 介護保険料;
    private RString 備考;
    private Code 旧措置者区分;
    private Code 利用者負担段階;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private Code 決定区分;
    private RString 非承認理由;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private int 履歴番号;
    private Code 旧措置者区分Code;
    private Code 申請理由区分;
    private Code 利用者負担段階Code;
    private Code 境界層該当者区分;
    private Code 激変緩和措置対象者区分;
    private Code 居室種別;
    private Decimal 食費負担限度額;
    private Decimal ユニット型個室;
    private Decimal ユニット型準個室;
    private Decimal 従来型個室_特養等;
    private Decimal 従来型個室_老健_療養など;
    private Decimal 多床室;
    private IKojin 個人;
    private JukyushaDaichoAlive 受給者台帳;
    private HihokenshaDaichoAlive 被保険者台帳;

}
