/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200004_利用状況一覧表のEntityクラスです。
 *
 * @reamsid_L DBC-3500-040 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoJokyoIchiranEntity {

    private DbWT1513RiyoJokyoTokeihyoEntity 帳票出力対象データリスト;
    private List<RString> 並び順;
    private List<RString> 改頁;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 旧市町村コード;
    private RString 旧市町村名;
    private RString 明細合計出力区分;
}
