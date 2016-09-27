/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu;

import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 進捗の取込みリストファイル一時テーブルEntity
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JinbunoQurirumirisutofairuYishiteburuEntity extends
        DbTableEntityBase<JinbunoQurirumirisutofairuYishiteburuEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("JinbunoQurirumirisutofairuYishiteburuTemp"));
    }

    @TempTableColumnOrder(1)
    private RString shikibetsukodo;
    @TempTableColumnOrder(2)
    private RString shikibetsukodo_meisho;
    @TempTableColumnOrder(3)
    private RString hokenshabango;
    @TempTableColumnOrder(4)
    private RString hihokenjabango;
    @TempTableColumnOrder(5)
    private FlexibleDate ninteishinseibi;
    @TempTableColumnOrder(6)
    private RString edaban;
    @TempTableColumnOrder(7)
    private RString shinseikubunhorei;
    @TempTableColumnOrder(8)
    private RString shinseikubunhorei_meisho;
    @TempTableColumnOrder(9)
    private RString shinseikubunshinseiji;
    @TempTableColumnOrder(10)
    private RString shinseikubunshinseiji_meisho;
    @TempTableColumnOrder(11)
    private RString torisakubunkodo;
    @TempTableColumnOrder(12)
    private RString torisakubunkodo_meisho;
    @TempTableColumnOrder(13)
    private RString hihokenjakubun;
    @TempTableColumnOrder(14)
    private RString hihokenjakubun_meisho;
    @TempTableColumnOrder(15)
    private RString shinseidaikokubun;
    @TempTableColumnOrder(16)
    private RString shinseidaikokubun_meisho;
    @TempTableColumnOrder(17)
    private FlexibleDate seinengappi;
    @TempTableColumnOrder(18)
    private RString nenrei;
    @TempTableColumnOrder(19)
    private RString seibetsukodo;
    @TempTableColumnOrder(20)
    private RString seibetsukodo_meisho;
    @TempTableColumnOrder(21)
    private RString hihokenjakanashimei;
    @TempTableColumnOrder(22)
    private RString hihokenjakanjishimei;
    @TempTableColumnOrder(23)
    private YubinNo yubenbango;
    @TempTableColumnOrder(24)
    private RString jusho;
    @TempTableColumnOrder(25)
    private TelNo tenwabango;
    @TempTableColumnOrder(26)
    private RString byoinshisetsutonomeisho;
    @TempTableColumnOrder(27)
    private RString byoinshisetsutonoshozaichi;
    @TempTableColumnOrder(28)
    private RString zenkainoninteishinsakaikekka;
    @TempTableColumnOrder(29)
    private RString zenkainoninteishinsakaikekka_meisho;
    @TempTableColumnOrder(30)
    private FlexibleDate zenkainoninteiyukokigenkaishi;
    @TempTableColumnOrder(31)
    private FlexibleDate zenkainoninteiyukokigenshuryo;
    @TempTableColumnOrder(32)
    private RString shujiiiryokikanbango;
    @TempTableColumnOrder(33)
    private RString shujiibango;
    @TempTableColumnOrder(34)
    private FlexibleDate lkenshoiraibi;
    @TempTableColumnOrder(35)
    private FlexibleDate lkenshonyushubi;
    @TempTableColumnOrder(36)
    private RString lkensho_tankikioku;
    @TempTableColumnOrder(37)
    private RString lkensho_ninchinoryoku;
    @TempTableColumnOrder(38)
    private RString lkensho_dentatsunoryoku;
    @TempTableColumnOrder(39)
    private RString lkensho_shokujikoi;
    @TempTableColumnOrder(40)
    private RString lkensho_ninshishokoreishajiritsudo;
    @TempTableColumnOrder(41)
    private FlexibleDate chosairaibi;
    @TempTableColumnOrder(42)
    private FlexibleDate chosajisshibi;
    @TempTableColumnOrder(43)
    private RString shiteikyotakukaigoshienjigyoshatobango;
    @TempTableColumnOrder(44)
    private RString ltakukubun;
    @TempTableColumnOrder(45)
    private RString ltakukubun_meisho;
    @TempTableColumnOrder(46)
    private RString ninteichosainbango;
    @TempTableColumnOrder(47)
    private RString ninteichosainshikakukodo;
    @TempTableColumnOrder(48)
    private RString ninteichosainshikakukodo_meisho;
    @TempTableColumnOrder(49)
    private FlexibleDate lchijihanteibi;
    @TempTableColumnOrder(50)
    private RString lchijihanteikekka;
    @TempTableColumnOrder(51)
    private RString lchijihanteikekka_meisho;
    @TempTableColumnOrder(52)
    private RString lchijihanteikekka_ninshishokasan;
    @TempTableColumnOrder(53)
    private RString lchijihanteikekka_ninshishokasan_meisho;
    @TempTableColumnOrder(54)
    private FlexibleDate ninteishinsakaishiryosakuseibi;
    @TempTableColumnOrder(55)
    private FlexibleDate ninteishinsakaiyoteibi;
    @TempTableColumnOrder(56)
    private RString gogitaibango;
    @TempTableColumnOrder(57)
    private RString shinsakaishiryobango;
    @TempTableColumnOrder(58)
    private FlexibleDate nijihanteibi;
    @TempTableColumnOrder(59)
    private RString nijihanteikekka;
    @TempTableColumnOrder(60)
    private RString nijihanteikekka_meisho;
    @TempTableColumnOrder(61)
    private FlexibleDate ninteiyukokigen_kaishi;
    @TempTableColumnOrder(62)
    private FlexibleDate ninteiyukokigen_shuryo;
    @TempTableColumnOrder(63)
    private RString tokuteishippeikodo;
    @TempTableColumnOrder(64)
    private RString tokuteishippeikodo_meisho;
    @TempTableColumnOrder(65)
    private RString yokaigo1nobaainojotaizo;
    @TempTableColumnOrder(66)
    private RString yokaigo1nobaainojotaizo_meisho;
    @TempTableColumnOrder(67)
    private RString genzainosabisukubunkodo;
    @TempTableColumnOrder(68)
    private RString genzainosabisukubunkodo_meisho;
    @TempTableColumnOrder(69)
    private RString genzainojokyo;
    @TempTableColumnOrder(70)
    private RString genzainojokyo_meisho;

}
