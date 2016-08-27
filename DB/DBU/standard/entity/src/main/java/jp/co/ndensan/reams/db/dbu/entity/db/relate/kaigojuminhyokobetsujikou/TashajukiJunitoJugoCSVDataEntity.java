/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsujikou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護住民票個別事項連携情報作成【他社住基】12桁CSV用データEntity 介護住民票個別事項連携情報作成【他社住基】15桁CSV用データEntity
 *
 * @reamsid_L DBU-0350-030 zhengshukai
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TashajukiJunitoJugoCSVDataEntity {

    private RString 市町村コード;
    private RString 識別ＩＤ;
    private RString タイムスタンプ;
    private RString 最終レコード区分;
    private RString 連番;
    private RString 識別コード;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;
    private RString 資格被保険者区分;
    private RString 住所地特例者区分;
    private RString 受給者区分;
    private Code 要介護状態区分コード;
    private FlexibleDate 認定有効開始日;
    private FlexibleDate 認定有効終了日;
    private FlexibleDate 受給認定年月日;
    private FlexibleDate 受給認定取消年月日;
    private RString 削除フラグ;
    private RString 作成日時;
    private RString 更新日時;
}
