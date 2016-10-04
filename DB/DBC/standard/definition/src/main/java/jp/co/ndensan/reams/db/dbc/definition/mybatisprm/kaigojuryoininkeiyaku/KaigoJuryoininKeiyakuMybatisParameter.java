/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigojuryoininkeiyaku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任契約事業者一覧表作成Parameter
 *
 * @reamsid_L DBC-2110-050 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJuryoininKeiyakuMybatisParameter implements IMyBatisParameter {

    private RString 契約事業者番号FROM;
    private RString 契約事業者番号TO;
    private FlexibleDate 契約日FROM;
    private FlexibleDate 契約日TO;
    private RString 並び順;
    private RString 契約種別;
    private RString 契約期間終了事業者;
}
