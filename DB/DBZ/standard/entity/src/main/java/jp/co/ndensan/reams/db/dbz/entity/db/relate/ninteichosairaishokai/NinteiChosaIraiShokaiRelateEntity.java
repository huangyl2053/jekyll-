/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteichosairaishokai;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査情報を取得するのエンティティクラスです。
 *
 * @reamsid_L DBE-0200-020 zhangguopeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaIraiShokaiRelateEntity {

    private Code koroshoIfShikibetsuCode;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiShinseijiKubunCode;
    private FlexibleDate torisageYMD;
    private FlexibleDate nijiHanteiYMD;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private int nijiHanteiNinteiYukoKikan;
    private RString jigyoshaMeisho;
    private ChosaItakusakiCode ninteiChosaItakusakiCode;
    private ChosainCode ninteiChosainCode;
    private RString chosainShimei;
    private Code ninteichosaIraiKubunCode;
}
