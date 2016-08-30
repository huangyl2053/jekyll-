/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.noufugakudatasakuseishoridate;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 前回の処理日付取得MybatisParameter
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NoufuGakuDataSakuseiShoriDateParameter implements IMyBatisParameter {

    private List<LasdecCode> 市町村コードList;
    private List<RString> 処理枝番List;

    /**
     * コンストラクタです。
     */
    public NoufuGakuDataSakuseiShoriDateParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 市町村コード List<RString>
     * @param 処理枝番 List<RString>
     */
    NoufuGakuDataSakuseiShoriDateParameter(
            List<LasdecCode> 市町村コードList,
            List<RString> 処理枝番List) {
        this.市町村コードList = 市町村コードList;
        this.処理枝番List = 処理枝番List;
    }
}
