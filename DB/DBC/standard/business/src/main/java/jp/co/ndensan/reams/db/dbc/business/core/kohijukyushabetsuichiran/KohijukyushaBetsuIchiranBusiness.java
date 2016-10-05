/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kohijukyushabetsuichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費公費受給者別一覧表のBusinessです。
 *
 * @reamsid_L DBC-2800-030 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KohijukyushaBetsuIchiranBusiness {

    private RString 連番_公費受給者別明細;
    private RString 履歴番号_公費受給者別明細;
    private RString 公費受給者番号;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 事業所名;
    private RString サービスコード;
    private RString サービス種類名;
    private RString サービス項目名;
    private RString 日数回数;
    private int 公費対象単位数;
    private int 公費負担金額;
    private int 公費分本人負担額;
    private RString 履歴番号_公費受給者別集計;
    private RString 公費負担者番号;
    private RString 公費負担者名;
    private RString 審査年月;
    private RString 国保連合会名;
    private int 公費対象単位数集計;
    private int 公費負担金額集計;
    private int 公費分本人負担額集計;
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
    private RDateTime 作成日時;
    private IOutputOrder 出力順情報;
}
