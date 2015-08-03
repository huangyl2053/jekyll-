package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査票（基本調査）テーブルの項目定義クラスです。
 */
public enum DbT5203NinteichosahyoKihonChosa implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 要介護認定調査履歴番号
     * <br/>認定調査依頼情報
     */
    ninteichosaRirekiNo(5, 0),
    /**
     * 厚労省IF識別コード
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * 調査項目01
     */
    reserchItem01(1, 0),
    /**
     * 調査項目02
     */
    reserchItem02(1, 0),
    /**
     * 調査項目03
     */
    reserchItem03(1, 0),
    /**
     * 調査項目04
     */
    reserchItem04(1, 0),
    /**
     * 調査項目05
     */
    reserchItem05(1, 0),
    /**
     * 調査項目06
     */
    reserchItem06(1, 0),
    /**
     * 調査項目07
     */
    reserchItem07(1, 0),
    /**
     * 調査項目08
     */
    reserchItem08(1, 0),
    /**
     * 調査項目09
     */
    reserchItem09(1, 0),
    /**
     * 調査項目10
     */
    reserchItem10(1, 0),
    /**
     * 調査項目11
     */
    reserchItem11(1, 0),
    /**
     * 調査項目12
     */
    reserchItem12(1, 0),
    /**
     * 調査項目13
     */
    reserchItem13(1, 0),
    /**
     * 調査項目14
     */
    reserchItem14(1, 0),
    /**
     * 調査項目15
     */
    reserchItem15(1, 0),
    /**
     * 調査項目16
     */
    reserchItem16(1, 0),
    /**
     * 調査項目17
     */
    reserchItem17(1, 0),
    /**
     * 調査項目18
     */
    reserchItem18(1, 0),
    /**
     * 調査項目19
     */
    reserchItem19(1, 0),
    /**
     * 調査項目20
     */
    reserchItem20(1, 0),
    /**
     * 調査項目21
     */
    reserchItem21(1, 0),
    /**
     * 調査項目22
     */
    reserchItem22(1, 0),
    /**
     * 調査項目23
     */
    reserchItem23(1, 0),
    /**
     * 調査項目24
     */
    reserchItem24(1, 0),
    /**
     * 調査項目25
     */
    reserchItem25(1, 0),
    /**
     * 調査項目26
     */
    reserchItem26(1, 0),
    /**
     * 調査項目27
     */
    reserchItem27(1, 0),
    /**
     * 調査項目28
     */
    reserchItem28(1, 0),
    /**
     * 調査項目29
     */
    reserchItem29(1, 0),
    /**
     * 調査項目30
     */
    reserchItem30(1, 0),
    /**
     * 調査項目31
     */
    reserchItem31(1, 0),
    /**
     * 調査項目32
     */
    reserchItem32(1, 0),
    /**
     * 調査項目33
     */
    reserchItem33(1, 0),
    /**
     * 調査項目34
     */
    reserchItem34(1, 0),
    /**
     * 調査項目35
     */
    reserchItem35(1, 0),
    /**
     * 調査項目36
     */
    reserchItem36(1, 0),
    /**
     * 調査項目37
     */
    reserchItem37(1, 0),
    /**
     * 調査項目38
     */
    reserchItem38(1, 0),
    /**
     * 調査項目39
     */
    reserchItem39(1, 0),
    /**
     * 調査項目40
     */
    reserchItem40(1, 0),
    /**
     * 調査項目41
     */
    reserchItem41(1, 0),
    /**
     * 調査項目42
     */
    reserchItem42(1, 0),
    /**
     * 調査項目43
     */
    reserchItem43(1, 0),
    /**
     * 調査項目44
     */
    reserchItem44(1, 0),
    /**
     * 調査項目45
     */
    reserchItem45(1, 0),
    /**
     * 調査項目46
     */
    reserchItem46(1, 0),
    /**
     * 調査項目47
     */
    reserchItem47(1, 0),
    /**
     * 調査項目48
     */
    reserchItem48(1, 0),
    /**
     * 調査項目49
     */
    reserchItem49(1, 0),
    /**
     * 調査項目50
     */
    reserchItem50(1, 0),
    /**
     * 調査項目51
     */
    reserchItem51(1, 0),
    /**
     * 調査項目52
     */
    reserchItem52(1, 0),
    /**
     * 調査項目53
     */
    reserchItem53(1, 0),
    /**
     * 調査項目54
     */
    reserchItem54(1, 0),
    /**
     * 調査項目55
     */
    reserchItem55(1, 0),
    /**
     * 調査項目56
     */
    reserchItem56(1, 0),
    /**
     * 調査項目57
     */
    reserchItem57(1, 0),
    /**
     * 調査項目58
     */
    reserchItem58(1, 0),
    /**
     * 調査項目59
     */
    reserchItem59(1, 0),
    /**
     * 調査項目60
     */
    reserchItem60(1, 0),
    /**
     * 調査項目61
     */
    reserchItem61(1, 0),
    /**
     * 調査項目62
     */
    reserchItem62(1, 0),
    /**
     * 調査項目63
     */
    reserchItem63(1, 0),
    /**
     * 調査項目64
     */
    reserchItem64(1, 0),
    /**
     * 調査項目65
     */
    reserchItem65(1, 0),
    /**
     * 調査項目66
     */
    reserchItem66(1, 0),
    /**
     * 調査項目67
     */
    reserchItem67(1, 0),
    /**
     * 調査項目68
     */
    reserchItem68(1, 0),
    /**
     * 調査項目69
     */
    reserchItem69(1, 0),
    /**
     * 調査項目70
     */
    reserchItem70(1, 0),
    /**
     * 調査項目71
     */
    reserchItem71(1, 0),
    /**
     * 調査項目72
     */
    reserchItem72(1, 0),
    /**
     * 調査項目73
     */
    reserchItem73(1, 0),
    /**
     * 調査項目74
     */
    reserchItem74(1, 0),
    /**
     * 調査項目75
     */
    reserchItem75(1, 0),
    /**
     * 調査項目76
     */
    reserchItem76(1, 0),
    /**
     * 調査項目77
     */
    reserchItem77(1, 0),
    /**
     * 調査項目78
     */
    reserchItem78(1, 0),
    /**
     * 調査項目79
     */
    reserchItem79(1, 0),
    /**
     * 調査項目80
     */
    reserchItem80(1, 0),
    /**
     * 調査項目81
     */
    reserchItem81(1, 0),
    /**
     * 調査項目82
     */
    reserchItem82(1, 0),
    /**
     * 調査項目83
     */
    reserchItem83(1, 0),
    /**
     * 調査項目84
     */
    reserchItem84(1, 0),
    /**
     * 調査項目85
     */
    reserchItem85(1, 0),
    /**
     * 調査項目86
     */
    reserchItem86(1, 0),
    /**
     * 調査項目87
     */
    reserchItem87(1, 0),
    /**
     * 調査項目88
     */
    reserchItem88(1, 0),
    /**
     * 調査項目89
     */
    reserchItem89(1, 0),
    /**
     * 調査項目90
     */
    reserchItem90(1, 0),
    /**
     * 調査項目91
     */
    reserchItem91(1, 0),
    /**
     * 調査項目92
     */
    reserchItem92(1, 0),
    /**
     * 調査項目93
     */
    reserchItem93(1, 0),
    /**
     * 調査項目94
     */
    reserchItem94(1, 0),
    /**
     * 調査項目95
     */
    reserchItem95(1, 0),
    /**
     * 調査項目96
     */
    reserchItem96(1, 0),
    /**
     * 調査項目97
     */
    reserchItem97(1, 0),
    /**
     * 調査項目98
     */
    reserchItem98(1, 0),
    /**
     * 認定調査・認知症高齢者の日常生活自立度コード
     * <br/>Enum（DBE：認知症高齢者自立度コード）
     */
    ninchishoNichijoSeikatsuJiritsudoCode(2147483647, 0),
    /**
     * 認定調査・障害高齢者の日常生活自立度コード
     * <br/>Enum（DBE：障害高齢者自立度コード）
     */
    shogaiNichijoSeikatsuJiritsudoCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5203NinteichosahyoKihonChosa(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
