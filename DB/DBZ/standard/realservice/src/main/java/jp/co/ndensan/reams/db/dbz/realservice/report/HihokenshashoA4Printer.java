/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.report;

import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.HihokenshashoBuilderFactory;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoPrintPosition;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshasho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.ur.urz.business.IAssociation;
import jp.co.ndensan.reams.ua.uax.business.atesaki.ITsuchishoAtesaki;
import jp.co.ndensan.reams.ur.urz.business.report.IReportBuilder;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.kojin.IKojin;

/**
 * 被保険者証A4版を発行するために使用するPrinterクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoA4Printer {

    private final HihokenshashoPrinterBase printerBase;
    private final HihokenshashoBuilderFactory hihoshoBuilderFactory;

    private static final RString REPORT_ID_A4;

    static {
        REPORT_ID_A4 = new RString("DBA100002_HihokenshashoA4");
    }

    /**
     * コンストラクタです。
     */
    public HihokenshashoA4Printer() {
        this.printerBase = new HihokenshashoPrinterBase();
        this.hihoshoBuilderFactory = new HihokenshashoBuilderFactory();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param printerBase 被保険者証PrinterBase
     * @param hihoshoBuilderFactory 被保険者証BuilderFactory
     */
    HihokenshashoA4Printer(HihokenshashoPrinterBase printerBase, HihokenshashoBuilderFactory hihoshoBuilderFactory) {
        this.printerBase = printerBase;
        this.hihoshoBuilderFactory = hihoshoBuilderFactory;
    }

    /**
     * 引数から受け取った情報を元に、被保険者証単票発行時のソースデータを出力します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikakuHakkoModel 被保険者資格発行Model
     * @param position 被保険者証印字位置
     * @return 帳票ソースデータ
     */
//    public SourceDataCollection print(HihokenshaNo hihokenshaNo, HihokenshaShikakuHakkoModel shikakuHakkoModel,
//            HihokenshashoPrintPosition position) {
//        Class formType;
//        RString reportId;
//        IReportBuilder<IHihokenshasho> builder;
//
//        HihokenshaDaichoModel daichoModel = printerBase.getDaichoModel(hihokenshaNo);
//        IKojin kojin = printerBase.getKojin(daichoModel);
//
//        HihokenshashoModel target = new HihokenshashoModel(daichoModel, kojin, shikakuHakkoModel, position);
//
//        ITsuchishoAtesaki tsuchishoAtesaki = printerBase.getTsuchishoAtesaki(
//                target.getShikakuHakko().get交付日(), target.getKojinJoho().get識別コード());
//        IAssociation assosiation = printerBase.getAssociation();
//
//        formType = HihokenshashoA4.class;
//        reportId = REPORT_ID_A4;
//        builder = hihoshoBuilderFactory
//                .createInstanceForA4(target, assosiation, tsuchishoAtesaki);
//
//        return printerBase.print(formType, reportId, builder);
//    }
}
