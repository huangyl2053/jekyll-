/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput;

import jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput.ShinsaTaishoDataOutPutResult;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsChikokuUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IssotaiUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.CodeMasterEucCsvEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.NijiHanteiKekkaInputHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsShiryoSakuseiZumi;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.NinteiShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * コードマスタCSV出力処理クラスです。
 */
public class CodeMasterOutputProcess extends SimpleBatchProcessBase {

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE518005");
    private static final RString FILE_NAME = new RString("コードマスタ.csv");
    private static final RString EUC_WRITER_ENCLOSURE = RString.EMPTY;
    private ShinsaTaishoDataOutPutProcessParammeter processParamter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    @BatchWriter
    private CsvWriter<CodeMasterEucCsvEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), FILE_NAME);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process() {
        write介護認定審査会進捗状況();
        write資料作成済区分();
        write介護認定審査会議長区分コード();
        write委員出席();
        write委員遅刻有無();
        write委員早退有無();
        write判定結果コード();
        write要介護状態区分コード();
        write原本マスク区分();
        write認知症高齢者自立度コード();
        write障害高齢者自立度コード();
        write要介護状態像例コード();
        write認定審査会意見種類();
        write二次判定結果入力方法();
        write申請区分法令コード();
        write申請区分申請時コード();
        write要介護認定状態の安定性コード();
        write認知機能及び状態安定性から推定される給付区分コード();
        write特記事項テキストイメージ区分();
        write認定調査依頼区分コード();
        write調査区分();
        write調査実施場所コード();
        write現在のサービス区分コード();
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                FILE_NAME,
                EUC_ENTITY_ID.toRString(),
                new ShinsaTaishoDataOutPutResult().get出力件数(new Decimal(eucCsvWriter.getCount())),
                new ShinsaTaishoDataOutPutResult().get出力条件(processParamter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private void write介護認定審査会進捗状況() {
        for (ShinsakaiShinchokuJokyo value : ShinsakaiShinchokuJokyo.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("介護認定審査会進捗状況"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write資料作成済区分() {
        for (IsShiryoSakuseiZumi value : IsShiryoSakuseiZumi.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("資料作成済区分"));
            entity.setコード(new RString(value.is作成済()));
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write介護認定審査会議長区分コード() {
        for (KaigoninteiShinsakaiGichoKubunCode value : KaigoninteiShinsakaiGichoKubunCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("介護認定審査会議長区分コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write委員出席() {
        for (IsShusseki value : IsShusseki.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("委員出席"));
            entity.setコード(new RString(value.is委員出席()));
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write委員遅刻有無() {
        for (IsChikokuUmu value : IsChikokuUmu.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("委員遅刻有無"));
            entity.setコード(new RString(value.is委員遅刻()));
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write委員早退有無() {
        for (IssotaiUmu value : IssotaiUmu.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("委員早退有無"));
            entity.setコード(new RString(value.is委員早退()));
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write判定結果コード() {
        for (HanteiKekkaCode value : HanteiKekkaCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("判定結果コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write要介護状態区分コード() {
        for (YokaigoJotaiKubun value : YokaigoJotaiKubun.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("要介護状態区分コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write原本マスク区分() {
        for (GenponMaskKubun value : GenponMaskKubun.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("原本マスク区分"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write認知症高齢者自立度コード() {
        for (NinchishoNichijoSeikatsuJiritsudoCode value : NinchishoNichijoSeikatsuJiritsudoCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("認知症高齢者自立度コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write障害高齢者自立度コード() {
        for (ShogaiNichijoSeikatsuJiritsudoCode value : ShogaiNichijoSeikatsuJiritsudoCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("障害高齢者自立度コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write要介護状態像例コード() {
        for (YokaigoJotaizoReiCode value : YokaigoJotaizoReiCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("要介護状態像例コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write認定審査会意見種類() {
        for (NinteiShinsakaiIkenShurui value : NinteiShinsakaiIkenShurui.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("認定審査会意見種類"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write二次判定結果入力方法() {
        for (NijiHanteiKekkaInputHoho value : NijiHanteiKekkaInputHoho.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("二次判定結果入力方法"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write申請区分法令コード() {
        for (NinteiShinseiHoreiCode value : NinteiShinseiHoreiCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("申請区分法令コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write申請区分申請時コード() {
        for (NinteiShinseiShinseijiKubunCode value : NinteiShinseiShinseijiKubunCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("申請区分申請時コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write要介護認定状態の安定性コード() {
        for (JotaiAnteiseiCode value : JotaiAnteiseiCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("要介護認定状態の安定性コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write認知機能及び状態安定性から推定される給付区分コード() {
        for (SuiteiKyufuKubunCode value : SuiteiKyufuKubunCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("認知機能及び状態安定性から推定される給付区分コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write特記事項テキストイメージ区分() {
        for (TokkijikoTextImageKubun value : TokkijikoTextImageKubun.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("特記事項テキストイメージ区分"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write認定調査依頼区分コード() {
        for (NinteiChousaIraiKubunCode value : NinteiChousaIraiKubunCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("認定調査依頼区分コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write調査区分() {
        for (ChosaKubun value : ChosaKubun.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("調査区分"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write調査実施場所コード() {
        for (ChosaJisshiBashoCode value : ChosaJisshiBashoCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("調査実施場所コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write現在のサービス区分コード() {
        for (ServiceKubunCode value : ServiceKubunCode.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("現在のサービス区分コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
    }

}
