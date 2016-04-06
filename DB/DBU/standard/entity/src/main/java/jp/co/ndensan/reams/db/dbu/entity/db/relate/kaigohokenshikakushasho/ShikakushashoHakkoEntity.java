/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格者証発行のエンティティです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakushashoHakkoEntity {

    private RString hokenshaNo;
    private RString hokenshaName;
    private RString yukoKigen;
    private RString hihokenshaNo;
    private RString kofuYMD;
    private RString yokaigoJotai;
    private RString ninteiYMD;
    private RString yukoKaishiYMD;
    private RString yukoShuryoYMD;
    private RString kubunShikyuYukoKaishiYMD;
    private RString kubunShikyuYukoShuryoYMD;
    private RString kubunShikyuKizyunngaku;
    private List<ShuruiShikyuGendoKizyunngakuEntity> shikyuGendoKizyungakuList;
    private RString serviceShitei;
    private RString seigenNaiyo;
    private RString seigenKaishiYMD;
    private RString seigenShuryoYMD;
    private RString nyushoShisetsu;
    private RString nyushoYMD;
    private RString taishoYMD;
    private List<ShienJigyoshaEntity> shienJigyoshaList;
    private RString shikibetsuCode;
}
