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
 * 認定調査依頼発行一覧表ヘッダのITEMです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiHakkoIchiranhyoHeadItem {

    private RString 認定調査委託先コード;
    private RString 認定調査員コード;
    private RString 保険者番号;
    private RString 依頼日From;
    private RString 依頼日To;
    private RString 認定調査依頼書FLG;
}
