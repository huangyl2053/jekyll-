/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者ｶﾅ氏名と被保険者漢字氏名は空白処理Entity
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShimeiWaKuhakuNoShoriEntity {

    private AtenaKanaMeisho hihokenshaKana;
    private AtenaMeisho hihokenshaName;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiShinseijiKubunCode;

}
