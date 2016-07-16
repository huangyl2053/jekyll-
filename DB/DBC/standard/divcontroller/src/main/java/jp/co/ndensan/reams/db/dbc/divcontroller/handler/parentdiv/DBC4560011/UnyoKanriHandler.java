/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4560011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4560011.UnyoKanriDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * {@link UnyoKanriHandler}のHandlerクラスです。
 *
 * @reamsid_L DBC-5820-010 tianshuai
 */
public class UnyoKanriHandler {

    private final UnyoKanriDiv div;
    private static final RString CODE_１割負担 = new RString("1");
    private static final RString CODE_２割負担 = new RString("2");
    private static final RString NAME_１割負担 = new RString("１割負担");
    private static final RString NAME_２割負担 = new RString("２割負担");
    private static final RString CODE_処理済 = new RString("1");
    private static final RString CODE_再処理前 = new RString("2");
    private static final RString CODE_未処理 = new RString("0");
    private static final RString NAME_処理済 = new RString("処理済");
    private static final RString NAME_再処理前 = new RString("再処理前");
    private static final RString NAME_未処理 = new RString("未処理");

    /**
     * コンストラクタです。
     *
     * @param div UnyoKanriDiv
     */
    public UnyoKanriHandler(UnyoKanriDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時の動作です。
     */
    public void initializeDisplay() {
        RDate 適用基準日 = RDate.getNowDate();
        RString 本人未申告区分 = get業務Config(ConfigNameDBC.利用者負担割合判定基準_本人未申告区分, 適用基準日);
        RString 本人所得調査中区分 = get業務Config(ConfigNameDBC.利用者負担割合判定基準_本人所得調査中区分, 適用基準日);
        RString 年次負担割合処理済年度 = get業務Config(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理済年度, 適用基準日);
        RString 年次負担割合処理状態 = get業務Config(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理状態, 適用基準日);
        initializeControl(年次負担割合処理済年度);
        if (!本人未申告区分.isNullOrEmpty()) {
            div.getDdlHonninMishinkokuKubun().setSelectedKey(本人未申告区分);
            div.setHdnHonninMishinkokuKubun(本人未申告区分);
        } else {
            div.setHdnHonninMishinkokuKubun(RString.EMPTY);
        }
        if (!本人所得調査中区分.isNullOrEmpty()) {
            div.getDdlHonninShutokuChosachuKubun().setSelectedKey(本人所得調査中区分);
            div.setHdnHonninShutokuChosachuKubun(本人所得調査中区分);
        } else {
            div.setHdnHonninShutokuChosachuKubun(RString.EMPTY);
        }
        if (!年次負担割合処理済年度.isNullOrEmpty()) {
            div.getTxtNenjiFutanWariaiShoriZumiNendo().setValue(new RDate(年次負担割合処理済年度.toString()));
            if (!年次負担割合処理状態.isNullOrEmpty()) {
                div.getDdlNenjiFutanWariaiShoriJotai().setSelectedKey(年次負担割合処理状態);
            } else {
                div.getDdlNenjiFutanWariaiShoriJotai().setSelectedKey(CODE_処理済);
            }
        } else {
            div.getTxtNenjiFutanWariaiShoriZumiNendo().setPlaceHolder(RString.EMPTY);
            div.getDdlNenjiFutanWariaiShoriJotai().setSelectedKey(CODE_未処理);
        }
        if (!年次負担割合処理状態.isNullOrEmpty()) {
            div.setHdnNenjiFutanWariaiShoriJotai(年次負担割合処理状態);
        } else {
            div.setHdnNenjiFutanWariaiShoriJotai(RString.EMPTY);
        }
    }

    /**
     * 引数で指定された年を和暦年（前半角スペース埋め）に編集し、元年表記で返却します。<br />
     * 変換元：2014<br />
     * 変換後：平成26（年がそれぞれ一桁の場合、前半角スペース埋めする）
     *
     * @param date 年
     * @return RString 年度
     */
    public RString getパターン102(RYear date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear();
        }
        return wareki;
    }

    private void initializeControl(RString 年次負担割合処理済年度) {
        div.setReadOnly(false);
        List<KeyValueDataSource> 本人区分dataSource = get本人区分DataSource();
        List<KeyValueDataSource> 未処理状態DataSource = get未処理状態DataSource();
        List<KeyValueDataSource> 処理状態DataSource = get処理状態DataSource();
        div.getDdlHonninMishinkokuKubun().setDataSource(本人区分dataSource);
        div.getDdlHonninShutokuChosachuKubun().setDataSource(本人区分dataSource);
        div.getTxtNenjiFutanWariaiShoriZumiNendo().clearValue();
        if (年次負担割合処理済年度.isNullOrEmpty()) {
            div.getDdlNenjiFutanWariaiShoriJotai().setDataSource(未処理状態DataSource);
        } else {
            div.getDdlNenjiFutanWariaiShoriJotai().setDataSource(処理状態DataSource);
        }
    }

    private RString get業務Config(Enum キー名称, RDate 適用基準日) {
        return DbBusinessConfig.get(キー名称, 適用基準日,
                SubGyomuCode.DBC介護給付);
    }

    private List<KeyValueDataSource> get本人区分DataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(CODE_１割負担, NAME_１割負担));
        dataSourceList.add(new KeyValueDataSource(CODE_２割負担, NAME_２割負担));
        return dataSourceList;
    }

    private List<KeyValueDataSource> get未処理状態DataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(CODE_未処理, NAME_未処理));
        return dataSourceList;
    }

    private List<KeyValueDataSource> get処理状態DataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(CODE_処理済, NAME_処理済));
        dataSourceList.add(new KeyValueDataSource(CODE_再処理前, NAME_再処理前));
        return dataSourceList;
    }
}
