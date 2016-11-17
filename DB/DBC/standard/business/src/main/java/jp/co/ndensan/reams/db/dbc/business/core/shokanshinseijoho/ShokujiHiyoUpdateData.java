/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanshinseijoho;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;

/**
 * 食事費用登録更新処理のクラスです。
 *
 * @reamsid_L DBC-1030-090 qiuxy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokujiHiyoUpdateData implements Serializable {

    private List<ShokanMeisaiResult> 償還払請求明細データ;
    private List<ShokanShokujiHiyo> 償還払請求食事費用データ;

}
