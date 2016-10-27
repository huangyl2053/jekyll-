/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 異動一時1Tempエンティティクラスです。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class Ido1TmpEntity extends DbTableEntityBase<Ido1TmpEntity> implements IDbAccessable {

    private RString 被保険者番号;
    private RString 履歴番号;
    private RString データ区分;
    private RString 異動日;
    private RString 終了日;
    private RString 異動一時1テーブルエリア;

}
