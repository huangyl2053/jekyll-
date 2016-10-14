/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 一時用エンティティクラスです。
 *
 * @reamsid_L DBC-2720-070 zhujun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TmpDataEntity {

    private RString 異動日;
    private RString 終了日;
    private RString 喪失日;
    private RString データ区分;
}
