/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 認定調査票基本調査調査項目一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class ChosaItemJohoTempTableEntity extends DbTableEntityBase<ChosaItemJohoTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString shinseishoKanriNo;
    @TempTableColumnOrder(2)
    private RString koroshoIfShikibetsuCode;
    @TempTableColumnOrder(3)
    private RString remban1;
    @TempTableColumnOrder(4)
    private RString remban2;
    @TempTableColumnOrder(5)
    private RString remban3;
    @TempTableColumnOrder(6)
    private RString remban4;
    @TempTableColumnOrder(7)
    private RString remban5;
    @TempTableColumnOrder(8)
    private RString remban6;
    @TempTableColumnOrder(9)
    private RString remban7;
    @TempTableColumnOrder(10)
    private RString remban8;
    @TempTableColumnOrder(11)
    private RString remban9;
    @TempTableColumnOrder(12)
    private RString remban10;
    @TempTableColumnOrder(13)
    private RString remban11;
    @TempTableColumnOrder(14)
    private RString remban12;
    @TempTableColumnOrder(15)
    private RString remban13;
    @TempTableColumnOrder(16)
    private RString remban14;
    @TempTableColumnOrder(17)
    private RString remban15;
    @TempTableColumnOrder(18)
    private RString remban16;
    @TempTableColumnOrder(19)
    private RString remban17;
    @TempTableColumnOrder(20)
    private RString remban18;
    @TempTableColumnOrder(21)
    private RString remban19;
    @TempTableColumnOrder(22)
    private RString remban20;
    @TempTableColumnOrder(23)
    private RString remban21;
    @TempTableColumnOrder(24)
    private RString remban22;
    @TempTableColumnOrder(25)
    private RString remban23;
    @TempTableColumnOrder(26)
    private RString remban24;
    @TempTableColumnOrder(27)
    private RString remban25;
    @TempTableColumnOrder(28)
    private RString remban26;
    @TempTableColumnOrder(29)
    private RString remban27;
    @TempTableColumnOrder(30)
    private RString remban28;
    @TempTableColumnOrder(31)
    private RString remban29;
    @TempTableColumnOrder(32)
    private RString remban30;
    @TempTableColumnOrder(33)
    private RString remban31;
    @TempTableColumnOrder(34)
    private RString remban32;
    @TempTableColumnOrder(35)
    private RString remban33;
    @TempTableColumnOrder(36)
    private RString remban34;
    @TempTableColumnOrder(37)
    private RString remban35;
    @TempTableColumnOrder(38)
    private RString remban36;
    @TempTableColumnOrder(39)
    private RString remban37;
    @TempTableColumnOrder(40)
    private RString remban38;
    @TempTableColumnOrder(41)
    private RString remban39;
    @TempTableColumnOrder(42)
    private RString remban40;
    @TempTableColumnOrder(43)
    private RString remban41;
    @TempTableColumnOrder(44)
    private RString remban42;
    @TempTableColumnOrder(45)
    private RString remban43;
    @TempTableColumnOrder(46)
    private RString remban44;
    @TempTableColumnOrder(47)
    private RString remban45;
    @TempTableColumnOrder(48)
    private RString remban46;
    @TempTableColumnOrder(49)
    private RString remban47;
    @TempTableColumnOrder(50)
    private RString remban48;
    @TempTableColumnOrder(51)
    private RString remban49;
    @TempTableColumnOrder(52)
    private RString remban50;
    @TempTableColumnOrder(53)
    private RString remban51;
    @TempTableColumnOrder(54)
    private RString remban52;
    @TempTableColumnOrder(55)
    private RString remban53;
    @TempTableColumnOrder(56)
    private RString remban54;
    @TempTableColumnOrder(57)
    private RString remban55;
    @TempTableColumnOrder(58)
    private RString remban56;
    @TempTableColumnOrder(59)
    private RString remban57;
    @TempTableColumnOrder(60)
    private RString remban58;
    @TempTableColumnOrder(61)
    private RString remban59;
    @TempTableColumnOrder(62)
    private RString remban60;
    @TempTableColumnOrder(63)
    private RString remban61;
    @TempTableColumnOrder(64)
    private RString remban62;
    @TempTableColumnOrder(65)
    private RString remban63;
    @TempTableColumnOrder(66)
    private RString remban64;
    @TempTableColumnOrder(67)
    private RString remban65;
    @TempTableColumnOrder(68)
    private RString remban66;
    @TempTableColumnOrder(69)
    private RString remban67;
    @TempTableColumnOrder(70)
    private RString remban68;
    @TempTableColumnOrder(71)
    private RString remban69;
    @TempTableColumnOrder(72)
    private RString remban70;
    @TempTableColumnOrder(73)
    private RString remban71;
    @TempTableColumnOrder(74)
    private RString remban72;
    @TempTableColumnOrder(75)
    private RString remban73;
    @TempTableColumnOrder(76)
    private RString remban74;
    @TempTableColumnOrder(77)
    private RString remban75;
    @TempTableColumnOrder(78)
    private RString remban76;
    @TempTableColumnOrder(79)
    private RString remban77;
    @TempTableColumnOrder(80)
    private RString remban78;
    @TempTableColumnOrder(81)
    private RString remban79;
    @TempTableColumnOrder(82)
    private RString remban80;
    @TempTableColumnOrder(83)
    private RString remban81;
    @TempTableColumnOrder(84)
    private RString remban82;
    @TempTableColumnOrder(85)
    private RString remban83;
    @TempTableColumnOrder(86)
    private RString remban84;
    @TempTableColumnOrder(87)
    private RString remban85;
}
