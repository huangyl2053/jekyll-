/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）のMyBatisパラメタークラスです。
 *
 * @reamsid_L DBC-4790-030 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC020080JigyobunKogakuGassanJikofutangakuKeisanMybatisParameter implements IMyBatisParameter {

    private SubGyomuCode サブ業務コード;
    private RString 処理名;
    private RString 処理枝番;
    private FlexibleYear 年度;
    private LasdecCode 市町村コード;
}
