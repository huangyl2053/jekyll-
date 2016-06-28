/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Source;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特徴開始通知書(本算定）の発行クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class PrtTokuchoKaishiTsuchishoHonsanteiProcess extends SimpleBatchProcessBase {

    private Association 地方公共団体;
    private HonsanteifukaProcessParameter processParameter;
    @BatchWriter
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoB5Source> reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB5Source> dbb100032ReportSourceWriter;

    @Override
    protected void beforeExecute() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void process() {
        HonsanteiTsuchishoIkkatsuHakko manager = HonsanteiTsuchishoIkkatsuHakko.createInstance();
        HonsanteifukaBatchTyouhyou 出力帳票一覧 = processParameter.get出力帳票一覧();
        try {
            manager.prtTokuchoKaishiTsuchishoHonsantei(processParameter.get調定年度(), processParameter.get特徴_発行日(),
                    processParameter.get帳票作成日時().getRDateTime(), 出力帳票一覧.get出力順ID(), 出力帳票一覧.get帳票ID(),
                    processParameter.get特徴_出力対象());
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtTokuchoKaishiTsuchishoHonsanteiProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void afterExecute() {

        CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目1.class, チェック項目1.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名());

        reportWriter = BatchWriters
                .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoB5Source.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(processParameter.get出力帳票一覧().get帳票ID())
                .build();
        dbb100032ReportSourceWriter = new ReportSourceWriter<>(reportWriter);
        new TokubetsuChoshuKaishiTsuchishoB5Report(new EditedHonSanteiTsuchiShoKyotsu(), null, null).writeBy(dbb100032ReportSourceWriter);

    }

    private enum 特定項目1 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoB5Source.ITEM_NENDO, "賦課年度"),
        key2(TokubetsuChoshuKaishiTsuchishoB5Source.ITEM_TSUCHISHONO2, "通知書番号");

        private final RString itemName;
        private final RString printName;

        private 特定項目1(String itemName, String printName) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }
    }

    private enum チェック項目1 implements ICheckTarget {

        target1("hihokenshaName2", "被保険者氏名2", CheckShubetsu.文字切れ),
        target2("setainushiName1", "世帯主名1", CheckShubetsu.文字切れ),
        target4("hokenshaName", "被保険者氏名", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目1(String itemName, String printName, CheckShubetsu checkShubetsu) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
            this.checkShubetsu = checkShubetsu;
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }

        @Override
        public CheckShubetsu getCheckShubetsu() {
            return this.checkShubetsu;
        }
    }

}
