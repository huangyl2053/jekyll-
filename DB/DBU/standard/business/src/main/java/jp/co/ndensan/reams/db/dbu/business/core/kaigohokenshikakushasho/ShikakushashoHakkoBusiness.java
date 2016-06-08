/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.KyufuseigenBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.NyushoShisetsuBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.ShuruiShikyuGendoKizyunngakuBusiness;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格者証発行のビジネスです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakushashoHakkoBusiness {

    private RString 保険者番号;
    private RString 保険者名称;
    private RString 有効期限;
    private RString 被保番号;
    private RString 交付日;
    private RString 介護状態;
    private RString 認定日;
    private RString 有効期間の開始日付;
    private RString 有効期間の終了日付;
    private RString 区分支給限度額の有効開始日付;
    private RString 区分支給限度額の有効終了日付;
    private RString 区分支給限度額の基準額;
    private List<ShuruiShikyuGendoKizyunngakuBusiness> うち種類支給限度基準額の情報;
    private RString 種類の指定;
    private List<KyufuseigenBusiness> 給付制限の情報;
    private List<NyushoShisetsuBusiness> 介護保険施設等の情報;
    private List<ShienJigyoshaBusiness> 支援事業者の情報;
    private RString 識別コード;
}
