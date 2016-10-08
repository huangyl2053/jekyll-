/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * 異動一時エンティティ。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdouTblEntity extends DbTableEntityBase<IdouTblEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo 被保険者番号;
    @PrimaryKey
    private int 連番;
    private int 被保険者番号Max連番;
    private RString 支払方法変更_支払方法;
    private RString 支払方法変更_給付費減額;
    private RString 後期高齢者情報;
    private RString 国保資格情報;
    private RString 生活保護受給者;
    private RString 特定入所者;
    private RString 社福減免;
    private RString 利用者負担額減額;
    private RString 標準負担;
    private RString 利用者負担割合明細;
    private RString 居宅計画;
    private RString 住所地特例;
    private RString 宛名;
    private RString 受給者台帳;
    private RString 二次予防事業対象者;
    private RString 総合事業対象者;
    private RString 被保険者台帳管理;
}
