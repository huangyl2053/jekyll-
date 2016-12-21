/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他機関情報Entityクラスです。
 *
 * @author n8407
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SonotaKikanJohoEntity {
    
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString hokensha;
    private RString sonotaKikanCode;
    private RString kikanMeisho;
    private RString kikanMeishoKana;
    private YubinNo yubinNo;
    private RString jusho;
    private RString jushoKana;
    private TelNo telNo;
    private RString chosaItakuKubun;
    private int waritsukeTeiin;
    private ChikuCode waritsukeChiku;
    private RString kikanKubun;
    private boolean haishiFlag;
    private KinyuKikanCode kinyuKikanCode;
    private KinyuKikanShitenCode kinyuKikanShitenCode;
    private RString yokinShubetsu;
    private RString kozaNo;
    private AtenaKanaMeisho kozaMeigininKana;
    private AtenaMeisho kozaMeiginin;
}
