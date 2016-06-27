/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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

    private ShinseishoKanriNo dbt5502_shinseishoKanriNo;
    private int dbt5502_shinsakaiOrder;
    private FlexibleDate dbt5502_shinsakaiKaisaiYMD;
    private RString dbt5101_hihokenshaKubunCode;
    private Code dbt5101_koroshoIfShikibetsuCode;
    private int dbt5101_age;
    private Code dbt5101_seibetsu;
    private Code dbt5101_ninteiKubunCode;
    private Code dbt5101_zenYokaigoKubunCode;
    private FlexibleDate dbt5101_zenkaiYukoKikanStart;
    private FlexibleDate dbt5101_zenkaiYukoKikanEnd;
    private FlexibleDate dbt5101_zenkaiNinteiYMD;
    private FlexibleDate dbt5101_ninteiShinseiYMD;
    private AtenaMeisho dbt5101_hihokenshaName;
    private RString dbt5101_hihokenshaNo;
    private RString dbt5101_shoKisaiHokenshaNo;
    private Code dbt5101_nigoTokuteiShippeiCode;
    private Code dbt5116_ichijiHanteiKekkaCode;
    private int dbt5116_kijunJikan;
    private int dbt5116_kijunJikanShokuji;
    private int dbt5116_kijunJikanHaisetsu;
    private int dbt5116_kijunJikanIdo;
    private int dbt5116_kijunJikanSeiketsuHoji;
    private int dbt5116_kijunJikanKansetsuCare;
    private int dbt5116_kijunJikanBPSDKanren;
    private int dbt5116_kijunJikanKinoKunren;
    private int dbt5116_kijunJikanIryoKanren;
    private int dbt5116_kijunJikanNinchishoKasan;
    private RString dbt5116_ichijiHnateiKeikokuCode;
    private int dbt5116_chukanHyokaKomoku1gun;
    private int dbt5116_chukanHyokaKomoku2gun;
    private int dbt5116_chukanHyokaKomoku3gun;
    private int dbt5116_chukanHyokaKomoku4gun;
    private int dbt5116_chukanHyokaKomoku5gun;
    private Decimal dbt5116_iIijoNoGaizensei;
    private Code dbt5116_jotaiAnteiseiCode;
    private Code dbt5116_suiteiKyufuKubunCode;
    private int dbt5302_ikenshoIraiRirekiNo;
    private ShinseishoKanriNo dbt5302_shinseishoKanriNo;
    private RString dbt5302_shujiiIryoKikanCode;
    private RString dbt5302_shujiiCode;
    private int dbt5304_ikenshoIraiRirekiNo;
    private ShinseishoKanriNo dbt5304_shinseishoKanriNo;
    private int dbt5304_remban;
    private Code dbt5304_koroshoIfShikibetsuCode;
    private RString dbt5304_ikenItem;
    private int dbT5203_ninteichosaRirekiNo;
    private ShinseishoKanriNo dbT5203_shinseishoKanriNo;
    private Code dbT5203_ninchishoCode;
    private Code dbT5203_shogaiCode;
    private int dbt5211_ninteichosaRirekiNo;
    private ShinseishoKanriNo dbt5211_shinseishoKanriNo;
    private int dbt5211_remban;
    private Code dbt5211_koroshoIfShikibetsuCode;
    private RString dbt5211_researchItem;
    private int dbt5202_ninteichosaRirekiNo;
    private ShinseishoKanriNo dbt5202_shinseishoKanriNo;
    private FlexibleDate dbt5202_ninteichosaJisshiYMD;
    private JigyoshaNo dbt5202_chosaItakusakiCode;
    private Code dbt5202_ninteiChosaKubunCode;
    private Code dbt5202_serviceKubunCode;
    private Code dbt5202_chosaJisshiBashoCode;
    private int dbt5207_ninteichosaRirekiNo;
    private ShinseishoKanriNo dbt5207_shinseishoKanriNo;
    private int dbt5207_remban;
    private Code dbt5207_koroshoIfShikibetsuCode;
    private int dbt5207_serviceJokyo;
    private int dbt5210_ninteichosaRirekiNo;
    private ShinseishoKanriNo dbt5210_shinseishoKanriNo;
    private int dbt5210_remban;
    private Code dbt5210_koroshoIfShikibetsuCode;

}
