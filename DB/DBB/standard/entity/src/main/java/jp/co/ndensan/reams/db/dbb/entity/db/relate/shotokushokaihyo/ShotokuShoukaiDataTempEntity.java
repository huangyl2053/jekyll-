/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得照会票データTemp
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShoukaiDataTempEntity {

    private ShikibetsuCode 識別コード;
    private LasdecCode 現全国地方公共団体コード;
    private LasdecCode 送付先全国住所コード;
    private SetaiCode 世帯コード;
    private HihokenshaNo 被保険者番号;
    private RString 前住所;
    private RString 現住所;
    private AtenaKanaMeisho カナ氏名;
    private AtenaMeisho 名称;
    private FlexibleDate 生年月日;
    private FlexibleDate 異動年月日;
    private RString 候補者区分;
    private RString 本人区分;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 前住所コード;
    private YubinNo 郵便番号;
    private RString 地区コード１;
    private RString 地区コード２;
    private RString 地区コード３;
    private RString 住民状態コード;
    private RString 被保険者区分コード;
    private RString 住民種別コード;
    private RString 性別コード;

}
