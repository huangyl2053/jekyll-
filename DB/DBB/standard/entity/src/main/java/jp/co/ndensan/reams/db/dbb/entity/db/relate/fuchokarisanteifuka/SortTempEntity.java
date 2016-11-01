/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 出力順TempのEntity。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SortTempEntity extends DbTableEntityBase<SortTempEntity>
        implements IDbAccessable {

    private TsuchishoNo tsuchishoNo;
    private RString choshuHoho;
    private RString tkKaishiM;

}
