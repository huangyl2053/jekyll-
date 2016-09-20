/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuchiikiKasanGemmenEntity {

    private HihokenshaNo 特別地域加算_被保険者番号;
    private FlexibleDate 特別地域加算_申請年月日;
    private FlexibleDate 特別地域加算_決定年月日;
    private FlexibleDate 特別地域加算_適用開始年月日;
    private FlexibleDate 特別地域加算_適用終了年月日;
    private HokenKyufuRitsu 特別地域加算_減額率;
    private RString 特別地域加算_確認番号;
}
