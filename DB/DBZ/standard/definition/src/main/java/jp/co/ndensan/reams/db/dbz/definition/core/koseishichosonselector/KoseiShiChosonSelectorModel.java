/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.definition.core.koseishichosonselector;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 構成市町村選択の画面Modelクラスです。
 * @reamsid_L DBE-3000-060 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiShiChosonSelectorModel implements Serializable {
    
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 証記載保険者番号;
}
