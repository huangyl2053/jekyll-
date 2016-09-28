/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.servicetype;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * サービス種類一覧のコントローラです。
 *
 * @reamsid_L DBA-0070-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceTypeModel implements Serializable {

    private RString サービス種類コード;
    private FlexibleYearMonth 基準年月;
    private List<RString> サービス種類リスト;
    private List<RString> サービス分類リスト;
    private RString 抽出パターン;

}
