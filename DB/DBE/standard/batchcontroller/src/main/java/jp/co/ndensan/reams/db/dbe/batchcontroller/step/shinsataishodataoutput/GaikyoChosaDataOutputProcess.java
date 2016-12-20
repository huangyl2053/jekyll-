/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput;

import jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput.ShinsaTaishoDataOutPutResult;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaNinchishoKasanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
 * 概況調査データのCSV出力処理クラスです。
 */
public class GaikyoChosaDataOutputProcess extends BatchProcessBase<GaikyoChosaDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput.IShinsaTaishoDataOutPutMapper."
            + "get概況調査データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE518003");
    private static final RString FILE_NAME = new RString("概況調査データ.csv");
    private static final RString EUC_WRITER_ENCLOSURE = RString.EMPTY;
    private ShinsaTaishoDataOutPutProcessParammeter processParamter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    @BatchWriter
    private CsvWriter<GaikyoChosaDataEucCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShinsaTaishoDataOutMybatisParameter());
    }

    @Override
    protected void createWriter() {
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
    protected void process(GaikyoChosaDataRelateEntity entity) {
        eucCsvWriter.writeLine(createCsvEntity(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        outputJokenhyoFactory();
    }

    private GaikyoChosaDataEucCsvEntity createCsvEntity(GaikyoChosaDataRelateEntity entity) {
        GaikyoChosaDataEucCsvEntity csvEntity = new GaikyoChosaDataEucCsvEntity();

        csvEntity.set申請書管理番号(entity.get申請書管理番号());
        csvEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        //csvEntity.set厚労省認定ソフトのバージョン(KoroshoIfShikibetsuCode.toValue(entity.get厚労省IF識別コード()).get名称());
        csvEntity.set証記載保険者番号(entity.get証記載保険者番号());
        csvEntity.set被保険者番号(entity.get被保険者番号());
        csvEntity.set認定申請年月日(entity.get認定申請年月日());
        csvEntity.set認定申請区分_申請時_コード(entity.get認定申請区分_申請時_コード());
        //csvEntity.set認定申請区分_申請時(NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分_申請時_コード()).get略称());
        csvEntity.set被保険者氏名(entity.get被保険者氏名());
        csvEntity.set被保険者氏名カナ(entity.get被保険者氏名カナ());
        csvEntity.set生年月日(entity.get生年月日());
        csvEntity.set年齢(entity.get年齢());
        csvEntity.set性別(entity.get性別());
        csvEntity.set郵便番号(entity.get郵便番号());
        csvEntity.set住所(entity.get住所());
        csvEntity.set電話番号(entity.get電話番号());
        csvEntity.set保険者名(entity.get保険者名());
        csvEntity.set認定調査依頼完了年月日(entity.get認定調査依頼完了年月日());
        csvEntity.set認定調査依頼履歴番号(entity.get認定調査依頼履歴番号());
        csvEntity.set認定調査委託先コード(entity.get認定調査委託先コード());
        //csvEntity.set調査委託先();
        csvEntity.set認定調査員コード(entity.get認定調査員コード());
        csvEntity.set調査員氏名(entity.get調査員氏名());
        csvEntity.set概況特記テキスト_イメージ区分コード(entity.get概況特記テキスト_イメージ区分コード());
        //csvEntity.set概況特記テキスト_イメージ区分(TokkijikoTextImageKubun.toValue(entity.get概況特記テキスト_イメージ区分コード()).get名称());
        csvEntity.set認定調査依頼区分コード(entity.get認定調査依頼区分コード());
        //csvEntity.set認定調査依頼区分(NinteiChousaIraiKubunCode.toValue(entity.get認定調査依頼区分コード()).get名称());
        csvEntity.set認定調査回数(entity.get認定調査回数());
        csvEntity.set認定調査実施年月日(entity.get認定調査実施年月日());
        csvEntity.set認定調査受領年月日(entity.get認定調査受領年月日());
        csvEntity.set認定調査区分コード(entity.get認定調査区分コード());
        //csvEntity.set認定調査区分(ChosaKubun.toValue(entity.get認定調査区分コード()).get名称());
        csvEntity.set認定調査実施場所コード(entity.get認定調査実施場所コード());
        csvEntity.set認定調査実施場所(entity.get認定調査実施場所());
        csvEntity.set認定調査実施場所名称(entity.get認定調査実施場所名称());
        csvEntity.set家族等連絡先郵便番号(entity.get家族等連絡先郵便番号());
        csvEntity.set家族等電話番号(entity.get家族等電話番号());
        csvEntity.set家族等住所(entity.get家族等住所());
        csvEntity.set家族等氏名(entity.get家族等氏名());
        csvEntity.set調査対象者との関係(entity.get調査対象者との関係());
        csvEntity.set認定調査_サービス区分コード(entity.get認定調査_サービス区分コード());
        //csvEntity.set認定調査_サービス区分(ServiceKubunCode.toValue(entity.get認定調査_サービス区分コード()).get名称());
        csvEntity.set利用施設名(entity.get利用施設名());
        csvEntity.set利用施設住所(entity.get利用施設住所());
        csvEntity.set利用施設電話番号(entity.get利用施設電話番号());
        csvEntity.set利用施設郵便番号(entity.get利用施設郵便番号());
        csvEntity.set特記(entity.get特記());
        csvEntity.set認定調査特記事項受付年月日(entity.get認定調査特記事項受付年月日());
        csvEntity.set認定調査特記事項受領年月日(entity.get認定調査特記事項受領年月日());
        csvEntity.set住宅改修_改修箇所(entity.get住宅改修_改修箇所());
        csvEntity.set市町村特別給付サービス種類名(entity.get市町村特別給付サービス種類名());
        csvEntity.set介護保険給付以外の在宅サービス種類名(entity.get介護保険給付以外の在宅サービス種類名());
        csvEntity.setサービスの状況連番01(entity.getサービスの状況連番01());
        csvEntity.setサービスの状況01(entity.getサービスの状況01());
        csvEntity.setサービスの状況連番02(entity.getサービスの状況連番02());
        csvEntity.setサービスの状況02(entity.getサービスの状況02());
        csvEntity.setサービスの状況連番03(entity.getサービスの状況連番03());
        csvEntity.setサービスの状況03(entity.getサービスの状況03());
        csvEntity.setサービスの状況連番04(entity.getサービスの状況連番04());
        csvEntity.setサービスの状況04(entity.getサービスの状況04());
        csvEntity.setサービスの状況連番05(entity.getサービスの状況連番05());
        csvEntity.setサービスの状況05(entity.getサービスの状況05());
        csvEntity.setサービスの状況連番06(entity.getサービスの状況連番06());
        csvEntity.setサービスの状況06(entity.getサービスの状況06());
        csvEntity.setサービスの状況連番07(entity.getサービスの状況連番07());
        csvEntity.setサービスの状況07(entity.getサービスの状況07());
        csvEntity.setサービスの状況連番08(entity.getサービスの状況連番08());
        csvEntity.setサービスの状況08(entity.getサービスの状況08());
        csvEntity.setサービスの状況連番09(entity.getサービスの状況連番09());
        csvEntity.setサービスの状況09(entity.getサービスの状況09());
        csvEntity.setサービスの状況連番10(entity.getサービスの状況連番10());
        csvEntity.setサービスの状況10(entity.getサービスの状況10());
        csvEntity.setサービスの状況連番11(entity.getサービスの状況連番11());
        csvEntity.setサービスの状況11(entity.getサービスの状況11());
        csvEntity.setサービスの状況連番12(entity.getサービスの状況連番12());
        csvEntity.setサービスの状況12(entity.getサービスの状況12());
        csvEntity.setサービスの状況連番13(entity.getサービスの状況連番13());
        csvEntity.setサービスの状況13(entity.getサービスの状況13());
        csvEntity.setサービスの状況連番14(entity.getサービスの状況連番14());
        csvEntity.setサービスの状況14(entity.getサービスの状況14());
        csvEntity.setサービスの状況連番15(entity.getサービスの状況連番15());
        csvEntity.setサービスの状況15(entity.getサービスの状況15());
        csvEntity.setサービスの状況連番16(entity.getサービスの状況連番16());
        csvEntity.setサービスの状況16(entity.getサービスの状況16());
        csvEntity.setサービスの状況連番17(entity.getサービスの状況連番17());
        csvEntity.setサービスの状況17(entity.getサービスの状況17());
        csvEntity.setサービスの状況連番18(entity.getサービスの状況連番18());
        csvEntity.setサービスの状況18(entity.getサービスの状況18());
        csvEntity.setサービスの状況連番19(entity.getサービスの状況連番19());
        csvEntity.setサービスの状況19(entity.getサービスの状況19());
        csvEntity.setサービスの状況連番20(entity.getサービスの状況連番20());
        csvEntity.setサービスの状況20(entity.getサービスの状況20());
        csvEntity.setサービスの状況フラグ連番(entity.getサービスの状況フラグ連番());
        csvEntity.setサービスの状況フラグ(entity.isサービスの状況フラグ());
        csvEntity.set記入項目連番01(entity.get記入項目連番01());
        csvEntity.setサービスの状況記入01(entity.getサービスの状況記入01());
        csvEntity.set記入項目連番02(entity.get記入項目連番02());
        csvEntity.setサービスの状況記入02(entity.getサービスの状況記入02());
        csvEntity.set施設利用連番01(entity.get施設利用連番01());
        csvEntity.set施設利用フラグ01(entity.is施設利用フラグ01());
        csvEntity.set施設利用連番02(entity.get施設利用連番02());
        csvEntity.set施設利用フラグ02(entity.is施設利用フラグ02());
        csvEntity.set施設利用連番03(entity.get施設利用連番03());
        csvEntity.set施設利用フラグ03(entity.is施設利用フラグ03());
        csvEntity.set施設利用連番04(entity.get施設利用連番04());
        csvEntity.set施設利用フラグ04(entity.is施設利用フラグ04());
        csvEntity.set施設利用連番05(entity.get施設利用連番05());
        csvEntity.set施設利用フラグ05(entity.is施設利用フラグ05());
        csvEntity.set施設利用連番06(entity.get施設利用連番06());
        csvEntity.set施設利用フラグ06(entity.is施設利用フラグ06());
        csvEntity.set施設利用連番07(entity.get施設利用連番07());
        csvEntity.set施設利用フラグ07(entity.is施設利用フラグ07());
        csvEntity.set施設利用連番08(entity.get施設利用連番08());
        csvEntity.set施設利用フラグ08(entity.is施設利用フラグ08());
        csvEntity.set施設利用連番09(entity.get施設利用連番09());
        csvEntity.set施設利用フラグ09(entity.is施設利用フラグ09());
        csvEntity.set認定調査認知症高齢者の日常生活自立度コード(entity.get認定調査認知症高齢者の日常生活自立度コード());
        //csvEntity.set認定調査認知症高齢者の日常生活自立度(
        //        NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get認定調査認知症高齢者の日常生活自立度コード()).get名称());
        csvEntity.set認定調査障害高齢者の日常生活自立度コード(entity.get認定調査障害高齢者の日常生活自立度コード());
        //csvEntity.set認定調査障害高齢者の日常生活自立度(
        //        ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get認定調査障害高齢者の日常生活自立度コード()).get名称());
        csvEntity.setステータス(entity.getステータス());
        csvEntity.set中間評価項目得点第1群(entity.get中間評価項目得点第1群());
        csvEntity.set中間評価項目得点第2群(entity.get中間評価項目得点第2群());
        csvEntity.set中間評価項目得点第3群(entity.get中間評価項目得点第3群());
        csvEntity.set中間評価項目得点第4群(entity.get中間評価項目得点第4群());
        csvEntity.set中間評価項目得点第5群(entity.get中間評価項目得点第5群());
        csvEntity.set被保険者区分コード(entity.get被保険者区分コード());
        //csvEntity.set被保険者区分名称(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get略称());
        csvEntity.set認知症自立度Ⅱ以上の蓋然性(entity.get認知症自立度Ⅱ以上の蓋然性());
        csvEntity.set給付区分コード(entity.get給付区分コード());
        //csvEntity.set給付区分(SuiteiKyufuKubunCode.toValue(entity.get給付区分コード()).get名称());
        csvEntity.set状態の安定性コード(entity.get状態の安定性コード());
        //csvEntity.set状態の安定性(JotaiAnteiseiCode.toValue(entity.get状態の安定性コード()).get名称());
        csvEntity.set主治医認定調査認知症高齢者の日常生活自立度コード(entity.get主治医認定調査認知症高齢者の日常生活自立度コード());
        //csvEntity.set主治医認定調査認知症高齢者の日常生活自立度(
        //        NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get主治医認定調査認知症高齢者の日常生活自立度コード()).get名称());
        csvEntity.set主治医認定調査障害高齢者の日常生活自立度コード(entity.get主治医認定調査障害高齢者の日常生活自立度コード());
        //csvEntity.set主治医認定調査障害高齢者の日常生活自立度(
        //        ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get主治医認定調査障害高齢者の日常生活自立度コード()).get名称());
        csvEntity.set二号特定疾病コード(entity.get二号特定疾病コード());
        csvEntity.set認定申請理由(entity.get認定申請理由());
        csvEntity.set要介護認定一次判定結果コード(entity.get要介護認定一次判定結果コード());
        //csvEntity.set要介護認定一次判定結果(IchijiHanteiKekkaCode09.toValue(entity.get要介護認定一次判定結果コード()).get名称());
        csvEntity.set要介護認定等基準時間(entity.get要介護認定等基準時間());
        csvEntity.set要介護認定等基準時間_食事(entity.get要介護認定等基準時間_食事());
        csvEntity.set要介護認定等基準時間_排泄(entity.get要介護認定等基準時間_排泄());
        csvEntity.set要介護認定等基準時間_移動(entity.get要介護認定等基準時間_移動());
        csvEntity.set要介護認定等基準時間_清潔保持(entity.get要介護認定等基準時間_清潔保持());
        csvEntity.set要介護認定等基準時間_間接ケア(entity.get要介護認定等基準時間_間接ケア());
        csvEntity.set要介護認定等基準時間_BPSD関連(entity.get要介護認定等基準時間_BPSD関連());
        csvEntity.set要介護認定等基準時間_機能訓練(entity.get要介護認定等基準時間_機能訓練());
        csvEntity.set要介護認定等基準時間_医療関連(entity.get要介護認定等基準時間_医療関連());
        csvEntity.set要介護認定等基準時間_認知症加算(entity.get要介護認定等基準時間_認知症加算());
        csvEntity.set要介護認定一次判定警告コード(entity.get要介護認定一次判定警告コード());
        csvEntity.set前回_審査会開催番号(entity.get前回_審査会開催番号());
        csvEntity.set前回_認定有効開始年月日(entity.get前回_認定有効開始年月日());
        csvEntity.set前回_認定有効終了年月日(entity.get前回_認定有効終了年月日());
        csvEntity.set前回_認定期間(entity.get前回_認定期間());
        csvEntity.set前回_二次判定日(entity.get前回_二次判定日());
        csvEntity.set前回_申請区分_申(entity.get前回_申請区分_申());
        csvEntity.set前回_申請区分_法(entity.get前回_申請区分_法());
        csvEntity.set前回_通知区分(entity.get前回_通知区分());
        csvEntity.set前回_特定疾病(entity.get前回_特定疾病());
        csvEntity.set前回_一次判定(entity.get前回_一次判定());
        csvEntity.set前回_二次判定(entity.get前回_二次判定());
        csvEntity.set前回_状態像(entity.get前回_状態像());
        csvEntity.set前回_審査会メモ(entity.get前回_審査会メモ());
        csvEntity.set前回_審査会意見(entity.get前回_審査会意見());
        csvEntity.set前々回_審査会開催番号(entity.get前々回_審査会開催番号());
        csvEntity.set前々回_認定有効開始年月日(entity.get前々回_認定有効開始年月日());
        csvEntity.set前々回_認定有効終了年月日(entity.get前々回_認定有効終了年月日());
        csvEntity.set前々回_認定期間(entity.get前々回_認定期間());
        csvEntity.set前々回_二次判定日(entity.get前々回_二次判定日());
        csvEntity.set前々回_申請区分_申(entity.get前々回_申請区分_申());
        csvEntity.set前々回_申請区分_法(entity.get前々回_申請区分_法());
        csvEntity.set前々回_通知区分(entity.get前々回_通知区分());
        csvEntity.set前々回_特定疾病(entity.get前々回_特定疾病());
        csvEntity.set前々回_一次判定(entity.get前々回_一次判定());
        csvEntity.set前々回_二次判定(entity.get前々回_二次判定());
        csvEntity.set前々回_状態像(entity.get前々回_状態像());
        csvEntity.set前々回_審査会メモ(entity.get前々回_審査会メモ());
        csvEntity.set前々回_審査会意見(entity.get前々回_審査会意見());
        csvEntity.set今回_審査会開催番号(entity.get今回_審査会開催番号());
        csvEntity.set今回_認定有効開始年月日(entity.get今回_認定有効開始年月日());
        csvEntity.set今回_認定有効終了年月日(entity.get今回_認定有効終了年月日());
        csvEntity.set今回_認定期間(entity.get今回_認定期間());
        csvEntity.set今回_二次判定日(entity.get今回_二次判定日());
        csvEntity.set今回_申請区分_申(entity.get今回_申請区分_申());
        csvEntity.set今回_申請区分_法(entity.get今回_申請区分_法());
        csvEntity.set今回_通知区分(entity.get今回_通知区分());
        csvEntity.set今回_特定疾病(entity.get今回_特定疾病());
        csvEntity.set今回_一次判定(entity.get今回_一次判定());
        csvEntity.set今回_二次判定(entity.get今回_二次判定());
        csvEntity.set今回_状態像(entity.get今回_状態像());
        csvEntity.set今回_審査会メモ(entity.get今回_審査会メモ());
        csvEntity.set今回_審査会意見(entity.get今回_審査会意見());
        csvEntity.set要介護認定1_5次判定年月日(entity.get要介護認定1_5次判定年月日());
        csvEntity.set要介護認定1_5次判定結果コード(entity.get要介護認定1_5次判定結果コード());
        //csvEntity.set要介護認定1_5次判定結果(IchijiHanteiKekkaCode09.toValue(entity.get要介護認定1_5次判定結果コード()).get名称());
        csvEntity.set要介護認定1_5次判定結果コード_認知症加算(entity.get要介護認定1_5次判定結果コード_認知症加算());
        //csvEntity.set要介護認定1_5次判定結果_認知症加算(
        //        IchijiHanteiKekkaNinchishoKasanCode.toValue(entity.get要介護認定1_5次判定結果コード_認知症加算()).get名称());
        csvEntity.set要介護認定等基準時間_1_5次(entity.get要介護認定等基準時間_1_5次());
        csvEntity.set要介護認定等基準時間_食事_1_5次(entity.get要介護認定等基準時間_食事_1_5次());
        csvEntity.set要介護認定等基準時間_排泄_1_5次(entity.get要介護認定等基準時間_排泄_1_5次());
        csvEntity.set要介護認定等基準時間_移動_1_5次(entity.get要介護認定等基準時間_移動_1_5次());
        csvEntity.set要介護認定等基準時間_清潔保持_1_5次(entity.get要介護認定等基準時間_清潔保持_1_5次());
        csvEntity.set要介護認定等基準時間_間接ケア_1_5次(entity.get要介護認定等基準時間_間接ケア_1_5次());
        csvEntity.set要介護認定等基準時間_BPSD関連_1_5次(entity.get要介護認定等基準時間_BPSD関連_1_5次());
        csvEntity.set要介護認定等基準時間_機能訓練_1_5次(entity.get要介護認定等基準時間_機能訓練_1_5次());
        csvEntity.set要介護認定等基準時間_医療関連_1_5次(entity.get要介護認定等基準時間_医療関連_1_5次());
        csvEntity.set要介護認定等基準時間_認知症加算_1_5次(entity.get要介護認定等基準時間_認知症加算_1_5次());
        csvEntity.set中間評価項目得点第1群_1_5次(entity.get中間評価項目得点第1群_1_5次());
        csvEntity.set中間評価項目得点第2群_1_5次(entity.get中間評価項目得点第2群_1_5次());
        csvEntity.set中間評価項目得点第3群_1_5次(entity.get中間評価項目得点第3群_1_5次());
        csvEntity.set中間評価項目得点第4群_1_5次(entity.get中間評価項目得点第4群_1_5次());
        csvEntity.set中間評価項目得点第5群_1_5次(entity.get中間評価項目得点第5群_1_5次());
        csvEntity.set要介護認定1_5次判定警告コード_1_5次(entity.get要介護認定1_5次判定警告コード_1_5次());
        csvEntity.set要介護認定状態の安定性コード_1_5次(entity.get要介護認定状態の安定性コード_1_5次());
        csvEntity.set認知症自立度Ⅱ以上の蓋然性_1_5次(entity.get認知症自立度Ⅱ以上の蓋然性_1_5次());
        csvEntity.set認知機能及び状態安定性から推定される給付区分コード_1_5次(entity.get認知機能及び状態安定性から推定される給付区分コード_1_5次());
        csvEntity.set短期記憶内容コード(entity.get短期記憶内容コード());
        //csvEntity.set短期記憶内容(IkenKomoku04.toValue(entity.get短期記憶内容コード()).get名称());
        csvEntity.set認知能力内容コード(entity.get認知能力内容コード());
        //csvEntity.set認知能力内容(IkenKomoku05.toValue(entity.get認知能力内容コード()).get名称());
        csvEntity.set伝達能力内容コード(entity.get伝達能力内容コード());
        //csvEntity.set伝達能力内容(IkenKomoku06.toValue(entity.get伝達能力内容コード()).get名称());
        csvEntity.set食事行為内容コード(entity.get食事行為内容コード());
        //csvEntity.set食事行為内容(IkenKomoku14.toValue(entity.get食事行為内容コード()).get名称());
        csvEntity.set介護認定審査会審査順(entity.get介護認定審査会審査順());

        return csvEntity;
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
}
