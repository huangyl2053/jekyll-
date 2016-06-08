/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査依頼発行一覧表ヘッダのITEMです。
 *
 * @reamsid_L DBE-0080-110 yaodongsheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiHakkoIchiranhyoHeadItem {

    private List<RString> 認定調査委託先コード;
    private List<RString> 認定調査員コード;
    private RString 保険者番号;
    private RString 依頼日From;
    private RString 依頼日To;
    private RString 認定調査依頼書FLG;
}
