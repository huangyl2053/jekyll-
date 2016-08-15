/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.itizihanteiiftorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.NinteichosaJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * バッチ設計_DBE309002_一次判定IF取込の一時テーブルです。
 *
 * @reamsid_L DBE-1470-022 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class IchijiHanteiKekkaJohoTempTableEntity extends DbTableEntityBase<NinteichosaJohoTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    private RString shinseishoKanriNo;
    @TempTableColumnOrder(2)
    private RString hihokenshaNo;
    @TempTableColumnOrder(3)
    private RString ninteiShinseiYMD;
    @TempTableColumnOrder(4)
    private RString ninteiShinseiShinseijiKubunCode;
    @TempTableColumnOrder(5)
    private RString ichijiHanteiKekkaCode;
    @TempTableColumnOrder(6)
    private RString ichijiHanteiKekkaNinchishoKasanCode;
    @TempTableColumnOrder(7)
    private RString kijunJikan;
    @TempTableColumnOrder(8)
    private RString kijunJikanShokuji;
    @TempTableColumnOrder(9)
    private RString kijunJikanHaisetsu;
    @TempTableColumnOrder(10)
    private RString kijunJikanIdo;
    @TempTableColumnOrder(11)
    private RString kijunJikanSeiketsuHoji;
    @TempTableColumnOrder(12)
    private RString kijunJikanKansetsuCare;
    @TempTableColumnOrder(13)
    private RString kijunJikanBPSDKanren;
    @TempTableColumnOrder(14)
    private RString kijunJikanKinoKunren;
    @TempTableColumnOrder(15)
    private RString kijunJikanIryoKanren;
    @TempTableColumnOrder(16)
    private RString kijunJikanNinchishoKasan;
    @TempTableColumnOrder(17)
    private RString chukanHyokaKomoku1gun;
    @TempTableColumnOrder(18)
    private RString chukanHyokaKomoku2gun;
    @TempTableColumnOrder(19)
    private RString chukanHyokaKomoku3gun;
    @TempTableColumnOrder(20)
    private RString chukanHyokaKomoku4gun;
    @TempTableColumnOrder(21)
    private RString chukanHyokaKomoku5gun;
    @TempTableColumnOrder(22)
    private RString ichijiHnateiKeikokuCode;
    @TempTableColumnOrder(23)
    private RString jotaiAnteiseiCode;
    @TempTableColumnOrder(24)
    private RString ninchishoJiritsudoIIijoNoGaizensei;
    @TempTableColumnOrder(25)
    private RString suiteiKyufuKubunCode;
}
