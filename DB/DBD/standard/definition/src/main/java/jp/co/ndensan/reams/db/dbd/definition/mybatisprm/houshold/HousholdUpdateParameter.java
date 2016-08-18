/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.houshold;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者情報登録のMyBatis保存処理用パラメータクラスです。
 *
 * @reamsid_L DBD-4930-010 wangjie2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HousholdUpdateParameter {

    private RString 基礎年金番号_キー;
    private int updateCount;
    private RString lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private RString 年金コード_キー;
    private RString 被保番号_キー;
    private RString 年金保険者コード_キー;
    private RString 作成年月日_キー;
    private RString 対象年_キー;
    private RString 年度;
    private RString 処理区分;
    private RString 対象月;
    private RString 基礎年金番号;
    private RString 現基礎年金番号;
    private RString 年金コード;
    private RString 被保険者番号;
    private RString 登録区分;
    private RString dtレコード区分;
    private RString dt市町村コード;
    private RString dt年金保険者コード;
    private RString dt通知内容コード;
    private RString dt予備１;
    private RString dt制度コード;
    private RString dt作成年月日;
    private RString dt基礎年金番号;
    private RString dt年金コード;
    private RString dt予備２;
    private RString dt生年月日;
    private RString dt性別;
    private RString dtカナ氏名;
    private RString dtシフトコード１;
    private RString dt漢字氏名;
    private RString dtシフトコード２;
    private RString dt郵便番号;
    private RString dtカナ住所;
    private RString dtシフトコード３;
    private RString dt漢字住所;
    private RString dtシフトコード４;
    private RString dt対象年;
    private RString dt訂正表示;
    private RString dt各種区分;
    private RString dt処理結果;
    private RString dt予備３;
    private RString dt予備４;
    private RString dt金額１;
    private RString dt金額予備１;
    private RString dt金額予備２;
    private RString dt予備５;
    private RString dt共済年金証書記号番号;

}
