/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0130002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchoheijunkakakutei.HokenryoDankaibetu;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchoheijunkakakutei.Taishokensu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunkakakutei.TokuchoHeijunkaKakuteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002.HeijunkaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002.dgHeijunkaKakutei_Row;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunkakakutei.TokuchoHeijunkaKakutei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBBGM35004_特徴平準化確定のハンドラクラスです。
 *
 * @reamsid_L DBB-0830-010 wangkanglei
 */
public class HeijunkaKakuteiHandler {

    private final HeijunkaKakuteiDiv div;
    private static final RString 特徴平準化_特徴6月分 = new RString("DBBMN35004");
    private static final RString 特徴平準化_特徴8月分 = new RString("DBBMN35005");
    private static final RString NUM_0 = new RString("0");
    private static final RString 遷移区分_0 = new RString("0");
    private static final RString 遷移区分_1 = new RString("1");
    private static final RString FORMAT = new RString("%02d");
    private static final RString 処理枝番 = new RString("0001");
    private static final RString 年度内連番 = new RString("0001");
    private static final RString 確定処理を実行する = new RString("btnKakuteiReal");

    /**
     * コンストラクタです。
     *
     * @param div HeijunkaKakuteiDiv
     */
    public HeijunkaKakuteiHandler(HeijunkaKakuteiDiv div) {
        this.div = div;
    }

    /**
     * 基準日時チェックのメソッドます。
     */
    public void check基準日時() {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        ShoriDateKanri 処理日付管理 = null;
        RString 機能 = RString.EMPTY;
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        if (特徴平準化_特徴6月分.equals(ResponseHolder.getMenuID())) {
            処理日付管理 = manager.get処理日付管理マスタ(SubGyomuCode.DBB介護賦課,
                    ShoriName.特徴平準化_6月分_確定.get名称(),
                    処理枝番,
                    new FlexibleYear(調定年度.toString()),
                    年度内連番);
            機能 = ShoriName.特徴平準化_6月分_確定.get名称();
        } else if (特徴平準化_特徴8月分.equals(ResponseHolder.getMenuID())) {
            処理日付管理 = manager.get処理日付管理マスタ(SubGyomuCode.DBB介護賦課,
                    ShoriName.特徴平準化_8月分_確定.get名称(),
                    処理枝番,
                    new FlexibleYear(調定年度.toString()),
                    年度内連番);
            機能 = ShoriName.特徴平準化_8月分_確定.get名称();
        }
        if (処理日付管理 != null && 処理日付管理.get基準日時() != null && !処理日付管理.get基準日時().isEmpty()) {
            throw new ApplicationException(DbbErrorMessages.処理済み.getMessage().replace(機能.toString()));
        }
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @return 処理日付管理
     */
    public ShoriDateKanri initialize() {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        YMDHMS 基準日時 = null;
        ShoriDateKanri 処理日付管理 = null;
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        if (特徴平準化_特徴6月分.equals(ResponseHolder.getMenuID())) {
            処理日付管理 = manager.get処理日付管理マスタ(SubGyomuCode.DBB介護賦課,
                    ShoriName.特徴平準化計算_6月分.get名称(),
                    処理枝番,
                    new FlexibleYear(調定年度.toString()),
                    年度内連番);
        } else if (特徴平準化_特徴8月分.equals(ResponseHolder.getMenuID())) {
            処理日付管理 = manager.get処理日付管理マスタ(SubGyomuCode.DBB介護賦課,
                    ShoriName.特徴平準化計算_8月分.get名称(),
                    処理枝番,
                    new FlexibleYear(調定年度.toString()),
                    年度内連番);
        }
        if (処理日付管理 != null) {
            基準日時 = 処理日付管理.get基準日時();
        }
        div.getHeijunkaKakuteiShoriNaiyo().getTxtFukaNendo().setDomain(new RYear(調定年度.toString()));

        if (基準日時 != null) {
            RString 年月日 = 基準日時.getRDateTime().getDate().wareki().toDateString();
            RString 時刻 = 基準日時.getRDateTime().getTime().toFormattedTimeString(
                    DisplayTimeFormat.HH_mm_ss);
            RString 処理日時 = 年月日.concat(RString.HALF_SPACE).concat(時刻);
            div.getHeijunkaKakuteiShoriNaiyo().getTxtShoriNichiji().setValue(処理日時);
            set保険料段階別一覧(new FlexibleYear(調定年度.toString()), 基準日時);
        }
        div.getBtnSagakuSettei().setDisabled(false);
        div.getBtnTaishoGaiKensuSanshutsu().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(確定処理を実行する, false);
        return 処理日付管理;
    }

    private void set保険料段階別一覧(FlexibleYear 調定年度, YMDHMS 基準日時) {
        div.getHeijunkaSagakuKakunin().getTxtSagaku().setValue(Decimal.ZERO);
        HokenryoDankaiList 保険料段階 = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(調定年度);
        if (保険料段階 != null) {
            List<HokenryoDankai> 保険料段階List = 保険料段階.asList();
            Collections.sort(保険料段階List, new Comparator<HokenryoDankai>() {
                @Override
                public int compare(HokenryoDankai o1, HokenryoDankai o2) {

                    RString index1 = new RString(String.format(FORMAT.toString(),
                            Integer.valueOf(o1.get段階Index().toString())));
                    RString index2 = new RString(String.format(FORMAT.toString(),
                            Integer.valueOf(o2.get段階Index().toString())));
                    return index1.compareTo(index2);
                }
            });
            List<Integer> countList = TokuchoHeijunkaKakutei.createInstance().getHeijunkaTaishoKensu(
                    調定年度, 調定年度, 基準日時, 保険料段階List);
            List<dgHeijunkaKakutei_Row> rowList = new ArrayList<>();
            dgHeijunkaKakutei_Row row;
            Integer index = 0;
            for (HokenryoDankai 段階 : 保険料段階.asList()) {
                row = new dgHeijunkaKakutei_Row();
                row.setTxtHokenryoDankai(段階.get表記());
                row.getTxtSagaku().setValue(Decimal.ZERO);
                row.setTxtHeijunkaKensu(new RString(countList.get(index)));
                row.setTxtKakuteiKensu(NUM_0);
                row.setTxtTaishogaiKensu(NUM_0);
                row.setTxtDankaiKubun(段階.get段階区分());
                rowList.add(row);
                index++;
            }
            div.getHeijunkaSagakuKakunin().getDgHeijunkaKakutei().setDataSource(rowList);
        }
    }

    /**
     * 「保険料段階別一覧」の差額列に反映のメソッドます。
     */
    public void set差額() {
        List<dgHeijunkaKakutei_Row> rowList = div.getHeijunkaSagakuKakunin().getDgHeijunkaKakutei().getDataSource();
        for (dgHeijunkaKakutei_Row row : rowList) {
            row.getTxtSagaku().setValue(div.getHeijunkaSagakuKakunin().getTxtSagaku().getValue());
        }
    }

    /**
     * 「差額設定による対象外件数を算出する」ボタンのメソッドます。
     *
     * @param 基準日時 YMDHMS
     * @return flag 全ての保険料段階の差額が0円
     */
    public boolean set対象件数と対象外件数(YMDHMS 基準日時) {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        List<dgHeijunkaKakutei_Row> rowList = div.getHeijunkaSagakuKakunin().getDgHeijunkaKakutei().getDataSource();
        List<HokenryoDankaibetu> 保険料段階と差額List = new ArrayList<>();
        HokenryoDankaibetu entity;
        boolean flag = true;
        for (dgHeijunkaKakutei_Row row : rowList) {
            entity = new HokenryoDankaibetu();
            entity.set保険料段階(row.getTxtDankaiKubun());
            Decimal 差額 = row.getTxtSagaku().getValue() != null ? row.getTxtSagaku().getValue() : Decimal.ZERO;
            entity.set差額(差額);
            保険料段階と差額List.add(entity);
            if (!Decimal.ZERO.equals(差額)) {
                flag = false;
            }
        }
        List<Taishokensu> taishokensuList = new ArrayList<>();
        if (特徴平準化_特徴6月分.equals(ResponseHolder.getMenuID())) {
            taishokensuList = TokuchoHeijunkaKakutei.createInstance().getKakuteiKensu(
                    new FlexibleYear(調定年度.toString()),
                    new FlexibleYear(調定年度.toString()),
                    基準日時,
                    遷移区分_0,
                    保険料段階と差額List);
        } else if (特徴平準化_特徴8月分.equals(ResponseHolder.getMenuID())) {
            taishokensuList = TokuchoHeijunkaKakutei.createInstance().getKakuteiKensu(
                    new FlexibleYear(調定年度.toString()),
                    new FlexibleYear(調定年度.toString()),
                    基準日時,
                    遷移区分_1,
                    保険料段階と差額List);
        }
        Map<RString, Taishokensu> map = new HashMap<>();
        for (Taishokensu taishokensu : taishokensuList) {
            map.put(taishokensu.get保険料段階(), taishokensu);
        }
        for (dgHeijunkaKakutei_Row dgRow : rowList) {
            Taishokensu taishokensuEntity = map.get(dgRow.getTxtDankaiKubun());
            dgRow.setTxtKakuteiKensu(new RString(taishokensuEntity.get確定対象件数()));
            dgRow.setTxtTaishogaiKensu(new RString(taishokensuEntity.get対象外件数()));
        }
        return flag;
    }

    /**
     * 賦課処理状況の更新のメソッドます。
     *
     * @param 処理日付管理 ShoriDateKanri
     */
    public void 更新賦課処理状況更新(ShoriDateKanri 処理日付管理) {
        RYear 調定年度 = div.getHeijunkaKakuteiShoriNaiyo().getTxtFukaNendo().getDomain();
        FlexibleYear 賦課年度 = new FlexibleYear(調定年度.toString());
        TokuchoHeijunkaKakutei.createInstance().updateFukaShoriJokyo(賦課年度, 処理日付管理.get基準日時());
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        処理日付管理 = 処理日付管理.createBuilderForEdit()
                .set基準日時(new YMDHMS(RDate.getNowDate(), RDate.getNowTime())).build();
        処理日付管理 = 処理日付管理.modifiedModel();
        manager.save処理日付管理マスタ(処理日付管理);
    }

    /**
     * バッチパラメータ作成。
     *
     * @param 調定日時 YMDHMS
     * @return パラメータ
     */
    public TokuchoHeijunkaKakuteiBatchParameter creatParameter(YMDHMS 調定日時) {

        RString 遷移区分 = RString.EMPTY;
        if (特徴平準化_特徴6月分.equals(ResponseHolder.getMenuID())) {
            遷移区分 = 遷移区分_0;
        } else if (特徴平準化_特徴8月分.equals(ResponseHolder.getMenuID())) {
            遷移区分 = 遷移区分_1;
        }
        List<dgHeijunkaKakutei_Row> rowList = div.getHeijunkaSagakuKakunin().getDgHeijunkaKakutei().getDataSource();
        Map<RString, Decimal> 差額Map = new HashMap<>();
        for (dgHeijunkaKakutei_Row row : rowList) {
            差額Map.put(row.getTxtDankaiKubun(), row.getTxtSagaku().getValue());
        }
        RYear 賦課年度 = div.getHeijunkaKakuteiShoriNaiyo().getTxtFukaNendo().getDomain();
        TokuchoHeijunkaKakuteiBatchParameter parameter = TokuchoHeijunkaKakutei.createInstance()
                .createTokuchoHeijunkaKakuteiParameter(差額Map, new FlexibleYear(賦課年度.toString()),
                        new FlexibleYear(賦課年度.toString()), 調定日時, 遷移区分);
        return parameter;
    }
}
