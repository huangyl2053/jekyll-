/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 健康かるて連携データ作成のEntityです。
 *
 * @reamsid_L DBC-5020-040 zhaoyao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KenkouKaruteRenkeiDataEntity {

    private RString 被保険者番号;
    private FlexibleDate 異動日;
    private RString 市町村コード;
    private RString 識別コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格喪失年月日;
    private boolean 論理削除フラグ;
    private RString 業務コード;
    private RString 住民種別コード;
    private RString 住民状態コード;
    private RString 名称;
    private RString カナ名称;
    private RString 個人番号;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 履歴番号;
    private RString 枝番;
    private RString 要介護認定状態区分コード;
    private FlexibleDate 認定年月日;
    private FlexibleDate 喪失年月日;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
}
