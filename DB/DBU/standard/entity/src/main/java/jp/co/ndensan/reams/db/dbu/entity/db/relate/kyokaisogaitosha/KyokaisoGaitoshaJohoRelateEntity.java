/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 境界層該当者一覧情報のエンティティクラスです。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyokaisoGaitoshaJohoRelateEntity {

    private HihokenshaNo 被保険者番号;
    private Decimal リンク番号;
    private FlexibleDate 申請年月日;
    private FlexibleDate 受付年月日;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private RString 措置該当_非該当区分;
    private FlexibleDate 境界層措置決定年月日;
    private RString 給付額減額記載解除フラグ;
    private RString 標準負担額額該当フラグ;
    private Decimal 標準負担軽減後負担額;
    private RString 居住費等負担額減額該当フラグ;
    private RString 居住費軽減後居室種類コード;
    private Decimal 居住費軽減後負担額;
    private RString 食費負担額減額該当フラグ;
    private Decimal 食費軽減後負担額;
    private RString 高額ｻｰﾋﾞｽ費上限額減額該当フラグ;
    private Decimal 高額費減額後上限額;
    private RString 保険料納付減額フラグ;
    private RString 申請_廃止区分;
    private FlexibleDate 申請_廃止年月日;
    private Decimal 保護不要根拠減額金額;
    private FlexibleDate 境界層証明書交付年月日;
    private Decimal 給付額減額取消_減額自己負担月額;
    private Decimal 居住費軽減_減額自己負担月額;
    private RString 居住費軽減_負担限度額段階コード;
    private Decimal 食費軽減_減額自己負担月額;
    private RString 食費軽減_負担限度額段階コード;
    private Decimal 利用者負担世帯合算額_減額自己負担月額;
    private Decimal 保険料減額_減額自己負担月額;
    private Decimal 減額自己負担月額合計額;
    private RString 保険料納付減額後保険料段階;
}
