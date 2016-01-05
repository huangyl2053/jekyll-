/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.tennyutenshutsuhoryutaishosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 転入転出保留対象者管理
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuTenshutsuHoryuEntity {

    private ShikibetsuCode shikibetsuCode;
    private HihokenshaNo hihokenshaNo;
    private Decimal rirekiNo;
    private LasdecCode shichosonCode;
    private RString juminShubetsuCode;
    private AtenaMeisho atenaShimei;
    private AtenaKanaMeisho atenaKanaShimei;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private RString idoJiyuCode;
    private FlexibleDate torokuIdoYMD;
    private AtenaJusho tenshutsuYoteiJusho;
    private FlexibleDate tenshutsuKakuteiIdoYMD;
    private FlexibleDate tenshutsuYoteiIdoYMD;

}
