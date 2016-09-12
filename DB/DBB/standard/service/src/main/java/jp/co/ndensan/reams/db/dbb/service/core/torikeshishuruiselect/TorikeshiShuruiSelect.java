/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.torikeshishuruiselect;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 介護保険料減免の取消種類選択ビジネス
 *
 * @reamsid_L DBB-1660-080 xupeng
 */
public class TorikeshiShuruiSelect {

    /**
     * 取消種類情報を取得する
     *
     * @param システム日付 FlexibleDate
     * @return List<UzT0007CodeEntity>
     */
    public List<UzT0007CodeEntity> getTorikeshiShurui(FlexibleDate システム日付) {
        List<UzT0007CodeEntity> list = CodeMaster.getCode(SubGyomuCode.DBB介護賦課,
                DBBCodeShubetsu.保険料減免取消種類.getコード(), システム日付);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
