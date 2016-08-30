/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.systemkanrininteikekkatotal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBDCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterMaintainer;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * @author tz_sunl
 */
public class SystemKanriNinteiKekkaTotalManager {

    private final Map<RString, RString> UzT0007Code付加情報マップ;

    public SystemKanriNinteiKekkaTotalManager(Map<RString, RString> UzT0007CodeDataMap) {
        this.UzT0007Code付加情報マップ = UzT0007CodeDataMap;
    }

    /**
     * uzT0007Codeテーブルを更新する
     */
    public void uzT0007Codeテーブル更新() {
        List<UzT0007CodeEntity> uzT0007CodeEntityList = new ArrayList<>();
        Iterator<Map.Entry<RString, RString>> it = UzT0007Code付加情報マップ.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<RString, RString> entry = it.next();
            if (!entry.getValue().equals(getCodeMeiSho(entry.getKey()))) {
                UzT0007CodeEntity uzT0007CodeEntity = CodeMaster.getCode(SubGyomuCode.DBD介護受給,
                        DBDCodeShubetsu.結果通知理由.getコード(), new Code(entry.getKey()), FlexibleDate.getNowDate());
                uzT0007CodeEntity.setコード名称(entry.getValue());
                uzT0007CodeEntityList.add(uzT0007CodeEntity);
            }
        }
        for (int i = 0; i < uzT0007CodeEntityList.size(); i++) {
            CodeMasterMaintainer.updateCode(uzT0007CodeEntityList.get(i));
        }
    }

    /**
     * コード名称を取得
     *
     * @param code
     * @return コード名称
     */
    private RString getCodeMeiSho(RString code) {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                new Code(code), FlexibleDate.getNowDate());
    }
}
