/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1170001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.shotokushokai.ShotokuShokaiTaishosha;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1170001.ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1170001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.service.core.shotokushokai.ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranManager;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.config.ShotokuHikidashiConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysHizuke;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 画面設計_DBBGM51001_所得照会状況一覧のハンドラクラス
 *
 * @reamsid_L DBB-1700-010 zhangrui
 */
public class ShotokuShokaiTaishoshaIchiranHandler {

    private final ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div;
    private final ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranManager manager;

    private static final RString 住民税減免前後表示区分_表示する = new RString("1");
    private static final RString 改行タグ = new RString("<br>");
    private static final RString 個人番号_利用有無 = new RString("個人番号 利用有無");
    private static final RString 法人番号_利用有無 = new RString("法人番号 利用有無");
    private static final RString キー抽出基準年度 = new RString("抽出基準年度");
    private static final RString キー抽出期間FROM年月日 = new RString("抽出期間FROM年月日");
    private static final RString キー抽出期間FROM時分秒 = new RString("抽出期間FROM時分秒");
    private static final RString キー抽出期間TO年月日 = new RString("抽出期間TO年月日");
    private static final RString キー抽出期間TO時分秒 = new RString("抽出期間TO時分秒");
    private static final RString 無し = new RString("無し");
    private static final RString 連番_0001 = new RString("0001");
    private static final RString 連番_0002 = new RString("0002");

    /**
     * コンストラクタ
     *
     * @param div ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv
     */
    public ShotokuShokaiTaishoshaIchiranHandler(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
        this.div = div;
        this.manager = ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranManager.createInstance();
    }

    /**
     * コンストラクタです
     *
     * @param div 画面DIV
     * @return ShotokuShokaiTaishoshaIchiranHandler Mainハンドラークラス
     */
    public static ShotokuShokaiTaishoshaIchiranHandler of(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
        return new ShotokuShokaiTaishoshaIchiranHandler(div);
    }

    /**
     * onload方法
     *
     * @param keyMap Map<RString, Object>
     */
    public void onload(Map<RString, Object> keyMap) {
        if (null != keyMap) {
            RYear 基準年度 = (RYear) keyMap.get(キー抽出基準年度);
            RDate 期間FROM年月日 = (RDate) keyMap.get(キー抽出期間FROM年月日);
            RTime 期間FROM時分秒 = (RTime) keyMap.get(キー抽出期間FROM時分秒);
            RDate 期間TO年月日 = (RDate) keyMap.get(キー抽出期間TO年月日);
            RTime 期間TO時分秒 = (RTime) keyMap.get(キー抽出期間TO時分秒);
            div.getTxtChushutsuKijunNendo().setDomain(基準年度);
            div.getTxtChushutsuStYMD().setValue(期間FROM年月日);
            div.getTxtChushutsuStTime().setValue(期間FROM時分秒);
            div.getTxtChushutsuEdYMD().setValue(期間TO年月日);
            div.getTxtChushutsuEdTime().setValue(期間TO時分秒);
            do対象者を抽出する();
        } else {
            FlexibleYear 日付関連_調定年度
                    = new FlexibleYear(DbBusinessConfig.get(
                                    ConfigKeysHizuke.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
            RDateTime now = RDateTime.now();
            div.getTxtChushutsuKijunNendo().setDomain(new RYear(日付関連_調定年度.getYearValue()));
            div.getTxtChushutsuStTime().setValue(RTime.of(0, 0, 0));
            div.getTxtChushutsuEdYMD().setValue(now.getDate());
            div.getTxtChushutsuEdTime().setValue(now.getTime());
        }
    }

    /**
     * 対象者を抽出する
     *
     */
    public void do対象者を抽出する() {
        div.getDgTaishoshaIchiran().getDataSource().clear();
        List<ShotokuShokaiTaishosha> taishoshaList = do対象者一覧データを取得();
        if (null == taishoshaList || taishoshaList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }
        List<dgTaishoshaIchiran_Row> dataSource = new ArrayList<>();
        for (ShotokuShokaiTaishosha taishosha : taishoshaList) {
            RString 被保険者番号 = (taishosha.getEntity().getHihokenshaNo() != null)
                    ? taishosha.getEntity().getHihokenshaNo().getColumnValue() : RString.EMPTY;
            RString 世帯コード = (taishosha.getEntity().getSetaiCode() != null)
                    ? taishosha.getEntity().getSetaiCode().getColumnValue() : RString.EMPTY;
            RString 識別コード = (taishosha.getEntity().getShikibetsuCode() != null)
                    ? taishosha.getEntity().getShikibetsuCode().getColumnValue() : RString.EMPTY;
            RString 氏名_カナ = (taishosha.getEntity().getKanaShimei() != null)
                    ? taishosha.getEntity().getKanaShimei().getColumnValue() : RString.EMPTY;
            RString 氏名_漢字 = (taishosha.getEntity().getKanjiShimei() != null)
                    ? taishosha.getEntity().getKanjiShimei().getColumnValue() : RString.EMPTY;
            RString 生年月日 = (taishosha.getEntity().getSeinengappiYMD() != null)
                    ? taishosha.getEntity().getSeinengappiYMD().wareki().toDateString() : RString.EMPTY;
            RString 性別 = (taishosha.getEntity().getSeibetsuCode() != null)
                    ? Seibetsu.toValue(taishosha.getEntity().getSeibetsuCode()).get名称() : RString.EMPTY;
            RString 照会日 = (taishosha.getEntity().getHakkoYMD() != null)
                    ? taishosha.getEntity().getHakkoYMD().wareki().toDateString() : RString.EMPTY;
            RString 送付先自治体名 = RString.EMPTY;
            if (taishosha.getEntity().getShokaisakiLasdecCode() != null) {
                ICityAtesakiFinder finder = CityAtesakiService.createCityAtesakiFinder();
                ShichosonAtesaki atesaki = finder.get市町村宛先(taishosha.getEntity().getShokaisakiLasdecCode(),
                        SofusakiGroup.所得照会関連.getCode());
                if (null != atesaki) {
                    送付先自治体名 = atesaki.get名称();
                }
            }
            RString 世帯コードAnd識別コード = 世帯コード.concat(改行タグ).concat(識別コード);
            RString 氏名 = 氏名_カナ.concat(改行タグ).concat(氏名_漢字);
            RString 生年月日And性別 = 生年月日.concat(改行タグ).concat(性別);
            RString 照会日And送付先自治体名 = 照会日.concat(改行タグ).concat(送付先自治体名);
            dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row();
            row.getTxtHihokenshaNo().setValue(被保険者番号);
            row.getTxtKetsugoCode().setValue(世帯コードAnd識別コード);
            row.getTxtSetaiCode().setValue(世帯コード);
            row.getTxtShikibetsuCode().setValue(識別コード);
            row.getTxtKetsugo1().setValue(氏名);
            row.getTxtKanaShimei().setValue(氏名_カナ);
            row.getTxtShimei().setValue(氏名_漢字);
            row.getTxtKetsugo3().setValue(生年月日And性別);
            row.getTxtUmareYMD().setValue(生年月日);
            row.getTxtSebetsu().setValue(性別);
            row.getTxtKetsugo5().setValue(照会日And送付先自治体名);
            row.getTxtShokaiYMD().setValue(照会日);
            row.getTxtShokaisakiCityName().setValue(送付先自治体名);
            dataSource.add(row);
            AccessLogger.log(AccessLogType.照会, toPersonalData(taishosha.getEntity().getShikibetsuCode()));
        }
        div.getDgTaishoshaIchiran().setDataSource(dataSource);
    }

    /**
     * 遷移前データを準備する、所得照会回答内容登録画面の引数
     *
     * @return FukaTaishoshaKey
     */
    public FukaTaishoshaKey do遷移前データ準備_引数() {
        dgTaishoshaIchiran_Row selected = div.getDgTaishoshaIchiran().getClickedItem();
        RString 被保険者番号 = selected.getTxtHihokenshaNo().getValue();
        RString 識別コード = selected.getTxtShikibetsuCode().getValue();
        RYear 所得年度 = div.getTxtChushutsuKijunNendo().getDomain();
        return new FukaTaishoshaKey(new HihokenshaNo(被保険者番号), new ShikibetsuCode(識別コード),
                null, null, new FlexibleYear(所得年度.toString()),
                null,
                new FlexibleYear(所得年度.toString()));
    }

    /**
     * 遷移前データを準備する、抽出条件
     *
     * @return Map<RString, Object>
     */
    public Map<RString, Object> do遷移前データ準備_抽出条件() {
        Map<RString, Object> keyMap = new HashMap<>();
        RDate 期間FROM年月日 = div.getTxtChushutsuStYMD().getValue();
        RTime 期間FROM時分秒 = div.getTxtChushutsuStTime().getValue();
        RDate 期間TO年月日 = div.getTxtChushutsuEdYMD().getValue();
        RTime 期間TO時分秒 = div.getTxtChushutsuEdTime().getValue();
        RYear 所得年度 = div.getTxtChushutsuKijunNendo().getDomain();
        keyMap.put(キー抽出基準年度, 所得年度);
        keyMap.put(キー抽出期間FROM年月日, 期間FROM年月日);
        keyMap.put(キー抽出期間FROM時分秒, 期間FROM時分秒);
        keyMap.put(キー抽出期間TO年月日, 期間TO年月日);
        keyMap.put(キー抽出期間TO時分秒, 期間TO時分秒);
        return keyMap;
    }

    private List<ShotokuShokaiTaishosha> do対象者一覧データを取得() {
        ShotokuHikidashiConfig cfg = new ShotokuHikidashiConfig();
        RString 住民税減免前後表示区分 = cfg.get所得引出_住民税減免前後表示区分();
        RYear 基準年度 = div.getTxtChushutsuKijunNendo().getDomain();
        RDate 期間FROM年月日 = div.getTxtChushutsuStYMD().getValue();
        RTime 期間FROM時分秒 = div.getTxtChushutsuStTime().getValue();
        RDate 期間TO年月日 = div.getTxtChushutsuEdYMD().getValue();
        RTime 期間TO時分秒 = div.getTxtChushutsuEdTime().getValue();
        return manager.get対象者一覧データ(住民税減免前後表示区分_表示する.equals(住民税減免前後表示区分),
                基準年度, 期間FROM年月日, 期間FROM時分秒, 期間TO年月日, 期間TO時分秒);
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(new Code(連番_0001), 個人番号_利用有無, 無し);
        ExpandedInformation expandedInfo2 = new ExpandedInformation(new Code(連番_0002), 法人番号_利用有無, 無し);
        return PersonalData.of(識別コード, expandedInfo1, expandedInfo2);
    }

}
