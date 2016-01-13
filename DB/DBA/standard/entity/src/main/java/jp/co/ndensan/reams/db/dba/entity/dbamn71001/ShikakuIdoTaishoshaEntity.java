/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.dbamn71001;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格異動対象者Entityクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuIdoTaishoshaEntity {

    private ShikibetsuCode 識別コード;
    private LasdecCode 現全国地方公共団体コード;
    private LasdecCode 旧全国地方公共団体コード;
    private RString 住民種別コード;
    private RString 住民状態コード;
    private FlexibleDate 生年月日;
    
}
