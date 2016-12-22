/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.csv.imageinput;

import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n2818
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageInputCsvEntity {

    @FldField(order = 1, length = 3)
    private RString ID;
    @FldField(order = 2, length = 16)
    private RString ナンバリング;
    @FldField(order = 3, length = 6)
    private RString 保険者番号;
    @FldField(order = 4, length = 6)
    private RString 申請日;
    @FldField(order = 5, length = 10)
    private RString 被保険者番号;
    @FldField(order = 6, length = 1)
    private RString 同意の有無;
    @FldField(order = 7, length = 6)
    private RString 最終診察日;
    @FldField(order = 8, length = 6)
    private RString 記入日;
    @FldField(order = 9, length = 6)
    private RString 受領日;
    @FldField(order = 10, length = 1)
    private RString 意見書作成回数;
    @FldField(order = 11, length = 1)
    private RString 他科受診の有無;
    @FldField(order = 12, length = 13)
    private RString 記入のあった科;
    @FldField(order = 13, length = 1)
    private RString 発症年月日１和暦;
    @FldField(order = 14, length = 6)
    private RString 発症年月日１;
    @FldField(order = 15, length = 1)
    private RString 発症年月日２和暦;
    @FldField(order = 16, length = 6)
    private RString 発症年月日２;
    @FldField(order = 17, length = 1)
    private RString 発症年月日３和暦;
    @FldField(order = 18, length = 6)
    private RString 発症年月日３;
    @FldField(order = 19, length = 1)
    private RString 症状の安定性;
    @FldField(order = 20, length = 9)
    private RString 処置内容;
    @FldField(order = 21, length = 2)
    private RString 特別な対応;
    @FldField(order = 22, length = 1)
    private RString カテーテル;
    @FldField(order = 23, length = 1)
    private RString 障害高齢者の自立度;
    @FldField(order = 24, length = 1)
    private RString 認知症高齢者の自立度;
    @FldField(order = 25, length = 1)
    private RString 短期記憶;
    @FldField(order = 26, length = 1)
    private RString 認知能力;
    @FldField(order = 27, length = 1)
    private RString 伝達能力;
    @FldField(order = 28, length = 1)
    private RString 問題行動の有無;
    @FldField(order = 29, length = 12)
    private RString 問題行動;
    @FldField(order = 30, length = 1)
    private RString 精神神経症状;
    @FldField(order = 31, length = 1)
    private RString 専門科医受診;
}
