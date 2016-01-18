/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 証発行管理リスト帳票用データリストクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihohenshashoHakkoKanriboChohyoDataSakuseiEntity {

    private RString 印刷日時;
    private int ページ数;
    private RString 帳票タイトル;
    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RString ソート順１;
    private RString ソート順２;
    private RString ソート順３;
    private RString ソート順４;
    private RString ソート順５;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private RString 被保険者番号;
    private ShikibetsuCode 識別コード;
    private RString 郵便番号;
    private RString 氏名;
    private RString 住所;
    private LasdecCode 市町村コードListYou;
    private RString 交付年月日;
    private RString 交付事由コード;
    private RString 交付事由略称;
    private RString 交付事由名称;
    private RString 回収年月日;
    private RString 回収事由コード;
    private RString 回収事由名称;
    private RString 有効期限;
    private RString 様式;

}
