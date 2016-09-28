/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuNyutaishoEntity {

    private ShikibetsuCode 施設入退所_識別コード;
    private FlexibleDate 施設入退所_入所年月日;
    private FlexibleDate 施設入退所_退所年月日;
    private RString 施設入退所_入所施設コード;
    private RString 施設入退所_事業者名称;
    private RString 施設入退所_電話番号;

}
