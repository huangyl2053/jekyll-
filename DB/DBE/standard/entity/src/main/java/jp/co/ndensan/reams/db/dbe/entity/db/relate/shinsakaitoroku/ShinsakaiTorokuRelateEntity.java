/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaitoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会登録relateエンティティクラスです。
 * 
 * @author n3402 猪股 祐太
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiTorokuRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code shinseijiKubunCode;
    private Code ninteiShinseiHoreiKubunCode;
    private FlexibleDate ninteiShinseiYMD;
    private Code yusenWaritsukeKubunCode;
    private RString shichosonMeisho;
    private FlexibleDate ninteichosaKanryoYMD;
    private FlexibleDate ikenshoTorokuKanryoYMD;
    private FlexibleDate maskingKanryoYMD;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private FlexibleDate kaiWariateKanryoYMD;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString shinsakaiKaisaiNo;
    private int gogitaiNo;
    private FlexibleDate shinsakaiWariateYMD;
    private RString gogitaiMei;
}
