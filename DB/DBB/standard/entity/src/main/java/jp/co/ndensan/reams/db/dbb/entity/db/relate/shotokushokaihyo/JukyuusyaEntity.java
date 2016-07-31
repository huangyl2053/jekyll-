/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期間内（処理年度8月1日～翌年7月31日）の受給者を抽出して、受給者Tempへ出力する
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuusyaEntity {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private RString 住所地特例フラグ;
    private FlexibleDate 適用年月日;
    private FlexibleDate 解除年月日;
    private RString 被保険者区分コード;
}
