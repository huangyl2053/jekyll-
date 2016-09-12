/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyodojukyushataishosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 共同処理用受給者訂正連絡票登録（対象者検索）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-1951-050 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoJukyushaTaishoshaParameter {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 異動日From;
    private FlexibleDate 異動日To;
    private boolean 削除データ検索;

}
