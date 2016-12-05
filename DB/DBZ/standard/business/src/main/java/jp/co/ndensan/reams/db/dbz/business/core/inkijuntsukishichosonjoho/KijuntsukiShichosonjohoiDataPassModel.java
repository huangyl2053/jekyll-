/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査委託先＆調査員ガイドdivのbusinessクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijuntsukiShichosonjohoiDataPassModel implements Serializable {

    private RString 委託先コード;
    private RString 委託先名;
    private RString 調査員コード;
    private RString 調査員名;
    private RString 市町村コード;
    private RString サブ業務コード;
    private RString 対象モード;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
}
