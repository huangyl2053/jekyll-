/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import lombok.Getter;
import lombok.Setter;

/**
 * 項目小計のEntityクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class KoumokuSyoukeyi extends DbTableEntityBase<KoumokuSyoukeyi> implements IDbAccessable {

    private RString choteiNendo;
    private RString fukaNendo;
    private RString hokenryoDankai;
    private RString choshuHouhou;
    private Decimal yoGetuNinsu;
    private Decimal goGetuNinsu;
    private Decimal rokuGetuNinsu;
    private Decimal nanaGetuNinsu;
    private Decimal hatiGetuNinsu;
    private Decimal kyuGetuNinsu;
    private Decimal jyuGetuNinsu;
    private Decimal jyuitiGetuNinsu;
    private Decimal jyuniGetuNinsu;
    private Decimal itiGetuNinsu;
    private Decimal niGetuNinsu;
    private Decimal sanGetuNinsu;
    private Decimal gennenSuyijiNinsu;
    private Decimal kanendoNinsu;
    private Decimal sayisyutuKanpuNinsu;
    private Decimal yoGetuKinkaku;
    private Decimal goGetuKinkaku;
    private Decimal rokuGetuKinkaku;
    private Decimal nanaGetuKinkaku;
    private Decimal hatiGetuKinkaku;
    private Decimal kyuGetuKinkaku;
    private Decimal jyuGetuKinkaku;
    private Decimal jyuitiGetuKinkaku;
    private Decimal jyuniGetuKinkaku;
    private Decimal itiGetuKinkaku;
    private Decimal niGetuKinkaku;
    private Decimal sanGetuKinkaku;
    private Decimal gennenSuyijiKinkaku;
    private Decimal kanendoKinkaku;
    private Decimal sayisyutuKanpuKinkaku;

}
