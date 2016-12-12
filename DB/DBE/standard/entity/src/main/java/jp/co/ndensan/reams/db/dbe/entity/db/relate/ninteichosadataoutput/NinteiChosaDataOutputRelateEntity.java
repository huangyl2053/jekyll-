/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査データ出力（モバイル）のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1860-010 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosaDataOutputRelateEntity {

    private RString 申請書管理番号;
    private RString 認定調査委託先コード;
    private RString 認定調査員コード;
    private boolean モバイルデータ出力済フラグ;
    private RString 被保険者番号;
    private RString 氏名;
    private FlexibleDate 認定申請年月日;
    private RString 認定申請区分_申請時_コード;
    private RString 性別;
    private RString 保険者;
    private RString 調査委託先名称;
    private RString 調査員氏名;

}
