/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
public class HihokenshaAndHenkanBangoEntity extends DbWT0001HihokenshaTempEntity {

    private LasdecCode shichosonCode2;
    private RString shinNo;
    private RString kyuNo;
    private LasdecCode kyuShichosonCode;

}
