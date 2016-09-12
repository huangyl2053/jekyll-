/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.keikakurirekiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 対象世帯員クラスの世帯員情報です
 *
 * @reamsid_L DBC-4640-080 liuxiaoyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeikakuRireki {

    private RString 暫定状態;
    private FlexibleDate 適用開始日;
    private FlexibleDate 適用終了日;
    private JigyoshaNo 計画事業者番号;
    private AtenaMeisho 計画事業者名称;
    private JigyoshaNo 委託先事業者番号;
    private AtenaMeisho 委託先事業者名称;

}
