/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.shikakushogohyojyoho;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格照合表情報取込共通処理（CSVファイル取込）ProcessParameter
 *
 * @reamsid_L DBC-2890-013 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShogohyoJyohoReadCsvFileParameter implements IBatchProcessParameter {

    private RString 保存先フォルダ;
    private List<RString> エントリ情報List;
    private boolean isLast;
    private int 連番;
    private int codeNum;

}
