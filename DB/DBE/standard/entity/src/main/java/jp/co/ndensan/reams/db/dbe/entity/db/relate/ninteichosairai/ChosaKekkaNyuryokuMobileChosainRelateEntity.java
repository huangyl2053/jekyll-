/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * モバイル入力用データ（調査結果入力用調査員データ）RelateEntityクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ChosaKekkaNyuryokuMobileChosainRelateEntity {

    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private RString ninteichosaItakusakiCode;
    private JigyoshaNo jigyoshaNo;
    private RString jigyoshaMeisho;
    private RString jigyoshaMeishoKana;
    private YubinNo yubinNo;
    private RString jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private RString daihyoshaName;
    private RString daihyoshaNameKana;
    private int waritsukeTeiin;
    private boolean autoWaritsukeFlag;
    private boolean tokuteiChosainDisplayFlag;
    private ChikuCode waritsukeChiku;
    private RString chosaItakuKubun;
    private RString kikanKubun;
    private boolean jokyoFlag;
    private RString ninteiChosainCode;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    private RString seibetsu;
    private RString chikuCode;
    private RString chosainShikaku;
    private int chosaKanoNinzuPerMonth;
    private boolean chosainJokyoFlag;
    private YubinNo chosainYubinNo;
    private AtenaJusho chosainJusho;
    private TelNo chosainTelNo;
    private TelNo chosainFaxNo;
    private RString shozokuKikanName;

}
