/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 委員用一次判定結果の情報です。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ItiziHanteiEntity {

    private int ninteichosaIraiRirekiNo;
    private int ikenshoIraiRirekiNo;
    private ShinseishoKanriNo shinseishoKanriNo;
    private Code koroshoIfShikibetsuCode;
    private RString hihokenshaKubunCode;
    private Code ninteiShinseiShinseijiKubunCode;
    private int age;
    private Code seibetsu;
    private Code zzKoroshoIfShikibetsuCode;
    private Code zzNijiHanteiYokaigoJotaiKubunCode;
    private int zzNijiHanteiNinteiYukoKikan;
    private FlexibleDate zzNijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate zzNijiHanteiNinteiYukoShuryoYMD;
    private Code zKoroshoIfShikibetsuCode;
    private Code zNijiHanteiYokaigoJotaiKubunCode;
    private int zNijiHanteiNinteiYukoKikan;
    private FlexibleDate zNijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate zNijiHanteiNinteiYukoShuryoYMD;
    private FlexibleDate zNijiHanteiYMD;
    private Code zYokaigoJotaizoReiCode;
    private FlexibleDate ninteiShinseiYMD;
    private FlexibleDate shinsakaiKaisaiYMD;
    private Code ichijiHanteiKekkaCode;
    private Code ichijiHanteiKekkaNinchishoKasanCode;
    private int kijunJikan;
    private int zKijunJikan;
    private int kijunJikanShokuji;
    private int kijunJikanHaisetsu;
    private int kijunJikanIdo;
    private int kijunJikanSeiketsuHoji;
    private int kijunJikanKansetsuCare;
    private int kijunJikanBPSDKanren;
    private int kijunJikanKinoKunren;
    private int kijunJikanIryoKanren;
    private int kijunJikanNinchishoKasan;
    private int zKijunJikanShokuji;
    private int zKijunJikanHaisetsu;
    private int zKijunJikanIdo;
    private int zKijunJikanSeiketsuHoji;
    private int zKijunJikanKansetsuCare;
    private int zKijunJikanBPSDKanren;
    private int zKijunJikanKinoKunren;
    private int zKijunJikanIryoKanren;
    private int zKijunJikanNinchishoKasan;
    private FlexibleDate ninteichosaJisshiYMD;
    private RString chosaJisshiBashoMeisho;
    private Code nigoTokuteiShippeiCode;
    private RString ichijiHnateiKeikokuCode;
    private int chukanHyokaKomoku1gun;
    private int chukanHyokaKomoku2gun;
    private int chukanHyokaKomoku3gun;
    private int chukanHyokaKomoku4gun;
    private int chukanHyokaKomoku5gun;
    private int zChukanHyokaKomoku1gun;
    private int zChukanHyokaKomoku2gun;
    private int zChukanHyokaKomoku3gun;
    private int zChukanHyokaKomoku4gun;
    private int zChukanHyokaKomoku5gun;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private RString ninchishoNichijoSeikatsuJiritsudo;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private RString shogaiNichijoSeikatsuJiritsudo;
    private RString ikenItem;
    private Decimal ninchishoJiritsudoIIijoNoGaizensei;
    private Code jotaiAnteiseiCode;
    private Code suiteiKyufuKubunCode;
    private Code serviceKubunCode;
    private ShinseishoKanriNo zShinseishoKanriNo;
    private AtenaMeisho hihokenshaName;
    private RString hihokenshaNo;
    private RString shoKisaiHokenshaNo;
    private RString shichosonMeisho;
    private RString ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString ninteiChosainCode;
    private RString chosainShimei;
    private RString chosainShikaku;
    private RString shujiiCode;
    private RString shujiiName;
    private RString shujiiIryokikanCode;
    private RString iryoKikanMeisho;
    private RString jotaizo;
    private RString shishoMei;
    private int shinsakaiOrder;
}
