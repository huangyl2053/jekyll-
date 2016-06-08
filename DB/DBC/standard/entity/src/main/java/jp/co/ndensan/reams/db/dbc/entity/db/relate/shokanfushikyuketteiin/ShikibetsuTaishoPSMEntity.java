/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 取得した宛名情報Entity
 *
 * @reamsid_L DBC-2590-030 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikibetsuTaishoPSMEntity implements Serializable {

    private ShikibetsuCode 識別コード;
    private ZenkokuJushoCode 全国住所コード;
    private AtenaJusho 住所;
    private GyoseikuCode 行政区コード;
    private RString 行政区名;
}
