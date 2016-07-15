/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBBGM51002_所得照会票作成
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiInn {

    private RString 住民状態コード;
    private RString 住民種別コード;
    private FlexibleDate 転出日;
    private FlexibleDate 転入異動日;
    private ShikibetsuCode 識別コード;
    private RString カナ氏名;
    private RString 氏名;
    private FlexibleDate 生年月日;
}
