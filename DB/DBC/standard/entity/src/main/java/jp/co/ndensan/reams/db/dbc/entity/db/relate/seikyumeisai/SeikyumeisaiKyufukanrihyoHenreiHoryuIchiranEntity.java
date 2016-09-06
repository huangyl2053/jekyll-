/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyumeisai;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 請求明細・給付管理票返戻（保留）一覧表のEntityです。
 *
 * @reamsid_L DBC-2830-030 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity {

    private RString 履歴番号_請求;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 審査年月;
    private RString 国保連合会名;
    private RString 連番_請求明細;
    private RString 履歴番号_請求明細;
    private RString 事業者番号;
    private RString 事業者名;
    private RString 種別;
    private RString サービス提供年月;
    private RString サービス種類コード;
    private RString サービス項目コード等;
    private int 単位数;
    private RString 事由;
    private RString 内容;
    private RString 備考;
    private RString 連番_被保険者;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString サービス提供年月末日;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private RString 旧市町村コード;
    private RString 変換被保険者番号;
    private RString 登録被保険者番号;
    private RString 市町村コード;
    private RString 管内管外区分;
    private RString 郵便番号;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 行政区名;
    private RString 住所;
    private RString 番地;
    private RString 方書;
    private RString 宛名カナ名称;
    private RString 宛名名称;
    private RString 氏名50音カナ;
    private RString 識別コード;
    private RString 資格取得日;
    private RString 資格取得事由コード;
    private RString 資格喪失日;
    private RString 資格喪失事由コード;
    private RString 世帯集約番号;
    private RString 出力順情報;
    private RDateTime 作成日時;
}
