/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付管理票照会画面のコレクションクラスです。
 *
 * @reamsid_L DBC-2960-010 chenxiangyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiGaitoshaCollect implements Serializable {

    private RString 支給限度額一本化年月;
    private RString 被保険者番号;
    private RString 被保険者名称;
    private RString 事業所番号;
    private RString 事業者名称;
    private RString 保険者番号;
    private RString 給付対象年月開始;
    private RString 給付対象年月終了;
    private RString 給付管理票一覧序列;

}
