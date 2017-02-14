/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 意見書情報のEntityクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class IkenshoJohoEntity {

    private RString shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString shichosonMeisho;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private FlexibleDate seinengappiYMD;
    private int age;
    private RString hihokenshaKubunCode;
    private RString nigoTokuteiShippeiCode;
    private FlexibleDate ninteiShinseiYMD;
    private RString shienShinseiKubun;
    private Code ninteiShinseiHoreiKubunCode;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code shoriJotaiKubun;
    private RString shinseiShujiiIryokikanCode;
    private RString shinseiIryoKikanMeisho;
    private RString shinseiShujiiCode;
    private RString shinseiShujiiName;
    private RString ikenshoIraiKubun;
    private RString iraiShujiiIryokikanCode;
    private RString iraiIryoKikanMeisho;
    private RString iraiShujiiCode;
    private RString iraiShujiiName;
    private RString iraiIshiKubunCode;
    private RString nyushuShujiiIryokikanCode;
    private RString nyushuIryoKikanMeisho;
    private RString nyushuShujiiCode;
    private RString nyushuShujiiName;
    private FlexibleDate ikenshoJuryoYMD;
    private FlexibleDate ikenshoKinyuYMD;
    private FlexibleDate ikenshoReadYMD;
    private FlexibleDate saishuShinryoYMD;
    private boolean ikenshoDoiFlag;
    private Code ikenshoSakuseiKaisuKubun;
    private Code zaitakuShisetsuKubun;
    private boolean existTakaJushinFlag;
    private boolean existNaikaJushinFlag;
    private boolean existSeishinkaJushinFlag;
    private boolean existGekaJushinFlag;
    private boolean existSeikeigekaJushinFlag;
    private boolean existNoshinkeigekaJushinFlag;
    private boolean existHifukaJushinFlag;
    private boolean existHinyokikaJushinFlag;
    private boolean existFujinkaJushinFlag;
    private boolean existJibiinkokaJushinFlag;
    private boolean existRehabilitationkaJushinFlag;
    private boolean existShikaJushinFlag;
    private boolean existGankaJushinFlag;
    private boolean existSonotaJushinkaFlag;
    private RString sonotaJushinKaMei;
    private RString shindamMei1;
    private RString hasshoYMD1;
    private RString shindamMei2;
    private RString hasshoYMD2;
    private RString shindamMei3;
    private RString hasshoYMD3;
    private RString anteisei;
    private RString fuanteiJokyo;
    private RString chiryoNaiyo;
    private RString tokkiJiko;
    private boolean nijiHanteiKekkaRenrakuFlag;
    private RString ikenshoMemo;
    private Code koroshoIfShikibetsuCode;
}
