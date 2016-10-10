/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishosetaiinido.TaishoSetaiinIdoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.CreateShoriResultCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.Shotai;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.TaishoSetaiin;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc190030.ShoriResultCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.taishosetaiinido.TaishoSetaiinIdoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.taishosetaiinido.ITaishoSetaiinIdoMapper;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * ビジネス設計_DBC110065_基準収入額適用申請書_異動分作成_対象世帯員するクラスです。
 *
 * @reamsid_L DBC-4640-080 xuzhao
 */
public class CreateShoriResultCsvFileProcess extends BatchProcessBase<DbT3116KijunShunyugakuTekiyoKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence"
            + ".db.mapper.relate.taishosetaiinido.ITaishoSetaiinIdoMapper.select基準収入額適用管理マスタ");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 処理結果確認リスト = new RString("処理結果確認リスト.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBU900002");
    private static final RString DATA_世帯コード = new RString("世帯コード");
    private static final RString DATA_被保険者番号 = new RString("被保険者番号");
    private static final RString DATA_対象者判定 = new RString("対象者判定");
    private static final RString DATA_ENTITY_ID = new RString("DBC110065");
    private static final RString DATA_資格喪失 = new RString("資格喪失、認定期間切れ等によって対象外になりました。");
    private static final RString 異動分 = new RString("0001");
    private static final RString 被保険者番号 = new RString("0002");
    private static final RString 基準収入額適用申請書 = new RString("0001");
    private static final RString 無条件抽出 = new RString("0002");
    private static final RString 課税 = new RString("1");
    private static final RString 非課税 = new RString("2");
    private static final RString 資格区分_1 = new RString("1");
    private static final RString 資格区分_3 = new RString("3");
    private static final RString 第１号被保険者あり = new RString("1");
    private static final RString 第１号被保険者なし = new RString("2");
    private static final Decimal DATA_145 = new Decimal("1450000");
    private static final Decimal DATA_383 = new Decimal("3830000");
    private static final Decimal DATA_520 = new Decimal("5200000");
    private static final RString 出力する = new RString("1");
    private static final RString 出力しない = new RString("2");
    private static final RString DATA_第１号被保険者が存在
            = new RString("世帯内に第１号被保険者が存在しないため、申請書を出力しません");
    private static final RString DATA_非課税のため
            = new RString("世帯課税が非課税のため、申請書を出力しません");
    private static final RString DATA_世帯員が存在しないため申請書
            = new RString("課税所得が145万円以上の世帯員が存在しないため、申請書を出力しません");
    private static final RString DATA_単独世帯
            = new RString("単独世帯で総収入額が383万円以上のため、申請書を出力しません");
    private static final RString DATA_複数世帯
            = new RString("複数世帯で総収入額が520万円以上のため、申請書を出力しません");
    private static final RString DATA_既に発行済み
            = new RString("既に発行済みのため、申請書を出力しません");
    private static final RString DATA_世帯把握基準日が遡
            = new RString("世帯把握基準日が遡っているため、申請書を出力しません");

    private CreateShoriResultCsvFileProcessParameter parameter;
    private RString 処理結果確認リストＣＳＶFilePath;
    private FileSpoolManager manager;
    private RString 市町村コード;
    private RString 市町村名;
    private ITaishoSetaiinIdoMapper mapper;
    private boolean flag;
    private TaishoSetaiin 対象世帯員クラス;

    @BatchWriter
    CsvWriter<ShoriResultCsvEntity> 処理結果確認リストＣＳＶ;

    @Override
    protected void initialize() {
        市町村コード = AssociationFinderFactory.createInstance().getAssociation()
                .get地方公共団体コード().code市町村RString();
        市町村名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
        mapper = getMapper(ITaishoSetaiinIdoMapper.class);
        対象世帯員クラス = extractTaishosha(parameter.get抽出条件(),
                parameter.get抽出対象(), parameter.get世帯員把握基準日(), parameter.get対象世帯員クラス());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toTaishoSetaiinIdoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        処理結果確認リストＣＳＶFilePath = Path.combinePath(spoolWorkPath, 処理結果確認リスト);
        処理結果確認リストＣＳＶ = BatchWriters.csvWriter(ShoriResultCsvEntity.class)
                .filePath(処理結果確認リストＣＳＶFilePath)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(DbT3116KijunShunyugakuTekiyoKanriEntity t) {
        if (!(対象世帯員クラス.get世帯コード().equals(new RString((t.getSetaiCode().toString()))))) {
            ShoriResultCsvEntity csvEntity = new ShoriResultCsvEntity();
            csvEntity.set市町村コード(市町村コード);
            csvEntity.set市町村名(市町村名);
            csvEntity.set処理日時(RDate.getNowDate().toDateString());
            csvEntity.setキー項目1(DATA_世帯コード);
            csvEntity.setキー項目2(DATA_被保険者番号);
            csvEntity.setキー項目3(RString.EMPTY);
            csvEntity.setキー項目4(RString.EMPTY);
            csvEntity.setキー項目5(RString.EMPTY);
            csvEntity.setプログラム名_上(DATA_対象者判定);
            csvEntity.setプログラム名_下(DATA_ENTITY_ID);
            csvEntity.set項目1(t.getSetaiCode().getColumnValue());
            csvEntity.set項目2(t.getHihokenshaNo().getColumnValue());
            csvEntity.set項目3(RString.EMPTY);
            csvEntity.set項目4(RString.EMPTY);
            csvEntity.set項目5(RString.EMPTY);
            csvEntity.set内容_上(DATA_資格喪失);
            csvEntity.set内容_下(RString.EMPTY);
            処理結果確認リストＣＳＶ.writeLine(csvEntity);
        }
    }

    @Override
    protected void afterExecute() {
        処理結果確認リストＣＳＶ.close();
        manager.spool(SubGyomuCode.DBC介護給付, 処理結果確認リストＣＳＶFilePath);
    }

    private TaishoSetaiin extractTaishosha(RString 抽出条件, RString 抽出対象, FlexibleDate 世帯員把握基準日, TaishoSetaiin 対象世帯員クラス) {
        Collections.sort(対象世帯員クラス.get世帯員情報(), new Comparator<Shotai>() {
            @Override
            public int compare(Shotai o1, Shotai o2) {
                int flag = o1.get受給区分().compareTo(o2.get受給区分());
                if (0 == flag) {
                    flag = o1.get被保険者番号().compareTo(o2.get被保険者番号());
                }
                return flag;
            }
        });
        対象世帯員クラス.set総収入額(Decimal.ZERO);
        TaishoSetaiin temp_対象世帯員クラス = new TaishoSetaiin();
        temp_対象世帯員クラス = temp_対象世帯員クラス.clone(対象世帯員クラス);
        if (異動分.equals(抽出条件) || (被保険者番号.equals(抽出条件) && 基準収入額適用申請書.equals(抽出対象))) {
            settei(対象世帯員クラス, temp_対象世帯員クラス);
            hanntei(対象世帯員クラス, temp_対象世帯員クラス, 世帯員把握基準日);
            if (異動分.equals(抽出条件) && 出力しない.equals(対象世帯員クラス.get出力有無())
                    && (DATA_第１号被保険者が存在.equals(対象世帯員クラス.getメッセージ())
                    || DATA_非課税のため.equals(対象世帯員クラス.getメッセージ())
                    || DATA_世帯員が存在しないため申請書.equals(対象世帯員クラス.getメッセージ())
                    || DATA_単独世帯.equals(対象世帯員クラス.getメッセージ())
                    || DATA_複数世帯.equals(対象世帯員クラス.getメッセージ()))) {
                mapper.select基準収入額適用管理情報(TaishoSetaiinIdoMybatisParameter
                        .createMybatisParam(対象世帯員クラス.get世帯コード(), 対象世帯員クラス.get処理年度()));
            }
        } else if (被保険者番号.equals(抽出条件)
                && 無条件抽出.equals(抽出対象)) {
            hanntei(対象世帯員クラス, temp_対象世帯員クラス, 世帯員把握基準日);
        }

        return temp_対象世帯員クラス;
    }

    private void hanntei(TaishoSetaiin 対象世帯員クラス, TaishoSetaiin temp_対象世帯員クラス, FlexibleDate 世帯員把握基準日) {
        temp_対象世帯員クラス.setメッセージ(RString.EMPTY);
        temp_対象世帯員クラス.set出力有無(出力する);
        for (Shotai shotailist : 対象世帯員クラス.get世帯員情報()) {
            if (資格区分_1.equals(shotailist.get資格区分())) {
                if (非課税.equals(対象世帯員クラス.get世帯員情報().get(0).get課税区分())) {
                    temp_対象世帯員クラス.setメッセージ(DATA_非課税のため);
                    temp_対象世帯員クラス.set出力有無(出力しない);
                } else if (第１号被保険者なし.equals(temp_対象世帯員クラス.get課税所得区分())) {
                    temp_対象世帯員クラス.setメッセージ(DATA_世帯員が存在しないため申請書);
                    temp_対象世帯員クラス.set出力有無(出力しない);
                } else if (対象世帯員クラス.get世帯員情報().size() == 1 && !(temp_対象世帯員クラス.get総収入額().compareTo(DATA_383) < 0)) {
                    temp_対象世帯員クラス.setメッセージ(DATA_単独世帯);
                    temp_対象世帯員クラス.set出力有無(出力しない);
                } else if ((!(対象世帯員クラス.get世帯員情報().size() < 2)) && (!(temp_対象世帯員クラス.get総収入額().compareTo(DATA_520) < 0))) {
                    temp_対象世帯員クラス.setメッセージ(DATA_複数世帯);
                    temp_対象世帯員クラス.set出力有無(出力しない);
                }
                break;
            } else {
                temp_対象世帯員クラス.setメッセージ(DATA_第１号被保険者が存在);
                temp_対象世帯員クラス.set出力有無(出力しない);
            }
        }
        if (出力する.equals(temp_対象世帯員クラス.get出力有無())) {

            TaishoSetaiinIdoMybatisParameter mybatiParameter = TaishoSetaiinIdoMybatisParameter
                    .createMybatisParam(対象世帯員クラス.get世帯コード(), 対象世帯員クラス.get処理年度());

            List<TaishoSetaiinIdoEntity> entityList = mapper.select基準収入額適用管理(mybatiParameter);
            if (entityList.isEmpty()) {
                temp_対象世帯員クラス.set更新時履歴番号(対象世帯員クラス.get更新時履歴番号() + 1);
            }
            for (TaishoSetaiinIdoEntity taishosetaiinidoentity : entityList) {
                for (Shotai shotailist_1 : 対象世帯員クラス.get世帯員情報()) {
                    flag = false;
                    if (taishosetaiinidoentity.getHihokenshaNo().equals(shotailist_1.get被保険者番号())) {
                        flag = true;
                    }
                    if (!flag) {
                        break;
                    }
                }
            }

            set対象世帯員(entityList, 対象世帯員クラス, temp_対象世帯員クラス, flag, 世帯員把握基準日);

        }
    }

    private TaishoSetaiin settei(TaishoSetaiin 対象世帯員クラス, TaishoSetaiin temp_対象世帯員クラス) {
        Decimal 年金収入 = Decimal.ZERO;
        Decimal 合計所得 = Decimal.ZERO;
        for (Shotai shotailist : 対象世帯員クラス.get世帯員情報()) {
            if (課税.equals(shotailist.get課税区分())) {
                temp_対象世帯員クラス.set世帯課税区分(課税);
                break;
            } else {
                temp_対象世帯員クラス.set世帯課税区分(非課税);
            }
        }
        for (Shotai shotailist : 対象世帯員クラス.get世帯員情報()) {
            RString rs資格区分 = shotailist.get資格区分();
            if ((資格区分_1.equals(rs資格区分) || 資格区分_3.equals(rs資格区分)) && (!(shotailist.get課税所得_控除後().compareTo(DATA_145) < 0))) {
                temp_対象世帯員クラス.set課税所得区分(第１号被保険者あり);
                break;
            } else {
                temp_対象世帯員クラス.set課税所得区分(第１号被保険者なし);
            }
        }
        for (Shotai shotailist : 対象世帯員クラス.get世帯員情報()) {
            if (資格区分_1.equals(shotailist.get資格区分()) || 資格区分_3.equals(shotailist.get資格区分())) {
                年金収入 = 年金収入.add(shotailist.get年金収入());
            }
            合計所得 = 合計所得.add(shotailist.getその他の合計所得());
        }
        temp_対象世帯員クラス.set総収入額(年金収入.add(合計所得));
        return temp_対象世帯員クラス;
    }

    private void set対象世帯員(List<TaishoSetaiinIdoEntity> entityList,
            TaishoSetaiin 対象世帯員クラス, TaishoSetaiin temp_対象世帯員クラス,
            boolean flag, FlexibleDate 世帯員把握基準日) {
        if (entityList.isEmpty()) {
            temp_対象世帯員クラス.set更新時履歴番号(対象世帯員クラス.get更新時履歴番号() + 1);
        }

        for (TaishoSetaiinIdoEntity taishosetaiinidoentity : entityList) {
            if (taishosetaiinidoentity.getShinseishoSakuseiSetaiKijunYMD().isBeforeOrEquals(世帯員把握基準日)) {
                if (flag) {
                    temp_対象世帯員クラス.setメッセージ(DATA_既に発行済み);
                    temp_対象世帯員クラス.set出力有無(出力しない);
                } else {
                    temp_対象世帯員クラス.set更新時履歴番号(taishosetaiinidoentity.getRirekiNo() + 1);
                }
            } else {
                temp_対象世帯員クラス.setメッセージ(DATA_世帯把握基準日が遡);
                temp_対象世帯員クラス.set出力有無(出力しない);
            }
        }
    }
}
