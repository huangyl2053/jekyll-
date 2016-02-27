/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaishadaichojoho;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名識別対象RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikibetsuTaishoRelateEntity {

    private LasdecCode 現全国地方公共団体コード;
    private TelNo 連絡先1;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private SetaiCode 世帯コード;
    private ShikibetsuCode 識別コード;
    private AtenaKanaMeisho カナ名称;
    private AtenaMeisho 名称;
    private ChikuCode 地区コード1;
    private RString 地区名1;
    private ChikuCode 地区コード2;
    private RString 地区名2;
    private ChikuCode 地区コード3;
    private RString 地区名3;
    private AtenaJusho 住所;
    private ZenkokuJushoCode 全国住所コード;
    private GyoseikuCode 行政区コード;
    private AtenaJusho 転入前住所;
    private ZenkokuJushoCode 転入前全国住所コード;
}
