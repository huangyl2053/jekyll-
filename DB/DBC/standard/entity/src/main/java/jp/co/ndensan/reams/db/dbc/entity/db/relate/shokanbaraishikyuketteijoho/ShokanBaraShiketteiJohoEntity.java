/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給決定情報Entityです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanBaraShiketteiJohoEntity implements Serializable {

    private RString 交換情報識別番号;
    private RString 帳票レコード種別_ヘッダ;
    private RString 証記載保険者番号;
    private RString 保険者名;
    private RString 作成年月日;
    private RString 国保連合会名;
    private RString 帳票レコード種別;
    private RString no;
    private RString 整理番号;
    private RString 被保険者番号;
    private RString 被保険者氏名_漢字;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 事業所名_漢字;
    private RString サービス種類コード;
    private RString サービス種類名;
    private RString 単位数_金額;
    private RString 支払金額;
    private RString 増減単位数;
    private RString 支払方法区分コード;
    private RString 備考;
}
