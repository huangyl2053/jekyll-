/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiJutakuKaishuhi;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績住宅改修費を照会のbusinessクラスです。
 *
 * @reamsid_L DBC-2970-100 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiJutakuKaishuhiBusiness implements Serializable {

    private static final long serialVersionUID = 8066000298508985720L;

    private KyufujissekiJutakuKaishuhi 給付実績住宅改修費情報;
    private RString サービス種類略称;
}
