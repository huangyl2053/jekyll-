/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsuBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsuControl;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji1;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji2;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji3;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.CustomerBarcodeHenkanErrorHenshuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.CustomerBarcodeShiyoUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.DaikoPrintUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.DianoninHyojiUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.GaibuChohyoMojigireSeigyo;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.KozaMaskUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.KozaMeigininKanaYusenKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.MojigireBunriSeigyo;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.NaibuChohyoMojigireSeigyo;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.SetainushiHyojiUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.IKaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.KaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuControlManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護帳票制御共通Div処理するクラスです。
 *
 * @reamsid_L DBB-1770-070 yebangqiang
 */
public class KaigoChohyoSeigyoKyotsuHandler {

    private final KaigoChohyoSeigyoKyotsuDiv div;
    private static final RString ラジオ_する = new RString("1");
    private static final RString ラジオ_しない = new RString("0");
    private static final int 帳票出力順_1 = 1;
    private static final int 帳票出力順_2 = 2;
    private static final int 帳票出力順_3 = 3;
    private static final int 帳票出力順_4 = 4;
    private static final RString 帳票出力順表示_ALL = new RString("ALL");
    private static final RString 帳票出力順表示_SORT_ONLY = new RString("SORT_ONLY");
    private static final RString 帳票出力順表示_SHUKEI_NONE = new RString("SHUKEI_NONE");
    private static final RString 帳票出力順表示_KAIPEJIJOKEN_NONE = new RString("KAIPEJIJOKEN_NONE");
    private static final RString 画面表示可 = new RString("2");
    private static final RString タグ挿入ボタン表示制御_表示する = new RString("1");
    private static final RString タグ_改行記号 = new RString("改行記号");
    private static final RString 埋め込み_改行記号 = new RString("<改行記号>");
    private static final RString タグ_市町村名 = new RString("市町村名");
    private static final RString 埋め込み_市町村名 = new RString("<市町村名>");
    private static final RString タグ_都道府県名 = new RString("都道府県名");
    private static final RString 埋め込み_都道府県名 = new RString("<都道府県名>");
    private static final RString タグ_本日日付 = new RString("本日日付");
    private static final RString 埋め込み_本日日付 = new RString("<本日日付>");
    private static final RString タグ_郵便番号 = new RString("郵便番号");
    private static final RString 埋め込み_郵便番号 = new RString("<郵便番号>");
    private static final RString タグ_所在地 = new RString("所在地");
    private static final RString 埋め込み_所在地 = new RString("<所在地>");
    private static final RString タグ_庁舎名 = new RString("庁舎名");
    private static final RString 埋め込み_庁舎名 = new RString("<庁舎名>");
    private static final RString タグ_電話番号 = new RString("電話番号");
    private static final RString 埋め込み_電話番号 = new RString("<電話番号>");
    private static final RString タグ_内線番号 = new RString("内線番号");
    private static final RString 埋め込み_内線番号 = new RString("<内線番号>");
    private static final RString タグ_部署名 = new RString("部署名");
    private static final RString 埋め込み_部署名 = new RString("<部署名>");
    private static final RString タグ_担当者名 = new RString("担当者名");
    private static final RString 埋め込み_担当者名 = new RString("<担当者名>");

    /**
     * コンストラクタです。
     *
     * @param kaigoChohyoSeigyoKyotsuDiv 介護帳票制御共通Div
     */
    public KaigoChohyoSeigyoKyotsuHandler(KaigoChohyoSeigyoKyotsuDiv kaigoChohyoSeigyoKyotsuDiv) {
        this.div = kaigoChohyoSeigyoKyotsuDiv;
    }

    /**
     * 介護帳票制御共通情報の初期化
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     */
    public void initialize(SubGyomuCode subGyomuCode, ReportId reportId, ChohyoSeigyoKyotsu 帳票制御共通) {
        ChohyoSeigyoKyotsuControlManager manager = new ChohyoSeigyoKyotsuControlManager();
        ChohyoSeigyoKyotsuControl 帳票制御共通コントロール = manager.get帳票制御共通コントロール(subGyomuCode, reportId);
        if (!画面表示可.equals(帳票制御共通コントロール.get住所編集使用区分())) {
            div.getAtesakiJusho().setDisplayNone(true);
        }
        if (!画面表示可.equals(帳票制御共通コントロール.get地区表示使用区分())) {
            div.getConfigInfo1().setDisplayNone(true);
        }
        if (!画面表示可.equals(帳票制御共通コントロール.get世帯主表示使用区分()) && !画面表示可.equals(
                帳票制御共通コントロール.get代納人表示使用区分()) && !画面表示可.equals(
                        帳票制御共通コントロール.get口座マスク使用区分()) && !画面表示可.equals(
                        帳票制御共通コントロール.get口座名義人カナ優先使用区分())) {
            div.getConfigInfo2().setDisplayNone(true);
        } else {
            if (!画面表示可.equals(帳票制御共通コントロール.get世帯主表示使用区分())) {
                div.getConfigInfo2().getRadSetaiNushiHyoji().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get代納人表示使用区分())) {
                div.getConfigInfo2().getRadDainoninHyoji().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get口座マスク使用区分())) {
                div.getConfigInfo2().getRadKozaMask().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get口座名義人カナ優先使用区分())) {
                div.getConfigInfo2().getRadKozaMeigininKana().setDisplayNone(true);
            }
        }
        if (!画面表示可.equals(帳票制御共通コントロール.get外部帳票文字切れ制御使用区分()) && !画面表示可.equals(
                帳票制御共通コントロール.get内部帳票文字切れ制御使用区分()) && !画面表示可.equals(
                        帳票制御共通コントロール.get文字切れ分離制御使用区分()) && !画面表示可.equals(
                        帳票制御共通コントロール.get代行プリント使用区分())
                && !画面表示可.equals(帳票制御共通コントロール.get定型文文字サイズ使用区分())) {
            div.getConfigInfo3().setDisplayNone(true);
        } else {
            if (!画面表示可.equals(帳票制御共通コントロール.get外部帳票文字切れ制御使用区分())) {
                div.getConfigInfo3().getRadMonjiKireCrtlGaibu().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get内部帳票文字切れ制御使用区分())) {
                div.getConfigInfo3().getRadMonjiKireCrtlNaibu().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get文字切れ分離制御使用区分())) {
                div.getConfigInfo3().getRadMojiKireBunriCtrl().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get代行プリント使用区分())) {
                div.getConfigInfo3().getRadDaikoPrintUmu().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get定型文文字サイズ使用区分())) {
                div.getConfigInfo3().getDdlChohyoMongonYoshiki().setDisplayNone(true);
            }
        }
        if (!画面表示可.equals(帳票制御共通コントロール.getカスタマバーコード使用区分())) {
            div.getConfigInfo4().setDisplayNone(true);
        }
        if (!画面表示可.equals(帳票制御共通コントロール.get文書番号使用区分()) && !画面表示可.equals(
                帳票制御共通コントロール.get通知書定型文使用区分()) && !画面表示可.equals(
                        帳票制御共通コントロール.get認証者使用区分()) && !画面表示可.equals(
                        帳票制御共通コントロール.get介護問合せ先使用区分())) {
            div.getCommonButtonPanel().setDisplayNone(true);
        } else {
            if (!画面表示可.equals(帳票制御共通コントロール.get文書番号使用区分())) {
                div.getCommonButtonPanel().getBtnBunshoNo().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get通知書定型文使用区分())) {
                div.getCommonButtonPanel().getBtnTsuchishoTeikeibun().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get認証者使用区分())) {
                div.getCommonButtonPanel().getBtnGyomuNinshohsa().setDisplayNone(true);
            }
            if (!画面表示可.equals(帳票制御共通コントロール.get介護問合せ先使用区分())) {
                div.getCommonButtonPanel().getBtnKaigoToiawasesaki().setDisplayNone(true);
            }
        }
        if (!画面表示可.equals(帳票制御共通コントロール.get帳票出力順使用区分())) {
            div.getCcdChohyoShutsuryokujun().setDisplayNone(true);
        }
        setDataSource();
        set初期表示(subGyomuCode, reportId, 帳票制御共通コントロール.get帳票出力順表示方法(), 帳票制御共通);

        div.setHdnSubGyomuCode(subGyomuCode.value());
        div.setHdnReportId(reportId.value());
        div.setHdnReportName(帳票制御共通.get帳票分類名称());
        div.setHdnIsDisplayInsertTag(タグ挿入ボタン表示制御_表示する);
        Map<RString, RString> tagList = new HashMap<>();
        tagList.put(タグ_改行記号, 埋め込み_改行記号);
        tagList.put(タグ_市町村名, 埋め込み_市町村名);
        tagList.put(タグ_都道府県名, 埋め込み_都道府県名);
        tagList.put(タグ_本日日付, 埋め込み_本日日付);
        tagList.put(タグ_郵便番号, 埋め込み_郵便番号);
        tagList.put(タグ_所在地, 埋め込み_所在地);
        tagList.put(タグ_庁舎名, 埋め込み_庁舎名);
        tagList.put(タグ_電話番号, 埋め込み_電話番号);
        tagList.put(タグ_内線番号, 埋め込み_内線番号);
        tagList.put(タグ_部署名, 埋め込み_部署名);
        tagList.put(タグ_担当者名, 埋め込み_担当者名);
        div.setHdnTagList(DataPassingConverter.serialize((Serializable) tagList));
    }

    /**
     * 介護帳票制御共通情報の保存
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     */
    public void save(SubGyomuCode subGyomuCode, ReportId reportId, ChohyoSeigyoKyotsu 帳票制御共通) {
        ChohyoSeigyoKyotsuManager 帳票制御共通Mgr = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsuBuilder builder = 帳票制御共通.createBuilderForEdit();
        if (!div.getAtesakiJusho().isDisplayNone()) {
            KaigoAtesakiJushoSetteiDiv ccdDiv = (KaigoAtesakiJushoSetteiDiv) div.getAtesakiJusho().getCcdKaigoAtesakiJushoSettei();
            RString 住所設定 = ccdDiv.getRadJushoSettei().getSelectedKey();
            if (ラジオ_する.equals(住所設定)) {
                final IKaigoAtesakiJushoSetteiDiv ccdKaigoAtesakiJushoSettei = div.getAtesakiJusho().getCcdKaigoAtesakiJushoSettei();
                builder.set住所編集区分(ラジオ_する).set住所編集都道府県名表示有無(ccdKaigoAtesakiJushoSettei.is都道府県名表示()).
                        set住所編集郡名表示有無(ccdKaigoAtesakiJushoSettei.is郡名表示()).set住所編集市町村名表示有無(ccdKaigoAtesakiJushoSettei.is市町村名表示()).
                        set住所編集町域編集方法(ccdKaigoAtesakiJushoSettei.get町域編集方法()).set住所編集方書表示有無(ccdKaigoAtesakiJushoSettei.is方書表示());
            } else {
                builder.set住所編集区分(ラジオ_しない);
            }
        }
        if (!div.getConfigInfo1().isDisplayNone()) {
            builder.set地区表示1(div.getConfigInfo1().getDdlHyojiCodeName1().getSelectedKey()).
                    set地区表示2(div.getConfigInfo1().getDdlHyojiCodeName2().getSelectedKey()).
                    set地区表示3(div.getConfigInfo1().getDdlHyojiCodeName3().getSelectedKey());
        }
        if (!div.getConfigInfo2().isDisplayNone()) {
            RString 世帯主 = div.getConfigInfo2().getRadSetaiNushiHyoji().getSelectedKey();
            builder.set世帯主表示有無(false);
            if (ラジオ_する.equals(世帯主)) {
                builder.set世帯主表示有無(true);
            }
            RString 代納人 = div.getConfigInfo2().getRadDainoninHyoji().getSelectedKey();
            builder.set代納人表示有無(false);
            if (ラジオ_する.equals(代納人)) {
                builder.set代納人表示有無(true);
            }
            RString 口座番号 = div.getConfigInfo2().getRadKozaMask().getSelectedKey();
            builder.set口座マスク有無(false);
            if (ラジオ_する.equals(口座番号)) {
                builder.set口座マスク有無(true);
            }
            builder.set口座名義人カナ優先区分(
                    div.getConfigInfo2().getRadKozaMeigininKana().getSelectedKey());
        }
        if (!div.getConfigInfo3().isDisplayNone()) {
            builder.set外部帳票文字切れ制御(
                    div.getConfigInfo3().getRadMonjiKireCrtlGaibu().getSelectedKey());
            builder.set内部帳票文字切れ制御(
                    div.getConfigInfo3().getRadMonjiKireCrtlNaibu().getSelectedKey());
            builder.set文字切れ分離制御(
                    div.getConfigInfo3().getRadMojiKireBunriCtrl().getSelectedKey());
            RString 代行プリント有無 = div.getConfigInfo3().getRadDaikoPrintUmu().getSelectedKey();
            builder.set代行プリント有無(false);
            if (ラジオ_する.equalsIgnoreCase(代行プリント有無)) {
                builder.set代行プリント有無(true);
            }
            builder.set定型文文字サイズ(
                    div.getConfigInfo3().getDdlChohyoMongonYoshiki().getSelectedKey());
        }
        if (!div.getConfigInfo4().isDisplayNone()) {
            RString バーコード使用有無 = div.getConfigInfo4().getDdlBarCodeUmu().getSelectedKey();
            builder.setカスタマバーコード使用有無(false);
            if (ラジオ_する.equalsIgnoreCase(バーコード使用有無)) {
                builder.setカスタマバーコード使用有無(true);
            }
            builder.setカスタマバーコード変換エラー編集方法(
                    div.getConfigInfo4().getDdlBarCodeHenshuHoho().getSelectedKey());
        }
        if (!div.getAtesakiJusho().isDisplayNone() || !div.getConfigInfo1().isDisplayNone()
                || !div.getConfigInfo2().isDisplayNone() || !div.getConfigInfo3().isDisplayNone()
                || !div.getConfigInfo4().isDisplayNone()) {
            帳票制御共通 = builder.build();
            帳票制御共通Mgr.update帳票制御共通(帳票制御共通);
        }
    }

    private void setDataSource() {
        List<KeyValueDataSource> 地区表示1 = new ArrayList<>();
        地区表示1.add(new KeyValueDataSource(ChikuHyoji1.なし.getコード(), ChikuHyoji1.なし.get名称()));
        地区表示1.add(new KeyValueDataSource(ChikuHyoji1.住所コード.getコード(), ChikuHyoji1.住所コード.get名称()));
        地区表示1.add(new KeyValueDataSource(ChikuHyoji1.行政区コード.getコード(), ChikuHyoji1.行政区コード.get名称()));
        div.getConfigInfo1().getDdlHyojiCodeName1().setDataSource(地区表示1);

        List<KeyValueDataSource> 地区表示2 = new ArrayList<>();
        地区表示2.add(new KeyValueDataSource(ChikuHyoji2.なし.getコード(), ChikuHyoji2.なし.get名称()));
        final RDate nowDate = RDate.getNowDate();
        地区表示2.add(new KeyValueDataSource(ChikuHyoji2.地区の分類1.getコード(),
                DbBusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, nowDate,
                        SubGyomuCode.URZ業務共通_共通系)));
        地区表示2.add(new KeyValueDataSource(ChikuHyoji2.地区の分類2.getコード(),
                DbBusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, nowDate,
                        SubGyomuCode.URZ業務共通_共通系)));
        地区表示2.add(new KeyValueDataSource(ChikuHyoji2.地区の分類3.getコード(),
                DbBusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, nowDate,
                        SubGyomuCode.URZ業務共通_共通系)));
        地区表示2.add(new KeyValueDataSource(ChikuHyoji2.納組コード.getコード(), ChikuHyoji2.納組コード.get名称()));
        div.getConfigInfo1().getDdlHyojiCodeName2().setDataSource(地区表示2);

        List<KeyValueDataSource> 地区表示3 = new ArrayList<>();
        地区表示3.add(new KeyValueDataSource(ChikuHyoji3.なし.getコード(), ChikuHyoji3.なし.get名称()));
        地区表示3.add(new KeyValueDataSource(ChikuHyoji3.地区の分類1.getコード(),
                DbBusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, nowDate,
                        SubGyomuCode.URZ業務共通_共通系)));
        地区表示3.add(new KeyValueDataSource(ChikuHyoji3.地区の分類2.getコード(),
                DbBusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, nowDate,
                        SubGyomuCode.URZ業務共通_共通系)));
        地区表示3.add(new KeyValueDataSource(ChikuHyoji3.地区の分類3.getコード(),
                DbBusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, nowDate,
                        SubGyomuCode.URZ業務共通_共通系)));
        地区表示3.add(new KeyValueDataSource(ChikuHyoji3.納組コード.getコード(), ChikuHyoji3.納組コード.get名称()));
        div.getConfigInfo1().getDdlHyojiCodeName3().setDataSource(地区表示3);

        List<KeyValueDataSource> 世帯主 = new ArrayList<>();
        世帯主.add(new KeyValueDataSource(SetainushiHyojiUmu.表示する.getコード(), SetainushiHyojiUmu.表示する.get名称()));
        世帯主.add(new KeyValueDataSource(
                SetainushiHyojiUmu.表示しない.getコード(), SetainushiHyojiUmu.表示しない.get名称()));
        div.getConfigInfo2().getRadSetaiNushiHyoji().setDataSource(世帯主);

        List<KeyValueDataSource> 代納人 = new ArrayList<>();
        代納人.add(new KeyValueDataSource(DianoninHyojiUmu.表示する.getコード(), DianoninHyojiUmu.表示する.get名称()));
        代納人.add(new KeyValueDataSource(DianoninHyojiUmu.表示しない.getコード(), DianoninHyojiUmu.表示しない.get名称()));
        div.getConfigInfo2().getRadDainoninHyoji().setDataSource(代納人);

        List<KeyValueDataSource> 口座番号マスク = new ArrayList<>();
        口座番号マスク.add(new KeyValueDataSource(KozaMaskUmu.マスクする.getコード(), KozaMaskUmu.マスクする.get名称()));
        口座番号マスク.add(new KeyValueDataSource(KozaMaskUmu.マスクしない.getコード(), KozaMaskUmu.マスクしない.get名称()));
        div.getConfigInfo2().getRadKozaMask().setDataSource(口座番号マスク);

        List<KeyValueDataSource> 口座名義人カナ優先区分 = new ArrayList<>();
        口座名義人カナ優先区分.add(new KeyValueDataSource(KozaMeigininKanaYusenKubun.表示する.getコード(),
                KozaMeigininKanaYusenKubun.表示する.get名称()));
        口座名義人カナ優先区分.add(new KeyValueDataSource(KozaMeigininKanaYusenKubun.表示しない.getコード(),
                KozaMeigininKanaYusenKubun.表示しない.get名称()));
        div.getConfigInfo2().getRadKozaMeigininKana().setDataSource(口座名義人カナ優先区分);

        List<KeyValueDataSource> 外部帳票文字切れ制御 = new ArrayList<>();
        外部帳票文字切れ制御.add(new KeyValueDataSource(GaibuChohyoMojigireSeigyo.印字しない.getコード(),
                GaibuChohyoMojigireSeigyo.印字しない.get名称()));
        外部帳票文字切れ制御.add(new KeyValueDataSource(GaibuChohyoMojigireSeigyo.印字可能範囲まで印字する.getコード(),
                GaibuChohyoMojigireSeigyo.印字可能範囲まで印字する.get名称()));
        div.getConfigInfo3().getRadMonjiKireCrtlGaibu().setDataSource(外部帳票文字切れ制御);

        List<KeyValueDataSource> 内部帳票文字切れ制御 = new ArrayList<>();
        内部帳票文字切れ制御.add(new KeyValueDataSource(NaibuChohyoMojigireSeigyo.印字可能範囲まで印字する.getコード(),
                NaibuChohyoMojigireSeigyo.印字可能範囲まで印字する.get略称()));
        内部帳票文字切れ制御.add(new KeyValueDataSource(NaibuChohyoMojigireSeigyo.ｵｰﾊﾞｰﾌﾛｰ文字を印字する.getコード(),
                NaibuChohyoMojigireSeigyo.ｵｰﾊﾞｰﾌﾛｰ文字を印字する.get略称()));
        div.getConfigInfo3().getRadMonjiKireCrtlNaibu().setDataSource(内部帳票文字切れ制御);

        List<KeyValueDataSource> 文字切れ分離制御 = new ArrayList<>();
        文字切れ分離制御.add(new KeyValueDataSource(MojigireBunriSeigyo.分ける.getコード(),
                MojigireBunriSeigyo.分ける.get略称()));
        文字切れ分離制御.add(new KeyValueDataSource(MojigireBunriSeigyo.分けない.getコード(),
                MojigireBunriSeigyo.分けない.get略称()));
        div.getConfigInfo3().getRadMojiKireBunriCtrl().setDataSource(文字切れ分離制御);

        List<KeyValueDataSource> 代行プリント有無 = new ArrayList<>();
        代行プリント有無.add(new KeyValueDataSource(DaikoPrintUmu.プリントする.getコード(),
                DaikoPrintUmu.プリントする.get名称()));
        代行プリント有無.add(new KeyValueDataSource(DaikoPrintUmu.プリントしない.getコード(),
                DaikoPrintUmu.プリントしない.get名称()));
        div.getConfigInfo3().getRadDaikoPrintUmu().setDataSource(代行プリント有無);

        List<KeyValueDataSource> 帳票文言様式 = new ArrayList<>();
        帳票文言様式.add(new KeyValueDataSource(TeikeibunMojiSize.フォント上大下小.getコード(),
                TeikeibunMojiSize.フォント上大下小.get名称()));
        帳票文言様式.add(new KeyValueDataSource(TeikeibunMojiSize.フォント上小下大.getコード(),
                TeikeibunMojiSize.フォント上小下大.get名称()));
        帳票文言様式.add(new KeyValueDataSource(TeikeibunMojiSize.フォント大.getコード(),
                TeikeibunMojiSize.フォント大.get名称()));
        帳票文言様式.add(new KeyValueDataSource(TeikeibunMojiSize.フォント小.getコード(),
                TeikeibunMojiSize.フォント小.get名称()));
        div.getConfigInfo3().getDdlChohyoMongonYoshiki().setDataSource(帳票文言様式);

        List<KeyValueDataSource> カスタマーバーコード = new ArrayList<>();
        カスタマーバーコード.add(new KeyValueDataSource(CustomerBarcodeShiyoUmu.使用しない.getコード(),
                CustomerBarcodeShiyoUmu.使用しない.get名称()));
        カスタマーバーコード.add(new KeyValueDataSource(CustomerBarcodeShiyoUmu.使用する.getコード(),
                CustomerBarcodeShiyoUmu.使用する.get名称()));
        div.getConfigInfo4().getDdlBarCodeUmu().setDataSource(カスタマーバーコード);

        List<KeyValueDataSource> バーコード変換エラー時のバーコード編集方法 = new ArrayList<>();
        バーコード変換エラー時のバーコード編集方法.add(
                new KeyValueDataSource(CustomerBarcodeHenkanErrorHenshuHoho.空白をセット.getコード(),
                        CustomerBarcodeHenkanErrorHenshuHoho.空白をセット.get名称()));
        バーコード変換エラー時のバーコード編集方法.add(
                new KeyValueDataSource(CustomerBarcodeHenkanErrorHenshuHoho.入力郵便番号をセット.getコード(),
                        CustomerBarcodeHenkanErrorHenshuHoho.入力郵便番号をセット.get名称()));
        div.getConfigInfo4().getDdlBarCodeHenshuHoho().setDataSource(バーコード変換エラー時のバーコード編集方法);
    }

    private void set初期表示(SubGyomuCode subGyomuCode, ReportId reportId, RString 帳票出力順表示方法,
            ChohyoSeigyoKyotsu 帳票制御共通) {
        div.getCcdKaigoAtesakiJushoSettei().initialize(subGyomuCode.getColumnValue(), reportId.getColumnValue());
        div.getCcdChohyoShutsuryokujun().load(subGyomuCode, reportId);
        set出力順モード(帳票出力順表示方法, (ChohyoShutsuryokujunDiv) div.getCcdChohyoShutsuryokujun());
        div.getConfigInfo1().getDdlHyojiCodeName1().setSelectedKey(帳票制御共通.get地区表示1());
        div.getConfigInfo1().getDdlHyojiCodeName2().setSelectedKey(帳票制御共通.get地区表示2());
        div.getConfigInfo1().getDdlHyojiCodeName3().setSelectedKey(帳票制御共通.get地区表示3());
        div.getConfigInfo2().getRadSetaiNushiHyoji().setSelectedKey(
                帳票制御共通.is世帯主表示有無() ? ラジオ_する : ラジオ_しない);
        div.getConfigInfo2().getRadDainoninHyoji().setSelectedKey(
                帳票制御共通.is代納人表示有無() ? ラジオ_する : ラジオ_しない);
        div.getConfigInfo2().getRadKozaMask().setSelectedKey(
                帳票制御共通.is口座マスク有無() ? ラジオ_する : ラジオ_しない);
        div.getConfigInfo2().getRadKozaMeigininKana().setSelectedKey(帳票制御共通.get口座名義人カナ優先区分());
        div.getConfigInfo3().getRadMonjiKireCrtlGaibu().setSelectedKey(帳票制御共通.get外部帳票文字切れ制御());
        div.getConfigInfo3().getRadMonjiKireCrtlNaibu().setSelectedKey(帳票制御共通.get内部帳票文字切れ制御());
        div.getConfigInfo3().getRadMojiKireBunriCtrl().setSelectedKey(帳票制御共通.get文字切れ分離制御());
        div.getConfigInfo3().getRadDaikoPrintUmu().setSelectedKey(
                帳票制御共通.is代行プリント有無() ? ラジオ_する : ラジオ_しない);
        div.getConfigInfo3().getDdlChohyoMongonYoshiki().setSelectedKey(帳票制御共通.get定型文文字サイズ());
        div.getConfigInfo4().getDdlBarCodeUmu().setSelectedKey(
                帳票制御共通.isカスタマバーコード使用有無() ? ラジオ_する : ラジオ_しない);
        div.getConfigInfo4().getDdlBarCodeHenshuHoho().setSelectedKey(
                帳票制御共通.getカスタマバーコード変換エラー編集方法());
    }

    private void set出力順モード(RString 帳票出力順表示方法, ChohyoShutsuryokujunDiv ccdDiv) {
        if (帳票出力順表示方法 != null) {
            switch (Integer.parseInt(帳票出力順表示方法.toString())) {
                case 帳票出力順_1:
                    ccdDiv.setMode_DisplayNone(ChohyoShutsuryokujunDiv.DisplayNone.getEnum(
                            帳票出力順表示_ALL.toString()));
                    break;
                case 帳票出力順_2:
                    ccdDiv.setMode_DisplayNone(ChohyoShutsuryokujunDiv.DisplayNone.getEnum(
                            帳票出力順表示_SORT_ONLY.toString()));
                    break;
                case 帳票出力順_3:
                    ccdDiv.setMode_DisplayNone(ChohyoShutsuryokujunDiv.DisplayNone.getEnum(
                            帳票出力順表示_SHUKEI_NONE.toString()));
                    break;
                case 帳票出力順_4:
                    ccdDiv.setMode_DisplayNone(ChohyoShutsuryokujunDiv.DisplayNone.getEnum(
                            帳票出力順表示_KAIPEJIJOKEN_NONE.toString()));
                    break;
                default:
                    break;
            }
        }
    }
}
