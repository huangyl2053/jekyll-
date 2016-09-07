/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 氏名カナ突合結果件数一時SQL検索結果Entityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShimeiKanaTotsugoKensuJohoEntity {

    private RString dt年金保険者コード;
    private RString dt年金コード;
    private RString dt基礎年金番号;
    private RString dt対象年;
    private FlexibleDate dt作成年月日;
    private int 件数;
}
