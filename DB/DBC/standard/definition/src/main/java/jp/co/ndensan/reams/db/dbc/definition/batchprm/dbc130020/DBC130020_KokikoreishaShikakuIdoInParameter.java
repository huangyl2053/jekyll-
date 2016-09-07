/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc130020;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC130020_KokikoreishaShikakuIdoInParameter {

    private static final String KEY_INSURERDISTINCTION = "insurerDistinction";
    private static final String KEY_TABLENAME = "tableName";
    private static final String KEY_SHORISHICHOSON = "shoriShichoson";
    private static final String KEY_IFTYPE = "ifType";
    private static final String KEY_TORIKOMIKEISHIKI = "torikomiKeishiki";
    private static final String KEY_SHORITIMESTAMP = "shoriTimestamp";

    @BatchParameter(key = KEY_INSURERDISTINCTION, name = "保険者区分")
    private RString insurerDistinction;
    @BatchParameter(key = KEY_TABLENAME, name = "表題")
    private RString tableName;
    @BatchParameter(key = KEY_SHORISHICHOSON, name = "処理対象市町村")
    private List<RString> shoriShichoson;
    @BatchParameter(key = KEY_IFTYPE, name = "ＩＦ種類")
    private RString ifType;
    @BatchParameter(key = KEY_TORIKOMIKEISHIKI, name = "取込形式")
    private RString torikomiKeishiki;
    @BatchParameter(key = KEY_SHORITIMESTAMP, name = "処理日時")
    private RString shoriTimestamp;
}
