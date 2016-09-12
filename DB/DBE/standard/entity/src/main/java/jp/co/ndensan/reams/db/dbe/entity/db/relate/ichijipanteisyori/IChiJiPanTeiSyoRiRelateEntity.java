/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijipanteisyori;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 対象者一覧RelateEntityクラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IChiJiPanTeiSyoRiRelateEntity implements Serializable {

    private RString shichosonMeisho;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiShinseijiKubunCode;
    private FlexibleDate ichijiHanteiYMD;
    private Code ichijiHanteiKekkaCode;
    private RString ichijiHnateiKeikokuCode;
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
    private Code jotaiAnteiseiCode;
    private Decimal ninchishoJiritsudoIIijoNoGaizensei;
    private Code suiteiKyufuKubunCode;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ikenshoJuryoYMD;
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString koroshoIfShikibetsuCode;
}
