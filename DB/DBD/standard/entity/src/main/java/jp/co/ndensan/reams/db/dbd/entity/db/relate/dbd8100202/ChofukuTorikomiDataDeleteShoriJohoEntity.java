/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 重複取込データ除外処理SQL検索結果Entityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChofukuTorikomiDataDeleteShoriJohoEntity {

    private int 連番;
    private RString DTレコード区分;
    private RString DT市町村コード;
    private RString DT年金保険者コード;
    private RString DT通知内容コード;
    private RString DT予備1;
    private RString DT制度コード;
    private RString DT作成年月日;
    private RString DT基礎年金番号;
    private RString DT年金コード;
    private RString DT予備2;
    private RString DT生年月日;
    private RString DT性別;
    private RString DTカナ氏名;
    private RString DTシフトコード1;
    private RString DT漢字氏名;
    private RString DTシフトコード2;
    private RString DT郵便番号;
    private RString DTカナ住所;
    private RString DTシフトコード3;
    private RString DT漢字住所;
    private RString DTシフトコード4;
    private RString DT対象年;
    private RString DT訂正表示;
    private RString DT各種区分;
    private RString DT処理結果;
    private RString DT予備3;
    private RString DT予備4;
    private RString DT金額1;
    private RString DT金額予備1;
    private RString DT金額予備2;
    private RString DT予備5;
    private RString DT共済年金証書記号番号;
    private HihokenshaNo 実績_被保険者番号;
    private RString 実績_宛名カナ氏名;
    private RString 実績_宛名生年月日;
    private RString 実績_宛名性別;
    private ShikibetsuCode 実績_識別コード;
    private RString 実績_世帯コード;
    private RString 実績_宛名漢字氏名;
    private RString 実績_宛名郵便番号;
    private RString 実績_宛名漢字住所;
    private RString 実績_年度;
    private RString 実績_処理区分;
    private RString 実績_対象月;
    private RString 実績_基礎年金番号;
    private RString 実績_現基礎年金番号;
    private RString 実績_年金コード;
    private RString 実績_登録区分;
    private RString 実績_DTレコード区分;
    private RString 実績_DT市町村コード;
    private RString 実績_DT年金保険者コード;
    private RString 実績_DT通知内容コード;
    private RString 実績_DT予備1;
    private RString 実績_DT制度コード;
    private RString 実績_DT作成年月日;
    private RString 実績_DT基礎年金番号;
    private RString 実績_DT年金コード;
    private RString 実績_DT予備2;
    private RString 実績_DT生年月日;
    private RString 実績_DT性別;
    private RString 実績_DTカナ氏名;
    private RString 実績_DTシフトコード1;
    private RString 実績_DT漢字氏名;
    private RString 実績_DTシフトコード2;
    private RString 実績_DT郵便番号;
    private RString 実績_DTカナ住所;
    private RString 実績_DTシフトコード3;
    private RString 実績_DT漢字住所;
    private RString 実績_DTシフトコード4;
    private RString 実績_DT対象年;
    private RString 実績_DT訂正表示;
    private RString 実績_DT各種区分;
    private RString 実績_DT処理結果;
    private RString 実績_DT予備3;
    private RString 実績_DT予備4;
    private RString 実績_DT金額1;
    private RString 実績_DT金額予備1;
    private RString 実績_DT金額予備2;
    private RString 実績_DT予備5;
    private RString 実績_DT共済年金証書記号番号;

    private RString 非課税_同定結果区分;
    private RString 非課税_不一致事由;
    private RString 非課税_該当事由;
    private RString 非課税_不一致項目;
    private RString 非課税_基礎年金番号変更;
    private HihokenshaNo 非課税_被保険者番号;
    private RString 非課税_宛名カナ氏名;
    private RString 非課税_宛名生年月日;
    private RString 非課税_宛名性別;
    private ShikibetsuCode 非課税_識別コード;
    private RString 非課税_世帯コード;
    private RString 非課税_年度;
    private RString 非課税_処理区分;
    private RString 非課税_対象月;
    private RString 非課税_基礎年金番号;
    private RString 非課税_現基礎年金番号;
    private RString 非課税_年金コード;
    private RString 非課税_登録区分;
    private RString 非課税_DTレコード区分;
    private RString 非課税_DT市町村コード;
    private RString 非課税_DT年金保険者コード;
    private RString 非課税_DT通知内容コード;
    private RString 非課税_DT予備1;
    private RString 非課税_DT制度コード;
    private RString 非課税_DT作成年月日;
    private RString 非課税_DT基礎年金番号;
    private RString 非課税_DT年金コード;
    private RString 非課税_DT予備2;
    private RString 非課税_DT生年月日;
    private RString 非課税_DT性別;
    private RString 非課税_DTカナ氏名;
    private RString 非課税_DTシフトコード1;
    private RString 非課税_DT漢字氏名;
    private RString 非課税_DTシフトコード2;
    private RString 非課税_DT郵便番号;
    private RString 非課税_DTカナ住所;
    private RString 非課税_DTシフトコード3;
    private RString 非課税_DT漢字住所;
    private RString 非課税_DTシフトコード4;
    private RString 非課税_DT対象年;
    private RString 非課税_DT訂正表示;
    private RString 非課税_DT各種区分;
    private RString 非課税_DT処理結果;
    private RString 非課税_DT予備3;
    private RString 非課税_DT予備4;
    private RString 非課税_DT金額1;
    private RString 非課税_DT金額予備1;
    private RString 非課税_DT金額予備2;
    private RString 非課税_DT予備5;
    private RString 非課税_DT共済年金証書記号番号;
}
