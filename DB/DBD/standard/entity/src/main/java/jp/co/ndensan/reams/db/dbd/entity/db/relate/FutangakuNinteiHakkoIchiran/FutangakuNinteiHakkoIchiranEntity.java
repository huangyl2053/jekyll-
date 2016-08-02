/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.FutangakuNinteiHakkoIchiran;

import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定の帳票情報Entityです。
 *
 * @reamsid_L DBD-3981-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class FutangakuNinteiHakkoIchiranEntity {

    private HihokenshaNo 被保険者番号;
    private IKojin 個人情報;
    private FlexibleDate 申請日;
    private FlexibleDate 決定日;
    private FlexibleDate 適用日;
    private FlexibleDate 有効期限;
    private KetteiKubun 決定;
    private RString 負担段階;
    private boolean 通知書発行フラグ;
    private boolean 認定証発行済み;
    private boolean 通知書発行済み;
    private boolean 認定証発行フラグ;
    private RString 入所施設CD;
    private FlexibleDate 喪失年月日;
}
