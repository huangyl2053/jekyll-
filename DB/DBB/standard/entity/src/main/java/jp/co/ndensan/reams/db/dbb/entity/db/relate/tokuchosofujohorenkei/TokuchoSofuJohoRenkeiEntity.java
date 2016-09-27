/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosofujohorenkei;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴送付情報連携Entityクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoSofuJohoRenkeiEntity {

    private RString 構成市町村コード;
    private RString 処理対象年月;
    private RString 市町村コードDT;
    private Code 特別徴収義務者コードDT;
    private RString 特別徴収制度コードDT;
    private RString 媒体コードDT;
    private RString 通知内容コードDT;
    private RString 作成年月日DT;
    private RString 基礎年金番号DT;
    private RString 年金コードDT;
    private RString 生年月日DT;
    private RString 性別DT;
    private RString カナ氏名DT;
    private RString シフトコード1DT;
    private RString 漢字氏名DT;
    private RString シフトコード2DT;
    private RString 郵便番号DT;
    private RString カナ住民DT;
    private RString シフトコード3DT;
    private RString 漢字住所DT;
    private RString シフトコード4DT;
    private RString 各種区分DT;
    private RString 処理結果DT;
    private RString 各種年月日DT;
    private RString 各種金額欄1DT;
    private RString 各種金額欄2DT;
    private RString 各種金額欄3DT;
    private RString 共済年金証記号番号DT;
    private RString 後期移管コードDT;
    private RString 予備1DT;
    private RString 予備2DT;
    private RString 介護保険被保険者番号;
    private RString 個人コード区分;
    private RString 個人コード;
    private RString 介護保険住所地特例区分;
    private RString 捕捉年月日;
    private RString 待機フラグ;
    private RString 予備;

}
