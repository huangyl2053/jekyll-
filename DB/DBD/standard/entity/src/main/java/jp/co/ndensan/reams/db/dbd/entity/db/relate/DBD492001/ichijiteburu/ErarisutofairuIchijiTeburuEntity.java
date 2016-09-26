/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.ichijiteburu;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 進捗の取込みエラーリストファイル一時テーブル
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ErarisutofairuIchijiTeburuEntity extends DbTableEntityBase<ErarisutofairuIchijiTeburuEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("ErarisutofairuIchijiTeburuTemp"));
    }

    @TempTableColumnOrder(1)
    private ShikibetsuCode shikibetsukodo;
    @TempTableColumnOrder(2)
    private RString hokenshabango;
    @TempTableColumnOrder(3)
    private RString hihokenjabango;
    @TempTableColumnOrder(4)
    private FlexibleDate ninteishinseibi;
    @TempTableColumnOrder(5)
    private RString edaban;
    @TempTableColumnOrder(6)
    private Code shinseikubunhorei;
    @TempTableColumnOrder(7)
    private Code shinseikubunshinseiji;
    @TempTableColumnOrder(8)
    private Code torisakubunkodo;
    @TempTableColumnOrder(9)
    private Code hihokenjakubun;
    @TempTableColumnOrder(10)
    private Code shinseidaikokubun;
    @TempTableColumnOrder(11)
    private FlexibleDate seinengappi;
    @TempTableColumnOrder(12)
    private int nenrei;
    @TempTableColumnOrder(13)
    private Code seibetsukodo;
    @TempTableColumnOrder(14)
    private AtenaKanaMeisho hihokenjakanashimei;
    @TempTableColumnOrder(15)
    private AtenaMeisho hihokenjakanjishimei;
    @TempTableColumnOrder(16)
    private YubinNo yubenbango;
    @TempTableColumnOrder(17)
    private AtenaJusho jusho;
    @TempTableColumnOrder(18)
    private TelNo tenwabango;
    @TempTableColumnOrder(19)
    private RString byoinshisetsutonomeisho;
    @TempTableColumnOrder(20)
    private RString byoinshisetsutonoshozaichi;
    @TempTableColumnOrder(21)
    private RString eramesseji;
}
