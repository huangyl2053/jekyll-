/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0840011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011.SystemKanriPanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kensakujoken.KensakuCursorPosition;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinShimeiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaiyusenChikuCode;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * システム管理情報（介護統計共通)のHandlerクラスです。
 *
 * @reamsid_L DBU-3990-010 zhengsongling
 */
public class SystemKanriPanelHandler {

    private final SystemKanriPanelDiv div;
    private RString メニューID;
    private static final RString 対象としない = new RString("0");
    private static final RString 対象とする = new RString("1");
    private static final RString 選択 = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriPanelDiv
     */
    public SystemKanriPanelHandler(SystemKanriPanelDiv div) {
        this.div = div;
    }

    /**
     * システム管理情報（介護統計共通)の初期化です。
     *
     */
    public void onload() {
        List<RString> list選択 = new ArrayList<>();
        list選択.add(選択);
        div.getSystemKanri().getTxtHokenjaCode().setValue(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        div.getSystemKanri().getTxtHokenjaName().setValue(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        div.getSystemKanri().getTxtYubinNo().setValue(new YubinNo(DbBusinessConfig.get(ConfigNameDBU.保険者情報_郵便番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        div.getSystemKanri().getTxtJusho().setDomain(
                new AtenaJusho(DbBusinessConfig.get(ConfigNameDBU.保険者情報_住所, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        div.getSystemKanri().getTxtTelNo().setDomain(
                new TelNo(DbBusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        RString 最優先地区コード = DbBusinessConfig.get(ConfigNameDBU.保険者情報_最優先地区コード, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getSystemKanri().getDdlChikuCode().setSelectedKey(最優先地区コード);
        RString 氏名表示方法 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_氏名表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getSystemKanri().getDdlGaikokujinHyoji().setSelectedKey(氏名表示方法);
        RString 生年月日表示方法 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getSystemKanri().getDdlGaikokujinBirthdayHyoji().setSelectedKey(生年月日表示方法);
        div.getSystemKanri().getTxtRojinHokenShichosonNo().setValue(DbBusinessConfig.get(ConfigNameDBU.老人保健情報_市町村番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        RString カーソル位置 = DbBusinessConfig.get(ConfigNameDBU.検索画面設定_カーソル位置, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getSystemKanri().getSearchCondition().getDdlCursorPosition().setSelectedKey(カーソル位置);
        RString 前方一致条件有無 = DbBusinessConfig.get(ConfigNameDBU.検索画面設定_検索オプション_前方一致条件有無,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (対象としない.equals(前方一致条件有無) || 対象とする.equals(前方一致条件有無)) {
            div.getSystemKanri().getSearchCondition().getRadForwardMatch().setSelectedKey(前方一致条件有無);
        }
        RString 被保険者対象有無 = DbBusinessConfig.get(ConfigNameDBU.検索画面設定_検索オプション_被保険者対象有無,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        switch (被保険者対象有無.toString()) {
            case "0":
                break;
            case "1":
                div.getSystemKanri().getSearchCondition().getChkSearchOptionHihokensha().setSelectedItemsByKey(list選択);
                break;
            default:
                break;
        }
        RString 要介護認定者対象有無 = DbBusinessConfig.get(ConfigNameDBU.検索画面設定_検索オプション_要介護認定者対象有無,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        switch (要介護認定者対象有無.toString()) {
            case "0":
                break;
            case "1":
                div.getSystemKanri().getSearchCondition().getChkSearchOptionYokaigoNinteisha().setSelectedItemsByKey(list選択);
                break;
            default:
                break;
        }
        RString 住所地特例者対象有無 = DbBusinessConfig.get(ConfigNameDBU.検索画面設定_検索オプション_住所地特例者対象有無,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        switch (住所地特例者対象有無.toString()) {
            case "0":
                break;
            case "1":
                div.getSystemKanri().getSearchCondition().getChkSearchOptionJushochiTokureisha().setSelectedItemsByKey(list選択);
                break;
            default:
                break;
        }
        RString 他市町村住所地特例者対象有無 = DbBusinessConfig.get(ConfigNameDBU.検索画面設定_検索オプション_他市町村住所地特例者対象有無,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        switch (他市町村住所地特例者対象有無.toString()) {
            case "0":
                break;
            case "1":
                div.getSystemKanri().getSearchCondition().getChkSearchOptionTajushochiTokureisha().setSelectedItemsByKey(list選択);
                break;
            default:
                break;
        }
        RString 適用除外者対象有無 = DbBusinessConfig.get(ConfigNameDBU.検索画面設定_検索オプション_適用除外者対象有無,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        switch (適用除外者対象有無.toString()) {
            case "0":
                break;
            case "1":
                div.getSystemKanri().getSearchCondition().getChkSearchOptionTekiyoJogaisha().setSelectedItemsByKey(list選択);
                break;
            default:
                break;
        }
        div.getSystemKanri().getSearchCondition().getTxtMaxGetNumber().setValue(new Decimal(
                Integer.valueOf(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString())));
    }

    /**
     * DDLの値を取得です。
     */
    public void set_DDL() {
        div.getSystemKanri().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        div.setHdnTxtDonyuKeitaiCode(new RString(shichosonSecurityJoho.get導入形態コード().toString()));
        div.getSystemKanri().getDdlChikuCode().getDataSource().clear();
        List<KeyValueDataSource> list最優先地区コード = new ArrayList<>();
        for (SaiyusenChikuCode saiyusenChikuCode : SaiyusenChikuCode.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(saiyusenChikuCode.getコード());
            dataSource.setValue(saiyusenChikuCode.get名称());
            list最優先地区コード.add(dataSource);
        }
        div.getSystemKanri().getDdlChikuCode().setDataSource(list最優先地区コード);
        div.getSystemKanri().getDdlGaikokujinHyoji().getDataSource().clear();
        List<KeyValueDataSource> list外国人氏名表示優先度 = new ArrayList<>();
        for (GaikokujinShimeiHyojihoho gaikokujinShimeiHyojihoho : GaikokujinShimeiHyojihoho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(gaikokujinShimeiHyojihoho.getコード());
            dataSource.setValue(gaikokujinShimeiHyojihoho.get名称());
            list外国人氏名表示優先度.add(dataSource);
        }
        div.getSystemKanri().getDdlGaikokujinHyoji().setDataSource(list外国人氏名表示優先度);
        div.getSystemKanri().getDdlGaikokujinBirthdayHyoji().getDataSource().clear();
        List<KeyValueDataSource> list外国人生年月日表示優先度 = new ArrayList<>();
        for (GaikokujinSeinengappiHyojihoho gaikokujinSeinengappiHyojihoho : GaikokujinSeinengappiHyojihoho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(gaikokujinSeinengappiHyojihoho.getコード());
            dataSource.setValue(gaikokujinSeinengappiHyojihoho.get名称());
            list外国人生年月日表示優先度.add(dataSource);
        }
        div.getSystemKanri().getDdlGaikokujinBirthdayHyoji().setDataSource(list外国人生年月日表示優先度);
        div.getSystemKanri().getSearchCondition().getDdlCursorPosition().getDataSource().clear();
        List<KeyValueDataSource> listカーソル位置 = new ArrayList<>();
        RString コード = KensakuCursorPosition.住所.getコード();
        RString 事務広域 = DonyuKeitaiCode.事務広域.getCode();
        for (KensakuCursorPosition kensakuCursorPosition : KensakuCursorPosition.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(kensakuCursorPosition.getコード());
            dataSource.setValue(kensakuCursorPosition.get名称());
            if (!(事務広域.equals(div.getHdnTxtDonyuKeitaiCode()) && コード.equals(kensakuCursorPosition.getコード()))) {
                listカーソル位置.add(dataSource);
            }
        }
        div.getSystemKanri().getSearchCondition().getDdlCursorPosition().setDataSource(listカーソル位置);
    }

    /**
     * 保存ボタン。
     *
     * @param メニューID メニューID
     */
    public void set_保存ボタン(RString メニューID) {
        setDB_更新(ConfigNameDBU.保険者情報_保険者番号, div.getSystemKanri().getTxtHokenjaCode().getValue());
        setDB_更新(ConfigNameDBU.保険者情報_保険者名称, div.getSystemKanri().getTxtHokenjaName().getValue());
        setDB_更新(ConfigNameDBU.保険者情報_郵便番号, new RString(div.getSystemKanri().getTxtYubinNo().getValue().toString()));
        setDB_更新(ConfigNameDBU.保険者情報_住所, new RString(div.getSystemKanri().getTxtJusho().getDomain().toString()));
        setDB_更新(ConfigNameDBU.保険者情報_電話番号, new RString(div.getSystemKanri().getTxtTelNo().getDomain().toString()));
        setDB_更新(ConfigNameDBU.保険者情報_最優先地区コード, div.getSystemKanri().getDdlChikuCode().getSelectedKey());
        setDB_更新(ConfigNameDBU.外国人表示制御_氏名表示方法, div.getSystemKanri().getDdlGaikokujinHyoji().getSelectedKey());
        setDB_更新(ConfigNameDBU.外国人表示制御_生年月日表示方法, div.getSystemKanri().getDdlGaikokujinBirthdayHyoji().getSelectedKey());
        setDB_更新(ConfigNameDBU.老人保健情報_市町村番号, div.getSystemKanri().getTxtRojinHokenShichosonNo().getValue());
        setDB_更新(ConfigNameDBU.検索画面設定_カーソル位置, div.getSystemKanri().getSearchCondition().getDdlCursorPosition().getSelectedKey());
        setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_前方一致条件有無, div.getSystemKanri().getSearchCondition().getRadForwardMatch().getSelectedKey());
        setDB_更新(ConfigNameDBU.検索制御_最大取得件数, new RString(div.getSystemKanri().getSearchCondition().getTxtMaxGetNumber().getValue().toString()));
        if (div.getSystemKanri().getChohyoJushoDefault().getCcdKaigoAtesakiJushoSettei().is都道府県名表示()) {
            setDB_更新(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, 対象とする);
        } else {
            setDB_更新(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, 対象としない);
        }
        if (div.getSystemKanri().getChohyoJushoDefault().getCcdKaigoAtesakiJushoSettei().is郡名表示()) {
            setDB_更新(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, 対象とする);
        } else {
            setDB_更新(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, 対象としない);
        }
        if (div.getSystemKanri().getChohyoJushoDefault().getCcdKaigoAtesakiJushoSettei().is市町村名表示()) {
            setDB_更新(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, 対象とする);
        } else {
            setDB_更新(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, 対象としない);
        }
        setDB_更新(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                div.getSystemKanri().getChohyoJushoDefault().getCcdKaigoAtesakiJushoSettei().get町域編集方法());
        if (div.getSystemKanri().getChohyoJushoDefault().getCcdKaigoAtesakiJushoSettei().is方書表示()) {
            setDB_更新(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, 対象とする);
        } else {
            setDB_更新(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, 対象としない);
        }
        if (div.getSystemKanri().getSearchCondition().getChkSearchOptionHihokensha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_被保険者対象有無, 対象とする);
        } else if (!div.getSystemKanri().getSearchCondition().getChkSearchOptionHihokensha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_被保険者対象有無, 対象としない);
        }
        if (div.getSystemKanri().getSearchCondition().getChkSearchOptionYokaigoNinteisha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_要介護認定者対象有無, 対象とする);
        } else if (!div.getSystemKanri().getSearchCondition().getChkSearchOptionYokaigoNinteisha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_要介護認定者対象有無, 対象としない);
        }
        if (div.getSystemKanri().getSearchCondition().getChkSearchOptionJushochiTokureisha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_住所地特例者対象有無, 対象とする);
        } else if (!div.getSystemKanri().getSearchCondition().getChkSearchOptionJushochiTokureisha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_住所地特例者対象有無, 対象としない);
        }
        if (div.getSystemKanri().getSearchCondition().getChkSearchOptionTajushochiTokureisha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_他市町村住所地特例者対象有無, 対象とする);
        } else if (!div.getSystemKanri().getSearchCondition().getChkSearchOptionTajushochiTokureisha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_他市町村住所地特例者対象有無, 対象としない);
        }
        if (div.getSystemKanri().getSearchCondition().getChkSearchOptionTekiyoJogaisha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_適用除外者対象有無, 対象とする);
        } else if (!div.getSystemKanri().getSearchCondition().getChkSearchOptionTekiyoJogaisha().isAllSelected()) {
            setDB_更新(ConfigNameDBU.検索画面設定_検索オプション_適用除外者対象有無, 対象としない);
        }
        RealInitialLocker.release(new LockingKey(メニューID));
    }

    private void setDB_更新(Enum key, RString values) {
        RStringBuilder 変更理由 = new RStringBuilder();
        メニューID = UrControlDataFactory.createInstance().getMenuID();
        変更理由.append(メニューID);
        変更理由.append(new RString("を使用して更新"));
        BusinessConfig.update(key, values, 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
    }

}
