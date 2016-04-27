/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaishadaichojoho;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 適用除外者台帳情報RelateEntityクラスです。
 *
 * @reamsid_L DBA-0412-010 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyoJogaishaDaichoJohoRelateEntity {

    private RString 印刷日時;
    private int ページ目;
    private RString タイトル;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 状態;
    private RString 電話番号タイトル;
    private RString 電話番号１;
    private RString 電話番号２;
    private RString 生年月日;
    private RString 性別;
    private RString 世帯コード;
    private RString 識別コード;
    private RString 氏名カナ;
    private RString 氏名;
    private RString 地区コード1;
    private RString 地区タイトル1;
    private RString 地区コード2;
    private RString 地区タイトル2;
    private RString 地区コード3;
    private RString 地区タイトル3;
    private RString 住所1;
    private RString 住所タイトル1;
    private RString 住所コード;
    private RString 行政区タイトル;
    private RString 行政区コード;
    private RString 住所2;
    private RString 住所タイトル2;
    private RString 住所コード2;
    private int 連番;
    private RString 適用年月日;
    private RString 適用届出年月日;
    private RString 適用除外適用事由コード;
    private RString 適用除外適用事由名称;
    private RString 解除年月日;
    private RString 解除届出年月日;
    private RString 適用除外解除事由コード;
    private RString 適用除外解除事由名称;
    private RString 入所年月日;
    private RString 退所年月日;
    private AtenaMeisho 事業者名称;
    private RString 事業者住所;
    private TelNo 電話番号;
    private RString 郵便番号;

}
