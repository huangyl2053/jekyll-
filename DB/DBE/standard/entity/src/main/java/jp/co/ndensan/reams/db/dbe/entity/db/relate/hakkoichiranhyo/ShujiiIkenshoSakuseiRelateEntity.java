/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼発行一覧表RelateEntityクラスです。
 *
 * @reamsid_L DBE-0080-150 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShujiiIkenshoSakuseiRelateEntity {

    private RString 依頼書作成日;
    private RString 依頼書提出期限;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 依頼日;
    private RString 医療機関コード;
    private RString 医療機関名称;
    private RString 代表者名;
    private RString 連絡先;
    private RString 主治医コード;
    private RString 主治医名;
    private RString 証記載保険者番号;

}
