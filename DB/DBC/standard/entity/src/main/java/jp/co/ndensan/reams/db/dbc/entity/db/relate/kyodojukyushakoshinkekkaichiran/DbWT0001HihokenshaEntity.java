/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者一時TBLのEntityクラスです。
 *
 * @reamsid_L DBC-2780-030 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT0001HihokenshaEntity {

    private RString 連番;
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
}
