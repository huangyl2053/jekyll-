/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績基本情報子Divのbusinessクラスです。
 *
 * @reamsid_L DBC-2970-010 wangjie2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiHeaderAll implements Serializable {

    private RString 被保険者番号;
    private RString 住民種別;
    private RString 要介護度;
    private RDate 有効期間開始年月日;
    private RDate 有効期間終了年月日;
    private RString 氏名;
    private RString 性別;
    private RDate 生年月日;
    private RDate 提供年月;
    private RString 実績区分;
    private RString 作成区分;
    private RString 整理番号;
    private RString 証記載保険者番号;
    private RString 様式番号;
    private RString 様式番号_Name;
    private RString 事業者;
    private RString 事業者_Name;

}
