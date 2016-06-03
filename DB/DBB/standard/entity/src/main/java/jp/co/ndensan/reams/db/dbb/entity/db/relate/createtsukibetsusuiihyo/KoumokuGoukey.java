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
 * 合計部分合計値Entityクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class KoumokuGoukey extends DbTableEntityBase<KoumokuGoukey> implements IDbAccessable {

    private RString hokenryoDankai;
    private Decimal yoGetuNinsuuGoukeyi;
    private Decimal goGetuNinsuuGoukeyi;
    private Decimal rokuGetuNinsuuGoukeyi;
    private Decimal nanaGetuNinsuuGoukeyi;
    private Decimal hatiGetuNinsuuGoukeyi;
    private Decimal kyuGetuNinsuuGoukeyi;
    private Decimal jyuGetuNinsuuGoukeyi;
    private Decimal jyuitiGetuNinsuuGoukeyi;
    private Decimal jyuniGetuNinsuuGoukeyi;
    private Decimal itiGetuNinsuuGoukeyi;
    private Decimal niGetuNinsuuGoukeyi;
    private Decimal sanGetuNinsuuGoukeyi;
    private Decimal 現年随時の人数合計;
    private Decimal 過年度の人数合計;
    private Decimal 歳出還付の人数合計;
    private Decimal 該当段階の人数合計;
    private Decimal 総人数合計;
    private Decimal yoGetuKinkakuGoukeyi;
    private Decimal goGetuKinkakuGoukeyi;
    private Decimal rokuGetuKinkakuGoukeyi;
    private Decimal nanaGetuKinkakuGoukeyi;
    private Decimal hatiGetuKinkakuGoukeyi;
    private Decimal kyuGetuKinkakuGoukeyi;
    private Decimal jyuGetuKinkakuGoukeyi;
    private Decimal jyuitiGetuKinkakuGoukeyi;
    private Decimal jyuniGetuKinkakuGoukeyi;
    private Decimal itiGetuKinkakuGoukeyi;
    private Decimal niGetuKinkakuGoukeyi;
    private Decimal sanGetuKinkakuGoukeyi;
    private Decimal 現年随時の金額合計;
    private Decimal 過年度の金額合計;
    private Decimal 歳出還付の金額合計;
    private Decimal 該当段階の金額合計;
    private Decimal 総金額合計;

}
