/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 取込国保情報Entityクラスです。
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiKokuhoJyohoEntity extends DbTableEntityBase<TorikomiKokuhoJyohoEntity> implements IDbAccessable {

    private RString 市町村コード;
    @PrimaryKey
    private RString iN住民コード;
    @PrimaryKey
    private RString 履歴番号;
    private RString 国保番号;
    private RString 国保資格取得年月日;
    private RString 国保資格喪失年月日;
    private RString 国保保険者番号;
    private RString 国保保険証番号;
    private RString 国保個人番号;
    private RString 国保退職該当日;
    private RString 国保退職非該当日;
    private RString 個人区分コード;
    private RString 登録区分;
    private RString 更新コード;
    private RString 氏名;
    private RString カナ氏名;
    private RString 生年月日;
    private RString 性別コード;
    private RString 郵便番号;
    private RString 住所;
    private RString 方書;
    private RString バイト数;
    private RString エラーコード;
    private RString エラー文言;
    private RString エラー区分;
}
