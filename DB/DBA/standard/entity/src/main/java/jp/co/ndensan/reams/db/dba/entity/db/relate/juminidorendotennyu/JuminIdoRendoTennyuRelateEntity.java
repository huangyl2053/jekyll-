/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績一覧表 のEntityクラスです。
 *
 * @reamsid_L DBC-3070-030 dangjingjing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKyufujissekiIchiranRelateEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = -8488005220642642798L;

    private RString inputShikibetsuNo;
    private RString 証記載保険者番号;
    private RString hiHokenshaNo;
    private RString serviceTeikyoYM;
    private RString jigyoshoNo;
    private RString kyufuJissekiKubunCode;
    private RString 公費1_負担者番号;
    private RString 公費1_受給者番号;
    private RString 公費2_負担者番号;
    private RString 公費2_受給者番号;
    private RString 公費3_負担者番号;
    private RString 公費3_受給者番号;
    private RString yoKaigoJotaiKubunCode;
    private RString 後_保険_サービス単位数;
    private RString 後_保険_請求額;
    private RString 後_保険_利用者負担額;
    private RString 後_緊急時施設療養費請求額;
    private RString 後_保険_特定診療費請求額;
    private RString 後_保険_特定入所者介護サービス費等請求額;
    private RString 後_公費1_サービス単位数;
    private RString 後_公費1_請求額;
    private RString 後_公費1_本人負担額;
    private RString 後_公費1_緊急時施設療養費請求額;
    private RString 後_公費1_特定診療費請求額;
    private RString 後_公費1_特定入所者介護サービス費等請求額;
    private RString 後_公費2_サービス単位数;
    private RString 後_公費2_請求額;
    private RString 後_公費2_本人負担額;
    private RString 後_公費2_緊急時施設療養費請求額;
    private RString 後_公費2_特定診療費請求額;
    private RString 後_公費2_特定入所者介護サービス費等請求額;
    private RString 後_公費3_サービス単位数;
    private RString 後_公費3_請求額;
    private RString 後_公費3_本人負担額;
    private RString 後_公費3_緊急時施設療養費請求額;
    private RString 後_公費3_特定診療費請求額;
    private RString 後_公費3_特定入所者介護サービス費等請求額;
    private RString shinsaYM;
    private RString 識別コード;
    private RString shichosonCode;
    private RString 被保険者氏名;
    private RString kanaMeisho;
    private RString 住所;
    private RString choikiCode;
    private RString gyoseikuCode;
    private RString setaiCode;
    private RString 事業者名称;
    private RString 要介護状態区分名称;
    private RString 給付実績区分名称;
    private RString meishoCode;
}
