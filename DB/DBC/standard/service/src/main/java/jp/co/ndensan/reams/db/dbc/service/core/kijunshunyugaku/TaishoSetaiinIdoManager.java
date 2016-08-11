/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kijunshunyugaku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku.Shotai;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku.TaishoSetaiin;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishosetaiinido.TaishoSetaiinIdoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.taishosetaiinido.TaishoSetaiinIdoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3116KijunShunyugakuTekiyoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.taishosetaiinido.ITaishoSetaiinIdoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBC110065_基準収入額適用申請書_異動分作成_対象世帯員するクラスです。
 *
 * @reamsid_L DBC-4640-080 liuxiaoyu
 */
public class TaishoSetaiinIdoManager {

    private static final int INT_0 = 0;
    private static final RString タイトル_市町村コード = new RString("市町村コード");
    private static final RString タイトル_市町村名 = new RString("市町村名");
    private static final RString タイトル_処理日時 = new RString("処理日時");
    private static final RString タイトル_キー項目１ = new RString("キー項目１");
    private static final RString タイトル_キー項目２ = new RString("キー項目２");
    private static final RString タイトル_キー項目３ = new RString("キー項目３");
    private static final RString タイトル_キー項目4 = new RString("キー項目4");
    private static final RString タイトル_キー項目5 = new RString("キー項目5");
    private static final RString タイトル_プログラム名上 = new RString("プログラム名(上)");
    private static final RString タイトル_プログラム名下 = new RString("プログラム名（下）");
    private static final RString タイトル_項目１ = new RString("項目１");
    private static final RString タイトル_項目2 = new RString("項目2");
    private static final RString タイトル_項目3 = new RString("項目3");
    private static final RString タイトル_項目4 = new RString("項目4");
    private static final RString タイトル_項目5 = new RString("項目5");
    private static final RString タイトル_内容上 = new RString("内容（上）");
    private static final RString タイトル_内容下 = new RString("内容（下）");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 処理結果確認リスト = new RString("処理結果確認リスト.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC110065");
    private static final RString DATA_世帯コード = new RString("世帯コード");
    private static final RString DATA_被保険者番号 = new RString("被保険者番号");
    private static final RString DATA_対象者判定 = new RString("対象者判定");
    private static final RString DATA_ENTITY_ID = new RString("DBC110065");
    private static final RString DATA_資格喪失 = new RString("資格喪失、認定期間切れ等によって対象外になりました。");
    private final DbT3116KijunShunyugakuTekiyoKanriDac 基準収入額適用管理Dac;
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
    private final DbT3116KijunShunyugakuTekiyoKanriDac dac;
    private final MapperProvider mapperProvider;
    private boolean hanndann;

    /**
     * コンストラクタです。
     */
    public TaishoSetaiinIdoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT3116KijunShunyugakuTekiyoKanriDac.class);
        this.基準収入額適用管理Dac = InstanceProvider.create(DbT3116KijunShunyugakuTekiyoKanriDac.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TaishoSetaiinIdoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TaishoSetaiinIdoManager}のインスタンス
     */
    public static TaishoSetaiinIdoManager createInstance() {
        return InstanceProvider.create(TaishoSetaiinIdoManager.class);
    }

    /**
     * 対象者抽出メソッドです。
     *
     * @param 抽出条件 Rsting
     * @param 抽出対象 Rsting
     * @param 世帯員把握基準日 FlexibleDate
     * @param 対象世帯員クラス TaishoSetaiin
     * @return 対象世帯員クラス
     */
    public TaishoSetaiin extractTaishosha(RString 抽出条件, RString 抽出対象, FlexibleDate 世帯員把握基準日, TaishoSetaiin 対象世帯員クラス) {
        Collections.sort(対象世帯員クラス.get世帯員情報(), new Comparator<Shotai>() {
            @Override
            public int compare(Shotai o1, Shotai o2) {
                int flag = o2.get受給区分().compareTo(o1.get受給区分());
                if (0 == flag) {
                    flag = o2.get被保険者番号().compareTo(o1.get被保険者番号());
                }

                return flag;
            }
        });
        対象世帯員クラス.set総収入額(Decimal.ZERO);
        TaishoSetaiin temp_対象世帯員クラス = new TaishoSetaiin();
        temp_対象世帯員クラス = temp_対象世帯員クラス.clone(対象世帯員クラス);
        if (異動分.equals(抽出条件) || (被保険者番号.equals(抽出条件) && 基準収入額適用申請書.equals(抽出対象))) {
            settei(対象世帯員クラス, temp_対象世帯員クラス);
            hanntei(対象世帯員クラス, temp_対象世帯員クラス);
            if (異動分.equals(抽出条件) && 出力しない.equals(対象世帯員クラス.get出力有無())
                    && (DATA_第１号被保険者が存在.equals(対象世帯員クラス.getメッセージ())
                    || DATA_非課税のため.equals(対象世帯員クラス.getメッセージ())
                    || DATA_世帯員が存在しないため申請書.equals(対象世帯員クラス.getメッセージ())
                    || DATA_単独世帯.equals(対象世帯員クラス.getメッセージ())
                    || DATA_複数世帯.equals(対象世帯員クラス.getメッセージ()))) {
                List<DbT3116KijunShunyugakuTekiyoKanriEntity> kijunlist = new ArrayList();
                kijunlist = dac.selectJouhousootoNendo(対象世帯員クラス.get世帯コード(), 対象世帯員クラス.get処理年度());
            }
        } else if (被保険者番号.equals(抽出条件)
                && 無条件抽出.equals(抽出対象)) {
            hanntei(対象世帯員クラス, temp_対象世帯員クラス);
        }

        return temp_対象世帯員クラス;
    }

    /**
     * 処理結果確認リスト出力です。
     *
     * @param 対象世帯員クラス TaishoSetaiin
     * @param 年度 FlexibleYear
     *
     */
    public void kekkaKakuninListOutput(TaishoSetaiin 対象世帯員クラス, FlexibleYear 年度) {
        List<DbT3116KijunShunyugakuTekiyoKanriEntity> list_select基準収入額適用管理マスタ = dac.select基準収入額適用管理マスタ(年度);
        for (DbT3116KijunShunyugakuTekiyoKanriEntity dbt3116entity : list_select基準収入額適用管理マスタ) {
            if (!(対象世帯員クラス.get世帯コード().equals(dbt3116entity.getSetaiCode()))) {
                publish処理結果確認リスト(list_select基準収入額適用管理マスタ);
            }
        }

    }

    /**
     * ょうかい照会 の けっか結果の はんだん判断です。
     *
     * @param 対象世帯員クラス TaishoSetaiin
     * @param temp_対象世帯員クラス TaishoSetaiin
     *
     */
    private void hanntei(TaishoSetaiin 対象世帯員クラス, TaishoSetaiin temp_対象世帯員クラス) {
        temp_対象世帯員クラス.setメッセージ(null);
        temp_対象世帯員クラス.set出力有無(出力する);
        for (Shotai shotailist : 対象世帯員クラス.get世帯員情報()) {
            if (!(資格区分_1.equals(shotailist.get資格区分()))) {
                temp_対象世帯員クラス.setメッセージ(DATA_第１号被保険者が存在);
                temp_対象世帯員クラス.set出力有無(出力しない);
            } else if (非課税.equals(対象世帯員クラス.get世帯員情報().get(0).get課税区分())) {
                temp_対象世帯員クラス.setメッセージ(DATA_非課税のため);
                temp_対象世帯員クラス.set出力有無(出力しない);
            } else if (第１号被保険者なし.equals(対象世帯員クラス.get課税所得区分())) {
                temp_対象世帯員クラス.setメッセージ(DATA_世帯員が存在しないため申請書);
                temp_対象世帯員クラス.set出力有無(出力しない);
            } else if (対象世帯員クラス.get世帯員情報().size() == 1 && !(対象世帯員クラス.get総収入額().compareTo(DATA_383) < 0)) {
                temp_対象世帯員クラス.setメッセージ(DATA_単独世帯);
                temp_対象世帯員クラス.set出力有無(出力しない);
            } else if ((!(対象世帯員クラス.get世帯員情報().size() < 2)) && (!(対象世帯員クラス.get総収入額().compareTo(DATA_520) < 0))) {
                temp_対象世帯員クラス.setメッセージ(DATA_複数世帯);
                temp_対象世帯員クラス.set出力有無(出力しない);

                if (出力する.equals(対象世帯員クラス.get出力有無())) {

                    TaishoSetaiinIdoMybatisParameter parameter = TaishoSetaiinIdoMybatisParameter
                            .createMybatisParam(対象世帯員クラス.get世帯コード(), 対象世帯員クラス.get処理年度());
                    ITaishoSetaiinIdoMapper mapper = mapperProvider.create(ITaishoSetaiinIdoMapper.class);
                    List<TaishoSetaiinIdoEntity> entityList = mapper.select基準収入額適用管理(parameter);
                    set対象世帯員(entityList, shotailist, 対象世帯員クラス, temp_対象世帯員クラス);
                }
            }
        }

    }

    /**
     * 世帯課税の設定,課税所得の設定,です。
     *
     * @param 対象世帯員クラス TaishoSetaiin
     * @param temp_対象世帯員クラス TaishoSetaiin
     *
     */
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

    /**
     * 更新時履歴番号の設定,メッセージの設定,出力有無の設定です。
     *
     * @param entityList List<TaishoSetaiinIdoEntity>
     * @param shotailist Shotai
     * @param 対象世帯員クラス TaishoSetaiin
     * @param temp_対象世帯員クラス TaishoSetaiin
     *
     */
    private void set対象世帯員(List<TaishoSetaiinIdoEntity> entityList, Shotai shotailist, TaishoSetaiin 対象世帯員クラス, TaishoSetaiin temp_対象世帯員クラス) {
        if (entityList.isEmpty()) {
            temp_対象世帯員クラス.set更新時履歴番号(対象世帯員クラス.get更新時履歴番号() + 1);
        }
        for (TaishoSetaiinIdoEntity taishosetaiinidoentity : entityList) {
            if (!(0 < taishosetaiinidoentity.getShinseishoSakuseiSetaiKijunYMD().compareTo(対象世帯員クラス.get世帯員把握基準日()))) {
                if (taishosetaiinidoentity.getHihokenshaNo().equals(shotailist.get被保険者番号())) {
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

    /**
     * 処理結果確認リストです。
     *
     * @param list_select基準収入額適用管理マスタ
     * List<DbT3116KijunShunyugakuTekiyoKanriEntity>
     *
     */
    public void publish処理結果確認リスト(List<DbT3116KijunShunyugakuTekiyoKanriEntity> list_select基準収入額適用管理マスタ) {
        List<RString> headerList = new ArrayList<>();
        headerList.add(タイトル_市町村コード);
        headerList.add(タイトル_市町村名);
        headerList.add(タイトル_処理日時);
        headerList.add(タイトル_キー項目１);
        headerList.add(タイトル_キー項目２);
        headerList.add(タイトル_キー項目３);
        headerList.add(タイトル_キー項目4);
        headerList.add(タイトル_キー項目5);
        headerList.add(タイトル_プログラム名上);
        headerList.add(タイトル_プログラム名下);
        headerList.add(タイトル_項目１);
        headerList.add(タイトル_項目2);
        headerList.add(タイトル_項目3);
        headerList.add(タイトル_項目4);
        headerList.add(タイトル_項目5);
        headerList.add(タイトル_内容上);
        headerList.add(タイトル_内容下);
        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, 処理結果確認リスト);
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(headerList)
                .build()) {
            for (DbT3116KijunShunyugakuTekiyoKanriEntity 基準収入額適用管理情報 : list_select基準収入額適用管理マスタ) {
                List<RString> bodyList = new ArrayList<>();
                bodyList.add(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().code市町村RString());
                bodyList.add(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
                bodyList.add(RDate.getNowDate().toDateString());
                bodyList.add(DATA_世帯コード);
                bodyList.add(DATA_被保険者番号);
                bodyList.add(RString.EMPTY);
                bodyList.add(RString.EMPTY);
                bodyList.add(RString.EMPTY);
                bodyList.add(DATA_対象者判定);
                bodyList.add(DATA_ENTITY_ID);
                bodyList.add(基準収入額適用管理情報.getSetaiCode().getColumnValue());
                bodyList.add(基準収入額適用管理情報.getHihokenshaNo().getColumnValue());
                bodyList.add(RString.EMPTY);
                bodyList.add(RString.EMPTY);
                bodyList.add(RString.EMPTY);
                bodyList.add(DATA_資格喪失);
                bodyList.add(RString.EMPTY);
                toBodyList(bodyList);
                csvListWriter.writeLine(bodyList);
            }
            csvListWriter.close();
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        }
    }

    private void toBodyList(List<RString> bodyList) {
        for (int i = INT_0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
    }

}
