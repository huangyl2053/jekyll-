/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokuchoSofuJohoRenkeiDataEntity {

    @FldField(order = 16, length = 1)
    private RString データレコード区分;
    @FldField(order = 17, length = 5)
    private RString データ市町村コード;
    @FldField(order = 18, length = 3)
    private RString データ特別徴収義務者コード;
    @FldField(order = 19, length = 2)
    private RString データ通知内容コード;
    @FldField(order = 20, length = 2)
    private RString データ予備1;
    @FldField(order = 21, length = 1)
    private RString データ特別徴収制度コード;
    @FldField(order = 22, length = 8)
    private RString データ作成年月日;
    @FldField(order = 23, length = 10)
    private RString データ基礎年金番号;
    @FldField(order = 24, length = 4)
    private RString データ年金コード;
    @FldField(order = 25, length = 3)
    private RString データ予備2;
    @FldField(order = 26, length = 8)
    private RString データ生年月日;
    @FldField(order = 27, length = 1)
    private RString データ性別;
    @FldField(order = 28, length = 25)
    private RString データ氏名カナ;
    @FldField(order = 29, length = 3)
    private RString データ氏名シフトコード1;
    @FldField(order = 30, length = 50)
    private RString データ氏名漢字1;
    @FldField(order = 31, length = 3)
    private RString データ氏名シフトコード2;
    @FldField(order = 32, length = 7)
    private RString データ住所郵便番号;
    @FldField(order = 33, length = 80)
    private RString データ住所カナ;
    @FldField(order = 34, length = 3)
    private RString データ住所シフトコード3;
    @FldField(order = 35, length = 160)
    private RString データ住所漢字2;
    @FldField(order = 36, length = 3)
    private RString データ住所シフトコード4;
    @FldField(order = 37, length = 2)
    private RString データ各種区分;
    @FldField(order = 38, length = 2)
    private RString データ処理結果;
    @FldField(order = 39, length = 1)
    private RString データ後期移管コード;
    @FldField(order = 40, length = 8)
    private RString データ各種年月日;
    @FldField(order = 41, length = 11)
    private RString データ各種金額欄金額1;
    @FldField(order = 42, length = 11)
    private RString データ各種金額欄金額2;
    @FldField(order = 43, length = 11)
    private RString データ各種金額欄金額3;
    @FldField(order = 44, length = 58)
    private RString データ予備3;
    @FldField(order = 45, length = 15)
    private RString データ共済年金証書記号番号;
    @FldField(order = 46, length = 10)
    private RString データ介護保険被保険者番号;
    @FldField(order = 47, length = 1)
    private RString データ個人コード区分;
    @FldField(order = 48, length = 16)
    private RString データ個人コード;
    @FldField(order = 49, length = 1)
    private RString データ介護保険住所地特例区分;
    @FldField(order = 50, length = 8)
    private RString データ捕捉年月日;
    @FldField(order = 51, length = 1)
    private RString データ待機フラグ;
    @FldField(order = 52, length = 13)
    private RString データ予備;

    /**
     * コンストラクタです。
     *
     * @param データレコード区分 RString
     * @param データ市町村コード RString
     * @param データ特別徴収義務者コード RString
     * @param データ通知内容コード RString
     * @param データ予備1 RString
     * @param データ特別徴収制度コード RString
     * @param データ作成年月日 RString
     * @param データ基礎年金番号 RString
     * @param データ年金コード RString
     * @param データ予備2 RString
     * @param データ生年月日 RString
     * @param データ性別 RString
     * @param データ氏名カナ RString
     * @param データ氏名シフトコード1 RString
     * @param データ氏名漢字1 RString
     * @param データ氏名シフトコード2 RString
     * @param データ住所郵便番号 RString
     * @param データ住所カナ RString
     * @param データ住所シフトコード3 RString
     * @param データ住所漢字2 RString
     * @param データ住所シフトコード4 RString
     * @param データ各種区分 RString
     * @param データ処理結果 RString
     * @param データ後期移管コード RString
     * @param データ各種年月日 RString
     * @param データ各種金額欄金額1 RString
     * @param データ各種金額欄金額2 RString
     * @param データ各種金額欄金額3 RString
     * @param データ予備3 RString
     * @param データ共済年金証書記号番号 RString
     */
    public TokuchoSofuJohoRenkeiDataEntity(RString データレコード区分, RString データ市町村コード, RString データ特別徴収義務者コード,
            RString データ通知内容コード, RString データ予備1, RString データ特別徴収制度コード, RString データ作成年月日, RString データ基礎年金番号,
            RString データ年金コード, RString データ予備2, RString データ生年月日, RString データ性別, RString データ氏名カナ,
            RString データ氏名シフトコード1, RString データ氏名漢字1, RString データ氏名シフトコード2, RString データ住所郵便番号, RString データ住所カナ,
            RString データ住所シフトコード3, RString データ住所漢字2, RString データ住所シフトコード4, RString データ各種区分, RString データ処理結果,
            RString データ後期移管コード, RString データ各種年月日, RString データ各種金額欄金額1, RString データ各種金額欄金額2,
            RString データ各種金額欄金額3, RString データ予備3, RString データ共済年金証書記号番号) {
        this.データレコード区分 = データレコード区分;
        this.データ市町村コード = データ市町村コード;
        this.データ特別徴収義務者コード = データ特別徴収義務者コード;
        this.データ通知内容コード = データ通知内容コード;
        this.データ予備1 = データ予備1;
        this.データ特別徴収制度コード = データ特別徴収制度コード;
        this.データ作成年月日 = データ作成年月日;
        this.データ基礎年金番号 = データ基礎年金番号;
        this.データ年金コード = データ年金コード;
        this.データ予備2 = データ予備2;
        this.データ生年月日 = データ生年月日;
        this.データ性別 = データ性別;
        this.データ氏名カナ = データ氏名カナ;
        this.データ氏名シフトコード1 = データ氏名シフトコード1;
        this.データ氏名漢字1 = データ氏名漢字1;
        this.データ氏名シフトコード2 = データ氏名シフトコード2;
        this.データ住所郵便番号 = データ住所郵便番号;
        this.データ住所カナ = データ住所カナ;
        this.データ住所シフトコード3 = データ住所シフトコード3;
        this.データ住所漢字2 = データ住所漢字2;
        this.データ住所シフトコード4 = データ住所シフトコード4;
        this.データ各種区分 = データ各種区分;
        this.データ処理結果 = データ処理結果;
        this.データ後期移管コード = データ後期移管コード;
        this.データ各種年月日 = データ各種年月日;
        this.データ各種金額欄金額1 = データ各種金額欄金額1;
        this.データ各種金額欄金額2 = データ各種金額欄金額2;
        this.データ各種金額欄金額3 = データ各種金額欄金額3;
        this.データ予備3 = データ予備3;
        this.データ共済年金証書記号番号 = データ共済年金証書記号番号;
    }

    /**
     * コンストラクタです。
     *
     * @param データレコード区分 RString
     * @param データ市町村コード RString
     * @param データ特別徴収義務者コード RString
     * @param データ通知内容コード RString
     * @param データ予備1 RString
     * @param データ特別徴収制度コード RString
     * @param データ作成年月日 RString
     * @param データ基礎年金番号 RString
     * @param データ年金コード RString
     * @param データ予備2 RString
     * @param データ生年月日 RString
     * @param データ性別 RString
     * @param データ氏名カナ RString
     * @param データ氏名シフトコード1 RString
     * @param データ氏名漢字1 RString
     * @param データ氏名シフトコード2 RString
     * @param データ住所郵便番号 RString
     * @param データ住所カナ RString
     * @param データ住所シフトコード3 RString
     * @param データ住所漢字2 RString
     * @param データ住所シフトコード4 RString
     * @param データ各種区分 RString
     * @param データ処理結果 RString
     * @param データ後期移管コード RString
     * @param データ各種年月日 RString
     * @param データ各種金額欄金額1 RString
     * @param データ各種金額欄金額2 RString
     * @param データ各種金額欄金額3 RString
     * @param データ共済年金証書記号番号 RString
     * @param データ介護保険被保険者番号 RString
     * @param データ個人コード区分 RString
     * @param データ個人コード RString
     * @param データ介護保険住所地特例区分 RString
     * @param データ捕捉年月日 RString
     * @param データ待機フラグ RString
     * @param データ予備 RString
     */
    public TokuchoSofuJohoRenkeiDataEntity(RString データレコード区分, RString データ市町村コード, RString データ特別徴収義務者コード,
            RString データ通知内容コード, RString データ予備1, RString データ特別徴収制度コード, RString データ作成年月日,
            RString データ基礎年金番号, RString データ年金コード, RString データ予備2, RString データ生年月日, RString データ性別,
            RString データ氏名カナ, RString データ氏名シフトコード1, RString データ氏名漢字1, RString データ氏名シフトコード2,
            RString データ住所郵便番号, RString データ住所カナ, RString データ住所シフトコード3, RString データ住所漢字2,
            RString データ住所シフトコード4, RString データ各種区分, RString データ処理結果, RString データ後期移管コード,
            RString データ各種年月日, RString データ各種金額欄金額1, RString データ各種金額欄金額2, RString データ各種金額欄金額3,
            RString データ共済年金証書記号番号, RString データ介護保険被保険者番号, RString データ個人コード区分,
            RString データ個人コード, RString データ介護保険住所地特例区分, RString データ捕捉年月日, RString データ待機フラグ, RString データ予備) {
        this.データレコード区分 = データレコード区分;
        this.データ市町村コード = データ市町村コード;
        this.データ特別徴収義務者コード = データ特別徴収義務者コード;
        this.データ通知内容コード = データ通知内容コード;
        this.データ予備1 = データ予備1;
        this.データ特別徴収制度コード = データ特別徴収制度コード;
        this.データ作成年月日 = データ作成年月日;
        this.データ基礎年金番号 = データ基礎年金番号;
        this.データ年金コード = データ年金コード;
        this.データ予備2 = データ予備2;
        this.データ生年月日 = データ生年月日;
        this.データ性別 = データ性別;
        this.データ氏名カナ = データ氏名カナ;
        this.データ氏名シフトコード1 = データ氏名シフトコード1;
        this.データ氏名漢字1 = データ氏名漢字1;
        this.データ氏名シフトコード2 = データ氏名シフトコード2;
        this.データ住所郵便番号 = データ住所郵便番号;
        this.データ住所カナ = データ住所カナ;
        this.データ住所シフトコード3 = データ住所シフトコード3;
        this.データ住所漢字2 = データ住所漢字2;
        this.データ住所シフトコード4 = データ住所シフトコード4;
        this.データ各種区分 = データ各種区分;
        this.データ処理結果 = データ処理結果;
        this.データ後期移管コード = データ後期移管コード;
        this.データ各種年月日 = データ各種年月日;
        this.データ各種金額欄金額1 = データ各種金額欄金額1;
        this.データ各種金額欄金額2 = データ各種金額欄金額2;
        this.データ各種金額欄金額3 = データ各種金額欄金額3;
        this.データ共済年金証書記号番号 = データ共済年金証書記号番号;
        this.データ介護保険被保険者番号 = データ介護保険被保険者番号;
        this.データ個人コード区分 = データ個人コード区分;
        this.データ個人コード = データ個人コード;
        this.データ介護保険住所地特例区分 = データ介護保険住所地特例区分;
        this.データ捕捉年月日 = データ捕捉年月日;
        this.データ待機フラグ = データ待機フラグ;
        this.データ予備 = データ予備;
    }
}
