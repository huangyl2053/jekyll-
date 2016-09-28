/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表のEntityクラスです。
 *
 * @reamsid_L DBC-3500-050 jinjue
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoJokyoTokeihyoShukeiKekkaEntity {

    private Code 処理市町村コード;
    private RString 処理市町村名;
    private List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 旧市町村コード;
    private RString 旧市町村名;
    private RDateTime 作成日時;
}
