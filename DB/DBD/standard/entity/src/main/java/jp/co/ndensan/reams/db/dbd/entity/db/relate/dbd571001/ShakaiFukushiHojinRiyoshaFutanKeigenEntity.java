/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
public class ShakaiFukushiHojinRiyoshaFutanKeigenEntity {

    private HihokenshaNo 社福法人軽減_被保険者番号;
    private FlexibleDate 社福法人軽減_申請年月日;
    private FlexibleDate 社福法人軽減_決定年月日;
    private FlexibleDate 社福法人軽減_適用開始年月日;
    private FlexibleDate 社福法人軽減_適用終了年月日;
    private RString 社福法人軽減_確認番号;
    private Decimal 社福法人軽減_軽減率_分子;
    private Decimal 社福法人軽減_軽減率_分母;
    private boolean 社福法人軽減_居宅サービス限定;
    private boolean 社福法人軽減_居住費食費のみ;
    private boolean 社福法人軽減_旧措置者ユニット型個室のみ;
}
