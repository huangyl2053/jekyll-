/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 集計一時テーブルに対するテーブルのエンティティ
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoketteiShukeiIchijiEntity implements Serializable {

    private RString 交換情報識別番号;
    private RString 帳票レコード種別ヘッダ部;
    private FlexibleYearMonth 取扱年月;
    private RString 公費負担者番号;
    private RString 公費負担者名;
    private FlexibleDate 作成年月日;
    private RString 頁;
    private RString 国保連合会名;
    private RString 帳票レコード種別集計部;
    private int 介護給付費の件数;
    private Decimal 介護給付費の単位数;
    private Decimal 介護給付費の公費負担額;
    private int 高額介護サービス費の件数;
    private Decimal 高額介護サービス費の単位数;
    private Decimal 高額介護サービス費の公費負担額;
    private int 特定入所者介護サービス費等の件数;
    private Decimal 特定入所者介護サービス費等の単位数;
    private Decimal 特定入所者介護サービス費等の公費負担額;
}
