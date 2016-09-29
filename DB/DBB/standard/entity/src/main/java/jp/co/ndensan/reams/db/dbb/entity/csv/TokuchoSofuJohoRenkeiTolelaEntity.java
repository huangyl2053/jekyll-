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
public class TokuchoSofuJohoRenkeiTolelaEntity {

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
     * @param トレイラレコード区分 RString
     * @param トレイラ市町村コード RString
     * @param トレイラ特別徴収義務者コード RString
     * @param トレイラ通知内容コード RString
     * @param トレイラ予備1 RString
     * @param トレイラ特別徴収制度コード RString
     * @param トレイラ作成年月日 RString
     * @param トレイラレコード件数 RString
     * @param トレイラ合計金額金額1 RString
     * @param トレイラ合計金額金額2 RString
     * @param トレイラ合計金額金額3 RString
     * @param トレイラ予備2 RString
     */
    public TokuchoSofuJohoRenkeiTolelaEntity(RString トレイラレコード区分, RString トレイラ市町村コード, RString トレイラ特別徴収義務者コード,
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
