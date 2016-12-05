/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.entity.db.relate.iryohokenRireki;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 医療保険種別コードを取得する
 *
 * @author n8429
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class IryohokenRirekiShubetsuCodeEntity implements IDbAccessable{
    
    private RString code;
    private RString codeName;
    
}
