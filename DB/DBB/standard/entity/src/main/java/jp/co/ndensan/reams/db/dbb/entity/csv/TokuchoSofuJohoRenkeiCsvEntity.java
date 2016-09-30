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
public class TokuchoSofuJohoRenkeiCsvEntity {

    @FldField(order = 1, length = 5)
    private RString 管理市町村コード;
    @FldField(order = 2, length = 1)
    private RString 管理スペース;
    @FldField(order = 3, length = 3)
    private RString 管理媒体通番;
    @FldField(order = 4, length = 8)
    private RString 管理作成年月日;
    @FldField(order = 5, length = 31)
    private RString 管理予備;
    @FldField(order = 6, length = 6)
    private RString ファイル格納件数;
    @FldField(order = 7, length = 42)
    private RString ファイル管理予備;
    @FldField(order = 8, length = 1)
    private RString ヘッダレコード区分;
    @FldField(order = 9, length = 5)
    private RString ヘッダ市町村コード;
    @FldField(order = 10, length = 3)
    private RString ヘッダ特別徴収義務者コード;
    @FldField(order = 11, length = 2)
    private RString ヘッダ通知内容コード;
    @FldField(order = 12, length = 1)
    private RString ヘッダ媒体コード;
    @FldField(order = 13, length = 1)
    private RString ヘッダ特別徴収制度コード;
    @FldField(order = 14, length = 8)
    private RString ヘッダ作成年月日;
    @FldField(order = 15, length = 479)
    private RString ヘッダ予備;
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
    @FldField(order = 53, length = 1)
    private RString トレイラレコード区分;
    @FldField(order = 54, length = 5)
    private RString トレイラ市町村コード;
    @FldField(order = 55, length = 3)
    private RString トレイラ特別徴収義務者コード;
    @FldField(order = 56, length = 2)
    private RString トレイラ通知内容コード;
    @FldField(order = 57, length = 1)
    private RString トレイラ予備1;
    @FldField(order = 58, length = 1)
    private RString トレイラ特別徴収制度コード;
    @FldField(order = 59, length = 8)
    private RString トレイラ作成年月日;
    @FldField(order = 60, length = 9)
    private RString トレイラレコード件数;
    @FldField(order = 61, length = 11)
    private RString トレイラ合計金額金額1;
    @FldField(order = 62, length = 11)
    private RString トレイラ合計金額金額2;
    @FldField(order = 63, length = 11)
    private RString トレイラ合計金額金額3;
    @FldField(order = 64, length = 437)
    private RString トレイラ予備2;

    /**
     * コンストラクタです。
     *
     * @param 管理市町村コード 管理市町村コード
     * @param 管理スペース 管理スペース
     * @param 管理媒体通番 管理媒体通番
     * @param 管理作成年月日 管理作成年月日
     * @param 管理予備 管理予備
     * @param ファイル格納件数 ファイル格納件数
     * @param ファイル管理予備 ファイル管理予備
     */
    public TokuchoSofuJohoRenkeiCsvEntity(RString 管理市町村コード, RString 管理スペース, RString 管理媒体通番, RString 管理作成年月日,
            RString 管理予備, RString ファイル格納件数, RString ファイル管理予備) {
        this.管理市町村コード = 管理市町村コード;
        this.管理スペース = 管理スペース;
        this.管理媒体通番 = 管理媒体通番;
        this.管理作成年月日 = 管理作成年月日;
        this.管理予備 = 管理予備;
        this.ファイル格納件数 = ファイル格納件数;
        this.ファイル管理予備 = ファイル管理予備;
    }

    /**
     * コンストラクタです。
     *
     * @param ヘッダレコード区分 ヘッダレコード区分
     * @param ヘッダ市町村コード ヘッダ市町村コード
     * @param ヘッダ特別徴収義務者コード ヘッダ特別徴収義務者コード
     * @param ヘッダ通知内容コード ヘッダ通知内容コード
     * @param ヘッダ媒体コード ヘッダ媒体コード
     * @param ヘッダ特別徴収制度コード ヘッダ特別徴収制度コード
     * @param ヘッダ作成年月日 ヘッダ作成年月日
     * @param ヘッダ予備 ヘッダ予備
     */
    public TokuchoSofuJohoRenkeiCsvEntity(RString ヘッダレコード区分, RString ヘッダ市町村コード, RString ヘッダ特別徴収義務者コード,
            RString ヘッダ通知内容コード, RString ヘッダ媒体コード, RString ヘッダ特別徴収制度コード, RString ヘッダ作成年月日, RString ヘッダ予備) {
        this.ヘッダレコード区分 = ヘッダレコード区分;
        this.ヘッダ市町村コード = ヘッダ市町村コード;
        this.ヘッダ特別徴収義務者コード = ヘッダ特別徴収義務者コード;
        this.ヘッダ通知内容コード = ヘッダ通知内容コード;
        this.ヘッダ媒体コード = ヘッダ媒体コード;
        this.ヘッダ特別徴収制度コード = ヘッダ特別徴収制度コード;
        this.ヘッダ作成年月日 = ヘッダ作成年月日;
        this.ヘッダ予備 = ヘッダ予備;
    }

    /**
     * コンストラクタです。
     *
     * @param データレコード区分 データレコード区分
     * @param データ市町村コード データ市町村コード
     * @param データ特別徴収義務者コード データ特別徴収義務者コード
     * @param データ通知内容コード データ通知内容コード
     * @param データ予備1 データ予備1
     * @param データ特別徴収制度コード データ特別徴収制度コード
     * @param データ作成年月日 データ作成年月日
     * @param データ基礎年金番号 データ基礎年金番号
     * @param データ年金コード データ年金コード
     * @param データ予備2 データ予備2
     * @param データ生年月日 データ生年月日
     * @param データ性別 データ性別
     * @param データ氏名カナ データ氏名カナ
     * @param データ氏名シフトコード1 データ氏名シフトコード1
     * @param データ氏名漢字1 データ氏名漢字1
     * @param データ氏名シフトコード2 データ氏名シフトコード2
     * @param データ住所郵便番号 データ住所郵便番号
     * @param データ住所カナ データ住所カナ
     * @param データ住所シフトコード3 データ住所シフトコード3
     * @param データ住所漢字2 データ住所漢字2
     * @param データ住所シフトコード4 データ住所シフトコード4
     * @param データ各種区分 データ各種区分
     * @param データ処理結果 データ処理結果
     * @param データ後期移管コード データ後期移管コード
     * @param データ各種年月日 データ各種年月日
     * @param データ各種金額欄金額1 データ各種金額欄金額1
     * @param データ各種金額欄金額2 データ各種金額欄金額2
     * @param データ各種金額欄金額3 データ各種金額欄金額3
     * @param データ共済年金証書記号番号 データ共済年金証書記号番号
     */
    public TokuchoSofuJohoRenkeiCsvEntity(RString データレコード区分, RString データ市町村コード, RString データ特別徴収義務者コード,
            RString データ通知内容コード, RString データ予備1, RString データ特別徴収制度コード, RString データ作成年月日, RString データ基礎年金番号,
            RString データ年金コード, RString データ予備2, RString データ生年月日, RString データ性別, RString データ氏名カナ,
            RString データ氏名シフトコード1, RString データ氏名漢字1, RString データ氏名シフトコード2, RString データ住所郵便番号, RString データ住所カナ,
            RString データ住所シフトコード3, RString データ住所漢字2, RString データ住所シフトコード4, RString データ各種区分, RString データ処理結果,
            RString データ後期移管コード, RString データ各種年月日, RString データ各種金額欄金額1, RString データ各種金額欄金額2,
            RString データ各種金額欄金額3, RString データ共済年金証書記号番号) {
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
    }

    /**
     * コンストラクタです。
     *
     * @param データレコード区分 データレコード区分
     * @param データ市町村コード データ市町村コード
     * @param データ特別徴収義務者コード データ特別徴収義務者コード
     * @param データ通知内容コード データ通知内容コード
     * @param データ予備1 データ予備1
     * @param データ特別徴収制度コード データ特別徴収制度コード
     * @param データ作成年月日 データ作成年月日
     * @param データ基礎年金番号 データ基礎年金番号
     * @param データ年金コード データ年金コード
     * @param データ予備2 データ予備2
     * @param データ生年月日 データ生年月日
     * @param データ性別 データ性別
     * @param データ氏名カナ データ氏名カナ
     * @param データ氏名シフトコード1 データ氏名シフトコード1
     * @param データ氏名漢字1 データ氏名漢字1
     * @param データ氏名シフトコード2 データ氏名シフトコード2
     * @param データ住所郵便番号 データ住所郵便番号
     * @param データ住所カナ データ住所カナ
     * @param データ住所シフトコード3 データ住所シフトコード3
     * @param データ住所漢字2 データ住所漢字2
     * @param データ住所シフトコード4 データ住所シフトコード4
     * @param データ各種区分 データ各種区分
     * @param データ処理結果 データ処理結果
     * @param データ後期移管コード データ後期移管コード
     * @param データ各種年月日 データ各種年月日
     * @param データ各種金額欄金額1 データ各種金額欄金額1
     * @param データ各種金額欄金額2 データ各種金額欄金額2
     * @param データ各種金額欄金額3 データ各種金額欄金額3
     * @param データ共済年金証書記号番号 データ共済年金証書記号番号
     * @param データ介護保険被保険者番号 データ介護保険被保険者番号
     * @param データ個人コード区分 データ個人コード区分
     * @param データ個人コード データ個人コード
     * @param データ介護保険住所地特例区分 データ介護保険住所地特例区分
     * @param データ捕捉年月日 データ捕捉年月日
     * @param データ待機フラグ データ待機フラグ
     * @param データ予備 データ予備
     */
    public TokuchoSofuJohoRenkeiCsvEntity(RString データレコード区分, RString データ市町村コード, RString データ特別徴収義務者コード,
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

    /**
     * コンストラクタです。
     *
     * @param トレイラレコード区分 トレイラレコード区分
     * @param トレイラ市町村コード トレイラ市町村コード
     * @param トレイラ特別徴収義務者コード トレイラ特別徴収義務者コード
     * @param トレイラ通知内容コード トレイラ通知内容コード
     * @param トレイラ予備1 トレイラ予備1
     * @param トレイラ特別徴収制度コード トレイラ特別徴収制度コード
     * @param トレイラ作成年月日 トレイラ作成年月日
     * @param トレイラレコード件数 トレイラレコード件数
     * @param トレイラ合計金額金額1 トレイラ合計金額金額1
     * @param トレイラ合計金額金額2 トレイラ合計金額金額2
     * @param トレイラ合計金額金額3 トレイラ合計金額金額3
     * @param トレイラ予備2 トレイラ予備2
     */
    public TokuchoSofuJohoRenkeiCsvEntity(RString トレイラレコード区分, RString トレイラ市町村コード, RString トレイラ特別徴収義務者コード,
            RString トレイラ通知内容コード, RString トレイラ予備1, RString トレイラ特別徴収制度コード, RString トレイラ作成年月日,
            RString トレイラレコード件数, RString トレイラ合計金額金額1, RString トレイラ合計金額金額2, RString トレイラ合計金額金額3,
            RString トレイラ予備2) {
        this.トレイラレコード区分 = トレイラレコード区分;
        this.トレイラ市町村コード = トレイラ市町村コード;
        this.トレイラ特別徴収義務者コード = トレイラ特別徴収義務者コード;
        this.トレイラ通知内容コード = トレイラ通知内容コード;
        this.トレイラ予備1 = トレイラ予備1;
        this.トレイラ特別徴収制度コード = トレイラ特別徴収制度コード;
        this.トレイラ作成年月日 = トレイラ作成年月日;
        this.トレイラレコード件数 = トレイラレコード件数;
        this.トレイラ合計金額金額1 = トレイラ合計金額金額1;
        this.トレイラ合計金額金額2 = トレイラ合計金額金額2;
        this.トレイラ合計金額金額3 = トレイラ合計金額金額3;
        this.トレイラ予備2 = トレイラ予備2;
    }

}
