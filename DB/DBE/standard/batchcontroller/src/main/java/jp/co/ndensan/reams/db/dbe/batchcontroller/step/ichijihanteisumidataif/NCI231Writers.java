/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteisumidataif;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteisumidataif.IchijiHanteiSumiDataIFEditor;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

/**
 * 複数のNCI231.CSVを作成します。
 * 書込みに用いるentityの値により、書き込むCSVファイル(NCI231)を制御します。
 * また、CSVファイルのスプール、アクセスログの記録も内部で行います。
 */
final class NCI231Writers {

    private static final RString SJIS = new RString("1");
    private static final RString UTF_8_WITH_BOM = new RString("2");

    private final Map<RString, NCI231Writer> elements;
    private final Encode encode;
    private final IchijiHanteiSumiDataIFEditor editor;

    /**
     * @param fsManager CSVファイルのスプールに用いる{@link FileSpoolManager}
     * @param operationDate 処理日付
     */
    NCI231Writers(RDate operationDate) {
        this.elements = new HashMap<>();
        this.encode = getEncode(operationDate);
        this.editor = new IchijiHanteiSumiDataIFEditor(operationDate);
    }

    private static Encode getEncode(RDate operationDate) {
        RString code = DbBusinessConfig.get(ConfigNameDBE.一次判定IF文字コード, operationDate);
        if (SJIS.equals(code)) {
            return Encode.SJIS;
        } else if (UTF_8_WITH_BOM.equals(code)) {
            return Encode.UTF_8withBOM;
        }
        return Encode.SJIS;
    }

    private NCI231Writer getOrCreateWriter(RString fileName) {
        if (!this.elements.containsKey(fileName)) {
            this.elements.put(fileName, new NCI231Writer(fileName, this.encode));
        }
        return this.elements.get(fileName);
    }

    /**
     * 対応するCSVファイルに対して、一行を出力します。
     *
     * @param entity {@link IchijihanteiSumidataIDataShutsuryokuRelateEntity}
     */
    void writeLine(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        IchijiHanteiSumiDataIFEditor.IResult result = editor.edit(entity);
        if (!result.exists()) {
            return;
        }
        this.getOrCreateWriter(result.getFileName()).writeLine(result);
    }

    /**
     * CSVファイルをスプールします。
     */
    void spool() {
        for (NCI231Writer e : this.elements.values()) {
            e.spool();
        }
    }

    /**
     * @return
     */
    Iterable<OutputingCsv> outputingInfos() {
        List<OutputingCsv> list = new ArrayList<>();
        for (NCI231Writer e : this.elements.values()) {
            list.add(e.newOutputingCsv());
        }
        return list;
    }

}
