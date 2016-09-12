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

/**
 * 介護認定審査対象者一覧表の情報です。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseiJohoEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private int shinsakaiOrder;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private int age;
    private Code koroshoCode;
    private Code nijiHanteiCode;
    private int nijiHanteiKikan;
    private FlexibleDate nijiHanteiKaishiYMD;
    private FlexibleDate nijiHanteiShuryoYMD;
    private Code ichijiHanteiKekkaCode;
    private RString ichijiHnateiKeikokuCode;
    private int kijunJikan;
    private Code ichijiHanteiKasanCode;
}
