/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput.ShinsaTaishoDataOutPutResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput.GaikyoChosaDataMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaData5207_08_09_10RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataZenkaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput.IShinsaTaishoDataOutPutMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
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
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private static final int 連番1 = 1;
    private static final int 連番2 = 2;
    private static final int 連番3 = 3;
    private static final int 連番4 = 4;
    private static final int 連番5 = 5;
    private static final int 連番6 = 6;
    private static final int 連番7 = 7;
    private static final int 連番8 = 8;
    private static final int 連番9 = 9;
    private static final int 連番10 = 10;
    private static final int 連番11 = 11;
    private static final int 連番12 = 12;
    private static final int 連番13 = 13;
    private static final int 連番14 = 14;
    private static final int 連番15 = 15;
    private static final int 連番16 = 16;
    private static final int 連番17 = 17;
    private static final int 連番18 = 18;
    private static final int 連番19 = 19;
    private static final int 連番20 = 20;

    private ShinsaTaishoDataOutPutProcessParammeter processParamter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private IShinsaTaishoDataOutPutMapper mapper;
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
    protected void beforeExecute() {
        mapper = getMapper(IShinsaTaishoDataOutPutMapper.class);
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
        csvEntity.set厚労省認定ソフトのバージョン(RString.EMPTY);
        csvEntity.set証記載保険者番号(entity.get証記載保険者番号());
        csvEntity.set被保険者番号(entity.get被保険者番号());
        csvEntity.set認定申請年月日(entity.get認定申請年月日());
        csvEntity.set認定申請区分_申請時_コード(entity.get認定申請区分_申請時_コード());
        csvEntity.set認定申請区分_申請時(
                RString.isNullOrEmpty(entity.get認定申請区分_申請時_コード())
                ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分_申請時_コード()).get略称());
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
        csvEntity.set調査委託先(entity.get調査委託先());
        csvEntity.set認定調査員コード(entity.get認定調査員コード());
        csvEntity.set調査員氏名(entity.get調査員氏名());
        csvEntity.set概況特記テキスト_イメージ区分コード(entity.get概況特記テキスト_イメージ区分コード());
        csvEntity.set概況特記テキスト_イメージ区分(
                RString.isNullOrEmpty(entity.get概況特記テキスト_イメージ区分コード())
                ? RString.EMPTY : TokkijikoTextImageKubun.toValue(entity.get概況特記テキスト_イメージ区分コード()).get名称());
        csvEntity.set認定調査依頼区分コード(entity.get認定調査依頼区分コード());
        csvEntity.set認定調査依頼区分(
                RString.isNullOrEmpty(entity.get認定調査依頼区分コード())
                ? RString.EMPTY : NinteiChousaIraiKubunCode.toValue(entity.get認定調査依頼区分コード()).get名称());
        csvEntity.set認定調査回数(entity.get認定調査回数());
        csvEntity.set認定調査実施年月日(entity.get認定調査実施年月日());
        csvEntity.set認定調査受領年月日(entity.get認定調査受領年月日());
        csvEntity.set認定調査区分コード(entity.get認定調査区分コード());
        csvEntity.set認定調査区分(
                RString.isNullOrEmpty(entity.get認定調査区分コード())
                ? RString.EMPTY : ChosaKubun.toValue(entity.get認定調査区分コード()).get名称());
        csvEntity.set認定調査実施場所コード(entity.get認定調査実施場所コード());
        csvEntity.set認定調査実施場所(ChosaJisshiBashoCode.toValue(entity.get認定調査実施場所コード()).get名称());
        csvEntity.set認定調査実施場所名称(entity.get認定調査実施場所名称());
        csvEntity.set家族等連絡先郵便番号(entity.get家族等連絡先郵便番号());
        csvEntity.set家族等電話番号(entity.get家族等電話番号());
        csvEntity.set家族等住所(entity.get家族等住所());
        csvEntity.set家族等氏名(entity.get家族等氏名());
        csvEntity.set調査対象者との関係(entity.get調査対象者との関係());
        csvEntity.set認定調査_サービス区分コード(entity.get認定調査_サービス区分コード());
        csvEntity.set認定調査_サービス区分(
                RString.isNullOrEmpty(entity.get認定調査_サービス区分コード())
                ? RString.EMPTY : ServiceKubunCode.toValue(entity.get認定調査_サービス区分コード()).get名称());
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
        csvEntity.set認定調査認知症高齢者の日常生活自立度コード(entity.get認定調査認知症高齢者の日常生活自立度コード());
        csvEntity.set認定調査認知症高齢者の日常生活自立度(
                RString.isNullOrEmpty(entity.get認定調査認知症高齢者の日常生活自立度コード())
                ? RString.EMPTY : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get認定調査認知症高齢者の日常生活自立度コード()).get名称());
        csvEntity.set認定調査障害高齢者の日常生活自立度コード(entity.get認定調査障害高齢者の日常生活自立度コード());
        csvEntity.set認定調査障害高齢者の日常生活自立度(
                RString.isNullOrEmpty(entity.get認定調査障害高齢者の日常生活自立度コード())
                ? RString.EMPTY : ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get認定調査障害高齢者の日常生活自立度コード()).get名称());
        csvEntity.setステータス(RString.EMPTY);
        csvEntity.set中間評価項目得点第1群(entity.get中間評価項目得点第1群());
        csvEntity.set中間評価項目得点第2群(entity.get中間評価項目得点第2群());
        csvEntity.set中間評価項目得点第3群(entity.get中間評価項目得点第3群());
        csvEntity.set中間評価項目得点第4群(entity.get中間評価項目得点第4群());
        csvEntity.set中間評価項目得点第5群(entity.get中間評価項目得点第5群());
        csvEntity.set被保険者区分コード(entity.get被保険者区分コード());
        csvEntity.set被保険者区分名称(
                RString.isNullOrEmpty(entity.get被保険者区分コード())
                ? RString.EMPTY : HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get略称());
        csvEntity.set認知症自立度Ⅱ以上の蓋然性(entity.get認知症自立度Ⅱ以上の蓋然性());
        csvEntity.set給付区分コード(entity.get給付区分コード());
        csvEntity.set給付区分(
                RString.isNullOrEmpty(entity.get給付区分コード())
                ? RString.EMPTY : SuiteiKyufuKubunCode.toValue(entity.get給付区分コード()).get名称());
        csvEntity.set状態の安定性コード(entity.get状態の安定性コード());
        csvEntity.set状態の安定性(
                RString.isNullOrEmpty(entity.get状態の安定性コード())
                ? RString.EMPTY : JotaiAnteiseiCode.toValue(entity.get状態の安定性コード()).get名称());
        csvEntity.set二号特定疾病コード(entity.get二号特定疾病コード());
        csvEntity.set認定申請理由(entity.get認定申請理由());
        csvEntity.set要介護認定一次判定結果コード(entity.get要介護認定一次判定結果コード());
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード())) {
            csvEntity.set要介護認定一次判定結果(
                    RString.isNullOrEmpty(entity.get要介護認定一次判定結果コード())
                    ? RString.EMPTY : IchijiHanteiKekkaCode02.toValue(entity.get要介護認定一次判定結果コード()).get名称());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.get厚労省IF識別コード())) {
            csvEntity.set要介護認定一次判定結果(
                    RString.isNullOrEmpty(entity.get要介護認定一次判定結果コード())
                    ? RString.EMPTY : IchijiHanteiKekkaCode06.toValue(entity.get要介護認定一次判定結果コード()).get名称());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())) {
            csvEntity.set要介護認定一次判定結果(
                    RString.isNullOrEmpty(entity.get要介護認定一次判定結果コード())
                    ? RString.EMPTY : IchijiHanteiKekkaCode09.toValue(entity.get要介護認定一次判定結果コード()).get名称());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード())) {
            csvEntity.set要介護認定一次判定結果(
                    RString.isNullOrEmpty(entity.get要介護認定一次判定結果コード())
                    ? RString.EMPTY : IchijiHanteiKekkaCode99.toValue(entity.get要介護認定一次判定結果コード()).get名称());
        }
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
        csvEntity.set要介護認定1_5次判定年月日(RString.EMPTY);
        csvEntity.set要介護認定1_5次判定結果コード(RString.EMPTY);
        csvEntity.set要介護認定1_5次判定結果(RString.EMPTY);
        csvEntity.set要介護認定1_5次判定結果コード_認知症加算(RString.EMPTY);
        csvEntity.set要介護認定1_5次判定結果_認知症加算(RString.EMPTY);
        csvEntity.set要介護認定等基準時間_1_5次(null);
        csvEntity.set要介護認定等基準時間_食事_1_5次(null);
        csvEntity.set要介護認定等基準時間_排泄_1_5次(null);
        csvEntity.set要介護認定等基準時間_移動_1_5次(null);
        csvEntity.set要介護認定等基準時間_清潔保持_1_5次(null);
        csvEntity.set要介護認定等基準時間_間接ケア_1_5次(null);
        csvEntity.set要介護認定等基準時間_BPSD関連_1_5次(null);
        csvEntity.set要介護認定等基準時間_機能訓練_1_5次(null);
        csvEntity.set要介護認定等基準時間_医療関連_1_5次(null);
        csvEntity.set要介護認定等基準時間_認知症加算_1_5次(null);
        csvEntity.set中間評価項目得点第1群_1_5次(null);
        csvEntity.set中間評価項目得点第2群_1_5次(null);
        csvEntity.set中間評価項目得点第3群_1_5次(null);
        csvEntity.set中間評価項目得点第4群_1_5次(null);
        csvEntity.set中間評価項目得点第5群_1_5次(null);
        csvEntity.set要介護認定1_5次判定警告コード_1_5次(RString.EMPTY);
        csvEntity.set要介護認定状態の安定性コード_1_5次(RString.EMPTY);
        csvEntity.set認知症自立度Ⅱ以上の蓋然性_1_5次(null);
        csvEntity.set認知機能及び状態安定性から推定される給付区分コード_1_5次(RString.EMPTY);
        csvEntity.set短期記憶内容コード(RString.EMPTY);
        csvEntity.set短期記憶内容(RString.EMPTY);
        csvEntity.set認知能力内容コード(RString.EMPTY);
        csvEntity.set認知能力内容(RString.EMPTY);
        csvEntity.set伝達能力内容コード(RString.EMPTY);
        csvEntity.set伝達能力内容(RString.EMPTY);
        csvEntity.set食事行為内容コード(RString.EMPTY);
        csvEntity.set食事行為内容(RString.EMPTY);
        csvEntity.set介護認定審査会審査順(entity.get介護認定審査会審査順());

        csvEntity = setサービスの状況等(entity.get申請書管理番号(), entity.get認定調査依頼履歴番号(), csvEntity);
        csvEntity = set前回前々回情報(entity.get申請書管理番号(), csvEntity);
        csvEntity = set主治医意見書情報(entity.get申請書管理番号(), csvEntity);

        return csvEntity;
    }

    private GaikyoChosaDataEucCsvEntity setサービスの状況等(
            RString 申請書管理番号,
            Decimal 認定調査依頼履歴番号,
            GaikyoChosaDataEucCsvEntity csvEntity) {

        GaikyoChosaDataMybatisParameter parameter = GaikyoChosaDataMybatisParameter.createParamter(
                申請書管理番号,
                認定調査依頼履歴番号);
        GaikyoChosaData5207_08_09_10RelateEntity サービスの状況等リスト = mapper.get概況調査データサービスの状況等(parameter);

        if (サービスの状況等リスト == null) {
            return csvEntity;
        }
        csvEntity = setサービスの状況(csvEntity, サービスの状況等リスト.getサービスの状況リスト());
        csvEntity = setサービスの状況フラグ(csvEntity, サービスの状況等リスト.getサービスの状況フラグリスト());
        csvEntity = set記入項目(csvEntity, サービスの状況等リスト.get記入項目リスト());
        csvEntity = set施設利用(csvEntity, サービスの状況等リスト.get施設利用リスト());

        return csvEntity;
    }

    private GaikyoChosaDataEucCsvEntity setサービスの状況(
            GaikyoChosaDataEucCsvEntity csvEntity,
            List<DbT5207NinteichosahyoServiceJokyoEntity> サービスの状況リスト) {

        for (DbT5207NinteichosahyoServiceJokyoEntity サービスの状況 : サービスの状況リスト) {
            if (サービスの状況.getRemban() == 連番1) {
                csvEntity.setサービスの状況連番01(サービスの状況.getRemban());
                csvEntity.setサービスの状況01(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番2) {
                csvEntity.setサービスの状況連番02(サービスの状況.getRemban());
                csvEntity.setサービスの状況02(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番3) {
                csvEntity.setサービスの状況連番03(サービスの状況.getRemban());
                csvEntity.setサービスの状況03(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番4) {
                csvEntity.setサービスの状況連番04(サービスの状況.getRemban());
                csvEntity.setサービスの状況04(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番5) {
                csvEntity.setサービスの状況連番05(サービスの状況.getRemban());
                csvEntity.setサービスの状況05(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番6) {
                csvEntity.setサービスの状況連番06(サービスの状況.getRemban());
                csvEntity.setサービスの状況06(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番7) {
                csvEntity.setサービスの状況連番07(サービスの状況.getRemban());
                csvEntity.setサービスの状況07(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番8) {
                csvEntity.setサービスの状況連番08(サービスの状況.getRemban());
                csvEntity.setサービスの状況08(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番9) {
                csvEntity.setサービスの状況連番09(サービスの状況.getRemban());
                csvEntity.setサービスの状況09(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番10) {
                csvEntity.setサービスの状況連番10(サービスの状況.getRemban());
                csvEntity.setサービスの状況10(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番11) {
                csvEntity.setサービスの状況連番11(サービスの状況.getRemban());
                csvEntity.setサービスの状況11(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番12) {
                csvEntity.setサービスの状況連番12(サービスの状況.getRemban());
                csvEntity.setサービスの状況12(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番13) {
                csvEntity.setサービスの状況連番13(サービスの状況.getRemban());
                csvEntity.setサービスの状況13(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番14) {
                csvEntity.setサービスの状況連番14(サービスの状況.getRemban());
                csvEntity.setサービスの状況14(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番15) {
                csvEntity.setサービスの状況連番15(サービスの状況.getRemban());
                csvEntity.setサービスの状況15(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番16) {
                csvEntity.setサービスの状況連番16(サービスの状況.getRemban());
                csvEntity.setサービスの状況16(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番17) {
                csvEntity.setサービスの状況連番17(サービスの状況.getRemban());
                csvEntity.setサービスの状況17(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番18) {
                csvEntity.setサービスの状況連番18(サービスの状況.getRemban());
                csvEntity.setサービスの状況18(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番19) {
                csvEntity.setサービスの状況連番19(サービスの状況.getRemban());
                csvEntity.setサービスの状況19(サービスの状況.getServiceJokyo());
            } else if (サービスの状況.getRemban() == 連番20) {
                csvEntity.setサービスの状況連番20(サービスの状況.getRemban());
                csvEntity.setサービスの状況20(サービスの状況.getServiceJokyo());
            }
        }

        return csvEntity;
    }

    private GaikyoChosaDataEucCsvEntity setサービスの状況フラグ(
            GaikyoChosaDataEucCsvEntity csvEntity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> サービスの状況フラグリスト) {

        for (DbT5208NinteichosahyoServiceJokyoFlagEntity サービスの状況フラグ : サービスの状況フラグリスト) {
            if (サービスの状況フラグ.getRemban() == 連番1) {
                csvEntity.setサービスの状況フラグ連番(サービスの状況フラグ.getRemban());
                csvEntity.setサービスの状況フラグ(サービスの状況フラグ.getServiceJokyoFlag());
            }
        }
        return csvEntity;
    }

    private GaikyoChosaDataEucCsvEntity set記入項目(
            GaikyoChosaDataEucCsvEntity csvEntity,
            List<DbT5209NinteichosahyoKinyuItemEntity> 記入項目リスト) {

        for (DbT5209NinteichosahyoKinyuItemEntity 記入項目 : 記入項目リスト) {
            if (記入項目.getRemban() == 連番1) {
                csvEntity.set記入項目連番01(記入項目.getRemban());
                csvEntity.setサービスの状況記入01(記入項目.getServiceJokyoKinyu());
            } else if (記入項目.getRemban() == 連番2) {
                csvEntity.set記入項目連番02(記入項目.getRemban());
                csvEntity.setサービスの状況記入02(記入項目.getServiceJokyoKinyu());
            }
        }
        return csvEntity;
    }

    private GaikyoChosaDataEucCsvEntity set施設利用(
            GaikyoChosaDataEucCsvEntity csvEntity,
            List<DbT5210NinteichosahyoShisetsuRiyoEntity> 施設利用リスト) {
        for (DbT5210NinteichosahyoShisetsuRiyoEntity 施設利用 : 施設利用リスト) {
            if (施設利用.getRemban() == 連番1) {
                csvEntity.set施設利用連番01(施設利用.getRemban());
                csvEntity.set施設利用フラグ01(施設利用.getShisetsuRiyoFlag());
            } else if (施設利用.getRemban() == 連番2) {
                csvEntity.set施設利用連番02(施設利用.getRemban());
                csvEntity.set施設利用フラグ02(施設利用.getShisetsuRiyoFlag());
            } else if (施設利用.getRemban() == 連番3) {
                csvEntity.set施設利用連番03(施設利用.getRemban());
                csvEntity.set施設利用フラグ03(施設利用.getShisetsuRiyoFlag());
            } else if (施設利用.getRemban() == 連番4) {
                csvEntity.set施設利用連番04(施設利用.getRemban());
                csvEntity.set施設利用フラグ04(施設利用.getShisetsuRiyoFlag());
            } else if (施設利用.getRemban() == 連番5) {
                csvEntity.set施設利用連番05(施設利用.getRemban());
                csvEntity.set施設利用フラグ05(施設利用.getShisetsuRiyoFlag());
            } else if (施設利用.getRemban() == 連番6) {
                csvEntity.set施設利用連番06(施設利用.getRemban());
                csvEntity.set施設利用フラグ06(施設利用.getShisetsuRiyoFlag());
            } else if (施設利用.getRemban() == 連番7) {
                csvEntity.set施設利用連番07(施設利用.getRemban());
                csvEntity.set施設利用フラグ07(施設利用.getShisetsuRiyoFlag());
            } else if (施設利用.getRemban() == 連番8) {
                csvEntity.set施設利用連番08(施設利用.getRemban());
                csvEntity.set施設利用フラグ08(施設利用.getShisetsuRiyoFlag());
            } else if (施設利用.getRemban() == 連番9) {
                csvEntity.set施設利用連番09(施設利用.getRemban());
                csvEntity.set施設利用フラグ09(施設利用.getShisetsuRiyoFlag());
            }
        }
        return csvEntity;
    }

    private GaikyoChosaDataEucCsvEntity set前回前々回情報(
            RString 申請書管理番号,
            GaikyoChosaDataEucCsvEntity csvEntity) {

        GaikyoChosaDataMybatisParameter parameter = GaikyoChosaDataMybatisParameter.createParamter(
                申請書管理番号);
        GaikyoChosaDataZenkaiJohoRelateEntity 前回情報 = mapper.get概況調査データ前回情報(parameter);

        if (前回情報 == null) {
            return csvEntity;
        } else {
            csvEntity = set前回情報(csvEntity, 前回情報);
        }

        parameter = GaikyoChosaDataMybatisParameter.createParamter(
                前回情報.get申請書管理番号());

        GaikyoChosaDataZenkaiJohoRelateEntity 前々回情報 = mapper.get概況調査データ前回情報(parameter);

        if (前々回情報 == null) {
            return csvEntity;
        } else {
            csvEntity = set前々回情報(csvEntity, 前々回情報);
        }

        return csvEntity;
    }

    private GaikyoChosaDataEucCsvEntity set前回情報(
            GaikyoChosaDataEucCsvEntity csvEntity,
            GaikyoChosaDataZenkaiJohoRelateEntity 前回情報) {

        csvEntity.set前回_審査会開催番号(前回情報.get審査会開催番号());
        csvEntity.set前回_認定有効開始年月日(前回情報.get認定有効開始年月日());
        csvEntity.set前回_認定有効終了年月日(前回情報.get認定有効終了年月日());
        csvEntity.set前回_認定期間(前回情報.get認定期間());
        csvEntity.set前回_二次判定日(前回情報.get二次判定日());
        csvEntity.set前回_申請区分_申(前回情報.get申請区分_申());
        csvEntity.set前回_申請区分_法(前回情報.get申請区分_法());
        csvEntity.set前回_通知区分(前回情報.get通知区分());
        csvEntity.set前回_特定疾病(前回情報.get特定疾病());
        csvEntity.set前回_一次判定(前回情報.get一次判定());
        csvEntity.set前回_二次判定(前回情報.get二次判定());
        csvEntity.set前回_状態像(前回情報.get状態像());
        csvEntity.set前回_審査会メモ(前回情報.get審査会メモ());
        csvEntity.set前回_審査会意見(前回情報.get審査会意見());

        return csvEntity;
    }

    private GaikyoChosaDataEucCsvEntity set前々回情報(
            GaikyoChosaDataEucCsvEntity csvEntity,
            GaikyoChosaDataZenkaiJohoRelateEntity 前々回情報) {

        csvEntity.set前々回_審査会開催番号(前々回情報.get審査会開催番号());
        csvEntity.set前々回_認定有効開始年月日(前々回情報.get認定有効開始年月日());
        csvEntity.set前々回_認定有効終了年月日(前々回情報.get認定有効終了年月日());
        csvEntity.set前々回_認定期間(前々回情報.get認定期間());
        csvEntity.set前々回_二次判定日(前々回情報.get二次判定日());
        csvEntity.set前々回_申請区分_申(前々回情報.get申請区分_申());
        csvEntity.set前々回_申請区分_法(前々回情報.get申請区分_法());
        csvEntity.set前々回_通知区分(前々回情報.get通知区分());
        csvEntity.set前々回_特定疾病(前々回情報.get特定疾病());
        csvEntity.set前々回_一次判定(前々回情報.get一次判定());
        csvEntity.set前々回_二次判定(前々回情報.get二次判定());
        csvEntity.set前々回_状態像(前々回情報.get状態像());
        csvEntity.set前々回_審査会メモ(前々回情報.get審査会メモ());
        csvEntity.set前々回_審査会意見(前々回情報.get審査会意見());

        return csvEntity;
    }

    private GaikyoChosaDataEucCsvEntity set主治医意見書情報(
            RString 申請書管理番号,
            GaikyoChosaDataEucCsvEntity csvEntity) {

        GaikyoChosaDataMybatisParameter parameter = GaikyoChosaDataMybatisParameter.createParamter(
                申請書管理番号);
        List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書意見項目リスト = mapper.get要介護認定主治医意見書意見項目(parameter);

        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書意見項目 : 主治医意見書意見項目リスト) {
            if (主治医意見書意見項目.getRemban() == 連番14) {
                csvEntity.set主治医認定調査認知症高齢者の日常生活自立度コード(主治医意見書意見項目.getIkenItem());
                csvEntity.set主治医認定調査認知症高齢者の日常生活自立度(
                        RString.isNullOrEmpty(主治医意見書意見項目.getIkenItem())
                        ? RString.EMPTY : IkenKomoku03.toValue(主治医意見書意見項目.getIkenItem()).get名称());
            }
            if (主治医意見書意見項目.getRemban() == 連番13) {
                csvEntity.set主治医認定調査障害高齢者の日常生活自立度コード(主治医意見書意見項目.getIkenItem());
                csvEntity.set主治医認定調査障害高齢者の日常生活自立度(
                        RString.isNullOrEmpty(主治医意見書意見項目.getIkenItem())
                        ? RString.EMPTY : IkenKomoku02.toValue(主治医意見書意見項目.getIkenItem()).get名称());
            }
        }

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
