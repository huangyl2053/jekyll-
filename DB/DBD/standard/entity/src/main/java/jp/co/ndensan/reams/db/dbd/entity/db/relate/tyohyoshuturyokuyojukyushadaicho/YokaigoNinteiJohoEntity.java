/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiJohoEntity {

    private SentoEntity 先頭Entity;
    private RString 認定区分;
    private RString 明細番号;
    private FlexibleDate 認定申請日;
    private FlexibleDate 認定日;
    private RString 申請事由;
    private RString 異動事由;
    private RString 要介護度;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private Decimal 訪問限度額;
    private FlexibleDate 訪問開始日;
    private FlexibleDate 訪問終了日;
    private Decimal 短期限度額;
    private FlexibleDate 短期開始日;
    private FlexibleDate 短期終了日;
    private FlexibleDate 調査依頼日;
    private FlexibleDate 調査予定日;
    private FlexibleDate 調査実施日;
    private FlexibleDate 医師依頼日;
    private FlexibleDate 医師予定日;
    private FlexibleDate 医師取寄日;
    private FlexibleDate 資料作成日;
    private FlexibleDate 審査予定日;
    private FlexibleDate 二次判定日;
    private RString 一次要介護度;
    private FlexibleDate 一次判定日;
    private RString 一次要介護度_重;
    private RString 旧措置;
    private FlexibleDate 喪失日;
    private RString 資格取得前申請;
    private FlexibleDate 延期通知書発行日;
    private RString 延期通知書発行回数;
    private FlexibleDate 資格証明書発行日１;
    private FlexibleDate 資格証明書発行日２;
    private RString 特定疾病;
    private RString 申請代行事業者;
    private RString 代行者コード;
    private RString 指定医区分;
    private RString 調査委託先コード;
    private RString 調査委託先名;
    private RString 調査員コード;
    private RString 調査員名;
    private RString 主治医医療機関コード;
    private RString 主治医医療機関名;
    private RString 主治医コード;
    private RString 主治医名;
    private RString 認定審査会意見;
    private RString 申請区分_申請時;
    private RString 申請区分_法令;

}
