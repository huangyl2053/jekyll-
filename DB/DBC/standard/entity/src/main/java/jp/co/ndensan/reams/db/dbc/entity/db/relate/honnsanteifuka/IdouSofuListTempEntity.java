/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 送付対象リスト一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2770-050 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class IdouSofuListTempEntity extends DbTableEntityBase<IdouSofuListTempEntity> implements IDbAccessable {

    private RString 被保険者番号;
    private RString 氏名;
    private RString 区分;
    private FlexibleDate 異動年月日;
    private RString 要介護度;
    private FlexibleDate 開始認定日;
    private FlexibleDate 終了認定日;
    private RString 変更項目;
    private FlexibleDate 作成年月日;
    private int ページ数;
    private RString タイトル;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private RString 備考;
}
