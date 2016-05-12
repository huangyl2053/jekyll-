/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 人数金額のEntityクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinsuKinkaku {

    private RString choteiNendo;
    private RString fukaNendo;
    private RString choshuHouhou;
    private RString hokenryoDankai;
    private Decimal yoGetuNinsu;
    private Decimal yoGetuKinkaku;
    private Decimal goGetuNinsu;
    private Decimal goGetuKinkaku;
    private Decimal rokuGetuNinsu;
    private Decimal rokuGetuKinkaku;
    private Decimal nanaGetuNinsu;
    private Decimal nanaGetuKinkaku;
    private Decimal hatiGetuNinsu;
    private Decimal hatiGetuKinkaku;
    private Decimal kyuGetuNinsu;
    private Decimal kyuGetuKinkaku;
    private Decimal jyuGetuNinsu;
    private Decimal jyuGetuKinkaku;
    private Decimal jyuitiGetuNinsu;
    private Decimal jyuitiGetuKinkaku;
    private Decimal jyuniGetuNinsu;
    private Decimal jyuniGetuKinkaku;
    private Decimal itiGetuNinsu;
    private Decimal itiGetuKinkaku;
    private Decimal niGetuNinsu;
    private Decimal niGetuKinkaku;
    private Decimal sanGetuNinsu;
    private Decimal sanGetuKinkaku;
    private Decimal gennenSuyijiNinsu;
    private Decimal gennenSuyijiKinkaku;
    private Decimal kanendoNinsu;
    private Decimal kanendoKinkaku;
    private Decimal sayisyutuKanpuNinsu;
    private Decimal sayisyutuKanpuKinkaku;
    private Decimal fumeNinsu;
    private Decimal fumeKinkaku;
    private Decimal kanendoGemmenGaku;
    private Decimal kanendoNinsuGoukeyi;
    private Decimal kanendoGemmenGakuGokeyi;
    private RString getu;
}
