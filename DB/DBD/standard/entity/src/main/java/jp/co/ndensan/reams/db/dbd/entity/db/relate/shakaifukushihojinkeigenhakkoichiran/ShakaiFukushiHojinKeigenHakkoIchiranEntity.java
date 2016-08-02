/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shakaifukushihojinkeigenhakkoichiran;

import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shakaifukushihojinkeigen.GemmenKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表Entityです。
 *
 * @reamsid_L DBD-3981-070 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class ShakaiFukushiHojinKeigenHakkoIchiranEntity {

    private RString 確認番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 申請日;
    private FlexibleDate 決定日;
    private FlexibleDate 適用日;
    private FlexibleDate 有効期限;
    private KetteiKubun 決定;
    private GemmenKubun 軽減;
    private RString 軽減率_分子;
    private RString 軽減率_分母;
    private boolean 居宅サービス限定;
    private boolean 居住費食費のみ;
    private boolean 旧措置者ユニット型個室のみ;
    private boolean 通知書発行フラグ;
    private boolean 認定証発行済み;
    private boolean 通知書発行済み;
    private boolean 認定証発行フラグ;
    private FlexibleDate 喪失年月日;
}
