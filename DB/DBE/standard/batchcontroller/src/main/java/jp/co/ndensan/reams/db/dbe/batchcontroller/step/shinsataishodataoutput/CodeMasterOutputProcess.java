/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsChikokuUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IssotaiUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.CodeMasterEucCsvEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyo.ServiceJokyo09B;
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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKeikoku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.NinteiShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * コードマスタCSV出力処理クラスです。
 */
public class CodeMasterOutputProcess extends SimpleBatchProcessBase {

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE518005");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private static final int サービス状況コード長さ = 2;

    private ShinsaTaishoDataOutPutProcessParammeter processParamter;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter<CodeMasterEucCsvEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        eucFilePath = Path.combinePath(processParamter.getTempPath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID.toRString()));
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process() {
        writeサービス状況();
        write一次判定警告コード();
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
    }

    private void writeサービス状況() {
        for (ServiceJokyo09B value : ServiceJokyo09B.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("サービス状況"));
            entity.setコード(new RString(value.getテーブル内連番()).padZeroToLeft(サービス状況コード長さ));
            entity.set名称(value.get帳票上の名称_予防給付());
            List<RString> 単位 = value.get単位().split(RString.HALF_SPACE.toString());
            if (Decimal.ZERO.intValue() < 単位.size()) {
                entity.set備考1(単位.get(Decimal.ZERO.intValue()));
            }
            if (Decimal.ONE.intValue() < 単位.size()) {
                entity.set備考2(単位.get(Decimal.ONE.intValue()));
            }

            eucCsvWriter.writeLine(entity);
        }
    }

    private void write一次判定警告コード() {
        for (IchijiHanteiKeikoku value : IchijiHanteiKeikoku.values()) {
            CodeMasterEucCsvEntity entity = new CodeMasterEucCsvEntity();

            entity.setコード種別(new RString("一次判定警告コード"));
            entity.setコード(value.getコード());
            entity.set名称(value.get名称());

            eucCsvWriter.writeLine(entity);
        }
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
