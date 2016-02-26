/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護保険特別会計経理状況登録遷移先渡す項目のエンティティクラスです。
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

    public InsuranceInformationEntity() {
    }

    public InsuranceInformationEntity(FlexibleYear 報告年,
            FlexibleYear 集計対象年,
            RString 統計対象区分,
            LasdecCode 市町村コード,
            Code 表番号, RString 処理フラグ,
            ShoKisaiHokenshaNo 保険者コード,
            RString 市町村名称,
            RString 様式４入力状況,
            RString 様式４の２入力状況,
            RString 様式４の３入力状況) {
        this.報告年 = 報告年;
        this.集計対象年 = 集計対象年;
        this.統計対象区分 = 統計対象区分;
        this.市町村コード = 市町村コード;
        this.表番号 = 表番号;
        this.処理フラグ = 処理フラグ;
        this.保険者コード = 保険者コード;
        this.市町村名称 = 市町村名称;
        this.様式４入力状況 = 様式４入力状況;
        this.様式４の２入力状況 = 様式４の２入力状況;
        this.様式４の３入力状況 = 様式４の３入力状況;
    }
}
