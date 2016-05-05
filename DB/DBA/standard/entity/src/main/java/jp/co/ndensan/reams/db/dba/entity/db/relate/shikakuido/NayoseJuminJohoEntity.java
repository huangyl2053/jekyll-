/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.shikakuido;

import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 名寄せ住民情報のエンティティクラスです。
 *
 * @reamsid_L DBA-1300-020 dingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NayoseJuminJohoEntity {

    private ShikibetsuCode shikibetsuCode;
    private LasdecCode lasdecCode;
    private JuminJotai juminJotai;
    private FlexibleDate seinengappi;
    private AtenaKanaMeisho kanaMeisho;

}
