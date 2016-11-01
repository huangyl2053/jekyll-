/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc130020;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理管理日付マスタ更新
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdShoriDateKanriMybatisParameter implements IMyBatisParameter {

    private RString 処理名;
    private RString 処理枝番;
    private RString 基準年月日;
    private YMDHMS 基準日時;
    private RString 対象開始年月日;
    private YMDHMS 対象開始日時;
    private RDateTime 処理日時;
}
