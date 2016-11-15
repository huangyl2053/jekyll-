/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonShikibetsuIDniYoruShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.ur.urz.definition.core.chiku.ChikuShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 地区市町村選択【共有子Div】のハンドラクラスです。
 *
 * @reamsid_L DBB-5720-010 xuxin
 */
public class ChikuShichosonSelectHandler {

    private static final RString コード_事務単一 = new RString("120");
    private static final RString コード_事務広域 = new RString("111");
    private static final RString コード_事務構成市町村 = new RString("112");
    private static final RString 文字_全て = new RString("全て");
    private static final RString 文字_町域 = new RString("町域");
    private static final RString KEY = new RString("000000");
    private static final RString 全角空白 = new RString("　");
    private static final RString 文字_全市町村 = new RString("全市町村");
    private static final RString 文字_TRUE = new RString("true");
    private static final RString 文字_を選択する = new RString("を選択する");

    private final ChikuShichosonSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ChikuShichosonSelectDiv
     */
    public ChikuShichosonSelectHandler(ChikuShichosonSelectDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div ChikuShichosonSelectHandler
     * @return ChikuShichosonSelectHandler
     */
    public static ChikuShichosonSelectHandler of(ChikuShichosonSelectDiv div) {
        return new ChikuShichosonSelectHandler(div);
    }

    /**
     * 共有子Div画面の初期表示です。
     */
    public void init() {

        RDate 適用基準日 = RDate.getNowDate();
        ShichosonSecurityJoho 市町村安全情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態Code = 市町村安全情報.get導入形態コード();
        if (導入形態Code != null && !導入形態Code.isEmpty() && !導入形態Code.value().isNullOrEmpty()) {
            div.setHdnTxtDonyuKeitaiCode(導入形態Code.value());
            if (コード_事務単一.equals(導入形態Code.value())) {
                div.getTanitsuShichoson().setDisplayNone(false);
                div.getBtnChoikiGuide().setDisplayNone(true);
                div.getBtnChikuNyuryokuGuide().setDisplayNone(true);
                div.getDdlCodeList().init();
                div.getKoikiShichoson().setDisplayNone(true);
                set選択対象DDL(適用基準日);
            }
            if (コード_事務広域.equals(導入形態Code.value()) || コード_事務構成市町村.equals(導入形態Code.value())) {
                div.getTanitsuShichoson().setDisplayNone(true);
                div.getKoikiShichoson().setDisplayNone(false);
                div.getDdlKyushichosonKoiki().setDisplayNone(true);
                set市町村DDL(導入形態Code);
            }
        }
        div.setHdnTxtIsMultiSelected(文字_TRUE);
        div.setHdnTxtChikuShubetsu(RString.EMPTY);
        div.setHdnMapMultiSelect(RString.EMPTY);
        div.setHdnTxtTitle(RString.EMPTY);
    }

    /**
     * 共有子Div画面の初期表示です。
     *
     * @param 導入形態コード 導入形態コード
     */
    public void initialize(Code 導入形態コード) {
        RDate 適用基準日 = RDate.getNowDate();
        if (導入形態コード != null && !導入形態コード.isEmpty() && !導入形態コード.value().isNullOrEmpty()) {
            div.setHdnTxtDonyuKeitaiCode(導入形態コード.value());
            if (コード_事務単一.equals(導入形態コード.value())) {
                div.getTanitsuShichoson().setDisplayNone(false);
                div.getBtnChoikiGuide().setDisplayNone(true);
                div.getBtnChikuNyuryokuGuide().setDisplayNone(true);
                div.getDdlCodeList().init();
                div.getKoikiShichoson().setDisplayNone(true);
                set選択対象DDL(適用基準日);
            }
            if (コード_事務広域.equals(導入形態コード.value())) {
                div.getTanitsuShichoson().setDisplayNone(true);
                div.getKoikiShichoson().setDisplayNone(false);
                div.getDdlKyushichosonKoiki().setDisplayNone(true);
                set市町村DDL(導入形態コード);
            }
        }
        div.setHdnTxtIsMultiSelected(文字_TRUE);
        div.setHdnTxtChikuShubetsu(RString.EMPTY);
        div.setHdnMapMultiSelect(RString.EMPTY);
        div.setHdnTxtTitle(RString.EMPTY);
    }

    private void set市町村DDL(Code 導入形態Code) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        if (コード_事務広域.equals(導入形態Code.value())) {
            dataSource.add(new KeyValueDataSource(KEY, KEY.concat(全角空白).concat(文字_全市町村)));
            List<KoseiShichoson> 広域市町村情報 = finder.getKoseiShichosonList().records();
            if (!広域市町村情報.isEmpty()) {
                List<RString> keyList = new ArrayList<>();
                for (KoseiShichoson item : 広域市町村情報) {
                    RString 市町村Code = item.get市町村コード().getColumnValue();
                    RString 市町村名称 = item.get市町村名称();
                    if (!keyList.contains(市町村Code)) {
                        dataSource.add(new KeyValueDataSource(市町村Code, 市町村Code.concat(全角空白).concat(市町村名称)));
                        keyList.add(市町村Code);
                    }
                }
            }
            div.getDdlShichoson().setDataSource(dataSource);
            div.getDdlShichoson().setSelectedKey(KEY);
        }
        if (コード_事務構成市町村.equals(導入形態Code.value())) {
            RString UserId = ControlDataHolder.getUserId();
            if (!RString.isNullOrEmpty(UserId) && !ShichosonSecurityJoho.getShichosonShikibetsuId(UserId).isEmpty()) {
                AuthorityItem 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(UserId).get(0);
                List<ShichosonShikibetsuIDniYoruShichosonJoho> 構成市町村情報list = finder.
                        loginUserShichosonJoho(市町村識別ID.getItemId()).records();
                if (!構成市町村情報list.isEmpty()) {
                    RString 市町村Code = 構成市町村情報list.get(0).get市町村コード().value();
                    RString 市町村名称 = 構成市町村情報list.get(0).get市町村名称();
                    dataSource.add(new KeyValueDataSource(市町村Code, 市町村Code.concat(全角空白).concat(市町村名称)));
                    div.getDdlShichoson().setDataSource(dataSource);
                    div.getDdlShichoson().setSelectedKey(市町村Code);
                    onChange_市町村DDL();
                }
            }
        }
    }

    /**
     * 選択対象DDLのdataSource設定です。
     */
    private void set選択対象DDL(RDate 適用基準日) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(文字_全て, 文字_全て));
        dataSource.add(new KeyValueDataSource(文字_町域, 文字_町域));
        dataSource.add(new KeyValueDataSource(ChikuShubetsu.行政区.getShubetsu(), ChikuShubetsu.行政区.getShubetsu()));
        RString 地区1 = getConfig値(ConfigKeysCodeName.コード名称_地区の分類１, 適用基準日);
        if (!RString.isNullOrEmpty(地区1) && 地区1.length() > 0) {
            dataSource.add(new KeyValueDataSource(ChikuShubetsu.地区1.getShubetsu(), 地区1));
        }
        RString 地区2 = getConfig値(ConfigKeysCodeName.コード名称_地区の分類２, 適用基準日);
        if (!RString.isNullOrEmpty(地区2) && 地区2.length() > 0) {
            dataSource.add(new KeyValueDataSource(ChikuShubetsu.地区2.getShubetsu(), 地区2));
        }
        RString 地区3 = getConfig値(ConfigKeysCodeName.コード名称_地区の分類３, 適用基準日);
        if (!RString.isNullOrEmpty(地区3) && 地区3.length() > 0) {
            dataSource.add(new KeyValueDataSource(ChikuShubetsu.地区3.getShubetsu(), 地区3));
        }
        div.getDdlChiku().setDataSource(dataSource);
        div.getDdlChiku().setSelectedKey(文字_全て);
    }

    private RString getConfig値(Enum key, RDate 適用基準日) {
        return DbBusinessConfig.get(key, 適用基準日, SubGyomuCode.URZ業務共通_共通系);
    }

    /**
     * 選択対象DDL選択変更時の処理です。
     */
    public void onChange_選択対象DDL() {

        if (文字_全て.equals(div.getDdlChiku().getSelectedKey())) {
            div.getBtnChoikiGuide().setDisplayNone(true);
            div.getBtnChikuNyuryokuGuide().setDisplayNone(true);
            div.getDdlCodeList().getDataSource().clear();
            div.setHdnTxtChikuShubetsu(RString.EMPTY);
            div.setHdnMapMultiSelect(RString.EMPTY);
            div.setHdnTxtTitle(RString.EMPTY);
        } else if (文字_町域.equals(div.getDdlChiku().getSelectedKey())) {
            div.getBtnChoikiGuide().setDisplayNone(false);
            div.getBtnChikuNyuryokuGuide().setDisplayNone(true);
            div.getDdlCodeList().getDataSource().clear();
            div.setHdnTxtChikuShubetsu(RString.EMPTY);
            div.setHdnMapMultiSelect(RString.EMPTY);
            div.setHdnTxtTitle(RString.EMPTY);
        } else {
            div.getBtnChoikiGuide().setDisplayNone(true);
            div.getBtnChikuNyuryokuGuide().setDisplayNone(false);
            if (ChikuShubetsu.行政区.getShubetsu().equals(div.getDdlChiku().getSelectedKey())) {
                div.getBtnChikuNyuryokuGuide().setText(div.getDdlChiku().getSelectedValue().concat(文字_を選択する));
            }
            if (ChikuShubetsu.地区1.getShubetsu().equals(div.getDdlChiku().getSelectedKey())) {
                div.getBtnChikuNyuryokuGuide().setText(div.getDdlChiku().getSelectedValue().concat(文字_を選択する));
            }
            if (ChikuShubetsu.地区2.getShubetsu().equals(div.getDdlChiku().getSelectedKey())) {
                div.getBtnChikuNyuryokuGuide().setText(div.getDdlChiku().getSelectedValue().concat(文字_を選択する));
            }
            if (ChikuShubetsu.地区3.getShubetsu().equals(div.getDdlChiku().getSelectedKey())) {
                div.getBtnChikuNyuryokuGuide().setText(div.getDdlChiku().getSelectedValue().concat(文字_を選択する));
            }
            div.getDdlCodeList().getDataSource().clear();
            div.setHdnTxtChikuShubetsu(div.getDdlChiku().getSelectedKey());
            div.setHdnMapMultiSelect(RString.EMPTY);
            div.setHdnTxtTitle(div.getDdlChiku().getSelectedKey());
        }
    }

    /**
     * 町域入力ガイド確定時の処理です。
     */
    public void onOkClose_町域選択ボタン() {

        Map<RString, RString> map = DataPassingConverter.deserialize(div.getHdnMapMultiSelect(), HashMap.class);
        if (map != null && !map.isEmpty()) {
            List<ddlCodeList_Row> dataSource = new ArrayList<>();
            for (Map.Entry<RString, RString> entry : map.entrySet()) {
                ddlCodeList_Row row = new ddlCodeList_Row();
                row.setCode(entry.getKey());
                row.setName(entry.getValue());
                dataSource.add(row);
            }
            div.getDdlCodeList().setDataSource(setDgDataSource昇順ByKey(dataSource));
        }
        div.setHdnTxtIsMultiSelected(文字_TRUE);
    }

    /**
     * 地区入力ガイド確定時の処理です。
     */
    public void onOkClose_地区選択ボタン() {

        Map<RString, RString> map = DataPassingConverter.deserialize(div.getHdnMapMultiSelect(), HashMap.class);
        if (map != null && !map.isEmpty()) {
            List<ddlCodeList_Row> dataSource = new ArrayList<>();
            for (Map.Entry<RString, RString> entry : map.entrySet()) {
                ddlCodeList_Row row = new ddlCodeList_Row();
                row.setCode(entry.getKey());
                row.setName(entry.getValue());
                dataSource.add(row);
            }
            div.getDdlCodeList().setDataSource(setDgDataSource昇順ByKey(dataSource));
        }
        div.setHdnTxtIsMultiSelected(文字_TRUE);
    }

    /**
     * 市町村DDL選択変更時の処理です。
     */
    public void onChange_市町村DDL() {

        if (KEY.equals(div.getDdlShichoson().getSelectedKey())) {
            div.getDdlKyushichosonKoiki().setDisplayNone(true);
        } else {
            KyuShichosonCodeJoho 旧市町村情報 = KyuShichosonCode.getKyuShichosonCodeJoho(
                    new LasdecCode(div.getDdlShichoson().getSelectedKey()),
                    DonyuKeitaiCode.toValue(div.getHdnTxtDonyuKeitaiCode()));
            if (旧市町村情報 != null && 旧市町村情報.is合併市町村有無フラグ()) {
                div.getDdlKyushichosonKoiki().setDisplayNone(false);
                List<KyuShichosonCode> 旧市町村コード情報List = 旧市町村情報.get旧市町村コード情報List();
                if (旧市町村コード情報List != null && !旧市町村コード情報List.isEmpty()) {
                    List<KeyValueDataSource> dataSource = new ArrayList<>();
                    dataSource.add(new KeyValueDataSource(KEY, 文字_全市町村));
                    List<RString> keyList = new ArrayList<>();
                    keyList.add(KEY);
                    for (KyuShichosonCode item : 旧市町村コード情報List) {
                        RString 旧市町村Code = item.get旧市町村コード().getColumnValue();
                        RString 旧市町村名称 = item.get旧市町村名称();
                        if (!keyList.contains(旧市町村Code)) {
                            dataSource.add(new KeyValueDataSource(旧市町村Code, 旧市町村名称));
                            keyList.add(旧市町村Code);
                        }
                    }
                    div.getDdlKyushichosonKoiki().setDataSource(setDdlDataSource昇順ByKey(dataSource));
                    div.getDdlKyushichosonKoiki().setSelectedIndex(0);
                }
            } else {
                div.getDdlKyushichosonKoiki().setDisplayNone(true);
            }
        }
    }

    private List<KeyValueDataSource> setDdlDataSource昇順ByKey(List<KeyValueDataSource> dataSource) {
        if (dataSource.isEmpty()) {
            return dataSource;
        }
        Collections.sort(dataSource,
                new Comparator<KeyValueDataSource>() {
                    @Override
                    public int compare(KeyValueDataSource arg0, KeyValueDataSource arg1) {
                        return arg0.getKey().toString().compareTo(arg1.getKey().toString());
                    }
                }
        );
        return dataSource;
    }

    private List<ddlCodeList_Row> setDgDataSource昇順ByKey(List<ddlCodeList_Row> dataSource) {
        if (dataSource.isEmpty()) {
            return dataSource;
        }
        Collections.sort(dataSource,
                new Comparator<ddlCodeList_Row>() {
                    @Override
                    public int compare(ddlCodeList_Row arg0, ddlCodeList_Row arg1) {
                        return arg0.getCode().toString().compareTo(arg1.getCode().toString());
                    }
                }
        );
        return dataSource;
    }

}
