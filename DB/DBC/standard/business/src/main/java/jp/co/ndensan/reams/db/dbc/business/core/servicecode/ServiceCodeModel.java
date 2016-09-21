/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.servicecode;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * サービスコード入力ガイドのダイアログパラメータクラスです。
 *
 * @reamsid_L DBA-0060-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceCodeModel implements Serializable {

    private RString サービス種類コード;
    private RString サービス項目コード;
    private RString サービス種類名称;
    private FlexibleYearMonth 基準年月;
    private List<RString> サービス種類リスト;
    private List<RString> サービス分類リスト;
    private RString 抽出パターン;
}
