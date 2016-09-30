/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費支給（不支給）決定通知書作成の処理日付管理マスタの年度内連番取得Parameterです。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SelectShoriDateKanriMybatisParameter implements IMyBatisParameter {

    private SubGyomuCode サブ業務コード;
    private LasdecCode 市町村コード;
    private RString 処理名;
    private RString 処理枝番;
    private FlexibleYear 年度;

    public SelectShoriDateKanriMybatisParameter(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名,
            RString 処理枝番, FlexibleYear 年度) {
        this.サブ業務コード = サブ業務コード;
        this.市町村コード = 市町村コード;
        this.処理名 = 処理名;
        this.処理枝番 = 処理枝番;
        this.年度 = 年度;

    }
}
