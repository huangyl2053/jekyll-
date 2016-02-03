/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.insuranceinformation;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 遷移先渡す項目のエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsuranceInformationEntity implements Serializable {

    private FlexibleYear 報告年;
    private FlexibleYear 集計対象年;
    private RString 統計対象区分;
    private LasdecCode 市町村コード;
    private Code 表番号;
    private RString 処理フラグ;
    private ShoKisaiHokenshaNo 保険者コード;
    private RString 市町村名称;
    private RString 様式４入力状況;
    private RString 様式４の２入力状況;
    private RString 様式４の３入力状況;

}
