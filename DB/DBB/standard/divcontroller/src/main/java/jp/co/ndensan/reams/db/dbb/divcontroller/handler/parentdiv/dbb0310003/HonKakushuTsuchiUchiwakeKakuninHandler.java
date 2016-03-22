/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0310003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.TsuchishoUchiwakeJoken;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.KetteiHenkoTsuchishoUchiwake;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.KetteiHenkoTsuchishoUchiwakeKozaJoken;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003.HonKakushuTsuchiUchiwakeKakuninDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003.dgKakushuTsuchiUchiwakeSentaku_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003.dgTsuchishoSettei_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteifuka.Honsanteifuka;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 打ち分け方法確認のHandler
 */
public class HonKakushuTsuchiUchiwakeKakuninHandler {

    private final HonKakushuTsuchiUchiwakeKakuninDiv div;
    private static final int LIST_00 = 0;
    private static final int LIST_01 = 1;
    private static final int LIST_02 = 2;
    private static final int LIST_03 = 3;
    private static final int LIST_04 = 4;
    private static final int LIST_05 = 5;
    private static final int LIST_06 = 6;
    private static final int LIST_07 = 7;
    private static final int LIST_08 = 8;
    private static final int LIST_09 = 9;
    private static final int LIST_10 = 10;
    private static final int LIST_11 = 11;
    private static final int LIST_12 = 12;
    private static final int 変更区分_0 = 0;
    private static final int 変更区分_1 = 1;
    private static final RString EMPTY = RString.EMPTY;
    private static final RString SELECTED_FLAG = new RString("1");
    private static final RString NOTSELECTED_FLAG = new RString("0");
    private static final RString 徴収なし = new RString("徴収なし");
    private static final RString 特別徴収 = new RString("特別徴収");
    private static final RString 普通徴収 = new RString("普通徴収");
    private static final RString 資格継続_イコール = new RString("資格継続（仮徴収額＝保険料年額）");
    private static final RString 資格継続_大或 = new RString("資格継続（仮徴収額＞保険料年額）「還付あり」");
    private static final RString 資格喪失_イコール = new RString("資格喪失（仮徴収額＝保険料年額）");
    private static final RString 資格喪失_大或 = new RString("資格喪失（仮徴収額＞保険料年額）「還付あり」");
    private static final RString 資格喪失 = new RString("資格喪失（年額=0）");
    private static final RString 仮徴収は特別徴収 = new RString("仮徴収は特別徴収");
    private static final RString 仮徴収は特別徴収_から = new RString("仮徴収は特別徴収（年金保険者からの特徴停止あり）");
    private static final RString 仮徴収は普通徴収 = new RString("仮徴収は普通徴収");
    private static final RString 資格継続_なし = new RString("資格継続（仮徴収なし・新規資格取得者）");
    private static final RString 資格継続_特別 = new RString("資格継続（仮徴収は特別徴収）");
    private static final RString 資格継続_普通 = new RString("資格継続（仮徴収は普通徴収）");
    private static final RString 資格喪失_特別 = new RString("資格喪失（仮徴収は特別徴収）");
    private static final RString 資格喪失_普通 = new RString("資格喪失（仮徴収は普通徴収）");

    /**
     * コンストラクタです
     *
     * @param div HonKakushuTsuchiUchiwakeKakuninDiv
     */
    public HonKakushuTsuchiUchiwakeKakuninHandler(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        this.div = div;
    }

    /**
     * 打分け方法一覧を表示。
     *
     * @param 打分け方法List 取得した打分け方法List。
     */
    public void show打分け方法(List<TsuchishoUchiwakeJoken> 打分け方法List) {
        List<dgKakushuTsuchiUchiwakeSentaku_Row> dataSources = new ArrayList<>();
        for (TsuchishoUchiwakeJoken 打分け方法 : 打分け方法List) {
            dgKakushuTsuchiUchiwakeSentaku_Row row = new dgKakushuTsuchiUchiwakeSentaku_Row();
            row.setTxtJokenMeisho(打分け方法.get打ち分け条件());
            row.setTxtUchiwake(NOTSELECTED_FLAG);
            dataSources.add(row);
        }
        dataSources.get(0).setTxtUchiwake(SELECTED_FLAG);
        div.getHonKakushuTsuchiUchiwakeSentaku().getDgKakushuTsuchiUchiwakeSentaku().setDataSource(dataSources);
    }

    /**
     * 打分け方法情報一覧を表示。
     *
     * @param 方法情報一覧 打分け方法情報一覧
     */
    public void show打分け方法情報(TsuchishoUchiwakeJoken 方法情報一覧) {
        List<KeyValueDataSource> 通知書List = get通知書List();
        List<KeyValueDataSource> 対象者List = get対象者List();
        List<dgTsuchishoSettei_Row> dataSources = new ArrayList<>();

        dgTsuchishoSettei_Row row1 = new dgTsuchishoSettei_Row();
        row1.setTxtChosyuHoho(徴収なし);
        row1.setTxtJotai(資格継続_イコール);
        row1.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row1.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書01());
        row1.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row1.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座01());
        row1.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名01());
        dataSources.add(row1);

        dgTsuchishoSettei_Row row2 = new dgTsuchishoSettei_Row();
        row2.setTxtChosyuHoho(徴収なし);
        row2.setTxtJotai(資格継続_大或);
        row2.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row2.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書02());
        row2.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row2.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座02());
        row2.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名02());
        dataSources.add(row2);

        dgTsuchishoSettei_Row row3 = new dgTsuchishoSettei_Row();
        row3.setTxtChosyuHoho(徴収なし);
        row3.setTxtJotai(資格喪失_イコール);
        row3.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row3.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書03());
        row3.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row3.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座03());
        row3.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名03());
        dataSources.add(row3);

        dgTsuchishoSettei_Row row4 = new dgTsuchishoSettei_Row();
        row4.setTxtChosyuHoho(徴収なし);
        row4.setTxtJotai(資格喪失_大或);
        row4.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row4.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書04());
        row4.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row4.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座04());
        row4.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名04());
        dataSources.add(row4);

        dgTsuchishoSettei_Row row5 = new dgTsuchishoSettei_Row();
        row5.setTxtChosyuHoho(徴収なし);
        row5.setTxtJotai(資格喪失);
        row5.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row5.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書05());
        row5.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row5.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座05());
        row5.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名05());
        dataSources.add(row5);

        dgTsuchishoSettei_Row row6 = new dgTsuchishoSettei_Row();
        row6.setTxtChosyuHoho(特別徴収);
        row6.setTxtJotai(仮徴収は特別徴収);
        row6.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row6.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書06());
        row6.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row6.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座06());
        row6.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名06());
        dataSources.add(row6);

        dgTsuchishoSettei_Row row7 = new dgTsuchishoSettei_Row();
        row7.setTxtChosyuHoho(特別徴収);
        row7.setTxtJotai(仮徴収は特別徴収_から);
        row7.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row7.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書07());
        row7.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row7.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座07());
        row7.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名07());
        dataSources.add(row7);

        dgTsuchishoSettei_Row row8 = new dgTsuchishoSettei_Row();
        row8.setTxtChosyuHoho(特別徴収);
        row8.setTxtJotai(仮徴収は普通徴収);
        row8.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row8.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書08());
        row8.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row8.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座08());
        row8.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名08());
        dataSources.add(row8);

        dgTsuchishoSettei_Row row9 = new dgTsuchishoSettei_Row();
        row9.setTxtChosyuHoho(普通徴収);
        row9.setTxtJotai(資格継続_なし);
        row9.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row9.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書09());
        row9.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row9.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座09());
        row9.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名09());
        dataSources.add(row9);

        dgTsuchishoSettei_Row row10 = new dgTsuchishoSettei_Row();
        row10.setTxtChosyuHoho(普通徴収);
        row10.setTxtJotai(資格継続_特別);
        row10.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row10.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書10());
        row10.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row10.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座10());
        row10.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名10());
        dataSources.add(row10);

        dgTsuchishoSettei_Row row11 = new dgTsuchishoSettei_Row();
        row11.setTxtChosyuHoho(普通徴収);
        row11.setTxtJotai(資格継続_普通);
        row11.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row11.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書11());
        row11.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row11.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座11());
        row11.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名11());
        dataSources.add(row11);

        dgTsuchishoSettei_Row row12 = new dgTsuchishoSettei_Row();
        row12.setTxtChosyuHoho(普通徴収);
        row12.setTxtJotai(資格喪失_特別);
        row12.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row12.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書12());
        row12.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row12.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座12());
        row12.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名12());
        dataSources.add(row12);

        dgTsuchishoSettei_Row row13 = new dgTsuchishoSettei_Row();
        row13.setTxtChosyuHoho(普通徴収);
        row13.setTxtJotai(資格喪失_普通);
        row13.getTxtTsuchisyoShitei().setDataSource(通知書List);
        row13.getTxtTsuchisyoShitei().setSelectedKey(方法情報一覧.get選択通知書13());
        row13.getTxtGenkinKozaShitei().setDataSource(対象者List);
        row13.getTxtGenkinKozaShitei().setSelectedKey(方法情報一覧.get選択現金口座13());
        row13.getTxtHakkojiGroup().setValue(方法情報一覧.get出力順グループ名13());
        dataSources.add(row13);

        div.getDgTsuchishoSettei().setDataSource(dataSources);
    }

    /**
     * Selected打ち分け条件の取得
     *
     * @param 打ち分け条件List 打分け方法一覧
     * @return 打分け方法
     */
    public RString getSelected打ち分け条件(List<dgKakushuTsuchiUchiwakeSentaku_Row> 打ち分け条件List) {
        for (dgKakushuTsuchiUchiwakeSentaku_Row 打ち分け条件 : 打ち分け条件List) {
            if (SELECTED_FLAG.equals(打ち分け条件.getTxtUchiwake())) {
                return 打ち分け条件.getTxtJokenMeisho();
            }
        }
        return null;
    }

    /**
     * 現データは変更有無
     *
     * @param 打分け方法 打分け方法
     * @return 変更flag
     */
    public boolean 変更有無(TsuchishoUchiwakeJoken 打分け方法) {
        int 変更flag = 0;
        List<dgTsuchishoSettei_Row> dataSources = div.getDgTsuchishoSettei().getDataSource();
        変更flag = 変更flag + check(打分け方法.get選択通知書01(), dataSources.get(LIST_00).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座01(), dataSources.get(LIST_00).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名01(), dataSources.get(LIST_00).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書02(), dataSources.get(LIST_01).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座02(), dataSources.get(LIST_01).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名02(), dataSources.get(LIST_01).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書03(), dataSources.get(LIST_02).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座03(), dataSources.get(LIST_02).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名03(), dataSources.get(LIST_02).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書04(), dataSources.get(LIST_03).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座04(), dataSources.get(LIST_03).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名04(), dataSources.get(LIST_03).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書05(), dataSources.get(LIST_04).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座05(), dataSources.get(LIST_04).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名05(), dataSources.get(LIST_04).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書06(), dataSources.get(LIST_05).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座06(), dataSources.get(LIST_05).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名06(), dataSources.get(LIST_05).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書07(), dataSources.get(LIST_06).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座07(), dataSources.get(LIST_06).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名07(), dataSources.get(LIST_06).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書08(), dataSources.get(LIST_07).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座08(), dataSources.get(LIST_07).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名08(), dataSources.get(LIST_07).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書09(), dataSources.get(LIST_08).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座09(), dataSources.get(LIST_08).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名09(), dataSources.get(LIST_08).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書10(), dataSources.get(LIST_09).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座10(), dataSources.get(LIST_09).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名10(), dataSources.get(LIST_09).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書11(), dataSources.get(LIST_10).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座11(), dataSources.get(LIST_10).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名11(), dataSources.get(LIST_10).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書12(), dataSources.get(LIST_11).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座12(), dataSources.get(LIST_11).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名12(), dataSources.get(LIST_11).getTxtHakkojiGroup().getValue());
        変更flag = 変更flag + check(打分け方法.get選択通知書13(), dataSources.get(LIST_12).getTxtTsuchisyoShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get選択現金口座13(), dataSources.get(LIST_12).getTxtGenkinKozaShitei().getSelectedKey());
        変更flag = 変更flag + check(打分け方法.get出力順グループ名13(), dataSources.get(LIST_12).getTxtHakkojiGroup().getValue());
        return 変更flag != 0;
    }

    private int check(RString object, RString obj) {
        if (obj == null && object != null) {
            return 1;
        } else if (obj != null && !obj.equals(object)) {
            return 1;
        }
        return 0;
    }

    /**
     * 打分け方法情報の保存。
     *
     * @param 変更打分け方法 変更打分け方法
     */
    public void 切替時保存処理(TsuchishoUchiwakeJoken 変更打分け方法) {
        Honsanteifuka 本算定賦課計算 = Honsanteifuka.createInstance();
        本算定賦課計算.regutiwakehouhoujyoho1(変更打分け方法);
    }

    /**
     * 変更区分=1の場合「設定を保存する」ボタン押下時の保存処理Handler
     */
    public void 設定時保存処理_変更区分_1() {
        Honsanteifuka 本算定賦課計算 = Honsanteifuka.createInstance();
        TsuchishoUchiwakeJoken 変更打分け方法 = get確認画面の打分け方法(true);
        RString 打ち分け条件 = div.getTxtTsuchishoSetteiHozonMeisho().getValue();
        ViewStateHolder.put(ViewStateKeys.打分け方法情報キー, 打ち分け条件);
        変更打分け方法 = 変更打分け方法.createBuilderForEdit().set打ち分け条件(打ち分け条件).build();
        本算定賦課計算.regutiwakehouhoujyoho2(変更打分け方法, new RString(String.valueOf(変更区分_1)));
    }

    /**
     * 変更区分=0の場合「設定を保存する」ボタン押下時の保存処理Handler
     */
    public void 設定時保存処理_変更区分_0() {
        Honsanteifuka 本算定賦課計算 = Honsanteifuka.createInstance();
        TsuchishoUchiwakeJoken 変更打分け方法 = get確認画面の打分け方法(true);
        RString 打ち分け条件 = ViewStateHolder.get(ViewStateKeys.打分け方法情報キー, RString.class);
        変更打分け方法 = 変更打分け方法.createBuilderForEdit().set打ち分け条件(打ち分け条件).build();
        本算定賦課計算.regutiwakehouhoujyoho2(変更打分け方法, new RString(String.valueOf(変更区分_0)));
    }

    /**
     * 確認画面の打分け方法の取得
     *
     * @param flag 新規１の場合flag==true else flag==false
     * @return 確認画面の打分け方法
     */
    public TsuchishoUchiwakeJoken get確認画面の打分け方法(boolean flag) {
        Honsanteifuka 本算定賦課計算 = Honsanteifuka.createInstance();
        RString 打ち分け条件 = ViewStateHolder.get(ViewStateKeys.打分け方法情報キー, RString.class);
        List<TsuchishoUchiwakeJoken> jokenList = 本算定賦課計算.getutiwakehouhoujyoho2(打ち分け条件);
        List<dgTsuchishoSettei_Row> dataSources = div.getDgTsuchishoSettei().getDataSource();
        TsuchishoUchiwakeJoken joken = jokenList.get(0).createBuilderForEdit()
                .set保存日時(RDateTime.now())
                .set選択通知書01(dataSources.get(LIST_00).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座01(dataSources.get(LIST_00).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名01(dataSources.get(LIST_00).getTxtHakkojiGroup().getValue())
                .set選択通知書02(dataSources.get(LIST_01).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座02(dataSources.get(LIST_01).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名02(dataSources.get(LIST_01).getTxtHakkojiGroup().getValue())
                .set選択通知書03(dataSources.get(LIST_02).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座03(dataSources.get(LIST_02).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名03(dataSources.get(LIST_02).getTxtHakkojiGroup().getValue())
                .set選択通知書04(dataSources.get(LIST_03).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座04(dataSources.get(LIST_03).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名04(dataSources.get(LIST_03).getTxtHakkojiGroup().getValue())
                .set選択通知書05(dataSources.get(LIST_04).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座05(dataSources.get(LIST_04).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名05(dataSources.get(LIST_04).getTxtHakkojiGroup().getValue())
                .set選択通知書06(dataSources.get(LIST_05).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座06(dataSources.get(LIST_05).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名06(dataSources.get(LIST_05).getTxtHakkojiGroup().getValue())
                .set選択通知書07(dataSources.get(LIST_06).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座07(dataSources.get(LIST_06).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名07(dataSources.get(LIST_06).getTxtHakkojiGroup().getValue())
                .set選択通知書08(dataSources.get(LIST_07).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座08(dataSources.get(LIST_07).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名08(dataSources.get(LIST_07).getTxtHakkojiGroup().getValue())
                .set選択通知書09(dataSources.get(LIST_08).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座09(dataSources.get(LIST_08).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名09(dataSources.get(LIST_08).getTxtHakkojiGroup().getValue())
                .set選択通知書10(dataSources.get(LIST_09).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座10(dataSources.get(LIST_09).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名10(dataSources.get(LIST_09).getTxtHakkojiGroup().getValue())
                .set選択通知書11(dataSources.get(LIST_10).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座11(dataSources.get(LIST_10).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名11(dataSources.get(LIST_10).getTxtHakkojiGroup().getValue())
                .set選択通知書12(dataSources.get(LIST_11).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座12(dataSources.get(LIST_11).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名12(dataSources.get(LIST_11).getTxtHakkojiGroup().getValue())
                .set選択通知書13(dataSources.get(LIST_12).getTxtTsuchisyoShitei().getSelectedKey())
                .set選択現金口座13(dataSources.get(LIST_12).getTxtGenkinKozaShitei().getSelectedKey())
                .set出力順グループ名13(dataSources.get(LIST_12).getTxtHakkojiGroup().getValue())
                .build();
        if (flag) {
            joken = joken.createBuilderForEdit()
                    .set選択通知書14(EMPTY)
                    .set選択現金口座14(EMPTY)
                    .set出力順グループ名14(EMPTY)
                    .set選択通知書15(EMPTY)
                    .set選択現金口座15(EMPTY)
                    .set出力順グループ名15(EMPTY)
                    .build();
        }
        return joken;
    }

    /**
     * 保存名称変更有無
     *
     * @return 変更区分
     */
    public int 変更区分() {
        RString 打ち分け条件view = ViewStateHolder.get(ViewStateKeys.打分け方法情報キー, RString.class);
        RString 打ち分け条件 = div.getTxtTsuchishoSetteiHozonMeisho().getValue();
        return 打ち分け条件view.equals(打ち分け条件) ? 変更区分_0 : 変更区分_1;
    }

    private List<KeyValueDataSource> get通知書List() {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        for (KetteiHenkoTsuchishoUchiwake 通知書 : KetteiHenkoTsuchishoUchiwake.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(通知書.getコード(), 通知書.get名称());
            dataSources.add(dataSource);
        }
        return dataSources;
    }

    private List<KeyValueDataSource> get対象者List() {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        for (KetteiHenkoTsuchishoUchiwakeKozaJoken 対象者 : KetteiHenkoTsuchishoUchiwakeKozaJoken.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(対象者.getコード(), 対象者.get名称());
            dataSources.add(dataSource);
        }
        return dataSources;
    }

}
