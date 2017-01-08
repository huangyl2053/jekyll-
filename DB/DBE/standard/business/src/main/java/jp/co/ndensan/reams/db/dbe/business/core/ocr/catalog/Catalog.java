/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.Models;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.FileReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * カタログファイル(ca3)を解析した結果を保持します。
 */
public class Catalog {

    private final Map<RString, Map<RString, CatalogLine>> map;

    /**
     * @param filePath ファイルパス
     */
    public Catalog(RString filePath) {
        this.map = readFile(filePath);
    }

    private static Map<RString, Map<RString, CatalogLine>> readFile(RString filePath) {
        File file = new File(filePath.toString());
        try (FileReader reader = new FileReader(file.toPath(), Encode.SJIS)) {
            RString line = reader.readLine();
            Map<RString, Map<RString, CatalogLine>> modelMap = new HashMap<>();
            while (line != null) {
                groupByModel(line, modelMap);
                line = reader.readLine();
            }
            return modelMap;
        }
    }

    private static void groupByModel(RString line, Map<RString, Map<RString, CatalogLine>> modelMap) {
        CatalogLine cfl = new CatalogLine(line);
        RString model = cfl.getモデル名();
        if (!modelMap.containsKey(model)) {
            modelMap.put(model, new HashMap<RString, CatalogLine>());
        }
        modelMap.get(model).put(cfl.get帳票一連ID下8桁(), cfl);
    }

    /**
     * @param modelName モデル名
     * @param sheetID シートID
     * @return 指定のモデル名、シートIDに合致するCatalogFileLine
     */
    public Optional<CatalogLine> find(RString modelName, SheetID sheetID) {
        Map<RString, CatalogLine> model = this.map.get(modelName);
        if (model == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(model.get(sheetID.get帳票一連ID下8桁()));
    }

    /**
     * @param model モデル名
     * @param sheetID シートID
     * @return 指定のモデル名、シートIDに合致するCatalogFileLine
     */
    public Optional<CatalogLine> find(Models model, SheetID sheetID) {
        return find(model.getName(), sheetID);
    }
}
