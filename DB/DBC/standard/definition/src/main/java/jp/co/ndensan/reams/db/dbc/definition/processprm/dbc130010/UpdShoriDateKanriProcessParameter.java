/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc130010.UpdShoriDateKanriMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理管理日付マスタ更新
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdShoriDateKanriProcessParameter implements IBatchProcessParameter {

    private RString 保険者区分;
    private RString 表題;
    private List<RString> 処理対象市町村;
    private RString if種類;
    private RString 取込形式;
    private RString 処理日時;
    private RString 処理名;

    /**
     *
     * @param 保険者区分 RString
     * @param 表題 RString
     * @param 処理対象市町村 List<RString>
     * @param if種類 RString
     * @param 取込形式 RString
     * @param 処理日時 RString
     * @param 処理名 RString
     */
    public UpdShoriDateKanriProcessParameter(RString 保険者区分, RString 表題,
            List<RString> 処理対象市町村, RString if種類, RString 取込形式, RString 処理日時, RString 処理名) {

        this.保険者区分 = 保険者区分;
        this.表題 = 表題;
        this.処理対象市町村 = 処理対象市町村;
        this.if種類 = if種類;
        this.取込形式 = 取込形式;
        this.処理日時 = 処理日時;
        this.処理名 = 処理名;
    }

    /**
     *
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @return UpdShoriDateKanriMybatisParameter
     */
    public UpdShoriDateKanriMybatisParameter toUpdShoriDateKanriMybatisParameter(RString 処理名, RString 処理枝番) {
        UpdShoriDateKanriMybatisParameter mybatisParameter = new UpdShoriDateKanriMybatisParameter();
        mybatisParameter.set処理名(処理名);
        mybatisParameter.set処理枝番(処理枝番);
        return mybatisParameter;
    }
}
