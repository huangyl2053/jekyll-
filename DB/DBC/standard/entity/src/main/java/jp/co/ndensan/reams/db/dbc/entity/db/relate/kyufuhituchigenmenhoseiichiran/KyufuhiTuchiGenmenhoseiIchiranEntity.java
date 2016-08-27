/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchigenmenhoseiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付費通知減免補正一覧表パラメータクラスです。
 *
 * @reamsid_L DBC-2270-040 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiTuchiGenmenhoseiIchiranEntity {

    private RString 保険者コード;
    private RString 保険者名;
    private RString 出力順1;
    private RString 出力順2;
    private RString 出力順3;
    private RString 出力順4;
    private RString 出力順5;
    private RString 改ページ条件1;
    private RString 改ページ条件2;
    private RString 改ページ条件3;
    private RString 改ページ条件4;
    private RString 改ページ条件5;
    private RString 被保険者番号;
    private RString 被保険者名;
    private RString 年月;
    private RString サービス事業者コード;
    private RString サービス事業者;
    private RString サービス種類コード;
    private RString サービス種類;
    private RString 利用者負担額;
    private RString サービス費用;
}
