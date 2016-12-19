/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosairai;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 自動割り当てに必要な情報を保持します。
 */
@lombok.Getter
@lombok.AllArgsConstructor
public class NinteichosaIraiJidoWariate {

    RString 保険者番号;
    RString 地区コード;
    RString 申請書管理番号;
    RString 厚労省IF識別コード;

}
