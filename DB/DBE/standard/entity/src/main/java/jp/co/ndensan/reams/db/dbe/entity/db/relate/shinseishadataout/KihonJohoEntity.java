/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請者基本情報のEntityクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class KihonJohoEntity {

    private RString shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString shichosonMeisho;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private AtenaKanaMeisho hihokenshaKana;
    private Code seibetsu;
    private FlexibleDate seinengappiYMD;
    private int age;
    private RString hihokenshaKubunCode;
    private RString nigoTokuteiShippeiCode;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private ChikuCode chikuCode;
    private FlexibleDate ninteiShinseiYMD;
    private RString shienShinseiKubun;
    private Code ninteiShinseiHoreiKubunCode;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code shoriJotaiKubun;
    private boolean shisetsuNyushoFlag;
    private JigyoshaNo nyushoShisetsuCode;
    private AtenaMeisho nyushoShisetsuMeisho;
    private AtenaMeisho renrakusakiShimei;
    private YubinNo renrakusakiYubinNo;
    private AtenaJusho renrakusakiJusho;
    private TelNo renrakusakiTelNo;
    private TelNo renrakusakiKeitaiTelNo;
    private RString renrakusakiTuzukigara;
    private Code shinseiTodokedeDaikoKubunCode;
    private AtenaMeisho shinseiTodokedeshaShimei;
    private YubinNo shinseiTodokedeshaYubinNo;
    private AtenaJusho shinseiTodokedeshaJusho;
    private TelNo shinseiTodokedeshaTelNo;
    private RString shinseiTodokedeshaTsuzukigara;
    private RString jigyoshaKubun;
    private RString JigyoshaNo;
    private FlexibleDate ninteiShinseiJohoTorokuKanryoYMD;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private FlexibleDate ninteichosaKanryoYMD;
    private FlexibleDate ikenshoSakuseiIraiKanryoYMD;
    private FlexibleDate ikenshoTorokuKanryoYMD;
    private FlexibleDate ichijiHanteiKanryoYMD;
    private FlexibleDate maskingKanryoYMD;
    private FlexibleDate ninteiShinsakaiWariateKanryoYMD;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private FlexibleDate centerSoshinYMD;
    private Code ninteiChosaKubunCode;
    private FlexibleDate ninteichosaJisshiYMD;
    private JigyoshaNo chosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString chosainCode;
    private RString chosainShimei;
    private Code chosaJisshiBashoCode;
    private RString chosaJisshiBashoMeisho;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private RString shujiiIryoKikanCode;
    private RString iryoKikanMeisho;
    private RString shujiiCode;
    private RString shujiiName;
    private FlexibleDate ikenshoKinyuYMD;
    private FlexibleDate saishuShinryoYMD;
    private boolean ikenshoDoiFlag;
    private Code ikenshoSakuseiKaisuKubun;
    private RString ikenshoNetakirido;
    private RString ikenshoNinchido;
    private FlexibleDate ichijiHanteiYMD;
    private Code ichijiHanteiKekkaCode;
    private Code ichijiHanteiKekkaNinchishoKasanCode;
    private FlexibleDate ichiGojiHanteiYMD;
    private Code ichiGojiHanteiKekkaCode;
    private Code ichiGojiHanteiKekkaNinchishoKasanCode;
    private FlexibleDate nijiHanteiYMD;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private int nijiHanteiNinteiYukoKikan;
    private FlexibleDate nijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate nijiHanteiNinteiYukoShuryoYMD;
    private Code yokaigoJotaizoReiCode;
    private RString ichijiHanteiKekkaHenkoRiyu;
    private RString ninteishinsakaiIkenShurui;
    private RString shinsakaiIken;
    private RString shinsakaiMemo;
    private RString shinsakaiKaisaiNo;
    private int yoteiGogitaiNo;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private int kekkaGogitaiNo;
    private FlexibleDate shinsakaiKaisaiYMD;
    private Code hanteiKekkaCode;
    private FlexibleDate zenkaiIchijiHanteiYMD;
    private Code zenkaiIchijiHanteiKekkaCode;
    private Code zenkaiIchijiHanteiKekkaNinchishoKasanCode;
    private FlexibleDate zenkaiIchiGojiHanteiYMD;
    private Code zenkaiIchiGojiHanteiKekkaCode;
    private Code zenkaiIchiGojiHanteiKekkaNinchishoKasanCode;
    private FlexibleDate zenkaiNijiHanteiYMD;
    private Code zenkaiNijiHanteiYokaigoJotaiKubunCode;
    private int zenkaiNijiHanteiNinteiYukoKikan;
    private FlexibleDate zenkaiNijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate zenkaiNijiHanteiNinteiYukoShuryoYMD;
    private boolean johoteikyoDoiFlag;
    private Code koroshoIfShikibetsuCode;
    private FlexibleDate ninteiShinseiJohoChushutsuYMD;
    private FlexibleDate ninteiChosaKekkaJohoChushutsuYMD;
    private FlexibleDate ninteiChosaIkenshoKekkaJohoChushutsuYMD;
    private FlexibleDate ichijihanteiChushutsuYMD;
    private FlexibleDate shinsakaiKekkaJohoChushutsuYMD;
    private FlexibleDate centerSoshinChushutsuYMD;
}
