/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.report;

import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoPrintPosition;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 被保険者証の印刷可能データを生成するクラスです。<br/>
 * 業務コンフィグの被保険者証表示方法_証表示タイプの情報を元に、B4版かA4版どちらかのPrinterを内部で使用し、印字可能データを返します。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoPrinter {

    private final HihokenshashoPrintConfig printConfig;

    private final HihokenshashoA4Printer a4Printer;
    private final HihokenshashoB4Printer b4Printer;

    /**
     * コンストラクタです。
     */
    public HihokenshashoPrinter() {
        printConfig = new HihokenshashoPrintConfig();
        a4Printer = new HihokenshashoA4Printer();
        b4Printer = new HihokenshashoB4Printer();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param printConfig 被保険者証表示方法コンフィグ
     * @param a4Printer A4版Printerクラス
     * @param b4Printer B4版Printerクラス
     */
    HihokenshashoPrinter(HihokenshashoPrintConfig printConfig,
            HihokenshashoA4Printer a4Printer, HihokenshashoB4Printer b4Printer) {
        this.printConfig = printConfig;
        this.a4Printer = a4Printer;
        this.b4Printer = b4Printer;
    }

    /**
     * 引数から受け取った情報を元に、被保険者証単票発行時のソースデータを出力します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikakuHakkoModel 被保険者資格発行Model
     * @param position 被保険者証印字位置
     * @return 帳票ソースデータ
     */
    public SourceDataCollection print(HihokenshaNo hihokenshaNo, HihokenshaShikakuHakkoModel shikakuHakkoModel,
            HihokenshashoPrintPosition position) {
        switch (printConfig.get証表示タイプ()) {
            case A4横:
                return a4Printer.print(hihokenshaNo, shikakuHakkoModel, position);
            case B4横:
            default:
                return b4Printer.print(hihokenshaNo, shikakuHakkoModel, position);
        }
    }

}
