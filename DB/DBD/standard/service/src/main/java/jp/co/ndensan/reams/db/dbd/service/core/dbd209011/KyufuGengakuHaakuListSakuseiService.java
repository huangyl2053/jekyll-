/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd209011;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200008.KyufuGengakuHaakuIchiranProerty.DBD200008ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011.KyufuGengakuHaakuListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.GengakuTaishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.HihokenshaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.KyufuGengakuHaakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.ShunoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.ShunoKibetsuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KyufuGengakuHaakuListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KyufuGengakuHaakuListTaishoTokuteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.NinteiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.TaishoshaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 給付額減額滞納者把握リストのビジネスクラスです．
 *
 * @reamsid_L DBD-3610-050 x_miaocl
 */
public class KyufuGengakuHaakuListSakuseiService {

    private final RString 収納情報なし = new RString("収　納　情　報　な　し");
    private static final RString 出力条件_基準日 = new RString("【基準日】");
    private static final RString 出力条件_抽出対象 = new RString("【抽出対象】");
    private static final RString 出力条件_時効起算日登録者の選択 = new RString("【時効起算日登録者の選択】");
    private static final RString 出力条件_被保険者選択 = new RString("【被保険者】");
    private static final RString 出力条件_受給者全員 = new RString("【受給者全員】");
    private static final RString 出力条件_受給認定申請中者 = new RString("【受給認定申請中者】");
    private static final RString 出力条件_受給認定日抽出 = new RString("【受給認定日抽出】");
    private static final RString 出力条件_受給認定日抽出の開始 = new RString("【受給認定日抽出の開始】");
    private static final RString 出力条件_受給認定日抽出の終了 = new RString("【受給認定日抽出の終了】");
    private static final RString 出力条件_認定有効終了日抽出 = new RString("【認定有効終了日抽出】");
    private static final RString 出力条件_認定有効終了日抽出の開始 = new RString("【認定有効終了日抽出の開始】");
    private static final RString 出力条件_認定有効終了日抽出の終了 = new RString("【認定有効終了日抽出の終了】");
    private static final RString 出力条件_保険料完納者も出力 = new RString("【保険料完納者も出力】");
    private static final RString 出力条件_改頁出力順ID = new RString("【改頁出力順ID】");
    private static final RString 出力条件_帳票分類ID = new RString("【帳票分類ID】");
    private static final RString 出力条件_帳票ID = new RString("【帳票ID】");
    private static final RString 出力条件_帳票作成日時 = new RString("【帳票作成日時】");
    private static final RString 出力条件_出力順 = new RString("【出力順】");

    private static final RString チェックオン = new RString("0");
    private static final RString チェックオフ = new RString("1");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_12 = 12;
    private static final RString SIGN = new RString(" ＞ ");

    /**
     * 給付額減額滞納者把握リストのビジネスを生成します。
     *
     * @return 給付額減額滞納者把握リストのビジネス
     */
    public static KyufuGengakuHaakuListSakuseiService createInstance() {
        return InstanceProvider.create(KyufuGengakuHaakuListSakuseiService.class);
    }

    /**
     * 対象者情報一時テーブルのデータを編集します。
     *
     * @param tmpTblEntity 対象者情報一時テーブルのデータ
     * @return 対象者情報一時テーブルのデータ
     */
    public TaishoshaJohoTempTableEntity edit対象者(KyufuGengakuHaakuListTaishoTokuteiEntity tmpTblEntity) {
        TaishoshaJohoTempTableEntity insertEntity = new TaishoshaJohoTempTableEntity();
        insertEntity.setHihokenshaNo2(tmpTblEntity.getHihokenshaNo());
        return insertEntity;
    }

    /**
     * 減額対象最新情報を設定します。
     *
     * @param entity 給付額減額滞納者把握情報
     * @param 調定額Map 調定額Map
     * @param 収入額Map 収入額Map
     * @param 未納額Map 未納額Map
     */
    public void 減額対象最新情報の設定(KyufuGengakuHaakuListSakuseiEntity entity, Map<FlexibleYear, Decimal> 調定額Map,
            Map<FlexibleYear, Decimal> 収入額Map, Map<FlexibleYear, Decimal> 未納額Map) {

        ShunoTainoJokyoTempTableEntity 収納滞納状況TmpTblEntity = entity.get収納滞納状況TmpTblEntity();
        FlexibleYear 賦課年度 = 収納滞納状況TmpTblEntity.getTmp_fukaNendo();

        Decimal 調定額_当該 = 収納滞納状況TmpTblEntity.getTmp_choteigaku();
        if (調定額_当該 == null) {
            調定額_当該 = Decimal.ZERO;
        }
        Decimal 調定額_合計 = 調定額Map.get(賦課年度);
        if (調定額_合計 != null) {
            調定額_合計 = 調定額_合計.add(調定額_当該);
            調定額Map.put(賦課年度, 調定額_合計);
        } else {
            調定額Map.put(賦課年度, 調定額_当該);
        }

        Decimal 収入額_当該 = 収納滞納状況TmpTblEntity.getTmp_shunyugaku();
        if (収入額_当該 == null) {
            収入額_当該 = Decimal.ZERO;
        }
        Decimal 収入額_合計 = 収入額Map.get(賦課年度);
        if (収入額_合計 != null) {
            収入額_合計 = 収入額_合計.add(収入額_当該);
            収入額Map.put(賦課年度, 収入額_合計);
        } else {
            収入額Map.put(賦課年度, 収入額_当該);
        }

        Decimal 未納額_当該 = 収納滞納状況TmpTblEntity.getTmp_minogaku();
        if (未納額_当該 == null) {
            未納額_当該 = Decimal.ZERO;
        }
        Decimal 未納額_合計 = 未納額Map.get(賦課年度);
        if (未納額_合計 != null) {
            未納額_合計 = 未納額_合計.add(未納額_当該);
            収入額Map.put(賦課年度, 未納額_合計);
        } else {
            収入額Map.put(賦課年度, 未納額_当該);
        }
    }

    /**
     * 帳票出力用の給付額減額把握リストEntityを編集します。
     *
     * @param 把握情報Map 把握情報Map
     * @param 調定額Map 調定額Map
     * @param 収入額Map 収入額Map
     * @param 未納額Map 未納額Map
     * @param 徴収権消滅期間Map 徴収権消滅期間Map
     * @param 納付済み期間Map 納付済み期間Map
     * @param 把握情報List 把握情報List
     * @param 支払方法変更減額List 支払方法変更減額List
     * @return 給付額減額把握リストEntity
     */
    public KyufuGengakuHaakuIchiranEntity edit給付額減額把握リストEntity(Map<FlexibleYear, List<KyufuGengakuHaakuListSakuseiEntity>> 把握情報Map,
            Map<FlexibleYear, Decimal> 調定額Map, Map<FlexibleYear, Decimal> 収入額Map,
            Map<FlexibleYear, Decimal> 未納額Map, Map<FlexibleYear, Decimal> 徴収権消滅期間Map, Map<FlexibleYear, Decimal> 納付済み期間Map,
            List<KyufuGengakuHaakuListSakuseiEntity> 把握情報List, List<DbT4025ShiharaiHohoHenkoGengakuEntity> 支払方法変更減額List) {

        Decimal 徴収権消滅期間_すべて合計 = Decimal.ZERO;
        Decimal 納付済み期間の合計_すべて合計 = Decimal.ZERO;

        Iterator<Map.Entry<FlexibleYear, Decimal>> it = 調定額Map.entrySet().iterator();
        Map.Entry<FlexibleYear, Decimal> entry;
        FlexibleYear 賦課年度;
        Decimal 徴収権消滅期間;
        Decimal 納付済み期間;
        while (it.hasNext()) {
            entry = it.next();
            賦課年度 = entry.getKey();
            Decimal 調定額_合計 = entry.getValue();
            Decimal 収入額_合計 = 収入額Map.get(賦課年度);
            Decimal 未納額_合計 = 未納額Map.get(賦課年度);

            if (!Decimal.ZERO.equals(調定額_合計)) {
                徴収権消滅期間 = 収入額_合計.divide(調定額_合計);
                徴収権消滅期間Map.put(賦課年度, 徴収権消滅期間);
                納付済み期間 = 未納額_合計.divide(調定額_合計);
                納付済み期間Map.put(賦課年度, 納付済み期間);

                徴収権消滅期間_すべて合計 = 徴収権消滅期間_すべて合計.add(徴収権消滅期間);
                納付済み期間の合計_すべて合計 = 納付済み期間の合計_すべて合計.add(納付済み期間);
            }
        }

        KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity = new KyufuGengakuHaakuIchiranEntity();
        set給付額減額情報(給付額減額把握リストEntity, 把握情報List.get(0), 徴収権消滅期間_すべて合計, 納付済み期間の合計_すべて合計);
        set被保険者ごとの収納情報(給付額減額把握リストEntity, 把握情報Map);
        set減額対象情報(給付額減額把握リストEntity, 支払方法変更減額List);
        edit収納情報なし(給付額減額把握リストEntity);

        return 給付額減額把握リストEntity;
    }

    private void edit収納情報なし(KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity) {
        RString 日付関連_調定年度コンフィング = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        FlexibleYear 日付関連_調定年度 = new FlexibleYear(日付関連_調定年度コンフィング);
        boolean is調定年度コンフィングminus9収納存在 = false;
        boolean is調定年度コンフィングminus8収納存在 = false;
        boolean is調定年度コンフィングminus7収納存在 = false;
        boolean is調定年度コンフィングminus6収納存在 = false;
        boolean is調定年度コンフィングminus5収納存在 = false;
        boolean is調定年度コンフィングminus4収納存在 = false;
        boolean is調定年度コンフィングminus3収納存在 = false;
        boolean is調定年度コンフィングminus2収納存在 = false;
        boolean is調定年度コンフィングminus1収納存在 = false;
        boolean is調定年度コンフィングequal収納存在 = false;

        List<ShunoJohoEntity> 収納情報リスト = 給付額減額把握リストEntity.get収納情報リスト();
        for (ShunoJohoEntity 収納情報 : 収納情報リスト) {
            if (日付関連_調定年度.minusYear(NUM_9).equals(収納情報.get賦課年度())) {
                is調定年度コンフィングminus9収納存在 = true;
            } else if (日付関連_調定年度.minusYear(NUM_8).equals(収納情報.get賦課年度())) {
                is調定年度コンフィングminus8収納存在 = true;
            } else if (日付関連_調定年度.minusYear(NUM_7).equals(収納情報.get賦課年度())) {
                is調定年度コンフィングminus7収納存在 = true;
            } else if (日付関連_調定年度.minusYear(NUM_6).equals(収納情報.get賦課年度())) {
                is調定年度コンフィングminus6収納存在 = true;
            } else if (日付関連_調定年度.minusYear(NUM_5).equals(収納情報.get賦課年度())) {
                is調定年度コンフィングminus5収納存在 = true;
            } else if (日付関連_調定年度.minusYear(NUM_4).equals(収納情報.get賦課年度())) {
                is調定年度コンフィングminus4収納存在 = true;
            } else if (日付関連_調定年度.minusYear(NUM_3).equals(収納情報.get賦課年度())) {
                is調定年度コンフィングminus3収納存在 = true;
            } else if (日付関連_調定年度.minusYear(NUM_2).equals(収納情報.get賦課年度())) {
                is調定年度コンフィングminus2収納存在 = true;
            } else if (日付関連_調定年度.minusYear(NUM_1).equals(収納情報.get賦課年度())) {
                is調定年度コンフィングminus1収納存在 = true;
            } else if (日付関連_調定年度.equals(収納情報.get賦課年度())) {
                is調定年度コンフィングequal収納存在 = true;
            }
        }

        if (!is調定年度コンフィングminus9収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度.minusYear(NUM_9));
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        if (!is調定年度コンフィングminus8収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度.minusYear(NUM_8));
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        if (!is調定年度コンフィングminus7収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度.minusYear(NUM_7));
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        if (!is調定年度コンフィングminus6収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度.minusYear(NUM_6));
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        if (!is調定年度コンフィングminus5収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度.minusYear(NUM_5));
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        if (!is調定年度コンフィングminus4収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度.minusYear(NUM_4));
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        if (!is調定年度コンフィングminus3収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度.minusYear(NUM_3));
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        if (!is調定年度コンフィングminus2収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度.minusYear(NUM_2));
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        if (!is調定年度コンフィングminus1収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度.minusYear(NUM_1));
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        if (!is調定年度コンフィングequal収納存在) {
            ShunoJohoEntity shunoJohoEntity = new ShunoJohoEntity();
            shunoJohoEntity.set賦課年度(日付関連_調定年度);
            shunoJohoEntity.set収納情報なし(収納情報なし);
            収納情報リスト.add(shunoJohoEntity);
        }
        給付額減額把握リストEntity.set収納情報リスト(収納情報リスト);
    }

    /**
     * バッチ出力条件リストの出力を行います。
     *
     * @param 出力ページ数 出力ページ数
     * @param parameter プロセスパラメータ
     * @param outputOrder 出力順
     */
    public void バッチ出力条件リストの出力(RString 出力ページ数, KyufuGengakuHaakuListSakuseiProcessParameter parameter, IOutputOrder outputOrder) {

        List<RString> 出力条件 = new ArrayList<>();

        RStringBuilder 基準日builder = new RStringBuilder();
        RStringBuilder 時効起算日登録者の選択builder = new RStringBuilder();
        RStringBuilder 被保険者選択builder = new RStringBuilder();
        RStringBuilder 受給者全員builder = new RStringBuilder();
        RStringBuilder 受給認定申請中者builder = new RStringBuilder();
        RStringBuilder 受給認定日抽出builder = new RStringBuilder();
        RStringBuilder 受給認定日抽出日付builder = new RStringBuilder();
        RStringBuilder 認定有効終了日抽出builder = new RStringBuilder();
        RStringBuilder 認定有効終了日日付builder = new RStringBuilder();
        RStringBuilder 保険料完納者も出力builder = new RStringBuilder();
        RStringBuilder 帳票作成日時builder = new RStringBuilder();

        基準日builder.append(出力条件_基準日).append(RString.HALF_SPACE).append(parameter.get基準日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        if (チェックオン.equals(parameter.get時効起算日登録者の選択())) {
            時効起算日登録者の選択builder.append(出力条件_抽出対象).append(RString.HALF_SPACE).append(new RString("時効起算日登録者のみ出力"));
        } else if (チェックオフ.equals(parameter.get時効起算日登録者の選択())) {
            時効起算日登録者の選択builder.append(出力条件_抽出対象).append(RString.HALF_SPACE).append(new RString("時効起算日登録者以外出力"));
        }

        if (チェックオン.equals(parameter.get被保険者選択())) {
            被保険者選択builder.append(出力条件_被保険者選択).append(RString.HALF_SPACE).append(new RString("被保険者全員"));
        } else if (チェックオフ.equals(parameter.get被保険者選択())) {
            被保険者選択builder.append(出力条件_被保険者選択).append(RString.HALF_SPACE).append(new RString("被保険者全員以外"));
        }

        if (チェックオン.equals(parameter.get受給者全員())) {
            受給者全員builder.append("　　　　・受給者全員");
        }
        if (チェックオン.equals(parameter.get受給認定申請中者())) {
            受給認定申請中者builder.append("　　　　・受給認定申請中者");
        }
        if (チェックオン.equals(parameter.get受給認定日抽出())) {
            受給認定日抽出builder.append("　　　　・受給認定日抽出");
        }
        RString 受給認定日抽出の開始 = RString.EMPTY;
        if (parameter.get受給認定日抽出の開始() != null) {
            受給認定日抽出の開始 = parameter.get受給認定日抽出の開始().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        RString 受給認定日抽出の終了 = RString.EMPTY;
        if (parameter.get受給認定日抽出の終了() != null) {
            受給認定日抽出の終了 = parameter.get受給認定日抽出の終了().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        受給認定日抽出日付builder.append("　　　　　開始：").append(受給認定日抽出の開始).append(" ～ ").append(受給認定日抽出の終了);

        if (チェックオン.equals(parameter.get認定有効終日抽出())) {
            認定有効終了日抽出builder.append("　　　　・認定有効終日抽出");
        }
        RString 認定有効終日抽出の開始 = RString.EMPTY;
        if (parameter.get受給認定日抽出の開始() != null) {
            認定有効終日抽出の開始 = parameter.get認定有効終日抽出の開始().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        RString 認定有効終日抽出の終了 = RString.EMPTY;
        if (parameter.get認定有効終日抽出の終了() != null) {
            認定有効終日抽出の終了 = parameter.get認定有効終日抽出の終了().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        認定有効終了日日付builder.append("　　　　　開始：").append(認定有効終日抽出の開始).append(" ～ ").append(認定有効終日抽出の終了);

        if (チェックオン.equals(parameter.get保険料完納者も出力())) {
            保険料完納者も出力builder.append("　　　　・保険料完納者も出力");
        }
        帳票作成日時builder.append(出力条件_帳票作成日時).append(RString.HALF_SPACE).append(parameter.get帳票作成日時());

        出力条件.add(基準日builder.toRString());
        出力条件.add(時効起算日登録者の選択builder.toRString());
        出力条件.add(被保険者選択builder.toRString());
        if (受給者全員builder.length() != 0) {
            出力条件.add(受給者全員builder.toRString());
        }
        if (受給認定申請中者builder.length() != 0) {
            出力条件.add(受給認定申請中者builder.toRString());
        }
        if (受給認定日抽出builder.length() != 0) {
            出力条件.add(受給認定日抽出builder.toRString());
            出力条件.add(受給認定日抽出日付builder.toRString());
        }
        if (認定有効終了日抽出builder.length() != 0) {
            出力条件.add(認定有効終了日抽出builder.toRString());
            出力条件.add(認定有効終了日日付builder.toRString());
        }
        if (保険料完納者も出力builder.length() != 0) {
            出力条件.add(保険料完納者も出力builder.toRString());
        }
        出力条件.add(帳票作成日時builder.toRString());
        出力条件.add(get出力順RStr(outputOrder));

        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = RString.EMPTY;

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD200008.getReportId().value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                ReportIdDBD.DBD200008.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    /**
     * 帳票の改頁を設定します。
     *
     * @param outputOrder IOutputOrder
     * @param pageBreakKeys 改頁キー
     */
    public void set改頁Key(IOutputOrder outputOrder, List pageBreakKeys) {
        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        Map<Integer, ISetSortItem> 改頁Map = ChohyoUtil.get改頁項目Map(outputOrder);
        if (改頁Map.get(NUM_1) != null) {
            改頁１ = to帳票物理名(改頁Map.get(NUM_1));
        }
        if (改頁Map.get(NUM_2) != null) {
            改頁２ = to帳票物理名(改頁Map.get(NUM_2));
        }
        if (改頁Map.get(NUM_3) != null) {
            改頁３ = to帳票物理名(改頁Map.get(NUM_3));
        }
        if (改頁Map.get(NUM_4) != null) {
            改頁４ = to帳票物理名(改頁Map.get(NUM_4));
        }
        if (改頁Map.get(NUM_5) != null) {
            改頁５ = to帳票物理名(改頁Map.get(NUM_5));
        }

        if (改頁１ != null && !改頁１.isEmpty()) {
            pageBreakKeys.add(改頁１);
        }
        if (改頁２ != null && !改頁２.isEmpty()) {
            pageBreakKeys.add(改頁２);
        }
        if (改頁３ != null && !改頁３.isEmpty()) {
            pageBreakKeys.add(改頁３);
        }
        if (改頁４ != null && !改頁４.isEmpty()) {
            pageBreakKeys.add(改頁４);
        }
        if (改頁５ != null && !改頁５.isEmpty()) {
            pageBreakKeys.add(改頁５);
        }
    }

    private RString to帳票物理名(ISetSortItem item) {  // #103476  「町域コード」「市町村コード」がありません。

        RString 帳票物理名 = RString.EMPTY;

        if (DBD200008ShutsuryokujunEnum.郵便番号.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = KyufuGengakuHaakuIchiranReportSource.改頁_郵便番号;
        } else if (DBD200008ShutsuryokujunEnum.行政区コード.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = KyufuGengakuHaakuIchiranReportSource.改頁_行政区コード;
        } else if (DBD200008ShutsuryokujunEnum.世帯コード.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = KyufuGengakuHaakuIchiranReportSource.改頁_世帯コード;
        } else if (DBD200008ShutsuryokujunEnum.識別コード.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = KyufuGengakuHaakuIchiranReportSource.改頁_識別コード;
        } else if (DBD200008ShutsuryokujunEnum.氏名５０音カナ.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = KyufuGengakuHaakuIchiranReportSource.改頁_氏名５０音カナ;
        } else if (DBD200008ShutsuryokujunEnum.被保険者番号.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = KyufuGengakuHaakuIchiranReportSource.改頁_被保険者番号;
        }

        return 帳票物理名;
    }

    private RString get出力順RStr(IOutputOrder outputOrder) {
        RStringBuilder 出力順builder = new RStringBuilder();
        出力順builder.append(出力条件_出力順).append(RString.HALF_SPACE);

        List<ISetSortItem> list = new ArrayList<>();
        if (outputOrder != null) {
            list = outputOrder.get設定項目リスト();
        }
        if (list != null && list.size() > NUM_0) {
            出力順builder.append(list.get(NUM_0).get項目名()).append(SIGN);
        }
        if (list != null && list.size() > NUM_1) {
            出力順builder.append(list.get(NUM_1).get項目名()).append(SIGN);
        }
        if (list != null && list.size() > NUM_2) {
            出力順builder.append(list.get(NUM_2).get項目名()).append(SIGN);
        }
        if (list != null && list.size() > NUM_3) {
            出力順builder.append(list.get(NUM_3).get項目名()).append(SIGN);
        }
        if (list != null && list.size() > NUM_4) {
            出力順builder.append(list.get(NUM_4).get項目名()).append(SIGN);
        }
        RString 出力順RStr = 出力順builder.toRString();
        if (出力順builder.length() > NUM_5) {
            出力順RStr = 出力順builder.substring(0, 出力順builder.length() - NUM_3);
        }
        return 出力順RStr;
    }

    private void set給付額減額情報(KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity, KyufuGengakuHaakuListSakuseiEntity entity,
            Decimal 徴収権消滅期間_すべて合計, Decimal 納付済み期間の合計_すべて合計) {

        HihokenshaJohoEntity 被保険者情報Entity = new HihokenshaJohoEntity();
        edit宛名情報(entity, 被保険者情報Entity);
        edit資格情報(entity, 被保険者情報Entity);
        edit認定情報(entity, 被保険者情報Entity);

        Decimal 給付額減額期間 = Decimal.ZERO;
        if (!Decimal.ZERO.equals(徴収権消滅期間_すべて合計)) {
            給付額減額期間 = 徴収権消滅期間_すべて合計.multiply(徴収権消滅期間_すべて合計.divide(
                    徴収権消滅期間_すべて合計.add(納付済み期間の合計_すべて合計))).divide(2).multiply(NUM_12);
        }
        被保険者情報Entity.set徴収権消滅期間(new RString(徴収権消滅期間_すべて合計.toString()));
        被保険者情報Entity.set納付済み期間(new RString(納付済み期間の合計_すべて合計.toString()));
        被保険者情報Entity.set給付額減額期間(new RString(給付額減額期間.toString()));

        給付額減額把握リストEntity.set被保険者情報Entity(被保険者情報Entity);
    }

    private void edit宛名情報(KyufuGengakuHaakuListSakuseiEntity entity, HihokenshaJohoEntity 被保険者情報Entity) {
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.get宛名Entity();
        if (宛名Entity == null) {
            宛名Entity = new UaFt200FindShikibetsuTaishoEntity();
        }
        ShikibetsuCode 識別コード = 宛名Entity.getShikibetsuCode();
        AtenaMeisho 被保険者氏名 = 宛名Entity.getKanjiShimei();
        GyoseikuCode 行政区ｺｰﾄﾞ = 宛名Entity.getGyoseikuCode();
        AtenaJusho 住所 = 宛名Entity.getJusho();
        ZenkokuJushoCode 住所コード = 宛名Entity.getZenkokuJushoCode();
        YubinNo 郵便番号 = 宛名Entity.getYubinNo();

        if (識別コード != null) {
            被保険者情報Entity.set識別コード(識別コード.getColumnValue());
        }
        if (被保険者氏名 != null) {
            被保険者情報Entity.set被保険者氏名(被保険者氏名.getColumnValue());
        }
        被保険者情報Entity.set被保険者氏名カナ(宛名Entity.getKanaName());
        被保険者情報Entity.set世帯番号(宛名Entity.getSeibetsuCode());
        被保険者情報Entity.set行政区(宛名Entity.getGyoseikuName());
        if (行政区ｺｰﾄﾞ != null) {
            被保険者情報Entity.set行政区ｺｰﾄﾞ(行政区ｺｰﾄﾞ.getColumnValue());
        }
        if (住所 != null) {
            被保険者情報Entity.set住所(住所.getColumnValue());
        }
        if (住所コード != null) {
            被保険者情報Entity.set住所コード(住所コード.getColumnValue());
        }
        if (郵便番号 != null) {
            被保険者情報Entity.set郵便番号(郵便番号.getColumnValue());
        }
    }

    private void edit資格情報(KyufuGengakuHaakuListSakuseiEntity entity, HihokenshaJohoEntity 被保険者情報Entity) {
        DbT1001HihokenshaDaichoEntity 資格情報Entity = entity.get資格情報Entity();
        if (資格情報Entity == null) {
            資格情報Entity = new DbT1001HihokenshaDaichoEntity();
        }
        if (資格情報Entity.getHihokenshaNo() != null) {
            被保険者情報Entity.set被保険者番号(資格情報Entity.getHihokenshaNo().getColumnValue());
        }
        被保険者情報Entity.set資格取得日(資格情報Entity.getShikakuShutokuYMD());
        被保険者情報Entity.set資格喪失日(資格情報Entity.getShikakuSoshitsuYMD());
        被保険者情報Entity.set喪失事由(資格情報Entity.getShikakuSoshitsuJiyuCode());
        被保険者情報Entity.set資格区分(資格情報Entity.getHihokennshaKubunCode());
        被保険者情報Entity.set住特フラグ(資格情報Entity.getJushochiTokureiFlag());
        boolean 生保フラグ = false;
        if (entity.get生保情報Entity() != null && entity.get生保情報Entity().getJukyuKaishiYMD() != null
                && !entity.get生保情報Entity().getJukyuKaishiYMD().isEmpty()) {
            生保フラグ = true;
        }
        被保険者情報Entity.set生保フラグ(生保フラグ);
    }

    private void edit認定情報(KyufuGengakuHaakuListSakuseiEntity entity, HihokenshaJohoEntity 被保険者情報Entity) {
        NinteiJohoEntity 認定情報 = entity.get認定情報();
        if (認定情報 == null) {
            認定情報 = new NinteiJohoEntity();
        }
        if (認定情報.get要介護認定申請Entity() != null) {
            if (認定情報.get要介護認定申請Entity().getKoroshoIfShikibetsuCode() != null) {
                被保険者情報Entity.set厚労省IF識別コード(認定情報.get要介護認定申請Entity().getKoroshoIfShikibetsuCode().getColumnValue());
            }
            被保険者情報Entity.set認定有効期間開始年月日(認定情報.get要介護認定申請Entity().getZenkaiYukoKikanEnd());
            被保険者情報Entity.set認定有効期間終了年月日(認定情報.get要介護認定申請Entity().getZenkaiYukoKikanStart());
            被保険者情報Entity.set申請日(認定情報.get要介護認定申請Entity().getNinteiShinseiYMD());
        }
        if (認定情報.get受給者Entity() != null) {
            if (認定情報.get受給者Entity().getYokaigoJotaiKubunCode() != null) {
                被保険者情報Entity.set要介護状態区分コード(認定情報.get受給者Entity().getYokaigoJotaiKubunCode().getColumnValue());
            }
            被保険者情報Entity.set認定日(認定情報.get受給者Entity().getNinteiYMD());
        }
        boolean 申請中フラグ = false;
        if (entity.get申請中被保険者() != null && !entity.get申請中被保険者().isEmpty()) {
            申請中フラグ = true;
        }
        被保険者情報Entity.set申請中フラグ(申請中フラグ);
    }

    private void set被保険者ごとの収納情報(KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity,
            Map<FlexibleYear, List<KyufuGengakuHaakuListSakuseiEntity>> 把握情報Map) {

        List<ShunoJohoEntity> 収納情報リスト = new ArrayList<>();
        ShunoJohoEntity shunoEntity;
        List<ShunoKibetsuEntity> 期別情報List;
        ShunoKibetsuEntity 期別情報;

        Iterator<Map.Entry<FlexibleYear, List<KyufuGengakuHaakuListSakuseiEntity>>> it = 把握情報Map.entrySet().iterator();
        Map.Entry<FlexibleYear, List<KyufuGengakuHaakuListSakuseiEntity>> entry;
        List<KyufuGengakuHaakuListSakuseiEntity> 年度の把握情報List;
        while (it.hasNext()) {
            shunoEntity = new ShunoJohoEntity();
            期別情報List = new ArrayList<>();

            entry = it.next();
            年度の把握情報List = entry.getValue();
            shunoEntity.set特徴普徴区分(年度の把握情報List.get(0).get収納滞納状況TmpTblEntity().getTmp_tokucho_fuchoKubun());
            shunoEntity.set調定年度(年度の把握情報List.get(0).get収納滞納状況TmpTblEntity().getTmp_choteiNendo());
            shunoEntity.set賦課年度(年度の把握情報List.get(0).get収納滞納状況TmpTblEntity().getTmp_fukaNendo());

            for (KyufuGengakuHaakuListSakuseiEntity tblEntity : 年度の把握情報List) {
                期別情報 = new ShunoKibetsuEntity();
                期別情報.set保険料金(tblEntity.get収納滞納状況TmpTblEntity().getTmp_choteigaku());
                期別情報.set時効起算事由(tblEntity.get収納滞納状況TmpTblEntity().getTmp_jikoKisanJiyu());
                期別情報.set時効起算日(tblEntity.get収納滞納状況TmpTblEntity().getTmp_jikoKisanYMD());
                期別情報.set期別(new RString(tblEntity.get収納滞納状況TmpTblEntity().getTmp_kibetsu()));
                期別情報.set滞納区分(tblEntity.get収納滞納状況TmpTblEntity().getTmp_tainoKubun());
                期別情報.set滞納額(tblEntity.get収納滞納状況TmpTblEntity().getTmp_minogaku());
                if (tblEntity.get収納滞納状況TmpTblEntity().getTmp_nokigen() != null) {
                    期別情報.set納期限(new FlexibleDate(tblEntity.get収納滞納状況TmpTblEntity().getTmp_nokigen().toDateString()));
                }
                期別情報List.add(期別情報);
            }
//            if (年度の把握情報List.isEmpty()) {
//                shunoEntity.set収納情報なし(収納情報なし);
//            }
            shunoEntity.set期別情報(期別情報List);
            収納情報リスト.add(shunoEntity);
        }
        給付額減額把握リストEntity.set収納情報リスト(収納情報リスト);
    }

    private void set減額対象情報(KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity,
            List<DbT4025ShiharaiHohoHenkoGengakuEntity> 支払方法変更減額List) {

        List<GengakuTaishoJohoEntity> 減額対象情報リスト = new ArrayList<>();
        GengakuTaishoJohoEntity 減額対象;
        for (DbT4025ShiharaiHohoHenkoGengakuEntity 減額情報 : 支払方法変更減額List) {
            減額対象 = new GengakuTaishoJohoEntity();
            Decimal 徴収権消滅期間 = 減額情報.getChoshukenShometsuKikan();
            if (徴収権消滅期間 != null) {
                減額対象.set徴収権消滅期間(new RString(徴収権消滅期間.toString()));
            }
            減額対象.set確定減額期間終了年月日(減額情報.getKakutei_GengakuShuryoYMD());
            減額対象.set確定減額期間開始年月日(減額情報.getKakutei_GengakuKaishiYMD());
            Decimal 納付済期間 = 減額情報.getNofusumiKikan();
            if (納付済期間 != null) {
                減額対象.set納付済み期間(new RString(納付済期間.toString()));
            }
            Decimal 納付済減額期間 = 減額情報.getNofusumiGengakuKikan();
            if (納付済減額期間 != null) {
                減額対象.set給付額減額期間(new RString(納付済減額期間.toString()));
            }
            減額対象情報リスト.add(減額対象);
        }
        給付額減額把握リストEntity.set減額対象情報リスト(減額対象情報リスト);
    }

}
