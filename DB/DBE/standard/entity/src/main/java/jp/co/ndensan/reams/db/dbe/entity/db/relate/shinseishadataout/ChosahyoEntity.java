/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 調査票情報のEntityクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class ChosahyoEntity {

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
    private RString shinseiNinteiChosaItakusakiCode;
    private RString shinseiJigyoshaMeisho;
    private RString shinseiNinteiChosainCode;
    private RString shinseiChosainShimei;
    private Code ninteichosaIraiKubunCode;
    private JigyoshaNo iraiNinteichosaItakusakiCode;
    private RString iraiJigyoshaMeisho;
    private RString iraiNinteiChosainCode;
    private RString iraiChosainShimei;
    private JigyoshaNo nyushuChosaItakusakiCode;
    private RString nyushuIraiJigyoshaMeisho;
    private RString nyushuChosainCode;
    private RString nyushuIraiChosainShimei;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private Code ninteiChosaKubunCode;
    private Code chosaJisshiBashoCode;
    private RString chosaJisshiBashoMeisho;
    private Code serviceKubunCode;
    private RString riyoShisetsuShimei;
    private RString tokki;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private boolean kariIchijiHanteiKubun;
    private FlexibleDate ichijiHanteiYMD;
    private Code ichijiHanteiKekkaCode;
    private Code ichijiHanteiKekkaNinchishoKasanCode;
    private int kijunJikan;
    private int kijunJikanShokuji;
    private int kijunJikanHaisetsu;
    private int kijunJikanIdo;
    private int kijunJikanSeiketsuHoji;
    private int kijunJikanKansetsuCare;
    private int kijunJikanBPSDKanren;
    private int kijunJikanKinoKunren;
    private int kijunJikanIryoKanren;
    private int kijunJikanNinchishoKasan;
    private int chukanHyokaKomoku1gun;
    private int chukanHyokaKomoku2gun;
    private int chukanHyokaKomoku3gun;
    private int chukanHyokaKomoku4gun;
    private int chukanHyokaKomoku5gun;
    private RString ichijiHnateiKeikokuCode;
    private Code jotaiAnteiseiCode;
    private Decimal ninchishoJiritsudoIIijoNoGaizensei;
    private Code suiteiKyufuKubunCode;
    private Code koroshoIfShikibetsuCode;
}
