/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査請求書登録を登録のエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SinsaSeikyusyoTorokuEntity {

    private ShikibetsuCode shikibetsuCode;
    private HihokenshaNo genshobunsHihokennshaNo;
    private FlexibleDate shinsaSeikyuTodokedeYMD;
    private YubinNo shinsaSeikyuninYubinNo;
    private AtenaJusho shinsaSeikyuninJusho;
    private AtenaMeisho shinsaSeikyuninShimei;
    private TelNo shinsaSeikyuninTelNo;
    private RString hihokenshaTonoKankeiCode;
    private RString hihokenshaTonoKankei;
    private YubinNo dairininYubinNo;
    private AtenaJusho dairininJusho;
    private AtenaMeisho dairininShimei;
    private TelNo dairininTelNo;
    private RString shobunCho;
    private FlexibleDate shobunYMD;
    private RString shobunShuruiCode;
    private FlexibleDate shobunKakuninYMD;
    private RString shinsaSeikyuRiyu;
    private RString shobunChoKyojiNaiyo;
    private boolean tempuShoruiTo;
    private FlexibleDate shinsaSeikyuTorisageYMD;
}
