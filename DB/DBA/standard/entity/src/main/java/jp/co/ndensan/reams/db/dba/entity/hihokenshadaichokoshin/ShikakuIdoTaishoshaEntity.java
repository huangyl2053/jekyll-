/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.hihokenshadaichokoshin;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格異動対象者Entityクラスです。
 *
 * @reamsid_L DBA-0330-030 xuyue
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
