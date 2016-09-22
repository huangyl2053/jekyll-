/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteihokenshain;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 再審査決定通知書情報取込（保険者分）のパラメータです。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaInParameter implements IMyBatisParameter {

    private RString 出力順;

}
