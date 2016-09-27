/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 要介護認定インターフェースマスタルEntity
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoninteiIntafesumasutaEntity extends DbTableEntityBase<NinteiKekkaIchijiTeburuEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("YokaigoninteiIntafesumasutaTemp"));
    }

    @TempTableColumnOrder(1)
    private RString hihokenjabango;
    @TempTableColumnOrder(2)
    private RString rirekibango;
    @TempTableColumnOrder(3)
    private RString torikominichiji;
    @TempTableColumnOrder(4)
    private RString torikomikubun;
    @TempTableColumnOrder(5)
    private Code shinseishubetsukodo;
    @TempTableColumnOrder(6)
    private Code torisakubunkodo;
    @TempTableColumnOrder(7)
    private FlexibleDate ninteiYMD;
    @TempTableColumnOrder(8)
    private RString iryokikankodo;
    @TempTableColumnOrder(9)
    private RString shujiikodo;
    @TempTableColumnOrder(10)
    private FlexibleDate ikenshoiraiYMD;
    @TempTableColumnOrder(11)
    private FlexibleDate ikenshotoriyoseYMD;
    @TempTableColumnOrder(12)
    private FlexibleDate chosaitakuYMD;
    @TempTableColumnOrder(13)
    private FlexibleDate chosashuryoYMD;
    @TempTableColumnOrder(14)
    private RString chosaitakusakikodo;
    @TempTableColumnOrder(15)
    private RString chosainkodo;
    @TempTableColumnOrder(16)
    private FlexibleDate ichijihanteibi;
    @TempTableColumnOrder(17)
    private RString ichijihanteikekka;
    @TempTableColumnOrder(18)
    private RString ichijihanteikekka_omomi;
    @TempTableColumnOrder(19)
    private FlexibleDate shinsakaishiryosakuseinengappi;
    @TempTableColumnOrder(20)
    private FlexibleDate shinsakaiyoteinengappi;
    @TempTableColumnOrder(21)
    private RString gogitaibango;
    @TempTableColumnOrder(22)
    private FlexibleDate nijihanteibi;
    @TempTableColumnOrder(23)
    private RString nijihanteikekka;
    @TempTableColumnOrder(24)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(25)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(26)
    private Code sabisuhenkoriyukodo;
    @TempTableColumnOrder(27)
    private Code tokuteishippeikodo;
    @TempTableColumnOrder(28)
    private RString shogaikoreishajiritsudo;
    @TempTableColumnOrder(29)
    private RString ninshishokoreishajiritsudo;
    @TempTableColumnOrder(30)
    private RString shinsakaiiken;
    @TempTableColumnOrder(31)
    private ShikibetsuCode hanbango;
    @TempTableColumnOrder(32)
    private RString ichijihanteinaiyo;
    @TempTableColumnOrder(33)
    private RString ichijihanteinaiyo2;
    @TempTableColumnOrder(34)
    private RString zenkaitorikominichiji;
    @TempTableColumnOrder(35)
    private RString keshigomufuragu;
    @TempTableColumnOrder(36)
    private RString keshigomunichiji;
    @TempTableColumnOrder(37)
    private RString yobikomoku1;
    @TempTableColumnOrder(38)
    private RString yobikomoku2;
    @TempTableColumnOrder(39)
    private RString yobikomoku3;
    @TempTableColumnOrder(40)
    private RString yobikomoku4;
    @TempTableColumnOrder(41)
    private RString yobikomoku5;
    @TempTableColumnOrder(42)
    private RString yobikubun1;
    @TempTableColumnOrder(43)
    private RString yobikubun2;
    @TempTableColumnOrder(44)
    private RString yobikubun3;
    @TempTableColumnOrder(45)
    private RString yobikubun4;
    @TempTableColumnOrder(46)
    private RString yobikubun5;
    @TempTableColumnOrder(47)
    private RString rizabu;

}
