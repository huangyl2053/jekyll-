/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 非課税年金対象者情報一覧CSV用のデータ取得Entityクラスです．
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeiNennkinTaishouSyaJohoListCsvResultEntity {

    private int 連番;
    private RString dtレコード区分;
    private RString dt市町村コード;
    private RString dt年金保険者コード;
    private RString dt通知内容コード;
    private RString dt予備1;
    private RString dt制度コード;
    private RString dt作成年月日;
    private RString dt基礎年金番号;
    private RString dt年金コード;
    private RString dt予備2;
    private RString dt生年月日;
    private RString dt性別;
    private RString dtカナ氏名;
    private RString dtシフトコード1;
    private RString dt漢字氏名;
    private RString dtシフトコード2;
    private RString dt郵便番号;
    private RString dtカナ住所;
    private RString dtシフトコード3;
    private RString dt漢字住所;
    private RString dtシフトコード4;
    private RString dt対象年;
    private RString dt訂正表示;
    private RString dt各種区分;
    private RString dt処理結果;
    private RString dt予備3;
    private RString dt予備4;
    private Decimal dt金額1;
    private Decimal dt金額予備1;
    private Decimal dt金額予備2;
    private RString dt予備5;
    private RString dt共済年金証書記号番号;
}
