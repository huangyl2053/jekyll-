/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shisetsunyushoinfo.ninteishinseishakihoninfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請者基本情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-190 hezhenzhen
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseishaKihonInfoRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private RString hihokenshaKubunCode;
    private FlexibleDate seinengappiYMD;
    private int age;
    private Code seibetsu;
    private AtenaMeisho hihokenshaName;
    private AtenaKanaMeisho hihokenshaKana;
    private YubinNo yubinNo;
    private TelNo telNo;
    private AtenaJusho jusho;
    private RString shichosonMeisho;
    private RString shinsakaiKaisaiNo;

}
