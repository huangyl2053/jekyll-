/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.kekkatsuchiichiranhyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定結果通知一覧表のEntityです。
 *
 * @reamsid_L DBE-0180-020 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KekkatsuchiIchiranhyoEntity {

    private RString shichosonName;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString shinsakaiNo;
    private FlexibleDate shinsakaiKaisaiYMD;
    private RDateTime printTimeStamp;
    private RString hokenshaName;
    private RString shinseiYMD;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString hihokenshaKana;
    private RString seinengappiYMD;
    private RString seibetsu;
    private RString nijiHanteiKekka;
    private RString ninteiYukoKikan;
    private RString ninteiYukokaishiYMD;
    private RString ninteiYukoshurouYMD;
    private int gogitaiNo;
}
