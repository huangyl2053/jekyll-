/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査依頼発行一覧表ボディのITEMです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiHakkoIchiranhyoBodyItem {

    private int renban;
    private RString 依頼書作成日;
    private RString 依頼書提出期限;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 依頼日;
    private RString 委託先名;
    private RString 代表者名;
    private RString 連絡先;
    private RString 調査員名;
}
