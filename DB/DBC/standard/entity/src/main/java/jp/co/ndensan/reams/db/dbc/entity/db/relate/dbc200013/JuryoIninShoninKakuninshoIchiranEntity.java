/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBCMN32002_受領委任契約承認確認書発行一覧表）のEntityクラスです
 *
 * @reamsid_L DBC-1910-070 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuryoIninShoninKakuninshoIchiranEntity {

    private RString 連番;
    private RString 被保険者番号;
    private RString 被保険者氏名1;
    private RString 事業者所在地;
    private RString 受付日;
    private RString 承認開始日;
    private RString 承認終了日;
    private RString 承認終区分;
    private RString 被保険者氏名2;
    private RString 事業者名称;
    private RString 承認日;
    private RString 利用サービス内容;

    private RString 契約申請年月日;
    private RString 契約事業者番号;
    private RString 受領委任契約番号;

}
