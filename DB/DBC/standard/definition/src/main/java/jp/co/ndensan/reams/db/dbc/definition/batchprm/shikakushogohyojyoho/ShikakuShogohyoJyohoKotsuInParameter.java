/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.shikakushogohyojyoho;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格照合表情報取込共通処理（CSVファイル取込）BatchParameter
 *
 * @reamsid_L DBC-2890-013 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShogohyoJyohoKotsuInParameter extends BatchParameterBase {

    private static final String KEY_HOZONSEN_FORUDA = "保存先フォルダ";
    private static final String KEY_FILE_NAME_LIST = "fileNameList";

    @BatchParameter(key = KEY_HOZONSEN_FORUDA, name = "保存先フォルダ")
    private RString 保存先フォルダ;
    @BatchParameter(key = KEY_FILE_NAME_LIST, name = "エントリ情報List")
    private List<RString> fileNameList;

}
