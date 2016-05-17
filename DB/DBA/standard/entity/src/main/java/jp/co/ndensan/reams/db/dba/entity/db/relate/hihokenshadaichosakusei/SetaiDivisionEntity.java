/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 分割した世帯一覧情報のエンティティクラスです。
 *
 * @reamsid_L DBA-0500-010 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiDivisionEntity {

    private List<RString> 世帯左No;
    private List<ShikibetsuCode> 世帯左識別コード;
    private List<RString> 氏名;
    private List<RString> 世帯性別;
    private List<RString> 世帯生年月日;
    private List<RString> 世帯続柄;
    private List<HihokenshaNo> 世帯被保険者番号;
}
