/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定履歴一覧RelateEntityクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinnteiRiriRelateEntity implements Serializable {

    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiShinseiKubunCode;
    private Code ninteiShinseiHoreiKubunCode;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosainCode;
    private FlexibleDate torisageYMD;
    private RString shujiiCode;
    private RString shujiiIryokikanCode;
    private FlexibleDate johoteikyoSiryoOutputYMD;
    private FlexibleDate nijiHanteiYMD;
    private RString shinseishoKanriNo;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private int nijiHanteiNinteiYukoKikan;
    private FlexibleDate nijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate nijiHanteiNinteiYukoShuryoYMD;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private FlexibleDate ninteichosaIraiYMD;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private FlexibleDate ikenshoJuryoYMD;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private FlexibleDate shinsakaiKaisaiYMD;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private boolean johoteikyoDoiFlag;
    private boolean ikenshoDoiFlag;
    private RString shichosonCode;
}
