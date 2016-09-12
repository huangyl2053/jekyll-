/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyoshuruiselect;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 徴収猶予種類選択ビジネス
 *
 * @reamsid_L DBB-1680-090 xupeng
 */
public class ChoshuYuyoShuruiSelect {

    /**
     * 徴収猶予種類情報を取得する
     *
     * @param システム日付 FlexibleDate
     * @return List<UzT0007CodeEntity>
     */
    public List<UzT0007CodeEntity> getChoshuYuyoShurui(FlexibleDate システム日付) {
        List<UzT0007CodeEntity> list = CodeMaster.getCode(SubGyomuCode.DBB介護賦課,
                DBBCodeShubetsu.保険料徴収猶予種類.getコード(), システム日付);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
