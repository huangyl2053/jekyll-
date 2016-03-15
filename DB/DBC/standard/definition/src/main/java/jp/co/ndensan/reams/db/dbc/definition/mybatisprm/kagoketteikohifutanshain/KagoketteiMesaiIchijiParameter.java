/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 一時テーブルに対するMapperパラメータ
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoketteiMesaiIchijiParameter {

    private RString 交換情報識別番号;
    private RString 帳票レコード種別ヘッダ部;
    private FlexibleYearMonth 取扱年月;
    private RString 公費負担者番号;
    private RString 公費負担者名;
    private FlexibleDate 作成年月日;
    private RString 頁;
    private RString 国保連合会名;
    private RString 帳票レコード種別明細部;
    private RString 事業所番号;
    private RString 事業所名;
    private RString 公費受給者番号;
    private RString 公費受給者氏名;
    private RString 証記載保険者番号;
    private RString 証記載保険者名;
    private RString 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString サービス種類コード;
    private RString サービス種類名;
    private RString 過誤申立事由コード;
    private RString 過誤申立事由;
    private Decimal 単位数;
    private Decimal 公費負担額;
}
