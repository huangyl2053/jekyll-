/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;

/**
 * 高額合算支給申請書情報作成送付ファイル作成と口座情報登録確認ためのSQLパラメータクラスです。
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SofuFileSakuseiMybatisParameter extends KozaSearchParameter implements IMyBatisParameter {

    private HokenshaNo 保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 HokenshaNo
     * @param key 口座検索用の検索キークラス
     * @param list 科目コードリスト
     */
    public SofuFileSakuseiMybatisParameter(HokenshaNo 保険者番号, IKozaSearchKey key, List<KamokuCode> list) {
        super(key, list);
        this.保険者番号 = 保険者番号;
    }
}
