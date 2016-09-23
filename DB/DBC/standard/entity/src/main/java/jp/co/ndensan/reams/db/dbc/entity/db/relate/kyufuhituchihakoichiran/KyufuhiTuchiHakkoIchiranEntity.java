/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200044_給付費通知発行一覧表のEntityクラスです。
 *
 * @reamsid_L DBC-2280-080 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiTuchiHakkoIchiranEntity {

    private RString 発行日時;
    private RString ページ数;
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
    private RString 帳票連番;
    private RString 被保険者番号;
    private RString 証記載保険者;
    private RString 年月;
    private RString サービス事業者コード;
    private RString サービス事業者;
    private RString サービス種類コード;
    private RString サービス項目コード;
    private RString サービス名称;
    private RString 日数_回数;
    private RString 利用者負担額_円;
    private RString サービス費用_円;
    private RString 要介護度;
    private RString 資格喪失日;
    private RString 喪失事由;
    private RString 補正有無;
    private RString 被保険者氏名;

}
