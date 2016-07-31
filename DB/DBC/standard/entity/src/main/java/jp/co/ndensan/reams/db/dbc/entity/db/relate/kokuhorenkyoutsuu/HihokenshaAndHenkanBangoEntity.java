/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者一時TBLと新旧被保険者番号変換TBL並びエンティティです。
 *
 * @reamsid_L DBC-0980-560 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaAndHenkanBangoEntity {

    private int 連番;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate サービス提供年月末日;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private LasdecCode 旧市町村コード;
    private HihokenshaNo 変換被保険者番号;
    private HihokenshaNo 登録被保険者番号;
    private LasdecCode 市町村コード;
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
    private FlexibleDate 資格取得日;
    private RString 資格取得事由コード;
    private FlexibleDate 資格喪失日;
    private RString 資格喪失事由コード;
    private RString 世帯集約番号;
    private LasdecCode shichosonCode2;
    private RString shinNo;
    private RString kyuNo;
    private LasdecCode kyuShichosonCode;

}
